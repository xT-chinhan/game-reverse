package com.anythink.network.adx;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATInitMediation;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdxBidRequestInfo extends ATBidRequestInfo {
    private JSONObject a;

    public AdxBidRequestInfo(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public void fillLocalExtra(Map<String, Object> map, boolean z) {
        int intFromMap;
        int intFromMap2;
        if (z) {
            if (map != null) {
                try {
                    intFromMap = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_WIDTH);
                    intFromMap2 = ATInitMediation.getIntFromMap(map, ATAdConst.KEY.AD_HEIGHT);
                } catch (Throwable unused) {
                    return;
                }
            } else {
                intFromMap = -1;
                intFromMap2 = -1;
            }
            if (intFromMap > 0) {
                this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_WIDTH, intFromMap);
            }
            if (intFromMap2 > 0) {
                this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_HEIGHT, intFromMap2);
            }
        }
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.a;
    }
}
