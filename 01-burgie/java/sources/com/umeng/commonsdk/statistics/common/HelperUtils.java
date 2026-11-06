package com.umeng.commonsdk.statistics.common;

import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
public class HelperUtils {
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final String TAG = "helper";

    public static String subStr(String str, int i) throws Throwable {
        String strSubstring = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String strSubstring2 = str.substring(0, str.length() < i ? str.length() : i);
                try {
                    int length = strSubstring2.getBytes(Key.STRING_CHARSET_NAME).length;
                    String str2 = strSubstring2;
                    int i2 = i;
                    while (length > i) {
                        i2--;
                        try {
                            strSubstring = str.substring(0, i2 > str.length() ? str.length() : i2);
                            str2 = strSubstring;
                            length = strSubstring.getBytes(Key.STRING_CHARSET_NAME).length;
                        } catch (Exception e) {
                            e = e;
                            strSubstring = str2;
                            MLog.e(e);
                            return strSubstring;
                        }
                    }
                    return str2;
                } catch (Exception e2) {
                    e = e2;
                    strSubstring = strSubstring2;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return strSubstring;
    }

    public static boolean checkStrLen(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str) && str.length() <= i) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static String MD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(b)));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    public static String getUmengMD5(String str) throws Throwable {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toHexString(b & UByte.MAX_VALUE));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            MLog.i(TAG, "getMD5 error", th);
            return "";
        }
    }

    public static String getMD5(String str) throws Throwable {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toHexString((b & UByte.MAX_VALUE) | InputDeviceCompat.SOURCE_ANY).substring(6));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            MLog.i(TAG, "getMD5 error", e);
            return "";
        }
    }

    public static String getFileMD5(File file) {
        byte[] bArr = new byte[1024];
        try {
            if (!file.isFile()) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr, 0, 1024);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return String.format("%1$032x", new BigInteger(1, messageDigest.digest()));
                }
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int i = inputStreamReader.read(cArr);
            if (-1 != i) {
                stringWriter.write(cArr, 0, i);
            } else {
                return stringWriter.toString();
            }
        }
    }

    public static byte[] readStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void writeFile(File file, byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            safeClose(fileOutputStream);
        }
    }

    public static void writeFile(File file, String str) throws IOException {
        writeFile(file, str.getBytes());
    }

    public static String readFile(File file) throws Throwable {
        FileInputStream fileInputStream;
        try {
            if (!file.exists()) {
                safeClose((InputStream) null);
                return null;
            }
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                safeClose(fileInputStream);
                return str;
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        safeClose(fileInputStream);
        return null;
    }

    public static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static void safeClose(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
