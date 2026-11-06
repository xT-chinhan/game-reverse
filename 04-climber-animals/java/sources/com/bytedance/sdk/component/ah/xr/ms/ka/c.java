package com.bytedance.sdk.component.ah.xr.ms.ka;

import com.bytedance.sdk.component.ah.ms.qv;
import com.bytedance.sdk.component.ah.ms.y;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.g;
import com.bytedance.sdk.component.ah.xr.i;
import com.bytedance.sdk.component.ah.xr.re;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.yu;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.bytedance.sdk.component.ah.xr.ms.ah.ah {
    private static final com.bytedance.sdk.component.ah.ms.c ab;
    private static final com.bytedance.sdk.component.ah.ms.c ah;
    private static final com.bytedance.sdk.component.ah.ms.c c;
    private static final List<com.bytedance.sdk.component.ah.ms.c> ch;
    private static final com.bytedance.sdk.component.ah.ms.c d;
    private static final List<com.bytedance.sdk.component.ah.ms.c> hi;
    private static final com.bytedance.sdk.component.ah.ms.c ka;
    private static final com.bytedance.sdk.component.ah.ms.c ny;
    private static final com.bytedance.sdk.component.ah.ms.c x;
    private static final com.bytedance.sdk.component.ah.ms.c xr;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final com.bytedance.sdk.component.ah.xr.ms.xr.ab f1087ms;
    private final re sl;
    private final ab u;
    private ny ub;
    private final t.ms zb;

    static {
        com.bytedance.sdk.component.ah.ms.c cVarMs = com.bytedance.sdk.component.ah.ms.c.ms("connection");
        xr = cVarMs;
        com.bytedance.sdk.component.ah.ms.c cVarMs2 = com.bytedance.sdk.component.ah.ms.c.ms("host");
        ah = cVarMs2;
        com.bytedance.sdk.component.ah.ms.c cVarMs3 = com.bytedance.sdk.component.ah.ms.c.ms("keep-alive");
        d = cVarMs3;
        com.bytedance.sdk.component.ah.ms.c cVarMs4 = com.bytedance.sdk.component.ah.ms.c.ms("proxy-connection");
        ka = cVarMs4;
        com.bytedance.sdk.component.ah.ms.c cVarMs5 = com.bytedance.sdk.component.ah.ms.c.ms("transfer-encoding");
        c = cVarMs5;
        com.bytedance.sdk.component.ah.ms.c cVarMs6 = com.bytedance.sdk.component.ah.ms.c.ms("te");
        ab = cVarMs6;
        com.bytedance.sdk.component.ah.ms.c cVarMs7 = com.bytedance.sdk.component.ah.ms.c.ms("encoding");
        x = cVarMs7;
        com.bytedance.sdk.component.ah.ms.c cVarMs8 = com.bytedance.sdk.component.ah.ms.c.ms("upgrade");
        ny = cVarMs8;
        ch = com.bytedance.sdk.component.ah.xr.ms.ah.ms(cVarMs, cVarMs2, cVarMs3, cVarMs4, cVarMs6, cVarMs5, cVarMs7, cVarMs8, ah.ah, ah.d, ah.ka, ah.c);
        hi = com.bytedance.sdk.component.ah.xr.ms.ah.ms(cVarMs, cVarMs2, cVarMs3, cVarMs4, cVarMs6, cVarMs5, cVarMs7, cVarMs8);
    }

    public c(re reVar, t.ms msVar, com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar, ab abVar2) {
        this.sl = reVar;
        this.zb = msVar;
        this.f1087ms = abVar;
        this.u = abVar2;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public qv ms(yu yuVar, long j) {
        return this.ub.x();
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void ms(yu yuVar) throws IOException {
        if (this.ub != null) {
            return;
        }
        ny nyVarMs = this.u.ms(xr(yuVar), yuVar.d() != null);
        this.ub = nyVarMs;
        nyVarMs.ka().ms(this.zb.ah(), TimeUnit.MILLISECONDS);
        this.ub.c().ms(this.zb.d(), TimeUnit.MILLISECONDS);
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void ms() throws IOException {
        this.u.xr();
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void xr() throws IOException {
        this.ub.x().close();
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public cv.ms ms(boolean z) throws IOException {
        cv.ms msVarMs = ms(this.ub.d());
        if (z && com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(msVarMs) == 100) {
            return null;
        }
        return msVarMs;
    }

    public static List<ah> xr(yu yuVar) {
        com.bytedance.sdk.component.ah.xr.qv qvVarAh = yuVar.ah();
        ArrayList arrayList = new ArrayList(qvVarAh.ms() + 4);
        arrayList.add(new ah(ah.ah, yuVar.xr()));
        arrayList.add(new ah(ah.d, com.bytedance.sdk.component.ah.xr.ms.ah.ny.ms(yuVar.ms())));
        String strMs = yuVar.ms("Host");
        if (strMs != null) {
            arrayList.add(new ah(ah.c, strMs));
        }
        arrayList.add(new ah(ah.ka, yuVar.ms().ah()));
        int iMs = qvVarAh.ms();
        for (int i = 0; i < iMs; i++) {
            com.bytedance.sdk.component.ah.ms.c cVarMs = com.bytedance.sdk.component.ah.ms.c.ms(qvVarAh.ms(i).toLowerCase(Locale.US));
            if (!ch.contains(cVarMs)) {
                arrayList.add(new ah(cVarMs, qvVarAh.xr(i)));
            }
        }
        return arrayList;
    }

    public static cv.ms ms(List<ah> list) throws IOException {
        com.bytedance.sdk.component.ah.xr.qv.ms msVar = new com.bytedance.sdk.component.ah.xr.qv.ms();
        int size = list.size();
        com.bytedance.sdk.component.ah.xr.ms.ah.hi hiVarMs = null;
        for (int i = 0; i < size; i++) {
            ah ahVar = list.get(i);
            if (ahVar == null) {
                if (hiVarMs != null && hiVarMs.xr == 100) {
                    msVar = new com.bytedance.sdk.component.ah.xr.qv.ms();
                    hiVarMs = null;
                }
            } else {
                com.bytedance.sdk.component.ah.ms.c cVar = ahVar.ab;
                String strMs = ahVar.x.ms();
                if (cVar.equals(ah.xr)) {
                    hiVarMs = com.bytedance.sdk.component.ah.xr.ms.ah.hi.ms("HTTP/1.1 ".concat(String.valueOf(strMs)));
                } else if (!hi.contains(cVar)) {
                    com.bytedance.sdk.component.ah.xr.ms.ms.f1106ms.ms(msVar, cVar.ms(), strMs);
                }
            }
        }
        if (hiVarMs == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new cv.ms().ms(i.HTTP_2).ms(hiVarMs.xr).ms(hiVarMs.ah).ms(msVar.ms());
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public g ms(cv cvVar) throws IOException {
        return new com.bytedance.sdk.component.ah.xr.ms.ah.x(cvVar.ms("Content-Type"), com.bytedance.sdk.component.ah.xr.ms.ah.ka.ms(cvVar), com.bytedance.sdk.component.ah.ms.sl.ms(new ms(this.ub.ab())));
    }

    @Override // com.bytedance.sdk.component.ah.xr.ms.ah.ah
    public void ah() {
        ny nyVar = this.ub;
        if (nyVar != null) {
            nyVar.xr(xr.CANCEL);
        }
    }

    class ms extends com.bytedance.sdk.component.ah.ms.x {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        boolean f1088ms;
        long xr;

        ms(y yVar) {
            super(yVar);
            this.f1088ms = false;
            this.xr = 0L;
        }

        @Override // com.bytedance.sdk.component.ah.ms.x, com.bytedance.sdk.component.ah.ms.y
        public long ms(com.bytedance.sdk.component.ah.ms.ah ahVar, long j) throws IOException {
            try {
                long jMs = xr().ms(ahVar, j);
                if (jMs > 0) {
                    this.xr += jMs;
                }
                return jMs;
            } catch (IOException e) {
                ms(e);
                throw e;
            }
        }

        @Override // com.bytedance.sdk.component.ah.ms.x, com.bytedance.sdk.component.ah.ms.y, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            ms(null);
        }

        private void ms(IOException iOException) {
            if (this.f1088ms) {
                return;
            }
            this.f1088ms = true;
            c.this.f1087ms.ms(false, (com.bytedance.sdk.component.ah.xr.ms.ah.ah) c.this, this.xr, iOException);
        }
    }
}
