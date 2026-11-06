package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.taptap.sdk.kit.internal.p000const.TrackAction;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static String a;
    private static String b;

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (x.a(th)) {
                return TrackAction.FAIL;
            }
            th.printStackTrace();
            return TrackAction.FAIL;
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (x.a(th)) {
                return TrackAction.FAIL;
            }
            th.printStackTrace();
            return TrackAction.FAIL;
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!AppInfo.a(context, "android.permission.READ_PHONE_STATE")) {
            x.d("no READ_PHONE_STATE permission to get IMEI", new Object[0]);
            return null;
        }
        try {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            return deviceId != null ? deviceId.toLowerCase() : deviceId;
        } catch (Throwable unused) {
            x.a("Failed to get IMEI.", new Object[0]);
            return null;
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        if (!AppInfo.a(context, "android.permission.READ_PHONE_STATE")) {
            x.d("no READ_PHONE_STATE permission to get IMSI", new Object[0]);
            return null;
        }
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            return subscriberId != null ? subscriberId.toLowerCase() : subscriberId;
        } catch (Throwable unused) {
            x.a("Failed to get IMSI.", new Object[0]);
            return null;
        }
    }

    public static String c(Context context) {
        String string = TrackAction.FAIL;
        if (context == null) {
            return TrackAction.FAIL;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return string == null ? AbstractJsonLexerKt.NULL : string.toLowerCase();
        } catch (Throwable th) {
            if (!x.a(th)) {
                x.a("Failed to get Android ID.", new Object[0]);
            }
            return string;
        }
    }

    public static String d(Context context) {
        WifiInfo connectionInfo;
        String lowerCase = TrackAction.FAIL;
        if (context == null) {
            return TrackAction.FAIL;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String macAddress = connectionInfo.getMacAddress();
                if (macAddress == null) {
                    return AbstractJsonLexerKt.NULL;
                }
                lowerCase = macAddress.toLowerCase();
            }
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
        }
        return lowerCase;
    }

    private static boolean o() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static String p() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String str;
        try {
            fileReader = new FileReader("/system/build.prop");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            str = null;
                            break;
                        }
                        String[] strArrSplit = line.split("=", 2);
                        if (strArrSplit.length == 2) {
                            if (strArrSplit[0].equals("ro.product.cpu.abilist")) {
                                str = strArrSplit[1];
                                break;
                            }
                            if (strArrSplit[0].equals("ro.product.cpu.abi")) {
                                str = strArrSplit[1];
                                break;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            if (!x.a(th)) {
                                th.printStackTrace();
                            }
                            return null;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                    if (!x.a(e)) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e2) {
                                    if (!x.a(e2)) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
                if (str != null) {
                    str = str.split(",")[0];
                }
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    if (!x.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e4) {
                    if (!x.a(e4)) {
                        e4.printStackTrace();
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
        }
    }

    public static String a(boolean z) {
        String strP;
        if (z) {
            try {
                strP = p();
            } catch (Throwable th) {
                if (x.a(th)) {
                    return TrackAction.FAIL;
                }
                th.printStackTrace();
                return TrackAction.FAIL;
            }
        } else {
            strP = null;
        }
        if (strP == null) {
            strP = System.getProperty("os.arch");
        }
        return strP;
    }

    public static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long f() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        long j = Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            if (!x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            if (!x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return j;
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        if (!x.a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                        return -1L;
                    } catch (IOException e4) {
                        if (x.a(e4)) {
                            return -1L;
                        }
                        e4.printStackTrace();
                        return -1L;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            return -2L;
                        } catch (IOException e5) {
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                if (!x.a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e7) {
                                if (!x.a(e7)) {
                                    e7.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            fileReader = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public static long g() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e) {
                            if (!x.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e2) {
                            if (!x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j = (Long.parseLong(line.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
                    String line2 = bufferedReader2.readLine();
                    if (line2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e3) {
                            if (!x.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            if (!x.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j2 = j + (Long.parseLong(line2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    String line3 = bufferedReader2.readLine();
                    if (line3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            if (!x.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e6) {
                            if (!x.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long j3 = j2 + (Long.parseLong(line3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e7) {
                        if (!x.a(e7)) {
                            e7.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e8) {
                        if (!x.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    return j3;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (fileReader == null) {
                            return -2L;
                        }
                        try {
                            return -2L;
                        } catch (IOException e9) {
                        }
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                if (!x.a(e10)) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e11) {
                                if (!x.a(e11)) {
                                    e11.printStackTrace();
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
    }

    public static long h() {
        if (!o()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (x.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static long i() {
        if (!o()) {
            return 0L;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (x.a(th)) {
                return -2L;
            }
            th.printStackTrace();
            return -2L;
        }
    }

    public static String j() {
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return TrackAction.FAIL;
        }
    }

    public static String k() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return TrackAction.FAIL;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0080  */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    public static String e(Context context) {
        TelephonyManager telephonyManager;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0 || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
                return "unknown";
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                    return "GPRS";
                case 2:
                    return "EDGE";
                case 3:
                    return "UMTS";
                case 4:
                    return "CDMA";
                case 5:
                    return "EVDO_0";
                case 6:
                    return "EVDO_A";
                case 7:
                    return "1xRTT";
                case 8:
                    return "HSDPA";
                case 9:
                    return "HSUPA";
                case 10:
                    return "HSPA";
                case 11:
                    return "iDen";
                case 12:
                    return "EVDO_B";
                case 13:
                    return "LTE";
                case 14:
                    return "eHRPD";
                case 15:
                    return "HSPA+";
                default:
                    return "MOBILE(" + networkType + ")";
            }
            if (!x.a(e)) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        } catch (Exception e) {
            if (!x.a(e)) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        }
    }

    public static String f(Context context) {
        String strA = z.a(context, "ro.miui.ui.version.name");
        if (!z.a(strA) && !strA.equals(TrackAction.FAIL)) {
            return "XiaoMi/MIUI/" + strA;
        }
        String strA2 = z.a(context, "ro.build.version.emui");
        if (!z.a(strA2) && !strA2.equals(TrackAction.FAIL)) {
            return "HuaWei/EMOTION/" + strA2;
        }
        String strA3 = z.a(context, "ro.lenovo.series");
        if (!z.a(strA3) && !strA3.equals(TrackAction.FAIL)) {
            return "Lenovo/VIBE/" + z.a(context, "ro.build.version.incremental");
        }
        String strA4 = z.a(context, "ro.build.nubia.rom.name");
        if (!z.a(strA4) && !strA4.equals(TrackAction.FAIL)) {
            return "Zte/NUBIA/" + strA4 + "_" + z.a(context, "ro.build.nubia.rom.code");
        }
        String strA5 = z.a(context, "ro.meizu.product.model");
        if (!z.a(strA5) && !strA5.equals(TrackAction.FAIL)) {
            return "Meizu/FLYME/" + z.a(context, "ro.build.display.id");
        }
        String strA6 = z.a(context, "ro.build.version.opporom");
        if (!z.a(strA6) && !strA6.equals(TrackAction.FAIL)) {
            return "Oppo/COLOROS/" + strA6;
        }
        String strA7 = z.a(context, "ro.vivo.os.build.display.id");
        if (!z.a(strA7) && !strA7.equals(TrackAction.FAIL)) {
            return "vivo/FUNTOUCH/" + strA7;
        }
        String strA8 = z.a(context, "ro.aa.romver");
        if (!z.a(strA8) && !strA8.equals(TrackAction.FAIL)) {
            return "htc/" + strA8 + "/" + z.a(context, "ro.build.description");
        }
        String strA9 = z.a(context, "ro.lewa.version");
        if (!z.a(strA9) && !strA9.equals(TrackAction.FAIL)) {
            return "tcl/" + strA9 + "/" + z.a(context, "ro.build.display.id");
        }
        String strA10 = z.a(context, "ro.gn.gnromvernumber");
        if (!z.a(strA10) && !strA10.equals(TrackAction.FAIL)) {
            return "amigo/" + strA10 + "/" + z.a(context, "ro.build.display.id");
        }
        String strA11 = z.a(context, "ro.build.tyd.kbstyle_version");
        if (!z.a(strA11) && !strA11.equals(TrackAction.FAIL)) {
            return "dido/" + strA11;
        }
        return z.a(context, "ro.build.fingerprint") + "/" + z.a(context, "ro.build.rom.id");
    }

    public static String g(Context context) {
        return z.a(context, "ro.board.platform");
    }

    public static boolean h(Context context) {
        boolean zExists;
        try {
            zExists = new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            zExists = false;
        }
        ArrayList<String> arrayListA = z.a(context, new String[]{"/system/bin/sh", "-c", "type su"});
        Boolean bool = null;
        if (arrayListA != null && arrayListA.size() > 0) {
            for (String str : arrayListA) {
                x.c(str, new Object[0]);
                if (str.contains("not found")) {
                    bool = false;
                }
            }
            if (bool == null) {
                bool = true;
            }
        }
        return (Build.TAGS != null && Build.TAGS.contains("test-keys")) || zExists || Boolean.valueOf(bool == null ? false : bool.booleanValue()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0067 A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #5 {all -> 0x008e, blocks: (B:6:0x0023, B:8:0x0029, B:9:0x002c, B:11:0x0031, B:13:0x003f, B:20:0x0059, B:22:0x0067, B:28:0x007e), top: B:53:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0077 A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #3 {all -> 0x007c, blocks: (B:23:0x0071, B:25:0x0077), top: B:49:0x0071 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String l() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String line;
        try {
            StringBuilder sb = new StringBuilder();
            if (new File("/sys/block/mmcblk0/device/type").exists()) {
                bufferedReader = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/type"));
                try {
                    String line2 = bufferedReader.readLine();
                    if (line2 != null) {
                        sb.append(line2);
                    }
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
            } else {
                bufferedReader = null;
            }
            sb.append(",");
            if (new File("/sys/block/mmcblk0/device/name").exists()) {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/name"));
                try {
                    String line3 = bufferedReader3.readLine();
                    if (line3 != null) {
                        sb.append(line3);
                    }
                    bufferedReader3.close();
                    bufferedReader = bufferedReader3;
                    sb.append(",");
                    if (new File("/sys/block/mmcblk0/device/cid").exists()) {
                        bufferedReader2 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/cid"));
                        try {
                            line = bufferedReader2.readLine();
                            if (line != null) {
                                sb.append(line);
                            }
                            bufferedReader = bufferedReader2;
                        } catch (Throwable unused2) {
                            bufferedReader = bufferedReader2;
                        }
                    }
                    String string = sb.toString();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            x.a(e);
                        }
                    }
                    return string;
                } catch (Throwable unused3) {
                    bufferedReader = bufferedReader3;
                }
            } else {
                sb.append(",");
                if (new File("/sys/block/mmcblk0/device/cid").exists()) {
                    bufferedReader2 = new BufferedReader(new FileReader("/sys/block/mmcblk0/device/cid"));
                    line = bufferedReader2.readLine();
                    if (line != null) {
                        sb.append(line);
                    }
                    bufferedReader = bufferedReader2;
                }
                String string2 = sb.toString();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return string2;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                x.a(e2);
            }
        }
        return null;
    }

    public static String i(Context context) {
        StringBuilder sb = new StringBuilder();
        String strA = z.a(context, "ro.genymotion.version");
        if (strA != null) {
            sb.append("ro.genymotion.version|");
            sb.append(strA);
            sb.append("\n");
        }
        String strA2 = z.a(context, "androVM.vbox_dpi");
        if (strA2 != null) {
            sb.append("androVM.vbox_dpi|");
            sb.append(strA2);
            sb.append("\n");
        }
        String strA3 = z.a(context, "qemu.sf.fake_camera");
        if (strA3 != null) {
            sb.append("qemu.sf.fake_camera|");
            sb.append(strA3);
        }
        return sb.toString();
    }

    public static String j(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        StringBuilder sb = new StringBuilder();
        if (a == null) {
            a = z.a(context, "ro.secure");
        }
        if (a != null) {
            sb.append("ro.secure|");
            sb.append(a);
            sb.append("\n");
        }
        if (b == null) {
            b = z.a(context, "ro.debuggable");
        }
        if (b != null) {
            sb.append("ro.debuggable|");
            sb.append(b);
            sb.append("\n");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x.a(th);
                        return sb.toString();
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                x.a(e);
                            }
                        }
                    }
                }
            } while (!line.startsWith("TracerPid:"));
            if (line != null) {
                String strTrim = line.substring(10).trim();
                sb.append("tracer_pid");
                sb.append("|");
                sb.append(strTrim);
            }
            String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                x.a(e2);
            }
            return string;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004c A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #1 {all -> 0x00a4, blocks: (B:3:0x000e, B:6:0x001b, B:13:0x003e, B:15:0x004c, B:22:0x006e, B:24:0x007c), top: B:42:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:18:0x005c A[Catch: all -> 0x006c, TryCatch #4 {all -> 0x006c, blocks: (B:16:0x0056, B:18:0x005c, B:19:0x0067), top: B:49:0x0056 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x006e A[Catch: all -> 0x00a4, PHI: r5
      0x006e: PHI (r5v4 java.io.BufferedReader) = (r5v3 java.io.BufferedReader), (r5v9 java.io.BufferedReader) binds: [B:14:0x004a, B:20:0x006a] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {all -> 0x00a4, blocks: (B:3:0x000e, B:6:0x001b, B:13:0x003e, B:15:0x004c, B:22:0x006e, B:24:0x007c), top: B:42:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:24:0x007c A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #1 {all -> 0x00a4, blocks: (B:3:0x000e, B:6:0x001b, B:13:0x003e, B:15:0x004c, B:22:0x006e, B:24:0x007c), top: B:42:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:27:0x008c A[Catch: all -> 0x009c, TryCatch #3 {all -> 0x009c, blocks: (B:25:0x0086, B:27:0x008c, B:28:0x0097), top: B:47:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a0 A[Catch: IOException -> 0x00aa, TRY_ENTER, TryCatch #0 {IOException -> 0x00aa, blocks: (B:32:0x00a0, B:34:0x00a6), top: B:42:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00a6 A[Catch: IOException -> 0x00aa, TRY_LEAVE, TryCatch #0 {IOException -> 0x00aa, blocks: (B:32:0x00a0, B:34:0x00a6), top: B:42:0x000e }] */
    public static String m() {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2;
        String line2;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader3 = null;
        try {
            try {
                if (new File("/sys/class/power_supply/ac/online").exists()) {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader("/sys/class/power_supply/ac/online"));
                    try {
                        String line3 = bufferedReader4.readLine();
                        if (line3 != null) {
                            sb.append("ac_online");
                            sb.append("|");
                            sb.append(line3);
                        }
                        bufferedReader4.close();
                        bufferedReader3 = bufferedReader4;
                        sb.append("\n");
                        if (new File("/sys/class/power_supply/usb/online").exists()) {
                            bufferedReader2 = new BufferedReader(new FileReader("/sys/class/power_supply/usb/online"));
                            try {
                                line2 = bufferedReader2.readLine();
                                if (line2 != null) {
                                    sb.append("usb_online");
                                    sb.append("|");
                                    sb.append(line2);
                                }
                                bufferedReader2.close();
                                bufferedReader3 = bufferedReader2;
                                sb.append("\n");
                                if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                                    bufferedReader = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                                    try {
                                        line = bufferedReader.readLine();
                                        if (line != null) {
                                            sb.append("battery_capacity");
                                            sb.append("|");
                                            sb.append(line);
                                        }
                                        bufferedReader.close();
                                        bufferedReader3 = bufferedReader;
                                    } catch (Throwable unused) {
                                        bufferedReader3 = bufferedReader;
                                        if (bufferedReader3 != null) {
                                            bufferedReader3.close();
                                        }
                                        return sb.toString();
                                    }
                                }
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                            } catch (Throwable unused2) {
                                bufferedReader3 = bufferedReader2;
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                                return sb.toString();
                            }
                        } else {
                            sb.append("\n");
                            if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                                bufferedReader = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                                line = bufferedReader.readLine();
                                if (line != null) {
                                    sb.append("battery_capacity");
                                    sb.append("|");
                                    sb.append(line);
                                }
                                bufferedReader.close();
                                bufferedReader3 = bufferedReader;
                            }
                            if (bufferedReader3 != null) {
                                bufferedReader3.close();
                            }
                        }
                    } catch (Throwable unused3) {
                        bufferedReader3 = bufferedReader4;
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        return sb.toString();
                    }
                } else {
                    sb.append("\n");
                    if (new File("/sys/class/power_supply/usb/online").exists()) {
                        bufferedReader2 = new BufferedReader(new FileReader("/sys/class/power_supply/usb/online"));
                        line2 = bufferedReader2.readLine();
                        if (line2 != null) {
                            sb.append("usb_online");
                            sb.append("|");
                            sb.append(line2);
                        }
                        bufferedReader2.close();
                        bufferedReader3 = bufferedReader2;
                        sb.append("\n");
                        if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                            bufferedReader = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                            line = bufferedReader.readLine();
                            if (line != null) {
                                sb.append("battery_capacity");
                                sb.append("|");
                                sb.append(line);
                            }
                            bufferedReader.close();
                            bufferedReader3 = bufferedReader;
                        }
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                    } else {
                        sb.append("\n");
                        if (new File("/sys/class/power_supply/battery/capacity").exists()) {
                            bufferedReader = new BufferedReader(new FileReader("/sys/class/power_supply/battery/capacity"));
                            line = bufferedReader.readLine();
                            if (line != null) {
                                sb.append("battery_capacity");
                                sb.append("|");
                                sb.append(line);
                            }
                            bufferedReader.close();
                            bufferedReader3 = bufferedReader;
                        }
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                    }
                }
            } catch (IOException e) {
                x.a(e);
            }
        } catch (Throwable unused4) {
        }
        return sb.toString();
    }

    public static String k(Context context) {
        StringBuilder sb = new StringBuilder();
        String strA = z.a(context, "gsm.sim.state");
        if (strA != null) {
            sb.append("gsm.sim.state|");
            sb.append(strA);
        }
        sb.append("\n");
        String strA2 = z.a(context, "gsm.sim.state2");
        if (strA2 != null) {
            sb.append("gsm.sim.state2|");
            sb.append(strA2);
        }
        return sb.toString();
    }

    public static long n() {
        BufferedReader bufferedReader;
        Throwable th;
        float fCurrentTimeMillis = 0.0f;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        fCurrentTimeMillis = (System.currentTimeMillis() / 1000) - Float.parseFloat(line.split(" ")[0]);
                    }
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x.a(th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return (long) fCurrentTimeMillis;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                x.a(e);
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
            }
        } catch (IOException e2) {
            x.a(e2);
        }
        return (long) fCurrentTimeMillis;
    }
}
