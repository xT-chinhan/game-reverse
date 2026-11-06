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
import com.anythink.core.common.u.n;
import com.byazt.qp.q;
import com.byazt.qyu.qg;
import com.byazt.tka.d;
import com.byazt.tka.tj;
import com.byazt.vf.wo;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.component.sdk.annotation.HungeonFlag;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
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
    public static volatile boolean a = false;
    public static volatile double acs = -1.0d;
    public static volatile long act = 0;
    public static volatile boolean f = false;
    public static volatile boolean h = false;
    public static SharedPreferences n = null;
    public static volatile String q = null;
    public static boolean qg = false;
    public static volatile String w;
    public static final AtomicBoolean s = new AtomicBoolean(false);
    public static volatile int l = 0;
    public static long LastReportTooltypeTime = System.currentTimeMillis();
    public static Map<Integer, Integer> codeIdCountMap = new HashMap();

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
        String strQ = tj.q();
        if (strQ.isEmpty()) {
            return 1;
        }
        ?? r1 = 11;
        r1 = 11;
        r1 = 11;
        InputStream inputStream3 = null;
        try {
            zipFile = new ZipFile(strQ + "/apk/base-1.apk");
            try {
                InputStream inputStream4 = zipFile.getInputStream(zipFile.getEntry("classes.dex"));
                try {
                    String strN = n(inputStream4);
                    String str = strN.substring(strN.length() / 2) + strN.substring(0, strN.length() / 2);
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
    private static String n(InputStream inputStream) {
        int i;
        try {
            byte[] bArr = new byte[8192];
            MessageDigest messageDigest = MessageDigest.getInstance(n.a);
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
        } catch (IOException unused) {
            return "";
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("NoSuchAlgorithmException", e2);
        }
    }

    @DungeonFlag
    public static String p() {
        return qg.n(tj.s()).getPath();
    }

    @DungeonFlag
    public static int u() {
        UsbAccessory[] accessoryList = ((UsbManager) tj.s().getSystemService("usb")).getAccessoryList();
        return (accessoryList == null || accessoryList.length == 0) ? 0 : 1;
    }

    @DungeonFlag
    public static void cs(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("sofchara", str).putLong("t", System.currentTimeMillis()).apply();
        }
    }

    @DungeonFlag
    public static String gc() {
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString("sofchara", "");
            long j = sharedPreferences.getLong("t", 0L);
            if (j != 0 && !TextUtils.isEmpty(string) && System.currentTimeMillis() - j <= 300000) {
                return string;
            }
        }
        return "";
    }

    @DungeonFlag
    public static String i() {
        int i = l + 1;
        l = i;
        if (i != 2) {
            return "2";
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) tj.s().getSystemService("accessibility");
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
        } catch (Throwable unused) {
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
        } catch (Throwable unused) {
            return -1;
        }
    }

    @DungeonFlag
    public static long tft() {
        return tj.l();
    }

    @DungeonFlag
    public static int trc() {
        return tj.w();
    }

    @DungeonFlag
    public static String dn() {
        try {
            return Settings.Secure.getString(tj.s().getContentResolver(), "bluetooth_name");
        } catch (Throwable unused) {
            return "-1";
        }
    }

    @DungeonFlag
    public static long fi() {
        try {
            return tj.s().getPackageManager().getPackageInfo(tj.s().getPackageName(), 0).firstInstallTime / 1000;
        } catch (PackageManager.NameNotFoundException unused) {
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
            ConnectivityManager connectivityManager = (ConnectivityManager) tj.s().getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasCapability(15) ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @DungeonFlag
    public static JSONObject gdh() {
        try {
            SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
            if (sharedPreferences == null || sharedPreferences.getBoolean("reported_devicehardware_2", false) || tj.s() == null || n(tj.s().getPackageManager().getPackageInfo(tj.s().getPackageName(), 0).firstInstallTime, System.currentTimeMillis())) {
                return null;
            }
            String strN = tj.n("gsm.version.baseband", "");
            String strN2 = tj.n("ro.build.fingerprint", "");
            String property = System.getProperty("os.version");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("radio", strN);
            jSONObject.put("fp", strN2);
            jSONObject.put("kernel", property);
            jSONObject.put("rom_version", tj.n("ro.build.display.id", ""));
            jSONObject.put("build_id", tj.n("ro.build.id", ""));
            jSONObject.put("incremental", tj.n("ro.build.version.incremental", ""));
            jSONObject.put("compiling_time", tj.n("ro.build.date.utc", ""));
            sharedPreferences.edit().putBoolean("reported_devicehardware_2", true).apply();
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @DungeonFlag
    public static void rsd(final String str) {
        ((wo) q.n("thread_service")).q().postDelayed(new Runnable() { // from class: com.byakv.z.SoftDecTool.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectGdh = SoftDecTool.gdh();
                    if (jSONObjectGdh == null && !TextUtils.isEmpty(str)) {
                        jSONObjectGdh = new JSONObject();
                    }
                    if (jSONObjectGdh != null) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONObjectGdh.put("rd2", str);
                        }
                        d.n("device_hardware", jSONObjectGdh);
                    }
                } catch (Throwable unused) {
                }
            }
        }, 20000L);
    }

    private static boolean n(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && n(j) == n(j2);
    }

    private static long n(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static SharedPreferences getSharedPreferences(String str) {
        if (n == null) {
            try {
                Context contextS = tj.s();
                if (contextS != null && str != null) {
                    Context contextCreateDeviceProtectedStorageContext = contextS.createDeviceProtectedStorageContext();
                    contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(contextS, str);
                    n = qg.qg(contextCreateDeviceProtectedStorageContext, str, 0);
                }
                return null;
            } catch (Throwable unused) {
            }
        }
        return n;
    }

    @DungeonFlag
    public static synchronized Object cn(int i, Object[] objArr) {
        if (!d.qg()) {
            return null;
        }
        return b(i, objArr);
    }

    @DungeonFlag
    private static int n(String str, String str2) {
        String strN = tj.n(str2, "unknown");
        return (str.equals("unknown") || strN.equals("unknown") || str.equals(strN)) ? 0 : 1;
    }

    @DungeonFlag
    public static String dgb() {
        StringBuilder sb = new StringBuilder();
        sb.append(n(Build.BOARD, "ro.product.board"));
        sb.append(n(Build.MODEL, "ro.product.model"));
        sb.append(n(Build.VERSION.RELEASE, "ro.build.version.release"));
        sb.append(n(Build.MANUFACTURER, "ro.product.manufacturer"));
        sb.append(n(Build.DISPLAY, "ro.build.display.id"));
        long j = Build.TIME;
        long j2 = Long.parseLong(tj.n("ro.build.date.utc", "-1"));
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
            if (System.currentTimeMillis() - LastReportTooltypeTime <= 3000 || codeIdCountMap.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry<Integer, Integer> entry : codeIdCountMap.entrySet()) {
                jSONObject2.put(String.valueOf(entry.getKey()), entry.getValue());
            }
            jSONObject.put("ctt", jSONObject2);
            LastReportTooltypeTime = System.currentTimeMillis();
            codeIdCountMap.clear();
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    @DungeonFlag
    public static String getwvid() {
        if (q != null) {
            return q;
        }
        if (!s.compareAndSet(false, true)) {
            return null;
        }
        ((wo) q.n("thread_service")).qg().execute(new Runnable() { // from class: com.byakv.z.SoftDecTool.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MediaDrm mediaDrm = new MediaDrm(UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"));
                    byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                    mediaDrm.release();
                    if (propertyByteArray == null || propertyByteArray.length <= 0) {
                        return;
                    }
                    String unused = SoftDecTool.q = SoftDecTool.q(SoftDecTool.qg(propertyByteArray));
                } catch (Throwable unused2) {
                    SoftDecTool.s.set(false);
                }
            }
        });
        return null;
    }

    public static String getss() {
        boolean z;
        List<Sensor> sensorList;
        SharedPreferences sharedPreferences = getSharedPreferences(SP_NAME);
        String string = sharedPreferences.getString("sensor_fingerprint", null);
        int i = 0;
        if (string == null || string.isEmpty()) {
            string = null;
            z = false;
        } else {
            z = true;
        }
        boolean zN = n(System.currentTimeMillis(), sharedPreferences.getLong("last_sensor_hash_time", 0L));
        if (!zN) {
            qg = false;
        }
        if (!qg && (!z || !zN)) {
            qg = true;
            try {
                JSONObject jSONObject = new JSONObject();
                SensorManager sensorManager = (SensorManager) tj.s().getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && !sensorList.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray = new JSONArray();
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            i++;
                            if (i > 100) {
                                break;
                            }
                            arrayList.add(s(sensor.getName() + "|" + sensor.getVendor() + "|" + sensor.getVersion()));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(TapEventParamConstants.PARAM_NAME, sensor.getName());
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
                    String strQ = q(sb.toString());
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putString("sensor_fingerprint", strQ).putLong("last_sensor_hash_time", System.currentTimeMillis()).apply();
                    }
                    jSONObject.put("sensors", jSONArray);
                    jSONObject.put("sensor_fingerprint", strQ);
                    d.n("device_hardware_sensor", jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        return string;
    }

    public static String getBId() {
        if (w != null) {
            return w;
        }
        synchronized (SoftDecTool.class) {
            if (w == null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
                    try {
                        w = bufferedReader.readLine();
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
                } catch (Exception unused) {
                    return null;
                }
            }
        }
        return w;
    }

    private static String s(String str) throws Exception {
        return qg(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String q(String str) throws Exception {
        return qg(Arrays.copyOf(MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8)), 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
