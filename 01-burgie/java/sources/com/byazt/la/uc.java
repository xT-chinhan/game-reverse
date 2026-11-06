package com.byazt.la;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1119, 5})
public class uc implements c, Function {
    public volatile c hw;
    public volatile Function pr;

    public uc(c cVar) {
        this.hw = cVar;
    }

    public uc(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.la.c
    public void aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        this.pr.apply(sparseArray);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object obj2 = sparseArray.get(1);
                Object xVar = sparseArray.get(2);
                if (xVar != null) {
                    xVar = new x((Function) xVar);
                }
                this.hw.pr(((Boolean) obj2).booleanValue(), (hn) xVar);
                return null;
            case 2:
                return this.hw.pr();
            case 3:
                return Boolean.valueOf(this.hw.hw());
            case 4:
                return Integer.valueOf(this.hw.hn());
            case 5:
                return this.hw.x();
            case 6:
                return Boolean.valueOf(this.hw.c());
            case 7:
                return this.hw.uc();
            case 8:
                this.hw.pr((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                return null;
            case 9:
                return this.hw.fw();
            case 10:
                return this.hw.zo();
            case 11:
                this.hw.aj();
                return null;
            case 12:
            case 13:
            case 14:
            default:
                return null;
            case 15:
                com.byazt.vkw.pr prVarVk = this.hw.vk();
                return prVarVk != null ? new com.byazt.vkw.hw(prVarVk) : prVarVk;
            case 16:
                Object obj3 = sparseArray.get(1);
                Object xVar2 = sparseArray.get(2);
                Object obj4 = sparseArray.get(3);
                if (xVar2 != null) {
                    xVar2 = new x((Function) xVar2);
                }
                this.hw.pr(((Boolean) obj3).booleanValue(), (hn) xVar2, (JSONObject) obj4);
                return null;
        }
    }

    @Override // com.byazt.la.c
    public boolean c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.la.c
    public String fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.c
    public int hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.la.c
    public boolean hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.la.c
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.c
    public void pr(String str, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.c
    public void pr(boolean z, hn hnVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Boolean.valueOf(z));
        if (hnVar != null) {
            hnVar = new x(hnVar);
        }
        sparseArray.put(2, hnVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.c
    public void pr(boolean z, hn hnVar, JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, Boolean.valueOf(z));
        if (hnVar != null) {
            hnVar = new x(hnVar);
        }
        sparseArray.put(2, hnVar);
        sparseArray.put(3, jSONObject);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.c
    public String uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.la.c
    public com.byazt.vkw.pr vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        ?? Apply = this.pr.apply(sparseArray);
        ?? hwVar = Apply;
        if (Apply != 0) {
            hwVar = new com.byazt.vkw.hw((Function) Apply);
        }
        return (com.byazt.vkw.pr) hwVar;
    }

    @Override // com.byazt.la.c
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.la.c
    public String zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.pr.apply(sparseArray);
    }
}
