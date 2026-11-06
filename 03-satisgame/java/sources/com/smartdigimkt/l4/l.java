package com.smartdigimkt.l4;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends m {
    public l(int i, int i2, String str, int i3, boolean z) {
        super(i, i2, str, i3, z);
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 6;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        if (eVar.a() == 6) {
            l lVar = (l) eVar;
            if (lVar.e == this.e && Objects.equals(lVar.b, this.b)) {
                return true;
            }
        }
        return false;
    }
}
