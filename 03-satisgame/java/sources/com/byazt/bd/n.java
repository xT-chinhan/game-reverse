package com.byazt.bd;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 19})
public abstract class n<K, A> {
    public final s<K> l;
    public com.byazt.yt.s<A> s;
    public final List<InterfaceC0134n> n = new ArrayList(1);
    public boolean q = false;
    public float qg = 0.0f;
    public A w = null;
    public float x = -1.0f;
    public float fs = -1.0f;

    /* JADX INFO: renamed from: com.byazt.bd.n$n, reason: collision with other inner class name */
    public interface InterfaceC0134n {
        void n();
    }

    private interface s<T> {
        boolean n();

        boolean n(float f);

        float q();

        com.byazt.yt.n<T> qg();

        boolean qg(float f);

        float s();
    }

    public abstract A n(com.byazt.yt.n<K> nVar, float f);

    public n(List<? extends com.byazt.yt.n<K>> list) {
        this.l = n(list);
    }

    public void n() {
        this.q = true;
    }

    public void n(InterfaceC0134n interfaceC0134n) {
        this.n.add(interfaceC0134n);
    }

    public void n(float f) {
        if (this.l.n()) {
            return;
        }
        if (f < rv()) {
            f = rv();
        } else if (f > w()) {
            f = w();
        }
        if (f == this.qg) {
            return;
        }
        this.qg = f;
        if (this.l.n(f)) {
            qg();
        }
    }

    public void qg() {
        for (int i = 0; i < this.n.size(); i++) {
            this.n.get(i).n();
        }
    }

    public com.byazt.yt.n<K> s() {
        com.byazt.pp.l.n("BaseKeyframeAnimation#getCurrentKeyframe");
        com.byazt.yt.n<K> nVarQg = this.l.qg();
        com.byazt.pp.l.qg("BaseKeyframeAnimation#getCurrentKeyframe");
        return nVarQg;
    }

    public float q() {
        if (this.q) {
            return 0.0f;
        }
        com.byazt.yt.n<K> nVarS = s();
        if (nVarS.l()) {
            return 0.0f;
        }
        return (this.qg - nVarS.s()) / (nVarS.q() - nVarS.s());
    }

    public float l() {
        com.byazt.yt.n<K> nVarS = s();
        if (nVarS == null || nVarS.l()) {
            return 0.0f;
        }
        return nVarS.s.getInterpolation(q());
    }

    private float rv() {
        if (this.x == -1.0f) {
            this.x = this.l.s();
        }
        return this.x;
    }

    public float w() {
        if (this.fs == -1.0f) {
            this.fs = this.l.q();
        }
        return this.fs;
    }

    public A x() {
        A aN;
        float fQ = q();
        if (this.s == null && this.l.qg(fQ)) {
            return this.w;
        }
        com.byazt.yt.n<K> nVarS = s();
        if (nVarS.q != null && nVarS.l != null) {
            aN = n(nVarS, fQ, nVarS.q.getInterpolation(fQ), nVarS.l.getInterpolation(fQ));
        } else {
            aN = n(nVarS, l());
        }
        this.w = aN;
        return aN;
    }

    public float fs() {
        return this.qg;
    }

    public A n(com.byazt.yt.n<K> nVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> s<T> n(List<? extends com.byazt.yt.n<T>> list) {
        if (list.isEmpty()) {
            return new qg();
        }
        if (list.size() == 1) {
            return new l(list);
        }
        return new q(list);
    }

    @com.byazt.cp.n(n = {0, 1, 893, 226})
    private static final class qg<T> implements s<T> {
        @Override // com.byazt.bd.n.s
        public boolean n() {
            return true;
        }

        @Override // com.byazt.bd.n.s
        public boolean n(float f) {
            return false;
        }

        @Override // com.byazt.bd.n.s
        public float q() {
            return 1.0f;
        }

        @Override // com.byazt.bd.n.s
        public float s() {
            return 0.0f;
        }

        private qg() {
        }

        @Override // com.byazt.bd.n.s
        public com.byazt.yt.n<T> qg() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.byazt.bd.n.s
        public boolean qg(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    @com.byazt.cp.n(n = {0, 1, 893, 1705})
    private static final class l<T> implements s<T> {
        public final com.byazt.yt.n<T> n;
        public float qg = -1.0f;

        @Override // com.byazt.bd.n.s
        public boolean n() {
            return false;
        }

        public l(List<? extends com.byazt.yt.n<T>> list) {
            this.n = list.get(0);
        }

        @Override // com.byazt.bd.n.s
        public boolean n(float f) {
            return !this.n.l();
        }

        @Override // com.byazt.bd.n.s
        public com.byazt.yt.n<T> qg() {
            return this.n;
        }

        @Override // com.byazt.bd.n.s
        public float s() {
            return this.n.s();
        }

        @Override // com.byazt.bd.n.s
        public float q() {
            return this.n.q();
        }

        @Override // com.byazt.bd.n.s
        public boolean qg(float f) {
            if (this.qg == f) {
                return true;
            }
            this.qg = f;
            return false;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 893, 1125})
    private static final class q<T> implements s<T> {
        public final List<? extends com.byazt.yt.n<T>> n;
        public com.byazt.yt.n<T> s = null;
        public float q = -1.0f;
        public com.byazt.yt.n<T> qg = s(0.0f);

        @Override // com.byazt.bd.n.s
        public boolean n() {
            return false;
        }

        public q(List<? extends com.byazt.yt.n<T>> list) {
            this.n = list;
        }

        @Override // com.byazt.bd.n.s
        public boolean n(float f) {
            if (this.qg.n(f)) {
                return !this.qg.l();
            }
            this.qg = s(f);
            return true;
        }

        private com.byazt.yt.n<T> s(float f) {
            List<? extends com.byazt.yt.n<T>> list = this.n;
            com.byazt.yt.n<T> nVar = list.get(list.size() - 1);
            if (f >= nVar.s()) {
                return nVar;
            }
            for (int size = this.n.size() - 2; size > 0; size--) {
                com.byazt.yt.n<T> nVar2 = this.n.get(size);
                if (this.qg != nVar2 && nVar2.n(f)) {
                    return nVar2;
                }
            }
            return this.n.get(0);
        }

        @Override // com.byazt.bd.n.s
        public com.byazt.yt.n<T> qg() {
            return this.qg;
        }

        @Override // com.byazt.bd.n.s
        public float s() {
            return this.n.get(0).s();
        }

        @Override // com.byazt.bd.n.s
        public float q() {
            List<? extends com.byazt.yt.n<T>> list = this.n;
            return list.get(list.size() - 1).q();
        }

        @Override // com.byazt.bd.n.s
        public boolean qg(float f) {
            com.byazt.yt.n<T> nVar = this.s;
            com.byazt.yt.n<T> nVar2 = this.qg;
            if (nVar == nVar2 && this.q == f) {
                return true;
            }
            this.s = nVar2;
            this.q = f;
            return false;
        }
    }
}
