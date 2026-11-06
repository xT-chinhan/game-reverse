package com.smartdigimkt.y0;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public final HashMap a = new HashMap();
    public Map b;

    public final synchronized Map a() {
        if (this.b == null) {
            this.b = Collections.unmodifiableMap(new HashMap(this.a));
        }
        return this.b;
    }
}
