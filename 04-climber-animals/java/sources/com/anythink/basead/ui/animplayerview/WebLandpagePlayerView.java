package com.anythink.basead.ui.animplayerview;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.basead.j.e;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.basead.ui.web.BaseWebView;
import com.anythink.core.basead.ui.web.WebProgressBarView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.cc;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.res.image.RecycleImageView;
import com.anythink.core.common.v.q;
import com.anythink.core.common.v.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class WebLandpagePlayerView extends BaseAnimPlayerView implements com.anythink.core.basead.ui.web.b {
    int A;
    int B;
    IOfferClickHandler C;
    int D;
    String E;
    boolean F;
    private final int G;
    private final int H;
    private final int I;
    private final int J;
    private TranslateAnimation K;
    private TranslateAnimation L;
    private TranslateAnimation M;
    private WebView N;
    private com.anythink.core.basead.ui.web.c O;
    private ValueCallback<Uri[]> P;
    private final int Q;
    private String R;
    private int S;
    private Map<String, JSONArray> T;
    private boolean U;
    LinearLayout h;

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void a() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void b() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void c() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    protected final void d() {
    }

    @Override // com.anythink.core.basead.ui.web.b
    public WebProgressBarView getWebProgressBarView() {
        return null;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebFinish() {
    }

    @Override // com.anythink.core.basead.ui.web.b
    public boolean supportDeeplinkJump() {
        return true;
    }

    static /* synthetic */ int c(WebLandpagePlayerView webLandpagePlayerView) {
        webLandpagePlayerView.S = 2;
        return 2;
    }

    private static /* synthetic */ boolean f(WebLandpagePlayerView webLandpagePlayerView) {
        webLandpagePlayerView.U = true;
        return true;
    }

    public WebLandpagePlayerView(Context context) {
        super(context, null);
        this.G = 1;
        this.H = 2;
        this.I = 3;
        this.J = 0;
        this.A = 8;
        this.B = 0;
        this.P = null;
        this.Q = 512;
        this.D = 0;
        this.F = false;
        this.R = "";
        this.S = 0;
        this.U = false;
    }

    public WebLandpagePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.G = 1;
        this.H = 2;
        this.I = 3;
        this.J = 0;
        this.A = 8;
        this.B = 0;
        this.P = null;
        this.Q = 512;
        this.D = 0;
        this.F = false;
        this.R = "";
        this.S = 0;
        this.U = false;
    }

    public WebLandpagePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.G = 1;
        this.H = 2;
        this.I = 3;
        this.J = 0;
        this.A = 8;
        this.B = 0;
        this.P = null;
        this.Q = 512;
        this.D = 0;
        this.F = false;
        this.R = "";
        this.S = 0;
        this.U = false;
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(w wVar, x xVar, boolean z, List<Bitmap> list, e eVar) {
        super.init(wVar, xVar, z, list, eVar);
        Context context = getContext();
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels - q.a(context, 40.0f));
        this.T = new LinkedHashMap();
        LinearLayout linearLayout = new LinearLayout(context);
        this.h = linearLayout;
        linearLayout.setGravity(1);
        this.h.setOrientation(1);
        this.h.setBackgroundColor(-1);
        RecycleImageView recycleImageView = new RecycleImageView(context);
        recycleImageView.setImageResource(q.a(getContext(), "myoffer_arrow_up", "drawable"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(q.a(context, 9.0f), q.a(context, 9.0f));
        layoutParams.topMargin = q.a(context, 3.0f);
        this.h.addView(recycleImageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setText(q.a(getContext(), "myoffer_slide_hint", "string"));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(Color.parseColor("#000000"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = q.a(context, 1.0f);
        this.h.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, q.a(context, 54.0f));
        layoutParams3.addRule(12);
        layoutParams3.setMargins(0, 0, 0, 0);
        addView(this.h, layoutParams3);
        if (this.K == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, q.a(context, 18.0f), 0.0f);
            this.K = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.K.setRepeatMode(2);
            this.K.setRepeatCount(-1);
            this.K.setInterpolator(new AnticipateInterpolator());
            this.K.setDuration(600L);
        }
        this.h.startAnimation(this.K);
        post(new AnonymousClass1(context));
    }

    private void a(Context context) {
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels - q.a(context, 40.0f));
        this.T = new LinkedHashMap();
        LinearLayout linearLayout = new LinearLayout(context);
        this.h = linearLayout;
        linearLayout.setGravity(1);
        this.h.setOrientation(1);
        this.h.setBackgroundColor(-1);
        RecycleImageView recycleImageView = new RecycleImageView(context);
        recycleImageView.setImageResource(q.a(getContext(), "myoffer_arrow_up", "drawable"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(q.a(context, 9.0f), q.a(context, 9.0f));
        layoutParams.topMargin = q.a(context, 3.0f);
        this.h.addView(recycleImageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setText(q.a(getContext(), "myoffer_slide_hint", "string"));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(Color.parseColor("#000000"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = q.a(context, 1.0f);
        this.h.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, q.a(context, 54.0f));
        layoutParams3.addRule(12);
        layoutParams3.setMargins(0, 0, 0, 0);
        addView(this.h, layoutParams3);
        if (this.K == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, q.a(context, 18.0f), 0.0f);
            this.K = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.K.setRepeatMode(2);
            this.K.setRepeatCount(-1);
            this.K.setInterpolator(new AnticipateInterpolator());
            this.K.setDuration(600L);
        }
        this.h.startAnimation(this.K);
        post(new AnonymousClass1(context));
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebLandpagePlayerView.a(WebLandpagePlayerView.this, this.a);
            WebLandpagePlayerView.a(WebLandpagePlayerView.this);
        }
    }

    private void b(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.h = linearLayout;
        linearLayout.setGravity(1);
        this.h.setOrientation(1);
        this.h.setBackgroundColor(-1);
        RecycleImageView recycleImageView = new RecycleImageView(context);
        recycleImageView.setImageResource(q.a(getContext(), "myoffer_arrow_up", "drawable"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(q.a(context, 9.0f), q.a(context, 9.0f));
        layoutParams.topMargin = q.a(context, 3.0f);
        this.h.addView(recycleImageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setText(q.a(getContext(), "myoffer_slide_hint", "string"));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(Color.parseColor("#000000"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = q.a(context, 1.0f);
        this.h.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, q.a(context, 54.0f));
        layoutParams3.addRule(12);
        layoutParams3.setMargins(0, 0, 0, 0);
        addView(this.h, layoutParams3);
        if (this.K == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, q.a(context, 18.0f), 0.0f);
            this.K = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.K.setRepeatMode(2);
            this.K.setRepeatCount(-1);
            this.K.setInterpolator(new AnticipateInterpolator());
            this.K.setDuration(600L);
        }
        this.h.startAnimation(this.K);
    }

    private void i() {
        if (this.L == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -getMeasuredHeight());
            this.L = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.L.setDuration(1200L);
        }
        if (this.M == null) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, getMeasuredHeight(), 0.0f);
            this.M = translateAnimation2;
            translateAnimation2.setFillAfter(true);
            this.M.setDuration(1200L);
            this.M.setAnimationListener(new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$2, reason: invalid class name */
    final class AnonymousClass2 implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        AnonymousClass2() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            if (WebLandpagePlayerView.this.N != null) {
                WebLandpagePlayerView.this.N.setVisibility(0);
            }
        }
    }

    private void c(Context context) {
        try {
            this.N = new BaseWebView(context);
            this.O = new com.anythink.core.basead.ui.web.c(this.x);
            this.N.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getMeasuredHeight());
            this.N.setVisibility(8);
            addView(this.N, layoutParams);
            com.anythink.core.basead.ui.a.a.a(context);
            com.anythink.core.basead.ui.a.a.a(this.N, context, this);
            this.N.setDownloadListener(new AnonymousClass3(context));
            this.F = true;
        } catch (Throwable unused) {
            this.F = false;
        }
    }

    private void d(Context context) {
        com.anythink.core.basead.ui.a.a.a(this.N, context, this);
        this.N.setDownloadListener(new AnonymousClass3(context));
    }

    /* JADX INFO: renamed from: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView$3, reason: invalid class name */
    final class AnonymousClass3 implements DownloadListener {
        final /* synthetic */ Context a;

        AnonymousClass3(Context context) {
            this.a = context;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            t.b();
            if (WebLandpagePlayerView.this.x != null && WebLandpagePlayerView.this.y != null && !TextUtils.isEmpty(WebLandpagePlayerView.this.x.I())) {
                if (WebLandpagePlayerView.this.C == null || !(WebLandpagePlayerView.this.C instanceof IOfferClickHandler) || !WebLandpagePlayerView.this.C.startDataFetchApp(this.a, WebLandpagePlayerView.this.x, WebLandpagePlayerView.this.y, str)) {
                    WebLandpagePlayerView.this.B = 2;
                    y.a(str);
                    WebLandpagePlayerView.this.A = 7;
                } else {
                    WebLandpagePlayerView.this.A = 6;
                    WebLandpagePlayerView.this.B = 1;
                }
            } else {
                WebLandpagePlayerView.this.A = 11;
                y.a(str);
            }
            WebLandpagePlayerView.c(WebLandpagePlayerView.this);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void start() {
        super.start();
        if (this.N != null) {
            CookieSyncManager.getInstance().startSync();
            this.N.setWebChromeClient(new WebChromeClient() { // from class: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.4
                @Override // android.webkit.WebChromeClient
                public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    try {
                        WebLandpagePlayerView.this.P = valueCallback;
                        Intent intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*", "audio/*"});
                        intent.addCategory("android.intent.category.OPENABLE");
                        intent.setType("image/* video/* audio/*");
                        if (!(WebLandpagePlayerView.this.getContext() instanceof Activity)) {
                            return true;
                        }
                        ((Activity) WebLandpagePlayerView.this.getContext()).startActivityForResult(Intent.createChooser(intent, "File Chooser"), 512);
                        return true;
                    } catch (Throwable unused) {
                        return false;
                    }
                }

                @Override // android.webkit.WebChromeClient
                public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
                    com.anythink.core.basead.ui.a.a.a(WebLandpagePlayerView.this.getContext(), str, callback);
                    super.onGeolocationPermissionsShowPrompt(str, callback);
                }
            });
            this.N.onResume();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        super.pause();
        if (this.N != null) {
            CookieSyncManager.getInstance().stopSync();
            this.N.setWebChromeClient(null);
            com.anythink.core.basead.ui.a.a.a(this.N, getContext() instanceof Activity ? ((Activity) getContext()).isFinishing() : false);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        super.stop();
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void release(int i) {
        super.release(i);
        WebView webView = this.N;
        if (webView != null) {
            webView.setDownloadListener(null);
            this.N.destroy();
        }
        this.N = null;
        if (this.x == null || this.y == null) {
            return;
        }
        x xVar = this.y;
        int iB = this.x.b();
        String strV = this.x.v();
        Map<String, JSONArray> map = this.T;
        int i2 = this.D;
        int i3 = this.B;
        int i4 = this.A;
        String str = this.E;
        int i5 = this.y.j;
        String str2 = this.R;
        int i6 = this.S;
        if (i6 == 0) {
            i6 = 1;
        }
        com.anythink.core.common.u.e.a(xVar, iB, strV, map, i2, i3, i4, str, i5, 1, 0L, str2, i6, this.U);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == 512) {
            try {
                if (this.P == null) {
                    return;
                }
                if (i2 != -1 || intent == null) {
                    uriArr = null;
                } else {
                    String dataString = intent.getDataString();
                    try {
                        ClipData clipData = intent.getClipData();
                        if (clipData != null) {
                            uriArr = new Uri[clipData.getItemCount()];
                            for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                                try {
                                    uriArr[i3] = clipData.getItemAt(i3).getUri();
                                } catch (Throwable unused) {
                                }
                            }
                        } else {
                            uriArr = null;
                        }
                    } catch (Throwable unused2) {
                    }
                    if (dataString != null) {
                        uriArr = new Uri[]{Uri.parse(dataString)};
                    }
                }
                this.P.onReceiveValue(uriArr);
                this.P = null;
            } catch (Throwable unused3) {
            }
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void recordRedirectUrl(String str) {
        if (this.T.size() > 0) {
            JSONArray jSONArray = this.T.get(this.R);
            try {
                if (this.S == 0 && jSONArray != null) {
                    if (TextUtils.isEmpty(jSONArray.getString(1))) {
                        jSONArray.put(1, new StringBuilder().append(System.currentTimeMillis()).toString());
                    }
                    this.T.put(this.R, jSONArray);
                }
            } catch (Throwable unused) {
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(new StringBuilder().append(System.currentTimeMillis()).toString());
        jSONArray2.put("");
        this.T.put(str, jSONArray2);
        this.R = str;
        this.S = 0;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void callbackClickResult(cc ccVar) {
        this.A = ccVar.l;
        if (ccVar.n) {
            if (ccVar.m) {
                this.D = 1;
                this.S = 2;
            } else {
                this.D = 2;
            }
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageFinish(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && this.S != 3) {
            this.S = 2;
            JSONArray jSONArray = this.T.get(str);
            if (jSONArray != null) {
                try {
                    jSONArray.put(1, new StringBuilder().append(System.currentTimeMillis()).toString());
                    this.T.put(str, jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        com.anythink.core.basead.ui.web.c cVar = this.O;
        if (cVar != null) {
            cVar.a(webView, str);
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageStart(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.S = 1;
        JSONArray jSONArray = this.T.get(str);
        if (jSONArray != null) {
            try {
                jSONArray.put(0, new StringBuilder().append(System.currentTimeMillis()).toString());
                jSONArray.put(1, "");
                this.T.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.anythink.core.basead.ui.web.b
    public void onWebPageLoadError(WebView webView, String str) {
        this.S = 3;
    }

    @Override // com.anythink.core.basead.ui.web.b
    public w getBaseAdContent() {
        return this.x;
    }

    public synchronized boolean openInternalWebView(String str, IOfferClickHandler iOfferClickHandler) {
        if (TextUtils.isEmpty(this.E)) {
            this.E = str;
            this.C = iOfferClickHandler;
            post(new Runnable() { // from class: com.anythink.basead.ui.animplayerview.WebLandpagePlayerView.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (WebLandpagePlayerView.this.N != null) {
                        cc ccVarA = com.anythink.core.basead.a.e.a(WebLandpagePlayerView.this.E);
                        WebLandpagePlayerView.this.A = ccVarA.l;
                        WebLandpagePlayerView.this.N.loadUrl(ccVarA.o);
                        WebLandpagePlayerView webLandpagePlayerView = WebLandpagePlayerView.this;
                        webLandpagePlayerView.recordRedirectUrl(webLandpagePlayerView.N.getUrl());
                        if (WebLandpagePlayerView.this.h.getAnimation() != null) {
                            WebLandpagePlayerView.this.h.getAnimation().cancel();
                        }
                        WebLandpagePlayerView.this.h.startAnimation(WebLandpagePlayerView.this.L);
                        WebLandpagePlayerView.this.N.startAnimation(WebLandpagePlayerView.this.M);
                    }
                }
            });
        }
        return this.F;
    }

    static /* synthetic */ void a(WebLandpagePlayerView webLandpagePlayerView, Context context) {
        try {
            webLandpagePlayerView.N = new BaseWebView(context);
            webLandpagePlayerView.O = new com.anythink.core.basead.ui.web.c(webLandpagePlayerView.x);
            webLandpagePlayerView.N.setBackgroundColor(-1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, webLandpagePlayerView.getMeasuredHeight());
            webLandpagePlayerView.N.setVisibility(8);
            webLandpagePlayerView.addView(webLandpagePlayerView.N, layoutParams);
            com.anythink.core.basead.ui.a.a.a(context);
            com.anythink.core.basead.ui.a.a.a(webLandpagePlayerView.N, context, webLandpagePlayerView);
            webLandpagePlayerView.N.setDownloadListener(webLandpagePlayerView.new AnonymousClass3(context));
            webLandpagePlayerView.F = true;
        } catch (Throwable unused) {
            webLandpagePlayerView.F = false;
        }
    }

    static /* synthetic */ void a(WebLandpagePlayerView webLandpagePlayerView) {
        if (webLandpagePlayerView.L == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -webLandpagePlayerView.getMeasuredHeight());
            webLandpagePlayerView.L = translateAnimation;
            translateAnimation.setFillAfter(true);
            webLandpagePlayerView.L.setDuration(1200L);
        }
        if (webLandpagePlayerView.M == null) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, webLandpagePlayerView.getMeasuredHeight(), 0.0f);
            webLandpagePlayerView.M = translateAnimation2;
            translateAnimation2.setFillAfter(true);
            webLandpagePlayerView.M.setDuration(1200L);
            webLandpagePlayerView.M.setAnimationListener(webLandpagePlayerView.new AnonymousClass2());
        }
    }
}
