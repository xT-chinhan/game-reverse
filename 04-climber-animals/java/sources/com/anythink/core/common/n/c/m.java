package com.anythink.core.common.n.c;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes.dex */
public final class m implements w {
    private final e a;
    private final Inflater b;
    private int c;
    private boolean d;

    private m(w wVar, Inflater inflater) {
        this(n.a(wVar), inflater);
    }

    m(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = eVar;
        this.b = inflater;
    }

    @Override // com.anythink.core.common.n.c.w
    public final long a_(c cVar, long j) throws IOException {
        boolean z;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            z = false;
            if (this.b.needsInput()) {
                c();
                if (this.b.getRemaining() != 0) {
                    throw new IllegalStateException("?");
                }
                if (this.a.g()) {
                    z = true;
                } else {
                    s sVar = this.a.c().b;
                    this.c = sVar.e - sVar.d;
                    this.b.setInput(sVar.c, sVar.d, this.c);
                }
            }
            try {
                s sVarG = cVar.g(1);
                int iInflate = this.b.inflate(sVarG.c, sVarG.e, (int) Math.min(j, 8192 - sVarG.e));
                if (iInflate > 0) {
                    sVarG.e += iInflate;
                    long j2 = iInflate;
                    cVar.c += j2;
                    return j2;
                }
                if (!this.b.finished() && !this.b.needsDictionary()) {
                }
                c();
                if (sVarG.d != sVarG.e) {
                    return -1L;
                }
                cVar.b = sVarG.c();
                t.a(sVarG);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!z);
        throw new EOFException("source exhausted prematurely");
    }

    private boolean b() {
        if (!this.b.needsInput()) {
            return false;
        }
        c();
        if (this.b.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.a.g()) {
            return true;
        }
        s sVar = this.a.c().b;
        this.c = sVar.e - sVar.d;
        this.b.setInput(sVar.c, sVar.d, this.c);
        return false;
    }

    private void c() {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.a.i(remaining);
    }

    @Override // com.anythink.core.common.n.c.w
    public final x a() {
        return this.a.a();
    }

    @Override // com.anythink.core.common.n.c.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }
}
