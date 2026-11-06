package com.bytedance.sdk.openadsdk.mediation.xr.ms.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements IMediationDrawTokenInfo {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f4046ms;

    public ms(Function<SparseArray<Object>, Object> function) {
        this.f4046ms = function == null ? com.bykv.ms.ms.ms.ms.xr.ah : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270031);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.t.ms.ms.ms.ms(drawFeedAdListener));
        this.f4046ms.apply(sparseArray);
    }
}
