package com.byazt.fd;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 43, 1117})
public class IntentUtils {
    public static HashMap<Long, WeakReference<Bundle>> pr = new HashMap<>();

    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void pr(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            pr(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    private static void pr(long j, Bundle bundle) {
        pr.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void pr(Intent intent) {
        Bundle bundlePr;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra != 0 && (bundlePr = pr(longExtra)) != null) {
            intent.putExtras(bundlePr);
        }
    }

    private static Bundle pr(long j) {
        WeakReference<Bundle> weakReferenceRemove = pr.remove(Long.valueOf(j));
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
