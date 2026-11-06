package com.mcto.sspsdk;

import android.content.Context;
import com.mcto.sspsdk.internal.kh;
import com.mcto.sspsdk.internal.v4;
import com.mcto.sspsdk.internal.zg;

/* JADX INFO: loaded from: classes2.dex */
public final class QySdk {
    public static final String SDK_VERSION = "2.3.102";
    private static volatile boolean sInitialized;
    private static volatile QyClient sQyClient;

    public interface InitCallBack {
        void fail(int i, String str);

        void success();
    }

    private QySdk() {
    }

    public static QyClient getAdClient() {
        return sQyClient;
    }

    public static QyClient init(Context context, QySdkConfig qySdkConfig) {
        try {
            v4.a(context).d();
        } catch (Throwable th) {
        }
        if (!sInitialized) {
            synchronized (QySdk.class) {
                if (!sInitialized) {
                    sQyClient = new QyClient(context, qySdkConfig);
                    sInitialized = true;
                }
            }
        }
        return sQyClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postToMainThread(InitCallBack initCallBack, boolean z, Throwable th) {
        kh.a.a(new b(initCallBack, z, th));
    }

    public static void init(Context context, QySdkConfig qySdkConfig, InitCallBack initCallBack) {
        if (sInitialized) {
            postToMainThread(initCallBack, true, null);
        } else {
            zg.a.a(new a(context, qySdkConfig, initCallBack));
        }
    }
}
