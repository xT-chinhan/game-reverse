package com.anythink.basead.exoplayer.k;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class x extends BufferedOutputStream {
    private boolean a;

    public x(OutputStream outputStream) {
        super(outputStream);
    }

    public x(OutputStream outputStream, int i) {
        super(outputStream, i);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.a = true;
        flush();
        th = null;
        try {
            this.out.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        if (th != null) {
            af.a(th);
        }
    }

    public final void a(OutputStream outputStream) {
        a.b(this.a);
        this.out = outputStream;
        this.count = 0;
        this.a = false;
    }
}
