package com.mcto.sspsdk.internal;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class yk implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        bl blVar = (bl) obj;
        bl blVar2 = (bl) obj2;
        int iCompare = Double.compare(blVar2.c, blVar.c);
        return iCompare != 0 ? iCompare : Long.compare(blVar2.k, blVar.k);
    }
}
