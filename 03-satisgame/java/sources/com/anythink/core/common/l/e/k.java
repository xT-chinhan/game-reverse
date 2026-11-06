package com.anythink.core.common.l.e;

import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static k b = null;
    private static final Object c = new Object();
    private static final int g = 3;
    private static final int h = 3;
    private final String a = getClass().getSimpleName();
    private volatile com.anythink.core.common.l.e.a.e d;
    private volatile com.anythink.core.common.l.e.a.e e;
    private volatile com.anythink.core.common.l.e.a.e f;
    private volatile com.anythink.core.common.l.e.a.f[] i;
    private volatile com.anythink.core.common.l.e.a.b[] j;

    private k() {
    }

    protected static k a() {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k();
                }
            }
        }
        return b;
    }

    public final void a(i iVar, i.a aVar) {
        com.anythink.core.common.l.e.a.e eVar;
        int iA = iVar.a();
        if (iA == 12 || iA == 12) {
            a(b(), iVar, aVar);
            return;
        }
        if (iA == 13) {
            a(c(), iVar, aVar);
            return;
        }
        synchronized (c) {
            try {
                if (iA == 9) {
                    if (this.f == null) {
                        this.f = new com.anythink.core.common.l.e.a.d();
                    }
                    eVar = this.f;
                } else if (iA == 6) {
                    if (this.e == null) {
                        this.e = new com.anythink.core.common.l.e.a.c();
                    }
                    eVar = this.e;
                } else {
                    if (this.d == null) {
                        this.d = new com.anythink.core.common.l.e.a.a();
                    }
                    eVar = this.d;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (eVar != null) {
            eVar.c(iVar, aVar);
        } else if (aVar != null) {
            aVar.a((Throwable) new Exception("socketUploadData is null."));
        }
    }

    private com.anythink.core.common.l.e.a.f[] b() {
        if (this.i == null) {
            synchronized (c) {
                if (this.i == null) {
                    com.anythink.core.common.l.e.a.f[] fVarArr = new com.anythink.core.common.l.e.a.f[3];
                    for (int i = 0; i < 3; i++) {
                        fVarArr[i] = new com.anythink.core.common.l.e.a.f();
                    }
                    this.i = fVarArr;
                }
            }
        }
        return this.i;
    }

    private com.anythink.core.common.l.e.a.b[] c() {
        if (this.j == null) {
            synchronized (c) {
                if (this.j == null) {
                    com.anythink.core.common.l.e.a.b[] bVarArr = new com.anythink.core.common.l.e.a.b[3];
                    for (int i = 0; i < 3; i++) {
                        bVarArr[i] = new com.anythink.core.common.l.e.a.b();
                    }
                    this.j = bVarArr;
                }
            }
        }
        return this.j;
    }

    private static void a(com.anythink.core.common.l.e.a.e[] eVarArr, i iVar, i.a aVar) {
        for (com.anythink.core.common.l.e.a.e eVar : eVarArr) {
            if (eVar != null && eVar.f()) {
                eVar.c(iVar, aVar);
                return;
            }
        }
        if (aVar != null) {
            aVar.a((Throwable) new RejectedExecutionException("all TCP connections busy, fallback to HTTP"));
        }
    }
}
