package com.bykv.vk.openvk.component.video.ms.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class ms implements ah {
    private ah.InterfaceC0180ah ab;
    private ah.xr ah;
    private ah.ab c;
    private ah.ms d;
    private ah.c ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected boolean f49ms = false;
    private ah.d x;
    private ah.ka xr;

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public final void ms(ah.ka kaVar) {
        this.xr = kaVar;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public final void ms(ah.xr xrVar) {
        this.ah = xrVar;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public final void ms(ah.ms msVar) {
        this.d = msVar;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public final void ms(ah.c cVar) {
        this.ka = cVar;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public final void ms(ah.InterfaceC0180ah interfaceC0180ah) {
        this.ab = interfaceC0180ah;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public final void ms(ah.d dVar) {
        this.x = dVar;
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public final void ms(ah.ab abVar) {
        this.c = abVar;
    }

    public void ms() {
        this.xr = null;
        this.d = null;
        this.ah = null;
        this.ka = null;
        this.c = null;
        this.ab = null;
        this.x = null;
    }

    protected final void xr() {
        try {
            ah.ka kaVar = this.xr;
            if (kaVar != null) {
                kaVar.xr(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    protected final void ah() {
        try {
            ah.xr xrVar = this.ah;
            if (xrVar != null) {
                xrVar.ms(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    protected final void ms(int i) {
        try {
            ah.ms msVar = this.d;
            if (msVar != null) {
                msVar.ms(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    protected final void d() {
        try {
            ah.c cVar = this.ka;
            if (cVar != null) {
                cVar.ah(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    protected final void ms(int i, int i2, int i3, int i4) {
        try {
            ah.ab abVar = this.c;
            if (abVar != null) {
                abVar.ms(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    protected final boolean ms(int i, int i2) {
        try {
            ah.InterfaceC0180ah interfaceC0180ah = this.ab;
            return interfaceC0180ah != null && interfaceC0180ah.ms(this, i, i2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    protected final boolean xr(int i, int i2) {
        try {
            ah.d dVar = this.x;
            return dVar != null && dVar.xr(this, i, i2);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.c.ah.ah("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.ms.d.ah
    public void ms(boolean z) {
        this.f49ms = z;
    }
}
