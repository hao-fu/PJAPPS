package fu.hao.pjapps;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BaseAuthenicationHttpClient {
    public static int getCodeByURL(String paramString, int paramInt) {
        int i = 0;
        try {
            HttpURLConnection localHttpURLConnection = (HttpURLConnection) new URL(paramString).openConnection();
            localHttpURLConnection.setDoInput(true);
            localHttpURLConnection.connect();
            i = localHttpURLConnection.getResponseCode();
        } catch (IOException localIOException) {

            localIOException.printStackTrace();
            Log.e("info", "getCodeByURL:" + localIOException.toString());
        }
        if (i != 200) {
            if (paramInt < 1) {
                i = getCodeByURL(paramString, paramInt + 1);
            }
        }
        return i;
    }

    public static String getStringByURL(String paramString)
            throws IOException {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection) new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.connect();
        if (localHttpURLConnection.getResponseCode() == 200) {
            InputStreamReader localInputStreamReader = new InputStreamReader(localHttpURLConnection.getInputStream(), "UTF-8");
            BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
            String str;
            for (paramString = ""; ; paramString = paramString + str) {
                str = localBufferedReader.readLine();
                if (str == null) {
                    Log.i("info", "test:" + paramString);
                    localInputStreamReader.close();
                    localHttpURLConnection.disconnect();
                    return paramString;
                }
            }
        }
        return null;
    }

    public static String getXboxStrByURL(String paramString)
            throws IOException {
        HttpURLConnection localHttpURLConnection = (HttpURLConnection) new URL(paramString).openConnection();
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.addRequestProperty("User-Agent", "NokiaN7610-1/4.0850.43.1.1 Series60/3.0 Profile/MIDP-2.0 Configuration/CLDC-1.1");
        localHttpURLConnection.addRequestProperty("Accept", "*/*");
        localHttpURLConnection.addRequestProperty("Accept-Encoding", "gzip, deflate");
        localHttpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
        localHttpURLConnection.addRequestProperty("Accept-Encoding", "gzip, deflate");
        Log.i("info", localHttpURLConnection.getRequestProperties().toString());
        localHttpURLConnection.connect();
        if (localHttpURLConnection.getResponseCode() == 200) {
            InputStreamReader localInputStreamReader = new InputStreamReader(localHttpURLConnection.getInputStream());
            BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
            String str;
            for (paramString = ""; ; paramString = paramString + str) {
                str = localBufferedReader.readLine();
                if (str == null) {
                    localInputStreamReader.close();
                    localHttpURLConnection.disconnect();
                    return paramString;
                }
            }
        }
        return null;
    }
}

