package com.bytedance.sdk.openadsdk.ao.ms.ah;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements LocationProvider {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ValueSet f1651ms;

    public static SparseArray<Object> ms(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        com.bykv.ms.ms.ms.ms.xr xrVarMs = com.bykv.ms.ms.ms.ms.xr.ms();
        xrVarMs.ms(262001, locationProvider.getLatitude());
        xrVarMs.ms(262002, locationProvider.getLongitude());
        return xrVarMs.xr().sparseArray();
    }

    public ah(ValueSet valueSet) {
        this.f1651ms = valueSet == null ? com.bykv.ms.ms.ms.ms.xr.f12ms : valueSet;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f1651ms.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f1651ms.doubleValue(262002);
    }
}
