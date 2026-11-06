package com.byazt.ls;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 32, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy extends cd {
    public final byte[] n;
    public int qg;

    public cy(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.qg = -1;
        this.n = bArr;
    }

    @Override // com.byazt.ls.cd, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.n;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cy)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((cy) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.qg == -1) {
            try {
                this.qg = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.qg = 0;
            }
        }
        return this.qg;
    }
}
