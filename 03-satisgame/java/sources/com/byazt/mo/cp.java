package com.byazt.mo;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTImage;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 29})
public class cp extends TTImage {
    public final Function<SparseArray<Object>, Object> n;
    public ValueSet qg;

    public cp(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getHeight() {
        return this.qg.intValue(230002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getWidth() {
        return this.qg.intValue(230001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public String getImageUrl() {
        return this.qg.stringValue(230003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public double getDuration() {
        return this.qg.doubleValue(230004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public boolean isValid() {
        return this.qg.booleanValue(230005);
    }
}
