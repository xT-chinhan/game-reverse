package com.smartdigimkt.sdk.api.format;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SDMAdDeepRewardResultListener {
    void onError(int i, String str);

    void onSuccess(List<SDMAdDeepRewardResult> list);
}
