package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.hi;

/* JADX INFO: loaded from: classes3.dex */
public class AppPrivacyPolicyActivity extends Activity {
    private long ah;
    private long d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ImageView f4367ms;
    private WebView xr;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_privacy_policy);
        if (ms()) {
            xr();
        } else {
            com.ss.android.socialbase.appdownloader.ah.ms((Activity) this);
        }
    }

    public static void ms(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) AppPrivacyPolicyActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    private boolean ms() {
        this.ah = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.xr.xr xrVarMs = ah.ms().ms(this.ah);
        if (xrVarMs == null) {
            return false;
        }
        this.d = xrVarMs.xr;
        String str = xrVarMs.ny;
        this.ka = str;
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        this.ka = hi.ny().optString("ad_privacy_backup_url", "https://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html");
        return true;
    }

    private void xr() {
        this.f4367ms = (ImageView) findViewById(R.id.iv_privacy_back);
        this.xr = (WebView) findViewById(R.id.privacy_webview);
        this.f4367ms.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ab.ms("lp_app_privacy_click_close", AppPrivacyPolicyActivity.this.d);
                AppPrivacyPolicyActivity.this.finish();
            }
        });
        WebSettings settings = this.xr.getSettings();
        settings.setDefaultFontSize(16);
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        this.xr.setWebViewClient(new WebViewClient() { // from class: com.ss.android.downloadlib.addownload.compliance.AppPrivacyPolicyActivity.2
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return ms(webResourceRequest.getUrl());
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return ms(Uri.parse(str));
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (!renderProcessGoneDetail.didCrash()) {
                    com.ss.android.downloadlib.ab.hi.ms("System killed the WebView rendering process to reclaim memory. Recreating...");
                    if (webView != null) {
                        ((ViewGroup) webView.getParent()).removeView(webView);
                        webView.destroy();
                    }
                    return true;
                }
                com.ss.android.downloadlib.ab.hi.ms("The WebView rendering process crashed!");
                if (webView != null) {
                    ((ViewGroup) webView.getParent()).removeView(webView);
                    webView.destroy();
                }
                return true;
            }

            private boolean ms(Uri uri) {
                String scheme = uri.getScheme();
                return ("http".equals(scheme) || "https".equals(scheme)) ? false : true;
            }
        });
        ms(this.xr);
        this.xr.setScrollBarStyle(0);
        this.xr.loadUrl(this.ka);
    }

    private void ms(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ab.ms("lp_app_privacy_click_close", this.d);
        super.onBackPressed();
    }
}
