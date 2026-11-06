package com.byazt.vkw;

import android.content.Context;
import android.os.Looper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface n {
    com.byazt.ihe.pr hn();

    com.byazt.ihe.vk hw();

    com.byazt.ihe.fw pr(Context context, String str);

    com.byazt.ihe.fw pr(Context context, boolean z, long j, JSONObject jSONObject, Looper looper);

    void pr(Context context, String str, int i, String[] strArr, long[] jArr, boolean z);

    void pr(boolean z);

    boolean pr();

    int x();
}
