package com.byazt.ek;

import android.content.Context;
import android.util.SparseArray;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1032, 26})
public class qg implements n, Function {
    public volatile Function n;
    public volatile n qg;

    public qg(n nVar) {
        this.qg = nVar;
    }

    public qg(Function function) {
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
                    return Boolean.valueOf(n((Context) sparseArray.get(1), (JSONObject) sparseArray.get(2)));
                case 2:
                    n((ScheduledExecutorService) sparseArray.get(1));
                    break;
                case 3:
                    n();
                    break;
                case 4:
                    n(((Integer) sparseArray.get(1)).intValue());
                    break;
                case 5:
                    n((Context) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
                    break;
                case 6:
                    n((String) sparseArray.get(1));
                    break;
                case 7:
                    qg();
                    break;
                case 8:
                    n((String) sparseArray.get(1), (String) sparseArray.get(2));
                    break;
                case 9:
                    qg((String) sparseArray.get(1), (String) sparseArray.get(2));
                    break;
                case 10:
                    s((String) sparseArray.get(1), (String) sparseArray.get(2));
                    break;
                case 11:
                    q((String) sparseArray.get(1), (String) sparseArray.get(2));
                    break;
                case 12:
                    n((String) sparseArray.get(1), (Throwable) sparseArray.get(2));
                    break;
                case 13:
                    n((String) sparseArray.get(1), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
                    break;
                case 14:
                    l((String) sparseArray.get(1), (String) sparseArray.get(2));
                    break;
                case 15:
                    qg((String) sparseArray.get(1), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
                    break;
                case 16:
                    qg((String) sparseArray.get(1), (Throwable) sparseArray.get(2));
                    break;
                case 17:
                    s();
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

    @Override // com.byazt.ek.n
    public void l(String str, String str2) {
        if (this.qg != null) {
            this.qg.l(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n() {
        if (this.qg != null) {
            this.qg.n();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n(int i) {
        if (this.qg != null) {
            this.qg.n(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n(Context context, String str, String str2) {
        if (this.qg != null) {
            this.qg.n(context, str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n(String str) {
        if (this.qg != null) {
            this.qg.n(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n(String str, String str2) {
        if (this.qg != null) {
            this.qg.n(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n(String str, String str2, Throwable th) {
        if (this.qg != null) {
            this.qg.n(str, str2, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, th);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n(String str, Throwable th) {
        if (this.qg != null) {
            this.qg.n(str, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, str);
        sparseArray.put(2, th);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void n(ScheduledExecutorService scheduledExecutorService) {
        if (this.qg != null) {
            this.qg.n(scheduledExecutorService);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, scheduledExecutorService);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public boolean n(Context context, JSONObject jSONObject) {
        if (this.qg != null) {
            return this.qg.n(context, jSONObject);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, jSONObject);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ek.n
    public void q(String str, String str2) {
        if (this.qg != null) {
            this.qg.q(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void qg() {
        if (this.qg != null) {
            this.qg.qg();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void qg(String str, String str2) {
        if (this.qg != null) {
            this.qg.qg(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void qg(String str, String str2, Throwable th) {
        if (this.qg != null) {
            this.qg.qg(str, str2, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, th);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void qg(String str, Throwable th) {
        if (this.qg != null) {
            this.qg.qg(str, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, str);
        sparseArray.put(2, th);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void s() {
        if (this.qg != null) {
            this.qg.s();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ek.n
    public void s(String str, String str2) {
        if (this.qg != null) {
            this.qg.s(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
    }
}
