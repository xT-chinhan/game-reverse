package com.tapsdk.tapad.e;

import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.network.ResponseBean;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.model.entities.AdExpoResult;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class i {

    class a extends com.tapsdk.tapad.internal.network.c.c<ResponseBean<AdExpoResult>> {
        a() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdExpoResult a(TapAdConfig tapAdConfig, List<String> list) throws JSONException, com.tapsdk.tapad.internal.network.b.a, IOException, NullPointerException {
        com.tapsdk.tapad.internal.network.a aVarA = com.tapsdk.tapad.a.a().a(Constants.b.a);
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", GUIDHelper.INSTANCE.getUID());
            jSONObject.put(com.tapsdk.tapad.internal.tracker.experiment.h.b.n, tapAdConfig.mMediaId);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
            jSONObject.put("track_id", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ResponseBean responseBean = (ResponseBean) aVarA.a(new a(), "/ad-config/pre_load", map, map2, jSONObject);
        responseBean.getClass();
        return (AdExpoResult) responseBean.data;
    }
}
