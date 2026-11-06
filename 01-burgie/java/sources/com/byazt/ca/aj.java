package com.byazt.ca;

import android.os.Handler;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 61})
public class aj {
    public static volatile Handler hn;
    public static volatile Handler hw;
    public static volatile Handler pr;

    public static Handler pr() {
        Handler handlerX;
        if (hw == null && (handlerX = ((qi) com.byazt.zs.uc.pr("thread_service")).x()) != null) {
            hw = handlerX;
        }
        return hw;
    }

    public static Handler hw() {
        if (pr == null) {
            pr = ((qi) com.byazt.zs.uc.pr("thread_service")).uc();
        }
        return pr;
    }

    public static Handler hn() {
        Handler handlerC;
        if (hn == null && (handlerC = ((qi) com.byazt.zs.uc.pr("thread_service")).c()) != null) {
            hn = handlerC;
        }
        return hn;
    }
}
