package com.byazt.pe;

import com.byazt.hg.of;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 5})
public class uc<T> implements c<T> {
    public final c<T> pr;

    public uc(c<T> cVar) {
        this.pr = cVar;
    }

    @Override // com.byazt.pe.c
    public void pr(final T t, final boolean z, final of ofVar) {
        zo.pr(new Runnable() { // from class: com.byazt.pe.uc.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (uc.this.pr != null) {
                    uc.this.pr.pr(t, z, ofVar);
                }
            }
        });
    }

    @Override // com.byazt.pe.c
    public void pr(final T t) {
        zo.pr(new Runnable() { // from class: com.byazt.pe.uc.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (uc.this.pr != null) {
                    uc.this.pr.pr(t);
                }
            }
        });
    }

    @Override // com.byazt.pe.c
    public void pr(final int i, final String str) {
        zo.pr(new Runnable() { // from class: com.byazt.pe.uc.3
            @Override // java.lang.Runnable
            public void run() {
                if (uc.this.pr != null) {
                    uc.this.pr.pr(i, str);
                }
            }
        });
    }
}
