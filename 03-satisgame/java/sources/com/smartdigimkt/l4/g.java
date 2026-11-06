package com.smartdigimkt.l4;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends e {
    public double b;

    public g(int i, double d) {
        this.a = i;
        this.b = d;
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 5;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        return eVar.a() == 5 && ((g) eVar).b == this.b;
    }
}
