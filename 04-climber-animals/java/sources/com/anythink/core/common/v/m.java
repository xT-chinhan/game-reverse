package com.anythink.core.common.v;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATSDKGlobalSetting;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class m {
    private static String K = null;
    private static String L = null;
    private static String M = null;
    private static String N = null;
    private static String O = null;
    private static String P = null;
    private static String Q = null;
    private static String R = null;
    private static String S = null;
    private static String T = null;
    private static String U = null;
    private static String V = null;
    private static String W = null;
    private static String X = null;
    private static String Y = null;
    private static String Z = null;
    public static String a = null;
    private static String aa = null;
    private static String ab = null;
    private static String ac = null;
    private static String ad = null;
    private static String af = null;
    private static String ag = null;
    private static PackageInfo ah = null;
    private static BatteryManager al = null;
    public static String b = null;
    static String d = null;
    public static final String e = "unknown";
    private static final String f = "m";
    private static String g;
    private static String h;
    private static String k;
    private static boolean l;
    private static int m;
    private static boolean n;
    private static String o;
    private static PackageInfo p;
    private static final JSONObject i = new JSONObject();
    private static String j = null;
    public static String c = "";
    private static volatile String q = null;
    private static final Object r = new Object();
    private static volatile String s = null;
    private static final Object t = new Object();
    private static volatile String u = null;
    private static String v = "";
    private static String w = "";
    private static String x = "";
    private static String y = "";
    private static int z = 0;
    private static String A = "";
    private static String B = "";
    private static String C = null;
    private static Object D = new Object();
    private static String E = "";
    private static String F = "";
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static int J = -1;
    private static String ae = "";
    private static int ai = -999;
    private static int aj = -1;
    private static double ak = 0.0d;
    private static int am = -1;
    private static volatile String an = null;
    private static volatile String ao = null;
    private static final Object ap = new Object();
    private static final Object aq = new Object();

    private static void P() {
    }

    private static void Q() {
    }

    private static int a(int i2) {
        if (i2 == 20) {
            return 16;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 13;
            default:
                return -1;
        }
    }

    private m() {
    }

    public static void a(Context context) {
        try {
            d();
            m(context);
            i(context);
            h(context);
            f(context);
            a();
            b();
            d(context);
            f();
            e(context);
            c();
            com.anythink.core.common.d.t.b();
            com.anythink.core.common.c.b.a().a(context, p.a.a, new AnonymousClass1());
            B(context);
            C(context);
            D(context);
            E(context);
            if (q.a("android.permission.READ_PHONE_STATE", context)) {
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (q.b(simOperator) && simOperator.length() > 3) {
                    E = simOperator.substring(0, 3);
                    F = simOperator.substring(3, simOperator.length());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.anythink.core.common.c.a(com.anythink.core.common.d.j.t.a, "hw_ver"));
            arrayList.add(new com.anythink.core.common.c.a(com.anythink.core.common.d.j.t.b, "hw_hms_ver"));
            arrayList.add(new com.anythink.core.common.c.a(com.anythink.core.common.d.j.t.h, "mi_global_ver"));
            com.anythink.core.common.c.b.a().a(arrayList);
            r();
            s();
            w(context);
            x(context);
            t();
            u();
            v();
            w();
            x();
            y();
            z();
            A();
            B();
            C();
            D();
            E();
            F();
            G();
        } catch (Exception unused) {
        }
    }

    public static String b(Context context) {
        if (com.anythink.core.common.d.t.b().c("mcc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.d.t.b().g();
        }
        try {
            return !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b() ? "" : E;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        if (com.anythink.core.common.d.t.b().c("mnc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.d.t.b().g();
        }
        try {
            return !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b() ? "" : F;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        if (com.anythink.core.common.d.t.b().c("android_id") || !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
            return "";
        }
        if (q != null) {
            return q;
        }
        com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
        if (sVarC != null) {
            if (context == null) {
                context = com.anythink.core.common.d.t.b().g();
            }
            synchronized (r) {
                if (q != null) {
                    return q;
                }
                String strC = af.c(context, com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.f, "");
                q = strC;
                if (TextUtils.isEmpty(strC)) {
                    q = sVarC.getAid(context);
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(q)) {
                        af.b(context, com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.f, q);
                    }
                }
                if (q == null) {
                    q = "";
                }
            }
        }
        return q;
    }

    private static String F(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String strD = d(context);
            if (TextUtils.isEmpty(strD)) {
                return "";
            }
            if (TextUtils.isEmpty(d)) {
                d = o.b(strD);
            }
        } catch (Throwable unused) {
        }
        return d;
    }

    public static String a() {
        if (com.anythink.core.common.d.t.b().c("model")) {
            return "";
        }
        try {
            return !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b() ? "" : Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        if (com.anythink.core.common.d.t.b().c("brand")) {
            return "";
        }
        try {
            return !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b() ? "" : Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        if (com.anythink.core.common.d.t.b().c("language")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
                return "";
            }
            if (TextUtils.isEmpty(A)) {
                String language = context.getResources().getConfiguration().locale.getLanguage();
                A = language;
                return language;
            }
            return A;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int f(Context context) {
        if (com.anythink.core.common.d.t.b().c("orient")) {
            return 0;
        }
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        return context.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    public static boolean g(Context context) {
        return f(context) == 2;
    }

    public static String h(Context context) {
        if (com.anythink.core.common.d.t.b().c("app_vc")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        if (z == 0) {
            try {
                z = A(context).versionCode;
                return new StringBuilder().append(z).toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return new StringBuilder().append(z).toString();
    }

    public static String i(Context context) {
        if (com.anythink.core.common.d.t.b().c("app_vn")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        try {
            if (TextUtils.isEmpty(y)) {
                String str = A(context).versionName;
                y = str;
                return str;
            }
            return y;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int j(Context context) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int k(Context context) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String l(Context context) {
        if (com.anythink.core.common.d.t.b().c("screen")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        try {
            return !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b() ? "" : j(context) + "*" + k(context);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m(Context context) {
        if (com.anythink.core.common.d.t.b().c("package_name")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        try {
            if (TextUtils.isEmpty(x)) {
                String str = A(context).packageName;
                x = str;
                return str;
            }
            return x;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String n(Context context) {
        if (com.anythink.core.common.d.t.b().c("it_src")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        try {
            if (TextUtils.isEmpty(a)) {
                String installerPackageName = context.getPackageManager().getInstallerPackageName(m(context));
                a = installerPackageName;
                return installerPackageName;
            }
            return a;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static int G(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || !q.a(com.kuaishou.weapon.p0.g.b, context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            if (activeNetworkInfo.getType() == 1) {
                return -2;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getNetworkType();
        } catch (Throwable unused) {
        }
        return -1;
    }

    public static String o(Context context) {
        if (com.anythink.core.common.d.t.b().c("network_type")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
                return "";
            }
            if (context == null) {
                return "-1";
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    return "-1";
                }
                if (q.a(com.kuaishou.weapon.p0.g.b, context)) {
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
                        return sb.append(i2).toString();
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

    public static String c() {
        if (com.anythink.core.common.d.t.b().c("timezone")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
                return "";
            }
            try {
                if (TextUtils.isEmpty(B)) {
                    String displayName = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                    B = displayName;
                    return displayName;
                }
            } catch (Throwable unused) {
            }
            return B;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String d() {
        if (com.anythink.core.common.d.t.b().c("os_vc")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
                return "";
            }
            if (TextUtils.isEmpty(w)) {
                w = String.valueOf(Build.VERSION.SDK_INT);
            }
            return w;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        if (com.anythink.core.common.d.t.b().c("os_vn")) {
            return "";
        }
        if (TextUtils.isEmpty(v)) {
            v = Build.VERSION.RELEASE;
        }
        return v;
    }

    private static int M() {
        return Build.VERSION.SDK_INT;
    }

    public static void a(String str) {
        h = str;
        af.b(com.anythink.core.common.d.t.b().g(), com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.d, h);
    }

    public static String f() {
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
                return "";
            }
            if (h == null) {
                h = af.c(com.anythink.core.common.d.t.b().g(), com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.d, "");
            }
            return h;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g() {
        String str;
        synchronized (D) {
            if (C == null) {
                com.anythink.core.common.d.t.b();
            }
            if (C == null) {
                C = "";
            }
            str = C;
        }
        return str;
    }

    private static void H(Context context) {
        com.anythink.core.common.d.t.b();
        com.anythink.core.common.c.b.a().a(context, p.a.a, new AnonymousClass1());
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.m$1, reason: invalid class name */
    final class AnonymousClass1 implements com.anythink.core.common.c.h.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.core.common.c.h.a
        public final void a(PackageInfo packageInfo) {
            synchronized (m.D) {
                if (packageInfo != null) {
                    String unused = m.C = packageInfo.versionName;
                }
            }
        }
    }

    public static String p(Context context) {
        if (TextUtils.isEmpty(b)) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            b = String.valueOf(displayMetrics.density);
        }
        return b;
    }

    public static JSONObject h() {
        try {
            return new JSONObject(j);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void a(final int i2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.v.m.2
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (m.i) {
                    if (m.i.has(String.valueOf(i2))) {
                        return;
                    }
                    try {
                        m.i.put(String.valueOf(i2), str);
                        String unused = m.j = m.i.toString();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }, 13);
    }

    public static String b(String str) {
        try {
            return i.getString(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static synchronized String i() {
        if (com.anythink.core.common.d.t.b().c("ua")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
                return "";
            }
            String strJ = j();
            if (!TextUtils.isEmpty(strJ)) {
                return strJ;
            }
            String str = Build.VERSION.RELEASE;
            String strA = a();
            String str2 = Build.ID;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strA) || TextUtils.isEmpty(str2)) {
                return "";
            }
            return "Mozilla/5.0 (Linux; Android " + str + "; " + strA + " Build/" + str2 + ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized String j() {
        if (!TextUtils.isEmpty(s)) {
            return s;
        }
        if (s == null) {
            String strC = af.c(com.anythink.core.common.d.t.b().g(), com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.q, "");
            s = strC;
            if (!TextUtils.isEmpty(strC)) {
                return s;
            }
        }
        return null;
    }

    public static String k() {
        if (u != null) {
            return u;
        }
        if (com.anythink.core.common.d.t.b().c(com.anythink.core.common.m.e.bw)) {
            return "";
        }
        if (u == null) {
            synchronized (t) {
                if (u == null) {
                    try {
                        u = System.getProperty("http.agent");
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (u == null) {
            u = "";
        }
        return u;
    }

    public static void q(Context context) {
        try {
            s = WebSettings.getDefaultUserAgent(context);
            af.b(context, com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.q, s);
            af.b(context, com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.r, Build.VERSION.RELEASE);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.m$3, reason: invalid class name */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass3(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebView webView = new WebView(this.a);
            p.a(webView);
            String unused = m.s = webView.getSettings().getUserAgentString();
        }
    }

    public static synchronized void r(Context context) {
        if (TextUtils.isEmpty(com.anythink.core.common.d.t.b().B())) {
            com.anythink.core.common.d.s sVarC = com.anythink.core.common.d.t.b().c();
            String uniqueId = sVarC != null ? sVarC.getUniqueId(context) : "";
            if (TextUtils.isEmpty(uniqueId)) {
                uniqueId = s(context);
            }
            if (TextUtils.isEmpty(uniqueId) || Pattern.matches("^[0-]+$", uniqueId)) {
                uniqueId = p();
            }
            if (TextUtils.isEmpty(uniqueId)) {
                uniqueId = d(context);
            }
            if (TextUtils.isEmpty(uniqueId)) {
                uniqueId = UUID.randomUUID().toString();
            }
            com.anythink.core.common.d.t.b().l(o.a(uniqueId));
            com.anythink.core.common.u.e.a("", "3", "", String.valueOf(System.currentTimeMillis()));
        }
    }

    public static synchronized String s(final Context context) {
        if (com.anythink.core.common.d.t.b().c("gaid")) {
            return "";
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        final ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        final String[] strArr = new String[1];
        executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.anythink.core.common.v.m.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    try {
                        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class<?> cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        strArr[0] = (String) cls2.getMethod("getId", new Class[0]).invoke(cls.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context), new Object[0]);
                    } catch (Exception unused) {
                    }
                } catch (Throwable unused2) {
                    strArr[0] = new com.anythink.core.common.d.e().a(context).a();
                }
                if (!TextUtils.isEmpty(strArr[0]) && !m.i(strArr[0])) {
                    m.a(strArr[0]);
                }
                try {
                    synchronized (executorServiceNewFixedThreadPool) {
                        executorServiceNewFixedThreadPool.notifyAll();
                    }
                } catch (Throwable unused3) {
                }
            }
        });
        try {
            synchronized (executorServiceNewFixedThreadPool) {
                executorServiceNewFixedThreadPool.wait(com.anythink.basead.exoplayer.i.a.f);
            }
            executorServiceNewFixedThreadPool.shutdown();
            String str = strArr[0];
            return str != null ? str : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean j(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String l() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String strO = com.anythink.core.common.d.t.b().O();
        if (!TextUtils.isEmpty(strO)) {
            c = strO;
            return strO;
        }
        String strO2 = com.anythink.core.common.d.t.b().O();
        if (TextUtils.isEmpty(strO2)) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                strO2 = "2";
            } catch (Throwable unused) {
                strO2 = "1";
            }
            try {
                Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
                Class.forName("org.cocos2dx.lib.Cocos2dxJavascriptJavaBridge");
                strO2 = "4";
            } catch (Throwable unused2) {
            }
            try {
                Class.forName("com.facebook.react.ReactActivity");
                strO2 = "5";
            } catch (Throwable unused3) {
            }
            try {
                Class.forName("io.flutter.embedding.android.FlutterActivity");
                strO2 = "6";
            } catch (Throwable unused4) {
            }
        }
        c = strO2;
        return strO2;
    }

    public static int t(Context context) {
        if (G == -1) {
            G = q.a(context, "com.tencent.mm") ? 1 : 0;
        }
        return G;
    }

    public static int m() {
        if (H == -1) {
            try {
                Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
                Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
                H = 1;
            } catch (Throwable unused) {
                H = 0;
            }
        }
        return H;
    }

    public static String n() {
        Object obj;
        String strD = com.anythink.core.common.d.t.b().d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        try {
            Map<String, Object> mapM = com.anythink.core.common.d.t.b().m();
            if (mapM != null && (obj = mapM.get(ATAdConst.KEY.WECHAT_APPID)) != null) {
                return obj.toString();
            }
        } catch (Throwable unused) {
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null) {
            return bVarB.aW();
        }
        return null;
    }

    public static int o() {
        int i2 = I;
        if (i2 != -1) {
            return i2;
        }
        I = 0;
        try {
            I = ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable unused) {
        }
        return I;
    }

    public static int c(String str) {
        int i2 = J;
        if (i2 != -1) {
            return i2;
        }
        J = 0;
        try {
            J = ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", new Class[0]).invoke(d(str), new Object[0])).intValue();
        } catch (Throwable unused) {
        }
        return J;
    }

    public static Object d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.anythink.core.common.d.t.b().g(), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void N() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.anythink.core.common.c.a(com.anythink.core.common.d.j.t.a, "hw_ver"));
        arrayList.add(new com.anythink.core.common.c.a(com.anythink.core.common.d.j.t.b, "hw_hms_ver"));
        arrayList.add(new com.anythink.core.common.c.a(com.anythink.core.common.d.j.t.h, "mi_global_ver"));
        com.anythink.core.common.c.b.a().a(arrayList);
    }

    public static String a(Context context, String str) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        if (context != null) {
            try {
                return new StringBuilder().append(context.getPackageManager().getPackageInfo(str, 0).versionCode).toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static PackageInfo b(Context context, String str) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String p() {
        if (com.anythink.core.common.d.t.b().c("amazon_id") || !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
            return "";
        }
        if (k == null) {
            k = af.c(com.anythink.core.common.d.t.b().g(), com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.e, "");
        }
        if (TextUtils.isEmpty(k) && !l) {
            try {
                l = true;
                String string = Settings.Secure.getString(com.anythink.core.common.d.t.b().g().getContentResolver(), "advertising_id");
                k = string;
                if (!TextUtils.isEmpty(string)) {
                    af.b(com.anythink.core.common.d.t.b().g(), com.anythink.core.common.d.u.b.a, com.anythink.core.common.d.u.a.e, k);
                } else {
                    k = "";
                }
            } catch (Throwable unused) {
            }
        }
        return k;
    }

    public static int q() {
        if (!com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b()) {
            return -1;
        }
        if (m <= 0 && !n) {
            try {
                n = true;
                m = Settings.Secure.getInt(com.anythink.core.common.d.t.b().g().getContentResolver(), "limit_ad_tracking") != 0 ? 2 : 1;
            } catch (Throwable unused) {
                m = -1;
            }
        }
        return m;
    }

    public static String r() {
        if (k("cpu")) {
            return "";
        }
        if (K == null) {
            synchronized (v.class) {
                if (K == null) {
                    K = v.b();
                }
            }
        }
        return K;
    }

    public static String s() {
        if (k("isroot")) {
            return "";
        }
        if (L == null) {
            synchronized (v.class) {
                if (L == null) {
                    L = v.a();
                }
            }
        }
        return L;
    }

    public static String u(Context context) {
        return k("isagent") ? "" : v.a(context);
    }

    public static String v(Context context) {
        return I(context) ? "" : v.c(context);
    }

    public static String w(Context context) {
        if (M == null) {
            synchronized (v.class) {
                if (M == null) {
                    M = v.d(context);
                }
            }
        }
        return M;
    }

    public static String x(Context context) {
        if (N == null) {
            synchronized (v.class) {
                if (N == null) {
                    N = v.e(context);
                }
            }
        }
        return N;
    }

    public static String y(Context context) {
        return v.b(context);
    }

    public static String z(Context context) {
        return k("battery") ? "" : v.f(context);
    }

    public static String t() {
        if (k(com.anythink.core.common.m.e.aO)) {
            return "";
        }
        if (O == null) {
            O = q.a() ? "1" : "0";
        }
        return O;
    }

    public static String u() {
        if (O()) {
            return "";
        }
        if (P == null) {
            try {
                P = Build.TYPE;
            } catch (Throwable unused) {
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

    public static String v() {
        if (O()) {
            return "";
        }
        if (TextUtils.isEmpty(Q)) {
            try {
                Q = Build.TAGS;
            } catch (Throwable unused) {
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

    public static String w() {
        if (O()) {
            return "";
        }
        if (R == null) {
            try {
                R = Build.USER;
            } catch (Throwable unused) {
                R = "";
            }
        }
        String str = R;
        if (str == null) {
            R = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return R;
    }

    public static String x() {
        if (O()) {
            return "";
        }
        if (S == null) {
            try {
                S = Build.RADIO;
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

    public static String y() {
        if (O()) {
            return "";
        }
        if (T == null) {
            try {
                T = Build.BOOTLOADER;
            } catch (Throwable unused) {
                T = "";
            }
        }
        String str = T;
        if (str == null) {
            T = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return T;
    }

    public static String z() {
        if (O()) {
            return "";
        }
        if (U == null) {
            try {
                U = Build.HARDWARE;
            } catch (Throwable unused) {
                U = "";
            }
        }
        String str = U;
        if (str == null) {
            U = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return U;
    }

    public static String A() {
        if (O()) {
            return "";
        }
        if (V == null) {
            try {
                V = Build.HOST;
            } catch (Throwable unused) {
                V = "";
            }
        }
        String str = V;
        if (str == null) {
            V = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return V;
    }

    public static String B() {
        if (O()) {
            return "";
        }
        if (W == null) {
            try {
                W = Build.VERSION.CODENAME;
            } catch (Throwable unused) {
                W = "";
            }
        }
        String str = W;
        if (str == null) {
            W = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return W;
    }

    public static String C() {
        if (O()) {
            return "";
        }
        if (X == null) {
            try {
                X = Build.VERSION.INCREMENTAL;
            } catch (Throwable unused) {
                X = "";
            }
        }
        String str = X;
        if (str == null) {
            X = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return X;
    }

    public static String D() {
        if (O()) {
            return "";
        }
        if (Y == null) {
            try {
                Y = Build.SERIAL;
            } catch (Throwable unused) {
                Y = "";
            }
        }
        String str = Y;
        if (str == null) {
            Y = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return Y;
    }

    public static String E() {
        if (O()) {
            return "";
        }
        if (Z == null) {
            try {
                Z = Build.DISPLAY;
            } catch (Throwable unused) {
                Z = "";
            }
        }
        String str = Z;
        if (str == null) {
            Z = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return Z;
    }

    public static String F() {
        if (O()) {
            return "";
        }
        if (aa == null) {
            try {
                aa = "1";
            } catch (Throwable unused) {
                aa = "";
            }
        }
        return aa;
    }

    public static String G() {
        if (O()) {
            return "";
        }
        if (ab == null) {
            try {
                ab = Build.BOARD;
            } catch (Throwable unused) {
                ab = "";
            }
        }
        String str = ab;
        if (str == null) {
            ab = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return ab;
    }

    private static boolean k(String str) {
        return com.anythink.core.common.d.t.b().c(str) || !com.anythink.core.common.d.v.a(com.anythink.core.common.d.t.b().g()).b();
    }

    private static boolean O() {
        Context contextG = com.anythink.core.common.d.t.b().g();
        return !com.anythink.core.common.d.v.a(contextG).b() || I(contextG) || com.anythink.core.common.d.t.b().c("device_minor_data_deny");
    }

    private static boolean I(Context context) {
        return !com.anythink.core.d.d.a(context).b(com.anythink.core.common.d.t.b().p()).aA();
    }

    public static String H() {
        return o;
    }

    public static void e(String str) {
        o = str;
    }

    public static PackageInfo A(Context context) {
        if (p == null) {
            try {
                p = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable unused) {
            }
        }
        return p;
    }

    private static PackageInfo J(Context context) {
        if (ah == null) {
            try {
                ah = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (Throwable unused) {
            }
        }
        return ah;
    }

    public static String c(Context context, String str) {
        Signature signature;
        if (com.anythink.core.common.d.t.b().c(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(af)) {
            return af;
        }
        try {
            PackageInfo packageInfoJ = J(context);
            if (packageInfoJ != null && packageInfoJ.signatures != null && packageInfoJ.signatures.length > 0 && (signature = packageInfoJ.signatures[0]) != null) {
                byte[] bArrDigest = MessageDigest.getInstance(k.b("U0hBMQ==")).digest(signature.toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                String strSubstring = sb.substring(0, sb.length() - 1);
                af = strSubstring;
                return strSubstring;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public static String d(Context context, String str) {
        Signature signature;
        if (com.anythink.core.common.d.t.b().c(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(ag)) {
            return ag;
        }
        try {
            PackageInfo packageInfoJ = J(context);
            if (packageInfoJ != null && packageInfoJ.signatures != null && packageInfoJ.signatures.length > 0 && (signature = packageInfoJ.signatures[0]) != null) {
                byte[] bArrDigest = MessageDigest.getInstance(k.b("TUQ1")).digest(signature.toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                String strSubstring = sb.substring(0, sb.length() - 1);
                ag = strSubstring;
                return strSubstring;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public static int B(Context context) {
        TelephonyManager telephonyManager;
        try {
            if (!k("s_c") && !I(context)) {
                int i2 = ai;
                if (i2 != -999) {
                    return i2;
                }
                if (q.a("android.permission.READ_PHONE_STATE", context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    if (telephonyManager.getSimState() == 5) {
                        ai = 2;
                    } else if (telephonyManager.getSimState() == 1) {
                        ai = 1;
                    } else {
                        ai = -1;
                    }
                } else {
                    ai = -1;
                }
                return ai;
            }
            return -1;
        } catch (Throwable unused) {
            ai = -1;
        }
    }

    public static int C(Context context) {
        try {
            if (com.anythink.core.common.d.t.b().c("u_a")) {
                return -1;
            }
            int i2 = ai;
            if (i2 != -1) {
                return i2;
            }
            if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
                aj = 2;
            } else {
                aj = 1;
            }
        } catch (Throwable unused) {
        }
        return aj;
    }

    public static double D(Context context) {
        try {
            if (k("battery")) {
                return 0.0d;
            }
            double d2 = ak;
            if (d2 != 0.0d) {
                return d2;
            }
            if (al == null) {
                al = (BatteryManager) context.getSystemService("batterymanager");
            }
            BatteryManager batteryManager = al;
            if (batteryManager != null) {
                double intProperty = ((double) batteryManager.getIntProperty(4)) / 100.0d;
                ak = intProperty;
                return intProperty;
            }
        } catch (Throwable unused) {
        }
        return ak;
    }

    public static int E(Context context) {
        try {
            if (com.anythink.core.common.d.t.b().c("d_s")) {
                return -1;
            }
            int i2 = am;
            if (i2 != -1) {
                return i2;
            }
            if (Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                am = 2;
            } else {
                am = 1;
            }
        } catch (Throwable unused) {
        }
        return am;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    public static String I() {
        try {
            if (com.anythink.core.common.d.t.b().c("ip_v4")) {
                if (an == null) {
                    an = "";
                }
                return "";
            }
            if (an != null) {
                String str = an;
                if (an == null) {
                    an = "";
                }
                return str;
            }
            if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
                com.anythink.core.common.d.t.b();
                if (!com.anythink.core.common.d.t.c(com.anythink.core.common.d.t.b().g())) {
                    String str2 = an;
                    if (an == null) {
                        an = "";
                    }
                    return str2;
                }
            }
            synchronized (ap) {
                if (an != null) {
                    String str3 = an;
                    if (an == null) {
                        an = "";
                    }
                    return str3;
                }
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                an = hostAddress;
                            }
                        }
                    }
                }
                Object[] objArr = new Object[1];
                if (an == null) {
                    an = "";
                }
                if (an == null) {
                    an = "";
                }
            }
        } catch (Throwable unused) {
            if (an == null) {
                an = "";
            }
        }
        return an;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    public static String J() {
        try {
            if (com.anythink.core.common.d.t.b().c("ip_v6")) {
                if (ao == null) {
                    ao = "";
                }
                return "";
            }
            if (ao != null) {
                String str = ao;
                if (ao == null) {
                    ao = "";
                }
                return str;
            }
            if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
                com.anythink.core.common.d.t.b();
                if (!com.anythink.core.common.d.t.c(com.anythink.core.common.d.t.b().g())) {
                    String str2 = ao;
                    if (ao == null) {
                        ao = "";
                    }
                    return str2;
                }
            }
            synchronized (aq) {
                if (ao != null) {
                    String str3 = ao;
                    if (ao == null) {
                        ao = "";
                    }
                    return str3;
                }
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address)) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                ao = hostAddress;
                            }
                        }
                    }
                }
                Object[] objArr = new Object[1];
                if (ao == null) {
                    ao = "";
                }
                if (ao == null) {
                    ao = "";
                }
            }
        } catch (Throwable unused) {
            if (ao == null) {
                ao = "";
            }
        }
        return ao;
    }

    static /* synthetic */ boolean i(String str) {
        return Pattern.matches("^[0-]+$", str);
    }
}
