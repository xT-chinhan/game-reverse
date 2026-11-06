package com.byazt.jx;

import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 5})
public class uc implements x {
    public hn hw;
    public List<x> pr = new ArrayList();

    public uc() {
        hn hnVar = new hn(a.hw().ku());
        this.hw = hnVar;
        this.pr.add(new c(hnVar));
        this.pr.add(new fw(this.hw));
    }

    @Override // com.byazt.jx.x
    public boolean pr(com.byazt.vo.pr prVar) {
        Iterator<x> it = this.pr.iterator();
        while (it.hasNext()) {
            if (it.next().pr(prVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.jx.x
    public boolean hw(com.byazt.vo.pr prVar) {
        Iterator<x> it = this.pr.iterator();
        while (it.hasNext()) {
            if (it.next().hw(prVar)) {
                return true;
            }
        }
        return false;
    }
}
