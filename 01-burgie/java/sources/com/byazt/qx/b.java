package com.byazt.qx;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.fj.SSWebView;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.mo.ThemeStatusBroadcastReceiver;
import com.byazt.sd.nl;
import com.byazt.wt.e;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.wt.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME})
public class b extends com.byazt.kq.pr implements g, ho {
    public com.byazt.mq.aj a;
    public of aj;
    public nt cz;
    public long fo;
    public Context fw;
    public int g;
    public boolean ho;
    public com.byazt.pj.hn k;
    public com.byazt.eq.zo lb;
    public nl m;
    public boolean nt;
    public com.byazt.ak.hw ny;
    public fw qa;
    public com.byazt.nk.pr rc;
    public final Map<String, com.byazt.nv.hn> uc;
    public com.byazt.ko.pr vk;
    public String w;
    public com.byazt.wt.pr yb;
    public String zo;

    public b(Context context, com.byazt.mq.m mVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.byazt.ko.pr prVar, of ofVar, com.byazt.mq.aj ajVar, nt ntVar) {
        of ofVar2;
        com.byazt.qe.hw hwVarP;
        super(context, mVar, themeStatusBroadcastReceiver);
        this.uc = Collections.synchronizedMap(new HashMap());
        this.g = 8;
        this.ho = true;
        this.nt = true;
        this.fo = -1L;
        this.fw = context;
        this.zo = mVar.uc();
        this.aj = ofVar;
        this.vk = prVar;
        this.pr = mVar.c();
        this.w = pr(ofVar);
        this.a = ajVar;
        this.cz = ntVar;
        this.rc = new com.byazt.nk.pr(ofVar);
        pr(s.hn(s.hw(this.w)));
        themeStatusBroadcastReceiver.pr(this);
        w();
        k();
        m();
        if (com.byazt.ak.x.fw().hn() && (ofVar2 = this.aj) != null && (hwVarP = ofVar2.p()) != null) {
            int iA = hwVarP.a();
            this.ny = new com.byazt.ak.hw(iA <= 0 ? ls.k(this.aj) : iA, this.aj.le(), this.aj.z());
        }
    }

    public static String pr(of ofVar) {
        String str;
        if (!ie.aj(ofVar)) {
            str = null;
        } else {
            str = "v3";
        }
        return com.byazt.ce.hw.hw(str);
    }

    public static void pr(Map<String, Object> map, of ofVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            byte showDLFactorsEventParams = nativeExpressView.getShowDLFactorsEventParams();
            if (showDLFactorsEventParams != -1) {
                map.put("biz_type", Byte.valueOf(showDLFactorsEventParams));
            }
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (ie.fw(ofVar) != null && !TextUtils.isEmpty(ie.fw(ofVar).w())) {
                map.put("engine_version", ie.fw(ofVar).w());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void w() {
        if (this.hn == null) {
            return;
        }
        nt();
        nl nlVar = new nl(this.fw);
        this.m = nlVar;
        nlVar.hw(this.hn).pr(this.aj).hw(this.aj.x()).x(this.aj.B_()).pr(this.zo).hn(ls.x(this.zo)).c(ls.a(this.aj)).pr(this).x(this.pr).pr(this.cz).pr(this.hn).pr(this.vk);
    }

    private void nt() {
        if (this.aj == null || this.hn == null) {
            return;
        }
        if (!TextUtils.equals(this.zo, "rewarded_video") && !TextUtils.equals(this.zo, "fullscreen_interstitial_ad")) {
            return;
        }
        String strCz = this.aj.cz();
        if (TextUtils.isEmpty(strCz)) {
            return;
        }
        com.byazt.son.pr.pr(strCz, this.hn.getInnerIWebView());
    }

    public void k() {
        if (this.hn == null) {
            return;
        }
        this.hn.setMaterialMeta(e.pr(this.aj));
        try {
            this.hn.setBackgroundColor(0);
            this.hn.setBackgroundResource(R.color.transparent);
        } catch (Exception e) {
        }
        pr(this.hn);
        if (pr() != null) {
            this.k = new com.byazt.pj.hn(this.aj, pr()).hw(false);
        }
        this.k.pr(this.vk);
        this.hn.setWebChromeClient(new com.byazt.lz.hn(this.m, this.k));
        this.hn.setDownloadListener(new DownloadListener() { // from class: com.byazt.qx.b.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (b.this.uc.containsKey(str)) {
                    com.byazt.nv.hn hnVar = (com.byazt.nv.hn) b.this.uc.get(str);
                    if (hnVar != null) {
                        hnVar.pr(ls.fo(b.this.aj), false);
                        return;
                    }
                    return;
                }
                com.byazt.nv.hn hnVarPr = com.byazt.jx.zo.pr(b.this.fw, str, b.this.aj, b.this.zo);
                b.this.uc.put(str, hnVarPr);
                hnVarPr.pr(ls.fo(b.this.aj), false);
            }
        });
        if ("rewarded_video".equals(this.zo) || "fullscreen_interstitial_ad".equals(this.zo)) {
            er.pr((com.byazt.son.x) this.hn);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            com.byazt.kq.c.pr().pr(this.hn, this.m);
        }
    }

