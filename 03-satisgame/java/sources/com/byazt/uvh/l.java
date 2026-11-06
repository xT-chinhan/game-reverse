package com.byazt.uvh;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 576, 18})
public final class l {
    public final s[] n = new s[4096];
    public int qg;
    public int s;

    public synchronized void n(s sVar) {
        if (sVar == null) {
            return;
        }
        s[] sVarArr = this.n;
        int i = this.qg;
        sVarArr[i] = sVar;
        int i2 = i + 1;
        this.qg = i2;
        if (i2 >= sVarArr.length) {
            this.qg = 0;
        }
        int i3 = this.s;
        if (i3 < sVarArr.length) {
            this.s = i3 + 1;
        }
    }

    public synchronized List<s> n(long j, long j2) {
        int i;
        ArrayList arrayList = new ArrayList();
        if (j2 > j && (i = this.s) > 0) {
            int length = this.qg - i;
            if (length < 0) {
                length += this.n.length;
            }
            for (int i2 = 0; i2 < this.s; i2++) {
                int length2 = length + i2;
                s[] sVarArr = this.n;
                if (length2 >= sVarArr.length) {
                    length2 -= sVarArr.length;
                }
                s sVar = sVarArr[length2];
                if (sVar != null) {
                    long jS = sVar.s();
                    if (jS > j && jS <= j2) {
                        arrayList.add(sVar);
                    }
                }
            }
            return arrayList;
        }
        return arrayList;
    }
}
