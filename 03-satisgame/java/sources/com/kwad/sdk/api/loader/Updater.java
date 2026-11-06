package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.SDKApiHolder;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.util.ApiExecutorUtils;
import com.kwad.sdk.api.util.ApiSafeRunnable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class Updater {
    private static final String CONFIG_URL = "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
    private static final AtomicBoolean mHasRequest = new AtomicBoolean();

    public static void checkAndUpdate(final Context context, final IKsAdSDK iKsAdSDK) {
        if (SDKApiHolder.disableDynamic()) {
            return;
        }
        AtomicBoolean atomicBoolean = mHasRequest;
        if (atomicBoolean.get() || context == null || iKsAdSDK == null) {
            return;
        }
        atomicBoolean.set(true);
        ApiExecutorUtils.submit(new ApiSafeRunnable() { // from class: com.kwad.sdk.api.loader.Updater.1
            @Override // com.kwad.sdk.api.util.ApiSafeRunnable
            public void doTask() {
                try {
                    if (Math.abs(System.currentTimeMillis() - ApiSpUtils.getLong(context, ApiSpUtils.SP_LASTUPDATE_TIME)) < ApiSpUtils.getLong(context, ApiSpUtils.SP_INTERVAL) * 1000) {
                        return;
                    }
                    ApiLogger.d(DynamicMonitor.TAG, "start checkAndUpdate");
                    ProducerFactory.newUpdateProducer().produceResults(new UpdaterProvider() { // from class: com.kwad.sdk.api.loader.Updater.1.1
                        @Override // com.kwad.sdk.api.loader.UpdaterProvider
                        public Context getContext() {
                            return context;
                        }

                        @Override // com.kwad.sdk.api.loader.UpdaterProvider
                        public String getUpdateUrl() {
                            return Updater.getConfigUrl();
                        }

                        @Override // com.kwad.sdk.api.loader.UpdaterProvider
                        public IKsAdSDK getKSSDK() {
                            return iKsAdSDK;
                        }
                    }, new ProducerFactory.Consumer<Boolean>() { // from class: com.kwad.sdk.api.loader.Updater.1.2
                        @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                        public void onNewResult(Boolean bool) {
                            ApiLogger.d(DynamicMonitor.TAG, "onNewResult: " + bool);
                        }

                        @Override // com.kwad.sdk.api.loader.ProducerFactory.Consumer
                        public void onFailure(Throwable th) {
                            ApiLogger.d(DynamicMonitor.TAG, "onFailure", th);
                        }
                    });
                } catch (Throwable th) {
                    ApiLogger.d(DynamicMonitor.TAG, "onFailure", th);
                }
            }
        });
    }

    public static void revertDynamic(Context context) {
        DVersionUtils.setCurrentDynamicVersion(context, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getConfigUrl() {
        String updateUrl = SDKApiHolder.getUpdateUrl(CONFIG_URL);
        return !TextUtils.isEmpty(updateUrl) ? updateUrl : CONFIG_URL;
    }
}
