package com.byazt.hm;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.byazt.gct.pk;
import com.byazt.ho.BaseConstants;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.byazt.tk.oa;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 49, 8})
public class s {
    public com.byazt.uad.q a;
    public String l;
    public String ln;
    public JSONObject ou;
    public String q;
    public long t;
    public Runnable ur;
    public WeakReference<qg> v;
    public final pk w;
    public com.byazt.vgn.q wm;
    public int n = 0;
    public volatile boolean qg = false;
    public int s = -1;
    public String x = "landingpage";
    public long fs = 0;
    public long rv = 0;
    public long tj = 0;
    public long cp = 0;
    public long d = 0;
    public boolean oa = false;
    public long sz = 0;
    public long k = 0;
    public long cy = 0;
    public long hd = -1;
    public boolean cd = false;
    public AtomicInteger um = new AtomicInteger(0);
    public boolean py = false;
    public AtomicBoolean m = new AtomicBoolean(false);
    public boolean hu = false;
    public boolean h = true;
    public final AtomicBoolean bb = new AtomicBoolean(false);
    public final Map<String, com.byazt.qq.s.n> lh = new ConcurrentHashMap();

    public interface qg {
        void n(String str);
    }

    public void n(qg qgVar) {
        this.v = new WeakReference<>(qgVar);
    }

    public s(pk pkVar, com.byazt.uad.q qVar) {
        this.w = pkVar;
        this.a = qVar;
        if (qVar != null) {
            qVar.addJavascriptInterface(new n(this.um, this.v), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.t = System.currentTimeMillis();
        this.ln = String.valueOf(SystemClock.elapsedRealtime());
    }

    public void n(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.x = str;
    }

    public String n() {
        return this.x;
    }

    public void n(long j) {
        this.tj = j;
    }

    public boolean qg() {
        return this.hu;
    }

    public void n(boolean z) {
        this.hu = z;
    }

    public com.byazt.vgn.q s() {
        return this.wm;
    }

    public void n(com.byazt.vgn.q qVar) {
        this.wm = qVar;
    }

    public void n(JSONObject jSONObject) {
        this.ou = jSONObject;
    }

    public s qg(boolean z) {
        this.py = z;
        return this;
    }

    public s qg(long j) {
        this.k = j;
        return this;
    }

    public s s(long j) {
        this.cy = j;
        return this;
    }

    public s q(long j) {
        this.hd = j;
        return this;
    }

    public void n(WebView webView, int i) {
        if (this.cp == 0 && i > 0) {
            this.n = 1;
            this.cp = System.currentTimeMillis();
        } else {
            if (i != 100 || this.oa) {
                return;
            }
            this.oa = true;
            this.d = System.currentTimeMillis();
            if (!"landingpage".equals(this.x) || this.n == 3) {
                return;
            }
            qg("landingpage_load_hundred");
        }
    }

    public void n(WebView webView, String str, Bitmap bitmap) {
        com.byazt.vgn.q qVar = this.wm;
        if (qVar != null) {
            qVar.rv();
        }
        if (this.qg) {
            return;
        }
        this.sz = System.currentTimeMillis();
        this.qg = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        n("load_start", jSONObject);
    }

    public void n(WebView webView) {
        com.byazt.vgn.q qVar = this.wm;
        if (qVar != null) {
            qVar.tj();
        }
        if (this.d <= 0) {
            this.d = System.currentTimeMillis();
        }
        if (webView != null && !this.cd && this.py) {
            this.cd = true;
            oa.n(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.m.get()) {
            return;
        }
        if (this.n != 3) {
            this.n = 2;
        }
        this.m.set(true);
        this.fs = System.currentTimeMillis();
        if (this.n == 2) {
            qg("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", this.s);
            jSONObject.put("error_msg", this.q);
            jSONObject.put("error_url", this.l);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        n("load_fail", jSONObject);
    }

    public void n(int i, String str, String str2, String str3) {
        com.byazt.vgn.q qVar = this.wm;
        if (qVar != null) {
            qVar.cp();
        }
        if (!(str3 != null && str3.startsWith("image")) && this.n != 2) {
            this.n = 3;
        }
        this.s = i;
        this.q = str;
        this.l = str2;
    }

    public void q() {
        this.fs = System.currentTimeMillis();
        if (this.sz == 0) {
            this.sz = System.currentTimeMillis();
        }
        if ("landingpage".equals(this.x) || "landingpage_endcard".equals(this.x)) {
            if (this.bb.compareAndSet(false, true)) {
                com.byazt.wb.s.x().n("landingStart", this.w, this.ln);
                com.byazt.mvx.n.l().n("landingStart", this.w);
            } else {
                com.byazt.wb.s.x().n("landingContinue", this.w, this.ln);
                com.byazt.mvx.n.l().n("landingContinue", this.w);
            }
        }
    }

    public void l() {
        if (this.h) {
            this.h = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.t);
                jSONObject.put("end", System.currentTimeMillis());
                com.byazt.aci.n.n(jSONObject, this.w);
            } catch (JSONException unused) {
            }
            com.byazt.hm.n.n(this.w, "landingpage", "agg_stay_page", new com.byazt.rs.n() { // from class: com.byazt.hm.s.1
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                    return jSONObject;
                }
            });
        }
        if (this.n == 2) {
            if (this.tj > 0 || !qg()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.rv = jCurrentTimeMillis;
                long jMax = jCurrentTimeMillis - Math.max(this.fs, this.tj);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("load_status", this.n);
                    jSONObject2.put("max_scroll_percent", this.um.get());
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                } catch (JSONException unused2) {
                }
                n("stay_page", jSONObject2, Math.min(jMax, 600000L));
                com.byazt.wb.s.x().n("landingPause", this.w, this.ln);
                com.byazt.mvx.n.l().n("landingPause", this.w);
            }
        }
    }

