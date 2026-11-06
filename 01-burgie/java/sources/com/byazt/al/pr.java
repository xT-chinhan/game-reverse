package com.byazt.al;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, 37})
public abstract class pr<K, A> {
    public final hn<K> c;
    public com.byazt.cz.hn<A> hn;
    public final List<InterfaceC0016pr> pr = new ArrayList(1);
    public boolean x = false;
    public float hw = 0.0f;
    public A uc = null;
    public float fw = -1.0f;
    public float zo = -1.0f;

    private interface hn<T> {
        float hn();

        com.byazt.cz.pr<T> hw();

        boolean hw(float f);

        boolean pr();

        boolean pr(float f);

        float x();
    }

    /* JADX INFO: renamed from: com.byazt.al.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0016pr {
        void pr();
    }

    public abstract A pr(com.byazt.cz.pr<K> prVar, float f);

    public pr(List<? extends com.byazt.cz.pr<K>> list) {
        this.c = pr(list);
    }

    public void pr() {
        this.x = true;
    }

    public void pr(InterfaceC0016pr interfaceC0016pr) {
        this.pr.add(interfaceC0016pr);
    }

    public void pr(float f) {
        if (this.c.pr()) {
            return;
        }
        if (f < aj()) {
            f = aj();
        } else if (f > uc()) {
            f = uc();
        }
        if (f == this.hw) {
            return;
        }
        this.hw = f;
        if (this.c.pr(f)) {
            hw();
        }
    }

    public void hw() {
        for (int i = 0; i < this.pr.size(); i++) {
            this.pr.get(i).pr();
        }
    }

    public com.byazt.cz.pr<K> hn() {
        com.byazt.dx.c.pr("BaseKeyframeAnimation#getCurrentKeyframe");
        com.byazt.cz.pr<K> prVarHw = this.c.hw();
        com.byazt.dx.c.hw("BaseKeyframeAnimation#getCurrentKeyframe");
        return prVarHw;
    }

    public float x() {
        if (this.x) {
            return 0.0f;
        }
        com.byazt.cz.pr<K> prVarHn = hn();
        if (prVarHn.c()) {
            return 0.0f;
        }
        return (this.hw - prVarHn.hn()) / (prVarHn.x() - prVarHn.hn());
    }

    public float c() {
        com.byazt.cz.pr<K> prVarHn = hn();
        if (prVarHn == null || prVarHn.c()) {
            return 0.0f;
        }
        return prVarHn.hn.getInterpolation(x());
    }

    private float aj() {
        if (this.fw == -1.0f) {
            this.fw = this.c.hn();
        }
        return this.fw;
    }

    public float uc() {
        if (this.zo == -1.0f) {
            this.zo = this.c.x();
        }
        return this.zo;
    }

    public A fw() {
        A aPr;
        float fX = x();
        if (this.hn == null && this.c.hw(fX)) {
            return this.uc;
        }
        com.byazt.cz.pr<K> prVarHn = hn();
        if (prVarHn.x != null && prVarHn.c != null) {
            aPr = pr(prVarHn, fX, prVarHn.x.getInterpolation(fX), prVarHn.c.getInterpolation(fX));
        } else {
            aPr = pr(prVarHn, c());
        }
        this.uc = aPr;
        return aPr;
    }

    public float zo() {
        return this.hw;
    }

    public A pr(com.byazt.cz.pr<K> prVar, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T> hn<T> pr(List<? extends com.byazt.cz.pr<T>> list) {
        if (list.isEmpty()) {
            return new hw();
        }
        if (list.size() == 1) {
            return new c(list);
        }
        return new x(list);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 60, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static final class hw<T> implements hn<T> {
        private hw() {
        }

        @Override // com.byazt.al.pr.hn
        public boolean pr() {
            return true;
        }

        @Override // com.byazt.al.pr.hn
        public boolean pr(float f) {
            return false;
        }

        @Override // com.byazt.al.pr.hn
        public com.byazt.cz.pr<T> hw() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.byazt.al.pr.hn
        public float hn() {
            return 0.0f;
        }

        @Override // com.byazt.al.pr.hn
        public float x() {
            return 1.0f;
        }

        @Override // com.byazt.al.pr.hn
        public boolean hw(float f) {
            throw new IllegalStateException("not implemented");
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 60, 103})
    private static final class c<T> implements hn<T> {
        public float hw = -1.0f;
        public final com.byazt.cz.pr<T> pr;

        public c(List<? extends com.byazt.cz.pr<T>> list) {
            this.pr = list.get(0);
        }

        @Override // com.byazt.al.pr.hn
        public boolean pr() {
            return false;
        }

        @Override // com.byazt.al.pr.hn
        public boolean pr(float f) {
            return !this.pr.c();
        }

        @Override // com.byazt.al.pr.hn
        public com.byazt.cz.pr<T> hw() {
            return this.pr;
        }

        @Override // com.byazt.al.pr.hn
        public float hn() {
            return this.pr.hn();
        }

        @Override // com.byazt.al.pr.hn
        public float x() {
            return this.pr.x();
        }

        @Override // com.byazt.al.pr.hn
        public boolean hw(float f) {
            if (this.hw == f) {
                return true;
            }
            this.hw = f;
            return false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 60, 100})
    private static final class x<T> implements hn<T> {
        public final List<? extends com.byazt.cz.pr<T>> pr;
        public com.byazt.cz.pr<T> hn = null;
        public float x = -1.0f;
        public com.byazt.cz.pr<T> hw = hn(0.0f);

        public x(List<? extends com.byazt.cz.pr<T>> list) {
            this.pr = list;
        }

        @Override // com.byazt.al.pr.hn
        public boolean pr() {
            return false;
        }

        @Override // com.byazt.al.pr.hn
        public boolean pr(float f) {
            if (this.hw.pr(f)) {
                return !this.hw.c();
            }
            this.hw = hn(f);
            return true;
        }

        private com.byazt.cz.pr<T> hn(float f) {
            List<? extends com.byazt.cz.pr<T>> list = this.pr;
            com.byazt.cz.pr<T> prVar = list.get(list.size() - 1);
            if (f >= prVar.hn()) {
                return prVar;
            }
            for (int size = this.pr.size() - 2; size > 0; size--) {
                com.byazt.cz.pr<T> prVar2 = this.pr.get(size);
                if (this.hw != prVar2 && prVar2.pr(f)) {
                    return prVar2;
                }
            }
            return this.pr.get(0);
        }

        @Override // com.byazt.al.pr.hn
        public com.byazt.cz.pr<T> hw() {
            return this.hw;
        }

        @Override // com.byazt.al.pr.hn
        public float hn() {
            return this.pr.get(0).hn();
        }

        @Override // com.byazt.al.pr.hn
        public float x() {
            List<? extends com.byazt.cz.pr<T>> list = this.pr;
            return list.get(list.size() - 1).x();
        }

        @Override // com.byazt.al.pr.hn
        public boolean hw(float f) {
            com.byazt.cz.pr<T> prVar = this.hn;
            com.byazt.cz.pr<T> prVar2 = this.hw;
            if (prVar == prVar2 && this.x == f) {
                return true;
            }
            this.hn = prVar2;
            this.x = f;
            return false;
        }
    }
}
