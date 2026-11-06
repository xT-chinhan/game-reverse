package com.byazt.qdx;

import android.graphics.Bitmap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 844, 26})
public class qg {
    public Map<String, String> l;
    public int n;
    public List<Object> q;
    public byte[] qg;
    public Bitmap s;

    public qg(byte[] bArr, int i) {
        this.s = null;
        this.q = null;
        this.l = null;
        this.qg = bArr;
        this.n = i;
    }

    public qg(Bitmap bitmap, int i) {
        this.qg = null;
        this.q = null;
        this.l = null;
        this.s = bitmap;
        this.n = i;
    }

    public Bitmap n() {
        return this.s;
    }

    public int qg() {
        return this.n;
    }

    public byte[] s() {
        try {
            if (this.qg == null) {
                this.qg = com.byazt.tk.s.qg(this.s);
            }
        } catch (OutOfMemoryError unused) {
        }
        return this.qg;
    }

    public boolean q() {
        if (this.s != null) {
            return true;
        }
        byte[] bArr = this.qg;
        return bArr != null && bArr.length > 0;
    }

    public boolean l() {
        byte[] bArr = this.qg;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }
}
