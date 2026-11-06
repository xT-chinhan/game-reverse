package com.tapsdk.tapad.internal.runtime;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AdnRuntimeCoreBridge {
    private static final int ERR_INVALID_OUTPUT = -9717;
    private static final int ERR_RUNTIME_UNAVAILABLE = -9712;
    private static final int MAX_LOAD_LOSS_BYTES = 262144;
    private static final int MAX_OUTPUT_BYTES = 262144;
    private static final int OP_ACK_EVENT = 10;
    private static final int OP_PLATFORM_LIFECYCLE = 16;
    private static final int OP_PROJECT_LIFECYCLE = 11;
    private static final int OP_PROJECT_TELEMETRY = 8;

    public static final class Result {
        public final JSONObject output;
        public final int status;

        /* JADX INFO: Access modifiers changed from: private */
        public static Result failure(int i) {
            return new Result(i, null);
        }

        public boolean isSuccess() {
            return this.status > 0 && this.output != null;
        }

        private Result(int i, JSONObject jSONObject) {
            this.status = i;
            this.output = jSONObject;
        }
    }

    private AdnRuntimeCoreBridge() {
    }

    public static void acknowledgeEvent(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            execute(10, new JSONObject().put("event_id", str).put("accepted", z));
        } catch (Throwable th) {
        }
    }

    private static Result execute(int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
        try {
            WasmModule module = DirichletRuntime.getInstance().getModule("core");
            if (module != null && !module.isUnloaded()) {
                String string = jSONObject.toString();
                Charset charset = StandardCharsets.UTF_8;
                WasmModule.CoreStateResult coreStateResultCallCoreStateSync = module.callCoreStateSync(i, string.getBytes(charset));
                if (coreStateResultCallCoreStateSync.isSuccess()) {
                    byte[] bArr = coreStateResultCallCoreStateSync.output;
                    if (bArr.length != 0 && bArr.length <= 262144) {
                        JSONObject jSONObject2 = new JSONObject(new String(coreStateResultCallCoreStateSync.output, charset));
                        return jSONObject2.optInt("schema_version", 0) != 1 ? Result.failure(ERR_INVALID_OUTPUT) : new Result(coreStateResultCallCoreStateSync.status, jSONObject2);
                    }
                }
                return Result.failure(coreStateResultCallCoreStateSync.status);
            }
            return Result.failure(ERR_RUNTIME_UNAVAILABLE);
        } catch (Throwable th) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
    }

    public static Result projectLifecycle(JSONObject jSONObject) {
        return execute(11, jSONObject);
    }

    public static Result projectPlatformLifecycle(JSONObject jSONObject) {
        return execute(16, jSONObject);
    }

    public static Result projectTelemetry(JSONObject jSONObject) {
        return execute(8, jSONObject);
    }

    public static void reportLoadLoss(String str, Map<String, Object> map) {
        WasmModule module;
        if (map == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !key.isEmpty()) {
                    Object value = entry.getValue();
                    if (value == null) {
                        jSONObject.put(key, JSONObject.NULL);
                    } else if ((value instanceof String) || (value instanceof Number) || (value instanceof Boolean)) {
                        jSONObject.put(key, value);
                    } else {
                        jSONObject.put(key, String.valueOf(value));
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str == null) {
                str = "";
            }
            String string = jSONObject2.put("error_message", str).put("params", jSONObject).toString();
            if (string.getBytes(StandardCharsets.UTF_8).length <= 262144 && (module = DirichletRuntime.getInstance().getModule("core")) != null && !module.isUnloaded()) {
                module.callVoid("ad_send_load_loss_notification", string);
            }
        } catch (Throwable th) {
        }
    }
}
