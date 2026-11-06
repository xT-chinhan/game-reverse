package com.byazt.pq;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 109, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public abstract class cy {
    public static final cy n = new cy() { // from class: com.byazt.pq.cy.1
    };

    public interface n {
        cy n(l lVar);
    }

    public void n(l lVar, rv rvVar) {
    }

    public void n(l lVar, IOException iOException) {
    }

    public void n(l lVar, InetSocketAddress inetSocketAddress, Proxy proxy, m mVar) {
    }

    public void n(l lVar, InetSocketAddress inetSocketAddress, Proxy proxy, m mVar, IOException iOException) {
    }

    public static n n(cy cyVar) {
        return new n() { // from class: com.byazt.pq.cy.2
            @Override // com.byazt.pq.cy.n
            public cy n(l lVar) {
                return cy.this;
            }
        };
    }
}
