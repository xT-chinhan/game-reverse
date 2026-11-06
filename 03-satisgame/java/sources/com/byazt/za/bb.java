package com.byazt.za;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.hne.ThemeStatusBroadcastReceiver;
import com.byazt.kfh.SSWebView;
import com.byazt.pmn.ITTInnerDownloadAdapter;
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
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF})
public class bb extends com.byazt.gjp.n implements cy, k {
    public com.byazt.udb.rv a;
    public com.byazt.ew.fs cd;
    public String cp;
    public boolean cy;
    public com.byazt.hm.s d;
    public String fs;
    public com.byazt.ot.n hd;
    public boolean k;
    public com.byazt.cv.n m;
    public com.byazt.gcl.s oa;
    public com.byazt.vhv.qg ou;
    public hd py;
    public pk rv;
    public int sz;
    public com.byazt.vgn.q tj;
    public fs um;
    public final Map<String, ITTInnerDownloadAdapter> w;
    public long wm;
    public Context x;

    public bb(Context context, com.byazt.udb.oa oaVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.byazt.vgn.q qVar, pk pkVar, com.byazt.udb.rv rvVar, hd hdVar) {
        com.byazt.zq.qg qgVarXd;
        super(context, oaVar, themeStatusBroadcastReceiver);
        this.w = Collections.synchronizedMap(new HashMap());
        this.sz = 8;
        this.k = true;
        this.cy = true;
        this.wm = -1L;
        this.x = context;
        this.fs = oaVar.w();
        this.rv = pkVar;
        this.tj = qVar;
        this.n = oaVar.l();
        this.cp = n(pkVar);
        this.a = rvVar;
        this.py = hdVar;
        this.m = new com.byazt.cv.n(pkVar);
        n(com.byazt.lq.l.s(com.byazt.lq.l.qg(this.cp)));
        themeStatusBroadcastReceiver.n(this);
        cp();
        d();
        oa();
        if (!com.byazt.vhv.q.x().s() || this.rv == null || !nf.rv(pkVar) || (qgVarXd = this.rv.xd()) == null) {
            return;
        }
        int iA = qgVarXd.a();
        this.ou = new com.byazt.vhv.qg(iA <= 0 ? com.byazt.vgx.w.d(this.rv) : iA, this.rv.ih(), this.rv.h());
    }

    public static String n(pk pkVar) {
        return com.byazt.mzw.qg.qg(nf.rv(pkVar) ? "v3" : null);
    }

    public static void n(Map<String, Object> map, pk pkVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            byte showDLFactorsEventParams = nativeExpressView.getShowDLFactorsEventParams();
            if (showDLFactorsEventParams != -1) {
                map.put("biz_type", Byte.valueOf(showDLFactorsEventParams));
            }
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (nf.x(pkVar) != null && !TextUtils.isEmpty(nf.x(pkVar).cp())) {
                map.put("engine_version", nf.x(pkVar).cp());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void cp() {
        if (this.s == null) {
            return;
        }
        cy();
        com.byazt.gcl.s sVar = new com.byazt.gcl.s(this.x);
        this.oa = sVar;
        sVar.qg(this.s).n(this.rv).qg(this.rv.q()).q(this.rv.F_()).n(this.fs).s(com.byazt.vgx.w.q(this.fs)).l(com.byazt.vgx.w.wm(this.rv)).n(this).q(this.n).n(this.py).n(this.s).n(this.tj);
    }

    private void cy() {
        if (this.rv == null || this.s == null) {
            return;
        }
        if (TextUtils.equals(this.fs, "rewarded_video") || TextUtils.equals(this.fs, "fullscreen_interstitial_ad")) {
            String strPy = this.rv.py();
            if (TextUtils.isEmpty(strPy)) {
                return;
            }
            com.byazt.uad.n.n(strPy, this.s.getInnerIWebView());
        }
    }

    public void d() {
        if (this.s == null) {
            return;
        }
        this.s.setMaterialMeta(com.byazt.cd.s.n(this.rv));
        try {
            this.s.setBackgroundColor(0);
            this.s.setBackgroundResource(R.color.transparent);
        } catch (Exception unused) {
        }
        n(this.s);
        if (n() != null) {
            this.d = new com.byazt.hm.s(this.rv, n()).qg(false);
        }
        this.d.n(this.tj);
        this.s.setWebChromeClient(new com.byazt.dho.qg(this.oa, this.d));
        this.s.setDownloadListener(new DownloadListener() { // from class: com.byazt.za.bb.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (bb.this.w.containsKey(str)) {
                    ITTInnerDownloadAdapter iTTInnerDownloadAdapter = (ITTInnerDownloadAdapter) bb.this.w.get(str);
                    if (iTTInnerDownloadAdapter != null) {
                        iTTInnerDownloadAdapter.changeDownloadStatus(com.byazt.vgx.w.h(bb.this.rv), false);
                        return;
                    }
                    return;
                }
                ITTInnerDownloadAdapter iTTInnerDownloadAdapterN = com.byazt.iz.fs.n(bb.this.x, str, bb.this.rv, bb.this.fs);
                bb.this.w.put(str, iTTInnerDownloadAdapterN);
                iTTInnerDownloadAdapterN.changeDownloadStatus(com.byazt.vgx.w.h(bb.this.rv), false);
            }
        });
        if ("rewarded_video".equals(this.fs) || "fullscreen_interstitial_ad".equals(this.fs)) {
            com.byazt.okk.s.n((com.byazt.uad.q) this.s);
        }
        com.byazt.gjp.l.n().n(this.s, this.oa);
    }

