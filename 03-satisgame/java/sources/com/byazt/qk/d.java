package com.byazt.qk;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMaxIpCountEachDomain, 113})
public class d implements rv, Function {
    public volatile Function n;
    public volatile rv qg;

    public d(rv rvVar) {
        this.qg = rvVar;
    }

    public d(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.qg.n(((Integer) sparseArray.get(1)).intValue());
            case 2:
                return this.qg.n((String) sparseArray.get(1));
            case 3:
                return this.qg.n((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 4:
                return this.qg.qg((String) sparseArray.get(1));
            case 5:
                return this.qg.n((byte[]) sparseArray.get(1));
            case 6:
                return this.qg.qg((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 7:
                return this.qg.s((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 8:
                return this.qg.n((String) sparseArray.get(1), (String) sparseArray.get(2), (byte[]) sparseArray.get(3));
            case 9:
                return this.qg.n((String) sparseArray.get(1), (byte[]) sparseArray.get(2));
            case 10:
                Object qgVar = sparseArray.get(1);
                if (qgVar != null) {
                    qgVar = new qg((Function) qgVar);
                }
                return this.qg.n((n) qgVar);
            case 11:
                oa oaVarN = this.qg.n();
                return oaVarN != null ? new sz(oaVarN) : oaVarN;
            case 12:
                Object fsVar = sparseArray.get(1);
                if (fsVar != null) {
                    fsVar = new fs((Function) fsVar);
                }
                this.qg.n((x) fsVar);
                return null;
            case 13:
                this.qg.qg();
                return null;
            case 14:
                return this.qg.s();
            case 15:
                return this.qg.n((Map<String, Object>) sparseArray.get(1));
            case 16:
                return this.qg.q();
            case 17:
                return this.qg.n((JSONObject) sparseArray.get(1));
            case 18:
                return this.qg.q((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 19:
                return this.qg.l();
            default:
                return null;
        }
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

    @Override // com.byazt.qk.rv
    public rv l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        this.n.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.qk.rv
    public oa n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        ?? Apply = this.n.apply(sparseArray);
        ?? szVar = Apply;
        if (Apply != 0) {
            szVar = new sz((Function) Apply);
        }
        return (oa) szVar;
    }

    @Override // com.byazt.qk.rv
    public rv n(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(n nVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        if (nVar != null) {
            nVar = new qg(nVar);
        }
        sparseArray.put(1, nVar);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str, String str2, byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, bArr);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(String str, byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, bArr);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(Map map) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, map);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, jSONObject);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv n(byte[] bArr) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, bArr);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public void n(x xVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        if (xVar != null) {
            xVar = new fs(xVar);
        }
        sparseArray.put(1, xVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.rv
    public rv q(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public Map q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.rv
    public rv qg(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public rv qg(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public void qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.rv
    public rv s(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.n.apply(sparseArray);
        return this;
    }

    @Override // com.byazt.qk.rv
    public byte[] s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (byte[]) this.n.apply(sparseArray);
    }
}
