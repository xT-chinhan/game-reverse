package com.byazt.pq;

import com.anythink.core.common.l.b;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, 849})
public final class ou extends t {
    public final py cp;
    public final List<qg> d;
    public long oa = -1;
    public final com.byazt.wa.w rv;
    public final py tj;
    public static final py n = py.n("multipart/mixed");
    public static final py qg = py.n("multipart/alternative");
    public static final py s = py.n("multipart/digest");
    public static final py q = py.n("multipart/parallel");
    public static final py l = py.n("multipart/form-data");
    public static final byte[] w = {58, 32};
    public static final byte[] x = {13, 10};
    public static final byte[] fs = {45, 45};

    public ou(com.byazt.wa.w wVar, py pyVar, List<qg> list) {
        this.rv = wVar;
        this.tj = pyVar;
        this.cp = py.n(pyVar + "; boundary=" + wVar.n());
        this.d = com.byazt.zho.s.n(list);
    }

    @Override // com.byazt.pq.t
    public py n() {
        return this.cp;
    }

    @Override // com.byazt.pq.t
    public long qg() throws IOException {
        long j = this.oa;
        if (j != -1) {
            return j;
        }
        long jN = n((com.byazt.wa.q) null, true);
        this.oa = jN;
        return jN;
    }

    @Override // com.byazt.pq.t
    public void n(com.byazt.wa.q qVar) throws IOException {
        n(qVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long n(com.byazt.wa.q qVar, boolean z) throws IOException {
        com.byazt.wa.s sVar;
        if (z) {
            qVar = new com.byazt.wa.s();
            sVar = qVar;
        } else {
            sVar = 0;
        }
        int size = this.d.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            qg qgVar = this.d.get(i);
            cd cdVar = qgVar.n;
            t tVar = qgVar.qg;
            qVar.s(fs);
            qVar.qg(this.rv);
            qVar.s(x);
            if (cdVar != null) {
                int iN = cdVar.n();
                for (int i2 = 0; i2 < iN; i2++) {
                    qVar.qg(cdVar.n(i2)).s(w).qg(cdVar.qg(i2)).s(x);
                }
            }
            py pyVarN = tVar.n();
            if (pyVarN != null) {
                qVar.qg("Content-Type: ").qg(pyVarN.toString()).s(x);
            }
            long jQg = tVar.qg();
            if (jQg != -1) {
                qVar.qg("Content-Length: ").d(jQg).s(x);
            } else if (z) {
                sVar.cd();
                return -1L;
            }
            byte[] bArr = x;
            qVar.s(bArr);
            if (z) {
                j += jQg;
            } else {
                tVar.n(qVar);
            }
            qVar.s(bArr);
        }
        byte[] bArr2 = fs;
        qVar.s(bArr2);
        qVar.qg(this.rv);
        qVar.s(bArr2);
        qVar.s(x);
        if (!z) {
            return j;
        }
        long jQg2 = j + sVar.qg();
        sVar.cd();
        return jQg2;
    }

    public static StringBuilder n(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
        return sb;
    }

    @com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT})
    public static final class qg {
        public final cd n;
        public final t qg;

        public static qg n(cd cdVar, t tVar) {
            if (tVar == null) {
                throw new NullPointerException("body == null");
            }
            if (cdVar != null && cdVar.n(b.g) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (cdVar != null && cdVar.n("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new qg(cdVar, tVar);
        }

        public static qg n(String str, String str2, t tVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            ou.n(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                ou.n(sb, str2);
            }
            return n(cd.n("Content-Disposition", sb.toString()), tVar);
        }

        private qg(cd cdVar, t tVar) {
            this.n = cdVar;
            this.qg = tVar;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 109, 946})
    public static final class n {
        public final com.byazt.wa.w n;
        public py qg;
        public final List<qg> s;

        public n() {
            this(UUID.randomUUID().toString());
        }

        public n(String str) {
            this.qg = ou.n;
            this.s = new ArrayList();
            this.n = com.byazt.wa.w.n(str);
        }

        public n n(py pyVar) {
            if (pyVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!pyVar.n().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(pyVar)));
            }
            this.qg = pyVar;
            return this;
        }

        public n n(String str, String str2, t tVar) {
            return n(qg.n(str, str2, tVar));
        }

        public n n(qg qgVar) {
            if (qgVar == null) {
                throw new NullPointerException("part == null");
            }
            this.s.add(qgVar);
            return this;
        }

        public ou n() {
            if (this.s.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new ou(this.n, this.qg, this.s);
        }
    }
}
