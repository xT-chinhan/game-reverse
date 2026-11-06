package com.bytedance.pangle.x;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class ao extends qv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final byte[] f720ms;
    private int xr;

    ao(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.xr = -1;
        this.f720ms = bArr;
    }

    @Override // com.bytedance.pangle.x.qv, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f720ms;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ao)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((ao) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.xr == -1) {
            try {
                this.xr = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.xr = 0;
            }
        }
        return this.xr;
    }
}
