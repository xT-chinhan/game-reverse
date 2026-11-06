package com.byazt.vgn;

import android.text.TextUtils;
import com.anythink.core.common.f.a;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.gct.su;
import com.byazt.tk.rv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1373, 13})
public class w implements q {
    public boolean cp;
    public volatile boolean cy;
    public int d;
    public JSONObject fs;
    public volatile int k;
    public Boolean l;
    public String n;
    public AtomicLong oa;
    public JSONObject q;
    public String qg;
    public JSONArray rv;
    public pk s;
    public JSONObject sz;
    public JSONArray tj;
    public Boolean w;
    public Boolean x;

    public w(String str, pk pkVar, JSONObject jSONObject, JSONObject jSONObject2) {
        this.qg = com.byazt.wg.qg.AD_TAG_FEED;
        this.l = Boolean.FALSE;
        this.w = Boolean.FALSE;
        this.x = Boolean.FALSE;
        this.cp = false;
        this.oa = new AtomicLong();
        this.k = 0;
        this.cy = false;
        this.qg = str;
        this.s = pkVar;
        this.fs = jSONObject;
        this.rv = new JSONArray();
        this.tj = new JSONArray();
        this.q = jSONObject2;
        this.n = pkVar == null ? com.byazt.vgx.s.q() : pkVar.mk();
    }

    public w() {
        this.qg = com.byazt.wg.qg.AD_TAG_FEED;
        this.l = Boolean.FALSE;
        this.w = Boolean.FALSE;
        this.x = Boolean.FALSE;
        this.cp = false;
        this.oa = new AtomicLong();
        this.k = 0;
        this.cy = false;
    }

