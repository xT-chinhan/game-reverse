package com.byazt.yb;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 86})
public final class cd {
    public static hd n(Context context) {
        if (com.byazt.sd.n.cd()) {
            return new ou(new h());
        }
        if (com.byazt.sd.n.um() && h.n()) {
            return new h();
        }
        if (py.n()) {
            return new py(context);
        }
        if (com.byazt.sd.n.d() && com.byazt.sd.n.oa()) {
            return new rv();
        }
        if (com.byazt.sd.n.d() && !com.byazt.sd.n.oa()) {
            return new d();
        }
        if (com.byazt.sd.n.n(context) || com.byazt.sd.n.d()) {
            return new rv();
        }
        if (com.byazt.sd.n.ou()) {
            return new ou();
        }
        if (com.byazt.sd.n.py()) {
            return new sz();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (com.byazt.sd.n.wm()) {
                return new m();
            }
            if (com.byazt.sd.n.hu()) {
                return new k();
            }
            if (com.byazt.sd.n.m()) {
                return new oa();
            }
            if (com.byazt.sd.n.h()) {
                return new n();
            }
            w wVar = new w(context);
            return wVar.qg(context) ? wVar : new l();
        }
        if (com.byazt.sd.n.sz() || !rv.n(context)) {
            return null;
        }
        return new rv();
    }
}
