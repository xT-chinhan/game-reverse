package com.byazt.tuy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public int hn;
    public pr hw;
    public pr pr;
    public int x = 10;

    public boolean pr(long j, long j2) {
        synchronized (this) {
            pr prVar = this.pr;
            if (prVar != null) {
                if (j >= prVar.pr && j2 >= prVar.hw) {
                    pr prVar2 = prVar.hn;
                    if (prVar2 != null && j2 - prVar2.hw < 1000) {
                        prVar.pr = j;
                        prVar.hw = j2;
                        return true;
                    }
                }
                return false;
            }
            pr prVarPr = pr();
            prVarPr.pr = j;
            prVarPr.hw = j2;
            if (prVar != null) {
                prVarPr.hn = prVar;
                prVar.x = prVarPr;
            }
            this.pr = prVarPr;
            return true;
        }
    }

    public long hw(long j, long j2) {
        synchronized (this) {
            pr prVar = this.pr;
            if (prVar == null) {
                return -1L;
            }
            pr prVarPr = pr(j);
            if (prVarPr == null) {
                return -1L;
            }
            long j3 = prVar.pr - prVarPr.pr;
            long j4 = j2 - prVarPr.hw;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private pr pr() {
        pr prVar;
        int i = this.hn;
        if (i >= this.x && (prVar = this.hw) != null) {
            pr prVar2 = prVar.x;
            prVar.x = null;
            this.hw = prVar2;
            if (prVar2 != null) {
                prVar2.hn = null;
            }
            return prVar;
        }
        this.hn = i + 1;
        return new pr();
    }

    private pr pr(long j) {
        pr prVar = this.pr;
        pr prVar2 = null;
        while (prVar != null && prVar.hw > j) {
            prVar2 = prVar;
            prVar = prVar.hn;
        }
        if (prVar != null && prVar2 != null && prVar != prVar2 && j - prVar.hw < prVar2.hw - j) {
            return prVar;
        }
        return prVar2;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST, 169})
    private static class pr {
        public pr hn;
        public long hw;
        public long pr;
        public pr x;

        private pr() {
        }
    }
}
