package com.kwad.framework.filedownloader.download;

import android.os.Process;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import java.io.IOException;
import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    private final String aca;
    private final int amZ;
    private final ConnectTask anV;
    private final f anW;
    private e anX;
    final int anY;
    private final boolean anw;
    private volatile boolean nf;

    /* synthetic */ c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str, byte b) {
        this(i, i2, connectTask, fVar, z, str);
    }

    private c(int i, int i2, ConnectTask connectTask, f fVar, boolean z, String str) {
        this.amZ = i;
        this.anY = i2;
        this.nf = false;
        this.anW = fVar;
        this.aca = str;
        this.anV = connectTask;
        this.anw = z;
    }

    public final void pause() {
        this.nf = true;
        e eVar = this.anX;
        if (eVar != null) {
            eVar.pause();
        }
    }

    public final void xy() {
        pause();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Exception e;
        Process.setThreadPriority(10);
        long j = this.anV.ya().ani;
        com.kwad.framework.filedownloader.a.b bVarXX = null;
        boolean z2 = false;
        while (true) {
            try {
                if (this.nf) {
                    if (bVarXX != null) {
                        bVarXX.xS();
                        return;
                    }
                    return;
                }
                try {
                    bVarXX = this.anV.xX();
                    int responseCode = bVarXX.getResponseCode();
                    if (com.kwad.framework.filedownloader.f.d.apD) {
                        com.kwad.framework.filedownloader.f.d.c(this, "the connection[%d] for %d, is connected %s with requestHttpCode[%d]", Integer.valueOf(this.anY), Integer.valueOf(this.amZ), this.anV.ya(), Integer.valueOf(responseCode));
                    }
                    if (responseCode != 206 && responseCode != 200) {
                        throw new SocketException(com.kwad.framework.filedownloader.f.f.c("Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again.", this.anV.getRequestHeader(), bVarXX.xR(), Integer.valueOf(responseCode), Integer.valueOf(this.amZ), Integer.valueOf(this.anY)));
                    }
                    try {
                        e.a aVar = new e.a();
                        if (!this.nf) {
                            e eVarYG = aVar.bP(this.amZ).bO(this.anY).b(this.anW).a(this).bi(this.anw).d(bVarXX).c(this.anV.ya()).bv(this.aca).yG();
                            this.anX = eVarYG;
                            eVarYG.run();
                            if (!this.nf) {
                                break;
                            }
                            this.anX.pause();
                            break;
                        }
                        if (bVarXX != null) {
                            bVarXX.xS();
                            return;
                        }
                        return;
                    } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e2) {
                        e = e2;
                        z = true;
                        try {
                            if (!this.anW.a(e)) {
                                this.anW.b(e);
                                if (bVarXX != null) {
                                    bVarXX.xS();
                                    return;
                                }
                                return;
                            }
                            if (z) {
                                e eVar = this.anX;
                                if (eVar == null) {
                                    com.kwad.framework.filedownloader.f.d.d(this, "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s", e);
                                    this.anW.b(e);
                                    if (bVarXX != null) {
                                        bVarXX.xS();
                                        return;
                                    }
                                    return;
                                }
                                this.anW.a(e, eVar.ani - j);
                            } else {
                                this.anW.a(e, 0L);
                            }
                            if (bVarXX != null) {
                                bVarXX.xS();
                            }
                            z2 = z;
                        } catch (Throwable th) {
                            if (bVarXX != null) {
                                bVarXX.xS();
                            }
                            throw th;
                        }
                    }
                } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e3) {
                    e = e3;
                    z = false;
                }
            } catch (FileDownloadGiveUpRetryException | IOException | ArrayIndexOutOfBoundsException | IllegalAccessException | IllegalArgumentException e4) {
                z = z2;
                e = e4;
            }
            z2 = z;
        }
        if (bVarXX != null) {
            bVarXX.xS();
        }
    }

    public static class a {
        private String aca;
        private Boolean anT;
        private f anW;
        private final ConnectTask.a anZ = new ConnectTask.a();
        private Integer aoa;

        public final a a(f fVar) {
            this.anW = fVar;
            return this;
        }

        public final a bM(int i) {
            this.anZ.bL(i);
            return this;
        }

        public final a bs(String str) {
            this.anZ.bp(str);
            return this;
        }

        public final a bt(String str) {
            this.anZ.bq(str);
            return this;
        }

        public final a c(com.kwad.framework.filedownloader.d.b bVar) {
            this.anZ.a(bVar);
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.download.a aVar) {
            this.anZ.a(aVar);
            return this;
        }

        public final a bu(String str) {
            this.aca = str;
            return this;
        }

        public final a bg(boolean z) {
            this.anT = Boolean.valueOf(z);
            return this;
        }

        public final a i(Integer num) {
            this.aoa = num;
            return this;
        }

        public final c yt() {
            if (this.anW == null || this.aca == null || this.anT == null || this.aoa == null) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("%s %s %B", this.anW, this.aca, this.anT));
            }
            ConnectTask connectTaskYb = this.anZ.yb();
            return new c(connectTaskYb.amZ, this.aoa.intValue(), connectTaskYb, this.anW, this.anT.booleanValue(), this.aca, (byte) 0);
        }
    }
}
