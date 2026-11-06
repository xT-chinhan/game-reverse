package com.bytedance.sdk.component.widget.recycler.ms.xr;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    public interface ms<T> {
        T ms();

        boolean ms(T t);
    }

    public static class xr<T> implements ms<T> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final Object[] f1423ms;
        private int xr;

        public xr(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1423ms = new Object[i];
        }

        @Override // com.bytedance.sdk.component.widget.recycler.ms.xr.d.ms
        public T ms() {
            int i = this.xr;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.f1423ms;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.xr = i - 1;
            return t;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.ms.xr.d.ms
        public boolean ms(T t) {
            if (xr(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.xr;
            Object[] objArr = this.f1423ms;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.xr = i + 1;
            return true;
        }

        private boolean xr(T t) {
            for (int i = 0; i < this.xr; i++) {
                if (this.f1423ms[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
