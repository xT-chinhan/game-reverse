package com.kwad.sdk.liteapi;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.loader.DexLoadError;
import com.kwad.sdk.api.loader.KsLiteApi;
import com.kwad.sdk.api.util.ApiExecutorUtils;
import com.kwad.sdk.api.util.ApiSafeRunnable;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.kwad.sdk.liteapi.report.LiteApiReporter;

/* JADX INFO: loaded from: classes3.dex */
public class KsLiteApiImpl implements KsLiteApi {
    private static final String TAG = "KsLiteApiImpl";

    @Override // com.kwad.sdk.api.loader.KsLiteApi
    public void holdSdkConfig(SdkConfig sdkConfig) {
        if (sdkConfig != null) {
            InputParamHolder.holderSdkConfig(sdkConfig);
        }
    }

    @Override // com.kwad.sdk.api.loader.KsLiteApi
    public String getAESKey(Context context) {
        return LiteEncryptUtils.getKey(context, 0);
    }

    @Override // com.kwad.sdk.api.loader.KsLiteApi
    public void onInit(Context context) {
        LiteOAIDHelper.getAppOAID(context);
    }

    @Override // com.kwad.sdk.api.loader.KsLiteApi
    public void reportDexLoadError(final Context context, final DexLoadError dexLoadError) {
        LiteApiLogger.d(TAG, "reportDexLoadError dexLoadError: " + dexLoadError);
        if (dexLoadError != null) {
            ApiExecutorUtils.submit(new ApiSafeRunnable() { // from class: com.kwad.sdk.liteapi.KsLiteApiImpl.1
                @Override // com.kwad.sdk.api.util.ApiSafeRunnable
                public void doTask() {
                    LiteApiLogger.d(KsLiteApiImpl.TAG, "reportDexLoadError doTask: ");
                    LiteApiReporter.reportDexError(context, dexLoadError.getErrorMsg(), dexLoadError.getErrorCode());
                }
            });
        }
    }
}
