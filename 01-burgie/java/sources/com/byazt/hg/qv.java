package com.byazt.hg;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 1082})
public class qv {
    public com.byazt.n.pr hn;
    public com.byazt.n.x hw;
    public com.byazt.n.x pr;

    public qv() {
    }

    public qv(JSONObject jSONObject) {
        String str;
        qv qvVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject != null) {
            com.byazt.n.x xVar = new com.byazt.n.x();
            xVar.hw(jSONObjectOptJSONObject.optInt("cover_height"));
            xVar.hn(jSONObjectOptJSONObject.optInt("cover_width"));
            xVar.pr(jSONObjectOptJSONObject.optString(an.z));
            xVar.pr(jSONObjectOptJSONObject.optLong("size"));
            xVar.pr(jSONObjectOptJSONObject.optDouble(Constants.VIDEO_DURATION_FIELD));
            xVar.hw(jSONObjectOptJSONObject.optString("cover_url"));
            xVar.hn(jSONObjectOptJSONObject.optString("video_url"));
            xVar.x(jSONObjectOptJSONObject.optString("endcard"));
            xVar.uc(jSONObjectOptJSONObject.optString("file_hash"));
            xVar.pr((float) jSONObjectOptJSONObject.optDouble("play_speed_ratio", -1.0d));
            xVar.pr(jSONObjectOptJSONObject.optInt("fallback_endcard_judge", 0));
            xVar.c(jSONObjectOptJSONObject.optInt("video_preload_size", 307200));
            xVar.uc(jSONObjectOptJSONObject.optInt("reward_video_cached_type", 0));
            xVar.fw(jSONObjectOptJSONObject.optInt("execute_cached_type", 0));
            xVar.hw(jSONObjectOptJSONObject.optDouble(TrackAction.START, -1.0d));
            qvVar = this;
            str = "size";
            qvVar.pr = xVar;
        } else {
            str = "size";
            qvVar = this;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("h265_video");
        if (jSONObjectOptJSONObject2 != null) {
            com.byazt.n.x xVar2 = new com.byazt.n.x();
            xVar2.hw(jSONObjectOptJSONObject2.optInt("cover_height"));
            xVar2.hn(jSONObjectOptJSONObject2.optInt("cover_width"));
            xVar2.pr(jSONObjectOptJSONObject2.optString(an.z));
            xVar2.pr(jSONObjectOptJSONObject2.optLong(str));
            xVar2.pr(jSONObjectOptJSONObject2.optDouble(Constants.VIDEO_DURATION_FIELD));
            xVar2.hw(jSONObjectOptJSONObject2.optString("cover_url"));
            xVar2.hn(jSONObjectOptJSONObject2.optString("video_url"));
            xVar2.x(jSONObjectOptJSONObject2.optString("endcard"));
            xVar2.uc(jSONObjectOptJSONObject2.optString("file_hash"));
            xVar2.pr((float) jSONObjectOptJSONObject2.optDouble("play_speed_ratio", -1.0d));
            xVar2.pr(jSONObjectOptJSONObject2.optInt("fallback_endcard_judge", 0));
            xVar2.c(jSONObjectOptJSONObject2.optInt("video_preload_size", 307200));
            xVar2.uc(jSONObjectOptJSONObject2.optInt("reward_video_cached_type", 0));
            xVar2.fw(jSONObjectOptJSONObject2.optInt("execute_cached_type", 0));
            xVar2.hw(jSONObjectOptJSONObject2.optDouble(TrackAction.START, -1.0d));
            qvVar.hw = xVar2;
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(MediaFormat.KEY_AUDIO);
        if (jSONObjectOptJSONObject3 != null) {
            com.byazt.n.pr prVar = new com.byazt.n.pr();
            prVar.hw(jSONObjectOptJSONObject3.optString("audio_url"));
            prVar.pr(jSONObjectOptJSONObject3.optInt("reward_audio_cached_type", Integer.MIN_VALUE));
            prVar.hw(jSONObjectOptJSONObject3.optLong("audio_preload_size", -2147483648L));
            prVar.pr(jSONObjectOptJSONObject3.optLong(str, -2147483648L));
            prVar.pr(jSONObjectOptJSONObject3.optString("file_hash"));
            prVar.hw(jSONObjectOptJSONObject3.optDouble("audio_duration", -2.147483648E9d));
            prVar.pr(jSONObjectOptJSONObject3.optDouble(TrackAction.START, -1.0d));
            prVar.hw(jSONObjectOptJSONObject3.optInt("repeat_count", 0));
            qvVar.hn = prVar;
        }
    }

    public void pr(JSONObject jSONObject) {
        try {
            com.byazt.n.x xVar = this.pr;
            if (xVar != null) {
                jSONObject.put("video", xVar.qa());
            }
        } catch (JSONException e) {
        }
        try {
            com.byazt.n.x xVar2 = this.hw;
            if (xVar2 != null) {
                jSONObject.put("h265_video", xVar2.qa());
            }
        } catch (JSONException e2) {
        }
        try {
            com.byazt.n.pr prVar = this.hn;
            if (prVar != null) {
                jSONObject.put(MediaFormat.KEY_AUDIO, prVar.pr());
            }
        } catch (JSONException e3) {
        }
    }

    public void pr(com.byazt.n.x xVar) {
        this.pr = xVar;
    }

    public static String pr(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return "";
        }
        if (com.byazt.lpk.pr.pr(ofVar)) {
            return v.fw(ofVar);
        }
        if (com.byazt.zp.k.pr(ofVar)) {
            return yb(ofVar).c();
        }
        com.byazt.n.x xVar = qvVarQa.pr;
        if (xVar == null) {
            return "";
        }
        return xVar.k();
    }

