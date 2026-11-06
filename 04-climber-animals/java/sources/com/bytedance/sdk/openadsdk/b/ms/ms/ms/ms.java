package com.bytedance.sdk.openadsdk.b.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.ms.ms.ms.ms.xr;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements TTFeedAd.CustomizeVideo {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f1836ms;

    public ms(Function<SparseArray<Object>, Object> function) {
        this.f1836ms = function == null ? xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 162101);
        sparseArray.put(-99999985, String.class);
        return (String) this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 162102);
        sparseArray.put(-99999985, Void.TYPE);
        this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 162103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 162104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 162105);
        sparseArray.put(-99999985, Void.class);
        this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 162106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 162107);
        sparseArray.put(-99999985, Void.class);
        this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 162108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, Integer.valueOf(i2));
        this.f1836ms.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 162109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        this.f1836ms.apply(sparseArray);
    }
}
