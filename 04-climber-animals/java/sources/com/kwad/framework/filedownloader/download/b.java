package com.kwad.framework.filedownloader.download;

import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private com.kwad.framework.filedownloader.services.c ank;
    private com.kwad.framework.filedownloader.f.c.a anl;
    private com.kwad.framework.filedownloader.f.c.b anm;
    private com.kwad.framework.filedownloader.f.c.e ann;
    private volatile com.kwad.framework.filedownloader.b.a ano;
    private com.kwad.framework.filedownloader.f.c.d anp;

    static final class a {
        private static final b anq = new b();
    }

    public static b yc() {
        return a.anq;
    }

    public final void a(com.kwad.framework.filedownloader.services.c.b bVar) {
        synchronized (this) {
            this.ank = new com.kwad.framework.filedownloader.services.c(bVar);
            this.anm = null;
            this.ann = null;
            this.ano = null;
            this.anp = null;
        }
    }

    public final void b(com.kwad.framework.filedownloader.services.c.b bVar) {
        synchronized (this) {
            this.ank = new com.kwad.framework.filedownloader.services.c(bVar);
        }
    }

    public final com.kwad.framework.filedownloader.a.b br(String str) {
        try {
            return yi().bo(str);
        } catch (Throwable unused) {
            com.kwad.framework.filedownloader.a.c.b bVar = new com.kwad.framework.filedownloader.a.c.b();
            this.anm = bVar;
            return bVar.bo(str);
        }
    }

    public final com.kwad.framework.filedownloader.e.a b(File file) {
        return yj().c(file);
    }

    public final com.kwad.framework.filedownloader.f.c.d yd() {
        com.kwad.framework.filedownloader.f.c.d dVar = this.anp;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.anp == null) {
                this.anp = yk().zj();
            }
        }
        return this.anp;
    }

    public final synchronized com.kwad.framework.filedownloader.b.a ye() {
        if (this.ano != null) {
            return this.ano;
        }
        this.ano = yk().zf();
        a(this.ano.xT());
        return this.ano;
    }

    public final int yf() {
        return yk().yf();
    }

    public final boolean yg() {
        yj();
        return true;
    }

    public final int a(int i, String str, String str2, long j) {
        return yh().V(j);
    }

    private com.kwad.framework.filedownloader.f.c.a yh() {
        com.kwad.framework.filedownloader.f.c.a aVar = this.anl;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.anl == null) {
                this.anl = yk().zi();
            }
        }
        return this.anl;
    }

    private com.kwad.framework.filedownloader.f.c.b yi() {
        com.kwad.framework.filedownloader.f.c.b bVar = this.anm;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.anm == null) {
                this.anm = yk().zh();
            }
        }
        return this.anm;
    }

    private com.kwad.framework.filedownloader.f.c.e yj() {
        com.kwad.framework.filedownloader.f.c.e eVar = this.ann;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.ann == null) {
                this.ann = yk().zg();
            }
        }
        return this.ann;
    }

    private com.kwad.framework.filedownloader.services.c yk() {
        com.kwad.framework.filedownloader.services.c cVar = this.ank;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.ank == null) {
                this.ank = new com.kwad.framework.filedownloader.services.c();
            }
        }
        return this.ank;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x01a2  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    private static void a(com.kwad.framework.filedownloader.b.a.InterfaceC0464a interfaceC0464a) throws Throwable {
        boolean z;
        String str = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d";
        Iterator<com.kwad.framework.filedownloader.d.c> it = interfaceC0464a.iterator();
        com.kwad.framework.filedownloader.f.c.d dVarYd = yc().yd();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        while (it.hasNext()) {
            try {
                com.kwad.framework.filedownloader.d.c next = it.next();
                if (next.wJ() == 3 || next.wJ() == 2 || next.wJ() == -1 || (next.wJ() == 1 && next.yZ() > 0)) {
                    next.d((byte) -2);
                }
                String targetFilePath = next.getTargetFilePath();
                if (targetFilePath == null) {
                    str = str;
                    jCurrentTimeMillis = jCurrentTimeMillis;
                    j = j;
                    z = true;
                } else {
                    File file = new File(targetFilePath);
                    if (next.wJ() == -2) {
                        str = str;
                        try {
                            if (com.kwad.framework.filedownloader.f.f.a(next.getId(), next, next.getPath(), null)) {
                                File file2 = new File(next.yr());
                                if (!file2.exists() && file.exists()) {
                                    boolean zRenameTo = file.renameTo(file2);
                                    if (com.kwad.framework.filedownloader.f.d.apD) {
                                        com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "resume from the old no-temp-file architecture [%B], [%s]->[%s]", Boolean.valueOf(zRenameTo), file.getPath(), file2.getPath());
                                    }
                                }
                            }
                            if (next.wJ() == 1 || next.yZ() > 0) {
                                z = com.kwad.framework.filedownloader.f.f.b(next.getId(), next) || file.exists();
                            }
                        } catch (Throwable th) {
                            th = th;
                            jCurrentTimeMillis = jCurrentTimeMillis;
                            j = j;
                            str = str;
                            com.kwad.framework.filedownloader.f.f.aK(com.kwad.framework.filedownloader.f.c.zz());
                            interfaceC0464a.xU();
                            if (com.kwad.framework.filedownloader.f.d.apD) {
                                com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                            }
                            throw th;
                        }
                    } else {
                        str = str;
                    }
                    if (next.wJ() == 1) {
                    }
                    if (com.kwad.framework.filedownloader.f.f.b(next.getId(), next)) {
                    }
                }
                if (z) {
                    try {
                        it.remove();
                        j2++;
                        j = j;
                    } catch (Throwable th2) {
                        th = th2;
                        str = str;
                        com.kwad.framework.filedownloader.f.f.aK(com.kwad.framework.filedownloader.f.c.zz());
                        interfaceC0464a.xU();
                        if (com.kwad.framework.filedownloader.f.d.apD) {
                            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                        }
                        throw th;
                    }
                } else {
                    int id = next.getId();
                    int iF = dVarYd.f(next.getUrl(), next.getPath(), next.wF());
                    if (iF != id) {
                        if (com.kwad.framework.filedownloader.f.d.apD) {
                            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, "the id is changed on restoring from db: old[%d] -> new[%d]", Integer.valueOf(id), Integer.valueOf(iF));
                        }
                        next.setId(iF);
                        interfaceC0464a.a(id, next);
                        j3++;
                    }
                    interfaceC0464a.c(next);
                    j++;
                }
            } catch (Throwable th3) {
                th = th3;
                jCurrentTimeMillis = jCurrentTimeMillis;
                j = j;
            }
        }
        String str2 = str;
        long j4 = jCurrentTimeMillis;
        long j5 = j;
        com.kwad.framework.filedownloader.f.f.aK(com.kwad.framework.filedownloader.f.c.zz());
        interfaceC0464a.xU();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(com.kwad.framework.filedownloader.b.a.class, str2, Long.valueOf(j5), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(System.currentTimeMillis() - j4));
        }
    }
}
