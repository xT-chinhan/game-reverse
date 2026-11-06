package com.byazt.rg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.bs.TTViewStub;
import com.byazt.ca.ho;
import com.byazt.dp.c;
import com.byazt.fj.SSWebView;
import com.byazt.fj.TTProgressBar;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.hg.s;
import com.byazt.hg.yb;
import com.byazt.jx.zo;
import com.byazt.lz.x;
import com.byazt.on.hw;
import com.byazt.pj.hn;
import com.byazt.ro.UgenBanner;
import com.byazt.sd.a;
import com.byazt.sd.e;
import com.byazt.sd.fo;
import com.byazt.sd.iu;
import com.byazt.sd.nl;
import com.byazt.sdv.uc;
import com.byazt.wt.cz;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 204, 2232})
public abstract class BaseLandingPageActivity extends BaseThemeActivity implements c {
    public TTViewStub aj;
    public nl b;
    public Activity c;
    public x cz;
    public boolean er;
    public com.byazt.mv.x fo;
    public TTViewStub fw;
    public ImageView g;
    public String hn;
    public ImageView ho;
    public String hw;
    public hn lb;
    public UgenBanner ls;
    public String m;
    public com.byazt.ri.pr nl;
    public TextView nt;
    public SSWebView ny;
    public String pr;
    public hw qa;
    public TTProgressBar rc;
    public TTViewStub uc;
    public Button ve;
    public String vk;
    public boolean w;
    public View ww;
    public int x;
    public TextView y;
    public TextView yb;
    public com.byazt.pfl.hw z;
    public TTViewStub zo;
    public boolean v = false;
    public int k = 0;
    public boolean a = false;
    public JSONArray iu = null;
    public String qi = "立即下载";
    public AtomicBoolean gz = new AtomicBoolean(true);
    public long qn = Long.MIN_VALUE;
    public final Map<String, com.byazt.nv.hn> n = Collections.synchronizedMap(new HashMap());
    public com.byazt.nv.pr e = new com.byazt.nv.pr() { // from class: com.byazt.rg.BaseLandingPageActivity.1
        @Override // com.byazt.nv.pr
        public void pr() {
            BaseLandingPageActivity baseLandingPageActivity = BaseLandingPageActivity.this;
            baseLandingPageActivity.hw(baseLandingPageActivity.pr());
            com.byazt.dp.pr.pr(BaseLandingPageActivity.this.pr);
        }

        @Override // com.byazt.nv.pr
        public void pr(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.hw("下载中...");
            com.byazt.dp.pr.pr(BaseLandingPageActivity.this.pr, j, j2);
        }

        @Override // com.byazt.nv.pr
        public void hw(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.hw("暂停");
            com.byazt.dp.pr.hw(BaseLandingPageActivity.this.pr, j, j2);
        }

        @Override // com.byazt.nv.pr
        public void hn(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.hw("下载失败");
            com.byazt.dp.pr.hn(BaseLandingPageActivity.this.pr, j, j2);
        }

        @Override // com.byazt.nv.pr
        public void pr(long j, String str, String str2) {
            BaseLandingPageActivity.this.hw("点击安装");
            com.byazt.dp.pr.hw(BaseLandingPageActivity.this.pr);
        }

        @Override // com.byazt.nv.pr
        public void pr(String str, String str2) {
            BaseLandingPageActivity.this.hw("点击打开");
            com.byazt.dp.pr.hn(BaseLandingPageActivity.this.pr);
        }
    };

    public abstract View fw();

    public String pr() {
        if (this.s != null && !TextUtils.isEmpty(this.s.se())) {
            this.qi = this.s.se();
        }
        return this.qi;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hw();
    }

