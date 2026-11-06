package com.byazt.qk;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMaxIpCountEachDomain, 13})
public class w implements l, Function {
    public volatile Function n;
    public volatile l qg;

    public w(l lVar) {
        this.qg = lVar;
    }

    public w(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -5) {
            return this.qg != null ? this.qg : this.n;
        }
        if (iIntValue == -4) {
            Function function = (Function) sparseArray.get(1);
            if (function != null) {
                this.n = function;
                this.qg = null;
            }
        } else if (iIntValue == 1) {
            return n((String) sparseArray.get(1), (byte[]) sparseArray.get(2), (Map) sparseArray.get(3), (String) sparseArray.get(4), (String) sparseArray.get(5), ((Integer) sparseArray.get(6)).intValue());
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // com.byazt.qk.l
    public s n(String str, byte[] bArr, Map map, String str2, String str3, int i) {
        ?? qVar;
        if (this.qg != null) {
            return this.qg.n(str, bArr, map, str2, str3, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, bArr);
        sparseArray.put(3, map);
        sparseArray.put(4, str2);
        sparseArray.put(5, str3);
        sparseArray.put(6, Integer.valueOf(i));
        ?? Apply = this.n.apply(sparseArray);
        if (Apply != 0) {
            qVar = Apply;
            qVar = new q((Function) Apply);
        }
        qVar = Apply;
        return (s) qVar;
    }
}
