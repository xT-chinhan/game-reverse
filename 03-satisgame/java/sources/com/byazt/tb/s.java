package com.byazt.tb;

import com.byazt.si.a;
import com.byazt.si.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 573, 8})
public class s implements w {
    public String n;
    public a q;
    public boolean qg;
    public boolean s;

    public s(String str, boolean z, boolean z2, a aVar) {
        this.n = str;
        this.qg = z;
        this.s = z2;
        this.q = aVar;
    }

    @Override // com.byazt.si.w
    public String n() {
        return this.n;
    }

    @Override // com.byazt.si.w
    public boolean qg() {
        return this.qg;
    }

    @Override // com.byazt.si.w
    public boolean s() {
        return this.s;
    }

    @Override // com.byazt.si.w
    public a q() {
        return this.q;
    }
}
