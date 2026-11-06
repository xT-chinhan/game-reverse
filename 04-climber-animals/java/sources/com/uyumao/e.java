package com.uyumao;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DevInfoUtil.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {
    public static Context a;
    public static WeakReference<Future<?>> b;
    public static WeakReference<Future<?>> c;

    public static Context a() {
        return a;
    }

    public static Boolean b() {
        Boolean bool = Boolean.FALSE;
        try {
            Class<?> cls = Class.forName("com.umeng.commonsdk.UMConfigure");
            Method declaredMethod = cls.getDeclaredMethod("isInForeground", new Class[0]);
            if (declaredMethod == null) {
                return bool;
            }
            declaredMethod.setAccessible(true);
            return (Boolean) declaredMethod.invoke(cls, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return bool;
        }
    }

    public static String[] c(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!a(context, com.kuaishou.weapon.p0.g.b)) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "Wi-Fi";
                return strArr;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = "mobile_network";
                strArr[1] = networkInfo2.getSubtypeName();
            }
            return strArr;
        } catch (Throwable unused) {
        }
    }

    public static String d(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static JSONArray e(Context context) {
        WifiManager wifiManager;
        if (context == null || !h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            WifiInfo connectionInfo = (!a(context, com.kuaishou.weapon.p0.g.d) || (wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)) == null) ? null : wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            String strReplace = connectionInfo.getSSID().replace("\"", "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject.put("bssid", bssid);
            jSONObject.put("ssid", strReplace);
            jSONObject.put("ts", jCurrentTimeMillis);
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray f(Context context) {
        List<ScanResult> scanResults;
        if (!h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager != null && a(context, com.kuaishou.weapon.p0.g.d) && a(context, com.kuaishou.weapon.p0.g.g) && (scanResults = wifiManager.getScanResults()) != null) {
                int size = scanResults.size();
                if (size > 100) {
                    size = 100;
                }
                for (int i = 0; i < size; i++) {
                    ScanResult scanResult = scanResults.get(i);
                    if (scanResult != null) {
                        String str = scanResult.BSSID;
                        String str2 = scanResult.SSID;
                        String strValueOf = String.valueOf(scanResult.level);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bssid", str);
                        jSONObject.put("ssid", str2);
                        jSONObject.put("rssi", strValueOf);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String[] g(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String[] strArr = {"", ""};
        try {
            if (a(context, com.kuaishou.weapon.p0.g.d) && a(context, com.kuaishou.weapon.p0.g.h) && a(context, com.kuaishou.weapon.p0.g.g) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String ssid = connectionInfo.getSSID();
                String bssid = connectionInfo.getBSSID();
                if (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') {
                    strArr[0] = ssid.substring(1, ssid.length() - 1);
                }
                if (bssid != null) {
                    strArr[1] = bssid;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return strArr;
    }

    public static boolean h(Context context) {
        WifiManager wifiManager;
        if (context == null) {
            return false;
        }
        try {
            return 3 == ((!a(context, com.kuaishou.weapon.p0.g.d) || (wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)) == null) ? -1 : wifiManager.getWifiState());
        } catch (Throwable unused) {
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ bArr2[i % bArr2.length]) ^ (i & 255));
            }
        }
        return bArr;
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z) throws Exception {
        SystemClock.elapsedRealtime();
        URL url = new URL(str);
        return new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        String string = "";
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, i));
                    }
                    string = sb.toString();
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.e("efs.util.file", "read file error", th);
                    } finally {
                        a(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        return string;
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int i = gZIPInputStream.read(bArr2);
                    if (i == -1) {
                        break;
                    } else {
                        outputStream.write(bArr2, 0, i);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPInputStream = null;
        }
        n.a(gZIPInputStream);
    }

    public static boolean a(File file, byte[] bArr, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, z);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                a(fileOutputStream);
                return true;
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    return false;
                } finally {
                    a(fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    public static JSONObject b(Context context) {
        LocationManager locationManager;
        String str = "network";
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!a(context, com.kuaishou.weapon.p0.g.g) || !a(context, com.kuaishou.weapon.p0.g.h) || (locationManager = (LocationManager) context.getSystemService("location")) == null) {
                return null;
            }
            List<String> providers = locationManager.getProviders(true);
            if (providers.contains("gps")) {
                str = "gps";
            } else if (providers.contains("network")) {
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(str);
            if (lastKnownLocation != null) {
                String str2 = "latitude is " + lastKnownLocation.getLatitude() + "\nlongitude is " + lastKnownLocation.getLongitude();
                double latitude = lastKnownLocation.getLatitude();
                double longitude = lastKnownLocation.getLongitude();
                double altitude = lastKnownLocation.hasAltitude() ? lastKnownLocation.getAltitude() : 0.0d;
                double speed = lastKnownLocation.hasSpeed() ? lastKnownLocation.getSpeed() : 0.0d;
                long time = lastKnownLocation.getTime();
                jSONObject.put("c_lat", latitude);
                jSONObject.put("c_lng", longitude);
                jSONObject.put("c_alt", altitude);
                jSONObject.put("c_acc", speed);
                jSONObject.put("c_lts", time);
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        GZIPOutputStream gZIPOutputStream;
        InputStream errorStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = str.getBytes();
        OutputStream outputStream = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPOutputStream = null;
        }
        n.a(gZIPOutputStream);
        byte[] bArrA = a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(bArrA.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArrA);
            n.a(outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (errorStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int i = errorStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (Throwable th) {
                        n.a(errorStream);
                        throw th;
                    }
                }
                n.a(errorStream);
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] bArrA2 = a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                a(bArrA2, byteArrayOutputStream);
            }
            String string = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return string;
            }
            throw new IOException("code:" + responseCode + " msg:" + string);
        } catch (Throwable th2) {
            n.a(outputStream);
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00e2 A[Catch: all -> 0x0269, TRY_LEAVE, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ea A[Catch: all -> 0x0269, TRY_ENTER, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ff A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0108 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0150 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0154 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x0169 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0172 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x01ba A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x01be A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01fe A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0202 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0217 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0220 A[Catch: all -> 0x0269, TryCatch #0 {all -> 0x0269, blocks: (B:24:0x0084, B:25:0x00a6, B:27:0x00aa, B:28:0x00e2, B:31:0x00ea, B:33:0x00ff, B:35:0x0133, B:34:0x0108, B:36:0x0150, B:38:0x0154, B:40:0x0169, B:42:0x019d, B:41:0x0172, B:43:0x01ba, B:45:0x01be, B:46:0x01fe, B:48:0x0202, B:50:0x0217, B:52:0x024b, B:51:0x0220), top: B:59:0x0084 }] */
    public static JSONArray a(Context context) {
        CellIdentityGsm cellIdentity;
        String strSubstring;
        String strValueOf;
        CellIdentityWcdma cellIdentity2;
        String strSubstring2;
        String strValueOf2;
        CellIdentityLte cellIdentity3;
        String strSubstring3;
        String strValueOf3;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (a(context, com.kuaishou.weapon.p0.g.g)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    try {
                        networkOperator.substring(0, 3);
                        networkOperator.substring(3);
                    } catch (Throwable unused) {
                    }
                }
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        if (cellInfo.isRegistered()) {
                            int i = Build.VERSION.SDK_INT;
                            if (i >= 29) {
                                if (cellInfo instanceof CellInfoNr) {
                                    JSONObject jSONObject = new JSONObject();
                                    CellIdentityNr cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                                    int pci = cellIdentityNr.getPci();
                                    long nci = cellIdentityNr.getNci();
                                    int tac = cellIdentityNr.getTac();
                                    String mncString = cellIdentityNr.getMncString();
                                    String mccString = cellIdentityNr.getMccString();
                                    try {
                                        jSONObject.put("nt", "Nr");
                                        jSONObject.put("pci", pci);
                                        jSONObject.put("nci", nci);
                                        jSONObject.put("tac", tac);
                                        jSONObject.put("mnc", mncString);
                                        jSONObject.put("mcc", mccString);
                                        jSONObject.put("ts", System.currentTimeMillis());
                                        jSONArray.put(jSONObject);
                                    } catch (Throwable unused2) {
                                        return null;
                                    }
                                } else if (cellInfo instanceof CellInfoTdscdma) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    CellIdentityTdscdma cellIdentity4 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                                    int cid = cellIdentity4.getCid();
                                    int lac = cellIdentity4.getLac();
                                    String mncString2 = cellIdentity4.getMncString();
                                    String mccString2 = cellIdentity4.getMccString();
                                    jSONObject2.put("nt", "Tdscdma");
                                    jSONObject2.put("cid", cid);
                                    jSONObject2.put("lac", lac);
                                    jSONObject2.put("mnc", mncString2);
                                    jSONObject2.put("mcc", mccString2);
                                    jSONObject2.put("ts", System.currentTimeMillis());
                                    jSONArray.put(jSONObject2);
                                } else if (cellInfo instanceof CellInfoLte) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                                    int pci2 = cellIdentity3.getPci();
                                    int tac2 = cellIdentity3.getTac();
                                    if (i >= 28) {
                                        strSubstring3 = cellIdentity3.getMncString();
                                        strValueOf3 = cellIdentity3.getMccString();
                                    } else {
                                        String str = "00" + String.valueOf(cellIdentity3.getMnc());
                                        strSubstring3 = str.substring(str.length() - 2);
                                        strValueOf3 = String.valueOf(cellIdentity3.getMcc());
                                    }
                                    jSONObject3.put("nt", "Lte");
                                    jSONObject3.put("pci", pci2);
                                    jSONObject3.put("tac", tac2);
                                    jSONObject3.put("mnc", strSubstring3);
                                    jSONObject3.put("mcc", strValueOf3);
                                    jSONObject3.put("ts", System.currentTimeMillis());
                                    jSONArray.put(jSONObject3);
                                } else if (cellInfo instanceof CellInfoWcdma) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    cellIdentity2 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                                    int cid2 = cellIdentity2.getCid();
                                    int lac2 = cellIdentity2.getLac();
                                    if (i >= 28) {
                                        strSubstring2 = cellIdentity2.getMncString();
                                        strValueOf2 = cellIdentity2.getMccString();
                                    } else {
                                        String str2 = "00" + String.valueOf(cellIdentity2.getMnc());
                                        strSubstring2 = str2.substring(str2.length() - 2);
                                        strValueOf2 = String.valueOf(cellIdentity2.getMcc());
                                    }
                                    jSONObject4.put("nt", "Wcdma");
                                    jSONObject4.put("cid", cid2);
                                    jSONObject4.put("lac", lac2);
                                    jSONObject4.put("mnc", strSubstring2);
                                    jSONObject4.put("mcc", strValueOf2);
                                    jSONObject4.put("ts", System.currentTimeMillis());
                                    jSONArray.put(jSONObject4);
                                } else if (cellInfo instanceof CellInfoCdma) {
                                    JSONObject jSONObject5 = new JSONObject();
                                    CellIdentityCdma cellIdentity5 = ((CellInfoCdma) cellInfo).getCellIdentity();
                                    int basestationId = cellIdentity5.getBasestationId();
                                    int networkId = cellIdentity5.getNetworkId();
                                    int systemId = cellIdentity5.getSystemId();
                                    jSONObject5.put("nt", "Cdma");
                                    jSONObject5.put(com.anythink.core.common.m.b.g.i, basestationId);
                                    jSONObject5.put("nid", networkId);
                                    jSONObject5.put("sid", systemId);
                                    jSONObject5.put("mnc", "03");
                                    jSONObject5.put("mcc", "460");
                                    jSONObject5.put("ts", System.currentTimeMillis());
                                    jSONArray.put(jSONObject5);
                                } else if (cellInfo instanceof CellInfoGsm) {
                                    JSONObject jSONObject6 = new JSONObject();
                                    cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                                    int cid3 = cellIdentity.getCid();
                                    int lac3 = cellIdentity.getLac();
                                    if (i >= 28) {
                                        strSubstring = cellIdentity.getMncString();
                                        strValueOf = cellIdentity.getMccString();
                                    } else {
                                        String str3 = "00" + String.valueOf(cellIdentity.getMnc());
                                        strSubstring = str3.substring(str3.length() - 2);
                                        strValueOf = String.valueOf(cellIdentity.getMcc());
                                    }
                                    jSONObject6.put("nt", "Gsm");
                                    jSONObject6.put("cid", cid3);
                                    jSONObject6.put("lac", lac3);
                                    jSONObject6.put("mnc", strSubstring);
                                    jSONObject6.put("mcc", strValueOf);
                                    jSONObject6.put("ts", System.currentTimeMillis());
                                    jSONArray.put(jSONObject6);
                                }
                            } else if (cellInfo instanceof CellInfoLte) {
                                JSONObject jSONObject7 = new JSONObject();
                                cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                                int pci3 = cellIdentity3.getPci();
                                int tac3 = cellIdentity3.getTac();
                                if (i >= 28) {
                                    strSubstring3 = cellIdentity3.getMncString();
                                    strValueOf3 = cellIdentity3.getMccString();
                                } else {
                                    String str4 = "00" + String.valueOf(cellIdentity3.getMnc());
                                    strSubstring3 = str4.substring(str4.length() - 2);
                                    strValueOf3 = String.valueOf(cellIdentity3.getMcc());
                                }
                                jSONObject7.put("nt", "Lte");
                                jSONObject7.put("pci", pci3);
                                jSONObject7.put("tac", tac3);
                                jSONObject7.put("mnc", strSubstring3);
                                jSONObject7.put("mcc", strValueOf3);
                                jSONObject7.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject7);
                            } else if (cellInfo instanceof CellInfoWcdma) {
                                JSONObject jSONObject8 = new JSONObject();
                                cellIdentity2 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                                int cid4 = cellIdentity2.getCid();
                                int lac4 = cellIdentity2.getLac();
                                if (i >= 28) {
                                    strSubstring2 = cellIdentity2.getMncString();
                                    strValueOf2 = cellIdentity2.getMccString();
                                } else {
                                    String str5 = "00" + String.valueOf(cellIdentity2.getMnc());
                                    strSubstring2 = str5.substring(str5.length() - 2);
                                    strValueOf2 = String.valueOf(cellIdentity2.getMcc());
                                }
                                jSONObject8.put("nt", "Wcdma");
                                jSONObject8.put("cid", cid4);
                                jSONObject8.put("lac", lac4);
                                jSONObject8.put("mnc", strSubstring2);
                                jSONObject8.put("mcc", strValueOf2);
                                jSONObject8.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject8);
                            } else if (cellInfo instanceof CellInfoCdma) {
                                JSONObject jSONObject9 = new JSONObject();
                                CellIdentityCdma cellIdentity6 = ((CellInfoCdma) cellInfo).getCellIdentity();
                                int basestationId2 = cellIdentity6.getBasestationId();
                                int networkId2 = cellIdentity6.getNetworkId();
                                int systemId2 = cellIdentity6.getSystemId();
                                jSONObject9.put("nt", "Cdma");
                                jSONObject9.put(com.anythink.core.common.m.b.g.i, basestationId2);
                                jSONObject9.put("nid", networkId2);
                                jSONObject9.put("sid", systemId2);
                                jSONObject9.put("mnc", "03");
                                jSONObject9.put("mcc", "460");
                                jSONObject9.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject9);
                            } else if (cellInfo instanceof CellInfoGsm) {
                                JSONObject jSONObject10 = new JSONObject();
                                cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                                int cid5 = cellIdentity.getCid();
                                int lac5 = cellIdentity.getLac();
                                if (i >= 28) {
                                    strSubstring = cellIdentity.getMncString();
                                    strValueOf = cellIdentity.getMccString();
                                } else {
                                    String str6 = "00" + String.valueOf(cellIdentity.getMnc());
                                    strSubstring = str6.substring(str6.length() - 2);
                                    strValueOf = String.valueOf(cellIdentity.getMcc());
                                }
                                jSONObject10.put("nt", "Gsm");
                                jSONObject10.put("cid", cid5);
                                jSONObject10.put("lac", lac5);
                                jSONObject10.put("mnc", strSubstring);
                                jSONObject10.put("mcc", strValueOf);
                                jSONObject10.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject10);
                            }
                            jSONArray2 = null;
                        }
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused3) {
            return jSONArray2;
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) throws Exception {
        GZIPOutputStream gZIPOutputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        boolean z;
        String string = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = string.getBytes();
        InputStream errorStream = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPOutputStream = null;
        }
        n.a(gZIPOutputStream);
        byte[] bArrA = a(byteArrayOutputStream.toByteArray(), bytes);
        SystemClock.elapsedRealtime();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.addRequestProperty("appkey", str2);
                if (TextUtils.isEmpty(jSONObject.optString("uuid"))) {
                    z = true;
                } else {
                    httpURLConnection.addRequestProperty("Rich-Resp-Code", "1");
                    z = false;
                }
                httpURLConnection.setFixedLengthStreamingMode(bArrA.length);
                httpURLConnection.setDoOutput(true);
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(bArrA);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 400) {
                        errorStream = httpURLConnection.getInputStream();
                    } else {
                        errorStream = httpURLConnection.getErrorStream();
                    }
                    byteArrayOutputStream.reset();
                    if (errorStream != null) {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i = errorStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                        }
                    }
                    n.a(outputStream);
                    n.a(errorStream);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    if (responseCode == 200) {
                        byte[] bArrA2 = a(byteArrayOutputStream.toByteArray(), bytes);
                        byteArrayOutputStream.reset();
                        if (z) {
                            a(bArrA2, byteArrayOutputStream);
                            byteArrayOutputStream.toString();
                        } else {
                            new String(bArrA2);
                        }
                    }
                    if (responseCode != 200) {
                        throw new Exception("response code " + responseCode);
                    }
                } catch (Throwable th) {
                    th = th;
                    n.a(outputStream);
                    n.a(errorStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            outputStream = null;
        }
    }

    public static void a(File file) {
        File[] fileArrListFiles;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
                        for (File file2 : fileArrListFiles) {
                            a(file2);
                        }
                    }
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String a(NetworkInfo networkInfo) {
        try {
            int subtype = networkInfo.getSubtype();
            if (subtype == 20) {
                return "5G";
            }
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    String subtypeName = networkInfo.getSubtypeName();
                    if (TextUtils.isEmpty(subtypeName)) {
                        return "";
                    }
                    return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? "3G" : subtypeName;
            }
            th.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.json.JSONArray] */
    public static JSONArray a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            try {
                if (jSONObject != 0 && jSONObject2 != null) {
                    JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                    if (jSONObject2.length() > 0) {
                        Iterator<String> itKeys = jSONObject2.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            jSONObject3.put(next, jSONObject2.get(next));
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject3);
                    jSONObject = jSONArray;
                } else {
                    if (jSONObject != 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        try {
                            jSONArray2.put((Object) jSONObject);
                            return jSONArray2;
                        } catch (Throwable unused) {
                            return jSONArray2;
                        }
                    }
                    JSONArray jSONArray3 = new JSONArray();
                    jSONArray3.put(jSONObject2);
                    jSONObject = jSONArray3;
                }
            } catch (Throwable unused2) {
            }
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
