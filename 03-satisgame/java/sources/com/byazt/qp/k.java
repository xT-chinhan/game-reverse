package com.byazt.qp;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.vf.sh;
import com.byazt.vf.wo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 210})
public class k implements wo, Function {
    public com.byazt.txb.qg fs = com.byazt.txb.qg.n();
    public volatile Handler l;
    public volatile ThreadPoolExecutor n;
    public volatile ScheduledExecutorService q;
    public ThreadPoolExecutor qg;
    public volatile ThreadPoolExecutor s;
    public volatile Handler w;
    public volatile Handler x;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                n((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return tj();
            case -1:
                rv();
                return null;
            case 0:
            default:
                return null;
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
                return null;
            case 11:
                n((Runnable) sparseArray.get(1));
                return null;
            case 12:
                qg((Runnable) sparseArray.get(1));
                return null;
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
                return null;
            case 16:
                n((JSONObject) sparseArray.get(1));
                return null;
            case 17:
                s((Runnable) sparseArray.get(1));
                return null;
        }
    }

    @Override // com.byazt.vf.wo
    public ExecutorService n(int i, int i2) {
        return null;
    }

    public void n(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.n = (ThreadPoolExecutor) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.qg = (ThreadPoolExecutor) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            this.s = (ThreadPoolExecutor) obj3;
        }
        Object obj4 = sparseArray.get(4);
        if (obj4 != null) {
            this.q = (ScheduledExecutorService) obj4;
        }
        Object obj5 = sparseArray.get(5);
        if (obj5 != null) {
            this.l = (Handler) obj5;
        }
        Object obj6 = sparseArray.get(6);
        if (obj6 != null) {
            this.w = (Handler) obj6;
        }
        Object obj7 = sparseArray.get(7);
        if (obj7 != null) {
            this.x = (Handler) obj7;
        }
    }

    public SparseArray tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.n);
        sparseArray.put(2, this.qg);
        sparseArray.put(3, this.s);
        sparseArray.put(4, this.q);
        sparseArray.put(5, this.l);
        sparseArray.put(6, this.w);
        sparseArray.put(7, this.x);
        return sparseArray;
    }

    @Override // com.byazt.vf.wo
    public ExecutorService n() {
        if (this.n == null) {
            this.n = com.byazt.qit.rv.qg.rv();
        }
        return this.n;
    }

    @Override // com.byazt.vf.wo
    public ExecutorService qg() {
        return com.byazt.qit.rv.qg.sz();
    }

    @Override // com.byazt.vf.wo
    public ExecutorService s() {
        if (this.qg == null) {
            this.qg = com.byazt.qit.rv.qg.tj();
        }
        return this.qg;
    }

    @Override // com.byazt.vf.wo
    public Handler q() {
        Handler handlerN;
        if (this.x == null) {
            synchronized (k.class) {
                if (this.x == null && (handlerN = this.fs.n("csj_io")) != null) {
                    this.x = handlerN;
                }
            }
        }
        return this.x;
    }

    @Override // com.byazt.vf.wo
    public Handler l() {
        Handler handlerN;
        if (this.l == null) {
            synchronized (k.class) {
                if (this.l == null && (handlerN = this.fs.n("csj_main")) != null) {
                    this.l = handlerN;
                }
            }
        }
        return this.l;
    }

    @Override // com.byazt.vf.wo
    public Handler w() {
        if (this.w == null) {
            synchronized (k.class) {
                if (this.w == null) {
                    this.w = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.w;
    }

    @Override // com.byazt.vf.wo
    public ExecutorService x() {
        if (this.s == null) {
            this.s = com.byazt.qit.rv.qg.sz();
        }
        return this.s;
    }

    @Override // com.byazt.vf.wo
    public ScheduledExecutorService fs() {
        if (this.q == null) {
            this.q = com.byazt.qit.rv.qg.oa();
        }
        return this.q;
    }

    @Override // com.byazt.vf.wo
    public void n(Runnable runnable, int i) {
        s().execute(runnable);
    }

    @Override // com.byazt.vf.wo
    public void n(Runnable runnable) {
        s().execute(runnable);
    }

    @Override // com.byazt.vf.wo
    public void qg(Runnable runnable) {
        n().execute(runnable);
    }

    @Override // com.byazt.vf.wo
    public Handler n(String str) {
        return this.fs.n(str);
    }

    @Override // com.byazt.vf.wo
    public Handler n(wo.n nVar, String str) {
        return this.fs.n(nVar, str);
    }

    @Override // com.byazt.vf.wo
    public void n(Handler handler) {
        this.fs.n(handler);
    }

    @Override // com.byazt.vf.wo
    public void n(JSONObject jSONObject) {
        com.byazt.qit.rv.qg.n(jSONObject);
    }

    @Override // com.byazt.vf.wo
    public void s(Runnable runnable) {
        q().post(runnable);
    }

    public void rv() {
        this.fs.qg();
    }
}
