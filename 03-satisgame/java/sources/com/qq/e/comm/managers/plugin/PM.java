package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PM {
    public static final int CALL_START_BY_DEV = 1;
    private static final Map<Class<?>, String> r = new b();
    private final Context b;
    private String c;
    private File d;
    private volatile int e;
    private DexClassLoader f;
    private volatile POFactory g;
    private int h;
    private int i;
    private Future<Boolean> j;
    private boolean l;
    private String m;
    private JSONObject n;
    private int p;
    private boolean q;
    final ExecutorService a = Executors.newSingleThreadExecutor();
    private boolean k = false;
    private final com.qq.e.comm.util.b o = new com.qq.e.comm.util.b();

    class a implements Callable<Boolean> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            PM.this.o.c();
            PM.this.i();
            PM.this.o.b();
            if (PM.this.h()) {
                PM.this.i = (int) (System.currentTimeMillis() - jCurrentTimeMillis);
                PM.this.e();
            }
            PM.this.o.a();
            PM.this.h = (int) (System.currentTimeMillis() - jCurrentTimeMillis);
            return Boolean.TRUE;
        }
    }

    class b extends HashMap<Class<?>, String> {
        b() {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    }

    public PM(Context context, f fVar) {
        this.b = context.getApplicationContext();
        i.a(context);
        g();
    }

    private void b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        File file = this.d;
        if (file != null) {
            file.getAbsolutePath();
        }
        if (this.c == null || this.d == null) {
            this.f = null;
            return;
        }
        try {
            this.f = new DexClassLoader(this.d.getAbsolutePath(), h.b(this.b).getAbsolutePath(), null, getClass().getClassLoader());
            j();
        } catch (Throwable th) {
            GDTLogger.e("插件ClassLoader构造发生异常", th);
            b();
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
        }
    }

    private boolean f() {
        if (this.l) {
            return false;
        }
        g gVar = new g(h.c(this.b), h.d(this.b));
        if (gVar.a(this.b, false)) {
            this.p = 3;
            gVar.a(h.c(this.b, gVar.c()), h.f(this.b), this.b);
        }
        g gVar2 = new g(h.f(this.b));
        if (!gVar2.a(this.b, true)) {
            return false;
        }
        if (gVar2.c() < SDKStatus.getBuildInPluginVersion()) {
            SDKStatus.getBuildInPluginVersion();
            return false;
        }
        this.c = gVar2.b();
        this.e = gVar2.c();
        this.d = gVar2.a();
        this.m = gVar2.d();
        this.k = true;
        if (this.p == 0) {
            this.p = 2;
            this.q = h.a(this.b, this.e);
            this.o.b();
        }
        return true;
    }

    private void g() {
        this.k = false;
        this.j = this.a.submit(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        try {
            System.currentTimeMillis();
            boolean zF = f();
            this.o.b();
            if (zF) {
                this.o.b();
                System.currentTimeMillis();
                return true;
            }
            boolean zD = d();
            this.o.b();
            System.currentTimeMillis();
            return zD;
        } catch (Throwable th) {
            try {
                GDTLogger.e("插件加载出现异常", th);
                com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
                return false;
            } finally {
                System.currentTimeMillis();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("start_crash", 0);
        if (sharedPreferences.getInt("crash_count", 0) >= 2) {
            this.l = true;
            sharedPreferences.edit().remove("crash_count").commit();
            GDTLogger.e("加载本地插件");
        }
    }

    private void j() {
    }

    private void k() {
        Future<Boolean> future = this.j;
        if (future != null) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public <T> T getFactory(Class<T> cls) throws e {
        k();
        new StringBuilder("GetFactoryInstaceforInterface:").append(cls);
        ClassLoader classLoaderC = c();
        getClass().getClassLoader();
        if (classLoaderC == null) {
            throw new e("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
        try {
            String str = r.get(cls);
            if (TextUtils.isEmpty(str)) {
                throw new e("factory  implemention name is not specified for interface:" + cls.getName());
            }
            Class<?> clsLoadClass = classLoaderC.loadClass(str);
            T tCast = cls.cast(clsLoadClass.getDeclaredMethod("getInstance", Context.class, JSONObject.class).invoke(clsLoadClass, this.b, a()));
            new StringBuilder("ServiceDelegateFactory =").append(tCast);
            return tCast;
        } catch (Throwable th) {
            throw new e("Fail to getfactory implement instance for interface:" + cls.getName(), th);
        }
    }

    public POFactory getPOFactory() throws e {
        return getPOFactory(true, false);
    }

    public int getPluginVersion() {
        k();
        return this.e;
    }

    public JSONObject getStartCaller(int i) {
        if (this.n == null) {
            this.n = new JSONObject();
        }
        try {
            this.n.put("scr", i);
        } catch (JSONException unused) {
        }
        return this.n;
    }

    private ClassLoader c() {
        return Sig.ASSET_PLUGIN_SIG == null ? getClass().getClassLoader() : this.f;
    }

    private boolean d() {
        try {
            this.p = 1;
            Context context = this.b;
            this.d = com.qq.e.comm.managers.plugin.b.a(context, h.f(context));
            this.c = Sig.ASSET_PLUGIN_SIG;
            this.e = SDKStatus.getBuildInPluginVersion();
            return true;
        } catch (Throwable th) {
            GDTLogger.e("插件初始化失败 ");
            com.qq.e.comm.managers.plugin.a.a(th, th.getMessage());
            return false;
        }
    }

    public POFactory getPOFactory(boolean z, boolean z2) throws e {
        if (this.g == null) {
            synchronized (this) {
                if (this.g == null) {
                    try {
                        this.g = (POFactory) getFactory(POFactory.class);
                    } catch (e e) {
                        if (!this.k) {
                            throw e;
                        }
                        GDTLogger.e("插件加载错误，回退到内置版本");
                        this.l = true;
                        g();
                        this.g = (POFactory) getFactory(POFactory.class);
                    }
                }
            }
        }
        if (z && this.g != null) {
            this.g.start(getStartCaller(z2 ? 0 : 2));
        }
        return this.g;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int pluginVersion = getPluginVersion();
            if (pluginVersion > 10000) {
                jSONObject.put("vas", this.m);
            }
            jSONObject.put("pv", pluginVersion);
            jSONObject.put("sig", this.c);
            jSONObject.put("appId", com.qq.e.comm.managers.a.b().a());
            jSONObject.put("pn", i.a(this.b));
            jSONObject.put("ict", this.h);
            jSONObject.put("ifg", this.p);
            jSONObject.put("pct", this.i);
            jSONObject.put("tcr", this.o.toString());
            jSONObject.put("dot", this.q);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
