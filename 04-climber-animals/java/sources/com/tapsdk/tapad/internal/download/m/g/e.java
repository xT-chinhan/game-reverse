package com.tapsdk.tapad.internal.download.m.g;

import com.tapsdk.tapad.internal.download.core.breakpoint.i;
import com.tapsdk.tapad.internal.download.f;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private final c a = new c();

    public c a() {
        return this.a;
    }

    public d a(f fVar, com.tapsdk.tapad.internal.download.core.breakpoint.c cVar, i iVar) {
        return new d(fVar, cVar, iVar);
    }

    public void a(f fVar) throws IOException {
        File fileH = fVar.h();
        if (fileH != null && fileH.exists() && !fileH.delete()) {
            throw new IOException("Delete file failed!");
        }
    }

    public void a(d dVar, f fVar) {
    }

    public boolean b(f fVar) {
        if (!com.tapsdk.tapad.internal.download.i.j().h().a()) {
            return false;
        }
        if (fVar.t() != null) {
            return fVar.t().booleanValue();
        }
        return true;
    }
}
