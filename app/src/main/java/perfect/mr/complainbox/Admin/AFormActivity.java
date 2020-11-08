package perfect.mr.complainbox.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import perfect.mr.complainbox.MapsActivity;
import perfect.mr.complainbox.R;
import perfect.mr.complainbox.User.UFormActivity;
import perfect.mr.complainbox.User.UFormTask;

public class AFormActivity extends AppCompatActivity {
    EditText t_Fname,t_city,t_state,t_detailed_view,t_ward_no,t_ward_name;
    TextView t_complain_no;

    String UName,UphoneNumber,Ucity,Ustate,UdetailView,UwardNo,UwardName;
    Button submitForm;
    String currentTime,currentDate;
    String complainNo;
    Intent i;

    /*===== String Values Used For Intents  =====*/
    String id,name,phoneNumber,city,state,ward_no,ward_name,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aform);
        String cn=getIntent().getExtras().getString("ComplainNumber");
        Toast.makeText(this, cn, Toast.LENGTH_SHORT).show();

        /* ===== All Values Calling  =====
        valueCalling();
        Toast.makeText(this, "Check value Calling\n"+
                        "id = "+id+"\n"+
                        "name = "+name+"\n"+
                        "ward_no = "+ward_no+"\n"+
                        "ward_name = "+ward_name+"\n"+
                        "phoneNumber = "+phoneNumber+"\n"+
                        "city = "+city+"\n"+
                        "state = "+state+"\n"+
                        "password = "+password
                ,Toast.LENGTH_SHORT).show();*/


        complainGeneration();

        t_complain_no=(TextView) findViewById(R.id.input_complain_no);
        t_complain_no.setText(complainNo);

        t_Fname=(EditText) findViewById(R.id.input_name);
        t_Fname.setText(name, TextView.BufferType.EDITABLE);

        t_city=(EditText) findViewById(R.id.input_city);
        t_city.setText(city, TextView.BufferType.EDITABLE);


        t_ward_name=(EditText) findViewById(R.id.input_ward_name);
        t_ward_name.setText(ward_name, TextView.BufferType.EDITABLE);

        t_ward_no=(EditText) findViewById(R.id.input_ward_no);
        t_ward_no.setText(ward_no, TextView.BufferType.EDITABLE);


        t_detailed_view=(EditText)findViewById(R.id.input_feeds);

        t_state=(EditText) findViewById(R.id.input_state);
        t_state.setText(state,TextView.BufferType.EDITABLE);

        submitForm=(Button) findViewById(R.id.btn_fillform);
        submitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }
        });

    }
    public  void valueCalling(){
        id=getIntent().getExtras().getString("Id");
        name=getIntent().getExtras().getString("Name");
        ward_no=getIntent().getExtras().getString("WardNo");
        ward_name=getIntent().getExtras().getString("WardName");
        phoneNumber=getIntent().getExtras().getString("MobileNo");
        city=getIntent().getExtras().getString("City");
        state=getIntent().getExtras().getString("State");
        password=getIntent().getExtras().getString("Password");

    }

    public void editTextToString(){
        UName=t_Fname.getText().toString();
        UwardNo=t_ward_no.getText().toString();
        UwardName=t_ward_name.getText().toString();
       // UphoneNumber=t_contact_no.getText().toString();
        Ucity=t_city.getText().toString();
        Ustate=t_state.getText().toString();

        UdetailView=t_detailed_view.getText().toString();

    }

    public  void valueSending(){
        editTextToString();

        i.putExtra("Id", id);
        i.putExtra("Name", name);
        i.putExtra("WardNo", ward_no);
        i.putExtra("WardName", ward_name);
        i.putExtra("City", city);
        i.putExtra("State", state);
        i.putExtra("Password", password);

    }

    public void complainGeneration(){

        /*====================  Complain No. Generation =============================*/
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();

        Random rnd = new Random();
        while (stringBuilder.length() < 12)
        {
            int index = (int) (rnd.nextFloat() * str.length());
            stringBuilder.append(str.charAt(index));
        }
        complainNo = stringBuilder.toString();
        /*========================================================*/
    }
    public void insertData() {
        getDateTime();
        editTextToString();

        String method="FormData";
        AFormTask adminBackgroundTaskForm=new AFormTask(this);
        adminBackgroundTaskForm.execute(method,
                id,
                UName,
                Ucity,
                Ustate,
                UdetailView,
                complainNo,
                UwardName,
                UwardNo,
                currentTime,
                currentDate);
    }
    public void getDateTime(){
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat timeFormat = new SimpleDateFormat("HHmmss");
        currentTime=timeFormat.format(date);
        DateFormat dateFormat=new SimpleDateFormat("yyMMdd");
        currentDate=dateFormat.format(date);


    }
}
