package com.byazt.ev;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 18})
public class l extends tj {
    public long n;

    public l(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.byazt.ev.tj, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = super.skip(j);
        this.n += jSkip;
        return jSkip;
    }

    @Override // com.byazt.ev.tj
    public synchronized void n(int i) {
        if (i != -1) {
            this.n += (long) i;
        }
    }

    public int n() {
        long jQg = qg();
        if (jQg <= 2147483647L) {
            return (int) jQg;
        }
        throw new ArithmeticException("The byte count " + jQg + " is too large to be converted to an int");
    }

    public synchronized long qg() {
        return this.n;
    }
}
