package com.taptap.sdk.kit.internal.enginebridge.internal;

import android.app.Activity;
import android.text.TextUtils;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridge;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeKt;
import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeParams;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.command.Command;
import com.taptap.sdk.kit.internal.enginebridge.exception.BridgeExceptionMessage;
import com.taptap.sdk.kit.internal.enginebridge.exception.EngineBridgeException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EngineBridgeReflector.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ-\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u001c\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u001b\u0018\u00010\r2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\r¨\u0006\u001e"}, d2 = {"Lcom/taptap/sdk/kit/internal/enginebridge/internal/EngineBridgeReflector;", "", "()V", "checkCommand", "", "command", "Lcom/taptap/sdk/kit/internal/enginebridge/command/Command;", "checkParamsMatchMethod", "", "jsonObject", "Lorg/json/JSONObject;", "checkServiceValid", "serviceClz", "Ljava/lang/Class;", "constructorCommandArgs", "", "method", "Ljava/lang/reflect/Method;", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "(Ljava/lang/reflect/Method;Lcom/taptap/sdk/kit/internal/enginebridge/command/Command;Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;)[Ljava/lang/Object;", "filterArray", "jsonArray", "Lorg/json/JSONArray;", "(Lorg/json/JSONArray;)[Ljava/lang/Object;", "findParams", "getRegisteredService", "Lcom/taptap/sdk/kit/internal/enginebridge/IEngineBridgeService;", "getValidService", "clz", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EngineBridgeReflector {
    public static final EngineBridgeReflector INSTANCE = new EngineBridgeReflector();

    private EngineBridgeReflector() {
    }

    public final boolean checkServiceValid(Class<?> serviceClz) {
        Intrinsics.checkNotNullParameter(serviceClz, "serviceClz");
        if (serviceClz.getAnnotation(EngineBridgeService.class) == null) {
            return false;
        }
        return IEngineBridgeService.class.isAssignableFrom(serviceClz);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Class<? extends IEngineBridgeService> getValidService(Class<?> clz) {
        Intrinsics.checkNotNullParameter(clz, "clz");
        Class[] interfaceClz = clz.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaceClz, "interfaceClz");
        for (Class superClz : interfaceClz) {
            Intrinsics.checkNotNullExpressionValue(superClz, "superClz");
            if (checkServiceValid(superClz)) {
                return superClz;
            }
        }
        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_SERVICE_ERROR.getMessage());
    }

    public final void checkCommand(Command command) {
        Intrinsics.checkNotNullParameter(command, "command");
        if (!(command.getService().length() == 0)) {
            if (!(command.getMethod().length() == 0)) {
                return;
            }
        }
        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_PARSE_ERROR.getMessage());
    }

    public final Class<? extends IEngineBridgeService> getRegisteredService(Command command) {
        Intrinsics.checkNotNullParameter(command, "command");
        Class<? extends IEngineBridgeService> key = BridgeHolder.INSTANCE.getBridgeService(command.getService()).getKey();
        EngineBridgeService serviceName = (EngineBridgeService) key.getAnnotation(EngineBridgeService.class);
        boolean isServiceRegister = serviceName != null && Intrinsics.areEqual(serviceName.value(), command.getService());
        if (isServiceRegister) {
            return key;
        }
        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_SERVICE_ERROR.getMessage());
    }

    public final Object[] constructorCommandArgs(Method method, Command command, EngineBridgeCallback callback) {
        JSONObject jsonObject;
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(command, "command");
        Class<?>[] parameterTypes = method.getParameterTypes();
        Object[] args = new Object[parameterTypes.length];
        int originParamsCount = 0;
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "construct command: command=" + command + ", args=" + command.getArgs());
        try {
            if (TextUtils.isEmpty(command.getArgs())) {
                jsonObject = new JSONObject();
            } else {
                jsonObject = new JSONObject(command.getArgs());
                originParamsCount = jsonObject.length();
            }
            int length = parameterTypes.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls = parameterTypes[i];
                if (Intrinsics.areEqual(cls, Activity.class)) {
                    args[i] = EngineBridge.INSTANCE.getCurrentActivity$tap_common_release();
                    originParamsCount++;
                } else if (Intrinsics.areEqual(cls, EngineBridgeCallback.class)) {
                    if (callback == null) {
                        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_ARGS_ERROR.getExtraMessage("callback is null"));
                    }
                    args[i] = callback;
                    originParamsCount++;
                } else {
                    args[i] = findParams(jsonObject, method);
                }
            }
            TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "construct command over: command=" + command + ", args=" + command.getArgs());
            if (!checkParamsMatchMethod(jsonObject) || originParamsCount != args.length) {
                return new Object[0];
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return args;
    }

    private final boolean checkParamsMatchMethod(JSONObject jsonObject) {
        return jsonObject.length() == 0;
    }

    public final Object findParams(JSONObject jsonObject, Method method) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(method, "method");
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "findParams: jsonObject=" + jsonObject + ", method=" + method);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "parameterAnnotations");
        for (Annotation[] annotations : parameterAnnotations) {
            Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
            for (Annotation annotation : annotations) {
                if ((annotation instanceof EngineBridgeParams) && jsonObject.has(((EngineBridgeParams) annotation).value())) {
                    Object args = jsonObject.get(((EngineBridgeParams) annotation).value());
                    jsonObject.remove(((EngineBridgeParams) annotation).value());
                    if (args == JSONObject.NULL) {
                        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, " method " + method.getDeclaringClass().getName() + '.' + method.getName() + " param " + ((EngineBridgeParams) annotation).value() + " convert jsonNull to null");
                        args = null;
                    }
                    if (args instanceof JSONArray) {
                        return filterArray((JSONArray) args);
                    }
                    return args;
                }
            }
        }
        return null;
    }

    private final Object[] filterArray(JSONArray jsonArray) throws JSONException {
        int len = jsonArray.length();
        TapLogger.logi(EngineBridgeKt.ENGINE_BRIDGE_LOGGER_TAG, "filterArray: jsonArray=" + jsonArray);
        Class<?> cls = jsonArray.get(0).getClass();
        if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
            List result = new ArrayList();
            for (int i = 0; i < len; i++) {
                result.add(Boolean.valueOf(jsonArray.getBoolean(i)));
            }
            List $this$toTypedArray$iv = result;
            return $this$toTypedArray$iv.toArray(new Boolean[0]);
        }
        if (Intrinsics.areEqual(cls, Integer.TYPE)) {
            List result2 = new ArrayList();
            for (int i2 = 0; i2 < len; i2++) {
                result2.add(Integer.valueOf(jsonArray.getInt(i2)));
            }
            List $this$toTypedArray$iv2 = result2;
            return $this$toTypedArray$iv2.toArray(new Integer[0]);
        }
        if (Intrinsics.areEqual(cls, Long.TYPE)) {
            List result3 = new ArrayList();
            for (int i3 = 0; i3 < len; i3++) {
                result3.add(Long.valueOf(jsonArray.getLong(i3)));
            }
            List $this$toTypedArray$iv3 = result3;
            return $this$toTypedArray$iv3.toArray(new Long[0]);
        }
        if (Intrinsics.areEqual(cls, Float.TYPE)) {
            List result4 = new ArrayList();
            for (int i4 = 0; i4 < len; i4++) {
                result4.add(Float.valueOf((float) jsonArray.getDouble(i4)));
            }
            List $this$toTypedArray$iv4 = result4;
            return $this$toTypedArray$iv4.toArray(new Float[0]);
        }
        if (Intrinsics.areEqual(cls, Double.TYPE)) {
            List result5 = new ArrayList();
            for (int i5 = 0; i5 < len; i5++) {
                result5.add(Double.valueOf(jsonArray.getDouble(i5)));
            }
            List $this$toTypedArray$iv5 = result5;
            return $this$toTypedArray$iv5.toArray(new Double[0]);
        }
        if (Intrinsics.areEqual(cls, String.class)) {
            List result6 = new ArrayList();
            for (int i6 = 0; i6 < len; i6++) {
                String string = jsonArray.getString(i6);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                result6.add(string);
            }
            List $this$toTypedArray$iv6 = result6;
            return $this$toTypedArray$iv6.toArray(new String[0]);
        }
        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_ARGS_ERROR.getExtraMessage("数组类型的参数必须为基础数据类型!"));
    }
}
