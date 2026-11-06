package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.jw;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
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
public class yu extends com.bytedance.sdk.component.adexpress.ka.ms implements u, ub {
    private String ab;
    private com.bytedance.sdk.openadsdk.u.x ao;
    private Context c;
    private String ch;
    private ab h;
    private com.bytedance.sdk.openadsdk.core.zb.d hi;
    private com.bytedance.sdk.openadsdk.c.ms ny;
    private com.bytedance.sdk.component.adexpress.xr.ny qv;
    private final Map<String, com.bytedance.sdk.openadsdk.core.hi.xr.ah> sl;
    private int u;
    private com.bytedance.sdk.openadsdk.core.jw.ms ub;
    private lm x;
    private long y;
    private pc zb;

    public yu(Context context, com.bytedance.sdk.component.adexpress.xr.zb zbVar, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.openadsdk.c.ms msVar, lm lmVar, com.bytedance.sdk.component.adexpress.xr.ny nyVar) {
        super(context, zbVar, themeStatusBroadcastReceiver);
        this.sl = Collections.synchronizedMap(new HashMap());
        this.u = 8;
        this.y = -1L;
        this.c = context;
        this.ab = zbVar.c();
        this.x = lmVar;
        this.ny = msVar;
        this.f885ms = zbVar.ka();
        String strMs = ms(lmVar);
        this.ch = strMs;
        this.qv = nyVar;
        ms(jw.xr(strMs));
        themeStatusBroadcastReceiver.ms(this);
        sl();
        zb();
        u();
    }

    public static String ms(lm lmVar) {
        return com.bytedance.sdk.component.adexpress.ms.xr.xr.xr((lmVar == null || !lmVar.na()) ? null : "v3");
    }

