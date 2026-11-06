package com.anythink.core.common.m.b.a.a;

import com.anythink.core.common.m.c.h;
import com.anythink.core.common.m.c.v;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class e extends h {
    private boolean a;

    protected void b() {
    }

    e(v vVar) {
        super(vVar);
    }

    @Override // com.anythink.core.common.m.c.h, com.anythink.core.common.m.c.v
    public final void a(com.anythink.core.common.m.c.c cVar, long j) throws EOFException {
        if (this.a) {
            cVar.i(j);
            return;
        }
        try {
            super.a(cVar, j);
        } catch (IOException unused) {
            this.a = true;
            b();
        }
    }

    @Override // com.anythink.core.common.m.c.h, com.anythink.core.common.m.c.v, java.io.Flushable
    public void flush() {
        if (this.a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException unused) {
            this.a = true;
            b();
        }
    }

    @Override // com.anythink.core.common.m.c.h, com.anythink.core.common.m.c.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.a) {
            return;
        }
        try {
            super.close();
        } catch (IOException unused) {
            this.a = true;
            b();
        }
    }
}
