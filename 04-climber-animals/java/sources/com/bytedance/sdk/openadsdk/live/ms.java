package com.bytedance.sdk.openadsdk.live;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.callback.Callback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Callback<Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f3933ms;

    public ms(Function<SparseArray<Object>, Object> function) {
        this.f3933ms = function;
    }

    @Override // com.bytedance.android.live.base.api.callback.Callback
    public void invoke(Object obj) {
        if (this.f3933ms != null) {
            this.f3933ms.apply(com.bykv.ms.ms.ms.ms.xr.ms().ms(0, obj).ms(-99999987, 1).xr().sparseArray());
        }
    }
}
