package com.byazt.bd;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 101})
public class fs {
    public final List<n<com.byazt.aw.sz, Path>> n;
    public final List<n<Integer, Integer>> qg;
    public final List<com.byazt.aw.fs> s;

    public fs(List<com.byazt.aw.fs> list) {
        this.s = list;
        this.n = new ArrayList(list.size());
        this.qg = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.n.add(list.get(i).qg().n());
            this.qg.add(list.get(i).s().n());
        }
    }

    public List<com.byazt.aw.fs> n() {
        return this.s;
    }

    public List<n<com.byazt.aw.sz, Path>> qg() {
        return this.n;
    }

    public List<n<Integer, Integer>> s() {
        return this.qg;
    }
}
