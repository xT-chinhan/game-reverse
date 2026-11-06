package com.byazt.pt;

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
import com.byazt.gct.f;
import com.byazt.gct.hd;
import com.byazt.gct.pk;
import com.byazt.gct.y;
import com.byazt.hm.s;
import com.byazt.iz.fs;
import com.byazt.kfh.SSWebView;
import com.byazt.kfh.TTProgressBar;
import com.byazt.lew.q;
import com.byazt.ll.l;
import com.byazt.lz.TTViewStub;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.byazt.pmn.AppDownloadListener;
import com.byazt.pmn.ITTInnerDownloadAdapter;
import com.byazt.tk.k;
import com.byazt.vgx.w;
import com.byazt.wg.qg;
import com.byazt.zc.UgenBanner;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, 2429})
public abstract class BaseLandingPageActivity extends BaseThemeActivity implements l {
    public s cd;
    public boolean cp;
    public TextView cy;
    public UgenBanner f;
    public boolean fi;
    public TTViewStub fs;
    public com.byazt.gcl.s h;
    public TextView hd;
    public qg hu;
    public ImageView k;
    public Activity l;
    public TextView lh;
    public com.byazt.oh.n ln;
    public TTProgressBar m;
    public String n;
    public String oa;
    public SSWebView ou;
    public com.byazt.dho.s py;
    public int q;
    public String qg;
    public TTViewStub rv;
    public String s;
    public ImageView sz;
    public String tj;
    public com.byazt.nsm.qg um;
    public Button ur;
    public View v;
    public TTViewStub w;
    public q wm;
    public TTViewStub x;
    public boolean df = false;
    public int d = 0;
    public boolean a = false;
    public JSONArray t = null;
    public String oj = "立即下载";
    public AtomicBoolean bb = new AtomicBoolean(true);
    public long dg = Long.MIN_VALUE;
    public final Map<String, ITTInnerDownloadAdapter> j = Collections.synchronizedMap(new HashMap());
    public AppDownloadListener an = new AppDownloadListener() { // from class: com.byazt.pt.BaseLandingPageActivity.1
        @Override // com.byazt.pmn.AppDownloadListener
        public void onIdle() {
            BaseLandingPageActivity baseLandingPageActivity = BaseLandingPageActivity.this;
            baseLandingPageActivity.qg(baseLandingPageActivity.n());
            com.byazt.ll.n.n(BaseLandingPageActivity.this.n);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.qg("下载中...");
            com.byazt.ll.n.n(BaseLandingPageActivity.this.n, j, j2);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.qg("暂停");
            com.byazt.ll.n.qg(BaseLandingPageActivity.this.n, j, j2);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) {
            BaseLandingPageActivity.this.qg("下载失败");
            com.byazt.ll.n.s(BaseLandingPageActivity.this.n, j, j2);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) {
            BaseLandingPageActivity.this.qg("点击安装");
            com.byazt.ll.n.qg(BaseLandingPageActivity.this.n);
        }

        @Override // com.byazt.pmn.AppDownloadListener
        public void onInstalled(String str, String str2) {
            BaseLandingPageActivity.this.qg("点击打开");
            com.byazt.ll.n.s(BaseLandingPageActivity.this.n);
        }
    };

    public void l() {
    }

    public void n(Bundle bundle) {
    }

    public void n(String str) {
    }

    public abstract View x();

    public String n() {
        if (this.ae != null && !TextUtils.isEmpty(this.ae.jb())) {
            this.oj = this.ae.jb();
        }
        return this.oj;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        qg();
    }

