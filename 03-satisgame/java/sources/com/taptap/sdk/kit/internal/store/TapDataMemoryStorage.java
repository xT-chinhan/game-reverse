package com.taptap.sdk.kit.internal.store;

import com.anythink.core.common.f.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapDataMemoryStorage.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/taptap/sdk/kit/internal/store/TapDataMemoryStorage;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "get", e.a.b, "put", "", e.a.d, "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapDataMemoryStorage {
    public static final TapDataMemoryStorage INSTANCE = new TapDataMemoryStorage();
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    private TapDataMemoryStorage() {
    }

    public final void put(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        String str = value;
        if (str == null || str.length() == 0) {
            map.remove(key);
        } else {
            map.put(key, value);
        }
    }

    public final String get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return map.get(key);
    }
}
