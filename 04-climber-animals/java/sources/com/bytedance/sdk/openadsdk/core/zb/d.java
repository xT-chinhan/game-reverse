package com.bytedance.sdk.openadsdk.core.zb;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.utils.hi;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.umeng.analytics.pro.cl;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private JSONObject b;
    private final lm c;
    private String d;
    private WeakReference<xr> g;
    private String ka;
    private Runnable le;
    private long op;
    private com.bytedance.sdk.openadsdk.c.ms re;
    private com.bytedance.sdk.component.zb.ah t;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3857ms = 0;
    private volatile boolean xr = false;
    private int ah = -1;
    private String ab = "landingpage";
    private long x = 0;
    private long ny = 0;
    private long ch = 0;
    private long hi = 0;
    private long sl = 0;
    private boolean zb = false;
    private long u = 0;
    private long ub = 0;
    private long ao = 0;
    private long h = -1;
    private boolean qv = false;
    private AtomicInteger y = new AtomicInteger(0);
    private boolean nw = false;
    private AtomicBoolean i = new AtomicBoolean(false);
    private boolean w = false;
    private boolean yu = true;
    private final Map<String, com.bytedance.sdk.openadsdk.core.jw.lm.ms> cv = new ConcurrentHashMap();

    public interface xr {
        void ms(String str);
    }

    public void ms(xr xrVar) {
        this.g = new WeakReference<>(xrVar);
    }

    public d(lm lmVar, com.bytedance.sdk.component.zb.ah ahVar) {
        this.c = lmVar;
        this.t = ahVar;
        if (ahVar != null) {
            ahVar.addJavascriptInterface(new ms(this.y, this.g), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.op = System.currentTimeMillis();
    }

    public void ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ab = str;
    }

    public String ms() {
        return this.ab;
    }

    public void ms(long j) {
        this.ch = j;
    }

    public boolean xr() {
        return this.w;
    }

    public void ms(boolean z) {
        this.w = z;
    }

    public com.bytedance.sdk.openadsdk.c.ms ah() {
        return this.re;
    }

    public void ms(com.bytedance.sdk.openadsdk.c.ms msVar) {
        this.re = msVar;
    }

    public void ms(JSONObject jSONObject) {
        this.b = jSONObject;
    }

    public d xr(boolean z) {
        this.nw = z;
        return this;
    }

    public d xr(long j) {
        this.ub = j;
        return this;
    }

    public d ah(long j) {
        this.ao = j;
        return this;
    }

    public d d(long j) {
        this.h = j;
        return this;
    }

    public void ms(WebView webView, int i) {
        if (this.hi == 0 && i > 0) {
            this.f3857ms = 1;
            this.hi = System.currentTimeMillis();
        } else {
            if (i != 100 || this.zb) {
                return;
            }
            this.zb = true;
            this.sl = System.currentTimeMillis();
            if (!"landingpage".equals(this.ab) || this.f3857ms == 3) {
                return;
            }
            xr("landingpage_load_hundred");
        }
    }

    public void ms(WebView webView, String str, Bitmap bitmap) {
        com.bytedance.sdk.openadsdk.c.ms msVar = this.re;
        if (msVar != null) {
            msVar.c();
        }
        if (this.xr) {
            return;
        }
        this.u = System.currentTimeMillis();
        this.xr = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(j.w.E, "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        ms("load_start", jSONObject);
    }

    public void ms(WebView webView) {
        com.bytedance.sdk.openadsdk.c.ms msVar = this.re;
        if (msVar != null) {
            msVar.ab();
        }
        if (this.sl <= 0) {
            this.sl = System.currentTimeMillis();
        }
        if (webView != null && !this.qv && this.nw) {
            this.qv = true;
            hi.ms(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.i.get()) {
            return;
        }
        if (this.f3857ms != 3) {
            this.f3857ms = 2;
        }
        this.i.set(true);
        this.x = System.currentTimeMillis();
        if (this.f3857ms == 2) {
            xr("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", this.ah);
            jSONObject.put("error_msg", this.d);
            jSONObject.put("error_url", this.ka);
            jSONObject.putOpt(j.w.E, "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        ms("load_fail", jSONObject);
    }

    public void ms(int i, String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.c.ms msVar = this.re;
        if (msVar != null) {
            msVar.x();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.f3857ms != 2) {
            this.f3857ms = 3;
        }
        this.ah = i;
        this.d = str;
        this.ka = str2;
    }

    public void d() {
        this.x = System.currentTimeMillis();
        if (this.u == 0) {
            this.u = System.currentTimeMillis();
        }
    }

    public void ka() {
        if (this.yu) {
            this.yu = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.op);
                jSONObject.put(cl.s, System.currentTimeMillis());
                com.bytedance.sdk.openadsdk.ka.ms.ms(jSONObject, this.c);
            } catch (JSONException e) {
                sl.ms(e);
            }
            ah.ms(this.c, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.d.1
                @Override // com.bytedance.sdk.openadsdk.c.ms.ms
                public void ms(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
        if (this.f3857ms == 2) {
            if (this.ch > 0 || !xr()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.ny = jCurrentTimeMillis;
                long jMax = jCurrentTimeMillis - Math.max(this.x, this.ch);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.f3857ms);
                    jSONObject2.put("max_scroll_percent", this.y.get());
                    jSONObject2.putOpt(j.w.E, "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused) {
                }
                ms("stay_page", jSONObject2, Math.min(jMax, 600000L));
            }
        }
    }

    public void c() {
        com.bytedance.sdk.component.zb.ah ahVar = this.t;
        if (ahVar != null) {
            ahVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.t = null;
        if (!this.i.get() && this.xr) {
            ah.ah(this.c, this.ab, System.currentTimeMillis() - this.u);
        }
        this.le = null;
        if (this.cv.isEmpty()) {
            return;
        }
        u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.zb.d.2
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() {
                com.bytedance.sdk.openadsdk.core.t.ms.xr xrVarMs = com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("web_cache_hit_report");
                if (d.this.c != null) {
                    xrVarMs.c(d.this.c.eu());
                }
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (com.bytedance.sdk.openadsdk.core.jw.lm.ms msVar : d.this.cv.values()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("url", msVar.ah());
                        jSONObject2.put("hit", msVar.d());
                        jSONObject2.put("miss", msVar.ka());
                        jSONArray.put(jSONObject2);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    jSONObject.put("hit_records", jSONArray);
                } catch (JSONException unused2) {
                }
                xrVarMs.xr(jSONObject.toString());
                return xrVarMs;
            }
        }, "web_cache_hit_report");
    }

    private void ms(String str, JSONObject jSONObject) {
        ms(str, jSONObject, -1L);
    }

    private void ms(String str, JSONObject jSONObject, long j) {
        if (!this.nw || this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        ah.ah(this.c, this.ab, str, jSONObject2);
    }

    public void xr(String str) {
        if (this.nw) {
            if ("load_finish".equals(str) && "landingpage".equals(this.ab)) {
                this.le = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.d.3
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.ny();
                    }
                };
                com.bytedance.sdk.openadsdk.core.ub.ms.ms(new com.bytedance.sdk.openadsdk.core.ub.ms.RunnableC0311ms(this.le));
            }
            long j = this.sl - this.hi;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.ah);
                jSONObject.put("error_msg", this.d);
                jSONObject.put("error_url", this.ka);
                jSONObject.putOpt(j.w.E, "h5");
                jSONObject.putOpt("render_type_2", 0);
                long j2 = this.ub;
                if (j2 > 0) {
                    jSONObject.put("exp_duration", this.sl - j2);
                }
                long j3 = this.ao;
                if (j3 > 0) {
                    jSONObject.put("web_duration", this.sl - j3);
                }
                long j4 = this.h;
                if (j4 >= 0) {
                    jSONObject.put("webview_duration", j4);
                }
            } catch (Exception unused) {
            }
            ms(str, jSONObject, Math.min(j, 600000L));
        }
    }

    private static class ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final AtomicInteger f3861ms;
        private final WeakReference<xr> xr;

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }

        ms(AtomicInteger atomicInteger, WeakReference<xr> weakReference) {
            this.f3861ms = atomicInteger;
            this.xr = weakReference;
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            try {
                int iIntValue = Float.valueOf(str).intValue();
                if (iIntValue > 100) {
                    i = 100;
                } else if (iIntValue >= 0) {
                    i = iIntValue;
                }
            } catch (Throwable unused) {
            }
            AtomicInteger atomicInteger = this.f3861ms;
            if (atomicInteger != null) {
                atomicInteger.set(i);
            }
            WeakReference<xr> weakReference = this.xr;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.xr.get().ms(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny() {
        try {
            if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.ub.ms.f3373ms) && this.c != null) {
                StringBuilder sb = new StringBuilder(com.bytedance.sdk.openadsdk.core.ub.ms.f3373ms);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("cid", this.c.df());
                jSONObject.putOpt("ad_id", this.c.cz());
                jSONObject.put("log_extra", this.c.lx());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.ao);
                jSONObject2.put("click_time", this.ub);
                jSONObject2.put("web_url", this.c.ir());
                jSONObject.put("client_info", jSONObject2);
                com.bytedance.sdk.openadsdk.core.ub.ms.ms(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                String strConcat = "javascript:".concat(String.valueOf(string));
                com.bytedance.sdk.component.zb.ah ahVar = this.t;
                if (ahVar != null) {
                    hi.ms(ahVar, strConcat);
                }
            }
        } catch (Throwable th) {
            sl.xr(th.getMessage());
        }
    }

    public void ab() {
        com.bytedance.sdk.openadsdk.core.ub.ms.ms msVarTz;
        com.bytedance.sdk.component.zb.ah ahVar;
        if (!(this.f3857ms == 2 && this.zb) || (msVarTz = re.xr().tz()) == null || (ahVar = this.t) == null) {
            return;
        }
        msVarTz.ms(ahVar.getWebView(), this.c);
    }

    public Map<String, com.bytedance.sdk.openadsdk.core.jw.lm.ms> x() {
        return this.cv;
    }
}
