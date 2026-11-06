package com.byazt.ova;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 13})
public class hw {
    public final List<cz> pr = new ArrayList();

    public void pr(cz czVar) {
        this.pr.add(czVar);
    }

    public void pr(Path path) {
        for (int size = this.pr.size() - 1; size >= 0; size--) {
            com.byazt.ptr.vk.pr(path, this.pr.get(size));
        }
    }
}
