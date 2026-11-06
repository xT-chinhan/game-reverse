package com.byazt.vlp;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2172, 20})
public class hn implements hw, Function {
    public volatile hw hw;
    public volatile Function pr;

    public hn(hw hwVar) {
        this.hw = hwVar;
    }

    public hn(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.vlp.hw
    public String aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.hw.pr());
            case 2:
                c cVarHw = this.hw.hw();
                return cVarHw != null ? new uc(cVarHw) : cVarHw;
            case 3:
                return Boolean.valueOf(this.hw.hn());
            case 4:
                return Boolean.valueOf(this.hw.x());
            case 5:
                return this.hw.c();
            case 6:
                return Boolean.valueOf(this.hw.uc());
            case 7:
                return this.hw.fw();
            case 8:
                return Boolean.valueOf(this.hw.zo());
            case 9:
                return this.hw.aj();
            case 10:
                return Boolean.valueOf(this.hw.vk());
            case 11:
                w wVarW = this.hw.w();
                return wVarW != null ? new k(wVarW) : wVarW;
            case 12:
                return this.hw.k();
            case 13:
                return Boolean.valueOf(this.hw.m());
            case 14:
                return this.hw.g();
            case 15:
                return Boolean.valueOf(this.hw.ho());
            case 16:
                return Boolean.valueOf(this.hw.pr(((Integer) sparseArray.get(1)).intValue()));
            default:
                return null;
        }
    }

    @Override // com.byazt.vlp.hw
    public String c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.hw
    public String fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.hw
    public Map g() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.hw
    public boolean hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.hw
    public boolean ho() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.vlp.hw
    public c hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        ?? Apply = this.pr.apply(sparseArray);
        ?? ucVar = Apply;
        if (Apply != 0) {
            ucVar = new uc((Function) Apply);
        }
        return (c) ucVar;
    }

    @Override // com.byazt.vlp.hw
    public String k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vlp.hw
    public boolean m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.hw
    public boolean pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.hw
    public boolean pr(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, Integer.valueOf(i));
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.hw
    public boolean uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.hw
    public boolean vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.vlp.hw
    public w w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.pr.apply(sparseArray);
        ?? kVar = Apply;
        if (Apply != 0) {
            kVar = new k((Function) Apply);
        }
        return (w) kVar;
    }

    @Override // com.byazt.vlp.hw
    public boolean x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vlp.hw
    public boolean zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
