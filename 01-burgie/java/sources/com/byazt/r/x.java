package com.byazt.r;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.la.c;
import com.byazt.la.fw;
import com.byazt.la.k;
import com.byazt.la.uc;
import com.byazt.la.w;
import com.byazt.la.zo;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 203, 121})
public class x implements hn, Function {
    public volatile hn hw;
    public volatile Function pr;

    public x(hn hnVar) {
        this.hw = hnVar;
    }

    public x(Function function) {
        this.pr = function;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x0143  */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object ucVar;
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                return this.hw != null ? this.hw : this.pr;
            case -4:
                Function function = (Function) sparseArray.get(1);
                if (function != null) {
                    this.pr = function;
                    this.hw = null;
                    Object obj2 = sparseArray.get(1);
                    ucVar = sparseArray.get(2);
                    if (ucVar != null) {
                        ucVar = new uc((Function) ucVar);
                    }
                    pr((Context) obj2, (c) ucVar);
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                Object obj3 = sparseArray.get(1);
                ucVar = sparseArray.get(2);
                if (ucVar != null) {
                    ucVar = new uc((Function) ucVar);
                }
                pr((Context) obj3, (c) ucVar);
                return null;
            case 2:
                pr((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 3:
                Object obj4 = sparseArray.get(1);
                Object obj5 = sparseArray.get(2);
                Object obj6 = sparseArray.get(3);
                Object obj7 = sparseArray.get(4);
                Object kVar = sparseArray.get(5);
                if (kVar != null) {
                    kVar = new k((Function) kVar);
                }
                pr((String) obj4, (JSONObject) obj5, ((Boolean) obj6).booleanValue(), ((Long) obj7).longValue(), (w) kVar);
                return null;
            case 4:
                Object obj8 = sparseArray.get(1);
                Object hwVar = sparseArray.get(2);
                if (hwVar != null) {
                    hwVar = new com.byazt.la.hw((Function) hwVar);
                }
                pr((String) obj8, (com.byazt.la.pr) hwVar);
                return null;
            case 5:
                Object obj9 = sparseArray.get(1);
                Object hwVar2 = sparseArray.get(2);
                if (hwVar2 != null) {
                    hwVar2 = new com.byazt.la.hw((Function) hwVar2);
                }
                hw((String) obj9, (com.byazt.la.pr) hwVar2);
                return null;
            case 6:
                pr();
                return null;
            case 7:
                pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 8:
                return Integer.valueOf(hw());
            case 9:
                return hn();
            case 10:
                pr((String) sparseArray.get(1));
                return null;
            case 11:
                hw((String) sparseArray.get(1));
                return null;
            case 12:
                Object obj10 = sparseArray.get(1);
                Object zoVar = sparseArray.get(2);
                if (zoVar != null) {
                    zoVar = new zo((Function) zoVar);
                }
                pr((String) obj10, (fw) zoVar);
                return null;
            case 13:
                hn((String) sparseArray.get(1));
                return null;
        }
    }

    @Override // com.byazt.r.hn
    public String hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void hn(String str) {
        if (this.hw != null) {
            this.hw.hn(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public int hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.r.hn
    public void hw(String str) {
        if (this.hw != null) {
            this.hw.hw(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void hw(String str, com.byazt.la.pr prVar) {
        if (this.hw != null) {
            this.hw.hw(str, prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        if (prVar != null) {
            prVar = new com.byazt.la.hw(prVar);
        }
        sparseArray.put(2, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr() {
        if (this.hw != null) {
            this.hw.pr();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr(int i) {
        if (this.hw != null) {
            this.hw.pr(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr(Context context, c cVar) {
        if (this.hw != null) {
            this.hw.pr(context, cVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        if (cVar != null) {
            cVar = new uc(cVar);
        }
        sparseArray.put(2, cVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr(String str) {
        if (this.hw != null) {
            this.hw.pr(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr(String str, fw fwVar) {
        if (this.hw != null) {
            this.hw.pr(str, fwVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, str);
        if (fwVar != null) {
            fwVar = new zo(fwVar);
        }
        sparseArray.put(2, fwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr(String str, com.byazt.la.pr prVar) {
        if (this.hw != null) {
            this.hw.pr(str, prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        if (prVar != null) {
            prVar = new com.byazt.la.hw(prVar);
        }
        sparseArray.put(2, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr(String str, String str2) {
        if (this.hw != null) {
            this.hw.pr(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.hn
    public void pr(String str, JSONObject jSONObject, boolean z, long j, w wVar) {
        if (this.hw != null) {
            this.hw.pr(str, jSONObject, z, j, wVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, Long.valueOf(j));
        if (wVar != null) {
            wVar = new k(wVar);
        }
        sparseArray.put(5, wVar);
        this.pr.apply(sparseArray);
    }
}
