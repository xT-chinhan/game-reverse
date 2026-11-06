package com.bytedance.sdk.openadsdk.ats.ms;

import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bytedance.sdk.component.d.ah {
    private Method ah;
    private boolean c;
    private Method d;
    private Method ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Class f1834ms;
    private Method xr;

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(5)
    public void ms(String str, String str2) {
    }

    public xr() {
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.f1834ms = clsLoadClass;
            Method declaredMethod = clsLoadClass.getDeclaredMethod("get", String.class);
            this.xr = declaredMethod;
            declaredMethod.setAccessible(true);
            this.c = true;
        } catch (Exception unused) {
            this.f1834ms = null;
            this.c = false;
        }
    }

    private Method ms(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.f1834ms.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    private <T> T ms(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.f1834ms, str);
        } catch (Exception e) {
            sl.xr("SystemPropRefect", "invoke failed", e);
            return null;
        }
    }

    public boolean ms() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(1)
    public String ms(String str) {
        return (String) ms(this.xr, str);
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(2)
    public int xr(String str) {
        if (this.ah == null) {
            this.ah = ms("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) ms(this.ah, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(3)
    public long ah(String str) {
        if (this.d == null) {
            this.d = ms("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) ms(this.d, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.component.d.ah
    @ATSMethod(4)
    public boolean d(String str) {
        if (this.ka == null) {
            this.ka = ms("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) ms(this.ka, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
