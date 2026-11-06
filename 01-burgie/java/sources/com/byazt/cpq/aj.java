package com.byazt.cpq;

import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.du.a;
import com.byazt.du.lb;
import com.byazt.du.qa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, 61})
public final class aj {
    public static final /* synthetic */ boolean aj = true;
    public final pr c;
    public final int hn;
    public long hw;
    public boolean k;
    public final hw m;
    public final List<com.byazt.cpq.hn> vk;
    public List<com.byazt.cpq.hn> w;
    public final fw x;
    public long pr = 0;
    public final hn uc = new hn();
    public final hn fw = new hn();
    public com.byazt.cpq.hw zo = null;

    public aj(int i, fw fwVar, boolean z, boolean z2, List<com.byazt.cpq.hn> list) {
        if (fwVar == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.hn = i;
        this.x = fwVar;
        this.hw = fwVar.m.x();
        hw hwVar = new hw(fwVar.k.x());
        this.m = hwVar;
        pr prVar = new pr();
        this.c = prVar;
        hwVar.hw = z2;
        prVar.hw = z;
        this.vk = list;
    }

    public int pr() {
        return this.hn;
    }

    public synchronized boolean hw() {
        if (this.zo != null) {
            return false;
        }
        return ((this.m.hw || this.m.pr) && (this.c.hw || this.c.pr) && this.k) ? false : true;
    }

    public boolean hn() {
        return this.x.hw == ((this.hn & 1) == 1);
    }

    public synchronized List<com.byazt.cpq.hn> x() throws IOException {
        List<com.byazt.cpq.hn> list;
        if (!hn()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.uc.pr();
        while (this.w == null && this.zo == null) {
            try {
                k();
            } catch (Throwable th) {
                this.uc.zo();
                throw th;
            }
        }
        this.uc.zo();
        list = this.w;
        if (list != null) {
            this.w = null;
        } else {
            throw new ho(this.zo);
        }
        return list;
    }

    public a c() {
        return this.uc;
    }

    public a uc() {
        return this.fw;
    }

    public qa fw() {
        return this.m;
    }

    public lb zo() {
        synchronized (this) {
            if (!this.k && !hn()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.c;
    }

    public void pr(com.byazt.cpq.hw hwVar) throws IOException {
        if (!x(hwVar)) {
            return;
        }
        this.x.hw(this.hn, hwVar);
    }

    public void hw(com.byazt.cpq.hw hwVar) {
        if (!x(hwVar)) {
            return;
        }
        this.x.pr(this.hn, hwVar);
    }

    private boolean x(com.byazt.cpq.hw hwVar) {
        if (!aj && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.zo != null) {
                return false;
            }
            if (this.m.hw && this.c.hw) {
                return false;
            }
            this.zo = hwVar;
            notifyAll();
            this.x.hw(this.hn);
            return true;
        }
    }

    public void pr(List<com.byazt.cpq.hn> list) {
        boolean zHw;
        if (!aj && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            zHw = true;
            this.k = true;
            if (this.w == null) {
                this.w = list;
                zHw = hw();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.w);
                arrayList.add(null);
                arrayList.addAll(list);
                this.w = arrayList;
            }
        }
        if (!zHw) {
            this.x.hw(this.hn);
        }
    }

    public void pr(com.byazt.du.c cVar, int i) throws IOException {
        if (!aj && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.m.pr(cVar, i);
    }

    public void aj() {
        boolean zHw;
        if (!aj && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.m.hw = true;
            zHw = hw();
            notifyAll();
        }
        if (!zHw) {
            this.x.hw(this.hn);
        }
    }

    public synchronized void hn(com.byazt.cpq.hw hwVar) {
        if (this.zo == null) {
            this.zo = hwVar;
            notifyAll();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 470})
    private final class hw implements qa {
        public static final /* synthetic */ boolean hn = true;
        public final long fw;
        public boolean hw;
        public boolean pr;
        public final com.byazt.du.hn c = new com.byazt.du.hn();
        public final com.byazt.du.hn uc = new com.byazt.du.hn();

        public hw(long j) {
            this.fw = j;
        }

        @Override // com.byazt.du.qa
        public long pr(com.byazt.du.hn hnVar, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
            }
            synchronized (aj.this) {
                hw();
                hn();
                if (this.uc.hw() == 0) {
                    return -1L;
                }
                com.byazt.du.hn hnVar2 = this.uc;
                long jPr = hnVar2.pr(hnVar, Math.min(j, hnVar2.hw()));
                aj.this.pr += jPr;
                if (aj.this.pr >= aj.this.x.k.x() / 2) {
                    aj.this.x.pr(aj.this.hn, aj.this.pr);
                    aj.this.pr = 0L;
                }
                synchronized (aj.this.x) {
                    aj.this.x.vk += jPr;
                    if (aj.this.x.vk >= aj.this.x.k.x() / 2) {
                        aj.this.x.pr(0, aj.this.x.vk);
                        aj.this.x.vk = 0L;
                    }
                }
                return jPr;
            }
        }

        private void hw() throws IOException {
            aj.this.uc.pr();
            while (this.uc.hw() == 0 && !this.hw && !this.pr && aj.this.zo == null) {
                try {
                    aj.this.k();
                } catch (Throwable th) {
                    aj.this.uc.zo();
                    throw th;
                }
            }
            aj.this.uc.zo();
        }

        public void pr(com.byazt.du.c cVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!hn && Thread.holdsLock(aj.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (aj.this) {
                    z = this.hw;
                    z2 = true;
                    z3 = this.uc.hw() + j > this.fw;
                }
                if (z3) {
                    cVar.zo(j);
                    aj.this.hw(com.byazt.cpq.hw.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    cVar.zo(j);
                    return;
                }
                long jPr = cVar.pr(this.c, j);
                if (jPr == -1) {
                    throw new EOFException();
                }
                j -= jPr;
                synchronized (aj.this) {
                    if (this.uc.hw() != 0) {
                        z2 = false;
                    }
                    this.uc.pr(this.c);
                    if (z2) {
                        aj.this.notifyAll();
                    }
                }
            }
        }

        @Override // com.byazt.du.qa
        public a pr() {
            return aj.this.uc;
        }

        @Override // com.byazt.du.qa, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (aj.this) {
                this.pr = true;
                this.uc.lb();
                aj.this.notifyAll();
            }
            aj.this.vk();
        }

        private void hn() throws IOException {
            if (this.pr) {
                throw new IOException("stream closed");
            }
            if (aj.this.zo != null) {
                throw new ho(aj.this.zo);
            }
        }
    }

    public void vk() throws IOException {
        boolean z;
        boolean zHw;
        if (!aj && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = !this.m.hw && this.m.pr && (this.c.hw || this.c.pr);
            zHw = hw();
        }
        if (z) {
            pr(com.byazt.cpq.hw.CANCEL);
        } else if (!zHw) {
            this.x.hw(this.hn);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, MediaPlayer.MEDIA_PLAYER_OPTION_GET_RES_HEADERS})
    final class pr implements lb {
        public static final /* synthetic */ boolean hn = true;
        public final com.byazt.du.hn c = new com.byazt.du.hn();
        public boolean hw;
        public boolean pr;

        public pr() {
        }

        @Override // com.byazt.du.lb
        public void a_(com.byazt.du.hn hnVar, long j) throws IOException {
            if (!hn && Thread.holdsLock(aj.this)) {
                throw new AssertionError();
            }
            this.c.a_(hnVar, j);
            while (this.c.hw() >= PlaybackStateCompat.ACTION_PREPARE) {
                pr(false);
            }
        }

        private void pr(boolean z) throws IOException {
            long jMin;
            synchronized (aj.this) {
                aj.this.fw.pr();
                while (aj.this.hw <= 0 && !this.hw && !this.pr && aj.this.zo == null) {
                    try {
                        aj.this.k();
                    } catch (Throwable th) {
                        aj.this.fw.zo();
                        throw th;
                    }
                }
                aj.this.fw.zo();
                aj.this.w();
                jMin = Math.min(aj.this.hw, this.c.hw());
                aj.this.hw -= jMin;
            }
            aj.this.fw.pr();
            try {
                aj.this.x.pr(aj.this.hn, z && jMin == this.c.hw(), this.c, jMin);
            } finally {
                aj.this.fw.zo();
            }
        }

        @Override // com.byazt.du.lb, java.io.Flushable
        public void flush() throws IOException {
            if (!hn && Thread.holdsLock(aj.this)) {
                throw new AssertionError();
            }
            synchronized (aj.this) {
                aj.this.w();
            }
            while (this.c.hw() > 0) {
                pr(false);
                aj.this.x.hw();
            }
        }

        @Override // com.byazt.du.lb
        public a pr() {
            return aj.this.fw;
        }

        @Override // com.byazt.du.lb, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!hn && Thread.holdsLock(aj.this)) {
                throw new AssertionError();
            }
            synchronized (aj.this) {
                if (this.pr) {
                    return;
                }
                if (!aj.this.c.hw) {
                    if (this.c.hw() > 0) {
                        while (this.c.hw() > 0) {
                            pr(true);
                        }
                    } else {
                        aj.this.x.pr(aj.this.hn, true, (com.byazt.du.hn) null, 0L);
                    }
                }
                synchronized (aj.this) {
                    this.pr = true;
                }
                aj.this.x.hw();
                aj.this.vk();
            }
        }
    }

    public void pr(long j) {
        this.hw += j;
        if (j > 0) {
            notifyAll();
        }
    }

    public void w() throws IOException {
        if (this.c.pr) {
            throw new IOException("stream closed");
        }
        if (this.c.hw) {
            throw new IOException("stream finished");
        }
        if (this.zo != null) {
            throw new ho(this.zo);
        }
    }

    public void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 405, 474})
    class hn extends com.byazt.du.pr {
        public hn() {
        }

        @Override // com.byazt.du.pr
        public void e_() {
            aj.this.hw(com.byazt.cpq.hw.CANCEL);
        }

        @Override // com.byazt.du.pr
        public IOException hw(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void zo() throws IOException {
            if (hw()) {
                throw hw((IOException) null);
            }
        }
    }
}
