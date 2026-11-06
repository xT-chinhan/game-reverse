package com.bytedance.sdk.openadsdk.core.f;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.sdk.openadsdk.ao.xr.ah.ms {
    public ms(ValueSet valueSet) {
        super(valueSet);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.ah.ms
    public com.bytedance.sdk.openadsdk.ao.xr.ah.d ms() {
        Object objObjectValue = this.f1695ms.objectValue(261012, Object.class);
        if (objObjectValue instanceof ValueSet) {
            return new ka((ValueSet) objObjectValue);
        }
        if (objObjectValue instanceof SparseArray) {
            return new ka(com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) objObjectValue).xr());
        }
        return null;
    }
}
