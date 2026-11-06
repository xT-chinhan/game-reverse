package com.byazt.av;

import android.os.Looper;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.compliance.constants.ComplianceMessage;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, ComplianceMessage.OPEN_ALERT_TIP, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public abstract class c implements x {
    public final com.byazt.kbl.hn hn;
    public final com.byazt.hh.hw hw;

    public c(com.byazt.hh.hw hwVar, com.byazt.kbl.hn hnVar) {
        this.hw = hwVar;
        this.hn = hnVar;
    }

    public void x() {
        hn();
    }

    public Looper c() {
        return ((qi) com.byazt.zs.uc.pr("thread_service")).x().getLooper();
    }
}
