package com.byazt.qp;

import java.util.Collections;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 525, 5})
public final class q implements Function<Object, Object> {
    public static final String TAG = "AutoService";
    public static q qg;
    public int s = com.byazt.nf.tj.qg;
    public final n n = new n();

    private q() {
    }

    public static q n() {
        q qVar = qg;
        if (qVar != null) {
            return qVar;
        }
        synchronized (q.class) {
            if (qg == null) {
                System.currentTimeMillis();
                qg = new q();
                System.currentTimeMillis();
            }
        }
        return qg;
    }

    public static <T> T n(String str) {
        return (T) n(str, null);
    }

    public static <T> T n(String str, com.byazt.vf.n nVar) {
        n nVar2 = n().n;
        T t = (T) nVar2.n(str, nVar, true);
        return t == null ? (T) nVar2.n(str, nVar) : t;
    }

    public void n(tj tjVar) {
        this.n.n(tjVar);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        try {
            if (obj == null) {
                return Collections.unmodifiableMap(this.n.n());
            }
            if (obj instanceof Function) {
                this.n.n(this, (Function) obj);
            } else {
                if (obj instanceof String) {
                    return this.n.n(String.valueOf(obj), null, false);
                }
                if (obj instanceof Integer) {
                    return Integer.valueOf(this.s);
                }
            }
            return this.n.n(obj);
        } catch (Exception e) {
            tj tjVarW = this.n.w();
            if (tjVarW != null) {
                tjVarW.n(0, obj == null ? "" : obj.getClass().getName() + " " + obj, e);
            }
            return null;
        }
    }

    public static com.byazt.vf.n qg(String str) {
        return n().n.n(str);
    }

    public int qg() {
        return this.s;
    }

    public d s(String str) {
        return this.n.x().n(str);
    }

    public void s() {
        com.byazt.dq.n.n();
    }

    public void q() {
        this.n.fs();
    }
}
