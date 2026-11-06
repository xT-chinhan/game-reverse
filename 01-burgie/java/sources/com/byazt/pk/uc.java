package com.byazt.pk;

import android.content.Context;
import com.byazt.hg.e;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME, 5})
public class uc {
    public static volatile uc pr;
    public final com.byazt.tf.hw hn;
    public com.byazt.oz.pr hw;

    public static uc pr() {
        if (pr == null) {
            synchronized (uc.class) {
                if (pr == null) {
                    com.byazt.qr.pr.pr().pr(com.byazt.mp.hn.pr().uc() != 2);
                    pr = new uc(a.getContext());
                }
            }
        }
        return pr;
    }

    private uc(Context context) {
        com.byazt.tf.hw hwVarPr = new com.byazt.tf.hw.pr().pr(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).hw(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).hn(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).pr(new hw.pr()).pr(e.pr()).pr(e.hw()).pr(true).pr();
        this.hn = hwVarPr;
        com.byazt.nzn.x xVarPr = hwVarPr.pr().pr();
        if (xVarPr != null) {
            xVarPr.pr(32);
            xVarPr.hw(com.byazt.mp.hn.pr().c());
        }
    }

    public com.byazt.tf.hw hw() {
        return this.hn;
    }

    public com.byazt.oz.pr hn() {
        x();
        return this.hw;
    }

    private void x() {
        if (this.hw == null) {
            this.hw = new com.byazt.oz.pr();
        }
    }
}
