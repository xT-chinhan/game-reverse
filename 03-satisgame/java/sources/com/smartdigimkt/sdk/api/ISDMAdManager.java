package com.smartdigimkt.sdk.api;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ISDMAdManager {

    public interface BidTokenCallBack {
        void onComplete(JSONObject jSONObject);
    }

    public interface S2SBidTokenCallback {
        void onComplete(String str);
    }

    void getBidTokenJSONObject(Map<String, Object> map, BidTokenCallBack bidTokenCallBack);

    JSONObject getDirectlyBidTokenJSONObject(Context context, Map<String, Object> map, Map<String, String> map2);

    void getS2SBidToken(String str, Map<String, Object> map, S2SBidTokenCallback s2SBidTokenCallback);
}
