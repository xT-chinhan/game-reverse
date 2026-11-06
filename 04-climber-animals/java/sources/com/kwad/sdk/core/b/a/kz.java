package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class kz implements com.kwad.sdk.core.d<com.kwad.components.ad.reward.k.r.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.reward.k.r.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.reward.k.r.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.reward.k.r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.AL = new RewardFraudVerifyRespInfo.FraudDataInfo();
        aVar.AL.parseJson(jSONObject.optJSONObject("verifyResult"));
    }

    private static JSONObject b(com.kwad.components.ad.reward.k.r.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.aa.a(jSONObject, "verifyResult", aVar.AL);
        return jSONObject;
    }
}
