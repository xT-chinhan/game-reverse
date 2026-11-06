package com.bytedance.sdk.component.ah.xr;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ah implements Closeable, Flushable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final com.bytedance.sdk.component.ah.xr.ms.ms.c f1027ms;
    final com.bytedance.sdk.component.ah.xr.ms.ms.d xr;

    void update(cv cvVar, cv cvVar2) {
        com.bytedance.sdk.component.ah.xr.ms.ms.d.ms msVarMs;
        xr xrVar = new xr(cvVar2);
        try {
            msVarMs = ((ms) cvVar.x()).f1028ms.ms();
            if (msVarMs != null) {
                try {
                    xrVar.ms(msVarMs);
                    msVarMs.xr();
                } catch (IOException unused) {
                    ms(msVarMs);
                }
            }
        } catch (IOException unused2) {
            msVarMs = null;
        }
    }

    private void ms(com.bytedance.sdk.component.ah.xr.ms.ms.d.ms msVar) {
        if (msVar != null) {
            try {
                msVar.ah();
            } catch (IOException unused) {
            }
        }
    }

    public void delete() throws IOException {
        this.xr.delete();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.xr.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.xr.close();
    }

    private static final class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static final String f1029ms = com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ah() + "-Sent-Millis";
        private static final String xr = com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ah() + "-Received-Millis";
        private final int ab;
        private final String ah;
        private final i c;
        private final h ch;
        private final qv d;
        private final long hi;
        private final String ka;
        private final qv ny;
        private final long sl;
        private final String x;

        xr(cv cvVar) {
            this.ah = cvVar.ms().ms().toString();
            this.d = com.bytedance.sdk.component.ah.xr.ms.ah.ka.xr(cvVar);
            this.ka = cvVar.ms().xr();
            this.c = cvVar.xr();
            this.ab = cvVar.ah();
            this.x = cvVar.ka();
            this.ny = cvVar.ab();
            this.ch = cvVar.c();
            this.hi = cvVar.zb();
            this.sl = cvVar.u();
        }

        public void ms(com.bytedance.sdk.component.ah.xr.ms.ms.d.ms msVar) throws IOException {
            com.bytedance.sdk.component.ah.ms.d dVarMs = com.bytedance.sdk.component.ah.ms.sl.ms(msVar.ms(0));
            dVarMs.xr(this.ah).ny(10);
            dVarMs.xr(this.ka).ny(10);
            dVarMs.sl(this.d.ms()).ny(10);
            int iMs = this.d.ms();
            for (int i = 0; i < iMs; i++) {
                dVarMs.xr(this.d.ms(i)).xr(": ").xr(this.d.xr(i)).ny(10);
            }
            dVarMs.xr(new com.bytedance.sdk.component.ah.xr.ms.ah.hi(this.c, this.ab, this.x).toString()).ny(10);
            dVarMs.sl(this.ny.ms() + 2).ny(10);
            int iMs2 = this.ny.ms();
            for (int i2 = 0; i2 < iMs2; i2++) {
                dVarMs.xr(this.ny.ms(i2)).xr(": ").xr(this.ny.xr(i2)).ny(10);
            }
            dVarMs.xr(f1029ms).xr(": ").sl(this.hi).ny(10);
            dVarMs.xr(xr).xr(": ").sl(this.sl).ny(10);
            if (ms()) {
                dVarMs.ny(10);
                dVarMs.xr(this.ch.xr().ms()).ny(10);
                ms(dVarMs, this.ch.ah());
                ms(dVarMs, this.ch.d());
                dVarMs.xr(this.ch.ms().ms()).ny(10);
            }
            dVarMs.close();
        }

        private boolean ms() {
            return this.ah.startsWith("https://");
        }

        private void ms(com.bytedance.sdk.component.ah.ms.d dVar, List<Certificate> list) throws IOException {
            try {
                dVar.sl(list.size()).ny(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dVar.xr(com.bytedance.sdk.component.ah.ms.c.ms(list.get(i).getEncoded()).xr()).ny(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    private static class ms extends g {
        private final String ah;
        private final String d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final com.bytedance.sdk.component.ah.xr.ms.ms.d.ah f1028ms;
        private final com.bytedance.sdk.component.ah.ms.ka xr;

        @Override // com.bytedance.sdk.component.ah.xr.g
        public nw ms() {
            String str = this.ah;
            if (str != null) {
                return nw.ms(str);
            }
            return null;
        }

        @Override // com.bytedance.sdk.component.ah.xr.g
        public long xr() {
            try {
                String str = this.d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1L;
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }

        @Override // com.bytedance.sdk.component.ah.xr.g
        public com.bytedance.sdk.component.ah.ms.ka ah() {
            return this.xr;
        }
    }
}
