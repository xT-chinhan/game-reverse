package com.mcto.sspsdk;

import android.content.Context;
import android.util.Log;
import com.mcto.sspsdk.internal.f8;
import com.mcto.sspsdk.internal.jd;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.rd;
import com.mcto.sspsdk.internal.zd;

/* JADX INFO: loaded from: classes2.dex */
public final class QyClient {
    public QyClient(Context context, QySdkConfig qySdkConfig) {
        boolean z = rd.a;
        if (qySdkConfig.getQyCustomMade() == null) {
            throw new RuntimeException("SDK初始化的时候QySdkConfig中QyCustomMade是必须要设置的。");
        }
        rd.f = qySdkConfig.getAppId();
        qySdkConfig.getAppName();
        rd.e = qySdkConfig.isDebug();
        rd.c = qySdkConfig.isForceRequestHttps();
        rd.d = qySdkConfig.getQyCustomMade();
        r9.a = rd.e ? 0 : 3;
        Log.e("ssp_sdk", "Version: 2.3.102, Version Code: 2026041616");
        jd.a(context, qySdkConfig.getMainProcessName());
        f8.a();
    }

    public IQYNative createAdNative(Context context) {
        return new zd(context);
    }
}
