package com.byazt.qk;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.io.File;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMaxIpCountEachDomain, 110})
public class sz implements oa, Function {
    public volatile Function n;
    public volatile oa qg;

    public sz(oa oaVar) {
        this.qg = oaVar;
    }

    public sz(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.qg.n());
            case 2:
                return this.qg.qg();
            case 3:
                return this.qg.s();
            case 4:
                return this.qg.n((String) sparseArray.get(1));
            case 5:
                return this.qg.n((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 6:
                return this.qg.q();
            case 7:
                return this.qg.l();
            case 8:
                tj tjVarW = this.qg.w();
                return tjVarW != null ? new cp(tjVarW) : tjVarW;
            case 9:
                return Boolean.valueOf(this.qg.x());
            case 10:
                return this.qg.fs();
            case 11:
                return Long.valueOf(this.qg.rv());
            case 12:
                return this.qg.tj();
            case 13:
                return this.qg.cp();
            case 14:
                return this.qg.d();
            case 15:
                return this.qg.oa();
            default:
                return null;
        }
    }

    @Override // com.byazt.qk.oa
    public Throwable cp() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (Throwable) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public String d() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.n.apply(sparseArray);
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

    @Override // com.byazt.qk.oa
    public String fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.n.apply(sparseArray);
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

    @Override // com.byazt.qk.oa
    public JSONObject l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public int n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.qk.oa
    public String n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public String n(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public String oa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public byte[] q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (byte[]) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public String qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public long rv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.qk.oa
    public Map s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (Map) this.n.apply(sparseArray);
    }

    @Override // com.byazt.qk.oa
    public File tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (File) this.n.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.qk.oa
    public tj w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        ?? Apply = this.n.apply(sparseArray);
        ?? cpVar = Apply;
        if (Apply != 0) {
            cpVar = new cp((Function) Apply);
        }
        return (tj) cpVar;
    }

    @Override // com.byazt.qk.oa
    public boolean x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }
}
