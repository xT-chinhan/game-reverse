package com.byazt.vgx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS, 8})
public class s {
    public static s n;

    public static s n() {
        if (n == null) {
            synchronized (s.class) {
                if (n == null) {
                    n = new s();
                }
            }
        }
        return n;
    }

    public com.byazt.vf.n n(String str) {
        return com.byazt.qp.q.qg(str);
    }

    public static String qg() {
        return com.byazt.vyf.s.cy().ou();
    }

    public static String s() {
        return com.byazt.vyf.s.cy().ou();
    }

    public static String q() {
        return com.byazt.vyf.s.cy().ou();
    }

    public static com.byazt.vf.n l() {
        return com.byazt.qp.q.qg(q());
    }
}
