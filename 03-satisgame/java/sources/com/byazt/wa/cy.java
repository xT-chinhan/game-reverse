package com.byazt.wa;

import com.anythink.china.a.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public final class cy {
    public static k n;
    public static long qg;

    private cy() {
    }

    public static k n() {
        synchronized (cy.class) {
            k kVar = n;
            if (kVar != null) {
                n = kVar.w;
                kVar.w = null;
                qg -= c.n;
                return kVar;
            }
            return new k();
        }
    }

    public static void n(k kVar) {
        if (kVar.w != null || kVar.x != null) {
            throw new IllegalArgumentException();
        }
        if (kVar.q) {
            return;
        }
        synchronized (cy.class) {
            long j = qg;
            if (j + c.n > c.q) {
                return;
            }
            qg = j + c.n;
            kVar.w = n;
            kVar.s = 0;
            kVar.qg = 0;
            n = kVar;
        }
    }
}
