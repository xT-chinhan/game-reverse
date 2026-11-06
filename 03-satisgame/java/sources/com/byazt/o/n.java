package com.byazt.o;

import android.content.Context;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY, 19})
public abstract class n implements l {
    public final Context n;
    public final com.byazt.f.n qg;
    public final String s;

    public n(Context context, com.byazt.f.n nVar, String str) {
        this.n = context;
        this.qg = nVar;
        this.s = str;
    }

    public boolean n() {
        if (this.n == null) {
            return false;
        }
        try {
            return qg().resolveActivity(this.n.getPackageManager()) != null;
        } catch (Throwable th) {
            if (com.byazt.fe.n.n()) {
                k.n("AbsDevicePlan", "check is valid failed!", th);
            }
        }
    }
}
