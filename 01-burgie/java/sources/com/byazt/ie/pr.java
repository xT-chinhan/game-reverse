package com.byazt.ie;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 585, 37})
public abstract class pr {
    public abstract List<com.byazt.hh.pr> hw(int i, com.byazt.hh.pr prVar, boolean z, List<String> list, String str);

    public abstract boolean hw(int i, String str, com.byazt.hh.pr prVar);

    public abstract boolean pr(com.byazt.hh.pr prVar);

    public abstract boolean pr(String str);

    public List<com.byazt.hh.pr> pr(int i, com.byazt.hh.pr prVar, boolean z, List<String> list, String str) {
        if (com.byazt.nn.x.pr(i)) {
            return hw(i, prVar, z, list, str);
        }
        if (pr(prVar)) {
            return hw(i, prVar, z, list, str);
        }
        return null;
    }

    public boolean pr(int i, String str, com.byazt.hh.pr prVar) {
        if (com.byazt.nn.x.pr(i)) {
            return pr(str);
        }
        if (pr(prVar)) {
            return hw(i, str, prVar);
        }
        return false;
    }
}