    public void w() {
        com.byazt.uad.q qVar = this.a;
        if (qVar != null) {
            qVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        this.a = null;
        if (!this.m.get() && this.qg) {
            com.byazt.hm.n.s(this.w, this.x, System.currentTimeMillis() - this.sz);
        }
        if ("landingpage".equals(this.x) || "landingpage_endcard".equals(this.x)) {
            com.byazt.wb.s.x().n("landingFinish", this.w, this.ln);
            com.byazt.mvx.n.l().n("landingFinish", this.w);
        }
        this.ur = null;
        if (this.lh.isEmpty()) {
            return;
        }
        com.byazt.eji.s sVarN = com.byazt.eji.s.n();
        pk pkVar = this.w;
        sVarN.n("web_cache_hit_report", pkVar != null ? pkVar.ou() : null, new com.byazt.rs.n() { // from class: com.byazt.hm.s.2
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (com.byazt.qq.s.n nVar : s.this.lh.values()) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put(ImagesContract.URL, nVar.s());
                        jSONObject3.put("hit", nVar.q());
                        jSONObject3.put("miss", nVar.l());
                        jSONArray.put(jSONObject3);
                    } catch (JSONException unused) {
                    }
                }
                try {
                    jSONObject2.put("hit_records", jSONArray);
                } catch (JSONException unused2) {
                }
                return jSONObject2;
            }
        });
    }

    private void n(String str, JSONObject jSONObject) {
        n(str, jSONObject, -1L);
    }

    private void n(String str, JSONObject jSONObject, long j) {
        if (!this.py || this.w == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put(MediationConstant.EXTRA_DURATION, j);
                    }
                } catch (JSONException unused) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused2) {
            }
        }
        com.byazt.hm.n.s(this.w, this.x, str, jSONObject2);
    }

    public void qg(String str) {
        if (this.py) {
            if ("load_finish".equals(str) && "landingpage".equals(this.x)) {
                this.ur = new Runnable() { // from class: com.byazt.hm.s.3
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.rv();
                    }
                };
                com.byazt.vu.n.n(new com.byazt.vu.n.RunnableC0377n(this.ur));
            }
            long j = this.d - this.cp;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.s);
                jSONObject.put("error_msg", this.q);
                jSONObject.put("error_url", this.l);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
                long j2 = this.k;
                if (j2 > 0) {
                    jSONObject.put("exp_duration", this.d - j2);
                }
                long j3 = this.cy;
                if (j3 > 0) {
                    jSONObject.put("web_duration", this.d - j3);
                }
                long j4 = this.hd;
                if (j4 >= 0) {
                    jSONObject.put("webview_duration", j4);
                }
            } catch (Exception unused) {
            }
            n(str, jSONObject, Math.min(j, 600000L));
        }
    }

    @com.byazt.cp.n(n = {0, 1, 49, 546})
    private static class n {
        public final AtomicInteger n;
        public final WeakReference<qg> qg;

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }

        public n(AtomicInteger atomicInteger, WeakReference<qg> weakReference) {
            this.n = atomicInteger;
            this.qg = weakReference;
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
            AtomicInteger atomicInteger = this.n;
            if (atomicInteger != null) {
                atomicInteger.set(i);
            }
            WeakReference<qg> weakReference = this.qg;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.qg.get().n(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        try {
            if (!TextUtils.isEmpty(com.byazt.vu.n.n) && this.w != null) {
                StringBuilder sb = new StringBuilder(com.byazt.vu.n.n);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("cid", this.w.q());
                jSONObject.putOpt(MediationConstant.EXTRA_ADID, this.w.wm());
                jSONObject.put("log_extra", this.w.F_());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.cy);
                jSONObject2.put("click_time", this.k);
                jSONObject2.put("web_url", this.w.fs());
                jSONObject.put("client_info", jSONObject2);
                com.byazt.vu.n.n(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                String strConcat = "javascript:".concat(String.valueOf(string));
                com.byazt.uad.q qVar = this.a;
                if (qVar != null) {
                    oa.n(qVar, strConcat);
                }
            }
        } catch (Throwable th) {
            k.n(th.getMessage());
        }
    }

    public void x() {
        com.byazt.kir.n nVarXi;
        com.byazt.uad.q qVar;
        if (!(this.n == 2 && this.oa) || (nVarXi = rv.qg().xi()) == null || (qVar = this.a) == null) {
            return;
        }
        nVarXi.n(qVar.getWebView(), this.w);
    }

    public Map<String, com.byazt.qq.s.n> fs() {
        return this.lh;
    }
}
