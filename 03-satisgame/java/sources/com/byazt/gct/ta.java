package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME})
public class ta {
    public com.byazt.zsl.s n;
    public com.byazt.zsl.s qg;
    public com.byazt.zsl.n s;

    public ta() {
    }

    public ta(JSONObject jSONObject) {
        String str;
        ta taVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MediaFormat.KEY_VIDEO);
        if (jSONObjectOptJSONObject != null) {
            com.byazt.zsl.s sVar = new com.byazt.zsl.s();
            sVar.qg(jSONObjectOptJSONObject.optInt("cover_height"));
            sVar.s(jSONObjectOptJSONObject.optInt("cover_width"));
            sVar.n(jSONObjectOptJSONObject.optString("resolution"));
            sVar.n(jSONObjectOptJSONObject.optLong("size"));
            sVar.n(jSONObjectOptJSONObject.optDouble("video_duration"));
            sVar.qg(jSONObjectOptJSONObject.optString("cover_url"));
            sVar.s(jSONObjectOptJSONObject.optString("video_url"));
            sVar.q(jSONObjectOptJSONObject.optString("endcard"));
            sVar.w(jSONObjectOptJSONObject.optString("file_hash"));
            sVar.n((float) jSONObjectOptJSONObject.optDouble("play_speed_ratio", -1.0d));
            sVar.n(jSONObjectOptJSONObject.optInt("fallback_endcard_judge", 0));
            sVar.l(jSONObjectOptJSONObject.optInt("video_preload_size", 307200));
            sVar.w(jSONObjectOptJSONObject.optInt("reward_video_cached_type", 0));
            sVar.x(jSONObjectOptJSONObject.optInt("execute_cached_type", 0));
            sVar.qg(jSONObjectOptJSONObject.optDouble("start", -1.0d));
            taVar = this;
            str = "size";
            taVar.n = sVar;
        } else {
            str = "size";
            taVar = this;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject2 != null) {
            com.byazt.zsl.s sVar2 = new com.byazt.zsl.s();
            sVar2.qg(jSONObjectOptJSONObject2.optInt("cover_height"));
            sVar2.s(jSONObjectOptJSONObject2.optInt("cover_width"));
            sVar2.n(jSONObjectOptJSONObject2.optString("resolution"));
            sVar2.n(jSONObjectOptJSONObject2.optLong(str));
            sVar2.n(jSONObjectOptJSONObject2.optDouble("video_duration"));
            sVar2.qg(jSONObjectOptJSONObject2.optString("cover_url"));
            sVar2.s(jSONObjectOptJSONObject2.optString("video_url"));
            sVar2.q(jSONObjectOptJSONObject2.optString("endcard"));
            sVar2.w(jSONObjectOptJSONObject2.optString("file_hash"));
            sVar2.n((float) jSONObjectOptJSONObject2.optDouble("play_speed_ratio", -1.0d));
            sVar2.n(jSONObjectOptJSONObject2.optInt("fallback_endcard_judge", 0));
            sVar2.l(jSONObjectOptJSONObject2.optInt("video_preload_size", 307200));
            sVar2.w(jSONObjectOptJSONObject2.optInt("reward_video_cached_type", 0));
            sVar2.x(jSONObjectOptJSONObject2.optInt("execute_cached_type", 0));
            sVar2.qg(jSONObjectOptJSONObject2.optDouble("start", -1.0d));
            taVar.qg = sVar2;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(MediaFormat.KEY_AUDIO);
        if (jSONObjectOptJSONObject3 != null) {
            com.byazt.zsl.n nVar = new com.byazt.zsl.n();
            nVar.qg(jSONObjectOptJSONObject3.optString("audio_url"));
            nVar.n(jSONObjectOptJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            nVar.qg(jSONObjectOptJSONObject3.optLong("audio_preload_size", -2147483648L));
            nVar.n(jSONObjectOptJSONObject3.optLong(str, -2147483648L));
            nVar.n(jSONObjectOptJSONObject3.optString("file_hash"));
            nVar.qg(jSONObjectOptJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            nVar.n(jSONObjectOptJSONObject3.optDouble("start", -1.0d));
            nVar.qg(jSONObjectOptJSONObject3.optInt("repeat_count", 0));
            taVar.s = nVar;
        }
    }

    public void n(JSONObject jSONObject) {
        try {
            com.byazt.zsl.s sVar = this.n;
            if (sVar != null) {
                jSONObject.put(MediaFormat.KEY_VIDEO, sVar.um());
            }
        } catch (JSONException unused) {
        }
        try {
            com.byazt.zsl.s sVar2 = this.qg;
            if (sVar2 != null) {
                jSONObject.put("h265_video", sVar2.um());
            }
        } catch (JSONException unused2) {
        }
        try {
            com.byazt.zsl.n nVar = this.s;
            if (nVar != null) {
                jSONObject.put(MediaFormat.KEY_AUDIO, nVar.n());
            }
        } catch (JSONException unused3) {
        }
    }

    public void n(com.byazt.zsl.s sVar) {
        this.n = sVar;
    }

    public static String n(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return "";
        }
        if (com.byazt.gks.n.n(pkVar)) {
            return oj.x(pkVar);
        }
        if (com.byazt.ql.s.n(pkVar)) {
            return hd(pkVar).l();
        }
        com.byazt.zsl.s sVar = taVarUm.n;
        return sVar == null ? "" : sVar.d();
    }

    public static String qg(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return "";
        }
        if (com.byazt.gks.n.n(pkVar)) {
            return oj.fs(pkVar);
        }
        com.byazt.zsl.s sVar = taVarUm.n;
        return sVar == null ? "" : sVar.cp();
    }

