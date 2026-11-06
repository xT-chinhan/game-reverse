package com.byazt.rg;

import android.R;
import android.content.Context;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.byazt.gct.cy;
import com.byazt.gct.h;
import com.byazt.gct.pk;
import com.byazt.kfh.SSWebView;
import com.byazt.tk.k;
import com.byazt.udb.cp;
import com.byazt.udb.sz;
import com.byazt.za.d;
import com.byazt.za.ln;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_PATH_INFO})
public class PlayableFeedWebView extends SSWebView implements com.byazt.uad.s.n, com.byazt.whi.qg, x {
    public cy a;
    public cp cd;
    public boolean cp;
    public final Runnable cy;
    public com.byazt.rg.n d;
    public com.byazt.whi.n fs;
    public com.byazt.ew.fs hd;
    public final Runnable k;
    public final Context l;
    public boolean oa;
    public double py;
    public cy rv;
    public int sz;
    public final ViewGroup tj;
    public cy um;
    public com.byazt.gcl.s w;
    public final pk x;

    public com.byazt.gcl.s getJsObject() {
        return this.w;
    }

    public void w() {
        this.oa = true;
        com.byazt.gcl.s sVar = this.w;
        if (sVar != null) {
            sVar.an();
        }
    }

    public PlayableFeedWebView(com.byazt.whi.n nVar, ViewGroup viewGroup) {
        super(nVar.getContext());
        this.cp = false;
        this.oa = false;
        this.sz = 8;
        this.k = new Runnable() { // from class: com.byazt.rg.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.qg(0);
            }
        };
        this.cy = new Runnable() { // from class: com.byazt.rg.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.qg(8);
            }
        };
        this.cd = new cp() { // from class: com.byazt.rg.PlayableFeedWebView.3
            @Override // com.byazt.udb.cp
            public void n(sz szVar) {
            }

            @Override // com.byazt.udb.cp
            public void qg(View view, int i, com.byazt.twc.s sVar, int i2) {
            }

            @Override // com.byazt.udb.cp
            public void n(View view, int i, com.byazt.twc.s sVar, int i2) {
                com.byazt.de.w.q(com.byazt.de.x.n(PlayableFeedWebView.this.x));
                PlayableFeedWebView.this.d.n(view, i, sVar, i2);
            }
        };
        this.fs = nVar;
        this.l = nVar.getContext();
        this.x = nVar.qg();
        this.tj = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        n(Integer.MIN_VALUE, Integer.MIN_VALUE, this.tj.getWidth(), this.tj.getHeight());
        tj();
        rv();
        cp();
        loadUrl(h.rv(this.x).n(this.tj.getWidth() <= this.tj.getHeight()));
        setExpressVideoListener(this.d);
    }

    private void rv() {
        com.byazt.pb.n nVar = new com.byazt.pb.n();
        com.byazt.pb.s sVar = new com.byazt.pb.s(this.w);
        com.byazt.pb.qg qgVar = new com.byazt.pb.qg();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.byazt.ew.fs fsVarS = nVar.n(com.byazt.nf.rv.getContext(), this, sVar, qgVar, hashSet, com.byazt.ew.fs.n.OTHER).l(getUrl()).q(com.byazt.ges.qg.fs()).n(com.byazt.ges.qg.n()).n("sdkEdition", com.byazt.ges.qg.s()).qg(com.byazt.ges.qg.w()).s(com.byazt.ges.qg.l()).s(false);
        this.hd = fsVarS;
        Set<String> setTj = fsVarS.tj();
        if (this.w == null || setTj == null || setTj.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.hd);
        Iterator<String> it = setTj.iterator();
        while (it.hasNext()) {
            this.w.w().n(it.next(), (com.byazt.cf.l<?, ?>) new com.byazt.cf.l<JSONObject, JSONObject>() { // from class: com.byazt.rg.PlayableFeedWebView.4
                @Override // com.byazt.cf.l
                public JSONObject n(JSONObject jSONObject, com.byazt.cf.w wVar) throws Exception {
                    try {
                        com.byazt.ew.fs fsVar = (com.byazt.ew.fs) weakReference.get();
                        if (fsVar == null) {
                            return null;
                        }
                        return fsVar.q(n(), jSONObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.byazt.kfh.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.byazt.kfh.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.byazt.rg.x
    public void q() {
        com.byazt.de.w.q(com.byazt.de.x.n(this.x));
        com.byazt.rg.n nVar = this.d;
        if (nVar != null) {
            nVar.n((View) this);
        }
    }

    @Override // com.byazt.rg.x
    public void s() {
        com.byazt.whi.n nVar = this.fs;
        if (nVar != null) {
            nVar.q();
        }
    }

    @Override // com.byazt.rg.x
    public void setEasyPlayInteractionAreaInfo(cy cyVar) {
        this.a = cyVar;
    }

    @Override // com.byazt.whi.qg
    public JSONObject getMaxRectJson() {
        return cy.n(this.um);
    }

    @Override // com.byazt.whi.qg
    public JSONObject getActualRectJson() {
        return cy.n(this.a);
    }

    @Override // com.byazt.whi.qg
    public double getExceedAreaRate() {
        return this.py;
    }

    @Override // com.byazt.rg.x
    public void n(cy cyVar, double d) {
        this.um = cyVar;
        this.py = d;
        this.rv = cyVar;
    }

    @Override // com.byazt.rg.x
    public void qg() {
        com.byazt.de.w.q(com.byazt.de.x.n(this.x), 1);
        com.byazt.whi.n nVar = this.fs;
        if (nVar != null) {
            nVar.l();
        }
    }

    @Override // com.byazt.rg.x
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.byazt.whi.n nVar = this.fs;
        if (nVar != null) {
            return nVar.s();
        }
        return null;
    }

    @Override // com.byazt.rg.x
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.tj.getLeft();
            int top = this.tj.getTop();
            jSONArray.put(0, com.byazt.okk.s.q(getContext(), left));
            jSONArray.put(1, com.byazt.okk.s.q(getContext(), top));
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.tj.getMeasuredWidth();
            int measuredHeight = this.tj.getMeasuredHeight();
            jSONArray2.put(0, com.byazt.okk.s.q(getContext(), measuredWidth));
            jSONArray2.put(1, com.byazt.okk.s.q(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            k.qg("xeasy", e.getMessage());
            return null;
        }
    }

    @Override // com.byazt.rg.x
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.byazt.rg.x
    public boolean Q_() {
        return this.oa;
    }

    public void x() {
        if (this.cp) {
            return;
        }
        this.cp = true;
        postDelayed(new Runnable() { // from class: com.byazt.rg.PlayableFeedWebView.5
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.update();
            }
        }, 100L);
    }

    public void fs() {
        qg(false);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        qg(i == 0);
    }

    @Override // com.byazt.kfh.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        qg(z);
    }

    @Override // com.byazt.rg.x
    public void n(final int i, final int i2, final int i3, final int i4) {
        com.byazt.ag.qg.n((Runnable) new com.byazt.qit.x("changeFrame") { // from class: com.byazt.rg.PlayableFeedWebView.6
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
                if (i == Integer.MIN_VALUE && i2 == Integer.MIN_VALUE) {
                    layoutParams.gravity = 17;
                }
                int i5 = i;
                if (i5 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationX(i5);
                }
                int i6 = i2;
                if (i6 != Integer.MIN_VALUE) {
                    PlayableFeedWebView.this.setTranslationY(i6);
                }
                PlayableFeedWebView.this.setLayoutParams(layoutParams);
            }
        });
    }

    private void tj() {
        com.byazt.gcl.s sVar = new com.byazt.gcl.s(this.l);
        this.w = sVar;
        sVar.qg(this).n(this.x).qg(this.x.q()).q(this.x.F_()).n(com.byazt.vgx.w.qg(this.x)).l(com.byazt.vgx.w.wm(this.x)).n((x) this).q(com.byazt.ns.qg.n(0.0f, 0.0f, false, this.x, true)).n(this.cd).n((SSWebView) this);
    }

    private void cp() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        n((SSWebView) this);
        if (this.x != null) {
            Context context = this.l;
            com.byazt.gcl.s sVar = this.w;
            pk pkVar = this.x;
            setWebViewClient(new n(context, sVar, pkVar, pkVar.q()));
        }
        com.byazt.gjp.l.n().n(this, this.w);
        setWebChromeClient(new com.byazt.dho.qg(this.w));
    }

    @Override // com.byazt.rg.x
    public void R_() {
        if (this.w == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new ln(this, this.w, this.x));
        if (this.fs != null) {
            this.fs.n(getMaxRectJson());
        }
        qg(getVisibility());
    }

    private void n(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.dho.n.n(this.l).n(false).n(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            com.byazt.qq.n.n(sSWebView, com.byazt.nf.tj.l, pk.l(this.x));
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
            k.qg("xeasy", e.toString());
        }
    }

    @Override // com.byazt.qza.BizWebView, com.byazt.uad.q
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void qg(boolean z) {
        com.byazt.gcl.s sVar = this.w;
        if (sVar != null) {
            sVar.cp(z);
        }
    }

    public void setExpressVideoListener(d dVar) {
        com.byazt.gcl.s sVar = this.w;
        if (sVar != null) {
            sVar.n(dVar);
        }
    }

    public void setEasyPlayableListener(com.byazt.rg.n nVar) {
        this.d = nVar;
    }

    @Override // com.byazt.uad.s.n
    public Pair<Boolean, Boolean> n(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int iQ = com.byazt.okk.s.q(getContext(), x);
        int iQ2 = com.byazt.okk.s.q(getContext(), y);
        cy cyVar = this.rv;
        if (cyVar == null || cyVar.n(iQ, iQ2)) {
            return null;
        }
        com.byazt.whi.n nVar = this.fs;
        if (nVar != null) {
            nVar.n(this.x, iQ, iQ2, 2);
        }
        return new Pair<>(Boolean.TRUE, Boolean.FALSE);
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 1258})
    public static class n extends com.byazt.dho.s {
        public pk n;

        public n(Context context, com.byazt.gcl.s sVar, pk pkVar, String str) {
            super(context, sVar, str);
            this.n = pkVar;
        }

        @Override // com.byazt.dho.s, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.byazt.mzw.n nVarN = com.byazt.lu.n.n(webView, this.n, str, new com.byazt.lu.n.InterfaceC0242n() { // from class: com.byazt.rg.PlayableFeedWebView.n.1
                    @Override // com.byazt.lu.n.InterfaceC0242n
                    public boolean n() {
                        return false;
                    }

                    @Override // com.byazt.lu.n.InterfaceC0242n
                    public com.byazt.mzw.n n(String str2, com.byazt.cq.tj.n nVar, String str3) {
                        com.byazt.mzw.n nVar2 = new com.byazt.mzw.n();
                        nVar2.n(5);
                        nVar2.n(com.byazt.cr.qg.qg().n(webView, nVar, str2));
                        return nVar2;
                    }
                });
                if (nVarN != null && nVarN.n() != null) {
                    return nVarN.n();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.byazt.dho.s, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                k.n("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.cy);
        removeCallbacks(this.k);
        if (i == 0) {
            postDelayed(this.k, 50L);
        } else {
            postDelayed(this.cy, 50L);
        }
    }

    public void qg(int i) {
        if (i == this.sz) {
            return;
        }
        this.sz = i;
        if (this.w != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adVisible", i == 0);
                this.w.qg("expressAdShow", jSONObject);
            } catch (Exception unused) {
            }
        }
        com.byazt.sn.n.n(this.w, i == 0, true, true);
    }

    @Override // com.byazt.kfh.SSWebView, com.byazt.qza.BizWebView, com.byazt.qza.MultiWebview, com.byazt.uad.q
    public void destroy() {
        this.d = null;
        U_();
        setOnShakeListener(null);
        com.byazt.gcl.s sVar = this.w;
        if (sVar != null) {
            sVar.l();
            this.w.n((SSWebView.qg) null);
        }
        this.w = null;
        super.destroy();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.de.w.q(com.byazt.de.x.n(this.x), 2);
    }
}
