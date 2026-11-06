package com.byazt.eaw;

import android.util.SparseArray;
import com.byazt.qvu.s;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 696, 26})
public class qg implements ILiveHostActionParam {
    public Function<SparseArray<Object>, Object> n;

    public qg(Function<SparseArray<Object>, Object> function) {
        this.n = function;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        if (this.n != null) {
            this.n.apply(s.n().n(0, z).n(1, str).n(2, str2).n(3, map).n(-99999987, 1).qg().sparseArray());
        }
    }
}
