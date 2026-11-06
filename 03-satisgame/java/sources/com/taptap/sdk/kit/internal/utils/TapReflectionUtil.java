package com.taptap.sdk.kit.internal.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapReflectionUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0007JC\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\f\u001a\u00020\b2\u001e\u0010\r\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u000e\"\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u000fJ?\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u001e\u0010\r\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u000e\"\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0010J9\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u000b2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/kit/internal/utils/TapReflectionUtil;", "", "()V", "getFieldQuietly", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "fieldName", "", "className", "getMethodQuietly", "Ljava/lang/reflect/Method;", "methodName", "parameterTypes", "", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "invokeMethodQuietly", "receiver", "method", "args", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapReflectionUtil {
    public static final TapReflectionUtil INSTANCE = new TapReflectionUtil();

    private TapReflectionUtil() {
    }

    @JvmStatic
    public static final Field getFieldQuietly(String className, String fieldName) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        try {
            Class<?> clazz = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(clazz, "clazz");
            return getFieldQuietly(clazz, fieldName);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Field getFieldQuietly(Class<?> clazz, String fieldName) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        try {
            return clazz.getField(fieldName);
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(String className, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            Class<?> clazz = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(clazz, "clazz");
            return getMethodQuietly(clazz, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Object invokeMethodQuietly(Object receiver, Method method, Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return method.invoke(receiver, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
