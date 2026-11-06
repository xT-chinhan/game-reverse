package com.byazt.qm;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2253, 5})
public final class uc {
    public boolean c;
    public uc fw;
    public int hn;
    public int hw;
    public final byte[] pr;
    public uc uc;
    public boolean x;

    public uc() {
        this.pr = new byte[8192];
        this.c = true;
        this.x = false;
    }

    public uc(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.pr = bArr;
        this.hw = i;
        this.hn = i2;
        this.x = z;
        this.c = z2;
    }

    public final uc pr() {
        this.x = true;
        return new uc(this.pr, this.hw, this.hn, true, false);
    }

    public final uc hw() {
        uc ucVar = this.uc;
        uc ucVar2 = ucVar != this ? ucVar : null;
        uc ucVar3 = this.fw;
        if (ucVar3 != null) {
            ucVar3.uc = ucVar;
        }
        uc ucVar4 = this.uc;
        if (ucVar4 != null) {
            ucVar4.fw = ucVar3;
        }
        this.uc = null;
        this.fw = null;
        return ucVar2;
    }

    public final uc pr(uc ucVar) {
        ucVar.fw = this;
        ucVar.uc = this.uc;
        this.uc.fw = ucVar;
        this.uc = ucVar;
        return ucVar;
    }
}
