package com.mcto.sspsdk.internal;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class el implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((cl) obj2).b, ((cl) obj).b);
    }
}
