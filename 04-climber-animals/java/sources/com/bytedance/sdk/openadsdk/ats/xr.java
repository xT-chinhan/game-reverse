package com.bytedance.sdk.openadsdk.ats;

import com.anythink.core.common.e.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static final Map<ClassLoader, Map<String, Class>> f1835ms = new HashMap();

    public static String ms(Class cls) {
        try {
            if (cls.getClassLoader() == ATSApi.class.getClassLoader()) {
                ATSApi aTSApi = (ATSApi) cls.getAnnotation(ATSApi.class);
                if (aTSApi != null) {
                    return aTSApi.value();
                }
                return null;
            }
            Annotation annotationXr = xr(cls, "com.bytedance.sdk.openadsdk.ats.ATSApi");
            if (annotationXr == null) {
                return null;
            }
            return String.valueOf(ms(annotationXr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Annotation xr(Class cls) {
        try {
            if (cls.getClassLoader() == ATSApi.class.getClassLoader()) {
                return cls.getAnnotation(ATSApi.class);
            }
            return xr(cls, "com.bytedance.sdk.openadsdk.ats.ATSApi");
        } catch (Exception unused) {
            return null;
        }
    }

    public static Annotation ms(Class cls, Method method) {
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            return method.getAnnotation(ATSMethod.class);
        }
        Class<? extends Annotation> clsMs = ms(cls, "com.bytedance.sdk.openadsdk.ats.ATSMethod");
        if (clsMs == null) {
            return null;
        }
        return method.getAnnotation(clsMs);
    }

    public static Class ah(Class cls) {
        if (cls.getClassLoader() == ATSMethod.class.getClassLoader()) {
            return ATSMethod.class;
        }
        return ms(cls, "com.bytedance.sdk.openadsdk.ats.ATSMethod");
    }

    private static Class<? extends Annotation> ms(Class cls, String str) {
        Class<? extends Annotation> cls2;
        try {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null) {
                return null;
            }
            Map<String, Class> map = f1835ms.get(classLoader);
            if (map == null) {
                map = new HashMap<>(8);
                cls2 = null;
            } else {
                cls2 = map.get(str);
            }
            if (cls2 != null) {
                return cls2;
            }
            Class clsLoadClass = classLoader.loadClass(str);
            if (clsLoadClass != null) {
                map.put(str, clsLoadClass);
            }
            return clsLoadClass;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Annotation xr(Class cls, String str) {
        Class<? extends Annotation> clsMs = ms(cls, str);
        if (clsMs != null) {
            return cls.getAnnotation(clsMs);
        }
        return null;
    }

    public static Object ms(Annotation annotation) {
        try {
            Method method = annotation.getClass().getMethod(f.a.d, new Class[0]);
            if (method == null) {
                return null;
            }
            return method.invoke(annotation, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
