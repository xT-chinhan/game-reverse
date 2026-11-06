package com.byazt.gs;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 20})
public class hn {
    public static String[] pr(File file) {
        String[] strArrPr = com.byazt.ii.hw.pr(file);
        if (TextUtils.isEmpty(strArrPr[0])) {
            return com.byazt.ii.pr.pr(file);
        }
        return strArrPr;
    }
}
