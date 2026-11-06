package com.bytedance.sdk.openadsdk.ah;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ms.InterfaceC0260ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f1649ms;

    public xr(Function<SparseArray<Object>, Object> function) {
        this.f1649ms = function;
    }

    @Override // com.bytedance.sdk.openadsdk.ah.ms.InterfaceC0260ms
    public void ms() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 0);
        Function<SparseArray<Object>, Object> function = this.f1649ms;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ah.ms.InterfaceC0260ms
    public void xr() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        Function<SparseArray<Object>, Object> function = this.f1649ms;
        if (function != null) {
            function.apply(sparseArray);
        }
    }
}
