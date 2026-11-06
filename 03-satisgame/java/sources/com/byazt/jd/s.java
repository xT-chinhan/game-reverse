package com.byazt.jd;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 788, 8})
public class s implements LocationProvider {
    public ValueSet n;

    public static SparseArray<Object> n(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        com.byazt.qvu.s sVarN = com.byazt.qvu.s.n();
        sVarN.n(262001, locationProvider.getLatitude());
        sVarN.n(262002, locationProvider.getLongitude());
        return sVarN.qg().sparseArray();
    }

    public s(ValueSet valueSet) {
        this.n = valueSet == null ? com.byazt.qvu.s.n : valueSet;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.n.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.n.doubleValue(262002);
    }
}
