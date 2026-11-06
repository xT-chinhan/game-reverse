package com.bytedance.sdk.openadsdk.live.ms;

import android.util.SparseArray;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements ILiveHostActionParam {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Function<SparseArray<Object>, Object> f3936ms;

    public xr(Function<SparseArray<Object>, Object> function) {
        this.f3936ms = function;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        if (this.f3936ms != null) {
            this.f3936ms.apply(com.bykv.ms.ms.ms.ms.xr.ms().ms(0, z).ms(1, str).ms(2, str2).ms(3, map).ms(-99999987, 1).xr().sparseArray());
        }
    }
}
