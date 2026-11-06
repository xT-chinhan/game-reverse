package com.anythink.core.express.web;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.core.common.d.t;
import com.anythink.core.common.v.k;
import com.anythink.core.common.v.q;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BaseWebView extends WebView {
    private boolean a;
    private View.OnTouchListener b;
    private View.OnTouchListener c;
    protected Context h;
    public long lastTouchTime;
    public b mWebViewClient;

    static /* synthetic */ boolean b(BaseWebView baseWebView) {
        baseWebView.a = true;
        return true;
    }

    public BaseWebView(Context context) {
        super(context);
        this.lastTouchTime = 0L;
        this.a = false;
        this.b = new View.OnTouchListener() { // from class: com.anythink.core.express.web.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.c != null) {
                    return BaseWebView.this.c.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.h = context.getApplicationContext();
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastTouchTime = 0L;
        this.a = false;
        this.b = new View.OnTouchListener() { // from class: com.anythink.core.express.web.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.c != null) {
                    return BaseWebView.this.c.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.h = context.getApplicationContext();
        a();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastTouchTime = 0L;
        this.a = false;
        this.b = new View.OnTouchListener() { // from class: com.anythink.core.express.web.BaseWebView.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    BaseWebView.this.lastTouchTime = System.currentTimeMillis();
                }
                if (BaseWebView.this.c != null) {
                    return BaseWebView.this.c.onTouch(view, motionEvent);
                }
                return false;
            }
        };
        this.h = context.getApplicationContext();
        a();
    }

    public void setFilter(a aVar) {
        b bVar = this.mWebViewClient;
        if (bVar == null || !(bVar instanceof b)) {
            return;
        }
        bVar.a(aVar);
    }

    protected void a() {
        if (this.mWebViewClient == null) {
            b bVar = new b();
            this.mWebViewClient = bVar;
            setWebViewClient(bVar);
        }
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
            Method declaredMethod = WebSettings.class.getDeclaredMethod(k.b("c2V0TWl4ZWRDb250ZW50TW9kZQ=="), Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(settings, 0);
        } catch (Throwable unused2) {
        }
        settings.setDatabaseEnabled(true);
        String path = this.h.getDir("database", 0).getPath();
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
            Method declaredMethod3 = WebSettings.class.getDeclaredMethod(k.b("c2V0QWxsb3dVbml2ZXJzYWxBY2Nlc3NGcm9tRmlsZVVSTHM="), Boolean.TYPE);
            declaredMethod3.setAccessible(true);
            declaredMethod3.invoke(settings, Boolean.TRUE);
        } catch (Throwable unused4) {
        }
        super.setOnTouchListener(this.b);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.c = onTouchListener;
    }

    public void setTransparent() {
        setLayerType(1, null);
        setBackgroundColor(0);
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof b) {
            this.mWebViewClient = (b) webViewClient;
        }
    }

    public b getBaseWebViewClient() {
        return this.mWebViewClient;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        super.loadUrl(checkToGetUrl(str));
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map<String, String> map) {
        super.loadUrl(checkToGetUrl(str), map);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        super.loadDataWithBaseURL(checkToGetUrl(str), str2, str3, str4, str5);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    public String checkToGetUrl(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("../")) {
                z = true;
            } else if (str.startsWith("file")) {
                String path = Uri.parse(str).getPath();
                if (TextUtils.isEmpty(path) || !path.contains(com.anythink.core.common.res.d.a(t.b().g()).a())) {
                    z = true;
                }
            }
        }
        if (!z) {
            return str;
        }
        Log.e("anythink_express", "illegal URL: ".concat(String.valueOf(str)));
        return com.anythink.core.common.res.d.a;
    }

    public boolean isDestroyed() {
        return this.a;
    }

    public void release() {
        try {
            removeAllViews();
            setDownloadListener(null);
            Context context = getContext();
            if (context == null) {
                context = t.b().g();
            }
            float fI = q.i(context);
            if (fI == 0.0f) {
                this.a = true;
                destroy();
            } else {
                t.b().a(new Runnable() { // from class: com.anythink.core.express.web.BaseWebView.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseWebView.b(BaseWebView.this);
                        BaseWebView.this.destroy();
                    }
                }, (long) (fI * 1000.0f));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