    private void pr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.lz.hw.pr(this.fw).pr(false).pr(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            if (com.byazt.sd.a.hw().ll()) {
                sSWebView.clearCache(true);
            }
            com.byazt.wt.cz.pr(sSWebView, com.byazt.sd.iu.x, of.c(this.aj));
            if (Build.VERSION.SDK_INT >= 21) {
                sSWebView.setMixedContentMode(0);
            }
            sSWebView.setJavaScriptEnabled(true);
            sSWebView.setJavaScriptCanOpenWindowsAutomatically(true);
            sSWebView.setDomStorageEnabled(true);
            sSWebView.setDatabaseEnabled(true);
            sSWebView.setAppCacheEnabled(true);
            sSWebView.setAllowFileAccess(false);
            sSWebView.setSupportZoom(true);
            sSWebView.setBuiltInZoomControls(true);
            sSWebView.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            sSWebView.setUseWideViewPort(true);
        } catch (Exception e) {
            com.byazt.ca.ho.hw("WebViewRender", e.toString());
        }
    }

    public void m() {
        if (this.hn == null || this.lb != null) {
            return;
        }
        com.byazt.ns.hn hnVar = new com.byazt.ns.hn();
        com.byazt.ns.x xVar = new com.byazt.ns.x();
        com.byazt.ns.c cVar = new com.byazt.ns.c(this.m);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.aj.x());
            jSONObject.put("log_extra", this.aj.B_());
        } catch (Throwable th) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        hashSet.add("sendReward");
        this.lb = hnVar.pr(com.byazt.sd.a.getContext(), this.hn, cVar, xVar, hashSet, com.byazt.pfl.hw.AD_TAG_FEED.equals(this.zo) ? com.byazt.eq.zo.pr.FEED : com.byazt.eq.zo.pr.OTHER).c(this.w).x(com.byazt.hb.pr.zo()).pr(com.byazt.hb.pr.pr()).c(jSONObject).pr("sdkEdition", com.byazt.hb.pr.hn()).hw(com.byazt.hb.pr.uc()).hn(com.byazt.hb.pr.c()).hn(false);
        this.qa = new fw(this.fw, this.m, this.aj, this.k, yb(), this.lb, vk());
        this.hn.setWebViewClient(this.qa);
        com.byazt.mq.aj ajVar = this.a;
        if (ajVar instanceof vk) {
            ((vk) ajVar).pr(this.lb);
        }
        Set<String> setVk = this.lb.vk();
        if (this.m == null || setVk == null || setVk.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.lb);
        Iterator<String> it = setVk.iterator();
        while (it.hasNext()) {
            this.m.uc().pr(it.next(), (com.byazt.ee.c<?, ?>) new com.byazt.ee.c<JSONObject, JSONObject>() { // from class: com.byazt.qx.b.2
                @Override // com.byazt.ee.c
                public JSONObject pr(JSONObject jSONObject2, com.byazt.ee.uc ucVar) throws Exception {
                    try {
                        com.byazt.eq.zo zoVar = (com.byazt.eq.zo) weakReference.get();
                        if (zoVar == null) {
                            return null;
                        }
                        return zoVar.x(pr(), jSONObject2);
                    } catch (Throwable th2) {
                        return null;
                    }
                }
            });
        }
    }

    public fw g() {
        return this.qa;
    }

    @Override // com.byazt.kq.pr
    public SSWebView pr() {
        return this.hn;
    }

    private boolean yb() {
        return !TextUtils.isEmpty(this.zo) && this.zo.equals("splash_ad");
    }

    @Override // com.byazt.kq.pr, com.byazt.mq.x
    public void pr(boolean z) {
        com.byazt.nk.pr prVar;
        com.byazt.ak.hw hwVar;
        if (z && (hwVar = this.ny) != null) {
            hwVar.zo();
            this.ny = null;
        }
        if (z && (prVar = this.rc) != null) {
            prVar.hw();
            this.rc = null;
        }
        if (this.c.get()) {
            return;
        }
        com.byazt.pj.hn hnVar = this.k;
        if (hnVar != null) {
            hnVar.uc();
        }
        if (this.hn != null) {
            this.hn.U_();
            this.hn.setOnShakeListener(null);
        }
        nl nlVar = this.m;
        if (nlVar != null) {
            nlVar.c();
        }
        super.pr(z);
        this.uc.clear();
        this.m = null;
        com.byazt.eq.zo zoVar = this.lb;
        if (zoVar == null) {
            return;
        }
        zoVar.n();
    }

    @Override // com.byazt.kq.pr, com.byazt.mq.x
    public int hw() {
        return ie.hn(this.aj);
    }

    @Override // com.byazt.kq.pr
    public void x() {
        if (pr() == null) {
            return;
        }
        try {
            pr().resumeTimers();
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.kq.pr
    public void pr(boolean z, int i) {
        super.pr(z, i);
        com.byazt.ko.pr prVar = this.vk;
        if (prVar != null) {
            prVar.pr(z, i);
            this.vk.hw(false);
        }
    }

    @Override // com.byazt.kq.pr, com.byazt.qx.g
    public void fw() {
        nl nlVar;
        super.fw();
        if (this.m == null) {
            return;
        }
        com.byazt.nk.pr prVar = this.rc;
        if (prVar != null) {
            prVar.pr();
        }
        lb();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.m.hw("expressShow", jSONObject);
        } catch (Exception e) {
        }
        com.byazt.ak.hw hwVar = this.ny;
        if (hwVar != null && (nlVar = this.m) != null && this.aj != null) {
            nlVar.pr(hwVar);
            this.ny.c();
        }
    }

    private void lb() {
        if (this.m == null || ((ViewGroup) this.hn.getParent()) == null) {
            return;
        }
        this.m.pr(new iu(this.hn, this.m, this.aj));
    }

    @Override // com.byazt.kq.pr
    public void zo() {
        com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
        this.yb = prVarHn;
        prVarHn.pr(this);
    }

    @Override // com.byazt.kq.pr
    public void aj() {
        super.aj();
        com.byazt.wt.pr prVar = this.yb;
        if (prVar != null) {
            prVar.hw(this);
        }
    }

    @Override // com.byazt.kq.pr
    public void c() {
        nl nlVar = this.m;
        if (nlVar == null) {
            return;
        }
        nlVar.hw("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.byazt.kq.pr, com.byazt.qx.g
    public void hw(final int i) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.qx.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.hn(i);
                b.this.x(i);
                if (i != b.this.g) {
                    b.this.g = i;
                    b.this.c(i == 0);
                    b.this.qa();
                }
            }
        });
    }

    public void hn(final boolean z) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.qx.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.ho = z;
                b.this.qa();
            }
        });
    }

    public void x(final boolean z) {
        com.byazt.zp.zo.pr(new Runnable() { // from class: com.byazt.qx.b.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = b.this.nt;
                boolean z3 = z;
                if (z2 != (!z3)) {
                    b.this.nt = !z3;
                    b.this.qa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(int i) {
        com.byazt.eq.zo zoVar = this.lb;
        if (zoVar == null) {
            return;
        }
        if (i == 0) {
            zoVar.hw(true);
            this.lb.pr(false);
        } else {
            zoVar.hw(false);
            this.lb.pr(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.m == null || this.hn == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.m.hw("expressAdShow", jSONObject);
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.qx.ho
    public nl P_() {
        return this.m;
    }

    @Override // com.byazt.mo.pr
    public void b_(int i) {
        if (this.m == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i);
        } catch (JSONException e) {
        }
        this.m.hw("themeChange", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(int i) {
        try {
            if (com.byazt.sd.iu.pr() && i == 0) {
                long jPp = com.byazt.sd.a.hw().pp();
                if (this.fo != -1 && System.currentTimeMillis() - this.fo > jPp) {
                    SSWebView sSWebViewPr = pr();
                    WebView webView = sSWebViewPr.getWebView();
                    sSWebViewPr.removeView(webView);
                    sSWebViewPr.addView(webView);
                }
                this.fo = -1L;
                return;
            }
            this.fo = System.currentTimeMillis();
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.kq.pr
    public void pr(float f, float f2) {
        float f3 = this.fw.getResources().getDisplayMetrics().density;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        super.pr(er.hw(f3, er.pr(f4, f)), er.hw(f3, er.pr(f4, f2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
        com.byazt.lr.pr.pr(this.m, this.g == 0, this.ho, this.nt);
    }

    public void pr(com.byazt.cy.pr prVar) {
        com.byazt.ak.hw hwVar = this.ny;
        if (hwVar != null) {
            hwVar.pr(prVar);
        }
    }

    public void ho() {
        com.byazt.ak.hw hwVar = this.ny;
        if (hwVar != null) {
            hwVar.zo();
            this.ny = null;
        }
        com.byazt.nk.pr prVar = this.rc;
        if (prVar != null) {
            prVar.hw();
            this.rc = null;
        }
    }
}
