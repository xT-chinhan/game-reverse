package com.byazt.di;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD, 20})
public abstract class hn {
    public abstract List<Certificate> pr(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static hn pr(X509TrustManager x509TrustManager) {
        return com.byazt.lp.c.hw().pr(x509TrustManager);
    }
}
