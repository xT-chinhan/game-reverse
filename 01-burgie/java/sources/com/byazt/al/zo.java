package com.byazt.al;

import android.graphics.Path;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public final List<com.byazt.ynb.zo> hn;
    public final List<pr<Integer, Integer>> hw;
    public final List<pr<com.byazt.ynb.g, Path>> pr;

    public zo(List<com.byazt.ynb.zo> list) {
        this.hn = list;
        this.pr = new ArrayList(list.size());
        this.hw = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.pr.add(list.get(i).hw().pr());
            this.hw.add(list.get(i).hn().pr());
        }
    }

    public List<com.byazt.ynb.zo> pr() {
        return this.hn;
    }

    public List<pr<com.byazt.ynb.g, Path>> hw() {
        return this.pr;
    }

    public List<pr<Integer, Integer>> hn() {
        return this.hw;
    }
}
