package com.byazt.xlm;

import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static qi pr;

    public static void pr(fw fwVar) {
        fwVar.pr(10);
        c().pr(fwVar);
    }

    public static ExecutorService pr() {
        return c().hw();
    }

    public static void hw(fw fwVar) {
        pr().execute(fwVar);
    }

    public static void pr(fw fwVar, int i) {
        fwVar.pr(i);
        pr().execute(fwVar);
    }

    public static ExecutorService hw() {
        return c().pr();
    }

    public static void hn(fw fwVar) {
        hw().execute(fwVar);
    }

    public static void hw(fw fwVar, int i) {
        fwVar.pr(i);
        c().fw().execute(fwVar);
    }

    public static ExecutorService hn() {
        return pr();
    }

    public static void x(fw fwVar) {
        c().pr(fwVar);
    }

    private static qi c() {
        if (pr == null) {
            pr = (qi) com.byazt.zs.uc.pr("thread_service");
        }
        return pr;
    }

    public static ScheduledExecutorService x() {
        return c().zo();
    }
}
