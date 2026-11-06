package com.taptap.sdk.compilance.internal;

import android.text.TextUtils;
import com.taptap.sdk.compilance.constants.BundleKey;
import com.taptap.sdk.okio.ByteString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: TapComplianceSettings.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"getSPNameByUserId", "", "userId", "tap-compliance_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceSettingsKt {
    public static /* synthetic */ String getSPNameByUserId$default(String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = TapComplianceInternal.INSTANCE.getUserId();
        }
        return getSPNameByUserId(str);
    }

    public static final String getSPNameByUserId(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(userId)) {
            sb.append(ByteString.encodeString(userId, Charsets.UTF_8).md5()).append("_");
        }
        String string = sb.append(BundleKey.TIMING_FILE_SUFFIX).toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.append(TIMING_FILE_SUFFIX).toString()");
        return string;
    }
}
