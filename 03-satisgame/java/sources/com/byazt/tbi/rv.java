package com.byazt.tbi;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1862, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements w, Function {
    public volatile Function n;
    public volatile w qg;

    public rv(w wVar) {
        this.qg = wVar;
    }

    public rv(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return this.qg.n();
            case 2:
                return Boolean.valueOf(this.qg.qg());
            case 3:
                x xVarS = this.qg.s();
                return xVarS != null ? new fs(xVarS) : xVarS;
            case 4:
                return this.qg.q();
            case 5:
                return Boolean.valueOf(this.qg.l());
            case 6:
                return this.qg.w();
            case 7:
                return this.qg.x();
            case 8:
                return Boolean.valueOf(this.qg.fs());
            case 9:
                return Boolean.valueOf(this.qg.rv());
            case 10:
                return Boolean.valueOf(this.qg.tj());
            case 11:
                return this.qg.cp();
            default:
                return null;
        }
    }

    @Override // com.byazt.tbi.w
    public String cp() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
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

    @Override // com.byazt.tbi.w
    public boolean fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
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

    @Override // com.byazt.tbi.w
    public boolean l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.w
    public String n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.w
    public Map q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.w
    public boolean qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.w
    public boolean rv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.tbi.w
    public x s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        ?? Apply = this.n.apply(sparseArray);
        ?? fsVar = Apply;
        if (Apply != 0) {
            fsVar = new fs((Function) Apply);
        }
        return (x) fsVar;
    }

    @Override // com.byazt.tbi.w
    public boolean tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.tbi.w
    public JSONObject w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.tbi.w
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }
}
