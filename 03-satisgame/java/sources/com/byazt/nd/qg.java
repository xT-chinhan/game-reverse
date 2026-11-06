package com.byazt.nd;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.tk.k;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 674, 26})
public class qg extends com.byazt.nd.n {
    public final Object d;
    public final InterfaceC0256qg k;
    public final Object oa;
    public final int sz;

    /* JADX INFO: renamed from: com.byazt.nd.qg$qg, reason: collision with other inner class name */
    public interface InterfaceC0256qg {
        void n(qg qgVar);
    }

    public qg(n nVar) {
        super(nVar.q, nVar.l);
        this.sz = nVar.x;
        this.k = nVar.fs;
        this.d = this;
        this.x = nVar.n;
        this.fs = nVar.qg;
        this.w = nVar.w;
        this.rv = nVar.s;
        this.oa = nVar.rv;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.n.n(this.fs);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            x();
        } catch (Throwable unused) {
        }
        this.q.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.n.qg(this.fs);
        InterfaceC0256qg interfaceC0256qg = this.k;
        if (interfaceC0256qg != null) {
            interfaceC0256qg.n(this);
        }
    }

    private boolean x() throws com.byazt.gy.n {
        while (this.rv.n()) {
            q();
            fs.n nVarQg = this.rv.qg();
            try {
                n(nVarQg);
                return true;
            } catch (com.byazt.gy.s unused) {
                nVarQg.n();
                Boolean.valueOf(w());
                String str = this.x;
            } catch (l.n unused2) {
                Boolean.valueOf(w());
                String str2 = this.x;
                return false;
            } catch (IOException e) {
                if (e instanceof SocketTimeoutException) {
                    nVarQg.qg();
                }
                if (!qg()) {
                    Boolean.valueOf(w());
                    String str3 = this.x;
                }
            } catch (Throwable unused3) {
                return false;
            }
        }
        return false;
    }

    private void n(fs.n nVar) throws Throwable {
        File fileS = this.n.s(this.fs);
        long length = fileS.length();
        int i = this.sz;
        if (i > 0 && length >= i) {
            String str = this.fs;
            return;
        }
        int iL = l();
        com.byazt.frl.n nVarQuery = this.qg.query(this.fs, iL);
        if (nVarQuery != null && length >= nVarQuery.s) {
            if (q.l) {
                String str2 = this.fs;
                return;
            }
            return;
        }
        q();
        int i2 = (int) length;
        com.byazt.ien.n nVarN = n(nVar, i2, this.sz, TapHttp.METHOD_GET);
        if (nVarN == null) {
            return;
        }
        boolean z = true;
        l lVar = null;
        try {
            q();
            String strN = com.byazt.cmv.n.n(nVarN, q.x, true);
            if (strN != null) {
                throw new com.byazt.gy.s(strN + ", rawKey: " + this.x + ", url: " + nVar);
            }
            int iN = com.byazt.cmv.n.n(nVarN);
            if (nVarQuery != null && nVarQuery.s != iN) {
                if (q.l) {
                    k.qg("TAG_PROXY_DownloadTask", "Content-Length not match, old: " + nVarQuery.s + ", " + iN + ", key: " + this.fs);
                }
                throw new com.byazt.gy.qg("Content-Length not match, old length: " + nVarQuery.s + ", new length: " + iN + ", rawKey: " + this.x + ", currentUrl: " + nVar + ", previousInfo: " + nVarQuery.l);
            }
            com.byazt.cmv.n.n(nVarN, this.qg, this.fs, iL);
            com.byazt.frl.n nVarQuery2 = this.qg.query(this.fs, iL);
            int i3 = nVarQuery2 == null ? 0 : nVarQuery2.s;
            InputStream inputStreamQ = nVarN.q();
            l lVar2 = new l(fileS, q.w ? "rwd" : "rw");
            try {
                lVar2.n(length);
                boolean z2 = q.l;
                byte[] bArr = new byte[8192];
                while (true) {
                    int i4 = inputStreamQ.read(bArr);
                    if (i4 >= 0) {
                        q();
                        if (i4 > 0) {
                            lVar2.n(bArr, 0, i4);
                            i2 += i4;
                            this.s.addAndGet(i4);
                            n(i3, i2);
                        }
                        int i5 = this.sz;
                        if (i5 > 0 && i2 >= i5) {
                            boolean z3 = q.l;
                            com.byazt.cmv.n.n(nVarN.q());
                            lVar2.n();
                            n();
                            boolean z4 = q.l;
                            return;
                        }
                        q();
                    } else {
                        try {
                            s();
                            boolean z5 = q.l;
                            com.byazt.cmv.n.n(nVarN.q());
                            lVar2.n();
                            return;
                        } catch (Throwable th) {
                            th = th;
                            z = false;
                        }
                    }
                    lVar = lVar2;
                    com.byazt.cmv.n.n(nVarN.q());
                    if (lVar != null) {
                        lVar.n();
                    }
                    if (z) {
                        n();
                        boolean z6 = q.l;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 674, 48})
    static final class n {
        public InterfaceC0256qg fs;
        public com.byazt.frl.s l;
        public String n;
        public com.byazt.lp.n q;
        public String qg;
        public Object rv;
        public fs s;
        public List<w.qg> w;
        public int x;

        public n n(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.n = str;
            return this;
        }

        public n qg(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.qg = str;
            return this;
        }

        public n n(fs fsVar) {
            if (fsVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.s = fsVar;
            return this;
        }

        public n n(com.byazt.lp.n nVar) {
            if (nVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.q = nVar;
            return this;
        }

        public n n(com.byazt.frl.s sVar) {
            if (sVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.l = sVar;
            return this;
        }

        public n n(List<w.qg> list) {
            this.w = list;
            return this;
        }

        public n n(int i) {
            this.x = i;
            return this;
        }

        public n n(InterfaceC0256qg interfaceC0256qg) {
            this.fs = interfaceC0256qg;
            return this;
        }

        public n n(Object obj) {
            this.rv = obj;
            return this;
        }

        public qg n() {
            if (this.q == null || this.l == null || TextUtils.isEmpty(this.n) || TextUtils.isEmpty(this.qg) || this.s == null) {
                throw new IllegalArgumentException();
            }
            return new qg(this);
        }
    }
}
