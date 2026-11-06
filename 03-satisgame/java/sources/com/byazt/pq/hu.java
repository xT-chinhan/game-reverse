package com.byazt.pq;

import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 793})
public final class hu implements l {
    public cy l;
    public final wm n;
    public final boolean q;
    public final com.byazt.cri.tj qg;
    public final h s;
    public boolean w;
    public volatile String x;

    private hu(wm wmVar, h hVar, boolean z) {
        this.n = wmVar;
        this.s = hVar;
        this.q = z;
        this.qg = new com.byazt.cri.tj(wmVar, z);
    }

    public static hu n(wm wmVar, h hVar, boolean z) {
        hu huVar = new hu(wmVar, hVar, z);
        huVar.l = new qg(huVar, wmVar.m().n(huVar));
        return huVar;
    }

    public void n(String str) {
        this.x = str;
    }

    @Override // com.byazt.pq.l
    public h n() {
        return this.s;
    }

    @Override // com.byazt.pq.l
    public bb qg() throws IOException {
        synchronized (this) {
            if (this.w) {
                throw new IllegalStateException("Already Executed");
            }
            this.w = true;
        }
        tj();
        try {
            try {
                if (this.s.x != null) {
                    this.s.x.n();
                }
                this.n.um().n(this);
                bb bbVarRv = rv();
                if (bbVarRv == null) {
                    throw new IOException("Canceled");
                }
                if (bbVarRv.s == 0) {
                    throw new IOException(bbVarRv.q);
                }
                bbVarRv.n(this.x);
                this.n.um().qg(this);
                return bbVarRv;
            } catch (IOException e) {
                this.l.n(this, e);
                this.n.um().qg(this);
                return null;
            } catch (Exception e2) {
                this.l.n(this, new IOException(e2));
                this.n.um().qg(this);
                return null;
            }
        } catch (Throwable th) {
            this.n.um().qg(this);
            throw th;
        }
    }

    private void tj() {
        this.qg.n(com.byazt.quz.l.qg().n("response.body().close()"));
    }

    @Override // com.byazt.pq.l
    public void n(w wVar) {
        boolean z;
        Throwable th;
        try {
            synchronized (this) {
                if (this.w) {
                    throw new IllegalStateException("Already Executed");
                }
                z = true;
                this.w = true;
            }
            tj();
            try {
                this.n.um().n(new n(wVar));
            } catch (Throwable th2) {
                th = th2;
                IOException iOException = new IOException(th.getMessage(), th);
                if (z) {
                    this.l.n(this, iOException);
                }
                if (wVar != null) {
                    wVar.n(this, iOException);
                }
            }
        } catch (Throwable th3) {
            z = false;
            th = th3;
        }
    }

    @Override // com.byazt.pq.l
    public void s() {
        this.qg.n();
    }

    @Override // com.byazt.pq.l
    public boolean q() {
        return this.qg.qg();
    }

    @Override // com.byazt.pq.l
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public hu l() {
        return n(this.n, this.s, this.q);
    }

    @com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES})
    final class n extends com.byazt.zho.qg {
        public final w s;

        public n(w wVar) {
            super("OkHttp %s", hu.this.fs());
            this.s = wVar;
        }

        public String n() {
            return hu.this.s.n().w();
        }

        public h qg() {
            return hu.this.s;
        }

        public hu s() {
            return hu.this;
        }

        public void q() {
            if (hu.this.s == null || hu.this.s.x == null) {
                return;
            }
            hu.this.s.x.cp();
        }

        public void l() {
            IOException iOException = new IOException("ready queue max count exceeded");
            try {
                hu.this.l.n(hu.this, iOException);
            } catch (Throwable unused) {
            }
            w wVar = this.s;
            if (wVar != null) {
                try {
                    wVar.n(hu.this, iOException);
                } catch (Throwable unused2) {
                }
            }
        }

        @Override // com.byazt.zho.qg
        public void w() {
            boolean z = false;
            try {
                try {
                    try {
                        if (hu.this.s != null && hu.this.s.x != null) {
                            hu.this.s.x.n();
                        }
                        bb bbVarRv = hu.this.rv();
                        try {
                            if (hu.this.qg.qg()) {
                                this.s.n(hu.this, new IOException("Canceled"));
                            } else {
                                if (bbVarRv != null) {
                                    bbVarRv.n(hu.this.x);
                                }
                                this.s.n(hu.this, bbVarRv);
                            }
                            if (bbVarRv.s == 0) {
                                throw new IOException(bbVarRv.q);
                            }
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (!z) {
                                hu.this.l.n(hu.this, e);
                                this.s.n(hu.this, e);
                            } else {
                                com.byazt.quz.l.qg().n(4, "Callback failure for " + hu.this.x(), e);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    hu.this.l.n(hu.this, new IOException(e3));
                    this.s.n(hu.this, new IOException(e3));
                }
                hu.this.n.um().qg(this);
            } catch (Throwable th) {
                hu.this.n.um().qg(this);
                throw th;
            }
        }
    }

    public String x() {
        return (q() ? "canceled " : "") + (this.q ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + fs();
    }

    public String fs() {
        return this.s.n().d();
    }

    public bb rv() throws IOException {
        ArrayList arrayList = new ArrayList(this.n.ou());
        arrayList.add(this.qg);
        arrayList.add(new com.byazt.cri.n(this.n.w()));
        arrayList.add(new com.byazt.ym.n(this.n.x()));
        arrayList.add(new com.byazt.sqs.n(this.n));
        if (!this.q) {
            arrayList.addAll(this.n.wm());
        }
        arrayList.add(new com.byazt.cri.qg(this.q));
        return new com.byazt.cri.x(arrayList, null, null, null, 0, this.s, this, this.l, this.n.n(), this.n.qg(), this.n.s()).n(this.s);
    }

    @com.byazt.cp.n(n = {0, 1, 109, 1897})
    private static final class qg extends cy {
        public final hu qg;
        public final cy s;

        public qg(hu huVar, cy cyVar) {
            this.qg = huVar;
            this.s = cyVar == null ? cy.n : cyVar;
        }

        private void n(InetSocketAddress inetSocketAddress) {
            InetAddress address;
            String hostAddress;
            if (inetSocketAddress == null || this.qg == null || (address = inetSocketAddress.getAddress()) == null || (hostAddress = address.getHostAddress()) == null || hostAddress.length() <= 0) {
                return;
            }
            this.qg.n(hostAddress);
        }

        @Override // com.byazt.pq.cy
        public void n(l lVar, InetSocketAddress inetSocketAddress, Proxy proxy, m mVar) {
            n(inetSocketAddress);
            this.s.n(lVar, inetSocketAddress, proxy, mVar);
        }

        @Override // com.byazt.pq.cy
        public void n(l lVar, InetSocketAddress inetSocketAddress, Proxy proxy, m mVar, IOException iOException) {
            n(inetSocketAddress);
            this.s.n(lVar, inetSocketAddress, proxy, mVar, iOException);
        }

        @Override // com.byazt.pq.cy
        public void n(l lVar, rv rvVar) {
            if (rvVar != null && rvVar.n() != null) {
                n(rvVar.n().s());
            }
            this.s.n(lVar, rvVar);
        }

        @Override // com.byazt.pq.cy
        public void n(l lVar, IOException iOException) {
            this.s.n(lVar, iOException);
        }
    }
}
