package com.bytedance.sdk.component.xr.ms.ms.ms;

import com.bytedance.sdk.component.ah.xr.g;
import com.bytedance.sdk.component.ah.xr.nw;
import com.bytedance.sdk.component.xr.ms.h;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ch extends h {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    g f1604ms;

    ch(g gVar) {
        this.f1604ms = gVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public long ms() {
        g gVar = this.f1604ms;
        if (gVar != null) {
            return gVar.xr();
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public String xr() {
        try {
            return this.f1604ms.c();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g gVar = this.f1604ms;
        if (gVar != null) {
            gVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public InputStream ah() {
        g gVar = this.f1604ms;
        if (gVar != null) {
            return gVar.d();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public byte[] d() {
        try {
            return this.f1604ms.ka();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public com.bytedance.sdk.component.xr.ms.ch ka() {
        nw nwVarMs;
        g gVar = this.f1604ms;
        if (gVar == null || (nwVarMs = gVar.ms()) == null) {
            return null;
        }
        return new com.bytedance.sdk.component.xr.ms.ch(nwVarMs.toString(), nwVarMs.ms(), nwVarMs.xr(), nwVarMs.ah() != null ? nwVarMs.ah().name() : null);
    }
}
