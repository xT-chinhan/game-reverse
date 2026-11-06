package com.byazt.jm;

import com.byazt.ca.yb;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 13})
public class hw {
    public com.byazt.ra.uc.pr c;
    public com.byazt.hg.zo.x uc;
    public int x;
    public int pr = 0;
    public long hw = 0;
    public int hn = -1;

    public int pr(com.byazt.qe.hw hwVar, int i) {
        double d;
        this.x = i;
        int iZo = a.hw().zo(i);
        if (iZo <= 0 || iZo > 3) {
            return iZo;
        }
        com.byazt.hg.zo.hn hnVarPr = com.byazt.hg.zo.pr();
        boolean z = false;
        int iAj = hnVarPr == null ? 0 : hnVarPr.aj();
        com.byazt.hg.zo.x xVarW = hnVarPr == null ? null : hnVarPr.w();
        this.uc = xVarW;
        if (xVarW == null || iAj != 5) {
            return iZo;
        }
        if (xVarW.hw() > 0) {
            try {
                d = Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", hwVar.gz()));
            } catch (Exception e) {
                d = 0.0d;
            }
            if (d > 0.0d && d < this.uc.hw()) {
                this.pr = 1;
                return 1;
            }
        }
        if (this.uc.hn() > 0) {
            switch (yb.hn(a.getContext())) {
                case 2:
                    if ((this.uc.hn() & 1) != 0) {
                        z = true;
                    }
                    break;
                case 3:
                    if ((this.uc.hn() & 2) != 0) {
                        z = true;
                    }
                    break;
                case 4:
                    if ((this.uc.hn() & 16) != 0) {
                        z = true;
                    }
                    break;
                case 5:
                    if ((this.uc.hn() & 4) != 0) {
                        z = true;
                    }
                    break;
                case 6:
                    if ((this.uc.hn() & 8) != 0) {
                        z = true;
                    }
                    break;
            }
            if (z) {
                this.pr = 2;
                return 1;
            }
        }
        this.c = com.byazt.ra.uc.pr(String.valueOf(i), this.uc);
        if (this.uc.x() > 0) {
            this.pr = 3;
            int iPr = this.c.pr(this.uc.x(), this.uc);
            if (iPr > 0) {
                this.hw = System.currentTimeMillis() - ((((long) iPr) * 60) * 1000);
                return 1;
            }
            if (iPr == 0) {
                return 1;
            }
        }
        this.pr = 4;
        pr(this.c.pr(this.uc.c(), this.uc));
        return 2;
    }

    public boolean pr() {
        return this.pr == 4;
    }

    public boolean hw() {
        com.byazt.hg.zo.x xVar;
        if (this.hw > 0 && this.pr == 3) {
            int iPr = -1;
            com.byazt.ra.uc.pr prVar = this.c;
            if (prVar != null && (xVar = this.uc) != null) {
                iPr = prVar.pr(xVar.c(), this.uc);
            }
            pr(iPr);
            this.hn = 2;
            return true;
        }
        return false;
    }

    private void pr(int i) {
        if (i > 0) {
            this.hw = System.currentTimeMillis() - ((((long) i) * 60) * 1000);
        } else if (i == 0) {
            this.hw = 0L;
        } else {
            this.hw = System.currentTimeMillis();
        }
    }
}
