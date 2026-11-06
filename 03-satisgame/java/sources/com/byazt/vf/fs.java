package com.byazt.vf;

import android.util.SparseArray;
import android.view.MotionEvent;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, 101})
public class fs implements x, Function {
    public volatile Function n;
    public volatile x qg;

    public fs(x xVar) {
        this.qg = xVar;
    }

    public fs(Function function) {
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
                    return Boolean.valueOf(n((String) sparseArray.get(1), (String) sparseArray.get(2)));
                case 3:
                    return Boolean.valueOf(n((String) sparseArray.get(1)));
                case 4:
                    n((MotionEvent) sparseArray.get(1));
                    break;
                case 5:
                    return n((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
                case 6:
                    n(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                    break;
                case 7:
                    return qg((String) sparseArray.get(1), (String) sparseArray.get(2));
                case 8:
                    return qg();
                case 9:
                    qg((String) sparseArray.get(1));
                    break;
                case 10:
                    n(((Integer) sparseArray.get(1)).intValue());
                    break;
                case 11:
                    n((JSONObject) sparseArray.get(1));
                    break;
                case 12:
                    n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue());
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

    @Override // com.byazt.vf.x
    public String n() {
        if (this.qg != null) {
            return this.qg.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public String n(String str, long j, int i, boolean z) {
        if (this.qg != null) {
            return this.qg.n(str, j, i, z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, Boolean.valueOf(z));
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public void n(int i) {
        if (this.qg != null) {
            this.qg.n(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public void n(int i, int i2, boolean z) {
        if (this.qg != null) {
            this.qg.n(i, i2, z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        sparseArray.put(3, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public void n(long j, int i) {
        if (this.qg != null) {
            this.qg.n(j, i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(2, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public void n(MotionEvent motionEvent) {
        if (this.qg != null) {
            this.qg.n(motionEvent);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, motionEvent);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public void n(JSONObject jSONObject) {
        if (this.qg != null) {
            this.qg.n(jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, jSONObject);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public boolean n(String str) {
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.x
    public boolean n(String str, String str2) {
        if (this.qg != null) {
            return this.qg.n(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.x
    public String qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public String qg(String str, String str2) {
        if (this.qg != null) {
            return this.qg.qg(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.x
    public void qg(String str) {
        if (this.qg != null) {
            this.qg.qg(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }
}
