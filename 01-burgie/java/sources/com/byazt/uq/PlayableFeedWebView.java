package com.byazt.uq;

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
import com.byazt.ca.ho;
import com.byazt.fj.SSWebView;
import com.byazt.hg.b;
import com.byazt.hg.nt;
import com.byazt.hg.of;
import com.byazt.mq.g;
import com.byazt.qx.iu;
import com.byazt.sd.a;
import com.byazt.sd.nl;
import com.byazt.wt.cz;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.tapsdk.tapad.group.constants.Constants;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 209, 906})
public class PlayableFeedWebView extends SSWebView implements com.byazt.son.hn.pr, aj, com.byazt.fq.hw {
    public nt a;
    public nt aj;
    public final Context c;
    public double cz;
    public final of fw;
    public int g;
    public final Runnable ho;
    public com.byazt.uq.pr k;
    public com.byazt.mq.w lb;
    public boolean m;
    public final Runnable nt;
    public nt qa;
    public nl uc;
    public final ViewGroup vk;
    public boolean w;
    public com.byazt.eq.zo yb;
    public com.byazt.fq.pr zo;

    public nl getJsObject() {
        return this.uc;
    }

    public void uc() {
        this.m = true;
        nl nlVar = this.uc;
        if (nlVar != null) {
            nlVar.e();
        }
    }

