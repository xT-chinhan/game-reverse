package com.byazt.nzn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c extends ho {
    public List<String> hw;
    public List<String> pr;

    public c(List<String> list, List<String> list2) {
        this.pr = list;
        this.hw = list2;
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 169})
    public static final class pr {
        public final List<String> pr = new ArrayList();
        public final List<String> hw = new ArrayList();

        public pr pr(String str, String str2) {
            this.pr.add(str);
            this.hw.add(str2);
            return this;
        }

        public c pr() {
            return new c(this.pr, this.hw);
        }
    }
}
