package com.smartdigimkt.l4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 extends WeakReference {
    public final String a;

    public f0(String str, Object obj, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        this.a = str;
    }
}
