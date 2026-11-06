package com.byazt.xb;

import android.os.Bundle;
import android.util.SparseArray;
import com.anythink.core.common.m.a.m;
import com.byazt.qp.q;
import com.byazt.vf.rv;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, m.h, 26})
public class qg implements Function {
    public static volatile qg n;

    private qg() {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        if (!(obj instanceof SparseArray)) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(-99999987)).intValue() != 1) {
            return null;
        }
        Bundle bundle = (Bundle) sparseArray.get(0);
        rv rvVar = (rv) q.n("boost");
        if (rvVar != null) {
            return rvVar.n(bundle);
        }
        return null;
    }
}
