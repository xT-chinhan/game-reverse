package com.byazt.mo;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 8})
public class s implements ComplianceInfo {
    public final Function<SparseArray<Object>, Object> n;
    public ValueSet qg;

    public s(Function<SparseArray<Object>, Object> function) {
        this.qg = com.byazt.qvu.s.n;
        function = function == null ? com.byazt.qvu.s.qg : function;
        this.n = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.qg = com.byazt.qvu.s.n((SparseArray<Object>) objApply).qg();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppName() {
        return this.qg.stringValue(250001);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppVersion() {
        return this.qg.stringValue(250002);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getDeveloperName() {
        return this.qg.stringValue(250003);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPrivacyUrl() {
        return this.qg.stringValue(250004);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.qg.objectValue(250006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPermissionUrl() {
        return this.qg.stringValue(250005);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getFunctionDescUrl() {
        return this.qg.stringValue(250007);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getRegUrl() {
        return this.qg.stringValue(250009);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getRegNumber() {
        return this.qg.stringValue(250008);
    }
}
