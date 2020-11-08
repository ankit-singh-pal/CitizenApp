package perfect.mr.complainbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class RankActivity extends AppCompatActivity {
    /*===== String Values Used For Intents  =====*/
    String id,name,phoneNumber,city,pincode,state,ward_no,ward_name,email_id,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        /* ===== All Values Calling  ===== */
        valueCalling();
       /* Toast.makeText(this, "Check value Calling\n"+
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
                ,Toast.LENGTH_SHORT).show();*/


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
}
