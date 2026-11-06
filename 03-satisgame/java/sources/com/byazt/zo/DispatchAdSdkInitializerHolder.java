package com.byazt.zo;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.vf.py;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 588, 2175})
public class DispatchAdSdkInitializerHolder implements py, Function {
    public static volatile Object n;
    public static com.byazt.vyf.n qg;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        return getDispatchAdSdkInitializer((Bundle) sparseArray.get(1), sparseArray.get(2));
    }

    @Override // com.byazt.vf.py
    public Object getDispatchAdSdkInitializer(Bundle bundle, Object obj) {
        com.byazt.vyf.n nVar = (com.byazt.vyf.n) obj;
        qg = nVar;
        if (n == null) {
            synchronized (DispatchAdSdkInitializerHolder.class) {
                if (n == null) {
                    n = new oa(bundle, nVar);
                }
            }
        }
        return n;
    }

    public static com.byazt.vyf.x getCsjManger() {
        com.byazt.vyf.n nVar = qg;
        if (nVar != null) {
            return nVar.qg();
        }
        return null;
    }

    public static boolean isInitSuccess() {
        com.byazt.vyf.n nVar = qg;
        return nVar != null && nVar.n();
    }

    public static com.byazt.yn.n getCsjLoader(Context context) {
        if (getCsjManger() != null) {
            return getCsjManger().n(context);
        }
        return null;
    }
}
