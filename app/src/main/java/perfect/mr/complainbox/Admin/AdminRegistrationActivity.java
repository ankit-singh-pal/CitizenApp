package perfect.mr.complainbox.Admin;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

import perfect.mr.complainbox.R;
import perfect.mr.complainbox.User.UHomeActivity;
import perfect.mr.complainbox.User.URegisterTask;
import perfect.mr.complainbox.User.UserRegistrationActivity2;

public class AdminRegistrationActivity extends AppCompatActivity {
    TextInputLayout t_name,t_user_ward_no,
            t_user_ward_name,t_user_city,
            t_user_state,t_user_password ,t_contact_number;
    Button register1;
    String  user_name,user_ward_no,user_ward_name,user_city,
            user_state,user_email_id,user_password ,user_contact_no,user_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_registration);

        t_name = (TextInputLayout) findViewById(R.id.eName);
        t_user_ward_no = (TextInputLayout) findViewById(R.id.et_ward_no);
        t_user_ward_name = (TextInputLayout) findViewById(R.id.et_ward_name);
        t_user_city = (TextInputLayout) findViewById(R.id.et_city);
        t_user_state = (TextInputLayout) findViewById(R.id.et_state);
        t_contact_number=(TextInputLayout) findViewById(R.id.et_contact_no);
        t_user_password = (TextInputLayout) findViewById(R.id.et_password);


        register1=(Button) findViewById(R.id.buttonRegister);
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_name=t_name.getEditText().getText().toString().trim();
                user_ward_no = t_user_ward_no.getEditText().getText().toString().trim();
                user_ward_name = t_user_ward_name.getEditText().getText().toString().trim();
                user_city=t_user_city.getEditText().getText().toString().trim();
                user_state=t_user_state.getEditText().getText().toString().trim();
                user_contact_no=t_contact_number.getEditText().getText().toString().trim();
                user_password=t_user_password.getEditText().getText().toString().trim();
                act();
            }
        });

    }

    public void act(){
        /* ===== ID Generation ===== */
        String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$%&?/*-+!";
        StringBuilder stringBuilder = new StringBuilder();

        Random rnd = new Random();
        while (stringBuilder.length() < 6)
        {
            int index = (int) (rnd.nextFloat() * str.length());
            stringBuilder.append(str.charAt(index));
        }
        String user_id = stringBuilder.toString()+"2019";
        /*========================================================*/

        String m="Registration";
        ARegisterTask aRegisterTask= new ARegisterTask(this);
        aRegisterTask.execute(m,
                user_id,
                user_name,
                user_ward_no,
                user_ward_name,
                user_city,
                user_state,
                user_contact_no,
                user_password);

        Toast.makeText(this,"Reg2-act() :\n"+user_id+"\n"+
                user_name+"\n"+user_ward_no
                +"\n"+user_ward_name+"\n"
                +user_city+"\n"+user_state+"\n"+user_contact_no+"\n"
                +user_email_id+"\n"+user_password,Toast.LENGTH_LONG).show();
        try {
            Intent i = new Intent(AdminRegistrationActivity.this, AHomeActivity.class);
            i.putExtra("Id", user_id);
            i.putExtra("Name", user_name);
            i.putExtra("WardNo", user_ward_no);
            i.putExtra("WardName", user_ward_name);
            i.putExtra("MobileNo", user_contact_no);
            i.putExtra("City", user_city);
            i.putExtra("State", user_state);
            i.putExtra("Password", user_password);
            startActivity(i);
            finish();
        }catch(Exception e){Toast.makeText(this,"Intent StartActivity\n"+e.getMessage(),Toast.LENGTH_LONG).show();}
    }

}
