package com.byazt.ej;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, 13})
public class w implements l, Function {
    public volatile Function n;
    public volatile l qg;

    public w(l lVar) {
        this.qg = lVar;
    }

    public w(Function function) {
        this.n = function;
    }

    @Override // com.byazt.ej.l
    public int a() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.qg.n());
            case 2:
                this.qg.n(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 3:
                return Integer.valueOf(this.qg.qg());
            case 4:
                this.qg.qg(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 5:
                return Integer.valueOf(this.qg.s());
            case 6:
                this.qg.s(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 7:
                return Integer.valueOf(this.qg.q());
            case 8:
                this.qg.q(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 9:
                return Long.valueOf(this.qg.l());
            case 10:
                this.qg.n(((Long) sparseArray.get(1)).longValue());
                return null;
            case 11:
                return Double.valueOf(this.qg.w());
            case 12:
                this.qg.n(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 13:
                return Double.valueOf(this.qg.x());
            case 14:
                this.qg.qg(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 15:
                return Float.valueOf(this.qg.fs());
            case 16:
                this.qg.n(((Float) sparseArray.get(1)).floatValue());
                return null;
            case 17:
                return this.qg.rv();
            case 18:
                this.qg.n((String) sparseArray.get(1));
                return null;
            case 19:
                return this.qg.tj();
            case 20:
                return this.qg.cp();
            case 21:
                this.qg.qg((String) sparseArray.get(1));
                return null;
            case 22:
                return this.qg.d();
            case 23:
                this.qg.s((String) sparseArray.get(1));
                return null;
            case 24:
                return this.qg.oa();
            case 25:
                this.qg.q((String) sparseArray.get(1));
                return null;
            case 26:
                return this.qg.sz();
            case 27:
                this.qg.l((String) sparseArray.get(1));
                return null;
            case 28:
                return this.qg.k();
            case 29:
                this.qg.w((String) sparseArray.get(1));
                return null;
            case 30:
                return Integer.valueOf(this.qg.cy());
            case 31:
                this.qg.l(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 32:
                return Integer.valueOf(this.qg.hd());
            case 33:
                this.qg.w(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 34:
                return Integer.valueOf(this.qg.cd());
            case 35:
                this.qg.x(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 36:
                return this.qg.um();
            case 37:
                return Integer.valueOf(this.qg.a());
            case 38:
                this.qg.fs(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 39:
                return Integer.valueOf(this.qg.py());
            case 40:
                this.qg.rv(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 41:
                return Boolean.valueOf(this.qg.ou());
            case 42:
                return Boolean.valueOf(this.qg.wm());
            case 43:
                this.qg.tj(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 44:
                return Integer.valueOf(this.qg.m());
            default:
                return null;
        }
    }

    @Override // com.byazt.ej.l
    public int cd() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public String cp() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public int cy() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public String d() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return (String) this.n.apply(sparseArray);
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

    @Override // com.byazt.ej.l
    public float fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Float) objApply).floatValue();
        }
        return 0.0f;
    }

    @Override // com.byazt.ej.l
    public void fs(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
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

    @Override // com.byazt.ej.l
    public int hd() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public String k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public long l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.ej.l
    public void l(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void l(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public int m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public int n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public void n(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Double.valueOf(d));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void n(float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, Float.valueOf(f));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void n(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void n(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public String oa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public boolean ou() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.l
    public int py() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public int q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public void q(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void q(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public int qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public void qg(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Double.valueOf(d));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void qg(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void qg(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public String rv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void rv(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public int s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.l
    public void s(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void s(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public String sz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void tj(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public int[] tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return (int[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public JSONObject um() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public double w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Double) objApply).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.byazt.ej.l
    public void w(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public void w(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.l
    public boolean wm() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.l
    public double x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Double) objApply).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.byazt.ej.l
    public void x(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }
}
