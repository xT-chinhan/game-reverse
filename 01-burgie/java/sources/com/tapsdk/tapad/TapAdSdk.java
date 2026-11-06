package com.tapsdk.tapad;

import android.content.Context;
import com.tapsdk.tapad.internal.AdnRuntimeBootstrap;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.oaid.OaidHelper;
import com.tapsdk.tapad.internal.observability.AdnTelemetryHost;
import com.tapsdk.tapad.internal.platform.AndroidLifecycleHost;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.PublisherSettingsBridge;
import com.tapsdk.tapad.internal.storage.SafeSP;
import com.tapsdk.tapad.internal.utils.AndroidUserAgent;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import com.tapsdk.tapad.log.TapADLogger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class TapAdSdk {
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean();

    private TapAdSdk() {
    }

    private static void configureLogging(TapAdConfig tapAdConfig) {
        TapADLogger.setLevel((tapAdConfig == null || !tapAdConfig.mIsDebug) ? TapADLogger.Level.INFO : TapADLogger.Level.DEBUG);
    }

    public static int getVersion() {
        return 50300001;
    }

    public static void init(Context context, final TapAdConfig tapAdConfig) {
        configureLogging(tapAdConfig);
        AtomicBoolean atomicBoolean = INITIALIZED;
        if (atomicBoolean.get() || tapAdConfig == null) {
            return;
        }
        String str = tapAdConfig.mMediaKey;
        if (str == null || str.length() < 64) {
            String str2 = tapAdConfig.mMediaKey;
            (str2 == null ? AbstractJsonLexerKt.NULL : Integer.valueOf(str2.length())).toString();
            return;
        }
        if (context == null || context.getApplicationContext() == null) {
            return;
        }
        boolean z = true;
        if (atomicBoolean.compareAndSet(false, true)) {
            final Context applicationContext = context.getApplicationContext();
            try {
                OaidHelper oaidHelper = OaidHelper.getInstance();
                TapAdCustomController tapAdCustomController = tapAdConfig.mCustomController;
                if (tapAdCustomController == null || !tapAdCustomController.isCanUsePhoneState()) {
                    z = false;
                }
                oaidHelper.setGaidCollectionAllowed(z);
                AppContextHolder.init(applicationContext);
                AndroidUserAgent.initialize(applicationContext);
                AdnRuntimeBootstrap.getInstance().prepare(applicationContext, tapAdConfig);
                if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.TapAdSdk$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TapAdSdk.initializeAndroidHost(applicationContext, tapAdConfig);
                    }
                })) {
                    return;
                }
                atomicBoolean.set(false);
            } catch (Throwable th) {
                INITIALIZED.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initializeAndroidHost(Context context, TapAdConfig tapAdConfig) {
        try {
            SafeSP.initialize(context);
        } catch (Throwable th) {
        }
        AdnTelemetryHost.initialize(context, tapAdConfig);
        try {
            TapAdManager.initializeHost(context, tapAdConfig);
        } catch (Throwable th2) {
        }
        try {
            AndroidLifecycleHost.getInstance().m194lambda$init$0$comtapsdktapadinternalplatformAndroidLifecycleHost(context);
        } catch (Throwable th3) {
        }
    }

    public static boolean isInitialized() {
        return INITIALIZED.get();
    }

    public static void preJump(MediaPreConversionHook mediaPreConversionHook) {
        DirichletRuntime.getInstance().setMediaPreConversionHook(mediaPreConversionHook);
    }

    public static void putMediaGlobalSettings(String str, String str2) {
        PublisherSettingsBridge.put(str, str2);
    }
}
