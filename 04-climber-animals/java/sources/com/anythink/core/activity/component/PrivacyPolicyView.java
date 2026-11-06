package com.anythink.core.activity.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.v.p;
import com.anythink.core.common.v.q;
import com.bykv.vk.component.ttvideo.player.C;

/* JADX INFO: loaded from: classes.dex */
public class PrivacyPolicyView extends RelativeLayout implements View.OnClickListener {
    private static String n = "PrivacyPolicyView";
    ViewGroup a;
    LinearLayout b;
    LoadingView c;
    TextView d;
    FrameLayout e;
    WebView f;
    CheckBox g;
    View h;
    TextView i;
    boolean j;
    boolean k;
    String l;
    a m;

    public interface a {
        void onLevelSelect(int i);

        void onPageLoadFail();

        void onPageLoadSuccess();
    }

    public PrivacyPolicyView(Context context) {
        super(context);
        this.j = true;
        this.k = false;
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "privace_policy_layout", "layout"), this);
        this.a = (ViewGroup) findViewById(q.a(getContext(), "policy_content_view", "id"));
        this.b = (LinearLayout) findViewById(q.a(getContext(), "policy_loading_view", "id"));
        this.c = new LoadingView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(q.a(getContext(), 30.0f), q.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.c.setLayoutParams(layoutParams);
        this.d = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = q.a(getContext(), 5.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setText("Page failed to load, please try again later.");
        this.d.setTextColor(-8947849);
        this.d.setTextSize(1, 12.0f);
        this.b.addView(this.c);
        this.b.addView(this.d);
        this.b.setOnClickListener(new AnonymousClass1());
        this.e = (FrameLayout) findViewById(q.a(getContext(), "policy_webview_area", "id"));
        WebView webView = new WebView(getContext());
        this.f = webView;
        p.a(webView);
        this.e.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setCacheMode(-1);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new AnonymousClass2());
        this.f.setWebChromeClient(new AnonymousClass3());
        this.g = (CheckBox) findViewById(q.a(getContext(), "policy_check_box", "id"));
        this.h = findViewById(q.a(getContext(), "policy_agree_view", "id"));
        this.i = (TextView) findViewById(q.a(getContext(), "policy_reject_view", "id"));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        int iA = q.a(getContext(), 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(iA);
        this.h.setBackgroundDrawable(gradientDrawable);
        this.i.setText(Html.fromHtml("<u>No,Thanks</u>"));
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(q.a(getContext(), "privace_policy_layout", "layout"), this);
        this.a = (ViewGroup) findViewById(q.a(getContext(), "policy_content_view", "id"));
        this.b = (LinearLayout) findViewById(q.a(getContext(), "policy_loading_view", "id"));
        this.c = new LoadingView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(q.a(getContext(), 30.0f), q.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.c.setLayoutParams(layoutParams);
        this.d = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = q.a(getContext(), 5.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setText("Page failed to load, please try again later.");
        this.d.setTextColor(-8947849);
        this.d.setTextSize(1, 12.0f);
        this.b.addView(this.c);
        this.b.addView(this.d);
        this.b.setOnClickListener(new AnonymousClass1());
        this.e = (FrameLayout) findViewById(q.a(getContext(), "policy_webview_area", "id"));
        WebView webView = new WebView(getContext());
        this.f = webView;
        p.a(webView);
        this.e.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setCacheMode(-1);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new AnonymousClass2());
        this.f.setWebChromeClient(new AnonymousClass3());
        this.g = (CheckBox) findViewById(q.a(getContext(), "policy_check_box", "id"));
        this.h = findViewById(q.a(getContext(), "policy_agree_view", "id"));
        this.i = (TextView) findViewById(q.a(getContext(), "policy_reject_view", "id"));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        int iA = q.a(getContext(), 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(iA);
        this.h.setBackgroundDrawable(gradientDrawable);
        this.i.setText(Html.fromHtml("<u>No,Thanks</u>"));
    }

    /* JADX INFO: renamed from: com.anythink.core.activity.component.PrivacyPolicyView$1, reason: invalid class name */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                if (PrivacyPolicyView.this.f == null || PrivacyPolicyView.this.k) {
                    return;
                }
                PrivacyPolicyView.this.j = true;
                Log.d(PrivacyPolicyView.n, "reload.......");
                PrivacyPolicyView privacyPolicyView = PrivacyPolicyView.this;
                privacyPolicyView.loadPolicyUrl(privacyPolicyView.l);
            } catch (Throwable unused) {
            }
        }
    }

    private void c() {
        WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setCacheMode(-1);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new AnonymousClass2());
        this.f.setWebChromeClient(new AnonymousClass3());
    }

    /* JADX INFO: renamed from: com.anythink.core.activity.component.PrivacyPolicyView$2, reason: invalid class name */
    final class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Log.d(PrivacyPolicyView.n, "onPageStarted:".concat(String.valueOf(str)));
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            try {
                Log.d(PrivacyPolicyView.n, "onPageFinished:" + str + "   mIsWebViewloadSuccess:" + PrivacyPolicyView.this.j);
                if (PrivacyPolicyView.this.l.equals(str)) {
                    if (PrivacyPolicyView.this.j) {
                        PrivacyPolicyView.this.b.setVisibility(4);
                        PrivacyPolicyView.this.a.setVisibility(0);
                        PrivacyPolicyView.this.b.setVisibility(8);
                        PrivacyPolicyView.this.c.clearAnimation();
                        if (PrivacyPolicyView.this.m != null) {
                            PrivacyPolicyView.this.m.onPageLoadSuccess();
                        }
                    } else {
                        PrivacyPolicyView.this.b.setVisibility(0);
                        PrivacyPolicyView.this.c.clearAnimation();
                        PrivacyPolicyView.this.d.setVisibility(0);
                        PrivacyPolicyView.this.a.setVisibility(8);
                        if (PrivacyPolicyView.this.m != null) {
                            PrivacyPolicyView.this.m.onPageLoadFail();
                        }
                    }
                    PrivacyPolicyView.this.k = false;
                    super.onPageFinished(webView, str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.d(PrivacyPolicyView.n, "shouldOverrideUrlLoading:".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PrivacyPolicyView.a(PrivacyPolicyView.this.getContext(), str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            PrivacyPolicyView.this.j = false;
            Log.d(PrivacyPolicyView.n, "onPageFinished:" + webResourceError.getErrorCode());
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    /* JADX INFO: renamed from: com.anythink.core.activity.component.PrivacyPolicyView$3, reason: invalid class name */
    final class AnonymousClass3 extends WebChromeClient {
        AnonymousClass3() {
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("error")) {
                PrivacyPolicyView.this.j = false;
            }
            super.onReceivedTitle(webView, str);
        }
    }

    public void loadPolicyUrl(String str) {
        if (this.k) {
            return;
        }
        this.l = str;
        if (q.a(getContext())) {
            this.j = true;
            this.b.setVisibility(0);
            this.c.clearAnimation();
            this.c.startAnimation();
            this.d.setVisibility(8);
            this.k = true;
            if (this.l.equals(this.f.getUrl())) {
                this.f.reload();
                return;
            } else {
                this.f.loadUrl(this.l);
                return;
            }
        }
        this.j = false;
        this.b.setVisibility(0);
        this.c.clearAnimation();
        this.d.setVisibility(0);
        this.a.setVisibility(8);
        a aVar = this.m;
        if (aVar != null) {
            aVar.onPageLoadFail();
        }
    }

    private static void b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
    }

    public void destory() {
        try {
            removeAllViews();
            ViewGroup viewGroup = this.a;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            FrameLayout frameLayout = this.e;
            if (frameLayout != null) {
                frameLayout.removeView(this.f);
                this.f.removeAllViews();
            }
            WebView webView = this.f;
            if (webView != null) {
                webView.clearHistory();
                this.f.clearCache(true);
                this.f.destroy();
                this.f = null;
            }
        } catch (Throwable unused) {
        }
    }

    public void setResultCallbackListener(a aVar) {
        this.m = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.h) {
            ATSDK.setGDPRUploadDataLevel(getContext(), 0);
            view.setTag(0);
            a aVar = this.m;
            if (aVar != null) {
                aVar.onLevelSelect(0);
                return;
            }
            return;
        }
        if (view == this.i) {
            ATSDK.setGDPRUploadDataLevel(getContext(), 1);
            view.setTag(1);
            a aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.onLevelSelect(1);
            }
        }
    }

    static /* synthetic */ void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
    }
}
