package com.byazt.kj;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends uc {
    @Override // com.byazt.kj.uc
    public int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar) {
        char cPr;
        int i2 = i;
        while (true) {
            cPr = pr(i2, str);
            if (!com.byazt.ha.pr.hw(cPr) && !com.byazt.ha.pr.hn(cPr)) {
                break;
            }
            i2++;
        }
        if (cPr != '(') {
            return prVar.pr(str, i, deque);
        }
        deque.push(new com.byazt.tki.vk(str.substring(i, i2)));
        return i2 + 1;
    }
}
