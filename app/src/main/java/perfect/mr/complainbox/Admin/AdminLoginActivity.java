package perfect.mr.complainbox.Admin;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import perfect.mr.complainbox.R;
import perfect.mr.complainbox.Admin.AHomeActivity;

public class AdminLoginActivity extends AppCompatActivity {

    TextInputLayout t_user_username,t_user_password;
    String username,password;
    Button login;

    String db_username,db_password,db_Name,db_phoneNumber,db_city,db_state,db_ward_no,db_ward_name;

    String json_string;
    String JSON_STRING;

    private ProgressDialog mLoginProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        mLoginProgress = new ProgressDialog(this);

        t_user_username=(TextInputLayout)findViewById(R.id.username);
        t_user_password=(TextInputLayout) findViewById(R.id.password);



        login=(Button)findViewById(R.id.buttonLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=t_user_username.getEditText().getText().toString().trim();
                password=t_user_password.getEditText().getText().toString().trim();
                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
                    Toast.makeText(AdminLoginActivity.this, "Please Fill all blocks", Toast.LENGTH_SHORT).show();
                    return ;
                }

                Toast.makeText(AdminLoginActivity.this, "Login Details\n"+username+"\n"+password, Toast.LENGTH_SHORT).show();

                mLoginProgress.setTitle("Logging In");
                mLoginProgress.setMessage("Please wait while we check your credentials.");
                mLoginProgress.setCanceledOnTouchOutside(false);
                mLoginProgress.show();


                CheckLoginData();

            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();

        new AdminLoginActivity.BackgroundTask().execute();
        Toast.makeText(AdminLoginActivity.this,"Data Retrieved onStart",Toast.LENGTH_LONG).show();

    }

    public class BackgroundTask extends AsyncTask<Void,Void,String> {

        //String user_login_url="https://unturbid-contrast.000webhostapp.com/user_login_getjson.php";
        String user_login_url="https://unturbid-contrast.000webhostapp.com/get_admin_data.php";
        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url= new URL(user_login_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder= new StringBuilder();

                while ((json_string=bufferedReader.readLine())!=null){

                    stringBuilder.append(json_string+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        public BackgroundTask() {
            super();
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView= (TextView)findViewById(R.id.textView);
            textView.setText(result);

            // parse in a proper format
            JSON_STRING=result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    void CheckLoginData(){
        try {

            JSONObject jsonObject=new JSONObject(JSON_STRING);

            try{
                JSONArray jsonArray = jsonObject.getJSONArray("Server response");

                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject JO= jsonArray.getJSONObject(i);

                    db_username= JO.getString("admin_id");
                    db_password= JO.getString("admin_password");
                    db_Name=JO.getString("admin_name");
                    db_phoneNumber=JO.getString("admin_contact_no");
                    db_city=JO.getString("admin_city");
                   // db_pincode=JO.getString("admin_pincode");
                    db_state=JO.getString("admin_state");
                    db_ward_no=JO.getString("admin_ward_no");
                    db_ward_name=JO.getString("admin_ward_name");

                    if((username.equals(db_username))   && (password.equals(db_password))) {
                        Toast.makeText(this, String.valueOf(db_username)+" = "+username + "\n"
                                + String.valueOf(db_password)+" = "+password, Toast.LENGTH_LONG).show();
                        Intent i1=new Intent(this,AHomeActivity.class);
                        i1.putExtra("Id",db_username);
                        i1.putExtra("Name",db_Name);
                        i1.putExtra("WardNo",db_ward_no);
                        i1.putExtra("WardName",db_ward_name);
                        i1.putExtra("MobileNo",db_phoneNumber);
                        i1.putExtra("City",db_city);
                       // i1.putExtra("Pincode",db_pincode);
                        i1.putExtra("State",db_state);
                        i1.putExtra("Password",db_password);

                        startActivity(i1);
                        finish();


                    }

                }

            }catch(Exception e){Toast.makeText(this, "Error : " + e.getMessage(), Toast.LENGTH_LONG).show();}    //


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
