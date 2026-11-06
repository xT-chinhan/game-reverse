package com.byazt.ld;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 104, 19})
public class ho implements g, Function {
    public volatile g hw;
    public volatile Function pr;

    public ho(g gVar) {
        this.hw = gVar;
    }

    public ho(Function function) {
        this.pr = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object zVar = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (zVar != null) {
                    zVar = new z((Function) zVar);
                }
                k kVarPr = this.hw.pr((rc) zVar, ((Integer) obj2).intValue());
                return kVarPr != null ? new m(kVarPr) : kVarPr;
            case 2:
                Object zVar2 = sparseArray.get(1);
                if (zVar2 != null) {
                    zVar2 = new z((Function) zVar2);
                }
                k kVarPr2 = this.hw.pr((rc) zVar2);
                return kVarPr2 != null ? new m(kVarPr2) : kVarPr2;
            case 3:
                k kVarPr3 = this.hw.pr((ImageView) sparseArray.get(1));
                return kVarPr3 != null ? new m(kVarPr3) : kVarPr3;
            case 4:
                return this.hw.pr((String) sparseArray.get(1));
            case 5:
                return this.hw.hw((String) sparseArray.get(1));
            case 6:
                Object hnVar = sparseArray.get(1);
                if (hnVar != null) {
                    hnVar = new hn((Function) hnVar);
                }
                return this.hw.pr((hw) hnVar);
            case 7:
                return this.hw.hn((String) sparseArray.get(1));
            case 8:
                return this.hw.pr((ImageView.ScaleType) sparseArray.get(1));
            case 9:
                return this.hw.pr((Bitmap.Config) sparseArray.get(1));
            case 10:
                return this.hw.pr(((Integer) sparseArray.get(1)).intValue());
            case 11:
                return this.hw.hw(((Integer) sparseArray.get(1)).intValue());
            case 12:
                return this.hw.hn(((Integer) sparseArray.get(1)).intValue());
            case 13:
                Object eVar = sparseArray.get(1);
                if (eVar != null) {
                    eVar = new e((Function) eVar);
                }
                return this.hw.pr((n) eVar);
            case 14:
                return this.hw.pr(((Boolean) sparseArray.get(1)).booleanValue());
            case 15:
                return this.hw.hw(((Boolean) sparseArray.get(1)).booleanValue());
            case 16:
                return this.hw.pr((ExecutorService) sparseArray.get(1));
            case 17:
                Object wVar = sparseArray.get(1);
                if (wVar != null) {
                    wVar = new w((Function) wVar);
                }
                return this.hw.pr((vk) wVar);
            case 18:
                return this.hw.x(((Integer) sparseArray.get(1)).intValue());
            case 19:
                return this.hw.c(((Integer) sparseArray.get(1)).intValue());
            case 20:
                return this.hw.hn(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                Object czVar = sparseArray.get(1);
                if (czVar != null) {
                    czVar = new cz((Function) czVar);
                }
                return this.hw.pr((a) czVar);
            case 22:
                return this.hw.x(((Boolean) sparseArray.get(1)).booleanValue());
            default:
                return null;
        }
    }

    @Override // com.byazt.ld.g
    public g c(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g hn(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g hn(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g hn(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g hw(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g hw(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g hw(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(Bitmap.Config config) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, config);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(ImageView.ScaleType scaleType) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, scaleType);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(a aVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        if (aVar != null) {
            aVar = new cz(aVar);
        }
        sparseArray.put(1, aVar);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(hw hwVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (hwVar != null) {
            hwVar = new hn(hwVar);
        }
        sparseArray.put(1, hwVar);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(n nVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (nVar != null) {
            nVar = new e(nVar);
        }
        sparseArray.put(1, nVar);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(vk vkVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        if (vkVar != null) {
            vkVar = new w(vkVar);
        }
        sparseArray.put(1, vkVar);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(ExecutorService executorService) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, executorService);
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g pr(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.byazt.ld.g
    public k pr(ImageView imageView) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, imageView);
        ?? Apply = this.pr.apply(sparseArray);
        ?? mVar = Apply;
        if (Apply != 0) {
            mVar = new m((Function) Apply);
        }
        return (k) mVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.ld.g
    public k pr(rc rcVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (rcVar != null) {
            rcVar = new z(rcVar);
        }
        sparseArray.put(1, rcVar);
        ?? Apply = this.pr.apply(sparseArray);
        ?? mVar = Apply;
        if (Apply != 0) {
            mVar = new m((Function) Apply);
        }
        return (k) mVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.ld.g
    public k pr(rc rcVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (rcVar != null) {
            rcVar = new z(rcVar);
        }
        sparseArray.put(1, rcVar);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.pr.apply(sparseArray);
        ?? mVar = Apply;
        if (Apply != 0) {
            mVar = new m((Function) Apply);
        }
        return (k) mVar;
    }

    @Override // com.byazt.ld.g
    public g x(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.ld.g
    public g x(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
        return this;
    }
}
