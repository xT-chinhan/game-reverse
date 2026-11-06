package com.byazt.sd;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 23, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.wt.pr.hw {
    public final Map<Integer, WeakReference<com.byazt.wt.pr.hw>> pr = new HashMap();

    public void pr(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        function.apply(com.byazt.xi.hw.pr().pr(9).pr(Boolean.class).pr(0, new com.byazt.ofr.pr() { // from class: com.byazt.sd.c.1
            @Override // com.byazt.ofr.pr
            public void pr() {
                c.this.pr();
            }

            @Override // com.byazt.ofr.pr
            public void hw() {
                c.this.hw();
            }
        }).hw());
    }

    public void pr(com.byazt.wt.pr.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        this.pr.put(Integer.valueOf(hwVar.hashCode()), new WeakReference<>(hwVar));
    }

    public void hw(com.byazt.wt.pr.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        this.pr.remove(Integer.valueOf(hwVar.hashCode()));
    }

    @Override // com.byazt.wt.pr.hw
    public void pr() {
        Iterator<Map.Entry<Integer, WeakReference<com.byazt.wt.pr.hw>>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.byazt.wt.pr.hw> value = it.next().getValue();
            if (value != null) {
                com.byazt.wt.pr.hw hwVar = value.get();
                if (hwVar != null) {
                    hwVar.pr();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // com.byazt.wt.pr.hw
    public void hw() {
        Iterator<Map.Entry<Integer, WeakReference<com.byazt.wt.pr.hw>>> it = this.pr.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<com.byazt.wt.pr.hw> value = it.next().getValue();
            if (value != null) {
                com.byazt.wt.pr.hw hwVar = value.get();
                if (hwVar != null) {
                    hwVar.hw();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // com.byazt.wt.pr.hw
    public void hn() {
    }

    @Override // com.byazt.wt.pr.hw
    public void x() {
    }
}
