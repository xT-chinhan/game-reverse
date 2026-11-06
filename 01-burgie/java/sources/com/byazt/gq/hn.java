package com.byazt.gq;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1588, 20})
public class hn implements Callable<com.byazt.jdi.pr> {
    public Long hw;
    public final pr pr;

    public hn(pr prVar, Long l) {
        this.hw = 0L;
        this.pr = prVar;
        this.hw = l;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.byazt.jdi.pr call() throws Exception {
        Future futurePr = com.byazt.jcn.pr.pr(new Callable<com.byazt.jdi.pr>() { // from class: com.byazt.gq.hn.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public com.byazt.jdi.pr call() throws Exception {
                try {
                    return hn.this.pr.pr();
                } catch (Exception e) {
                    com.byazt.wx.pr.hw("__kiteFingerTask#future call error " + e.getMessage());
                    return new com.byazt.jdi.pr();
                }
            }
        });
        try {
            if (this.hw.longValue() > 0) {
                return (com.byazt.jdi.pr) futurePr.get(this.hw.longValue(), TimeUnit.SECONDS);
            }
            return (com.byazt.jdi.pr) futurePr.get();
        } catch (TimeoutException e) {
            com.byazt.wx.pr.hw("__kiteFingerTask# collection timed out" + e.getMessage());
            return new com.byazt.jdi.pr();
        }
    }
}
