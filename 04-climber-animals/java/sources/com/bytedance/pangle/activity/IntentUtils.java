package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class IntentUtils {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    static HashMap<Long, WeakReference<Bundle>> f617ms = new HashMap<>();

    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void ms(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            ms(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    private static void ms(long j, Bundle bundle) {
        f617ms.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void ms(Intent intent) {
        Bundle bundleMs;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (bundleMs = ms(longExtra)) == null) {
            return;
        }
        intent.putExtras(bundleMs);
    }

    private static Bundle ms(long j) {
        WeakReference<Bundle> weakReferenceRemove = f617ms.remove(Long.valueOf(j));
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
