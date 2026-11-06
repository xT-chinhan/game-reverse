package com.bytedance.sdk.openadsdk.ao.xr.xr;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Bridge {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1714ms;
    private Bridge xr;

    public c(Bridge bridge) {
        this.xr = com.bykv.ms.ms.ms.ms.xr.xr;
        this.xr = bridge == null ? com.bykv.ms.ms.ms.ms.xr.xr : bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        ValueSet valueSet = this.f1714ms;
        if (valueSet != null) {
            return valueSet;
        }
        ValueSet valueSetAb = ab();
        this.f1714ms = valueSetAb;
        return valueSetAb;
    }

    private ValueSet ab() {
        return com.bykv.ms.ms.ms.ms.xr.ms().xr();
    }

    public String ms() {
        return (String) this.xr.call(241103, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), String.class);
    }

    public String xr() {
        return (String) this.xr.call(241104, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), String.class);
    }

    public boolean ah() {
        return ((Boolean) this.xr.call(241105, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), Boolean.TYPE)).booleanValue();
    }

    public List<c> d() {
        List arrayList = (List) this.xr.call(241108, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), List.class);
        if (arrayList == null) {
            arrayList = new ArrayList(0);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new c((Bridge) it.next()));
        }
        return arrayList2;
    }

    public boolean ka() {
        return ((Boolean) this.xr.call(241107, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), Boolean.TYPE)).booleanValue();
    }

    public boolean c() {
        return ((Boolean) this.xr.call(241106, com.bykv.ms.ms.ms.ms.xr.ms(0).xr(), Boolean.TYPE)).booleanValue();
    }

    public void ms(c cVar) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, cVar);
        this.xr.call(241101, xrVarMs.xr(), Void.class);
    }

    public void ms(boolean z) {
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms(1);
        xrVarMs.ms(0, z);
        this.xr.call(241102, xrVarMs.xr(), Void.class);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 241101:
                ms(new c((Bridge) valueSet.objectValue(0, Bridge.class)));
                return null;
            case 241102:
                ms(valueSet.booleanValue(0));
                return null;
            case 241103:
                return (T) ms();
            case 241104:
                return (T) xr();
            case 241105:
                return (T) Boolean.class.cast(Boolean.valueOf(ah()));
            case 241106:
                return (T) Boolean.class.cast(Boolean.valueOf(c()));
            case 241107:
                return (T) Boolean.class.cast(Boolean.valueOf(ka()));
            case 241108:
                return (T) d();
            default:
                return null;
        }
    }
}
