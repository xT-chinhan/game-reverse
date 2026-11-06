package com.byazt.si;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT})
public class hd implements cy, Function {
    public volatile Function n;
    public volatile cy qg;

    public hd(cy cyVar) {
        this.qg = cyVar;
    }

    public hd(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.qg.n();
            case 2:
                return this.qg.qg();
            case 3:
                return this.qg.s();
            case 4:
                return this.qg.q();
            case 5:
                this.qg.setResult(sparseArray.get(1));
                return null;
            case 6:
                return Integer.valueOf(this.qg.l());
            case 7:
                return Integer.valueOf(this.qg.w());
            case 8:
                return this.qg.x();
            case 9:
                return Boolean.valueOf(this.qg.fs());
            case 10:
                return Boolean.valueOf(this.qg.rv());
            case 11:
                fs fsVarTj = this.qg.tj();
                return fsVarTj != null ? new rv(fsVarTj) : fsVarTj;
            case 12:
                return Integer.valueOf(this.qg.cp());
            default:
                return null;
        }
    }

    @Override // com.byazt.si.cy
    public int cp() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
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

    @Override // com.byazt.si.cy
    public boolean fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
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

    @Override // com.byazt.si.cy
    public int l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.si.cy
    public String n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.cy
    public Object q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.cy
    public String qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.cy
    public boolean rv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.si.cy
    public Object s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.cy
    public void setResult(Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, obj);
        this.n.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.si.cy
    public fs tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.n.apply(sparseArray);
        ?? rvVar = Apply;
        if (Apply != 0) {
            rvVar = new rv((Function) Apply);
        }
        return (fs) rvVar;
    }

    @Override // com.byazt.si.cy
    public int w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.si.cy
    public Map x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Map) this.n.apply(sparseArray);
    }
}
