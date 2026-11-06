package com.byazt.sp;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 26})
public class qg {
    public final List<py> n = new ArrayList();

    public void n(py pyVar) {
        this.n.add(pyVar);
    }

    public void n(Path path) {
        for (int size = this.n.size() - 1; size >= 0; size--) {
            com.byazt.nu.tj.n(path, this.n.get(size));
        }
    }
}
