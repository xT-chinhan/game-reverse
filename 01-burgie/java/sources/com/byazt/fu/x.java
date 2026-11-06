package com.byazt.fu;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1766, 121})
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
    /* JADX WARN: Code duplicated, block: B:33:0x0167  */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        Object hwVar;
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
                    Object obj3 = sparseArray.get(2);
                    Object obj4 = sparseArray.get(3);
                    Object obj5 = sparseArray.get(4);
                    Object obj6 = sparseArray.get(5);
                    Object obj7 = sparseArray.get(6);
                    Object obj8 = sparseArray.get(7);
                    hwVar = sparseArray.get(8);
                    if (hwVar != null) {
                        hwVar = new com.byazt.ttf.hw((Function) hwVar);
                    }
                    pr((String) obj2, (String) obj3, (String) obj4, (String) obj5, (String) obj6, (String) obj7, (JSONObject) obj8, (com.byazt.ttf.pr) hwVar);
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                Object obj9 = sparseArray.get(1);
                Object obj10 = sparseArray.get(2);
                Object obj11 = sparseArray.get(3);
                Object obj12 = sparseArray.get(4);
                Object obj13 = sparseArray.get(5);
                Object obj14 = sparseArray.get(6);
                Object obj15 = sparseArray.get(7);
                hwVar = sparseArray.get(8);
                if (hwVar != null) {
                    hwVar = new com.byazt.ttf.hw((Function) hwVar);
                }
                pr((String) obj9, (String) obj10, (String) obj11, (String) obj12, (String) obj13, (String) obj14, (JSONObject) obj15, (com.byazt.ttf.pr) hwVar);
                return null;
            case 2:
                Object obj16 = sparseArray.get(1);
                Object obj17 = sparseArray.get(2);
                Object hwVar2 = sparseArray.get(3);
                if (hwVar2 != null) {
                    hwVar2 = new com.byazt.ttf.hw((Function) hwVar2);
                }
                pr((String) obj16, ((Byte) obj17).byteValue(), (com.byazt.ttf.pr) hwVar2);
                return null;
            case 3:
                pr((JSONObject) sparseArray.get(1), ((Byte) sparseArray.get(2)).byteValue());
                return null;
            case 4:
                pr();
                return null;
            case 5:
                pr((String) sparseArray.get(1), (List) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), (Map) sparseArray.get(4), (JSONObject) sparseArray.get(5));
                return null;
            case 6:
                pr((String) sparseArray.get(1));
                return null;
            case 7:
                pr(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 8:
                Object hwVar3 = sparseArray.get(1);
                if (hwVar3 != null) {
                    hwVar3 = new hw((Function) hwVar3);
                }
                pr((pr) hwVar3);
                return null;
            case 9:
                Object hwVar4 = sparseArray.get(1);
                if (hwVar4 != null) {
                    hwVar4 = new hw((Function) hwVar4);
                }
                hw((pr) hwVar4);
                return null;
            case 10:
                return hw();
            case 11:
                return Boolean.valueOf(pr((String) sparseArray.get(1), ((Double) sparseArray.get(2)).doubleValue()));
            case 12:
                return hn();
        }
    }

    @Override // com.byazt.fu.hn
    public String hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public String hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void hw(pr prVar) {
        if (this.hw != null) {
            this.hw.hw(prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        if (prVar != null) {
            prVar = new hw(prVar);
        }
        sparseArray.put(1, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr() {
        if (this.hw != null) {
            this.hw.pr();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr(pr prVar) {
        if (this.hw != null) {
            this.hw.pr(prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        if (prVar != null) {
            prVar = new hw(prVar);
        }
        sparseArray.put(1, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr(String str) {
        if (this.hw != null) {
            this.hw.pr(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr(String str, byte b, com.byazt.ttf.pr prVar) {
        if (this.hw != null) {
            this.hw.pr(str, b, prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Byte.valueOf(b));
        if (prVar != null) {
            prVar = new com.byazt.ttf.hw(prVar);
        }
        sparseArray.put(3, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, com.byazt.ttf.pr prVar) {
        com.byazt.ttf.pr hwVar = prVar;
        if (this.hw != null) {
            this.hw.pr(str, str2, str3, str4, str5, str6, jSONObject, prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, str3);
        sparseArray.put(4, str4);
        sparseArray.put(5, str5);
        sparseArray.put(6, str6);
        sparseArray.put(7, jSONObject);
        if (hwVar != null) {
            hwVar = new com.byazt.ttf.hw(hwVar);
        }
        sparseArray.put(8, hwVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr(String str, List list, boolean z, Map map, JSONObject jSONObject) {
        if (this.hw != null) {
            this.hw.pr(str, list, z, map, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, list);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, map);
        sparseArray.put(5, jSONObject);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr(JSONObject jSONObject, byte b) {
        if (this.hw != null) {
            this.hw.pr(jSONObject, b);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, jSONObject);
        sparseArray.put(2, Byte.valueOf(b));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public void pr(boolean z) {
        if (this.hw != null) {
            this.hw.pr(z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.fu.hn
    public boolean pr(String str, double d) {
        if (this.hw != null) {
            return this.hw.pr(str, d);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, Double.valueOf(d));
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
