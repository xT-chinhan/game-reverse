package com.onevcat.uniwebview;

import android.app.Activity;
import android.webkit.WebViewDatabase;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.onevcat.uniwebview.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0758u {
    public static void a(Activity activity, String host, String realm) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(realm, "realm");
        WebViewDatabase.getInstance(activity).clearHttpAuthUsernamePassword();
    }
}
