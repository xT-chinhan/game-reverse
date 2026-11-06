package com.byazt.qit;

import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 18})
public class l {
    public static wo n;

    public static void n(x xVar) {
        xVar.setPriority(10);
        l().n(xVar);
    }

    public static ExecutorService n() {
        return l().qg();
    }

    public static void qg(x xVar) {
        n().execute(xVar);
    }

    public static void n(x xVar, int i) {
        xVar.setPriority(i);
        n().execute(xVar);
    }

    public static ExecutorService qg() {
        return l().n();
    }

    public static void s(x xVar) {
        qg().execute(xVar);
    }

    public static void qg(x xVar, int i) {
        xVar.setPriority(i);
        l().x().execute(xVar);
    }

    public static ExecutorService s() {
        return n();
    }

    public static void q(x xVar) {
        l().n(xVar);
    }

    private static wo l() {
        if (n == null) {
            n = (wo) com.byazt.qp.q.n("thread_service");
        }
        return n;
    }

    public static ScheduledExecutorService q() {
        return l().fs();
    }
}
