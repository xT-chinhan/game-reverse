package com.bytedance.sdk.openadsdk.ao;

import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Bridge f1650ms;

    public ms(Bridge bridge) {
        this.f1650ms = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        Bridge bridge = this.f1650ms;
        if (bridge != null) {
            return bridge.values();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Bridge bridge = this.f1650ms;
        if (bridge == null) {
            return null;
        }
        if (valueSet == null) {
            valueSet = xr.f12ms;
        }
        return (T) bridge.call(i, valueSet, cls);
    }
}
