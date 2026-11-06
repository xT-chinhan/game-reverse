package com.byazt.pj;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.byazt.ca.ho;
import com.byazt.ca.m;
import com.byazt.fi.BaseConstants;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.wt.qn;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.view.ImageViewManager;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, 20})
public class hn {
    public com.byazt.son.x a;
    public String c;
    public com.byazt.ko.pr fo;
    public long iu;
    public String nl;
    public JSONObject ny;
    public final of uc;
    public Runnable ve;
    public WeakReference<hw> ww;
    public String x;
    public int pr = 0;
    public volatile boolean hw = false;
    public int hn = -1;
    public String fw = "landingpage";
    public long zo = 0;
    public long aj = 0;
    public long vk = 0;
    public long w = 0;
    public long k = 0;
    public boolean m = false;
    public long g = 0;
    public long ho = 0;
    public long nt = 0;
    public long yb = -1;
    public boolean lb = false;
    public AtomicInteger qa = new AtomicInteger(0);
    public boolean cz = false;
    public AtomicBoolean rc = new AtomicBoolean(false);
    public boolean z = false;
    public boolean b = true;
    public final AtomicBoolean gz = new AtomicBoolean(false);
    public final Map<String, qn.pr> y = new ConcurrentHashMap();

    public interface hw {
        void pr(String str);
    }

    public void pr(hw hwVar) {
        this.ww = new WeakReference<>(hwVar);
    }

    public hn(of ofVar, com.byazt.son.x xVar) {
        this.uc = ofVar;
        this.a = xVar;
        if (xVar != null) {
            xVar.addJavascriptInterface(new pr(this.qa, this.ww), "JS_LANDING_PAGE_LOG_OBJ");
        }
        this.iu = System.currentTimeMillis();
        this.nl = String.valueOf(SystemClock.elapsedRealtime());
    }

