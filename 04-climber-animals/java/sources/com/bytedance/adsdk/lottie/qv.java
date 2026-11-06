package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class qv {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f269ms = false;
    private final Set<Object> xr = new ms();
    private final Map<String, com.bytedance.adsdk.lottie.ka.ab> ah = new HashMap();
    private final Comparator<Pair<String, Float>> d = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.lottie.qv.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    void ms(boolean z) {
        this.f269ms = z;
    }

    public void ms(String str, float f) {
        if (this.f269ms) {
            com.bytedance.adsdk.lottie.ka.ab abVar = this.ah.get(str);
            if (abVar == null) {
                abVar = new com.bytedance.adsdk.lottie.ka.ab();
                this.ah.put(str, abVar);
            }
            abVar.ms(f);
            if (str.equals("__container")) {
                Iterator<Object> it = this.xr.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
