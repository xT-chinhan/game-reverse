package com.anythink.dlopt.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.d.t;
import com.anythink.dlopt.common.a;
import com.anythink.dlopt.common.b;

/* JADX INFO: loaded from: classes.dex */
public class ATDownloadHandler {
    public static ATApkManager getATApkManager(Context context) {
        if (!(context instanceof Activity)) {
            Log.e("anythink", "Context must be Activity.");
            return null;
        }
        if (TextUtils.isEmpty(t.b().p())) {
            Log.e("anythink", "getATApkManager() failed. You should init SDK first.");
            return null;
        }
        return new a(context, b.a(context));
    }
}