    public static int s(pk pkVar) {
        com.byazt.zsl.s sVar;
        ta taVarUm = um(pkVar);
        if (taVarUm == null || (sVar = taVarUm.n) == null) {
            return 0;
        }
        return sVar.qg();
    }

    public static int q(pk pkVar) {
        com.byazt.zsl.s sVar;
        ta taVarUm = um(pkVar);
        if (taVarUm == null || (sVar = taVarUm.n) == null) {
            return 0;
        }
        return sVar.s();
    }

    public static int[] l(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        if (pkVar.ge() == 166 && oj.n(pkVar)) {
            return new int[]{oj.d(pkVar), oj.oa(pkVar)};
        }
        com.byazt.zsl.s sVarCy = cy(pkVar);
        if (w(pkVar) && sVarCy != null) {
            return sVarCy.tj();
        }
        com.byazt.zsl.s sVarK = k(pkVar);
        if (sVarK != null) {
            return sVarK.tj();
        }
        return null;
    }

    public static boolean w(pk pkVar) {
        return pkVar != null && pkVar.io() == 1 && com.byazt.nf.tj.l() && pkVar.kz() == 1 && cy(pkVar) != null;
    }

    public static double x(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return 0.0d;
        }
        if (com.byazt.gks.n.n(pkVar)) {
            int iQg = oj.qg(pkVar);
            com.byazt.zq.qg qgVarXd = pkVar.xd();
            if (qgVarXd != null && qgVarXd.a() == 9) {
                iQg *= 2;
            }
            return iQg;
        }
        if (com.byazt.ql.s.n(pkVar)) {
            return ((int) hd(pkVar).w()) * (hd(pkVar).x() + 1);
        }
        com.byazt.zsl.s sVar = taVarUm.n;
        if (sVar == null) {
            return 0.0d;
        }
        return sVar.w();
    }

    public static String fs(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return "";
        }
        if (com.byazt.gks.n.n(pkVar)) {
            return com.byazt.nl.n.n(oj.x(pkVar));
        }
        if (com.byazt.ql.s.n(pkVar)) {
            return hd(pkVar).qg();
        }
        return taVarUm.n.k();
    }

    public static String rv(pk pkVar) {
        com.byazt.zsl.s sVar;
        ta taVarUm = um(pkVar);
        return (taVarUm == null || (sVar = taVarUm.n) == null) ? "" : sVar.oa();
    }

    public static int tj(pk pkVar) {
        if (um(pkVar) == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(n(pkVar))) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (TextUtils.isEmpty(qg(pkVar))) {
            return TTAdConstant.VIDEO_COVER_URL_CODE;
        }
        return 200;
    }

    public static boolean cp(pk pkVar) {
        com.byazt.zsl.s sVar;
        ta taVarUm = um(pkVar);
        return (taVarUm == null || (sVar = taVarUm.n) == null || sVar.n() != 1) ? false : true;
    }

    public static boolean d(pk pkVar) {
        ta taVarUm = um(pkVar);
        return (taVarUm == null || taVarUm.s == null) ? false : true;
    }

    public static boolean oa(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return false;
        }
        return taVarUm.n.ou();
    }

    public static com.byazt.zsl.s sz(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return null;
        }
        com.byazt.zsl.s sVar = new com.byazt.zsl.s();
        com.byazt.zsl.s sVar2 = taVarUm.n;
        if (sVar2 != null) {
            sVar.qg(sVar2.qg());
            sVar.s(taVarUm.n.s());
            sVar.n(taVarUm.n.rv());
            sVar.n(taVarUm.n.l());
            sVar.n(taVarUm.n.w());
            sVar.qg(taVarUm.n.cp());
            sVar.s(taVarUm.n.d());
            sVar.q(taVarUm.n.oa());
            sVar.w(taVarUm.n.k());
            sVar.n(taVarUm.n.n());
            sVar.l(taVarUm.n.cy());
            sVar.w(taVarUm.n.hd());
            sVar.x(taVarUm.n.cd());
            sVar.n(taVarUm.n.fs());
            sVar.qg(taVarUm.n.x());
        }
        if (com.byazt.gks.n.n(pkVar)) {
            sVar.qg(oj.fs(pkVar));
            sVar.s(oj.x(pkVar));
            sVar.w(com.byazt.nl.n.n(oj.x(pkVar)));
            sVar.n(-1L);
            sVar.n(oj.qg(pkVar));
            sVar.l(0);
            sVar.w(1);
        }
        if (com.byazt.ql.s.n(pkVar)) {
            sVar.s(taVarUm.s.l());
            sVar.w(0);
            sVar.l(0);
            sVar.w(taVarUm.s.qg());
            sVar.n(taVarUm.s.s());
            sVar.qg(taVarUm.s.q());
            sVar.n(taVarUm.s.w() * ((double) (taVarUm.s.x() + 1)));
        }
        return sVar;
    }

    public static com.byazt.zsl.s k(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return null;
        }
        com.byazt.zsl.s sVar = taVarUm.n;
        if (sVar != null) {
            return sVar;
        }
        if (com.byazt.ql.s.n(pkVar) && nf.s(pkVar) == 3) {
            return sVar;
        }
        if (!com.byazt.ql.s.n(pkVar)) {
            return taVarUm.n;
        }
        com.byazt.zsl.s sVar2 = new com.byazt.zsl.s();
        if (com.byazt.ql.s.n(pkVar)) {
            sVar2.s(taVarUm.s.l());
            sVar2.w(0);
            sVar2.l(0);
            sVar2.w(taVarUm.s.qg());
            sVar2.n(taVarUm.s.s());
            sVar2.n(taVarUm.s.w() * ((double) (taVarUm.s.x() + 1)));
        }
        taVarUm.n = sVar2;
        return sVar2;
    }

    public static com.byazt.zsl.s cy(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return null;
        }
        return taVarUm.qg;
    }

    public static com.byazt.zsl.n hd(pk pkVar) {
        ta taVarUm = um(pkVar);
        if (taVarUm == null) {
            return null;
        }
        return taVarUm.s;
    }

    public static com.byazt.zsl.l n(int i, pk pkVar) {
        String strQg;
        if (pkVar.io() == 1 && !com.byazt.nf.tj.l()) {
            pkVar.cx(0);
        }
        if (com.byazt.ql.s.n(pkVar)) {
            pkVar.cx(0);
        }
        if (i == 1) {
            strQg = com.byazt.ql.qg.n(pkVar.io()).qg();
        } else if (i == 2) {
            strQg = com.byazt.ql.qg.n(pkVar.io()).s();
        } else if (i == 3) {
            strQg = com.byazt.ql.qg.n(pkVar.io()).q();
        } else {
            strQg = i != 4 ? "" : com.byazt.ql.qg.n(pkVar.io()).n();
        }
        com.byazt.zsl.l lVar = new com.byazt.zsl.l(strQg, sz(pkVar), cy(pkVar), pkVar.io(), pkVar.kz());
        lVar.n(pkVar.yj());
        return lVar;
    }

    public static com.byazt.zsl.l cd(pk pkVar) {
        ta taVarFh;
        com.byazt.zsl.l lVarN = n(4, pkVar);
        lVarN.n(true);
        if (pkVar != null && (taVarFh = pkVar.fh()) != null) {
            com.byazt.ej.l lVarV = lVarN.v();
            com.byazt.zsl.n nVar = taVarFh.s;
            if (nVar != null && lVarV != null) {
                lVarV.s(nVar.l());
                lVarV.w(0);
                lVarV.l(0);
                lVarV.w(taVarFh.s.qg());
                lVarV.n(taVarFh.s.s());
                lVarV.qg(taVarFh.s.q());
                lVarV.n(taVarFh.s.w() * ((double) (taVarFh.s.x() + 1)));
            }
        }
        return lVarN;
    }

    private static ta um(pk pkVar) {
        if (pkVar == null) {
            return null;
        }
        return pkVar.fh();
    }
}
