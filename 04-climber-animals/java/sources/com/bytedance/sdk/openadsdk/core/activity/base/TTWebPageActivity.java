package com.bytedance.sdk.openadsdk.core.activity.base;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.ao.d;
import com.bytedance.sdk.openadsdk.core.az;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.hi.ah.ub;
import com.bytedance.sdk.openadsdk.core.hi.ah.x;
import com.bytedance.sdk.openadsdk.core.hi.ka;
import com.bytedance.sdk.openadsdk.core.hi.xr.ah;
import com.bytedance.sdk.openadsdk.core.jw.c;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.op;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.e;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.nw;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.playable.xr.xr;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTWebPageActivity extends BaseLandingPageActivity implements le.ms, d {
    private static final String x = "TTWebPageActivity";
    com.bytedance.sdk.openadsdk.core.zb.d ab;
    private TextView ao;
    private com.bytedance.sdk.openadsdk.core.widget.ms.d az;
    private TTViewStub b;
    com.bytedance.sdk.openadsdk.core.dislike.ui.ms c;
    private ImageView ch;
    private boolean cv;
    private int e;
    private ah f;
    private xr fm;
    private String g;
    private TextView h;
    private ImageView hi;
    private TTViewStub i;
    private com.bytedance.sdk.openadsdk.sl.d jw;
    private int k;
    private pc le;
    private boolean lm;
    private boolean m;
    private TTViewStub nw;
    private SSWebView ny;
    private LinearLayout op;
    private Activity pc;
    private LinearLayout qv;
    private TTViewStub re;
    private TextView sl;
    private Context t;
    private TextView u;
    private TextView ub;
    private Button w;
    private boolean xn;
    private ImageView y;
    private TTProgressBar yu;
    private TextView zb;
    private AtomicBoolean of = new AtomicBoolean(true);
    private JSONArray p = null;
    private final Map<String, ah> ul = Collections.synchronizedMap(new HashMap());
    private final le eg = new le(Looper.getMainLooper(), this);
    private String il = "立即下载";
    private com.bytedance.sdk.openadsdk.core.hi.xr.ms qf = new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.12
        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms() {
            TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
            tTWebPageActivity.ms(tTWebPageActivity.ab());
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTWebPageActivity.this.f1893ms, 1, 0);
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.ms("下载中...");
            String unused = TTWebPageActivity.x;
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTWebPageActivity.this.f1893ms, 3, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void xr(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.ms("暂停");
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTWebPageActivity.this.f1893ms, 2, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ah(long j, long j2, String str, String str2) {
            TTWebPageActivity.this.ms("下载失败");
            if (j > 0) {
                com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTWebPageActivity.this.f1893ms, 4, (int) ((j2 * 100) / j));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(long j, String str, String str2) {
            TTWebPageActivity.this.ms("点击安装");
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTWebPageActivity.this.f1893ms, 5, 100);
        }

        @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
        public void ms(String str, String str2) {
            TTWebPageActivity.this.ms("点击打开");
            com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(TTWebPageActivity.this.f1893ms, 6, 100);
        }
    };

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.ka == null) {
            return;
        }
        this.pc = this;
        this.t = this;
        try {
            re.ms(this);
        } catch (Throwable unused) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        setContentView(x());
        Intent intent = getIntent();
        com.bytedance.sdk.openadsdk.core.playable.xr.ms().ms(this.ka);
        sl();
        ny();
        if (this.ny != null) {
            com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.t).ms(false).xr(false).ms(this.ny);
        }
        this.cv = intent.getBooleanExtra("is_outer_click", false);
        String stringExtra = intent.getStringExtra("url");
        this.g = stringExtra;
        this.g = f.xr(this.ka, this.g);
        String stringExtra2 = intent.getStringExtra("title");
        if (this.ka != null && this.ka.ca() != null) {
            this.ka.ca().ms("landing_page");
        }
        this.xn = intent.getBooleanExtra("has_phone_num_status", false);
        ah(this.ka);
        SSWebView sSWebView = this.ny;
        if (sSWebView != null) {
            sSWebView.addJavascriptInterface(new com.bytedance.sdk.openadsdk.core.p.xr.ms(this.ny, getApplicationContext(), (this.ka != null && this.ka.ah()) || this.xn), "CCWifiJSBridge");
            this.ab = new com.bytedance.sdk.openadsdk.core.zb.d(this.ka, this.ny).xr(true).xr(jCurrentTimeMillis).d(this.ny.getCreateDuration());
            d();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.f1893ms);
            jSONObject.put("url", stringExtra);
            jSONObject.put("web_title", stringExtra2);
            jSONObject.put("is_multi_process", com.bytedance.sdk.openadsdk.core.multipro.xr.ah());
            jSONObject.put("event_tag", this.ah);
        } catch (JSONException unused2) {
        }
        this.ab.ms(jSONObject);
        ch();
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar = new com.bytedance.sdk.openadsdk.core.widget.ms.d(this.t, this.le, this.f1893ms, this.ab, this.jw) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTWebPageActivity.this.yu == null || TTWebPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTWebPageActivity.this.yu.setVisibility(8);
                } catch (Throwable unused3) {
                }
            }
        };
        this.az = dVar;
        this.ny.setWebViewClient(dVar);
        SSWebView sSWebView2 = this.ny;
        if (sSWebView2 != null) {
            t.ms(sSWebView2, g.xr, lm.d(this.ka));
        }
        this.ny.setMixedContentMode(0);
        this.ny.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.le, this.ab) { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.7
            @Override // com.bytedance.sdk.openadsdk.core.widget.ms.ah, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTWebPageActivity.this.yu == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                if (i != 100 || !TTWebPageActivity.this.yu.isShown()) {
                    TTWebPageActivity.this.yu.setProgress(i);
                } else {
                    TTWebPageActivity.this.yu.setVisibility(8);
                }
            }
        });
        this.ny.setDownloadListener(new ms(this.ul, this.ka, this.t, this.ah));
        TextView textView = this.sl;
        if (textView != null && !this.m && !this.lm) {
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = com.bytedance.sdk.component.utils.t.ms(this.pc, "tt_web_title_default");
            }
            textView.setText(stringExtra2);
        }
        TextView textView2 = this.ao;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.ms(tTWebPageActivity.ka);
                }
            });
        }
        TextView textView3 = this.h;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity tTWebPageActivity = TTWebPageActivity.this;
                    tTWebPageActivity.xr(tTWebPageActivity.ka);
                }
            });
        }
        c();
        ms(4);
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.ka, getClass().getName());
        this.ny.setVisibility(0);
        this.ab.ah(System.currentTimeMillis());
        this.ny.loadUrl(this.g);
        com.bytedance.sdk.openadsdk.core.zb.ah.xr(this.ka);
        if (this.m || this.lm) {
            zb();
        }
        this.fm = new xr(this.ab.ms());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        xr xrVar = this.fm;
        if (xrVar != null) {
            xrVar.ms(this.pc, this.ka);
        }
    }

    private void d() {
        lm lmVar = this.ka;
        if (lmVar == null) {
            return;
        }
        this.jw = com.bytedance.sdk.openadsdk.sl.d.ms(this.t, lmVar, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        String strZx = lmVar.zx();
        ub();
        c.ms(this.t, lmVar.df(), strZx, new c.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.10
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                TTWebPageActivity.this.ao();
                TTWebPageActivity.this.ka();
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                TTWebPageActivity.this.ao();
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                TTWebPageActivity.this.ao();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(lm lmVar) {
        if (lmVar == null) {
            return;
        }
        String strZx = lmVar.zx();
        ub();
        c.ms(this.t, lmVar.df(), new c.ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.11
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                TTWebPageActivity.this.ao();
                TTWebPageActivity.this.ka();
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                TTWebPageActivity.this.ao();
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                TTWebPageActivity.this.ao();
            }
        }, strZx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ka() {
        int iQv = nw.qv(this.ka);
        if (this.ka != null) {
            if (this.ka.jr() == 4 || iQv != 0) {
                if (this.f == null) {
                    ah ahVarMs = ka.ms((Context) this.pc, this.ka, TextUtils.isEmpty(this.ah) ? f.ms(this.d) : this.ah, false);
                    this.f = ahVarMs;
                    ahVarMs.ms(ub.ms(this.ka));
                    this.f.ms(this.qf, false);
                }
                this.f.ms(this.pc);
                ah ahVar = this.f;
                if (ahVar instanceof x) {
                    ((x) ahVar).ah(true);
                    ((x) this.f).hi().ms(false);
                }
                com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.pc, this.ka, "embeded_ad_landingpage", this.d);
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
                this.f.ms(this.ka, false);
                ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.f);
            }
        }
    }

    private void c() {
        if (this.ka == null || this.ka.jr() != 4) {
            return;
        }
        TTViewStub tTViewStub = this.i;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387735);
        this.w = button;
        if (button != null) {
            ms(ab());
            if (this.f == null) {
                ah ahVarMs = ka.ms((Context) this.pc, this.ka, TextUtils.isEmpty(this.ah) ? f.ms(this.d) : this.ah, false);
                this.f = ahVarMs;
                ahVarMs.ms(ub.ms(this.ka));
                this.f.ms(this.qf, false);
            }
            this.f.ms(this.pc);
            ah ahVar = this.f;
            if (ahVar instanceof x) {
                ((x) ahVar).ah(true);
            }
            com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.pc, this.ka, "embeded_ad_landingpage", this.d);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ah(true);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(true);
            this.w.setOnClickListener(msVar);
            this.w.setOnTouchListener(msVar);
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ab() {
        if (this.ka != null && !TextUtils.isEmpty(this.ka.bn())) {
            this.il = this.ka.bn();
        }
        return this.il;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.w) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.13
            @Override // java.lang.Runnable
            public void run() {
                if (TTWebPageActivity.this.w == null || TTWebPageActivity.this.isFinishing()) {
                    return;
                }
                TTWebPageActivity.this.w.setText(str);
            }
        });
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    private View x() {
        Activity activity = this.pc;
        if (activity == null) {
            return null;
        }
        Resources resources = activity.getResources();
        this.op = new LinearLayout(this.pc);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.op.setOrientation(1);
        this.op.setLayoutParams(layoutParams);
        TTViewStub tTViewStub = new TTViewStub(this.t, new com.bytedance.sdk.openadsdk.res.layout.ms.xr());
        this.nw = tTViewStub;
        tTViewStub.setId(2114387776);
        this.op.addView(this.nw, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub2 = new TTViewStub(this.t, new com.bytedance.sdk.openadsdk.res.layout.ms.ah());
        this.b = tTViewStub2;
        tTViewStub2.setId(2114387798);
        this.op.addView(this.b, new LinearLayout.LayoutParams(-1, -2));
        TTViewStub tTViewStub3 = new TTViewStub(this.t, new com.bytedance.sdk.openadsdk.res.layout.ms.d());
        this.re = tTViewStub3;
        tTViewStub3.setId(2114387939);
        this.op.addView(this.re, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.pc);
        this.op.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        SSWebView sSWebView = new SSWebView(this.pc);
        this.ny = sSWebView;
        sSWebView.setMaterialMeta(com.bytedance.sdk.openadsdk.core.jw.pc.ms(this.ka));
        this.ny.setId(2114387739);
        this.ny.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(this.ny);
        TTViewStub tTViewStub4 = new TTViewStub(this.t, new com.bytedance.sdk.openadsdk.res.layout.ms.ms());
        this.i = tTViewStub4;
        tTViewStub4.setId(2114387956);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 48.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 81;
        frameLayout.addView(this.i, layoutParams2);
        TTProgressBar tTProgressBar = new TTProgressBar(this.pc, null, R.style.Widget.ProgressBar.Horizontal);
        this.yu = tTProgressBar;
        tTProgressBar.setId(2114387928);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 3.0f, resources.getDisplayMetrics()));
        layoutParams3.gravity = 49;
        this.yu.setLayoutParams(layoutParams3);
        this.yu.setProgress(1);
        this.yu.setProgressDrawable(com.bytedance.sdk.component.utils.t.ah(this.pc, "tt_browser_progress_style"));
        frameLayout.addView(this.yu);
        return this.op;
    }

    private void ny() {
        TTViewStub tTViewStub;
        if (this.m || this.lm) {
            TTViewStub tTViewStub2 = this.re;
            if (tTViewStub2 != null) {
                tTViewStub2.setVisibility(0);
            }
            this.y = (ImageView) findViewById(2114387849);
        } else if (this.ka != null && this.ka.hi()) {
            TTViewStub tTViewStub3 = this.nw;
            if (tTViewStub3 != null) {
                tTViewStub3.setVisibility(8);
            }
            TTViewStub tTViewStub4 = this.b;
            if (tTViewStub4 != null) {
                tTViewStub4.setVisibility(8);
            }
        } else {
            int iOp = ch.ub().op();
            if (iOp == 0) {
                TTViewStub tTViewStub5 = this.nw;
                if (tTViewStub5 != null) {
                    tTViewStub5.setVisibility(0);
                }
            } else if (iOp == 1 && (tTViewStub = this.b) != null) {
                tTViewStub.setVisibility(0);
            }
        }
        ImageView imageView = (ImageView) findViewById(2114387711);
        this.ch = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ul.ms(TTWebPageActivity.this.ny)) {
                        return;
                    }
                    if (TTWebPageActivity.this.fm != null) {
                        TTWebPageActivity.this.fm.ms(0);
                    }
                    TTWebPageActivity.this.onBackPressed();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387710);
        this.hi = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.finish();
                }
            });
        }
        this.sl = (TextView) findViewById(2114387952);
        this.zb = (TextView) findViewById(2114387633);
        this.u = (TextView) findViewById(2114387616);
        this.ub = (TextView) findViewById(2114387707);
        this.ao = (TextView) findViewById(2114387604);
        this.h = (TextView) findViewById(2114387706);
        this.qv = (LinearLayout) findViewById(2114387682);
        TextView textView = this.zb;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTWebPageActivity.this.ms();
                }
            });
        }
    }

    private void ch() {
        if (this.ny == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ka);
        pc pcVar = new pc(this.pc);
        this.le = pcVar;
        pcVar.d(this.cv);
        this.le.xr(this.ny).ms(this.ka).ah(arrayList).xr(this.f1893ms).ah(this.xr).ah(this.d).ms(this.ah).d(f.ao(this.ka)).ms(this.ny).ms(true).xr(ub.ms(this.ka)).ms(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        pc pcVar = this.le;
        if (pcVar != null) {
            pcVar.yu();
            this.le.ms(new SSWebView.xr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.4
                @Override // com.bytedance.sdk.component.widget.SSWebView.xr
                public void ms(int i) {
                    TTWebPageActivity.this.le.ms(i);
                }
            });
        }
        ah ahVar = this.f;
        if (ahVar != null) {
            ahVar.x();
        }
        Map<String, ah> map = this.ul;
        if (map != null) {
            for (Map.Entry<String, ah> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().x();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ab;
        if (dVar != null) {
            dVar.d();
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar2 = this.az;
        if (dVar2 != null) {
            dVar2.xr(true);
        }
        hi();
        ao();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ab;
        if (dVar != null) {
            dVar.ka();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        pc pcVar = this.le;
        if (pcVar != null) {
            pcVar.op();
        }
        Map<String, ah> map = this.ul;
        if (map != null) {
            for (Map.Entry<String, ah> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue();
                }
            }
        }
        com.bytedance.sdk.openadsdk.core.widget.ms.d dVar = this.az;
        if (dVar != null) {
            dVar.ah();
        }
        ub();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        xr xrVar = this.fm;
        if (xrVar != null) {
            xrVar.ms(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            if ((lm.ah(this.ka) || com.bytedance.sdk.openadsdk.core.nw.pc.ms(this.ka)) && ul.ms(this.ny)) {
                return;
            }
            xr xrVar = this.fm;
            if (xrVar == null || !xrVar.xr(this.pc, this.ka)) {
                super.onBackPressed();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i) {
        if (lm.ah(this.ka)) {
            ul.ms((View) this.hi, 4);
        } else if (lm.ah(this.ka)) {
            ul.ms((View) this.hi, i);
        }
    }

    private void hi() {
        if (this.ka == null) {
            return;
        }
        JSONArray jSONArrayXr = xr(this.g);
        int iNy = f.ny(this.ka);
        int iX = f.x(this.ka);
        yu<com.bytedance.sdk.openadsdk.core.zb.ms> yuVarMs = re.ms();
        if (jSONArrayXr == null || yuVarMs == null || iNy <= 0 || iX <= 0) {
            return;
        }
        e eVar = new e();
        eVar.ka = jSONArrayXr;
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = this.ka.rt();
        if (xrVarRt == null) {
            return;
        }
        yuVarMs.ms(op.xr(xrVarRt).ah(6).ms(), eVar, iX, new yu.xr() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(int i, String str, com.bytedance.sdk.openadsdk.core.nw.xr xrVar) {
                TTWebPageActivity.this.ms(0);
                xrVar.ms(i);
                com.bytedance.sdk.openadsdk.core.nw.xr.ms(xrVar);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.xr
            public void ms(com.bytedance.sdk.openadsdk.core.nw.ms msVar, com.bytedance.sdk.openadsdk.core.nw.xr xrVar) {
                if (msVar != null) {
                    try {
                        TTWebPageActivity.this.of.set(false);
                        TTWebPageActivity.this.le.ms(msVar.ah());
                    } catch (Exception unused) {
                        TTWebPageActivity.this.ms(0);
                    }
                }
            }
        });
    }

    private JSONArray xr(String str) {
        int i;
        JSONArray jSONArray = this.p;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.p;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?id=");
        int iIndexOf2 = str.indexOf("&");
        if (iIndexOf == -1 || iIndexOf2 == -1 || (i = iIndexOf + 4) >= iIndexOf2) {
            return null;
        }
        String strSubstring = str.substring(i, iIndexOf2);
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(strSubstring);
        return jSONArray2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.ab;
        if (dVar != null) {
            dVar.ab();
        }
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.ny;
        if (sSWebView != null) {
            az.ms(this.t, sSWebView);
            az.ms(this.ny);
        }
        this.ny = null;
        com.bytedance.sdk.openadsdk.sl.d dVar2 = this.jw;
        if (dVar2 != null) {
            dVar2.d();
        }
        pc pcVar = this.le;
        if (pcVar != null) {
            pcVar.le();
        }
        ah ahVar = this.f;
        if (ahVar != null) {
            ahVar.ny();
        }
        Map<String, ah> map = this.ul;
        if (map != null) {
            for (Map.Entry<String, ah> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().ny();
                }
            }
            this.ul.clear();
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar3 = this.ab;
        if (dVar3 != null) {
            dVar3.c();
        }
        com.bytedance.sdk.openadsdk.core.playable.xr.ms().xr(this.ka);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ao.d
    public void ms(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.p = jSONArray;
        hi();
    }

    protected void ms() {
        if (this.ka == null || isFinishing()) {
            return;
        }
        if (this.c == null) {
            xr();
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = this.c;
        if (msVar != null) {
            msVar.ms();
        }
    }

    void xr() {
        try {
            com.bytedance.sdk.openadsdk.core.dislike.ui.ms msVar = new com.bytedance.sdk.openadsdk.core.dislike.ui.ms(this.pc, this.ka.ca(), this.ah, true);
            this.c = msVar;
            com.bytedance.sdk.openadsdk.core.dislike.ah.ms(this.pc, msVar, this.ka);
            this.c.ms(new com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                public void ms() {
                    TTWebPageActivity.this.ub();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                public void ms(int i, String str, boolean z) {
                    TTWebPageActivity.this.ao();
                }

                @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.ms.InterfaceC0288ms
                public void xr() {
                    TTWebPageActivity.this.ao();
                }
            });
        } catch (Exception e) {
            sl.xr(e.getMessage());
        }
    }

    private void ah(lm lmVar) {
        LinearLayout linearLayout = this.qv;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
            return;
        }
        if (this.ka == null) {
            LinearLayout linearLayout2 = this.qv;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
                return;
            }
            return;
        }
        String strZx = lmVar.zx();
        if (TextUtils.isEmpty(strZx)) {
            LinearLayout linearLayout3 = this.qv;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
                return;
            }
            return;
        }
        try {
            if (TextUtils.isEmpty(strZx)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.nw.c cVarKa = com.bytedance.sdk.openadsdk.core.ms.ka(new JSONObject(strZx));
            if (cVarKa == null) {
                LinearLayout linearLayout4 = this.qv;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(cVarKa.zb())) {
                LinearLayout linearLayout5 = this.qv;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                    return;
                }
                return;
            }
            LinearLayout linearLayout6 = this.qv;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            String strKa = cVarKa.ka();
            String strAb = cVarKa.ab();
            String strU = cVarKa.u();
            if (TextUtils.isEmpty(strU)) {
                strU = ub.xr(lmVar);
            }
            if (this.u != null) {
                this.u.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.t, "tt_open_app_detail_developer"), strAb));
            }
            if (this.ub != null) {
                this.ub.setText(String.format(com.bytedance.sdk.component.utils.t.ms(this.t, "tt_open_landing_page_app_name"), strU, strKa));
            }
        } catch (Throwable unused) {
        }
    }

    private void sl() {
        this.lm = qf.y(this.ka);
        this.m = qf.qv(this.ka) && !com.bytedance.sdk.openadsdk.core.x.d.ah;
        if (this.lm) {
            if (com.bytedance.sdk.openadsdk.core.x.d.d) {
                if (this.m) {
                    this.lm = false;
                    return;
                }
                return;
            }
            this.m = false;
        }
    }

    private void zb() {
        this.e = 0;
        if (this.m) {
            this.e = com.bytedance.sdk.openadsdk.core.x.d.f3760ms;
        } else if (this.lm && !com.bytedance.sdk.openadsdk.core.x.d.d) {
            this.e = qf.u(this.ka);
        }
        xr(this.e);
        if (this.e > 0 && !this.eg.hasMessages(10)) {
            if (this.m) {
                this.eg.sendEmptyMessageDelayed(10, 1000L);
            } else if (this.lm) {
                this.eg.sendEmptyMessageDelayed(10, 1000L);
            }
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what == 10 && u()) {
            int i = this.k + 1;
            this.k = i;
            if (this.m) {
                com.bytedance.sdk.openadsdk.core.x.d.xr = i;
            }
            int iMax = Math.max(0, this.e - this.k);
            xr(iMax);
            if (iMax <= 0 && this.lm) {
                com.bytedance.sdk.openadsdk.core.x.d.d = true;
            }
            this.eg.sendEmptyMessageDelayed(10, 1000L);
        }
    }

    private boolean u() {
        return this.m || this.lm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub() {
        if (u()) {
            this.eg.removeMessages(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao() {
        if (!u() || this.eg.hasMessages(10)) {
            return;
        }
        this.eg.sendEmptyMessageDelayed(10, 1000L);
    }

    private void xr(int i) {
        if (i > 0) {
            if (this.m) {
                ul.ms(this.sl, i + "s后可领取奖励");
                return;
            } else {
                if (this.lm) {
                    SpannableString spannableString = new SpannableString("浏览 " + i + "秒 获得更多福利");
                    spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), spannableString.length() - 4, spannableString.length(), 17);
                    ul.ms(this.sl, spannableString);
                    return;
                }
                return;
            }
        }
        if (this.m) {
            ul.ms(this.sl, "领取成功");
        } else if (this.lm) {
            ul.ms((View) this.y, 8);
            ul.ms(this.sl, "恭喜你！福利已领取");
        }
    }

    public static class ms implements DownloadListener {
        private Context ah;
        private String d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private Map<String, ah> f1955ms;
        private lm xr;

        ms(Map<String, ah> map, lm lmVar, Context context, String str) {
            this.f1955ms = map;
            this.xr = lmVar;
            this.ah = context;
            this.d = str;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Map<String, ah> map = this.f1955ms;
            if (map != null && map.containsKey(str)) {
                ah ahVar = this.f1955ms.get(str);
                if (ahVar != null) {
                    ahVar.xr(f.y(this.xr), false);
                    return;
                }
                return;
            }
            ah ahVarMs = ka.ms(this.ah, str, this.xr, this.d);
            ahVarMs.ms(ub.ms(this.xr));
            this.f1955ms.put(str, ahVarMs);
            ahVarMs.xr(f.y(this.xr), false);
        }
    }
}
