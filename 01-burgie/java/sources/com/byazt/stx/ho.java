package com.byazt.stx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 19})
public class ho {
    public static long pr(List<aj> list) {
        int size = list.size();
        long jC = 0;
        for (int i = 0; i < size; i++) {
            aj ajVar = list.get(i);
            if (ajVar.hn() > jC) {
                break;
            }
            if (ajVar.c() > jC) {
                jC = ajVar.c();
            }
        }
        return jC;
    }

    public static long hw(List<aj> list) {
        long j = 0;
        long jHn = -1;
        long jX = -1;
        for (aj ajVar : list) {
            if (jHn == -1) {
                if (ajVar.pr() > 0) {
                    jHn = ajVar.hn();
                    jX = ajVar.x();
                }
            } else if (ajVar.hn() > jX) {
                j += jX - jHn;
                if (ajVar.pr() > 0) {
                    jHn = ajVar.hn();
                    jX = ajVar.x();
                } else {
                    jHn = -1;
                    jX = -1;
                }
            } else if (ajVar.x() > jX) {
                jX = ajVar.x();
            }
        }
        if (jHn >= 0 && jX > jHn) {
            return j + (jX - jHn);
        }
        return j;
    }
}
