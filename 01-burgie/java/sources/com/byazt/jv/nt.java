package com.byazt.jv;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 74})
public abstract class nt {
    public static final nt pr = new nt() { // from class: com.byazt.jv.nt.1
    };

    public interface pr {
        nt pr(c cVar);
    }

    public static pr pr(nt ntVar) {
        return new pr() { // from class: com.byazt.jv.nt.2
            @Override // com.byazt.jv.nt.pr
            public nt pr(c cVar) {
                return nt.this;
            }
        };
    }

    public void pr(c cVar, InetSocketAddress inetSocketAddress, Proxy proxy, rc rcVar) {
    }

    public void pr(c cVar, InetSocketAddress inetSocketAddress, Proxy proxy, rc rcVar, IOException iOException) {
    }

    public void pr(c cVar, aj ajVar) {
    }

    public void pr(c cVar, IOException iOException) {
    }
}
