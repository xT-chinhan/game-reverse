package com.smartdigimkt.sdk.api.format;

/* JADX INFO: loaded from: classes3.dex */
public final class SDMAdDeepRewardResult {
    public static final String KEY_TASK_TYPE = "task_type";
    public static final int TASK_TYPE_DEEP = 1;
    private final int taskType;

    public SDMAdDeepRewardResult(int i) {
        this.taskType = i;
    }

    public int getTaskType() {
        return this.taskType;
    }
}
