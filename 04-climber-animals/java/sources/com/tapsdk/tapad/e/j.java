package com.tapsdk.tapad.e;

import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.network.ResponseBean;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.RewardResult;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    class a implements Function<ResponseBean<RewardResult>, RewardResult> {
        a() {
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public RewardResult apply(ResponseBean<RewardResult> responseBean) throws Exception {
            return responseBean.data;
        }
    }

    class b extends com.tapsdk.tapad.internal.network.c.c<ResponseBean<RewardResult>> {
        b() {
        }
    }

    public Observable<RewardResult> a(AdRequest adRequest, AdInfo adInfo, TapAdConfig tapAdConfig) {
        com.tapsdk.tapad.internal.network.a aVarA = com.tapsdk.tapad.a.a().a(Constants.b.a);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", adRequest.userId);
            jSONObject.put("track_id", adInfo.trackId);
            if (adRequest.extra1 != null && adRequest.extra1.length() > 0) {
                jSONObject.put("extra", adRequest.extra1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aVarA.b(new b(), "/ad-config/reward_verify", jSONObject).map(new a());
    }
}
