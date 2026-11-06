package com.smartdigimkt.r4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.smartdigimkt.sdk.core.SDKContext;
import com.smartdigimkt.sdk.core.bridge.entity.AppInfoEntity;
import com.smartdigimkt.sdk.core.bridge.entity.DeviceInfoEntity;
import java.io.File;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static volatile String A;
    public static volatile String B;
    public static volatile String C;
    public static volatile String D;
    public static volatile String E;
    public static volatile String F;
    public static String G;
    public static String H;
    public static String I;
    public static String J;
    public static String K;
    public static String L;
    public static String M;
    public static String N;
    public static String O;
    public static String P;
    public static String Q;
    public static String R;
    public static String S;
    public static volatile PackageInfo T;
    public static BatteryManager U;
    public static com.smartdigimkt.a3.d V;
    public static DeviceInfoEntity W;
    public static AppInfoEntity X;
    public static final Object Y;
    public static final Object Z;
    public static String a;
    public static final Object a0;
    public static String b;
    public static final Object b0;
    public static String c;
    public static final Object c0;
    public static volatile PackageInfo d;
    public static final Object d0;
    public static volatile String e;
    public static final Object e0;
    public static volatile String f;
    public static final Object f0;
    public static volatile boolean g;
    public static final Object g0;
    public static volatile boolean h;
    public static final Object h0;
    public static String i;
    public static final Object i0;
    public static String j;
    public static final Object j0;
    public static String k;
    public static String l;
    public static int m;
    public static String n;
    public static String o;
    public static volatile String p;
    public static volatile String q;
    public static volatile int r;
    public static volatile double s;
    public static volatile int t;
    public static volatile int u;
    public static volatile int v;
    public static volatile int w;
    public static volatile int x;
    public static volatile int y;
    public static volatile String z;

    static {
        new JSONObject();
        c = "";
        f = null;
        g = false;
        h = false;
        i = "";
        j = "";
        k = "";
        l = "";
        m = 0;
        n = "";
        o = "";
        p = null;
        q = null;
        r = -1;
        s = 0.0d;
        t = -1;
        u = -999;
        v = -1;
        w = -1;
        x = -1;
        y = -1;
        Y = new Object();
        Z = new Object();
        a0 = new Object();
        b0 = new Object();
        c0 = new Object();
        d0 = new Object();
        e0 = new Object();
        f0 = new Object();
        g0 = new Object();
        h0 = new Object();
        i0 = new Object();
        j0 = new Object();
    }

    public static void A() {
        Object obj = Z;
        synchronized (obj) {
            h = true;
            obj.notifyAll();
        }
    }

    public static String B() {
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        synchronized (Z) {
            if (!TextUtils.isEmpty(f)) {
                return f;
            }
            DeviceInfoEntity deviceInfoEntity = W;
            if (deviceInfoEntity != null) {
                String userAgent = deviceInfoEntity.getUserAgent();
                if (!TextUtils.isEmpty(userAgent)) {
                    f = userAgent;
                    if (!TextUtils.isEmpty(f)) {
                        y.a(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", com.smartdigimkt.k4.b.a, f);
                    }
                }
            }
            if (f == null) {
                f = y.c(SDKContext.getInstance().d(), "sdm_adx_rp_sdk", com.smartdigimkt.k4.b.a);
            }
            return f;
        }
    }

    public static boolean C() {
        SDKContext.getInstance().d();
        com.smartdigimkt.w2.c.a().getClass();
        return ((com.smartdigimkt.o4.e.c().a().K == 1) ^ true) || SDKContext.getInstance().a("device_minor_data_deny");
    }

    public static void a(AbstractMap abstractMap) {
        if (abstractMap != null) {
            try {
                if (abstractMap.isEmpty()) {
                    return;
                }
                Object obj = abstractMap.get(com.anythink.core.bridge.a.C0010a.a);
                Object obj2 = abstractMap.get(com.anythink.core.bridge.a.C0010a.b);
                a(obj instanceof Bundle ? (DeviceInfoEntity) com.smartdigimkt.r2.b.a((Bundle) obj, DeviceInfoEntity.class) : null, obj2 instanceof Bundle ? (AppInfoEntity) com.smartdigimkt.r2.b.a((Bundle) obj2, AppInfoEntity.class) : null);
            } catch (Throwable unused) {
            }
        }
    }

    public static String b(Context context) {
        if (SDKContext.getInstance().a("android_id")) {
            return "";
        }
        SDKContext.getInstance().d();
        com.smartdigimkt.w2.c.a().getClass();
        if (e != null) {
            return e;
        }
        com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
        if (bVarE != null) {
            if (context == null) {
                context = SDKContext.getInstance().d();
            }
            synchronized (Y) {
                if (e != null) {
                    return e;
                }
                e = y.c(context, "sdm_adx_rp_sdk", "sdm_adx_rp_aid");
                if (TextUtils.isEmpty(e)) {
                    DeviceInfoEntity deviceInfoEntity = W;
                    if (deviceInfoEntity != null) {
                        String androidId = deviceInfoEntity.getAndroidId();
                        if (!TextUtils.isEmpty(androidId)) {
                            e = androidId;
                        }
                    }
                    if (TextUtils.isEmpty(e)) {
                        e = bVarE.getAid(context);
                    }
                    if (!TextUtils.isEmpty(e)) {
                        y.a(context, "sdm_adx_rp_sdk", "sdm_adx_rp_aid", e);
                    }
                }
                if (e == null) {
                    e = "";
                }
            }
        }
        return e;
    }

    public static String c() {
        if (C()) {
            return "";
        }
        if (N == null) {
            try {
                N = Build.VERSION.CODENAME;
            } catch (Throwable unused) {
                N = "";
            }
        }
        String str = N;
        if (str == null) {
            N = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return N;
    }

    public static String d() {
        if (C()) {
            return "";
        }
        if (Q == null) {
            try {
                Q = Build.DISPLAY;
            } catch (Throwable unused) {
                Q = "";
            }
        }
        String str = Q;
        if (str == null) {
            Q = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return Q;
    }

    public static String e() {
        if (C()) {
            return "";
        }
        if (L == null) {
            try {
                L = Build.HARDWARE;
            } catch (Throwable unused) {
                L = "";
            }
        }
        String str = L;
        if (str == null) {
            L = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return L;
    }

    public static String f() {
        if (C()) {
            return "";
        }
        if (M == null) {
            try {
                M = Build.HOST;
            } catch (Throwable unused) {
                M = "";
            }
        }
        String str = M;
        if (str == null) {
            M = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return M;
    }

    public static String g() {
        if (C()) {
            return "";
        }
        if (O == null) {
            try {
                O = Build.VERSION.INCREMENTAL;
            } catch (Throwable unused) {
                O = "";
            }
        }
        String str = O;
        if (str == null) {
            O = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return O;
    }

    public static void h(Context context) {
        if (context == null || SDKContext.getInstance().a("ua")) {
            return;
        }
        SDKContext.getInstance().d();
        com.smartdigimkt.w2.c.a().getClass();
        if (TextUtils.isEmpty(B())) {
            synchronized (Z) {
                if (g) {
                    return;
                }
                g = true;
                h = false;
                com.smartdigimkt.q3.f.a().a(new f(context), 0L, 13);
            }
        }
    }

    public static String i() {
        if (C()) {
            return "";
        }
        if (P == null) {
            try {
                P = Build.SERIAL;
            } catch (Throwable unused) {
                P = "";
            }
        }
        String str = P;
        if (str == null) {
            P = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return P;
    }

    public static int j(Context context) {
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int k(Context context) {
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String l(Context context) {
        if (D == null) {
            synchronized (h0) {
                if (D == null) {
                    String strA = p.a(context, "ro.product.cpu.abi");
                    D = (strA == null || TextUtils.isEmpty(strA) || !strA.contains("x86")) ? "2" : "1";
                }
            }
        }
        return D;
    }

    public static String m() {
        if (c("cpu")) {
            return "";
        }
        if (B == null) {
            synchronized (f0) {
                if (B == null) {
                    B = p.a();
                }
            }
        }
        return B;
    }

    public static String n(Context context) {
        if (SDKContext.getInstance().a("language")) {
            return "";
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            if (!TextUtils.isEmpty(n)) {
                return n;
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            n = language;
            return language;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o(Context context) {
        if (SDKContext.getInstance().a("network_type")) {
            return "";
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            if (context == null) {
                return "-1";
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return "-1";
                }
                if (k.d(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        return "-1";
                    }
                    int i2 = 1;
                    if (activeNetworkInfo.getType() == 1) {
                        return "-2";
                    }
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager == null) {
                            return "-3";
                        }
                        int networkType = telephonyManager.getNetworkType();
                        StringBuilder sb = new StringBuilder();
                        if (networkType != 20) {
                            switch (networkType) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    break;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    i2 = 3;
                                    break;
                                case 13:
                                    i2 = 13;
                                    break;
                                default:
                                    i2 = -1;
                                    break;
                            }
                        } else {
                            i2 = 16;
                        }
                        return sb.append(i2).append("").toString();
                    } catch (Throwable unused) {
                    }
                }
                return "-3";
            } catch (Throwable unused2) {
                return "-1";
            }
        } catch (Exception unused3) {
            return "";
        }
    }

    public static String p(Context context) {
        if (SDKContext.getInstance().a("package_name")) {
            return "";
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        try {
            if (!TextUtils.isEmpty(k)) {
                return k;
            }
            String str = g(context).packageName;
            k = str;
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String q() {
        if (SDKContext.getInstance().a("model")) {
            return "";
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String r(Context context) {
        if (SDKContext.getInstance().a("screen")) {
            return "";
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            return k(context) + "*" + j(context);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String s() {
        if (SDKContext.getInstance().a("brand")) {
            return "";
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            return Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String t() {
        String str;
        if (c("isroot")) {
            return "";
        }
        if (C == null) {
            synchronized (g0) {
                if (C == null) {
                    try {
                        String[] strArr = p.a;
                        boolean z2 = false;
                        for (int i2 = 0; i2 < 18; i2++) {
                            if (new File(strArr[i2]).exists()) {
                                z2 = true;
                                break;
                            }
                        }
                        String str2 = Build.TAGS;
                        str = ((str2 == null || !str2.contains("test-keys")) && !z2) ? "2" : "1";
                    } catch (Throwable unused) {
                        str = "";
                    }
                    C = str;
                }
            }
        }
        return C;
    }

    public static String u(Context context) {
        if (SDKContext.getInstance().a("app_vc")) {
            return "";
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        if (m != 0) {
            return com.smartdigimkt.c0.j.a(new StringBuilder(), m, "");
        }
        try {
            m = g(context).versionCode;
            return m + "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String v(Context context) {
        if (SDKContext.getInstance().a("app_vn")) {
            return "";
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        try {
            if (!TextUtils.isEmpty(l)) {
                return l;
            }
            String str = g(context).versionName;
            l = str;
            return str;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void w(Context context) {
        synchronized (a0) {
            if (TextUtils.isEmpty(SDKContext.getInstance().h())) {
                DeviceInfoEntity deviceInfoEntity = W;
                if (deviceInfoEntity != null) {
                    String upId = deviceInfoEntity.getUpId();
                    if (!TextUtils.isEmpty(upId)) {
                        SDKContext sDKContext = SDKContext.getInstance();
                        y.a(sDKContext.c, "sdm_adx_rp_sdk", com.anythink.core.common.d.t.a.w, upId);
                        sDKContext.v = upId;
                        return;
                    }
                }
                com.smartdigimkt.w2.b bVarE = SDKContext.getInstance().e();
                String uniqueId = bVarE != null ? bVarE.getUniqueId(context) : "";
                if (TextUtils.isEmpty(uniqueId)) {
                    uniqueId = b(context);
                }
                if (TextUtils.isEmpty(uniqueId)) {
                    uniqueId = UUID.randomUUID().toString();
                }
                SDKContext sDKContext2 = SDKContext.getInstance();
                String strB = i.b(uniqueId);
                y.a(sDKContext2.c, "sdm_adx_rp_sdk", com.anythink.core.common.d.t.a.w, strB);
                sDKContext2.v = strB;
                SDKContext.getInstance().h();
                String strValueOf = String.valueOf(System.currentTimeMillis());
                com.smartdigimkt.f3.c cVar = new com.smartdigimkt.f3.c(null, null);
                cVar.a = "3000004";
                cVar.c = "";
                cVar.l = "3";
                cVar.m = "";
                cVar.n = strValueOf;
                com.smartdigimkt.n3.k.a(cVar);
            }
        }
    }

    public static String x() {
        String str = SDKContext.getInstance().i;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        com.smartdigimkt.p4.a aVarA = com.smartdigimkt.o4.e.c().a();
        if (aVarA != null) {
            return aVarA.M;
        }
        return null;
    }

    public static int y(Context context) {
        if (SDKContext.getInstance().a("orient")) {
            return 0;
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        return context.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    public static boolean z() {
        AppInfoEntity appInfoEntity = X;
        return appInfoEntity != null && appInfoEntity.getMediationPlatform() == 1;
    }

    public static String j() {
        if (C()) {
            return "";
        }
        if (TextUtils.isEmpty(H)) {
            try {
                H = Build.TAGS;
            } catch (Throwable unused) {
            }
        }
        String str = H;
        if (str == null) {
            H = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return H;
    }

    public static String k() {
        if (C()) {
            return "";
        }
        if (G == null) {
            try {
                G = Build.TYPE;
            } catch (Throwable unused) {
            }
        }
        String str = G;
        if (str == null) {
            G = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return G;
    }

    public static void y() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.a, "hw_ver"));
        arrayList.add(new com.smartdigimkt.v2.a(com.smartdigimkt.q2.a.b, "hw_hms_ver"));
        com.smartdigimkt.v2.p pVarC = com.smartdigimkt.v2.p.c();
        pVarC.getClass();
        if (!SDKContext.getInstance().a(com.anythink.core.common.l.f.bG) && arrayList.size() > 0) {
            com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.v2.h(pVarC, arrayList), Math.max(0L, com.smartdigimkt.q2.g.h), 2);
        }
        com.smartdigimkt.v2.p.c().i();
    }

    public static String m(Context context) {
        if (E == null) {
            synchronized (i0) {
                if (E == null) {
                    E = "1".equals(p.a(context, "ro.kernel.qemu")) ? "1" : "2";
                }
            }
        }
        return E;
    }

    public static String q(Context context) {
        if (TextUtils.isEmpty(b)) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            b = String.valueOf(displayMetrics.density);
        }
        return b;
    }

    public static String s(Context context) {
        if (SDKContext.getInstance().a("it_src")) {
            return "";
        }
        if (context == null) {
            context = SDKContext.getInstance().d();
        }
        try {
            if (TextUtils.isEmpty(a)) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(p(context));
                a = installerPackageName;
                return installerPackageName;
            }
            return a;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(DeviceInfoEntity deviceInfoEntity, AppInfoEntity appInfoEntity) {
        DeviceInfoEntity deviceInfoEntity2 = W;
        AppInfoEntity appInfoEntity2 = X;
        if (deviceInfoEntity2 == null) {
            W = deviceInfoEntity;
        } else if (deviceInfoEntity != null) {
            String userAgent = deviceInfoEntity.getUserAgent();
            if (!TextUtils.isEmpty(userAgent)) {
                deviceInfoEntity2.setUserAgent(userAgent);
            }
            String oaid = deviceInfoEntity.getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                deviceInfoEntity2.setOaid(oaid);
            }
            String ssid = deviceInfoEntity.getSsid();
            if (!TextUtils.isEmpty(ssid)) {
                deviceInfoEntity2.setSsid(ssid);
            }
            String imei = deviceInfoEntity.getImei();
            if (!TextUtils.isEmpty(imei)) {
                deviceInfoEntity2.setImei(imei);
            }
            String imsi = deviceInfoEntity.getImsi();
            if (!TextUtils.isEmpty(imsi)) {
                deviceInfoEntity2.setImsi(imsi);
            }
            String mac = deviceInfoEntity.getMac();
            if (!TextUtils.isEmpty(mac)) {
                deviceInfoEntity2.setMac(mac);
            }
        }
        if (appInfoEntity2 == null) {
            X = appInfoEntity;
        } else if (appInfoEntity != null) {
            appInfoEntity2.setMediationPlatform(appInfoEntity.getMediationPlatform());
            appInfoEntity2.setMediationVersion(appInfoEntity.getMediationVersion());
            appInfoEntity2.setMediationAppId(appInfoEntity.getMediationAppId());
            appInfoEntity2.setMediationAppKey(appInfoEntity.getMediationAppKey());
        }
    }

    public static String l() {
        if (C()) {
            return "";
        }
        if (I == null) {
            try {
                I = Build.USER;
            } catch (Throwable unused) {
                I = "";
            }
        }
        String str = I;
        if (str == null) {
            I = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return I;
    }

    public static boolean c(String str) {
        if (SDKContext.getInstance().a(str)) {
            return true;
        }
        SDKContext.getInstance().d();
        com.smartdigimkt.w2.c.a().getClass();
        return false;
    }

    public static String d(Context context) {
        Signature[] signatureArr;
        Signature signature;
        if (SDKContext.getInstance().a(com.anythink.core.common.l.f.bf)) {
            return "";
        }
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        try {
            PackageInfo packageInfoE = e(context);
            if (packageInfoE != null && (signatureArr = packageInfoE.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                byte[] bArrDigest = MessageDigest.getInstance(e.a("U0hBMQ==")).digest(signature.toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                z = sb.substring(0, sb.length() - 1);
                return z;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static PackageInfo e(Context context) {
        PackageInfo packageInfo;
        if (T == null) {
            synchronized (e0) {
                if (T == null) {
                    try {
                        T = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                        if (T == null) {
                            packageInfo = new PackageInfo();
                            T = packageInfo;
                        }
                    } catch (Throwable unused) {
                        if (T == null) {
                            packageInfo = new PackageInfo();
                            T = packageInfo;
                        }
                    }
                }
            }
        }
        return T;
    }

    public static double f(Context context) {
        try {
            if (c("battery")) {
                return 0.0d;
            }
            if (s != 0.0d) {
                return s;
            }
            if (U == null) {
                U = (BatteryManager) context.getSystemService("batterymanager");
            }
            BatteryManager batteryManager = U;
            if (batteryManager != null) {
                s = ((double) batteryManager.getIntProperty(4)) / 100.0d;
                return s;
            }
            return s;
        } catch (Throwable unused) {
        }
    }

    public static PackageInfo g(Context context) {
        PackageInfo packageInfo;
        if (d == null) {
            synchronized (b0) {
                if (d == null) {
                    try {
                        d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        if (d == null) {
                            packageInfo = new PackageInfo();
                            d = packageInfo;
                        }
                    } catch (Throwable unused) {
                        if (d == null) {
                            packageInfo = new PackageInfo();
                            d = packageInfo;
                        }
                    }
                }
            }
        }
        return d;
    }

    public static String r() {
        if (SDKContext.getInstance().a("os_vc")) {
            return "";
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            if (TextUtils.isEmpty(j)) {
                j = Build.VERSION.SDK_INT + "";
            }
            return j;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        Signature[] signatureArr;
        Signature signature;
        if (SDKContext.getInstance().a(com.anythink.core.common.l.f.bg)) {
            return "";
        }
        if (!TextUtils.isEmpty(A)) {
            return A;
        }
        try {
            PackageInfo packageInfoE = e(context);
            if (packageInfoE != null && (signatureArr = packageInfoE.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                byte[] bArrDigest = MessageDigest.getInstance(e.a("TUQ1")).digest(signature.toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                A = sb.substring(0, sb.length() - 1);
                return A;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static int i(Context context) {
        try {
            if (SDKContext.getInstance().a("d_s")) {
                return -1;
            }
            if (r != -1) {
                return r;
            }
            if (Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                r = 2;
            } else {
                r = 1;
            }
            return r;
        } catch (Throwable unused) {
        }
    }

    public static String h() {
        if (C()) {
            return "";
        }
        if (J == null) {
            try {
                J = Build.RADIO;
            } catch (Throwable unused) {
                J = "";
            }
        }
        String str = J;
        if (str == null) {
            J = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return J;
    }

    public static String v() {
        if (SDKContext.getInstance().a("timezone")) {
            return "";
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            try {
                if (TextUtils.isEmpty(o)) {
                    String displayName = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                    o = displayName;
                    return displayName;
                }
            } catch (Throwable unused) {
            }
            return o;
        } catch (Exception unused2) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    public static String n() {
        String str;
        if (SDKContext.getInstance().a("ua")) {
            return "";
        }
        SDKContext.getInstance().d();
        com.smartdigimkt.w2.c.a().getClass();
        String strB = B();
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        if (g && !h) {
            synchronized (Z) {
                while (!h && TextUtils.isEmpty(f)) {
                    try {
                        Z.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        str = f;
                        if (!TextUtils.isEmpty(str)) {
                            return str;
                        }
                        String str2 = Build.VERSION.RELEASE;
                        String strQ = q();
                        String str3 = Build.ID;
                        return (!TextUtils.isEmpty(str2) || TextUtils.isEmpty(strQ) || TextUtils.isEmpty(str3)) ? "" : com.smartdigimkt.f.i.a(new StringBuilder("Mozilla/5.0 (Linux; Android ").append(str2).append("; ").append(strQ).append(" Build/"), str3, ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
                    }
                }
                str = f;
            }
        } else {
            str = f;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = Build.VERSION.RELEASE;
        String strQ2 = q();
        String str5 = Build.ID;
        return (!TextUtils.isEmpty(str4) || TextUtils.isEmpty(strQ2) || TextUtils.isEmpty(str5)) ? "" : com.smartdigimkt.f.i.a(new StringBuilder("Mozilla/5.0 (Linux; Android ").append(str4).append("; ").append(strQ2).append(" Build/"), str5, ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    public static String p() {
        try {
            if (SDKContext.getInstance().a("ip_v6")) {
                if (q == null) {
                    q = "";
                }
                return "";
            }
            if (q != null) {
                String str = q;
                if (q == null) {
                    q = "";
                }
                return str;
            }
            if (!com.smartdigimkt.q2.g.e && !SDKContext.getInstance().l) {
                String str2 = q;
                if (q == null) {
                    q = "";
                }
                return str2;
            }
            synchronized (d0) {
                if (q != null) {
                    String str3 = q;
                    if (q == null) {
                        q = "";
                    }
                    return str3;
                }
                DeviceInfoEntity deviceInfoEntity = W;
                if (deviceInfoEntity != null) {
                    q = deviceInfoEntity.getIpV6();
                }
                if (!TextUtils.isEmpty(q)) {
                    String str4 = q;
                    if (q == null) {
                        q = "";
                    }
                    return str4;
                }
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address)) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                q = hostAddress;
                            }
                        }
                    }
                }
                if (q == null) {
                    q = "";
                }
                if (q == null) {
                    q = "";
                }
            }
        } catch (Throwable unused) {
            if (q == null) {
                q = "";
            }
        }
        return q;
    }

    public static int x(Context context) {
        try {
            if (!c("s_c")) {
                if (!(!(com.smartdigimkt.o4.e.c().a().K == 1))) {
                    if (u != -999) {
                        return u;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        if (telephonyManager.getSimState() == 5) {
                            u = 2;
                        } else if (telephonyManager.getSimState() == 1) {
                            u = 1;
                        } else {
                            u = -1;
                        }
                    } else {
                        u = -1;
                    }
                    return u;
                }
            }
            return -1;
        } catch (Throwable unused) {
            u = -1;
        }
    }

    public static int t(Context context) {
        try {
            if (SDKContext.getInstance().a("u_a")) {
                return -1;
            }
            if (u != -1) {
                return u;
            }
            if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
                t = 2;
            } else {
                t = 1;
            }
            return t;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x00ca  */
    public static String o() {
        try {
            if (SDKContext.getInstance().a("ip_v4")) {
                if (p == null) {
                    p = "";
                }
                return "";
            }
            if (p != null) {
                String str = p;
                if (p == null) {
                    p = "";
                }
                return str;
            }
            if (!com.smartdigimkt.q2.g.e && !SDKContext.getInstance().l) {
                String str2 = p;
                if (p == null) {
                    p = "";
                }
                return str2;
            }
            synchronized (c0) {
                if (p != null) {
                    String str3 = p;
                    if (p == null) {
                        p = "";
                    }
                    return str3;
                }
                DeviceInfoEntity deviceInfoEntity = W;
                if (deviceInfoEntity != null) {
                    p = deviceInfoEntity.getIpV4();
                }
                if (!TextUtils.isEmpty(p)) {
                    String str4 = p;
                    if (p == null) {
                        p = "";
                    }
                    return str4;
                }
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                p = hostAddress;
                            }
                        }
                    }
                }
                if (p == null) {
                    p = "";
                }
                if (p == null) {
                    p = "";
                }
            }
        } catch (Throwable unused) {
            if (p == null) {
                p = "";
            }
        }
        return p;
    }

    public static com.smartdigimkt.a3.d w() {
        int i2;
        int i3;
        if (V == null) {
            synchronized (j0) {
                if (V == null) {
                    V = new com.smartdigimkt.a3.d();
                }
            }
        }
        try {
            com.smartdigimkt.a3.d dVar = V;
            Context contextD = SDKContext.getInstance().d();
            if (v == -1) {
                v = k.b(contextD, "com.tencent.mm") ? 1 : 0;
            }
            dVar.a = v;
            com.smartdigimkt.a3.d dVar2 = V;
            if (w == -1) {
                try {
                    Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                    Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
                    w = 1;
                } catch (Throwable unused) {
                    w = 0;
                }
            }
            dVar2.b = w;
            com.smartdigimkt.a3.d dVar3 = V;
            if (x != -1) {
                i2 = x;
            } else {
                x = 0;
                try {
                    x = ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
                } catch (Throwable unused2) {
                }
                i2 = x;
            }
            dVar3.c = i2;
            com.smartdigimkt.a3.d dVar4 = V;
            String strX = x();
            if (y != -1) {
                i3 = y;
            } else {
                y = 0;
                try {
                    y = ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", null).invoke(b(strX), null)).intValue();
                } catch (Throwable unused3) {
                }
                i3 = y;
            }
            dVar4.d = i3;
        } catch (Throwable unused4) {
        }
        return V;
    }

    public static Object b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, SDKContext.getInstance().d(), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b() {
        if (C()) {
            return "";
        }
        if (K == null) {
            try {
                K = Build.BOOTLOADER;
            } catch (Throwable unused) {
                K = "";
            }
        }
        String str = K;
        if (str == null) {
            K = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return K;
    }

    public static boolean a(String str) {
        if (SDKContext.getInstance().a(str)) {
            return false;
        }
        try {
            SDKContext.getInstance().d();
            com.smartdigimkt.w2.c.a().getClass();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(Context context) {
        try {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            if (!TextUtils.isEmpty(defaultUserAgent)) {
                synchronized (Z) {
                    f = defaultUserAgent;
                }
                y.a(context, "sdm_adx_rp_sdk", com.smartdigimkt.k4.b.a, defaultUserAgent);
            }
        } catch (Throwable unused) {
        }
        A();
    }

    public static String a() {
        if (C()) {
            return "";
        }
        if (S == null) {
            try {
                S = Build.BOARD;
            } catch (Throwable unused) {
                S = "";
            }
        }
        String str = S;
        if (str == null) {
            S = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return S;
    }

    public static String u() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String str = SDKContext.getInstance().j;
        if (!TextUtils.isEmpty(str)) {
            c = str;
            return str;
        }
        String str2 = SDKContext.getInstance().j;
        if (TextUtils.isEmpty(str2)) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                str2 = "2";
            } catch (Throwable unused) {
                str2 = "1";
            }
            try {
                Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
                Class.forName("org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge");
                str2 = "4";
            } catch (Throwable unused2) {
            }
            try {
                Class.forName("com.facebook.react.ReactActivity");
                str2 = "5";
            } catch (Throwable unused3) {
            }
            try {
                Class.forName("io.flutter.embedding.android.FlutterActivity");
                str2 = "6";
            } catch (Throwable unused4) {
            }
        }
        c = str2;
        return str2;
    }
}
