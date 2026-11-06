package com.tapsdk.tapad.internal.download.m.h;

import com.tapsdk.tapad.internal.download.m.e.f;
import com.tapsdk.tapad.internal.download.m.f.g;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class d implements c.a, c.b {
    @Override // com.tapsdk.tapad.internal.download.m.h.c.b
    public long a(f fVar) throws IOException {
        try {
            return fVar.o();
        } catch (IOException e) {
            fVar.d().a(e);
            throw e;
        }
    }

    @Override // com.tapsdk.tapad.internal.download.m.h.c.a
    public com.tapsdk.tapad.internal.download.core.connection.a.InterfaceC0605a b(f fVar) throws IOException {
        com.tapsdk.tapad.internal.download.m.e.d dVarD = fVar.d();
        while (true) {
            try {
                if (dVarD.f()) {
                    throw com.tapsdk.tapad.internal.download.m.f.c.a;
                }
                return fVar.n();
            } catch (IOException e) {
                if (!(e instanceof g)) {
                    fVar.d().a(e);
                    fVar.i().a(fVar.c());
                    throw e;
                }
                fVar.r();
            }
        }
    }
}
