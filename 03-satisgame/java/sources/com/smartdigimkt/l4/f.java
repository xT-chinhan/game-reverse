package com.smartdigimkt.l4;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends e {
    public boolean b;

    public f(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 1;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        return eVar.a() == 1 && ((f) eVar).b == this.b;
    }
}
