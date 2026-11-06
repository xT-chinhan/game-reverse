package com.anythink.core.common.v;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.AdError;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ac {
    private static volatile ac f;
    private volatile String k;
    private volatile String l;
    private volatile String m;
    private volatile String n;
    private File p;
    private final String e = "ac";
    private final String g = k.b("aHR0cHM6Ly9kMnExeTd0aXIyODF4Ni5jbG91ZGZyb250Lm5ldC9vbXNkay9vbXNka192MS41LjIuanM=");
    private final String h = k.b("aHR0cHM6Ly9kMnExeTd0aXIyODF4Ni5jbG91ZGZyb250Lm5ldC9vbXNkay9vbXNka193ZWJ2aWV3X2luamVjdGlvbl9jb250ZW50LnR4dA==");
    private final String i = "omsdk_sdk_js.txt";
    private final String j = "omsdk_webview_injection_content.txt";
    private final String o = "anythink_omsdk/";
    boolean a = false;
    boolean b = false;
    final String c = "omsdk_sdk_js_url";
    final String d = "omsdk_webview_injection_content_url";
    private final Object q = new Object();
    private String r = "";
    private String s = "";
    private String t = "";
    private String u = "";

    public static ac a() {
        if (f == null) {
            synchronized (ac.class) {
                if (f == null) {
                    f = new ac();
                }
            }
        }
        return f;
    }

    public final void a(final Context context) {
        try {
            this.p = new File(com.anythink.core.common.d.t.b().g().getFilesDir().getAbsoluteFile().getAbsolutePath() + "/anythink_omsdk/");
        } catch (Throwable unused) {
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.core.common.v.ac.1
            @Override // java.lang.Runnable
            public final void run() {
                ac.this.f(context);
                ac.this.g(context);
                ac acVar = ac.this;
                acVar.l = acVar.a("omsdk_sdk_js.txt");
                ac acVar2 = ac.this;
                acVar2.n = acVar2.a("omsdk_webview_injection_content.txt");
            }
        }, 2);
    }

    public final boolean b(Context context) {
        boolean zB;
        if (this.a) {
            return false;
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(context).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null && !bVarB.R()) {
            zB = b();
        } else {
            com.anythink.core.common.d.t.b();
            zB = false;
        }
        if (!zB) {
            return false;
        }
        String strAL = (bVarB == null || bVarB.R()) ? "" : bVarB.aL();
        if (TextUtils.isEmpty(strAL)) {
            strAL = this.g;
        }
        if (TextUtils.isEmpty(strAL) || TextUtils.equals(this.s, strAL)) {
            return false;
        }
        String strE = e();
        if (!TextUtils.isEmpty(strE) && TextUtils.equals(strE, strAL)) {
            if (TextUtils.isEmpty(this.l)) {
                this.l = a("omsdk_sdk_js.txt");
            }
            return false;
        }
        this.k = strAL;
        return true;
    }

    public final void c(final Context context) {
        if (b(context)) {
            this.a = true;
            try {
                new com.anythink.core.common.m.h(this.k).a(1, new com.anythink.core.common.m.q() { // from class: com.anythink.core.common.v.ac.2
                    @Override // com.anythink.core.common.m.q
                    public final void onLoadStart(int i) {
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadFinish(int i, Object obj) {
                        String string = obj != null ? obj.toString() : "";
                        String unused = ac.this.e;
                        String unused2 = ac.this.k;
                        string.length();
                        if (!TextUtils.isEmpty(string)) {
                            ac acVar = ac.this;
                            acVar.a(context, acVar.k);
                            ac.this.l = string;
                            ac.a(ac.this, string, "omsdk_sdk_js.txt");
                        }
                        ac.this.a = false;
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadError(int i, String str, AdError adError) {
                        ac acVar = ac.this;
                        acVar.s = acVar.k;
                        ac.this.a = false;
                        com.anythink.core.common.u.e.a(1, ac.this.k, adError != null ? adError.printStackTrace() : "");
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadCanceled(int i) {
                        ac.this.a = false;
                    }
                });
            } catch (Throwable unused) {
                this.a = false;
            }
        }
    }

    public final boolean d(Context context) {
        boolean zB;
        if (this.b) {
            return false;
        }
        com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(context).b(com.anythink.core.common.d.t.b().p());
        if (bVarB != null && !bVarB.R()) {
            zB = b();
        } else {
            com.anythink.core.common.d.t.b();
            zB = false;
        }
        if (!zB) {
            return false;
        }
        String strAK = (bVarB == null || bVarB.R()) ? "" : bVarB.aK();
        if (TextUtils.isEmpty(strAK)) {
            strAK = this.h;
        }
        if (TextUtils.isEmpty(strAK) || TextUtils.equals(this.u, strAK)) {
            return false;
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF) && TextUtils.equals(strF, strAK)) {
            if (TextUtils.isEmpty(this.n)) {
                this.n = a("omsdk_webview_injection_content.txt");
            }
            return false;
        }
        this.m = strAK;
        return true;
    }

    public final void e(final Context context) {
        if (d(context)) {
            this.b = true;
            try {
                new com.anythink.core.common.m.h(this.m).a(1, new com.anythink.core.common.m.q() { // from class: com.anythink.core.common.v.ac.3
                    @Override // com.anythink.core.common.m.q
                    public final void onLoadStart(int i) {
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadFinish(int i, Object obj) {
                        String string = obj != null ? obj.toString() : "";
                        String unused = ac.this.e;
                        String unused2 = ac.this.m;
                        string.length();
                        if (!TextUtils.isEmpty(string)) {
                            ac acVar = ac.this;
                            acVar.b(context, acVar.m);
                            ac.this.n = string;
                            ac.a(ac.this, string, "omsdk_webview_injection_content.txt");
                        }
                        ac.this.b = false;
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadError(int i, String str, AdError adError) {
                        ac acVar = ac.this;
                        acVar.u = acVar.m;
                        ac.this.b = false;
                        com.anythink.core.common.u.e.a(2, ac.this.m, adError != null ? adError.printStackTrace() : "");
                    }

                    @Override // com.anythink.core.common.m.q
                    public final void onLoadCanceled(int i) {
                        ac.this.b = false;
                    }
                });
            } catch (Throwable unused) {
                this.b = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String a(String str) throws Throwable {
        String strA;
        synchronized (this.q) {
            strA = "";
            try {
                File file = new File(this.p, str);
                if (file.exists() && file.canRead()) {
                    strA = w.a(file);
                }
            } catch (Throwable unused) {
            }
        }
        return strA;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.v.ac$4, reason: invalid class name */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        AnonymousClass4(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (ac.this.q) {
                try {
                    if (!ac.this.p.exists()) {
                        ac.this.p.mkdirs();
                    }
                    File file = new File(ac.this.p, this.a);
                    if (file.exists()) {
                        file.delete();
                    }
                    w.a(this.b.getBytes(), file);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void a(String str, String str2) {
        com.anythink.core.common.v.b.b.a().b(new AnonymousClass4(str2, str), 2);
    }

    private String c() {
        return !b() ? "" : this.l;
    }

    private String d() {
        return !b() ? "" : this.n;
    }

    public static boolean b() {
        return com.anythink.core.d.d.a(com.anythink.core.common.d.t.b().g()).b(com.anythink.core.common.d.t.b().p()).aJ() == 1;
    }

    private synchronized String e() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(Context context, String str) {
        this.r = str;
        af.b(context, com.anythink.core.common.d.u.b.a, "omsdk_sdk_js_url", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f(Context context) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        this.r = af.c(context, com.anythink.core.common.d.u.b.a, "omsdk_sdk_js_url", "");
    }

    private synchronized String f() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(Context context, String str) {
        this.t = str;
        af.b(context, com.anythink.core.common.d.u.b.a, "omsdk_webview_injection_content_url", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Context context) {
        if (context == null) {
            context = com.anythink.core.common.d.t.b().g();
        }
        this.t = af.c(context, com.anythink.core.common.d.u.b.a, "omsdk_webview_injection_content_url", "");
    }

    static /* synthetic */ void a(ac acVar, String str, String str2) {
        com.anythink.core.common.v.b.b.a().b(acVar.new AnonymousClass4(str2, str), 2);
    }
}
