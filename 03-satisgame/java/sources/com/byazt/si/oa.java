package com.byazt.si;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 16, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa implements d, Function {
    public volatile Function n;
    public volatile d qg;

    public oa(d dVar) {
        this.qg = dVar;
    }

    public oa(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return Boolean.valueOf(this.qg.n());
            case 2:
                return this.qg.qg();
            case 3:
                return Integer.valueOf(this.qg.s());
            case 4:
                return Integer.valueOf(this.qg.q());
            case 5:
                return this.qg.l();
            case 6:
                return this.qg.w();
            case 7:
                return this.qg.x();
            case 8:
                return this.qg.fs();
            default:
                return null;
        }
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

    @Override // com.byazt.si.d
    public Bitmap.Config fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (Bitmap.Config) this.n.apply(sparseArray);
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

    @Override // com.byazt.si.d
    public ImageView.ScaleType l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (ImageView.ScaleType) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.d
    public boolean n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.si.d
    public int q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.si.d
    public String qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.d
    public int s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.si.d
    public String w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.si.d
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.n.apply(sparseArray);
    }
}
