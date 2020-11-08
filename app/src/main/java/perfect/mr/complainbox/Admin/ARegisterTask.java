package perfect.mr.complainbox.Admin;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

public class ARegisterTask extends AsyncTask<String,Void,String> {
    Context ctx;

    @Override
    protected String doInBackground(String... params) {
        String reg_url="https://unturbid-contrast.000webhostapp.com/insert_admin_data.php";
        String m= params[0];// going to stare the 1st parameter into variable called string.
        if(m.equals("Registration")){
            String user_id=params[1];
            String user_name= params[2];
            String user_ward_no=params[3];
            String user_ward_name=params[4];
            String user_city=params[5];
            String user_state=params[6];
            String user_contact_no=params[7];
            String user_password=params[8];

            try {
                URL url= new URL(reg_url);  //create object of url
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();  //send this to db
                //^
                //  |
                //Typecast
                httpURLConnection.setRequestMethod("POST");     //  to set request method basically mention the method which r going to use to transfer the data
                httpURLConnection.setDoOutput(true);
                OutputStream os= httpURLConnection.getOutputStream();   // obj of outputstream &allow to send the data to stream

                BufferedWriter bufferedWriter= new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));  //to write data in db

                // create string and encode all the data into string
                String data=URLEncoder.encode("admin_id", "UTF-8")+"="+URLEncoder.encode(user_id,"UTF-8")+"&"+
                        URLEncoder.encode("admin_name", "UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+
                        URLEncoder.encode("admin_ward_no ","UTF-8")+"="+URLEncoder.encode(user_ward_no,"UTF-8")+"&"+
                        URLEncoder.encode("admin_ward_name","UTF-8")+"="+URLEncoder.encode(user_ward_name,"UTF-8")+"&"+
                        URLEncoder.encode("admin_city","UTF-8")+"="+URLEncoder.encode(user_city,"UTF-8")+"&"+
                        URLEncoder.encode("admin_state","UTF-8")+"="+URLEncoder.encode(user_state,"UTF-8")+"&"+
                        URLEncoder.encode("admin_contact_no","UTF-8")+"="+URLEncoder.encode(user_contact_no,"UTF-8")+"&"+
                        URLEncoder.encode("admin_password","UTF-8")+"="+URLEncoder.encode(user_password,"UTF-8");



                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                os.close();

                InputStream IS= httpURLConnection.getInputStream();
                IS.close();
                return "Registration Successful ! \n"+user_id+"\n"+user_name+
                        user_ward_no+"\n"+user_ward_name
                        +"\n"+user_city+"\n"+user_state+user_contact_no+"\n"+user_password;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ARegisterTask(Context ctx) {
        this.ctx=ctx;
    }
    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();

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

