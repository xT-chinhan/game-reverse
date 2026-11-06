package com.smartdigimkt.v0;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public final Uri a;
    public final com.smartdigimkt.y0.i b;
    public final g c;
    public final com.smartdigimkt.z0.e d;
    public final com.smartdigimkt.n0.i e;
    public volatile boolean f;
    public boolean g;
    public long h;
    public com.smartdigimkt.y0.k i;
    public long j;
    public final /* synthetic */ i k;

    public f(i iVar, Uri uri, com.smartdigimkt.y0.i iVar2, g gVar, com.smartdigimkt.z0.e eVar) {
        this.k = iVar;
        uri.getClass();
        this.a = uri;
        iVar2.getClass();
        this.b = iVar2;
        gVar.getClass();
        this.c = gVar;
        this.d = eVar;
        this.e = new com.smartdigimkt.n0.i();
        this.g = true;
        this.j = -1L;
    }

    public final void a() throws Throwable {
        com.smartdigimkt.n0.c cVar;
        int iA = 0;
        while (iA == 0 && !this.f) {
            try {
                long j = this.e.a;
                com.smartdigimkt.y0.k kVar = new com.smartdigimkt.y0.k(this.a, j, this.k.g);
                this.i = kVar;
                long jA = this.b.a(kVar);
                this.j = jA;
                if (jA != -1) {
                    this.j = jA + j;
                }
                com.smartdigimkt.y0.i iVar = this.b;
                cVar = new com.smartdigimkt.n0.c(iVar, j, this.j);
                try {
                    g gVar = this.c;
                    iVar.a();
                    com.smartdigimkt.n0.e eVarA = gVar.a(cVar);
                    if (this.g) {
                        eVarA.a(j, this.h);
                        this.g = false;
                    }
                    while (iA == 0 && !this.f) {
                        com.smartdigimkt.z0.e eVar = this.d;
                        synchronized (eVar) {
                            while (!eVar.a) {
                                try {
                                    eVar.wait();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        iA = eVarA.a(cVar, this.e);
                        long j2 = cVar.d;
                        if (j2 > this.k.h + j) {
                            this.d.a();
                            i iVar2 = this.k;
                            iVar2.n.post(iVar2.m);
                            j = j2;
                        }
                    }
                    if (iA == 1) {
                        iA = 0;
                    } else {
                        this.e.a = cVar.d;
                        long j3 = this.i.b;
                    }
                    com.smartdigimkt.y0.i iVar3 = this.b;
                    int i = com.smartdigimkt.z0.u.a;
                    if (iVar3 != null) {
                        try {
                            iVar3.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (iA != 1 && cVar != null) {
                        this.e.a = cVar.d;
                        long j4 = this.i.b;
                    }
                    com.smartdigimkt.y0.i iVar4 = this.b;
                    int i2 = com.smartdigimkt.z0.u.a;
                    if (iVar4 != null) {
                        try {
                            iVar4.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cVar = null;
            }
        }
    }
}
