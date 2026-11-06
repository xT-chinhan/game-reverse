package com.byazt.hkc;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj {
    public static float n(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<qg.n> n(float f, List<qg.n> list) {
        ArrayList<qg.n> arrayList = new ArrayList();
        Iterator<qg.n> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((qg.n) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (qg.n nVar : arrayList) {
            if (nVar.qg) {
                i = (int) (i + nVar.n);
            } else {
                i2 = (int) (i2 + nVar.n);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (qg.n nVar2 : arrayList) {
                if (!nVar2.qg && nVar2.s != 0.0f && nVar2.n * f4 > nVar2.s) {
                    nVar2.n = nVar2.s;
                    nVar2.qg = true;
                    z2 = true;
                }
                arrayList2.add(nVar2);
            }
            if (z2) {
                return n(f, arrayList2);
            }
        }
        int i3 = 0;
        for (qg.n nVar3 : arrayList) {
            if (nVar3.qg) {
                nVar3.n = n(nVar3.n * f3);
            } else {
                nVar3.n = n(nVar3.n * f4);
            }
            i3 = (int) (i3 + nVar3.n);
        }
        float f5 = i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int size = 0; size < arrayList.size() && f6 > 0.0f; size = (size + 1) % arrayList.size()) {
                qg.n nVar4 = (qg.n) arrayList.get(size);
                if ((f < f2 && nVar4.qg) || (f > f2 && !nVar4.qg)) {
                    nVar4.n += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
