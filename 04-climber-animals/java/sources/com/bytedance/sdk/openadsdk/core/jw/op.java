package com.bytedance.sdk.openadsdk.core.jw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.ValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class op {
    public static com.bytedance.sdk.openadsdk.ao.xr.ah.xr ms(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms msVar = new com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms();
            msVar.ms(jSONObject.optString("mAdId", ""));
            msVar.xr(jSONObject.optString("mCreativeId", ""));
            msVar.ah(jSONObject.optString("mExt", ""));
            msVar.d(jSONObject.optString("mCodeId", ""));
            msVar.ny(jSONObject.optString("mUserData"));
            msVar.ms(jSONObject.optBoolean("mIsAutoPlay", true));
            int iOptInt = jSONObject.optInt("mImgAcceptedWidth", MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK);
            msVar.xr(jSONObject.optInt("mImgAcceptedHeight", MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME));
            msVar.ms(iOptInt);
            double dOptDouble = jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d);
            double dOptDouble2 = jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d);
            msVar.xr(Double.valueOf(dOptDouble).floatValue());
            msVar.ms(Double.valueOf(dOptDouble2).floatValue());
            msVar.xr(jSONObject.optBoolean("mSupportDeepLink", true));
            msVar.ah(jSONObject.optInt("mAdCount", 1));
            msVar.ka(jSONObject.optString("mMediaExtra", ""));
            msVar.c(jSONObject.optString("mUserID", ""));
            msVar.d(jSONObject.optInt("mOrientation", 2));
            msVar.ka(jSONObject.optInt("mNativeAdType"));
            msVar.ms(f.zb(jSONObject.optString("mExternalABVid", "")));
            msVar.c(jSONObject.optInt("mAdLoadSeq", 0));
            msVar.ab(jSONObject.optString("mPrimeRit", ""));
            msVar.x(jSONObject.optString("mBidAdm"));
            msVar.x(jSONObject.optInt("mRewardAmount", 0));
            msVar.ch(jSONObject.optString("mRewardName", ""));
            return msVar.ms();
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mAdId", xrVar.ms());
            jSONObject.put("mCreativeId", xrVar.xr());
            jSONObject.put("mExt", xrVar.ah());
            jSONObject.put("mCodeId", str);
            jSONObject.put("mUserData", xrVar.b());
            jSONObject.put("mIsAutoPlay", xrVar.ka());
            jSONObject.put("mImgAcceptedWidth", xrVar.c());
            jSONObject.put("mImgAcceptedHeight", xrVar.ab());
            jSONObject.put("mExpressViewAcceptedWidth", xrVar.x());
            jSONObject.put("mExpressViewAcceptedHeight", xrVar.ny());
            jSONObject.put("mSupportDeepLink", xrVar.ch());
            jSONObject.put("mSupportRenderControl", xrVar.hi());
            if (com.bytedance.sdk.openadsdk.core.g.xr >= 5900) {
                jSONObject.put("mSupportIconStyle", xrVar.yu());
            }
            jSONObject.put("mAdCount", xrVar.sl());
            jSONObject.put("mMediaExtra", xrVar.zb());
            jSONObject.put("mUserID", xrVar.u());
            jSONObject.put("mOrientation", xrVar.ub());
            jSONObject.put("mNativeAdType", xrVar.ao());
            jSONObject.put("mExternalABVid", f.ms(xrVar.h()));
            jSONObject.put("mAdLoadSeq", xrVar.qv());
            jSONObject.put("mPrimeRit", xrVar.y());
            jSONObject.put("mBidAdm", xrVar.nw());
            jSONObject.put("mRewardAmount", xrVar.w());
            jSONObject.put("mRewardName", xrVar.i());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject ms(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        return ms(xrVar, xrVar.d());
    }

    public static com.bytedance.sdk.openadsdk.ao.xr.ah.xr ms(int i, String str, float f, float f2) {
        return ms().d(str).ab(i).xr(f2).ms(f).ms();
    }

    public static com.bytedance.sdk.openadsdk.ao.xr.ah.xr ms(int i) {
        return ms().ab(i).ms();
    }

    public static com.bytedance.sdk.openadsdk.ao.xr.ah.xr ms(int i, ValueSet valueSet) {
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar = new com.bytedance.sdk.openadsdk.ao.xr.ah.xr(valueSet);
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms msVar = new com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms(xrVar);
        float fX = xrVar.x();
        float fNy = xrVar.ny();
        if (fX <= 0.0f) {
            fX = ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), xrVar.c());
            fNy = ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), xrVar.ab());
        }
        if (fX > 0.0f || fNy > 0.0f) {
            int iD = (int) (((double) ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), ul.ka(com.bytedance.sdk.openadsdk.core.re.getContext()))) * 1.3d);
            int iD2 = (int) (((double) ul.d(com.bytedance.sdk.openadsdk.core.re.getContext(), ul.d(com.bytedance.sdk.openadsdk.core.re.getContext()))) * 1.3d);
            int iMax = Math.max(iD, iD2);
            int iMin = Math.min(iD, iD2);
            if (fX > fNy) {
                if (iD2 > 0) {
                    float f = iMax;
                    if (fX > f) {
                        fNy = iMin;
                        fX = f;
                    }
                }
            } else if (iD > 0) {
                float f2 = iMax;
                if (fNy > f2) {
                    fX = iMin;
                    fNy = f2;
                }
            }
        }
        msVar.ms(fX).xr(fNy);
        return new com.bytedance.sdk.openadsdk.core.nw.ah(xr(msVar.ms()).ab(i).ms());
    }

    public static final com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms xr(com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        return new com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms(xrVar);
    }

    private static final com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms ms() {
        return new com.bytedance.sdk.openadsdk.ao.xr.ah.xr.ms().ah(1).xr(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME).ms(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK).xr(true).c("defaultUser").d(2).ms(true);
    }

    public static boolean ms(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, z);
        }
        return ((Boolean) com.bytedance.sdk.openadsdk.core.re.xr().ms(str, Boolean.valueOf(z))).booleanValue();
    }

    public static long ms(JSONObject jSONObject, String str, long j) {
        if (jSONObject.has(str)) {
            return jSONObject.optLong(str, j);
        }
        return ((Long) com.bytedance.sdk.openadsdk.core.re.xr().ms(str, Long.valueOf(j))).longValue();
    }

    public static int ms(JSONObject jSONObject, String str, int i) {
        if (jSONObject.has(str)) {
            return jSONObject.optInt(str, i);
        }
        return ((Integer) com.bytedance.sdk.openadsdk.core.re.xr().ms(str, Integer.valueOf(i))).intValue();
    }
}
