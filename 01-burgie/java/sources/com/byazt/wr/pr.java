package com.byazt.wr;

import android.content.Context;
import com.byazt.af.aj;
import com.byazt.ca.b;
import com.byazt.ca.yb;
import com.byazt.hg.qa;
import com.byazt.sd.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME, 37})
public abstract class pr {
    public aj hw;
    public Context pr;
    public boolean hn = true;
    public int x = 0;
    public boolean c = false;

    public abstract boolean hn();

    public void pr(Context context) {
        this.pr = context;
    }

    public void pr(aj ajVar) {
        this.hw = ajVar;
    }

    public void pr(boolean z) {
        this.hn = z;
    }

    public void hw(boolean z) {
        this.c = z;
    }

    public boolean pr() {
        Context context;
        if (this.hw == null || (context = this.pr) == null) {
            this.x = 10;
            return true;
        }
        if (!this.hn) {
            return false;
        }
        if (yb.hn(context) == 0) {
            try {
                b.pr(this.pr, "\"无网络，请稍后再试\"", 0);
            } catch (Throwable th) {
            }
        }
        boolean zHn = hn();
        if (zHn) {
            uc.pr = true;
            uc.hn = true;
        }
        return zHn;
    }

    public int hw() {
        return this.x;
    }

    public int x() {
        int iHn = yb.hn(this.pr);
        aj ajVar = this.hw;
        if (ajVar == null) {
            return -1;
        }
        switch (qa.x(ajVar.z_())) {
            case -1:
                return !zo.nt().hn(iHn) ? 11 : -1;
            case 0:
                return -1;
            case 1:
            default:
                if (zo.nt().hn(iHn)) {
                    return -1;
                }
                int iFw = 104857600;
                com.byazt.hg.c cVarHo = this.hw.ho();
                if (cVarHo != null && cVarHo.fw() > 0) {
                    iFw = cVarHo.fw();
                }
                return iFw > qa.c(this.hw.z_()) ? 14 : -1;
            case 2:
                return iHn != 4 ? 12 : -1;
            case 3:
                return 13;
        }
    }
}