    public void qg() {
        if (this.ae == null || this.ae.rv() != 4) {
            return;
        }
        TTViewStub tTViewStub = this.rv;
        if (tTViewStub != null) {
            tTViewStub.setVisibility(0);
        }
        Button button = (Button) findViewById(2114387729);
        this.ur = button;
        if (button != null) {
            qg(n());
            if (this.ln == null) {
                this.ln = fs.n(this.l, this.ae, TextUtils.isEmpty(this.s) ? w.n(this.q) : this.s);
            }
            this.ln.setActivity(this.l, false);
            this.ln.setCheckCompliance(com.byazt.oh.l.n(this.ae));
            this.ln.n(true);
            this.ln.setShowDLFactorsCard(this.df);
            this.ln.addAppDownloadListener(this.an, false);
            com.byazt.ys.n nVar = new com.byazt.ys.n(this.l, this.ae, "embeded_ad_landingpage", this.q);
            ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).s(true);
            ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n(true);
            ((com.byazt.zct.n) nVar.n(com.byazt.zct.n.class)).n((ITTInnerDownloadAdapter) this.ln);
            this.ur.setOnClickListener(nVar);
            this.ur.setOnTouchListener(nVar);
            TextView textView = this.lh;
            if (textView != null) {
                textView.setOnClickListener(nVar);
                this.lh.setOnTouchListener(nVar);
            }
        }
    }

    public void n(final qg.n nVar, boolean z) {
        ImageView imageView = (ImageView) findViewById(2114387705);
        this.sz = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pt.BaseLandingPageActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.s();
                }
            });
        }
        ImageView imageView2 = (ImageView) findViewById(2114387704);
        this.k = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pt.BaseLandingPageActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.q();
                }
            });
        }
        TextView textView = (TextView) findViewById(2114387952);
        this.cy = textView;
        if (textView != null) {
            textView.setText(TextUtils.isEmpty(this.oa) ? "广告" : this.oa);
        }
        TextView textView2 = (TextView) findViewById(2114387627);
        this.hd = textView2;
        if (textView2 != null) {
            if (this.ae != null && this.ae.pt() != null) {
                this.ae.pt().n("landing_page");
            }
            this.hd.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.pt.BaseLandingPageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BaseLandingPageActivity.this.n(nVar);
                }
            });
        }
        n(4);
    }

    public void s() {
        if (com.byazt.okk.s.n(this.ou)) {
            return;
        }
        com.byazt.nsm.qg qgVar = this.um;
        if (qgVar != null) {
            qgVar.n(0);
        }
        onBackPressed();
    }

    public void q() {
        n("detail_skip");
        finish();
    }

    public void n(qg.n nVar) {
        if (this.ae == null || isFinishing()) {
            return;
        }
        if (this.hu == null) {
            qg(nVar);
        }
        qg qgVar = this.hu;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    public void qg(qg.n nVar) {
        try {
            this.hu = new qg(this.l, this.ae.pt(), this.s, true, com.byazt.imu.s.n());
            com.byazt.yo.s.n(this.l, this.ae, this.hu);
            this.hu.n(nVar);
        } catch (Exception e) {
            k.n(e.getMessage());
        }
    }

    @Override // com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        tj();
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.s = intent.getStringExtra("event_tag");
        this.n = intent.getStringExtra(MediationConstant.EXTRA_ADID);
        this.q = intent.getIntExtra("landing_page_source", -1);
        this.cp = intent.getBooleanExtra("is_outer_click", false);
        this.tj = intent.getStringExtra(ImagesContract.URL);
        this.df = intent.getBooleanExtra("web_dl_factors", false) && !TextUtils.isEmpty(this.tj) && this.tj.contains("chengzijianzhan");
        this.tj = w.q(this.ae, this.tj);
        this.oa = intent.getStringExtra("title");
        this.d = intent.getIntExtra("get_phone_num_status", 0);
        this.a = intent.getBooleanExtra("video_is_auto_play", true);
        if (this.ae == null) {
            finish();
            return;
        }
        this.qg = this.ae.F_();
        this.l = this;
        n(bundle);
        try {
            rv.n(this.l);
        } catch (Throwable unused) {
        }
        View viewX = x();
        this.v = viewX;
        setContentView(viewX);
        l();
        w();
        if (cp() || Build.VERSION.SDK_INT < 36 || !MediationConstant.ADN_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            return;
        }
        this.v.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.byazt.pt.BaseLandingPageActivity.6
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                View view = BaseLandingPageActivity.this.v;
                if (view != null) {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    float fCp = com.byazt.okk.s.cp((Context) null);
                    if (iArr[1] <= 0) {
                        view.setPadding(0, (int) fCp, 0, 0);
                    }
                }
            }
        });
    }

    public void n(boolean z) {
        com.byazt.dho.n.n(this.l).n(z).qg(false).n(this.ou);
        this.ou.addJavascriptInterface(new com.byazt.mga.n(this.ou, getApplicationContext(), this.ae != null ? this.ae.x() : this.d, this.ae), "CCWifiJSBridge");
        this.cd = new s(this.ae, this.ou).qg(true).qg(System.currentTimeMillis()).q(this.ou.getCreateDuration());
        d();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adid", this.n);
            jSONObject.put(ImagesContract.URL, this.tj);
            jSONObject.put("web_title", this.oa);
            jSONObject.put("is_multi_process", com.byazt.byp.qg.n());
            jSONObject.put("event_tag", this.s);
        } catch (JSONException unused) {
        }
        this.cd.n(jSONObject);
        oa();
        com.byazt.dho.s sVar = new com.byazt.dho.s(this.l, this.h, this.n, this.cd, this.wm) { // from class: com.byazt.pt.BaseLandingPageActivity.7
            public final long rv = System.currentTimeMillis();

            @Override // com.byazt.dho.s, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (BaseLandingPageActivity.this.m != null && !BaseLandingPageActivity.this.isFinishing()) {
                        BaseLandingPageActivity.this.m.setVisibility(8);
                    }
                    if (webView != null) {
                        webView.evaluateJavascript(BaseLandingPageActivity.n(this.rv), null);
                    }
                } catch (Throwable unused2) {
                }
            }
        };
        this.py = sVar;
        this.ou.setWebViewClient(sVar);
        com.byazt.qq.n.n(this.ou, tj.l, pk.l(this.ae));
        this.ou.setMixedContentMode(0);
        this.ou.setWebChromeClient(new com.byazt.dho.qg(this.h, this.cd) { // from class: com.byazt.pt.BaseLandingPageActivity.8
            @Override // com.byazt.dho.qg, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (BaseLandingPageActivity.this.m == null || BaseLandingPageActivity.this.isFinishing()) {
                    return;
                }
                if (i == 100 && BaseLandingPageActivity.this.m.isShown()) {
                    BaseLandingPageActivity.this.m.setVisibility(8);
                } else {
                    BaseLandingPageActivity.this.m.setProgress(i);
                }
            }
        });
        this.ou.setDownloadListener(new n(this.j, this.ae, this.l, this.s, this.df));
        this.ou.setVisibility(0);
        this.cd.s(System.currentTimeMillis());
        this.ou.loadUrl(this.tj);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.nsm.qg qgVar = this.um;
        if (qgVar != null) {
            qgVar.n(this.l, this.ae);
        }
    }

    private void d() {
        pk pkVar = this.ae;
        if (pkVar == null) {
            return;
        }
        this.wm = q.n(this.l, pkVar, this.tj);
    }

    private void oa() {
        if (this.ou == null) {
            return;
        }
        sz();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.ae);
        com.byazt.gcl.s sVar = new com.byazt.gcl.s(this.l);
        this.h = sVar;
        sVar.q(this.cp);
        this.h.qg(this.ou).n(this.ae).s(arrayList).qg(this.n).q(this.qg).s(this.q).n(this.s).l(w.wm(this.ae)).n(this.ou).n(true).qg(com.byazt.oh.l.n(this.ae)).n(this);
    }

    private void sz() {
        if (this.ae == null || this.ou == null) {
            return;
        }
        String strPy = this.ae.py();
        if (TextUtils.isEmpty(strPy)) {
            return;
        }
        com.byazt.uad.n.n(strPy, this.ou.getInnerIWebView());
    }

    public void w() {
        com.byazt.hm.n.n(this.ae, getClass().getName());
        com.byazt.hm.n.n(this.ae);
        this.um = new com.byazt.nsm.qg(this.cd.n());
    }

    public void n(int i) {
        if (pk.q(this.ae)) {
            com.byazt.okk.s.n((View) this.k, 4);
        } else if (pk.q(this.ae)) {
            com.byazt.okk.s.n((View) this.k, i);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.byazt.nsm.qg qgVar = this.um;
        if (qgVar != null) {
            qgVar.n(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        com.byazt.fr.s.n().n(this, this.ae, w.bb(this.ae));
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        com.byazt.gcl.s sVar = this.h;
        if (sVar != null) {
            sVar.ln();
        }
        com.byazt.oh.n nVar = this.ln;
        if (nVar != null) {
            nVar.onPause();
        }
        for (Map.Entry<String, ITTInnerDownloadAdapter> entry : this.j.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().onPause();
            }
        }
        com.byazt.dho.s sVar2 = this.py;
        if (sVar2 != null) {
            sVar2.s();
        }
    }

    public void qg(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.ur) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.byazt.pt.BaseLandingPageActivity.9
            @Override // java.lang.Runnable
            public void run() {
                if (BaseLandingPageActivity.this.ur == null || BaseLandingPageActivity.this.isFinishing()) {
                    return;
                }
                BaseLandingPageActivity.this.ur.setText(str);
            }
        });
    }

    @Override // android.app.Activity
    public void onResume() {
        String strYr;
        super.onResume();
        Window window = getWindow();
        if (this.dg == Long.MIN_VALUE) {
            this.dg = System.currentTimeMillis();
        }
        if (window != null) {
            com.byazt.wb.fs.n(window.getDecorView());
        }
        com.byazt.gcl.s sVar = this.h;
        if (sVar != null) {
            sVar.bb();
            this.h.n(new SSWebView.qg() { // from class: com.byazt.pt.BaseLandingPageActivity.10
                @Override // com.byazt.kfh.SSWebView.qg
                public void n(int i) {
                    BaseLandingPageActivity.this.h.n(i);
                }
            });
        }
        com.byazt.oh.n nVar = this.ln;
        if (nVar != null) {
            nVar.onResume();
        }
        for (Map.Entry<String, ITTInnerDownloadAdapter> entry : this.j.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().onResume();
            }
        }
        s sVar2 = this.cd;
        if (sVar2 != null) {
            sVar2.q();
        }
        com.byazt.dho.s sVar3 = this.py;
        if (sVar3 != null) {
            sVar3.qg(true);
        }
        rv();
        if (this.ae == null || !cy()) {
            return;
        }
        if (this.f == null) {
            this.f = new UgenBanner(this);
        }
        addContentView(this.f, new ViewGroup.LayoutParams(-1, -2));
        this.fi = true;
        com.byazt.gct.l lVarK = this.ae.k();
        if (lVarK != null) {
            strYr = lVarK.s();
        } else {
            strYr = this.ae.yr();
        }
        this.f.setTopMargin(com.byazt.okk.s.s(this, 50.0f));
        this.f.n(k(), this.ae, new com.byazt.ys.qg(this, this.ae, this.s, this.q), strYr, this.ae.E_(), "立即打开", true);
    }

    private com.byazt.ai.n k() {
        hd hdVarSz = this.ae.sz();
        if (hdVarSz == null) {
            return null;
        }
        String strW = hdVarSz.w();
        if (TextUtils.isEmpty(strW)) {
            return null;
        }
        com.byazt.ai.n nVar = new com.byazt.ai.n();
        nVar.s(strW);
        nVar.qg(hdVarSz.x());
        nVar.n(strW);
        return nVar;
    }

    private boolean cy() {
        hd hdVarSz = this.ae.sz();
        if (hdVarSz == null) {
            return false;
        }
        hdVarSz.n(true);
        int iS = hdVarSz.s();
        return (iS == 1 || iS == 2) && !this.fi;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        s sVar = this.cd;
        if (sVar != null) {
            sVar.l();
        }
        com.byazt.fr.s.n().qg((Context) this, this.ae, false);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (fs()) {
            return;
        }
        super.onBackPressed();
    }

    public boolean fs() {
        try {
            if ((pk.q(this.ae) || f.n(this.ae)) && com.byazt.okk.s.n(this.ou)) {
                return true;
            }
            com.byazt.nsm.qg qgVar = this.um;
            return qgVar != null && qgVar.qg(this.l, this.ae);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.byazt.pt.BaseThemeActivity, android.app.Activity
    public void onDestroy() {
        com.byazt.mi.qg qgVar;
        super.onDestroy();
        s sVar = this.cd;
        if (sVar != null) {
            sVar.x();
        }
        try {
            if (getWindow() != null) {
                ((ViewGroup) getWindow().getDecorView()).removeAllViews();
            }
        } catch (Throwable unused) {
        }
        SSWebView sSWebView = this.ou;
        if (sSWebView != null) {
            com.byazt.uad.n.n(sSWebView);
            com.byazt.gcl.q.n(this.l, this.ou);
            com.byazt.gcl.q.n(this.ou);
        }
        this.ou = null;
        q qVar = this.wm;
        if (qVar != null) {
            qVar.q();
        }
        com.byazt.gcl.s sVar2 = this.h;
        if (sVar2 != null) {
            sVar2.lh();
        }
        com.byazt.oh.n nVar = this.ln;
        if (nVar != null) {
            nVar.onDestroy();
        }
        for (Map.Entry<String, ITTInnerDownloadAdapter> entry : this.j.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().onDestroy();
            }
        }
        this.j.clear();
        s sVar3 = this.cd;
        if (sVar3 != null) {
            sVar3.w();
        }
        UgenBanner ugenBanner = this.f;
        if (ugenBanner != null) {
            ugenBanner.n();
        }
        if (this.ae == null) {
            return;
        }
        hd hdVarSz = this.ae.sz();
        if (hdVarSz != null) {
            hdVarSz.n(false);
        }
        if (!this.ae.hy() || this.ae.ii() < 0 || (qgVar = (com.byazt.mi.qg) com.byazt.ikv.qg.n(this.ae.py(), com.byazt.mi.qg.class)) == null) {
            return;
        }
        boolean z = System.currentTimeMillis() - this.dg >= ((long) this.ae.ii()) * 1000;
        if (z) {
            com.byazt.hm.n.n(this.ae, 4);
        }
        qgVar.n(z ? 5 : 6, null);
    }

    @Override // com.byazt.ll.l
    public void n(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.t = jSONArray;
        rv();
    }

    public void rv() {
        if (this.ae == null) {
            return;
        }
        JSONArray jSONArrayS = s(this.tj);
        int iCy = w.cy(this.ae);
        int iD = w.d(this.ae);
        com.byazt.mw.n nVarN = rv.n();
        if (jSONArrayS == null || nVarN == null || iCy <= 0 || iD <= 0) {
            return;
        }
        y yVar = new y();
        yVar.w = jSONArrayS;
        com.byazt.zq.qg qgVarXd = this.ae.xd();
        if (qgVarXd == null) {
            return;
        }
        nVarN.n(com.byazt.vgx.q.qg(qgVarXd).s(6).n(), yVar, iD, new com.byazt.mw.n.qg() { // from class: com.byazt.pt.BaseLandingPageActivity.2
            @Override // com.byazt.mw.n.qg
            public void n(int i, String str, com.byazt.gct.qg qgVar) {
                BaseLandingPageActivity.this.n(0);
                qgVar.n(i);
                com.byazt.gct.qg.n(qgVar);
            }

            @Override // com.byazt.mw.n.qg
            public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar) {
                if (nVar != null) {
                    try {
                        BaseLandingPageActivity.this.bb.set(false);
                        BaseLandingPageActivity.this.h.n(nVar.s());
                    } catch (Exception unused) {
                        BaseLandingPageActivity.this.n(0);
                    }
                }
            }
        });
    }

    private JSONArray s(String str) {
        int i;
        JSONArray jSONArray = this.t;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.t;
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

    public static String n(long j) {
        return "const existingScript = document.getElementById('" + j + "');if (!existingScript) {var script = document.createElement('script');script.id = '" + j + "';script.src = '" + ("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/stylex-infra-mono/landing-sdk/index.js?t=" + System.currentTimeMillis()) + "';document.head?.appendChild(script);}";
    }

    public void tj() {
        com.byazt.cb.s.n(this);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    public static class n implements DownloadListener {
        public boolean l;
        public Map<String, ITTInnerDownloadAdapter> n;
        public String q;
        public pk qg;
        public Context s;

        public n(Map<String, ITTInnerDownloadAdapter> map, pk pkVar, Context context, String str, boolean z) {
            this.n = map;
            this.qg = pkVar;
            this.s = context;
            this.q = str;
            this.l = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            Map<String, ITTInnerDownloadAdapter> map = this.n;
            if (map != null && map.containsKey(str)) {
                ITTInnerDownloadAdapter iTTInnerDownloadAdapter = this.n.get(str);
                if (iTTInnerDownloadAdapter != null) {
                    iTTInnerDownloadAdapter.changeDownloadStatus(w.h(this.qg), false);
                    return;
                }
                return;
            }
            ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = fs.n(this.s, str, this.qg, this.q);
            iTTInnerDownloadAdapterN.setCheckCompliance(com.byazt.oh.l.n(this.qg));
            iTTInnerDownloadAdapterN.setShowDLFactorsCard(this.l);
            this.n.put(str, iTTInnerDownloadAdapterN);
            iTTInnerDownloadAdapterN.changeDownloadStatus(w.h(this.qg), false);
        }
    }
}
