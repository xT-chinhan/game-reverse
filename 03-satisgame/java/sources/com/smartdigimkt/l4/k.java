package com.smartdigimkt.l4;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends m {
    public k(int i, int i2, Object obj, int i3, boolean z) {
        super(i, i2, obj, i3, z);
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 8;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        return eVar.a() == 8 && Objects.equals(((k) eVar).b, this.b);
    }
}
