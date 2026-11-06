package com.anythink.basead.f;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.h.r;
import com.anythink.core.common.h.x;

/* JADX INFO: loaded from: classes.dex */
public final class f extends c {
    boolean i;

    public f(Context context, c.b bVar, x xVar, boolean z) {
        super(context, bVar, xVar);
        this.i = z;
    }

    public final void a(final com.anythink.basead.g.d dVar) {
        super.a(new com.anythink.basead.g.c() { // from class: com.anythink.basead.f.f.1
            @Override // com.anythink.basead.g.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.g.c
            public final void onAdCacheLoaded() {
                a aVarA = f.this.a();
                com.anythink.basead.g.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onNativeAdLoaded(aVarA);
                }
            }

            @Override // com.anythink.basead.g.c
            public final void onAdLoadFailed(com.anythink.basead.d.f fVar) {
                com.anythink.basead.g.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onNativeAdLoadError(fVar);
                }
            }
        });
    }

    public final a a() {
        if (!TextUtils.isEmpty(((r) this.d).d())) {
            if (this.h != null) {
                return this.h.a(this.a, this.d, this.b, this.i);
            }
            return null;
        }
        if (TextUtils.equals(this.d.aC(), com.anythink.basead.f.d.b.a)) {
            if (this.h != null) {
                return this.h.a(this.a, this.d, this.b, this.i);
            }
            return null;
        }
        if (this.h != null) {
            return this.h.a(this.a, this.d, this.b, this.i);
        }
        return null;
    }
}
