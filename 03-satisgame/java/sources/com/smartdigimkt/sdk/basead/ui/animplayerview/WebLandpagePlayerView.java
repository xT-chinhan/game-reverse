package com.smartdigimkt.sdk.basead.ui.animplayerview;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.v;
import com.smartdigimkt.h0.g;
import com.smartdigimkt.j2.b;
import com.smartdigimkt.j2.e;
import com.smartdigimkt.q1.p;
import com.smartdigimkt.q1.s;
import com.smartdigimkt.q1.t;
import com.smartdigimkt.r4.k;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.basead.ui.web.BaseWebView;
import com.smartdigimkt.sdk.basead.ui.web.WebProgressBarView;
import com.smartdigimkt.sdk.core.common.res.image.RecycleImageView;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class WebLandpagePlayerView extends BaseAnimPlayerView implements b {
    public static final /* synthetic */ int S = 0;
    public LinearLayout C;
    public TranslateAnimation D;
    public TranslateAnimation E;
    public TranslateAnimation F;
    public BaseWebView G;
    public int H;
    public int I;
    public IOfferClickHandler J;
    public e K;
    public ValueCallback L;
    public int M;
    public String N;
    public boolean O;
    public String P;
    public int Q;
    public LinkedHashMap R;

    public WebLandpagePlayerView(Context context) {
        super(context, null);
        this.H = 8;
        this.I = 0;
        this.L = null;
        this.M = 0;
        this.O = false;
        this.P = "";
        this.Q = 0;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
    }

    @Override // com.smartdigimkt.j2.b
    public void callbackClickResult(v vVar) {
        this.H = vVar.a;
        if (vVar.c) {
            if (!vVar.b) {
                this.M = 2;
            } else {
                this.M = 1;
                this.Q = 2;
            }
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
    }

    @Override // com.smartdigimkt.j2.b
    public c getBaseAdContent() {
        return this.p;
    }

    @Override // com.smartdigimkt.j2.b
    public a getBaseAdRequestInfo() {
        return null;
    }

    @Override // com.smartdigimkt.j2.b
    public String getOriginalUrl() {
        return "";
    }

    @Override // com.smartdigimkt.j2.b
    public WebProgressBarView getWebProgressBarView() {
        return null;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void init(c cVar, a aVar, boolean z, List<Bitmap> list) {
        super.init(cVar, aVar, z, list);
        Context context = getContext();
        a(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels - k.a(context, 40.0f));
        this.R = new LinkedHashMap();
        LinearLayout linearLayout = new LinearLayout(context);
        this.C = linearLayout;
        linearLayout.setGravity(1);
        this.C.setOrientation(1);
        this.C.setBackgroundColor(-1);
        RecycleImageView recycleImageView = new RecycleImageView(context);
        recycleImageView.setImageResource(k.a(getContext(), "myoffer_arrow_up", "drawable"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 9.0f) + 0.5f), (int) ((context.getResources().getDisplayMetrics().density * 9.0f) + 0.5f));
        layoutParams.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
        this.C.addView(recycleImageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setText(k.a(getContext(), "myoffer_slide_hint", "string"));
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(Color.parseColor("#000000"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = (int) ((context.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.C.addView(textView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) ((context.getResources().getDisplayMetrics().density * 54.0f) + 0.5f));
        layoutParams3.addRule(12);
        layoutParams3.setMargins(0, 0, 0, 0);
        addView(this.C, layoutParams3);
        if (this.D == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (int) ((context.getResources().getDisplayMetrics().density * 18.0f) + 0.5f), 0.0f);
            this.D = translateAnimation;
            translateAnimation.setFillAfter(true);
            this.D.setRepeatMode(2);
            this.D.setRepeatCount(-1);
            this.D.setInterpolator(new AnticipateInterpolator());
            this.D.setDuration(600L);
        }
        this.C.startAnimation(this.D);
        post(new p(this, context));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == 512) {
            try {
                if (this.L == null) {
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
                this.L.onReceiveValue(uriArr);
                this.L = null;
            } catch (Throwable unused3) {
            }
        }
    }

    @Override // com.smartdigimkt.j2.b
    public void onWebFinish() {
        this.Q = 3;
        BaseWebView baseWebView = this.G;
        this.G = null;
        this.O = false;
        if (baseWebView != null) {
            try {
                baseWebView.stopLoading();
                baseWebView.setWebChromeClient(null);
                baseWebView.setDownloadListener(null);
                ViewParent parent = baseWebView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(baseWebView);
                }
                baseWebView.destroy();
            } catch (Throwable unused) {
            }
        }
        a(new g(com.anythink.core.common.inner.b.b.k, "WebView render process gone!"));
    }

    @Override // com.smartdigimkt.j2.b
    public void onWebPageFinish(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && this.Q != 3) {
            this.Q = 2;
            JSONArray jSONArray = (JSONArray) this.R.get(str);
            if (jSONArray != null) {
                try {
                    jSONArray.put(1, "" + System.currentTimeMillis());
                    this.R.put(str, jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        e eVar = this.K;
        if (eVar != null) {
            eVar.a(webView, str);
        }
    }

    @Override // com.smartdigimkt.j2.b
    public void onWebPageLoadError(WebView webView, String str) {
        this.Q = 3;
    }

    @Override // com.smartdigimkt.j2.b
    public void onWebPageStart(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.Q = 1;
        JSONArray jSONArray = (JSONArray) this.R.get(str);
        if (jSONArray != null) {
            try {
                jSONArray.put(0, "" + System.currentTimeMillis());
                jSONArray.put(1, "");
                this.R.put(str, jSONArray);
            } catch (JSONException unused) {
            }
        }
    }

    public synchronized boolean openInternalWebView(String str, IOfferClickHandler iOfferClickHandler) {
        if (TextUtils.isEmpty(this.N)) {
            this.N = str;
            this.J = iOfferClickHandler;
            post(new t(this));
        }
        return this.O;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void pause() {
        super.pause();
        if (this.G != null) {
            CookieSyncManager.getInstance().stopSync();
            this.G.setWebChromeClient(null);
            boolean zIsFinishing = getContext() instanceof Activity ? ((Activity) getContext()).isFinishing() : false;
            BaseWebView baseWebView = this.G;
            if (zIsFinishing) {
                baseWebView.stopLoading();
                baseWebView.loadUrl("");
            }
            baseWebView.onPause();
        }
    }

    @Override // com.smartdigimkt.j2.b
    public void recordRedirectUrl(String str) {
        if (this.R.size() > 0) {
            JSONArray jSONArray = (JSONArray) this.R.get(this.P);
            try {
                if (this.Q == 0 && jSONArray != null) {
                    if (TextUtils.isEmpty(jSONArray.getString(1))) {
                        jSONArray.put(1, "" + System.currentTimeMillis());
                    }
                    this.R.put(this.P, jSONArray);
                }
            } catch (Throwable unused) {
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put("" + System.currentTimeMillis());
        jSONArray2.put("");
        this.R.put(str, jSONArray2);
        this.P = str;
        this.Q = 0;
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void release(int i) {
        a aVar;
        super.release(i);
        BaseWebView baseWebView = this.G;
        if (baseWebView != null) {
            baseWebView.setDownloadListener(null);
            this.G.destroy();
        }
        this.G = null;
        c cVar = this.p;
        if (cVar == null || (aVar = this.q) == null) {
            return;
        }
        int iE = cVar.e();
        String str = this.p.a;
        LinkedHashMap linkedHashMap = this.R;
        int i2 = this.M;
        int i3 = this.I;
        int i4 = this.H;
        String str2 = this.N;
        int i5 = this.q.c;
        String str3 = this.P;
        int i6 = this.Q;
        if (i6 == 0) {
            i6 = 1;
        }
        com.smartdigimkt.n3.k.a(aVar, iE, str, linkedHashMap, i2, i3, i4, str2, i5, 1, 0L, str3, i6);
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void start() {
        super.start();
        if (this.G != null) {
            CookieSyncManager.getInstance().startSync();
            this.G.setWebChromeClient(new s(this));
            this.G.onResume();
        }
    }

    @Override // com.smartdigimkt.sdk.basead.ui.animplayerview.BaseAnimPlayerView, com.smartdigimkt.sdk.basead.ui.animplayerview.BasePlayerView
    public void stop() {
        super.stop();
    }

    @Override // com.smartdigimkt.j2.b
    public boolean supportDeeplinkJump() {
        return true;
    }

    public WebLandpagePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.H = 8;
        this.I = 0;
        this.L = null;
        this.M = 0;
        this.O = false;
        this.P = "";
        this.Q = 0;
    }

    public WebLandpagePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.H = 8;
        this.I = 0;
        this.L = null;
        this.M = 0;
        this.O = false;
        this.P = "";
        this.Q = 0;
    }
}
