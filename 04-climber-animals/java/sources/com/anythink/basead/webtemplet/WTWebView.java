package com.anythink.basead.webtemplet;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.anythink.core.basead.ui.web.BaseWebView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WTWebView extends BaseWebView {
    private c A;
    k a;
    j b;
    c c;
    volatile boolean d;
    volatile boolean e;
    boolean f;
    private final String h;
    private long i;
    private com.anythink.core.common.t.b j;
    private w k;
    private x l;
    private boolean m;
    private Object n;
    private f o;
    private a p;
    private Object q;
    private final List<i> r;
    private volatile boolean s;
    private String t;
    private long u;
    private boolean v;
    private long w;
    private long x;
    private long y;
    private long z;

    public interface a {
        void a();
    }

    public WTWebView(Context context) {
        super(context);
        this.h = "WTWebView";
        this.i = com.tapsdk.tapad.e.a.f;
        this.d = false;
        this.e = false;
        this.q = new Object();
        this.f = false;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = false;
        this.t = "";
        this.v = false;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = new c() { // from class: com.anythink.basead.webtemplet.WTWebView.1
            @Override // com.anythink.basead.webtemplet.c
            public final void a() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void b() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void c() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void d() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, String str, Bitmap bitmap) {
                if (WTWebView.this.w == 0) {
                    WTWebView.this.w = System.currentTimeMillis();
                }
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, str, bitmap);
                }
            }

            @Override // com.anythink.basead.webtemplet.c
            public final boolean a(WebView webView, String str) {
                if (WTWebView.this.c != null) {
                    return WTWebView.this.c.a(webView, str);
                }
                return false;
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, int i, String str, String str2) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, i, str, str2);
                }
                WTWebView.this.a("", "onReceivedError:" + i + "," + str);
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, sslErrorHandler, sslError);
                }
                WTWebView.this.a("", "onReceivedSslError");
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView);
                }
                WTWebView.this.a("", "onRenderProcessGone");
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void b(WebView webView) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.b(webView);
                }
            }
        };
    }

    public WTWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = "WTWebView";
        this.i = com.tapsdk.tapad.e.a.f;
        this.d = false;
        this.e = false;
        this.q = new Object();
        this.f = false;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = false;
        this.t = "";
        this.v = false;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = new c() { // from class: com.anythink.basead.webtemplet.WTWebView.1
            @Override // com.anythink.basead.webtemplet.c
            public final void a() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void b() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void c() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void d() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, String str, Bitmap bitmap) {
                if (WTWebView.this.w == 0) {
                    WTWebView.this.w = System.currentTimeMillis();
                }
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, str, bitmap);
                }
            }

            @Override // com.anythink.basead.webtemplet.c
            public final boolean a(WebView webView, String str) {
                if (WTWebView.this.c != null) {
                    return WTWebView.this.c.a(webView, str);
                }
                return false;
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, int i, String str, String str2) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, i, str, str2);
                }
                WTWebView.this.a("", "onReceivedError:" + i + "," + str);
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, sslErrorHandler, sslError);
                }
                WTWebView.this.a("", "onReceivedSslError");
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView);
                }
                WTWebView.this.a("", "onRenderProcessGone");
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void b(WebView webView) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.b(webView);
                }
            }
        };
    }

    public WTWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = "WTWebView";
        this.i = com.tapsdk.tapad.e.a.f;
        this.d = false;
        this.e = false;
        this.q = new Object();
        this.f = false;
        this.r = Collections.synchronizedList(new ArrayList());
        this.s = false;
        this.t = "";
        this.v = false;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = 0L;
        this.A = new c() { // from class: com.anythink.basead.webtemplet.WTWebView.1
            @Override // com.anythink.basead.webtemplet.c
            public final void a() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void b() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void c() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void d() {
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, String str, Bitmap bitmap) {
                if (WTWebView.this.w == 0) {
                    WTWebView.this.w = System.currentTimeMillis();
                }
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, str, bitmap);
                }
            }

            @Override // com.anythink.basead.webtemplet.c
            public final boolean a(WebView webView, String str) {
                if (WTWebView.this.c != null) {
                    return WTWebView.this.c.a(webView, str);
                }
                return false;
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, int i2, String str, String str2) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, i2, str, str2);
                }
                WTWebView.this.a("", "onReceivedError:" + i2 + "," + str);
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView, sslErrorHandler, sslError);
                }
                WTWebView.this.a("", "onReceivedSslError");
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void a(WebView webView) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.a(webView);
                }
                WTWebView.this.a("", "onRenderProcessGone");
            }

            @Override // com.anythink.basead.webtemplet.c
            public final void b(WebView webView) {
                if (WTWebView.this.c != null) {
                    WTWebView.this.c.b(webView);
                }
            }
        };
    }

    @Override // com.anythink.core.basead.ui.web.BaseWebView
    protected final void a() {
        super.a();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        requestFocus();
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setTextZoom(100);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        try {
            settings.setSafeBrowsingEnabled(false);
        } catch (Throwable unused) {
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        try {
            settings.setAllowUniversalAccessFromFileURLs(false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            settings.setMixedContentMode(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod(com.anythink.core.common.v.k.b("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, 0);
        } catch (Throwable unused2) {
        }
        settings.setDatabaseEnabled(true);
        String path = getContext().getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        try {
            Method declaredMethod2 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(settings, Boolean.FALSE);
        } catch (Throwable unused3) {
        }
        try {
            Method declaredMethod3 = WebSettings.class.getDeclaredMethod(com.anythink.core.common.v.k.b("c2V0QWxsb3dVbml2ZXJzYWxBY2Nlc3NGcm9tRmlsZVVSTHM="), Boolean.TYPE);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(settings, Boolean.TRUE);
        } catch (Throwable unused4) {
        }
        j jVar = new j();
        this.b = jVar;
        jVar.a = this;
        jVar.b = new g(this);
        setWebChromeClient(this.b);
        k kVar = new k();
        this.a = kVar;
        kVar.a = new g(this);
        setWebViewClient(this.a);
        this.o = new f(this);
        setWebViewTransparent();
    }

    public void initData(w wVar, x xVar, boolean z) {
        this.k = wVar;
        this.l = xVar;
        this.m = z;
        if (xVar == null || xVar.o == null) {
            return;
        }
        this.i = this.l.o.bJ();
    }

    public void setWebViewListener(c cVar) {
        this.c = cVar;
        j jVar = this.b;
        if (jVar != null) {
            jVar.a(this.A);
        }
        k kVar = this.a;
        if (kVar != null) {
            kVar.a(this.A);
        }
    }

    private void b() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        requestFocus();
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setSavePassword(false);
        settings.setDatabaseEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setTextZoom(100);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        try {
            settings.setSafeBrowsingEnabled(false);
        } catch (Throwable unused) {
        }
        settings.setMediaPlaybackRequiresUserGesture(false);
        try {
            settings.setAllowUniversalAccessFromFileURLs(false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            settings.setMixedContentMode(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method declaredMethod = WebSettings.class.getDeclaredMethod(com.anythink.core.common.v.k.b("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, 0);
        } catch (Throwable unused2) {
        }
        settings.setDatabaseEnabled(true);
        String path = getContext().getDir("database", 0).getPath();
        settings.setDatabasePath(path);
        settings.setGeolocationEnabled(true);
        settings.setGeolocationDatabasePath(path);
        try {
            Method declaredMethod2 = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(settings, Boolean.FALSE);
        } catch (Throwable unused3) {
        }
        try {
            Method declaredMethod3 = WebSettings.class.getDeclaredMethod(com.anythink.core.common.v.k.b("c2V0QWxsb3dVbml2ZXJzYWxBY2Nlc3NGcm9tRmlsZVVSTHM="), Boolean.TYPE);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(settings, Boolean.TRUE);
        } catch (Throwable unused4) {
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        if (TextUtils.isEmpty(this.t)) {
            this.t = str;
            this.u = System.currentTimeMillis();
            if (this.j == null) {
                this.j = new com.anythink.core.common.t.b() { // from class: com.anythink.basead.webtemplet.WTWebView.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        WTWebView.this.h5ShowException("{\"error_code\":-999,\"error_message\":\"render timeout\"}");
                    }
                };
                com.anythink.core.common.t.d.a().a(this.j, this.i, true);
            }
        }
        super.loadUrl(str);
    }

    @Override // com.anythink.core.basead.ui.web.BaseWebView, android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f) {
            return;
        }
        this.f = true;
        notifyInnerAdEvent(301, null);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("wt_view_width", Integer.valueOf(i));
            map.put("wt_view_height", Integer.valueOf(i2));
            notifyInnerAdEvent(305, map);
        } catch (Throwable unused) {
        }
    }

    public boolean isPreload() {
        return this.m;
    }

    public void release() {
        try {
            if (this.j != null) {
                com.anythink.core.common.t.d.a().b(this.j);
                this.j = null;
            }
            setVisibility(8);
            setDownloadListener(null);
            this.n = null;
            if (this.A != null) {
                this.A = null;
            }
            if (this.c != null) {
                this.c = null;
            }
            destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWebViewTransparent() {
        setBackgroundColor(0);
        setBackgroundDrawable(null);
        setBackground(null);
    }

    private static int a(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
            return (currentWebViewPackage == null || TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) ? 0 : 5;
        } catch (Exception unused) {
        }
    }

    public Object getJsCommunicationObject() {
        return this.n;
    }

    public void setJsCommunicationObject(Object obj) {
        this.n = obj;
    }

    public Object getJsObject(String str) {
        f fVar = this.o;
        if (fVar == null) {
            return null;
        }
        return fVar.a(str);
    }

    public void prepare(a aVar) {
        this.p = aVar;
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.anythink.basead.webtemplet.WTWebView.3
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                try {
                    if (WTWebView.this.d) {
                        return false;
                    }
                    WTWebView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    WTWebView.this.d = true;
                    WTWebView.this.c();
                    return false;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            }
        });
    }

    public void jsCallInitSuccess() {
        this.x = System.currentTimeMillis();
    }

    public void offerDataInject() {
        this.y = System.currentTimeMillis();
        String string = "";
        try {
            if (getContext() == null) {
                t.b().g();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("offer_data", new JSONObject(this.k.av()));
            JSONObject jSONObject2 = new JSONObject();
            String strB = this.k.B();
            if (!TextUtils.isEmpty(strB)) {
                if (this.k.ab() > 0 || this.k.ac() > 0) {
                    jSONObject2.put("image_width", this.k.ab());
                    jSONObject2.put("image_height", this.k.ac());
                } else {
                    com.anythink.basead.b.f.a();
                    int[] iArrA = com.anythink.core.common.v.h.a(com.anythink.basead.b.f.a(1, strB));
                    if (iArrA != null) {
                        jSONObject2.put("image_width", iArrA[0]);
                        jSONObject2.put("image_height", iArrA[1]);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.k.E()) && this.k.V() > 0 && this.k.W() > 0) {
                jSONObject2.put("video_width", this.k.V());
                jSONObject2.put("video_height", this.k.W());
            }
            jSONObject.put(com.anythink.basead.webtemplet.a.b.c.g, jSONObject2);
            string = jSONObject.toString();
        } catch (Throwable unused) {
        }
        com.anythink.basead.webtemplet.a.c.a().a((WebView) this, com.anythink.basead.webtemplet.a.b.C0068b.a, string);
        this.z = System.currentTimeMillis();
        this.s = true;
        synchronized (this.r) {
            if (!this.r.isEmpty()) {
                for (i iVar : this.r) {
                    notifyInnerAdEvent(iVar.a, iVar.b);
                }
                this.r.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a aVar;
        synchronized (this.q) {
            if (this.d && this.e && (aVar = this.p) != null) {
                aVar.a();
                this.p = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.anythink.basead.webtemplet.adformat.a aVarA;
        Object obj = this.n;
        if (obj == null || !(obj instanceof com.anythink.basead.webtemplet.adformat.e) || (aVarA = ((com.anythink.basead.webtemplet.adformat.e) obj).a()) == null) {
            return;
        }
        aVarA.a(str, str2);
    }

    public void renderSuccess() {
        if (this.j != null) {
            com.anythink.core.common.t.d.a().b(this.j);
            this.j = null;
        }
        this.e = true;
        c cVar = this.c;
        if (cVar != null) {
            cVar.b(this);
        }
        c();
        a(1, "");
        if (!this.k.ae() || TextUtils.isEmpty(this.k.D())) {
            return;
        }
        HashMap map = new HashMap();
        map.put(com.anythink.basead.ui.improveclick.g.a.h, this.k.D());
        notifyInnerAdEvent(121, map);
    }

    public void h5ShowException(String str) {
        String strOptString;
        if (this.j != null) {
            com.anythink.core.common.t.d.a().b(this.j);
            this.j = null;
        }
        int iOptInt = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            iOptInt = jSONObject.optInt("error_code", 0);
            strOptString = jSONObject.optString("error_message", "");
        } catch (Throwable unused) {
            strOptString = "unknown";
        }
        a(iOptInt == -999 ? 3 : 2, iOptInt + "," + strOptString);
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(this, iOptInt, strOptString, getUrl());
        }
        a(String.valueOf(iOptInt), strOptString);
    }

    public void sendEventDA(final String str) {
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.webtemplet.WTWebView.4
            @Override // java.lang.Runnable
            public final void run() {
                w unused = WTWebView.this.k;
                com.anythink.core.common.u.e.a(WTWebView.this.l, str);
            }
        }, 2);
    }

    private void d() {
        a(1, "");
        if (!this.k.ae() || TextUtils.isEmpty(this.k.D())) {
            return;
        }
        HashMap map = new HashMap();
        map.put(com.anythink.basead.ui.improveclick.g.a.h, this.k.D());
        notifyInnerAdEvent(121, map);
    }

    public void notifyInnerAdEvent(final int i, final Map<String, Object> map) {
        if (!this.s) {
            synchronized (this.r) {
                this.r.add(new i(i, map));
            }
            return;
        }
        com.anythink.core.common.v.b.b.a().b(new Runnable() { // from class: com.anythink.basead.webtemplet.WTWebView.5
            /* JADX WARN: Code duplicated, block: B:97:0x01e7 A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:98:0x01e8  */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v2, types: [com.anythink.basead.webtemplet.a.c] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r3v14 */
            /* JADX WARN: Type inference failed for: r3v17 */
            /* JADX WARN: Type inference failed for: r3v2 */
            /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.String] */
            /* JADX WARN: Type inference failed for: r3v7 */
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                ?? r3;
                String str2;
                ?? r1 = i;
                String string = "";
                if (r1 == 101) {
                    str = com.anythink.basead.webtemplet.a.b.a.k;
                } else if (r1 == 301) {
                    str = com.anythink.basead.webtemplet.a.b.a.d;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONObject jSONObject2 = new JSONObject();
                        String strB = WTWebView.this.k.B();
                        if (!TextUtils.isEmpty(strB)) {
                            if (WTWebView.this.k.ab() > 0 || WTWebView.this.k.ac() > 0) {
                                jSONObject2.put("image_width", WTWebView.this.k.ab());
                                jSONObject2.put("image_height", WTWebView.this.k.ac());
                            } else {
                                com.anythink.basead.b.f.a();
                                int[] iArrA = com.anythink.core.common.v.h.a(com.anythink.basead.b.f.a(1, strB));
                                if (iArrA != null) {
                                    jSONObject2.put("image_width", iArrA[0]);
                                    jSONObject2.put("image_height", iArrA[1]);
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(WTWebView.this.k.E()) && WTWebView.this.k.V() > 0 && WTWebView.this.k.W() > 0) {
                            jSONObject2.put("video_width", WTWebView.this.k.V());
                            jSONObject2.put("video_height", WTWebView.this.k.W());
                        }
                        jSONObject.put(com.anythink.basead.webtemplet.a.b.c.g, jSONObject2);
                        string = jSONObject.toString();
                    } catch (Throwable unused) {
                    }
                } else {
                    try {
                        if (r1 == 305) {
                            Map map2 = map;
                            r1 = com.anythink.basead.webtemplet.a.b.a.o;
                            if (map2 != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                Object obj = map.get("wt_view_width");
                                if (obj != null) {
                                    jSONObject3.put("view_width", obj);
                                }
                                Object obj2 = map.get("wt_view_height");
                                if (obj2 != null) {
                                    jSONObject3.put("view_height", obj2);
                                }
                                string = jSONObject3.toString();
                            }
                        } else if (r1 == 107) {
                            str = com.anythink.basead.webtemplet.a.b.a.n;
                        } else {
                            if (r1 != 108) {
                                switch (r1) {
                                    case 110:
                                        str = com.anythink.basead.webtemplet.a.b.a.f;
                                        break;
                                    case 111:
                                        str = com.anythink.basead.webtemplet.a.b.a.e;
                                        break;
                                    case 112:
                                        str = com.anythink.basead.webtemplet.a.b.a.g;
                                        break;
                                    case 113:
                                        Map map3 = map;
                                        r1 = com.anythink.basead.webtemplet.a.b.a.b;
                                        if (map3 != null) {
                                            JSONObject jSONObject4 = new JSONObject();
                                            Object obj3 = map.get("click_type");
                                            if (obj3 != null) {
                                                jSONObject4.put("cl_s_type", obj3);
                                            }
                                            Object obj4 = map.get(com.anythink.basead.ui.improveclick.g.a.g);
                                            if (obj3 != null) {
                                                jSONObject4.put("cl_area", obj4);
                                            }
                                            string = jSONObject4.toString();
                                        }
                                        break;
                                    case 114:
                                        str = com.anythink.basead.webtemplet.a.b.a.a;
                                        break;
                                    case 115:
                                        str = com.anythink.basead.webtemplet.a.b.a.c;
                                        break;
                                    default:
                                        switch (r1) {
                                            case 121:
                                                if (map != null) {
                                                    try {
                                                        JSONObject jSONObject5 = new JSONObject();
                                                        Object obj5 = map.get(com.anythink.basead.ui.improveclick.g.a.h);
                                                        if (obj5 != null) {
                                                            jSONObject5.put(com.anythink.basead.ui.improveclick.g.a.h, obj5);
                                                        }
                                                        string = jSONObject5.toString();
                                                        break;
                                                    } catch (Throwable unused2) {
                                                    }
                                                }
                                                str2 = string;
                                                r3 = com.anythink.basead.webtemplet.a.b.a.h;
                                                break;
                                            case 122:
                                                str = com.anythink.basead.webtemplet.a.b.a.i;
                                                break;
                                            case 123:
                                                Map map4 = map;
                                                r1 = com.anythink.basead.webtemplet.a.b.a.j;
                                                if (map4 != null) {
                                                    JSONObject jSONObject6 = new JSONObject();
                                                    Object obj6 = map.get(com.anythink.basead.ui.improveclick.g.a.d);
                                                    if (obj6 != null) {
                                                        jSONObject6.put("duration", obj6);
                                                    }
                                                    string = jSONObject6.toString();
                                                }
                                                break;
                                            case 124:
                                                str = com.anythink.basead.webtemplet.a.b.a.m;
                                                break;
                                            case 125:
                                                Map map5 = map;
                                                r1 = com.anythink.basead.webtemplet.a.b.a.p;
                                                if (map5 != null) {
                                                    JSONObject jSONObject7 = new JSONObject();
                                                    Object obj7 = map.get(com.anythink.basead.ui.improveclick.g.a.k);
                                                    if (obj7 != null) {
                                                        jSONObject7.put("progress", obj7);
                                                    }
                                                    string = jSONObject7.toString();
                                                }
                                                break;
                                            default:
                                                str2 = "";
                                                r3 = string;
                                                break;
                                        }
                                        break;
                                }
                                if (TextUtils.isEmpty(r3)) {
                                    return;
                                }
                                com.anythink.basead.webtemplet.a.c.a().a(WTWebView.this, r3, str2);
                            }
                            Map map6 = map;
                            r1 = com.anythink.basead.webtemplet.a.b.a.l;
                            if (map6 != null) {
                                JSONObject jSONObject8 = new JSONObject();
                                Object obj8 = map.get(com.anythink.basead.ui.improveclick.g.a.i);
                                if (obj8 != null) {
                                    jSONObject8.put("error_message", obj8);
                                }
                                string = jSONObject8.toString();
                            }
                        }
                    } catch (Throwable unused3) {
                    }
                    str2 = string;
                    r3 = r1;
                    if (TextUtils.isEmpty(r3)) {
                        return;
                    }
                    com.anythink.basead.webtemplet.a.c.a().a(WTWebView.this, r3, str2);
                }
                String str3 = string;
                r3 = str;
                str2 = str3;
                if (TextUtils.isEmpty(r3)) {
                    return;
                }
                com.anythink.basead.webtemplet.a.c.a().a(WTWebView.this, r3, str2);
            }
        }, 2);
    }

    private synchronized void a(int i, String str) {
        if (!this.v && !this.g) {
            this.v = true;
            w wVar = this.k;
            x xVar = this.l;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.u;
            com.anythink.core.common.u.e.a(wVar, xVar, i, jCurrentTimeMillis - j, str, this.w, this.x, this.y, this.z, j);
        }
    }
}
