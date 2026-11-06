package com.byazt.zs;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.sd.iu;
import com.byazt.wt.ls;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 13})
public class hw implements com.byazt.vkw.pr, Function {
    public com.byazt.vlp.hw c;
    public volatile com.byazt.qe.pr hn;
    public String hw;
    public String mAppId;
    public volatile SparseArray pr;
    public com.byazt.vlp.fw x;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                hw((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return rc();
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
                com.byazt.vlp.hw hwVarW = w();
                return hwVarW != null ? new com.byazt.vlp.hn(hwVarW) : hwVarW;
            case 14:
                return Integer.valueOf(k());
            case 15:
                return Integer.valueOf(m());
            case 16:
                return Integer.valueOf(g());
            case 17:
                com.byazt.vlp.fw fwVarHo = ho();
                return fwVarHo != null ? new com.byazt.vlp.vk(fwVarHo) : fwVarHo;
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

    public void hw(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.pr = (SparseArray) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.hw = (String) obj2;
        }
    }

    public SparseArray rc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.pr);
        sparseArray.put(2, this.hw);
        return sparseArray;
    }

    public hw(String str) {
        this.mAppId = str;
    }

    private com.byazt.qe.pr z() {
        if (this.hn == null && this.pr != null) {
            this.hn = new com.byazt.qe.pr(this.pr);
        }
        return this.hn;
    }

    @Override // com.byazt.vkw.pr
    public String pr() {
        return this.mAppId;
    }

    @Override // com.byazt.vkw.pr
    public boolean hw() {
        return com.byazt.mp.hn.pr().hw();
    }

    @Override // com.byazt.vkw.pr
    public Object pr(String str) {
        Map<String, Object> mapYb;
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null || (mapYb = prVarZ.yb()) == null) {
            return null;
        }
        return mapYb.get(str);
    }

    @Override // com.byazt.vkw.pr
    public String hn() {
        String str = this.hw;
        if (str != null) {
            return str;
        }
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return "";
        }
        String strHw = prVarZ.hw();
        this.hw = strHw;
        if (TextUtils.isEmpty(strHw)) {
            this.hw = com.byazt.hb.pr.vk();
        }
        return this.hw;
    }

    @Override // com.byazt.vkw.pr
    public boolean x() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return false;
        }
        return prVarZ.hn();
    }

    @Override // com.byazt.vkw.pr
    public String c() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return "";
        }
        return prVarZ.x();
    }

    @Override // com.byazt.vkw.pr
    public String uc() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return "";
        }
        return prVarZ.c();
    }

    @Override // com.byazt.vkw.pr
    public int fw() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return 0;
        }
        return prVarZ.uc();
    }

    @Override // com.byazt.vkw.pr
    public boolean zo() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return false;
        }
        return prVarZ.fw();
    }

    @Override // com.byazt.vkw.pr
    public boolean aj() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return false;
        }
        return prVarZ.zo();
    }

    @Override // com.byazt.vkw.pr
    public int[] vk() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return new int[0];
        }
        return prVarZ.aj();
    }

    @Override // com.byazt.vkw.pr
    public com.byazt.vlp.hw w() {
        com.byazt.vlp.hw hwVar = this.c;
        if (hwVar != null) {
            return hwVar;
        }
        b();
        return this.c;
    }

    @Override // com.byazt.vkw.pr
    public int k() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return 0;
        }
        return prVarZ.k();
    }

    private void b() {
        com.byazt.qam.fw fwVarYb = com.byazt.sd.zo.nt().yb();
        if (fwVarYb == null) {
            return;
        }
        this.c = new com.byazt.xc.pr(fwVarYb);
    }

    @Override // com.byazt.vkw.pr
    public int m() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return 0;
        }
        return prVarZ.m();
    }

    @Override // com.byazt.vkw.pr
    public int g() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return 0;
        }
        return prVarZ.g();
    }

    @Override // com.byazt.vkw.pr
    public com.byazt.vlp.fw ho() {
        com.byazt.vlp.fw fwVar = this.x;
        if (fwVar != null) {
            return fwVar;
        }
        iu();
        return this.x;
    }

    private void iu() {
        com.byazt.or.pr prVarHo;
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null || (prVarHo = prVarZ.ho()) == null) {
            return;
        }
        this.x = new com.byazt.xc.hw(prVarHo);
    }

    @Override // com.byazt.vkw.pr
    public boolean nt() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return false;
        }
        return prVarZ.nt();
    }

    @Override // com.byazt.vkw.pr
    public Map<String, Object> yb() {
        com.byazt.qe.pr prVarZ = z();
        if (prVarZ == null) {
            return Collections.emptyMap();
        }
        return prVarZ.yb();
    }

    @Override // com.byazt.vkw.pr
    public void pr(SparseArray sparseArray) {
        if (this.pr == sparseArray) {
            return;
        }
        this.pr = sparseArray;
        this.hn = new com.byazt.qe.pr(sparseArray);
        if (this.x != null) {
            iu();
        }
        if (this.c != null) {
            b();
        }
    }

    @Override // com.byazt.vkw.pr
    public String lb() {
        return com.byazt.hb.pr.c();
    }

    @Override // com.byazt.vkw.pr
    public String qa() {
        return ls.zo();
    }

    @Override // com.byazt.vkw.pr
    public String a() {
        return ls.aj();
    }

    @Override // com.byazt.vkw.pr
    public String cz() {
        return iu.c;
    }

    @Override // com.byazt.vkw.pr
    public boolean ny() {
        return iu.pr();
    }

    @Override // com.byazt.vkw.pr
    public String fo() {
        return com.byazt.hb.pr.aj();
    }

    public <T> T hw(String str) {
        return (T) uc.pr(str, this);
    }
}
