package com.smartdigimkt.l4;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends e {
    public float b;

    public h(int i, float f) {
        this.a = i;
        this.b = f;
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 3;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        return eVar.a() == 3 && ((h) eVar).b == this.b;
    }
}
