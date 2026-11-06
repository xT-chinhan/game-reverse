package com.taptap.sdk.kit.internal;

import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapSdkFileLogger.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/taptap/sdk/kit/internal/TapSdkFileLogger;", "", "()V", "currentDate", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "timeFormat", "writer", "Ljava/io/BufferedWriter;", "writeLog", "", "logLevel", "", "codeLocation", "tag", "message", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapSdkFileLogger {
    private static String currentDate;
    private static BufferedWriter writer;
    public static final TapSdkFileLogger INSTANCE = new TapSdkFileLogger();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);

    private TapSdkFileLogger() {
    }

    public final synchronized void writeLog(int logLevel, String codeLocation, String tag, String message) {
        Intrinsics.checkNotNullParameter(codeLocation, "codeLocation");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
