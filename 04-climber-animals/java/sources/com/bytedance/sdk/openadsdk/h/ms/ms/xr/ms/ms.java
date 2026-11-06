package com.bytedance.sdk.openadsdk.h.ms.ms.xr.ms;

import android.os.Bundle;
import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f3917ms;

    public abstract void ms(Bundle bundle);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f3917ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetMs = ms();
        this.f3917ms = valueSetMs;
        return valueSetMs;
    }

    private ValueSet ms() {
        return xr.ms().xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 123101) {
            return null;
        }
        ms((Bundle) valueSet.objectValue(0, Bundle.class));
        return null;
    }
}
