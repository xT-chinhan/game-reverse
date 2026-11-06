package com.anythink.basead.h;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.ui.AsseblemSplashATView;
import com.anythink.basead.ui.BaseSdkSplashATView;
import com.anythink.basead.ui.BaseSplashATView;
import com.anythink.basead.ui.SinglePictureSplashATView;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.x;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class g extends c {
    com.anythink.basead.g.a a;
    BaseSplashATView k;
    boolean l;

    @Override // com.anythink.basead.h.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public g(Context context, x xVar, String str) {
        super(context, xVar, str, false);
    }

    public final void b() {
        this.l = true;
    }

    public final void a(final ViewGroup viewGroup) {
        t.b().b(new Runnable() { // from class: com.anythink.basead.h.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseSdkSplashATView.isSinglePicture(g.this.g, g.this.d.o)) {
                    g.this.k = new SinglePictureSplashATView(viewGroup.getContext(), g.this.d, g.this.g, g.this.a);
                } else {
                    g.this.k = new AsseblemSplashATView(viewGroup.getContext(), g.this.d, g.this.g, g.this.a);
                }
                g.this.k.setDontCountDown(g.this.l);
                viewGroup.addView(g.this.k);
            }
        });
    }

    public final void a(com.anythink.basead.g.a aVar) {
        this.a = aVar;
    }

    @Override // com.anythink.basead.h.c, com.anythink.basead.h.a
    public final boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.h.a.a.a(this.c).a(this.g, this.d, this.f);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void g() {
        this.a = null;
        BaseSplashATView baseSplashATView = this.k;
        if (baseSplashATView != null) {
            baseSplashATView.destroy();
            this.k = null;
        }
    }
}
