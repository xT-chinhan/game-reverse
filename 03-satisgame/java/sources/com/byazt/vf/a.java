package com.byazt.vf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a implements um, Function {
    public volatile Function n;
    public volatile um qg;

    public a(um umVar) {
        this.qg = umVar;
    }

    public a(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue == -4) {
            Function function = (Function) sparseArray.get(1);
            if (function != null) {
                this.n = function;
                this.qg = null;
            }
        } else {
            if (iIntValue == 1) {
                return n((String) sparseArray.get(1));
            }
            if (iIntValue == 2) {
                return n((String) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            }
            if (iIntValue == 3) {
                return n(((Integer) sparseArray.get(1)).intValue());
            }
            if (iIntValue == 4) {
                n();
            } else if (iIntValue == 5) {
                qg();
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
    @Override // com.byazt.vf.um
    public com.byazt.eau.l n(String str) {
        ?? wVar;
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            wVar = Apply;
            wVar = new com.byazt.eau.w((Function) Apply);
        }
        wVar = Apply;
        return (com.byazt.eau.l) wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.vf.um
    public com.byazt.eau.l n(String str, int i) {
        ?? wVar;
        if (this.qg != null) {
            return this.qg.n(str, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            wVar = Apply;
            wVar = new com.byazt.eau.w((Function) Apply);
        }
        wVar = Apply;
        return (com.byazt.eau.l) wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.vf.um
    public com.byazt.eau.s n(int i) {
        ?? qVar;
        if (this.qg != null) {
            return this.qg.n(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            qVar = Apply;
            qVar = new com.byazt.eau.q((Function) Apply);
        }
        qVar = Apply;
        return (com.byazt.eau.s) qVar;
    }

    @Override // com.byazt.vf.um
    public void n() {
        if (this.qg != null) {
            this.qg.n();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.um
    public void qg() {
        if (this.qg != null) {
            this.qg.qg();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.n.apply(sparseArray);
    }
}
