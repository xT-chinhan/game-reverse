package com.tapsdk.tapad.internal.runtime;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class ModuleStore {
    private final Map<String, WasmModule> modules = new HashMap();

    public synchronized WasmModule get(String str) {
        return this.modules.get(str);
    }

    public synchronized void invalidateAllAndClear() {
        for (WasmModule wasmModule : this.modules.values()) {
            if (wasmModule != null) {
                wasmModule.markUnloaded();
            }
        }
        this.modules.clear();
    }

    public synchronized void put(String str, WasmModule wasmModule) {
        this.modules.put(str, wasmModule);
    }

    public synchronized WasmModule remove(String str) {
        return this.modules.remove(str);
    }
}
