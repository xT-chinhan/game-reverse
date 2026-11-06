package com.byazt.ej;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, 110})
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
                this.qg.qg((String) sparseArray.get(1));
                return null;
            case 2:
                return this.qg.s((String) sparseArray.get(1));
            case 3:
                Object obj2 = sparseArray.get(1);
                Object cyVar = sparseArray.get(2);
                if (cyVar != null) {
                    cyVar = new cy((Function) cyVar);
                }
                this.qg.n(((Long) obj2).longValue(), (k) cyVar);
                return null;
            case 4:
                this.qg.n((String) sparseArray.get(1));
                return null;
            case 5:
                this.qg.n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), (String) sparseArray.get(3));
                return null;
            case 6:
                return this.qg.n();
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

    @Override // com.byazt.ej.oa
    public JSONObject n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.oa
    public void n(int i, int i2, String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        sparseArray.put(3, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.oa
    public void n(long j, k kVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Long.valueOf(j));
        if (kVar != null) {
            kVar = new cy(kVar);
        }
        sparseArray.put(2, kVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.oa
    public void n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.oa
    public void qg(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.oa
    public String s(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, str);
        return (String) this.n.apply(sparseArray);
    }
}
