package com.byazt.icw;

import android.view.View;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.lu.zo;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR, 5})
public class uc extends hn {
    public uc(TTBaseVideoActivity tTBaseVideoActivity, of ofVar, com.byazt.ax.hw hwVar, com.byazt.ax.c cVar, boolean z) {
        super(tTBaseVideoActivity, ofVar, hwVar, cVar, z);
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void hn(View view) {
        super.hn(view);
        this.uc.hn("video_player");
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void hw(View view) {
        super.hw(view);
        if (this.uc.bm() instanceof zo) {
            this.uc.ls();
        }
        this.uc.s();
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void pr(View view) {
        super.pr(view);
        if (pr()) {
            return;
        }
        this.uc.f().pr();
        if (this.uc.bm().f()) {
            hw();
        } else {
            hn();
        }
    }

    private void hw() {
        vk vkVar = new vk() { // from class: com.byazt.icw.uc.1
            @Override // com.byazt.wv.vk
            public void hw() {
                uc.this.uc.ho();
                uc.this.uc.er().postDelayed(new Runnable() { // from class: com.byazt.icw.uc.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        uc.this.uc.hw();
                    }
                }, 100L);
            }
        };
        int i = 2;
        int iC = this.uc.c(2);
        if (this.hw.sq() == 7) {
            if (this.hw.rr() && !this.uc.jn()) {
                i = 1;
            }
            iC = i;
        }
        if (iC == 1) {
            if (pr(vkVar)) {
                return;
            }
            vkVar.hw();
            return;
        }
        this.uc.hn();
    }

    private void hn() {
        vk vkVar = new vk() { // from class: com.byazt.icw.uc.2
            @Override // com.byazt.wv.vk
            public void hw() {
                uc.this.uc.hn();
            }
        };
        if (pr(vkVar)) {
            return;
        }
        vkVar.hw();
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void uc(View view) {
        super.uc(view);
        pr(view);
    }

    @Override // com.byazt.icw.hn, com.byazt.icw.hw
    public void fw(View view) {
        super.fw(view);
        this.uc.sv();
    }
}
