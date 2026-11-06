package com.bytedance.sdk.openadsdk.ao.xr.ah;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes2.dex */
public class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public final ValueSet f1695ms;

    public ms(ValueSet valueSet) {
        this.f1695ms = valueSet == null ? com.bykv.ms.ms.ms.ms.xr.f12ms : valueSet;
    }

    public String xr() {
        return (String) this.f1695ms.objectValue(261001, String.class);
    }

    public String ah() {
        return (String) this.f1695ms.objectValue(261002, String.class);
    }

    public boolean d() {
        return this.f1695ms.booleanValue(261003);
    }

    public String ka() {
        return (String) this.f1695ms.objectValue(261004, String.class);
    }

    public String c() {
        return (String) this.f1695ms.objectValue(261005, String.class);
    }

    public int ab() {
        return this.f1695ms.intValue(261006);
    }

    public boolean x() {
        return this.f1695ms.booleanValue(261007);
    }

    public boolean ny() {
        return this.f1695ms.booleanValue(261008);
    }

    public int[] ch() {
        return (int[]) this.f1695ms.objectValue(261009, int[].class);
    }

    public boolean hi() {
        return this.f1695ms.booleanValue(261011);
    }

    public d ms() {
        ValueSet valueSet = (ValueSet) this.f1695ms.objectValue(261012, ValueSet.class);
        if (valueSet != null) {
            return new d(valueSet);
        }
        return null;
    }

    public int sl() {
        return this.f1695ms.intValue(261013);
    }

    public int zb() {
        return this.f1695ms.intValue(261014);
    }

    public boolean u() {
        return this.f1695ms.booleanValue(261017);
    }
}
