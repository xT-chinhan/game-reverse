package com.byazt.si;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public class t implements h, Function {
    public volatile Function n;
    public volatile h qg;

    public t(h hVar) {
        this.qg = hVar;
    }

    public t(Function function) {
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
                Object bbVar = sparseArray.get(1);
                if (bbVar != null) {
                    bbVar = new bb((Function) bbVar);
                }
                return n((ur) bbVar);
            }
            if (iIntValue == 2) {
                Object bbVar2 = sparseArray.get(1);
                if (bbVar2 != null) {
                    bbVar2 = new bb((Function) bbVar2);
                }
                qg((ur) bbVar2);
            } else if (iIntValue == 3) {
                Object bbVar3 = sparseArray.get(1);
                if (bbVar3 != null) {
                    bbVar3 = new bb((Function) bbVar3);
                }
                s((ur) bbVar3);
            } else if (iIntValue == 4) {
                n();
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
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.byazt.si.h
    public sz n(ur urVar) {
        if (this.qg != null) {
            return this.qg.n(urVar);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (urVar != null) {
            urVar = new bb(urVar);
        }
        sparseArray.put(1, urVar);
        ?? Apply = this.n.apply(sparseArray);
        ?? kVar = Apply;
        if (Apply != 0) {
            kVar = new k((Function) Apply);
        }
        return (sz) kVar;
    }

    @Override // com.byazt.si.h
    public void n() {
        if (this.qg != null) {
            this.qg.n();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.h
    public void qg(ur urVar) {
        if (this.qg != null) {
            this.qg.qg(urVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (urVar != null) {
            urVar = new bb(urVar);
        }
        sparseArray.put(1, urVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.h
    public void s(ur urVar) {
        if (this.qg != null) {
            this.qg.s(urVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        if (urVar != null) {
            urVar = new bb(urVar);
        }
        sparseArray.put(1, urVar);
        this.n.apply(sparseArray);
    }
}
