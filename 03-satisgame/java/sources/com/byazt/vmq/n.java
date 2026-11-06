package com.byazt.vmq;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1122, 19})
public abstract class n implements s {
    public s.q fs;
    public s.w l;
    public boolean n = false;
    public s.n q;
    public s.l qg;
    public s.qg s;
    public s.x w;
    public s.InterfaceC0374s x;

    @Override // com.byazt.vmq.s
    public final void n(s.l lVar) {
        this.qg = lVar;
    }

    @Override // com.byazt.vmq.s
    public final void n(s.qg qgVar) {
        this.s = qgVar;
    }

    @Override // com.byazt.vmq.s
    public final void n(s.n nVar) {
        this.q = nVar;
    }

    @Override // com.byazt.vmq.s
    public final void n(s.w wVar) {
        this.l = wVar;
    }

    @Override // com.byazt.vmq.s
    public final void n(s.InterfaceC0374s interfaceC0374s) {
        this.x = interfaceC0374s;
    }

    @Override // com.byazt.vmq.s
    public final void n(s.q qVar) {
        this.fs = qVar;
    }

    @Override // com.byazt.vmq.s
    public final void n(s.x xVar) {
        this.w = xVar;
    }

    public void n() {
        this.qg = null;
        this.q = null;
        this.s = null;
        this.l = null;
        this.w = null;
        this.x = null;
        this.fs = null;
    }

    public final void qg() {
        try {
            s.l lVar = this.qg;
            if (lVar != null) {
                lVar.qg(this);
            }
        } catch (Throwable th) {
            com.byazt.nl.qg.n("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void s() {
        try {
            s.qg qgVar = this.s;
            if (qgVar != null) {
                qgVar.n(this);
            }
        } catch (Throwable th) {
            com.byazt.nl.qg.n("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    public final void n(int i) {
        try {
            s.n nVar = this.q;
            if (nVar != null) {
                nVar.n(this, i);
            }
        } catch (Throwable th) {
            com.byazt.nl.qg.n("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void q() {
        try {
            s.w wVar = this.l;
            if (wVar != null) {
                wVar.s(this);
            }
        } catch (Throwable th) {
            com.byazt.nl.qg.n("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    public final void n(int i, int i2, int i3, int i4) {
        try {
            s.x xVar = this.w;
            if (xVar != null) {
                xVar.n(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.byazt.nl.qg.n("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean n(int i, int i2) {
        try {
            s.InterfaceC0374s interfaceC0374s = this.x;
            return interfaceC0374s != null && interfaceC0374s.n(this, i, i2);
        } catch (Throwable th) {
            com.byazt.nl.qg.n("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    public final boolean qg(int i, int i2) {
        try {
            s.q qVar = this.fs;
            return qVar != null && qVar.qg(this, i, i2);
        } catch (Throwable th) {
            com.byazt.nl.qg.n("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.byazt.vmq.s
    public void n(boolean z) {
        this.n = z;
    }
}
