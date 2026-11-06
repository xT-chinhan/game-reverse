package com.byazt.ien;

import com.byazt.tbt.cy;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1989, 13})
public class w extends n {
    public cy s;

    public w(cy cyVar, l lVar) {
        com.byazt.tbt.w wVarFs;
        this.s = cyVar;
        this.n = new ArrayList();
        if (cyVar != null && (wVarFs = cyVar.fs()) != null) {
            for (int i = 0; i < wVarFs.n(); i++) {
                this.n.add(new com.byazt.nd.w.qg(wVarFs.n(i), wVarFs.qg(i)));
            }
        }
        this.qg = lVar;
    }

    @Override // com.byazt.ien.n
    public int n() {
        return this.s.q();
    }

    @Override // com.byazt.ien.n
    public boolean qg() {
        return this.s.q() >= 200 && this.s.q() < 300;
    }

    @Override // com.byazt.ien.n
    public String n(String str, String str2) {
        return n(str) != null ? n(str).qg : str2;
    }

    @Override // com.byazt.ien.n
    public List<com.byazt.nd.w.qg> s() {
        return this.n;
    }

    @Override // com.byazt.ien.n
    public InputStream q() {
        return this.s.x().s();
    }
}
