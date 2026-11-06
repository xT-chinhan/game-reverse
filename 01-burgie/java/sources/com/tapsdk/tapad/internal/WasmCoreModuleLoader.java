package com.tapsdk.tapad.internal;

import com.tapsdk.tapad.internal.runtime.CoreModuleSelector;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.WasmModule;

/* JADX INFO: loaded from: classes2.dex */
public final class WasmCoreModuleLoader {

    public interface Callback {
        void onError(Exception exc);

        void onLoaded(WasmModule wasmModule);
    }

    private WasmCoreModuleLoader() {
    }

    public static void load(DirichletRuntime dirichletRuntime, Callback callback) {
        loadCore(dirichletRuntime, callback);
    }

    public static void loadAd(DirichletRuntime dirichletRuntime, Callback callback) {
        loadCore(dirichletRuntime, callback);
    }

    public static void loadAuction(DirichletRuntime dirichletRuntime, Callback callback) {
        loadCore(dirichletRuntime, callback);
    }

    private static void loadCore(DirichletRuntime dirichletRuntime, Callback callback) {
        loadDomain(dirichletRuntime, CoreModuleSelector.WASM_ENTRY, "core", callback);
    }

    private static void loadDomain(DirichletRuntime dirichletRuntime, String str, String str2, final Callback callback) {
        dirichletRuntime.loadModuleFromBundle("core", str, str2, new DirichletRuntime.ModuleLoadCallback() { // from class: com.tapsdk.tapad.internal.WasmCoreModuleLoader.1
            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onError(Exception exc) {
                callback.onError(exc);
            }

            @Override // com.tapsdk.tapad.internal.runtime.DirichletRuntime.ModuleLoadCallback
            public void onSuccess(WasmModule wasmModule) {
                callback.onLoaded(wasmModule);
            }
        });
    }
}
