package com.smartdigimkt.x;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class d {
    public static ClassCastException a(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }
}
