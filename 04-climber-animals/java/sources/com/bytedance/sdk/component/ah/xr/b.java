package com.bytedance.sdk.component.ah.xr;

import androidx.browser.trusted.sharing.ShareTarget;
import com.umeng.analytics.pro.ek;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends op {
    private final nw ch;
    private final nw hi;
    private final com.bytedance.sdk.component.ah.ms.c ny;
    private final List<xr> sl;
    private long zb = -1;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final nw f1032ms = nw.ms("multipart/mixed");
    public static final nw xr = nw.ms("multipart/alternative");
    public static final nw ah = nw.ms("multipart/digest");
    public static final nw d = nw.ms("multipart/parallel");
    public static final nw ka = nw.ms(ShareTarget.ENCODING_TYPE_MULTIPART);
    private static final byte[] c = {58, 32};
    private static final byte[] ab = {ek.k, 10};
    private static final byte[] x = {45, 45};

    b(com.bytedance.sdk.component.ah.ms.c cVar, nw nwVar, List<xr> list) {
        this.ny = cVar;
        this.ch = nwVar;
        this.hi = nw.ms(nwVar + "; boundary=" + cVar.ms());
        this.sl = com.bytedance.sdk.component.ah.xr.ms.ah.ms(list);
    }

    @Override // com.bytedance.sdk.component.ah.xr.op
    public nw ms() {
        return this.hi;
    }

    @Override // com.bytedance.sdk.component.ah.xr.op
    public long xr() throws IOException {
        long j = this.zb;
        if (j != -1) {
            return j;
        }
        long jMs = ms((com.bytedance.sdk.component.ah.ms.d) null, true);
        this.zb = jMs;
        return jMs;
    }

    @Override // com.bytedance.sdk.component.ah.xr.op
    public void ms(com.bytedance.sdk.component.ah.ms.d dVar) throws IOException {
        ms(dVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long ms(com.bytedance.sdk.component.ah.ms.d dVar, boolean z) throws IOException {
        com.bytedance.sdk.component.ah.ms.ah ahVar;
        if (z) {
            dVar = new com.bytedance.sdk.component.ah.ms.ah();
            ahVar = dVar;
        } else {
            ahVar = 0;
        }
        int size = this.sl.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            xr xrVar = this.sl.get(i);
            qv qvVar = xrVar.f1034ms;
            op opVar = xrVar.xr;
            dVar.ah(x);
            dVar.xr(this.ny);
            dVar.ah(ab);
            if (qvVar != null) {
                int iMs = qvVar.ms();
                for (int i2 = 0; i2 < iMs; i2++) {
                    dVar.xr(qvVar.ms(i2)).ah(c).xr(qvVar.xr(i2)).ah(ab);
                }
            }
            nw nwVarMs = opVar.ms();
            if (nwVarMs != null) {
                dVar.xr("Content-Type: ").xr(nwVarMs.toString()).ah(ab);
            }
            long jXr = opVar.xr();
            if (jXr != -1) {
                dVar.xr("Content-Length: ").sl(jXr).ah(ab);
            } else if (z) {
                ahVar.qv();
                return -1L;
            }
            byte[] bArr = ab;
            dVar.ah(bArr);
            if (z) {
                j += jXr;
            } else {
                opVar.ms(dVar);
            }
            dVar.ah(bArr);
        }
        byte[] bArr2 = x;
        dVar.ah(bArr2);
        dVar.xr(this.ny);
        dVar.ah(bArr2);
        dVar.ah(ab);
        if (!z) {
            return j;
        }
        long jXr2 = j + ahVar.xr();
        ahVar.qv();
        return jXr2;
    }

    static StringBuilder ms(StringBuilder sb, String str) {
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

    public static final class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final qv f1034ms;
        final op xr;

        public static xr ms(qv qvVar, op opVar) {
            if (opVar == null) {
                throw new NullPointerException("body == null");
            }
            if (qvVar != null && qvVar.ms("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (qvVar != null && qvVar.ms("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new xr(qvVar, opVar);
        }

        public static xr ms(String str, String str2, op opVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            b.ms(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                b.ms(sb, str2);
            }
            return ms(qv.ms("Content-Disposition", sb.toString()), opVar);
        }

        private xr(qv qvVar, op opVar) {
            this.f1034ms = qvVar;
            this.xr = opVar;
        }
    }

    public static final class ms {
        private final List<xr> ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bytedance.sdk.component.ah.ms.c f1033ms;
        private nw xr;

        public ms() {
            this(UUID.randomUUID().toString());
        }

        public ms(String str) {
            this.xr = b.f1032ms;
            this.ah = new ArrayList();
            this.f1033ms = com.bytedance.sdk.component.ah.ms.c.ms(str);
        }

        public ms ms(nw nwVar) {
            if (nwVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!nwVar.ms().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(nwVar)));
            }
            this.xr = nwVar;
            return this;
        }

        public ms ms(String str, String str2, op opVar) {
            return ms(xr.ms(str, str2, opVar));
        }

        public ms ms(xr xrVar) {
            if (xrVar == null) {
                throw new NullPointerException("part == null");
            }
            this.ah.add(xrVar);
            return this;
        }

        public b ms() {
            if (this.ah.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new b(this.f1033ms, this.xr, this.ah);
        }
    }
}
