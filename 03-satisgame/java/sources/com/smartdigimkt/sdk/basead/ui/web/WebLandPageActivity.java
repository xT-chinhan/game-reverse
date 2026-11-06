package com.smartdigimkt.sdk.basead.ui.web;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.C;
import com.smartdigimkt.a3.a;
import com.smartdigimkt.b3.c;
import com.smartdigimkt.b3.v;
import com.smartdigimkt.c0.h;
import com.smartdigimkt.i2.x;
import com.smartdigimkt.j2.b;
import com.smartdigimkt.j2.d;
import com.smartdigimkt.j2.e;
import com.smartdigimkt.j2.f;
import com.smartdigimkt.j2.g;
import com.smartdigimkt.j2.i;
import com.smartdigimkt.j2.j;
import com.smartdigimkt.j2.l;
import com.smartdigimkt.j2.m;
import com.smartdigimkt.j2.n;
import com.smartdigimkt.j2.p;
import com.smartdigimkt.j2.q;
import com.smartdigimkt.n3.k;
import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class WebLandPageActivity extends Activity implements b {
    public static final /* synthetic */ int E = 0;
    public JSONArray A;
    public long D;
    public com.smartdigimkt.r4.b a;
    public WebProgressBarView b;
    public BaseWebView c;
    public ImageView d;
    public ImageView e;
    public TextView f;
    public ValueAnimator h;
    public Random i;
    public int j;
    public long k;
    public LinkedHashMap l;
    public WebLoadFailRefrshView o;
    public RelativeLayout p;
    public c s;
    public a t;
    public String u;
    public IOfferClickHandler v;
    public e w;
    public int x;
    public int g = 8;
    public String m = "";
    public int n = 0;
    public boolean q = true;
    public String r = "";
    public boolean y = false;
    public ValueCallback z = null;
    public int B = 0;
    public int C = 0;

    public static void a(Context context, String str) {
        d.b = true;
        Intent intent = new Intent();
        intent.setClass(context, WebLandPageActivity.class);
        intent.putExtra(com.anythink.core.basead.a.C0009a.c, (Serializable) null);
        intent.putExtra(com.anythink.core.basead.a.C0009a.e, (Serializable) null);
        intent.putExtra(com.anythink.core.basead.a.C0009a.i, str);
        intent.putExtra(com.anythink.core.basead.a.C0009a.p, -1);
        intent.putExtra(com.anythink.core.basead.a.C0009a.q, true);
        intent.putExtra("extra_need_limit_redirect", false);
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        context.startActivity(intent);
    }

    @Override // com.smartdigimkt.j2.b
    public final void callbackClickResult(v vVar) {
        this.g = vVar.a;
        if (vVar.c) {
            if (vVar.b) {
                this.B = 1;
                this.n = 2;
                a();
                return;
            }
            this.B = 2;
            if (vVar.e) {
                c cVar = this.s;
                k.a(2, 0, this.t, cVar, vVar.d, this.D > 0);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.D = System.currentTimeMillis();
            this.q = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public final void finish() {
        com.smartdigimkt.b3.e eVar;
        a aVar = this.t;
        if (aVar == null || (eVar = aVar.s) == null || eVar.J1 != 1) {
            a();
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, com.smartdigimkt.r4.k.a(this, "system_dialog", "style"));
            builder.setMessage(getString(com.smartdigimkt.r4.k.a(this, "web_land_page_dialog_title", "string"))).setCancelable(true).setPositiveButton(getString(com.smartdigimkt.r4.k.a(this, "web_land_page_dialog_stay", "string")), new f(this)).setNegativeButton(getString(com.smartdigimkt.r4.k.a(this, "web_land_page_dialog_yes", "string")), new q(this));
            builder.create().show();
        } catch (Throwable unused) {
            a();
        }
    }

    @Override // com.smartdigimkt.j2.b
    public final c getBaseAdContent() {
        return this.s;
    }

    @Override // com.smartdigimkt.j2.b
    public final a getBaseAdRequestInfo() {
        return this.t;
    }

    @Override // com.smartdigimkt.j2.b
    public final String getOriginalUrl() {
        return this.r;
    }

    @Override // com.smartdigimkt.j2.b
    public final WebProgressBarView getWebProgressBarView() {
        return this.b;
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        if (i == 512) {
            try {
                if (this.z == null) {
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
                this.z.onReceiveValue(uriArr);
                this.z = null;
            } catch (Throwable unused3) {
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        BaseWebView baseWebView = this.c;
        if (baseWebView == null || !baseWebView.canGoBack()) {
            finish();
        } else {
            this.c.goBack();
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = com.smartdigimkt.r4.d.a(this, new i(this));
        SDKContext.getInstance().a(getApplicationContext());
        this.k = SystemClock.elapsedRealtime();
        this.l = new LinkedHashMap();
        setResult(-1);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                Serializable serializableExtra = intent.getSerializableExtra(com.anythink.core.basead.a.C0009a.c);
                if (serializableExtra != null && (serializableExtra instanceof c)) {
                    c cVar = (c) serializableExtra;
                    this.s = cVar;
                    this.w = new e(cVar);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Serializable serializableExtra2 = intent.getSerializableExtra(com.anythink.core.basead.a.C0009a.e);
                if (serializableExtra2 != null && (serializableExtra2 instanceof a)) {
                    this.t = (a) serializableExtra2;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                Serializable serializableExtra3 = intent.getSerializableExtra(com.anythink.core.basead.a.C0009a.k);
                if (serializableExtra3 != null && (serializableExtra3 instanceof IOfferClickHandler)) {
                    this.v = (IOfferClickHandler) serializableExtra3;
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                this.u = intent.getStringExtra(com.anythink.core.basead.a.C0009a.i);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                this.x = intent.getIntExtra(com.anythink.core.basead.a.C0009a.p, -1);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            this.q = true;
            try {
                this.q = intent.getBooleanExtra(com.anythink.core.basead.a.C0009a.q, true);
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            try {
                this.y = intent.getBooleanExtra("extra_need_limit_redirect", false);
            } catch (Throwable th7) {
                th7.printStackTrace();
            }
        }
        String str = this.u;
        if (TextUtils.isEmpty(str)) {
            c cVar2 = this.s;
            str = cVar2 != null ? cVar2.l : "";
        }
        Context applicationContext = getApplicationContext();
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(applicationContext, com.smartdigimkt.r4.k.a(applicationContext, "basead_click_empty", "string"), 0).show();
            this.n = 3;
            a();
            return;
        }
        if (this.q) {
            v vVarA = h.a(applicationContext, str, this.s);
            if (vVarA.b) {
                callbackClickResult(vVarA);
                return;
            }
            callbackClickResult(vVarA);
        }
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(343452);
        char[] cArr = com.smartdigimkt.r4.k.a;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((getResources().getDisplayMetrics().density * 55.0f) + 0.5f));
        layoutParams.addRule(10);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        int i = (int) ((getResources().getDisplayMetrics().density * 16.0f) + 0.5f);
        linearLayout.setPadding(i, 0, i, 0);
        relativeLayout.addView(linearLayout);
        this.d = a(getResources().getDrawable(com.smartdigimkt.r4.k.a(this, "browser_left_icon", "drawable")));
        this.e = a(getResources().getDrawable(com.smartdigimkt.r4.k.a(this, "browser_close_icon", "drawable")));
        linearLayout.addView(this.d);
        linearLayout.addView(this.e);
        TextView textView = new TextView(this);
        new LinearLayout.LayoutParams(0, -2, 1.0f);
        textView.setPadding((int) ((getResources().getDisplayMetrics().density * 20.0f) + 0.5f), 0, 0, (int) ((getResources().getDisplayMetrics().density * 2.0f) + 0.5f));
        textView.setTextSize(1, 18.0f);
        textView.setTextColor(Color.parseColor("#666666"));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.f = textView;
        linearLayout.addView(textView);
        try {
            this.c = new BaseWebView(getApplicationContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, 343452);
            this.c.setLayoutParams(layoutParams2);
            relativeLayout.addView(this.c);
            View view = new View(this);
            view.setBackgroundColor(-2434342);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5f));
            layoutParams3.addRule(3, 343452);
            view.setLayoutParams(layoutParams3);
            relativeLayout.addView(view);
            WebProgressBarView webProgressBarView = new WebProgressBarView(this);
            this.b = webProgressBarView;
            webProgressBarView.setProgress(0);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) ((getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
            layoutParams4.addRule(3, 343452);
            relativeLayout.addView(this.b, layoutParams4);
            Random random = new Random();
            this.i = random;
            this.j = random.nextInt(12) + 3;
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 70);
            this.h = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(1000L);
            this.h.addUpdateListener(new g(this));
            this.h.start();
        } catch (Throwable unused) {
            relativeLayout = null;
        }
        this.p = relativeLayout;
        if (relativeLayout == null) {
            com.smartdigimkt.s4.e.a(str);
            a();
            return;
        }
        setContentView(relativeLayout);
        RelativeLayout relativeLayout2 = this.p;
        if (relativeLayout2 != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 28) {
                relativeLayout2.setFitsSystemWindows(true);
                this.p.requestApplyInsets();
            } else if (i2 >= 28) {
                Rect rect = new Rect(relativeLayout2.getPaddingLeft(), relativeLayout2.getPaddingTop(), relativeLayout2.getPaddingRight(), relativeLayout2.getPaddingBottom());
                relativeLayout2.setFitsSystemWindows(false);
                relativeLayout2.setOnApplyWindowInsetsListener(new com.smartdigimkt.n1.b(rect));
                relativeLayout2.addOnLayoutChangeListener(new com.smartdigimkt.n1.c());
                relativeLayout2.requestApplyInsets();
            }
        }
        this.d.setOnClickListener(new m(this));
        this.e.setOnClickListener(new n(this));
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        x.a(this.c, this, this.y);
        this.c.setDownloadListener(new j(this));
        v vVarB = h.b(str);
        this.g = vVarB.a;
        String str2 = vVarB.d;
        this.r = str2;
        this.c.loadUrl(str2);
        recordRedirectUrl(this.c.getUrl());
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        a aVar;
        com.smartdigimkt.r4.b bVar = this.a;
        if (bVar != null) {
            bVar.run();
            this.a = null;
        }
        d.b = false;
        super.onDestroy();
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.h = null;
        }
        BaseWebView baseWebView = this.c;
        if (baseWebView != null) {
            baseWebView.setDownloadListener(null);
            this.c.destroy();
        }
        this.c = null;
        c cVar = this.s;
        if (cVar == null || (aVar = this.t) == null) {
            return;
        }
        int iE = cVar.e();
        String str = this.s.a;
        LinkedHashMap linkedHashMap = this.l;
        int i = this.B;
        int i2 = this.C;
        int i3 = this.g;
        String str2 = this.u;
        int i4 = this.t.c;
        int i5 = this.x;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.k;
        String str3 = this.m;
        int i6 = this.n;
        if (i6 == 0) {
            i6 = 1;
        }
        k.a(aVar, iE, str, linkedHashMap, i, i2, i3, str2, i4, i5, jElapsedRealtime, str3, i6);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        BaseWebView baseWebView = this.c;
        if (baseWebView != null) {
            baseWebView.setWebChromeClient(null);
            BaseWebView baseWebView2 = this.c;
            if (isFinishing()) {
                baseWebView2.stopLoading();
                baseWebView2.loadUrl("");
            }
            baseWebView2.onPause();
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        BaseWebView baseWebView = this.c;
        if (baseWebView != null) {
            baseWebView.setWebChromeClient(new p(this));
            this.c.onResume();
        }
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
        d.b = false;
        d.a.incrementAndGet();
    }

    @Override // android.app.Activity
    public final void onStop() {
        AtomicInteger atomicInteger = d.a;
        if (atomicInteger.decrementAndGet() < 0) {
            atomicInteger.set(0);
        }
        super.onStop();
    }

    @Override // com.smartdigimkt.j2.b
    public final void onWebFinish() {
        a();
    }

    @Override // com.smartdigimkt.j2.b
    public final void onWebPageFinish(WebView webView, String str) {
        BaseWebView baseWebView;
        WebLoadFailRefrshView webLoadFailRefrshView = this.o;
        if (webLoadFailRefrshView != null && webLoadFailRefrshView.getParent() == null && (baseWebView = this.c) != null) {
            baseWebView.setVisibility(0);
        }
        webView.canGoBack();
        webView.canGoForward();
        if (!TextUtils.isEmpty(str) && this.n != 3 && TextUtils.equals(this.m, str) && !isFinishing()) {
            this.n = 2;
            JSONArray jSONArray = (JSONArray) this.l.get(str);
            if (jSONArray != null) {
                try {
                    jSONArray.put(1, "" + System.currentTimeMillis());
                    this.l.put(str, jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        e eVar = this.w;
        if (eVar != null) {
            eVar.a(webView, str);
        }
    }

    @Override // com.smartdigimkt.j2.b
    public final void onWebPageLoadError(WebView webView, String str) {
        if (TextUtils.equals(this.m, str)) {
            this.n = 3;
        }
        WebLoadFailRefrshView webLoadFailRefrshView = this.o;
        if (webLoadFailRefrshView != null) {
            com.smartdigimkt.o3.d.a(webLoadFailRefrshView);
        } else {
            WebLoadFailRefrshView webLoadFailRefrshView2 = new WebLoadFailRefrshView(this);
            this.o = webLoadFailRefrshView2;
            BaseWebView baseWebView = this.c;
            if (baseWebView != null) {
                webLoadFailRefrshView2.setLayoutParams(baseWebView.getLayoutParams());
            }
            this.o.setOnRefreshListener(new com.smartdigimkt.j2.h(this));
        }
        BaseWebView baseWebView2 = this.c;
        if (baseWebView2 != null) {
            baseWebView2.setVisibility(8);
        }
        this.p.addView(this.o);
    }

    @Override // com.smartdigimkt.j2.b
    public final void onWebPageStart(WebView webView, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.equals(this.m, str)) {
                this.n = 1;
            }
            JSONArray jSONArray = (JSONArray) this.l.get(str);
            if (jSONArray != null) {
                try {
                    jSONArray.put(0, "" + System.currentTimeMillis());
                    jSONArray.put(1, "");
                    this.l.put(str, jSONArray);
                } catch (JSONException unused) {
                }
            }
        }
        WebLoadFailRefrshView webLoadFailRefrshView = this.o;
        if (webLoadFailRefrshView != null) {
            com.smartdigimkt.o3.d.a(webLoadFailRefrshView);
        }
    }

    @Override // com.smartdigimkt.j2.b
    public final void recordRedirectUrl(String str) {
        if (this.A == null) {
            this.A = new JSONArray();
        }
        this.A.put(str);
        if (this.l.size() > 0) {
            JSONArray jSONArray = (JSONArray) this.l.get(this.m);
            try {
                if (this.n == 0 && jSONArray != null) {
                    if (TextUtils.isEmpty(jSONArray.getString(1))) {
                        jSONArray.put(1, "" + System.currentTimeMillis());
                    }
                    this.l.put(this.m, jSONArray);
                }
            } catch (Throwable unused) {
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put("" + System.currentTimeMillis());
        jSONArray2.put("");
        this.l.put(str, jSONArray2);
        this.m = str;
        this.n = 0;
    }

    @Override // com.smartdigimkt.j2.b
    public final boolean supportDeeplinkJump() {
        return this.q;
    }

    public static void a(int i, WebLandPageActivity webLandPageActivity, String str) {
        webLandPageActivity.getClass();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(webLandPageActivity, com.smartdigimkt.r4.k.a(webLandPageActivity, "system_dialog", "style"));
        builder.setMessage(webLandPageActivity.getString(com.smartdigimkt.r4.k.a(webLandPageActivity, "web_download_file_confirm_title", "string"))).setCancelable(true).setPositiveButton(webLandPageActivity.getString(com.smartdigimkt.r4.k.a(webLandPageActivity, "web_download_file_confirm", "string")), new l(i, webLandPageActivity, str)).setNegativeButton(webLandPageActivity.getString(com.smartdigimkt.r4.k.a(webLandPageActivity, "web_download_file_cancel", "string")), new com.smartdigimkt.j2.k(webLandPageActivity, str));
        builder.create().show();
    }

    public final void a() {
        try {
            ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        } catch (Throwable unused) {
        }
        super.finish();
    }

    public final ImageView a(Drawable drawable) {
        ImageView imageView = new ImageView(this);
        char[] cArr = com.smartdigimkt.r4.k.a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) ((getResources().getDisplayMetrics().density * 48.0f) + 0.5f), (int) ((getResources().getDisplayMetrics().density * 48.0f) + 0.5f));
        layoutParams.gravity = 16;
        layoutParams.rightMargin = (int) ((getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
        imageView.setLayoutParams(layoutParams);
        int i = (int) ((getResources().getDisplayMetrics().density * 16.0f) + 0.5f);
        imageView.setPadding(i, i, i, i);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageDrawable(drawable);
        return imageView;
    }
}
