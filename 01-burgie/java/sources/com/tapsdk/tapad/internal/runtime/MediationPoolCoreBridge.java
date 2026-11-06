package com.tapsdk.tapad.internal.runtime;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class MediationPoolCoreBridge {
    public static final int ERR_INVALID_OUTPUT = -9817;
    public static final int ERR_RUNTIME_UNAVAILABLE = -9812;
    private static final int MAX_OUTPUT_BYTES = 262144;
    public static final int OP_BIND_SLOT = 2;
    public static final int OP_CLEAR = 11;
    public static final int OP_CREATE = 1;
    public static final int OP_DESTROY = 12;
    public static final int OP_LEASE_EVENT = 8;
    public static final int OP_LOAD_RESULT = 6;
    public static final int OP_NEXT_SLOT = 3;
    public static final int OP_PRELOAD = 4;
    public static final int OP_QUERY_SLOT = 7;
    public static final int OP_SNAPSHOT = 13;
    public static final int OP_TAKE = 5;
    public static final int OP_TICK = 9;
    private static final String TAG = "MediationPoolCore";

    public static final class Result {
        public final JSONObject output;
        public final int status;

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

    private MediationPoolCoreBridge() {
    }

    public static Result transform(int i, JSONObject jSONObject) {
        try {
            return transform(DirichletRuntime.getInstance().getModule("core"), i, jSONObject);
        } catch (Throwable th) {
            return Result.failure(ERR_RUNTIME_UNAVAILABLE);
        }
    }

    public static Result transform(WasmModule wasmModule, int i, JSONObject jSONObject) {
        if (!DirichletRuntime.getInstance().isOnRuntimeQueue()) {
            return Result.failure(ERR_RUNTIME_UNAVAILABLE);
        }
        if (jSONObject == null) {
            return Result.failure(ERR_INVALID_OUTPUT);
        }
        if (wasmModule != null && !wasmModule.isUnloaded()) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                if (!jSONObject2.has("wall_time_ms")) {
                    jSONObject2.put("wall_time_ms", System.currentTimeMillis());
                }
                String string = jSONObject2.toString();
                Charset charset = StandardCharsets.UTF_8;
                WasmModule.MediationPoolResult mediationPoolResultCallMediationPoolSync = wasmModule.callMediationPoolSync(i, string.getBytes(charset));
                if (!mediationPoolResultCallMediationPoolSync.isSuccess()) {
                    return Result.failure(mediationPoolResultCallMediationPoolSync.status);
                }
                byte[] bArr = mediationPoolResultCallMediationPoolSync.output;
                if (bArr.length != 0 && bArr.length <= 262144) {
                    JSONObject jSONObject3 = new JSONObject(new String(mediationPoolResultCallMediationPoolSync.output, charset));
                    if (jSONObject3.optInt("schema_version", 0) != 1) {
                        return Result.failure(ERR_INVALID_OUTPUT);
                    }
                    return new Result(mediationPoolResultCallMediationPoolSync.status, jSONObject3);
                }
                return Result.failure(ERR_INVALID_OUTPUT);
            } catch (Throwable th) {
                return Result.failure(ERR_INVALID_OUTPUT);
            }
        }
        return Result.failure(ERR_RUNTIME_UNAVAILABLE);
    }
}
