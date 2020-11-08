package perfect.mr.complainbox.TestCase;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.ArrayList;
import java.util.List;

import perfect.mr.complainbox.R;

public class AdminGETForm extends AppCompatActivity {

    TextInputLayout t_user_username, t_user_password;
    String username, password;
    Button login;

    String db_username, db_password, db_Name, db_phoneNumber, db_city, db_pincode, db_state, db_ward_no, db_ward_name, db_email_id;

    String json_string;
    String JSON_STRING="unturbid-contrast.000webhostapp.com/get_admin_form.php";
    RecyclerView recyclerView;
    private ProgressDialog mLoginProgress;
    List<ADataAdapter> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_main);


        try {
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }catch(Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        mLoginProgress = new ProgressDialog(this);
        productList = new ArrayList<>();

    }

    @Override
    protected void onStart() {
        super.onStart();

        new AdminGETForm.BackgroundTask().execute();
        Toast.makeText(AdminGETForm.this, "Data Retrieved onStart", Toast.LENGTH_LONG).show();

    }

    public class BackgroundTask extends AsyncTask<Void, Void, String> {

        //String user_login_url="https://unturbid-contrast.000webhostapp.com/user_login_getjson.php";
        String user_login_url = "https://unturbid-contrast.000webhostapp.com/get_admin_form.php";

        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url = new URL(user_login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((json_string = bufferedReader.readLine()) != null) {

                    stringBuilder.append(json_string + "\n");
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
          /*  TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(result);
*/
            // parse in a proper format
            JSON_STRING = result;
            mLoginProgress.dismiss();

            CheckLoginData();

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoginProgress.setMessage("Data is Retrieve from Batabase");
            mLoginProgress.setTitle("Please Wait");
            mLoginProgress.setCanceledOnTouchOutside(false);
            mLoginProgress.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    void CheckLoginData() {
        mLoginProgress.dismiss();

        try {

            JSONObject jsonObject = new JSONObject(JSON_STRING);


            try {
                JSONArray jsonArray = jsonObject.getJSONArray("Server response");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject product = jsonArray.getJSONObject(i);

                    productList.add(new ADataAdapter(
                            product.getString("admin_id"),
                            product.getString("admin_name"),
                            product.getString("admin_ward_no"),
                            product.getString("admin_ward_name"),
                            product.getString("admin_city"),
                            product.getString("admin_state"),
                            product.getString("admin_complain_no"),
                            product.getString("admin_view"),
                            product.getString("time"),
                            product.getString("date")
                    ));


                    AAdapter adapter = new AAdapter(AdminGETForm.this, productList);
                    recyclerView.setAdapter(adapter);


                }

            } catch (Exception e) {
                Toast.makeText(this, "Error : " + e.getMessage(), Toast.LENGTH_LONG).show();
            }    //no value for id


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}




