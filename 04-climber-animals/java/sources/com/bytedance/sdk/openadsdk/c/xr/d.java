package com.bytedance.sdk.openadsdk.c.xr;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.ah.ab;
import com.bytedance.sdk.openadsdk.c.ah.ao;
import com.bytedance.sdk.openadsdk.c.ah.c;
import com.bytedance.sdk.openadsdk.c.ah.h;
import com.bytedance.sdk.openadsdk.c.ah.hi;
import com.bytedance.sdk.openadsdk.c.ah.ka;
import com.bytedance.sdk.openadsdk.c.ah.sl;
import com.bytedance.sdk.openadsdk.c.ah.u;
import com.bytedance.sdk.openadsdk.c.ah.ub;
import com.bytedance.sdk.openadsdk.c.ah.x;
import com.bytedance.sdk.openadsdk.c.ah.zb;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.op.ch;
import com.bytedance.sdk.openadsdk.op.ny;
import com.taptap.sdk.db.constant.Common;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Map<com.bykv.vk.openvk.component.video.api.xr.ms, h> f1862ms = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject ms(com.bykv.vk.openvk.component.video.api.ah.d dVar, String str, int i, int i2, lm lmVar, long j) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarRe;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (ch.ms(lmVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (dVar != null) {
                if (dVar.u()) {
                    ahVarRe = dVar.i();
                    jSONObject.put("codec", "h265");
                } else {
                    ahVarRe = dVar.re();
                }
                if (ahVarRe != null) {
                    jSONObject.put("video_resolution", ahVarRe.ny());
                    jSONObject.put("video_size", Long.valueOf(ahVarRe.ka()));
                    String strSl = ahVarRe.sl();
                    jSONObject.put("video_url", strSl);
                    jSONObject.put("is_expired", f.u(strSl));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (f.sl(lmVar) * 1000.0d)));
                    jSONObject.put("start_duration", j);
                    jSONObject.put("player_type", i2);
                    jSONObject.put("play_speed_ratio", ahVarRe.x());
                    if (ahVarRe.ab() > 0.0d) {
                        jSONObject.put("start", ahVarRe.ab());
                    }
                }
            }
            if (lmVar != null) {
                jSONObject.put("dynamic_join_type", lmVar.tf());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void ms(com.bytedance.sdk.openadsdk.c.ah.xr<sl> xrVar) {
        xr(xrVar, "load_video_start");
    }

    public static void xr(com.bytedance.sdk.openadsdk.c.ah.xr<zb> xrVar) {
        xr(xrVar, "load_video_success");
    }

    public static void ah(com.bytedance.sdk.openadsdk.c.ah.xr<hi> xrVar) {
        xr(xrVar, "load_video_error");
    }

    public static void d(com.bytedance.sdk.openadsdk.c.ah.xr<com.bytedance.sdk.openadsdk.c.ah.ch> xrVar) {
        xr(xrVar, "load_video_cancel");
    }

    public static boolean ms(lm lmVar, com.bykv.vk.openvk.component.video.api.xr.ms msVar, com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        int iPd = lmVar.pd();
        com.bykv.vk.openvk.component.video.api.ms.xr xrVarMs = ny.ms(iPd);
        if (iPd != 0) {
            if (iPd == 1) {
                return xrVarMs.ms(dVar);
            }
            return false;
        }
        long jXr = xrVarMs.xr(dVar);
        boolean zZb = dVar.zb();
        int iC = dVar.c();
        if (zZb) {
            iC = (int) dVar.sl();
        }
        int iXr = dVar.xr();
        if (iXr > 0) {
            iC = iXr;
        }
        return jXr >= ((long) iC);
    }

    public static void ms(final lm lmVar, final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final com.bykv.vk.openvk.component.video.api.ah.d dVar, final boolean z) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (lmVar == null || msVar == null || dVar == null) {
                    return;
                }
                String string = UUID.randomUUID().toString();
                com.bykv.vk.openvk.component.video.api.ms.xr xrVarMs = ny.ms(lmVar.pd());
                int i = d.ms(lmVar, msVar, dVar) ? 1 : 2;
                d.f1862ms.put(msVar, new h(SystemClock.elapsedRealtime(), string, i, dVar, lmVar));
                long jXr = xrVarMs.xr(dVar);
                ao aoVar = new ao();
                if (jXr > 0) {
                    aoVar.ms(jXr);
                }
                aoVar.ms(z);
                com.bytedance.sdk.openadsdk.core.w.zb.ms(i, jXr, lmVar, dVar);
                com.bykv.vk.openvk.component.video.api.ah.d dVar2 = dVar;
                JSONObject jSONObjectMs = d.ms(dVar2, string, i, dVar2.qv(), lmVar, 0L);
                d.ms(jSONObjectMs, dVar.ka("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVar, f.xr(lmVar), jSONObjectMs, aoVar);
                xrVar.ms(dVar.qv() == -1);
                d.xr(xrVar, "play_start");
            }
        });
    }

    public static void ms(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.4
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                if (msVar == null || msVar2 == null || (hVar = (h) d.f1862ms.get(msVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                lm lmVarKa = hVar.ka();
                if (dVarD == null || lmVarKa == null) {
                    return;
                }
                if (!ch.ms(lmVarKa) || t.xr(lmVarKa)) {
                    if (!msVar2.zb()) {
                        d.xr(lmVarKa, dVarD, msVar2);
                    }
                    com.bytedance.sdk.openadsdk.c.ah.ny nyVar = new com.bytedance.sdk.openadsdk.c.ah.ny();
                    nyVar.xr(msVar2.u() ? 1 : 0);
                    nyVar.ms(msVar2.ub() ? 1 : 0);
                    nyVar.xr(ny.ms(lmVarKa.pd()).xr(dVarD));
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - hVar.ms();
                    nyVar.ms(jElapsedRealtime);
                    JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, jElapsedRealtime);
                    d.ms(jSONObjectMs, dVarD.ka("EXTRA_PLAY_START"));
                    com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, nyVar);
                    xrVar.ms(msVar2.zb());
                    d.xr(xrVar, d.xr(lmVarKa, "feed_play"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xr(lm lmVar, String str) {
        if (lmVar == null || !f.c(lmVar) || !f.ab(lmVar)) {
            return str;
        }
        str.hashCode();
        switch (str) {
            case "feed_over":
                return "play_over";
            case "feed_play":
                return "play";
            case "feed_break":
                return "play_break";
            default:
                return str;
        }
    }

    public static String ms(com.bykv.vk.openvk.component.video.api.xr.ms msVar) {
        h hVar;
        if (msVar == null || (hVar = f1862ms.get(msVar)) == null) {
            return "empty";
        }
        String strXr = hVar.xr();
        return TextUtils.isEmpty(strXr) ? "empty" : strXr;
    }

    public static void ms(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2, final int i) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.5
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                if (msVar == null || msVar2 == null || (hVar = (h) d.f1862ms.get(msVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                lm lmVarKa = hVar.ka();
                if (dVarD == null || lmVarKa == null) {
                    return;
                }
                long jXr = msVar2.xr();
                long jD = msVar2.d();
                if (jD <= 0 || jXr <= 0) {
                    return;
                }
                x xVar = new x();
                xVar.ms(msVar2.ah());
                xVar.xr(jD);
                xVar.ms(i);
                xVar.ms(msVar2.ao());
                JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, SystemClock.elapsedRealtime() - hVar.ms());
                d.ms(jSONObjectMs, dVarD.ka("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, xVar);
                xrVar.ms(msVar2.zb());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jXr);
                    jSONObject.put("percent", msVar2.ny());
                    d.xr(xrVar, "feed_pause", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        });
    }

    public static void xr(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.6
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                if (msVar == null || msVar2 == null || (hVar = (h) d.f1862ms.get(msVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                lm lmVarKa = hVar.ka();
                if (dVarD == null || lmVarKa == null) {
                    return;
                }
                long jXr = msVar2.xr();
                long jD = msVar2.d();
                if (jD <= 0 || jXr <= 0) {
                    return;
                }
                c cVar = new c();
                cVar.ms(msVar2.ah());
                cVar.xr(jD);
                JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, SystemClock.elapsedRealtime() - hVar.ms());
                d.ms(jSONObjectMs, dVarD.ka("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, cVar);
                xrVar.ms(msVar2.zb());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jXr);
                    jSONObject.put("percent", msVar2.ny());
                    d.xr(xrVar, "feed_continue", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
            }
        });
    }

    public static void ms(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2, final String str, final int i, final boolean z) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.7
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                if (msVar == null || msVar2 == null || (hVar = (h) d.f1862ms.get(msVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                lm lmVarKa = hVar.ka();
                if (dVarD == null || lmVarKa == null) {
                    return;
                }
                long jXr = msVar2.xr();
                long jD = msVar2.d();
                if (jD < 0) {
                    return;
                }
                ub ubVar = new ub();
                ubVar.ah(msVar2.ah());
                ubVar.d(jD);
                ubVar.ah(msVar2.ka());
                ubVar.d(msVar2.c());
                ubVar.xr(i);
                ubVar.xr(ny.ms(lmVarKa.pd()).xr(dVarD));
                ubVar.ms(str);
                JSONArray jSONArrayMs = msVar2.ms();
                if (jSONArrayMs != null) {
                    ubVar.ms(jSONArrayMs);
                }
                ubVar.ms(jXr);
                ubVar.ms(msVar2.ny());
                ubVar.ms(z);
                JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, SystemClock.elapsedRealtime() - hVar.ms());
                d.ms(jSONObjectMs, dVarD.ka("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, ubVar);
                xrVar.ms(msVar2.zb());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jXr);
                    jSONObject.put("percent", msVar2.ny());
                    d.xr(xrVar, "play_error", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
                ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.f1862ms.remove(msVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void ah(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.8
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                if (msVar == null || msVar2 == null || (hVar = (h) d.f1862ms.get(msVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                lm lmVarKa = hVar.ka();
                if (dVarD == null || lmVarKa == null) {
                    return;
                }
                long jXr = msVar2.xr();
                long jD = msVar2.d();
                com.bytedance.sdk.openadsdk.c.ah.ah ahVar = new com.bytedance.sdk.openadsdk.c.ah.ah();
                ahVar.ah(msVar2.ah());
                ahVar.d(jD);
                ahVar.xr(msVar2.ab());
                ahVar.ah(msVar2.x());
                ahVar.xr(ny.ms(lmVarKa.pd()).xr(dVarD));
                ahVar.ms(jXr);
                ahVar.ms(msVar2.ny());
                JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, SystemClock.elapsedRealtime() - hVar.ms());
                d.ms(jSONObjectMs, dVarD.ka("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, ahVar);
                xrVar.ms(msVar2.zb());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jXr);
                    jSONObject.put("percent", msVar2.ny());
                    d.xr(xrVar, "endcard_skip", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
                ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.f1862ms.remove(msVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void ms(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2, final Map<String, Object> map, final int i) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.9
            @Override // java.lang.Runnable
            public void run() {
                h hVar;
                if (msVar == null || msVar2 == null || (hVar = (h) d.f1862ms.get(msVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                lm lmVarKa = hVar.ka();
                if (dVarD == null || lmVarKa == null) {
                    return;
                }
                long jXr = msVar2.xr();
                long jD = msVar2.d();
                if (jD <= 0) {
                    return;
                }
                ka kaVar = new ka();
                kaVar.xr(msVar2.ah());
                kaVar.ms(jD);
                kaVar.xr(msVar2.ch());
                kaVar.ah(msVar2.hi());
                kaVar.ms(i);
                JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, SystemClock.elapsedRealtime() - hVar.ms());
                d.ms(jSONObjectMs, map);
                com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, kaVar);
                xrVar.ms(msVar2.zb());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jXr);
                    jSONObject.put("percent", msVar2.ny());
                    com.bytedance.sdk.openadsdk.core.w.zb.ms(jXr, lmVarKa, dVarD);
                    d.xr(xrVar, d.xr(lmVarKa, "feed_break"), jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
                d.f1862ms.remove(msVar);
            }
        });
    }

    public static void d(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.10
            @Override // java.lang.Runnable
            public void run() {
                h.ms msVar3;
                com.bykv.vk.openvk.component.video.api.xr.ms msVar4 = msVar;
                if (msVar4 == null || (msVar3 = msVar2) == null) {
                    return;
                }
                d.ka(msVar4, msVar3);
                h hVar = (h) d.f1862ms.get(msVar);
                if (hVar == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                lm lmVarKa = hVar.ka();
                if (dVarD == null || lmVarKa == null) {
                    return;
                }
                long jXr = msVar2.xr();
                long jD = msVar2.d();
                if (jD <= 0) {
                    return;
                }
                ab abVar = new ab();
                abVar.xr(msVar2.ah());
                abVar.ms(jD);
                abVar.ms(msVar2.hi());
                JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, SystemClock.elapsedRealtime() - hVar.ms());
                d.ms(jSONObjectMs, dVarD.ka("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, abVar);
                xrVar.ms(msVar2.zb());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jXr);
                    jSONObject.put("percent", msVar2.ny());
                    com.bytedance.sdk.openadsdk.core.w.zb.ms(jXr, lmVarKa, dVarD);
                    d.xr(xrVar, d.xr(lmVarKa, "feed_over"), jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
                d.f1862ms.remove(msVar);
            }
        });
    }

    public static void ka(final com.bykv.vk.openvk.component.video.api.xr.ms msVar, final h.ms msVar2) {
        ah.ms().ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.11
            @Override // java.lang.Runnable
            public void run() {
                h.ms msVar3;
                if (msVar == null || (msVar3 = msVar2) == null) {
                    return;
                }
                if (msVar3.sl() > 0) {
                    h hVar = (h) d.f1862ms.get(msVar);
                    if (hVar == null) {
                        return;
                    }
                    com.bykv.vk.openvk.component.video.api.ah.d dVarD = hVar.d();
                    lm lmVarKa = hVar.ka();
                    if (dVarD == null || lmVarKa == null) {
                        return;
                    }
                    long jD = msVar2.d();
                    if (jD <= 0) {
                        return;
                    }
                    u uVar = new u();
                    uVar.ms(msVar2.ah());
                    uVar.xr(jD);
                    uVar.ms(msVar2.sl());
                    JSONObject jSONObjectMs = d.ms(dVarD, hVar.xr(), hVar.ah(), dVarD.qv(), lmVarKa, SystemClock.elapsedRealtime() - hVar.ms());
                    d.ms(jSONObjectMs, dVarD.ka("EXTRA_PLAY_ACTION"));
                    com.bytedance.sdk.openadsdk.c.ah.xr xrVar = new com.bytedance.sdk.openadsdk.c.ah.xr(lmVarKa, f.xr(lmVarKa), jSONObjectMs, uVar);
                    xrVar.ms(msVar2.zb());
                    d.xr(xrVar, "play_buffer");
                    return;
                }
                com.bytedance.sdk.component.utils.sl.ms("VideoEventManager", "Cancel log report when buffer count is 0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(com.bytedance.sdk.openadsdk.c.ah.xr xrVar, String str) {
        xr(xrVar, str, (JSONObject) null);
    }

    private static boolean ka(com.bytedance.sdk.openadsdk.c.ah.xr xrVar) {
        lm lmVarMs;
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt;
        if (xrVar == null || !xrVar.ka() || (lmVarMs = xrVar.ms()) == null || (xrVarRt = lmVarMs.rt()) == null) {
            return false;
        }
        String strB = xrVarRt.b();
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strB);
            int length = jSONArray.length();
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArray.getJSONObject(i).optString(Common.System.NAME);
                if ("content_did".equalsIgnoreCase(strOptString)) {
                    z = true;
                } else if ("content_utmsource".equalsIgnoreCase(strOptString)) {
                    z2 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(strOptString)) {
                    z3 = true;
                }
            }
            return z && z2 && z3;
        } catch (JSONException e) {
            e.getMessage();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final com.bytedance.sdk.openadsdk.c.ah.xr xrVar, String str, JSONObject jSONObject) {
        if (xrVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (xrVar.ka() && !TextUtils.isEmpty(xrVar.xr()) && !ka(xrVar)) {
            String strXr = xrVar.xr();
            strXr.hashCode();
            switch (strXr) {
                case "stream":
                case "embeded_ad":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        xr.ms(str, xrVar.ms());
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(xrVar.ms(), xrVar.xr(), str, jSONObject, new com.bytedance.sdk.openadsdk.c.ms.ms() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.2
            @Override // com.bytedance.sdk.openadsdk.c.ms.ms
            public void ms(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObjectAh = xrVar.ah();
                if (xrVar.d() != null) {
                    xrVar.d().a_(jSONObjectAh);
                }
                jSONObject2.put("ad_extra_data", jSONObjectAh.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xr(final lm lmVar, final com.bykv.vk.openvk.component.video.api.ah.d dVar, final h.ms msVar) {
        com.bytedance.sdk.openadsdk.core.t.u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.c.xr.d.3
            @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
            public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", d.ah(dVar));
                jSONObject.put("player_duration", msVar.d());
                jSONObject.put("cache_path_type", ny.d());
                jSONObject.put("url", dVar.ao());
                jSONObject.put("path", d.d(dVar));
                jSONObject.put("player_type", dVar.qv());
                return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("pangle_video_play_state").ms(f.x(lmVar)).xr(jSONObject.toString());
            }
        }, "pangle_video_play_state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long ah(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        if (dVar == null) {
            return 0L;
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarI = dVar.u() ? dVar.i() : dVar.re();
        if (ahVarI != null) {
            return Double.valueOf(ahVarI.c() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        return new File(dVar.ka(), dVar.h()).getAbsolutePath();
    }

    public static synchronized com.bykv.vk.openvk.component.video.api.ah.d xr(com.bykv.vk.openvk.component.video.api.xr.ms msVar) {
        if (msVar == null) {
            return null;
        }
        h hVar = f1862ms.get(msVar);
        if (hVar == null) {
            return null;
        }
        return hVar.d();
    }

    public static void ms(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
    }
}
