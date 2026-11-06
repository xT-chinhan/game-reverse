package com.byazt.mo;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJAdError;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 19})
public class n extends CSJAdError {
    public final Function<SparseArray<Object>, Object> n;
    public ValueSet qg;

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

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.qg.intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return this.qg.stringValue(263002);
    }
}
