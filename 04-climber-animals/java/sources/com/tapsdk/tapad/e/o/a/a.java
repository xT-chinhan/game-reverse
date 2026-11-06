package com.tapsdk.tapad.e.o.a;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static final String k = "ExpOAIDClient";
    private Class<?> c;
    private Class<?> d;
    private Class<?> e;
    private Class<?> f;
    private boolean a = false;
    private boolean b = false;
    private Method g = null;
    ExecutorService h = Executors.newSingleThreadExecutor();
    private List<String> i = Arrays.asList("00000000-0000-0000-0000-000000000000", "0000000000000000000000000000000000000000000000000000000000000000", "00000-00000-00000-00000");
    public k j = new k.b().a(0).a(Constants.l.a).a();

    /* JADX INFO: renamed from: com.tapsdk.tapad.e.o.a.a$a, reason: collision with other inner class name */
    class CallableC0590a implements Callable<k> {
        final /* synthetic */ d a;
        final /* synthetic */ Context b;

        CallableC0590a(d dVar, Context context) {
            this.a = dVar;
            this.b = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k call() throws Exception {
            String str;
            String str2;
            d dVar = this.a;
            if (dVar == null || this.b == null) {
                if (dVar == null) {
                    str = "ExpOAIDClient 请检查初始化的监听回调是否正确设置";
                    str2 = "initListener is null";
                } else {
                    str = "ExpOAIDClient 请检查 context 是否正确设置";
                    str2 = "context is null";
                }
                com.tapsdk.tapad.e.o.a.l.a.b(str);
                throw new RuntimeException(str2);
            }
            if (a.this.b && a.this.a) {
                com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClient no need to re-initialize");
                return a.this.j;
            }
            if (!a.this.c(this.b)) {
                a.this.b = true;
                com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient The MSA OAID SDK is Not imported into the project / UnSupported MSA OAID SDK version");
                return new k.b().a(1001).a(Constants.l.e).a();
            }
            if (!a.this.a(this.b)) {
                a.this.b = true;
                return new k.b().a(1002).a(Constants.l.f).a();
            }
            a.this.a = true;
            a.this.b = true;
            return a.this.j;
        }
    }

    class b implements Callable<com.tapsdk.tapad.internal.tracker.experiment.entities.a<k, String>> {
        final /* synthetic */ c a;
        final /* synthetic */ Context b;

        /* JADX INFO: renamed from: com.tapsdk.tapad.e.o.a.a$b$a, reason: collision with other inner class name */
        class C0591a implements InvocationHandler {
            final /* synthetic */ StringBuilder a;
            final /* synthetic */ k.b b;
            final /* synthetic */ CountDownLatch c;

            C0591a(StringBuilder sb, k.b bVar, CountDownLatch countDownLatch) {
                this.a = sb;
                this.b = bVar;
                this.c = countDownLatch;
            }

            /* JADX WARN: Code duplicated, block: B:17:0x0093  */
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                String str;
                StringBuilder sbAppend;
                com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClientMSA Fetch Callback " + method.getName() + " invoked");
                try {
                    if ("OnSupport".equals(method.getName())) {
                        if (((Boolean) objArr[0]).booleanValue()) {
                            str = (String) a.this.e.getDeclaredMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                            sbAppend = new StringBuilder("ExpOAIDClient MSA Fetch OAID Result_1:").append(str);
                            com.tapsdk.tapad.e.o.a.l.a.c(sbAppend.toString());
                        } else {
                            str = "";
                        }
                    } else if ("onSupport".equals(method.getName())) {
                        str = (String) a.this.e.getDeclaredMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]);
                        sbAppend = new StringBuilder("ExpOAIDClient MSA Fetch OAID Result_2:").append(str);
                        com.tapsdk.tapad.e.o.a.l.a.c(sbAppend.toString());
                    } else {
                        str = "";
                    }
                    if (str == null || str.length() <= 0) {
                        return null;
                    }
                    if (a.this.i.contains(str)) {
                        this.b.a(2005).a(Constants.l.m);
                    } else {
                        this.a.append(str);
                    }
                    this.c.countDown();
                    return null;
                } catch (Throwable unused) {
                    this.b.a(2003).a(Constants.l.k);
                    this.c.countDown();
                    return null;
                }
            }
        }

        b(c cVar, Context context) {
            this.a = cVar;
            this.b = context;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.tapsdk.tapad.internal.tracker.experiment.entities.a<k, String> call() throws Exception {
            com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClient Fetch start");
            if (this.a == null) {
                com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient 请检查获取 OAID 监听回调是否正确设置");
                throw new RuntimeException("fetchOAIDListener is null");
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            StringBuilder sb = new StringBuilder();
            k.b bVar = new k.b();
            C0591a c0591a = new C0591a(sb, bVar, countDownLatch);
            try {
                com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClient Call MSA Interface(InitSdk) to Fetch OAID");
                Object objInvoke = a.this.c.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, a.this.d).invoke(null, this.b, Boolean.TRUE, Proxy.newProxyInstance(this.b.getClassLoader(), new Class[]{a.this.d}, c0591a));
                if (objInvoke == null) {
                    com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient 获取 OAID 接口返回值出错:无返回值");
                    bVar.a(2002).a(Constants.l.j);
                    return com.tapsdk.tapad.internal.tracker.experiment.entities.a.a(bVar.a(), "");
                }
                int iIntValue = ((Integer) objInvoke).intValue();
                if (1008614 == iIntValue || 1008610 == iIntValue) {
                    if (countDownLatch.await(9000L, TimeUnit.MILLISECONDS) && sb.length() > 0) {
                        bVar.a(0).a(Constants.l.a);
                    }
                    return com.tapsdk.tapad.internal.tracker.experiment.entities.a.a(bVar.a(), sb.toString());
                }
                com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient 获取 OAID 接口返回值出错:错误的返回值:" + iIntValue);
                countDownLatch.countDown();
                bVar.a(2001).a(a.b(iIntValue));
                return com.tapsdk.tapad.internal.tracker.experiment.entities.a.a(bVar.a(), "");
            } catch (Throwable th) {
                com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient 获取 OAID 接口反射方法报错:" + th);
                countDownLatch.countDown();
                bVar.a(2002).a(Constants.l.j);
                return com.tapsdk.tapad.internal.tracker.experiment.entities.a.a(bVar.a(), "");
            }
        }
    }

    public interface c {
        void a(k kVar, String str);
    }

    public interface d {
        void a(k kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        if (this.g == null) {
            com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClient The currentVersion does not require configuration of certificates");
            return true;
        }
        try {
            com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClient Certificate configuration starts");
            String strB = b(context);
            if (TextUtils.isEmpty(strB)) {
                com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient The certificate configuration is abnormal; Pls check certificate file name is ${packageName}.cert.pem and file is placed in the src/main/assets");
                return false;
            }
            Object objInvoke = this.g.invoke(null, context, strB);
            if (objInvoke != null ? ((Boolean) objInvoke).booleanValue() : true) {
                com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClient certificate configuration successful");
                return true;
            }
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient Failed to initialize the certificate, Pls check whether certificate information is corrected");
            return false;
        } catch (Throwable unused) {
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient certificate configuration failed:unknown error");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i) {
        switch (i) {
            case Constants.i.e /* 1008611 */:
                return Constants.j.c;
            case Constants.i.c /* 1008612 */:
                return Constants.j.a;
            case Constants.i.d /* 1008613 */:
                return Constants.j.b;
            case Constants.i.a /* 1008614 */:
            default:
                return "";
            case Constants.i.f /* 1008615 */:
                return Constants.j.d;
        }
    }

    public static String b(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(context.getPackageName() + ".cert.pem")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return sb.toString();
                }
                sb.append(line);
                sb.append('\n');
            }
        } catch (Exception unused) {
            TapADLogger.e("loadPemFromAssetFile failed");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(Context context) {
        String str;
        com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClient prepare invoke");
        try {
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            this.c = cls;
            try {
                this.g = cls.getMethod("InitCert", Context.class, String.class);
            } catch (NoSuchMethodException unused) {
                com.tapsdk.tapad.e.o.a.l.a.a("don't need load cert");
            }
            try {
                try {
                    try {
                        this.d = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                        this.e = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                        return true;
                    } catch (Exception unused2) {
                        this.d = Class.forName("com.bun.supplier.IIdentifierListener");
                        this.e = Class.forName("com.bun.supplier.IdSupplier");
                        this.f = Class.forName("com.bun.miitmdid.core.JLibrary");
                        return true;
                    }
                } catch (Exception unused3) {
                    if (this.f != null) {
                        try {
                            com.tapsdk.tapad.e.o.a.l.a.c("ExpOAIDClientjLibrary 初始化");
                            this.f.getDeclaredMethod("InitEntry", Context.class).invoke(null, context);
                        } catch (Throwable unused4) {
                            str = "ExpOAIDClientjLibrary 异常，当前版本暂时不支持获取 OAID";
                            com.tapsdk.tapad.e.o.a.l.a.b(str);
                            return false;
                        }
                    }
                    boolean z = this.c == null || this.d == null || this.e == null;
                    if (z) {
                        com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient 请检查是否正确引入 MSA OAID SDK");
                    }
                    return !z;
                }
            } catch (Exception unused5) {
                this.d = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                this.e = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                this.f = Class.forName("com.bun.miitmdid.core.JLibrary");
                return true;
            }
        } catch (Throwable unused6) {
            str = "OAID Lack of Core Method";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(c cVar, Context context) {
        k kVarA;
        Future futureSubmit = this.h.submit(new b(cVar, context));
        try {
            com.tapsdk.tapad.internal.tracker.experiment.entities.a aVar = (com.tapsdk.tapad.internal.tracker.experiment.entities.a) futureSubmit.get(9100L, TimeUnit.MILLISECONDS);
            cVar.a((k) aVar.a, (String) aVar.b);
        } catch (InterruptedException e) {
            e = e;
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient fetchTask failed " + e.getMessage());
            kVarA = new k.b().a(2004).a(Constants.l.l).a();
            cVar.a(kVarA, "");
        } catch (ExecutionException e2) {
            e = e2;
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient fetchTask failed " + e.getMessage());
            kVarA = new k.b().a(2004).a(Constants.l.l).a();
            cVar.a(kVarA, "");
        } catch (TimeoutException unused) {
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient fetchTask timed out");
            k kVarA2 = new k.b().a(2003).a(Constants.l.k).a();
            futureSubmit.cancel(true);
            kVarA = kVarA2;
            cVar.a(kVarA, "");
        }
    }

    public void a(d dVar, Context context) {
        int i;
        String str;
        Future futureSubmit = this.h.submit(new CallableC0590a(dVar, context));
        try {
            dVar.a((k) futureSubmit.get(300L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e = e;
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient initTask failed " + e.getMessage());
            i = 1004;
            str = Constants.l.h;
            dVar.a(new k.b().a(i).a(str).a());
        } catch (ExecutionException e2) {
            e = e2;
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient initTask failed " + e.getMessage());
            i = 1004;
            str = Constants.l.h;
            dVar.a(new k.b().a(i).a(str).a());
        } catch (TimeoutException unused) {
            com.tapsdk.tapad.e.o.a.l.a.b("ExpOAIDClient initTask timed out");
            futureSubmit.cancel(true);
            i = 1003;
            str = Constants.l.g;
            dVar.a(new k.b().a(i).a(str).a());
        }
    }

    public boolean a() {
        return this.a;
    }
}
