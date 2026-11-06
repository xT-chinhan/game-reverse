package com.meta.android.mpg.cm;

import com.meta.android.mpg.cm.api.IMetaAdApi;
import com.meta.android.mpg.cm.core.c;

/* JADX INFO: loaded from: classes3.dex */
public final class MetaAdApi {
    private MetaAdApi() {
    }

    public static IMetaAdApi get() {
        return c.a();
    }
}
