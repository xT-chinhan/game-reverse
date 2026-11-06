package com.byazt.dj;

import android.content.Context;
import com.byazt.gct.pk;
import com.byazt.ys.l;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1976, 5})
public class q {
    public final Map<Class, n> n = new HashMap();

    public s n(pk pkVar, Context context, l lVar, boolean z) {
        s sVar = new s(lVar);
        com.byazt.soz.n nVar = new com.byazt.soz.n(pkVar, context);
        this.n.put(com.byazt.soz.n.class, nVar);
        qg qgVar = new qg(pkVar, context);
        this.n.put(qg.class, qgVar);
        com.byazt.zct.n nVarN = n(pkVar, context);
        this.n.put(com.byazt.zct.n.class, nVarN);
        com.byazt.fq.n nVar2 = new com.byazt.fq.n(pkVar, context);
        this.n.put(com.byazt.fq.n.class, nVar2);
        com.byazt.fq.s sVar2 = new com.byazt.fq.s(pkVar, context);
        this.n.put(com.byazt.fq.s.class, sVar2);
        sVar.n(sVar2);
        sVar.n(nVar);
        sVar.n(qgVar);
        sVar.n(nVar2);
        sVar.n(nVarN);
        return sVar;
    }

    private com.byazt.zct.n n(pk pkVar, Context context) {
        com.byazt.zct.s sVar = new com.byazt.zct.s();
        sVar.n(pkVar);
        sVar.n(context);
        return sVar;
    }

    public <T extends n> T n(Class<T> cls) {
        T t = (T) this.n.get(cls);
        return t == null ? (T) qg(cls) : t;
    }

    private <T extends n> T qg(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(pk.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }
}
