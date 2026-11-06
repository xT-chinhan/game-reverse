package com.taptap.sdk.kit.internal.enginebridge.command;

import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.enginebridge.EngineBridgeCallback;
import com.taptap.sdk.kit.internal.enginebridge.IEngineBridgeService;
import com.taptap.sdk.kit.internal.enginebridge.annotation.EngineBridgeMethod;
import com.taptap.sdk.kit.internal.enginebridge.exception.BridgeExceptionMessage;
import com.taptap.sdk.kit.internal.enginebridge.exception.EngineBridgeException;
import com.taptap.sdk.kit.internal.enginebridge.internal.BridgeHolder;
import com.taptap.sdk.kit.internal.enginebridge.internal.EngineBridgeReflector;
import com.taptap.sdk.kit.internal.json.TapJson;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.modules.SerializersModule;

/* JADX INFO: compiled from: CommandExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\f"}, d2 = {"Lcom/taptap/sdk/kit/internal/enginebridge/command/CommandExecutor;", "Lcom/taptap/sdk/kit/internal/enginebridge/command/ICommandExecutor;", "()V", "execute", "", "command", "Lcom/taptap/sdk/kit/internal/enginebridge/command/Command;", "callback", "Lcom/taptap/sdk/kit/internal/enginebridge/EngineBridgeCallback;", "executeAsync", "", "invokeCommand", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CommandExecutor implements ICommandExecutor {
    @Override // com.taptap.sdk.kit.internal.enginebridge.command.ICommandExecutor
    public void execute(Command command, EngineBridgeCallback callback) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(callback, "callback");
        EngineBridgeReflector.INSTANCE.checkCommand(command);
        Object it = invokeCommand(command, callback);
        if (it != null) {
            TapJson this_$iv = TapJson.INSTANCE;
            String strEncodeToString = null;
            try {
                StringFormat $this$encodeToString$iv$iv = this_$iv.getJson();
                SerializersModule $this$serializer$iv$iv$iv = $this$encodeToString$iv$iv.getSerializersModule();
                KSerializer<Object> kSerializerSerializer = SerializersKt.serializer($this$serializer$iv$iv$iv, Reflection.typeOf(Object.class));
                Intrinsics.checkNotNull(kSerializerSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                strEncodeToString = $this$encodeToString$iv$iv.encodeToString(kSerializerSerializer, it);
            } catch (Exception e$iv) {
                TapLogger.loge$default(TapJson.TAG, null, e$iv, 2, null);
            }
            if (strEncodeToString == null) {
                strEncodeToString = "";
            }
            callback.onResult(strEncodeToString);
        }
    }

    @Override // com.taptap.sdk.kit.internal.enginebridge.command.ICommandExecutor
    public Object executeAsync(Command command) {
        Intrinsics.checkNotNullParameter(command, "command");
        EngineBridgeReflector.INSTANCE.checkCommand(command);
        return invokeCommand$default(this, command, null, 2, null);
    }

    static /* synthetic */ Object invokeCommand$default(CommandExecutor commandExecutor, Command command, EngineBridgeCallback engineBridgeCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            engineBridgeCallback = null;
        }
        return commandExecutor.invokeCommand(command, engineBridgeCallback);
    }

    private final Object invokeCommand(Command command, EngineBridgeCallback callback) {
        String expandMessage = "";
        IEngineBridgeService targetInstance = BridgeHolder.INSTANCE.getBridgeService(command.getService()).getValue();
        Method targetMethod = null;
        Object[] targetArgs = null;
        try {
            Method[] methods = EngineBridgeReflector.INSTANCE.getRegisteredService(command).getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "methods");
            for (Method method : methods) {
                EngineBridgeMethod bridgeMethod = (EngineBridgeMethod) method.getAnnotation(EngineBridgeMethod.class);
                if (Intrinsics.areEqual(bridgeMethod != null ? bridgeMethod.value() : null, command.getMethod())) {
                    EngineBridgeReflector engineBridgeReflector = EngineBridgeReflector.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(method, "method");
                    try {
                        Object[] args = engineBridgeReflector.constructorCommandArgs(method, command, callback);
                        if (args.length == method.getParameterTypes().length) {
                            targetMethod = method;
                            targetArgs = args;
                        }
                    } catch (IllegalAccessException e) {
                        e = e;
                        e.printStackTrace();
                        if (e.getCause() != null) {
                            Throwable cause = e.getCause();
                            Intrinsics.checkNotNull(cause);
                            expandMessage = cause.getMessage();
                        }
                        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_ARGS_ERROR.getExtraMessage(expandMessage));
                    } catch (IllegalArgumentException e2) {
                        e = e2;
                        e.printStackTrace();
                        if (e.getCause() != null) {
                            Throwable cause2 = e.getCause();
                            Intrinsics.checkNotNull(cause2);
                            expandMessage = cause2.getMessage();
                        }
                        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_ARGS_ERROR.getExtraMessage(expandMessage));
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        e.printStackTrace();
                        if (e.getCause() != null) {
                            Throwable cause3 = e.getCause();
                            expandMessage = cause3 != null ? cause3.getMessage() : null;
                        }
                        throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_ARGS_ERROR.getExtraMessage(expandMessage));
                    }
                }
            }
            if (targetArgs == null) {
                throw new EngineBridgeException(BridgeExceptionMessage.COMMAND_ARGS_ERROR.getMessage());
            }
            if (targetMethod != null) {
                return targetMethod.invoke(targetInstance, Arrays.copyOf(targetArgs, targetArgs.length));
            }
            return null;
        } catch (IllegalAccessException e4) {
            e = e4;
        } catch (IllegalArgumentException e5) {
            e = e5;
        } catch (InvocationTargetException e6) {
            e = e6;
        }
    }
}
