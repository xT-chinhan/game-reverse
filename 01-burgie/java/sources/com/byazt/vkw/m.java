package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 108})
public class m implements k, Function {
    public volatile k hw;
    public volatile Function pr;

    public m(k kVar) {
        this.hw = kVar;
    }

    public m(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.vkw.k
    public long aj() {
        if (this.hw != null) {
            return this.hw.aj();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Long) this.pr.apply(sparseArray)).longValue();
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
                    return Boolean.valueOf(pr());
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return Boolean.valueOf(pr());
            case 2:
                return hw();
            case 3:
                return hn();
            case 4:
                return x();
            case 5:
                return Boolean.valueOf(c());
            case 6:
                return Boolean.valueOf(uc());
            case 7:
                return Boolean.valueOf(fw());
            case 8:
                return Boolean.valueOf(zo());
            case 9:
                return Long.valueOf(aj());
            case 10:
                return Integer.valueOf(vk());
            case 11:
                return Integer.valueOf(w());
            case 12:
                return Integer.valueOf(k());
            case 13:
                return Integer.valueOf(m());
            case 14:
                return g();
            case 15:
                return ho();
            case 16:
                return nt();
            case 17:
                return pr((String) sparseArray.get(1));
            case 18:
                return Long.valueOf(yb());
            case 19:
                return Integer.valueOf(lb());
            case 20:
                return qa();
        }
    }

    @Override // com.byazt.vkw.k
    public boolean c() {
        if (this.hw != null) {
            return this.hw.c();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.k
    public boolean fw() {
        if (this.hw != null) {
            return this.hw.fw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.k
    public JSONObject g() {
        if (this.hw != null) {
            return this.hw.g();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public String hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public JSONObject ho() {
        if (this.hw != null) {
            return this.hw.ho();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public String hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public int k() {
        if (this.hw != null) {
            return this.hw.k();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.k
    public int lb() {
        if (this.hw != null) {
            return this.hw.lb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.k
    public int m() {
        if (this.hw != null) {
            return this.hw.m();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.k
    public JSONObject nt() {
        if (this.hw != null) {
            return this.hw.nt();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public JSONArray pr(String str) {
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, str);
        return (JSONArray) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public boolean pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.k
    public JSONObject qa() {
        if (this.hw != null) {
            return this.hw.qa();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public boolean uc() {
        if (this.hw != null) {
            return this.hw.uc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.k
    public int vk() {
        if (this.hw != null) {
            return this.hw.vk();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.k
    public int w() {
        if (this.hw != null) {
            return this.hw.w();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.vkw.k
    public String x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.k
    public long yb() {
        if (this.hw != null) {
            return this.hw.yb();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.vkw.k
    public boolean zo() {
        if (this.hw != null) {
            return this.hw.zo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
