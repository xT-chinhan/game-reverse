package com.kwad.framework.filedownloader.download;

import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Handler.Callback {
    private volatile Thread amO;
    private final com.kwad.framework.filedownloader.d.c ant;
    private final a aob;
    private final int aoc;
    private final int aod;
    private final int aoe;
    private long aof;
    private HandlerThread aog;
    private volatile boolean aoj;
    private Handler handler;
    private volatile boolean aoh = false;
    private volatile long anN = 0;
    private final AtomicLong aoi = new AtomicLong();
    private boolean aok = true;
    private final com.kwad.framework.filedownloader.b.a ano = b.yc().ye();

    d(com.kwad.framework.filedownloader.d.c cVar, int i, int i2, int i3) {
        this.ant = cVar;
        this.aod = i2 < 5 ? 5 : i2;
        this.aoe = i3;
        this.aob = new a();
        this.aoc = i;
    }

    public final boolean isAlive() {
        HandlerThread handlerThread = this.aog;
        return handlerThread != null && handlerThread.isAlive();
    }

    final void yu() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.aog.quit();
            this.amO = Thread.currentThread();
            while (this.aoh) {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(100L));
            }
            this.amO = null;
        }
    }

    public final void yv() {
        this.ant.d((byte) 1);
        this.ano.bH(this.ant.getId());
        c((byte) 1);
    }

    final void yw() {
        this.ant.d((byte) 6);
        c((byte) 6);
        this.ano.bC(this.ant.getId());
    }

    final void a(boolean z, long j, String str, String str2) {
        String strZa = this.ant.za();
        if (strZa != null && !strZa.equals(str)) {
            throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.c("callback onConnected must with precondition succeed, but the etag is changes(%s != %s)", str, strZa));
        }
        this.aob.bh(z);
        this.ant.d((byte) 2);
        this.ant.ab(j);
        this.ant.bx(str);
        this.ant.bz(str2);
        this.ano.a(this.ant.getId(), j, str, str2);
        c((byte) 2);
        this.aof = h(j, this.aoe);
        this.aoj = true;
    }

    final void yx() {
        HandlerThread handlerThread = new HandlerThread("source-status-callback", 10);
        this.aog = handlerThread;
        handlerThread.start();
        this.handler = new Handler(this.aog.getLooper(), this);
    }

    final void onProgress(long j) {
        this.aoi.addAndGet(j);
        this.ant.aa(j);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zW = W(jElapsedRealtime);
        Handler handler = this.handler;
        if (handler == null) {
            b(jElapsedRealtime, zW);
        } else if (zW) {
            b(handler.obtainMessage(3));
        }
    }

    final void a(Exception exc, int i, long j) {
        this.aoi.set(0L);
        this.ant.aa(-j);
        Handler handler = this.handler;
        if (handler == null) {
            a(exc, i);
        } else {
            b(handler.obtainMessage(5, i, 0, exc));
        }
    }

    final void yy() {
        yD();
    }

    final void c(Exception exc) {
        e(exc);
    }

    final void yz() {
        if (yC()) {
            return;
        }
        yB();
    }

    private synchronized void b(Message message) {
        if (!this.aog.isAlive()) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
            }
            return;
        }
        try {
            this.handler.sendMessage(message);
        } catch (IllegalStateException e) {
            if (!this.aog.isAlive()) {
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.c(this, "require callback %d but the host thread of the flow has already dead, what is occurred because of there are several reason can final this flow on different thread.", Integer.valueOf(message.what));
                    return;
                }
                return;
            }
            throw e;
        }
    }

    private static long h(long j, long j2) {
        if (j2 <= 0) {
            return -1L;
        }
        if (j == -1) {
            return 1L;
        }
        long j3 = j / (j2 + 1);
        if (j3 <= 0) {
            return 1L;
        }
        return j3;
    }

    private Exception d(Exception exc) {
        long length;
        String strYr = this.ant.yr();
        if ((!this.ant.isChunked() && !com.kwad.framework.filedownloader.f.e.zB().apJ) || !(exc instanceof IOException) || !new File(strYr).exists()) {
            return exc;
        }
        long availableBytes = h.getAvailableBytes(strYr);
        if (availableBytes > 4096) {
            return exc;
        }
        File file = new File(strYr);
        if (!file.exists()) {
            com.kwad.framework.filedownloader.f.d.a(this, exc, "Exception with: free space isn't enough, and the target file not exist.", new Object[0]);
            length = 0;
        } else {
            length = file.length();
        }
        return new FileDownloadOutOfSpaceException(availableBytes, 4096L, length, exc);
    }

    private void a(SQLiteFullException sQLiteFullException) {
        int id = this.ant.getId();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "the data of the task[%d] is dirty, because the SQLite full exception[%s], so remove it from the database directly.", Integer.valueOf(id), sQLiteFullException.toString());
        }
        this.ant.by(sQLiteFullException.toString());
        this.ant.d((byte) -1);
        this.ano.bG(id);
        this.ano.bF(id);
    }

    private void yA() {
        String strYr = this.ant.yr();
        String targetFilePath = this.ant.getTargetFilePath();
        File file = new File(strYr);
        try {
            File file2 = new File(targetFilePath);
            if (file2.exists()) {
                long length = file2.length();
                if (!file2.delete()) {
                    throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't delete the old file([%s], [%d]), so can't replace it with the new downloaded one.", targetFilePath, Long.valueOf(length)));
                }
                com.kwad.framework.filedownloader.f.d.d(this, "The target file([%s], [%d]) will be replaced with the new downloaded file[%d]", targetFilePath, Long.valueOf(length), Long.valueOf(file.length()));
            }
            if (!file.renameTo(file2)) {
                throw new IOException(com.kwad.framework.filedownloader.f.f.c("Can't rename the  temp downloaded file(%s) to the target file(%s)", strYr, targetFilePath));
            }
            if (!file.exists() || file.delete()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", strYr);
        } catch (Throwable th) {
            if (file.exists() && !file.delete()) {
                com.kwad.framework.filedownloader.f.d.d(this, "delete the temp file(%s) failed, on completed downloading.", strYr);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        this.aoh = true;
        int i = message.what;
        try {
            if (i == 3) {
                b(SystemClock.elapsedRealtime(), true);
            } else {
                if (i == 5) {
                    a((Exception) message.obj, message.arg1);
                }
                this.aoh = false;
                if (this.amO != null) {
                    LockSupport.unpark(this.amO);
                }
                return true;
            }
            this.aoh = false;
            if (this.amO != null) {
                LockSupport.unpark(this.amO);
            }
            return true;
        } catch (Throwable th) {
            this.aoh = false;
            if (this.amO != null) {
                LockSupport.unpark(this.amO);
            }
            throw th;
        }
    }

    private void b(long j, boolean z) {
        if (this.ant.yZ() == this.ant.getTotal()) {
            this.ano.b(this.ant.getId(), this.ant.yZ());
            return;
        }
        if (this.aoj) {
            this.aoj = false;
            this.ant.d((byte) 3);
        }
        if (z) {
            this.anN = j;
            c((byte) 3);
            this.aoi.set(0L);
        }
    }

    private void yB() {
        yA();
        this.ant.d((byte) -3);
        this.ano.c(this.ant.getId(), this.ant.getTotal());
        this.ano.bF(this.ant.getId());
        c((byte) -3);
        if (com.kwad.framework.filedownloader.f.e.zB().apK) {
            com.kwad.framework.filedownloader.services.f.f(this.ant);
        }
    }

    private boolean yC() {
        if (this.ant.isChunked()) {
            com.kwad.framework.filedownloader.d.c cVar = this.ant;
            cVar.ab(cVar.yZ());
        } else if (this.ant.yZ() != this.ant.getTotal()) {
            c(new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("sofar[%d] not equal total[%d]", Long.valueOf(this.ant.yZ()), Long.valueOf(this.ant.getTotal()))));
            return true;
        }
        return false;
    }

    private void a(Exception exc, int i) {
        Exception excD = d(exc);
        this.aob.f(excD);
        this.aob.bN(this.aoc - i);
        this.ant.d((byte) 5);
        this.ant.by(excD.toString());
        this.ano.a(this.ant.getId(), excD);
        c((byte) 5);
    }

    private void yD() {
        this.ant.d((byte) -2);
        this.ano.d(this.ant.getId(), this.ant.yZ());
        c((byte) -2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void e(Exception exc) {
        SQLiteFullException sQLiteFullException;
        Exception excD = d(exc);
        if (excD instanceof SQLiteFullException) {
            a((SQLiteFullException) excD);
            sQLiteFullException = excD;
        } else {
            try {
                this.ant.d((byte) -1);
                this.ant.by(exc.toString());
                this.ano.a(this.ant.getId(), excD, this.ant.yZ());
                sQLiteFullException = excD;
            } catch (SQLiteFullException e) {
                SQLiteFullException sQLiteFullException2 = e;
                a(sQLiteFullException2);
                sQLiteFullException = sQLiteFullException2;
            }
        }
        this.aob.f(sQLiteFullException);
        c((byte) -1);
    }

    private boolean W(long j) {
        if (!this.aok) {
            return this.aof != -1 && this.aoi.get() >= this.aof && j - this.anN >= ((long) this.aod);
        }
        this.aok = false;
        return true;
    }

    private void c(byte b) {
        if (b == -2) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "High concurrent cause, Already paused and we don't need to call-back to Task in here, %d", Integer.valueOf(this.ant.getId()));
                return;
            }
            return;
        }
        com.kwad.framework.filedownloader.message.e.yT().s(com.kwad.framework.filedownloader.message.f.a(b, this.ant, this.aob));
    }

    public static class a {
        private boolean aol;
        private Exception aom;
        private int aon;

        final void bh(boolean z) {
            this.aol = z;
        }

        public final boolean yE() {
            return this.aol;
        }

        final void f(Exception exc) {
            this.aom = exc;
        }

        final void bN(int i) {
            this.aon = i;
        }

        public final Exception getException() {
            return this.aom;
        }

        public final int wN() {
            return this.aon;
        }
    }
}