    public void pr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fw = str;
    }

    public String pr() {
        return this.fw;
    }

    public void pr(long j) {
        this.vk = j;
    }

    public boolean hw() {
        return this.z;
    }

    public void pr(boolean z) {
        this.z = z;
    }

    public com.byazt.ko.pr hn() {
        return this.fo;
    }

    public void pr(com.byazt.ko.pr prVar) {
        this.fo = prVar;
    }

    public void pr(JSONObject jSONObject) {
        this.ny = jSONObject;
    }

    public hn hw(boolean z) {
        this.cz = z;
        return this;
    }

    public hn hw(long j) {
        this.ho = j;
        return this;
    }

    public hn hn(long j) {
        this.nt = j;
        return this;
    }

    public hn x(long j) {
        this.yb = j;
        return this;
    }

    public void pr(WebView webView, int i) {
        if (this.w == 0 && i > 0) {
            this.pr = 1;
            this.w = System.currentTimeMillis();
        } else if (i == 100 && !this.m) {
            this.m = true;
            this.k = System.currentTimeMillis();
            if ("landingpage".equals(this.fw) && this.pr != 3) {
                hw("landingpage_load_hundred");
            }
        }
    }

    public void pr(WebView webView, String str, Bitmap bitmap) {
        com.byazt.ko.pr prVar = this.fo;
        if (prVar != null) {
            prVar.uc();
        }
        if (!this.hw) {
            this.g = System.currentTimeMillis();
            this.hw = true;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (Exception e) {
            }
            pr("load_start", jSONObject);
        }
    }

    public void pr(WebView webView) {
        com.byazt.ko.pr prVar = this.fo;
        if (prVar != null) {
            prVar.fw();
        }
        if (this.k <= 0) {
            this.k = System.currentTimeMillis();
        }
        if (webView != null && !this.lb && this.cz) {
            this.lb = true;
            m.pr(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
        }
        if (this.rc.get()) {
            return;
        }
        if (this.pr != 3) {
            this.pr = 2;
        }
        this.rc.set(true);
        this.zo = System.currentTimeMillis();
        if (this.pr == 2) {
            hw("load_finish");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.ERROR_CODE_FIELD, this.hn);
            jSONObject.put(Constants.ERROR_MSG_FIELD, this.x);
            jSONObject.put("error_url", this.c);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception e) {
        }
        pr("load_fail", jSONObject);
    }

    public void pr(int i, String str, String str2, String str3) {
        com.byazt.ko.pr prVar = this.fo;
        if (prVar != null) {
            prVar.zo();
        }
        if (!(str3 != null && str3.startsWith(ImageViewManager.NAME)) && this.pr != 2) {
            this.pr = 3;
        }
        this.hn = i;
        this.x = str;
        this.c = str2;
    }

    public void x() {
        this.zo = System.currentTimeMillis();
        if (this.g == 0) {
            this.g = System.currentTimeMillis();
        }
        if ("landingpage".equals(this.fw) || "landingpage_endcard".equals(this.fw)) {
            if (this.gz.compareAndSet(false, true)) {
                com.byazt.mk.hn.fw().pr("landingStart", this.uc, this.nl);
            } else {
                com.byazt.mk.hn.fw().pr("landingContinue", this.uc, this.nl);
            }
        }
    }

    public void c() {
        if (this.b) {
            this.b = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TrackAction.START, this.iu);
                jSONObject.put("end", System.currentTimeMillis());
                com.byazt.ja.pr.pr(jSONObject, this.uc);
            } catch (JSONException e) {
            }
            com.byazt.pj.pr.pr(this.uc, "landingpage", "agg_stay_page", new com.byazt.ttf.pr() { // from class: com.byazt.pj.hn.1
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                    return jSONObject;
                }
            });
        }
        if (this.pr == 2) {
            if (this.vk <= 0 && hw()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.aj = jCurrentTimeMillis;
            long jMax = jCurrentTimeMillis - Math.max(this.zo, this.vk);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("load_status", this.pr);
                jSONObject2.put("max_scroll_percent", this.qa.get());
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
            } catch (JSONException e2) {
            }
            pr("stay_page", jSONObject2, Math.min(jMax, 600000L));
            com.byazt.mk.hn.fw().pr("landingPause", this.uc, this.nl);
        }
    }

    public void uc() {
        com.byazt.son.x xVar = this.a;
        if (xVar != null) {
            xVar.removeJavascriptInterface("JS_LANDING_PAGE_LOG_OBJ");
        }
        String strNy = null;
        this.a = null;
        if (!this.rc.get() && this.hw) {
            com.byazt.pj.pr.hn(this.uc, this.fw, System.currentTimeMillis() - this.g);
        }
        if ("landingpage".equals(this.fw) || "landingpage_endcard".equals(this.fw)) {
            com.byazt.mk.hn.fw().pr("landingFinish", this.uc, this.nl);
        }
        this.ve = null;
        if (!this.y.isEmpty()) {
            com.byazt.xk.hw hwVarPr = com.byazt.xk.hw.pr();
            of ofVar = this.uc;
            if (ofVar != null) {
                strNy = ofVar.ny();
            }
            hwVarPr.pr("web_cache_hit_report", strNy, new com.byazt.ttf.pr() { // from class: com.byazt.pj.hn.2
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (qn.pr prVar : hn.this.y.values()) {
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put(BreakpointSQLiteKey.URL, prVar.hn());
                            jSONObject3.put("hit", prVar.x());
                            jSONObject3.put("miss", prVar.c());
                            jSONArray.put(jSONObject3);
                        } catch (JSONException e) {
                        }
                    }
                    try {
                        jSONObject2.put("hit_records", jSONArray);
                    } catch (JSONException e2) {
                    }
                    return jSONObject2;
                }
            });
        }
    }

    private void pr(String str, JSONObject jSONObject) {
        pr(str, jSONObject, -1L);
    }

    private void pr(String str, JSONObject jSONObject, long j) {
        if (!this.cz || this.uc == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                    jSONObject2 = jSONObject3;
                } catch (JSONException e) {
                    jSONObject2 = jSONObject3;
                }
            } catch (JSONException e2) {
            }
        }
        com.byazt.pj.pr.hn(this.uc, this.fw, str, jSONObject2);
    }

    public void hw(String str) {
        if (!this.cz) {
            return;
        }
        if ("load_finish".equals(str) && "landingpage".equals(this.fw)) {
            Runnable runnable = new Runnable() { // from class: com.byazt.pj.hn.3
                @Override // java.lang.Runnable
                public void run() {
                    hn.this.aj();
                }
            };
            this.ve = runnable;
            com.byazt.ac.pr.pr(new com.byazt.ac.pr.RunnableC0007pr(runnable));
        }
        long j = this.k - this.w;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.ERROR_CODE_FIELD, this.hn);
            jSONObject.put(Constants.ERROR_MSG_FIELD, this.x);
            jSONObject.put("error_url", this.c);
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
            long j2 = this.ho;
            if (j2 > 0) {
                jSONObject.put("exp_duration", this.k - j2);
            }
            long j3 = this.nt;
            if (j3 > 0) {
                jSONObject.put("web_duration", this.k - j3);
            }
            long j4 = this.yb;
            if (j4 >= 0) {
                jSONObject.put("webview_duration", j4);
            }
        } catch (Exception e) {
        }
        pr(str, jSONObject, Math.min(j, 600000L));
    }

    @com.byazt.vzx.pr(pr = {0, 1, 115, 116})
    private static class pr {
        public final WeakReference<hw> hw;
        public final AtomicInteger pr;

        public pr(AtomicInteger atomicInteger, WeakReference<hw> weakReference) {
            this.pr = atomicInteger;
            this.hw = weakReference;
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
            } catch (Throwable th) {
            }
            AtomicInteger atomicInteger = this.pr;
            if (atomicInteger != null) {
                atomicInteger.set(i);
            }
            WeakReference<hw> weakReference = this.hw;
            if (weakReference != null && weakReference.get() != null) {
                this.hw.get().pr(str);
            }
        }

        @JavascriptInterface
        public String getUrl() {
            return "";
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        try {
            if (!TextUtils.isEmpty(com.byazt.ac.pr.pr) && this.uc != null) {
                StringBuilder sb = new StringBuilder(com.byazt.ac.pr.pr);
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("cid", this.uc.x());
                jSONObject.putOpt(MediationConstant.EXTRA_ADID, this.uc.fo());
                jSONObject.put("log_extra", this.uc.B_());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("web_init_time", this.nt);
                jSONObject2.put("click_time", this.ho);
                jSONObject2.put("web_url", this.uc.zo());
                jSONObject.put("client_info", jSONObject2);
                com.byazt.ac.pr.pr(sb, "\"/** adInfo **/\"", jSONObject.toString());
                String string = sb.toString();
                if (!TextUtils.isEmpty(string)) {
                    String strConcat = "javascript:".concat(String.valueOf(string));
                    com.byazt.son.x xVar = this.a;
                    if (xVar != null) {
                        m.pr(xVar, strConcat);
                    }
                }
            }
        } catch (Throwable th) {
            ho.pr(th.getMessage());
        }
    }

    public void fw() {
        com.byazt.dm.pr prVarEy;
        com.byazt.son.x xVar;
        if ((this.pr == 2 && this.m) && (prVarEy = a.hw().ey()) != null && (xVar = this.a) != null) {
            prVarEy.pr(xVar.getWebView(), this.uc);
        }
    }

    public Map<String, qn.pr> zo() {
        return this.y;
    }
}
