package com.byazt.hcx;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, 250})
public class k implements aj, Function {
    public volatile aj hw;
    public volatile Function pr;

    public k(aj ajVar) {
        this.hw = ajVar;
    }

    public k(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr(((Integer) sparseArray.get(1)).intValue());
            case 2:
                return this.hw.pr((String) sparseArray.get(1));
            case 3:
                return this.hw.pr((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 4:
                return this.hw.hw((String) sparseArray.get(1));
            case 5:
                return this.hw.pr((byte[]) sparseArray.get(1));
            case 6:
                return this.hw.hw((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return this.hw.hn((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 8:
                return this.hw.pr((String) sparseArray.get(1), (String) sparseArray.get(2), (byte[]) sparseArray.get(3));
            case 9:
                return this.hw.pr((String) sparseArray.get(1), (byte[]) sparseArray.get(2));
            case 10:
                Object hwVar = sparseArray.get(1);
                if (hwVar != null) {
                    hwVar = new hw((Function) hwVar);
                }
                return this.hw.pr((pr) hwVar);
            case 11:
                m mVarPr = this.hw.pr();
                return mVarPr != null ? new g(mVarPr) : mVarPr;
            case 12:
                Object zoVar = sparseArray.get(1);
                if (zoVar != null) {
                    zoVar = new zo((Function) zoVar);
                }
                this.hw.pr((fw) zoVar);
                return null;
            case 13:
                this.hw.hw();
                return null;
            case 14:
                return this.hw.hn();
            case 15:
                return this.hw.pr((Map<String, Object>) sparseArray.get(1));
            case 16:
                return this.hw.x();
            case 17:
                return this.hw.pr((JSONObject) sparseArray.get(1));
            case 18:
                return this.hw.x((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 19:
                return this.hw.c();
            default:
                return null;
        }
    }

    @Override // com.byazt.hcx.aj
    public aj c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj hn(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public byte[] hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (byte[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.aj
    public aj hw(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj hw(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public void hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.aj
    public aj pr(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(pr prVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        if (prVar != null) {
            prVar = new hw(prVar);
        }
        sparseArray.put(1, prVar);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str, String str2, byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, bArr);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str, byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, bArr);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(Map map) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, map);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, jSONObject);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, bArr);
        this.pr.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.hcx.aj
    public m pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.pr.apply(sparseArray);
        ?? gVar = Apply;
        if (Apply != 0) {
            gVar = new g((Function) Apply);
        }
        return (m) gVar;
    }

    @Override // com.byazt.hcx.aj
    public void pr(fw fwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        if (fwVar != null) {
            fwVar = new zo(fwVar);
        }
        sparseArray.put(1, fwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.aj
    public aj x(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public Map x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (Map) this.pr.apply(sparseArray);
    }
}
