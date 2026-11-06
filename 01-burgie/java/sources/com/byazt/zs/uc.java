package com.byazt.zs;

import com.byazt.sd.iu;
import java.util.Collections;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 5})
public final class uc implements Function<Object, Object> {
    public static final String TAG = "AutoService";
    public static uc hw;
    public int hn = iu.hw;
    public final pr pr = new pr();

    private uc() {
    }

    public static uc pr() {
        uc ucVar = hw;
        if (ucVar != null) {
            return ucVar;
        }
        synchronized (uc.class) {
            if (hw == null) {
                System.currentTimeMillis();
                hw = new uc();
                System.currentTimeMillis();
            }
        }
        return hw;
    }

    public static <T> T pr(String str) {
        return (T) pr(str, null);
    }

    public static <T> T pr(String str, com.byazt.vkw.pr prVar) {
        pr prVar2 = pr().pr;
        T t = (T) prVar2.pr(str, prVar, true);
        if (t == null) {
            return (T) prVar2.pr(str, prVar);
        }
        return t;
    }

    public void pr(k kVar) {
        this.pr.pr(kVar);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        try {
            if (obj == null) {
                return Collections.unmodifiableMap(this.pr.pr());
            }
            if (obj instanceof Function) {
                this.pr.pr(this, (Function) obj);
            } else {
                if (obj instanceof String) {
                    return this.pr.pr(String.valueOf(obj), null, false);
                }
                if (obj instanceof Integer) {
                    return Integer.valueOf(this.hn);
                }
            }
            return this.pr.pr(obj);
        } catch (Exception e) {
            k kVarZo = this.pr.zo();
            if (kVarZo != null) {
                kVarZo.pr(0, obj == null ? "" : obj.getClass().getName() + " " + obj, e);
            }
            return null;
        }
    }

    public static com.byazt.vkw.pr hw(String str) {
        return pr().pr.pr(str);
    }

    public int hw() {
        return this.hn;
    }

    public g hn(String str) {
        return this.pr.aj().pr(str);
    }

    public void hn() {
        this.pr.x();
    }
}
