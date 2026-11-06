package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.downloadnew.d;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadBridgeFactory {
    public static Function<SparseArray<Object>, Object> getDownloadBridge(Context context) {
        return d.ms(context);
    }
}
