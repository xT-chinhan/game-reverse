package com.byazt.cm;

import com.byazt.vkw.er;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1395, 13})
public class hw implements er {
    public Method c;
    public Method hn;
    public Method hw;
    public Class pr;
    public boolean uc;
    public Method x;

    public hw() {
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.pr = clsLoadClass;
            Method declaredMethod = clsLoadClass.getDeclaredMethod("get", String.class);
            this.hw = declaredMethod;
            declaredMethod.setAccessible(true);
            this.uc = true;
        } catch (Exception e) {
            this.pr = null;
            this.uc = false;
        }
    }

    private Method pr(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.pr.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e) {
            return null;
        }
    }

    private <T> T pr(Method method, String str) {
        if (method != null) {
            try {
                return (T) method.invoke(this.pr, str);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    public boolean pr() {
        return this.uc;
    }

    @Override // com.byazt.vkw.er
    public String pr(String str) {
        return (String) pr(this.hw, str);
    }

    @Override // com.byazt.vkw.er
    public int hw(String str) {
        if (this.hn == null) {
            this.hn = pr("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) pr(this.hn, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.byazt.vkw.er
    public long hn(String str) {
        if (this.x == null) {
            this.x = pr("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) pr(this.x, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.byazt.vkw.er
    public boolean x(String str) {
        if (this.c == null) {
            this.c = pr("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) pr(this.c, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.byazt.vkw.er
    public void pr(String str, String str2) {
    }
}
