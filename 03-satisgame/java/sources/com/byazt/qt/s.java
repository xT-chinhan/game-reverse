package com.byazt.qt;

import android.text.TextUtils;
import com.byazt.vy.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, 8})
public class s {
    public static String n;
    public static String qg;

    public static String n() {
        return m.n(l() + "/api/ad/union/mediation/config/");
    }

    public static String qg() {
        return m.n("https://" + qg.n().um());
    }

    public static String s() {
        return m.n(l() + "/api/ad/union/mediation/exchange/");
    }

    public static String q() {
        return m.n(l() + "/api/ad/union/mediation/reward_video/reward/");
    }

    private static String l() {
        String strW = w();
        return !TextUtils.isEmpty(strW) ? strW : "https://gromore.pangolin-sdk-toutiao.com";
    }

    private static String w() {
        String string = com.byazt.ri.n.n().getString("server_dist_host", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if (TextUtils.equals(string, n) && !TextUtils.isEmpty(qg)) {
            return qg;
        }
        n = string;
        qg = null;
        if (!TextUtils.isEmpty(string)) {
            qg = com.byazt.vy.n.qg(n, com.byazt.vy.qg.n());
        }
        if (TextUtils.isEmpty(qg)) {
            return null;
        }
        String str = "https://" + qg;
        qg = str;
        return str;
    }
}
