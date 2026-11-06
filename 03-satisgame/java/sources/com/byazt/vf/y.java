package com.byazt.vf;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 99})
public class y implements wo, Function {
    public volatile Function n;
    public volatile wo qg;

    public y(wo woVar) {
        this.qg = woVar;
    }

    public y(Function function) {
        this.n = function;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue != -4) {
            switch (iIntValue) {
                case 1:
                    return n();
                case 2:
                    return qg();
                case 3:
                    return s();
                case 4:
                    return n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue());
                case 5:
                    return q();
                case 6:
                    return l();
                case 7:
                    return w();
                case 8:
                    return x();
                case 9:
                    return fs();
                case 10:
                    n((Runnable) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
                    break;
                case 11:
                    n((Runnable) sparseArray.get(1));
                    break;
                case 12:
                    qg((Runnable) sparseArray.get(1));
                    break;
                case 13:
                    return n((String) sparseArray.get(1));
                case 14:
                    Object shVar = sparseArray.get(1);
                    Object obj2 = sparseArray.get(2);
                    if (shVar != null) {
                        shVar = new sh((Function) shVar);
                    }
                    return n((wo.n) shVar, (String) obj2);
                case 15:
                    n((Handler) sparseArray.get(1));
                    break;
                case 16:
                    n((JSONObject) sparseArray.get(1));
                    break;
                case 17:
                    s((Runnable) sparseArray.get(1));
                    break;
            }
        } else {
            Function function = (Function) sparseArray.get(1);
            if (function != null) {
                this.n = function;
                this.qg = null;
            }
        }
        return null;
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

    @Override // com.byazt.vf.wo
    public ScheduledExecutorService fs() {
        if (this.qg != null) {
            return this.qg.fs();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (ScheduledExecutorService) this.n.apply(sparseArray);
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

    @Override // com.byazt.vf.wo
    public Handler l() {
        if (this.qg != null) {
            return this.qg.l();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (Handler) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public Handler n(wo.n nVar, String str) {
        if (this.qg != null) {
            return this.qg.n(nVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        if (nVar != null) {
            nVar = new sh(nVar);
        }
        sparseArray.put(1, nVar);
        sparseArray.put(2, str);
        return (Handler) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public Handler n(String str) {
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        return (Handler) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public ExecutorService n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (ExecutorService) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public ExecutorService n(int i, int i2) {
        if (this.qg != null) {
            return this.qg.n(i, i2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        return (ExecutorService) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public void n(Handler handler) {
        if (this.qg != null) {
            this.qg.n(handler);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, handler);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public void n(Runnable runnable) {
        if (this.qg != null) {
            this.qg.n(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, runnable);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public void n(Runnable runnable, int i) {
        if (this.qg != null) {
            this.qg.n(runnable, i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, runnable);
        sparseArray.put(2, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public void n(JSONObject jSONObject) {
        if (this.qg != null) {
            this.qg.n(jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, jSONObject);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public Handler q() {
        if (this.qg != null) {
            return this.qg.q();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (Handler) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public ExecutorService qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (ExecutorService) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public void qg(Runnable runnable) {
        if (this.qg != null) {
            this.qg.qg(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, runnable);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public ExecutorService s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (ExecutorService) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public void s(Runnable runnable) {
        if (this.qg != null) {
            this.qg.s(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, runnable);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public Handler w() {
        if (this.qg != null) {
            return this.qg.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (Handler) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.wo
    public ExecutorService x() {
        if (this.qg != null) {
            return this.qg.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (ExecutorService) this.n.apply(sparseArray);
    }
}
