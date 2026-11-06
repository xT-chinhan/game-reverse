package com.byazt.oe;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1218, 26})
public class qg implements MediationAdLoadInfo {
    private final Function<SparseArray<Object>, Object> n;
    private ValueSet qg;

    public qg(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return this.qg.stringValue(271001);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return this.qg.stringValue(271002);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return this.qg.stringValue(271003);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.qg.intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return this.qg.stringValue(271005);
    }
}
