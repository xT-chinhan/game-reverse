package com.byazt.jo;

import android.util.Pair;
import android.util.SparseArray;
import com.byazt.zs.g;
import com.byazt.zs.k;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2040, 37})
public class pr {
    public final k pr;

    public pr(k kVar) {
        this.pr = kVar;
    }

    public boolean pr(g gVar, Function function) {
        int iPr = com.byazt.vs.pr.pr(function, gVar.uc);
        if (iPr <= gVar.hn) {
            return false;
        }
        gVar.hw(iPr);
        gVar.pr(function);
        return true;
    }

    public void pr(g gVar, com.byazt.zs.pr prVar, Function function) {
        if (!gVar.uc()) {
            return;
        }
        if (!gVar.fw) {
            Object objX = gVar.x();
            if (objX != null) {
                pr(gVar, null, objX, prVar);
                return;
            }
            return;
        }
        for (Map.Entry<com.byazt.vkw.pr, Object> entry : gVar.hn().entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                pr(gVar, entry.getKey(), value, prVar);
            }
        }
    }

    private void pr(g gVar, com.byazt.vkw.pr prVar, Object obj, com.byazt.zs.pr prVar2) {
        int iPr;
        Pair<Function, Object> pairPr = prVar2.fw().pr(gVar, prVar);
        if (pairPr == null || (iPr = com.byazt.vs.pr.pr((Function) pairPr.first, gVar.uc)) <= gVar.pr() || !gVar.hn(iPr) || pairPr.second == null || !(obj instanceof Function) || !(pairPr.second instanceof Function)) {
            return;
        }
        Function function = (Function) obj;
        Function function2 = (Function) pairPr.second;
        if (function.getClass().getClassLoader() == function2.getClass().getClassLoader()) {
            if (this.pr != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("source:").append(obj);
                sb.append(" target:").append(function2);
                sb.append(" classloader:").append(function.getClass().getClassLoader());
                sb.append(" target classloader:").append(function2.getClass().getClassLoader());
                this.pr.pr(gVar, 3, sb.toString(), null);
                return;
            }
            return;
        }
        pr(function, function2);
        gVar.pr(iPr);
        if (this.pr != null) {
            Object obj2 = pairPr.second;
        }
        pr(function, gVar);
    }

    private boolean pr(Function function, g gVar) {
        Function functionHw = com.byazt.vs.pr.hw(function);
        if (functionHw == null) {
            k kVar = this.pr;
            if (kVar != null) {
                kVar.pr(2, "get origin service impl failed:" + gVar.uc, null);
            }
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -1);
        functionHw.apply(sparseArray);
        return true;
    }

    private void pr(Function function, Function function2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, -4);
        sparseArray.put(1, function2);
        function.apply(sparseArray);
    }
}
