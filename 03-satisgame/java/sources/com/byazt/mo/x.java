package com.byazt.mo;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1649, 21})
public class x implements TTAdDislike {
    public final Function<SparseArray<Object>, Object> n;

    public x(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? com.byazt.qvu.s.qg : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240101);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.byazt.zp.n(dislikeInteractionCallback));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240104);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240105);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.n.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
