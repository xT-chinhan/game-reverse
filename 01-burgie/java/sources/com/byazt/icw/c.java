package com.byazt.icw;

import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.ea.w;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends hn {
    public c(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, com.byazt.ax.hw hwVar, com.byazt.ax.c cVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, hwVar, cVar, z);
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void hn(View view) {
        super.hn(view);
        this.uc.hn("playable");
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void hw(View view) {
        super.hw(view);
        if (lb.x(this.hw)) {
            this.uc.s();
        } else {
            this.uc.ls();
        }
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void pr(View view) {
        super.pr(view);
        if (pr()) {
            return;
        }
        this.uc.f().pr();
        if (lb.m(this.hw) || w.c(this.hw) || w.x(this.hw)) {
            this.uc.vk();
            return;
        }
        vk vkVar = new vk() { // from class: com.byazt.icw.c.1
            @Override // com.byazt.wv.vk
            public void hw() {
                c.this.uc.ho();
                c.this.uc.hw();
            }
        };
        if (pr(vkVar)) {
            this.fw--;
        } else {
            vkVar.hw();
        }
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void uc(View view) {
        super.uc(view);
        if (w.c(this.hw) || w.x(this.hw)) {
            this.uc.vk();
        } else {
            pr();
        }
    }
}
