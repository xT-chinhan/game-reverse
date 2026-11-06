package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 576})
public class ww implements y, Function {
    public volatile y hw;
    public volatile Function pr;

    public ww(y yVar) {
        this.hw = yVar;
    }

    public ww(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.vkw.y
    public String a() {
        if (this.hw != null) {
            return this.hw.a();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public int aj() {
        if (this.hw != null) {
            return this.hw.aj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

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
            case 2:
            case 6:
            case 19:
            case 22:
            case 23:
            case 24:
            case 27:
            case 28:
            default:
                return null;
            case 1:
                return pr();
            case 3:
                return Integer.valueOf(hw());
            case 4:
                return hn();
            case 5:
                return x();
            case 7:
                return c();
            case 8:
                return uc();
            case 9:
                return fw();
            case 10:
                return zo();
            case 11:
                return Integer.valueOf(aj());
            case 12:
                return vk();
            case 13:
                return w();
            case 14:
                return k();
            case 15:
                return m();
            case 16:
                return g();
            case 17:
                return ho();
            case 18:
                return nt();
            case 20:
                return yb();
            case 21:
                return lb();
            case 25:
                return qa();
            case 26:
                return a();
            case 29:
                return cz();
            case 30:
                return ny();
            case 31:
                return Integer.valueOf(fo());
            case 32:
                return rc();
            case 33:
                return Integer.valueOf(pr(((Boolean) sparseArray.get(1)).booleanValue()));
            case 34:
                return z();
            case 35:
                return hw(((Boolean) sparseArray.get(1)).booleanValue());
            case 36:
                return pr((Boolean) sparseArray.get(1));
            case 37:
                return b();
            case 38:
                return hw((Boolean) sparseArray.get(1));
            case 39:
                return hn((Boolean) sparseArray.get(1));
            case 40:
                return x((Boolean) sparseArray.get(1));
            case 41:
                return c((Boolean) sparseArray.get(1));
            case 42:
                return hn(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return iu();
            case 44:
                return ve();
            case 45:
                return gz();
            case 46:
                return Integer.valueOf(nl());
            case 47:
                return Integer.valueOf(y());
            case 48:
                return Integer.valueOf(ww());
            case 49:
                return n();
            case 50:
                return e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vkw.y
    public com.byazt.apo.pr b() {
        ?? hwVar;
        if (this.hw != null) {
            return this.hw.b();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            hwVar = Apply;
            hwVar = new com.byazt.apo.hw((Function) Apply);
        }
        hwVar = Apply;
        return (com.byazt.apo.pr) hwVar;
    }

    @Override // com.byazt.vkw.y
    public String c() {
        if (this.hw != null) {
            return this.hw.c();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String c(Boolean bool) {
        if (this.hw != null) {
            return this.hw.c(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String cz() {
        if (this.hw != null) {
            return this.hw.cz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String e() {
        if (this.hw != null) {
            return this.hw.e();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 50);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public int fo() {
        if (this.hw != null) {
            return this.hw.fo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.y
    public String fw() {
        if (this.hw != null) {
            return this.hw.fw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String g() {
        if (this.hw != null) {
            return this.hw.g();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String gz() {
        if (this.hw != null) {
            return this.hw.gz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String hn(Boolean bool) {
        if (this.hw != null) {
            return this.hw.hn(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String hn(boolean z) {
        if (this.hw != null) {
            return this.hw.hn(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String ho() {
        if (this.hw != null) {
            return this.hw.ho();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public int hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.y
    public String hw(Boolean bool) {
        if (this.hw != null) {
            return this.hw.hw(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String[] hw(boolean z) {
        if (this.hw != null) {
            return this.hw.hw(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String iu() {
        if (this.hw != null) {
            return this.hw.iu();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String k() {
        if (this.hw != null) {
            return this.hw.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String lb() {
        if (this.hw != null) {
            return this.hw.lb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String m() {
        if (this.hw != null) {
            return this.hw.m();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String n() {
        if (this.hw != null) {
            return this.hw.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 49);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public int nl() {
        if (this.hw != null) {
            return this.hw.nl();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.y
    public String nt() {
        if (this.hw != null) {
            return this.hw.nt();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String ny() {
        if (this.hw != null) {
            return this.hw.ny();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public int pr(boolean z) {
        if (this.hw != null) {
            return this.hw.pr(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Boolean.valueOf(z));
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.y
    public String pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String pr(Boolean bool) {
        if (this.hw != null) {
            return this.hw.pr(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String qa() {
        if (this.hw != null) {
            return this.hw.qa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String rc() {
        if (this.hw != null) {
            return this.hw.rc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String uc() {
        if (this.hw != null) {
            return this.hw.uc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String ve() {
        if (this.hw != null) {
            return this.hw.ve();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String vk() {
        if (this.hw != null) {
            return this.hw.vk();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String w() {
        if (this.hw != null) {
            return this.hw.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public int ww() {
        if (this.hw != null) {
            return this.hw.ww();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.y
    public String x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String x(Boolean bool) {
        if (this.hw != null) {
            return this.hw.x(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public int y() {
        if (this.hw != null) {
            return this.hw.y();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.y
    public String yb() {
        if (this.hw != null) {
            return this.hw.yb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String z() {
        if (this.hw != null) {
            return this.hw.z();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.y
    public String zo() {
        if (this.hw != null) {
            return this.hw.zo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.pr.apply(sparseArray);
    }
}
