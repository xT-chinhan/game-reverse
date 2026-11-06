package com.byazt.rz;

import android.content.Context;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static com.byazt.vl.x n(Context context, Uri uri) {
        return fs.n(context, uri);
    }

    public static com.byazt.vl.x n(Context context, String str) {
        return fs.n(context, str);
    }

    public static com.byazt.vl.x n(Context context, com.byazt.vl.l lVar, String str) {
        return fs.n(context, lVar, str);
    }

    public static com.byazt.vl.x n(String str) {
        return qg(com.byazt.ug.d.getContext(), str);
    }

    public static com.byazt.vl.x qg(Context context, String str) {
        return fs.qg(context, str);
    }

    public static com.byazt.vl.x n(Context context, String str, com.byazt.h.n nVar) {
        return fs.n(context, str, nVar);
    }

    public static com.byazt.vl.x n(String str, com.byazt.h.n nVar) {
        return fs.qg(str, nVar);
    }

    public static com.byazt.vl.x n(com.byazt.h.qg qgVar, String str, String str2) {
        return fs.n(qgVar, str, str2);
    }

    public static boolean s(Context context, String str) {
        return fs.s(context, str);
    }
}
