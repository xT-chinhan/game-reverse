package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

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
import com.bytedance.sdk.component.adexpress.xr.u;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.t;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.ao;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.op;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.re;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PlayableFeedWebView extends SSWebView implements com.bytedance.sdk.component.zb.xr.ms, com.bytedance.sdk.openadsdk.core.b.ah, ny {
    private final lm ab;
    private final Runnable ao;
    private pc c;
    private final ViewGroup ch;
    private com.bytedance.sdk.openadsdk.u.x h;
    private boolean hi;
    private final Context ka;
    private double nw;
    private ao ny;
    private com.bytedance.sdk.component.adexpress.xr.hi qv;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms sl;
    private ao t;
    private int u;
    private final Runnable ub;
    private com.bytedance.sdk.openadsdk.core.b.xr x;
    private ao y;
    private boolean zb;

    public pc getJsObject() {
        return this.c;
    }

    public void c() {
        this.zb = true;
        pc pcVar = this.c;
        if (pcVar != null) {
            pcVar.of();
        }
    }

    public PlayableFeedWebView(com.bytedance.sdk.openadsdk.core.b.xr xrVar, ViewGroup viewGroup) {
        super(xrVar.getContext());
        this.hi = false;
        this.zb = false;
        this.u = 8;
        this.ub = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.1
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.xr(0);
            }
        };
        this.ao = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.2
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.xr(8);
            }
        };
        this.qv = new com.bytedance.sdk.component.adexpress.xr.hi() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.3
            @Override // com.bytedance.sdk.component.adexpress.xr.hi
            public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, int i2) {
            }

            @Override // com.bytedance.sdk.component.adexpress.xr.hi
            public void ms(u uVar) {
            }

            @Override // com.bytedance.sdk.component.adexpress.xr.hi
            public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar) {
                PlayableFeedWebView.this.sl.xr(view, i, ahVar);
            }
        };
        this.x = xrVar;
        this.ka = xrVar.getContext();
        this.ab = xrVar.ms();
        this.ch = viewGroup;
        setVisibility(4);
        setTag("easy_pfwv");
        setTouchEventListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void update() {
        ms(Integer.MIN_VALUE, Integer.MIN_VALUE, this.ch.getWidth(), this.ch.getHeight());
        ch();
        ny();
        hi();
        loadUrl(op.ka(this.ab).ms(this.ch.getWidth() <= this.ch.getHeight()));
        setExpressVideoListener(this.sl);
    }

    private void ny() {
        com.bytedance.sdk.openadsdk.core.y.ah ahVar = new com.bytedance.sdk.openadsdk.core.y.ah();
        com.bytedance.sdk.openadsdk.core.y.ka kaVar = new com.bytedance.sdk.openadsdk.core.y.ka(this.c);
        com.bytedance.sdk.openadsdk.core.y.d dVar = new com.bytedance.sdk.openadsdk.core.y.d();
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        com.bytedance.sdk.openadsdk.u.x xVarAh = ahVar.ms(re.getContext(), this, kaVar, dVar, hashSet, com.bytedance.sdk.openadsdk.u.x.ms.OTHER).ka(getUrl()).d(com.bytedance.sdk.openadsdk.core.x.ms.ab()).ms(com.bytedance.sdk.openadsdk.core.x.ms.ms()).ms("sdkEdition", com.bytedance.sdk.openadsdk.core.x.ms.ah()).xr(com.bytedance.sdk.openadsdk.core.x.ms.ka()).ah(com.bytedance.sdk.openadsdk.core.x.ms.d()).ah(false);
        this.h = xVarAh;
        Set<String> setCh = xVarAh.ch();
        if (this.c == null || setCh == null || setCh.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.h);
        Iterator<String> it = setCh.iterator();
        while (it.hasNext()) {
            this.c.c().ms(it.next(), (com.bytedance.sdk.component.ms.ka<?, ?>) new com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.4
                @Override // com.bytedance.sdk.component.ms.ka
                public JSONObject ms(JSONObject jSONObject, com.bytedance.sdk.component.ms.c cVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.u.x xVar = (com.bytedance.sdk.openadsdk.u.x) weakReference.get();
                        if (xVar == null) {
                            return null;
                        }
                        return xVar.d(ms(), jSONObject);
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public void d() {
        com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms msVar = this.sl;
        if (msVar != null) {
            msVar.ms((View) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public void ah() {
        if (this.x != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", 1);
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.xr("xeasy", e.getMessage());
            }
            this.x.ms(false, jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public void setEasyPlayInteractionAreaInfo(ao aoVar) {
        this.t = aoVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.ah
    public JSONObject getMaxRectJson() {
        return ao.ms(this.y);
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.ah
    public JSONObject getActualRectJson() {
        return ao.ms(this.t);
    }

    @Override // com.bytedance.sdk.openadsdk.core.b.ah
    public double getExceedAreaRate() {
        return this.nw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public void ms(ao aoVar, double d) {
        this.y = aoVar;
        this.nw = d;
        this.ny = aoVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public void xr() {
        com.bytedance.sdk.openadsdk.core.b.xr xrVar = this.x;
        if (xrVar != null) {
            xrVar.ah();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public JSONObject getEstimatedInteractionAreaInfo() {
        com.bytedance.sdk.openadsdk.core.b.xr xrVar = this.x;
        if (xrVar != null) {
            return xrVar.xr();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public JSONObject getContainerInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            int left = this.ch.getLeft();
            int top = this.ch.getTop();
            jSONArray.put(0, ul.d(getContext(), left));
            jSONArray.put(1, ul.d(getContext(), top));
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int measuredWidth = this.ch.getMeasuredWidth();
            int measuredHeight = this.ch.getMeasuredHeight();
            jSONArray2.put(0, ul.d(getContext(), measuredWidth));
            jSONArray2.put(1, ul.d(getContext(), measuredHeight));
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.d("xeasy", e.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public JSONObject getCreativeVideoViewInfo() {
        return new JSONObject();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public boolean F_() {
        return this.zb;
    }

    public void ab() {
        if (this.hi) {
            return;
        }
        this.hi = true;
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.5
            @Override // java.lang.Runnable
            public void run() {
                PlayableFeedWebView.this.update();
            }
        }, 100L);
    }

    public void x() {
        ms(false);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        ms(i == 0);
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ms(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public void ms(final int i, final int i2, final int i3, final int i4) {
        com.bytedance.sdk.openadsdk.op.ab.ms((Runnable) new com.bytedance.sdk.component.ch.ny("changeFrame") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.6
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

    private void ch() {
        pc pcVar = new pc(this.ka);
        this.c = pcVar;
        pcVar.xr(this).ms(this.ab).xr(this.ab.df()).ah(this.ab.lx()).ms(f.xr(this.ab)).d(f.ao(this.ab)).ms((ny) this).c(com.bytedance.sdk.openadsdk.core.nativeexpress.xr.xr.ms(0.0f, 0.0f, false, this.ab)).ms(this.qv).ms((SSWebView) this);
    }

    private void hi() {
        setBackgroundColor(0);
        setBackgroundResource(R.color.transparent);
        ms((SSWebView) this);
        if (this.ab != null) {
            Context context = this.ka;
            pc pcVar = this.c;
            lm lmVar = this.ab;
            setWebViewClient(new ms(context, pcVar, lmVar, lmVar.df()));
        }
        com.bytedance.sdk.component.adexpress.ka.ka.ms().ms(this, this.c);
        setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.c));
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ny
    public void G_() {
        if (this.c == null || ((ViewGroup) getParent()) == null) {
            return;
        }
        setOnShakeListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.op(this, this.c, this.ab));
        if (this.x != null) {
            this.x.ms(true, getMaxRectJson());
        }
        xr(getVisibility());
    }

    private void ms(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.ka).ms(false).ms(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            t.ms(sSWebView, g.xr, lm.d(this.ab));
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
            com.bytedance.sdk.component.utils.sl.d("xeasy", e.toString());
        }
    }

    @Override // com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.zb.ah
    public void loadUrl(String str) {
        super.loadUrl(str);
    }

    public void ms(boolean z) {
        pc pcVar = this.c;
        if (pcVar != null) {
            pcVar.hi(z);
        }
    }

    public void setExpressVideoListener(com.bytedance.sdk.openadsdk.core.nativeexpress.hi hiVar) {
        pc pcVar = this.c;
        if (pcVar != null) {
            pcVar.ms(hiVar);
        }
    }

    public void setEasyPlayableListener(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.ms msVar) {
        this.sl = msVar;
    }

    @Override // com.bytedance.sdk.component.zb.xr.ms
    public Pair<Boolean, Boolean> ms(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int iD = ul.d(getContext(), x);
        int iD2 = ul.d(getContext(), y);
        ao aoVar = this.ny;
        if (aoVar == null || aoVar.ms(iD, iD2)) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.b.xr.ms(this.ab, iD, iD2, 2);
        return new Pair<>(Boolean.TRUE, Boolean.FALSE);
    }

    public static class ms extends com.bytedance.sdk.openadsdk.core.widget.ms.d {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private lm f3443ms;

        public ms(Context context, pc pcVar, lm lmVar, String str) {
            super(context, pcVar, str);
            this.f3443ms = lmVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(final WebView webView, String str) {
            try {
                com.bytedance.sdk.component.adexpress.ms.xr.ms msVarMs = com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.ms(webView, this.f3443ms, str, new com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.PlayableFeedWebView.ms.1
                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms
                    public boolean ms() {
                        return false;
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xr.ms.InterfaceC0297ms
                    public com.bytedance.sdk.component.adexpress.ms.xr.ms ms(String str2, com.bytedance.sdk.component.adexpress.d.ch.ms msVar, String str3) {
                        com.bytedance.sdk.component.adexpress.ms.xr.ms msVar2 = new com.bytedance.sdk.component.adexpress.ms.xr.ms();
                        msVar2.ms(5);
                        msVar2.ms(com.bytedance.sdk.openadsdk.core.ugeno.ka.ms.xr().ms(webView, msVar, str2));
                        return msVar2;
                    }
                });
                if (msVarMs != null && msVarMs.ms() != null) {
                    return msVarMs.ms();
                }
            } catch (Throwable unused) {
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @Override // com.bytedance.sdk.openadsdk.core.widget.ms.d, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            try {
                return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.sl.ah("xeasy", "shouldInterceptRequest error1", th);
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        removeCallbacks(this.ao);
        removeCallbacks(this.ub);
        if (i == 0) {
            postDelayed(this.ub, 50L);
        } else {
            postDelayed(this.ao, 50L);
        }
    }

    public void xr(int i) {
        if (i == this.u) {
            return;
        }
        this.u = i;
        if (this.c == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", i == 0);
            this.c.ms("expressAdShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.component.widget.SSWebView, com.bytedance.sdk.component.widget.web.BizWebView, com.bytedance.sdk.component.widget.web.MultiWebview, com.bytedance.sdk.component.zb.ah
    public void destroy() {
        this.sl = null;
        J_();
        setOnShakeListener(null);
        pc pcVar = this.c;
        if (pcVar != null) {
            pcVar.ka();
            this.c.ms((SSWebView.xr) null);
        }
        this.c = null;
        super.destroy();
    }
}
