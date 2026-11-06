package com.byazt.p;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 581, 37})
public abstract class pr implements hn {
    public hn.uc c;
    public hn.InterfaceC0160hn fw;
    public hn.hw hn;
    public hn.c hw;
    public boolean pr = false;
    public hn.fw uc;
    public hn.pr x;
    public hn.x zo;

    @Override // com.byazt.p.hn
    public final void pr(hn.c cVar) {
        this.hw = cVar;
    }

    @Override // com.byazt.p.hn
    public final void pr(hn.hw hwVar) {
        this.hn = hwVar;
    }

    @Override // com.byazt.p.hn
    public final void pr(hn.pr prVar) {
        this.x = prVar;
    }

    @Override // com.byazt.p.hn
    public final void pr(hn.uc ucVar) {
        this.c = ucVar;
    }

    @Override // com.byazt.p.hn
    public final void pr(hn.InterfaceC0160hn interfaceC0160hn) {
        this.fw = interfaceC0160hn;
    }

    @Override // com.byazt.p.hn
    public final void pr(hn.x xVar) {
        this.zo = xVar;
    }

    @Override // com.byazt.p.hn
    public final void pr(hn.fw fwVar) {
        this.uc = fwVar;
    }

    public void pr() {
        this.hw = null;
        this.x = null;
        this.hn = null;
        this.c = null;
        this.uc = null;
        this.fw = null;
        this.zo = null;
    }

    public final void hw() {
        try {
            hn.c cVar = this.hw;
            if (cVar != null) {
                cVar.hw(this);
            }
        } catch (Throwable th) {
            com.byazt.o.hw.pr("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void hn() {
        try {
            hn.hw hwVar = this.hn;
            if (hwVar != null) {
                hwVar.pr(this);
            }
        } catch (Throwable th) {
            com.byazt.o.hw.pr("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void pr(int i) {
        try {
            hn.pr prVar = this.x;
            if (prVar != null) {
                prVar.pr(this, i);
            }
        } catch (Throwable th) {
            com.byazt.o.hw.pr("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void x() {
        try {
            hn.uc ucVar = this.c;
            if (ucVar != null) {
                ucVar.hn(this);
            }
        } catch (Throwable th) {
            com.byazt.o.hw.pr("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    public final void pr(int i, int i2, int i3, int i4) {
        try {
            hn.fw fwVar = this.uc;
            if (fwVar != null) {
                fwVar.pr(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.byazt.o.hw.pr("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean pr(int i, int i2) {
        try {
            hn.InterfaceC0160hn interfaceC0160hn = this.fw;
            return interfaceC0160hn != null && interfaceC0160hn.pr(this, i, i2);
        } catch (Throwable th) {
            com.byazt.o.hw.pr("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    public final boolean hw(int i, int i2) {
        try {
            hn.x xVar = this.zo;
            return xVar != null && xVar.hw(this, i, i2);
        } catch (Throwable th) {
            com.byazt.o.hw.pr("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.byazt.p.hn
    public void pr(boolean z) {
        this.pr = z;
    }
}
