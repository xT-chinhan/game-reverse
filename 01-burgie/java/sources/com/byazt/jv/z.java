package com.byazt.jv;

import android.support.v4.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 110})
public final class z implements c {
    public nt c;
    public volatile String fw;
    public final b hn;
    public final com.byazt.osx.vk hw;
    public final fo pr;
    public boolean uc;
    public final boolean x;

    private z(fo foVar, b bVar, boolean z) {
        this.pr = foVar;
        this.hn = bVar;
        this.x = z;
        this.hw = new com.byazt.osx.vk(foVar, z);
    }

    public static z pr(fo foVar, b bVar, boolean z) {
        z zVar = new z(foVar, bVar, z);
        zVar.c = new hw(zVar, foVar.rc().pr(zVar));
        return zVar;
    }

    public void pr(String str) {
        this.fw = str;
    }

    @Override // com.byazt.jv.c
    public b pr() {
        return this.hn;
    }

    @Override // com.byazt.jv.c
    public gz hw() throws IOException {
        synchronized (this) {
            if (this.uc) {
                throw new IllegalStateException("Already Executed");
            }
            this.uc = true;
        }
        vk();
        try {
            try {
                if (this.hn.uc != null) {
                    this.hn.uc.pr();
                }
                this.pr.qa().pr(this);
                gz gzVarAj = aj();
                if (gzVarAj == null) {
                    throw new IOException("Canceled");
                }
                if (gzVarAj.hn == 0) {
                    throw new IOException(gzVarAj.x);
                }
                gzVarAj.pr(this.fw);
                this.pr.qa().hw(this);
                return gzVarAj;
            } catch (IOException e) {
                this.c.pr(this, e);
                this.pr.qa().hw(this);
                return null;
            } catch (Exception e2) {
                this.c.pr(this, new IOException(e2));
                this.pr.qa().hw(this);
                return null;
            }
        } catch (Throwable th) {
            this.pr.qa().hw(this);
            throw th;
        }
    }

    private void vk() {
        this.hw.pr(com.byazt.lp.c.hw().pr("response.body().close()"));
    }

    @Override // com.byazt.jv.c
    public void pr(uc ucVar) {
        try {
            synchronized (this) {
                if (this.uc) {
                    throw new IllegalStateException("Already Executed");
                }
                this.uc = true;
            }
            vk();
            this.pr.qa().pr(new pr(ucVar));
        } catch (Throwable th) {
            if (ucVar != null) {
                ucVar.pr(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.jv.c
    public void hn() {
        this.hw.pr();
    }

    @Override // com.byazt.jv.c
    public boolean x() {
        return this.hw.hw();
    }

    @Override // com.byazt.jv.c
    /* JADX INFO: renamed from: uc, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public z clone() {
        return pr(this.pr, this.hn, this.x);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 147})
    final class pr extends com.byazt.xx.hw {
        public final uc hn;

        public pr(uc ucVar) {
            super("OkHttp %s", z.this.zo());
            this.hn = ucVar;
        }

        public String pr() {
            return z.this.hn.pr().uc();
        }

        public z hw() {
            return z.this;
        }

        public void hn() {
            if (z.this.hn != null && z.this.hn.uc != null) {
                z.this.hn.uc.w();
            }
        }

        @Override // com.byazt.xx.hw
        public void x() {
            boolean z = false;
            try {
                try {
                    try {
                        if (z.this.hn != null && z.this.hn.uc != null) {
                            z.this.hn.uc.pr();
                        }
                        gz gzVarAj = z.this.aj();
                        try {
                            if (z.this.hw.hw()) {
                                this.hn.pr(z.this, new IOException("Canceled"));
                            } else {
                                if (gzVarAj != null) {
                                    gzVarAj.pr(z.this.fw);
                                }
                                this.hn.pr(z.this, gzVarAj);
                            }
                            if (gzVarAj.hn == 0) {
                                throw new IOException(gzVarAj.x);
                            }
                        } catch (IOException e) {
                            z = true;
                            e = e;
                            if (!z) {
                                z.this.c.pr(z.this, e);
                                this.hn.pr(z.this, e);
                            } else {
                                com.byazt.lp.c.hw().pr(4, "Callback failure for " + z.this.fw(), e);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    z.this.c.pr(z.this, new IOException(e3));
                    this.hn.pr(z.this, new IOException(e3));
                }
                z.this.pr.qa().hw(this);
            } catch (Throwable th) {
                z.this.pr.qa().hw(this);
                throw th;
            }
        }
    }

    public String fw() {
        return (x() ? "canceled " : "") + (this.x ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + zo();
    }

    public String zo() {
        return this.hn.pr().k();
    }

    public gz aj() throws IOException {
        ArrayList arrayList = new ArrayList(this.pr.ny());
        arrayList.add(this.hw);
        arrayList.add(new com.byazt.osx.pr(this.pr.uc()));
        arrayList.add(new com.byazt.gr.pr(this.pr.fw()));
        arrayList.add(new com.byazt.iaw.pr(this.pr));
        if (!this.x) {
            arrayList.addAll(this.pr.fo());
        }
        arrayList.add(new com.byazt.osx.hw(this.x));
        return new com.byazt.osx.fw(arrayList, null, null, null, 0, this.hn, this, this.c, this.pr.pr(), this.pr.hw(), this.pr.hn()).pr(this.hn);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 1426})
    private static final class hw extends nt {
        public final nt hn;
        public final z hw;

        public hw(z zVar, nt ntVar) {
            this.hw = zVar;
            this.hn = ntVar == null ? nt.pr : ntVar;
        }

        private void pr(InetSocketAddress inetSocketAddress) {
            InetAddress address;
            String hostAddress;
            if (inetSocketAddress != null && this.hw != null && (address = inetSocketAddress.getAddress()) != null && (hostAddress = address.getHostAddress()) != null && hostAddress.length() > 0) {
                this.hw.pr(hostAddress);
            }
        }

        @Override // com.byazt.jv.nt
        public void pr(c cVar, InetSocketAddress inetSocketAddress, Proxy proxy, rc rcVar) {
            pr(inetSocketAddress);
            this.hn.pr(cVar, inetSocketAddress, proxy, rcVar);
        }

        @Override // com.byazt.jv.nt
        public void pr(c cVar, InetSocketAddress inetSocketAddress, Proxy proxy, rc rcVar, IOException iOException) {
            pr(inetSocketAddress);
            this.hn.pr(cVar, inetSocketAddress, proxy, rcVar, iOException);
        }

        @Override // com.byazt.jv.nt
        public void pr(c cVar, aj ajVar) {
            if (ajVar != null && ajVar.pr() != null) {
                pr(ajVar.pr().hn());
            }
            this.hn.pr(cVar, ajVar);
        }

        @Override // com.byazt.jv.nt
        public void pr(c cVar, IOException iOException) {
            this.hn.pr(cVar, iOException);
        }
    }
}
