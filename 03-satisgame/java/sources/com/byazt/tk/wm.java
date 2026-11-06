package com.byazt.tk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public abstract class wm {
    public final ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Runnable>> n = new ConcurrentHashMap<>();

    public abstract boolean n(int i);

    public void n(int i, int i2, Runnable runnable) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap = this.n.get(Integer.valueOf(i));
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.n.put(Integer.valueOf(i), concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(i2), runnable);
    }

    public void n(int i, int i2) {
        ConcurrentHashMap<Integer, Runnable> concurrentHashMap;
        if (i <= 0 || i2 <= 0 || (concurrentHashMap = this.n.get(Integer.valueOf(i))) == null) {
            return;
        }
        concurrentHashMap.remove(Integer.valueOf(i2));
    }

    public void qg(int i) {
        this.n.remove(Integer.valueOf(i));
    }

    public void s(int i) {
        Runnable value;
        ConcurrentHashMap<Integer, Runnable> concurrentHashMapRemove = this.n.remove(Integer.valueOf(i));
        if (concurrentHashMapRemove != null) {
            for (Map.Entry<Integer, Runnable> entry : concurrentHashMapRemove.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.run();
                }
            }
        }
    }
}
