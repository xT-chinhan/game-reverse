package com.byazt.ot;

import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 50, 5})
public class q implements n.qg {
    public final Map<Integer, WeakReference<n.qg>> n = new HashMap();

    @Override // com.byazt.ot.n.qg
    public void q() {
    }

    @Override // com.byazt.ot.n.qg
    public void s() {
    }

    public void n(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        function.apply(com.byazt.of.qg.n().n(9).n(Boolean.class).n(0, new s() { // from class: com.byazt.ot.q.1
            @Override // com.byazt.ot.s
            public void qg() {
                q.this.n();
            }

            @Override // com.byazt.ot.s
            public void n() {
                q.this.qg();
            }
        }).qg());
    }

    public void n(n.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        this.n.put(Integer.valueOf(qgVar.hashCode()), new WeakReference<>(qgVar));
    }

    public void qg(n.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        this.n.remove(Integer.valueOf(qgVar.hashCode()));
    }

    @Override // com.byazt.ot.n.qg
    public void n() {
        Iterator<Map.Entry<Integer, WeakReference<n.qg>>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<n.qg> value = it.next().getValue();
            if (value != null) {
                n.qg qgVar = value.get();
                if (qgVar != null) {
                    qgVar.n();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }

    @Override // com.byazt.ot.n.qg
    public void qg() {
        Iterator<Map.Entry<Integer, WeakReference<n.qg>>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<n.qg> value = it.next().getValue();
            if (value != null) {
                n.qg qgVar = value.get();
                if (qgVar != null) {
                    qgVar.qg();
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
    }
}
