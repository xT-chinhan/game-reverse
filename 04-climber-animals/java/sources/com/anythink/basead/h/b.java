package com.anythink.basead.h;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.anythink.basead.ui.MraidBannerATView;
import com.anythink.basead.ui.SdkBannerATView;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    com.anythink.basead.g.a a;
    private final String k;

    @Override // com.anythink.basead.h.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public b(Context context, x xVar, String str, boolean z) {
        super(context, xVar, str, z);
        this.k = getClass().getSimpleName();
    }

    public final void a(com.anythink.basead.g.a aVar) {
        this.a = aVar;
    }

    public final View b() {
        if (!a()) {
            return null;
        }
        if (this.g.n()) {
            return new MraidBannerATView(this.c, this.d, this.g, this.a);
        }
        return new SdkBannerATView(this.c, this.d, this.g, this.a);
    }

    @Override // com.anythink.basead.h.c
    public final void c() {
        this.a = null;
    }
}
