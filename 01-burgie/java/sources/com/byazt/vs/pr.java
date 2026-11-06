package com.byazt.vs;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.jk.hw;
import com.byazt.zs.g;
import com.byazt.zs.uc;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2366, 37})
public class pr {
    public final com.byazt.zs.pr hw;
    public final hw pr;

    public pr(hw hwVar, com.byazt.zs.pr prVar) {
        this.pr = hwVar;
        this.hw = prVar;
    }

    public Object pr(SparseArray sparseArray) {
        Object obj = sparseArray.get(0);
        if (obj instanceof Integer) {
            switch (((Integer) obj).intValue()) {
                case 0:
                    this.hw.pr(true);
                    return null;
                case 1:
                    return Boolean.valueOf(this.hw.hw());
                case 2:
                    return Integer.valueOf(hn(sparseArray));
                case 3:
                    return hw(sparseArray);
                case 4:
                    return Integer.valueOf(uc.pr().hw());
                default:
                    return null;
            }
        }
        return null;
    }

    private Object hw(SparseArray sparseArray) {
        com.byazt.vkw.pr prVarPr;
        Object obj = sparseArray.get(1);
        String str = (String) sparseArray.get(2);
        if (TextUtils.isEmpty(str)) {
            prVarPr = null;
        } else {
            prVarPr = this.hw.pr(str);
        }
        return this.hw.pr((String) obj, prVarPr, false);
    }

    private int hn(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj instanceof String) {
            g gVarPr = this.pr.pr((String) obj);
            if (gVarPr == null || !gVarPr.c) {
                return -1;
            }
            return gVarPr.hn;
        }
        return 0;
    }

    public static int pr(Function function, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public static Object pr(Function function, g gVar, com.byazt.vkw.pr prVar) {
        if (gVar == null) {
            return null;
        }
        int iHn = hn(function);
        if (gVar.vk > 0 && iHn < gVar.vk) {
            return null;
        }
        if (iHn < 7500) {
            return function.apply(gVar.uc);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, gVar.uc);
        if (prVar != null) {
            sparseArray.put(2, prVar.pr());
        }
        return function.apply(sparseArray);
    }

    public static Boolean pr(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Boolean) {
            return (Boolean) objApply;
        }
        return Boolean.FALSE;
    }

    public static Function hw(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -5);
        return (Function) function.apply(sparseArray);
    }

    public static int hn(Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof Integer) {
            return ((Integer) objApply).intValue();
        }
        return -1;
    }
}
