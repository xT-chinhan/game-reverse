package com.anythink.core.common.d;

import android.app.Activity;
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
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdFilter;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATCommonConfig;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.api.ATDebuggerConfig;
import com.anythink.core.api.ATInitConfig;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATNetworkConfig;
import com.anythink.core.api.ATSDK;
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
import com.anythink.core.common.h.cb;
import com.anythink.core.common.u.aa;
import com.anythink.core.common.u.ad;
import com.anythink.core.common.u.af;
import com.anythink.core.common.u.ai;
import com.anythink.core.common.v;
import com.byazt.af.x;
import com.varbto.utils.api.MediationUtilsManager;
import com.varbto.utils.performance.DevicePerformanceGrader;
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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static final int a = 0;
    public static final int b = 1;
    public static final String n = "mmed_m_a_c";
    private static volatile s r;
    private volatile String B;
    private BroadcastReceiver E;
    private String F;
    private String G;
    private String H;
    private r I;
    private String O;
    private String P;
    private boolean R;
    private com.anythink.core.common.j.e X;
    private Location Y;
    private boolean aG;
    private volatile String aH;
    private volatile JSONObject aJ;
    private JSONArray aa;
    private List<String> ab;
    private String ad;
    private ATDebuggerConfig ae;
    private boolean af;
    private ConcurrentHashMap<String, IATAdFilter> aj;
    private ATUserDeviceInfo al;
    private cb am;
    private String ap;
    private boolean ar;
    private long as;
    private volatile com.anythink.core.common.l.d.i au;
    private com.anythink.core.common.e.b av;
    private String aw;
    private Pair<Integer, List<String>> ay;
    private Pair<Boolean, com.anythink.core.common.h.n> az;
    IATDeviceRiskListener g;
    WeakReference<Activity> h;
    private int o;
    private Context s;
    private String t;
    private String u;
    private ATNetworkConfig v;
    private String w;
    private ConcurrentHashMap<String, ATCustomAdapterConfig> z;
    private static final Object at = new Object();
    public static final String i = "anr_count";
    public static final String j = "dynamic_score";
    public static final String k = "total_score";
    public static final String l = "is_high_consumption";
    public static final String m = "anr_timestamps";
    private static final String[] aK = {i, j, k, l, m};
    private final String p = "SDK.init";
    private boolean q = false;
    private final Object D = new Object();
    private boolean K = false;
    private boolean L = false;
    private long M = 0;
    private long N = 0;
    private boolean S = false;
    private boolean T = false;
    private final Object U = new Object();
    private boolean V = false;
    private final Object W = new Object();
    private String Z = "";
    private int ag = 1;
    private boolean ah = false;
    private boolean ai = false;
    private String ak = "";
    private final Object ao = new Object();
    public volatile boolean c = false;
    boolean d = false;
    volatile long e = 0;
    volatile long f = 0;
    private int ax = -1;
    private final List<l> aA = new ArrayList();
    private final Map<String, ATAdFilter> aB = new HashMap();
    private final Map<String, ATAdFilter> aC = new HashMap();
    private int aD = -1;
    private int aE = -1;
    private int aF = -1;
    private volatile boolean aI = false;
    private ConcurrentHashMap<String, Map<String, Object>> y = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> x = new ConcurrentHashMap<>();
    private final String J = File.separator + "anythink.test";
    private boolean Q = true;
    private ConcurrentHashMap<String, List<String>> ac = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> C = new ConcurrentHashMap<>();
    private long an = System.currentTimeMillis();
    private final Map<String, Boolean> A = new ConcurrentHashMap(2);
    private long aq = System.currentTimeMillis();

    private static boolean ar() {
        return true;
    }

    private static boolean as() {
        return false;
    }

    private static int at() {
        return 100;
    }

    public final boolean a() {
        return this.R;
    }

    public static s b() {
        if (r == null) {
            synchronized (s.class) {
                if (r == null) {
                    r = new s();
                }
            }
        }
        return r;
    }

    public final r c() {
        IExHandler iExHandler;
        IDlHandler iDlHandler;
        IOdHandler iOdHandler;
        if (this.q) {
            return this.I;
        }
        synchronized (this.ao) {
            if (this.q) {
                return this.I;
            }
            IOsExHandler iOsExHandler = null;
            try {
                iExHandler = (IExHandler) a((Class<?>) IExHandler.class, i.g.b);
            } catch (Throwable unused) {
                iExHandler = null;
            }
            try {
                iDlHandler = (IDlHandler) a((Class<?>) IDlHandler.class, i.g.c);
            } catch (Throwable unused2) {
                iDlHandler = null;
            }
            try {
                iOdHandler = (IOdHandler) a((Class<?>) IOdHandler.class, i.g.d);
            } catch (Throwable unused3) {
                iOdHandler = null;
            }
            try {
                iOsExHandler = (IOsExHandler) a((Class<?>) IOsExHandler.class, "");
            } catch (Throwable unused4) {
            }
            if (iExHandler != null || iDlHandler != null || iOdHandler != null || iOsExHandler != null) {
                this.I = new r(iExHandler, iDlHandler, iOdHandler, iOsExHandler);
            }
            this.q = true;
            return this.I;
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
        } catch (Throwable unused) {
            return null;
        }
    }

    private s() {
    }

    public final void a(String str) {
        this.w = str;
    }

    public final String d() {
        return this.w;
    }

    public final synchronized void a(String str, ATCustomAdapterConfig aTCustomAdapterConfig) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.z == null) {
            this.z = new ConcurrentHashMap<>();
        }
        if (aTCustomAdapterConfig == null) {
            this.z.remove(str);
        } else {
            this.z.put(str, aTCustomAdapterConfig);
        }
    }

    public final ATCustomAdapterConfig b(String str) {
        if (this.z == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.z.get(str);
    }

    public final void a(int i2) {
        if (i2 == 2) {
            this.ag = 2;
        } else {
            this.ag = 1;
        }
    }

    public final int e() {
        return this.ag;
    }

    public final void a(String... strArr) {
        synchronized (this.A) {
            try {
                if (strArr != null) {
                    for (String str : strArr) {
                        this.A.put(str, Boolean.TRUE);
                    }
                } else {
                    this.A.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(String str) {
        boolean zContainsKey;
        synchronized (this.A) {
            zContainsKey = this.A.containsKey(str);
        }
        return zContainsKey;
    }

    public final String[] f() {
        synchronized (this.A) {
            Set<String> setKeySet = this.A.keySet();
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
            this.s = context;
        }
    }

    public final Context g() {
        return this.s;
    }

    public final long h() {
        return this.M;
    }

    public final long i() {
        return this.N;
    }

    public final int j() {
        return this.o;
    }

    public final void a(Map<String, Object> map) {
        if (map != null && map.containsKey("channel")) {
            Object obj = map.get("channel");
            String string = obj != null ? obj.toString() : "";
            this.O = string;
            if (!com.anythink.core.common.u.o.a(string)) {
                this.O = null;
                map.remove("channel");
            }
        }
        if (map != null && map.containsKey("sub_channel")) {
            Object obj2 = map.get("sub_channel");
            String string2 = obj2 != null ? obj2.toString() : "";
            this.P = string2;
            if (!com.anythink.core.common.u.o.b(string2)) {
                this.P = null;
                map.remove("sub_channel");
            }
        }
        this.x.clear();
        if (map != null) {
            com.anythink.core.common.u.i.a(this.x, map);
        }
        if (!TextUtils.isEmpty(this.O)) {
            this.x.put("channel", this.O);
        }
        if (TextUtils.isEmpty(this.P)) {
            return;
        }
        this.x.put("sub_channel", this.P);
    }

    public final void a(String str, Map<String, Object> map) {
        if (map != null) {
            this.y.put(str, map);
        }
    }

    private Map<String, Object> v(String str) {
        if (this.y == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.y.get(str);
    }

    public final void a(List<String> list) {
        try {
            this.ab = list;
            if (list != null && !list.isEmpty()) {
                this.aa = new JSONArray((Collection) list);
            } else {
                this.aa = null;
            }
        } catch (Exception unused) {
        }
    }

    public final List<String> k() {
        return this.ab;
    }

    public final JSONArray l() {
        return this.aa;
    }

    public final Map<String, Object> m() {
        return this.x;
    }

    public final Map<String, Object> d(String str) {
        Object obj;
        Object obj2;
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.y.get(str);
        ConcurrentHashMap<String, Object> concurrentHashMap = this.x;
        if (concurrentHashMap != null) {
            com.anythink.core.common.u.i.a(map, concurrentHashMap);
        }
        if (map2 != null) {
            com.anythink.core.common.u.i.a(map, map2);
        }
        map.remove("channel");
        map.remove("sub_channel");
        if (map2 != null) {
            obj = map2.get("channel");
            obj2 = map2.get("sub_channel");
        } else {
            obj = null;
            obj2 = null;
        }
        if (obj == null) {
            obj = this.x.get("channel");
        }
        if (obj2 == null) {
            obj2 = this.x.get("sub_channel");
        }
        if (obj != null) {
            map.put("channel", obj);
        }
        if (obj2 != null) {
            map.put("sub_channel", obj2);
        }
        return map;
    }

    public final String n() {
        Object obj = this.x.get("channel");
        return obj != null ? obj.toString() : "";
    }

    public final void e(String str) {
        this.O = str;
        this.x.put("channel", str);
    }

    public final String o() {
        Object obj = this.x.get("sub_channel");
        return obj != null ? obj.toString() : "";
    }

    public final void f(String str) {
        this.P = str;
        this.x.put("sub_channel", str);
    }

    public final String p() {
        return this.t;
    }

    private void b(String str, String str2) {
        this.t = str;
        this.u = str2;
    }

    public final String q() {
        return this.u;
    }

    public final String r() {
        try {
            if (TextUtils.isEmpty(this.B)) {
                a(this.s, this.t, 0);
            }
        } catch (Exception unused) {
        }
        return this.B;
    }

    public final String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = this.C.get(str);
        return !TextUtils.isEmpty(str2) ? str2 : x(str);
    }

    public final synchronized void a(Location location) {
        this.Y = location;
    }

    public final synchronized void a(boolean z) {
        this.Z = z ? "1" : "2";
    }

    public final boolean s() {
        return "1".equals(this.Z);
    }

    public final Location t() {
        return this.Y;
    }

    public final String u() {
        return this.Z;
    }

    public final void v() {
        try {
            com.anythink.core.common.u.l.a(this.s);
            com.anythink.core.common.u.l.o(this.s);
        } catch (Exception unused) {
        }
        if (G()) {
            String strD = com.anythink.core.common.u.l.d(this.s);
            Log.i("anythink", "********************************** " + com.anythink.core.common.u.o.a() + " *************************************");
            Log.i("anythink", "GAID(ADID): " + com.anythink.core.common.u.l.p(this.s) + " , AndroidID: " + strD + ", OAID: " + com.anythink.core.common.u.l.H());
            Log.i("anythink", "********************************** " + com.anythink.core.common.u.o.a() + " *************************************");
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
        this.s = context.getApplicationContext();
        if (context instanceof Activity) {
            a((Activity) context);
        }
        this.v = aTNetworkConfig;
        try {
            this.as = System.currentTimeMillis();
            this.e = 0L;
            a(this.s);
            this.t = str;
            this.u = str2;
            com.anythink.core.common.t.a.a.a().f();
            b.c().a((Application) this.s);
        } catch (Throwable unused) {
        }
        a(new Runnable() { // from class: com.anythink.core.common.d.s.1
            @Override // java.lang.Runnable
            public final void run() {
                r rVarC = s.b().c();
                if (rVarC != null) {
                    rVarC.startPlugin(s.this.s);
                }
            }
        });
        a(new Runnable() { // from class: com.anythink.core.common.d.s.11
            @Override // java.lang.Runnable
            public final void run() {
                s.a(s.this, context);
                s.b(s.this);
                com.anythink.core.common.a.d.a(context).a();
                com.anythink.core.common.r.b bVarA = com.anythink.core.common.r.b.a();
                Context context2 = context;
                String[] strArr = {t.b.a, t.b.c, t.b.g, t.b.h, t.b.i, t.b.j, t.b.k, "anythink_app_pl_cl_retry", t.b.d};
                for (int i2 = 0; i2 < 9; i2++) {
                    com.anythink.core.common.r.a aVarB = bVarA.b(context2, strArr[i2]);
                    if (aVarB instanceof com.anythink.core.common.r.b.e) {
                        ((com.anythink.core.common.r.b.e) aVarB).d();
                    }
                }
                s.c(s.this);
            }
        });
    }

    private void g(Context context) {
        int iA = com.anythink.core.common.u.p.a(context, "common_custom_pg", "string");
        if (iA > 0) {
            this.aw = context.getResources().getString(iA);
        }
    }

    public final String w() {
        return this.aw;
    }

    private synchronized void h(final Context context) {
        Context context2;
        if (context == null) {
            return;
        }
        this.s = context.getApplicationContext();
        com.anythink.core.common.t.a.a.a().f();
        if (!TextUtils.isEmpty(this.t) && !TextUtils.isEmpty(this.u)) {
            if (this.R) {
                return;
            }
            this.R = true;
            try {
                final Context applicationContext = context.getApplicationContext();
                try {
                    if (!this.aI && (context2 = this.s) != null) {
                        MediationUtilsManager mediationUtilsManager = MediationUtilsManager.getInstance(context2);
                        mediationUtilsManager.setDebugMode(G());
                        if (this.aF < 0) {
                            this.aF = mediationUtilsManager.getTotalScore();
                        }
                        if (this.aE < 0) {
                            this.aE = mediationUtilsManager.getDynamicScore();
                        }
                        if (!this.aG) {
                            this.aG = ae();
                        }
                        mediationUtilsManager.startMonitoring(new AnonymousClass9(), 5000L);
                    }
                } catch (Throwable unused) {
                }
                this.ah = com.anythink.core.common.u.p.a();
                try {
                    BroadcastReceiver broadcastReceiver = this.E;
                    if (broadcastReceiver != null) {
                        this.s.unregisterReceiver(broadcastReceiver);
                        m.a(this.s).a(this.E);
                    }
                    this.E = null;
                } catch (Throwable unused2) {
                }
                try {
                    this.E = new AnonymousClass3();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.addAction(i.A);
                    m.a(this.s).a(this.E, intentFilter);
                    if (Build.VERSION.SDK_INT >= 33) {
                        this.s.registerReceiver(this.E, intentFilter, "android.permission.ACCESS_NETWORK_STATE", null, 2);
                    } else {
                        this.s.registerReceiver(this.E, intentFilter, "android.permission.ACCESS_NETWORK_STATE", null);
                    }
                } catch (Throwable unused3) {
                }
                a(new Runnable() { // from class: com.anythink.core.common.d.s.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            s.this.T();
                            s.this.r();
                            s.b(s.this, context);
                            j.a(applicationContext).a();
                            s.d(s.this);
                        } catch (Exception unused4) {
                        }
                    }
                });
                a(new Runnable() { // from class: com.anythink.core.common.d.s.13
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.v();
                        s.f(applicationContext);
                        if (!TextUtils.isEmpty(s.this.ad)) {
                            String strP = com.anythink.core.common.u.l.p(s.this.s);
                            if (!TextUtils.isEmpty(strP)) {
                                s.this.h(strP);
                            }
                        }
                        s sVar = s.this;
                        s.c(sVar, sVar.s);
                    }
                });
                b.c().a(new g(y()));
                a(new Runnable() { // from class: com.anythink.core.common.d.s.14
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.this.c();
                        if (s.this.I != null) {
                            s.this.I.initDeviceInfo(context);
                            s.this.I.cleanExpiredInfo();
                        }
                    }
                });
                a(new AnonymousClass4(context, this.t));
                a(new Runnable() { // from class: com.anythink.core.common.d.s.15
                    @Override // java.lang.Runnable
                    public final void run() {
                        s sVar = s.this;
                        s.a(sVar, sVar.s, s.this.v);
                    }
                });
            } catch (Exception e) {
                Log.e("SDK.init", "init failed: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.s$16, reason: invalid class name */
    final class AnonymousClass16 implements Runnable {
        AnonymousClass16() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.o.a().a(s.this.s);
            com.anythink.core.common.a.g.a().b();
            com.anythink.core.common.res.d.a(s.this.g()).a();
            com.anythink.core.common.res.d.a(s.this.g());
            com.anythink.core.common.res.d.b();
        }
    }

    private void aj() {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cF, new AnonymousClass16()));
    }

    private static void i(Context context) {
        if (b().c("ua")) {
            return;
        }
        try {
            if (u.a(context).b()) {
                String strJ = com.anythink.core.common.u.l.j();
                String strC = ad.c(context, t.b.a, t.a.s, "");
                if (TextUtils.isEmpty(strJ) || !Build.VERSION.RELEASE.equals(strC)) {
                    com.anythink.core.common.u.l.n(context);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cH, runnable));
    }

    private void ak() {
        com.anythink.core.common.e.a.a();
        com.anythink.core.common.e.b bVarA = com.anythink.core.common.e.a.a(this.s);
        if (bVarA != null) {
            a(bVarA.b(), false, bVarA.a(), bVarA.c());
        }
    }

    private void j(Context context) {
        JSONObject cnDInfo;
        try {
            com.anythink.core.common.e.b bVar = this.av;
            if (bVar != null) {
                com.anythink.core.common.t.f.a(bVar);
                return;
            }
            Object objInvoke = null;
            try {
                objInvoke = Class.forName("com.anythink.network.adx.AdxATInitManager").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
            }
            if (objInvoke instanceof ATInitMediation) {
                ATInitMediation aTInitMediation = (ATInitMediation) objInvoke;
                HashMap map = new HashMap();
                map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PRECHECK_MODE, 1);
                com.anythink.core.bridge.entity.a aVar = new com.anythink.core.bridge.entity.a();
                aVar.a();
                aVar.a(com.anythink.core.common.u.o.a());
                aVar.b(this.t);
                aVar.c(this.u);
                map.put(com.anythink.core.bridge.a.C0010a.b, com.anythink.core.bridge.c.a(aVar));
                com.anythink.core.bridge.entity.d dVar = new com.anythink.core.bridge.entity.d();
                dVar.a(C());
                r rVarC = c();
                if (rVarC != null && (cnDInfo = rVarC.getCnDInfo()) != null) {
                    String strB = af.b(com.anythink.core.bridge.b.a);
                    String strB2 = af.b(com.anythink.core.bridge.b.d);
                    String strB3 = af.b(com.anythink.core.bridge.b.c);
                    String strB4 = af.b(com.anythink.core.bridge.b.b);
                    dVar.c(cnDInfo.optString(strB));
                    dVar.h(cnDInfo.optString(strB2));
                    dVar.j(cnDInfo.optString(strB3));
                    dVar.i(cnDInfo.optString(strB4));
                }
                dVar.k(com.anythink.core.common.u.l.d(context));
                dVar.d(com.anythink.core.common.u.l.p(context));
                dVar.f(com.anythink.core.common.u.l.I());
                dVar.g(com.anythink.core.common.u.l.J());
                map.put(com.anythink.core.bridge.a.C0010a.a, com.anythink.core.bridge.c.a(dVar));
                String[] strArrF = f();
                if (strArrF != null && strArrF.length > 0) {
                    map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DENNY_DEVICE_INFO, strArrF);
                }
                aTInitMediation.initSDK(context, map, new AnonymousClass17(context));
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.s$17, reason: invalid class name */
    final class AnonymousClass17 implements MediationInitCallback {
        final /* synthetic */ Context a;

        AnonymousClass17(Context context) {
            this.a = context;
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onSuccess() {
            com.anythink.core.bridge.a.b.a().a(this.a);
        }

        @Override // com.anythink.core.api.MediationInitCallback
        public final void onFail(String str) {
            s.this.a("There is a problem with the integrated resources of AnyThink SDK, please check whether you have followed the steps of the integration document.", true, 3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, boolean z, int i2, String str2) {
        if (ATCommonConfig.isShowInitErrorTips) {
            Log.e("anythink", str);
            a(new Runnable() { // from class: com.anythink.core.common.d.s.18
                @Override // java.lang.Runnable
                public final void run() {
                    if (s.this.s != null) {
                        Toast.makeText(s.this.s, str, 1).show();
                    }
                }
            }, 500L);
        }
        if (z) {
            com.anythink.core.common.t.f.a(new com.anythink.core.common.e.b(i2, str, str2));
        } else {
            this.av = new com.anythink.core.common.e.b(i2, str, str2);
        }
    }

    private static boolean al() {
        return y();
    }

    public static boolean y() {
        return !b.c().b();
    }

    public final void b(int i2) {
        this.o = i2;
    }

    @Deprecated
    private void w(String str) {
        this.ad = str;
    }

    public final boolean z() {
        return this.af;
    }

    public final void a(Context context, String str, ATDebuggerConfig aTDebuggerConfig) {
        r rVarC;
        if (context == null) {
            if (G()) {
                Log.e("SDK.init", "setDebuggerConfig fail, because context is null.");
                return;
            }
            return;
        }
        if (b().s == null) {
            b().a(context.getApplicationContext());
        }
        this.ad = str;
        this.ae = aTDebuggerConfig;
        String strD = com.anythink.core.common.u.l.d(context);
        boolean z = true;
        if (TextUtils.isEmpty(strD) || !strD.equals(this.ad)) {
            String strF = com.anythink.core.common.u.l.f();
            if ((TextUtils.isEmpty(strF) || !strF.equals(this.ad)) && ((rVarC = b().c()) == null || !rVarC.checkDebuggerDevice(context, this.ad))) {
                z = false;
            }
        }
        this.af = z;
        if (TextUtils.isEmpty(this.ad)) {
            if (G()) {
                Log.e("SDK.init", "Setting Debugger's device fail, because deviceId is empty.");
            }
            this.af = false;
        } else {
            if (this.af) {
                if (G()) {
                    Log.i("SDK.init", "Setting Debugger's device success.");
                }
                if (this.ae == null || !G()) {
                    return;
                }
                Log.i("SDK.init", "Debugger config is in effect now.");
                return;
            }
            if (G()) {
                Log.e("SDK.init", "The incoming device id does not match the current device id, and the debugger mode cannot take effect.");
            }
        }
    }

    private boolean k(Context context) {
        String strD = com.anythink.core.common.u.l.d(context);
        if (!TextUtils.isEmpty(strD) && strD.equals(this.ad)) {
            return true;
        }
        String strF = com.anythink.core.common.u.l.f();
        if (!TextUtils.isEmpty(strF) && strF.equals(this.ad)) {
            return true;
        }
        r rVarC = b().c();
        return rVarC != null && rVarC.checkDebuggerDevice(context, this.ad);
    }

    public final void h(String str) {
        if (TextUtils.isEmpty(this.ad)) {
            return;
        }
        if (TextUtils.equals(str, this.ad)) {
            this.af = true;
        }
        if (this.af && G()) {
            Log.i("SDK.init", "Update Setting Debugger's device success.");
        }
    }

    public final boolean A() {
        return this.af && this.ae != null;
    }

    public final ATDebuggerConfig B() {
        return this.ae;
    }

    private void l(Context context) {
        long jCurrentTimeMillis = this.e;
        try {
            String strC = ad.c(b().s, t.b.a, b().t + "playRecord", "");
            if (!TextUtils.isEmpty(strC)) {
                JSONObject jSONObject = new JSONObject(strC);
                long jOptLong = jSONObject.optLong(f.a);
                long jOptLong2 = jSONObject.optLong(f.b);
                String strOptString = jSONObject.optString(f.c);
                int iOptInt = jSONObject.optInt(f.d);
                if (jCurrentTimeMillis != 0) {
                    com.anythink.core.common.t.f.a(iOptInt == 1 ? 4 : 2, jOptLong, jOptLong2, strOptString);
                } else {
                    jCurrentTimeMillis = jOptLong;
                }
                ad.b(b().s, t.b.a, b().t + "playRecord", "");
            }
        } catch (Exception unused) {
            ad.b(b().s, t.b.a, b().t + "playRecord", "");
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = ad.b(context, t.b.a, t.a.v, 0L);
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        b.c().a(new f(jCurrentTimeMillis));
    }

    private void am() {
        try {
            BroadcastReceiver broadcastReceiver = this.E;
            if (broadcastReceiver != null) {
                this.s.unregisterReceiver(broadcastReceiver);
                m.a(this.s).a(this.E);
            }
            this.E = null;
        } catch (Throwable unused) {
        }
        try {
            this.E = new AnonymousClass3();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(i.A);
            m.a(this.s).a(this.E, intentFilter);
            if (Build.VERSION.SDK_INT >= 33) {
                this.s.registerReceiver(this.E, intentFilter, "android.permission.ACCESS_NETWORK_STATE", null, 2);
            } else {
                this.s.registerReceiver(this.E, intentFilter, "android.permission.ACCESS_NETWORK_STATE", null);
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.s$3, reason: invalid class name */
    final class AnonymousClass3 extends BroadcastReceiver {
        AnonymousClass3() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(final Context context, final Intent intent) {
            s.a(new Runnable() { // from class: com.anythink.core.common.d.s.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.anythink.core.common.u.p.a(context)) {
                        com.anythink.core.common.s.a().b();
                    }
                    s.this.c(context);
                    if (TextUtils.equals(intent.getAction(), i.A)) {
                        com.anythink.core.common.t.f.a(intent.getStringExtra(i.B));
                    }
                }
            });
            try {
                if (s.this.I != null) {
                    s.this.I.resetSSID();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private long an() {
        if (this.f == 0) {
            this.f = ad.b(this.s, t.b.a, t.a.v, 0L);
        }
        return this.f;
    }

    protected final long a(Context context, String str, int i2) {
        boolean z;
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(context).b(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jS = i2 == 0 ? bVarB.S() : bVarB.E();
        synchronized (this.D) {
            if (this.f == 0) {
                this.f = ad.b(this.s, t.b.a, t.a.v, 0L);
            }
            z = true;
            if (Math.max(0L, jCurrentTimeMillis - this.f) > jS) {
                this.B = com.anythink.core.common.u.n.a(str + jCurrentTimeMillis);
                this.f = jCurrentTimeMillis;
            } else {
                z = false;
            }
        }
        if (z) {
            this.C.clear();
            HashMap map = new HashMap();
            map.put(t.a.t, this.B);
            map.put(t.a.v, Long.valueOf(jCurrentTimeMillis));
            if (context != null) {
                try {
                    com.anythink.core.common.r.b.a().b(context, t.b.a).a(map);
                } catch (Throwable unused) {
                }
            }
            com.anythink.core.common.t.f.a((String) null, "1", (String) null, String.valueOf(jCurrentTimeMillis));
            if (i2 == 0) {
                this.e = jCurrentTimeMillis;
            }
            return jCurrentTimeMillis;
        }
        if (TextUtils.isEmpty(this.B)) {
            synchronized (this.D) {
                if (TextUtils.isEmpty(this.B)) {
                    this.B = ad.c(context, t.b.a, t.a.t, "");
                }
            }
        }
        return 0L;
    }

    private String x(String str) {
        String str2 = this.C.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = com.anythink.core.common.u.n.a(str + r());
        try {
            this.C.put(str, strA);
        } catch (Exception unused) {
        }
        com.anythink.core.common.t.f.a(str, "2", (String) null, String.valueOf(jCurrentTimeMillis));
        return strA;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.s$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        AnonymousClass4(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            s.this.c(this.a.getApplicationContext());
            com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.a.getApplicationContext()).b(this.b);
            if (bVarB != null) {
                if (!bVarB.J()) {
                    com.anythink.core.common.q.a(s.this.s).a(bVarB);
                    com.anythink.core.common.c.b.a().a(bVarB.ap());
                    com.anythink.core.common.c.a().b(bVarB.i());
                    com.anythink.core.a.b.a(this.a.getApplicationContext()).a(bVarB.at());
                    s.b().H();
                    s.b().a(bVarB);
                    com.anythink.core.common.u.e.a().a(bVarB.f());
                    r rVarC = s.this.c();
                    if (rVarC != null) {
                        rVarC.uploadAegisData(bVarB);
                    }
                    com.anythink.core.common.l.a(this.a.getApplicationContext()).a(bVarB.aQ());
                }
                s.this.b(bVarB);
                v.a().a(bVarB.g());
                if (TextUtils.isEmpty(com.anythink.core.e.d.a(this.a.getApplicationContext()).a(this.b))) {
                    com.anythink.core.e.d.a(this.a.getApplicationContext());
                }
                com.anythink.core.common.n.e.a().a(bVarB);
            }
        }
    }

    private void b(Context context, String str) {
        a(new AnonymousClass4(context, str));
    }

    public final void b(final Context context) {
        if (G()) {
            com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cG, new Runnable() { // from class: com.anythink.core.common.d.s.5
                @Override // java.lang.Runnable
                public final void run() {
                    boolean zC;
                    AnonymousClass5 anonymousClass5 = this;
                    int i2 = 0;
                    try {
                        Class.forName("android.support.v4.content.LocalBroadcastManager");
                    } catch (Throwable unused) {
                    }
                    if (1 == 0) {
                        try {
                            Log.e("anythink", "Missing: LocalBroadcastManager");
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                    try {
                        if (!com.anythink.core.common.u.p.a()) {
                            Log.e("anythink", "isCleartextTrafficPermitted=false, please check whether the \"android:networkSecurityConfig\" configuration in the AndroidManifest.xml of the application module is correct");
                        }
                    } catch (Throwable unused3) {
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
                                objInvoke = cls.getDeclaredMethod("getInstance", new Class[i2]).invoke(null, new Object[i2]);
                            } catch (Throwable unused4) {
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
                                    boolean zI = s.i(aTInitMediation.getNetworkSDKClass());
                                    boolean zB = s.b(aTInitMediation.getPluginClassStatus());
                                    boolean zA = s.a(context, (List<String>) aTInitMediation.getActivityStatus());
                                    boolean zB2 = s.b(context, (List<String>) aTInitMediation.getServiceStatus());
                                    boolean zC2 = s.c(context, (List<String>) aTInitMediation.getProviderStatus());
                                    boolean zD = s.d(context, (List<String>) aTInitMediation.getMetaValutStatus());
                                    boolean zE = s.e(context, (List<String>) aTInitMediation.getPermissionStatus());
                                    String strA = s.this.a(context, aTInitMediation.getResourceStatus(), aTInitMediation.getDevBundleName());
                                    boolean zIsEmpty = TextUtils.isEmpty(strA);
                                    if (zIsEmpty) {
                                        Log.i("anythink", "Resource: VERIFIED");
                                    } else {
                                        Log.e("anythink", "Resource: The " + strA + " resources are missing. If shrinkResources is enabled, the " + strA + " resources must be added to the whitelist (keep.xml)");
                                    }
                                    try {
                                        zC = s.c(aTInitMediation.getAdapterBridgeVersion());
                                    } catch (Throwable unused5) {
                                        zC = true;
                                    }
                                    if (zI && zB && zA && zB2 && zC2 && zD && zE && zIsEmpty && zC) {
                                        Log.i("anythink", "Status: Success");
                                    } else {
                                        Log.e("anythink", "Status: Fail");
                                    }
                                    Log.i("anythink", "----------------------------------------");
                                }
                            }
                        } catch (Throwable unused6) {
                        }
                        anonymousClass5 = this;
                        i2 = 0;
                    }
                    Log.i("anythink", "********************************** Network Integration Status *************************************");
                }
            }));
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
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (TextUtils.equals(providerInfoArr[i2].name, str)) {
                    z2 = true;
                    break;
                }
                i2++;
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
            for (int i2 = 0; i2 < size; i2++) {
                String str = list.get(i2);
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
                for (int i2 = 0; i2 < size; i2++) {
                    String str = list.get(i2);
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z = false;
                            break;
                        }
                        if (TextUtils.equals(str, strArr[i3])) {
                            z = true;
                            break;
                        }
                        i3++;
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
                for (int i4 = 0; i4 < size; i4++) {
                    String str2 = list.get(i4);
                    if (i4 == 0) {
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
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    String str3 = list.get(i2);
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = str3.split("_")[0] + "_*";
                        }
                        int identifier = !TextUtils.isEmpty(str) ? context.getResources().getIdentifier(str3, "layout", str) : -1;
                        if (identifier <= 0 && !TextUtils.isEmpty(this.ap)) {
                            identifier = context.getResources().getIdentifier(str3, "layout", this.ap);
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
                                    if (x.n.equalsIgnoreCase(layout.getName())) {
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
        String strA = com.anythink.core.common.u.o.a();
        boolean z = !TextUtils.isEmpty(str) && str.startsWith(strA);
        if (!z) {
            Log.e("anythink", String.format("Adapter Version: The current Adapter version(%s) does not apply to the SDK version(%s).", str, strA));
        } else {
            Log.i("anythink", "Adapter Version: VERIFIED");
        }
        return z;
    }

    public static boolean c(int i2) {
        try {
            int requireAdapterBridgeVersion = ATSDK.getRequireAdapterBridgeVersion();
            if (i2 != requireAdapterBridgeVersion) {
                Log.e("anythink", String.format("Adapter Bridge Version: The current Adapter Bridge version(%s) does not apply to the SDK Require version(%s).", Integer.valueOf(i2), Integer.valueOf(requireAdapterBridgeVersion)));
                return false;
            }
            Log.i("anythink", "Adapter Bridge Version: VERIFIED");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void c(Context context) {
        d(context);
    }

    public final void d(Context context) {
        r rVarC;
        String strA = com.anythink.core.e.d.a(context).a(this.t);
        if (!TextUtils.isEmpty(strA)) {
            com.anythink.core.e.d.a(context).a(this.t, this.u, strA);
        }
        com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(context).b(this.t);
        if (bVarB == null || (rVarC = b().c()) == null) {
            return;
        }
        rVarC.startRefreshes(bVarB.a());
    }

    public static void b(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().a(runnable);
    }

    public static void a(Runnable runnable, long j2) {
        com.anythink.core.common.u.b.c.a().a(runnable, j2);
    }

    public static void c(Runnable runnable) {
        com.anythink.core.common.u.b.c.a().b(runnable);
    }

    public static void b(Runnable runnable, long j2) {
        if (j2 > 0) {
            com.anythink.core.common.u.b.c.a().b(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cE, runnable), j2);
        } else {
            runnable.run();
        }
    }

    public final String C() {
        if (TextUtils.isEmpty(this.F)) {
            String strC = ad.c(this.s, t.b.a, t.a.w, "");
            this.F = strC;
            TextUtils.isEmpty(strC);
        }
        return this.F;
    }

    public final String D() {
        if (TextUtils.isEmpty(this.G)) {
            this.G = ad.c(this.s, t.b.f, t.a.B, "");
        }
        return this.G;
    }

    public final String E() {
        if (TextUtils.isEmpty(this.H)) {
            this.H = ad.c(this.s, t.b.f, t.a.C, "");
        }
        return this.H;
    }

    public final void j(String str) {
        this.G = str;
        ad.b(this.s, t.b.f, t.a.B, str);
    }

    public final void k(String str) {
        this.H = str;
        ad.b(this.s, t.b.f, t.a.C, str);
    }

    public final void l(String str) {
        ad.b(this.s, t.b.a, t.a.w, str);
        this.F = str;
    }

    public final void b(boolean z) {
        this.L = z;
    }

    public final void d(int i2) {
        this.ax = i2;
    }

    public final int F() {
        return this.ax;
    }

    private void ao() {
        Throwable th;
        boolean zExists;
        boolean z = false;
        if (this.s != null) {
            try {
                zExists = new File(this.s.getExternalFilesDir(null), this.J).exists();
                if (!zExists) {
                    try {
                        zExists = new File(this.s.getFilesDir(), this.J).exists();
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
        this.K = z;
    }

    public final boolean G() {
        return this.K || this.L;
    }

    private static long a(long j2) {
        Date date = new Date(j2);
        return new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
    }

    public static com.anythink.core.common.j.e a(com.anythink.core.common.f fVar) {
        return new com.anythink.core.common.p.e(fVar);
    }

    public final void c(boolean z) {
        this.Q = z;
    }

    private boolean ap() {
        return this.Q;
    }

    public final void a(String str, List<String> list) {
        if (G()) {
            Log.i("anythink", String.format("setFilterAdSourceIdList, placementId=%s, adSourceIdList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (list == null) {
            this.ac.remove(str);
        } else {
            this.ac.put(str, list);
        }
    }

    public final List<String> m(String str) {
        return this.ac.get(str);
    }

    public final void b(String str, List<String> list) {
        if (G()) {
            Log.i("anythink", String.format("setFilterNetworkFirmIdList, placementId=%s, networkFilmIdList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (list == null) {
            this.ac.remove(str + "_network_firm");
        } else {
            this.ac.put(str + "_network_firm", list);
        }
    }

    public final List<String> n(String str) {
        return this.ac.get(str + "_network_firm");
    }

    public final void c(String str, List<String> list) {
        if (G()) {
            Log.i("anythink", String.format("setAllowedShowNetworkFimIdList, placementId=%s, allowShowList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ac.remove(str + "_network_firm_f_s");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.ac.remove(str + "_network_firm_a_s");
        } else {
            this.ac.put(str + "_network_firm_a_s", arrayList);
        }
    }

    public final List<String> o(String str) {
        return this.ac.get(str + "_network_firm_a_s");
    }

    public final void d(String str, List<String> list) {
        if (G()) {
            Log.i("anythink", String.format("setForbidShowNetworkFirmIdList, placementId=%s, ForbidShowList=%s", str, list));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ac.remove(str + "_network_firm_a_s");
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.ac.remove(str + "_network_firm_f_s");
        } else {
            this.ac.put(str + "_network_firm_f_s", arrayList);
        }
    }

    public final List<String> p(String str) {
        return this.ac.get(str + "_network_firm_f_s");
    }

    public final void a(int i2, List<String> list) {
        if (G()) {
            Log.i("anythink", String.format("setForbidShowNetworkFirmIdList, risk=%s, ForbidList=%s", Integer.valueOf(i2), list));
        }
        this.ay = new Pair<>(Integer.valueOf(i2), list);
        H();
    }

    public final void a(IATDeviceRiskListener iATDeviceRiskListener) {
        this.g = iATDeviceRiskListener;
    }

    public final void a(com.anythink.core.e.b bVar) {
        if (bVar != null) {
            try {
                if (G()) {
                    Log.e("anythink", "notifyDeviceRisk:" + this.g);
                }
                if (this.g != null) {
                    JSONObject jSONObject = new JSONObject();
                    String strC = C();
                    if (!TextUtils.isEmpty(strC)) {
                        jSONObject.put("device_upid", strC);
                    }
                    String strE = bVar.e();
                    if (!TextUtils.isEmpty(strE)) {
                        jSONObject.put("device_risk_labels", strE);
                    }
                    this.g.onDeviceRiskInfo(jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void H() {
        com.anythink.core.common.h.n nVar;
        try {
            if (this.ay != null) {
                if (this.s != null && !TextUtils.isEmpty(this.t)) {
                    com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.s).b(this.t);
                    if (bVarB != null) {
                        if (bVarB.d() == 1) {
                            Pair<Boolean, com.anythink.core.common.h.n> pair = this.az;
                            if (pair != null && !((Boolean) pair.first).booleanValue()) {
                                nVar = (com.anythink.core.common.h.n) this.az.second;
                                this.az = null;
                            } else {
                                nVar = new com.anythink.core.common.h.n();
                                nVar.N(((Integer) this.ay.first).intValue());
                                if (this.ay.second != null) {
                                    nVar.x(((List) this.ay.second).toString());
                                }
                            }
                            com.anythink.core.common.t.e.a(b().s);
                            com.anythink.core.common.t.e.a(27, nVar);
                            return;
                        }
                        return;
                    }
                    com.anythink.core.common.h.n nVar2 = new com.anythink.core.common.h.n();
                    nVar2.N(((Integer) this.ay.first).intValue());
                    if (this.ay.second != null) {
                        nVar2.x(((List) this.ay.second).toString());
                    }
                    this.az = new Pair<>(Boolean.FALSE, nVar2);
                    return;
                }
                com.anythink.core.common.h.n nVar3 = new com.anythink.core.common.h.n();
                nVar3.N(((Integer) this.ay.first).intValue());
                if (this.ay.second != null) {
                    nVar3.x(((List) this.ay.second).toString());
                }
                this.az = new Pair<>(Boolean.FALSE, nVar3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Pair<Integer, List<String>> I() {
        return this.ay;
    }

    public final void b(List<String> list) {
        if (G()) {
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
            this.ac.remove("forbid_network_firm_list");
        } else {
            this.ac.put("forbid_network_firm_list", arrayList);
        }
    }

    public final List<String> J() {
        return this.ac.get("forbid_network_firm_list");
    }

    public static boolean a(List<String> list, String str) {
        return list != null && list.contains(str);
    }

    private void f(boolean z) {
        this.ah = z;
    }

    public final boolean K() {
        return this.ah;
    }

    public final void d(boolean z) {
        this.ai = z;
    }

    public final boolean L() {
        return this.ai;
    }

    public final void a(final Context context, final DeviceInfoCallback deviceInfoCallback) {
        if (!G()) {
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
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cI, new Runnable() { // from class: com.anythink.core.common.d.s.6
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(context).b(s.b().p());
                String strI = bVarB != null ? bVarB.I() : "";
                boolean z = true;
                if (!TextUtils.isEmpty(strI)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strI);
                        if (!jSONObject.isNull("a") && jSONObject.optInt("a") != 1) {
                            z = false;
                        }
                    } catch (Exception unused) {
                    }
                }
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    r rVarC = s.b().c();
                    if (rVarC != null) {
                        rVarC.fillTestDeviceData(jSONObject2, bVarB);
                    }
                    jSONObject2.put("GAID", com.anythink.core.common.u.l.p(context));
                    jSONObject2.put("AndroidID", z ? com.anythink.core.common.u.l.d(context) : "");
                    jSONObject2.put("How to config TestMode", "Please visit the document center and learn more through: Integration(Basic) -> How To Test");
                    aa.a("testModeDeviceInfo", jSONObject2.toString());
                    DeviceInfoCallback deviceInfoCallback2 = deviceInfoCallback;
                    if (deviceInfoCallback2 != null) {
                        deviceInfoCallback2.deviceInfo(jSONObject2.toString());
                    }
                } catch (Throwable unused2) {
                }
            }
        }));
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

    public final void a(final com.anythink.core.common.f fVar, final String str, final String str2, final Map<String, Object> map) {
        if (!this.d) {
            Log.e("SDK.init", "SDK should be inited first!");
            return;
        }
        if (fVar == null) {
            Log.e("SDK.init", "The commonAdManager object has not been created yet!");
            return;
        }
        final boolean zL = fVar.l();
        ae aeVar = new ae();
        aeVar.a(map);
        aeVar.a(fVar.n());
        final com.anythink.core.common.h.c cVarB = fVar.b(this.s, false, false, aeVar);
        com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cD, new Runnable() { // from class: com.anythink.core.common.d.s.7
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.e.l lVarA = com.anythink.core.e.n.a(s.this.s).a(fVar.c());
                String strM = fVar.m();
                String strD = com.anythink.core.common.u.o.d(str);
                com.anythink.core.common.h.c cVar = cVarB;
                if (cVar != null) {
                    com.anythink.core.common.h.n nVarAh = cVar.i().ah();
                    nVarAh.k(1);
                    nVarAh.H = strD;
                    if (v.a().a(lVarA)) {
                        ai.a(fVar.c(), lVarA, nVarAh);
                    }
                    com.anythink.core.common.t.e.a(s.this.s);
                    com.anythink.core.common.t.e.a(16, nVarAh);
                    return;
                }
                if (TextUtils.isEmpty(strM)) {
                    strM = "";
                }
                com.anythink.core.common.h.n nVarA = ai.a(strM, fVar.c(), lVarA, 0, 0, map, null, 0, fVar.n(), fVar);
                nVarA.k(zL ? 3 : 2);
                if (lVarA == null) {
                    nVarA.K(str2);
                }
                nVarA.H = strD;
                if (v.a().a(lVarA)) {
                    ai.a(fVar.c(), lVarA, nVarA);
                }
                com.anythink.core.common.t.e.a(s.this.s);
                com.anythink.core.common.t.e.a(16, nVarA);
            }
        }));
    }

    public final void a(Activity activity) {
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null || weakReference.get() == null) {
            this.h = new WeakReference<>(activity);
        }
    }

    public final Context M() {
        WeakReference<Activity> weakReference = this.h;
        if (weakReference != null && weakReference.get() != null) {
            return this.h.get();
        }
        return this.s;
    }

    public final Activity N() {
        WeakReference<Activity> weakReference = this.h;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.h.get();
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
            if (A()) {
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
        this.S = aTInitConfigList.size() > 0;
        for (ATInitConfig aTInitConfig3 : aTInitConfigList) {
            if (aTInitConfig3 != null) {
                if (aTInitConfig != null && TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                    if (!z) {
                        z = true;
                    }
                }
                a(new AnonymousClass8(aTInitConfig3, context));
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.s$8, reason: invalid class name */
    final class AnonymousClass8 implements Runnable {
        final /* synthetic */ ATInitConfig a;
        final /* synthetic */ Context b;

        AnonymousClass8(ATInitConfig aTInitConfig, Context context) {
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
                    String strC = ad.c(s.this.s, t.b.g, networkName, "");
                    if (!TextUtils.isEmpty(strC)) {
                        requestParamMap = com.anythink.core.common.u.p.c(strC);
                    } else {
                        requestParamMap = this.a.getRequestParamMap();
                        requestParamMap.put(ATInitMediation.KEY_LOCAL, Boolean.TRUE);
                    }
                    boolean z = false;
                    try {
                        zC = u.a(this.b).c();
                        try {
                            zD = u.a(this.b).d();
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
                    com.anythink.core.e.b bVarB = com.anythink.core.e.d.a(this.b).b(s.this.t);
                    requestParamMap.put("app_ccpa_switch", Boolean.valueOf(bVarB.s() == 3));
                    boolean zB = com.anythink.core.common.u.o.b();
                    if (bVarB.t() == 2 && zB) {
                        z = true;
                    }
                    requestParamMap.put("app_coppa_switch", Boolean.valueOf(z));
                    if (s.b().G()) {
                        Log.i("anythink", "pre init network: [" + networkName + "], params: " + new JSONObject(requestParamMap).toString() + ", gdpr: " + zC + ", in eu: " + zD);
                    }
                    initMediation.initSDK(s.this.s, requestParamMap, null);
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
            nVar = (com.anythink.core.common.h.n) map.get("anythink_tracking_info");
        } catch (Throwable unused) {
            nVar = null;
        }
        map.remove("anythink_tracking_info");
        String string = new JSONObject(map).toString();
        Log.e("anythink", "Mismatched initialization parameters! server params: [" + str + "], " + string);
        ad.b(this.s, t.b.g, str, string);
        if (nVar == null || strArr == null) {
            return;
        }
        try {
            com.anythink.core.common.t.f.a(nVar, strArr[0], strArr.length > 1 ? strArr[1] : null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(String[] strArr, IATAdFilter iATAdFilter) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap = this.aj;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if (this.aj == null) {
            this.aj = new ConcurrentHashMap<>();
        }
        for (String str : strArr) {
            this.aj.put(str, iATAdFilter);
        }
    }

    public final IATAdFilter q(String str) {
        ConcurrentHashMap<String, IATAdFilter> concurrentHashMap;
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.aj) == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public final String O() {
        return this.ak;
    }

    public final void r(String str) {
        this.ak = str;
    }

    public final boolean P() {
        return this.S;
    }

    public final void a(ATUserDeviceInfo aTUserDeviceInfo) {
        this.al = aTUserDeviceInfo;
    }

    public final ATUserDeviceInfo Q() {
        return this.al;
    }

    public final cb R() {
        if (this.am == null) {
            this.am = new cb();
        }
        try {
            this.am.a(com.anythink.core.common.u.l.r(b().s));
            this.am.b(com.anythink.core.common.u.l.m());
            this.am.c(com.anythink.core.common.u.l.o());
            this.am.d(com.anythink.core.common.u.l.b(com.anythink.core.common.u.l.n()));
        } catch (Throwable unused) {
        }
        return this.am;
    }

    public final long e(int i2) {
        if (i2 != 1 && i2 != 4 && i2 != 5) {
            return 26214400L;
        }
        com.anythink.core.e.d.a(this.s);
        return com.anythink.core.e.d.b() * com.anythink.china.a.c.k;
    }

    public final void S() {
        this.an = System.currentTimeMillis();
    }

    private long aq() {
        return this.an;
    }

    public final void T() {
        Context context = this.s;
        if (context == null || this.T) {
            return;
        }
        synchronized (this.U) {
            if (!this.T) {
                long jB = ad.b(context, t.b.a, t.a.z, 0L);
                this.M = jB;
                if (jB == 0) {
                    long j2 = this.as;
                    this.M = j2;
                    ad.a(context, t.b.a, t.a.z, j2);
                }
                this.N = ((a(this.as) - a(this.M)) / 86400000) + 1;
                com.anythink.core.common.g.c.a().a(context);
                this.T = true;
            }
        }
    }

    private static void m(Context context) {
        com.anythink.core.common.g.c.a().a(context);
    }

    private void n(Context context) {
        long jB = ad.b(context, t.b.a, t.a.z, 0L);
        this.M = jB;
        if (jB == 0) {
            long j2 = this.as;
            this.M = j2;
            ad.a(context, t.b.a, t.a.z, j2);
        }
        this.N = ((a(this.as) - a(this.M)) / 86400000) + 1;
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e("SDK.init", "setPrePlacementStrategy failed: path is null or empty.");
        } else {
            com.anythink.core.e.n.a(context.getApplicationContext()).j(str);
            com.anythink.core.e.d.a(context.getApplicationContext()).d(str);
        }
    }

    public static void a(ATSharedPlacementConfig aTSharedPlacementConfig) {
        v.a().a(aTSharedPlacementConfig);
    }

    public final void s(String str) {
        if (G()) {
            Log.i("anythink", "setBundleName: ".concat(String.valueOf(str)));
        }
        this.ap = str;
    }

    public final String U() {
        return this.ap;
    }

    public final boolean V() {
        return this.d;
    }

    public final boolean W() {
        return this.ar;
    }

    public final void e(boolean z) {
        this.ar = z;
        try {
            synchronized (this.aA) {
                if (!this.aA.isEmpty()) {
                    for (l lVar : this.aA) {
                        if (lVar != null) {
                            lVar.a(z);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(l lVar) {
        if (lVar != null) {
            try {
                synchronized (this.aA) {
                    try {
                        if (!this.aA.contains(lVar)) {
                            this.aA.add(lVar);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void b(l lVar) {
        if (lVar != null) {
            try {
                synchronized (this.aA) {
                    this.aA.remove(lVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final com.anythink.core.common.l.d.i X() {
        if (this.au == null) {
            synchronized (at) {
                if (this.au == null) {
                    this.au = new com.anythink.core.common.l.d.g(this.s);
                }
            }
        }
        return this.au;
    }

    public final long Y() {
        return this.as;
    }

    public final Map<String, ATAdFilter> Z() {
        return this.aB;
    }

    public final void a(String str, ATAdFilter aTAdFilter) {
        if (TextUtils.isEmpty(str) || aTAdFilter == null) {
            return;
        }
        this.aB.put(str, aTAdFilter);
    }

    public final void aa() {
        this.aB.clear();
    }

    public final void t(String str) {
        if (TextUtils.isEmpty(str) || this.aB.isEmpty()) {
            return;
        }
        this.aB.remove(str);
    }

    public final void b(String str, ATAdFilter aTAdFilter) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.aC.put(str, aTAdFilter);
    }

    public final ATAdFilter u(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aC.get(str);
    }

    public static void a(String str, String str2) {
        com.anythink.core.common.t.f.a("1", str, str2);
    }

    public final void a(Boolean bool) {
        if (bool != null) {
            synchronized (this.A) {
                if (!bool.booleanValue()) {
                    this.A.put("sensor_deny", Boolean.TRUE);
                } else {
                    this.A.remove("sensor_deny");
                }
            }
        }
    }

    public static void e(Context context) {
        b().h(context);
        b().b(com.anythink.core.e.d.a());
    }

    public final void c(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (map.containsKey("mmed_m_a_c")) {
            Object obj = map.get("mmed_m_a_c");
            if (obj instanceof JSONObject) {
                this.aJ = (JSONObject) obj;
            }
        }
        String[] strArr = aK;
        int length = strArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (!map.containsKey(strArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            if (map.containsKey(i)) {
                Object obj2 = map.get(i);
                if (obj2 instanceof Integer) {
                    this.aD = ((Integer) obj2).intValue();
                }
            }
            if (map.containsKey(j)) {
                Object obj3 = map.get(j);
                if (obj3 instanceof Integer) {
                    this.aE = ((Integer) obj3).intValue();
                }
            }
            if (map.containsKey(k)) {
                Object obj4 = map.get(k);
                if (obj4 instanceof Integer) {
                    this.aF = ((Integer) obj4).intValue();
                }
            }
            if (map.containsKey(l)) {
                Object obj5 = map.get(l);
                if (obj5 instanceof Boolean) {
                    this.aG = ((Boolean) obj5).booleanValue();
                }
            }
            if (map.containsKey(m)) {
                Object obj6 = map.get(m);
                if (obj6 instanceof String) {
                    this.aH = (String) obj6;
                }
            }
            this.aI = true;
        }
    }

    private void au() {
        Context context;
        if (this.aI || (context = this.s) == null) {
            return;
        }
        try {
            MediationUtilsManager mediationUtilsManager = MediationUtilsManager.getInstance(context);
            mediationUtilsManager.setDebugMode(G());
            if (this.aF < 0) {
                this.aF = mediationUtilsManager.getTotalScore();
            }
            if (this.aE < 0) {
                this.aE = mediationUtilsManager.getDynamicScore();
            }
            if (!this.aG) {
                this.aG = ae();
            }
            mediationUtilsManager.startMonitoring(new AnonymousClass9(), 5000L);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.common.d.s$9, reason: invalid class name */
    final class AnonymousClass9 implements DevicePerformanceGrader.PerformanceMonitorCallback {
        @Override // com.varbto.utils.performance.DevicePerformanceGrader.PerformanceMonitorCallback
        public final void onGpuUpdate(float f) {
        }

        @Override // com.varbto.utils.performance.DevicePerformanceGrader.PerformanceMonitorCallback
        public final void onMemoryUpdate(float f) {
        }

        @Override // com.varbto.utils.performance.DevicePerformanceGrader.PerformanceMonitorCallback
        public final void onThermalUpdate(int i) {
        }

        AnonymousClass9() {
        }

        @Override // com.varbto.utils.performance.DevicePerformanceGrader.PerformanceMonitorCallback
        public final void onCpuUpdate(float f, float f2) {
            s.i(s.this);
        }
    }

    private void a(com.anythink.core.common.b.b bVar) {
        if (this.aI || bVar == null) {
            return;
        }
        int iA = bVar.a();
        try {
            MediationUtilsManager mediationUtilsManager = MediationUtilsManager.getInstance(this.s);
            this.aD = mediationUtilsManager.getAnrCountWithinDays(iA);
            this.aH = mediationUtilsManager.getAnrTimestampsWithinDays(iA).toString();
        } catch (Throwable unused) {
        }
    }

    public final void b(com.anythink.core.e.b bVar) {
        if (this.V) {
            return;
        }
        synchronized (this.W) {
            if (!this.V) {
                c(bVar);
                this.V = true;
            }
        }
    }

    public static void c(com.anythink.core.e.b bVar) {
        if (bVar == null) {
            return;
        }
        b().a(bVar.bc());
        com.anythink.core.common.b.f.a().f();
        com.anythink.core.common.u.b.c.a().a(com.anythink.core.common.b.e.a(bVar.be()));
        com.anythink.core.common.b.f.a().k();
    }

    public final int ab() {
        int i2 = this.aD;
        if (i2 >= 0) {
            return i2;
        }
        return 0;
    }

    public final int ac() {
        int i2 = this.aE;
        if (i2 >= 0) {
            return i2;
        }
        return 0;
    }

    public final int ad() {
        int i2 = this.aF;
        if (i2 >= 0) {
            return i2;
        }
        return 0;
    }

    public final boolean ae() {
        if (!this.aI) {
            try {
                return MediationUtilsManager.getInstance(this.s).isHighConsumption();
            } catch (Throwable unused) {
            }
        }
        return this.aG;
    }

    public final String af() {
        return this.aH;
    }

    private boolean aw() {
        return this.aI;
    }

    public final long ag() {
        return this.aq;
    }

    private void b(long j2) {
        this.aq = j2;
    }

    public final JSONObject ah() {
        return this.aJ;
    }

    public final void ai() {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.ch, new Runnable() { // from class: com.anythink.core.common.d.s.10
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.common.r.b.a().b();
            }
        }));
    }

    public final void x() {
        if (!this.d) {
            Log.e("anythink", "Please exec ATSDK.init before ATSDK.start");
        } else {
            a(new Runnable() { // from class: com.anythink.core.common.d.s.2
                @Override // java.lang.Runnable
                public final void run() {
                    r rVarC = s.b().c();
                    if (rVarC != null) {
                        rVarC.startUpDateUPID(s.this.s);
                    }
                }
            });
        }
    }

    private boolean a(long j2, long j3) {
        if (this.f == 0) {
            this.f = ad.b(this.s, t.b.a, t.a.v, 0L);
        }
        return Math.max(0L, j2 - this.f) > j3;
    }

    private void av() {
        try {
            this.aE = MediationUtilsManager.getInstance(this.s).getDynamicScore();
            this.aG = MediationUtilsManager.getInstance(this.s).isHighConsumption();
        } catch (Throwable unused) {
        }
    }

    private void a(String str, int i2) {
        com.anythink.core.e.n nVarA;
        com.anythink.core.e.l lVarF;
        try {
            Context context = this.s;
            if (context == null || (nVarA = com.anythink.core.e.n.a(context)) == null || (lVarF = nVarA.f(str)) == null) {
                return;
            }
            com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(this.s, str, String.valueOf(lVarF.ap()));
            if (fVarA != null) {
                fVarA.a(i2);
            }
        } catch (Exception unused) {
        }
    }

    private void e(String str, List<ATAdInfo> list) {
        com.anythink.core.e.n nVarA;
        com.anythink.core.e.l lVarF;
        try {
            Context context = this.s;
            if (context == null || (nVarA = com.anythink.core.e.n.a(context)) == null || (lVarF = nVarA.f(str)) == null) {
                return;
            }
            com.anythink.core.common.f fVarA = com.anythink.core.common.f.a(this.s, str, String.valueOf(lVarF.ap()));
            if (fVarA != null) {
                fVarA.a(list);
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(s sVar, Context context) {
        int iA = com.anythink.core.common.u.p.a(context, "common_custom_pg", "string");
        if (iA > 0) {
            sVar.aw = context.getResources().getString(iA);
        }
    }

    static /* synthetic */ void b(s sVar) {
        Throwable th;
        boolean zExists;
        boolean z = false;
        if (sVar.s != null) {
            try {
                zExists = new File(sVar.s.getExternalFilesDir(null), sVar.J).exists();
                if (!zExists) {
                    try {
                        zExists = new File(sVar.s.getFilesDir(), sVar.J).exists();
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
        sVar.K = z;
    }

    static /* synthetic */ void c(s sVar) {
        com.anythink.core.common.e.a.a();
        com.anythink.core.common.e.b bVarA = com.anythink.core.common.e.a.a(sVar.s);
        if (bVarA != null) {
            sVar.a(bVarA.b(), false, bVarA.a(), bVarA.c());
        }
    }

    static /* synthetic */ void b(s sVar, Context context) {
        long jCurrentTimeMillis = sVar.e;
        try {
            String strC = ad.c(b().s, t.b.a, b().t + "playRecord", "");
            if (!TextUtils.isEmpty(strC)) {
                JSONObject jSONObject = new JSONObject(strC);
                long jOptLong = jSONObject.optLong(f.a);
                long jOptLong2 = jSONObject.optLong(f.b);
                String strOptString = jSONObject.optString(f.c);
                int iOptInt = jSONObject.optInt(f.d);
                if (jCurrentTimeMillis != 0) {
                    com.anythink.core.common.t.f.a(iOptInt == 1 ? 4 : 2, jOptLong, jOptLong2, strOptString);
                } else {
                    jCurrentTimeMillis = jOptLong;
                }
                ad.b(b().s, t.b.a, b().t + "playRecord", "");
            }
        } catch (Exception unused) {
            ad.b(b().s, t.b.a, b().t + "playRecord", "");
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = ad.b(context, t.b.a, t.a.v, 0L);
        }
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        b.c().a(new f(jCurrentTimeMillis));
    }

    static /* synthetic */ void d(s sVar) {
        com.anythink.core.common.u.b.c.a().e(new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.cF, sVar.new AnonymousClass16()));
    }

    static /* synthetic */ void f(Context context) {
        if (b().c("ua")) {
            return;
        }
        try {
            if (u.a(context).b()) {
                String strJ = com.anythink.core.common.u.l.j();
                String strC = ad.c(context, t.b.a, t.a.s, "");
                if (TextUtils.isEmpty(strJ) || !Build.VERSION.RELEASE.equals(strC)) {
                    com.anythink.core.common.u.l.n(context);
                }
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void c(s sVar, Context context) {
        JSONObject cnDInfo;
        try {
            com.anythink.core.common.e.b bVar = sVar.av;
            if (bVar != null) {
                com.anythink.core.common.t.f.a(bVar);
                return;
            }
            Object objInvoke = null;
            try {
                objInvoke = Class.forName("com.anythink.network.adx.AdxATInitManager").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
            }
            if (objInvoke instanceof ATInitMediation) {
                ATInitMediation aTInitMediation = (ATInitMediation) objInvoke;
                HashMap map = new HashMap();
                map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_PRECHECK_MODE, 1);
                com.anythink.core.bridge.entity.a aVar = new com.anythink.core.bridge.entity.a();
                aVar.a();
                aVar.a(com.anythink.core.common.u.o.a());
                aVar.b(sVar.t);
                aVar.c(sVar.u);
                map.put(com.anythink.core.bridge.a.C0010a.b, com.anythink.core.bridge.c.a(aVar));
                com.anythink.core.bridge.entity.d dVar = new com.anythink.core.bridge.entity.d();
                dVar.a(sVar.C());
                r rVarC = sVar.c();
                if (rVarC != null && (cnDInfo = rVarC.getCnDInfo()) != null) {
                    String strB = af.b(com.anythink.core.bridge.b.a);
                    String strB2 = af.b(com.anythink.core.bridge.b.d);
                    String strB3 = af.b(com.anythink.core.bridge.b.c);
                    String strB4 = af.b(com.anythink.core.bridge.b.b);
                    dVar.c(cnDInfo.optString(strB));
                    dVar.h(cnDInfo.optString(strB2));
                    dVar.j(cnDInfo.optString(strB3));
                    dVar.i(cnDInfo.optString(strB4));
                }
                dVar.k(com.anythink.core.common.u.l.d(context));
                dVar.d(com.anythink.core.common.u.l.p(context));
                dVar.f(com.anythink.core.common.u.l.I());
                dVar.g(com.anythink.core.common.u.l.J());
                map.put(com.anythink.core.bridge.a.C0010a.a, com.anythink.core.bridge.c.a(dVar));
                String[] strArrF = sVar.f();
                if (strArrF != null && strArrF.length > 0) {
                    map.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADX_DENNY_DEVICE_INFO, strArrF);
                }
                aTInitMediation.initSDK(context, map, sVar.new AnonymousClass17(context));
            }
        } catch (Throwable unused2) {
        }
    }

    static /* synthetic */ void a(s sVar, Context context, ATNetworkConfig aTNetworkConfig) {
        if (aTNetworkConfig == null) {
            aTNetworkConfig = new ATNetworkConfig();
        }
        List<ATInitConfig> aTInitConfigList = aTNetworkConfig.getATInitConfigList();
        if (aTInitConfigList == null) {
            aTInitConfigList = new ArrayList<>(2);
        }
        try {
            if (sVar.A()) {
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
        sVar.S = aTInitConfigList.size() > 0;
        for (ATInitConfig aTInitConfig3 : aTInitConfigList) {
            if (aTInitConfig3 != null) {
                if (aTInitConfig != null && TextUtils.equals(aTInitConfig.getClass().getSimpleName(), aTInitConfig3.getClass().getSimpleName())) {
                    if (!z) {
                        z = true;
                    }
                }
                a(sVar.new AnonymousClass8(aTInitConfig3, context));
            }
        }
    }

    static /* synthetic */ void i(s sVar) {
        try {
            sVar.aE = MediationUtilsManager.getInstance(sVar.s).getDynamicScore();
            sVar.aG = MediationUtilsManager.getInstance(sVar.s).isHighConsumption();
        } catch (Throwable unused) {
        }
    }
}
