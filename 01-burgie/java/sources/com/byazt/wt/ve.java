package com.byazt.wt;

import android.util.SparseArray;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM})
public class ve {
    public static com.byazt.qe.hw pr(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.byazt.qe.hw.pr prVar = new com.byazt.qe.hw.pr(str2);
            prVar.pr(jSONObject.optString("mAdId", ""));
            prVar.hw(jSONObject.optString("mCreativeId", ""));
            prVar.hn(jSONObject.optString("mExt", ""));
            prVar.x(jSONObject.optString("mCodeId", ""));
            prVar.aj(jSONObject.optString("mUserData"));
            prVar.pr(jSONObject.optBoolean("mIsAutoPlay", true));
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
            prVar.hw(jSONObject.optInt("mImgAcceptedHeight", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            prVar.pr(iOptInt);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            prVar.hw(Double.valueOf(dOptDouble).floatValue());
            prVar.pr(Double.valueOf(dOptDouble2).floatValue());
            prVar.hw(jSONObject.optBoolean("mSupportDeepLink", true));
            prVar.hn(jSONObject.optInt("mAdCount", 1));
            prVar.c(jSONObject.optString("mMediaExtra", ""));
            prVar.uc(jSONObject.optString("mUserID", ""));
            prVar.x(jSONObject.optInt("mOrientation", 2));
            prVar.fw(jSONObject.optInt("mAdType", 0));
            prVar.c(jSONObject.optInt("mNativeAdType"));
            prVar.pr(ls.m(jSONObject.optString("mExternalABVid", "")));
            prVar.uc(jSONObject.optInt("mAdLoadSeq", 0));
            prVar.fw(jSONObject.optString("mPrimeRit", ""));
            prVar.zo(jSONObject.optString("mBidAdm"));
            prVar.zo(jSONObject.optInt("mRewardAmount", 0));
            prVar.vk(jSONObject.optString("mRewardName", ""));
            return prVar.pr();
        } catch (Exception e) {
            return null;
        }
    }

    public static JSONObject pr(com.byazt.qe.hw hwVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", hwVar.pr());
            jSONObject.put("mCreativeId", hwVar.hw());
            jSONObject.put("mExt", hwVar.hn());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", hwVar.ny());
            jSONObject.put("mIsAutoPlay", hwVar.c());
            jSONObject.put("mImgAcceptedWidth", hwVar.uc());
            jSONObject.put("mImgAcceptedHeight", hwVar.fw());
            jSONObject.put("mExpressViewAcceptedWidth", hwVar.zo());
            jSONObject.put("mExpressViewAcceptedHeight", hwVar.aj());
            jSONObject.put("mSupportDeepLink", hwVar.vk());
            jSONObject.put("mSupportRenderControl", hwVar.w());
            if (com.byazt.sd.iu.x >= 5900) {
                jSONObject.put("mSupportIconStyle", hwVar.b());
            }
            jSONObject.put("mAdCount", hwVar.k());
            jSONObject.put("mMediaExtra", hwVar.m());
            jSONObject.put("mUserID", hwVar.g());
            jSONObject.put("mOrientation", hwVar.ho());
            jSONObject.put("mAdType", hwVar.a());
            jSONObject.put("mNativeAdType", hwVar.nt());
            jSONObject.put("mExternalABVid", ls.pr(hwVar.yb()));
            jSONObject.put("mAdLoadSeq", hwVar.lb());
            jSONObject.put("mPrimeRit", hwVar.qa());
            jSONObject.put("mBidAdm", hwVar.cz());
            jSONObject.put("mRewardAmount", hwVar.z());
            jSONObject.put("mRewardName", hwVar.rc());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public static JSONObject pr(com.byazt.qe.hw hwVar) {
        return pr(hwVar, hwVar.x());
    }

    public static com.byazt.qe.hw pr(int i, String str, float f, float f2, of ofVar) {
        return pr(ofVar == null ? null : ofVar.yn()).x(str).fw(i).hw(f2).pr(f).pr();
    }

    public static com.byazt.qe.hw pr(int i, String str) {
        return pr(str).fw(i).pr();
    }

    public static com.byazt.qe.hw pr(int i, PluginValueSet pluginValueSet) {
        com.byazt.qe.hw hwVar = new com.byazt.qe.hw(pluginValueSet != null ? pluginValueSet.sparseArray() : new SparseArray<>(), com.byazt.zb.pr.hw());
        com.byazt.qe.hw.pr prVar = new com.byazt.qe.hw.pr(hwVar);
        float fZo = hwVar.zo();
        float fAj = hwVar.aj();
        if (fZo <= 0.0f) {
            fZo = er.x(com.byazt.sd.a.getContext(), hwVar.uc());
            fAj = er.x(com.byazt.sd.a.getContext(), hwVar.fw());
        }
        if (fZo > 0.0f || fAj > 0.0f) {
            int iX = er.x(com.byazt.sd.a.getContext(), er.uc(com.byazt.sd.a.getContext()));
            int iX2 = er.x(com.byazt.sd.a.getContext(), er.c(com.byazt.sd.a.getContext()));
            int iMax = Math.max(iX, iX2);
            int iMin = Math.min(iX, iX2);
            if (fZo > fAj) {
                if (iX2 > 0 && fZo > ((double) iMax) * 1.3d) {
                    fZo = iMax;
                    fAj = iMin;
                }
            } else if (iX > 0 && fAj > ((double) iMax) * 1.3d) {
                fZo = iMin;
                fAj = iMax;
            }
        }
        prVar.pr(fZo).hw(fAj);
        return new com.byazt.hg.hn(hw(prVar.pr()).fw(i).pr());
    }

    public static final com.byazt.qe.hw.pr hw(com.byazt.qe.hw hwVar) {
        return new com.byazt.qe.hw.pr(hwVar);
    }

    private static final com.byazt.qe.hw.pr pr(String str) {
        return new com.byazt.qe.hw.pr(str).hn(1).hw(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).pr(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).hw(true).uc("defaultUser").x(2).pr(true);
    }

    public static boolean pr(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return ((Boolean) com.byazt.sd.a.hw().pr(str, Boolean.valueOf(z))).booleanValue();
    }

    public static long pr(JSONObject jSONObject, String str, long j) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j);
        }
        return ((Long) com.byazt.sd.a.hw().pr(str, Long.valueOf(j))).longValue();
    }

    public static int pr(JSONObject jSONObject, String str, int i) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i);
        }
        return ((Integer) com.byazt.sd.a.hw().pr(str, Integer.valueOf(i))).intValue();
    }
}
