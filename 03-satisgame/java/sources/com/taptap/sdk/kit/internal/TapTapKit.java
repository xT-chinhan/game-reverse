package com.taptap.sdk.kit.internal;

import android.content.Context;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: TapTapKit.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010$\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J\u0015\u0010&\u001a\u00020%2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/taptap/sdk/kit/internal/TapTapKit;", "", "()V", "TAG", "", "clientId", "getClientId$tap_kit_release", "()Ljava/lang/String;", "setClientId$tap_kit_release", "(Ljava/lang/String;)V", "clientToken", "getClientToken$tap_kit_release", "setClientToken$tap_kit_release", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isRND", "", "()Z", "setRND", "(Z)V", "regionType", "", "getRegionType$tap_kit_release", "()I", "setRegionType$tap_kit_release", "(I)V", "startInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "tapApplicationScope", "Lkotlinx/coroutines/CoroutineScope;", "getTapApplicationScope", "()Lkotlinx/coroutines/CoroutineScope;", "initializeClient", "", "startInitialize", "startInitialize$tap_kit_release", "tap-kit_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapKit {
    private static final String TAG = "TapTapKit";
    public static Context context;
    private static boolean isRND;
    private static int regionType;
    public static final TapTapKit INSTANCE = new TapTapKit();
    private static final AtomicBoolean startInitialized = new AtomicBoolean(false);
    private static String clientId = "";
    private static String clientToken = "";
    private static final CoroutineScope tapApplicationScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    private TapTapKit() {
    }

    public final String getClientId$tap_kit_release() {
        return clientId;
    }

    public final void setClientId$tap_kit_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clientId = str;
    }

    public final String getClientToken$tap_kit_release() {
        return clientToken;
    }

    public final void setClientToken$tap_kit_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        clientToken = str;
    }

    public final int getRegionType$tap_kit_release() {
        return regionType;
    }

    public final void setRegionType$tap_kit_release(int i) {
        regionType = i;
    }

    public final Context getContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        context = context2;
    }

    public final CoroutineScope getTapApplicationScope() {
        return tapApplicationScope;
    }

    public final boolean isRND() {
        return isRND;
    }

    public final void setRND(boolean z) {
        isRND = z;
    }

    public final synchronized void startInitialize$tap_kit_release(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        if (startInitialized.compareAndSet(false, true)) {
            TapLogger.logi(TAG, "startInitialize");
            TapTapKit tapTapKit = INSTANCE;
            Context applicationContext = context2.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            tapTapKit.setContext(applicationContext);
            TapActivityLifecycleTracker.INSTANCE.init(context2);
        }
    }

    public final void initializeClient(String clientId2, String clientToken2, int regionType2) {
        Intrinsics.checkNotNullParameter(clientId2, "clientId");
        Intrinsics.checkNotNullParameter(clientToken2, "clientToken");
        TapLogger.logi(TAG, "initializeClient");
        clientId = clientId2;
        clientToken = clientToken2;
        regionType = regionType2;
    }
}
