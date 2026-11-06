package com.anythink.network.ks;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.ATSDKGlobalSetting;
import com.anythink.core.common.k;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KSBidRequestInfo extends ATBidRequestInfo {
    String a;
    JSONObject b = new JSONObject();
    int c;
    String d;
    String e;

    KSBidRequestInfo(Map<String, Object> map, Map<String, Object> map2, int i) {
        try {
            String str = (String) map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ACCOUNT_ID);
            String str2 = (String) map.get("position_id");
            if (map.containsKey("orientation")) {
                this.c = Integer.parseInt(map.get("orientation").toString());
            }
            if (map2 != null) {
                this.d = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
                this.e = map2.get(ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map2.get(ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
            }
            if (!TextUtils.isEmpty(this.e) && this.e.contains(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME)) {
                this.e = this.e.replace(ATAdConst.REWARD_EXTRA_REPLACE_HODLER_KEY.NETWORK_PLACEMENT_ID_HOLDER_NAME, str2 + "");
            }
            HashMap map3 = new HashMap();
            if (!TextUtils.isEmpty(this.d)) {
                map3.put("thirdUserId", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                map3.put("extraData", this.e);
            }
            boolean z = true;
            KsScene.Builder builderAdNum = new KsScene.Builder(Long.parseLong(str2)).adNum(1);
            int i2 = 2;
            if (this.c != 2) {
                i2 = 1;
            }
            KsScene.Builder builderScreenOrientation = builderAdNum.screenOrientation(i2);
            builderScreenOrientation = map3.isEmpty() ? builderScreenOrientation : builderScreenOrientation.rewardCallbackExtraData(map3);
            Object obj = map2.containsKey(ATAdConst.KEY.AD_WIDTH) ? map2.get(ATAdConst.KEY.AD_WIDTH) : null;
            Object obj2 = map2.containsKey(ATAdConst.KEY.AD_HEIGHT) ? map2.get(ATAdConst.KEY.AD_HEIGHT) : null;
            if (obj != null) {
                try {
                    int i3 = (int) Double.parseDouble(obj.toString());
                    if (i3 > 0) {
                        builderScreenOrientation.width(i3);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (obj2 != null) {
                try {
                    int i4 = (int) Double.parseDouble(obj2.toString());
                    if (i4 > 0) {
                        builderScreenOrientation.height(i4);
                    }
                } catch (Throwable unused) {
                }
            }
            try {
                Boolean boolIsShakeEnabled = ATSDKGlobalSetting.isShakeEnabled(28);
                if (i == 4) {
                    SplashAdExtraData splashAdExtraData = new SplashAdExtraData();
                    splashAdExtraData.setDisableRotateStatus(!boolIsShakeEnabled.booleanValue());
                    splashAdExtraData.setDisableShakeStatus(!boolIsShakeEnabled.booleanValue());
                    splashAdExtraData.setDisableSlideStatus(!boolIsShakeEnabled.booleanValue());
                    builderScreenOrientation.setSplashExtraData(splashAdExtraData);
                } else if (i == 0) {
                    NativeAdExtraData nativeAdExtraData = new NativeAdExtraData();
                    if (boolIsShakeEnabled != null) {
                        nativeAdExtraData.setEnableShake(boolIsShakeEnabled.booleanValue());
                        nativeAdExtraData.setEnableRotate(boolIsShakeEnabled.booleanValue());
                    } else {
                        nativeAdExtraData.setEnableShake(ATInitMediation.getIntFromMap(map, k.aH) == 1);
                        if (ATInitMediation.getIntFromMap(map, "rotate_type") != 1) {
                            z = false;
                        }
                        nativeAdExtraData.setEnableRotate(z);
                    }
                    builderScreenOrientation.setNativeAdExtraData(nativeAdExtraData);
                }
            } catch (Throwable unused2) {
            }
            this.a = KsAdSDK.getLoadManager().getBidRequestTokenV2(builderScreenOrientation.build());
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ACCOUNT_ID, str);
            this.b.put("unit_id", str2);
            this.b.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BID_TOKEN, this.a);
        } catch (Throwable unused3) {
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.a);
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.b;
    }
}
