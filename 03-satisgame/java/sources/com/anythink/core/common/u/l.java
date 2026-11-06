package com.anythink.core.common.u;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATSDKGlobalSetting;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static volatile String K = null;
    private static volatile String L = null;
    private static volatile String M = null;
    private static volatile String N = null;
    private static volatile String O = null;
    private static volatile String P = null;
    private static volatile String Q = null;
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
    private static volatile PackageInfo ae = null;
    private static BatteryManager af = null;
    public static String b = null;
    public static final String d = "unknown";
    static String e = null;
    private static final String f = "l";
    private static volatile String h;
    private static volatile String j;
    private static int k;
    private static volatile boolean l;
    private static String m;
    private static volatile PackageInfo n;
    private static volatile String o;
    private static final JSONObject g = new JSONObject();
    private static String i = null;
    public static volatile String c = "";
    private static volatile String p = null;
    private static String q = "";
    private static String r = "";
    private static String s = "";
    private static String t = "";
    private static int u = 0;
    private static String v = "";
    private static String w = "";
    private static String x = null;
    private static String y = "";
    private static String z = "";
    private static volatile String A = null;
    private static volatile String B = null;
    private static volatile int C = -1;
    private static volatile double D = 0.0d;
    private static volatile int E = -1;
    private static volatile int F = -999;
    private static volatile int G = -1;
    private static volatile int H = -1;
    private static volatile int I = -1;
    private static volatile int J = -1;
    private static volatile String ag = null;
    private static final Object ah = new Object();
    private static final Object ai = new Object();
    private static final Object aj = new Object();
    private static final Object ak = new Object();
    private static final Object al = new Object();
    private static final Object am = new Object();
    private static final Object an = new Object();
    private static final Object ao = new Object();
    private static final Object ap = new Object();
    private static final Object aq = new Object();
    private static final Object ar = new Object();
    private static final Object as = new Object();
    private static final Object at = new Object();
    private static final Object au = new Object();
    private static final Object av = new Object();
    private static final Object aw = new Object();
    private static final Object ax = new Object();

    static /* synthetic */ void M() {
    }

    private static void Q() {
    }

    private static void S() {
    }

    private static void T() {
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

    private l() {
    }

    public static void a(final Context context) {
        try {
            d();
            j(context);
            h(context);
            g(context);
            f(context);
            a();
            b();
            d(context);
            p(context);
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cJ, new Runnable() { // from class: com.anythink.core.common.u.l.1
                @Override // java.lang.Runnable
                public final void run() {
                    l.q(context);
                }
            }));
            e(context);
            c();
            com.anythink.core.common.d.s.b();
            com.anythink.core.common.c.b.a().a(context, "com.android.vending", new AnonymousClass2());
            z(context);
            A(context);
            B(context);
            C(context);
            try {
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (p.b(simOperator) && simOperator.length() > 3) {
                    y = simOperator.substring(0, 3);
                    z = simOperator.substring(3, simOperator.length());
                    Object[] objArr = new Object[2];
                    Object[] objArr2 = new Object[2];
                }
            } catch (Throwable unused) {
            }
            r();
            s();
            u(context);
            v(context);
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
        } catch (Throwable unused2) {
        }
    }

    public static String b(Context context) {
        if (com.anythink.core.common.d.s.b().c("mcc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.d.s.b().g();
        }
        try {
            return !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b() ? "" : y;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        if (com.anythink.core.common.d.s.b().c("mnc")) {
            return "";
        }
        if (context == null) {
            com.anythink.core.common.d.s.b().g();
        }
        try {
            return !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b() ? "" : z;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(Context context) {
        if (com.anythink.core.common.d.s.b().c("android_id") || !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
            return "";
        }
        if (o != null) {
            return o;
        }
        com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
        if (rVarC != null) {
            if (context == null) {
                context = com.anythink.core.common.d.s.b().g();
            }
            synchronized (aj) {
                if (o != null) {
                    return o;
                }
                String strC = ad.c(context, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.g, "");
                o = strC;
                if (TextUtils.isEmpty(strC)) {
                    o = rVarC.getAid(context);
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(o)) {
                        ad.b(context, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.g, o);
                    }
                }
                if (o == null) {
                    o = "";
                }
            }
        }
        return o;
    }

    private static String D(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String strD = d(context);
            if (TextUtils.isEmpty(strD)) {
                return "";
            }
            if (TextUtils.isEmpty(e)) {
                e = n.b(strD);
            }
        } catch (Throwable unused) {
        }
        return e;
    }

    public static String a() {
        if (com.anythink.core.common.d.s.b().c("model")) {
            return "";
        }
        try {
            return !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b() ? "" : Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        if (com.anythink.core.common.d.s.b().c("brand")) {
            return "";
        }
        try {
            return !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b() ? "" : Build.BRAND;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        if (com.anythink.core.common.d.s.b().c("language")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        try {
            if (!com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
                return "";
            }
            if (TextUtils.isEmpty(v)) {
                String language = context.getResources().getConfiguration().locale.getLanguage();
                v = language;
                Object[] objArr = new Object[1];
                return language;
            }
            return v;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int f(Context context) {
        if (com.anythink.core.common.d.s.b().c("orient")) {
            return 0;
        }
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        return context.getResources().getConfiguration().orientation == 2 ? 2 : 1;
    }

    private static boolean E(Context context) {
        return f(context) == 2;
    }

    public static String g(Context context) {
        if (com.anythink.core.common.d.s.b().c("app_vc")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        if (u == 0) {
            try {
                u = y(context).versionCode;
                return new StringBuilder().append(u).toString();
            } catch (Throwable unused) {
                return "";
            }
        }
        return new StringBuilder().append(u).toString();
    }

    public static String h(Context context) {
        if (com.anythink.core.common.d.s.b().c("app_vn")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        try {
            if (TextUtils.isEmpty(t)) {
                String str = y(context).versionName;
                t = str;
                return str;
            }
            return t;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static int F(Context context) {
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static int G(Context context) {
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String i(Context context) {
        if (com.anythink.core.common.d.s.b().c("screen")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        try {
            if (!com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
                return "";
            }
            StringBuilder sbAppend = new StringBuilder().append((context == null ? com.anythink.core.common.d.s.b().g() : context).getResources().getDisplayMetrics().widthPixels).append("*");
            if (context == null) {
                context = com.anythink.core.common.d.s.b().g();
            }
            return sbAppend.append(context.getResources().getDisplayMetrics().heightPixels).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String j(Context context) {
        if (com.anythink.core.common.d.s.b().c("package_name")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        try {
            if (TextUtils.isEmpty(s)) {
                String str = y(context).packageName;
                s = str;
                return str;
            }
            return s;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k(Context context) {
        if (com.anythink.core.common.d.s.b().c("it_src")) {
            return "";
        }
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        try {
            String str = a;
            if (str != null) {
                return str;
            }
            String installerPackageName = context.getPackageManager().getInstallerPackageName(j(context));
            a = installerPackageName;
            if (installerPackageName == null) {
                a = "";
            }
            Object[] objArr = new Object[1];
            return a;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static int H(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return -1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || !p.a("android.permission.ACCESS_NETWORK_STATE", context) || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
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

    public static String l(Context context) {
        if (com.anythink.core.common.d.s.b().c("network_type")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
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
                if (p.a("android.permission.ACCESS_NETWORK_STATE", context)) {
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
        if (com.anythink.core.common.d.s.b().c("timezone")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
                return "";
            }
            try {
                if (TextUtils.isEmpty(w)) {
                    String displayName = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                    w = displayName;
                    Object[] objArr = new Object[1];
                    return displayName;
                }
            } catch (Throwable unused) {
            }
            return w;
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String d() {
        if (com.anythink.core.common.d.s.b().c("os_vc")) {
            return "";
        }
        try {
            if (!com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
                return "";
            }
            if (TextUtils.isEmpty(r)) {
                r = String.valueOf(Build.VERSION.SDK_INT);
            }
            return r;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        if (com.anythink.core.common.d.s.b().c("os_vn")) {
            return "";
        }
        if (TextUtils.isEmpty(q)) {
            q = Build.VERSION.RELEASE;
        }
        return q;
    }

    private static int P() {
        return Build.VERSION.SDK_INT;
    }

    private static void h(String str) {
        h = str;
        ad.b(com.anythink.core.common.d.s.b().g(), com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.d, h);
    }

    public static String f() {
        try {
            if (!com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
                return "";
            }
            if (h == null) {
                synchronized (am) {
                    if (h == null) {
                        h = ad.c(com.anythink.core.common.d.s.b().g(), com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.d, "");
                    }
                }
            }
            return h;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g() {
        if (x == null) {
            synchronized (ai) {
                if (x == null) {
                    com.anythink.core.common.d.s.b();
                }
                if (x == null) {
                    x = "";
                }
            }
        }
        return x;
    }

    private static void I(Context context) {
        com.anythink.core.common.d.s.b();
        com.anythink.core.common.c.b.a().a(context, "com.android.vending", new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.anythink.core.common.u.l$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.core.common.c.f.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.core.common.c.f.a
        public final void a(PackageInfo packageInfo) {
            synchronized (l.ai) {
                if (packageInfo != null) {
                    String unused = l.x = packageInfo.versionName;
                    Object[] objArr = new Object[1];
                    String unused2 = l.x;
                    l.M();
                }
            }
        }
    }

    public static String m(Context context) {
        if (TextUtils.isEmpty(b)) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            b = String.valueOf(displayMetrics.density);
            Object[] objArr = new Object[1];
        }
        return b;
    }

    public static JSONObject h() {
        try {
            return new JSONObject(i);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void a(final int i2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.aA, new Runnable() { // from class: com.anythink.core.common.u.l.3
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (l.g) {
                    if (l.g.has(String.valueOf(i2))) {
                        return;
                    }
                    try {
                        l.g.put(String.valueOf(i2), str);
                        String unused = l.i = l.g.toString();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }));
    }

    public static String a(String str) {
        try {
            return g.getString(str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i() {
        if (com.anythink.core.common.d.s.b().c("ua") || !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
            return "";
        }
        synchronized (ak) {
            String strJ = j();
            if (!TextUtils.isEmpty(strJ)) {
                return strJ;
            }
            Object[] objArr = new Object[1];
            String str = Build.VERSION.RELEASE;
            String strA = a();
            String str2 = Build.ID;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(strA) || TextUtils.isEmpty(str2)) {
                return "";
            }
            return "Mozilla/5.0 (Linux; Android " + str + "; " + strA + " Build/" + str2 + ") AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
        }
    }

    public static String j() {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        synchronized (ak) {
            if (!TextUtils.isEmpty(p)) {
                return p;
            }
            if (p == null) {
                p = ad.c(com.anythink.core.common.d.s.b().g(), com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.r, "");
                Object[] objArr = new Object[1];
                if (!TextUtils.isEmpty(p)) {
                    return p;
                }
            }
            return null;
        }
    }

    public static String k() {
        if (ag != null) {
            return ag;
        }
        if (com.anythink.core.common.d.s.b().c(com.anythink.core.common.l.f.bN)) {
            return "";
        }
        if (ag == null) {
            synchronized (ah) {
                if (ag == null) {
                    try {
                        ag = System.getProperty("http.agent");
                        Object[] objArr = new Object[1];
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (ag == null) {
            ag = "";
        }
        return ag;
    }

    public static void n(Context context) {
        try {
            p = WebSettings.getDefaultUserAgent(context);
            Object[] objArr = new Object[1];
            ad.b(context, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.r, p);
            ad.b(context, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.s, Build.VERSION.RELEASE);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.u.l$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass4(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebView webView = new WebView(this.a);
            o.a(webView);
            String unused = l.p = webView.getSettings().getUserAgentString();
            Object[] objArr = new Object[1];
            String unused2 = l.p;
            l.M();
            ad.b(this.a, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.r, l.p);
            ad.b(this.a, com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.s, Build.VERSION.RELEASE);
        }
    }

    public static void o(Context context) {
        synchronized (al) {
            if (TextUtils.isEmpty(com.anythink.core.common.d.s.b().C())) {
                com.anythink.core.common.d.r rVarC = com.anythink.core.common.d.s.b().c();
                String uniqueId = rVarC != null ? rVarC.getUniqueId(context) : "";
                if (TextUtils.isEmpty(uniqueId)) {
                    uniqueId = p(context);
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
                com.anythink.core.common.d.s.b().l(n.a(uniqueId));
                Object[] objArr = new Object[1];
                com.anythink.core.common.d.s.b().C();
                com.anythink.core.common.t.f.a("", "3", "", String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public static String p(Context context) {
        if (context == null || com.anythink.core.common.d.s.b().c("gaid")) {
            return "";
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return "";
        }
        synchronized (am) {
            try {
                try {
                    if (!TextUtils.isEmpty(h)) {
                        return h;
                    }
                    Object[] objArr = new Object[1];
                    String strJ = J(context);
                    if (!TextUtils.isEmpty(strJ) && !Pattern.matches("^[0-]+$", strJ)) {
                        h(strJ);
                        Object[] objArr2 = new Object[1];
                    }
                    return strJ;
                } catch (Throwable th) {
                    throw th;
                }
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    private static String J(final Context context) {
        Callable<String> callable = new Callable<String>() { // from class: com.anythink.core.common.u.l.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String call() {
                String strA;
                try {
                    try {
                        Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                        Class<?> cls2 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
                        Object objInvoke = cls.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
                        Method method = cls2.getMethod("getId", new Class[0]);
                        method.setAccessible(true);
                        strA = (String) method.invoke(objInvoke, new Object[0]);
                    } catch (Throwable unused) {
                        strA = "";
                    }
                } catch (Throwable unused2) {
                    strA = new com.anythink.core.common.d.e().a(context).a();
                }
                Object[] objArr = new Object[1];
                l.M();
                return strA;
            }
        };
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        try {
            try {
                String str = (String) threadPoolExecutor.submit(callable).get(2L, TimeUnit.SECONDS);
                try {
                    threadPoolExecutor.shutdown();
                } catch (Throwable unused) {
                }
                return str;
            } catch (Throwable unused2) {
                threadPoolExecutor.shutdown();
                return "";
            }
        } catch (Throwable unused3) {
            return "";
        }
    }

    public static void q(Context context) {
        if (context == null || com.anythink.core.common.d.s.b().c("gaid") || Looper.getMainLooper() == Looper.myLooper()) {
            return;
        }
        try {
            String strJ = J(context);
            if (!TextUtils.isEmpty(strJ) && !Pattern.matches("^[0-]+$", strJ)) {
                synchronized (am) {
                    try {
                        if (h == null) {
                            h = ad.c(com.anythink.core.common.d.s.b().g(), com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.d, "");
                        }
                        if (!strJ.equals(h)) {
                            Object[] objArr = new Object[2];
                            h(strJ);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean i(String str) {
        return Pattern.matches("^[0-]+$", str);
    }

    public static String l() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        String strO = com.anythink.core.common.d.s.b().O();
        if (!TextUtils.isEmpty(strO)) {
            c = strO;
        } else {
            synchronized (ax) {
                String strO2 = com.anythink.core.common.d.s.b().O();
                if (TextUtils.isEmpty(strO2)) {
                    strO2 = "1";
                    try {
                        Class.forName("com.unity3d.player.UnityPlayer");
                        strO2 = "2";
                    } catch (Throwable unused) {
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
            }
        }
        return c;
    }

    public static int r(Context context) {
        if (G == -1) {
            G = p.a(context, "com.tencent.mm") ? 1 : 0;
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
        String strD = com.anythink.core.common.d.s.b().d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        try {
            Map<String, Object> mapM = com.anythink.core.common.d.s.b().m();
            if (mapM != null && (obj = mapM.get(ATAdConst.KEY.WECHAT_APPID)) != null) {
                return obj.toString();
            }
        } catch (Throwable unused) {
        }
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(com.anythink.core.common.d.s.b().g()).b(com.anythink.core.common.d.s.b().p());
        if (bVarB != null) {
            return bVarB.aW();
        }
        return null;
    }

    public static int o() {
        if (I != -1) {
            return I;
        }
        I = 0;
        try {
            I = ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable unused) {
        }
        return I;
    }

    public static int b(String str) {
        if (J != -1) {
            return J;
        }
        J = 0;
        try {
            J = ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", new Class[0]).invoke(c(str), new Object[0])).intValue();
        } catch (Throwable unused) {
        }
        return J;
    }

    public static Object c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.anythink.core.common.d.s.b().g(), str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String d(Context context, String str) {
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
        }
        if (context != null) {
            try {
                return new StringBuilder().append(context.getPackageManager().getPackageInfo(str, 0).versionCode).toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static PackageInfo a(Context context, String str) {
        if (context == null) {
            context = com.anythink.core.common.d.s.b().g();
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
        String str;
        if (com.anythink.core.common.d.s.b().c("amazon_id") || !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
            return "";
        }
        if (j == null) {
            synchronized (an) {
                if (j == null) {
                    String strC = ad.c(com.anythink.core.common.d.s.b().g(), com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.f, "");
                    j = strC;
                    if (TextUtils.isEmpty(strC)) {
                        try {
                            j = Settings.Secure.getString(com.anythink.core.common.d.s.b().g().getContentResolver(), "advertising_id");
                            Object[] objArr = new Object[1];
                            if (!TextUtils.isEmpty(j)) {
                                ad.b(com.anythink.core.common.d.s.b().g(), com.anythink.core.common.d.t.b.a, com.anythink.core.common.d.t.a.f, j);
                            } else {
                                j = "";
                            }
                            if (j == null) {
                                j = str;
                            }
                        } catch (Throwable unused) {
                            str = j == null ? "" : "";
                            return j;
                        }
                    }
                }
            }
        }
        return j;
    }

    public static int q() {
        if (!com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b()) {
            return -1;
        }
        if (k <= 0 && !l) {
            synchronized (ao) {
                if (!l) {
                    l = true;
                    try {
                        int i2 = Settings.Secure.getInt(com.anythink.core.common.d.s.b().g().getContentResolver(), "limit_ad_tracking") != 0 ? 2 : 1;
                        k = i2;
                        Object[] objArr = new Object[1];
                        Integer.valueOf(i2);
                    } catch (Throwable unused) {
                        k = -1;
                    }
                }
            }
        }
        return k;
    }

    public static String r() {
        if (j("cpu")) {
            return "";
        }
        if (M == null) {
            synchronized (at) {
                if (M == null) {
                    M = u.b();
                    Object[] objArr = new Object[1];
                }
            }
        }
        return M;
    }

    public static String s() {
        if (j("isroot")) {
            return "";
        }
        if (N == null) {
            synchronized (au) {
                if (N == null) {
                    N = u.a();
                    Object[] objArr = new Object[1];
                }
            }
        }
        return N;
    }

    public static String s(Context context) {
        return j("isagent") ? "" : u.a(context);
    }

    public static String t(Context context) {
        return (K(context) || j(com.anythink.core.common.l.f.aO)) ? "" : u.c(context);
    }

    public static String u(Context context) {
        if (O == null) {
            synchronized (av) {
                if (O == null) {
                    O = u.d(context);
                    Object[] objArr = new Object[1];
                }
            }
        }
        return O;
    }

    public static String v(Context context) {
        if (P == null) {
            synchronized (aw) {
                if (P == null) {
                    P = u.e(context);
                    Object[] objArr = new Object[1];
                }
            }
        }
        return P;
    }

    public static String w(Context context) {
        return j(com.anythink.core.common.l.f.aP) ? "" : u.b(context);
    }

    public static String x(Context context) {
        return j("battery") ? "" : u.f(context);
    }

    public static String t() {
        if (j(com.anythink.core.common.l.f.aR)) {
            return "";
        }
        if (Q == null) {
            Q = p.a() ? "1" : "0";
        }
        return Q;
    }

    public static String u() {
        if (R()) {
            return "";
        }
        if (R == null) {
            try {
                R = Build.TYPE;
            } catch (Throwable unused) {
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

    public static String v() {
        if (R()) {
            return "";
        }
        if (TextUtils.isEmpty(S)) {
            try {
                S = Build.TAGS;
            } catch (Throwable unused) {
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

    public static String w() {
        if (R()) {
            return "";
        }
        if (T == null) {
            try {
                T = Build.USER;
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

    public static String x() {
        if (R()) {
            return "";
        }
        if (U == null) {
            try {
                U = Build.RADIO;
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

    public static String y() {
        if (R()) {
            return "";
        }
        if (V == null) {
            try {
                V = Build.BOOTLOADER;
            } catch (Throwable unused) {
                V = "";
            }
        }
        String str = V;
        return (str == null || !"unknown".equals(str)) ? V : "";
    }

    public static String z() {
        if (R()) {
            return "";
        }
        if (W == null) {
            try {
                W = Build.HARDWARE;
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

    public static String A() {
        if (R()) {
            return "";
        }
        if (X == null) {
            try {
                X = Build.HOST;
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

    public static String B() {
        if (R()) {
            return "";
        }
        if (Y == null) {
            try {
                Y = Build.VERSION.CODENAME;
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

    public static String C() {
        if (R()) {
            return "";
        }
        if (Z == null) {
            try {
                Z = Build.VERSION.INCREMENTAL;
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

    public static String D() {
        if (R()) {
            return "";
        }
        if (aa == null) {
            try {
                aa = Build.SERIAL;
            } catch (Throwable unused) {
                aa = "";
            }
        }
        String str = aa;
        if (str == null) {
            aa = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return aa;
    }

    public static String E() {
        if (R()) {
            return "";
        }
        if (ab == null) {
            try {
                ab = Build.DISPLAY;
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

    public static String F() {
        if (R()) {
            return "";
        }
        if (ac == null) {
            try {
                ac = "1";
            } catch (Throwable unused) {
                ac = "";
            }
        }
        return ac;
    }

    public static String G() {
        if (R()) {
            return "";
        }
        if (ad == null) {
            try {
                ad = Build.BOARD;
            } catch (Throwable unused) {
                ad = "";
            }
        }
        String str = ad;
        if (str == null) {
            ad = "";
        } else if ("unknown".equals(str)) {
            return "";
        }
        return ad;
    }

    private static boolean j(String str) {
        return com.anythink.core.common.d.s.b().c(str) || !com.anythink.core.common.d.u.a(com.anythink.core.common.d.s.b().g()).b();
    }

    private static boolean R() {
        Context contextG = com.anythink.core.common.d.s.b().g();
        return !com.anythink.core.common.d.u.a(contextG).b() || K(contextG) || com.anythink.core.common.d.s.b().c("device_minor_data_deny");
    }

    private static boolean K(Context context) {
        return !com.anythink.core.e.d.a(context).b(com.anythink.core.common.d.s.b().p()).an();
    }

    public static String H() {
        return m;
    }

    public static void d(String str) {
        m = str;
    }

    public static PackageInfo y(Context context) {
        PackageInfo packageInfo;
        if (n == null) {
            synchronized (ap) {
                if (n == null) {
                    try {
                        n = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        Object[] objArr = new Object[1];
                        if (n == null) {
                            packageInfo = new PackageInfo();
                            n = packageInfo;
                        }
                    } catch (Throwable unused) {
                        if (n == null) {
                            packageInfo = new PackageInfo();
                            n = packageInfo;
                        }
                    }
                }
            }
        }
        return n;
    }

    private static PackageInfo L(Context context) {
        PackageInfo packageInfo;
        if (ae == null) {
            synchronized (as) {
                if (ae == null) {
                    try {
                        ae = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                        Object[] objArr = new Object[1];
                        if (ae == null) {
                            packageInfo = new PackageInfo();
                            ae = packageInfo;
                        }
                    } catch (Throwable unused) {
                        if (ae == null) {
                            packageInfo = new PackageInfo();
                            ae = packageInfo;
                        }
                    }
                }
            }
        }
        return ae;
    }

    public static String b(Context context, String str) {
        Signature signature;
        if (com.anythink.core.common.d.s.b().c(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(K)) {
            return K;
        }
        try {
            PackageInfo packageInfoL = L(context);
            if (packageInfoL != null && packageInfoL.signatures != null && packageInfoL.signatures.length > 0 && (signature = packageInfoL.signatures[0]) != null) {
                byte[] bArrDigest = MessageDigest.getInstance(j.b("U0hBMQ==")).digest(signature.toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                K = sb.substring(0, sb.length() - 1);
                Object[] objArr = new Object[1];
                return K;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String c(Context context, String str) {
        Signature signature;
        if (com.anythink.core.common.d.s.b().c(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(L)) {
            return L;
        }
        try {
            PackageInfo packageInfoL = L(context);
            if (packageInfoL != null && packageInfoL.signatures != null && packageInfoL.signatures.length > 0 && (signature = packageInfoL.signatures[0]) != null) {
                byte[] bArrDigest = MessageDigest.getInstance(j.b("TUQ1")).digest(signature.toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                L = sb.substring(0, sb.length() - 1);
                Object[] objArr = new Object[1];
                return L;
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static int z(Context context) {
        try {
            if (!j("s_c") && !K(context)) {
                if (F != -999) {
                    return F;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    if (telephonyManager.getSimState() == 5) {
                        F = 2;
                    } else if (telephonyManager.getSimState() == 1) {
                        F = 1;
                    } else {
                        F = -1;
                    }
                } else {
                    F = -1;
                }
                return F;
            }
            return -1;
        } catch (Throwable unused) {
            F = -1;
        }
    }

    public static int A(Context context) {
        try {
            if (com.anythink.core.common.d.s.b().c("u_a")) {
                return -1;
            }
            if (E != -1) {
                return E;
            }
            if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
                E = 2;
            } else {
                E = 1;
            }
            return E;
        } catch (Throwable unused) {
        }
    }

    public static double B(Context context) {
        try {
            if (j("battery")) {
                return 0.0d;
            }
            if (D != 0.0d) {
                return D;
            }
            if (af == null) {
                af = (BatteryManager) context.getSystemService("batterymanager");
            }
            BatteryManager batteryManager = af;
            if (batteryManager != null) {
                double intProperty = ((double) batteryManager.getIntProperty(4)) / 100.0d;
                D = intProperty;
                return intProperty;
            }
            return D;
        } catch (Throwable unused) {
        }
    }

    public static int C(Context context) {
        try {
            if (com.anythink.core.common.d.s.b().c("d_s")) {
                return -1;
            }
            if (C != -1) {
                return C;
            }
            int i2 = Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0);
            Object[] objArr = new Object[1];
            Integer.valueOf(i2);
            if (i2 != 0) {
                C = 2;
            } else {
                C = 1;
            }
            return C;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    public static String I() {
        try {
            if (com.anythink.core.common.d.s.b().c("ip_v4")) {
                if (A == null) {
                    A = "";
                }
                return "";
            }
            if (A != null) {
                String str = A;
                if (A == null) {
                    A = "";
                }
                return str;
            }
            if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
                com.anythink.core.common.d.s.b();
                if (!com.anythink.core.common.d.s.y()) {
                    String str2 = A;
                    if (A == null) {
                        A = "";
                    }
                    return str2;
                }
            }
            synchronized (aq) {
                if (A != null) {
                    String str3 = A;
                    if (A == null) {
                        A = "";
                    }
                    return str3;
                }
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                A = hostAddress;
                            }
                        }
                    }
                }
                Object[] objArr = new Object[1];
                if (A == null) {
                    A = "";
                }
                if (A == null) {
                    A = "";
                }
            }
        } catch (Throwable unused) {
            if (A == null) {
                A = "";
            }
        }
        return A;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    public static String J() {
        try {
            if (com.anythink.core.common.d.s.b().c("ip_v6")) {
                if (B == null) {
                    B = "";
                }
                return "";
            }
            if (B != null) {
                String str = B;
                if (B == null) {
                    B = "";
                }
                return str;
            }
            if (!ATSDKGlobalSetting.enableGetDeviceInfoInBg) {
                com.anythink.core.common.d.s.b();
                if (!com.anythink.core.common.d.s.y()) {
                    String str2 = B;
                    if (B == null) {
                        B = "";
                    }
                    return str2;
                }
            }
            synchronized (ar) {
                if (B != null) {
                    String str3 = B;
                    if (B == null) {
                        B = "";
                    }
                    return str3;
                }
                Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
                while (it.hasNext()) {
                    for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet6Address)) {
                            String hostAddress = inetAddress.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                B = hostAddress;
                            }
                        }
                    }
                }
                Object[] objArr = new Object[1];
                if (B == null) {
                    B = "";
                }
                if (B == null) {
                    B = "";
                }
            }
        } catch (Throwable unused) {
            if (B == null) {
                B = "";
            }
        }
        return B;
    }
}
