package com.byazt.ym;

import com.byazt.wa.cd;
import com.byazt.wa.x;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1223, 18})
public class l extends x {
    public boolean n;

    public void n(IOException iOException) {
    }

    public l(cd cdVar) {
        super(cdVar);
    }

    @Override // com.byazt.wa.x, com.byazt.wa.cd
    public void a_(com.byazt.wa.s sVar, long j) throws IOException {
        if (this.n) {
            sVar.fs(j);
            return;
        }
        try {
            super.a_(sVar, j);
        } catch (IOException e) {
            this.n = true;
            n(e);
        }
    }

    @Override // com.byazt.wa.x, com.byazt.wa.cd, java.io.Flushable
    public void flush() throws IOException {
        if (this.n) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.n = true;
            n(e);
        }
    }

    @Override // com.byazt.wa.x, com.byazt.wa.cd, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.n) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.n = true;
            n(e);
        }
    }
}
