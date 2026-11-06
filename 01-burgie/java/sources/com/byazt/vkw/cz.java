package com.byazt.vkw;

import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 213})
public class cz implements a, Function {
    public volatile a hw;
    public volatile Function pr;

    public cz(a aVar) {
        this.hw = aVar;
    }

    public cz(Function function) {
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
                    return pr((Bundle) sparseArray.get(1), sparseArray.get(2));
                }
                return null;
            case 1:
                return pr((Bundle) sparseArray.get(1), sparseArray.get(2));
            default:
                return null;
        }
    }

    @Override // com.byazt.vkw.a
    public Object pr(Bundle bundle, Object obj) {
        if (this.hw != null) {
            return this.hw.pr(bundle, obj);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, bundle);
        sparseArray.put(2, obj);
        return this.pr.apply(sparseArray);
    }
}
