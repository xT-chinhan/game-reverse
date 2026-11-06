package com.byazt.pp;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 33})
public class um {
    public boolean n = false;
    public final Set<Object> qg = new n();
    public final Map<String, com.byazt.nu.fs> s = new HashMap();
    public final Comparator<Pair<String, Float>> q = new Comparator<Pair<String, Float>>() { // from class: com.byazt.pp.um.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    public void n(boolean z) {
        this.n = z;
    }

    public void n(String str, float f) {
        if (this.n) {
            com.byazt.nu.fs fsVar = this.s.get(str);
            if (fsVar == null) {
                fsVar = new com.byazt.nu.fs();
                this.s.put(str, fsVar);
            }
            fsVar.n(f);
            if ("__container".equals(str)) {
                Iterator<Object> it = this.qg.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
