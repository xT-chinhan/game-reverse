package com.byazt.ls;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1121, 13})
public class hw implements ILiveHostActionParam {
    public Function<SparseArray<Object>, Object> pr;

    public hw(Function<SparseArray<Object>, Object> function) {
        this.pr = function;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        if (this.pr != null) {
            this.pr.apply(hn.pr().pr(0, z).pr(1, str).pr(2, str2).pr(3, map).pr(-99999987, 1).hw().sparseArray());
        }
    }
}
