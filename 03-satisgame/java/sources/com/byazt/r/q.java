package com.byazt.r;

import com.byazt.m.rv;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 889, 5})
public class q implements rv {
    public long l;
    public final Object n;
    public boolean q;
    public final List<com.byazt.wm.s> qg;
    public rv s;
    public InputStream w;

    public boolean n(int i) {
        return i >= 200 && i < 300;
    }

    public void l() throws InterruptedException {
        synchronized (this.n) {
            if (this.q && this.s == null) {
                this.n.wait();
            }
        }
    }

    @Override // com.byazt.m.rv
    public InputStream n() throws IOException {
        InputStream inputStream = this.w;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.byazt.m.rv
    public void q() {
        rv rvVar = this.s;
        if (rvVar != null) {
            rvVar.q();
        }
    }

    @Override // com.byazt.m.x
    public String n(String str) {
        rv rvVar = this.s;
        if (rvVar != null) {
            return rvVar.n(str);
        }
        return null;
    }

    @Override // com.byazt.m.x
    public int qg() throws IOException {
        rv rvVar = this.s;
        if (rvVar != null) {
            return rvVar.qg();
        }
        return 0;
    }

    public List<com.byazt.wm.s> w() {
        return this.qg;
    }

    @Override // com.byazt.m.x
    public void s() {
        rv rvVar = this.s;
        if (rvVar != null) {
            rvVar.s();
        }
    }

    public boolean x() {
        try {
            rv rvVar = this.s;
            return rvVar != null && n(rvVar.qg());
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean fs() {
        return System.currentTimeMillis() - this.l < qg.n;
    }
}
