package com.bytedance.adsdk.lottie.ms.xr;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms<K, A> {
    protected com.bytedance.adsdk.lottie.c.ah<A> ah;
    private final ah<K> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final List<InterfaceC0189ms> f261ms = new ArrayList(1);
    private boolean d = false;
    protected float xr = 0.0f;
    private A c = null;
    private float ab = -1.0f;
    private float x = -1.0f;

    private interface ah<T> {
        float ah();

        float d();

        boolean ms();

        boolean ms(float f);

        com.bytedance.adsdk.lottie.c.ms<T> xr();

        boolean xr(float f);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.ms.xr.ms$ms, reason: collision with other inner class name */
    public interface InterfaceC0189ms {
        void ms();
    }

    abstract A ms(com.bytedance.adsdk.lottie.c.ms<K> msVar, float f);

    ms(List<? extends com.bytedance.adsdk.lottie.c.ms<K>> list) {
        this.ka = ms(list);
    }

    public void ms() {
        this.d = true;
    }

    public void ms(InterfaceC0189ms interfaceC0189ms) {
        this.f261ms.add(interfaceC0189ms);
    }

    public void ms(float f) {
        if (this.ka.ms()) {
            return;
        }
        if (f < ny()) {
            f = ny();
        } else if (f > c()) {
            f = c();
        }
        if (f == this.xr) {
            return;
        }
        this.xr = f;
        if (this.ka.ms(f)) {
            xr();
        }
    }

    public void xr() {
        for (int i = 0; i < this.f261ms.size(); i++) {
            this.f261ms.get(i).ms();
        }
    }

    protected com.bytedance.adsdk.lottie.c.ms<K> ah() {
        com.bytedance.adsdk.lottie.ka.ms("BaseKeyframeAnimation#getCurrentKeyframe");
        com.bytedance.adsdk.lottie.c.ms<K> msVarXr = this.ka.xr();
        com.bytedance.adsdk.lottie.ka.xr("BaseKeyframeAnimation#getCurrentKeyframe");
        return msVarXr;
    }

    float d() {
        if (this.d) {
            return 0.0f;
        }
        com.bytedance.adsdk.lottie.c.ms<K> msVarAh = ah();
        if (msVarAh.ka()) {
            return 0.0f;
        }
        return (this.xr - msVarAh.ah()) / (msVarAh.d() - msVarAh.ah());
    }

    protected float ka() {
        com.bytedance.adsdk.lottie.c.ms<K> msVarAh = ah();
        if (msVarAh == null || msVarAh.ka()) {
            return 0.0f;
        }
        return msVarAh.ah.getInterpolation(d());
    }

    private float ny() {
        if (this.ab == -1.0f) {
            this.ab = this.ka.ah();
        }
        return this.ab;
    }

    float c() {
        if (this.x == -1.0f) {
            this.x = this.ka.d();
        }
        return this.x;
    }

    public A ab() {
        A aMs;
        float fD = d();
        if (this.ah == null && this.ka.xr(fD)) {
            return this.c;
        }
        com.bytedance.adsdk.lottie.c.ms<K> msVarAh = ah();
        if (msVarAh.d != null && msVarAh.ka != null) {
            aMs = ms(msVarAh, fD, msVarAh.d.getInterpolation(fD), msVarAh.ka.getInterpolation(fD));
        } else {
            aMs = ms(msVarAh, ka());
        }
        this.c = aMs;
        return aMs;
    }

    public float x() {
        return this.xr;
    }

    protected A ms(com.bytedance.adsdk.lottie.c.ms<K> msVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> ah<T> ms(List<? extends com.bytedance.adsdk.lottie.c.ms<T>> list) {
        if (list.isEmpty()) {
            return new xr();
        }
        if (list.size() == 1) {
            return new ka(list);
        }
        return new d(list);
    }

    private static final class xr<T> implements ah<T> {
        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public float ah() {
            return 0.0f;
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public float d() {
            return 1.0f;
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean ms() {
            return true;
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean ms(float f) {
            return false;
        }

        private xr() {
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public com.bytedance.adsdk.lottie.c.ms<T> xr() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean xr(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    private static final class ka<T> implements ah<T> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final com.bytedance.adsdk.lottie.c.ms<T> f263ms;
        private float xr = -1.0f;

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean ms() {
            return false;
        }

        ka(List<? extends com.bytedance.adsdk.lottie.c.ms<T>> list) {
            this.f263ms = list.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean ms(float f) {
            return !this.f263ms.ka();
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public com.bytedance.adsdk.lottie.c.ms<T> xr() {
            return this.f263ms;
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public float ah() {
            return this.f263ms.ah();
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public float d() {
            return this.f263ms.d();
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean xr(float f) {
            if (this.xr == f) {
                return true;
            }
            this.xr = f;
            return false;
        }
    }

    private static final class d<T> implements ah<T> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final List<? extends com.bytedance.adsdk.lottie.c.ms<T>> f262ms;
        private com.bytedance.adsdk.lottie.c.ms<T> ah = null;
        private float d = -1.0f;
        private com.bytedance.adsdk.lottie.c.ms<T> xr = ah(0.0f);

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean ms() {
            return false;
        }

        d(List<? extends com.bytedance.adsdk.lottie.c.ms<T>> list) {
            this.f262ms = list;
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean ms(float f) {
            if (this.xr.ms(f)) {
                return !this.xr.ka();
            }
            this.xr = ah(f);
            return true;
        }

        private com.bytedance.adsdk.lottie.c.ms<T> ah(float f) {
            List<? extends com.bytedance.adsdk.lottie.c.ms<T>> list = this.f262ms;
            com.bytedance.adsdk.lottie.c.ms<T> msVar = list.get(list.size() - 1);
            if (f >= msVar.ah()) {
                return msVar;
            }
            for (int size = this.f262ms.size() - 2; size > 0; size--) {
                com.bytedance.adsdk.lottie.c.ms<T> msVar2 = this.f262ms.get(size);
                if (this.xr != msVar2 && msVar2.ms(f)) {
                    return msVar2;
                }
            }
            return this.f262ms.get(0);
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public com.bytedance.adsdk.lottie.c.ms<T> xr() {
            return this.xr;
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public float ah() {
            return this.f262ms.get(0).ah();
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public float d() {
            List<? extends com.bytedance.adsdk.lottie.c.ms<T>> list = this.f262ms;
            return list.get(list.size() - 1).d();
        }

        @Override // com.bytedance.adsdk.lottie.ms.xr.ms.ah
        public boolean xr(float f) {
            com.bytedance.adsdk.lottie.c.ms<T> msVar = this.ah;
            com.bytedance.adsdk.lottie.c.ms<T> msVar2 = this.xr;
            if (msVar == msVar2 && this.d == f) {
                return true;
            }
            this.ah = msVar2;
            this.d = f;
            return false;
        }
    }
}
