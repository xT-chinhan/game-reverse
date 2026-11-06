package com.anythink.core.common.d;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.ATCommonConfig;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.api.ATDebuggerConfig;
import com.anythink.core.api.ATInitConfig;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATNetworkConfig;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.api.ATSharedPlacementConfig;
import com.anythink.core.api.ATUserDeviceInfo;
import com.anythink.core.api.DeviceInfoCallback;
import com.anythink.core.api.IATAdFilter;
import com.anythink.core.api.IATDeviceRiskListener;
import com.anythink.core.api.IDlHandler;
import com.anythink.core.api.IExHandler;
import com.anythink.core.api.IOdHandler;
import com.anythink.core.api.IOsExHandler;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.core.common.h.ae;
import com.anythink.core.common.h.by;
import com.anythink.core.common.v.ab;
import com.anythink.core.common.v.ac;
import com.anythink.core.common.v.af;
import com.anythink.core.common.v.aj;
import com.anythink.core.common.w;
import com.anythink.core.common.x;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class t {
    public static final int a = 0;
    private static final Object ak = new Object();
    public static final int b = 1;
    private static volatile t k;
    private String A;
    private String B;
    private s C;
    private String I;
    private String J;
    private boolean L;
    private com.anythink.core.common.k.e P;
    private Location Q;
    private JSONArray S;
    private List<String> T;
    private String V;
    private ATDebuggerConfig W;
    private boolean X;
    private ConcurrentHashMap<String, IATAdFilter> ab;
    private ATUserDeviceInfo ad;
    private by ae;
    private String ah;
    private boolean ai;
    private long aj;
    private volatile com.anythink.core.common.m.c.i al;
    private Pair<Integer, List<String>> ao;
    private Pair<Boolean, com.anythink.core.common.h.n> ap;
    IATDeviceRiskListener f;
    WeakReference<Activity> g;
    private int h;
    private Context l;
    private String m;
    private String n;
    private ATNetworkConfig p;
    private String q;
    private ConcurrentHashMap<String, ATCustomAdapterConfig> t;
    private String v;
    private BroadcastReceiver y;
    private String z;
    private final String i = "SDK.init";
    private boolean j = false;
    private final Object x = new Object();
    private boolean E = false;
    private boolean F = false;
    private long G = 0;
    private long H = 0;
    private boolean M = false;
    private boolean N = false;
    private final Object O = new Object();
    private String R = "";
    private int Y = 1;
    private boolean Z = false;
    private boolean aa = false;
    private String ac = "";
    private final Object ag = new Object();
    public volatile boolean c = false;
    boolean d = false;
    private long am = -1;
    long e = 0;
    private int an = -1;
    private final List<m> aq = new ArrayList();
    private final Map<String, ATAdFilter> ar = new HashMap();
    private Handler o = new Handler(Looper.getMainLooper());
    private ConcurrentHashMap<String, Map<String, Object>> s = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> r = new ConcurrentHashMap<>();
    private final String D = File.separator + "anythink.test";
    private boolean K = true;
    private ConcurrentHashMap<String, List<String>> U = new ConcurrentHashMap<>();
    private JSONObject w = new JSONObject();
    private long af = System.currentTimeMillis();
    private final Map<String, Boolean> u = new ConcurrentHashMap(2);

    private static boolean ag() {
        return true;
    }

    private static boolean ah() {
        return false;
    }

    private static int ai() {
        return 0;
    }

    public final boolean a() {
        return this.L;
    }

    public static t b() {
        if (k == null) {
            synchronized (t.class) {
                if (k == null) {
                    k = new t();
                }
            }
        }
        return k;
    }

    public final s c() {
        IExHandler iExHandler;
        IDlHandler iDlHandler;
        IOdHandler iOdHandler;
        if (this.j) {
            return this.C;
        }
        synchronized (this.ag) {
            if (this.j) {
                return this.C;
            }
            IOsExHandler iOsExHandler = null;
            try {
                iExHandler = (IExHandler) a((Class<?>) IExHandler.class, j.g.b);
            } catch (Throwable unused) {
                iExHandler = null;
            }
            try {
                iDlHandler = (IDlHandler) a((Class<?>) IDlHandler.class, j.g.c);
            } catch (Throwable unused2) {
                iDlHandler = null;
            }
            try {
                iOdHandler = (IOdHandler) a((Class<?>) IOdHandler.class, j.g.d);
            } catch (Throwable unused3) {
                iOdHandler = null;
            }
            try {
                iOsExHandler = (IOsExHandler) a((Class<?>) IOsExHandler.class, "");
            } catch (Throwable unused4) {
            }
            if (iExHandler != null || iDlHandler != null || iOdHandler != null || iOsExHandler != null) {
                new StringBuilder("getExHandler, create OptPluginHandler, iExHandler=").append(iExHandler).append(", optHandler=").append(iDlHandler).append(", odHandler=").append(iOdHandler).append(", osExHandler=").append(iOsExHandler);
                this.C = new s(iExHandler, iDlHandler, iOdHandler, iOsExHandler);
            }
            this.j = true;
            return this.C;
        }
    }

    private static Object a(Class<?> cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str).asSubclass(cls);
            Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (Throwable th) {
            Object[] objArr = new Object[1];
            th.getMessage();
            return null;
        }
    }

    private t() {
    }

    public final void a(String str) {
        this.q = str;
    }

    public final String d() {
        return this.q;
    }

    public final synchronized void a(String str, ATCustomAdapterConfig aTCustomAdapterConfig) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.t == null) {
            this.t = new ConcurrentHashMap<>();
        }
        if (aTCustomAdapterConfig == null) {
            this.t.remove(str);
        } else {
            this.t.put(str, aTCustomAdapterConfig);
        }
    }

    public final ATCustomAdapterConfig b(String str) {
        if (this.t == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.t.get(str);
    }

    public final void a(int i) {
        if (i == 2) {
            this.Y = 2;
        } else {
            this.Y = 1;
        }
    }

    public final int e() {
        return this.Y;
    }

    public final void a(String... strArr) {
        synchronized (this.u) {
            try {
                if (strArr != null) {
                    for (String str : strArr) {
                        this.u.put(str, Boolean.TRUE);
                    }
                } else {
                    this.u.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(String str) {
        boolean zContainsKey;
        synchronized (this.u) {
            zContainsKey = this.u.containsKey(str);
        }
        return zContainsKey;
    }

    public final String[] f() {
        synchronized (this.u) {
            Set<String> setKeySet = this.u.keySet();
            int size = setKeySet.size();
            if (size <= 0) {
                return null;
            }
            String[] strArr = new String[size];
            setKeySet.toArray(strArr);
            return strArr;
        }
    }

    public final void a(Context context) {
        if (context == null) {
            Log.w("SDK.init", "ATSDK.setContext() is null!");
        } else {
            this.l = context;
        }
    }

    public final Context g() {
        return this.l;
    }

    public final long h() {
        return this.G;
    }

    public final long i() {
        return this.H;
    }

    public final int j() {
        return this.h;
    }

    public final void a(Map<String, Object> map) {
        if (map != null && map.containsKey("channel")) {
            Object obj = map.get("channel");
            String string = obj != null ? obj.toString() : "";
            this.I = string;
            if (!com.anythink.core.common.v.p.a(string)) {
                this.I = null;
                map.remove("channel");
            }
        }
        if (map != null && map.containsKey("sub_channel")) {
            Object obj2 = map.get("sub_channel");
            String string2 = obj2 != null ? obj2.toString() : "";
            this.J = string2;
            if (!com.anythink.core.common.v.p.b(string2)) {
                this.J = null;
                map.remove("sub_channel");
            }
        }
        this.r.clear();
        if (map != null) {
            com.anythink.core.common.v.j.a(this.r, map);
        }
        if (!TextUtils.isEmpty(this.I)) {
            this.r.put("channel", this.I);
        }
        if (TextUtils.isEmpty(this.J)) {
            return;
        }
        this.r.put("sub_channel", this.J);
    }

    public final void a(String str, Map<String, Object> map) {
        if (map != null) {
            this.s.put(str, map);
        }
    }

    private Map<String, Object> v(String str) {
        if (this.s == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.s.get(str);
    }

    public final void a(List<String> list) {
        try {
            this.T = list;
            if (list != null && !list.isEmpty()) {
                this.S = new JSONArray((Collection) list);
            } else {
                this.S = null;
            }
        } catch (Exception unused) {
        }
    }

    public final List<String> k() {
        return this.T;
    }

    public final JSONArray l() {
        return this.S;
    }

    public final Map<String, Object> m() {
        return this.r;
    }

    public final Map<String, Object> d(String str) {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.s.get(str);
        ConcurrentHashMap<String, Object> concurrentHashMap = this.r;
        if (concurrentHashMap != null) {
            com.anythink.core.common.v.j.a(map, concurrentHashMap);
        }
        if (map2 != null) {
            com.anythink.core.common.v.j.a(map, map2);
        }
        map.remove("channel");
        map.remove("sub_channel");
        Object obj = this.r.get("channel");
        Object obj2 = this.r.get("sub_channel");
        if (obj != null) {
            map.put("channel", obj);
        }
        if (obj2 != null) {
            map.put("sub_channel", obj2);
        }
        return map;
    }

    public final String n() {
        Object obj = this.r.get("channel");
        return obj != null ? obj.toString() : "";
    }

    public final void e(String str) {
        this.I = str;
        this.r.put("channel", str);
    }

    public final String o() {
        Object obj = this.r.get("sub_channel");
        return obj != null ? obj.toString() : "";
    }

    public final void f(String str) {
        this.J = str;
        this.r.put("sub_channel", str);
    }

    public final String p() {
        if (TextUtils.isEmpty(this.m)) {
            this.m = af.c(this.l, u.b.a, u.a.b, "");
        }
        return this.m;
    }

    private void b(String str, String str2) {
        this.m = str;
        this.n = str2;
        b();
        a(new AnonymousClass1(str, str2));
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.t$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        AnonymousClass1(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            af.b(t.this.l, u.b.a, u.a.b, this.a);
            af.b(t.this.l, u.b.a, u.a.c, this.b);
        }
    }

    public final String q() {
        if (TextUtils.isEmpty(this.n)) {
            this.n = af.c(this.l, u.b.a, u.a.c, "");
        }
        return this.n;
    }

    public final String r() {
        try {
            if (TextUtils.isEmpty(this.v)) {
                a(this.l, p(), 0);
            }
        } catch (Exception unused) {
        }
        return this.v;
    }

    public final String g(String str) {
        String strOptString;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        synchronized (this.x) {
            strOptString = this.w.optString(str);
        }
        return TextUtils.isEmpty(strOptString) ? x(str) : strOptString;
    }

    public final synchronized void a(Location location) {
        this.Q = location;
    }

    public final synchronized void a(boolean z) {
        this.R = z ? "1" : "2";
    }

    public final Location s() {
        return this.Q;
    }

    public final String t() {
        return this.R;
    }

    public final void u() {
        try {
            com.anythink.core.common.v.m.a(this.l);
            com.anythink.core.common.v.m.r(this.l);
        } catch (Exception unused) {
        }
        if (F()) {
            String strD = com.anythink.core.common.v.m.d(this.l);
            Log.i("anythink", "********************************** " + com.anythink.core.common.v.p.a() + " *************************************");
            Log.i("anythink", "GAID(ADID): " + com.anythink.core.common.v.m.f() + " , AndroidID: " + strD + ", OAID: " + com.anythink.core.common.v.m.H());
            Log.i("anythink", "********************************** " + com.anythink.core.common.v.p.a() + " *************************************");
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            Log.i("anythink", "You can use \"ATSDK.setDebuggerConfig(context, \"" + strD + "\",new ATDebuggerConfig.Builder(the NetworkFirmId you want to test).build());\" to open the debugger mode.");
        }
    }

    public final synchronized void a(final Context context, String str, String str2, ATNetworkConfig aTNetworkConfig) {
        if (this.d) {
            return;
        }
        this.d = true;
        this.l = context.getApplicationContext();
        if (context instanceof Activity) {
            a((Activity) context);
        }
        this.p = aTNetworkConfig;
        try {
            this.aj = System.currentTimeMillis();
            this.e = 0L;
            com.anythink.core.a.a.a(context.getApplicationContext()).a();
            a(this.l);
            this.m = str;
            this.n = str2;
            b();
            a(new AnonymousClass1(str, str2));
            b.b().a((Application) this.l);
        } catch (Throwable unused) {
        }
        a(new Runnable() { // from class: com.anythink.core.common.d.t.10
            @Override // java.lang.Runnable
            public final void run() {
                s sVarC = t.b().c();
                if (sVarC != null) {
                    sVarC.startPlugin(t.this.l);
                }
            }
        });
        a(new Runnable() { // from class: com.anythink.core.common.d.t.11
            @Override // java.lang.Runnable
            public final void run() {
                t.b(t.this);
                t tVar = t.this;
                t.a(tVar, tVar.l);
                com.anythink.core.common.a.i.a(context).a();
                com.anythink.core.common.s.b bVarA = com.anythink.core.common.s.b.a();
                Context context2 = context;
                String[] strArr = {u.b.a, u.b.b, u.b.c, u.b.e, u.b.g, u.b.h, u.b.i, u.b.j, u.b.k, u.b.l, u.b.m, u.b.n, u.b.o, "anythink_app_pl_cl_retry"};
                for (int i = 0; i < 14; i++) {
                    com.anythink.core.common.s.a aVarB = bVarA.b(context2, strArr[i]);
                    if (aVarB instanceof com.anythink.core.common.s.b.e) {
                        ((com.anythink.core.common.s.b.e) aVarB).c();
                    }
                }
                t.c(t.this);
            }
        });
    }

    private void ab() {
        if (this.am == -1) {
            long jB = af.b(this.l, u.b.a, u.a.I, 0L);
            this.am = jB;
            if (jB == 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.am = jCurrentTimeMillis;
                af.a(this.l, u.b.a, u.a.I, jCurrentTimeMillis);
            }
        }
    }

    public final boolean v() {
        Context context = this.l;
        if (context != null) {
            if (this.am == -1) {
                this.am = af.b(context, u.b.a, u.a.I, 0L);
            }
            if (this.am != 0 && System.currentTimeMillis() - this.am > 86400000) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void b(final Context context) {
        if (context == null) {
            return;
        }
        this.l = context.getApplicationContext();
        if (!TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.n)) {
            if (this.L) {
                return;
            }
            this.L = true;
            try {
                final Context applicationContext = context.getApplicationContext();
                this.Z = com.anythink.core.common.v.q.a();
                try {
                    BroadcastReceiver broadcastReceiver = this.y;
                    if (broadcastReceiver != null) {
                        this.l.unregisterReceiver(broadcastReceiver);
                        n.a(this.l).a(this.y);
                    }
                    this.y = null;
                } catch (Throwable unused) {
                }
                try {
                    this.y = new AnonymousClass3();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.addAction(j.v);
                    this.l.registerReceiver(this.y, intentFilter);
                    n.a(this.l).a(this.y, intentFilter);
                } catch (Throwable unused2) {
                }
                a(new Runnable() { // from class: com.anythink.core.common.d.t.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            t.this.T();
                            com.anythink.core.common.u.d.a().a(applicationContext);
                            t tVar = t.this;
                            tVar.a(applicationContext, tVar.m, 0);
                            t.b(t.this, context);
                            k.a(applicationContext).a();
                            com.anythink.core.common.a.o.a().b();
                            com.anythink.core.common.res.d.a(t.this.g()).b();
                            com.anythink.core.common.res.d.a(t.this.g());
                            com.anythink.core.common.res.d.c();
                            com.anythink.core.common.a.f.a();
                            ac.a().a(t.this.g());
                            com.anythink.core.common.v.g.a().a(t.this.g());
                        } catch (Exception unused3) {
                        }
                    }
                });
                a(new Runnable() { // from class: com.anythink.core.common.d.t.13
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.this.u();
                        t.e(applicationContext);
                    }
                });
                a(new Runnable() { // from class: com.anythink.core.common.d.t.14
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.anythink.core.common.o.a().a(t.this.l);
                    }
                });
                b.b().a(new h(c(this.l)));
                a(new Runnable() { // from class: com.anythink.core.common.d.t.15
                    @Override // java.lang.Runnable
                    public final void run() {
                        t.this.c();
                        if (t.this.C != null) {
                            t.this.C.initDeviceInfo(context);
                            t.this.C.cleanExpiredInfo();
                        }
                        com.anythink.core.d.n.a(applicationContext).a();
                        x.a(context);
                        com.anythink.core.common.d.a().a(context);
                        String strS = com.anythink.core.common.v.m.s(t.this.l);
                        if (TextUtils.isEmpty(strS)) {
                            return;
                        }
                        t.this.h(strS);
                    }
                });
                a(new Runnable() { // from class: com.anythink.core.common.d.t.16
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar = t.this;
                        t.a(tVar, tVar.l, t.this.p);
                    }
                });
                String str = this.m;
                a(context.getApplicationContext(), false);
                a(new AnonymousClass4(context, str));
            } catch (Exception e) {
                Log.e("SDK.init", "init failed: " + e.getMessage());
            }
            a(new Runnable() { // from class: com.anythink.core.common.d.t.17
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.common.t.a().b();
                }
            });
        }
    }

    private static void f(Context context) {
        if (b().c("ua")) {
            return;
        }
        try {
            if (v.a(context).b()) {
                String strJ = com.anythink.core.common.v.m.j();
                String strC = af.c(context, u.b.a, u.a.r, "");
                if (TextUtils.isEmpty(strJ) || !Build.VERSION.RELEASE.equals(strC)) {
                    com.anythink.core.common.v.m.q(context);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Runnable runnable) {
        com.anythink.core.common.v.b.b.a().b(runnable, 7);
    }

    private void g(Context context) {
        try {
            Class<?> cls = Class.forName("com.anythink.network.adx.AdxATInitManager");
            Object objInvoke = null;
            try {
                objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                Log.e("anythink", "Cannot instantiate " + cls.getName() + ", please check if SDK is imported");
            }
            if (objInvoke == null || !(objInvoke instanceof ATInitMediation)) {
                return;
            }
            ((ATInitMediation) objInvoke).initSDK(context, new HashMap(1), new AnonymousClass2());
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.t$2, reason: invalid class name */
    final class AnonymousClass2 implements MediationInitCallback {
        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
        }

        AnonymousClass2() {
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(String str) {
            if (ATCommonConfig.isShowInitErrorTips) {
                t.this.a(new Runnable() { // from class: com.anythink.core.common.d.t.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (t.this.l != null) {
                            Toast.makeText(t.this.l, "There is a problem with the integrated resources of AnyThink SDK, please check whether you have followed the steps of the integration document.", 1).show();
                        }
                    }
                }, 500L);
            }
        }
    }

    public static boolean c(Context context) {
        if (!ATSDKGlobalSetting.isDenyApi_getRunningAppProcesses() && context != null) {
            try {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        if (runningAppProcessInfo.importance == 100) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public final void b(int i) {
        this.h = i;
    }

    @Deprecated
    private void w(String str) {
        this.V = str;
    }

    public final boolean y() {
        return this.X;
    }

    public final void a(Context context, String str, ATDebuggerConfig aTDebuggerConfig) {
        s sVarC;
        if (context == null) {
            if (F()) {
                Log.e("SDK.init", "setDebuggerConfig fail, because context is null.");
                return;
            }
            return;
        }
        if (b().l == null) {
            b().a(context.getApplicationContext());
        }
        this.V = str;
        this.W = aTDebuggerConfig;
        String strD = com.anythink.core.common.v.m.d(context);
        boolean z = true;
        if (TextUtils.isEmpty(strD) || !strD.equals(this.V)) {
            String strF = com.anythink.core.common.v.m.f();
            if ((TextUtils.isEmpty(strF) || !strF.equals(this.V)) && ((sVarC = b().c()) == null || !sVarC.checkDebuggerDevice(context, this.V))) {
                z = false;
            }
        }
        this.X = z;
        if (TextUtils.isEmpty(this.V)) {
            if (F()) {
                Log.e("SDK.init", "Setting Debugger's device fail, because deviceId is empty.");
            }
            this.X = false;
        } else {
            if (this.X) {
                if (F()) {
                    Log.i("SDK.init", "Setting Debugger's device success.");
                }
                if (this.W == null || !F()) {
                    return;
                }
                Log.i("SDK.init", "Debugger config is in effect now.");
                return;
            }
            if (F()) {
                Log.e("SDK.init", "The incoming device id does not match the current device id, and the debugger mode cannot take effect.");
            }
        }
    }

    private boolean h(Context context) {
        String strD = com.anythink.core.common.v.m.d(context);
        if (!TextUtils.isEmpty(strD) && strD.equals(this.V)) {
            return true;
        }
        String strF = com.anythink.core.common.v.m.f();
        if (!TextUtils.isEmpty(strF) && strF.equals(this.V)) {
            return true;
        }
        s sVarC = b().c();
        return sVarC != null && sVarC.checkDebuggerDevice(context, this.V);
    }

    public final void h(String str) {
        if (TextUtils.isEmpty(this.V)) {
            return;
        }
        if (TextUtils.equals(str, this.V)) {
            this.X = true;
        }
        if (this.X && F()) {
            Log.i("SDK.init", "Update Setting Debugger's device success.");
        }
    }

    public final boolean z() {
        return this.X && this.W != null;
    }

    public final ATDebuggerConfig A() {
        return this.W;
    }

    private void i(Context context) {
        long jCurrentTimeMillis = this.e;
        try {
            String strC = af.c(b().l, u.b.a, b().p() + "playRecord", "");
            if (!TextUtils.isEmpty(strC)) {
                JSONObject jSONObject = new JSONObject(strC);
                long jOptLong = jSONObject.optLong("start_time");
                long jOptLong2 = jSONObject.optLong("end_time");
                String strOptString = jSONObject.optString(g.c);
                int iOptInt = jSONObject.optInt(g.d);
                if (jCurrentTimeMillis != 0) {
                    com.anythink.core.common.u.e.a(iOptInt == 1 ? 4 : 2, jOptLong, jOptLong2, strOptString);
                    long j = (jOptLong2 - jOptLong) / 1000;
                } else {
                    try {
                        long j2 = (jOptLong2 - jOptLong) / 1000;
                        jCurrentTimeMillis = jOptLong;
                    } catch (Exception unused) {
                        jCurrentTimeMillis = jOptLong;
                        af.b(b().l, u.b.a, b().p() + "playRecord", "");
                    }
                }
                af.b(b().l, u.b.a, b().p() + "playRecord", "");
            }
        } catch (Exception unused2) {
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = af.b(context, u.b.a, u.a.u, 0L);
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        b.b().a(new g(jCurrentTimeMillis));
    }

    private void ac() {
        try {
            BroadcastReceiver broadcastReceiver = this.y;
            if (broadcastReceiver != null) {
                this.l.unregisterReceiver(broadcastReceiver);
                n.a(this.l).a(this.y);
            }
            this.y = null;
        } catch (Throwable unused) {
        }
        try {
            this.y = new AnonymousClass3();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(j.v);
            this.l.registerReceiver(this.y, intentFilter);
            n.a(this.l).a(this.y, intentFilter);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.t$3, reason: invalid class name */
    final class AnonymousClass3 extends BroadcastReceiver {
        AnonymousClass3() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context context, final Intent intent) {
            t.a(new Runnable() { // from class: com.anythink.core.common.d.t.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.anythink.core.common.v.q.a(context)) {
                        com.anythink.core.common.t.a().b();
                        com.anythink.core.common.s.a().b();
                    }
                    com.anythink.core.common.u.d.a().b();
                    t.this.a(context, false);
                    if (TextUtils.equals(intent.getAction(), j.v)) {
                        com.anythink.core.common.u.e.b(intent.getStringExtra(j.w));
                    }
                }
            });
            try {
                if (t.this.C != null) {
                    t.this.C.resetSSID();
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected final synchronized long a(Context context, String str, int i) {
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(context).b(str);
        String strC = af.c(context, u.b.a, u.a.s, "");
        String strC2 = af.c(context, u.b.a, u.a.t, "");
        long jB = af.b(context, u.b.a, u.a.u, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - jB < 0) {
            jB = 0;
        }
        if (jCurrentTimeMillis - jB <= (i == 0 ? bVarB.ac() : bVarB.M())) {
            bVarB.ac();
            this.v = strC;
            if (!TextUtils.isEmpty(strC2)) {
                synchronized (this.x) {
                    this.w = new JSONObject(strC2);
                }
            }
            return 0L;
        }
        bVarB.ac();
        String strB = B();
        String strValueOf = "";
        if (TextUtils.isEmpty(strB)) {
            strB = com.anythink.core.common.v.m.d(context) + com.anythink.core.common.v.m.f();
            strValueOf = String.valueOf(new Random().nextInt(10000000));
        }
        this.v = com.anythink.core.common.v.o.a(strB + str + strValueOf + jCurrentTimeMillis);
        synchronized (this.x) {
            this.w = new JSONObject();
        }
        af.b(context, u.b.a, u.a.s, this.v);
        af.b(context, u.b.a, u.a.t, "");
        af.a(context, u.b.a, u.a.u, jCurrentTimeMillis);
        com.anythink.core.common.u.e.a((String) null, "1", strValueOf, String.valueOf(jCurrentTimeMillis));
        if (i == 0) {
            this.e = jCurrentTimeMillis;
        }
        return jCurrentTimeMillis;
        throw th;
    }

    private String x(String str) {
        synchronized (this.x) {
            String strOptString = this.w.optString(str);
            if (!TextUtils.isEmpty(strOptString)) {
                return strOptString;
            }
            String strB = B();
            String string = "";
            if (TextUtils.isEmpty(strB)) {
                strB = com.anythink.core.common.v.m.d(this.l) + com.anythink.core.common.v.m.f();
                string = new StringBuilder().append(new Random().nextInt(10000000)).toString();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strA = com.anythink.core.common.v.o.a(strB + str + string + jCurrentTimeMillis);
            try {
                this.w.put(str, strA);
            } catch (Exception unused) {
            }
            af.b(this.l, u.b.a, u.a.t, this.w.toString());
            if (!TextUtils.isEmpty(B())) {
                string = null;
            }
            com.anythink.core.common.u.e.a(str, "2", string, String.valueOf(jCurrentTimeMillis));
            return strA;
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.t$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        AnonymousClass4(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.a.getApplicationContext()).b(this.b);
            if (bVarB != null) {
                if (!bVarB.R()) {
                    com.anythink.core.common.q.a(t.this.l).a(bVarB);
                    com.anythink.core.common.c.b.a().a(bVarB.u(), bVarB.aC(), bVarB.aD(), bVarB.aI());
                    com.anythink.core.common.c.a().b(bVarB.j());
                    com.anythink.core.a.b.a(this.a.getApplicationContext()).a(bVarB.aH());
                    t.b().H();
                    t.b().a(bVarB);
                    com.anythink.core.common.v.e.a().a(bVarB.g());
                    com.anythink.core.common.b.a.a().a(bVarB);
                }
                w.a().a(bVarB.h());
                if (!com.anythink.core.d.d.a(this.a.getApplicationContext()).a(this.b)) {
                    com.anythink.core.d.d.a(this.a.getApplicationContext());
                }
                com.anythink.core.common.o.e.a().a(bVarB);
            }
        }
    }

    private void b(Context context, String str) {
        a(context.getApplicationContext(), false);
        a(new AnonymousClass4(context, str));
    }

    public final void d(final Context context) {
        if (F()) {
            com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.d.t.5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    boolean zU;
                    AnonymousClass5 anonymousClass5 = this;
                    int i = 0;
                    if (1 == 0) {
                        try {
                            Log.e("anythink", "Missing: LocalBroadcastManager");
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    try {
                        if (!com.anythink.core.common.v.q.a()) {
                            Log.e("anythink", "isCleartextTrafficPermitted=false, please check whether the \"android:networkSecurityConfig\" configuration in the AndroidManifest.xml of the application module is correct");
                        }
                    } catch (Throwable unused2) {
                    }
                    ArrayList arrayList = new ArrayList();
                    Enumeration<String> enumerationEntries = new DexFile(context.getPackageCodePath()).entries();
                    while (enumerationEntries.hasMoreElements()) {
                        String strNextElement = enumerationEntries.nextElement();
                        if (strNextElement.contains("com.anythink.network") && strNextElement.contains("InitManager") && !strNextElement.contains("$")) {
                            arrayList.add(strNextElement);
                        }
                    }
                    Log.i("anythink", "********************************** Network Integration Status *************************************");
                    if (arrayList.size() != 0) {
                        Log.i("anythink", "----------------------------------------");
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            Class<?> cls = Class.forName((String) it.next());
                            Object objInvoke = null;
                            try {
                                objInvoke = cls.getDeclaredMethod("getInstance", new Class[i]).invoke(null, new Object[i]);
                            } catch (Throwable unused3) {
                                Log.e("anythink", "Cannot instantiate " + cls.getName() + ", please check if a third-party SDK is imported");
                                Log.i("anythink", "----------------------------------------");
                            }
                            if (objInvoke != null && (objInvoke instanceof ATInitMediation)) {
                                ATInitMediation aTInitMediation = (ATInitMediation) objInvoke;
                                String networkName = aTInitMediation.getNetworkName();
                                if (!TextUtils.isEmpty(networkName)) {
                                    String networkVersion = aTInitMediation.getNetworkVersion();
                                    if (!TextUtils.isEmpty(networkVersion)) {
                                        Log.i("anythink", "NetworkName: " + networkName + "  (v" + networkVersion + ")");
                                    } else {
                                        Log.i("anythink", "NetworkName: ".concat(String.valueOf(networkName)));
                                    }
                                    boolean zI = t.i(aTInitMediation.getNetworkSDKClass());
                                    boolean zB = t.b(aTInitMediation.getPluginClassStatus());
                                    boolean zA = t.a(context, (List<String>) aTInitMediation.getActivityStatus());
                                    boolean zB2 = t.b(context, (List<String>) aTInitMediation.getServiceStatus());
                                    boolean zC = t.c(context, (List<String>) aTInitMediation.getProviderStatus());
                                    boolean zD = t.d(context, (List<String>) aTInitMediation.getMetaValutStatus());
                                    boolean zE = t.e(context, aTInitMediation.getPermissionStatus());
                                    String strA = t.this.a(context, aTInitMediation.getResourceStatus(), aTInitMediation.getDevBundleName());
                                    boolean zIsEmpty = TextUtils.isEmpty(strA);
                                    if (zIsEmpty) {
                                        Log.i("anythink", "Resource: VERIFIED");
                                    } else {
                                        Log.e("anythink", "Resource: The " + strA + " resources are missing. If shrinkResources is enabled, the " + strA + " resources must be added to the whitelist (keep.xml)");
                                    }
                                    try {
                                        zU = aTInitMediation.needCheckAdapterVersion() ? t.u(aTInitMediation.getAdapterVersion()) : true;
                                    } catch (Throwable unused4) {
                                    }
                                    if (zI && zB && zA && zB2 && zC && zD && zE && zIsEmpty && zU) {
                                        Log.i("anythink", "Status: Success");
                                    } else {
                                        Log.e("anythink", "Status: Fail");
                                    }
                                    Log.i("anythink", "----------------------------------------");
                                }
                            }
                        } catch (Throwable unused5) {
                        }
                        anonymousClass5 = this;
                        i = 0;
                    }
                    Log.i("anythink", "********************************** Network Integration Status *************************************");
                }
            }, 2);
        }
    }

    static boolean i(String str) {
        try {
            Class.forName(str);
            Log.i("anythink", "SDK: VERIFIED");
            return true;
        } catch (Throwable unused) {
            Log.i("anythink", "SDK: NOT VERIFIED");
            return false;
        }
    }

    static boolean b(Map<String, Boolean> map) {
        boolean z = true;
        if (map == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (!map.get(str).booleanValue()) {
                sb.append(", ").append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i("anythink", "Dependence Plugin: VERIFIED");
        } else {
            Log.e("anythink", "Dependence Plugin: Missing ".concat(String.valueOf(sb)));
        }
        return z;
    }

    static boolean a(Context context, List<String> list) {
        boolean z = true;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            try {
                if (context.getPackageManager().queryIntentActivities(new Intent(context, Class.forName(str)), 131072).size() <= 0) {
                    sb.append(", ").append(str);
                    z = false;
                }
            } catch (Throwable th) {
                sb.append(", error: ").append(th.getMessage());
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i("anythink", "Activities : VERIFIED");
        } else {
            Log.e("anythink", "Activities : Missing " + sb.toString() + " declare in AndroidManifest");
        }
        return z;
    }

    static boolean b(Context context, List<String> list) {
        boolean z = true;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        PackageManager packageManager = context.getPackageManager();
        for (String str : list) {
            try {
                if (packageManager.queryIntentServices(new Intent(context, Class.forName(str)), 131072).size() <= 0) {
                    sb.append(", ").append(str);
                    z = false;
                }
            } catch (Throwable th) {
                sb.append(", error: ").append(th.getMessage());
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i("anythink", "Services : VERIFIED");
        } else {
            Log.e("anythink", "Services : Missing " + sb.toString() + " declare in AndroidManifest");
        }
        return z;
    }

    static boolean c(Context context, List<String> list) {
        PackageInfo packageInfo;
        boolean z;
        boolean z2;
        if (list == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 8);
            z = true;
        } catch (Throwable th) {
            sb.append(", error: ").append(th.getMessage());
            packageInfo = null;
            z = false;
        }
        if (packageInfo == null) {
            return false;
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        for (String str : list) {
            int length = providerInfoArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = false;
                    break;
                }
                if (TextUtils.equals(providerInfoArr[i].name, str)) {
                    z2 = true;
                    break;
                }
                i++;
            }
            if (!z2) {
                sb.append(", ").append(str);
                z = false;
            }
        }
        if (sb.length() > 2) {
            sb.delete(0, 2);
        }
        if (z) {
            Log.i("anythink", "Providers : VERIFIED");
        } else {
            Log.e("anythink", "Providers : Missing " + sb.toString() + " declare in AndroidManifest");
        }
        return z;
    }

    static boolean d(Context context, List<String> list) {
        boolean z = true;
        if (list == null || list.size() == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String str = list.get(i);
                if (TextUtils.isEmpty(applicationInfo.metaData.getString(str))) {
                    sb.append(", \"").append(str).append("\"");
                    z = false;
                }
            }
            if (sb.length() > 2) {
                sb.delete(0, 2);
            }
            z2 = z;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (z2) {
            Log.i("anythink", "meta-data: VERIFIED");
        } else {
            Log.e("anythink", "meta-data: Missing " + sb.toString() + " declare in AndroidManifest");
        }
        return z2;
    }

    static boolean e(Context context, List<String> list) {
        int size;
        boolean z;
        if (list == null || (size = list.size()) == 0) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                boolean z3 = true;
                for (int i = 0; i < size; i++) {
                    String str = list.get(i);
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = false;
                            break;
                        }
                        if (TextUtils.equals(str, strArr[i2])) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z) {
                        if (sb.length() == 0) {
                            sb.append(str);
                        } else {
                            sb.append(", ").append(str);
                        }
                        z3 = false;
                    }
                }
                z2 = z3;
            } else {
                for (int i3 = 0; i3 < size; i3++) {
                    String str2 = list.get(i3);
                    if (i3 == 0) {
                        sb.append(str2);
                    } else {
                        sb.append(", ").append(str2);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (z2) {
            Log.i("anythink", "Permission: VERIFIED");
        } else {
            Log.e("anythink", "Permission: Missing " + sb.toString() + " declare in AndroidManifest");
        }
        return z2;
    }

    private boolean b(Context context, List<String> list, String str) {
        String strA = a(context, list, str);
        boolean zIsEmpty = TextUtils.isEmpty(strA);
        if (zIsEmpty) {
            Log.i("anythink", "Resource: VERIFIED");
        } else {
            Log.e("anythink", "Resource: The " + strA + " resources are missing. If shrinkResources is enabled, the " + strA + " resources must be added to the whitelist (keep.xml)");
        }
        return zIsEmpty;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:61:0x00c5 A[RETURN] */
    public final String a(Context context, List<String> list, String str) {
        String str2;
        if (list == null || list.size() == 0) {
            return "";
        }
        boolean z = false;
        try {
            int size = list.size();
            str2 = "";
            boolean z2 = true;
            for (int i = 0; i < size; i++) {
                try {
                    String str3 = list.get(i);
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = str3.split("_")[0] + "_*";
                        }
                        int identifier = !TextUtils.isEmpty(str) ? context.getResources().getIdentifier(str3, "layout", str) : -1;
                        if (identifier <= 0 && !TextUtils.isEmpty(this.ah)) {
                            identifier = context.getResources().getIdentifier(str3, "layout", this.ah);
                        }
                        if (identifier <= 0) {
                            identifier = context.getResources().getIdentifier(str3, "layout", context.getPackageName());
                        }
                        if (identifier <= 0) {
                            if (z) {
                                return "";
                            }
                            return str2;
                        }
                        XmlResourceParser layout = null;
                        try {
                            layout = context.getResources().getLayout(identifier);
                            while (true) {
                                int next = layout.next();
                                if (next == 1) {
                                    break;
                                }
                                if (next == 2) {
                                    if ("x".equalsIgnoreCase(layout.getName())) {
                                        if (layout.getAttributeCount() == 0) {
                                            z2 = false;
                                            break;
                                        }
                                    } else if (layout.getAttributeCount() >= 0) {
                                        break;
                                    }
                                }
                            }
                            if (layout != null) {
                                layout.close();
                            }
                        } catch (Throwable th) {
                            try {
                                th.printStackTrace();
                                if (layout != null) {
                                }
                            } catch (Throwable th2) {
                                if (layout != null) {
                                    layout.close();
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                }
            }
            z = z2;
        } catch (Throwable th4) {
            th = th4;
            str2 = "";
        }
        if (z) {
            return "";
        }
        return str2;
    }

    private static boolean y(String str) {
        String strA = com.anythink.core.common.v.p.a();
        boolean z = !TextUtils.isEmpty(str) && str.startsWith(strA);
        if (!z) {
            Log.e("anythink", String.format("Adapter Version: The current Adapter version(%s) does not apply to the SDK version(%s).", str, strA));
        } else {
            Log.i("anythink", "Adapter Version: VERIFIED");
        }
        return z;
    }

    private void j(Context context) {
        a(context, false);
    }

    public final void a(final Context context, boolean z) {
        Runnable runnable = new Runnable() { // from class: com.anythink.core.common.d.t.6
            @Override // java.lang.Runnable
            public final void run() {
                s sVarC;
                if (com.anythink.core.d.d.a(context).a(t.this.m)) {
                    com.anythink.core.d.d.a(context).a(t.this.m, t.this.n);
                }
                com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(context).b(t.this.m);
                if (bVarB == null || (sVarC = t.b().c()) == null) {
                    return;
                }
                sVarC.startRefreshes(bVarB.a());
            }
        };
        if (z) {
            com.anythink.core.common.v.b.b.a().b(runnable, 2);
        } else {
            com.anythink.core.common.v.b.b.a().c(runnable, 13);
        }
    }

    public final void b(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.o.post(runnable);
        }
    }

    public static void c(Runnable runnable) {
        com.anythink.core.common.v.b.b.a().b(runnable, 2);
    }

    public final void a(Runnable runnable, long j) {
        if (j <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.o.postDelayed(runnable, j);
        }
    }

    public final void d(Runnable runnable) {
        this.o.removeCallbacks(runnable);
    }

    public static void b(Runnable runnable, long j) {
        com.anythink.core.common.v.b.b.a().a(runnable, j);
    }

    public final String B() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = af.c(this.l, u.b.a, u.a.v, "");
        }
        return this.z;
    }

    public final String C() {
        if (TextUtils.isEmpty(this.A)) {
            this.A = af.c(this.l, u.b.f, u.a.y, "");
        }
        return this.A;
    }

    public final String D() {
        if (TextUtils.isEmpty(this.B)) {
            this.B = af.c(this.l, u.b.f, u.a.z, "");
        }
        return this.B;
    }

    public final void j(String str) {
        this.A = str;
        af.b(this.l, u.b.f, u.a.y, str);
    }

    public final void k(String str) {
        this.B = str;
        af.b(this.l, u.b.f, u.a.z, str);
    }

    public final void l(String str) {
        af.b(this.l, u.b.a, u.a.v, str);
        this.z = str;
    }

    public final void b(boolean z) {
        this.F = z;
    }

    public final void c(int i) {
        this.an = i;
    }

    public final int E() {
        return this.an;
    }

    private void ad() {
        Throwable th;
        boolean zExists;
        boolean z = false;
        if (this.l != null) {
            try {
                zExists = new File(this.l.getExternalFilesDir(null), this.D).exists();
                if (!zExists) {
                    try {
                        zExists = new File(this.l.getFilesDir(), this.D).exists();
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zExists = false;
            }
            z = zExists;
        }
        this.E = z;
    }

    public final boolean F() {
        return this.E || this.F;
    }

    private static long a(long j) {
        Date date = new Date(j);
        return new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
    }

    public static com.anythink.core.common.k.e G() {
        return new com.anythink.core.common.q.e();
    }

    public final void c(boolean z) {
        this.K = z;
    }

    private boolean ae() {
        return this.K;
    }

    public final void a(String str, List<String> list) {
        if (F()) {
            Log.i("anythink", String.format("setFilterAdSourceIdList, placementId=%s, adSourceIdList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (list == null) {
            this.U.remove(str);
        } else {
            this.U.put(str, list);
        }
    }

    public final List<String> m(String str) {
        return this.U.get(str);
    }

    public final void b(String str, List<String> list) {
        if (F()) {
            Log.i("anythink", String.format("setFilterNetworkFirmIdList, placementId=%s, networkFilmIdList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (list == null) {
            this.U.remove(str + "_network_firm");
        } else {
            this.U.put(str + "_network_firm", list);
        }
    }

    public final List<String> n(String str) {
        return this.U.get(str + "_network_firm");
    }

    public final void c(String str, List<String> list) {
        if (F()) {
            Log.i("anythink", String.format("setAllowedShowNetworkFimIdList, placementId=%s, allowShowList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.U.remove(str + "_network_firm_f_s");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.U.remove(str + "_network_firm_a_s");
        } else {
            this.U.put(str + "_network_firm_a_s", arrayList);
        }
    }

    public final List<String> o(String str) {
        return this.U.get(str + "_network_firm_a_s");
    }

    public final void d(String str, List<String> list) {
        if (F()) {
            Log.i("anythink", String.format("setForbidShowNetworkFirmIdList, placementId=%s, ForbidShowList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.U.remove(str + "_network_firm_a_s");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.U.remove(str + "_network_firm_f_s");
        } else {
            this.U.put(str + "_network_firm_f_s", arrayList);
        }
    }

    public final List<String> p(String str) {
        return this.U.get(str + "_network_firm_f_s");
    }

    public final void a(int i, List<String> list) {
        if (F()) {
            Log.i("anythink", String.format("setForbidShowNetworkFirmIdList, risk=%s, ForbidList=%s", Integer.valueOf(i), list));
        }
        this.ao = new Pair<>(Integer.valueOf(i), list);
        H();
    }

    public final void a(IATDeviceRiskListener iATDeviceRiskListener) {
        this.f = iATDeviceRiskListener;
    }

    public final void a(com.anythink.core.d.b bVar) {
        if (bVar != null) {
            try {
                if (F()) {
                    Log.e("anythink", "notifyDeviceRisk:" + this.f);
                }
                if (this.f != null) {
                    JSONObject jSONObject = new JSONObject();
                    String strB = B();
                    if (!TextUtils.isEmpty(strB)) {
                        jSONObject.put("device_upid", strB);
                    }
                    String strF = bVar.f();
                    if (!TextUtils.isEmpty(strF)) {
                        jSONObject.put("device_risk_labels", strF);
                    }
                    this.f.onDeviceRiskInfo(jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void H() {
        com.anythink.core.common.h.n nVar;
        try {
            if (this.ao != null) {
                if (this.l != null && !TextUtils.isEmpty(this.m)) {
                    com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.l).b(this.m);
                    if (bVarB != null) {
                        if (bVarB.e() == 1) {
                            Pair<Boolean, com.anythink.core.common.h.n> pair = this.ap;
                            if (pair != null && !((Boolean) pair.first).booleanValue()) {
                                nVar = (com.anythink.core.common.h.n) this.ap.second;
                                this.ap = null;
                            } else {
                                nVar = new com.anythink.core.common.h.n();
                                nVar.N(((Integer) this.ao.first).intValue());
                                if (this.ao.second != null) {
                                    nVar.y(((List) this.ao.second).toString());
                                }
                            }
                            com.anythink.core.common.u.c.a(b().l).a(27, nVar);
                            return;
                        }
                        return;
                    }
                    com.anythink.core.common.h.n nVar2 = new com.anythink.core.common.h.n();
                    nVar2.N(((Integer) this.ao.first).intValue());
                    if (this.ao.second != null) {
                        nVar2.y(((List) this.ao.second).toString());
                    }
                    this.ap = new Pair<>(Boolean.FALSE, nVar2);
                    return;
                }
                com.anythink.core.common.h.n nVar3 = new com.anythink.core.common.h.n();
                nVar3.N(((Integer) this.ao.first).intValue());
                if (this.ao.second != null) {
                    nVar3.y(((List) this.ao.second).toString());
                }
                this.ap = new Pair<>(Boolean.FALSE, nVar3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Pair<Integer, List<String>> I() {
        return this.ao;
    }

    public final void b(List<String> list) {
        if (F()) {
            Log.i("anythink", String.format("setForbidNetworkFirmIdList, ForbidList=%s", list));
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.U.remove("forbid_network_firm_list");
        } else {
            this.U.put("forbid_network_firm_list", arrayList);
        }
    }

    public final List<String> J() {
        return this.U.get("forbid_network_firm_list");
    }

    public static boolean a(List<String> list, String str) {
        return list != null && list.contains(str);
    }

    private void f(boolean z) {
        this.Z = z;
    }

    public final boolean K() {
        return this.Z;
    }

    public final void d(boolean z) {
        this.aa = z;
    }

    public final boolean L() {
        return this.aa;
    }

    public final void a(final Context context, final DeviceInfoCallback deviceInfoCallback) {
        if (!F()) {
            String strConcat = "Before call \"ATSDK.testModeDeviceInfo()\", you must to call \"ATSDK.setNetworkLogDebug(true);\" first. ".concat("Note: The call to the \"ATSDK.testModeDeviceInfo()\" method must be removed after the test is completed!!!");
            Log.e("anythink", strConcat);
            if (deviceInfoCallback != null) {
                deviceInfoCallback.deviceInfo(strConcat);
                return;
            }
            return;
        }
        Log.e("anythink", "Note: The call to the \"ATSDK.testModeDeviceInfo()\" method must be removed after the test is completed!!!");
        if (!this.d) {
            Log.e("anythink", "You should init SDK first.");
            if (deviceInfoCallback != null) {
                deviceInfoCallback.deviceInfo("You should init SDK first.");
                return;
            }
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.d.t.7
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(context).b(t.b().p());
                String strQ = bVarB != null ? bVarB.Q() : "";
                boolean z = true;
                if (!TextUtils.isEmpty(strQ)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strQ);
                        if (!jSONObject.isNull("a") && jSONObject.optInt("a") != 1) {
                            z = false;
                        }
                    } catch (Exception unused) {
                    }
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    s sVarC = t.b().c();
                    if (sVarC != null) {
                        sVarC.fillTestDeviceData(jSONObject2, bVarB);
                    }
                    jSONObject2.put("GAID", com.anythink.core.common.v.m.s(context));
                    jSONObject2.put("AndroidID", z ? com.anythink.core.common.v.m.d(context) : "");
                    jSONObject2.put("How to config TestMode", "Please visit the document center and learn more through: Integration(Basic) -> How To Test");
                    ab.a("testModeDeviceInfo", jSONObject2.toString());
                    DeviceInfoCallback deviceInfoCallback2 = deviceInfoCallback;
                    if (deviceInfoCallback2 != null) {
                        deviceInfoCallback2.deviceInfo(jSONObject2.toString());
                    }
                } catch (Throwable unused2) {
                }
            }
        }, 2);
    }

    private static void z(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("anythink", "AdSourceId is empty");
            return;
        }
        try {
            if (Long.parseLong(str) == 0) {
                Log.e("anythink", "AdSourceId can't set 0");
            }
        } catch (Exception unused) {
            Log.e("anythink", "AdSourceId '" + str + "' is not compliant");
        }
    }

    public final void a(final String str, final String str2, final String str3, final Map<String, Object> map) {
        if (!this.d) {
            Log.e("SDK.init", "SDK should be inited first!");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("SDK.init", "Please put placementId!");
            return;
        }
        final com.anythink.core.common.f fVarA = com.anythink.core.common.u.a().a(str, str3);
        if (fVarA == null) {
            Log.e("SDK.init", "The \"" + str + "\" object has not been created yet!");
            return;
        }
        final boolean zG = fVarA.g();
        ae aeVar = new ae();
        aeVar.a(map);
        aeVar.a(fVarA.i());
        final com.anythink.core.common.h.c cVarB = fVarA.b(this.l, false, false, aeVar);
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.d.t.8
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.d.l lVarA = com.anythink.core.d.n.a(t.this.l).a(str);
                String strH = fVarA.h();
                String strD = com.anythink.core.common.v.p.d(str2);
                com.anythink.core.common.h.c cVar = cVarB;
                if (cVar != null) {
                    com.anythink.core.common.h.n nVarAf = cVar.i().af();
                    nVarAf.k(1);
                    nVarAf.F = strD;
                    if (w.a().a(lVarA)) {
                        aj.a(str, lVarA, nVarAf);
                    }
                    com.anythink.core.common.u.c.a(t.this.l).a(16, nVarAf);
                    return;
                }
                if (TextUtils.isEmpty(strH)) {
                    strH = "";
                }
                com.anythink.core.common.h.n nVarA = aj.a(strH, str, lVarA, 0, 0, map, null, 0, fVarA.i());
                nVarA.k(zG ? 3 : 2);
                if (lVarA == null) {
                    nVarA.K(str3);
                }
                nVarA.F = strD;
                if (w.a().a(lVarA)) {
                    aj.a(str, lVarA, nVarA);
                }
                com.anythink.core.common.u.c.a(t.this.l).a(16, nVarA);
            }
        }, 2);
    }

    public final void a(Activity activity) {
        WeakReference<Activity> weakReference = this.g;
        if (weakReference == null || weakReference.get() == null) {
            this.g = new WeakReference<>(activity);
        }
    }

    public final Context M() {
        WeakReference<Activity> weakReference = this.g;
        if (weakReference != null && weakReference.get() != null) {
            return this.g.get();
        }
        return this.l;
    }

    public final Activity N() {
        WeakReference<Activity> weakReference = this.g;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.g.get();
    }

    private void a(Context context, ATNetworkConfig aTNetworkConfig) {
        if (aTNetworkConfig == null) {
            aTNetworkConfig = new ATNetworkConfig();
        }
        List<ATInitConfig> aTInitConfigList = aTNetworkConfig.getATInitConfigList();
        if (aTInitConfigList == null) {
            aTInitConfigList = new ArrayList<>(2);
        }
        try {
            if (z()) {
                aTInitConfigList.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            aTInitConfigList = new ArrayList<>(2);
        }
        ATInitConfig aTInitConfig = null;
        boolean z = false;
        if (Build.VERSION.SDK_INT != 29 && !a(b().J(), "1")) {
            try {
                Constructor declaredConstructor = Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(ATInitConfig.class).getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                ATInitConfig aTInitConfig2 = (ATInitConfig) declaredConstructor.newInstance(new Object[0]);
                try {
                    aTInitConfigList.add(0, aTInitConfig2);
                } catch (Throwable unused) {
                }
                aTInitConfig = aTInitConfig2;
            } catch (Throwable unused2) {
            }
        }
        this.M = aTInitConfigList.size() > 0;
        for (ATInitConfig aTInitConfig3 : aTInitConfigList) {
            if (aTInitConfig3 != null) {
                if (aTInitConfig != null && TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                    if (!z) {
                        z = true;
                    }
                }
                a(new AnonymousClass9(aTInitConfig3, context));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.t$9, reason: invalid class name */
    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ ATInitConfig a;
        final /* synthetic */ Context b;

        AnonymousClass9(ATInitConfig aTInitConfig, Context context) {
            this.a = aTInitConfig;
            this.b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Map<String, Object> requestParamMap;
            boolean zC;
            boolean zD;
            try {
                ATInitMediation initMediation = this.a.getInitMediation();
                if (initMediation != null) {
                    String networkName = initMediation.getNetworkName();
                    String strC = af.c(t.this.l, u.b.g, networkName, "");
                    if (!TextUtils.isEmpty(strC)) {
                        requestParamMap = com.anythink.core.common.v.q.c(strC);
                    } else {
                        requestParamMap = this.a.getRequestParamMap();
                        requestParamMap.put(ATInitMediation.KEY_LOCAL, Boolean.TRUE);
                    }
                    boolean z = false;
                    try {
                        zC = v.a(this.b).c();
                        try {
                            zD = v.a(this.b).d();
                            try {
                                initMediation.setUserDataConsent(this.b, zC, zD);
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            zD = false;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        zC = false;
                        zD = false;
                    }
                    com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.b).b(t.this.m);
                    requestParamMap.put(j.w.d, Boolean.valueOf(bVarB.A() == 3));
                    boolean zB = com.anythink.core.common.v.p.b();
                    if (bVarB.B() == 2 && zB) {
                        z = true;
                    }
                    requestParamMap.put(j.w.e, Boolean.valueOf(z));
                    if (t.b().F()) {
                        Log.i("anythink", "pre init network: [" + networkName + "], params: " + new JSONObject(requestParamMap).toString() + ", gdpr: " + zC + ", in eu: " + zD);
                    }
                    initMediation.initSDK(t.this.l, requestParamMap, null);
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
    }

    public final void a(String str, Map<String, Object> map, String... strArr) {
        com.anythink.core.common.h.n nVar;
        if (map == null || map.containsKey(ATInitMediation.KEY_LOCAL)) {
            return;
        }
        try {
            nVar = (com.anythink.core.common.h.n) map.get(j.w.i);
        } catch (Throwable unused) {
            nVar = null;
        }
        map.remove(j.w.i);
        String string = new JSONObject(map).toString();
        Log.e("anythink", "Mismatched initialization parameters! server params: [" + str + "], " + string);
        af.b(this.l, u.b.g, str, string);
        if (nVar == null || strArr == null) {
            return;
        }
        try {
            com.anythink.core.common.u.e.a(nVar, strArr[0], strArr.length > 1 ? strArr[1] : null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String[] strArr, IATAdFilter iATAdFilter) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap = this.ab;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if (this.ab == null) {
            this.ab = new ConcurrentHashMap<>();
        }
        for (String str : strArr) {
            this.ab.put(str, iATAdFilter);
        }
    }

    public final IATAdFilter q(String str) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.ab) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final String O() {
        return this.ac;
    }

    public final void r(String str) {
        this.ac = str;
    }

    public final boolean P() {
        return this.M;
    }

    public final void a(ATUserDeviceInfo aTUserDeviceInfo) {
        this.ad = aTUserDeviceInfo;
    }

    public final ATUserDeviceInfo Q() {
        return this.ad;
    }

    public final by R() {
        if (this.ae == null) {
            this.ae = new by();
        }
        try {
            this.ae.a(com.anythink.core.common.v.m.t(b().l));
            this.ae.b(com.anythink.core.common.v.m.m());
            this.ae.c(com.anythink.core.common.v.m.o());
            this.ae.d(com.anythink.core.common.v.m.c(com.anythink.core.common.v.m.n()));
        } catch (Throwable unused) {
        }
        return this.ae;
    }

    public final long d(int i) {
        if (i != 1 && i != 4 && i != 5) {
            return 26214400L;
        }
        com.anythink.core.d.d.a(this.l);
        return com.anythink.core.d.d.b() * 1024;
    }

    public final void S() {
        this.af = System.currentTimeMillis();
    }

    private long af() {
        return this.af;
    }

    public final void T() {
        Context context = this.l;
        if (context == null || this.N) {
            return;
        }
        synchronized (this.O) {
            if (!this.N) {
                long jB = af.b(context, u.b.a, u.a.x, 0L);
                this.G = jB;
                if (jB == 0) {
                    long j = this.aj;
                    this.G = j;
                    af.a(context, u.b.a, u.a.x, j);
                }
                this.H = ((a(this.aj) - a(this.G)) / 86400000) + 1;
                com.anythink.core.common.g.c.a().a(context);
                this.N = true;
            }
        }
    }

    private static void k(Context context) {
        com.anythink.core.common.g.c.a().a(context);
    }

    private void l(Context context) {
        long jB = af.b(context, u.b.a, u.a.x, 0L);
        this.G = jB;
        if (jB == 0) {
            long j = this.aj;
            this.G = j;
            af.a(context, u.b.a, u.a.x, j);
        }
        this.H = ((a(this.aj) - a(this.G)) / 86400000) + 1;
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e("SDK.init", "setPrePlacementStrategy failed: path is null or empty.");
        } else {
            com.anythink.core.d.n.a(context.getApplicationContext()).i(str);
            com.anythink.core.d.d.a(context.getApplicationContext()).c(str);
        }
    }

    public static void a(ATSharedPlacementConfig aTSharedPlacementConfig) {
        w.a().a(aTSharedPlacementConfig);
    }

    public final void s(String str) {
        if (F()) {
            Log.i("anythink", "setBundleName: ".concat(String.valueOf(str)));
        }
        this.ah = str;
    }

    public final String U() {
        return this.ah;
    }

    public final boolean V() {
        return this.d;
    }

    public final boolean W() {
        return this.ai;
    }

    public final void e(boolean z) {
        this.ai = z;
        try {
            synchronized (this.aq) {
                if (!this.aq.isEmpty()) {
                    for (m mVar : this.aq) {
                        if (mVar != null) {
                            mVar.a(z);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(m mVar) {
        if (mVar != null) {
            try {
                synchronized (this.aq) {
                    try {
                        if (!this.aq.contains(mVar)) {
                            this.aq.add(mVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void b(m mVar) {
        if (mVar != null) {
            try {
                synchronized (this.aq) {
                    this.aq.remove(mVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final com.anythink.core.common.m.c.i X() {
        if (this.al == null) {
            synchronized (ak) {
                if (this.al == null) {
                    this.al = new com.anythink.core.common.m.c.g(this.l);
                }
            }
        }
        return this.al;
    }

    public final long Y() {
        return this.aj;
    }

    public final Map<String, ATAdFilter> Z() {
        return this.ar;
    }

    public final void a(String str, ATAdFilter aTAdFilter) {
        if (TextUtils.isEmpty(str) || aTAdFilter == null) {
            return;
        }
        this.ar.put(str, aTAdFilter);
    }

    public final void aa() {
        this.ar.clear();
    }

    public final void t(String str) {
        if (TextUtils.isEmpty(str) || this.ar.isEmpty()) {
            return;
        }
        this.ar.remove(str);
    }

    public static void a(String str, String str2) {
        com.anythink.core.common.u.e.a("1", str, str2);
    }

    public final void a(Boolean bool) {
        if (bool != null) {
            synchronized (this.u) {
                if (!bool.booleanValue()) {
                    this.u.put("sensor_deny", Boolean.TRUE);
                } else {
                    this.u.remove("sensor_deny");
                }
            }
        }
    }

    public final void w() {
        if (!this.d) {
            Log.e("anythink", "Please exec ATSDK.init before ATSDK.start");
        } else {
            b(this.l);
        }
    }

    public final boolean x() {
        return c(this.l);
    }

    static /* synthetic */ void b(t tVar) {
        Throwable th;
        boolean zExists;
        boolean z = false;
        if (tVar.l != null) {
            try {
                zExists = new File(tVar.l.getExternalFilesDir(null), tVar.D).exists();
                if (!zExists) {
                    try {
                        zExists = new File(tVar.l.getFilesDir(), tVar.D).exists();
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                zExists = false;
            }
            z = zExists;
        }
        tVar.E = z;
    }

    static /* synthetic */ void a(t tVar, Context context) {
        try {
            Class<?> cls = Class.forName("com.anythink.network.adx.AdxATInitManager");
            Object objInvoke = null;
            try {
                objInvoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                Log.e("anythink", "Cannot instantiate " + cls.getName() + ", please check if SDK is imported");
            }
            if (objInvoke == null || !(objInvoke instanceof ATInitMediation)) {
                return;
            }
            ((ATInitMediation) objInvoke).initSDK(context, new HashMap(1), tVar.new AnonymousClass2());
        } catch (Throwable unused2) {
        }
    }

    static /* synthetic */ void c(t tVar) {
        if (tVar.am == -1) {
            long jB = af.b(tVar.l, u.b.a, u.a.I, 0L);
            tVar.am = jB;
            if (jB == 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                tVar.am = jCurrentTimeMillis;
                af.a(tVar.l, u.b.a, u.a.I, jCurrentTimeMillis);
            }
        }
    }

    static /* synthetic */ void b(t tVar, Context context) {
        long jCurrentTimeMillis = tVar.e;
        try {
            String strC = af.c(b().l, u.b.a, b().p() + "playRecord", "");
            if (!TextUtils.isEmpty(strC)) {
                JSONObject jSONObject = new JSONObject(strC);
                long jOptLong = jSONObject.optLong("start_time");
                long jOptLong2 = jSONObject.optLong("end_time");
                String strOptString = jSONObject.optString(g.c);
                int iOptInt = jSONObject.optInt(g.d);
                if (jCurrentTimeMillis != 0) {
                    com.anythink.core.common.u.e.a(iOptInt == 1 ? 4 : 2, jOptLong, jOptLong2, strOptString);
                    long j = (jOptLong2 - jOptLong) / 1000;
                } else {
                    try {
                        long j2 = (jOptLong2 - jOptLong) / 1000;
                        jCurrentTimeMillis = jOptLong;
                    } catch (Exception unused) {
                        jCurrentTimeMillis = jOptLong;
                        af.b(b().l, u.b.a, b().p() + "playRecord", "");
                    }
                }
                af.b(b().l, u.b.a, b().p() + "playRecord", "");
            }
        } catch (Exception unused2) {
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = af.b(context, u.b.a, u.a.u, 0L);
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        b.b().a(new g(jCurrentTimeMillis));
    }

    static /* synthetic */ void e(Context context) {
        if (b().c("ua")) {
            return;
        }
        try {
            if (v.a(context).b()) {
                String strJ = com.anythink.core.common.v.m.j();
                String strC = af.c(context, u.b.a, u.a.r, "");
                if (TextUtils.isEmpty(strJ) || !Build.VERSION.RELEASE.equals(strC)) {
                    com.anythink.core.common.v.m.q(context);
                }
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(t tVar, Context context, ATNetworkConfig aTNetworkConfig) {
        if (aTNetworkConfig == null) {
            aTNetworkConfig = new ATNetworkConfig();
        }
        List<ATInitConfig> aTInitConfigList = aTNetworkConfig.getATInitConfigList();
        if (aTInitConfigList == null) {
            aTInitConfigList = new ArrayList<>(2);
        }
        try {
            if (tVar.z()) {
                aTInitConfigList.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            aTInitConfigList = new ArrayList<>(2);
        }
        ATInitConfig aTInitConfig = null;
        boolean z = false;
        if (Build.VERSION.SDK_INT != 29 && !a(b().J(), "1")) {
            try {
                Constructor declaredConstructor = Class.forName("com.anythink.network.facebook.FacebookATInitConfig").asSubclass(ATInitConfig.class).getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                ATInitConfig aTInitConfig2 = (ATInitConfig) declaredConstructor.newInstance(new Object[0]);
                try {
                    aTInitConfigList.add(0, aTInitConfig2);
                } catch (Throwable unused) {
                }
                aTInitConfig = aTInitConfig2;
            } catch (Throwable unused2) {
            }
        }
        tVar.M = aTInitConfigList.size() > 0;
        for (ATInitConfig aTInitConfig3 : aTInitConfigList) {
            if (aTInitConfig3 != null) {
                if (aTInitConfig != null && TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                    if (!z) {
                        z = true;
                    }
                }
                a(tVar.new AnonymousClass9(aTInitConfig3, context));
            }
        }
    }

    static /* synthetic */ boolean u(String str) {
        String strA = com.anythink.core.common.v.p.a();
        boolean z = !TextUtils.isEmpty(str) && str.startsWith(strA);
        if (!z) {
            Log.e("anythink", String.format("Adapter Version: The current Adapter version(%s) does not apply to the SDK version(%s).", str, strA));
        } else {
            Log.i("anythink", "Adapter Version: VERIFIED");
        }
        return z;
    }
}
