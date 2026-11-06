package com.kwad.sdk.liteapi.oaid.helpers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public class HONORProxy {
    public Info info;
    public Context mContext;
    public final BinderOne mBinderOne = new BinderOne();
    public final BinderTwo mBinderTwo = new BinderTwo();
    public final CountDownLatch mCountDownLatch = new CountDownLatch(2);

    public static final class Info {
        public String id;
        public boolean isLimit;
    }

    public class BinderOne extends HONORProxyInterface.AbstractBinderC0001a {
        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.AbstractBinderC0001a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        public BinderOne() {
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.AbstractBinderC0001a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public void a(int i, Bundle bundle) {
            LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            if (i == 0) {
                try {
                    Info info = HONORProxy.this.info;
                    if (info != null) {
                        info.id = bundle.getString("oa_id_flag");
                        LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult success");
                    }
                } catch (Throwable th) {
                    LiteApiLogger.d("HONORDeviceIDHelper", "OAIDCallBack handleResult error: " + th.getMessage());
                    return;
                }
            }
            HONORProxy.countDown(HONORProxy.this);
        }
    }

    public class BinderTwo extends HONORProxyInterface.AbstractBinderC0001a {
        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.AbstractBinderC0001a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        public BinderTwo() {
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface.AbstractBinderC0001a, com.kwad.sdk.liteapi.oaid.interfaces.HONORProxyInterface
        public void a(int i, Bundle bundle) {
            LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            if (i == 0) {
                try {
                    if (HONORProxy.this.info != null) {
                        boolean z = bundle.getBoolean("oa_id_limit_state");
                        HONORProxy.this.info.isLimit = z;
                        LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult success  isLimit=" + z);
                    }
                } catch (Throwable th) {
                    LiteApiLogger.d("HONORDeviceIDHelper", "OAIDLimitCallback handleResult error:  " + th.getMessage());
                    return;
                }
            }
            HONORProxy.countDown(HONORProxy.this);
        }
    }

    public boolean isAdvertisingIdAvailable(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void countDown(HONORProxy hONORProxy) {
        try {
            hONORProxy.mCountDownLatch.countDown();
        } catch (Exception e) {
            LiteApiLogger.d("HONORDeviceIDHelper", "doCountDown  error:  " + e.getMessage());
        }
    }
}
