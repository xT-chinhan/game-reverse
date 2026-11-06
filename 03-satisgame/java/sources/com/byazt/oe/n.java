package com.byazt.oe;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1218, 19})
public class n extends MediationAdEcpmInfo {
    private final Function<SparseArray<Object>, Object> n;
    private ValueSet qg;

    public n(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public Map<String, String> getCustomData() {
        return (Map) this.qg.objectValue(271006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSdkName() {
        return this.qg.stringValue(271007);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getCustomSdkName() {
        return this.qg.stringValue(271008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSlotId() {
        return this.qg.stringValue(271009);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getLevelTag() {
        return this.qg.stringValue(271010);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getEcpm() {
        return this.qg.stringValue(271011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public int getReqBiddingType() {
        return this.qg.intValue(271012);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getErrorMsg() {
        return this.qg.stringValue(271013);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getRequestId() {
        return this.qg.stringValue(271014);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getRitType() {
        return this.qg.stringValue(271015);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSegmentId() {
        return this.qg.stringValue(271016);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getChannel() {
        return this.qg.stringValue(271017);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSubChannel() {
        return this.qg.stringValue(271018);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getAbTestId() {
        return this.qg.stringValue(271019);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getScenarioId() {
        return this.qg.stringValue(271020);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSubRitType() {
        return this.qg.stringValue(271051);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getDiscount() {
        return this.qg.stringValue(271052);
    }
}
