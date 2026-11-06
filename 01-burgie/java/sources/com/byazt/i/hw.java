package com.byazt.i;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 13})
public class hw extends com.byazt.i.pr {
    public final int g;
    public final InterfaceC0091hw ho;
    public final Object k;
    public final Object m;

    /* JADX INFO: renamed from: com.byazt.i.hw$hw, reason: collision with other inner class name */
    public interface InterfaceC0091hw {
        void pr(hw hwVar);
    }

    public hw(pr prVar) {
        super(prVar.x, prVar.c);
        this.g = prVar.fw;
        this.ho = prVar.zo;
        this.k = this;
        this.fw = prVar.pr;
        this.zo = prVar.hw;
        this.uc = prVar.uc;
        this.aj = prVar.hn;
        this.m = prVar.aj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pr.pr(this.zo);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            fw();
        } catch (com.byazt.m.pr e) {
        } catch (Throwable th) {
        }
        this.x.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.pr.hw(this.zo);
        InterfaceC0091hw interfaceC0091hw = this.ho;
        if (interfaceC0091hw != null) {
            interfaceC0091hw.pr(this);
        }
    }

    private boolean fw() throws com.byazt.m.pr {
        while (this.aj.pr()) {
            x();
            zo.pr prVarHw = this.aj.hw();
            try {
                pr(prVarHw);
                return true;
            } catch (c.pr e) {
                Boolean.valueOf(uc());
                String str = this.fw;
                return false;
            } catch (com.byazt.m.hn e2) {
                prVarHw.pr();
                Boolean.valueOf(uc());
                String str2 = this.fw;
            } catch (com.byazt.m.hw e3) {
                return false;
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    prVarHw.hw();
                }
                if (!hw()) {
                    Boolean.valueOf(uc());
                    String str3 = this.fw;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }

    private void pr(zo.pr prVar) throws Throwable {
        File fileHn = this.pr.hn(this.zo);
        long length = fileHn.length();
        int i = this.g;
        if (i > 0 && length >= i) {
            String str = this.zo;
            return;
        }
        int iC = c();
        com.byazt.d.pr prVarQuery = this.hw.query(this.zo, iC);
        if (prVarQuery != null && length >= prVarQuery.hn) {
            if (x.c) {
                String str2 = this.zo;
                return;
            }
            return;
        }
        x();
        int i2 = (int) length;
        com.byazt.aj.pr prVarPr = pr(prVar, i2, this.g, TapHttp.METHOD_GET);
        if (prVarPr == null) {
            return;
        }
        c cVar = null;
        boolean z = true;
        try {
            x();
            String strPr = com.byazt.a.pr.pr(prVarPr, x.fw, true);
            if (strPr != null) {
                throw new com.byazt.m.hn(strPr + ", rawKey: " + this.fw + ", url: " + prVar);
            }
            int iPr = com.byazt.a.pr.pr(prVarPr);
            if (prVarQuery != null && prVarQuery.hn != iPr) {
                if (x.c) {
                    ho.hw("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + prVarQuery.hn + ", " + iPr + ", key: " + this.zo);
                }
                throw new com.byazt.m.hw("Content-Length not match, old length: " + prVarQuery.hn + ", new length: " + iPr + ", rawKey: " + this.fw + ", currentUrl: " + prVar + ", previousInfo: " + prVarQuery.c);
            }
            com.byazt.a.pr.pr(prVarPr, this.hw, this.zo, iC);
            com.byazt.d.pr prVarQuery2 = this.hw.query(this.zo, iC);
            int i3 = prVarQuery2 == null ? 0 : prVarQuery2.hn;
            InputStream inputStreamX = prVarPr.x();
            c cVar2 = new c(fileHn, x.uc ? "rwd" : "rw");
            try {
                cVar2.pr(length);
                boolean z2 = x.c;
                byte[] bArr = new byte[8192];
                while (true) {
                    int i4 = inputStreamX.read(bArr);
                    if (i4 >= 0) {
                        x();
                        if (i4 > 0) {
                            cVar2.pr(bArr, 0, i4);
                            i2 += i4;
                            this.hn.addAndGet(i4);
                            pr(i3, i2);
                        }
                        int i5 = this.g;
                        if (i5 > 0 && i2 >= i5) {
                            boolean z3 = x.c;
                            com.byazt.a.pr.pr(prVarPr.x());
                            cVar2.pr();
                            pr();
                            boolean z4 = x.c;
                            return;
                        }
                        x();
                    } else {
                        try {
                            hn();
                            boolean z5 = x.c;
                            com.byazt.a.pr.pr(prVarPr.x());
                            cVar2.pr();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            cVar = cVar2;
                            z = false;
                        }
                    }
                    com.byazt.a.pr.pr(prVarPr.x());
                    if (cVar != null) {
                        cVar.pr();
                    }
                    if (z) {
                        pr();
                        boolean z6 = x.c;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cVar = cVar2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    static final class pr {
        public Object aj;
        public com.byazt.d.hn c;
        public int fw;
        public zo hn;
        public String hw;
        public String pr;
        public List<uc.hw> uc;
        public com.byazt.j.pr x;
        public InterfaceC0091hw zo;

        public pr pr(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.pr = str;
            return this;
        }

        public pr hw(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.hw = str;
            return this;
        }

        public pr pr(zo zoVar) {
            if (zoVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.hn = zoVar;
            return this;
        }

        public pr pr(com.byazt.j.pr prVar) {
            if (prVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.x = prVar;
            return this;
        }

        public pr pr(com.byazt.d.hn hnVar) {
            if (hnVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.c = hnVar;
            return this;
        }

        public pr pr(List<uc.hw> list) {
            this.uc = list;
            return this;
        }

        public pr pr(int i) {
            this.fw = i;
            return this;
        }

        public pr pr(InterfaceC0091hw interfaceC0091hw) {
            this.zo = interfaceC0091hw;
            return this;
        }

        public pr pr(Object obj) {
            this.aj = obj;
            return this;
        }

        public hw pr() {
            if (this.x == null || this.c == null || TextUtils.isEmpty(this.pr) || TextUtils.isEmpty(this.hw) || this.hn == null) {
                throw new IllegalArgumentException();
            }
            return new hw(this);
        }
    }
}
