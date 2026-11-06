package com.kwad.sdk.api.model;

import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: classes3.dex */
@KsAdSdkApi
public class KSAdRewardRetryTaskResult {
    public int conversionStatus;
    public KSAdInfoData ksAdInfoData;

    public @interface ResultType {
        public static final int CLICK_WITHOUT_CONVERT = 1;
        public static final int CLICK_WITH_CONVERT = 2;
        public static final int CLICK_WITH_OUT_TIME = 3;
        public static final int UNKNOWN = 0;
    }

    public KSAdRewardRetryTaskResult(KSAdInfoData kSAdInfoData) {
        this.conversionStatus = 0;
        this.ksAdInfoData = kSAdInfoData;
    }

    public KSAdRewardRetryTaskResult(KSAdInfoData kSAdInfoData, int i) {
        this.ksAdInfoData = kSAdInfoData;
        this.conversionStatus = i;
    }
}
