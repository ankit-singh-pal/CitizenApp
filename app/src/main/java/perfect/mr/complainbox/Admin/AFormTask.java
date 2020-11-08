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

public class AFormTask extends AsyncTask<String,Void,String> {
    Context ctx;

    @Override
    protected String doInBackground(String... params) {
        String reg_url="https://unturbid-contrast.000webhostapp.com/insert_admin_form.php";
        String m= params[0];// going to stare the 1st parameter into variable called string.
        if(m.equals("FormData")){
            String user_id=params[1];
            String user_name= params[2];
            String user_city=params[3];
            String user_state=params[4];
            String user_view_detail=params[5];
            String user_complain_no=params[6];
            String user_ward_name=params[7];
            String user_ward_no=params[8];
            String user_time=params[9];
            String user_date=params[10];




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
                        URLEncoder.encode("admin_city","UTF-8")+"="+URLEncoder.encode(user_city,"UTF-8")+"&"+
                        URLEncoder.encode("admin_state","UTF-8")+"="+URLEncoder.encode(user_state,"UTF-8")+"&"+
                        URLEncoder.encode("admin_view","UTF-8")+"="+URLEncoder.encode(user_view_detail,"UTF-8")+"&"+
                        URLEncoder.encode("admin_ward_name","UTF-8")+"="+URLEncoder.encode(user_ward_name,"UTF-8")+"&"+
                        URLEncoder.encode("admin_ward_no","UTF-8")+"="+URLEncoder.encode(user_ward_no,"UTF-8")+"&"+
                        URLEncoder.encode("admin_complain_no","UTF-8")+"="+URLEncoder.encode(user_complain_no,"UTF-8")+"&"+
                        URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(user_date,"UTF-8")+"&"+
                        URLEncoder.encode("time","UTF-8")+"="+URLEncoder.encode(user_time,"UTF-8");



                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                os.close();

                InputStream IS= httpURLConnection.getInputStream();
                IS.close();
                return "Form Successful Submitted! \n"+user_id+"\n"+user_name
                        +"\n"+user_city+"\n"+user_state+"\n"+
                        user_view_detail+"\n"+user_ward_name+"\n"+user_ward_no+"\n"+user_complain_no+"\n"+user_date+"\n"+user_time;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public AFormTask(Context ctx) {
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


