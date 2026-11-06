package com.byazt.yt;

import com.mar.sdk.MARCode;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1312, 37})
public class pr implements com.byazt.hh.hw {
    public com.byazt.hh.uc c;
    public com.byazt.hh.uc hn;
    public com.byazt.hh.uc hw;
    public int pr;
    public com.byazt.hh.hn uc;
    public com.byazt.hh.uc x;

    private pr() {
        this.pr = -1;
    }

    @Override // com.byazt.hh.hw
    public com.byazt.hh.hn pr() {
        return this.uc;
    }

    @Override // com.byazt.hh.hw
    public com.byazt.hh.uc hw() {
        return this.hw;
    }

    @Override // com.byazt.hh.hw
    public com.byazt.hh.uc hn() {
        return this.hn;
    }

    @Override // com.byazt.hh.hw
    public com.byazt.hh.uc x() {
        return this.x;
    }

    @Override // com.byazt.hh.hw
    public com.byazt.hh.uc c() {
        return this.c;
    }

    @Override // com.byazt.hh.hw
    public int uc() {
        return this.pr;
    }

    /* JADX INFO: renamed from: com.byazt.yt.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1312, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    public static class C0240pr {
        public com.byazt.hh.hn c;
        public com.byazt.hh.uc hn;
        public com.byazt.hh.uc hw;
        public com.byazt.hh.uc pr;
        public com.byazt.hh.uc x;
        public final AtomicBoolean uc = new AtomicBoolean(false);
        public int fw = 5000;
        public int zo = 10;
        public int aj = -1;
        public int vk = -1;

        public C0240pr pr(com.byazt.hh.hn hnVar) {
            this.c = hnVar;
            return this;
        }

        public C0240pr pr(int i) {
            this.vk = i;
            return this;
        }

        public pr pr() {
            pr prVar = new pr();
            prVar.hw = this.pr;
            prVar.hn = this.hw;
            prVar.x = this.hn;
            prVar.c = this.x;
            prVar.uc = this.c;
            prVar.pr = this.vk;
            return prVar;
        }
    }
}
