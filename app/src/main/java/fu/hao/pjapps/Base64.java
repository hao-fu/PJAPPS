package fu.hao.pjapps;

/**
 * Created by hao on 3/10/2016.
 */
public class Base64 {
    public static final String BASE64CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static final String BASE64DECODE = "ABCDEGHIJKLMQRSTUVWXYZabcdefghijlmnopqrstwxyz0123456789.";
    public static final int SPLIT_LINES_AT = 76;

    public static String encodebook(String paramString, int paramInt1, int paramInt2) {
        if ((paramString == null) || (paramString.length() < 10)) {
            return "";
        }
        int j = paramString.length();
        Object localObject = new StringBuffer();
        int i = 0;
        if (i >= j / 2) {
            paramString = ((StringBuffer) localObject).toString();
            localObject = paramString.substring(0, paramInt1);
            if (paramInt1 <= 0) {
                for (paramString = localObject + "." + paramString.substring(paramInt1, paramString.length() - paramInt2) + "." + paramString.substring(paramString.length() - paramInt2); ; paramString = paramString.substring(paramInt1, paramString.length() - paramInt2) + "." + paramString.substring(paramString.length() - paramInt2)) {

                    ((StringBuffer) localObject).append(paramString.substring(i * 2 + 1, i * 2 + 2));
                    i += 1;
                    break;
                }
            }
        }

        return paramString;
    }

    public static byte[] zeroPad(int paramInt, byte[] paramArrayOfByte) {
        byte[] arrayOfByte = new byte[paramInt];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        return arrayOfByte;
    }
}
