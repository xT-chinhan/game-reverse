package com.byazt.ttf;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2093, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr((JSONObject) sparseArray.get(1));
            default:
                return null;
        }
    }

    @Override // com.byazt.ttf.pr
    public JSONObject pr(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, jSONObject);
        return (JSONObject) this.pr.apply(sparseArray);
    }
}
