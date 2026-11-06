package com.byazt.vf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1941, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements k, Function {
    public volatile Function n;
    public volatile k qg;

    public cy(k kVar) {
        this.qg = kVar;
    }

    public cy(Function function) {
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
                    n();
                    break;
                case 2:
                    return Boolean.valueOf(qg());
                case 3:
                    return Integer.valueOf(s());
                case 4:
                    return n((byte[]) sparseArray.get(1));
                case 5:
                    return qg((byte[]) sparseArray.get(1));
                case 6:
                    return n((String) sparseArray.get(1));
                case 7:
                    return qg((String) sparseArray.get(1));
                case 8:
                    return s((String) sparseArray.get(1));
                case 9:
                    return q((String) sparseArray.get(1));
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

    @Override // com.byazt.vf.k
    public String n(String str) {
        if (this.qg != null) {
            return this.qg.n(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.k
    public void n() {
        if (this.qg != null) {
            this.qg.n();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.k
    public byte[] n(byte[] bArr) {
        if (this.qg != null) {
            return this.qg.n(bArr);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, bArr);
        return (byte[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.k
    public String q(String str) {
        if (this.qg != null) {
            return this.qg.q(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.k
    public String qg(String str) {
        if (this.qg != null) {
            return this.qg.qg(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.k
    public boolean qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vf.k
    public byte[] qg(byte[] bArr) {
        if (this.qg != null) {
            return this.qg.qg(bArr);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, bArr);
        return (byte[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.vf.k
    public int s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.k
    public String s(String str) {
        if (this.qg != null) {
            return this.qg.s(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }
}
