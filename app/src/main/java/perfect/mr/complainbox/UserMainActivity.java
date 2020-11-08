package perfect.mr.complainbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import perfect.mr.complainbox.MobileVerification.OTPActivity;
import perfect.mr.complainbox.User.UserLoginActivity;

public class UserMainActivity extends AppCompatActivity {

    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);


        register=(Button) findViewById(R.id.login_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserMainActivity.this,OTPActivity.class);
                startActivity(i);
            }
        });


        login=(Button) findViewById(R.id.reg_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserMainActivity.this,UserLoginActivity.class);
                startActivity(i);
            }
        });


    }
}
