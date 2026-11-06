package com.bytedance.sdk.component.widget.web;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.component.zb.ah;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class MultiWebview extends FrameLayout implements com.bytedance.sdk.component.zb.ms {
    public static com.bytedance.sdk.component.widget.ms d = null;
    private static int ka = 1;
    private com.bytedance.sdk.component.zb.ms.InterfaceC0259ms ab;
    protected WebViewImpl ah;
    private long c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final AtomicInteger f1473ms;
    private Map<ah, Set<String>> ny;
    private Deque<ah> x;
    protected volatile ah xr;

    public static void setMaxWebViewCount(int i) {
        ka = i + 1;
    }

    public static void setExceptionReport(com.bytedance.sdk.component.widget.ms msVar) {
        d = msVar;
    }

    public MultiWebview(Context context) {
        this(context, null);
    }

    public MultiWebview(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiWebview(final Context context, final AttributeSet attributeSet, final int i) {
        super(context, attributeSet, i);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f1473ms = atomicInteger;
        this.x = new LinkedList();
        this.ny = new ConcurrentHashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (ka()) {
            this.ah = ms(context, attributeSet, i);
            d();
            this.c = System.currentTimeMillis() - jCurrentTimeMillis;
            return;
        }
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.ah = multiWebview.ms(context, attributeSet, i);
                MultiWebview.this.d();
                MultiWebview.this.c = System.currentTimeMillis() - jCurrentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl ms(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.f1473ms.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.f1473ms.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.f1473ms.set(4);
            if (d == null) {
                return null;
            }
            d.ms(Thread.currentThread().getName(), th);
            return null;
        }
    }

    private ah ah() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.bytedance.sdk.component.widget.ms msVar = d;
            if (msVar == null) {
                return null;
            }
            msVar.ms(name, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.ah == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.ah.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.ah.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.x.add(this.ah);
        this.xr = this.ah;
    }

    public void H_() {
        this.ny.clear();
        this.ab = null;
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        while (true) {
            ah ahVarMs = ms();
            if (ahVarMs == null) {
                break;
            } else {
                removeView(ahVarMs.getView());
            }
        }
        WebViewImpl webViewImpl = this.ah;
        if (webViewImpl != null) {
            webViewImpl.xr();
        }
    }

    @Override // com.bytedance.sdk.component.zb.ms
    public int ms(final String str) {
        ah ahVarXr;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (ka == 1) {
            return 2;
        }
        if (getWebViewCount() >= ka) {
            return 1;
        }
        if (ka()) {
            ahVarXr = xr(str);
        } else {
            final ah[] ahVarArr = new ah[1];
            final Object obj = new Object();
            ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    ahVarArr[0] = MultiWebview.this.xr(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (ahVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
            ahVarXr = ahVarArr[0];
        }
        return ahVarXr != null ? 0 : -999;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ah xr(String str) {
        ah ahVarAh = ah();
        if (ahVarAh != null) {
            ah ahVar = this.xr;
            this.x.add(ahVarAh);
            this.xr = ahVarAh;
            addView(ahVarAh.getView(), new FrameLayout.LayoutParams(-1, -1));
            ms(ahVarAh);
            ahVarAh.loadUrl(str);
            if (ahVar != null) {
                ahVar.onPause();
                ahVar.setVisibility(8);
            }
        }
        return ahVarAh;
    }

    private void ms(ah ahVar) {
        ms msVar;
        Object objMs;
        WebViewImpl webViewImpl = this.ah;
        if (webViewImpl == null || ahVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            ahVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            ahVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            ahVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            ahVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            ahVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            ahVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            ahVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            ahVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            ahVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            ahVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            ahVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            ahVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            ahVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            ahVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            ahVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            ahVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            ahVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            ahVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            ahVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            ahVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            ahVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            ahVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            ahVar.setUserAgentString(userAgentString);
        }
        com.bytedance.sdk.component.zb.xr.ms onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            ahVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            ahVar.setDownloadListener(downloadListener);
        }
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient != null) {
            ahVar.setWebChromeClient(chromeClient);
        }
        com.bytedance.sdk.component.widget.xr client = webViewImpl.getClient();
        if (client != null) {
            ahVar.setWebViewClient(client.ms());
        }
        Map<String, ms> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (msVar = javascriptInterfaces.get(str)) != null && (objMs = msVar.ms()) != null) {
                    ahVar.addJavascriptInterface(objMs, str);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.zb.ms
    public ah ms() {
        if (ka()) {
            return ab();
        }
        final ah[] ahVarArr = new ah[1];
        final Object obj = new Object();
        ms(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                ahVarArr[0] = MultiWebview.this.ab();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (ahVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException unused) {
        }
        return ahVarArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ah ab() {
        if (this.x.size() < 2) {
            this.xr = this.ah;
            return null;
        }
        ah ahVarPollLast = this.x.pollLast();
        if (ahVarPollLast != null) {
            removeView(ahVarPollLast.getView());
            ahVarPollLast.destroy();
            this.ny.remove(ahVarPollLast);
        }
        ah last = this.x.getLast();
        if (last != null) {
            last.setVisibility(0);
            last.onResume();
            this.xr = last;
        }
        return ahVarPollLast;
    }

    public void destroy() {
        while (true) {
            ah ahVarPollLast = this.x.pollLast();
            if (ahVarPollLast != null) {
                ahVarPollLast.destroy();
            } else {
                this.ah = null;
                this.xr = null;
                this.ny.clear();
                this.ab = null;
                return;
            }
        }
    }

    public ah getCurrentWebView() {
        return this.xr;
    }

    public int getWebViewCount() {
        return this.x.size();
    }

    @Override // com.bytedance.sdk.component.zb.ms
    public void ms(ah ahVar, String str, String str2, Object obj) {
        if (str2 == null || ahVar == null) {
            return;
        }
        for (ah ahVar2 : this.ny.keySet()) {
            if (ahVar2 != null && ahVar != ahVar2) {
                Set<String> set = this.ny.get(ahVar2);
                if (set == null) {
                    return;
                }
                if (set.contains(str2)) {
                    ahVar2.ms(str, str2, obj);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.component.zb.ms
    public void ms(ah ahVar, String str) {
        if (ahVar == null || str == null) {
            return;
        }
        Set<String> hashSet = this.ny.get(ahVar);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.ny.put(ahVar, hashSet);
        }
        hashSet.add(str);
    }

    @Override // com.bytedance.sdk.component.zb.ms
    public void xr(ah ahVar, String str) {
        Set<String> set;
        if (ahVar == null || str == null || (set = this.ny.get(ahVar)) == null) {
            return;
        }
        set.remove(str);
    }

    public long getCreateDuration() {
        return this.c;
    }

    protected void ms(Runnable runnable) {
        ms(runnable, false);
    }

    protected void ms(final Runnable runnable, boolean z) {
        if (ka()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.bytedance.sdk.component.widget.web.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.ka()) {
                        runnable.run();
                    } else {
                        x.xr().post(runnable);
                    }
                }
            });
        } else {
            x.xr().post(runnable);
        }
    }

    protected boolean ka() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
