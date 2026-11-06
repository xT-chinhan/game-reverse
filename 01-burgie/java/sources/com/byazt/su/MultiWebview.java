package com.byazt.su;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.byazt.ca.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION})
public class MultiWebview extends FrameLayout implements com.byazt.son.hw {
    public static int c = 1;
    public static com.byazt.fj.pr x;
    public Map<com.byazt.son.x, Set<String>> aj;
    public com.byazt.son.hw.pr fw;
    public WebViewImpl hn;
    public volatile com.byazt.son.x hw;
    public final AtomicInteger pr;
    public long uc;
    public Map<com.byazt.son.x, c> vk;
    public Deque<com.byazt.son.x> zo;

    public static void setMaxWebViewCount(int i) {
        c = i + 1;
    }

    public static void setExceptionReport(com.byazt.fj.pr prVar) {
        x = prVar;
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
        this.pr = atomicInteger;
        this.zo = new LinkedList();
        this.aj = new ConcurrentHashMap();
        this.vk = new ConcurrentHashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (c()) {
            this.hn = pr(context, attributeSet, i);
            x();
            this.uc = System.currentTimeMillis() - jCurrentTimeMillis;
            return;
        }
        pr(new Runnable() { // from class: com.byazt.su.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.hn = multiWebview.pr(context, attributeSet, i);
                MultiWebview.this.x();
                MultiWebview.this.uc = System.currentTimeMillis() - jCurrentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl pr(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.pr.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.pr.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.pr.set(4);
            if (x != null) {
                x.pr(Thread.currentThread().getName(), th);
                return null;
            }
            return null;
        }
    }

    private com.byazt.son.x hn() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.byazt.fj.pr prVar = x;
            if (prVar != null) {
                prVar.pr(name, th);
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.hn == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.hn.getView().setId(2064056317);
        } catch (Throwable th) {
        }
        addView(this.hn.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.zo.add(this.hn);
        this.hw = this.hn;
    }

    public void S_() {
        this.aj.clear();
        this.fw = null;
        pr(new Runnable() { // from class: com.byazt.su.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.uc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc() {
        while (true) {
            com.byazt.son.x xVarPr = pr();
            if (xVarPr == null) {
                break;
            } else {
                removeView(xVarPr.getView());
            }
        }
        WebViewImpl webViewImpl = this.hn;
        if (webViewImpl != null) {
            webViewImpl.hw();
        }
    }

    @Override // com.byazt.son.hw
    public int pr(final String str) {
        com.byazt.son.x xVarHw;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (c == 1) {
            return 2;
        }
        if (getWebViewCount() >= c) {
            return 1;
        }
        if (c()) {
            xVarHw = hw(str);
        } else {
            final com.byazt.son.x[] xVarArr = new com.byazt.son.x[1];
            final Object obj = new Object();
            pr(new Runnable() { // from class: com.byazt.su.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    xVarArr[0] = MultiWebview.this.hw(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (xVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException e) {
            }
            xVarHw = xVarArr[0];
        }
        return xVarHw != null ? 0 : -999;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.son.x hw(String str) {
        com.byazt.son.x xVarHn = hn();
        if (xVarHn != null) {
            com.byazt.son.x xVar = this.hw;
            this.zo.add(xVarHn);
            this.hw = xVarHn;
            View view = xVarHn.getView();
            view.setBackground(new ColorDrawable(-1));
            addView(view, new FrameLayout.LayoutParams(-1, -1));
            pr(xVarHn);
            fw(xVarHn);
            x(xVarHn);
            xVarHn.loadUrl(str);
            if (xVar != null) {
                xVar.onPause();
                xVar.setVisibility(8);
            }
        }
        return xVarHn;
    }

    private void pr(com.byazt.son.x xVar) {
        if (xVar == null) {
            return;
        }
        c cVar = new c(getContext(), new Runnable() { // from class: com.byazt.su.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.pr();
            }
        });
        this.vk.put(xVar, cVar);
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
    }

    private c hw(com.byazt.son.x xVar) {
        if (xVar == null) {
            return null;
        }
        return this.vk.get(xVar);
    }

    private void hn(com.byazt.son.x xVar) {
        c cVarHw = hw(xVar);
        if (cVarHw != null) {
            cVarHw.hn();
        }
    }

    private void x(com.byazt.son.x xVar) {
        c cVarHw = hw(xVar);
        if (cVarHw != null) {
            cVarHw.hn();
            cVarHw.pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.son.x xVar) {
        c cVarHw = hw(xVar);
        if (cVarHw != null) {
            cVarHw.hw();
        }
    }

    @Override // com.byazt.son.hw
    public boolean pr(final boolean z) {
        final c cVarHw = hw(this.hw);
        if (cVarHw != null) {
            pr(new Runnable() { // from class: com.byazt.su.MultiWebview.5
                @Override // java.lang.Runnable
                public void run() {
                    c cVar = cVarHw;
                    if (cVar != null) {
                        cVar.pr(z);
                    }
                }
            });
            return true;
        }
        return false;
    }

    private void uc(com.byazt.son.x xVar) {
        c cVarRemove = this.vk.remove(xVar);
        if (cVarRemove != null) {
            cVarRemove.x();
            removeView(cVarRemove);
        }
    }

    private void fw(final com.byazt.son.x xVar) {
        pr prVar;
        Object objPr;
        WebViewImpl webViewImpl = this.hn;
        if (webViewImpl == null || xVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            xVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            xVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            xVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            xVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            xVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            xVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            xVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            xVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            xVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            xVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            xVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            xVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            xVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            xVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            xVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            xVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            xVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            xVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            xVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            xVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            xVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            xVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            xVar.setUserAgentString(userAgentString);
        }
        com.byazt.son.hn.pr onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            xVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            xVar.setDownloadListener(downloadListener);
        }
        Runnable runnable = new Runnable() { // from class: com.byazt.su.MultiWebview.6
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.c(xVar);
            }
        };
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient instanceof hn) {
            chromeClient = ((hn) chromeClient).pr();
        }
        xVar.setWebChromeClient(new hn(chromeClient, runnable));
        com.byazt.fj.hw client = webViewImpl.getClient();
        WebViewClient webViewClientPr = null;
        if (client != null) {
            webViewClientPr = client.pr();
            if (webViewClientPr instanceof x) {
                webViewClientPr = ((x) webViewClientPr).pr();
            }
        }
        xVar.setWebViewClient(new x(webViewClientPr, runnable));
        Map<String, pr> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (prVar = javascriptInterfaces.get(str)) != null && (objPr = prVar.pr()) != null) {
                    xVar.addJavascriptInterface(objPr, str);
                }
            }
        }
    }

