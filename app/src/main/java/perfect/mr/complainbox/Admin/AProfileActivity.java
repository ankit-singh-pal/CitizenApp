package perfect.mr.complainbox.Admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import perfect.mr.complainbox.R;

public class AProfileActivity  extends AppCompatActivity {

    /*===== String Values Used For Intents  =====*/
    String id,name,phoneNumber,city,pincode,state,ward_no,ward_name,password;
    TextView tid,tname,tphoneNumber,tcity,tpincode,tstate,tward_no,tward_name,tpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprofile);

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

    tpincode=(TextView) findViewById(R.id.tpincode);
        tpincode.setText(pincode);

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
        pincode=getIntent().getExtras().getString("Pincode");
        password=getIntent().getExtras().getString("Password");

    }


}

