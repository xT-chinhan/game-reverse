package com.byazt.pe;

import com.byazt.hg.of;
import com.byazt.hg.zo;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 13})
public class hw {
    public com.byazt.ci.pr c;
    public int hn = -2;
    public com.byazt.bp.c hw;
    public int pr;
    public com.byazt.ci.pr x;

    public hw(int i) {
        this.pr = i;
        x();
    }

    private int hn() {
        zo.hn hnVarPr = pr();
        if (hnVarPr == null) {
            return -2;
        }
        if (!hnVarPr.fw() || !a.hw().wn()) {
            return -1;
        }
        return hnVarPr.x();
    }

    private void x() {
        int i = this.pr;
        switch (i) {
            case 1:
                this.c = new com.byazt.ra.x(this, i);
                this.x = new com.byazt.om.hw(this);
                break;
            case 5:
                this.c = new com.byazt.ra.x(this, i);
                this.x = new com.byazt.yb.hw(this);
                break;
            case 6:
                this.x = new com.byazt.si.hw(this);
                break;
            case 7:
                this.x = new com.byazt.vh.uc(this);
                break;
            case 8:
                this.x = new com.byazt.vh.pr(this);
                break;
            case 9:
                this.c = new com.byazt.ra.x(this, i);
                this.x = new com.byazt.ju.hw(this);
                break;
        }
    }

    public boolean pr(of ofVar) {
        switch (com.byazt.eg.hw.pr().hn(ofVar)) {
            case 3:
                return false;
            default:
                return true;
        }
    }

    public zo.hn pr() {
        return zo.pr(this.pr);
    }

    public com.byazt.bp.c hw() {
        int iHn = hn();
        com.byazt.bp.c cVar = this.hw;
        if (cVar != null && iHn == this.hn) {
            return cVar;
        }
        switch (iHn) {
            case -1:
                this.hw = new com.byazt.bp.hw(this.pr);
                break;
            case 0:
                this.hw = new com.byazt.bp.pr(this.pr);
                break;
            case 1:
                this.hw = new com.byazt.bp.x(this.pr);
                break;
            case 2:
            default:
                this.hw = pr.hw(this.pr);
                break;
            case 3:
                this.hw = new com.byazt.bp.hn(this.pr);
                break;
        }
        this.hn = iHn;
        return this.hw;
    }

    public com.byazt.ci.pr pr(boolean z) {
        com.byazt.ci.pr prVar;
        if (z && (prVar = this.c) != null) {
            return prVar;
        }
        return this.x;
    }
}
