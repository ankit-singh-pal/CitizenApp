package perfect.mr.complainbox.User;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

import perfect.mr.complainbox.R;

public class SendSMS extends AppCompatActivity {
    private String mobile="9589439066";  //Enter Mobile no
    private int otp;


    private String authkey = "263439AMosizmREC5c97d26d";      // API KEY
    private String senderId = "MR-PERFECT";            //Sender ID
    private String route = "4";               // Enter 1 for promotional and 4 for transational
    private int max = 5000;                  // Enter max no. for which you want to generate an otp
    private int min = 1000;                  // Enter min no. for which you want to generate an otp
    private String countrycode="+91";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);

       // sendSms(authkey,mobile,senderId,route,countrycode,max,min);






    }

    public void sendSms(String authkey, String mobile, String senderId, String route, String countrycode, int max, int min) {
        otp = randomOtpGenrator(min, max);
        String message = "" + otp;

        TextView oOTP=(TextView) findViewById(R.id.totp);

        oOTP.setText(otp);
        URLConnection myURLConnection = null;
        URL myURL = null;
        BufferedReader reader = null;

        //encoding message (if you want to encode message then use this)
        // String encoded_message= URLEncoder.encode(message);

        //Send SMS API
        String mainUrl = "http://api.msg91.com/api/sendhttp.php?";

        //Prepare parameter string
        StringBuilder sbPostData = new StringBuilder(mainUrl);
        sbPostData.append("route=" + route);
        sbPostData.append("&sender=" + senderId);
        sbPostData.append("&mobiles=" + mobile);
        sbPostData.append("&authkey=" + authkey);
        sbPostData.append("&message=" + message);
        sbPostData.append("&country=" + countrycode);


        //final string
        mainUrl = sbPostData.toString();
        try {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader = new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

            //reading response
            String response;
            while ((response = reader.readLine()) != null)
                //print response
                Log.d("RESPONSE", "" + response);

            //finally close connection
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private int randomOtpGenrator(int min, int max) {
        if (min > max) {
            return 0;
        }
        Random random = new Random();
        int otpnumber = random.nextInt(max - min + 1) + min;
        return otpnumber;
    }

}
