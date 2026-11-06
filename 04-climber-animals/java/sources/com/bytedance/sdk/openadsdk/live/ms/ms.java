package com.bytedance.sdk.openadsdk.live.ms;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import com.bytedance.sdk.openadsdk.ao.ms.ah.ah;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements IHostPermission {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f3934ms;

    public ms(Function<SparseArray<Object>, Object> function) {
        this.f3934ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262101);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f3934ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 262102);
        sparseArray.put(-99999985, com.bytedance.sdk.openadsdk.LocationProvider.class);
        Object objApply = this.f3934ms.apply(sparseArray);
        final ah ahVar = objApply instanceof SparseArray ? new ah(com.bykv.ms.ms.ms.ms.xr.ms((SparseArray<Object>) objApply).xr()) : null;
        if (ahVar == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.live.ms.ms.1
            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLatitude() {
                return ahVar.getLatitude();
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLongitude() {
                return ahVar.getLongitude();
            }
        };
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262103);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f3934ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262104);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f3934ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262105);
        sparseArray.put(-99999985, String.class);
        return (String) this.f3934ms.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f3934ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262107);
        sparseArray.put(-99999985, String.class);
        return (String) this.f3934ms.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262108);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f3934ms.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262109);
        sparseArray.put(-99999985, String.class);
        return (String) this.f3934ms.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262112);
        sparseArray.put(-99999985, String.class);
        return (String) this.f3934ms.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262110);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.f3934ms.apply(sparseArray)).booleanValue();
    }
}
