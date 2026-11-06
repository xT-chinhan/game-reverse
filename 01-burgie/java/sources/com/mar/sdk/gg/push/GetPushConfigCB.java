package com.mar.sdk.gg.push;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface GetPushConfigCB {
    void onFail();

    void onSuc(String str, Map<PushStyle, List<PushConfig>> map);
}
