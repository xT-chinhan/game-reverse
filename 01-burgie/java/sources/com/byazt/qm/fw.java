package com.byazt.qm;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2253, 62})
public final class fw {
    public static long hw;
    public static uc pr;

    private fw() {
    }

    public static uc pr() {
        synchronized (fw.class) {
            uc ucVar = pr;
            if (ucVar != null) {
                pr = ucVar.uc;
                ucVar.uc = null;
                hw -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return ucVar;
            }
            return new uc();
        }
    }

    public static void pr(uc ucVar) {
        if (ucVar.uc != null || ucVar.fw != null) {
            throw new IllegalArgumentException();
        }
        if (ucVar.x) {
            return;
        }
        synchronized (fw.class) {
            long j = hw;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            hw = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            ucVar.uc = pr;
            ucVar.hn = 0;
            ucVar.hw = 0;
            pr = ucVar;
        }
    }
}
