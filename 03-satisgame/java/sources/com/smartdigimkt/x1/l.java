package com.smartdigimkt.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements com.smartdigimkt.i2.k {
    public final /* synthetic */ m a;

    public l(m mVar) {
        this.a = mVar;
    }

    @Override // com.smartdigimkt.i2.k
    public final void a(int i, int i2) {
        switch (i2) {
            case 36:
                break;
            case 37:
                if (this.a.b.r < 2) {
                    return;
                }
                break;
            case 38:
                if (this.a.b.r < 3) {
                    return;
                }
                break;
            default:
                return;
        }
        a aVar = this.a.b.e;
        if (aVar != null) {
            aVar.a(i, i2);
        }
    }
}
