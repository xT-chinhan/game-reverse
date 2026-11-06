package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends com.bytedance.sdk.openadsdk.api.ka implements DownloadMarketInterceptor {
    public ab(Function<SparseArray<Object>, Object> function) {
        this.f1777ms = function;
    }

    public ab(EventListener eventListener) {
        this.xr = eventListener;
    }

    @Override // com.ss.android.download.api.config.DownloadMarketInterceptor
    public Map<String, Object> interceptObmMarket(Map<String, Object> map) {
        ValueSet valueSetMs = ms(ValueSetConstants.VALUE_METHOD_INTERCEPT_OBM_MARKET, com.bykv.ms.ms.ms.ms.ms.ms().ms(com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_PARAMS_INTERCEPT_OBM_MARKET, map).xr()).xr());
        if (valueSetMs != null) {
            return (Map) valueSetMs.objectValue(ValueSetConstants.VALUE_PARAMS_INTERCEPT_OBM_MARKET, Map.class);
        }
        return null;
    }
}
