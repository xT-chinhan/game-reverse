package com.byazt.el;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 989, 26})
public class qg {
    public static Field n(Class<?> cls, String str) throws NoSuchFieldException {
        Field declaredField = cls.getDeclaredField(str);
        if (declaredField != null && !declaredField.isAccessible()) {
            declaredField.setAccessible(true);
        }
        return declaredField;
    }

    public static Method n(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (declaredMethod != null && !declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }

    public static Constructor n(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
        if (declaredConstructor != null && !declaredConstructor.isAccessible()) {
            declaredConstructor.setAccessible(true);
        }
        return declaredConstructor;
    }
}
