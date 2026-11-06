package com.mcto.sspsdk.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class fl {
    public final int a;
    public final List b;

    public fl(int i, ArrayList arrayList) {
        this.a = i;
        this.b = Collections.unmodifiableList(new ArrayList(arrayList));
    }
}
