package com.taptap.sdk.common.utils;

import android.content.Context;
import android.provider.Settings;
import com.taptap.sdk.db.constant.Common;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidIDUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/taptap/sdk/common/utils/AndroidIDUtils;", "", "()V", "androidId", "", "getAndroidID", d.R, "Landroid/content/Context;", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AndroidIDUtils {
    public static final AndroidIDUtils INSTANCE = new AndroidIDUtils();
    private static volatile String androidId;

    private AndroidIDUtils() {
    }

    public final String getAndroidID(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (androidId != null) {
            return androidId;
        }
        try {
            androidId = Settings.Secure.getString(context.getContentResolver(), Common.Predefined.SUB_ANDROID_ID);
        } catch (Throwable th) {
        }
        return androidId;
    }
}
