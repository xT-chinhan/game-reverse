package com.byazt.dx;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 108})
public final class m<V> {
    public final Throwable hw;
    public final V pr;

    public m(V v) {
        this.pr = v;
        this.hw = null;
    }

    public m(Throwable th) {
        this.hw = th;
        this.pr = null;
    }

    public V pr() {
        return this.pr;
    }

    public Throwable hw() {
        return this.hw;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (pr() != null && pr().equals(mVar.pr())) {
            return true;
        }
        if (hw() == null || mVar.hw() == null) {
            return false;
        }
        return hw().toString().equals(hw().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{pr(), hw()});
    }
}
