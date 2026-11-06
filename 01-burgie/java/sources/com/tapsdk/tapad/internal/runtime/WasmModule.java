package com.tapsdk.tapad.internal.runtime;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import java.util.Arrays;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public class WasmModule {
    private static final int CORE_STATE_HOST_INVALID_ARGUMENT = -9711;
    private static final int CORE_STATE_HOST_RUNTIME_UNAVAILABLE = -9712;
    private static final int CORE_STATE_HOST_WASM_CALL_FAILED = -9715;
    private static final int CORE_STATE_OUTPUT_CAPACITY_BYTES = 262144;
    private static final int FALLBACK_DISPLAY_HOST_INVALID_ARGUMENT = -9211;
    private static final int FALLBACK_DISPLAY_HOST_RUNTIME_UNAVAILABLE = -9212;
    private static final int FALLBACK_DISPLAY_HOST_WASM_CALL_FAILED = -9215;
    private static final int FALLBACK_DISPLAY_OUTPUT_CAPACITY_BYTES = 65536;
    private static final int MEDIATION_POOL_HOST_INVALID_ARGUMENT = -9811;
    private static final int MEDIATION_POOL_HOST_RUNTIME_UNAVAILABLE = -9812;
    private static final int MEDIATION_POOL_HOST_WASM_CALL_FAILED = -9815;
    private static final int MEDIATION_POOL_OUTPUT_CAPACITY_BYTES = 262144;
    private static final int MEDIATION_PROTOCOL_HOST_INVALID_ARGUMENT = -9611;
    private static final int MEDIATION_PROTOCOL_HOST_RUNTIME_UNAVAILABLE = -9612;
    private static final int MEDIATION_PROTOCOL_HOST_WASM_CALL_FAILED = -9615;
    private static final int MEDIATION_PROTOCOL_OUTPUT_CAPACITY_BYTES = 2097152;
    private static final int PRICING_HOST_INVALID_ARGUMENT = -9001;
    private static final int PRICING_HOST_RUNTIME_UNAVAILABLE = -9002;
    private static final int PRICING_HOST_WASM_CALL_FAILED = -9005;
    private static final int PRICING_OUTPUT_CAPACITY_BYTES = 2097152;
    static final int TEMPLATE_INVENTORY_ABI_VERSION = 1;
    private static final String TEMPLATE_INVENTORY_ABI_VERSION_EXPORT = "dirichlet_template_inventory_abi_version";
    static final int TEMPLATE_INVENTORY_ERROR = -1;
    private static final String TEMPLATE_INVENTORY_JSON_EXPORT = "dirichlet_template_inventory_json";
    private static final String TEMPLATE_INVENTORY_JSON_LEN_EXPORT = "dirichlet_template_inventory_json_len";
    static final int TEMPLATE_INVENTORY_MAX_JSON_BYTES = 2097152;
    private static final int TRACE_REPLAY_HOST_INVALID_ARGUMENT = -9411;
    private static final int TRACE_REPLAY_HOST_RUNTIME_UNAVAILABLE = -9412;
    private static final int TRACE_REPLAY_HOST_WASM_CALL_FAILED = -9415;
    private static final int TRACE_REPLAY_RECEIPT_BYTES = 72;
    private final String mName;
    private final long mNativePtr;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private volatile boolean mUnloaded = false;

    public static final class CoreStateResult {
        public final byte[] output;
        public final int status;

        public CoreStateResult(int i, byte[] bArr) {
            this.status = i;
            this.output = bArr;
        }

        public static CoreStateResult failure(int i) {
            return new CoreStateResult(i, new byte[0]);
        }

        public boolean isSuccess() {
            return this.status > 0;
        }
    }

    public static final class FallbackDisplaySnapshotResult {
        final byte[] output;
        final int status;

        /* JADX INFO: Access modifiers changed from: private */
        public static FallbackDisplaySnapshotResult failure(int i) {
            return new FallbackDisplaySnapshotResult(i, new byte[0]);
        }

        public boolean isSuccess() {
            return this.status > 0;
        }

        private FallbackDisplaySnapshotResult(int i, byte[] bArr) {
            this.status = i;
            this.output = bArr;
        }
    }

    public interface IntCallback {
        void onResult(int i);
    }

    public static final class MediationPoolResult {
        public final byte[] output;
        public final int status;

        public MediationPoolResult(int i, byte[] bArr) {
            this.status = i;
            this.output = bArr;
        }

        public static MediationPoolResult failure(int i) {
            return new MediationPoolResult(i, new byte[0]);
        }

        public boolean isSuccess() {
            return this.status > 0;
        }
    }

    public static final class MediationProtocolResult {
        public final byte[] output;
        public final int status;

        /* JADX INFO: Access modifiers changed from: private */
        public static MediationProtocolResult failure(int i) {
            return new MediationProtocolResult(i, new byte[0]);
        }

        public boolean isSuccess() {
            return this.status > 0;
        }

        private MediationProtocolResult(int i, byte[] bArr) {
            this.status = i;
            this.output = bArr;
        }
    }

    public static final class PricingEvaluationResult {
        public final byte[] output;
        public final int status;

        /* JADX INFO: Access modifiers changed from: private */
        public static PricingEvaluationResult failure(int i) {
            return new PricingEvaluationResult(i, new byte[0]);
        }

        public boolean isSuccess() {
            return this.status > 0;
        }

        private PricingEvaluationResult(int i, byte[] bArr) {
            this.status = i;
            this.output = bArr;
        }
    }

    public interface SecurityExecPermission {
        boolean isAllowed();
    }

    public static final class TemplateInventoryResult {
        public final int abiVersion;
        public final byte[] json;
        public final int status;

        /* JADX INFO: Access modifiers changed from: private */
        public static TemplateInventoryResult failure(int i) {
            return new TemplateInventoryResult(i, -1, new byte[0]);
        }

        public boolean isSuccess() {
            int i;
            return this.abiVersion == 1 && (i = this.status) > 0 && i == this.json.length;
        }

        private TemplateInventoryResult(int i, int i2, byte[] bArr) {
            this.abiVersion = i;
            this.status = i2;
            this.json = bArr;
        }
    }

    public interface TemplateInventoryTransport {
        int abiVersion();

        int copyJson(byte[] bArr);

        int jsonLength();
    }

    public WasmModule(String str, long j) {
        this.mName = str;
        this.mNativePtr = j;
    }

    private native Request nativeBuildSecurityHttpRequest(long j, int i, byte[] bArr, String str, String str2, String str3);

    private native int nativeCoreState(long j, int i, byte[] bArr, byte[] bArr2);

    private native byte[] nativeDecryptSecurityHttpResponse(long j, byte[] bArr, Request request);

    private native int nativeFallbackDisplaySnapshot(long j, int i, int i2, byte[] bArr);

    private native byte[] nativeGuardedSecurityExec(long j, int i, byte[] bArr, SecurityExecPermission securityExecPermission);

    private native boolean nativeHasFunction(long j, String str);

    private native int nativeMediationPool(long j, int i, byte[] bArr, byte[] bArr2);

    private native int nativeMediationProtocol(long j, int i, byte[] bArr, byte[] bArr2);

    private native int nativePostCallIntSync(long j, String str, Object[] objArr);

    private native void nativePostCallVoid(long j, String str, Object[] objArr);

    private native void nativePostCallVoidSync(long j, String str, Object[] objArr);

    private native int nativePricingEvaluate(long j, byte[] bArr, byte[] bArr2, byte[] bArr3);

    private native boolean nativeRecordSecurityMotionEvent(long j, String str, MotionEvent motionEvent);

    private native byte[] nativeSecurityExec(long j, int i, byte[] bArr);

    private native int nativeTemplateInventoryJson(long j, byte[] bArr);

    private native int nativeTraceReplay(long j, byte[] bArr, byte[] bArr2);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: postIntResult, reason: merged with bridge method [inline-methods] */
    public void m257lambda$callInt$0$comtapsdktapadinternalruntimeWasmModule(final IntCallback intCallback, final int i) {
        if (intCallback != null) {
            this.mMainHandler.post(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.WasmModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    intCallback.onResult(i);
                }
            });
        }
    }

    public static TemplateInventoryResult readTemplateInventory(TemplateInventoryTransport templateInventoryTransport) {
        if (templateInventoryTransport == null) {
            return TemplateInventoryResult.failure(-1);
        }
        int iAbiVersion = templateInventoryTransport.abiVersion();
        if (iAbiVersion != 1) {
            return TemplateInventoryResult.failure(iAbiVersion);
        }
        int iJsonLength = templateInventoryTransport.jsonLength();
        if (iJsonLength <= 0 || iJsonLength > 2097152) {
            return TemplateInventoryResult.failure(iAbiVersion);
        }
        byte[] bArr = new byte[iJsonLength];
        int iCopyJson = templateInventoryTransport.copyJson(bArr);
        return iCopyJson != iJsonLength ? TemplateInventoryResult.failure(iAbiVersion) : new TemplateInventoryResult(iAbiVersion, iCopyJson, bArr);
    }

    public Request buildSecurityHttpRequestSync(int i, byte[] bArr, String str, String str2, String str3) {
        if (this.mUnloaded || bArr == null || str == null || str2 == null || str3 == null) {
            return null;
        }
        return nativeBuildSecurityHttpRequest(this.mNativePtr, i, bArr, str, str2, str3);
    }

    public CoreStateResult callCoreStateSync(int i, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return CoreStateResult.failure(CORE_STATE_HOST_INVALID_ARGUMENT);
        }
        if (this.mUnloaded) {
            return CoreStateResult.failure(CORE_STATE_HOST_RUNTIME_UNAVAILABLE);
        }
        byte[] bArr2 = new byte[262144];
        int iNativeCoreState = nativeCoreState(this.mNativePtr, i, bArr, bArr2);
        if (iNativeCoreState <= 0) {
            return CoreStateResult.failure(iNativeCoreState);
        }
        return iNativeCoreState > 262144 ? CoreStateResult.failure(CORE_STATE_HOST_WASM_CALL_FAILED) : new CoreStateResult(iNativeCoreState, Arrays.copyOf(bArr2, iNativeCoreState));
    }

    public byte[] callGuardedSecurityExecSync(int i, byte[] bArr, SecurityExecPermission securityExecPermission) {
        return (this.mUnloaded || securityExecPermission == null) ? new byte[0] : nativeGuardedSecurityExec(this.mNativePtr, i, bArr, securityExecPermission);
    }

    public void callInt(final String str, final IntCallback intCallback, final Object... objArr) {
        if (this.mUnloaded) {
            m257lambda$callInt$0$comtapsdktapadinternalruntimeWasmModule(intCallback, 0);
            return;
        }
        final DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.WasmModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m258lambda$callInt$1$comtapsdktapadinternalruntimeWasmModule(intCallback, str, objArr, dirichletRuntime);
            }
        })) {
            return;
        }
        m257lambda$callInt$0$comtapsdktapadinternalruntimeWasmModule(intCallback, 0);
    }

    public int callIntSync(String str, Object... objArr) {
        if (this.mUnloaded) {
            return 0;
        }
        return nativePostCallIntSync(this.mNativePtr, str, objArr);
    }

    public MediationPoolResult callMediationPoolSync(int i, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return MediationPoolResult.failure(MEDIATION_POOL_HOST_INVALID_ARGUMENT);
        }
        if (this.mUnloaded) {
            return MediationPoolResult.failure(-9812);
        }
        byte[] bArr2 = new byte[262144];
        int iNativeMediationPool = nativeMediationPool(this.mNativePtr, i, bArr, bArr2);
        if (iNativeMediationPool <= 0) {
            return MediationPoolResult.failure(iNativeMediationPool);
        }
        return iNativeMediationPool > 262144 ? MediationPoolResult.failure(MEDIATION_POOL_HOST_WASM_CALL_FAILED) : new MediationPoolResult(iNativeMediationPool, Arrays.copyOf(bArr2, iNativeMediationPool));
    }

    public MediationProtocolResult callMediationProtocolSync(int i, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return MediationProtocolResult.failure(MEDIATION_PROTOCOL_HOST_INVALID_ARGUMENT);
        }
        if (this.mUnloaded) {
            return MediationProtocolResult.failure(MEDIATION_PROTOCOL_HOST_RUNTIME_UNAVAILABLE);
        }
        byte[] bArr2 = new byte[2097152];
        int iNativeMediationProtocol = nativeMediationProtocol(this.mNativePtr, i, bArr, bArr2);
        if (iNativeMediationProtocol <= 0) {
            return MediationProtocolResult.failure(iNativeMediationProtocol);
        }
        return iNativeMediationProtocol > 2097152 ? MediationProtocolResult.failure(MEDIATION_PROTOCOL_HOST_WASM_CALL_FAILED) : new MediationProtocolResult(iNativeMediationProtocol, Arrays.copyOf(bArr2, iNativeMediationProtocol));
    }

    public PricingEvaluationResult callPricingEvaluateSync(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return PricingEvaluationResult.failure(PRICING_HOST_INVALID_ARGUMENT);
        }
        if (this.mUnloaded) {
            return PricingEvaluationResult.failure(PRICING_HOST_RUNTIME_UNAVAILABLE);
        }
        byte[] bArr3 = new byte[2097152];
        int iNativePricingEvaluate = nativePricingEvaluate(this.mNativePtr, bArr, bArr2, bArr3);
        if (iNativePricingEvaluate <= 0) {
            return PricingEvaluationResult.failure(iNativePricingEvaluate);
        }
        return iNativePricingEvaluate > 2097152 ? PricingEvaluationResult.failure(PRICING_HOST_WASM_CALL_FAILED) : new PricingEvaluationResult(iNativePricingEvaluate, Arrays.copyOf(bArr3, iNativePricingEvaluate));
    }

    public byte[] callSecurityExecSync(int i, byte[] bArr) {
        return this.mUnloaded ? new byte[0] : nativeSecurityExec(this.mNativePtr, i, bArr);
    }

    public void callVoid(String str, Object... objArr) {
        if (this.mUnloaded) {
            return;
        }
        nativePostCallVoid(this.mNativePtr, str, objArr);
    }

    public void callVoidSync(String str, Object... objArr) {
        if (this.mUnloaded) {
            return;
        }
        nativePostCallVoidSync(this.mNativePtr, str, objArr);
    }

    public int copyTemplateInventoryJson(byte[] bArr) {
        if (this.mUnloaded) {
            return -1;
        }
        if ((bArr == null || bArr.length <= 2097152) && hasFunction(TEMPLATE_INVENTORY_JSON_EXPORT)) {
            return nativeTemplateInventoryJson(this.mNativePtr, bArr);
        }
        return -1;
    }

    public byte[] decryptSecurityHttpResponseSync(byte[] bArr, Request request) {
        return (this.mUnloaded || bArr == null || request == null) ? new byte[0] : nativeDecryptSecurityHttpResponse(this.mNativePtr, bArr, request);
    }

    public String getName() {
        return this.mName;
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public boolean hasFunction(String str) {
        if (this.mUnloaded) {
            return false;
        }
        return nativeHasFunction(this.mNativePtr, str);
    }

    public boolean isUnloaded() {
        return this.mUnloaded;
    }

    /* JADX INFO: renamed from: lambda$callInt$1$com-tapsdk-tapad-internal-runtime-WasmModule, reason: not valid java name */
    /* synthetic */ void m258lambda$callInt$1$comtapsdktapadinternalruntimeWasmModule(final IntCallback intCallback, String str, Object[] objArr, DirichletRuntime dirichletRuntime) {
        if (this.mUnloaded) {
            m257lambda$callInt$0$comtapsdktapadinternalruntimeWasmModule(intCallback, 0);
            return;
        }
        try {
            final int iNativePostCallIntSync = nativePostCallIntSync(this.mNativePtr, str, objArr);
            if (intCallback == null || dirichletRuntime.runOnRuntimeQueue(new Runnable() { // from class: com.tapsdk.tapad.internal.runtime.WasmModule$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m257lambda$callInt$0$comtapsdktapadinternalruntimeWasmModule(intCallback, iNativePostCallIntSync);
                }
            })) {
                return;
            }
            m257lambda$callInt$0$comtapsdktapadinternalruntimeWasmModule(intCallback, iNativePostCallIntSync);
        } catch (Error | RuntimeException e) {
            m257lambda$callInt$0$comtapsdktapadinternalruntimeWasmModule(intCallback, 0);
            throw e;
        }
    }

    public void markUnloaded() {
        this.mUnloaded = true;
    }

    public TemplateInventoryResult readTemplateInventorySync() {
        return this.mUnloaded ? TemplateInventoryResult.failure(-1) : readTemplateInventory(new TemplateInventoryTransport() { // from class: com.tapsdk.tapad.internal.runtime.WasmModule.1
            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.TemplateInventoryTransport
            public int abiVersion() {
                return WasmModule.this.templateInventoryAbiVersion();
            }

            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.TemplateInventoryTransport
            public int copyJson(byte[] bArr) {
                return WasmModule.this.copyTemplateInventoryJson(bArr);
            }

            @Override // com.tapsdk.tapad.internal.runtime.WasmModule.TemplateInventoryTransport
            public int jsonLength() {
                return WasmModule.this.templateInventoryJsonLength();
            }
        });
    }

    public boolean recordSecurityMotionEvent(String str, MotionEvent motionEvent) {
        if (this.mUnloaded || str == null || str.length() == 0 || motionEvent == null) {
            return false;
        }
        return nativeRecordSecurityMotionEvent(this.mNativePtr, str, motionEvent);
    }

    public int replayTraceSync(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length != 72) {
            return TRACE_REPLAY_HOST_INVALID_ARGUMENT;
        }
        if (this.mUnloaded) {
            return TRACE_REPLAY_HOST_RUNTIME_UNAVAILABLE;
        }
        int iNativeTraceReplay = nativeTraceReplay(this.mNativePtr, bArr, bArr2);
        return (iNativeTraceReplay == bArr2.length || iNativeTraceReplay < 0) ? iNativeTraceReplay : TRACE_REPLAY_HOST_WASM_CALL_FAILED;
    }

    public FallbackDisplaySnapshotResult snapshotFallbackDisplaySpec(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return FallbackDisplaySnapshotResult.failure(FALLBACK_DISPLAY_HOST_INVALID_ARGUMENT);
        }
        if (this.mUnloaded) {
            return FallbackDisplaySnapshotResult.failure(FALLBACK_DISPLAY_HOST_RUNTIME_UNAVAILABLE);
        }
        byte[] bArr = new byte[65536];
        int iNativeFallbackDisplaySnapshot = nativeFallbackDisplaySnapshot(this.mNativePtr, i, i2, bArr);
        if (iNativeFallbackDisplaySnapshot <= 0) {
            return FallbackDisplaySnapshotResult.failure(iNativeFallbackDisplaySnapshot);
        }
        return iNativeFallbackDisplaySnapshot > 65536 ? FallbackDisplaySnapshotResult.failure(FALLBACK_DISPLAY_HOST_WASM_CALL_FAILED) : new FallbackDisplaySnapshotResult(iNativeFallbackDisplaySnapshot, Arrays.copyOf(bArr, iNativeFallbackDisplaySnapshot));
    }

    public int templateInventoryAbiVersion() {
        if (this.mUnloaded || !hasFunction(TEMPLATE_INVENTORY_ABI_VERSION_EXPORT)) {
            return -1;
        }
        return callIntSync(TEMPLATE_INVENTORY_ABI_VERSION_EXPORT, new Object[0]);
    }

    public int templateInventoryJsonLength() {
        int iCallIntSync;
        if (this.mUnloaded || !hasFunction(TEMPLATE_INVENTORY_JSON_LEN_EXPORT) || (iCallIntSync = callIntSync(TEMPLATE_INVENTORY_JSON_LEN_EXPORT, new Object[0])) <= 0 || iCallIntSync > 2097152) {
            return -1;
        }
        return iCallIntSync;
    }
}
