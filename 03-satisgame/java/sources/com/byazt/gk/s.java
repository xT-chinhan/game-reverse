package com.byazt.gk;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1526, 8})
public class s extends MediationNativeAdAppInfo {
    private final Function<SparseArray<Object>, Object> n;

    public s(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.s.qg : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAppName() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271035);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getAuthorName() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271036);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public long getPackageSizeBytes() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271037);
        sparseArray.put(-99999985, Long.TYPE);
        return ((Long) this.n.apply(sparseArray)).longValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPermissionsUrl() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271038);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, String> getPermissionsMap() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271039);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getPrivacyAgreement() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271040);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getVersionName() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271041);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getFunctionDescUrl() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271047);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public String getRegUrl() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271051);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo
    public Map<String, Object> getAppInfoExtra() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 271042);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.n.apply(sparseArray);
    }
}
