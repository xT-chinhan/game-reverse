package com.byazt.fty;

import com.byakv.k.YogaNative;
import com.byakv.k.YogaNodeJNIBase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME, 250})
public class k extends YogaNodeJNIBase {
    public void finalize() throws Throwable {
        try {
            m();
        } finally {
            super.finalize();
        }
    }

    public void m() {
        if (this.pr != 0) {
            long j = this.pr;
            this.pr = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
