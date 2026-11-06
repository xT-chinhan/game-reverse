package com.anythink.core.common.u;

import android.util.Log;
import com.anythink.core.api.ATAdInfo;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static void a(String str, String str2, ATAdInfo aTAdInfo, boolean z) {
        if (aTAdInfo != null) {
            return;
        }
        try {
            com.anythink.core.common.t.f.b("ATAdInfo is null", String.format("An exception occurred for placementId (%s) in the method %s. External adInfo is null: %s", str, str2, Boolean.valueOf(z)), com.anythink.core.common.d.s.b().r());
        } catch (Throwable th) {
            Log.e("h", "sendATAdInfoNullPointException error: " + th.getMessage());
        }
    }
}