    @Override // com.byazt.son.hw
    public com.byazt.son.x pr() {
        if (c()) {
            return fw();
        }
        final com.byazt.son.x[] xVarArr = new com.byazt.son.x[1];
        final Object obj = new Object();
        pr(new Runnable() { // from class: com.byazt.su.MultiWebview.7
            @Override // java.lang.Runnable
            public void run() {
                xVarArr[0] = MultiWebview.this.fw();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (xVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException e) {
        }
        return xVarArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.son.x fw() {
        if (this.zo.size() < 2) {
            this.hw = this.hn;
            return null;
        }
        com.byazt.son.x xVarPollLast = this.zo.pollLast();
        if (xVarPollLast != null) {
            removeView(xVarPollLast.getView());
            uc(xVarPollLast);
            xVarPollLast.destroy();
            this.aj.remove(xVarPollLast);
        }
        com.byazt.son.x last = this.zo.getLast();
        if (last != null) {
            last.setVisibility(0);
            hn(last);
            last.onResume();
            this.hw = last;
        }
        return xVarPollLast;
    }

    public void destroy() {
        while (true) {
            com.byazt.son.x xVarPollLast = this.zo.pollLast();
            if (xVarPollLast != null) {
                uc(xVarPollLast);
                xVarPollLast.destroy();
            } else {
                this.hn = null;
                this.hw = null;
                this.aj.clear();
                this.vk.clear();
                this.fw = null;
                return;
            }
        }
    }

    public com.byazt.son.x getCurrentWebView() {
        return this.hw;
    }

    public int getWebViewCount() {
        return this.zo.size();
    }

    @Override // com.byazt.son.hw
    public void pr(com.byazt.son.x xVar, String str, String str2, Object obj) {
        Set<String> set;
        if (str2 == null || xVar == null) {
            return;
        }
        for (com.byazt.son.x xVar2 : this.aj.keySet()) {
            if (xVar2 != null && xVar != xVar2 && (set = this.aj.get(xVar2)) != null && set.contains(str2)) {
                xVar2.pr(str, str2, obj);
            }
        }
    }

    @Override // com.byazt.son.hw
    public void pr(com.byazt.son.x xVar, String str) {
        if (xVar == null || str == null) {
            return;
        }
        Set<String> hashSet = this.aj.get(xVar);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.aj.put(xVar, hashSet);
        }
        hashSet.add(str);
    }

    @Override // com.byazt.son.hw
    public void hw(com.byazt.son.x xVar, String str) {
        if (xVar == null) {
            return;
        }
        if (str == null) {
            this.aj.remove(xVar);
            return;
        }
        Set<String> set = this.aj.get(xVar);
        if (set != null) {
            set.remove(str);
            if (set.isEmpty()) {
                this.aj.remove(xVar);
            }
        }
    }

    public long getCreateDuration() {
        return this.uc;
    }

    public void pr(Runnable runnable) {
        pr(runnable, false);
    }

    public void pr(final Runnable runnable, boolean z) {
        if (c()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.byazt.su.MultiWebview.8
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.c()) {
                        runnable.run();
                    } else {
                        aj.hw().post(runnable);
                    }
                }
            });
        } else {
            aj.hw().post(runnable);
        }
    }

    public boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
