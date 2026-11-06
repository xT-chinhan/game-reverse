package com.tapsdk.tapad.internal.runtime;

import com.tapsdk.tapad.TapAdConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class NativeLibraryLoader {
    private static volatile boolean loaded;

    private NativeLibraryLoader() {
    }

    public static void load() {
        if (loaded) {
            return;
        }
        synchronized (NativeLibraryLoader.class) {
            if (loaded) {
                return;
            }
            String property = System.getProperty("dirichlet.native.path");
            if (property == null || property.length() <= 0) {
                System.loadLibrary(TapAdConfig.AggregationChannel.DIRICHLET);
            } else {
                System.load(property);
            }
            loaded = true;
        }
    }
}
