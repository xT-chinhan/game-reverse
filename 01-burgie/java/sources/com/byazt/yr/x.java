package com.byazt.yr;

import com.byazt.ap.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN, 121})
public class x extends com.byazt.ns.x {
    public final WeakReference<c> pr;

    public x(c cVar) {
        this.pr = new WeakReference<>(cVar);
    }

    @Override // com.byazt.eq.pr
    public void pr() {
        if (this.pr.get() != null) {
            this.pr.get().pr(0);
        }
    }

    @Override // com.byazt.eq.pr
    public void pr(int i, String str) {
        WeakReference<c> weakReference = this.pr;
        if (weakReference != null && weakReference.get() != null) {
            this.pr.get();
        }
    }
}