    public static String hw(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return "";
        }
        if (com.byazt.lpk.pr.pr(ofVar)) {
            return v.zo(ofVar);
        }
        com.byazt.n.x xVar = qvVarQa.pr;
        if (xVar == null) {
            return "";
        }
        return xVar.w();
    }

    public static int hn(of ofVar) {
        com.byazt.n.x xVar;
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null || (xVar = qvVarQa.pr) == null) {
            return 0;
        }
        return xVar.hw();
    }

    public static int x(of ofVar) {
        com.byazt.n.x xVar;
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null || (xVar = qvVarQa.pr) == null) {
            return 0;
        }
        return xVar.hn();
    }

    public static int[] c(of ofVar) {
        if (ofVar != null) {
            if (ofVar.jg() == 166 && v.pr(ofVar)) {
                return new int[]{v.k(ofVar), v.m(ofVar)};
            }
            com.byazt.n.x xVarNt = nt(ofVar);
            if (uc(ofVar) && xVarNt != null) {
                return xVarNt.vk();
            }
            com.byazt.n.x xVarHo = ho(ofVar);
            if (xVarHo != null) {
                return xVarHo.vk();
            }
            return null;
        }
        return null;
    }

    public static boolean uc(of ofVar) {
        return ofVar != null && ofVar.sd() == 1 && com.byazt.sd.iu.x() && ofVar.id() == 1 && nt(ofVar) != null;
    }

    public static double fw(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return 0.0d;
        }
        if (com.byazt.lpk.pr.pr(ofVar)) {
            int iHw = v.hw(ofVar);
            com.byazt.qe.hw hwVarP = ofVar.p();
            if (hwVarP != null) {
                switch (hwVarP.a()) {
                    case 9:
                        iHw *= 2;
                        break;
                }
            }
            return iHw;
        }
        if (com.byazt.zp.k.pr(ofVar)) {
            return ((int) yb(ofVar).uc()) * (yb(ofVar).fw() + 1);
        }
        com.byazt.n.x xVar = qvVarQa.pr;
        if (xVar == null) {
            return 0.0d;
        }
        return xVar.uc();
    }

    public static String zo(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return "";
        }
        if (com.byazt.lpk.pr.pr(ofVar)) {
            return com.byazt.o.pr.pr(v.fw(ofVar));
        }
        if (com.byazt.zp.k.pr(ofVar)) {
            return yb(ofVar).hw();
        }
        return qvVarQa.pr.ho();
    }

    public static String aj(of ofVar) {
        com.byazt.n.x xVar;
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null || (xVar = qvVarQa.pr) == null) {
            return "";
        }
        return xVar.m();
    }

    public static int vk(of ofVar) {
        if (qa(ofVar) == null) {
            return TTAdConstant.VIDEO_INFO_CODE;
        }
        if (TextUtils.isEmpty(pr(ofVar))) {
            return TTAdConstant.VIDEO_URL_CODE;
        }
        if (TextUtils.isEmpty(hw(ofVar))) {
            return TTAdConstant.VIDEO_COVER_URL_CODE;
        }
        return 200;
    }

    public static boolean w(of ofVar) {
        com.byazt.n.x xVar;
        qv qvVarQa = qa(ofVar);
        return (qvVarQa == null || (xVar = qvVarQa.pr) == null || xVar.pr() != 1) ? false : true;
    }

    public static boolean k(of ofVar) {
        qv qvVarQa = qa(ofVar);
        return (qvVarQa == null || qvVarQa.hn == null) ? false : true;
    }

    public static boolean m(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return false;
        }
        return qvVarQa.pr.ny();
    }

    public static com.byazt.n.x g(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return null;
        }
        com.byazt.n.x xVar = new com.byazt.n.x();
        com.byazt.n.x xVar2 = qvVarQa.pr;
        if (xVar2 != null) {
            xVar.hw(xVar2.hw());
            xVar.hn(qvVarQa.pr.hn());
            xVar.pr(qvVarQa.pr.aj());
            xVar.pr(qvVarQa.pr.c());
            xVar.pr(qvVarQa.pr.uc());
            xVar.hw(qvVarQa.pr.w());
            xVar.hn(qvVarQa.pr.k());
            xVar.x(qvVarQa.pr.m());
            xVar.uc(qvVarQa.pr.ho());
            xVar.pr(qvVarQa.pr.pr());
            xVar.c(qvVarQa.pr.nt());
            xVar.uc(qvVarQa.pr.yb());
            xVar.fw(qvVarQa.pr.lb());
            xVar.pr(qvVarQa.pr.zo());
            xVar.hw(qvVarQa.pr.fw());
        }
        if (com.byazt.lpk.pr.pr(ofVar)) {
            xVar.hw(v.zo(ofVar));
            xVar.hn(v.fw(ofVar));
            xVar.uc(com.byazt.o.pr.pr(v.fw(ofVar)));
            xVar.pr(-1L);
            xVar.pr(v.hw(ofVar));
            xVar.c(0);
            xVar.uc(1);
        }
        if (com.byazt.zp.k.pr(ofVar)) {
            xVar.hn(qvVarQa.hn.c());
            xVar.uc(0);
            xVar.c(0);
            xVar.uc(qvVarQa.hn.hw());
            xVar.pr(qvVarQa.hn.hn());
            xVar.hw(qvVarQa.hn.x());
            xVar.pr(qvVarQa.hn.uc() * ((double) (qvVarQa.hn.fw() + 1)));
        }
        return xVar;
    }

    public static com.byazt.n.x ho(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return null;
        }
        com.byazt.n.x xVar = qvVarQa.pr;
        if (xVar != null) {
            return xVar;
        }
        if (com.byazt.zp.k.pr(ofVar) && ie.hn(ofVar) == 3) {
            return xVar;
        }
        if (!com.byazt.zp.k.pr(ofVar)) {
            return qvVarQa.pr;
        }
        com.byazt.n.x xVar2 = new com.byazt.n.x();
        if (com.byazt.zp.k.pr(ofVar)) {
            xVar2.hn(qvVarQa.hn.c());
            xVar2.uc(0);
            xVar2.c(0);
            xVar2.uc(qvVarQa.hn.hw());
            xVar2.pr(qvVarQa.hn.hn());
            xVar2.pr(qvVarQa.hn.uc() * ((double) (qvVarQa.hn.fw() + 1)));
        }
        qvVarQa.pr = xVar2;
        return xVar2;
    }

    public static com.byazt.n.x nt(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return null;
        }
        return qvVarQa.hw;
    }

    public static com.byazt.n.pr yb(of ofVar) {
        qv qvVarQa = qa(ofVar);
        if (qvVarQa == null) {
            return null;
        }
        return qvVarQa.hn;
    }

    public static com.byazt.n.uc pr(int i, of ofVar) {
        String strHw;
        if (ofVar.sd() == 1 && !com.byazt.sd.iu.x()) {
            ofVar.l(0);
        }
        if (com.byazt.zp.k.pr(ofVar)) {
            ofVar.l(0);
        }
        switch (i) {
            case 1:
                strHw = com.byazt.zp.w.pr(ofVar.sd()).hw();
                break;
            case 2:
                strHw = com.byazt.zp.w.pr(ofVar.sd()).hn();
                break;
            case 3:
                strHw = com.byazt.zp.w.pr(ofVar.sd()).x();
                break;
            case 4:
                strHw = com.byazt.zp.w.pr(ofVar.sd()).pr();
                break;
            default:
                strHw = "";
                break;
        }
        com.byazt.n.uc ucVar = new com.byazt.n.uc(strHw, g(ofVar), nt(ofVar), ofVar.sd(), ofVar.id());
        ucVar.pr(ofVar.sq());
        return ucVar;
    }

    public static com.byazt.n.uc lb(of ofVar) {
        qv qvVarWx;
        com.byazt.n.uc ucVarPr = pr(4, ofVar);
        ucVarPr.pr(true);
        if (ofVar != null && (qvVarWx = ofVar.wx()) != null) {
            com.byazt.ihe.c cVarWw = ucVarPr.ww();
            com.byazt.n.pr prVar = qvVarWx.hn;
            if (prVar != null && cVarWw != null) {
                cVarWw.hn(prVar.c());
                cVarWw.uc(0);
                cVarWw.c(0);
                cVarWw.uc(qvVarWx.hn.hw());
                cVarWw.pr(qvVarWx.hn.hn());
                cVarWw.hw(qvVarWx.hn.x());
                cVarWw.pr(qvVarWx.hn.uc() * ((double) (qvVarWx.hn.fw() + 1)));
            }
        }
        return ucVarPr;
    }

    private static qv qa(of ofVar) {
        if (ofVar == null) {
            return null;
        }
        return ofVar.wx();
    }
}
