package com.byazt.ufs;

import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1460, 19})
public class n implements TTFeedAd.CustomizeVideo {
    public final Function<SparseArray<Object>, Object> n;

    public n(Function<SparseArray<Object>, Object> function) {
        this.n = function == null ? s.qg : function;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 162101);
        sparseArray.put(-99999985, String.class);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 162102);
        sparseArray.put(-99999985, Void.TYPE);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 162103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 162104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 162105);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 162106);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 162107);
        sparseArray.put(-99999985, Void.class);
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 162108);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, Integer.valueOf(i2));
        this.n.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j, int i, int i2) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(-99999987, 162109);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, Long.valueOf(j));
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        this.n.apply(sparseArray);
    }
}
