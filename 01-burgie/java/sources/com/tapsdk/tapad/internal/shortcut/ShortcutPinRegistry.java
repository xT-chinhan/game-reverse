package com.tapsdk.tapad.internal.shortcut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
final class ShortcutPinRegistry {
    static final String ACTION_STANDARD_RESULT = "com.tapsdk.tapad.internal.shortcut.action.STANDARD_RESULT";
    static final String EXTRA_SHORTCUT_ID = "com.tapsdk.tapad.internal.shortcut.extra.SHORTCUT_ID";
    static final String EXTRA_TOKEN = "com.tapsdk.tapad.internal.shortcut.extra.TOKEN";
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static final ConcurrentHashMap<String, PendingRequest> PENDING = new ConcurrentHashMap<>();
    private static final String RESULT_URI_AUTHORITY = "result";
    private static final String RESULT_URI_SCHEME = "tapad-shortcut-pin";

    public static final class PendingRequest {
        private ShortcutPinCallback callback;
        private final Context context;
        private BroadcastReceiver resultReceiver;
        private boolean resultReceiverRegistered;
        private final String shortcutId;
        private Runnable timeoutRunnable;

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            if (this.timeoutRunnable != null) {
                ShortcutPinRegistry.MAIN_HANDLER.removeCallbacks(this.timeoutRunnable);
                this.timeoutRunnable = null;
            }
            unregisterResultReceiver();
            this.callback = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ShortcutPinCallback consumeCallback() {
            ShortcutPinCallback shortcutPinCallback = this.callback;
            clear();
            return shortcutPinCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void registerResultReceiver(String str) {
            this.resultReceiver = new ShortcutPinResultReceiver();
            IntentFilter intentFilter = new IntentFilter(ShortcutPinRegistry.ACTION_STANDARD_RESULT);
            intentFilter.addDataScheme(ShortcutPinRegistry.RESULT_URI_SCHEME);
            intentFilter.addDataAuthority(ShortcutPinRegistry.RESULT_URI_AUTHORITY, null);
            intentFilter.addDataPath("/" + str, 0);
            if (Build.VERSION.SDK_INT >= 33) {
                this.context.registerReceiver(this.resultReceiver, intentFilter, 4);
            } else {
                this.context.registerReceiver(this.resultReceiver, intentFilter);
            }
            this.resultReceiverRegistered = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutRunnable(Runnable runnable) {
            this.timeoutRunnable = runnable;
        }

        private void unregisterResultReceiver() {
            BroadcastReceiver broadcastReceiver;
            if (!this.resultReceiverRegistered || (broadcastReceiver = this.resultReceiver) == null) {
                return;
            }
            try {
                this.context.unregisterReceiver(broadcastReceiver);
            } catch (Throwable th) {
            }
            this.resultReceiverRegistered = false;
            this.resultReceiver = null;
        }

        private PendingRequest(Context context, String str, ShortcutPinCallback shortcutPinCallback) {
            this.context = context;
            this.shortcutId = str;
            this.callback = shortcutPinCallback;
        }
    }

    private ShortcutPinRegistry() {
    }

    public static void cancel(String str) {
        PendingRequest pendingRequestRemove = PENDING.remove(str);
        if (pendingRequestRemove != null) {
            pendingRequestRemove.clear();
        }
    }

    public static void complete(String str, ShortcutPinResult shortcutPinResult) {
        ShortcutPinCallback shortcutPinCallbackConsumeCallback;
        PendingRequest pendingRequestRemove = PENDING.remove(str);
        if (pendingRequestRemove == null || (shortcutPinCallbackConsumeCallback = pendingRequestRemove.consumeCallback()) == null) {
            return;
        }
        dispatch(shortcutPinCallbackConsumeCallback, shortcutPinResult);
    }

    public static Uri createResultUri(String str) {
        return Uri.parse("tapad-shortcut-pin://result/" + str);
    }

    public static void dispatch(final ShortcutPinCallback shortcutPinCallback, final ShortcutPinResult shortcutPinResult) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            shortcutPinCallback.onResult(shortcutPinResult);
        } else {
            MAIN_HANDLER.post(new Runnable() { // from class: com.tapsdk.tapad.internal.shortcut.ShortcutPinRegistry.2
                @Override // java.lang.Runnable
                public void run() {
                    shortcutPinCallback.onResult(shortcutPinResult);
                }
            });
        }
    }

    public static void onStandardCallback(Context context, Intent intent) {
        String stringExtra;
        if (intent == null || !ACTION_STANDARD_RESULT.equals(intent.getAction()) || (stringExtra = intent.getStringExtra(EXTRA_TOKEN)) == null) {
            return;
        }
        PendingRequest pendingRequest = PENDING.get(stringExtra);
        String stringExtra2 = intent.getStringExtra(EXTRA_SHORTCUT_ID);
        if (stringExtra2 == null && pendingRequest != null) {
            stringExtra2 = pendingRequest.shortcutId;
        }
        String str = stringExtra2;
        if (str == null) {
            return;
        }
        boolean zIsPinnedShortcut = ShortcutPinManager.isPinnedShortcut(context.getApplicationContext(), str);
        complete(stringExtra, new ShortcutPinResult(str, ShortcutPinStatus.SUCCESS, ShortcutPinSource.STANDARD_CALLBACK, zIsPinnedShortcut, zIsPinnedShortcut ? "Launcher accepted the pin request and pinned shortcuts confirms it." : "Launcher accepted the pin request. Pinned shortcuts did not confirm it yet."));
    }

    public static void register(Context context, final String str, final String str2, ShortcutPinCallback shortcutPinCallback, ShortcutPinOptions shortcutPinOptions) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        final PendingRequest pendingRequest = new PendingRequest(context, str2, shortcutPinCallback);
        pendingRequest.registerResultReceiver(str);
        Runnable runnable = new Runnable() { // from class: com.tapsdk.tapad.internal.shortcut.ShortcutPinRegistry.1
            @Override // java.lang.Runnable
            public void run() {
                PendingRequest pendingRequest2 = (PendingRequest) ShortcutPinRegistry.PENDING.get(str);
                PendingRequest pendingRequest3 = pendingRequest;
                if (pendingRequest2 != pendingRequest3) {
                    return;
                }
                boolean zIsPinnedShortcut = ShortcutPinManager.isPinnedShortcut(pendingRequest3.context, str2);
                ShortcutPinRegistry.complete(str, new ShortcutPinResult(str2, zIsPinnedShortcut ? ShortcutPinStatus.SUCCESS : ShortcutPinStatus.CANCELLED_OR_TIMEOUT, zIsPinnedShortcut ? ShortcutPinSource.PINNED_SHORTCUTS_QUERY : ShortcutPinSource.TIMEOUT, zIsPinnedShortcut, zIsPinnedShortcut ? "Shortcut was found in pinned shortcuts after timeout." : "No launcher callback was received before timeout."));
            }
        };
        pendingRequest.setTimeoutRunnable(runnable);
        PENDING.put(str, pendingRequest);
        MAIN_HANDLER.postDelayed(runnable, shortcutPinOptions.getTimeoutMillis());
    }
}
