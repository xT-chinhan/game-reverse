package com.byazt.du;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 19})
public final class ho {
    public boolean c;
    public ho fw;
    public int hn;
    public int hw;
    public final byte[] pr;
    public ho uc;
    public boolean x;

    public ho() {
        this.pr = new byte[8192];
        this.c = true;
        this.x = false;
    }

    public ho(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.pr = bArr;
        this.hw = i;
        this.hn = i2;
        this.x = z;
        this.c = z2;
    }

    public final ho pr() {
        this.x = true;
        return new ho(this.pr, this.hw, this.hn, true, false);
    }

    public final ho hw() {
        ho hoVar = this.uc;
        ho hoVar2 = hoVar != this ? hoVar : null;
        ho hoVar3 = this.fw;
        if (hoVar3 != null) {
            hoVar3.uc = hoVar;
        }
        ho hoVar4 = this.uc;
        if (hoVar4 != null) {
            hoVar4.fw = hoVar3;
        }
        this.uc = null;
        this.fw = null;
        return hoVar2;
    }

    public final ho pr(ho hoVar) {
        hoVar.fw = this;
        hoVar.uc = this.uc;
        this.uc.fw = hoVar;
        this.uc = hoVar;
        return hoVar;
    }

    public final ho pr(int i) {
        ho hoVarPr;
        if (i <= 0 || i > this.hn - this.hw) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            hoVarPr = pr();
        } else {
            hoVarPr = nt.pr();
            System.arraycopy(this.pr, this.hw, hoVarPr.pr, 0, i);
        }
        hoVarPr.hn = hoVarPr.hw + i;
        this.hw += i;
        this.fw.pr(hoVarPr);
        return hoVarPr;
    }

    public final void hn() {
        ho hoVar = this.fw;
        if (hoVar == this) {
            throw new IllegalStateException();
        }
        if (hoVar.c) {
            int i = this.hn - this.hw;
            if (i > (8192 - hoVar.hn) + (hoVar.x ? 0 : hoVar.hw)) {
                return;
            }
            pr(hoVar, i);
            hw();
            nt.pr(this);
        }
    }

    public final void pr(ho hoVar, int i) {
        if (!hoVar.c) {
            throw new IllegalArgumentException();
        }
        int i2 = hoVar.hn;
        if (i2 + i > 8192) {
            if (hoVar.x) {
                throw new IllegalArgumentException();
            }
            int i3 = hoVar.hw;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = hoVar.pr;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            hoVar.hn -= hoVar.hw;
            hoVar.hw = 0;
        }
        System.arraycopy(this.pr, this.hw, hoVar.pr, hoVar.hn, i);
        hoVar.hn += i;
        this.hw += i;
    }
}
