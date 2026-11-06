package com.byazt.la;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1119, 250})
public class k implements w, Function {
    public volatile w hw;
    public volatile Function pr;

    public k(w wVar) {
        this.hw = wVar;
    }

    public k(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object obj2 = sparseArray.get(1);
                Object obj3 = sparseArray.get(2);
                Object obj4 = sparseArray.get(3);
                Object xVar = sparseArray.get(4);
                Object obj5 = sparseArray.get(5);
                Object vkVar = sparseArray.get(6);
                if (xVar != null) {
                    xVar = new x((Function) xVar);
                }
                if (vkVar != null) {
                    vkVar = new vk((Function) vkVar);
                }
                this.hw.pr((String) obj2, ((Boolean) obj3).booleanValue(), ((Long) obj4).longValue(), (hn) xVar, (JSONObject) obj5, (aj) vkVar);
                break;
        }
        return null;
    }

    @Override // com.byazt.la.w
    public void pr(String str, boolean z, long j, hn hnVar, JSONObject jSONObject, aj ajVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, Long.valueOf(j));
        if (hnVar != null) {
            hnVar = new x(hnVar);
        }
        sparseArray.put(4, hnVar);
        sparseArray.put(5, jSONObject);
        if (ajVar != null) {
            ajVar = new vk(ajVar);
        }
        sparseArray.put(6, ajVar);
        this.pr.apply(sparseArray);
    }
}
