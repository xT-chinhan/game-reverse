package com.byazt.udn;

import com.byazt.edb.aj;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1254, 121})
public class x implements aj {
    public long c;
    public aj hn;
    public final List<com.byazt.auw.hn> hw;
    public final Object pr;
    public InputStream uc;
    public boolean x;

    public void c() throws InterruptedException {
        synchronized (this.pr) {
            if (this.x && this.hn == null) {
                this.pr.wait();
            }
        }
    }

    @Override // com.byazt.edb.aj
    public InputStream pr() throws IOException {
        InputStream inputStream = this.uc;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    @Override // com.byazt.edb.aj
    public void x() {
        aj ajVar = this.hn;
        if (ajVar != null) {
            ajVar.x();
        }
    }

    @Override // com.byazt.edb.fw
    public String pr(String str) {
        aj ajVar = this.hn;
        if (ajVar != null) {
            return ajVar.pr(str);
        }
        return null;
    }

    @Override // com.byazt.edb.fw
    public int hw() throws IOException {
        aj ajVar = this.hn;
        if (ajVar != null) {
            return ajVar.hw();
        }
        return 0;
    }

    public List<com.byazt.auw.hn> uc() {
        return this.hw;
    }

    @Override // com.byazt.edb.fw
    public void hn() {
        aj ajVar = this.hn;
        if (ajVar != null) {
            ajVar.hn();
        }
    }

    public boolean fw() {
        try {
            aj ajVar = this.hn;
            return ajVar != null && pr(ajVar.hw());
        } catch (IOException e) {
            return false;
        }
    }

    public boolean pr(int i) {
        return i >= 200 && i < 300;
    }

    public boolean zo() {
        return System.currentTimeMillis() - this.c < hw.pr;
    }
}
