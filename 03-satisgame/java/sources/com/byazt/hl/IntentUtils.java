package com.byazt.hl;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1041, 1190})
public class IntentUtils {
    public static HashMap<Long, WeakReference<Bundle>> n = new HashMap<>();

    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void n(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            n(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    private static void n(long j, Bundle bundle) {
        n.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void n(Intent intent) {
        Bundle bundleN;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (bundleN = n(longExtra)) == null) {
            return;
        }
        intent.putExtras(bundleN);
    }

    private static Bundle n(long j) {
        WeakReference<Bundle> weakReferenceRemove = n.remove(Long.valueOf(j));
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
