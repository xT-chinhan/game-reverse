package com.byazt.sb;

import com.byazt.ca.fw;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 765, 121})
public class x extends com.byazt.za.hw {
    public x(int i, int i2) {
        super(i, i2);
    }

    @Override // com.byazt.za.hw, com.byazt.za.pr
    public void pr(List<File> list) {
        int size = list.size();
        if (!pr(0L, size)) {
            for (File file : list) {
                fw.hn(file);
                size--;
                if (pr(file, 0L, size)) {
                    return;
                }
            }
        }
    }
}
