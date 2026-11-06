package com.bytedance.sdk.openadsdk.ao.ms.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ab implements TTAdDislike {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f1674ms;

    public ab(Function<SparseArray<Object>, Object> function) {
        this.f1674ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240101);
        sparseArray.put(-99999985, Void.class);
        this.f1674ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240102);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, new com.bytedance.sdk.openadsdk.y.ms.ms.ms.ms(dislikeInteractionCallback));
        this.f1674ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        this.f1674ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240104);
        sparseArray.put(-99999985, Void.class);
        this.f1674ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 240105);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.f1674ms.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
