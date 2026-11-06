package com.byazt.gr;

import com.byakv.b.YogaNative;
import com.byakv.b.YogaNodeJNIBase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, 113})
public class d extends YogaNodeJNIBase {
    public void finalize() throws Throwable {
        try {
            sz();
        } finally {
            super.finalize();
        }
    }

    public void sz() {
        if (this.n != 0) {
            long j = this.n;
            this.n = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}
