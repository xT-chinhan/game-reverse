package com.taptap.sdk.common.device.generator;

import android.content.Context;
import com.taptap.sdk.common.utils.AndroidIDUtils;
import com.umeng.analytics.pro.d;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidIdGenerator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/common/device/generator/AndroidIdGenerator;", "", d.R, "Landroid/content/Context;", "(Landroid/content/Context;)V", "generate", "", "isValidDeviceId", "", "deviceId", "processAndroidID", "androidId", "Companion", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AndroidIdGenerator {
    private static final int ANDROID_ID_LEN = 16;
    private static final String ANDROID_ID_REGEX = "^[0-9a-zA-Z]{8,16}$";
    private static final Set<String> EXCLUDES = SetsKt.setOf((Object[]) new String[]{"0000000000000000", "ffffffffffffffff"});
    private final Context context;

    public AndroidIdGenerator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final String generate() {
        String androidId = AndroidIDUtils.INSTANCE.getAndroidID(this.context);
        String deviceId = processAndroidID(androidId);
        if (isValidDeviceId(deviceId)) {
            return deviceId;
        }
        return null;
    }

    private final String processAndroidID(String androidId) {
        String processedId = androidId;
        if (processedId != null) {
            if (!new Regex(ANDROID_ID_REGEX).matches(processedId)) {
                return null;
            }
            int length = processedId.length();
            if (length < 16) {
                processedId = StringsKt.repeat("0", 16 - length) + processedId;
            }
            if (EXCLUDES.contains(processedId)) {
                return null;
            }
            return processedId;
        }
        return processedId;
    }

    private final boolean isValidDeviceId(String deviceId) {
        String str = deviceId;
        return !(str == null || str.length() == 0) && deviceId.length() <= 256;
    }
}
