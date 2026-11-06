package com.byazt.qj;

import android.util.SparseArray;
import com.byazt.of.qg;
import com.byazt.us.s;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1120, 19})
public class n {
    public static s n(final Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            return new s() { // from class: com.byazt.qj.n.1
                @Override // com.byazt.fz.l
                public void n(long j) {
                    function.apply(qg.n().n(8166).n(Void.class).n(8074, Long.valueOf(j)).qg());
                }

                @Override // com.byazt.fz.l
                public void qg(long j) {
                    function.apply(qg.n().n(8167).n(Void.class).n(8074, Long.valueOf(j)).qg());
                }

                @Override // com.byazt.fz.l
                public void n() {
                    function.apply(qg.n().n(8168).n(Void.class).qg());
                }

                @Override // com.byazt.fz.l
                public void s(long j) {
                    function.apply(qg.n().n(8169).n(Void.class).n(8074, Long.valueOf(j)).qg());
                }

                @Override // com.byazt.fz.l
                public void qg() {
                    function.apply(qg.n().n(8170).n(Void.class).qg());
                }

                @Override // com.byazt.fz.l
                public void n(int i, int i2) {
                    function.apply(qg.n().n(8171).n(Void.class).n(8014, Integer.valueOf(i)).n(8075, Integer.valueOf(i2)).qg());
                }

                @Override // com.byazt.fz.l
                public void n(long j, int i, int i2) {
                    function.apply(qg.n().n(8172).n(Void.class).n(8014, Integer.valueOf(i)).n(8075, Integer.valueOf(i2)).n(8074, Long.valueOf(j)).qg());
                }
            };
        }
        return null;
    }
}