    public void hw() {
        if (this.s != null && this.s.aj() == 4) {
            TTViewStub tTViewStub = this.aj;
            if (tTViewStub != null) {
                tTViewStub.setVisibility(0);
            }
            Button button = (Button) findViewById(2114387729);
            this.ve = button;
            if (button != null) {
                hw(pr());
                if (this.nl == null) {
                    this.nl = zo.pr(this.c, this.s, TextUtils.isEmpty(this.hn) ? ls.pr(this.x) : this.hn);
                }
                this.nl.pr(this.c, false);
                this.nl.pr(com.byazt.ri.c.pr(this.s));
                this.nl.c(true);
                this.nl.x(this.v);
                this.nl.pr(this.e, false);
                com.byazt.az.pr prVar = new com.byazt.az.pr(this.c, this.s, "embeded_ad_landingpage", this.x);
                ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).hn(true);
                ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(true);
                ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr((com.byazt.nv.hn) this.nl);
                this.ve.setOnClickListener(prVar);
                this.ve.setOnTouchListener(prVar);
                TextView textView = this.y;
                if (textView != null) {
                    textView.setOnClickListener(prVar);
                    this.y.setOnTouchListener(prVar);
                }
            }
        }
    }

    public void pr(final com.byazt.pfl.hw.pr prVar, boolean z) {
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.g = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.rg.BaseLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.hn();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.ho = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.rg.BaseLandingPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.x();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387952);
        this.nt = textView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(this.m) ? "广告" : this.m);
        }
        TextView textView2 = (TextView) findViewById(2114387627);
        this.yb = textView2;
        if (textView2 != null) {
            if (this.s != null && this.s.ae() != null) {
                this.s.ae().pr("landing_page");
            }
            this.yb.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.rg.BaseLandingPageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.pr(prVar);
                }
            });
        }
        pr(4);
    }

    public void hn() {
        if (er.pr(this.ny)) {
            return;
        }
        hw hwVar = this.qa;
        if (hwVar != null) {
            hwVar.pr(0);
        }
        onBackPressed();
    }

    public void x() {
        pr("detail_skip");
        finish();
    }

    public void pr(com.byazt.pfl.hw.pr prVar) {
        if (this.s == null || isFinishing()) {
            return;
        }
        if (this.z == null) {
            hw(prVar);
        }
        com.byazt.pfl.hw hwVar = this.z;
        if (hwVar != null) {
            hwVar.pr();
        }
    }

    public void hw(com.byazt.pfl.hw.pr prVar) {
        try {
            this.z = new com.byazt.pfl.hw(this.c, this.s.ae(), this.hn, true, com.byazt.ub.hw.pr());
            com.byazt.pw.hn.pr(this.c, this.s, this.z);
            this.z.pr(prVar);
        } catch (Exception e) {
            ho.pr(e.getMessage());
        }
    }

    public void pr(String str) {
    }

    @Override // com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        vk();
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.hn = intent.getStringExtra("event_tag");
        this.pr = intent.getStringExtra(MediationConstant.EXTRA_ADID);
        this.x = intent.getIntExtra("landing_page_source", -1);
        this.w = intent.getBooleanExtra("is_outer_click", false);
        this.vk = intent.getStringExtra(BreakpointSQLiteKey.URL);
        this.v = intent.getBooleanExtra("web_dl_factors", false) && !TextUtils.isEmpty(this.vk) && this.vk.contains("chengzijianzhan");
        this.vk = ls.x(this.s, this.vk);
        this.m = intent.getStringExtra(BundleKey.TITLE);
        this.k = intent.getIntExtra("get_phone_num_status", 0);
        this.a = intent.getBooleanExtra("video_is_auto_play", true);
        if (this.s == null) {
            finish();
            return;
        }
        this.hw = this.s.B_();
        this.c = this;
        pr(bundle);
        try {
            a.pr(this.c);
        } catch (Throwable th) {
        }
        View viewFw = fw();
        this.ww = viewFw;
        setContentView(viewFw);
        c();
        uc();
        if (!w() && Build.BRAND.equalsIgnoreCase(MediationConstant.ADN_XIAOMI) && Build.VERSION.SDK_INT >= 36) {
            this.ww.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.rg.BaseLandingPageActivity.6
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    View view = BaseLandingPageActivity.this.ww;
                    if (view != null) {
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        float fW = er.w((Context) null);
                        if (iArr[1] <= 0) {
                            view.setPadding(0, (int) fW, 0, 0);
                        }
                    }
                }
            });
        }
    }

    public void pr(Bundle bundle) {
    }

    public void c() {
    }

    public void pr(boolean z) {
        com.byazt.lz.hw.pr(this.c).pr(z).hw(false).pr(this.ny);
        SSWebView sSWebView = this.ny;
        sSWebView.addJavascriptInterface(new com.byazt.fw.pr(sSWebView, getApplicationContext(), this.s != null ? this.s.fw() : this.k, this.s), "CCWifiJSBridge");
        this.lb = new hn(this.s, this.ny).hw(true).hw(System.currentTimeMillis()).x(this.ny.getCreateDuration());
        k();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.pr);
            jSONObject.put(BreakpointSQLiteKey.URL, this.vk);
            jSONObject.put("web_title", this.m);
            jSONObject.put("is_multi_process", com.byazt.iy.hw.pr());
            jSONObject.put("event_tag", this.hn);
        } catch (JSONException e) {
        }
        this.lb.pr(jSONObject);
        m();
        x xVar = new x(this.c, this.b, this.pr, this.lb, this.fo) { // from class: com.byazt.rg.BaseLandingPageActivity.7
            public final long aj = System.currentTimeMillis();

            @Override // com.byazt.lz.x, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (BaseLandingPageActivity.this.rc != null && !BaseLandingPageActivity.this.isFinishing()) {
                        BaseLandingPageActivity.this.rc.setVisibility(8);
                    }
                    if (webView != null) {
                        webView.evaluateJavascript(BaseLandingPageActivity.pr(this.aj), null);
                    }
                } catch (Throwable th) {
                }
            }
        };
        this.cz = xVar;
        this.ny.setWebViewClient(xVar);
        cz.pr(this.ny, iu.x, of.c(this.s));
        this.ny.setMixedContentMode(0);
        this.ny.setWebChromeClient(new com.byazt.lz.hn(this.b, this.lb) { // from class: com.byazt.rg.BaseLandingPageActivity.8
            @Override // com.byazt.lz.hn, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (BaseLandingPageActivity.this.rc != null && !BaseLandingPageActivity.this.isFinishing()) {
                    if (i == 100 && BaseLandingPageActivity.this.rc.isShown()) {
                        BaseLandingPageActivity.this.rc.setVisibility(8);
                    } else {
                        BaseLandingPageActivity.this.rc.setProgress(i);
                    }
                }
            }
        });
        this.ny.setDownloadListener(new pr(this.n, this.s, this.c, this.hn, this.v));
        this.ny.setVisibility(0);
        this.lb.hn(System.currentTimeMillis());
        this.ny.loadUrl(this.vk);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hw hwVar = this.qa;
        if (hwVar != null) {
            hwVar.pr(this.c, this.s);
        }
    }

    private void k() {
        of ofVar = this.s;
        if (ofVar == null) {
            return;
        }
        this.fo = com.byazt.mv.x.pr(this.c, ofVar, this.vk);
    }

    private void m() {
        if (this.ny == null) {
            return;
        }
        g();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.s);
        nl nlVar = new nl(this.c);
        this.b = nlVar;
        nlVar.x(this.w);
        this.b.hw(this.ny).pr(this.s).hn(arrayList).hw(this.pr).x(this.hw).hn(this.x).pr(this.hn).c(ls.a(this.s)).pr(this.ny).pr(true).hw(com.byazt.ri.c.pr(this.s)).pr(this);
    }

    private void g() {
        if (this.s == null || this.ny == null) {
            return;
        }
        String strCz = this.s.cz();
        if (TextUtils.isEmpty(strCz)) {
            return;
        }
        com.byazt.son.pr.pr(strCz, this.ny.getInnerIWebView());
    }

    public void uc() {
        com.byazt.pj.pr.pr(this.s, getClass().getName());
        com.byazt.pj.pr.pr(this.s);
        this.qa = new hw(this.lb.pr());
    }

    public void pr(int i) {
        if (of.x(this.s)) {
            er.pr((View) this.ho, 4);
        } else {
            if (!of.x(this.s)) {
                return;
            }
            er.pr((View) this.ho, i);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        hw hwVar = this.qa;
        if (hwVar != null) {
            hwVar.pr(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.byazt.rd.hn.pr().pr(this, this.s, ls.b(this.s));
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        nl nlVar = this.b;
        if (nlVar != null) {
            nlVar.nl();
        }
        for (Map.Entry<String, com.byazt.nv.hn> entry : this.n.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
        x xVar = this.cz;
        if (xVar != null) {
            xVar.hn();
        }
    }

    public void hw(final String str) {
        Button button;
        if (!TextUtils.isEmpty(str) && (button = this.ve) != null) {
            button.post(new Runnable() { // from class: com.byazt.rg.BaseLandingPageActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseLandingPageActivity.this.ve != null && !BaseLandingPageActivity.this.isFinishing()) {
                        BaseLandingPageActivity.this.ve.setText(str);
                    }
                }
            });
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        String strZj;
        super.onResume();
        Window window = getWindow();
        if (this.qn == Long.MIN_VALUE) {
            this.qn = System.currentTimeMillis();
        }
        if (window != null) {
            com.byazt.mk.zo.pr(window.getDecorView());
        }
        nl nlVar = this.b;
        if (nlVar != null) {
            nlVar.gz();
            this.b.pr(new SSWebView.hw() { // from class: com.byazt.rg.BaseLandingPageActivity.10
                @Override // com.byazt.fj.SSWebView.hw
                public void pr(int i) {
                    BaseLandingPageActivity.this.b.pr(i);
                }
            });
        }
        com.byazt.ri.pr prVar = this.nl;
        if (prVar != null) {
            prVar.hw();
        }
        for (Map.Entry<String, com.byazt.nv.hn> entry : this.n.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().hw();
            }
        }
        hn hnVar = this.lb;
        if (hnVar != null) {
            hnVar.x();
        }
        x xVar = this.cz;
        if (xVar != null) {
            xVar.hw(true);
        }
        aj();
        if (this.s != null && nt()) {
            if (this.ls == null) {
                this.ls = new UgenBanner(this);
            }
            addContentView(this.ls, new ViewGroup.LayoutParams(-1, -2));
            this.er = true;
            com.byazt.hg.c cVarHo = this.s.ho();
            if (cVarHo != null) {
                strZj = cVarHo.hn();
            } else {
                strZj = this.s.zj();
            }
            this.ls.setTopMargin(er.hn(this, 50.0f));
            this.ls.pr(ho(), this.s, new com.byazt.az.hw(this, this.s, this.hn, this.x), strZj, this.s.A_(), "立即打开", true);
        }
    }

    private com.byazt.qk.pr ho() {
        yb ybVarG = this.s.g();
        if (ybVarG == null) {
            return null;
        }
        String strUc = ybVarG.uc();
        if (TextUtils.isEmpty(strUc)) {
            return null;
        }
        com.byazt.qk.pr prVar = new com.byazt.qk.pr();
        prVar.hn(strUc);
        prVar.hw(ybVarG.fw());
        prVar.pr(strUc);
        return prVar;
    }

    private boolean nt() {
        yb ybVarG = this.s.g();
        if (ybVarG == null) {
            return false;
        }
        ybVarG.pr(true);
        int iHn = ybVarG.hn();
        if ((iHn != 1 && iHn != 2) || this.er) {
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        hn hnVar = this.lb;
        if (hnVar != null) {
            hnVar.c();
        }
        com.byazt.rd.hn.pr().hw((Context) this, this.s, false);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!zo()) {
            super.onBackPressed();
        }
    }

    public boolean zo() {
        try {
            if ((of.x(this.s) || s.pr(this.s)) && er.pr(this.ny)) {
                return true;
            }
            hw hwVar = this.qa;
            return hwVar != null && hwVar.hw(this.c, this.s);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.byazt.rg.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        com.byazt.rkl.hw hwVar;
        super.onDestroy();
        hn hnVar = this.lb;
        if (hnVar != null) {
            hnVar.fw();
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable th) {
        }
        SSWebView sSWebView = this.ny;
        if (sSWebView != null) {
            com.byazt.son.pr.pr(sSWebView);
            e.pr(this.c, this.ny);
            e.pr(this.ny);
        }
        this.ny = null;
        com.byazt.mv.x xVar = this.fo;
        if (xVar != null) {
            xVar.x();
        }
        nl nlVar = this.b;
        if (nlVar != null) {
            nlVar.y();
        }
        com.byazt.ri.pr prVar = this.nl;
        if (prVar != null) {
            prVar.hn();
        }
        for (Map.Entry<String, com.byazt.nv.hn> entry : this.n.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().hn();
            }
        }
        this.n.clear();
        hn hnVar2 = this.lb;
        if (hnVar2 != null) {
            hnVar2.uc();
        }
        UgenBanner ugenBanner = this.ls;
        if (ugenBanner != null) {
            ugenBanner.pr();
        }
        if (this.s == null) {
            return;
        }
        yb ybVarG = this.s.g();
        if (ybVarG != null) {
            ybVarG.pr(false);
        }
        if (this.s.ob() && this.s.tn() >= 0 && (hwVar = (com.byazt.rkl.hw) com.byazt.sd.cz.pr(this.s.cz(), com.byazt.rkl.hw.class)) != null) {
            boolean z = System.currentTimeMillis() - this.qn >= ((long) this.s.tn()) * 1000;
            if (z) {
                com.byazt.pj.pr.pr(this.s, 4);
            }
            hwVar.pr(z ? 5 : 6, null);
        }
    }

    @Override // com.byazt.dp.c
    public void pr(boolean z, JSONArray jSONArray) {
        if (z && jSONArray != null && jSONArray.length() > 0) {
            this.iu = jSONArray;
            aj();
        }
    }

    public void aj() {
        if (this.s == null) {
            return;
        }
        JSONArray jSONArrayHn = hn(this.vk);
        int iM = ls.m(this.s);
        int iK = ls.k(this.s);
        fo foVarPr = a.pr();
        if (jSONArrayHn == null || foVarPr == null || iM <= 0 || iK <= 0) {
            return;
        }
        i iVar = new i();
        iVar.uc = jSONArrayHn;
        com.byazt.qe.hw hwVarP = this.s.p();
        if (hwVarP == null) {
            return;
        }
        foVarPr.pr(ve.hw(hwVarP).hn(6).pr(), iVar, iK, new fo.hw() { // from class: com.byazt.rg.BaseLandingPageActivity.2
            @Override // com.byazt.sd.fo.hw
            public void pr(int i, String str, com.byazt.hg.hw hwVar) {
                BaseLandingPageActivity.this.pr(0);
                hwVar.pr(i);
                com.byazt.hg.hw.pr(hwVar);
            }

            @Override // com.byazt.sd.fo.hw
            public void pr(com.byazt.hg.pr prVar, com.byazt.hg.hw hwVar) {
                if (prVar != null) {
                    try {
                        BaseLandingPageActivity.this.gz.set(false);
                        BaseLandingPageActivity.this.b.pr(prVar.hn());
                    } catch (Exception e) {
                        BaseLandingPageActivity.this.pr(0);
                    }
                }
            }
        });
    }

    private JSONArray hn(String str) {
        int i;
        JSONArray jSONArray = this.iu;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.iu;
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

    public static String pr(long j) {
        return "const existingScript = document.getElementById('" + j + "');if (!existingScript) {var script = document.createElement('script');script.id = '" + j + "';script.src = '" + ("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/stylex-infra-mono/landing-sdk/index.js?t=" + System.currentTimeMillis()) + "';document.head?.appendChild(script);}";
    }

    public void vk() {
        uc.pr(this);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 204, 1954})
    public static class pr implements DownloadListener {
        public boolean c;
        public Context hn;
        public of hw;
        public Map<String, com.byazt.nv.hn> pr;
        public String x;

        public pr(Map<String, com.byazt.nv.hn> map, of ofVar, Context context, String str, boolean z) {
            this.pr = map;
            this.hw = ofVar;
            this.hn = context;
            this.x = str;
            this.c = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Map<String, com.byazt.nv.hn> map = this.pr;
            if (map != null && map.containsKey(str)) {
                com.byazt.nv.hn hnVar = this.pr.get(str);
                if (hnVar != null) {
                    hnVar.pr(ls.fo(this.hw), false);
                    return;
                }
                return;
            }
            com.byazt.nv.hn hnVarPr = zo.pr(this.hn, str, this.hw, this.x);
            hnVarPr.pr(com.byazt.ri.c.pr(this.hw));
            hnVarPr.x(this.c);
            this.pr.put(str, hnVarPr);
            hnVarPr.pr(ls.fo(this.hw), false);
        }
    }
}
