package com.smartdigimkt.l4;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends e {
    public int b;

    public i(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 2;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        return eVar.a() == 2 && ((i) eVar).b == this.b;
    }
}
