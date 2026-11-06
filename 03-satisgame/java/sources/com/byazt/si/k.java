package com.byazt.si;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, 210})
public class k implements sz, Function {
    public volatile Function n;
    public volatile sz qg;

    public k(sz szVar) {
        this.qg = szVar;
    }

    public k(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object huVar = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (huVar != null) {
                    huVar = new hu((Function) huVar);
                }
                d dVarN = this.qg.n((m) huVar, ((Integer) obj2).intValue());
                return dVarN != null ? new oa(dVarN) : dVarN;
            case 2:
                Object huVar2 = sparseArray.get(1);
                if (huVar2 != null) {
                    huVar2 = new hu((Function) huVar2);
                }
                d dVarN2 = this.qg.n((m) huVar2);
                return dVarN2 != null ? new oa(dVarN2) : dVarN2;
            case 3:
                d dVarN3 = this.qg.n((ImageView) sparseArray.get(1));
                return dVarN3 != null ? new oa(dVarN3) : dVarN3;
            case 4:
                return this.qg.n((String) sparseArray.get(1));
            case 5:
                return this.qg.qg((String) sparseArray.get(1));
            case 6:
                Object sVar = sparseArray.get(1);
                if (sVar != null) {
                    sVar = new s((Function) sVar);
                }
                return this.qg.n((qg) sVar);
            case 7:
                return this.qg.s((String) sparseArray.get(1));
            case 8:
                return this.qg.n((ImageView.ScaleType) sparseArray.get(1));
            case 9:
                return this.qg.n((Bitmap.Config) sparseArray.get(1));
            case 10:
                return this.qg.n(((Integer) sparseArray.get(1)).intValue());
            case 11:
                return this.qg.qg(((Integer) sparseArray.get(1)).intValue());
            case 12:
                return this.qg.s(((Integer) sparseArray.get(1)).intValue());
            case 13:
                Object anVar = sparseArray.get(1);
                if (anVar != null) {
                    anVar = new an((Function) anVar);
                }
                return this.qg.n((j) anVar);
            case 14:
                return this.qg.n(((Boolean) sparseArray.get(1)).booleanValue());
            case 15:
                return this.qg.qg(((Boolean) sparseArray.get(1)).booleanValue());
            case 16:
                return this.qg.n((ExecutorService) sparseArray.get(1));
            case 17:
                Object cpVar = sparseArray.get(1);
                if (cpVar != null) {
                    cpVar = new cp((Function) cpVar);
                }
                return this.qg.n((tj) cpVar);
            case 18:
                return this.qg.q(((Integer) sparseArray.get(1)).intValue());
            case 19:
                return this.qg.l(((Integer) sparseArray.get(1)).intValue());
            case 20:
                return this.qg.s(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                Object pyVar = sparseArray.get(1);
                if (pyVar != null) {
                    pyVar = new py((Function) pyVar);
                }
                return this.qg.n((a) pyVar);
            case 22:
                return this.qg.q(((Boolean) sparseArray.get(1)).booleanValue());
            default:
                return null;
        }
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (this.n != null) {
            obj2 = this.n;
        } else {
            if (this.qg == null) {
                return super.equals(obj);
            }
            obj2 = this.qg;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        Object obj;
        if (this.n != null) {
            obj = this.n;
        } else {
            if (this.qg == null) {
                return super.hashCode();
            }
            obj = this.qg;
        }
        return obj.hashCode();
    }

    @Override // com.byazt.si.sz
    public sz l(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.byazt.si.sz
    public d n(ImageView imageView) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, imageView);
        ?? Apply = this.n.apply(sparseArray);
        ?? oaVar = Apply;
        if (Apply != 0) {
            oaVar = new oa((Function) Apply);
        }
        return (d) oaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.si.sz
    public d n(m mVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (mVar != null) {
            mVar = new hu(mVar);
        }
        sparseArray.put(1, mVar);
        ?? Apply = this.n.apply(sparseArray);
        ?? oaVar = Apply;
        if (Apply != 0) {
            oaVar = new oa((Function) Apply);
        }
        return (d) oaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.si.sz
    public d n(m mVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (mVar != null) {
            mVar = new hu(mVar);
        }
        sparseArray.put(1, mVar);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.n.apply(sparseArray);
        ?? oaVar = Apply;
        if (Apply != 0) {
            oaVar = new oa((Function) Apply);
        }
        return (d) oaVar;
    }

    @Override // com.byazt.si.sz
    public sz n(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(Bitmap.Config config) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, config);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(ImageView.ScaleType scaleType) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, scaleType);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(a aVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        if (aVar != null) {
            aVar = new py(aVar);
        }
        sparseArray.put(1, aVar);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(j jVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (jVar != null) {
            jVar = new an(jVar);
        }
        sparseArray.put(1, jVar);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(qg qgVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (qgVar != null) {
            qgVar = new s(qgVar);
        }
        sparseArray.put(1, qgVar);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(tj tjVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        if (tjVar != null) {
            tjVar = new cp(tjVar);
        }
        sparseArray.put(1, tjVar);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(ExecutorService executorService) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, executorService);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz n(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz q(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz q(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz qg(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz qg(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz qg(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz s(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz s(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.si.sz
    public sz s(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
        return this;
    }
}
