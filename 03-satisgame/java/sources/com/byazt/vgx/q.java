package com.byazt.vgx;

import android.util.SparseArray;
import com.byazt.gct.pk;
import com.byazt.nf.rv;
import com.byazt.nf.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 5})
public class q {
    public static com.byazt.zq.qg n(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.byazt.zq.qg.n nVar = new com.byazt.zq.qg.n(str2);
            nVar.n(jSONObject.optString("mAdId", ""));
            nVar.qg(jSONObject.optString("mCreativeId", ""));
            nVar.s(jSONObject.optString("mExt", ""));
            nVar.q(jSONObject.optString("mCodeId", ""));
            nVar.rv(jSONObject.optString("mUserData"));
            nVar.n(jSONObject.optBoolean("mIsAutoPlay", true));
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
            nVar.qg(jSONObject.optInt("mImgAcceptedHeight", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            nVar.n(iOptInt);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            nVar.qg(Double.valueOf(dOptDouble).floatValue());
            nVar.n(Double.valueOf(dOptDouble2).floatValue());
            nVar.qg(jSONObject.optBoolean("mSupportDeepLink", true));
            nVar.s(jSONObject.optInt("mAdCount", 1));
            nVar.l(jSONObject.optString("mMediaExtra", ""));
            nVar.w(jSONObject.optString("mUserID", ""));
            nVar.q(jSONObject.optInt("mOrientation", 2));
            nVar.x(jSONObject.optInt("mAdType", 0));
            nVar.l(jSONObject.optInt("mNativeAdType"));
            nVar.n(w.oa(jSONObject.optString("mExternalABVid", "")));
            nVar.w(jSONObject.optInt("mAdLoadSeq", 0));
            nVar.x(jSONObject.optString("mPrimeRit", ""));
            nVar.fs(jSONObject.optString("mBidAdm"));
            nVar.fs(jSONObject.optInt("mRewardAmount", 0));
            nVar.tj(jSONObject.optString("mRewardName", ""));
            return nVar.n();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject n(com.byazt.zq.qg qgVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", qgVar.n());
            jSONObject.put("mCreativeId", qgVar.qg());
            jSONObject.put("mExt", qgVar.s());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", qgVar.ou());
            jSONObject.put("mIsAutoPlay", qgVar.l());
            jSONObject.put("mImgAcceptedWidth", qgVar.w());
            jSONObject.put("mImgAcceptedHeight", qgVar.x());
            jSONObject.put("mExpressViewAcceptedWidth", qgVar.fs());
            jSONObject.put("mExpressViewAcceptedHeight", qgVar.rv());
            jSONObject.put("mSupportDeepLink", qgVar.tj());
            jSONObject.put("mSupportRenderControl", qgVar.cp());
            if (tj.l >= 5900) {
                jSONObject.put("mSupportIconStyle", qgVar.h());
            }
            jSONObject.put("mAdCount", qgVar.d());
            jSONObject.put("mMediaExtra", qgVar.oa());
            jSONObject.put("mUserID", qgVar.sz());
            jSONObject.put("mOrientation", qgVar.k());
            jSONObject.put("mAdType", qgVar.a());
            jSONObject.put("mNativeAdType", qgVar.cy());
            jSONObject.put("mExternalABVid", w.n(qgVar.hd()));
            jSONObject.put("mAdLoadSeq", qgVar.cd());
            jSONObject.put("mPrimeRit", qgVar.um());
            jSONObject.put("mBidAdm", qgVar.py());
            jSONObject.put("mRewardAmount", qgVar.hu());
            jSONObject.put("mRewardName", qgVar.m());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject n(com.byazt.zq.qg qgVar) {
        return n(qgVar, qgVar.q());
    }

    public static com.byazt.zq.qg n(int i, String str, float f, float f2, pk pkVar) {
        return n(pkVar == null ? null : pkVar.mk()).q(str).x(i).qg(f2).n(f).n();
    }

    public static com.byazt.zq.qg n(int i, String str) {
        return n(str).x(i).n();
    }

    public static com.byazt.zq.qg n(int i, PluginValueSet pluginValueSet) {
        com.byazt.zq.qg qgVar = new com.byazt.zq.qg(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>(), s.qg());
        com.byazt.zq.qg.n nVar = new com.byazt.zq.qg.n(qgVar);
        float fFs = qgVar.fs();
        float fRv = qgVar.rv();
        if (fFs <= 0.0f) {
            fFs = com.byazt.okk.s.q(rv.getContext(), qgVar.w());
            fRv = com.byazt.okk.s.q(rv.getContext(), qgVar.x());
        }
        if (fFs > 0.0f || fRv > 0.0f) {
            int iQ = com.byazt.okk.s.q(rv.getContext(), com.byazt.okk.s.w(rv.getContext()));
            int iQ2 = com.byazt.okk.s.q(rv.getContext(), com.byazt.okk.s.l(rv.getContext()));
            int iMax = Math.max(iQ, iQ2);
            int iMin = Math.min(iQ, iQ2);
            if (fFs > fRv) {
                if (iQ2 > 0 && fFs > ((double) iMax) * 1.3d) {
                    fFs = iMax;
                    fRv = iMin;
                }
            } else if (iQ > 0 && fRv > ((double) iMax) * 1.3d) {
                fFs = iMin;
                fRv = iMax;
            }
        }
        nVar.n(fFs).qg(fRv);
        return new com.byazt.gct.s(qg(nVar.n()).x(i).n());
    }

    public static final com.byazt.zq.qg.n qg(com.byazt.zq.qg qgVar) {
        return new com.byazt.zq.qg.n(qgVar);
    }

    private static final com.byazt.zq.qg.n n(String str) {
        return new com.byazt.zq.qg.n(str).s(1).qg(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).n(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).qg(true).w("defaultUser").q(2).n(true);
    }

    public static boolean n(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return ((Boolean) rv.qg().n(str, Boolean.valueOf(z))).booleanValue();
    }

    public static long n(JSONObject jSONObject, String str, long j) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j);
        }
        return ((Long) rv.qg().n(str, Long.valueOf(j))).longValue();
    }

    public static int n(JSONObject jSONObject, String str, int i) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i);
        }
        return ((Integer) rv.qg().n(str, Integer.valueOf(i))).intValue();
    }
}
