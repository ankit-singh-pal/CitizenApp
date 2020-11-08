package perfect.mr.complainbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import perfect.mr.complainbox.Admin.AdminLoginActivity;
import perfect.mr.complainbox.Admin.AdminRegistrationActivity;

public class AdminMainActivity extends AppCompatActivity {

    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);


        login=(Button) findViewById(R.id.reg_btn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminMainActivity.this,AdminRegistrationActivity.class);
                startActivity(i);
            }
        });


        register=(Button) findViewById(R.id.login_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminMainActivity.this,AdminLoginActivity.class);
                startActivity(i);
            }
        });
    }
}
