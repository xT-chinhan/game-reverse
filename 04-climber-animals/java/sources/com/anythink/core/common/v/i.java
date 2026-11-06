package com.anythink.core.common.v;

import android.util.Log;
import com.anythink.core.api.ATAdInfo;

/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a(String str, String str2, ATAdInfo aTAdInfo, boolean z) {
        if (aTAdInfo != null) {
            return;
        }
        try {
            com.anythink.core.common.u.e.b("ATAdInfo is null", String.format("An exception occurred for placementId (%s) in the method %s. External adInfo is null: %s", str, str2, Boolean.valueOf(z)), com.anythink.core.common.d.t.b().r());
        } catch (Throwable th) {
            Log.e("i", "sendATAdInfoNullPointException error: " + th.getMessage());
        }
    }
}
