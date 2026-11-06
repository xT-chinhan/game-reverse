package com.byazt.fz;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1569, 121})
public final class x {

    public interface pr<T> {
        T pr();

        boolean pr(T t);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1569, 759})
    public static class hw<T> implements pr<T> {
        public int hw;
        public final Object[] pr;

        public hw(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.pr = new Object[i];
        }

        @Override // com.byazt.fz.x.pr
        public T pr() {
            int i = this.hw;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.pr;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.hw = i - 1;
            return t;
        }

        @Override // com.byazt.fz.x.pr
        public boolean pr(T t) {
            if (hw(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.hw;
            Object[] objArr = this.pr;
            if (i < objArr.length) {
                objArr[i] = t;
                this.hw = i + 1;
                return true;
            }
            return false;
        }

        private boolean hw(T t) {
            for (int i = 0; i < this.hw; i++) {
                if (this.pr[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
