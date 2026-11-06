package com.tapsdk.tapad.internal;

import com.tapsdk.tapad.AdRequest;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class WasmAdnLoadRequest {
    private WasmAdnLoadRequest() {
    }

    public static JSONObject create(AdRequest adRequest) {
        return new JSONObject().put(com.tapsdk.tapad.constants.Constants.Bidding.SPACE_ID, adRequest.spaceId).put(Common.System.USER_ID, safe(adRequest.userId)).put("reward_extras", safe(adRequest.extra1)).put("reward_name", safe(adRequest.rewardName)).put("reward_amount", adRequest.rewardAmount).put("query", safe(adRequest.query)).put("mina_id", adRequest.minaId).put("wall_time_ms", System.currentTimeMillis()).put("from_change_ad", adRequest.fromChangeAd).put("change_ad_times", adRequest.changeAdTimes).put(com.tapsdk.tapad.constants.Constants.Bidding.REQUEST_ID, safe(adRequest.requestId));
    }

    private static String safe(String str) {
        return str == null ? "" : str;
    }
}
