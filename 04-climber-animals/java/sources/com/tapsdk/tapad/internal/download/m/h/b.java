package com.tapsdk.tapad.internal.download.m.h;

import com.tapsdk.tapad.internal.download.f;
import com.tapsdk.tapad.internal.download.i;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class b implements c.b {
    private final InputStream a;
    private final byte[] b;
    private final com.tapsdk.tapad.internal.download.m.g.d c;
    private final int d;
    private final f e;
    private final com.tapsdk.tapad.internal.download.m.d.a f = i.j().b();

    public b(int i, InputStream inputStream, com.tapsdk.tapad.internal.download.m.g.d dVar, f fVar) {
        this.d = i;
        this.a = inputStream;
        this.b = new byte[fVar.q()];
        this.c = dVar;
        this.e = fVar;
    }

    @Override // com.tapsdk.tapad.internal.download.m.h.c.b
    public long a(com.tapsdk.tapad.internal.download.m.e.f fVar) throws IOException {
        if (fVar.d().f()) {
            throw com.tapsdk.tapad.internal.download.m.f.c.a;
        }
        i.j().f().a(fVar.k());
        int i = this.a.read(this.b);
        if (i == -1) {
            return i;
        }
        this.c.a(this.d, this.b, i);
        long j = i;
        fVar.a(j);
        if (this.f.a(this.e)) {
            fVar.b();
        }
        return j;
    }
}
