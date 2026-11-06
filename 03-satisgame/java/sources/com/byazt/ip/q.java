package com.byazt.ip;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1625, 5})
public final class q {

    public interface n<T> {
        T n();

        boolean n(T t);
    }

    @com.byazt.cp.n(n = {0, 1, 1625, 524})
    public static class qg<T> implements n<T> {
        public final Object[] n;
        public int qg;

        public qg(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.n = new Object[i];
        }

        @Override // com.byazt.ip.q.n
        public T n() {
            int i = this.qg;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.n;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.qg = i - 1;
            return t;
        }

        @Override // com.byazt.ip.q.n
        public boolean n(T t) {
            if (qg(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.qg;
            Object[] objArr = this.n;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.qg = i + 1;
            return true;
        }

        private boolean qg(T t) {
            for (int i = 0; i < this.qg; i++) {
                if (this.n[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
