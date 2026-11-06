package com.byazt.ls;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1121, 37})
public class pr implements IHostPermission {
    public final Function<SparseArray<Object>, Object> pr;

    public pr(Function<SparseArray<Object>, Object> function) {
        this.pr = function == null ? hn.hw : function;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262101);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        final com.byazt.bm.hn hnVar;
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 262102);
        sparseArray.put(-99999985, com.bytedance.sdk.openadsdk.LocationProvider.class);
        Object objApply = this.pr.apply(sparseArray);
        if (!(objApply instanceof SparseArray)) {
            hnVar = null;
        } else {
            hnVar = new com.byazt.bm.hn(hn.pr((SparseArray<Object>) objApply).hw());
        }
        if (hnVar == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.byazt.ls.pr.1
            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLatitude() {
                return hnVar.getLatitude();
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLongitude() {
                return hnVar.getLongitude();
            }
        };
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262103);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262104);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262105);
        sparseArray.put(-99999985, String.class);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262106);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262107);
        sparseArray.put(-99999985, String.class);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262108);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262109);
        sparseArray.put(-99999985, String.class);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262112);
        sparseArray.put(-99999985, String.class);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 262110);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
