package com.umeng.commonsdk.deeplink;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface InstallParamsCallback {
    void onFailure(int i, String str);

    void onSuccess(Map<String, Object> map);
}
