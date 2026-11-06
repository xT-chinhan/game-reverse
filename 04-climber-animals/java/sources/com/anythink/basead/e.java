package com.anythink.basead;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.q;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    private com.anythink.basead.e.a a;

    public interface a {
        void a();

        void b();
    }

    public final void a(Context context, w wVar, x xVar, a aVar) {
        try {
            com.anythink.basead.e.a aVar2 = new com.anythink.basead.e.a(!(context instanceof Activity) ? c.a().d() : context, q.a(context, "myoffer_feedback_dialog", "style"));
            this.a = aVar2;
            aVar2.a(aVar, wVar, xVar);
            this.a.show();
        } catch (Throwable th) {
            com.anythink.core.common.u.e.b("show feedback dialog error", th.getMessage() + ", " + q.a(th.getStackTrace()), t.b().r());
        }
    }

    public final boolean a() {
        com.anythink.basead.e.a aVar = this.a;
        return aVar != null && aVar.isShowing();
    }
}