    public static void ms(Map<String, Object> map, lm lmVar, NativeExpressView nativeExpressView) {
        try {
            map.put("dynamic_show_type", Integer.valueOf(nativeExpressView.getDynamicShowType()));
            int renderEngineCacheType = nativeExpressView.getRenderEngineCacheType();
            if (lmVar != null && lmVar.si() != null && !TextUtils.isEmpty(lmVar.si().hi())) {
                map.put("engine_version", lmVar.si().hi());
            }
            map.put("engine_type", Integer.valueOf(renderEngineCacheType));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void sl() {
        if (this.ah == null) {
            return;
        }
        pc pcVar = new pc(this.c);
        this.zb = pcVar;
        pcVar.xr(this.ah).ms(this.x).xr(this.x.df()).ah(this.x.lx()).ms(this.ab).ah(f.xr(this.ab)).d(f.ao(this.x)).ms(this).c(this.f885ms).ms(this.ah).ms(this.ny);
    }

    public void zb() {
        if (this.ah == null) {
            return;
        }
        this.ah.setMaterialMeta(com.bytedance.sdk.openadsdk.core.jw.pc.ms(this.x));
        this.ah.setBackgroundColor(0);
        this.ah.setBackgroundResource(R.color.transparent);
        ms(this.ah);
        if (ms() != null) {
            this.hi = new com.bytedance.sdk.openadsdk.core.zb.d(this.x, ms()).xr(false);
        }
        this.hi.ms(this.ny);
        this.ah.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.ms.ah(this.zb, this.hi));
        this.ah.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.yu.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                if (yu.this.sl.containsKey(str)) {
                    com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = (com.bytedance.sdk.openadsdk.core.hi.xr.ah) yu.this.sl.get(str);
                    if (ahVar != null) {
                        ahVar.xr(f.y(yu.this.x), false);
                        return;
                    }
                    return;
                }
                com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = com.bytedance.sdk.openadsdk.core.hi.ka.ms(yu.this.c, str, yu.this.x, yu.this.ab);
                yu.this.sl.put(str, ahVarMs);
                ahVarMs.xr(f.y(yu.this.x), false);
            }
        });
        if ("rewarded_video".equals(this.ab) || "fullscreen_interstitial_ad".equals(this.ab)) {
            ul.ms((com.bytedance.sdk.component.zb.ah) this.ah);
        }
        com.bytedance.sdk.component.adexpress.ka.ka.ms().ms(this.ah, this.zb);
    }

    private void ms(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.ms.xr.ms(this.c).ms(false).ms(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            com.bytedance.sdk.openadsdk.core.jw.t.ms(sSWebView, g.xr, lm.d(this.x));
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
            com.bytedance.sdk.component.utils.sl.d("WebViewRender", e.toString());
        }
    }

    public void u() {
        if (this.ah == null || this.ao != null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.y.ah ahVar = new com.bytedance.sdk.openadsdk.core.y.ah();
        com.bytedance.sdk.openadsdk.core.y.d dVar = new com.bytedance.sdk.openadsdk.core.y.d();
        com.bytedance.sdk.openadsdk.core.y.ka kaVar = new com.bytedance.sdk.openadsdk.core.y.ka(this.zb);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", this.x.df());
            jSONObject.put("log_extra", this.x.lx());
        } catch (Throwable unused) {
        }
        HashSet hashSet = new HashSet();
        hashSet.add("subscribe_app_ad");
        hashSet.add("adInfo");
        hashSet.add("webview_time_track");
        hashSet.add("download_app_ad");
        this.ao = ahVar.ms(com.bytedance.sdk.openadsdk.core.re.getContext(), this.ah, kaVar, dVar, hashSet, "embeded_ad".equals(this.ab) ? com.bytedance.sdk.openadsdk.u.x.ms.FEED : com.bytedance.sdk.openadsdk.u.x.ms.OTHER).ka(this.ch).d(com.bytedance.sdk.openadsdk.core.x.ms.ab()).ms(com.bytedance.sdk.openadsdk.core.x.ms.ms()).ka(jSONObject).ms("sdkEdition", com.bytedance.sdk.openadsdk.core.x.ms.ah()).xr(com.bytedance.sdk.openadsdk.core.x.ms.ka()).ah(com.bytedance.sdk.openadsdk.core.x.ms.d()).ah(false);
        this.h = new ab(this.c, this.zb, this.x, this.hi, ao(), this.ao, hi());
        this.ah.setWebViewClient(this.h);
        com.bytedance.sdk.component.adexpress.xr.ny nyVar = this.qv;
        if (nyVar instanceof ch) {
            ((ch) nyVar).ms(this.ao);
        }
        Set<String> setCh = this.ao.ch();
        if (this.zb == null || setCh == null || setCh.size() <= 0) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this.ao);
        Iterator<String> it = setCh.iterator();
        while (it.hasNext()) {
            this.zb.c().ms(it.next(), (com.bytedance.sdk.component.ms.ka<?, ?>) new com.bytedance.sdk.component.ms.ka<JSONObject, JSONObject>() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.yu.2
                @Override // com.bytedance.sdk.component.ms.ka
                public JSONObject ms(JSONObject jSONObject2, com.bytedance.sdk.component.ms.c cVar) throws Exception {
                    try {
                        com.bytedance.sdk.openadsdk.u.x xVar = (com.bytedance.sdk.openadsdk.u.x) weakReference.get();
                        if (xVar == null) {
                            return null;
                        }
                        return xVar.d(ms(), jSONObject2);
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            });
        }
    }

    public ab ub() {
        return this.h;
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    public SSWebView ms() {
        return this.ah;
    }

    private boolean ao() {
        return !TextUtils.isEmpty(this.ab) && this.ab.equals("splash_ad");
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    public void d() {
        if (this.ka.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.zb.d dVar = this.hi;
        if (dVar != null) {
            dVar.c();
        }
        if (this.ah != null) {
            this.ah.J_();
            this.ah.setOnShakeListener(null);
        }
        pc pcVar = this.zb;
        if (pcVar != null) {
            pcVar.ka();
        }
        super.d();
        this.sl.clear();
        this.zb = null;
        com.bytedance.sdk.openadsdk.u.x xVar = this.ao;
        if (xVar == null) {
            return;
        }
        xVar.pc();
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms, com.bytedance.sdk.component.adexpress.xr.d
    public int ah() {
        return this.x.du();
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    public void ka() {
        if (ms() == null) {
            return;
        }
        try {
            ms().resumeTimers();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    protected void ms(boolean z, int i) {
        super.ms(z, i);
        com.bytedance.sdk.openadsdk.c.ms msVar = this.ny;
        if (msVar != null) {
            msVar.ms(z, i);
            this.ny.xr(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms, com.bytedance.sdk.openadsdk.core.nativeexpress.u
    public void x() {
        super.x();
        if (this.zb == null) {
            return;
        }
        h();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.zb.ms("expressShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private void h() {
        if (this.zb == null || ((ViewGroup) this.ah.getParent()) == null) {
            return;
        }
        this.zb.ms(new op(this.ah, this.zb, this.x));
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    protected void ny() {
        com.bytedance.sdk.openadsdk.core.jw.ms msVarD = com.bytedance.sdk.openadsdk.core.ch.ub().d();
        this.ub = msVarD;
        msVarD.ms(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    protected void ch() {
        super.ch();
        com.bytedance.sdk.openadsdk.core.jw.ms msVar = this.ub;
        if (msVar != null) {
            msVar.xr(this);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    public void c() {
        pc pcVar = this.zb;
        if (pcVar == null) {
            return;
        }
        pcVar.ms("expressWebviewRecycle", (JSONObject) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms, com.bytedance.sdk.openadsdk.core.nativeexpress.u
    public void xr(final int i) {
        com.bytedance.sdk.openadsdk.op.ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.yu.3
            @Override // java.lang.Runnable
            public void run() {
                yu.this.ah(i);
                yu.this.d(i);
                if (i == yu.this.u) {
                    return;
                }
                yu.this.u = i;
                yu.this.xr(i == 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i) {
        com.bytedance.sdk.openadsdk.u.x xVar = this.ao;
        if (xVar == null) {
            return;
        }
        if (i == 0) {
            xVar.xr(true);
            this.ao.ms(false);
        } else {
            xVar.xr(false);
            this.ao.ms(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z) {
        if (this.zb == null || this.ah == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            this.zb.ms("expressAdShow", jSONObject);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ub
    public pc E_() {
        return this.zb;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.ms
    public void b_(int i) {
        if (this.zb == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        this.zb.ms("themeChange", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        try {
            if (g.ms() && i == 0) {
                long jR = com.bytedance.sdk.openadsdk.core.re.xr().r();
                if (this.y != -1 && System.currentTimeMillis() - this.y > jR) {
                    SSWebView sSWebViewMs = ms();
                    WebView webView = sSWebViewMs.getWebView();
                    sSWebViewMs.removeView(webView);
                    sSWebViewMs.addView(webView);
                }
                this.y = -1L;
                return;
            }
            this.y = System.currentTimeMillis();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.ka.ms
    protected void ms(float f, float f2) {
        float f3 = this.c.getResources().getDisplayMetrics().density;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        super.ms(ul.xr(f3, ul.ms(f4, f)), ul.xr(f3, ul.ms(f4, f2)));
    }
}
