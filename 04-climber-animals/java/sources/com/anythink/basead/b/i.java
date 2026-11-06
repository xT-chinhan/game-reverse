package com.anythink.basead.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.y;

/* JADX INFO: loaded from: classes.dex */
public final class i implements com.anythink.core.common.k.b {
    com.anythink.core.common.t.c a;
    Context b = t.b().g();

    @Override // com.anythink.core.common.k.b
    public final void a(final w wVar, final String str, final String str2, boolean z, final com.anythink.core.common.k.c cVar) {
        if (z) {
            boolean zA = b.a(this.b, wVar);
            if (cVar != null) {
                cVar.a(zA);
                return;
            }
            return;
        }
        y yVarR = wVar.r();
        if (yVarR == null) {
            if (cVar != null) {
                cVar.a(false);
                return;
            }
            return;
        }
        int iP = yVarR.P();
        int iQ = yVarR.Q();
        if (iP == 1) {
            final com.anythink.basead.a aVar = new com.anythink.basead.a() { // from class: com.anythink.basead.b.i.1
                @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityResumed(Activity activity) {
                    super.onActivityResumed(activity);
                    if (i.this.a != null) {
                        i.this.a.a();
                    }
                }

                @Override // com.anythink.basead.a, android.app.Application.ActivityLifecycleCallbacks
                public final void onActivityPaused(Activity activity) {
                    super.onActivityPaused(activity);
                    if (i.this.a != null) {
                        i.this.a.b();
                    }
                }
            };
            this.a = new com.anythink.core.common.t.c(iQ, new Runnable() { // from class: com.anythink.basead.b.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    ((Application) i.this.b).unregisterActivityLifecycleCallbacks(aVar);
                    boolean zA2 = b.a(i.this.b, wVar);
                    if (zA2) {
                        com.anythink.core.common.u.e.a(str, wVar.v(), str2, 6, (String) null, 0L, 0L, wVar.ap(), wVar.aq());
                    }
                    com.anythink.core.common.k.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.a(zA2);
                    }
                }
            });
            try {
                ((Application) this.b).registerActivityLifecycleCallbacks(aVar);
                return;
            } catch (Exception unused) {
                com.anythink.core.common.u.e.b("Error", "Error, cannot registerActivityLifecycleCallbacks here!", t.b().r());
                return;
            }
        }
        if (iP == 3) {
            com.anythink.core.common.b.a().a("1", new com.anythink.basead.d.h(wVar, str2, str, cVar));
        } else if (cVar != null) {
            cVar.a(false);
        }
    }
}
