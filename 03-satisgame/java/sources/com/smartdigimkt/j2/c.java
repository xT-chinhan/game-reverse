package com.smartdigimkt.j2;

import java.util.function.IntUnaryOperator;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements IntUnaryOperator {
    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i) {
        if (i > 0) {
            return i - 1;
        }
        return 0;
    }
}
