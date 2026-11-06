package com.bytedance.sdk.openadsdk.core.zb;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t.u;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x implements com.bytedance.sdk.openadsdk.c.ms {
    private JSONArray ab;
    private Boolean ah;
    private JSONObject c;
    private int ch;
    private Boolean d;
    private AtomicLong hi;
    private Boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3866ms;
    private boolean ny;
    private JSONObject sl;
    private volatile boolean u;
    private JSONArray x;
    private lm xr;
    private volatile int zb;

    public x(String str, lm lmVar, JSONObject jSONObject) {
        this.f3866ms = "embeded_ad";
        this.ah = Boolean.FALSE;
        this.d = Boolean.FALSE;
        this.ka = Boolean.FALSE;
        this.ny = false;
        this.hi = new AtomicLong();
        this.zb = 0;
        this.u = false;
        this.f3866ms = str;
        this.xr = lmVar;
        this.c = jSONObject;
        this.ab = new JSONArray();
        this.x = new JSONArray();
    }

    protected x() {
        this.f3866ms = "embeded_ad";
        this.ah = Boolean.FALSE;
        this.d = Boolean.FALSE;
        this.ka = Boolean.FALSE;
        this.ny = false;
        this.hi = new AtomicLong();
        this.zb = 0;
        this.u = false;
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ah
    public void ms() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.hi.set(System.currentTimeMillis());
                    JSONObject jSONObject = new JSONObject();
                    x xVar = x.this;
                    xVar.ms(jSONObject, "ts", Long.valueOf(xVar.hi.get()));
                    x xVar2 = x.this;
                    xVar2.ms(jSONObject, "render_sequence", Integer.valueOf(xVar2.xr.du()));
                    x xVar3 = x.this;
                    xVar3.ms(jSONObject, "render_timeout", Integer.valueOf(xVar3.ch));
                    x.this.ms(jSONObject, "webview_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ka.ka.ms().ka()));
                    x.this.ms(jSONObject, "available_cache_count", Integer.valueOf(com.bytedance.sdk.component.adexpress.ka.ka.ms().ah()));
                    x xVar4 = x.this;
                    xVar4.ms(xVar4.c, "render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ah
    public void xr() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.12
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "render_success", jSONObject);
                    if (x.this.f3866ms.equals("splash_ad") || x.this.f3866ms.equals("cache_splash_ad")) {
                        return;
                    }
                    if (x.this.c.optInt("webview_source", -1) == 2) {
                        sl.ms(x.this.f3866ms, "no count ENDCARD_SOURCE");
                    } else {
                        com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("ugen_render", "h5_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                    }
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ah
    public void ms(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.26
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "code", Integer.valueOf(i));
                    String str2 = str;
                    if (str2 != null) {
                        x.this.ms(jSONObject, MediationConstant.KEY_REASON, str2);
                    }
                    x xVar = x.this;
                    xVar.ms(xVar.c, "render_error", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.xr
    public void ah() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.27
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "native_render_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void ms(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.28
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void xr(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.29
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void ah(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.30
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, str, jSONObject);
                    if (x.this.f3866ms.equals("splash_ad") || x.this.f3866ms.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void xr(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.31
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "code", Integer.valueOf(i));
                    x xVar = x.this;
                    xVar.ms(xVar.c, str, jSONObject);
                    if (x.this.f3866ms.equals("splash_ad") || x.this.f3866ms.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void d(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.2
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, str, jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void ka(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.3
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, str, jSONObject);
                    if (x.this.f3866ms.equals("splash_ad") || x.this.f3866ms.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("ugen_render", "native_render_success", String.valueOf(jCurrentTimeMillis) + "0");
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void ah(final int i, final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.4
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "code", Integer.valueOf(i));
                    x xVar = x.this;
                    xVar.ms(xVar.c, str, jSONObject);
                    if (x.this.f3866ms.equals("splash_ad") || x.this.f3866ms.equals("cache_splash_ad")) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.w.ms.ms().ms("ugen_render", "native_render_fail", String.valueOf(jCurrentTimeMillis) + "1");
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ms
    public void ms(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.5
                @Override // java.lang.Runnable
                public void run() {
                    x.this.ms(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "render_exception", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void ms(final int i) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.6
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "isWebViewCache", Integer.valueOf(i));
                    if (x.this.xr != null) {
                        if (x.this.xr.na()) {
                            x.this.ms(jSONObject, "engine_version", "v3");
                        } else {
                            x.this.ms(jSONObject, "engine_version", "v1");
                        }
                    }
                    x xVar = x.this;
                    xVar.ms(xVar.c, "before_webview_request", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void d() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.7
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "native_render_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.xr
    public void ka() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.8
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "native_render_end", jSONObject);
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    x.this.ms(jSONObject2, "ts", Long.valueOf(jCurrentTimeMillis2));
                    x xVar2 = x.this;
                    xVar2.ms(xVar2.c, "render_success", jSONObject2);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void c() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.9
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "webview_load_start", (Object) jSONObject, false);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void ab() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.10
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "webview_load_success", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void x() {
        xr((JSONObject) null);
    }

    public void xr(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.11
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    x.this.ms(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "webview_load_error", jSONObject2);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void ny() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.13
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "native_endcard_show", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void ch() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.14
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "native_endcard_close", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void hi() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.15
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "type", "native_enterBackground");
                    x xVar = x.this;
                    xVar.ms(xVar.ab, jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    public void sl() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.16
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "type", "native_enterForeground");
                    x xVar = x.this;
                    xVar.ms(xVar.ab, jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void ms(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.17
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "start_ts", Long.valueOf(j));
                    x.this.ms(jSONObject, "end_ts", Long.valueOf(j2));
                    x.this.ms(jSONObject, "intercept_type", Integer.valueOf(i));
                    x.this.ms(jSONObject, "type", "intercept_html");
                    x.this.ms(jSONObject, "url", str);
                    x.this.ms(jSONObject, "duration", Long.valueOf(j2 - j));
                    x xVar = x.this;
                    xVar.ms(xVar.x, jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void xr(final String str, final long j, final long j2, final int i) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.18
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str) || j2 < j) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "start_ts", Long.valueOf(j));
                    x.this.ms(jSONObject, "end_ts", Long.valueOf(j2));
                    x.this.ms(jSONObject, "intercept_type", Integer.valueOf(i));
                    x.this.ms(jSONObject, "type", "intercept_js");
                    x.this.ms(jSONObject, "url", str);
                    x.this.ms(jSONObject, "duration", Long.valueOf(j2 - j));
                    x xVar = x.this;
                    xVar.ms(xVar.x, jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void c(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.19
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "jsb", str);
                    x xVar = x.this;
                    xVar.ms(xVar.c, "webview_jsb_start", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.d
    public void ab(final String str) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.20
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x.this.ms(jSONObject, "jsb", str);
                    x xVar = x.this;
                    xVar.ms(xVar.c, "webview_jsb_end", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.xr
    public void zb() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.21
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "no_native_render", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ah
    public void u() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.22
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "render_failed", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.d.ah
    public void ub() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.23
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    x.this.ms(jSONObject, "ts", Long.valueOf(jCurrentTimeMillis));
                    x xVar = x.this;
                    xVar.ms(xVar.c, "render_did_finish", jSONObject);
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.ms
    public void ah(final JSONObject jSONObject) {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.24
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    if (x.this.c == null || (jSONObject2 = jSONObject) == null) {
                        return;
                    }
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        x xVar = x.this;
                        xVar.ms(xVar.c, next, jSONObject.opt(next));
                    }
                    x.this.d = Boolean.TRUE;
                    x.this.h();
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.ms
    public void ao() {
        this.ah = Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.openadsdk.c.ms
    public void ms(boolean z) {
        this.ka = Boolean.valueOf(z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.ms
    public void h() {
        try {
            com.bytedance.sdk.component.utils.x.ms().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.zb.x.25
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.qv() && !x.this.ny) {
                        if (x.this.ab != null && x.this.ab.length() != 0) {
                            try {
                                x.this.c.put("native_switchBackgroundAndForeground", x.this.ab);
                            } catch (Exception unused) {
                            }
                        }
                        if (x.this.x != null && x.this.x.length() != 0) {
                            try {
                                x.this.c.put("intercept_source", x.this.x);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap map = new HashMap();
                        map.put("webview_time_track", x.this.c);
                        ch.ub().fm();
                        ah.ab(x.this.xr, x.this.f3866ms, "webview_time_track", map);
                        x.this.ny = true;
                    }
                }
            });
        } catch (Throwable th) {
            sl.xr("WebviewTimeTrack", th.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.ms
    public void ms(boolean z, int i) {
        try {
            if (this.sl == null) {
                this.sl = new JSONObject();
            }
            this.sl.put("error_code", i);
            this.sl.put("webview_time_cost", System.currentTimeMillis() - this.hi.get());
            this.sl.put("webview_result", z ? 0 : 1);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.ms
    public void ms(int i, int i2, String str) {
        try {
            this.zb = i;
            if (this.sl == null) {
                this.sl = new JSONObject();
            }
            this.sl.put(j.w.E, i);
            this.sl.put("error_code", i2);
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.ms
    public void xr(boolean z) {
        try {
            if (!this.u && this.xr != null) {
                this.u = true;
                if (this.xr.du() == 0 && this.zb != 0) {
                    if (this.sl == null) {
                        this.sl = new JSONObject();
                    }
                    this.sl.put("render_sequence", this.xr.du());
                    this.sl.put("render_control", this.xr.fm());
                    this.sl.put("fetch_tpl_time_out", re.xr().ms(this.f3866ms, this.xr.du()));
                    this.sl.put("req_id", this.xr.eu());
                    this.sl.put("ad_id", this.xr.df());
                    this.sl.put("ad_slot_type", f.x(this.xr));
                    if (z) {
                        this.sl.put("webview_time_cost", System.currentTimeMillis() - this.hi.get());
                        this.sl.put("webview_result", 2);
                    }
                    u.ms().ms(this.sl);
                }
            }
        } catch (Exception e) {
            sl.ms(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qv() {
        if (this.ka.booleanValue()) {
            return true;
        }
        return this.d.booleanValue() && this.ah.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception e) {
                sl.xr("WebviewTimeTrack", e.getMessage());
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    public void ms(JSONObject jSONObject, String str, Object obj) {
        ms(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(JSONArray jSONArray, Object obj) {
        if (jSONArray == null || jSONArray.length() >= 10) {
            return;
        }
        try {
            jSONArray.put(obj);
        } catch (Exception e) {
            sl.xr("WebviewTimeTrack", e.getMessage());
        }
    }

    public void xr(int i) {
        this.ch = i;
    }
}
