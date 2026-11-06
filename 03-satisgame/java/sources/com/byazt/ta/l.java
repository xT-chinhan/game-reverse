package com.byazt.ta;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 18})
public class l {
    public n n;
    public int q = 10;
    public n qg;
    public int s;

    public boolean n(long j, long j2) {
        synchronized (this) {
            n nVar = this.n;
            if (nVar != null) {
                if (j >= nVar.n && j2 >= nVar.qg) {
                    n nVar2 = nVar.s;
                    if (nVar2 != null && j2 - nVar2.qg < 1000) {
                        nVar.n = j;
                        nVar.qg = j2;
                        return true;
                    }
                }
                return false;
            }
            n nVarN = n();
            nVarN.n = j;
            nVarN.qg = j2;
            if (nVar != null) {
                nVarN.s = nVar;
                nVar.q = nVarN;
            }
            this.n = nVarN;
            return true;
        }
    }

    public long qg(long j, long j2) {
        synchronized (this) {
            n nVar = this.n;
            if (nVar == null) {
                return -1L;
            }
            n nVarN = n(j);
            if (nVarN == null) {
                return -1L;
            }
            long j3 = nVar.n - nVarN.n;
            long j4 = j2 - nVarN.qg;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private n n() {
        n nVar;
        int i = this.s;
        if (i >= this.q && (nVar = this.qg) != null) {
            n nVar2 = nVar.q;
            nVar.q = null;
            this.qg = nVar2;
            if (nVar2 != null) {
                nVar2.s = null;
            }
            return nVar;
        }
        this.s = i + 1;
        return new n();
    }

    private n n(long j) {
        n nVar = this.n;
        n nVar2 = null;
        while (nVar != null && nVar.qg > j) {
            nVar2 = nVar;
            nVar = nVar.s;
        }
        return (nVar == null || nVar2 == null || nVar == nVar2 || j - nVar.qg >= nVar2.qg - j) ? nVar2 : nVar;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n {
        public long n;
        public n q;
        public long qg;
        public n s;

        private n() {
        }
    }
}
