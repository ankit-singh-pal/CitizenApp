package perfect.mr.complainbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import perfect.mr.complainbox.User.SendSMS;

public class MainActivity extends AppCompatActivity {

    Button user,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(Button) findViewById(R.id.bt_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,UserMainActivity.class);
                startActivity(i);
            }
        });
        admin=(Button) findViewById(R.id.bt_admin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AdminMainActivity.class);
                startActivity(i);
            }
        });
    }
}
