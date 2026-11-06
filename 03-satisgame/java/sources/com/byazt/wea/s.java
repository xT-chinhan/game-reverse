package com.byazt.wea;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 571, 8})
public class s extends n {
    public List<String> cp;
    public boolean fs;
    public boolean rv;
    public com.byazt.di.n tj;
    public com.byazt.zq.qg x;

    public s(String str, String str2) {
        super(str, str2);
        this.cp = new CopyOnWriteArrayList();
    }

    public int q() {
        if (this.cp.isEmpty()) {
            return 1;
        }
        return this.cp.size();
    }
}
