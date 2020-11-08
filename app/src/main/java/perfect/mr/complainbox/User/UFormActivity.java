package perfect.mr.complainbox.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Date;
import java.util.Calendar;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import perfect.mr.complainbox.MapsActivity;
import perfect.mr.complainbox.R;

public class UFormActivity extends AppCompatActivity {

    EditText t_Fname,t_Lname,t_city,t_state,t_pincode,t_contact_no,t_detailed_view,t_ward_no,t_ward_name;
    String locationPin;

    String UName,UphoneNumber,Ucity,Ustate,Upincode,UdetailView,UwardNo,UwardName;
    Button submitForm;

    Intent i;
    String latitude;
    String longitude;

    String currentTime,currentDate;

    /*===== String Values Used For Intents  =====*/
    String id,name,phoneNumber,city,pincode,state,ward_no,ward_name,email_id,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uform);

        /* ===== All Values Calling  ===== */
        valueCalling();
        Toast.makeText(this, "Check value Calling\n"+
                        "id = "+id+"\n"+
                        "name = "+name+"\n"+
                        "ward_no = "+ward_no+"\n"+
                        "ward_name = "+ward_name+"\n"+
                        "phoneNumber = "+phoneNumber+"\n"+
                        "city = "+city+"\n"+
                        "state = "+state+"\n"+
                        "pincode = "+pincode+"\n"+
                        "email_id = "+email_id+"\n"+
                        "password = "+password+"\n"+
                        "locationPin = "+locationPin
                ,Toast.LENGTH_SHORT).show();

        t_Fname=(EditText) findViewById(R.id.input_name);
        t_Fname.setText(name, TextView.BufferType.EDITABLE);

        t_city=(EditText) findViewById(R.id.input_city);
        t_city.setText(city, TextView.BufferType.EDITABLE);

        t_state=(EditText) findViewById(R.id.input_State);
        t_state.setText(state, TextView.BufferType.EDITABLE);


        t_pincode=(EditText) findViewById(R.id.input_pincode);
        t_pincode.setText(pincode, TextView.BufferType.EDITABLE);

        t_contact_no=(EditText) findViewById(R.id.input_contact_no);
        t_contact_no.setText(phoneNumber, TextView.BufferType.EDITABLE);

        t_ward_name=(EditText) findViewById(R.id.input_ward_name);
        t_ward_name.setText(ward_name, TextView.BufferType.EDITABLE);

        t_ward_no=(EditText) findViewById(R.id.input_ward_no);
        t_ward_no.setText(ward_no, TextView.BufferType.EDITABLE);

        t_detailed_view=(EditText)findViewById(R.id.input_user_feeds);

        TextView locationPin=(TextView) findViewById(R.id.input_location_pin);
        locationPin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            i=new Intent(UFormActivity.this,MapsActivity.class);

            valueSending();
            startActivity(i);
            }
        });


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
        pincode=getIntent().getExtras().getString("Pincode");
        email_id=getIntent().getExtras().getString("EmailId");
        password=getIntent().getExtras().getString("Password");

    }

    public void editTextToString(){
        UName=t_Fname.getText().toString();
        UwardNo=t_ward_no.getText().toString();
        UwardName=t_ward_name.getText().toString();
        UphoneNumber=t_contact_no.getText().toString();
        Ucity=t_city.getText().toString();
        Ustate=t_state.getText().toString();
        Upincode=t_pincode.getText().toString();
        UdetailView=t_detailed_view.getText().toString();
        //locationPin=latitude+","+longitude;
    }

    public  void valueSending(){
        editTextToString();

        i.putExtra("Id", id);
        i.putExtra("Name", name);
        i.putExtra("WardNo", ward_no);
        i.putExtra("WardName", ward_name);
        i.putExtra("MobileNo", phoneNumber);
        i.putExtra("City", city);
        i.putExtra("Pincode", pincode);
        i.putExtra("State", state);
        i.putExtra("EmailId", email_id);
        i.putExtra("Password", password);

    }

    public void insertData() {
        getDateTime();
        editTextToString();
        /*====================  Complain No. Generation =============================*/
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder stringBuilder = new StringBuilder();

        Random rnd = new Random();
        while (stringBuilder.length() < 12)
        {
            int index = (int) (rnd.nextFloat() * str.length());
            stringBuilder.append(str.charAt(index));
        }
        String complainNo = stringBuilder.toString();
        /*========================================================*/
        locationPin="-79432,8065";
        String method="FormData";
        UFormTask userBackgroundTaskForm=new UFormTask(this);
        userBackgroundTaskForm.execute(method,
                id,
                UName,
                locationPin,
                Ucity,
                Ustate,
                Upincode,
                UphoneNumber,
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
