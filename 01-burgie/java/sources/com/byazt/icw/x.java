package com.byazt.icw;

import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 121})
public class x extends hn {
    public x(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, com.byazt.ax.hw hwVar, com.byazt.ax.c cVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, hwVar, cVar, z);
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void hn(View view) {
        super.hn(view);
        this.uc.hn(this.x.ls());
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void hw(View view) {
        super.hw(view);
        this.uc.ls();
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void pr(View view) {
        super.pr(view);
        if (pr()) {
            return;
        }
        this.uc.f().hw();
        if (this.x.v()) {
            this.uc.hw();
        } else if (this.uc.bm().f()) {
            hw();
        } else {
            hn();
        }
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void uc(View view) {
        super.uc(view);
        pr(view);
    }

    private void hw() {
        vk vkVar = new vk() { // from class: com.byazt.icw.x.1
            @Override // com.byazt.wv.vk
            public void hw() {
                x.this.uc.hw();
            }
        };
        if (pr(vkVar)) {
            this.fw--;
        } else {
            vkVar.hw();
        }
    }

    private void hn() {
        this.uc.hw();
    }

    @Override // com.byazt.icw.hn
    public boolean pr(vk vkVar) {
        if (this.hn != null) {
            return this.uc.hw(this.hn, vkVar);
        }
        return this.uc.hw(this.hw, vkVar);
    }
}
