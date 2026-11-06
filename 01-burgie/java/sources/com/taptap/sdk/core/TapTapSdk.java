package com.taptap.sdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taptap.sdk.core.utils.OptionsAdapter;
import com.taptap.sdk.initializer.TapTapSdkInitializer;
import com.taptap.sdk.initializer.api.TapInitCallback;
import com.taptap.sdk.initializer.api.TapInitState;
import com.taptap.sdk.initializer.api.model.Language;
import com.taptap.sdk.initializer.api.model.RegionType;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.extensions.SysExtKt;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.taptap.sdk.kit.internal.utils.localize.TapLocalizeUtil;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapTapSdk.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J-\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0007¢\u0006\u0002\u0010\u0017J1\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0015\"\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0007¨\u0006\u001e"}, d2 = {"Lcom/taptap/sdk/core/TapTapSdk;", "", "()V", "addInitCallback", "", "callback", "Lcom/taptap/sdk/initializer/api/TapInitCallback;", "failSyncInit", d.aw, "", MediationConstant.KEY_ERROR_CODE, "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", TrackAction.INIT, d.R, "Landroid/content/Context;", "sdkOptions", "Lcom/taptap/sdk/core/TapTapSdkOptions;", "options", "", "", "(Landroid/content/Context;Lcom/taptap/sdk/core/TapTapSdkOptions;[Ljava/lang/String;)V", "Lcom/taptap/sdk/core/TapTapSdkBaseOptions;", "(Landroid/content/Context;Lcom/taptap/sdk/core/TapTapSdkOptions;[Lcom/taptap/sdk/core/TapTapSdkBaseOptions;)V", "removeInitCallback", "setPreferredLanguage", "language", "Lcom/taptap/sdk/core/TapTapLanguage;", "tap-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapTapSdk {
    public static final TapTapSdk INSTANCE = new TapTapSdk();

    private TapTapSdk() {
    }

    @JvmStatic
    public static final void init(Context context, TapTapSdkOptions sdkOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkOptions, "sdkOptions");
        init(context, sdkOptions, new TapTapSdkBaseOptions[0]);
    }

    @JvmStatic
    public static final void init(Context context, TapTapSdkOptions sdkOptions, TapTapSdkBaseOptions... options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkOptions, "sdkOptions");
        Intrinsics.checkNotNullParameter(options, "options");
        Collection destination$iv$iv = new ArrayList(options.length);
        for (TapTapSdkBaseOptions tapTapSdkBaseOptions : options) {
            destination$iv$iv.add(tapTapSdkBaseOptions.toString());
        }
        Collection thisCollection$iv = (List) destination$iv$iv;
        init(context, sdkOptions, (String[]) thisCollection$iv.toArray(new String[0]));
    }

    @JvmStatic
    public static final synchronized void init(Context context, TapTapSdkOptions sdkOptions, String[] options) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkOptions, "sdkOptions");
        Intrinsics.checkNotNullParameter(options, "options");
        long session = TapTapSdkInitializer.INSTANCE.beginSession();
        try {
            TapTapSdkInitializer instance = OptionsAdapter.INSTANCE.adapt(new TapTapSdkInitializer.Builder(context).setClientId(sdkOptions.getClientId()).setClientToken(sdkOptions.getClientToken()).setRegion(RegionType.INSTANCE.from(sdkOptions.getRegion())).setGameVersion(sdkOptions.getGameVersion()).enableLog(sdkOptions.getEnableLog()).setLanguage(Language.INSTANCE.from(sdkOptions.getPreferredLanguage().getLanguage())).setScreenOrientation(sdkOptions.getScreenOrientation()), ArraysKt.toList(options)).build();
            try {
                TapTapSdkInitializer.INSTANCE.attach(instance);
                instance.initialize(session);
            } catch (CancellationException e) {
                instance.cancel();
                INSTANCE.failSyncInit(session, 1003, e);
                throw e;
            } catch (Exception e2) {
                instance.cancel();
                INSTANCE.failSyncInit(session, 1003, e2);
            }
        } catch (CancellationException e3) {
            INSTANCE.failSyncInit(session, 1003, e3);
            throw e3;
        } catch (Exception e4) {
            INSTANCE.failSyncInit(session, 1000, e4);
        }
    }

    private final void failSyncInit(long session, int errorCode, Exception e) {
        SysExtKt.showToast(e.getMessage());
        TapTapSdkInitializer.Companion companion = TapTapSdkInitializer.INSTANCE;
        String message = e.getMessage();
        if (message == null) {
            message = "unknown error";
        }
        companion.updateInitState(new TapInitState.Failed(errorCode, message), session);
        TapLogger.loge$default(null, null, e, 3, null);
    }

    @JvmStatic
    public static final void setPreferredLanguage(TapTapLanguage language) {
        Intrinsics.checkNotNullParameter(language, "language");
        TapLocalizeUtil.INSTANCE.setPreferredLanguage(language.getLanguage());
    }

    @JvmStatic
    public static final void addInitCallback(TapInitCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapTapSdkInitializer.INSTANCE.addInitCallback(callback);
    }

    @JvmStatic
    public static final void removeInitCallback(TapInitCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        TapTapSdkInitializer.INSTANCE.removeInitCallback(callback);
    }
}
