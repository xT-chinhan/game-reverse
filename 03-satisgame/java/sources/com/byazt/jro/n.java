package com.byazt.jro;

import android.text.TextUtils;
import com.byazt.qp.q;
import com.byazt.vf.wo;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2130, 19})
public final class n implements com.byazt.yl.qg {
    public final File n;
    public final com.byazt.db.n qg;

    public n(File file, long j) {
        this.n = file;
        this.qg = new com.byazt.xwa.qg(file, j, w());
    }

    @Override // com.byazt.yl.qg
    public File n() {
        return this.n;
    }

    @Override // com.byazt.yl.qg
    public boolean n(String str, byte[] bArr) {
        return (TextUtils.isEmpty(str) || bArr == null || !this.qg.n(str, bArr)) ? false : true;
    }

    @Override // com.byazt.yl.qg
    public boolean n(String str, String str2) {
        return n(str, str2 != null ? str2.getBytes(StandardCharsets.UTF_8) : null);
    }

    @Override // com.byazt.yl.qg
    public byte[] n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.qg.n(str);
    }

    @Override // com.byazt.yl.qg
    public String qg(String str) {
        byte[] bArrN = n(str);
        if (bArrN == null) {
            return null;
        }
        return new String(bArrN, StandardCharsets.UTF_8);
    }

    @Override // com.byazt.yl.qg
    public InputStream s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.qg.qg(str);
    }

    @Override // com.byazt.yl.qg
    public boolean q(String str) {
        return !TextUtils.isEmpty(str) && this.qg.q(str);
    }

    @Override // com.byazt.yl.qg
    public boolean l(String str) {
        return !TextUtils.isEmpty(str) && this.qg.s(str);
    }

    @Override // com.byazt.yl.qg
    public void qg() {
        this.qg.n();
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v3 double) = (r0v0 double), (r0v1 double) binds: [B:3:0x0004, B:6:0x000c] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.byazt.yl.qg
    public void n(double d) {
        double d2 = 0.0d;
        if (d < 0.0d) {
            d = d2;
        } else {
            d2 = 1.0d;
            if (d > 1.0d) {
                d = d2;
            }
        }
        this.qg.n(d);
    }

    @Override // com.byazt.yl.qg
    public int s() {
        return this.qg.qg();
    }

    @Override // com.byazt.yl.qg
    public long q() {
        return this.qg.s();
    }

    public boolean l() {
        this.qg.n();
        return true;
    }

    private ExecutorService w() {
        return ((wo) q.n("thread_service")).qg();
    }
}
