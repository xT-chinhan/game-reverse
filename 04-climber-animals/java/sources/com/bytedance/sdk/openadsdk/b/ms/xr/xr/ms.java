package com.bytedance.sdk.openadsdk.b.ms.xr.xr;

import com.bykv.ms.ms.ms.ms.xr;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1841ms;

    public abstract void ah();

    public abstract void ah(long j);

    public abstract void d();

    public abstract String ms();

    public abstract void ms(int i, int i2);

    public abstract void ms(long j);

    public abstract void ms(long j, int i, int i2);

    public abstract void xr();

    public abstract void xr(long j);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1841ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetKa = ka();
        this.f1841ms = valueSetKa;
        return valueSetKa;
    }

    private ValueSet ka() {
        return xr.ms().xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 162101:
                return (T) ms();
            case 162102:
                xr();
                return null;
            case 162103:
                ms(valueSet.longValue(0));
                return null;
            case 162104:
                xr(valueSet.longValue(0));
                return null;
            case 162105:
                ah();
                return null;
            case 162106:
                ah(valueSet.longValue(0));
                return null;
            case 162107:
                d();
                return null;
            case 162108:
                ms(valueSet.intValue(0), valueSet.intValue(1));
                return null;
            case 162109:
                ms(valueSet.longValue(0), valueSet.intValue(1), valueSet.intValue(2));
                return null;
            default:
                return null;
        }
    }
}
