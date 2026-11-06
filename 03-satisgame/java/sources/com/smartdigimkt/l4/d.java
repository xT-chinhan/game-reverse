package com.smartdigimkt.l4;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends m {
    public d(int i, int i2, Object obj, int i3, boolean z) {
        super(i, i2, obj, i3, z);
    }

    @Override // com.smartdigimkt.l4.e
    public final byte a() {
        return (byte) 7;
    }

    @Override // com.smartdigimkt.l4.e
    public final boolean a(e eVar) {
        if (eVar.a() != 7) {
            return false;
        }
        Object obj = ((d) eVar).b;
        Object obj2 = this.b;
        if (obj2 == obj) {
            return true;
        }
        if (obj2 != null && obj != null) {
            if (obj2 instanceof String) {
                return obj2.equals(obj);
            }
            if ((obj2 instanceof byte[]) && (obj instanceof byte[])) {
                return Arrays.equals((byte[]) obj2, (byte[]) obj);
            }
        }
        return false;
    }
}
