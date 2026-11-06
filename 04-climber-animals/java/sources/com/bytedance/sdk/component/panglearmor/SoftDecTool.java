package com.bytedance.sdk.component.panglearmor;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.bytedance.sdk.component.utils.sl;
import com.umeng.analytics.pro.bv;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SoftDecTool {
    public static final String SP_NAME = "softdec";
    public static volatile boolean a = false;
    public static volatile double acs = -1.0d;
    public static volatile long act = 0;
    public static volatile boolean f = false;
    public static volatile boolean h = false;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static SharedPreferences f1299ms;
    private static volatile int xr;

    @HungeonFlag
    public static native Object b(int i, Object[] objArr);

    public static native byte[] bc(int i, byte[] bArr);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    @DungeonFlag
    public static int b() throws Throwable {
        InputStream inputStream;
        ZipFile zipFile;
        InputStream inputStream2;
        boolean zEquals;
        String strC = c.c();
        if (strC.isEmpty()) {
            return 1;
        }
        ?? r1 = 11;
        r1 = 11;
        r1 = 11;
        InputStream inputStream3 = null;
        try {
            zipFile = new ZipFile(strC + "/apk/base-1.apk");
            try {
                InputStream inputStream4 = zipFile.getInputStream(zipFile.getEntry("classes.dex"));
                try {
                    String strMs = ms(inputStream4);
                    String str = strMs.substring(strMs.length() / 2) + strMs.substring(0, strMs.length() / 2);
                    ZipEntry entry = zipFile.getEntry("assets/pangle_vp_config.db");
                    if (entry != null) {
                        inputStream3 = zipFile.getInputStream(entry);
                        byte[] bArr = new byte[inputStream3.available()];
                        inputStream3.read(bArr);
                        zEquals = new String(bArr).equals(str);
                    }
                    if (inputStream4 != null) {
                        try {
                            r1 = zEquals;
                            inputStream4.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Exception unused3) {
                    InputStream inputStream5 = inputStream3;
                    inputStream3 = inputStream4;
                    inputStream2 = inputStream5;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (zipFile != null) {
                    }
                    return r1;
                } catch (Throwable th) {
                    th = th;
                    InputStream inputStream6 = inputStream3;
                    inputStream3 = inputStream4;
                    inputStream = inputStream6;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            throw th;
                        } catch (IOException unused8) {
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception unused9) {
                inputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Exception unused10) {
            inputStream2 = null;
            zipFile = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            zipFile = null;
        }
        try {
            zipFile.close();
        } catch (IOException unused11) {
        }
        return r1;
    }

    @DungeonFlag
    private static String ms(InputStream inputStream) {
        int i;
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b : bArrDigest) {
                int i3 = b & UByte.MAX_VALUE;
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        } catch (IOException e2) {
            sl.ms(e2);
            return "";
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("NoSuchAlgorithmException", e3);
        }
    }

    @DungeonFlag
    public static String p() {
        return com.bytedance.sdk.openadsdk.api.plugin.xr.ms(c.d()).getPath();
    }

    @DungeonFlag
    public static int u() {
        UsbAccessory[] accessoryList = ((UsbManager) c.d().getSystemService("usb")).getAccessoryList();
        return (accessoryList == null || accessoryList.length == 0) ? 0 : 1;
    }

    @DungeonFlag
    public static void cs(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sofchara", str).putLong(bv.aI, System.currentTimeMillis()).apply();
        }
    }

    @DungeonFlag
    public static String gc() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("sofchara", "");
            long j = sharedPreferences.getLong(bv.aI, 0L);
            if (j != 0 && !TextUtils.isEmpty(string) && System.currentTimeMillis() - j <= 300000) {
                return string;
            }
        }
        return "";
    }

    @DungeonFlag
    public static String i() {
        int i = xr + 1;
        xr = i;
        if (i != 2) {
            return "2";
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) c.d().getSystemService("accessibility");
            TreeSet treeSet = new TreeSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : accessibilityManager.getInstalledAccessibilityServiceList()) {
                treeSet.add(String.format("%s#%s", accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName, accessibilityServiceInfo.getResolveInfo().serviceInfo.name));
            }
            JSONArray jSONArray = new JSONArray((Collection) treeSet);
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            String string = jSONArray.toString();
            String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String string2 = sharedPreferences.getString("iacba", "");
            String string3 = sharedPreferences.getString("date", "1970-01-01");
            if (string2.equals(jSONArray.toString()) && str.equals(string3)) {
                return "2";
            }
            sharedPreferences.edit().putString("iacba", string).apply();
            sharedPreferences.edit().putString("date", str).apply();
            return string;
        } catch (Throwable th) {
            sl.ms(th);
            return "-1";
        }
    }

    @DungeonFlag
    public static synchronized int h(String str, boolean z) {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            int i = sharedPreferences.getInt(str, 0);
            if (!z) {
                return i;
            }
            int i2 = i + 1;
            sharedPreferences.edit().putInt(str, i2).apply();
            return i2;
        } catch (Throwable th) {
            sl.ms(th);
            return -1;
        }
    }

    @DungeonFlag
    public static long tft() {
        return c.x();
    }

    @DungeonFlag
    public static int trc() {
        return c.ny();
    }

    @DungeonFlag
    public static String dn() {
        try {
            return Settings.Secure.getString(c.d().getContentResolver(), "bluetooth_name");
        } catch (Throwable unused) {
            return "-1";
        }
    }

    @DungeonFlag
    public static long fi() {
        try {
            return c.d().getPackageManager().getPackageInfo(c.d().getPackageName(), 0).firstInstallTime / 1000;
        } catch (PackageManager.NameNotFoundException e) {
            sl.ms(e);
            return 0L;
        }
    }

    @DungeonFlag
    public static long fr() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences == null) {
            return 0L;
        }
        long j = sharedPreferences.getLong("frt", 0L);
        if (j != 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        sharedPreferences.edit().putLong("frt", jCurrentTimeMillis).apply();
        return jCurrentTimeMillis;
    }

    @DungeonFlag
    public static String kv() {
        return System.getProperty("os.version");
    }

    @DungeonFlag
    public static String prx() {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        return (TextUtils.isEmpty(property) && TextUtils.isEmpty(property2)) ? "" : String.format("%s:%s", property, property2);
    }

    @DungeonFlag
    public static int hv() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) c.d().getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(15) ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @DungeonFlag
    public static JSONObject gdh() {
        List<Sensor> sensorList;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            if (sharedPreferences == null || sharedPreferences.getBoolean("reported_devicehardware_2", false) || c.d() == null || ms(c.d().getPackageManager().getPackageInfo(c.d().getPackageName(), 0).firstInstallTime, System.currentTimeMillis())) {
                return null;
            }
            TreeSet treeSet = new TreeSet();
            SensorManager sensorManager = (SensorManager) c.d().getSystemService("sensor");
            if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null) {
                for (Sensor sensor : sensorList) {
                    if (sensor != null) {
                        treeSet.add(String.format(Locale.getDefault(), "%s###%s###%d", sensor.getName(), sensor.getVendor(), Integer.valueOf(sensor.getType())));
                    }
                }
            }
            String strMs = c.ms("gsm.version.baseband", "");
            String strMs2 = c.ms("ro.build.fingerprint", "");
            String property = System.getProperty("os.version");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sensors", treeSet);
            jSONObject.put("radio", strMs);
            jSONObject.put("fp", strMs2);
            jSONObject.put("kernel", property);
            jSONObject.put("rom_version", c.ms("ro.build.display.id", ""));
            jSONObject.put("build_id", c.ms("ro.build.id", ""));
            jSONObject.put("incremental", c.ms("ro.build.version.incremental", ""));
            jSONObject.put("compiling_time", c.ms("ro.build.date.utc", ""));
            sharedPreferences.edit().putBoolean("reported_devicehardware_2", true).apply();
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @DungeonFlag
    public static void rsd(final String str) {
        com.bytedance.sdk.component.utils.x.ms().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.SoftDecTool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    x xVarAb = c.ab();
                    if (xVarAb != null) {
                        JSONObject jSONObjectGdh = SoftDecTool.gdh();
                        if (jSONObjectGdh == null && !TextUtils.isEmpty(str)) {
                            jSONObjectGdh = new JSONObject();
                        }
                        if (jSONObjectGdh != null) {
                            if (!TextUtils.isEmpty(str)) {
                                jSONObjectGdh.put("rd2", str);
                            }
                            xVarAb.ms("device_hardware", jSONObjectGdh);
                        }
                    }
                } catch (Throwable th) {
                    sl.ms(th);
                }
            }
        }, 20000L);
    }

    private static boolean ms(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && ms(j) == ms(j2);
    }

    private static long ms(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static SharedPreferences getSharedPreferences(String str) {
        if (f1299ms == null) {
            try {
                Context contextD = c.d();
                if (contextD != null && str != null) {
                    Context contextCreateDeviceProtectedStorageContext = contextD.createDeviceProtectedStorageContext();
                    if (!contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(contextD, str)) {
                        sl.xr("HARLOG", "Failed to move shared preferences.");
                    }
                    f1299ms = com.bytedance.sdk.openadsdk.api.plugin.xr.xr(contextCreateDeviceProtectedStorageContext, str, 0);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return f1299ms;
    }

    @DungeonFlag
    public static synchronized Object cn(int i, Object[] objArr) {
        if (!ny.xr()) {
            return null;
        }
        return b(i, objArr);
    }

    @DungeonFlag
    private static int ms(String str, String str2) {
        String strMs = c.ms(str2, "unknown");
        return (str.equals("unknown") || strMs.equals("unknown") || str.equals(strMs)) ? 0 : 1;
    }

    @DungeonFlag
    public static String dgb() {
        StringBuilder sb = new StringBuilder();
        sb.append(ms(Build.BOARD, "ro.product.board"));
        sb.append(ms(Build.MODEL, "ro.product.model"));
        sb.append(ms(Build.VERSION.RELEASE, "ro.build.version.release"));
        sb.append(ms(Build.MANUFACTURER, "ro.product.manufacturer"));
        sb.append(ms(Build.DISPLAY, "ro.build.display.id"));
        long j = Build.TIME;
        long j2 = Long.parseLong(c.ms("ro.build.date.utc", "-1"));
        if (j == -1000 || j2 == -1) {
            sb.append("00");
        } else {
            if (String.valueOf(j).length() >= 10) {
                sb.append(Long.parseLong(String.valueOf(j).substring(0, 10)) == j2 ? 0 : 1);
            } else {
                sb.append(1);
            }
            sb.append(j != j2 * 1000 ? 1 : 0);
        }
        return sb.toString();
    }

    public static void ua() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            acs = sharedPreferences.getFloat("acs", -1.0f);
            act = sharedPreferences.getLong("act", 0L);
        }
    }

    public static void ua(double d, long j) {
        acs = d;
        act = j;
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putFloat("acs", (float) d).putLong("act", j).apply();
        }
    }
}
