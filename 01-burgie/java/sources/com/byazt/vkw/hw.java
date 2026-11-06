package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.vkw.pr
    public String a() {
        if (this.hw != null) {
            return this.hw.a();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public boolean aj() {
        if (this.hw != null) {
            return this.hw.aj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                return this.hw != null ? this.hw : this.pr;
            case -4:
                Function function = (Function) sparseArray.get(1);
                if (function != null) {
                    this.pr = function;
                    this.hw = null;
                    return pr();
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            case 1:
            default:
                return null;
            case 2:
                return pr();
            case 3:
                return Boolean.valueOf(hw());
            case 4:
                return pr((String) sparseArray.get(1));
            case 5:
                return hn();
            case 6:
                return Boolean.valueOf(x());
            case 7:
                return c();
            case 8:
                return uc();
            case 9:
                return Integer.valueOf(fw());
            case 10:
                return Boolean.valueOf(zo());
            case 11:
                return Boolean.valueOf(aj());
            case 12:
                return vk();
            case 13:
                return w();
            case 14:
                return Integer.valueOf(k());
            case 15:
                return Integer.valueOf(m());
            case 16:
                return Integer.valueOf(g());
            case 17:
                return ho();
            case 18:
                return Boolean.valueOf(nt());
            case 19:
                return yb();
            case 20:
                pr((SparseArray) sparseArray.get(1));
                return null;
            case 21:
                return lb();
            case 22:
                return qa();
            case 23:
                return a();
            case 24:
                return cz();
            case 25:
                return Boolean.valueOf(ny());
            case 26:
                return fo();
            case 27:
                return hw((String) sparseArray.get(1));
        }
    }

    @Override // com.byazt.vkw.pr
    public String c() {
        if (this.hw != null) {
            return this.hw.c();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public String cz() {
        if (this.hw != null) {
            return this.hw.cz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public String fo() {
        if (this.hw != null) {
            return this.hw.fo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public int fw() {
        if (this.hw != null) {
            return this.hw.fw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.pr
    public int g() {
        if (this.hw != null) {
            return this.hw.g();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.pr
    public String hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vkw.pr
    public com.byazt.vlp.fw ho() {
        ?? vkVar;
        if (this.hw != null) {
            return this.hw.ho();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            vkVar = Apply;
            vkVar = new com.byazt.vlp.vk((Function) Apply);
        }
        vkVar = Apply;
        return (com.byazt.vlp.fw) vkVar;
    }

    public Object hw(String str) {
        return com.byazt.zs.uc.pr(str, this);
    }

    @Override // com.byazt.vkw.pr
    public boolean hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.pr
    public int k() {
        if (this.hw != null) {
            return this.hw.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.pr
    public String lb() {
        if (this.hw != null) {
            return this.hw.lb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public int m() {
        if (this.hw != null) {
            return this.hw.m();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.pr
    public boolean nt() {
        if (this.hw != null) {
            return this.hw.nt();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.pr
    public boolean ny() {
        if (this.hw != null) {
            return this.hw.ny();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.pr
    public Object pr(String str) {
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public String pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public void pr(SparseArray sparseArray) {
        if (this.hw != null) {
            this.hw.pr(sparseArray);
            return;
        }
        SparseArray sparseArray2 = new SparseArray();
        sparseArray2.put(0, 20);
        sparseArray2.put(1, sparseArray);
        this.pr.apply(sparseArray2);
    }

    @Override // com.byazt.vkw.pr
    public String qa() {
        if (this.hw != null) {
            return this.hw.qa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public String uc() {
        if (this.hw != null) {
            return this.hw.uc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public int[] vk() {
        if (this.hw != null) {
            return this.hw.vk();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (int[]) this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vkw.pr
    public com.byazt.vlp.hw w() {
        ?? hnVar;
        if (this.hw != null) {
            return this.hw.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            hnVar = Apply;
            hnVar = new com.byazt.vlp.hn((Function) Apply);
        }
        hnVar = Apply;
        return (com.byazt.vlp.hw) hnVar;
    }

    @Override // com.byazt.vkw.pr
    public boolean x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.pr
    public Map yb() {
        if (this.hw != null) {
            return this.hw.yb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.pr
    public boolean zo() {
        if (this.hw != null) {
            return this.hw.zo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
