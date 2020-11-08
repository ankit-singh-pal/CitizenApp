package perfect.mr.complainbox.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import perfect.mr.complainbox.R;

public class UProfileActivity extends AppCompatActivity {

    /*===== String Values Used For Intents  =====*/
    String id,name,phoneNumber,city,state,ward_no,ward_name,email_id,password;
    TextView tid,tname,tphoneNumber,tcity,tstate,tward_no,tward_name,temail_id,tpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uprofile);

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
                        "email_id = "+email_id+"\n"+
                        "password = "+password
                ,Toast.LENGTH_SHORT).show();

        tid=(TextView) findViewById(R.id.tid);
        tid.setText(id);

        tname=(TextView) findViewById(R.id.tname);
        tname.setText(name);

        tcity=(TextView) findViewById(R.id.tcity);
        tcity.setText(city);

        tward_name=(TextView) findViewById(R.id.tward_name);
        tward_name.setText(ward_name);

        tward_no=(TextView) findViewById(R.id.tward_no);
        tward_no.setText(ward_no);

        tphoneNumber=(TextView) findViewById(R.id.tcontact);
        tphoneNumber.setText(phoneNumber);

        tpassword=(TextView) findViewById(R.id.password);
        tpassword.setText(password);

        temail_id=(TextView) findViewById(R.id.tedit);
        temail_id.setText(email_id);


        tstate=(TextView) findViewById(R.id.tstate);
        tstate.setText(state);
    }

    public  void valueCalling(){
        id=getIntent().getExtras().getString("Id");
        name=getIntent().getExtras().getString("Name");
        ward_no=getIntent().getExtras().getString("WardNo");
        ward_name=getIntent().getExtras().getString("WardName");
        phoneNumber=getIntent().getExtras().getString("MobileNo");
        city=getIntent().getExtras().getString("City");
        state=getIntent().getExtras().getString("State");
        email_id=getIntent().getExtras().getString("EmailId");
        password=getIntent().getExtras().getString("Password");

    }


}
