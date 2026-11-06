package com.anythink.core.common.l.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.u.ad;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements i {
    public static final String a = "anythink_app_pl_cl_retry";
    protected final Context b;
    protected final Object d = new Object();
    protected final Map<String, Long> c = new ConcurrentHashMap(1);

    protected boolean b(com.anythink.core.common.l.c.d dVar) {
        return false;
    }

    public d(Context context) {
        this.b = context;
    }

    @Override // com.anythink.core.common.l.d.i
    public com.anythink.core.common.l.c.f a(com.anythink.core.common.l.c.d dVar) {
        String strC = c(dVar);
        if (this.c == null || TextUtils.isEmpty(strC)) {
            return null;
        }
        com.anythink.core.common.l.c.f fVarA = com.anythink.core.common.l.c.f.a();
        synchronized (this.d) {
            Long lValueOf = this.c.get(strC);
            if (lValueOf == null) {
                lValueOf = Long.valueOf(ad.b(this.b, "anythink_app_pl_cl_retry", strC, 0L));
                this.c.put(strC, lValueOf);
            }
            if (lValueOf.longValue() == 0) {
                fVarA.a(false);
            } else if (lValueOf.longValue() == -1) {
                fVarA.a(true);
                fVarA.b(700);
            } else {
                boolean z = System.currentTimeMillis() - lValueOf.longValue() < 0;
                if (z) {
                    fVarA.b(700);
                }
                fVarA.a(z);
            }
        }
        return fVarA;
    }

    protected String c(com.anythink.core.common.l.c.d dVar) {
        return dVar != null ? dVar.a() : "";
    }
}
