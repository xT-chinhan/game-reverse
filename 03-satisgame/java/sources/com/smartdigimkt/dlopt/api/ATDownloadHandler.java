package com.smartdigimkt.dlopt.api;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.j.f;
import com.smartdigimkt.j.u;
import com.smartdigimkt.sdk.core.SDKContext;

/* JADX INFO: loaded from: classes3.dex */
public class ATDownloadHandler {
    public static ATApkManager getATApkManager(Context context) {
        if ((context instanceof Activity) && !TextUtils.isEmpty(SDKContext.getInstance().a())) {
            return new f(context, u.a(context));
        }
        return null;
    }
}
