package com.byazt.bf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN, 13})
public class w {
    public static long n(long j) {
        Date date;
        Date date2 = new Date();
        int minutes = date2.getMinutes();
        if (j >= 3600000 || minutes <= 30) {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 0, 0);
        } else {
            date = new Date(date2.getYear(), date2.getMonth(), date2.getDate(), date2.getHours(), 30, 0);
        }
        return n(date.getTime(), j);
    }

    private static long n(long j, long j2) {
        Date date = new Date(j2 + j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        com.byazt.rb.qg.n("TTMediationSDK_IntervalEffectiveTime", "old time " + j + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }

    public static String qg(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }
}
