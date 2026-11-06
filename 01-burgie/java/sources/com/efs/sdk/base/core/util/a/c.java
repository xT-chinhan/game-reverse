package com.efs.sdk.base.core.util.a;

import android.support.annotation.NonNull;
import com.efs.sdk.base.http.HttpResponse;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.efs.sdk.base.core.util.concurrent.d<HttpResponse> {
    public b a;

    c(@NonNull b bVar) {
        super(bVar);
        this.a = bVar;
    }

    @NonNull
    public final HttpResponse b() {
        this.a.e = "post";
        return a();
    }
}
