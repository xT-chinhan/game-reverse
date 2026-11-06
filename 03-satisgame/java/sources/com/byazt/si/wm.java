package com.byazt.si;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.InputStream;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm implements ou, Function {
    public volatile Function n;
    public volatile ou qg;

    public wm(ou ouVar) {
        this.qg = ouVar;
    }

    public wm(Function function) {
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
                    return n((String) sparseArray.get(1));
                case 2:
                    n(((Double) sparseArray.get(1)).doubleValue());
                    break;
                case 3:
                    qg(((Double) sparseArray.get(1)).doubleValue());
                    break;
                case 4:
                    s(((Double) sparseArray.get(1)).doubleValue());
                    break;
                case 5:
                    n();
                    break;
                case 6:
                    return n((String) sparseArray.get(1), (String) sparseArray.get(2));
                case 7:
                    return n((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
                case 8:
                    return Boolean.valueOf(qg((String) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3)));
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.si.ou
    public sz n(String str) {
        ?? kVar;
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            kVar = Apply;
            kVar = new k((Function) Apply);
        }
        kVar = Apply;
        return (sz) kVar;
    }

    @Override // com.byazt.si.ou
    public InputStream n(String str, String str2) {
        if (this.qg != null) {
            return this.qg.n(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (InputStream) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.ou
    public InputStream n(String str, String str2, String str3) {
        if (this.qg != null) {
            return this.qg.n(str, str2, str3);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        return (InputStream) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.ou
    public void n() {
        if (this.qg != null) {
            this.qg.n();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.ou
    public void n(double d) {
        if (this.qg != null) {
            this.qg.n(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Double.valueOf(d));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.ou
    public void qg(double d) {
        if (this.qg != null) {
            this.qg.qg(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Double.valueOf(d));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.ou
    public boolean qg(String str, String str2, String str3) {
        if (this.qg != null) {
            return this.qg.qg(str, str2, str3);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.si.ou
    public void s(double d) {
        if (this.qg != null) {
            this.qg.s(d);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Double.valueOf(d));
        this.n.apply(sparseArray);
    }
}
