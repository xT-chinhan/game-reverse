package com.smartdigimkt.l4;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends e {
    public long b;

    public j(int i, long j) {
        this.a = i;
        this.b = j;
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 4;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        return eVar.a() == 4 && ((j) eVar).b == this.b;
    }
}
