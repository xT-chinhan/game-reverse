package com.tapsdk.tapad.group;

import android.content.Context;
import com.tapsdk.tapad.group.ads.RewardCapsuleProcessBridge;
import com.tapsdk.tapad.group.config.MediationCompositionRoot;
import com.tapsdk.tapad.internal.AppContextHolder;
import com.tapsdk.tapad.internal.utils.AsyncExecutor;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class DirichletSdk {

    /* JADX INFO: renamed from: com.tapsdk.tapad.group.DirichletSdk$1, reason: invalid class name */
    public class AnonymousClass1 implements InitListener {
        final /* synthetic */ InitListener val$listener;

        public AnonymousClass1(InitListener initListener) {
            this.val$listener = initListener;
        }

        @Override // com.tapsdk.tapad.group.DirichletSdk.InitListener
        public void onInitFail(final int i, final String str) {
            final InitListener initListener = this.val$listener;
            AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.DirichletSdk$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    initListener.onInitFail(i, str);
                }
            });
        }

        @Override // com.tapsdk.tapad.group.DirichletSdk.InitListener
        public void onInitSuccess() {
            final InitListener initListener = this.val$listener;
            Objects.requireNonNull(initListener);
            AsyncExecutor.runOnMain(new Runnable() { // from class: com.tapsdk.tapad.group.DirichletSdk$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    initListener.onInitSuccess();
                }
            });
        }
    }

    public interface InitListener {
        void onInitFail(int i, String str);

        void onInitSuccess();
    }

    private DirichletSdk() {
    }

    public static int getVersion() {
        return 50300001;
    }

    public static String getVersionName() {
        return "5.3.0.1";
    }

    public static void init(Context context, final DirichletAdConfig dirichletAdConfig, InitListener initListener) {
        final InitListener initListenerOnMainThread = onMainThread(initListener);
        if (DirichletAdManager.get().checkArgs(context, dirichletAdConfig, initListenerOnMainThread)) {
            AppContextHolder.init(context);
            if (AppContextHolder.appContext == null) {
                if (initListenerOnMainThread != null) {
                    initListenerOnMainThread.onInitFail(-1, "请使用 application context 初始化");
                }
            } else {
                final Context context2 = AppContextHolder.appContext;
                RewardCapsuleProcessBridge.getInstance().init(context2);
                if (AsyncExecutor.tryExecuteIO(new Runnable() { // from class: com.tapsdk.tapad.group.DirichletSdk$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        DirichletSdk.lambda$init$0(context2, dirichletAdConfig, initListenerOnMainThread);
                    }
                }) || initListenerOnMainThread == null) {
                    return;
                }
                initListenerOnMainThread.onInitFail(-1, "SDK 初始化任务繁忙");
            }
        }
    }

    static /* synthetic */ void lambda$init$0(Context context, DirichletAdConfig dirichletAdConfig, InitListener initListener) {
        try {
            GUIDHelper.INSTANCE.init(context);
            MediationCompositionRoot.getInstance().init(context, dirichletAdConfig, initListener);
            long j = dirichletAdConfig.mMediaId;
        } catch (Throwable th) {
            if (initListener != null) {
                initListener.onInitFail(-1, "SDK 初始化失败");
            }
        }
    }

    private static InitListener onMainThread(InitListener initListener) {
        if (initListener == null) {
            return null;
        }
        return new AnonymousClass1(initListener);
    }

    public static void putMediaGlobalSettings(String str, String str2) {
        MediationCompositionRoot.getInstance().putMediaGlobalSettings(str, str2);
    }
}
