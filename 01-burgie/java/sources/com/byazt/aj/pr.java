package com.byazt.aj;

import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 61, 37})
public abstract class pr {
    public c hw;
    public List<com.byazt.i.uc.hw> pr;

    public abstract List<com.byazt.i.uc.hw> hn();

    public abstract boolean hw();

    public abstract int pr();

    public abstract String pr(String str, String str2);

    public abstract InputStream x();

    public c c() {
        return this.hw;
    }

    public com.byazt.i.uc.hw pr(String str) {
        List<com.byazt.i.uc.hw> list;
        if (str != null && (list = this.pr) != null && list.size() > 0) {
            for (com.byazt.i.uc.hw hwVar : this.pr) {
                if (str.equals(hwVar.pr)) {
                    return hwVar;
                }
            }
        }
        return null;
    }
}
