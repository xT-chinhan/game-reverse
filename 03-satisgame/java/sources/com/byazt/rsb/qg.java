package com.byazt.rsb;

import com.byazt.vf.u;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 590, 26})
public class qg implements u {
    public Method l;
    public Class n;
    public Method q;
    public Method qg;
    public Method s;
    public boolean w;

    @Override // com.byazt.vf.u
    public void n(String str, String str2) {
    }

    public qg() {
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.n = clsLoadClass;
            Method declaredMethod = clsLoadClass.getDeclaredMethod("get", String.class);
            this.qg = declaredMethod;
            declaredMethod.setAccessible(true);
            this.w = true;
        } catch (Exception unused) {
            this.n = null;
            this.w = false;
        }
    }

    private Method n(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.n.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    private <T> T n(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.n, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean n() {
        return this.w;
    }

    @Override // com.byazt.vf.u
    public String n(String str) {
        return (String) n(this.qg, str);
    }

    @Override // com.byazt.vf.u
    public int qg(String str) {
        if (this.s == null) {
            this.s = n("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) n(this.s, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.byazt.vf.u
    public long s(String str) {
        if (this.q == null) {
            this.q = n("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) n(this.q, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.byazt.vf.u
    public boolean q(String str) {
        if (this.l == null) {
            this.l = n("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) n(this.l, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
