package com.smartdigimkt.sdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.anythink.core.common.d.t;
import com.smartdigimkt.c4.d;
import com.smartdigimkt.f.i;
import com.smartdigimkt.f3.c;
import com.smartdigimkt.o4.e;
import com.smartdigimkt.q2.f;
import com.smartdigimkt.r4.h;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.api.IDlHandler;
import com.smartdigimkt.sdk.api.IExHandler;
import com.smartdigimkt.sdk.api.IOdHandler;
import com.smartdigimkt.sdk.api.SDMDebuggerConfig;
import com.smartdigimkt.sdk.api.SDMInitConfig;
import com.smartdigimkt.sdk.api.SDMSDK;
import com.smartdigimkt.sdk.core.bridge.entity.AppInfoEntity;
import com.smartdigimkt.sdk.core.net.interceptor.IHttpLoaderInterceptor;
import com.smartdigimkt.w3.a;
import com.smartdigimkt.x3.b;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class SDKContext {
    public static volatile SDKContext K;
    public static final Object L = new Object();
    public static final Object M = new Object();
    public SDMDebuggerConfig A;
    public boolean B;
    public f G;
    public String a;
    public String b;
    public volatile Context c;
    public volatile boolean d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile SDMInitConfig g;
    public String h;
    private volatile IHttpLoaderInterceptor httpLoaderInterceptor;
    public volatile boolean l;
    public long n;
    public volatile String u;
    public volatile String v;
    public volatile String w;
    public volatile String x;
    public String z;
    public String i = "";
    public String j = "";
    public final ConcurrentHashMap k = new ConcurrentHashMap();
    public long m = 0;
    public long o = 0;
    public boolean t = false;
    public boolean C = false;
    public boolean D = false;
    public final Object F = new Object();
    public final AtomicBoolean H = new AtomicBoolean(false);
    public volatile String I = "";
    public volatile long J = 0;
    public final a p = new a();
    public final com.smartdigimkt.t3.a q = new com.smartdigimkt.t3.a();
    public final com.smartdigimkt.u3.a r = new com.smartdigimkt.u3.a();
    public final b s = new b();
    public final ConcurrentHashMap E = new ConcurrentHashMap();
    public final String y = i.a(new StringBuilder(), File.separator, "sdm.test");

    public static void a(SDKContext sDKContext, Context context) {
        sDKContext.getClass();
        long jB = y.b(context, "sdm_adx_rp_sdk", t.a.z);
        sDKContext.m = jB;
        if (jB == 0) {
            long j = sDKContext.n;
            sDKContext.m = j;
            y.a(context, "sdm_adx_rp_sdk", t.a.z, j);
        }
        Date date = new Date(sDKContext.n);
        long time = new Date(date.getYear(), date.getMonth(), date.getDate()).getTime();
        Date date2 = new Date(sDKContext.m);
        sDKContext.o = ((time - new Date(date2.getYear(), date2.getMonth(), date2.getDate()).getTime()) / 86400000) + 1;
    }

    public static void c(SDKContext sDKContext) {
        Context contextD;
        Context context = sDKContext.c;
        try {
            h.a(sDKContext.k);
            h.h(context);
            h.w(context);
            com.smartdigimkt.w2.b bVarE = getInstance().e();
            if (bVarE != null) {
                bVarE.initDeviceInfo(context);
            }
            h.r();
            h.p(context);
            h.v(context);
            h.u(context);
            h.y(context);
            h.q();
            h.s();
            h.b(context);
            h.n(context);
            h.v();
            h.x(context);
            h.t(context);
            h.f(context);
            h.i(context);
            if (h.a("mcc") || h.a("mnc")) {
                if (context != null) {
                    contextD = context;
                } else {
                    try {
                        contextD = getInstance().d();
                    } catch (Throwable unused) {
                    }
                }
                com.smartdigimkt.y2.b.b(contextD);
            }
            h.y();
            h.m();
            h.t();
            h.l(context);
            h.m(context);
            if (!h.c(com.anythink.core.common.l.f.aR)) {
                if (h.F == null) {
                    h.F = k.b() ? "1" : "0";
                }
                String str = h.a;
            }
            h.k();
            h.j();
            h.l();
            h.h();
            h.b();
            h.e();
            h.f();
            h.c();
            h.g();
            h.i();
            h.d();
            if (!h.C()) {
                if (h.R == null) {
                    try {
                        h.R = String.valueOf(1);
                    } catch (Throwable unused2) {
                        h.R = "";
                    }
                }
                String str2 = h.a;
            }
            h.a();
        } catch (Exception unused3) {
        }
    }

    public static SDKContext getInstance() {
        if (K == null) {
            synchronized (SDKContext.class) {
                if (K == null) {
                    K = new SDKContext();
                }
            }
        }
        return K;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = y.c(this.c, "sdm_adx_rp_sdk", "sdm_adx_rp_appkey");
        }
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        AppInfoEntity appInfoEntity = h.X;
        if (appInfoEntity != null) {
            String mediationAppKey = appInfoEntity.getMediationAppKey();
            if (!TextUtils.isEmpty(mediationAppKey)) {
                return mediationAppKey;
            }
        }
        return this.b;
    }

    public final Context d() {
        if (this.c != null) {
            return this.c;
        }
        try {
            Object objInvoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
            if (objInvoke instanceof Application) {
                this.c = ((Application) objInvoke).getApplicationContext();
            }
        } catch (Throwable unused) {
        }
        return this.c;
    }

    public final com.smartdigimkt.w2.b e() {
        IExHandler iExHandler;
        IDlHandler iDlHandler;
        com.smartdigimkt.t3.a aVar = this.q;
        if (aVar.a) {
            return aVar.c;
        }
        synchronized (aVar.b) {
            if (aVar.a) {
                return aVar.c;
            }
            IOdHandler iOdHandler = null;
            try {
                iExHandler = (IExHandler) com.smartdigimkt.t3.a.a(IExHandler.class, "com.smartdigimkt.pd.ExHandler");
            } catch (Throwable unused) {
                iExHandler = null;
            }
            try {
                iDlHandler = (IDlHandler) com.smartdigimkt.t3.a.a(IDlHandler.class, "com.smartdigimkt.dlpd.DlHandler");
            } catch (Throwable unused2) {
                iDlHandler = null;
            }
            try {
                iOdHandler = (IOdHandler) com.smartdigimkt.t3.a.a(IOdHandler.class, "com.smartdigimkt.odpd.OdHandler");
            } catch (Throwable unused3) {
            }
            if (iExHandler != null || iDlHandler != null || iOdHandler != null) {
                Objects.toString(iExHandler);
                Objects.toString(iDlHandler);
                Objects.toString(iOdHandler);
                aVar.c = new com.smartdigimkt.w2.b(iExHandler, iDlHandler, iOdHandler);
            }
            aVar.a = true;
            return aVar.c;
        }
    }

    public final String f() {
        try {
            if (TextUtils.isEmpty(this.u)) {
                a(d(), a());
            }
        } catch (Exception unused) {
        }
        return this.u;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.w)) {
            this.w = y.c(this.c, t.b.f, t.a.B);
        }
        return this.w;
    }

    public IHttpLoaderInterceptor getHttpLoaderInterceptor() {
        if (this.httpLoaderInterceptor == null) {
            synchronized (M) {
                if (this.httpLoaderInterceptor == null) {
                    this.httpLoaderInterceptor = new d(this.c);
                }
            }
        }
        return this.httpLoaderInterceptor;
    }

    public final String h() {
        if (TextUtils.isEmpty(this.v)) {
            this.v = y.c(this.c, "sdm_adx_rp_sdk", t.a.w);
        }
        return this.v;
    }

    public final boolean i() {
        return this.B && this.A != null;
    }

    public final boolean j() {
        return this.C || this.D;
    }

    public final void k() {
        synchronized (L) {
            if (this.f) {
                return;
            }
            this.f = true;
            this.t = k.b();
            com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.q2.d(this), 0L, 7);
        }
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = (String) this.E.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String strB = (String) this.E.get(str);
        if (TextUtils.isEmpty(strB)) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            strB = com.smartdigimkt.r4.i.b(str + f());
            try {
                this.E.put(str, strB);
            } catch (Exception unused) {
            }
            String str3 = jCurrentTimeMillis + "";
            c cVar = new c(null, null);
            cVar.a = "3000004";
            cVar.c = str;
            cVar.l = "2";
            cVar.m = null;
            cVar.n = str3;
            com.smartdigimkt.n3.k.a(cVar);
        }
        return strB;
    }

    public final void a(Context context, SDMInitConfig sDMInitConfig) {
        Objects.toString(context);
        Objects.toString(sDMInitConfig);
        synchronized (L) {
            if (context != null) {
                if (context instanceof Activity) {
                    this.c = context.getApplicationContext();
                } else {
                    this.c = context;
                }
            }
            if (context == null) {
                return;
            }
            if (sDMInitConfig == null) {
                return;
            }
            if (this.d) {
                return;
            }
            this.d = true;
            this.g = sDMInitConfig;
            if (context instanceof Application) {
                com.smartdigimkt.r3.c.a().a((Application) context);
            }
            this.n = System.currentTimeMillis();
            String appId = sDMInitConfig.getAppId();
            String appKey = sDMInitConfig.getAppKey();
            String bundleName = sDMInitConfig.getBundleName();
            if (!TextUtils.isEmpty(bundleName)) {
                this.h = bundleName;
            }
            this.j = sDMInitConfig.getSystemDevFrameworkType();
            this.A = sDMInitConfig.getDebuggerConfig();
            try {
                Map<String, Object> extraMap = sDMInitConfig.getExtraMap();
                if (extraMap != null) {
                    this.k.clear();
                    for (Map.Entry<String, Object> entry : extraMap.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (key != null && value != null) {
                            this.k.put(key, value);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            this.a = appId;
            this.b = appKey;
            com.smartdigimkt.q3.f.a().a(new com.smartdigimkt.q2.b(this, appId, appKey, context), 0L, 7);
        }
    }

    public static void b(SDKContext sDKContext) {
        Context contextD = sDKContext.d();
        if (contextD != null) {
            try {
                f fVar = sDKContext.G;
                if (fVar != null) {
                    contextD.unregisterReceiver(fVar);
                    com.smartdigimkt.w2.a.a(contextD).a(sDKContext.G);
                }
                sDKContext.G = null;
            } catch (Throwable unused) {
            }
            try {
                sDKContext.G = new f(sDKContext);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                contextD.registerReceiver(sDKContext.G, intentFilter);
                com.smartdigimkt.w2.a.a(contextD).a(sDKContext.G, intentFilter);
            } catch (Throwable unused2) {
            }
        }
    }

    public final String c() {
        if (TextUtils.isEmpty(this.x)) {
            this.x = y.c(this.c, t.b.f, t.a.C);
        }
        return this.x;
    }

    public final void a(SDMSDK.InitCallBack initCallBack, String str) {
        if (initCallBack == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            initCallBack.fail(str);
            return;
        }
        String str2 = this.s.c;
        if (!TextUtils.isEmpty(str2)) {
            initCallBack.fail(str2);
        } else {
            initCallBack.success();
        }
    }

    public final void a(SDMSDK.InitCallBack initCallBack) {
        synchronized (L) {
            if (!this.d) {
                a(initCallBack, "Please call init method first.");
                return;
            }
            if (this.c == null) {
                a(initCallBack, "The context can not be null or empty.");
                return;
            }
            if (this.g == null) {
                a(initCallBack, "The sdmInitConfig can not be null or empty.");
                return;
            }
            if (TextUtils.isEmpty(this.a)) {
                a(initCallBack, "The appId can not be null or empty.");
                return;
            }
            if (TextUtils.isEmpty(this.b)) {
                a(initCallBack, "The appKey can not be null or empty.");
                return;
            }
            if (this.e) {
                a(initCallBack, "");
                return;
            }
            Context context = this.c;
            Map<String, Object> extraMap = this.g.getExtraMap();
            com.smartdigimkt.q2.c cVar = new com.smartdigimkt.q2.c(this, initCallBack);
            b bVar = this.s;
            if (bVar.c != null) {
                if (TextUtils.isEmpty(bVar.c)) {
                    cVar.onValidationSucceed();
                } else {
                    cVar.onValidationFail(bVar.c);
                }
            } else {
                com.smartdigimkt.q3.f.a().c(new com.smartdigimkt.x3.a(bVar, cVar, extraMap, context));
            }
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.a)) {
            this.a = y.c(this.c, "sdm_adx_rp_sdk", "sdm_adx_rp_appid");
        }
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        AppInfoEntity appInfoEntity = h.X;
        if (appInfoEntity != null) {
            String mediationAppId = appInfoEntity.getMediationAppId();
            if (!TextUtils.isEmpty(mediationAppId)) {
                return mediationAppId;
            }
        }
        return this.a;
    }

    public final boolean a(String str) {
        a aVar = this.p;
        return aVar != null && aVar.a.contains(str);
    }

    public final void a(Context context) {
        if (context != null && this.c == null) {
            this.c = context;
        }
    }

    public static void a(SDKContext sDKContext) {
        boolean zExists = false;
        if (sDKContext.c != null) {
            try {
                zExists = new File(sDKContext.c.getExternalFilesDir(null), sDKContext.y).exists();
                if (!zExists) {
                    zExists = new File(sDKContext.c.getFilesDir(), sDKContext.y).exists();
                }
            } catch (Throwable unused) {
            }
        }
        sDKContext.C = zExists;
    }

    public final void a(Context context, SDMDebuggerConfig sDMDebuggerConfig) {
        com.smartdigimkt.w2.b bVarE;
        if (context == null || sDMDebuggerConfig == null) {
            return;
        }
        if (this.c == null) {
            SDKContext sDKContext = getInstance();
            Context applicationContext = context.getApplicationContext();
            sDKContext.getClass();
            if (applicationContext != null) {
                if (applicationContext instanceof Activity) {
                    sDKContext.c = applicationContext.getApplicationContext();
                } else {
                    sDKContext.c = applicationContext;
                }
            }
        }
        this.z = sDMDebuggerConfig.getDeviceId();
        this.A = sDMDebuggerConfig;
        String strB = h.b(context);
        this.B = (!TextUtils.isEmpty(strB) && strB.equals(this.z)) || ((bVarE = getInstance().e()) != null && bVarE.checkDebuggerDevice(context, this.z));
        if (TextUtils.isEmpty(this.z)) {
            this.B = false;
        }
    }

    public final void a(Context context, String str) {
        boolean z;
        com.smartdigimkt.p4.a aVarA = e.c().a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = aVarA.p;
        synchronized (this.F) {
            if (this.J == 0) {
                this.J = y.b(this.c, "sdm_adx_rp_sdk", t.a.v);
            }
            if (Math.max(0L, jCurrentTimeMillis - this.J) > j) {
                this.u = com.smartdigimkt.r4.i.b(str + jCurrentTimeMillis);
                this.J = jCurrentTimeMillis;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.E.clear();
            HashMap map = new HashMap();
            map.put(t.a.t, this.u);
            map.put(t.a.v, Long.valueOf(jCurrentTimeMillis));
            if (context != null) {
                try {
                    com.smartdigimkt.k4.c.a().a(context, "sdm_adx_rp_sdk").a(map);
                } catch (Throwable unused) {
                }
            }
            c cVar = new c(null, null);
            cVar.a = "3000004";
            cVar.c = null;
            cVar.l = "1";
            cVar.m = null;
            cVar.n = jCurrentTimeMillis + "";
            com.smartdigimkt.n3.k.a(cVar);
            return;
        }
        if (TextUtils.isEmpty(this.u)) {
            synchronized (this.F) {
                if (TextUtils.isEmpty(this.u)) {
                    this.u = y.c(context, "sdm_adx_rp_sdk", t.a.t);
                }
            }
        }
    }
}
