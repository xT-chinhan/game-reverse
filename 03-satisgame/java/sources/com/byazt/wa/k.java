package com.byazt.wa;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 210})
public final class k {
    public boolean l;
    public final byte[] n;
    public boolean q;
    public int qg;
    public int s;
    public k w;
    public k x;

    public k() {
        this.n = new byte[8192];
        this.l = true;
        this.q = false;
    }

    public k(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.n = bArr;
        this.qg = i;
        this.s = i2;
        this.q = z;
        this.l = z2;
    }

    public final k n() {
        this.q = true;
        return new k(this.n, this.qg, this.s, true, false);
    }

    public final k qg() {
        k kVar = this.w;
        k kVar2 = kVar != this ? kVar : null;
        k kVar3 = this.x;
        if (kVar3 != null) {
            kVar3.w = kVar;
        }
        k kVar4 = this.w;
        if (kVar4 != null) {
            kVar4.x = kVar3;
        }
        this.w = null;
        this.x = null;
        return kVar2;
    }

    public final k n(k kVar) {
        kVar.x = this;
        kVar.w = this.w;
        this.w.x = kVar;
        this.w = kVar;
        return kVar;
    }

    public final k n(int i) {
        k kVarN;
        if (i <= 0 || i > this.s - this.qg) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            kVarN = n();
        } else {
            kVarN = cy.n();
            System.arraycopy(this.n, this.qg, kVarN.n, 0, i);
        }
        kVarN.s = kVarN.qg + i;
        this.qg += i;
        this.x.n(kVarN);
        return kVarN;
    }

    public final void s() {
        k kVar = this.x;
        if (kVar == this) {
            throw new IllegalStateException();
        }
        if (kVar.l) {
            int i = this.s - this.qg;
            if (i > (8192 - kVar.s) + (kVar.q ? 0 : kVar.qg)) {
                return;
            }
            n(kVar, i);
            qg();
            cy.n(this);
        }
    }

    public final void n(k kVar, int i) {
        if (!kVar.l) {
            throw new IllegalArgumentException();
        }
        int i2 = kVar.s;
        if (i2 + i > 8192) {
            if (kVar.q) {
                throw new IllegalArgumentException();
            }
            int i3 = kVar.qg;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = kVar.n;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            kVar.s -= kVar.qg;
            kVar.qg = 0;
        }
        System.arraycopy(this.n, this.qg, kVar.n, kVar.s, i);
        kVar.s += i;
        this.qg += i;
    }
}
