package com.byazt.qza;

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
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE, 798})
public class MultiWebview extends FrameLayout implements com.byazt.uad.qg {
    public static int l = 1;
    public static com.byazt.kfh.n q;
    public Deque<com.byazt.uad.q> fs;
    public final AtomicInteger n;
    public volatile com.byazt.uad.q qg;
    public Map<com.byazt.uad.q, Set<String>> rv;
    public WebViewImpl s;
    public Map<com.byazt.uad.q, l> tj;
    public long w;
    public com.byazt.uad.qg.n x;

    public static void setMaxWebViewCount(int i) {
        l = i + 1;
    }

    public static void setExceptionReport(com.byazt.kfh.n nVar) {
        q = nVar;
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
        this.n = atomicInteger;
        this.fs = new LinkedList();
        this.rv = new ConcurrentHashMap();
        this.tj = new ConcurrentHashMap();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        atomicInteger.set(1);
        if (l()) {
            this.s = n(context, attributeSet, i);
            q();
            this.w = System.currentTimeMillis() - jCurrentTimeMillis;
            return;
        }
        n(new Runnable() { // from class: com.byazt.qza.MultiWebview.1
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview multiWebview = MultiWebview.this;
                multiWebview.s = multiWebview.n(context, attributeSet, i);
                MultiWebview.this.q();
                MultiWebview.this.w = System.currentTimeMillis() - jCurrentTimeMillis;
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewImpl n(Context context, AttributeSet attributeSet, int i) {
        WebViewImpl webViewImpl;
        try {
            this.n.set(2);
            if (i == 0) {
                webViewImpl = new WebViewImpl(this, context, attributeSet);
            } else {
                webViewImpl = new WebViewImpl(this, context, attributeSet, i);
            }
            this.n.set(3);
            return webViewImpl;
        } catch (Throwable th) {
            this.n.set(4);
            if (q == null) {
                return null;
            }
            q.n(Thread.currentThread().getName(), th);
            return null;
        }
    }

    private com.byazt.uad.q s() {
        String name = Thread.currentThread().getName();
        try {
            return new WebViewImpl(this, getContext());
        } catch (Throwable th) {
            com.byazt.kfh.n nVar = q;
            if (nVar == null) {
                return null;
            }
            nVar.n(name, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.s == null) {
            return;
        }
        removeAllViews();
        setBackground(null);
        try {
            this.s.getView().setId(2064056317);
        } catch (Throwable unused) {
        }
        addView(this.s.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.fs.add(this.s);
        this.qg = this.s;
    }

    public void S_() {
        this.rv.clear();
        this.x = null;
        n(new Runnable() { // from class: com.byazt.qza.MultiWebview.2
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.w();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        while (true) {
            com.byazt.uad.q qVarN = n();
            if (qVarN == null) {
                break;
            } else {
                removeView(qVarN.getView());
            }
        }
        WebViewImpl webViewImpl = this.s;
        if (webViewImpl != null) {
            webViewImpl.qg();
        }
    }

    @Override // com.byazt.uad.qg
    public int n(final String str) {
        com.byazt.uad.q qVarQg;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (l == 1) {
            return 2;
        }
        if (getWebViewCount() >= l) {
            return 1;
        }
        if (l()) {
            qVarQg = qg(str);
        } else {
            final com.byazt.uad.q[] qVarArr = new com.byazt.uad.q[1];
            final Object obj = new Object();
            n(new Runnable() { // from class: com.byazt.qza.MultiWebview.3
                @Override // java.lang.Runnable
                public void run() {
                    qVarArr[0] = MultiWebview.this.qg(str);
                    synchronized (obj) {
                        obj.notifyAll();
                    }
                }
            });
            try {
                if (qVarArr[0] == null) {
                    synchronized (obj) {
                        obj.wait(2500L);
                    }
                }
            } catch (InterruptedException unused) {
            }
            qVarQg = qVarArr[0];
        }
        return qVarQg != null ? 0 : -999;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.uad.q qg(String str) {
        com.byazt.uad.q qVarS = s();
        if (qVarS != null) {
            com.byazt.uad.q qVar = this.qg;
            this.fs.add(qVarS);
            this.qg = qVarS;
            View view = qVarS.getView();
            view.setBackground(new ColorDrawable(-1));
            addView(view, new FrameLayout.LayoutParams(-1, -1));
            n(qVarS);
            x(qVarS);
            q(qVarS);
            qVarS.loadUrl(str);
            if (qVar != null) {
                qVar.onPause();
                qVar.setVisibility(8);
            }
        }
        return qVarS;
    }

    private void n(com.byazt.uad.q qVar) {
        if (qVar == null) {
            return;
        }
        l lVar = new l(getContext(), new Runnable() { // from class: com.byazt.qza.MultiWebview.4
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.n();
            }
        });
        this.tj.put(qVar, lVar);
        addView(lVar, new FrameLayout.LayoutParams(-1, -1));
    }

    private l qg(com.byazt.uad.q qVar) {
        if (qVar == null) {
            return null;
        }
        return this.tj.get(qVar);
    }

    private void s(com.byazt.uad.q qVar) {
        l lVarQg = qg(qVar);
        if (lVarQg != null) {
            lVarQg.s();
        }
    }

    private void q(com.byazt.uad.q qVar) {
        l lVarQg = qg(qVar);
        if (lVarQg != null) {
            lVarQg.s();
            lVarQg.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(com.byazt.uad.q qVar) {
        l lVarQg = qg(qVar);
        if (lVarQg != null) {
            lVarQg.qg();
        }
    }

    @Override // com.byazt.uad.qg
    public boolean n(final boolean z) {
        final l lVarQg = qg(this.qg);
        if (lVarQg == null) {
            return false;
        }
        n(new Runnable() { // from class: com.byazt.qza.MultiWebview.5
            @Override // java.lang.Runnable
            public void run() {
                l lVar = lVarQg;
                if (lVar != null) {
                    lVar.n(z);
                }
            }
        });
        return true;
    }

    private void w(com.byazt.uad.q qVar) {
        l lVarRemove = this.tj.remove(qVar);
        if (lVarRemove != null) {
            lVarRemove.q();
            removeView(lVarRemove);
        }
    }

    private void x(final com.byazt.uad.q qVar) {
        WebViewClient webViewClientN;
        n nVar;
        Object objN;
        WebViewImpl webViewImpl = this.s;
        if (webViewImpl == null || qVar == null) {
            return;
        }
        Integer backgroundColor = webViewImpl.getBackgroundColor();
        if (backgroundColor != null) {
            qVar.setBackgroundColor(backgroundColor.intValue());
        }
        Boolean allowFileAccess = webViewImpl.getAllowFileAccess();
        if (allowFileAccess != null) {
            qVar.setAllowFileAccess(allowFileAccess.booleanValue());
        }
        Boolean databaseEnabled = webViewImpl.getDatabaseEnabled();
        if (databaseEnabled != null) {
            qVar.setDatabaseEnabled(databaseEnabled.booleanValue());
        }
        Boolean appCacheEnabled = webViewImpl.getAppCacheEnabled();
        if (appCacheEnabled != null) {
            qVar.setAppCacheEnabled(appCacheEnabled.booleanValue());
        }
        Boolean domStorageEnabled = webViewImpl.getDomStorageEnabled();
        if (domStorageEnabled != null) {
            qVar.setDomStorageEnabled(domStorageEnabled.booleanValue());
        }
        Boolean supportZoom = webViewImpl.getSupportZoom();
        if (supportZoom != null) {
            qVar.setSupportZoom(supportZoom.booleanValue());
        }
        Boolean builtInZoomControls = webViewImpl.getBuiltInZoomControls();
        if (builtInZoomControls != null) {
            qVar.setBuiltInZoomControls(builtInZoomControls.booleanValue());
        }
        Boolean useWideViewPort = webViewImpl.getUseWideViewPort();
        if (useWideViewPort != null) {
            qVar.setUseWideViewPort(useWideViewPort.booleanValue());
        }
        WebSettings.LayoutAlgorithm layoutAlgorithm = webViewImpl.getLayoutAlgorithm();
        if (layoutAlgorithm != null) {
            qVar.setLayoutAlgorithm(layoutAlgorithm);
        }
        Boolean javaScriptEnabled = webViewImpl.getJavaScriptEnabled();
        if (javaScriptEnabled != null) {
            qVar.setJavaScriptEnabled(javaScriptEnabled.booleanValue());
        }
        Boolean javaScriptCanOpenWindowsAutomatically = webViewImpl.getJavaScriptCanOpenWindowsAutomatically();
        if (javaScriptCanOpenWindowsAutomatically != null) {
            qVar.setJavaScriptCanOpenWindowsAutomatically(javaScriptCanOpenWindowsAutomatically.booleanValue());
        }
        View.OnScrollChangeListener onScrollChangeListener = webViewImpl.getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            qVar.setOnScrollChangeListener(onScrollChangeListener);
        }
        Boolean mediaPlaybackRequiresUserGesture = webViewImpl.getMediaPlaybackRequiresUserGesture();
        if (mediaPlaybackRequiresUserGesture != null) {
            qVar.setMediaPlaybackRequiresUserGesture(mediaPlaybackRequiresUserGesture.booleanValue());
        }
        Boolean savePassword = webViewImpl.getSavePassword();
        if (savePassword != null) {
            qVar.setSavePassword(savePassword.booleanValue());
        }
        Boolean allowFileAccessFromFileURLs = webViewImpl.getAllowFileAccessFromFileURLs();
        if (allowFileAccessFromFileURLs != null) {
            qVar.setAllowFileAccessFromFileURLs(allowFileAccessFromFileURLs.booleanValue());
        }
        Boolean allowUniversalAccessFromFileURLs = webViewImpl.getAllowUniversalAccessFromFileURLs();
        if (allowUniversalAccessFromFileURLs != null) {
            qVar.setAllowUniversalAccessFromFileURLs(allowUniversalAccessFromFileURLs.booleanValue());
        }
        Boolean blockNetworkImage = webViewImpl.getBlockNetworkImage();
        if (blockNetworkImage != null) {
            qVar.setBlockNetworkImage(blockNetworkImage.booleanValue());
        }
        Integer defaultFontSize = webViewImpl.getDefaultFontSize();
        if (defaultFontSize != null) {
            qVar.setDefaultFontSize(defaultFontSize.intValue());
        }
        String defaultTextEncodingName = webViewImpl.getDefaultTextEncodingName();
        if (defaultTextEncodingName != null) {
            qVar.setDefaultTextEncodingName(defaultTextEncodingName);
        }
        Integer cacheMode = webViewImpl.getCacheMode();
        if (cacheMode != null) {
            qVar.setCacheMode(cacheMode.intValue());
        }
        Boolean displayZoomControls = webViewImpl.getDisplayZoomControls();
        if (displayZoomControls != null) {
            qVar.setDisplayZoomControls(displayZoomControls.booleanValue());
        }
        Boolean loadWithOverviewMod = webViewImpl.getLoadWithOverviewMod();
        if (loadWithOverviewMod != null) {
            qVar.setLoadWithOverviewMode(loadWithOverviewMod.booleanValue());
        }
        String userAgentString = webViewImpl.getUserAgentString();
        if (userAgentString != null) {
            qVar.setUserAgentString(userAgentString);
        }
        com.byazt.uad.s.n onTouchEventListener = webViewImpl.getOnTouchEventListener();
        if (onTouchEventListener != null) {
            qVar.setTouchEventListener(onTouchEventListener);
        }
        DownloadListener downloadListener = webViewImpl.getDownloadListener();
        if (downloadListener != null) {
            qVar.setDownloadListener(downloadListener);
        }
        Runnable runnable = new Runnable() { // from class: com.byazt.qza.MultiWebview.6
            @Override // java.lang.Runnable
            public void run() {
                MultiWebview.this.l(qVar);
            }
        };
        WebChromeClient chromeClient = webViewImpl.getChromeClient();
        if (chromeClient instanceof s) {
            chromeClient = ((s) chromeClient).n();
        }
        qVar.setWebChromeClient(new s(chromeClient, runnable));
        com.byazt.kfh.qg client = webViewImpl.getClient();
        if (client != null) {
            webViewClientN = client.n();
            if (webViewClientN instanceof q) {
                webViewClientN = ((q) webViewClientN).n();
            }
        } else {
            webViewClientN = null;
        }
        qVar.setWebViewClient(new q(webViewClientN, runnable));
        Map<String, n> javascriptInterfaces = webViewImpl.getJavascriptInterfaces();
        if (javascriptInterfaces != null) {
            for (String str : javascriptInterfaces.keySet()) {
                if (str != null && (nVar = javascriptInterfaces.get(str)) != null && (objN = nVar.n()) != null) {
                    qVar.addJavascriptInterface(objN, str);
                }
            }
        }
    }

    @Override // com.byazt.uad.qg
    public com.byazt.uad.q n() {
        if (l()) {
            return x();
        }
        final com.byazt.uad.q[] qVarArr = new com.byazt.uad.q[1];
        final Object obj = new Object();
        n(new Runnable() { // from class: com.byazt.qza.MultiWebview.7
            @Override // java.lang.Runnable
            public void run() {
                qVarArr[0] = MultiWebview.this.x();
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (qVarArr[0] == null) {
                synchronized (obj) {
                    obj.wait(2500L);
                }
            }
        } catch (InterruptedException unused) {
        }
        return qVarArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.uad.q x() {
        if (this.fs.size() < 2) {
            this.qg = this.s;
            return null;
        }
        com.byazt.uad.q qVarPollLast = this.fs.pollLast();
        if (qVarPollLast != null) {
            removeView(qVarPollLast.getView());
            w(qVarPollLast);
            qVarPollLast.destroy();
            this.rv.remove(qVarPollLast);
        }
        com.byazt.uad.q last = this.fs.getLast();
        if (last != null) {
            last.setVisibility(0);
            s(last);
            last.onResume();
            this.qg = last;
        }
        return qVarPollLast;
    }

    public void destroy() {
        while (true) {
            com.byazt.uad.q qVarPollLast = this.fs.pollLast();
            if (qVarPollLast != null) {
                w(qVarPollLast);
                qVarPollLast.destroy();
            } else {
                this.s = null;
                this.qg = null;
                this.rv.clear();
                this.tj.clear();
                this.x = null;
                return;
            }
        }
    }

    public com.byazt.uad.q getCurrentWebView() {
        return this.qg;
    }

    public int getWebViewCount() {
        return this.fs.size();
    }

    @Override // com.byazt.uad.qg
    public void n(com.byazt.uad.q qVar, String str, String str2, Object obj) {
        Set<String> set;
        if (str2 == null || qVar == null) {
            return;
        }
        for (com.byazt.uad.q qVar2 : this.rv.keySet()) {
            if (qVar2 != null && qVar != qVar2 && (set = this.rv.get(qVar2)) != null && set.contains(str2)) {
                qVar2.n(str, str2, obj);
            }
        }
    }

    @Override // com.byazt.uad.qg
    public void n(com.byazt.uad.q qVar, String str) {
        if (qVar == null || str == null) {
            return;
        }
        Set<String> hashSet = this.rv.get(qVar);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.rv.put(qVar, hashSet);
        }
        hashSet.add(str);
    }

    @Override // com.byazt.uad.qg
    public void qg(com.byazt.uad.q qVar, String str) {
        if (qVar == null) {
            return;
        }
        if (str == null) {
            this.rv.remove(qVar);
            return;
        }
        Set<String> set = this.rv.get(qVar);
        if (set != null) {
            set.remove(str);
            if (set.isEmpty()) {
                this.rv.remove(qVar);
            }
        }
    }

    public long getCreateDuration() {
        return this.w;
    }

    public void n(Runnable runnable) {
        n(runnable, false);
    }

    public void n(final Runnable runnable, boolean z) {
        if (l()) {
            runnable.run();
        } else if (z) {
            post(new Runnable() { // from class: com.byazt.qza.MultiWebview.8
                @Override // java.lang.Runnable
                public void run() {
                    if (MultiWebview.this.l()) {
                        runnable.run();
                    } else {
                        rv.qg().post(runnable);
                    }
                }
            });
        } else {
            rv.qg().post(runnable);
        }
    }

    public boolean l() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
