package com.byazt.pj;

import android.text.TextUtils;
import com.byazt.ca.aj;
import com.byazt.hg.cr;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.mg.PluginConstants;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 115, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements com.byazt.ko.pr {
    public JSONArray aj;
    public Boolean c;
    public Boolean fw;
    public JSONObject g;
    public of hn;
    public volatile int ho;
    public String hw;
    public int k;
    public AtomicLong m;
    public volatile boolean nt;
    public String pr;
    public Boolean uc;
    public JSONArray vk;
    public boolean w;
    public JSONObject x;
    public JSONObject zo;

    public zo(String str, of ofVar, JSONObject jSONObject, JSONObject jSONObject2) {
        this.hw = com.byazt.pfl.hw.AD_TAG_FEED;
        this.c = Boolean.FALSE;
        this.uc = Boolean.FALSE;
        this.fw = Boolean.FALSE;
        this.w = false;
        this.m = new AtomicLong();
        this.ho = 0;
        this.nt = false;
        this.hw = str;
        this.hn = ofVar;
        this.zo = jSONObject;
        this.aj = new JSONArray();
        this.vk = new JSONArray();
        this.x = jSONObject2;
        this.pr = ofVar == null ? com.byazt.zb.pr.x() : ofVar.yn();
    }

    public zo() {
        this.hw = com.byazt.pfl.hw.AD_TAG_FEED;
        this.c = Boolean.FALSE;
        this.uc = Boolean.FALSE;
        this.fw = Boolean.FALSE;
        this.w = false;
        this.m = new AtomicLong();
        this.ho = 0;
        this.nt = false;
    }

    @Override // com.byazt.uf.hn
    public void pr() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.1
                @Override // java.lang.Runnable
                public void run() {
                    zo.this.m.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    zo zoVar = zo.this;
                    zoVar.pr(jSONObject, "ts", Long.valueOf(zoVar.m.get()));
                    zo zoVar2 = zo.this;
                    zoVar2.pr(jSONObject, "render_sequence", Integer.valueOf(ie.hn(zoVar2.hn)));
                    zo zoVar3 = zo.this;
                    zoVar3.pr(jSONObject, "render_timeout", Integer.valueOf(zoVar3.k));
                    zo.this.pr(jSONObject, "webview_count", Integer.valueOf(com.byazt.kq.c.pr().c()));
                    zo.this.pr(jSONObject, "available_cache_count", Integer.valueOf(com.byazt.kq.c.pr().hn()));
                    cr crVarZo = ie.zo(zo.this.hn);
                    if (crVarZo != null) {
                        zo.this.pr(jSONObject, "rule_id", crVarZo.zo());
                    } else {
                        zo.this.pr(jSONObject, "rule_id", "0");
                    }
                    JSONObject jSONObjectYb = zo.this.yb();
                    if (jSONObjectYb != null) {
                        zo.this.pr(jSONObject, "size", jSONObjectYb);
                    }
                    zo zoVar4 = zo.this;
                    zoVar4.pr(zoVar4.zo, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject yb() {
        JSONObject jSONObject = this.x;
        if (jSONObject == null || !jSONObject.has("xSize")) {
            return null;
        }
        Object objOpt = this.x.opt("xSize");
        if (objOpt instanceof JSONObject) {
            JSONObject jSONObject2 = (JSONObject) objOpt;
            if (jSONObject2.has("width") && jSONObject2.has("height")) {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.putOpt("width", Double.valueOf(((JSONObject) objOpt).optDouble("width")));
                    jSONObject3.putOpt("height", Double.valueOf(((JSONObject) objOpt).optDouble("height")));
                    return jSONObject3;
                } catch (Throwable th) {
                    return null;
                }
            }
        }
        return null;
    }

    @Override // com.byazt.uf.hn
    public void hw() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.12
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "render_success", jSONObject);
                    if (zo.this.hw.equals("splash_ad") || zo.this.hw.equals("cache_splash_ad") || zo.this.zo.optInt("webview_source", -1) == 2) {
                        return;
                    }
                    com.byazt.ba.pr.pr().pr("ugen_render", "h5_render_success", String.valueOf(jCurrentTimeMillis) + "0", zo.this.pr);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.hn
    public void pr(final int i, final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.26
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                    String str2 = str;
                    if (str2 != null) {
                        zo.this.pr(jSONObject, MediationConstant.KEY_REASON, str2);
                    }
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.hw
    public void hn() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.27
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void pr(final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.28
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void hw(final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.29
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void hn(final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.30
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, str, jSONObject);
                    if (zo.this.hw.equals("splash_ad") || zo.this.hw.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.ba.pr.pr().pr("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0", zo.this.pr);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void hw(final int i, final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.31
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, str, jSONObject);
                    if (zo.this.hw.equals("splash_ad") || zo.this.hw.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.ba.pr.pr().pr("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1", zo.this.pr);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void x(final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.2
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void c(final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, str, jSONObject);
                    if (zo.this.hw.equals("splash_ad") || zo.this.hw.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.ba.pr.pr().pr("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0", zo.this.pr);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void hn(final int i, final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.4
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, PluginConstants.KEY_ERROR_CODE, Integer.valueOf(i));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, str, jSONObject);
                    if (zo.this.hw.equals("splash_ad") || zo.this.hw.equals("cache_splash_ad")) {
                        return;
                    }
                    com.byazt.ba.pr.pr().pr("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1", zo.this.pr);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.pr
    public void pr(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.5
                @Override // java.lang.Runnable
                public void run() {
                    zo.this.pr(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void pr(final int i) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.6
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, "isWebViewCache", Integer.valueOf(i));
                    if (zo.this.hn != null) {
                        if (ie.aj(zo.this.hn)) {
                            zo.this.pr(jSONObject, "engine_version", "v3");
                        } else {
                            zo.this.pr(jSONObject, "engine_version", "v1");
                        }
                    }
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void x() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.7
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.hw
    public void c() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.8
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "native_render_end", jSONObject);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    zo.this.pr(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                    zo zoVar2 = zo.this;
                    zoVar2.pr(zoVar2.zo, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void uc() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.9
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void fw() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.10
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void zo() {
        hw((JSONObject) null);
    }

    public void hw(final JSONObject jSONObject) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    zo.this.pr(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void aj() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.13
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void vk() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.14
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void w() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.15
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, "type", "native_enterBackground");
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.aj, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void k() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.16
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, "type", "native_enterForeground");
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.aj, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void pr(final String str, final long j, final long j2, final int i) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "start_ts", Long.valueOf(j));
                    zo.this.pr(jSONObject, "end_ts", Long.valueOf(j2));
                    zo.this.pr(jSONObject, "intercept_type", Integer.valueOf(i));
                    zo.this.pr(jSONObject, "type", "intercept_html");
                    zo.this.pr(jSONObject, BreakpointSQLiteKey.URL, str);
                    zo.this.pr(jSONObject, "duration", Long.valueOf(j2 - j));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.vk, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void hw(final String str, final long j, final long j2, final int i) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "start_ts", Long.valueOf(j));
                    zo.this.pr(jSONObject, "end_ts", Long.valueOf(j2));
                    zo.this.pr(jSONObject, "intercept_type", Integer.valueOf(i));
                    zo.this.pr(jSONObject, "type", "intercept_js");
                    zo.this.pr(jSONObject, BreakpointSQLiteKey.URL, str);
                    zo.this.pr(jSONObject, "duration", Long.valueOf(j2 - j));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.vk, jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void uc(final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, "jsb", str);
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.x
    public void fw(final String str) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo.this.pr(jSONObject, "jsb", str);
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.hw
    public void m() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.hn
    public void g() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.22
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    zo.this.pr(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.uf.hn
    public void hn(final JSONObject jSONObject) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.23
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    zo.this.pr(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis));
                    zo zoVar = zo.this;
                    zoVar.pr(zoVar.zo, "render_did_finish", jSONObject2);
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.ko.pr
    public void x(final JSONObject jSONObject) {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (zo.this.zo == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        zo zoVar = zo.this;
                        zoVar.pr(zoVar.zo, next, jSONObject.opt(next));
                    }
                    zo.this.uc = Boolean.TRUE;
                    zo.this.nt();
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.ko.pr
    public void ho() {
        this.c = Boolean.TRUE;
    }

    @Override // com.byazt.ko.pr
    public void pr(boolean z) {
        this.fw = Boolean.valueOf(z);
    }

    @Override // com.byazt.ko.pr
    public void nt() {
        try {
            aj.pr().post(new Runnable() { // from class: com.byazt.pj.zo.25
                @Override // java.lang.Runnable
                public void run() {
                    if (zo.this.lb() && !zo.this.w) {
                        if (zo.this.aj != null && zo.this.aj.length() != 0) {
                            try {
                                zo.this.zo.put("native_switchBackgroundAndForeground", zo.this.aj);
                            } catch (Exception e) {
                            }
                        }
                        if (zo.this.vk != null && zo.this.vk.length() != 0) {
                            try {
                                zo.this.zo.put("intercept_source", zo.this.vk);
                            } catch (Exception e2) {
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("webview_time_track", zo.this.zo);
                        com.byazt.sd.zo.nt().of();
                        pr.fw(zo.this.hn, zo.this.hw, "webview_time_track", map);
                        zo.this.w = true;
                    }
                }
            });
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // com.byazt.ko.pr
    public void pr(boolean z, int i) {
        try {
            if (this.g == null) {
                this.g = new JSONObject();
            }
            this.g.put(Constants.ERROR_CODE_FIELD, i);
            this.g.put("webview_time_cost", System.currentTimeMillis() - this.m.get());
            this.g.put("webview_result", z ? 0 : 1);
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.ko.pr
    public void pr(int i, int i2, String str) {
        try {
            this.ho = i;
            if (this.g == null) {
                this.g = new JSONObject();
            }
            this.g.put("render_type", i);
            this.g.put(Constants.ERROR_CODE_FIELD, i2);
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.ko.pr
    public void hw(boolean z) {
        try {
            if (!this.nt && this.hn != null) {
                this.nt = true;
                if (ie.hn(this.hn) == 0 && this.ho != 0) {
                    if (this.g == null) {
                        this.g = new JSONObject();
                    }
                    this.g.put("render_sequence", ie.hn(this.hn));
                    this.g.put("render_control", ie.pr(this.hn));
                    this.g.put("fetch_tpl_time_out", a.hw().pr(this.hw, ie.hn(this.hn)));
                    this.g.put("req_id", this.hn.ny());
                    this.g.put(MediationConstant.EXTRA_ADID, this.hn.x());
                    this.g.put("ad_slot_type", ls.k(this.hn));
                    if (z) {
                        this.g.put("webview_time_cost", System.currentTimeMillis() - this.m.get());
                        this.g.put("webview_result", 2);
                    }
                    com.byazt.xk.hw.pr().pr(this.g);
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lb() {
        if (this.fw.booleanValue()) {
            return true;
        }
        return this.uc.booleanValue() && this.c.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(JSONObject jSONObject, String str, Object obj, boolean z) {
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

    public void pr(JSONObject jSONObject, String str, Object obj) {
        pr(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void hw(int i) {
        this.k = i;
    }
}
