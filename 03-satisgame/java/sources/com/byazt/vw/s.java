package com.byazt.vw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_INITED_TIME, 8})
public abstract class s {
    public abstract List<Certificate> n(List<Certificate> list, String str) throws SSLPeerUnverifiedException;

    public static s n(X509TrustManager x509TrustManager) {
        return com.byazt.quz.l.qg().n(x509TrustManager);
    }
}
