package com.byazt.hcx;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, 5})
public class uc implements c, Function {
    public volatile c hw;
    public volatile Function pr;

    public uc(c cVar) {
        this.hw = cVar;
    }

    public uc(Function function) {
        this.pr = function;
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
                    return pr((String) sparseArray.get(1), (byte[]) sparseArray.get(2), (Map) sparseArray.get(3), (String) sparseArray.get(4), (String) sparseArray.get(5), ((Integer) sparseArray.get(6)).intValue());
                }
                return null;
            case 1:
                return pr((String) sparseArray.get(1), (byte[]) sparseArray.get(2), (Map) sparseArray.get(3), (String) sparseArray.get(4), (String) sparseArray.get(5), ((Integer) sparseArray.get(6)).intValue());
            default:
                return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r9v8 */
    @Override // com.byazt.hcx.c
    public hn pr(String str, byte[] bArr, Map map, String str2, String str3, int i) {
        ?? xVar;
        if (this.hw != null) {
            return this.hw.pr(str, bArr, map, str2, str3, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, str);
        sparseArray.put(2, bArr);
        sparseArray.put(3, map);
        sparseArray.put(4, str2);
        sparseArray.put(5, str3);
        sparseArray.put(6, Integer.valueOf(i));
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            xVar = Apply;
            xVar = new x((Function) Apply);
        }
        xVar = Apply;
        return (hn) xVar;
    }
}
