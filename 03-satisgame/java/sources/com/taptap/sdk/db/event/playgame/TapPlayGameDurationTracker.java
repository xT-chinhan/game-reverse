package com.taptap.sdk.db.event.playgame;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.taptap.sdk.db.event.TapPredefinedEvents;
import com.taptap.sdk.db.event.model.TapPlayGameDurationBean;
import com.taptap.sdk.db.event.utils.TapCoreKit;
import com.taptap.sdk.db.event.utils.TapEventLogger;
import com.taptap.sdk.db.event.utils.TapOpenlogHelper;
import com.taptap.sdk.kit.internal.TapLogger;
import com.taptap.sdk.kit.internal.utils.NetworkUtil;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks;
import com.taptap.sdk.kit.internal.utils.TapActivityLifecycleTracker;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: TapPlayGameDurationTracker.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007*\u0002\u0014\u001b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0003J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u00020!H\u0002J\u001c\u0010(\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010)\u001a\u00020*H\u0002J\u0006\u0010+\u001a\u00020!J\b\u0010,\u001a\u00020!H\u0003J\b\u0010-\u001a\u00020!H\u0003J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020*J\u0010\u00100\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/taptap/sdk/db/event/playgame/TapPlayGameDurationTracker;", "", "()V", "MESSAGE_CODE_START", "", "MESSAGE_CODE_STOP", "MESSAGE_CODE_TIMER", "MESSAGE_CODE_TRACK", "MESSAGE_DATA_ONLY_USER", "", "MESSAGE_DATA_TIME", "MESSAGE_DATA_USERID", "MESSAGE_TIME_INTERVAL", "", "TAG", "autoEventEnable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentUserId", "deviceStartTime", "handler", "com/taptap/sdk/db/event/playgame/TapPlayGameDurationTracker$handler$2$1", "getHandler", "()Lcom/taptap/sdk/db/event/playgame/TapPlayGameDurationTracker$handler$2$1;", "handler$delegate", "Lkotlin/Lazy;", "isInitialized", "lifecycleCallbacks", "com/taptap/sdk/db/event/playgame/TapPlayGameDurationTracker$lifecycleCallbacks$1", "Lcom/taptap/sdk/db/event/playgame/TapPlayGameDurationTracker$lifecycleCallbacks$1;", "playGameDurationStore", "Lcom/taptap/sdk/db/event/playgame/TapPlayGameDurationStore;", "userStartTime", "appendDurationToStore", "", TapPlayGameDurationTracker.MESSAGE_DATA_USERID, "handleAppOnBackground", "handleAppOnForeground", "handlerSendStartMessage", "handlerSendStopMessage", "handlerSendTimerMessage", "handlerSendTrackMessage", "onlyUser", "", "initializeIfNotInitialized", "sendDeviceDuration", "sendUserDuration", "setAutoEventEnable", "enable", "setUserId", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapPlayGameDurationTracker {
    private static final int MESSAGE_CODE_START = 18;
    private static final int MESSAGE_CODE_STOP = 19;
    private static final int MESSAGE_CODE_TIMER = 17;
    private static final int MESSAGE_CODE_TRACK = 20;
    private static final String MESSAGE_DATA_ONLY_USER = "only_user";
    private static final String MESSAGE_DATA_TIME = "time";
    private static final String MESSAGE_DATA_USERID = "userId";
    private static final long MESSAGE_TIME_INTERVAL = 3000;
    private static final String TAG = "TapEventPlayGameTracker";
    private static String currentUserId;
    private static TapPlayGameDurationStore playGameDurationStore;
    public static final TapPlayGameDurationTracker INSTANCE = new TapPlayGameDurationTracker();
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);
    private static final AtomicBoolean autoEventEnable = new AtomicBoolean(false);
    private static volatile long deviceStartTime = -1;
    private static volatile long userStartTime = -1;

    /* JADX INFO: renamed from: handler$delegate, reason: from kotlin metadata */
    private static final Lazy handler = LazyKt.lazy(new Function0<TapPlayGameDurationTracker$handler$2.AnonymousClass1>() { // from class: com.taptap.sdk.db.event.playgame.TapPlayGameDurationTracker$handler$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r1v1, types: [com.taptap.sdk.db.event.playgame.TapPlayGameDurationTracker$handler$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            HandlerThread handlerThread = new HandlerThread("TapEventPlayGameTask");
            handlerThread.start();
            return new Handler(handlerThread.getLooper()) { // from class: com.taptap.sdk.db.event.playgame.TapPlayGameDurationTracker$handler$2.1
                @Override // android.os.Handler
                public void handleMessage(Message msg) throws JSONException {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    super.handleMessage(msg);
                    switch (msg.what) {
                        case 17:
                            TapPlayGameDurationTracker.INSTANCE.appendDurationToStore(TapPlayGameDurationTracker.currentUserId);
                            sendEmptyMessageDelayed(17, 3000L);
                            break;
                        case 18:
                            if (TapPlayGameDurationTracker.deviceStartTime < 0) {
                                TapPlayGameDurationTracker tapPlayGameDurationTracker = TapPlayGameDurationTracker.INSTANCE;
                                TapPlayGameDurationTracker.deviceStartTime = msg.getData().getLong("time", -1L);
                            }
                            String str = TapPlayGameDurationTracker.currentUserId;
                            if (!(str == null || str.length() == 0) && TapPlayGameDurationTracker.userStartTime < 0) {
                                TapPlayGameDurationTracker tapPlayGameDurationTracker2 = TapPlayGameDurationTracker.INSTANCE;
                                TapPlayGameDurationTracker.userStartTime = msg.getData().getLong("time", -1L);
                                break;
                            }
                            break;
                        case 19:
                            TapPlayGameDurationTracker.INSTANCE.appendDurationToStore(TapPlayGameDurationTracker.currentUserId);
                            TapPlayGameDurationTracker.INSTANCE.sendDeviceDuration();
                            TapPlayGameDurationTracker.INSTANCE.sendUserDuration();
                            TapPlayGameDurationTracker tapPlayGameDurationTracker3 = TapPlayGameDurationTracker.INSTANCE;
                            TapPlayGameDurationTracker.deviceStartTime = -1L;
                            TapPlayGameDurationTracker tapPlayGameDurationTracker4 = TapPlayGameDurationTracker.INSTANCE;
                            TapPlayGameDurationTracker.userStartTime = -1L;
                            break;
                        case 20:
                            TapPlayGameDurationTracker.INSTANCE.appendDurationToStore(msg.getData().getString("userId", null));
                            TapPlayGameDurationTracker.INSTANCE.sendUserDuration();
                            if (!msg.getData().getBoolean("only_user", false)) {
                                TapPlayGameDurationTracker.INSTANCE.sendDeviceDuration();
                            }
                            break;
                    }
                }
            };
        }
    });
    private static final TapPlayGameDurationTracker$lifecycleCallbacks$1 lifecycleCallbacks = new TapActivityLifecycleCallbacks() { // from class: com.taptap.sdk.db.event.playgame.TapPlayGameDurationTracker$lifecycleCallbacks$1
        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityCreated(this, activity, bundle);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityDestroyed(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityPaused(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityResumed(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivitySaveInstanceState(this, activity, bundle);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityStarted(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            TapActivityLifecycleCallbacks.DefaultImpls.onActivityStopped(this, activity);
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks
        public void onForeground(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TapActivityLifecycleCallbacks.DefaultImpls.onForeground(this, context);
            TapOpenlogHelper.reportTechnicalLog$default(TapOpenlogHelper.INSTANCE, "event__foreground", null, 2, null);
            TapPlayGameDurationTracker.INSTANCE.handleAppOnForeground();
        }

        @Override // com.taptap.sdk.kit.internal.utils.TapActivityLifecycleCallbacks
        public void onBackground(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            TapActivityLifecycleCallbacks.DefaultImpls.onBackground(this, context);
            TapOpenlogHelper.reportTechnicalLog$default(TapOpenlogHelper.INSTANCE, "event__background", null, 2, null);
            TapPlayGameDurationTracker.INSTANCE.handleAppOnBackground();
        }
    };

    private TapPlayGameDurationTracker() {
    }

    public final void initializeIfNotInitialized() {
        if (isInitialized.compareAndSet(false, true)) {
            TapLogger.logd(TAG, "initialize start");
            playGameDurationStore = new TapPlayGameDurationStore();
            TapActivityLifecycleTracker.INSTANCE.registerActivityLifecycleCallbacks(lifecycleCallbacks);
            if (TapActivityLifecycleTracker.INSTANCE.isAppForeground()) {
                handlerSendStartMessage();
            }
            TapLogger.logd(TAG, "initialize end");
        }
    }

    public final void setUserId(String userId) {
        boolean z = true;
        if (!Intrinsics.areEqual(currentUserId, userId)) {
            handlerSendTrackMessage(userId, true);
        }
        currentUserId = userId;
        String str = userId;
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        userStartTime = System.currentTimeMillis();
    }

    public final void setAutoEventEnable(boolean enable) {
        autoEventEnable.set(enable);
        if (enable) {
            handlerSendTrackMessage$default(this, currentUserId, false, 2, null);
            handlerSendTimerMessage();
        } else {
            handlerSendStopMessage();
            getHandler().removeMessages(17);
        }
    }

    private final void handlerSendStartMessage() {
        Message messageObtainMessage = getHandler().obtainMessage();
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "handler.obtainMessage()");
        messageObtainMessage.what = 18;
        Bundle bundle = new Bundle();
        bundle.putLong(MESSAGE_DATA_TIME, System.currentTimeMillis());
        messageObtainMessage.setData(bundle);
        getHandler().sendMessage(messageObtainMessage);
    }

    private final void handlerSendStopMessage() {
        Message messageObtainMessage = getHandler().obtainMessage();
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "handler.obtainMessage()");
        messageObtainMessage.what = 19;
        Bundle bundle = new Bundle();
        bundle.putLong(MESSAGE_DATA_TIME, System.currentTimeMillis());
        messageObtainMessage.setData(bundle);
        getHandler().sendMessage(messageObtainMessage);
    }

    static /* synthetic */ void handlerSendTrackMessage$default(TapPlayGameDurationTracker tapPlayGameDurationTracker, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        tapPlayGameDurationTracker.handlerSendTrackMessage(str, z);
    }

    private final void handlerSendTrackMessage(String userId, boolean onlyUser) {
        Message messageObtainMessage = getHandler().obtainMessage();
        Intrinsics.checkNotNullExpressionValue(messageObtainMessage, "handler.obtainMessage()");
        messageObtainMessage.what = 20;
        Bundle bundle = new Bundle();
        bundle.putString(MESSAGE_DATA_USERID, userId);
        bundle.putBoolean(MESSAGE_DATA_ONLY_USER, onlyUser);
        messageObtainMessage.setData(bundle);
        getHandler().sendMessage(messageObtainMessage);
    }

    private final void handlerSendTimerMessage() {
        getHandler().removeMessages(17);
        getHandler().sendEmptyMessageDelayed(17, MESSAGE_TIME_INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAppOnForeground() {
        TapLogger.logd(TAG, "handleAppOnForeground");
        handlerSendStartMessage();
        handlerSendTimerMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAppOnBackground() {
        TapLogger.logd(TAG, "handleAppOnBackground");
        handlerSendStopMessage();
        getHandler().removeMessages(17);
    }

    private final TapPlayGameDurationTracker$handler$2.AnonymousClass1 getHandler() {
        return (TapPlayGameDurationTracker$handler$2.AnonymousClass1) handler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendDeviceDuration() throws JSONException {
        TapPlayGameDurationBean playGameDurationBean$tap_db_release;
        TapCoreKit.assertIsNotMainThread();
        if (NetworkUtil.isNetworkAvailable(TapEventLogger.INSTANCE.getApplicationContext$tap_db_release())) {
            TapPlayGameDurationStore tapPlayGameDurationStore = playGameDurationStore;
            TapPredefinedEvents.trackDevicePlayGame((tapPlayGameDurationStore == null || (playGameDurationBean$tap_db_release = tapPlayGameDurationStore.getPlayGameDurationBean$tap_db_release()) == null) ? 0L : playGameDurationBean$tap_db_release.getDeviceDuration());
            TapPlayGameDurationStore tapPlayGameDurationStore2 = playGameDurationStore;
            if (tapPlayGameDurationStore2 != null) {
                tapPlayGameDurationStore2.resetDeviceStore();
                return;
            }
            return;
        }
        TapPlayGameDurationStore tapPlayGameDurationStore3 = playGameDurationStore;
        if (tapPlayGameDurationStore3 != null) {
            tapPlayGameDurationStore3.syncStore(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendUserDuration() throws JSONException {
        TapPlayGameDurationBean playGameDurationBean$tap_db_release;
        TapCoreKit.assertIsNotMainThread();
        if (NetworkUtil.isNetworkAvailable(TapEventLogger.INSTANCE.getApplicationContext$tap_db_release())) {
            TapPlayGameDurationStore tapPlayGameDurationStore = playGameDurationStore;
            TapPredefinedEvents.trackUserPlayGame((tapPlayGameDurationStore == null || (playGameDurationBean$tap_db_release = tapPlayGameDurationStore.getPlayGameDurationBean$tap_db_release()) == null) ? null : playGameDurationBean$tap_db_release.getUserDuration());
            TapPlayGameDurationStore tapPlayGameDurationStore2 = playGameDurationStore;
            if (tapPlayGameDurationStore2 != null) {
                tapPlayGameDurationStore2.resetUserStore();
                return;
            }
            return;
        }
        TapPlayGameDurationStore tapPlayGameDurationStore3 = playGameDurationStore;
        if (tapPlayGameDurationStore3 != null) {
            tapPlayGameDurationStore3.syncStore(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void appendDurationToStore(String userId) {
        TapCoreKit.assertIsNotMainThread();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - deviceStartTime;
        if (deviceStartTime > 0 && j > 0) {
            deviceStartTime = jCurrentTimeMillis;
            TapPlayGameDurationStore tapPlayGameDurationStore = playGameDurationStore;
            if (tapPlayGameDurationStore != null) {
                tapPlayGameDurationStore.appendDeviceDuration(j);
            }
        }
        long j2 = jCurrentTimeMillis - userStartTime;
        String str = userId;
        if (!(str == null || str.length() == 0) && userStartTime > 0 && j2 > 0) {
            userStartTime = jCurrentTimeMillis;
            TapPlayGameDurationStore tapPlayGameDurationStore2 = playGameDurationStore;
            if (tapPlayGameDurationStore2 != null) {
                tapPlayGameDurationStore2.appendUserDuration(userId, j2);
            }
        }
        TapPlayGameDurationStore tapPlayGameDurationStore3 = playGameDurationStore;
        if (tapPlayGameDurationStore3 != null) {
            TapPlayGameDurationStore.syncStore$default(tapPlayGameDurationStore3, false, 1, null);
        }
    }
}
