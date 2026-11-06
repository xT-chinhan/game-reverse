package com.taptap.sdk.update.utils;

import android.os.SystemClock;
import kotlin.Metadata;

/* JADX INFO: compiled from: UIUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/update/utils/UIUtil;", "", "()V", "MIN_CLICK_INTERVAL", "", "lastClickTime", "", "isFastClick", "", "tap-update_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UIUtil {
    private static final int MIN_CLICK_INTERVAL = 200;
    public static final UIUtil INSTANCE = new UIUtil();
    private static long lastClickTime = -1;

    private UIUtil() {
    }

    public final boolean isFastClick() {
        long currentTime = SystemClock.elapsedRealtime();
        long j = lastClickTime;
        if (j != -1 && currentTime - j < 200) {
            return true;
        }
        lastClickTime = currentTime;
        return false;
    }
}
