package com.anythink.rewardvideo.api;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ATRewardRetryTaskContract {

    public interface AdRewardRetryTaskListener {
        void onAdRewardRetryTaskNotify(ATRewardRetryTaskInfo aTRewardRetryTaskInfo);
    }

    public interface RetryRewardConvertResultListener {
        void onError(int i, String str);

        void onSuccess();
    }

    public interface RetryRewardResultListener {
        void onError(int i, String str);

        void onSuccess(List<ATRewardRetryTaskResult> list);
    }

    void rewardAdRetryTaskUpdate(ATRewardRetryTaskInfo aTRewardRetryTaskInfo, RetryRewardConvertResultListener retryRewardConvertResultListener);

    void setRetryRewardResultListener(List<ATRewardRetryTaskInfo> list, RetryRewardResultListener retryRewardResultListener);
}
