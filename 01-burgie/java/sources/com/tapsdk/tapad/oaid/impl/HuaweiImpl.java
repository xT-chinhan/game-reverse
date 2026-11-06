package com.tapsdk.tapad.oaid.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.tapsdk.tapad.oaid.IGetter;
import com.tapsdk.tapad.oaid.IOAID;
import com.tapsdk.tapad.oaid.OAIDException;
import com.tapsdk.tapad.oaid.huawei.AdvertisingIdClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
class HuaweiImpl implements IOAID {
    private static final ExecutorService HUAWEI_OAID_EXECUTOR = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.tapsdk.tapad.oaid.impl.HuaweiImpl$$ExternalSyntheticLambda3
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return HuaweiImpl.lambda$static$0(runnable);
        }
    });
    private final Context context;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    public HuaweiImpl(Context context) {
        this.context = context;
    }

    static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "TapAd-HuaweiOAID");
        thread.setDaemon(true);
        thread.setPriority(1);
        return thread;
    }

    private void postOnMainThread(final IGetter iGetter, final String str) {
        this.uiHandler.post(new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.HuaweiImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                iGetter.onOAIDGetComplete(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: runOnSubThread, reason: merged with bridge method [inline-methods] */
    public void m396lambda$doGet$1$comtapsdktapadoaidimplHuaweiImpl(IGetter iGetter) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
            if (advertisingIdInfo == null) {
                postOnMainThread(iGetter, new OAIDException("Advertising identifier info is null"));
            } else if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                postOnMainThread(iGetter, new OAIDException("User has disabled advertising identifier"));
            } else {
                postOnMainThread(iGetter, advertisingIdInfo.getId());
            }
        } catch (Throwable th) {
            postOnMainThread(iGetter, new OAIDException(th));
        }
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void doGet(final IGetter iGetter) {
        HUAWEI_OAID_EXECUTOR.execute(new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.HuaweiImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m396lambda$doGet$1$comtapsdktapadoaidimplHuaweiImpl(iGetter);
            }
        });
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public String getName() {
        return "Huawei";
    }

    @Override // com.tapsdk.tapad.oaid.IOAID
    public void supported() {
        try {
            if (AdvertisingIdClient.isAdvertisingIdAvailable(this.context)) {
                return;
            }
            PackageManager packageManager = this.context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null && packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                throw new OAIDException("com.huawei 不支持 oaid 接口");
            }
        } catch (Throwable th) {
            throw new OAIDException(th);
        }
    }

    private void postOnMainThread(final IGetter iGetter, final OAIDException oAIDException) {
        this.uiHandler.post(new Runnable() { // from class: com.tapsdk.tapad.oaid.impl.HuaweiImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                iGetter.onOAIDGetError(oAIDException);
            }
        });
    }
}
