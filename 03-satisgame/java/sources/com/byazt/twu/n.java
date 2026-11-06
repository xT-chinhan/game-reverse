package com.byazt.twu;

import android.util.SparseArray;
import com.byazt.qp.cp;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1641, 19})
public final class n {
    public static void n(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, "ats_chain");
        sparseArray.put(1, n());
        sparseArray.put(2, qg());
        function.apply(sparseArray);
    }

    public static JSONObject n() {
        return cp.n.qg();
    }

    public static JSONObject qg() {
        return cp.n.s();
    }
}
