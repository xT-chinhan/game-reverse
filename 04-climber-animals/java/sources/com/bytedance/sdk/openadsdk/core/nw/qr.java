package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.bv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class qr {
    private com.bykv.vk.openvk.component.video.api.ah.ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.ah.ah f3088ms;
    private com.bykv.vk.openvk.component.video.api.ah.ah xr;

    public qr() {
    }

    public qr(JSONObject jSONObject) {
        String str;
        qr qrVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject != null) {
            com.bykv.vk.openvk.component.video.api.ah.ah ahVar = new com.bykv.vk.openvk.component.video.api.ah.ah();
            ahVar.xr(jSONObjectOptJSONObject.optInt("cover_height"));
            ahVar.ah(jSONObjectOptJSONObject.optInt("cover_width"));
            ahVar.ms(jSONObjectOptJSONObject.optString(bv.z));
            ahVar.ms(jSONObjectOptJSONObject.optLong("size"));
            ahVar.ms(jSONObjectOptJSONObject.optDouble("video_duration"));
            ahVar.xr(jSONObjectOptJSONObject.optString("cover_url"));
            ahVar.ah(jSONObjectOptJSONObject.optString("video_url"));
            ahVar.d(jSONObjectOptJSONObject.optString("endcard"));
            ahVar.ka(jSONObjectOptJSONObject.optString("file_hash"));
            ahVar.ms((float) jSONObjectOptJSONObject.optDouble("play_speed_ratio", -1.0d));
            ahVar.ms(jSONObjectOptJSONObject.optInt("fallback_endcard_judge", 0));
            ahVar.d(jSONObjectOptJSONObject.optInt("video_preload_size", 307200));
            ahVar.ka(jSONObjectOptJSONObject.optInt("reward_video_cached_type", 0));
            ahVar.c(jSONObjectOptJSONObject.optInt("execute_cached_type", 0));
            ahVar.xr(jSONObjectOptJSONObject.optDouble("start", -1.0d));
            qrVar = this;
            str = "size";
            qrVar.f3088ms = ahVar;
        } else {
            str = "size";
            qrVar = this;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject2 != null) {
            com.bykv.vk.openvk.component.video.api.ah.ah ahVar2 = new com.bykv.vk.openvk.component.video.api.ah.ah();
            ahVar2.xr(jSONObjectOptJSONObject2.optInt("cover_height"));
            ahVar2.ah(jSONObjectOptJSONObject2.optInt("cover_width"));
            ahVar2.ms(jSONObjectOptJSONObject2.optString(bv.z));
            ahVar2.ms(jSONObjectOptJSONObject2.optLong(str));
            ahVar2.ms(jSONObjectOptJSONObject2.optDouble("video_duration"));
            ahVar2.xr(jSONObjectOptJSONObject2.optString("cover_url"));
            ahVar2.ah(jSONObjectOptJSONObject2.optString("video_url"));
            ahVar2.d(jSONObjectOptJSONObject2.optString("endcard"));
            ahVar2.ka(jSONObjectOptJSONObject2.optString("file_hash"));
            ahVar2.ms((float) jSONObjectOptJSONObject2.optDouble("play_speed_ratio", -1.0d));
            ahVar2.ms(jSONObjectOptJSONObject2.optInt("fallback_endcard_judge", 0));
            ahVar2.d(jSONObjectOptJSONObject2.optInt("video_preload_size", 307200));
            ahVar2.ka(jSONObjectOptJSONObject2.optInt("reward_video_cached_type", 0));
            ahVar2.c(jSONObjectOptJSONObject2.optInt("execute_cached_type", 0));
            ahVar2.xr(jSONObjectOptJSONObject2.optDouble("start", -1.0d));
            qrVar.xr = ahVar2;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("audio");
        if (jSONObjectOptJSONObject3 != null) {
            com.bykv.vk.openvk.component.video.api.ah.ms msVar = new com.bykv.vk.openvk.component.video.api.ah.ms();
            msVar.xr(jSONObjectOptJSONObject3.optString("audio_url"));
            msVar.ms(jSONObjectOptJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            msVar.xr(jSONObjectOptJSONObject3.optLong("audio_preload_size", -2147483648L));
            msVar.ms(jSONObjectOptJSONObject3.optLong(str, -2147483648L));
            msVar.ms(jSONObjectOptJSONObject3.optString("file_hash"));
            msVar.xr(jSONObjectOptJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            msVar.ms(jSONObjectOptJSONObject3.optDouble("start", -1.0d));
            msVar.xr(jSONObjectOptJSONObject3.optInt("repeat_count", 0));
            qrVar.ah = msVar;
        }
    }

    public void ms(JSONObject jSONObject) {
        try {
            com.bykv.vk.openvk.component.video.api.ah.ah ahVar = this.f3088ms;
            if (ahVar != null) {
                jSONObject.put("video", ahVar.y());
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        try {
            com.bykv.vk.openvk.component.video.api.ah.ah ahVar2 = this.xr;
            if (ahVar2 != null) {
                jSONObject.put("h265_video", ahVar2.y());
            }
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.sl.ms(e2);
        }
        try {
            com.bykv.vk.openvk.component.video.api.ah.ms msVar = this.ah;
            if (msVar != null) {
                jSONObject.put("audio", msVar.ms());
            }
        } catch (JSONException e3) {
            com.bytedance.sdk.component.utils.sl.ms(e3);
        }
    }

    public void ms(com.bykv.vk.openvk.component.video.api.ah.ah ahVar) {
        this.f3088ms = ahVar;
    }

    public static String ms(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            return ul.ab(lmVar);
        }
        if (com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
            return ao(lmVar).ka();
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar = qrVarQv.f3088ms;
        return ahVar == null ? "" : ahVar.sl();
    }

    public static String xr(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            return ul.x(lmVar);
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar = qrVarQv.f3088ms;
        return ahVar == null ? "" : ahVar.hi();
    }

    public static int ah(lm lmVar) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar;
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null || (ahVar = qrVarQv.f3088ms) == null) {
            return 0;
        }
        return ahVar.xr();
    }

    public static int d(lm lmVar) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar;
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null || (ahVar = qrVarQv.f3088ms) == null) {
            return 0;
        }
        return ahVar.ah();
    }

    public static int[] ka(lm lmVar) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarUb;
        if (lmVar == null) {
            return null;
        }
        if (lmVar.kz() == 166 && ul.ms(lmVar)) {
            return new int[]{ul.sl(lmVar), ul.zb(lmVar)};
        }
        if (lmVar.pd() == 1 && lmVar.vx() == 1 && (ahVarUb = ub(lmVar)) != null) {
            return ahVarUb.ch();
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVarU = u(lmVar);
        if (ahVarU != null) {
            return ahVarU.ch();
        }
        return null;
    }

    public static double c(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return 0.0d;
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            int iXr = ul.xr(lmVar);
            com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = lmVar.rt();
            if (xrVarRt != null && xrVarRt.t() == 9) {
                iXr *= 2;
            }
            return iXr;
        }
        if (com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
            return ((int) ao(lmVar).c()) * (ao(lmVar).ab() + 1);
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar = qrVarQv.f3088ms;
        if (ahVar == null) {
            return 0.0d;
        }
        return ahVar.c();
    }

    public static String ab(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return "";
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            return com.bykv.vk.openvk.component.video.api.c.xr.ms(ul.ab(lmVar));
        }
        if (com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
            return ao(lmVar).xr();
        }
        return qrVarQv.f3088ms.ub();
    }

    public static String x(lm lmVar) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar;
        qr qrVarQv = qv(lmVar);
        return (qrVarQv == null || (ahVar = qrVarQv.f3088ms) == null) ? "" : ahVar.zb();
    }

    public static int ny(lm lmVar) {
        if (qv(lmVar) == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(ms(lmVar))) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (TextUtils.isEmpty(xr(lmVar))) {
            return TTAdConstant.VIDEO_COVER_URL_CODE;
        }
        return 200;
    }

    public static boolean ch(lm lmVar) {
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar;
        qr qrVarQv = qv(lmVar);
        return (qrVarQv == null || (ahVar = qrVarQv.f3088ms) == null || ahVar.ms() != 1) ? false : true;
    }

    public static boolean hi(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        return (qrVarQv == null || qrVarQv.ah == null) ? false : true;
    }

    public static boolean sl(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return false;
        }
        return qrVarQv.f3088ms.b();
    }

    public static com.bykv.vk.openvk.component.video.api.ah.ah ms(lm lmVar, int i) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar = new com.bykv.vk.openvk.component.video.api.ah.ah();
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar2 = qrVarQv.f3088ms;
        if (ahVar2 != null) {
            ahVar.xr(ahVar2.xr());
            ahVar.ah(qrVarQv.f3088ms.ah());
            ahVar.ms(qrVarQv.f3088ms.ny());
            ahVar.ms(qrVarQv.f3088ms.ka());
            ahVar.ms(qrVarQv.f3088ms.c());
            ahVar.xr(qrVarQv.f3088ms.hi());
            ahVar.ah(qrVarQv.f3088ms.sl());
            ahVar.d(qrVarQv.f3088ms.zb());
            ahVar.ka(qrVarQv.f3088ms.ub());
            ahVar.ms(qrVarQv.f3088ms.ms());
            ahVar.d(qrVarQv.f3088ms.ao());
            ahVar.ka(qrVarQv.f3088ms.h());
            ahVar.c(qrVarQv.f3088ms.qv());
            ahVar.ms(qrVarQv.f3088ms.x());
            ahVar.xr(qrVarQv.f3088ms.ab());
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar)) {
            ahVar.xr(ul.x(lmVar));
            ahVar.ah(ul.ab(lmVar));
            ahVar.ka(com.bykv.vk.openvk.component.video.api.c.xr.ms(ul.ab(lmVar)));
            ahVar.ms(-1L);
            ahVar.ms(ul.xr(lmVar));
            ahVar.d(0);
            ahVar.ka(1);
        }
        if (com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
            ahVar.ah(qrVarQv.ah.ka());
            ahVar.ka(0);
            ahVar.d(0);
            ahVar.ka(qrVarQv.ah.xr());
            ahVar.ms(qrVarQv.ah.ah());
            ahVar.xr(qrVarQv.ah.d());
            ahVar.ms(qrVarQv.ah.c() * ((double) (qrVarQv.ah.ab() + 1)));
        }
        return ahVar;
    }

    public static com.bykv.vk.openvk.component.video.api.ah.ah zb(lm lmVar) {
        return ms(lmVar, 0);
    }

    public static com.bykv.vk.openvk.component.video.api.ah.ah u(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return null;
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar = qrVarQv.f3088ms;
        if (ahVar != null) {
            return ahVar;
        }
        if (com.bytedance.sdk.openadsdk.op.ch.ms(lmVar) && lmVar.du() == 3) {
            return ahVar;
        }
        if (!com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
            return qrVarQv.f3088ms;
        }
        com.bykv.vk.openvk.component.video.api.ah.ah ahVar2 = new com.bykv.vk.openvk.component.video.api.ah.ah();
        if (com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
            ahVar2.ah(qrVarQv.ah.ka());
            ahVar2.ka(0);
            ahVar2.d(0);
            ahVar2.ka(qrVarQv.ah.xr());
            ahVar2.ms(qrVarQv.ah.ah());
            ahVar2.ms(qrVarQv.ah.c() * ((double) (qrVarQv.ah.ab() + 1)));
        }
        qrVarQv.f3088ms = ahVar2;
        return ahVar2;
    }

    public static com.bykv.vk.openvk.component.video.api.ah.ah ub(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return null;
        }
        return qrVarQv.xr;
    }

    public static com.bykv.vk.openvk.component.video.api.ah.ms ao(lm lmVar) {
        qr qrVarQv = qv(lmVar);
        if (qrVarQv == null) {
            return null;
        }
        return qrVarQv.ah;
    }

    public static com.bykv.vk.openvk.component.video.api.ah.d ms(int i, lm lmVar, int i2) {
        String strMs;
        if (lmVar.pd() == 1 && !com.bytedance.sdk.openadsdk.core.g.d()) {
            lmVar.tz(0);
        }
        if (com.bytedance.sdk.openadsdk.op.ch.ms(lmVar)) {
            lmVar.tz(0);
        }
        if (i == 1) {
            strMs = com.bytedance.sdk.openadsdk.op.ny.ms(lmVar.pd()).ms();
        } else if (i == 2) {
            strMs = com.bytedance.sdk.openadsdk.op.ny.ms(lmVar.pd()).xr();
        } else if (i == 3) {
            strMs = com.bytedance.sdk.openadsdk.op.ny.ms(lmVar.pd()).ah();
        } else {
            strMs = i != 4 ? "" : com.bytedance.sdk.openadsdk.op.ny.ms(lmVar.pd()).d();
        }
        com.bykv.vk.openvk.component.video.api.ah.d dVar = new com.bykv.vk.openvk.component.video.api.ah.d(strMs, ms(lmVar, i2), ub(lmVar), lmVar.pd(), lmVar.vx());
        dVar.ms(lmVar.qw());
        return dVar;
    }

    public static com.bykv.vk.openvk.component.video.api.ah.d ms(int i, lm lmVar) {
        return ms(i, lmVar, 0);
    }

    public static com.bykv.vk.openvk.component.video.api.ah.d h(lm lmVar) {
        qr qrVarOi;
        com.bykv.vk.openvk.component.video.api.ah.d dVarMs = ms(4, lmVar);
        dVarMs.ms(true);
        if (lmVar != null && (qrVarOi = lmVar.oi()) != null) {
            com.bykv.vk.openvk.component.video.api.ah.ah ahVarW = dVarMs.w();
            com.bykv.vk.openvk.component.video.api.ah.ms msVar = qrVarOi.ah;
            if (msVar != null && ahVarW != null) {
                ahVarW.ah(msVar.ka());
                ahVarW.ka(0);
                ahVarW.d(0);
                ahVarW.ka(qrVarOi.ah.xr());
                ahVarW.ms(qrVarOi.ah.ah());
                ahVarW.xr(qrVarOi.ah.d());
                ahVarW.ms(qrVarOi.ah.c() * ((double) (qrVarOi.ah.ab() + 1)));
            }
        }
        return dVarMs;
    }

    private static qr qv(lm lmVar) {
        if (lmVar == null) {
            return null;
        }
        return lmVar.oi();
    }
}
