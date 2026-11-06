package com.byazt.kj;

import com.byazt.tki.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1571, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends uc {
    @Override // com.byazt.kj.uc
    public int pr(String str, int i, Deque<com.byazt.awu.pr> deque, com.byazt.gb.pr prVar) {
        if (!com.byazt.ha.pr.x(pr(i, str))) {
            return prVar.pr(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{pr(i, str), pr(i2, str)});
        if (com.byazt.yiq.hn.pr(str2) != null) {
            deque.push(new nt(com.byazt.yiq.hn.pr(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(pr(i, str));
        if (com.byazt.yiq.hn.pr(strValueOf) != null) {
            deque.push(new nt(com.byazt.yiq.hn.pr(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
