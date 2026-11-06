package com.byazt.uko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 931, 50})
public class vk {
    public static float pr(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<hw.pr> pr(float f, List<hw.pr> list) {
        ArrayList<hw.pr> arrayList = new ArrayList();
        Iterator<hw.pr> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((hw.pr) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (hw.pr prVar : arrayList) {
            if (prVar.hw) {
                i = (int) (i + prVar.pr);
            } else {
                i2 = (int) (i2 + prVar.pr);
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
            for (hw.pr prVar2 : arrayList) {
                if (!prVar2.hw && prVar2.hn != 0.0f && prVar2.pr * f4 > prVar2.hn) {
                    prVar2.pr = prVar2.hn;
                    prVar2.hw = true;
                    z2 = true;
                }
                arrayList2.add(prVar2);
            }
            if (z2) {
                return pr(f, arrayList2);
            }
        }
        int i3 = 0;
        for (hw.pr prVar3 : arrayList) {
            if (prVar3.hw) {
                prVar3.pr = pr(prVar3.pr * f3);
            } else {
                prVar3.pr = pr(prVar3.pr * f4);
            }
            i3 = (int) (i3 + prVar3.pr);
        }
        float f5 = i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int size = 0; size < arrayList.size() && f6 > 0.0f; size = (size + 1) % arrayList.size()) {
                hw.pr prVar4 = (hw.pr) arrayList.get(size);
                if ((f < f2 && prVar4.hw) || (f > f2 && !prVar4.hw)) {
                    prVar4.pr += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
