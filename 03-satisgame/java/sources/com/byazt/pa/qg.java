package com.byazt.pa;

import com.byazt.tk.x;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2192, 26})
public class qg extends s {
    public qg(int i, int i2) {
        super(i, i2);
    }

    @Override // com.byazt.pa.s, com.byazt.pa.n
    public void n(List<File> list) {
        int size = list.size();
        if (n(0L, size)) {
            return;
        }
        for (File file : list) {
            x.s(file);
            size--;
            if (n(file, 0L, size)) {
                return;
            }
        }
    }
}