    @Override // com.byazt.vgn.s
    public void q() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.oa.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    w wVar = w.this;
                    wVar.n(jSONObject, "ts", Long.valueOf(wVar.oa.get()));
                    w wVar2 = w.this;
                    wVar2.n(jSONObject, "render_sequence", Integer.valueOf(nf.s(wVar2.s)));
                    w wVar3 = w.this;
                    wVar3.n(jSONObject, "render_timeout", Integer.valueOf(wVar3.d));
                    w.this.n(jSONObject, "webview_count", Integer.valueOf(com.byazt.gjp.l.n().l()));
                    w.this.n(jSONObject, "available_cache_count", Integer.valueOf(com.byazt.gjp.l.n().s()));
                    su suVarFs = nf.fs(w.this.s);
                    if (suVarFs != null) {
                        w.this.n(jSONObject, a.C0017a.o, suVarFs.fs());
                    } else {
                        w.this.n(jSONObject, a.C0017a.o, "0");
                    }
                    JSONObject jSONObjectHd = w.this.hd();
                    if (jSONObjectHd != null) {
                        w.this.n(jSONObject, "size", jSONObjectHd);
                    }
                    w wVar4 = w.this;
                    wVar4.n(wVar4.fs, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject hd() {
        JSONObject jSONObject = this.q;
        if (jSONObject != null && jSONObject.has("xSize")) {
            Object objOpt = this.q.opt("xSize");
            if (objOpt instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) objOpt;
                if (jSONObject2.has("width") && jSONObject2.has("height")) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.putOpt("width", Double.valueOf(((JSONObject) objOpt).optDouble("width")));
                        jSONObject3.putOpt("height", Double.valueOf(((JSONObject) objOpt).optDouble("height")));
                        return jSONObject3;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return null;
    }

    @Override // com.byazt.vgn.s
    public void l() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.12
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "render_success", jSONObject);
                    if (w.this.qg.equals("splash_ad") || w.this.qg.equals("cache_splash_ad") || w.this.fs.optInt("webview_source", -1) == 2) {
                        return;
                    }
                    com.byazt.gh.n.n().n("ugen_render", "h5_render_success", String.valueOf(jCurrentTimeMillis) + "0", w.this.n);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.s
    public void s(final int i, final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.26
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "code", Integer.valueOf(i));
                    String str2 = str;
                    if (str2 != null) {
                        w.this.n(jSONObject, MediationConstant.KEY_REASON, str2);
                    }
                    w wVar = w.this;
                    wVar.n(wVar.fs, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.qg
    public void n() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.27
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void n(final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.28
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void s(final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.29
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void qg(final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.30
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, str, jSONObject);
                    if (w.this.qg.equals("splash_ad") || w.this.qg.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.gh.n.n().n("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0", w.this.n);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void n(final int i, final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.31
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "code", Integer.valueOf(i));
                    w wVar = w.this;
                    wVar.n(wVar.fs, str, jSONObject);
                    if (w.this.qg.equals("splash_ad") || w.this.qg.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.gh.n.n().n("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1", w.this.n);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void q(final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.2
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void l(final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, str, jSONObject);
                    if (w.this.qg.equals("splash_ad") || w.this.qg.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.gh.n.n().n("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0", w.this.n);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void qg(final int i, final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.4
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "code", Integer.valueOf(i));
                    w wVar = w.this;
                    wVar.n(wVar.fs, str, jSONObject);
                    if (w.this.qg.equals("splash_ad") || w.this.qg.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.gh.n.n().n("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1", w.this.n);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.n
    public void n(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.5
                @Override // java.lang.Runnable
                public void run() {
                    w.this.n(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void n(final int i) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.6
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "isWebViewCache", Integer.valueOf(i));
                    if (w.this.s != null) {
                        if (nf.rv(w.this.s)) {
                            w.this.n(jSONObject, "engine_version", "v3");
                        } else {
                            w.this.n(jSONObject, "engine_version", "v1");
                        }
                    }
                    w wVar = w.this;
                    wVar.n(wVar.fs, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void d() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.7
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.qg
    public void qg() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.8
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "native_render_end", jSONObject);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    w.this.n(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                    w wVar2 = w.this;
                    wVar2.n(wVar2.fs, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void rv() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.9
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void tj() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.10
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void cp() {
        q((JSONObject) null);
    }

    public void q(final JSONObject jSONObject) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    w.this.n(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void oa() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.13
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void sz() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.14
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void k() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.15
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "type", "native_enterBackground");
                    w wVar = w.this;
                    wVar.n(wVar.rv, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void cy() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.16
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "type", "native_enterForeground");
                    w wVar = w.this;
                    wVar.n(wVar.rv, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void n(final String str, final long j, final long j2, final int i) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "start_ts", Long.valueOf(j));
                    w.this.n(jSONObject, "end_ts", Long.valueOf(j2));
                    w.this.n(jSONObject, "intercept_type", Integer.valueOf(i));
                    w.this.n(jSONObject, "type", "intercept_html");
                    w.this.n(jSONObject, ImagesContract.URL, str);
                    w.this.n(jSONObject, MediationConstant.EXTRA_DURATION, Long.valueOf(j2 - j));
                    w wVar = w.this;
                    wVar.n(wVar.tj, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void qg(final String str, final long j, final long j2, final int i) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "start_ts", Long.valueOf(j));
                    w.this.n(jSONObject, "end_ts", Long.valueOf(j2));
                    w.this.n(jSONObject, "intercept_type", Integer.valueOf(i));
                    w.this.n(jSONObject, "type", "intercept_js");
                    w.this.n(jSONObject, ImagesContract.URL, str);
                    w.this.n(jSONObject, MediationConstant.EXTRA_DURATION, Long.valueOf(j2 - j));
                    w wVar = w.this;
                    wVar.n(wVar.tj, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void w(final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "jsb", str);
                    w wVar = w.this;
                    wVar.n(wVar.fs, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.l
    public void x(final String str) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w.this.n(jSONObject, "jsb", str);
                    w wVar = w.this;
                    wVar.n(wVar.fs, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.qg
    public void s() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.s
    public void w() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.22
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    w.this.n(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.s
    public void qg(final JSONObject jSONObject) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.23
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    w.this.n(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis));
                    w wVar = w.this;
                    wVar.n(wVar.fs, "render_did_finish", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.q
    public void s(final JSONObject jSONObject) {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (w.this.fs == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        w wVar = w.this;
                        wVar.n(wVar.fs, next, jSONObject.opt(next));
                    }
                    w.this.w = Boolean.TRUE;
                    w.this.fs();
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.q
    public void x() {
        this.l = Boolean.TRUE;
    }

    @Override // com.byazt.vgn.q
    public void n(boolean z) {
        this.x = Boolean.valueOf(z);
    }

    @Override // com.byazt.vgn.q
    public void fs() {
        try {
            rv.n().post(new Runnable() { // from class: com.byazt.vgn.w.25
                @Override // java.lang.Runnable
                public void run() {
                    if (w.this.cd() && !w.this.cp) {
                        if (w.this.rv != null && w.this.rv.length() != 0) {
                            try {
                                w.this.fs.put("native_switchBackgroundAndForeground", w.this.rv);
                            } catch (Exception unused) {
                            }
                        }
                        if (w.this.tj != null && w.this.tj.length() != 0) {
                            try {
                                w.this.fs.put("intercept_source", w.this.tj);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("webview_time_track", w.this.fs);
                        com.byazt.vyf.s.cy().pk();
                        com.byazt.hm.n.x(w.this.s, w.this.qg, "webview_time_track", map);
                        w.this.cp = true;
                    }
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.vgn.q
    public void n(boolean z, int i) {
        try {
            if (this.sz == null) {
                this.sz = new JSONObject();
            }
            this.sz.put("error_code", i);
            this.sz.put("webview_time_cost", System.currentTimeMillis() - this.oa.get());
            this.sz.put("webview_result", z ? 0 : 1);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.vgn.q
    public void n(int i, int i2, String str) {
        try {
            this.k = i;
            if (this.sz == null) {
                this.sz = new JSONObject();
            }
            this.sz.put("render_type", i);
            this.sz.put("error_code", i2);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.vgn.q
    public void qg(boolean z) {
        try {
            if (!this.cy && this.s != null) {
                this.cy = true;
                if (nf.s(this.s) == 0 && this.k != 0) {
                    if (this.sz == null) {
                        this.sz = new JSONObject();
                    }
                    this.sz.put("render_sequence", nf.s(this.s));
                    this.sz.put("render_control", nf.n(this.s));
                    this.sz.put("fetch_tpl_time_out", com.byazt.nf.rv.qg().n(this.qg, nf.s(this.s)));
                    this.sz.put("req_id", this.s.ou());
                    this.sz.put(MediationConstant.EXTRA_ADID, this.s.q());
                    this.sz.put("ad_slot_type", com.byazt.vgx.w.d(this.s));
                    if (z) {
                        this.sz.put("webview_time_cost", System.currentTimeMillis() - this.oa.get());
                        this.sz.put("webview_result", 2);
                    }
                    com.byazt.eji.s.n().n(this.sz);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cd() {
        if (this.x.booleanValue()) {
            return true;
        }
        return this.w.booleanValue() && this.l.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e) {
                e.getMessage();
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void n(JSONObject jSONObject, String str, Object obj) {
        n(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void qg(int i) {
        this.d = i;
    }
}
