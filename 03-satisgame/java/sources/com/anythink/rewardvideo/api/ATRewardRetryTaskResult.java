package com.anythink.rewardvideo.api;

import java.io.Serializable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
public class ATRewardRetryTaskResult implements Serializable {
    private static final long serialVersionUID = 1;
    private int mConversionStatus;
    private ATRewardRetryTaskInfo mTaskInfo;

    public @interface ResultType {
        public static final int CLICK_WITHOUT_CONVERT = 1;
        public static final int CLICK_WITH_CONVERT = 2;
        public static final int CLICK_WITH_OUT_TIME = 3;
        public static final int UNKNOWN = 0;
    }

    public ATRewardRetryTaskResult() {
        this.mConversionStatus = 0;
    }

    public ATRewardRetryTaskResult(ATRewardRetryTaskInfo aTRewardRetryTaskInfo) {
        this.mConversionStatus = 0;
        this.mTaskInfo = aTRewardRetryTaskInfo;
    }

    public ATRewardRetryTaskResult(ATRewardRetryTaskInfo aTRewardRetryTaskInfo, int i) {
        this.mTaskInfo = aTRewardRetryTaskInfo;
        this.mConversionStatus = i;
    }

    public ATRewardRetryTaskInfo getTaskInfo() {
        return this.mTaskInfo;
    }

    public void setTaskInfo(ATRewardRetryTaskInfo aTRewardRetryTaskInfo) {
        this.mTaskInfo = aTRewardRetryTaskInfo;
    }

    public int getConversionStatus() {
        return this.mConversionStatus;
    }

    public void setConversionStatus(int i) {
        this.mConversionStatus = i;
    }

    public String toString() {
        return "ATRewardRetryTaskResult{taskInfo=" + this.mTaskInfo + ", conversionStatus=" + this.mConversionStatus + AbstractJsonLexerKt.END_OBJ;
    }
}
