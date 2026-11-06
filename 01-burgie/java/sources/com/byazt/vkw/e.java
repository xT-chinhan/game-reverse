package com.byazt.vkw;

import android.content.Context;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 105})
public class e implements n, Function {
    public volatile n hw;
    public volatile Function pr;

    public e(n nVar) {
        this.hw = nVar;
    }

    public e(Function function) {
        this.pr = function;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
                    return pr((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), ((Long) sparseArray.get(3)).longValue(), (JSONObject) sparseArray.get(4), (Looper) sparseArray.get(5));
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr((Context) sparseArray.get(1), ((Boolean) sparseArray.get(2)).booleanValue(), ((Long) sparseArray.get(3)).longValue(), (JSONObject) sparseArray.get(4), (Looper) sparseArray.get(5));
            case 2:
                return pr((Context) sparseArray.get(1), (String) sparseArray.get(2));
            case 3:
                pr((Context) sparseArray.get(1), (String) sparseArray.get(2), ((Integer) sparseArray.get(3)).intValue(), (String[]) sparseArray.get(4), (long[]) sparseArray.get(5), ((Boolean) sparseArray.get(6)).booleanValue());
                return null;
            case 4:
                return Boolean.valueOf(pr());
            case 5:
                pr(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 6:
                return hw();
            case 7:
                return hn();
            case 8:
                return Integer.valueOf(x());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vkw.n
    public com.byazt.ihe.pr hn() {
        ?? hwVar;
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            hwVar = Apply;
            hwVar = new com.byazt.ihe.hw((Function) Apply);
        }
        hwVar = Apply;
        return (com.byazt.ihe.pr) hwVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @Override // com.byazt.vkw.n
    public com.byazt.ihe.vk hw() {
        ?? kVar;
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            kVar = Apply;
            kVar = new com.byazt.ihe.k((Function) Apply);
        }
        kVar = Apply;
        return (com.byazt.ihe.vk) kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.byazt.vkw.n
    public com.byazt.ihe.fw pr(Context context, String str) {
        ?? ajVar;
        if (this.hw != null) {
            return this.hw.pr(context, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            ajVar = Apply;
            ajVar = new com.byazt.ihe.aj((Function) Apply);
        }
        ajVar = Apply;
        return (com.byazt.ihe.fw) ajVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // com.byazt.vkw.n
    public com.byazt.ihe.fw pr(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        ?? ajVar;
        if (this.hw != null) {
            return this.hw.pr(context, z, j, jSONObject, looper);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, Boolean.valueOf(z));
        sparseArray.put(3, Long.valueOf(j));
        sparseArray.put(4, jSONObject);
        sparseArray.put(5, looper);
        ?? Apply = this.pr.apply(sparseArray);
        if (Apply != 0) {
            ajVar = Apply;
            ajVar = new com.byazt.ihe.aj((Function) Apply);
        }
        ajVar = Apply;
        return (com.byazt.ihe.fw) ajVar;
    }

    @Override // com.byazt.vkw.n
    public void pr(Context context, String str, int i, String[] strArr, long[] jArr, boolean z) {
        if (this.hw != null) {
            this.hw.pr(context, str, i, strArr, jArr, z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, strArr);
        sparseArray.put(5, jArr);
        sparseArray.put(6, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.n
    public void pr(boolean z) {
        if (this.hw != null) {
            this.hw.pr(z);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.n
    public boolean pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.n
    public int x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }
}
