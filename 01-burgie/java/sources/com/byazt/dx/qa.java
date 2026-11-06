package com.byazt.dx;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 101})
public class qa {
    public boolean pr = false;
    public final Set<Object> hw = new pr();
    public final Map<String, com.byazt.ptr.zo> hn = new HashMap();
    public final Comparator<Pair<String, Float>> x = new Comparator<Pair<String, Float>>() { // from class: com.byazt.dx.qa.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            if (fFloatValue > fFloatValue2) {
                return -1;
            }
            return 0;
        }
    };

    public void pr(boolean z) {
        this.pr = z;
    }

    public void pr(String str, float f) {
        if (!this.pr) {
            return;
        }
        com.byazt.ptr.zo zoVar = this.hn.get(str);
        if (zoVar == null) {
            zoVar = new com.byazt.ptr.zo();
            this.hn.put(str, zoVar);
        }
        zoVar.pr(f);
        if ("__container".equals(str)) {
            Iterator<Object> it = this.hw.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
