package com.mar.sdk.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.Key;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.mar.sdk.log.Log;
import com.taptap.sdk.db.constant.Common;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class GUtils {
    private static final String fileAddressMac = "/sys/class/net/wlan0/address";
    private static final String marshmallowMacAddress = "02:00:00:00:00:00";
    protected static String uuid;

    public static String getDeviceID(Context context) {
        if (uuid == null) {
            generateDeviceID(context);
        }
        return uuid.replace("-", "");
    }

    @SuppressLint({"NewApi", "MissingPermission"})
    public static void generateDeviceID(Context context) {
        if (uuid == null) {
            synchronized (GUtils.class) {
                if (uuid == null) {
                    SharedPreferences prefs = context.getSharedPreferences("g_device_id.xml", 0);
                    String id = prefs.getString("device_id", null);
                    if (id != null) {
                        uuid = id;
                    } else {
                        String androidId = Settings.Secure.getString(context.getContentResolver(), Common.Predefined.SUB_ANDROID_ID);
                        try {
                            if (!"9774d56d682e549c".equals(androidId)) {
                                uuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf8")).toString();
                            } else {
                                String deviceId = null;
                                try {
                                    deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                uuid = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")).toString() : UUID.randomUUID().toString();
                            }
                            prefs.edit().putString("device_id", uuid.toString()).commit();
                        } catch (UnsupportedEncodingException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getMacAddress(Context context) {
        try {
            WifiManager wifiMan = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            WifiInfo wifiInf = wifiMan.getConnectionInfo();
            if (wifiInf != null && marshmallowMacAddress.equals(wifiInf.getMacAddress())) {
                try {
                    String result = getAdressMacByInterface();
                    if (result == null) {
                        return getAddressMacByFile(wifiMan);
                    }
                    return result;
                } catch (IOException e) {
                    Log.e("MobileAccess", "Erreur lecture propriete Adresse MAC");
                    return marshmallowMacAddress;
                } catch (Exception e2) {
                    Log.e("MobileAcces", "Erreur lecture propriete Adresse MAC ");
                    return marshmallowMacAddress;
                }
            }
            if (wifiInf != null && wifiInf.getMacAddress() != null) {
                return wifiInf.getMacAddress();
            }
            return "";
        } catch (Exception e3) {
            e3.printStackTrace();
            return AbstractJsonLexerKt.NULL;
        }
    }

    @SuppressLint({"NewApi"})
    private static String getAdressMacByInterface() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (nif.getName().equalsIgnoreCase("wlan0")) {
                    byte[] macBytes = nif.getHardwareAddress();
                    if (macBytes == null) {
                        return "";
                    }
                    StringBuilder res1 = new StringBuilder();
                    for (byte b : macBytes) {
                        res1.append(String.format("%02X:", Byte.valueOf(b)));
                    }
                    if (res1.length() > 0) {
                        res1.deleteCharAt(res1.length() - 1);
                    }
                    return res1.toString();
                }
            }
        } catch (Exception e) {
            Log.e("MobileAcces", "Erreur lecture propriete Adresse MAC ");
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private static String getAddressMacByFile(WifiManager wifiMan) throws Exception {
        int wifiState = wifiMan.getWifiState();
        wifiMan.setWifiEnabled(true);
        File fl = new File(fileAddressMac);
        FileInputStream fin = new FileInputStream(fl);
        String ret = crunchifyGetStringFromStream(fin);
        fin.close();
        boolean enabled = 3 == wifiState;
        wifiMan.setWifiEnabled(enabled);
        return ret;
    }

    private static String crunchifyGetStringFromStream(InputStream crunchifyStream) throws IOException {
        if (crunchifyStream == null) {
            return "No Contents";
        }
        Writer crunchifyWriter = new StringWriter();
        char[] crunchifyBuffer = new char[2048];
        try {
            Reader crunchifyReader = new BufferedReader(new InputStreamReader(crunchifyStream, Key.STRING_CHARSET_NAME));
            while (true) {
                int counter = crunchifyReader.read(crunchifyBuffer);
                if (counter != -1) {
                    crunchifyWriter.write(crunchifyBuffer, 0, counter);
                } else {
                    crunchifyStream.close();
                    return crunchifyWriter.toString();
                }
            }
        } catch (Throwable th) {
            crunchifyStream.close();
            throw th;
        }
    }

    public static String getScreenDpi(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels + "×" + dm.heightPixels;
    }

    public static String generateUrlSortedParamString(Map<String, String> params, String splitChar, boolean nullExcluded) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key) == null ? "" : params.get(key).toString();
            if (!nullExcluded || value.length() != 0) {
                content.append(key + "=" + value);
                if (!TextUtils.isEmpty(splitChar)) {
                    content.append(splitChar);
                }
            }
        }
        if (content.length() > 0 && !TextUtils.isEmpty(splitChar)) {
            content.deleteCharAt(content.length() - 1);
        }
        return content.toString();
    }

    public static void runInThread(Runnable run) {
        Thread t = new Thread(run);
        t.start();
    }

    @SuppressLint({"NewApi"})
    public static String[] getLackedPermissions(Activity context, String[] permissions) {
        if (permissions == null || permissions.length <= 0 || Build.VERSION.SDK_INT < 23) {
            return null;
        }
        List<String> lacks = new ArrayList<>();
        for (String p : permissions) {
            if (context.checkSelfPermission(p) != 0) {
                lacks.add(p);
            }
        }
        return (String[]) lacks.toArray(new String[lacks.size()]);
    }

    public static String getPackageName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo info = packageManager.getPackageInfo(context.getPackageName(), 0);
            String name = info.packageName;
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
            String name = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "");
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getAppVersionName(Context ctx) {
        try {
            PackageInfo packageInfo = ctx.getApplicationContext().getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            String localVersion = packageInfo.versionName;
            return localVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getAppVersionCode(Context ctx) {
        try {
            PackageInfo packageInfo = ctx.getApplicationContext().getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            int localVersionCode = packageInfo.versionCode;
            return localVersionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setServiceUserId(Context context, String userId) {
        SharedPreferences prefs = context.getSharedPreferences("g_device_id.xml", 0);
        prefs.edit().putString(Common.System.USER_ID, userId).apply();
    }

    public static String getServiceUserId(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences("g_device_id.xml", 0);
        return prefs.getString(Common.System.USER_ID, "");
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }
}