    private void n(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.dho.n.n(this.x).n(false).n(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            if (com.byazt.nf.rv.qg().af()) {
                sSWebView.clearCache(true);
            }
            com.byazt.qq.n.n(sSWebView, com.byazt.nf.tj.l, pk.l(this.rv));
            sSWebView.setMixedContentMode(0);
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
            com.byazt.tk.k.qg("WebViewRender", e.toString());
        }
    }

    public void oa() {
        if (this.s == null || this.cd != null) {
            return;
        }
        com.byazt.pb.n nVar = new com.byazt.pb.n();
        com.byazt.pb.qg qgVar = new com.byazt.pb.qg();
        com.byazt.pb.s sVar = new com.byazt.pb.s(this.oa);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.rv.q());
            jSONObject.put("log_extra", this.rv.F_());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        hashSet.add("sendReward");
        this.cd = nVar.n(com.byazt.nf.rv.getContext(), this.s, sVar, qgVar, hashSet, com.byazt.wg.qg.AD_TAG_FEED.equals(this.fs) ? com.byazt.ew.fs.n.FEED : com.byazt.ew.fs.n.OTHER).l(this.cp).q(com.byazt.ges.qg.fs()).n(com.byazt.ges.qg.n()).l(jSONObject).n("sdkEdition", com.byazt.ges.qg.s()).qg(com.byazt.ges.qg.w()).s(com.byazt.ges.qg.l()).s(false);
        this.um = new fs(this.x, this.oa, this.rv, this.d, hd(), this.cd, tj());
        this.s.setWebViewClient(this.um);
        com.byazt.udb.rv rvVar = this.a;
        if (rvVar instanceof cp) {
            ((cp) rvVar).n(this.cd);
        }
        Set<String> setTj = this.cd.tj();
        if (this.oa == null || setTj == null || setTj.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.cd);
        Iterator<String> it = setTj.iterator();
        while (it.hasNext()) {
            this.oa.w().n(it.next(), (com.byazt.cf.l<?, ?>) new com.byazt.cf.l<JSONObject, JSONObject>() { // from class: com.byazt.za.bb.2
                @Override // com.byazt.cf.l
                public JSONObject n(JSONObject jSONObject2, com.byazt.cf.w wVar) throws Exception {
                    try {
                        com.byazt.ew.fs fsVar = (com.byazt.ew.fs) weakReference.get();
                        if (fsVar == null) {
                            return null;
                        }
                        return fsVar.q(n(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    public fs sz() {
        return this.um;
    }

    @Override // com.byazt.gjp.n
    public SSWebView n() {
        return this.s;
    }

    private boolean hd() {
        return !TextUtils.isEmpty(this.fs) && this.fs.equals("splash_ad");
    }

    @Override // com.byazt.gjp.n, com.byazt.udb.q
    public void n(boolean z) {
        com.byazt.cv.n nVar;
        com.byazt.vhv.qg qgVar;
        if (z && (qgVar = this.ou) != null) {
            qgVar.rv();
            this.ou = null;
        }
        if (z && (nVar = this.m) != null) {
            nVar.qg();
            this.m = null;
        }
        if (this.l.get()) {
            return;
        }
        com.byazt.hm.s sVar = this.d;
        if (sVar != null) {
            sVar.w();
        }
        if (this.s != null) {
            this.s.U_();
            this.s.setOnShakeListener(null);
        }
        com.byazt.gcl.s sVar2 = this.oa;
        if (sVar2 != null) {
            sVar2.l();
        }
        super.n(z);
        this.w.clear();
        this.oa = null;
        com.byazt.ew.fs fsVar = this.cd;
        if (fsVar == null) {
            return;
        }
        fsVar.j();
    }

    @Override // com.byazt.gjp.n, com.byazt.udb.q
    public int qg() {
        return nf.s(this.rv);
    }

    @Override // com.byazt.gjp.n
    public void q() {
        if (n() == null) {
            return;
        }
        try {
            n().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gjp.n
    public void n(boolean z, int i) {
        super.n(z, i);
        com.byazt.vgn.q qVar = this.tj;
        if (qVar != null) {
            qVar.n(z, i);
            this.tj.qg(false);
        }
    }

    @Override // com.byazt.gjp.n, com.byazt.za.k
    public void x() {
        com.byazt.gcl.s sVar;
        super.x();
        if (this.oa == null) {
            return;
        }
        com.byazt.cv.n nVar = this.m;
        if (nVar != null) {
            nVar.n();
        }
        cd();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.oa.qg("expressShow", jSONObject);
        } catch (Exception unused) {
        }
        com.byazt.vhv.qg qgVar = this.ou;
        if (qgVar == null || (sVar = this.oa) == null || this.rv == null) {
            return;
        }
        sVar.n(qgVar);
        this.ou.w();
    }

    private void cd() {
        if (this.oa == null || ((ViewGroup) this.s.getParent()) == null) {
            return;
        }
        this.oa.n(new ln(this.s, this.oa, this.rv));
    }

    @Override // com.byazt.gjp.n
    public void fs() {
        com.byazt.ot.n nVarS = com.byazt.vyf.s.cy().s();
        this.hd = nVarS;
        nVarS.n(this);
    }

    @Override // com.byazt.gjp.n
    public void rv() {
        super.rv();
        com.byazt.ot.n nVar = this.hd;
        if (nVar != null) {
            nVar.qg(this);
        }
    }

    @Override // com.byazt.gjp.n
    public void l() {
        com.byazt.gcl.s sVar = this.oa;
        if (sVar == null) {
            return;
        }
        sVar.qg("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.byazt.gjp.n, com.byazt.za.k
    public void qg(final int i) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.za.bb.3
            @Override // java.lang.Runnable
            public void run() {
                bb.this.s(i);
                bb.this.q(i);
                if (i == bb.this.sz) {
                    return;
                }
                bb.this.sz = i;
                bb.this.l(i == 0);
                bb.this.um();
            }
        });
    }

    public void s(final boolean z) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.za.bb.4
            @Override // java.lang.Runnable
            public void run() {
                bb.this.k = z;
                bb.this.um();
            }
        });
    }

    public void q(final boolean z) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.za.bb.5
            @Override // java.lang.Runnable
            public void run() {
                boolean z2 = bb.this.cy;
                boolean z3 = z;
                if (z2 != (!z3)) {
                    bb.this.cy = !z3;
                    bb.this.um();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        com.byazt.ew.fs fsVar = this.cd;
        if (fsVar == null) {
            return;
        }
        if (i == 0) {
            fsVar.qg(true);
            this.cd.n(false);
        } else {
            fsVar.qg(false);
            this.cd.n(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z) {
        if (this.oa == null || this.s == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.oa.qg("expressAdShow", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.za.cy
    public com.byazt.gcl.s x_() {
        return this.oa;
    }

    @Override // com.byazt.hne.n
    public void b_(int i) {
        if (this.oa == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException unused) {
        }
        this.oa.qg("themeChange", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i) {
        try {
            if (com.byazt.nf.tj.n() && i == 0) {
                long jRg = com.byazt.nf.rv.qg().rg();
                if (this.wm != -1 && System.currentTimeMillis() - this.wm > jRg) {
                    SSWebView sSWebViewN = n();
                    WebView webView = sSWebViewN.getWebView();
                    sSWebViewN.removeView(webView);
                    sSWebViewN.addView(webView);
                }
                this.wm = -1L;
                return;
            }
            this.wm = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gjp.n
    public void n(float f, float f2) {
        float f3 = this.x.getResources().getDisplayMetrics().density;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        super.n(com.byazt.okk.s.qg(f3, com.byazt.okk.s.n(f4, f)), com.byazt.okk.s.qg(f3, com.byazt.okk.s.n(f4, f2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void um() {
        com.byazt.sn.n.n(this.oa, this.sz == 0, this.k, this.cy);
    }

    public void n(com.byazt.mkl.n nVar) {
        com.byazt.vhv.qg qgVar = this.ou;
        if (qgVar != null) {
            qgVar.n(nVar);
        }
    }

    public void k() {
        com.byazt.vhv.qg qgVar = this.ou;
        if (qgVar != null) {
            qgVar.rv();
            this.ou = null;
        }
        com.byazt.cv.n nVar = this.m;
        if (nVar != null) {
            nVar.qg();
            this.m = null;
        }
    }
}
