package com.byazt.nzn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 37})
public final class pr {
    public final boolean pr;

    public pr(C0150pr c0150pr) {
        this.pr = c0150pr.pr;
    }

    /* JADX INFO: renamed from: com.byazt.nzn.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static final class C0150pr {
        public boolean pr;

        public C0150pr pr() {
            this.pr = true;
            return this;
        }

        public pr hw() {
            return new pr(this);
        }
    }
}
