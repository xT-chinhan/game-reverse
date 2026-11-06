package com.byazt.sf;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsGetCustomHttpHeader, 5})
public class q implements s, Function {
    public volatile Function n;
    public volatile s qg;

    public q(s sVar) {
        this.qg = sVar;
    }

    public q(Function function) {
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
                    Object obj2 = sparseArray.get(1);
                    Object obj3 = sparseArray.get(2);
                    Object obj4 = sparseArray.get(3);
                    Object obj5 = sparseArray.get(4);
                    Object obj6 = sparseArray.get(5);
                    Object obj7 = sparseArray.get(6);
                    Object obj8 = sparseArray.get(7);
                    Object qgVar = sparseArray.get(8);
                    if (qgVar != null) {
                        qgVar = new com.byazt.rs.qg((Function) qgVar);
                    }
                    n((String) obj2, (String) obj3, (String) obj4, (String) obj5, (String) obj6, (String) obj7, (JSONObject) obj8, (com.byazt.rs.n) qgVar);
                    break;
                case 2:
                    Object obj9 = sparseArray.get(1);
                    Object obj10 = sparseArray.get(2);
                    Object qgVar2 = sparseArray.get(3);
                    if (qgVar2 != null) {
                        qgVar2 = new com.byazt.rs.qg((Function) qgVar2);
                    }
                    n((String) obj9, ((Byte) obj10).byteValue(), (com.byazt.rs.n) qgVar2);
                    break;
                case 3:
                    n((JSONObject) sparseArray.get(1), ((Byte) sparseArray.get(2)).byteValue());
                    break;
                case 4:
                    n();
                    break;
                case 5:
                    n((String) sparseArray.get(1), (List) sparseArray.get(2), ((Boolean) sparseArray.get(3)).booleanValue(), (Map) sparseArray.get(4), (JSONObject) sparseArray.get(5));
                    break;
                case 6:
                    n((String) sparseArray.get(1));
                    break;
                case 7:
                    n(((Boolean) sparseArray.get(1)).booleanValue());
                    break;
                case 8:
                    Object qgVar3 = sparseArray.get(1);
                    if (qgVar3 != null) {
                        qgVar3 = new qg((Function) qgVar3);
                    }
                    n((n) qgVar3);
                    break;
                case 9:
                    Object qgVar4 = sparseArray.get(1);
                    if (qgVar4 != null) {
                        qgVar4 = new qg((Function) qgVar4);
                    }
                    qg((n) qgVar4);
                    break;
                case 10:
                    return qg();
                case 11:
                    return Boolean.valueOf(n((String) sparseArray.get(1), ((Double) sparseArray.get(2)).doubleValue()));
                case 12:
                    return s();
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

    @Override // com.byazt.sf.s
    public void n() {
        if (this.qg != null) {
            this.qg.n();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void n(n nVar) {
        if (this.qg != null) {
            this.qg.n(nVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        if (nVar != null) {
            nVar = new qg(nVar);
        }
        sparseArray.put(1, nVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void n(String str) {
        if (this.qg != null) {
            this.qg.n(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void n(String str, byte b, com.byazt.rs.n nVar) {
        if (this.qg != null) {
            this.qg.n(str, b, nVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        sparseArray.put(2, Byte.valueOf(b));
        if (nVar != null) {
            nVar = new com.byazt.rs.qg(nVar);
        }
        sparseArray.put(3, nVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void n(String str, String str2, String str3, String str4, String str5, String str6, JSONObject jSONObject, com.byazt.rs.n nVar) {
        com.byazt.rs.n qgVar = nVar;
        if (this.qg != null) {
            this.qg.n(str, str2, str3, str4, str5, str6, jSONObject, nVar);
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
        if (qgVar != null) {
            qgVar = new com.byazt.rs.qg(qgVar);
        }
        sparseArray.put(8, qgVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void n(String str, List list, boolean z, Map map, JSONObject jSONObject) {
        if (this.qg != null) {
            this.qg.n(str, list, z, map, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, list);
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(4, map);
        sparseArray.put(5, jSONObject);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void n(JSONObject jSONObject, byte b) {
        if (this.qg != null) {
            this.qg.n(jSONObject, b);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, jSONObject);
        sparseArray.put(2, Byte.valueOf(b));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void n(boolean z) {
        if (this.qg != null) {
            this.qg.n(z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public boolean n(String str, double d) {
        if (this.qg != null) {
            return this.qg.n(str, d);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, Double.valueOf(d));
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.sf.s
    public String qg() {
        if (this.qg != null) {
            return this.qg.qg();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public void qg(n nVar) {
        if (this.qg != null) {
            this.qg.qg(nVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        if (nVar != null) {
            nVar = new qg(nVar);
        }
        sparseArray.put(1, nVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.sf.s
    public String s() {
        if (this.qg != null) {
            return this.qg.s();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.n.apply(sparseArray);
    }
}
