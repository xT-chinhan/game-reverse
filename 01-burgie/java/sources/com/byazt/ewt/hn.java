package com.byazt.ewt;

import com.byazt.ewt.hw;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1073, 20})
public abstract class hn<T, F extends hw> {
    public F hn;
    public T hw;
    public final List<uc<?>> pr = new CopyOnWriteArrayList();

    public final void pr(uc<?> ucVar) {
        if (ucVar != null) {
            this.pr.add(ucVar);
        }
    }

    public final void hw(uc<?> ucVar) {
        if (ucVar != null) {
            this.pr.remove(ucVar);
        }
    }

    public final F getContext() {
        return this.hn;
    }
}
