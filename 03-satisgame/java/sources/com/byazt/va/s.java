package com.byazt.va;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 44, 8})
public class s implements Callable<com.byazt.ahu.n> {
    public final n n;
    public Long qg;

    public s(n nVar, Long l) {
        Long.valueOf(0L);
        this.n = nVar;
        this.qg = l;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.byazt.ahu.n call() throws Exception {
        Future futureN = com.byazt.dp.n.n(new Callable<com.byazt.ahu.n>() { // from class: com.byazt.va.s.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public com.byazt.ahu.n call() throws Exception {
                try {
                    return s.this.n.n();
                } catch (Exception e) {
                    com.byazt.nt.n.qg("__kiteFingerTask#future call error " + e.getMessage());
                    return new com.byazt.ahu.n();
                }
            }
        });
        try {
            if (this.qg.longValue() > 0) {
                return (com.byazt.ahu.n) futureN.get(this.qg.longValue(), TimeUnit.SECONDS);
            }
            return (com.byazt.ahu.n) futureN.get();
        } catch (TimeoutException e) {
            com.byazt.nt.n.qg("__kiteFingerTask# collection timed out" + e.getMessage());
            return new com.byazt.ahu.n();
        }
    }
}
