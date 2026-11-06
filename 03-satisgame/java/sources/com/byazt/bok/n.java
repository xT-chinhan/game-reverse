package com.byazt.bok;

import com.byazt.wea.fs;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 19})
public abstract class n<T, F extends fs> {
    public final List<l<?>> n = new CopyOnWriteArrayList();
    public T qg;
    public F s;

    public final void n(l<?> lVar) {
        if (lVar != null) {
            this.n.add(lVar);
        }
    }

    public final void qg(l<?> lVar) {
        if (lVar != null) {
            this.n.remove(lVar);
        }
    }

    public final F getContext() {
        return this.s;
    }
}
