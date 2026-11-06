package com.smartdigimkt.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.smartdigimkt.i2.k {
    public final /* synthetic */ u a;

    public t(u uVar) {
        this.a = uVar;
    }

    @Override // com.smartdigimkt.i2.k
    public final void a(int i, int i2) {
        switch (i2) {
            case 33:
            case 35:
                if (this.a.a.t < 2) {
                    return;
                }
                break;
            case 34:
                break;
            default:
                return;
        }
        a aVar = this.a.a.e;
        if (aVar != null) {
            aVar.a(i, i2);
        }
    }
}
