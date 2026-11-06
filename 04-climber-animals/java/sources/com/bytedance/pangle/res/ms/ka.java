package com.bytedance.pangle.res.ms;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f677ms;

    public ka(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.ms.ch, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        long jSkip;
        jSkip = super.skip(j);
        this.f677ms += jSkip;
        return jSkip;
    }

    @Override // com.bytedance.pangle.res.ms.ch
    protected synchronized void ms(int i) {
        if (i != -1) {
            this.f677ms += (long) i;
        }
    }

    public int ms() {
        long jXr = xr();
        if (jXr <= 2147483647L) {
            return (int) jXr;
        }
        throw new ArithmeticException("The byte count " + jXr + " is too large to be converted to an int");
    }

    public synchronized long xr() {
        return this.f677ms;
    }
}
