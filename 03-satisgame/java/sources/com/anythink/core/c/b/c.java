package com.anythink.core.c.b;

import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.bridge.ATBaseAdAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements ATBiddingListener {
    protected ATBaseAdAdapter c;

    public c(ATBaseAdAdapter aTBaseAdAdapter) {
        this.c = aTBaseAdAdapter;
    }

    private void a() {
        this.c = null;
    }
}
