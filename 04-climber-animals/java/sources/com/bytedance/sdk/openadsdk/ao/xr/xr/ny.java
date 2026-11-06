package com.bytedance.sdk.openadsdk.ao.xr.xr;

import android.graphics.Bitmap;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ny extends ch implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1731ms;

    public abstract void ms(Bitmap bitmap, int i);

    public abstract void ms(com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms msVar);

    public abstract void ms(boolean z);

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch, com.bytedance.sdk.openadsdk.ao.xr.xr.zb, com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1731ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetD = d();
        this.f1731ms = valueSetD;
        return valueSetD;
    }

    private ValueSet d() {
        return com.bykv.ms.ms.ms.ms.xr.ms(super.values()).xr();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch, com.bytedance.sdk.openadsdk.ao.xr.xr.zb, com.bytedance.sdk.openadsdk.ao.xr.xr.x, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 170101:
                ms(valueSet.booleanValue(0));
                break;
            case 170102:
                ms((Bitmap) valueSet.objectValue(0, Bitmap.class), valueSet.intValue(1));
                break;
            case 170103:
                ms(new com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
        }
        return (T) super.call(i, valueSet, cls);
    }
}
