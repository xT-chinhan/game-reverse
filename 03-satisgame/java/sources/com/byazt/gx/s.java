package com.byazt.gx;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 8})
public class s {
    public static String[] n(File file) {
        String[] strArrN = com.byazt.iq.qg.n(file);
        return TextUtils.isEmpty(strArrN[0]) ? com.byazt.iq.n.n(file) : strArrN;
    }
}
