package com.byazt.ln;

import android.content.Context;
import com.byazt.hg.of;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 573, 121})
public class x {
    public final Map<Class, pr> pr = new HashMap();

    public hn pr(of ofVar, Context context, com.byazt.az.x xVar, boolean z) {
        hn hnVar = new hn(xVar);
        com.byazt.md.pr prVar = new com.byazt.md.pr(ofVar, context);
        this.pr.put(com.byazt.md.pr.class, prVar);
        hw hwVar = new hw(ofVar, context);
        this.pr.put(hw.class, hwVar);
        com.byazt.dl.pr prVarPr = pr(ofVar, context);
        this.pr.put(com.byazt.dl.pr.class, prVarPr);
        com.byazt.yx.pr prVar2 = new com.byazt.yx.pr(ofVar, context);
        this.pr.put(com.byazt.yx.pr.class, prVar2);
        com.byazt.yx.hn hnVar2 = new com.byazt.yx.hn(ofVar, context);
        this.pr.put(com.byazt.yx.hn.class, hnVar2);
        hnVar.pr(hnVar2);
        hnVar.pr(prVar);
        hnVar.pr(hwVar);
        hnVar.pr(prVar2);
        hnVar.pr(prVarPr);
        return hnVar;
    }

    private com.byazt.dl.pr pr(of ofVar, Context context) {
        com.byazt.dl.hn hnVar = new com.byazt.dl.hn();
        hnVar.pr(ofVar);
        hnVar.pr(context);
        return hnVar;
    }

    public <T extends pr> T pr(Class<T> cls) {
        T t = (T) this.pr.get(cls);
        if (t == null) {
            return (T) hw(cls);
        }
        return t;
    }

    private <T extends pr> T hw(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable th) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(of.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable th2) {
                return null;
            }
        }
    }
}
