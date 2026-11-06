package com.byakv.z;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.media.MediaDrm;
import android.net.ConnectivityManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.byazt.mg.hw;
import com.byazt.vkw.qi;
import com.byazt.yi.vk;
import com.byazt.yi.w;
import com.byazt.yi.zo;
import com.byazt.zs.uc;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.an;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SoftDecTool {
    public static final String SP_NAME = "softdec";
    public static volatile String uc;
    public static volatile String x;
    public static volatile boolean f = false;
    public static volatile boolean a = false;
    public static volatile boolean h = false;
    public static volatile double acs = -1.0d;
    public static volatile long act = 0;
    public static SharedPreferences pr = null;
    public static boolean hw = false;
    public static final AtomicBoolean hn = new AtomicBoolean(false);
    public static volatile int c = 0;
    public static long LastReportTooltypeTime = System.currentTimeMillis();
    public static Map<Integer, Integer> codeIdCountMap = new HashMap();

    @HungeonFlag
    public static native Object b(int i, Object[] objArr);

    public static native byte[] bc(int i, byte[] bArr);

    @DungeonFlag
    public static int b() throws Throwable {
        InputStream inputStream;
        ZipFile zipFile;
        InputStream inputStream2;
        String strC = zo.c();
        if (strC.isEmpty()) {
            return 1;
        }
        int i = 11;
        InputStream inputStream3 = null;
        try {
            try {
                zipFile = new ZipFile(strC + "/apk/base-1.apk");
                try {
                    InputStream inputStream4 = zipFile.getInputStream(zipFile.getEntry("classes.dex"));
                    try {
                        String strPr = pr(inputStream4);
                        String str = strPr.substring(strPr.length() / 2) + strPr.substring(0, strPr.length() / 2);
                        ZipEntry entry = zipFile.getEntry("assets/pangle_vp_config.db");
                        if (entry != null) {
                            inputStream3 = zipFile.getInputStream(entry);
                            byte[] bArr = new byte[inputStream3.available()];
                            inputStream3.read(bArr);
                            i = new String(bArr).equals(str) ? 1 : 0;
                        }
                        if (inputStream4 != null) {
                            try {
                                inputStream4.close();
                            } catch (IOException e) {
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e2) {
                            }
                        }
                        zipFile.close();
                    } catch (Exception e3) {
                        InputStream inputStream5 = inputStream3;
                        inputStream3 = inputStream4;
                        inputStream2 = inputStream5;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e5) {
                            }
                        }
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        InputStream inputStream6 = inputStream3;
                        inputStream3 = inputStream4;
                        inputStream = inputStream6;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (zipFile == null) {
                            throw th;
                        }
                        try {
                            zipFile.close();
                            throw th;
                        } catch (IOException e8) {
                            throw th;
                        }
                    }
                } catch (Exception e9) {
                    inputStream2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                }
            } catch (IOException e10) {
            }
        } catch (Exception e11) {
            inputStream2 = null;
            zipFile = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            zipFile = null;
        }
        return i;
    }

    @DungeonFlag
    private static String pr(InputStream inputStream) {
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
            return "";
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("NoSuchAlgorithmException", e3);
        }
    }

    @DungeonFlag
    public static String p() {
        return hw.pr(zo.hn()).getPath();
    }

    @DungeonFlag
    public static int u() {
        UsbAccessory[] accessoryList = ((UsbManager) zo.hn().getSystemService("usb")).getAccessoryList();
        return (accessoryList == null || accessoryList.length == 0) ? 0 : 1;
    }

    @DungeonFlag
    public static void cs(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sofchara", str).putLong(an.aI, System.currentTimeMillis()).apply();
        }
    }

    @DungeonFlag
    public static String gc() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("sofchara", "");
            long j = sharedPreferences.getLong(an.aI, 0L);
            if (j != 0 && !TextUtils.isEmpty(string) && System.currentTimeMillis() - j <= 300000) {
                return string;
            }
        }
        return "";
    }

    @DungeonFlag
    public static String i() {
        int i = c + 1;
        c = i;
        if (i != 2) {
            return "2";
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) zo.hn().getSystemService("accessibility");
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
            return -1;
        }
    }

    @DungeonFlag
    public static long tft() {
        return zo.fw();
    }

    @DungeonFlag
    public static int trc() {
        return zo.zo();
    }

    @DungeonFlag
    public static String dn() {
        try {
            return Settings.Secure.getString(zo.hn().getContentResolver(), "bluetooth_name");
        } catch (Throwable th) {
            return "-1";
        }
    }

    @DungeonFlag
    public static long fi() {
        try {
            return zo.hn().getPackageManager().getPackageInfo(zo.hn().getPackageName(), 0).firstInstallTime / 1000;
        } catch (PackageManager.NameNotFoundException e) {
            return 0L;
        }
    }

    @DungeonFlag
    public static long fr() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            long j = sharedPreferences.getLong("frt", 0L);
            if (j != 0) {
                return j;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            sharedPreferences.edit().putLong("frt", jCurrentTimeMillis).apply();
            return jCurrentTimeMillis;
        }
        return 0L;
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
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) zo.hn().getSystemService("connectivity");
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(15) ? 0 : 1;
            } catch (Throwable th) {
                return -1;
            }
        }
        return -1;
    }

    @DungeonFlag
    public static JSONObject gdh() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            if (sharedPreferences == null || sharedPreferences.getBoolean("reported_devicehardware_2", false) || zo.hn() == null || pr(zo.hn().getPackageManager().getPackageInfo(zo.hn().getPackageName(), 0).firstInstallTime, System.currentTimeMillis())) {
                return null;
            }
            String strPr = zo.pr("gsm.version.baseband", "");
            String strPr2 = zo.pr("ro.build.fingerprint", "");
            String property = System.getProperty("os.version");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("radio", strPr);
            jSONObject.put("fp", strPr2);
            jSONObject.put("kernel", property);
            jSONObject.put("rom_version", zo.pr("ro.build.display.id", ""));
            jSONObject.put("build_id", zo.pr("ro.build.id", ""));
            jSONObject.put("incremental", zo.pr("ro.build.version.incremental", ""));
            jSONObject.put("compiling_time", zo.pr("ro.build.date.utc", ""));
            sharedPreferences.edit().putBoolean("reported_devicehardware_2", true).apply();
            return jSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    @DungeonFlag
    public static void rsd(final String str) {
        ((qi) uc.pr("thread_service")).x().postDelayed(new Runnable() { // from class: com.byakv.z.SoftDecTool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    vk vkVarUc = zo.uc();
                    if (vkVarUc != null) {
                        JSONObject jSONObjectGdh = SoftDecTool.gdh();
                        if (jSONObjectGdh == null && !TextUtils.isEmpty(str)) {
                            jSONObjectGdh = new JSONObject();
                        }
                        if (jSONObjectGdh != null) {
                            if (!TextUtils.isEmpty(str)) {
                                jSONObjectGdh.put("rd2", str);
                            }
                            vkVarUc.pr("device_hardware", jSONObjectGdh);
                        }
                    }
                } catch (Throwable th) {
                }
            }
        }, 20000L);
    }

    private static boolean pr(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && pr(j) == pr(j2);
    }

    private static long pr(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static SharedPreferences getSharedPreferences(String str) {
        if (pr == null) {
            try {
                Context contextHn = zo.hn();
                if (contextHn != null && str != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        Context contextCreateDeviceProtectedStorageContext = contextHn.createDeviceProtectedStorageContext();
                        contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(contextHn, str);
                        contextHn = contextCreateDeviceProtectedStorageContext;
                    }
                    pr = hw.hw(contextHn, str, 0);
                }
                return null;
            } catch (Throwable th) {
            }
        }
        return pr;
    }

    @DungeonFlag
    public static synchronized Object cn(int i, Object[] objArr) {
        if (!w.hw()) {
            return null;
        }
        return b(i, objArr);
    }

    @DungeonFlag
    private static int pr(String str, String str2) {
        String strPr = zo.pr(str2, "unknown");
        return (str.equals("unknown") || strPr.equals("unknown") || str.equals(strPr)) ? 0 : 1;
    }

    @DungeonFlag
    public static String dgb() {
        StringBuilder sb = new StringBuilder();
        sb.append(pr(Build.BOARD, "ro.product.board"));
        sb.append(pr(Build.MODEL, "ro.product.model"));
        sb.append(pr(Build.VERSION.RELEASE, "ro.build.version.release"));
        sb.append(pr(Build.MANUFACTURER, "ro.product.manufacturer"));
        sb.append(pr(Build.DISPLAY, "ro.build.display.id"));
        long j = Build.TIME;
        long j2 = Long.parseLong(zo.pr("ro.build.date.utc", "-1"));
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

    public static JSONObject t() {
        try {
            if (System.currentTimeMillis() - LastReportTooltypeTime > 3000 && !codeIdCountMap.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<Integer, Integer> entry : codeIdCountMap.entrySet()) {
                    jSONObject2.put(String.valueOf(entry.getKey()), entry.getValue());
                }
                jSONObject.put("ctt", jSONObject2);
                LastReportTooltypeTime = System.currentTimeMillis();
                codeIdCountMap.clear();
                return jSONObject;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    @DungeonFlag
    public static String getwvid() {
        if (x != null) {
            return x;
        }
        if (hn.compareAndSet(false, true)) {
            ((qi) uc.pr("thread_service")).hw().execute(new Runnable() { // from class: com.byakv.z.SoftDecTool.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MediaDrm mediaDrm = new MediaDrm(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));
                        byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                        mediaDrm.release();
                        if (propertyByteArray != null && propertyByteArray.length > 0) {
                            String unused = SoftDecTool.x = SoftDecTool.x(SoftDecTool.hw(propertyByteArray));
                        }
                    } catch (Throwable th) {
                        SoftDecTool.hn.set(false);
                    }
                }
            });
            return null;
        }
        return null;
    }

    public static String getss() {
        boolean z;
        SensorManager sensorManager;
        List<Sensor> sensorList;
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        String string = sharedPreferences.getString("sensor_fingerprint", null);
        int i = 0;
        if (string != null && !string.isEmpty()) {
            z = true;
        } else {
            string = null;
            z = false;
        }
        boolean zPr = pr(System.currentTimeMillis(), sharedPreferences.getLong("last_sensor_hash_time", 0L));
        if (!zPr) {
            hw = false;
        }
        if (hw || (z && zPr)) {
            return string;
        }
        hw = true;
        try {
            vk vkVarUc = zo.uc();
            JSONObject jSONObject = new JSONObject();
            if (vkVarUc != null && (sensorManager = (SensorManager) zo.hn().getSystemService(an.ac)) != null && (sensorList = sensorManager.getSensorList(-1)) != null && !sensorList.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = new JSONArray();
                for (Sensor sensor : sensorList) {
                    if (sensor != null) {
                        i++;
                        if (i > 100) {
                            break;
                        }
                        arrayList.add(hn(sensor.getName() + "|" + sensor.getVendor() + "|" + sensor.getVersion()));
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(Common.System.NAME, sensor.getName());
                        jSONObject2.put("vendor", sensor.getVendor());
                        jSONObject2.put("version", sensor.getVersion());
                        jSONArray.put(jSONObject2);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                Collections.sort(arrayList);
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append((String) it.next()).append("|");
                }
                String strX = x(sb.toString());
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("sensor_fingerprint", strX).putLong("last_sensor_hash_time", System.currentTimeMillis()).apply();
                }
                jSONObject.put("sensors", jSONArray);
                jSONObject.put("sensor_fingerprint", strX);
                vkVarUc.pr("device_hardware_sensor", jSONObject);
            }
        } catch (Throwable th) {
        }
        return string;
    }

    public static String getBId() {
        if (uc != null) {
            return uc;
        }
        synchronized (SoftDecTool.class) {
            if (uc == null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
                    try {
                        uc = bufferedReader.readLine();
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return uc;
    }

    private static String hn(String str) throws Exception {
        return hw(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String x(String str) throws Exception {
        return hw(Arrays.copyOf(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)), 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hw(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
