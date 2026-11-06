package com.byazt.vlp;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2172, 50})
public class vk implements fw, Function {
    public volatile fw hw;
    public volatile Function pr;

    public vk(fw fwVar) {
        this.hw = fwVar;
    }

    public vk(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.vlp.fw
    public boolean aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return this.hw.pr();
            case 2:
                return Boolean.valueOf(this.hw.hw());
            case 3:
                zo zoVarHn = this.hw.hn();
                return zoVarHn != null ? new aj(zoVarHn) : zoVarHn;
            case 4:
                return this.hw.x();
            case 5:
                return Boolean.valueOf(this.hw.c());
            case 6:
                return this.hw.uc();
            case 7:
                return this.hw.fw();
            case 8:
                return Boolean.valueOf(this.hw.zo());
            case 9:
                return Boolean.valueOf(this.hw.aj());
            case 10:
                return Boolean.valueOf(this.hw.vk());
            case 11:
                return this.hw.w();
            default:
                return null;
        }
    }

    @Override // com.byazt.vlp.fw
    public boolean c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.fw
    public String fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.vlp.fw
    public zo hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        ?? Apply = this.pr.apply(sparseArray);
        ?? ajVar = Apply;
        if (Apply != 0) {
            ajVar = new aj((Function) Apply);
        }
        return (zo) ajVar;
    }

    @Override // com.byazt.vlp.fw
    public boolean hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.fw
    public String pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.fw
    public JSONObject uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.fw
    public boolean vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.fw
    public String w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.fw
    public Map x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.fw
    public boolean zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
