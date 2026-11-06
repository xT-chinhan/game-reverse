package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 19})
public class ho implements g, Function {
    public volatile g hw;
    public volatile Function pr;

    public ho(g gVar) {
        this.hw = gVar;
    }

    public ho(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.vkw.g
    public int a() {
        if (this.hw != null) {
            return this.hw.a();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.g
    public String aj() {
        if (this.hw != null) {
            return this.hw.aj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.pr.apply(sparseArray);
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
            default:
                return null;
            case 1:
                return pr();
            case 2:
                return hw();
            case 3:
                return hn();
            case 4:
                return x();
            case 5:
                return c();
            case 6:
                return uc();
            case 7:
                return fw();
            case 8:
                return Integer.valueOf(zo());
            case 9:
                return aj();
            case 10:
                return vk();
            case 11:
                return w();
            case 12:
                return k();
            case 13:
                return m();
            case 14:
                return g();
            case 15:
                return ho();
            case 16:
                return nt();
            case 17:
                return yb();
            case 18:
                return Integer.valueOf(lb());
            case 19:
                return Integer.valueOf(pr(((Boolean) sparseArray.get(1)).booleanValue()));
            case 20:
                return hw(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                return hn(((Boolean) sparseArray.get(1)).booleanValue());
            case 22:
                return pr((Boolean) sparseArray.get(1));
            case 23:
                return x(((Boolean) sparseArray.get(1)).booleanValue());
            case 24:
                return hw((Boolean) sparseArray.get(1));
            case 25:
                return hn((Boolean) sparseArray.get(1));
            case 26:
                return x((Boolean) sparseArray.get(1));
            case 27:
                return c((Boolean) sparseArray.get(1));
            case 28:
                return qa();
            case 29:
                return Integer.valueOf(a());
            case 30:
                return Integer.valueOf(cz());
            case 31:
                return Integer.valueOf(ny());
            case 32:
                return fo();
            case 33:
                return rc();
            case 34:
                return z();
            case 35:
                return b();
            case 36:
                return Integer.valueOf(pr(((Long) sparseArray.get(1)).longValue()));
            case 37:
                Object xVar = sparseArray.get(1);
                if (xVar != null) {
                    xVar = new com.byazt.apo.x((Function) xVar);
                }
                pr((com.byazt.apo.hn) xVar);
                return null;
            case 38:
                Object xVar2 = sparseArray.get(1);
                if (xVar2 != null) {
                    xVar2 = new com.byazt.apo.x((Function) xVar2);
                }
                hw((com.byazt.apo.hn) xVar2);
                return null;
            case 39:
                return iu();
            case 40:
                return Boolean.valueOf(ve());
            case 41:
                return Float.valueOf(gz());
            case 42:
                return c(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return pr(((Integer) sparseArray.get(1)).intValue());
            case 44:
                return nl();
            case 45:
                return y();
            case 46:
                return Long.valueOf(ww());
            case 47:
                return Boolean.valueOf(n());
            case 48:
                return Boolean.valueOf(e());
        }
    }

    @Override // com.byazt.vkw.g
    public String b() {
        if (this.hw != null) {
            return this.hw.b();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String c() {
        if (this.hw != null) {
            return this.hw.c();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String c(Boolean bool) {
        if (this.hw != null) {
            return this.hw.c(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public Map c(boolean z) {
        if (this.hw != null) {
            return this.hw.c(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Boolean.valueOf(z));
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public int cz() {
        if (this.hw != null) {
            return this.hw.cz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.g
    public boolean e() {
        if (this.hw != null) {
            return this.hw.e();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.g
    public String fo() {
        if (this.hw != null) {
            return this.hw.fo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String fw() {
        if (this.hw != null) {
            return this.hw.fw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String g() {
        if (this.hw != null) {
            return this.hw.g();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public float gz() {
        if (this.hw != null) {
            return this.hw.gz();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        return ((Float) this.pr.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.vkw.g
    public String hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String hn(Boolean bool) {
        if (this.hw != null) {
            return this.hw.hn(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String[] hn(boolean z) {
        if (this.hw != null) {
            return this.hw.hn(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String ho() {
        if (this.hw != null) {
            return this.hw.ho();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String hw(Boolean bool) {
        if (this.hw != null) {
            return this.hw.hw(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String hw(boolean z) {
        if (this.hw != null) {
            return this.hw.hw(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public void hw(com.byazt.apo.hn hnVar) {
        if (this.hw != null) {
            this.hw.hw(hnVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        if (hnVar != null) {
            hnVar = new com.byazt.apo.x(hnVar);
        }
        sparseArray.put(1, hnVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String iu() {
        if (this.hw != null) {
            return this.hw.iu();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String k() {
        if (this.hw != null) {
            return this.hw.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public int lb() {
        if (this.hw != null) {
            return this.hw.lb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.g
    public String m() {
        if (this.hw != null) {
            return this.hw.m();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public boolean n() {
        if (this.hw != null) {
            return this.hw.n();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.g
    public String nl() {
        if (this.hw != null) {
            return this.hw.nl();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String nt() {
        if (this.hw != null) {
            return this.hw.nt();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public int ny() {
        if (this.hw != null) {
            return this.hw.ny();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.g
    public int pr(long j) {
        if (this.hw != null) {
            return this.hw.pr(j);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, Long.valueOf(j));
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.g
    public int pr(boolean z) {
        if (this.hw != null) {
            return this.hw.pr(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Boolean.valueOf(z));
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.g
    public String pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String pr(int i) {
        if (this.hw != null) {
            return this.hw.pr(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        sparseArray.put(1, Integer.valueOf(i));
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String pr(Boolean bool) {
        if (this.hw != null) {
            return this.hw.pr(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public void pr(com.byazt.apo.hn hnVar) {
        if (this.hw != null) {
            this.hw.pr(hnVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        if (hnVar != null) {
            hnVar = new com.byazt.apo.x(hnVar);
        }
        sparseArray.put(1, hnVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String qa() {
        if (this.hw != null) {
            return this.hw.qa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String rc() {
        if (this.hw != null) {
            return this.hw.rc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String uc() {
        if (this.hw != null) {
            return this.hw.uc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public boolean ve() {
        if (this.hw != null) {
            return this.hw.ve();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.g
    public String vk() {
        if (this.hw != null) {
            return this.hw.vk();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String w() {
        if (this.hw != null) {
            return this.hw.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public long ww() {
        if (this.hw != null) {
            return this.hw.ww();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.vkw.g
    public com.byazt.apo.pr x(boolean z) {
        ?? hwVar;
        if (this.hw != null) {
            return this.hw.x(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, Boolean.valueOf(z));
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            hwVar = Apply;
            hwVar = new com.byazt.apo.hw((Function) Apply);
        }
        hwVar = Apply;
        return (com.byazt.apo.pr) hwVar;
    }

    @Override // com.byazt.vkw.g
    public String x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String x(Boolean bool) {
        if (this.hw != null) {
            return this.hw.x(bool);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        sparseArray.put(1, bool);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String y() {
        if (this.hw != null) {
            return this.hw.y();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String yb() {
        if (this.hw != null) {
            return this.hw.yb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public String z() {
        if (this.hw != null) {
            return this.hw.z();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.g
    public int zo() {
        if (this.hw != null) {
            return this.hw.zo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }
}
