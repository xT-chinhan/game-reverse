package com.bytedance.sdk.component.adexpress.dynamic.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    public static float ms(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<xr.ms> ms(float f, List<xr.ms> list) {
        ArrayList<xr.ms> arrayList = new ArrayList();
        Iterator<xr.ms> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((xr.ms) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (xr.ms msVar : arrayList) {
            if (msVar.xr) {
                i = (int) (i + msVar.f792ms);
            } else {
                i2 = (int) (i2 + msVar.f792ms);
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
            for (xr.ms msVar2 : arrayList) {
                if (!msVar2.xr && msVar2.ah != 0.0f && msVar2.f792ms * f4 > msVar2.ah) {
                    msVar2.f792ms = msVar2.ah;
                    msVar2.xr = true;
                    z2 = true;
                }
                arrayList2.add(msVar2);
            }
            if (z2) {
                return ms(f, arrayList2);
            }
        }
        int i3 = 0;
        for (xr.ms msVar3 : arrayList) {
            if (msVar3.xr) {
                msVar3.f792ms = ms(msVar3.f792ms * f3);
            } else {
                msVar3.f792ms = ms(msVar3.f792ms * f4);
            }
            i3 = (int) (i3 + msVar3.f792ms);
        }
        float f5 = i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int size = 0; size < arrayList.size() && f6 > 0.0f; size = (size + 1) % arrayList.size()) {
                xr.ms msVar4 = (xr.ms) arrayList.get(size);
                if ((f < f2 && msVar4.xr) || (f > f2 && !msVar4.xr)) {
                    msVar4.f792ms += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
