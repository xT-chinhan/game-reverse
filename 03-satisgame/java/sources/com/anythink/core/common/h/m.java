package com.anythink.core.common.h;

import com.anythink.core.api.AdError;

/* JADX INFO: loaded from: classes.dex */
public final class m extends IllegalStateException {
    public AdError a;
    public String b;

    public m(AdError adError, String str) {
        this.a = adError;
        this.b = str;
    }
}
