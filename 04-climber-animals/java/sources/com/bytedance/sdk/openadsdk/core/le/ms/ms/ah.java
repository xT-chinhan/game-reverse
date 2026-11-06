package com.bytedance.sdk.openadsdk.core.le.ms.ms;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements EventListener {
    protected Map<String, Object> ms(Map<String, Object> map) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        if (i != 223901 || result == null || result.values() == null) {
            return null;
        }
        return com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_PARAMS_INTERCEPT_OBM_MARKET, ms((Map) result.values().objectValue(ValueSetConstants.VALUE_PARAMS_INTERCEPT_OBM_MARKET, Map.class))).xr();
    }
}
