package com.tapsdk.tapad.internal.ui.views.web;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.internal.DownloadPresenter;
import com.tapsdk.tapad.internal.ui.views.banner.LandscapeBannerView;
import com.tapsdk.tapad.internal.ui.views.banner.PortraitBannerView;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.AppInfo;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BrowserActivity extends AppCompatActivity {
    private String p;
    private WebView a = null;
    private ViewGroup b = null;
    private ImageView c = null;
    private ImageView d = null;
    private ProgressBar e = null;
    private AdInfo f = null;
    private String g = "";
    Map<String, String> h = new HashMap();
    DownloadPresenter i = null;
    private PortraitBannerView j = null;
    private LandscapeBannerView k = null;
    private BottomDownloadingView l = null;
    private boolean m = false;
    private boolean n = false;
    com.tapsdk.tapad.internal.ui.views.web.b o = null;
    BottomDownloadingView.d q = new h();

    class a implements DownloadPresenter.h {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a() {
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void a(int i) {
            if (BrowserActivity.this.e != null) {
                BrowserActivity.this.e.setProgress(i);
            }
            if (BrowserActivity.this.j.getVisibility() == 0) {
                BrowserActivity.this.j.updateInteractionLayout();
            }
            if (BrowserActivity.this.k.getVisibility() == 0) {
                BrowserActivity.this.k.updateInteractionLayout();
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void b() {
            if (BrowserActivity.this.j.getVisibility() == 0) {
                BrowserActivity.this.j.updateInteractionLayout();
            }
            if (BrowserActivity.this.k.getVisibility() == 0) {
                BrowserActivity.this.k.updateInteractionLayout();
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void c() {
            if (BrowserActivity.this.j.getVisibility() == 0) {
                BrowserActivity.this.j.updateInteractionLayout();
            }
            if (BrowserActivity.this.k.getVisibility() == 0) {
                BrowserActivity.this.k.updateInteractionLayout();
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void d() {
            if (BrowserActivity.this.e != null) {
                BrowserActivity.this.e.setProgress(100);
            }
            if (BrowserActivity.this.j.getVisibility() == 0) {
                BrowserActivity.this.j.updateInteractionLayout();
            }
            if (BrowserActivity.this.k.getVisibility() == 0) {
                BrowserActivity.this.k.updateInteractionLayout();
            }
        }

        @Override // com.tapsdk.tapad.internal.DownloadPresenter.h
        public void e() {
            if (BrowserActivity.this.j.getVisibility() == 0) {
                BrowserActivity.this.j.updateInteractionLayout();
            }
            if (BrowserActivity.this.k.getVisibility() == 0) {
                BrowserActivity.this.k.updateInteractionLayout();
            }
        }
    }

    class b implements View.OnTouchListener {
        float a;
        float b;

        b() {
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0034  */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.a = motionEvent.getY();
            } else if (action == 1) {
                this.b = 0.0f;
                if (BrowserActivity.this.b != null) {
                    BrowserActivity.this.b.setTranslationY(this.b);
                }
            } else if (action == 2) {
                this.b = Math.max(this.b, Math.abs(this.a - motionEvent.getY()));
                if (BrowserActivity.this.b != null) {
                    BrowserActivity.this.b.setTranslationY(this.b);
                }
            }
            return view.onTouchEvent(motionEvent);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BrowserActivity.this.a.canGoBack()) {
                BrowserActivity.this.a.goBack();
            } else {
                BrowserActivity.this.finish();
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserActivity.this.finish();
        }
    }

    class e extends WebViewClient {
        e() {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (BrowserActivity.this.p.equals(BrowserActivity.this.g)) {
                HashMap map = new HashMap();
                map.put("code", String.valueOf(webResourceError.getErrorCode()));
                map.put("msg", webResourceError.getDescription().toString());
                com.tapsdk.tapad.internal.tracker.c.a().a(BrowserActivity.this.f.innerH5OpenFailedMonitorUrls, map);
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (BrowserActivity.this.p.equals(BrowserActivity.this.g)) {
                HashMap map = new HashMap();
                map.put("code", String.valueOf(webResourceResponse.getStatusCode()));
                map.put("msg", webResourceResponse.getReasonPhrase());
                com.tapsdk.tapad.internal.tracker.c.a().a(BrowserActivity.this.f.innerH5OpenFailedMonitorUrls, map);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (BrowserActivity.this.p.equals(BrowserActivity.this.g)) {
                HashMap map = new HashMap();
                map.put("code", String.valueOf(sslError.getPrimaryError()));
                map.put("msg", sslError.toString());
                com.tapsdk.tapad.internal.tracker.c.a().a(BrowserActivity.this.f.innerH5OpenFailedMonitorUrls, map);
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("https://") || str.startsWith("http://")) {
                BrowserActivity.this.p = str;
                webView.loadUrl(str, BrowserActivity.this.h);
                return false;
            }
            try {
                BrowserActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
    }

    class f implements DownloadListener {
        f() {
        }

        /* JADX WARN: Code duplicated, block: B:17:0x00d1  */
        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            RelativeLayout relativeLayout;
            if (BrowserActivity.this.f != null && !BrowserActivity.this.f.innerBrowserMonitorUrls.isEmpty()) {
                HashMap map = new HashMap();
                map.put("timestamp", String.valueOf(System.currentTimeMillis()));
                map.put("inner_browser_action_url", str);
                map.put("interaction_type", String.valueOf(1));
                com.tapsdk.tapad.internal.tracker.c.a().a(BrowserActivity.this.f.innerBrowserMonitorUrls, map);
            }
            TapADLogger.d("BrowserActivity: onDownloadStart: " + str + ", " + str2 + ", " + str3 + ", " + str4 + ", " + j);
            com.tapsdk.tapad.internal.ui.views.web.b bVar = new com.tapsdk.tapad.internal.ui.views.web.b(str, str2, str3, str4, j);
            if (BrowserActivity.this.f == null || BrowserActivity.this.f.getInnerWebViewIsSelf() != 1) {
                BrowserActivity.this.l.setVisibility(0);
                BrowserActivity.this.k.setVisibility(8);
                relativeLayout = BrowserActivity.this.j;
            } else {
                BrowserActivity browserActivity = BrowserActivity.this;
                if (browserActivity.i != null) {
                    browserActivity.l.setVisibility(8);
                    if (BrowserActivity.this.getResources().getConfiguration().orientation == 1) {
                        BrowserActivity.this.j.setVisibility(0);
                        relativeLayout = BrowserActivity.this.k;
                    } else {
                        BrowserActivity.this.k.setVisibility(0);
                    }
                } else {
                    BrowserActivity.this.l.setVisibility(0);
                    BrowserActivity.this.k.setVisibility(8);
                }
                relativeLayout = BrowserActivity.this.j;
            }
            relativeLayout.setVisibility(8);
            BrowserActivity browserActivity2 = BrowserActivity.this;
            browserActivity2.o = bVar;
            browserActivity2.a(bVar);
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BrowserActivity.this.m = true;
            BrowserActivity.this.e.setVisibility(8);
            BrowserActivity.this.b.setVisibility(0);
        }
    }

    class h implements BottomDownloadingView.d {
        h() {
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.BottomDownloadingView.d
        public void a() {
            BrowserActivity.this.b.setVisibility(8);
            BrowserActivity.this.e.setVisibility(0);
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.BottomDownloadingView.d
        public void a(int i) {
            if (BrowserActivity.this.e != null) {
                BrowserActivity.this.e.setProgress(i);
            }
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.BottomDownloadingView.d
        public void b() {
            BrowserActivity.this.n = false;
        }

        @Override // com.tapsdk.tapad.internal.ui.views.web.BottomDownloadingView.d
        public void onComplete() {
            BrowserActivity.this.b.setVisibility(8);
            BrowserActivity.this.e.setVisibility(0);
            BrowserActivity.this.e.setProgress(100);
        }
    }

    private void a() {
        this.c.setOnClickListener(new c());
        this.d.setOnClickListener(new d());
        this.a.setWebViewClient(new e());
        this.a.setDownloadListener(new f());
        WebSettings settings = this.a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setMixedContentMode(2);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        this.a.removeJavascriptInterface("accessibility");
        this.a.removeJavascriptInterface("accessibilityTraversal");
        ProgressBar progressBar = this.e;
        if (progressBar != null) {
            progressBar.setOnClickListener(new g());
        }
    }

    private void a(Bundle bundle) {
        if (bundle == null) {
            TapADLogger.d("BrowserActivity::没有bundle数据");
            finish();
            return;
        }
        this.a = (WebView) findViewById(R.id.ad_web_view);
        this.b = (ViewGroup) findViewById(R.id.bottom_container);
        this.c = (ImageView) findViewById(R.id.back_img);
        this.d = (ImageView) findViewById(R.id.close_img);
        this.e = (ProgressBar) findViewById(R.id.progress_bar);
        this.j = (PortraitBannerView) findViewById(R.id.portrait_bottom_banner);
        this.k = (LandscapeBannerView) findViewById(R.id.landscape_bottom_banner);
        this.l = (BottomDownloadingView) findViewById(R.id.else_download_banner);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        Parcelable parcelable = bundle.getParcelable("data");
        if (parcelable != null && (parcelable instanceof AdInfo)) {
            this.f = (AdInfo) parcelable;
        }
        String string = bundle.getString("landing_url", "");
        this.n = bundle.getInt("isDownloading", 0) == 1;
        if (TextUtils.isEmpty(string)) {
            TapADLogger.d("BrowserActivity: inner url is Empty");
            finish();
        }
        this.p = string;
        this.g = string;
        AdInfo adInfo = this.f;
        if (adInfo != null) {
            this.h.putAll(com.tapsdk.tapad.internal.network.c.a.a(adInfo.getLandingHeaderListWrapper()));
            int innerWebViewScreenOrientation = this.f.getInnerWebViewScreenOrientation();
            if (innerWebViewScreenOrientation == 0) {
                setRequestedOrientation(10);
            } else if (innerWebViewScreenOrientation == 1) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(0);
            }
            WeakReference<DownloadPresenter> weakReference = com.tapsdk.tapad.internal.s.a.a;
            if (weakReference != null) {
                this.i = weakReference.get();
            }
            DownloadPresenter downloadPresenter = this.i;
            if (downloadPresenter != null) {
                downloadPresenter.a(new a());
            }
        }
        this.a.loadUrl(this.g, this.h);
        this.a.setOnTouchListener(new b());
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tapsdk.tapad.internal.ui.views.web.b bVar) {
        DownloadPresenter downloadPresenter;
        AdInfo adInfo;
        AppInfo appInfo;
        this.n = true;
        this.b.setVisibility(0);
        this.b.setTranslationY(0.0f);
        if ((this.j.getVisibility() != 0 && this.k.getVisibility() != 0) || (downloadPresenter = this.i) == null || (adInfo = this.f) == null || adInfo.btnInteractionInfo == null) {
            if (this.l.getVisibility() == 0) {
                BottomDownloadingView bottomDownloadingView = this.l;
                AdInfo adInfo2 = this.f;
                bottomDownloadingView.a(bVar, adInfo2 == null ? Collections.emptyList() : adInfo2.innerBrowserMonitorUrls, this.q);
                return;
            }
            return;
        }
        this.j.render(this, adInfo, downloadPresenter, null, false, true, this.q);
        this.k.render(this, this.f, this.i, null, false, true, this.q);
        if (this.i.c() == DownloadPresenter.DownloadState.STARTED || (appInfo = this.f.appInfo) == null || TextUtils.isEmpty(appInfo.packageName) || !com.tapsdk.tapad.internal.utils.b.a(this, this.f.appInfo.packageName)) {
            this.i.a((com.tapsdk.tapad.internal.b) new DownloadPresenter.j(this.f));
        } else {
            com.tapsdk.tapad.internal.utils.b.b(this, this.f.appInfo.packageName);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tapad_activity_browser);
        a(getIntent().getExtras());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.a;
        if (webView != null) {
            webView.clearCache(true);
        }
        WeakReference<DownloadPresenter> weakReference = com.tapsdk.tapad.internal.s.a.a;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        a(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("data", this.f);
        bundle.putString("landing_url", this.g);
        super.onSaveInstanceState(bundle);
    }
}
