package com.anythink.core.c.c;

import com.anythink.core.api.BaseAd;
import com.anythink.core.api.bridge.ATBaseAdAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    ATBaseAdAdapter a;
    BaseAd b;

    public c(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd) {
        this.a = aTBaseAdAdapter;
        this.b = baseAd;
    }

    public final ATBaseAdAdapter a() {
        return this.a;
    }

    public final BaseAd b() {
        return this.b;
    }
}
