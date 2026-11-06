package com.byazt.zs;

import android.util.SparseArray;
import com.byazt.sd.a;
import com.byazt.wt.ls;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 62})
public class fw implements com.byazt.vkw.k, Function {
    public com.byazt.vkw.pr pr;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
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
            default:
                return null;
        }
    }

    public fw(com.byazt.vkw.pr prVar) {
        this.pr = prVar;
    }

    @Override // com.byazt.vkw.k
    public boolean pr() {
        return a.hw().tv();
    }

    @Override // com.byazt.vkw.k
    public String hw() {
        return ls.rc();
    }

    @Override // com.byazt.vkw.k
    public String hn() {
        return ls.z();
    }

    @Override // com.byazt.vkw.k
    public String x() {
        return ls.vk("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.byazt.vkw.k
    public boolean c() {
        return a.hw().xi();
    }

    @Override // com.byazt.vkw.k
    public boolean uc() {
        return a.hw().n();
    }

    @Override // com.byazt.vkw.k
    public boolean fw() {
        return false;
    }

    @Override // com.byazt.vkw.k
    public boolean zo() {
        return a.hw().e();
    }

    @Override // com.byazt.vkw.k
    public long aj() {
        long jS = a.hw().s();
        if (jS < 0 || jS == 2147483647L) {
            return 5000L;
        }
        return jS;
    }

    @Override // com.byazt.vkw.k
    public int vk() {
        int iEr = a.hw().er();
        if (iEr < 0 || iEr == Integer.MAX_VALUE) {
            return 10;
        }
        return iEr;
    }

    @Override // com.byazt.vkw.k
    public int w() {
        return a.hw().qn();
    }

    @Override // com.byazt.vkw.k
    public int k() {
        int iOd = a.hw().od();
        if (iOd <= 0 || iOd == Integer.MAX_VALUE) {
            return 100;
        }
        return iOd;
    }

    @Override // com.byazt.vkw.k
    public int m() {
        return a.hw().of();
    }

    @Override // com.byazt.vkw.k
    public JSONObject g() {
        return a.hw().qx();
    }

    @Override // com.byazt.vkw.k
    public JSONObject ho() {
        return a.hw().bd();
    }

    @Override // com.byazt.vkw.k
    public JSONObject nt() {
        return a.hw().mr();
    }

    @Override // com.byazt.vkw.k
    public JSONArray pr(String str) {
        return a.hw().qa(str);
    }

    @Override // com.byazt.vkw.k
    public long yb() {
        return a.hw().gv();
    }

    @Override // com.byazt.vkw.k
    public int lb() {
        return a.hw().dj();
    }

    @Override // com.byazt.vkw.k
    public JSONObject qa() {
        return a.hw().sr();
    }
}
