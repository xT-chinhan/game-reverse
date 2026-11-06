package com.tapsdk.tapad.internal.runtime;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class WasmAdInstance {
    private static final String TAG = "WasmAdInstance";
    private final DirichletRuntime.NativeCallback mCallback;
    private boolean mDisposed;
    private final int mInstanceId;
    private final WasmModule mModule;

    private WasmAdInstance(int i, WasmModule wasmModule, DirichletRuntime.NativeCallback nativeCallback) {
        this.mInstanceId = i;
        this.mModule = wasmModule;
        this.mCallback = nativeCallback;
    }

    public static WeakReference<WasmAdInstance> create(WasmModule wasmModule, DirichletRuntime.NativeCallback nativeCallback) {
        if (wasmModule == null || nativeCallback == null) {
            return new WeakReference<>(null);
        }
        try {
            int iCallIntSync = wasmModule.callIntSync("ad_create_instance", new Object[0]);
            if (iCallIntSync <= 0) {
                return new WeakReference<>(null);
            }
            WasmAdInstance wasmAdInstance = new WasmAdInstance(iCallIntSync, wasmModule, nativeCallback);
            DirichletRuntime.getInstance().retainInstance(wasmAdInstance);
            return new WeakReference<>(wasmAdInstance);
        } catch (Throwable th) {
            return new WeakReference<>(null);
        }
    }

    public DirichletRuntime.NativeCallback callback() {
        return this.mCallback;
    }

    public synchronized void dispose() {
        if (this.mDisposed) {
            return;
        }
        this.mDisposed = true;
        try {
            this.mModule.callVoid("ad_destroy_instance", Integer.valueOf(this.mInstanceId));
        } catch (Throwable th) {
        }
        DirichletRuntime.getInstance().releaseInstance(this.mInstanceId);
    }

    public int instanceId() {
        return this.mInstanceId;
    }

    public synchronized boolean isDisposed() {
        return this.mDisposed;
    }

    public WasmModule module() {
        return this.mModule;
    }
}
