package com.byazt.yl;

import android.util.SparseArray;
import java.io.File;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1845, 19})
public class n implements l, Function {
    public final com.byazt.jro.qg n = new com.byazt.jro.qg();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object qVar = sparseArray.get(1);
            if (qVar != null) {
                qVar = new q((Function) qVar);
            }
            qg qgVarN = n((s) qVar);
            return qgVarN != null ? new x(qgVarN) : qgVarN;
        }
        if (iIntValue == 2) {
            qg qgVarN2 = n((File) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue());
            return qgVarN2 != null ? new x(qgVarN2) : qgVarN2;
        }
        if (iIntValue != 3) {
            return null;
        }
        Object qVar2 = sparseArray.get(1);
        if (qVar2 != null) {
            qVar2 = new q((Function) qVar2);
        }
        return Boolean.valueOf(qg((s) qVar2));
    }

    @Override // com.byazt.yl.l
    public qg n(s sVar) {
        return this.n.n(sVar);
    }

    @Override // com.byazt.yl.l
    public qg n(final File file, final long j) {
        return this.n.n(new s() { // from class: com.byazt.yl.n.1
            @Override // com.byazt.yl.s
            public File n() {
                return file;
            }

            @Override // com.byazt.yl.s
            public long qg() {
                return j;
            }
        });
    }

    @Override // com.byazt.yl.l
    public boolean qg(s sVar) {
        return this.n.qg(sVar);
    }
}
