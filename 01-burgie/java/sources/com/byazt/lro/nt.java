package com.byazt.lro;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, 74})
public class nt extends lb {
    public int hw;
    public final byte[] pr;

    public nt(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.hw = -1;
        this.pr = bArr;
    }

    @Override // com.byazt.lro.lb, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.pr;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof nt)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((nt) obj).getEncoded());
        } catch (CertificateEncodingException e) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.hw == -1) {
            try {
                this.hw = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException e) {
                this.hw = 0;
            }
        }
        return this.hw;
    }
}
