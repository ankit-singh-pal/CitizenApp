package perfect.mr.complainbox.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import perfect.mr.complainbox.R;
import perfect.mr.complainbox.RankActivity;
import perfect.mr.complainbox.TestCase.AdminGETForm;

public class UHomeActivity extends AppCompatActivity {

    TextView rank,profile,adminAction,complain;
    Intent i;

    /*===== String Values Used For Intents  =====*/
    String id,name,phoneNumber,city,pincode,state,ward_no,ward_name,email_id,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uhome);

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
                "password = "+password
                ,Toast.LENGTH_SHORT).show();

        rank=(TextView) findViewById(R.id.trank);
        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(UHomeActivity.this,RankActivity.class);
                valueSending();
                startActivity(i);
            }
        });
        profile=(TextView)findViewById(R.id.t_profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(UHomeActivity.this,UProfileActivity.class);
                valueSending();
                startActivity(i);
            }
        });
        complain=(TextView) findViewById(R.id.tcomplain);
        complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(UHomeActivity.this,UFormActivity.class);
                valueSending();
                startActivity(i);
            }
        });
        adminAction=(TextView) findViewById(R.id.tadmin_action);
        adminAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(UHomeActivity.this,AdminGETForm.class);
                valueSending();
                startActivity(i);
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
    public  void valueSending(){
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


}
