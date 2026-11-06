package com.byazt.xjg;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTImage;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 12, 109})
public class w extends TTImage {
    public ValueSet hw;
    public final Function<SparseArray<Object>, Object> pr;

    public w(Function<SparseArray<Object>, Object> function) {
        this.hw = com.byazt.ij.hn.pr;
        function = function == null ? com.byazt.ij.hn.hw : function;
        this.pr = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.hw = com.byazt.ij.hn.pr((SparseArray<Object>) objApply).hw();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getHeight() {
        return this.hw.intValue(230002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getWidth() {
        return this.hw.intValue(230001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public String getImageUrl() {
        return this.hw.stringValue(230003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public double getDuration() {
        return this.hw.doubleValue(230004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public boolean isValid() {
        return this.hw.booleanValue(230005);
    }
}
