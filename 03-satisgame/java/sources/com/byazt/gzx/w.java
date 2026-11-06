package com.byazt.gzx;

import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1081, 13})
public class w<T> implements l<T> {
    public final l<T> n;

    public w(l<T> lVar) {
        this.n = lVar;
    }

    @Override // com.byazt.gzx.l
    public void n(final T t, final boolean z, final pk pkVar) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gzx.w.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.n != null) {
                    w.this.n.n(t, z, pkVar);
                }
            }
        });
    }

    @Override // com.byazt.gzx.l
    public void n(final T t) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gzx.w.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.n != null) {
                    w.this.n.n(t);
                }
            }
        });
    }

    @Override // com.byazt.gzx.l
    public void n(final int i, final String str) {
        com.byazt.ag.qg.n(new Runnable() { // from class: com.byazt.gzx.w.3
            @Override // java.lang.Runnable
            public void run() {
                if (w.this.n != null) {
                    w.this.n.n(i, str);
                }
            }
        });
    }
}
