package com.byazt.io;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ExitInstallListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1886, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public final ExitInstallListener n;

    public n(ExitInstallListener exitInstallListener) {
        this.n = exitInstallListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n != null && com.byazt.qvu.s.n(sparseArray).qg().intValue(-99999987) == 223101) {
            this.n.onExitInstall();
        }
        return null;
    }
}
