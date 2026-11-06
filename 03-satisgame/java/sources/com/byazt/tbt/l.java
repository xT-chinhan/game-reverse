package com.byazt.tbt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1089, 18})
public final class l extends k {
    public List<String> n;
    public List<String> qg;

    public l(List<String> list, List<String> list2) {
        this.n = list;
        this.qg = list2;
    }

    @com.byazt.cp.n(n = {0, 1, 1089, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static final class n {
        public final List<String> n = new ArrayList();
        public final List<String> qg = new ArrayList();

        public n n(String str, String str2) {
            this.n.add(str);
            this.qg.add(str2);
            return this;
        }

        public l n() {
            return new l(this.n, this.qg);
        }
    }
}