    public PlayableFeedWebView(com.byazt.fq.pr prVar, ViewGroup viewGroup) {
        super(prVar.getContext());
        this.w = false;
        this.m = false;
        this.g = 8;
        this.ho = new Runnable() { // from class: com.byazt.uq.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.hw(0);
            }
        };
        this.nt = new Runnable() { // from class: com.byazt.uq.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.hw(8);
            }
        };
        this.lb = new com.byazt.mq.w() { // from class: com.byazt.uq.PlayableFeedWebView.3
            @Override // com.byazt.mq.w
            public void pr(g gVar) {
            }

            @Override // com.byazt.mq.w
            public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(PlayableFeedWebView.this.fw));
                PlayableFeedWebView.this.k.pr(view, i, hnVar, i2);
            }

            @Override // com.byazt.mq.w
            public void hw(View view, int i, com.byazt.dj.hn hnVar, int i2) {
            }
        };
        this.zo = prVar;
        this.c = prVar.getContext();
        this.fw = prVar.pr();
        this.vk = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        pr(Integer.MIN_VALUE, Integer.MIN_VALUE, this.vk.getWidth(), this.vk.getHeight());
        vk();
        aj();
        w();
        loadUrl(b.zo(this.fw).pr(this.vk.getWidth() <= this.vk.getHeight()));
        setExpressVideoListener(this.k);
    }

    private void aj() {
        com.byazt.ns.hn hnVar = new com.byazt.ns.hn();
        com.byazt.ns.c cVar = new com.byazt.ns.c(this.uc);
        com.byazt.ns.x xVar = new com.byazt.ns.x();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.byazt.eq.zo zoVarHn = hnVar.pr(a.getContext(), this, cVar, xVar, hashSet, com.byazt.eq.zo.pr.OTHER).c(getUrl()).x(com.byazt.hb.pr.zo()).pr(com.byazt.hb.pr.pr()).pr("sdkEdition", com.byazt.hb.pr.hn()).hw(com.byazt.hb.pr.uc()).hn(com.byazt.hb.pr.c()).hn(false);
        this.yb = zoVarHn;
        Set<String> setVk = zoVarHn.vk();
        if (this.uc == null || setVk == null || setVk.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.yb);
        Iterator<String> it = setVk.iterator();
        while (it.hasNext()) {
            this.uc.uc().pr(it.next(), (com.byazt.ee.c<?, ?>) new com.byazt.ee.c<JSONObject, JSONObject>() { // from class: com.byazt.uq.PlayableFeedWebView.4
                @Override // com.byazt.ee.c
                public JSONObject pr(JSONObject jSONObject, com.byazt.ee.uc ucVar) throws Exception {
                    try {
                        com.byazt.eq.zo zoVar = (com.byazt.eq.zo) weakReference.get();
                        if (zoVar == null) {
                            return null;
                        }
                        return zoVar.x(pr(), jSONObject);
                    } catch (Throwable th) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.byazt.fj.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.byazt.fj.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.byazt.uq.aj
    public void x() {
        com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(this.fw));
        com.byazt.uq.pr prVar = this.k;
        if (prVar != null) {
            prVar.pr((View) this);
        }
    }

    @Override // com.byazt.uq.aj
    public void hn() {
        if (this.zo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.ERROR_CODE_FIELD, 1);
            } catch (JSONException e) {
                e.getMessage();
            }
            this.zo.pr(false, jSONObject);
        }
    }

    @Override // com.byazt.uq.aj
    public void setEasyPlayInteractionAreaInfo(nt ntVar) {
        this.a = ntVar;
    }

    @Override // com.byazt.fq.hw
    public JSONObject getMaxRectJson() {
        return nt.pr(this.qa);
    }

    @Override // com.byazt.fq.hw
    public JSONObject getActualRectJson() {
        return nt.pr(this.a);
    }

    @Override // com.byazt.fq.hw
    public double getExceedAreaRate() {
        return this.cz;
    }

    @Override // com.byazt.uq.aj
    public void pr(nt ntVar, double d) {
        this.qa = ntVar;
        this.cz = d;
        this.aj = ntVar;
    }

    @Override // com.byazt.uq.aj
    public void hw() {
        com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(this.fw), 1);
        com.byazt.fq.pr prVar = this.zo;
        if (prVar != null) {
            prVar.hn();
        }
    }

    @Override // com.byazt.uq.aj
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.byazt.fq.pr prVar = this.zo;
        if (prVar != null) {
            return prVar.hw();
        }
        return null;
    }

    @Override // com.byazt.uq.aj
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.vk.getLeft();
            int top = this.vk.getTop();
            jSONArray.put(0, er.x(getContext(), left));
            jSONArray.put(1, er.x(getContext(), top));
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.vk.getMeasuredWidth();
            int measuredHeight = this.vk.getMeasuredHeight();
            jSONArray2.put(0, er.x(getContext(), measuredWidth));
            jSONArray2.put(1, er.x(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            ho.hw("xeasy", e.getMessage());
            return null;
        }
    }

    @Override // com.byazt.uq.aj
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.byazt.uq.aj
    public boolean Q_() {
        return this.m;
    }

    public void fw() {
        if (!this.w) {
            this.w = true;
            postDelayed(new Runnable() { // from class: com.byazt.uq.PlayableFeedWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    PlayableFeedWebView.this.update();
                }
            }, 100L);
        }
    }

    public void zo() {
        hw(false);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        hw(i == 0);
    }

    @Override // com.byazt.fj.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        hw(z);
    }

    @Override // com.byazt.uq.aj
    public void pr(final int i, final int i2, final int i3, final int i4) {
        com.byazt.zp.zo.pr((Runnable) new com.byazt.xlm.fw("changeFrame") { // from class: com.byazt.uq.PlayableFeedWebView.6
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

    private void vk() {
        nl nlVar = new nl(this.c);
        this.uc = nlVar;
        nlVar.hw(this).pr(this.fw).hw(this.fw.x()).x(this.fw.B_()).pr(ls.hw(this.fw)).c(ls.a(this.fw)).pr((aj) this).x(com.byazt.hc.hw.pr(0.0f, 0.0f, false, this.fw, true)).pr(this.lb).pr((SSWebView) this);
    }

    private void w() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        pr((SSWebView) this);
        if (this.fw != null) {
            Context context = this.c;
            nl nlVar = this.uc;
            of ofVar = this.fw;
            setWebViewClient(new pr(context, nlVar, ofVar, ofVar.x()));
        }
        com.byazt.kq.c.pr().pr(this, this.uc);
        setWebChromeClient(new com.byazt.lz.hn(this.uc));
    }

    @Override // com.byazt.uq.aj
    public void R_() {
        if (this.uc == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new iu(this, this.uc, this.fw));
        if (this.zo != null) {
            this.zo.pr(true, getMaxRectJson());
        }
        hw(getVisibility());
    }

    private void pr(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.byazt.lz.hw.pr(this.c).pr(false).pr(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            cz.pr(sSWebView, com.byazt.sd.iu.x, of.c(this.fw));
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
            ho.hw("xeasy", e.toString());
        }
    }

    @Override // com.byazt.su.BizWebView, com.byazt.son.x
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void hw(boolean z) {
        nl nlVar = this.uc;
        if (nlVar != null) {
            nlVar.w(z);
        }
    }

    public void setExpressVideoListener(com.byazt.qx.w wVar) {
        nl nlVar = this.uc;
        if (nlVar != null) {
            nlVar.pr(wVar);
        }
    }

    public void setEasyPlayableListener(com.byazt.uq.pr prVar) {
        this.k = prVar;
    }

    @Override // com.byazt.son.hn.pr
    public Pair<Boolean, Boolean> pr(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iX = er.x(getContext(), x);
                int iX2 = er.x(getContext(), y);
                nt ntVar = this.aj;
                if (ntVar != null && !ntVar.pr(iX, iX2)) {
                    com.byazt.fq.pr prVar = this.zo;
                    if (prVar != null) {
                        prVar.pr(this.fw, iX, iX2, 2);
                    }
                    return new Pair<>(Boolean.TRUE, Boolean.FALSE);
                }
                return null;
            default:
                return null;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 209, 1546})
    public static class pr extends com.byazt.lz.x {
        public of pr;

        public pr(Context context, nl nlVar, of ofVar, String str) {
            super(context, nlVar, str);
            this.pr = ofVar;
        }

        @Override // com.byazt.lz.x, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.byazt.ce.pr prVarPr = com.byazt.hc.pr.pr(webView, this.pr, str, new com.byazt.hc.pr.InterfaceC0083pr() { // from class: com.byazt.uq.PlayableFeedWebView.pr.1
                    @Override // com.byazt.hc.pr.InterfaceC0083pr
                    public com.byazt.ce.pr pr(String str2, com.byazt.js.vk.pr prVar, String str3) {
                        com.byazt.ce.pr prVar2 = new com.byazt.ce.pr();
                        prVar2.pr(5);
                        prVar2.pr(com.byazt.hn.hw.hw().pr(webView, prVar, str2));
                        return prVar2;
                    }

                    @Override // com.byazt.hc.pr.InterfaceC0083pr
                    public boolean pr() {
                        return false;
                    }
                });
                if (prVarPr != null && prVarPr.pr() != null) {
                    return prVarPr.pr();
                }
            } catch (Throwable th) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.byazt.lz.x, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                ho.pr("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.nt);
        removeCallbacks(this.ho);
        if (i == 0) {
            postDelayed(this.ho, 50L);
        } else {
            postDelayed(this.nt, 50L);
        }
    }

    public void hw(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        if (this.uc != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adVisible", i == 0);
                this.uc.hw("expressAdShow", jSONObject);
            } catch (Exception e) {
            }
        }
        com.byazt.lr.pr.pr(this.uc, i == 0, true, true);
    }

    @Override // com.byazt.fj.SSWebView, com.byazt.su.BizWebView, com.byazt.su.MultiWebview, com.byazt.son.x
    public void destroy() {
        this.k = null;
        U_();
        setOnShakeListener(null);
        nl nlVar = this.uc;
        if (nlVar != null) {
            nlVar.c();
            this.uc.pr((SSWebView.hw) null);
        }
        this.uc = null;
        super.destroy();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(this.fw), 2);
    }
}
