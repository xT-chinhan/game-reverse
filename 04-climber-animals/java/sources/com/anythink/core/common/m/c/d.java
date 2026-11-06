package com.anythink.core.common.m.c;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.v.af;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class d implements i {
    public static final String a = "anythink_app_pl_cl_retry";
    protected final Context b;
    protected final Object d = new Object();
    protected final Map<String, Long> c = new ConcurrentHashMap(1);

    protected boolean b(com.anythink.core.common.m.b.d dVar) {
        return false;
    }

    public d(Context context) {
        this.b = context;
    }

    @Override // com.anythink.core.common.m.c.i
    public com.anythink.core.common.m.b.f a(com.anythink.core.common.m.b.d dVar) {
        String strC = c(dVar);
        if (this.c == null || TextUtils.isEmpty(strC)) {
            return null;
        }
        com.anythink.core.common.m.b.f fVarA = com.anythink.core.common.m.b.f.a();
        synchronized (this.d) {
            Long lValueOf = this.c.get(strC);
            boolean z = true;
            if (lValueOf == null) {
                getClass().getSimpleName();
                Object[] objArr = new Object[1];
                lValueOf = Long.valueOf(af.b(this.b, "anythink_app_pl_cl_retry", strC, 0L));
                this.c.put(strC, lValueOf);
            }
            getClass().getSimpleName();
            Object[] objArr2 = new Object[2];
            if (lValueOf.longValue() == 0) {
                fVarA.a(false);
            } else if (lValueOf.longValue() == -1) {
                fVarA.a(true);
                fVarA.b(700);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                getClass().getSimpleName();
                Object[] objArr3 = new Object[2];
                Long.valueOf(jCurrentTimeMillis);
                if (jCurrentTimeMillis - lValueOf.longValue() >= 0) {
                    z = false;
                }
                if (z) {
                    fVarA.b(700);
                }
                fVarA.a(z);
            }
        }
        return fVarA;
    }

    protected String c(com.anythink.core.common.m.b.d dVar) {
        return dVar != null ? dVar.a() : "";
    }
}
