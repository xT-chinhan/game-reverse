package com.tapsdk.tapad.internal.shortcut;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutPinManager {
    private ShortcutPinManager() {
    }

    private static Context applicationContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static String errorMessage(Throwable th) {
        String message = th.getMessage();
        return !TextUtils.isEmpty(message) ? message : th.getClass().getSimpleName();
    }

    public static boolean isPinnedShortcut(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return ShortcutPinApi26.isPinned(applicationContext(context), str);
    }

    public static boolean isRequestPinShortcutSupported(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return ShortcutPinApi26.isRequestPinShortcutSupported(applicationContext(context));
    }

    public static ShortcutPinHandle requestPinShortcut(Context context, ShortcutPinRequest shortcutPinRequest, ShortcutPinCallback shortcutPinCallback) {
        return requestPinShortcut(context, shortcutPinRequest, shortcutPinCallback, new ShortcutPinOptions());
    }

    private static void validate(Context context, ShortcutPinRequest shortcutPinRequest, ShortcutPinCallback shortcutPinCallback, ShortcutPinOptions shortcutPinOptions) {
        Objects.requireNonNull(context, "Context must not be null.");
        Objects.requireNonNull(shortcutPinRequest, "Shortcut pin request must not be null.");
        Objects.requireNonNull(shortcutPinCallback, "Shortcut pin callback must not be null.");
        Objects.requireNonNull(shortcutPinOptions, "Shortcut pin options must not be null.");
        shortcutPinRequest.validate();
    }

    public static ShortcutPinHandle requestPinShortcut(Context context, ShortcutPinRequest shortcutPinRequest, ShortcutPinCallback shortcutPinCallback, ShortcutPinOptions shortcutPinOptions) {
        validate(context, shortcutPinRequest, shortcutPinCallback, shortcutPinOptions);
        Context contextApplicationContext = applicationContext(context);
        String string = UUID.randomUUID().toString();
        ShortcutPinHandle shortcutPinHandle = new ShortcutPinHandle(string, new ShortcutPinHandle.CancelAction() { // from class: com.tapsdk.tapad.internal.shortcut.ShortcutPinManager.1
            @Override // com.tapsdk.tapad.internal.shortcut.ShortcutPinHandle.CancelAction
            public void cancel(String str) {
                ShortcutPinRegistry.cancel(str);
            }
        });
        if (Build.VERSION.SDK_INT < 26) {
            ShortcutPinRegistry.dispatch(shortcutPinCallback, new ShortcutPinResult(shortcutPinRequest.getId(), ShortcutPinStatus.REQUEST_NOT_SUPPORTED, ShortcutPinSource.LOCAL_VALIDATION, false, "Shortcut pinning requires Android 8.0 (API 26) or later."));
            return shortcutPinHandle;
        }
        if (ShortcutPinApi26.isPinned(contextApplicationContext, shortcutPinRequest.getId())) {
            ShortcutPinRegistry.dispatch(shortcutPinCallback, new ShortcutPinResult(shortcutPinRequest.getId(), ShortcutPinStatus.ALREADY_PINNED, ShortcutPinSource.PINNED_SHORTCUTS_QUERY, true, "Shortcut is already pinned."));
            return shortcutPinHandle;
        }
        if (!ShortcutPinApi26.isRequestPinShortcutSupported(contextApplicationContext)) {
            ShortcutPinRegistry.dispatch(shortcutPinCallback, new ShortcutPinResult(shortcutPinRequest.getId(), ShortcutPinStatus.REQUEST_NOT_SUPPORTED, ShortcutPinSource.LOCAL_VALIDATION, false, "Default launcher does not support requestPinShortcut()."));
            return shortcutPinHandle;
        }
        boolean z = false;
        try {
            PendingIntent broadcast = PendingIntent.getBroadcast(contextApplicationContext, string.hashCode(), new Intent("com.tapsdk.tapad.internal.shortcut.action.STANDARD_RESULT").setPackage(contextApplicationContext.getPackageName()).setData(ShortcutPinRegistry.createResultUri(string)).putExtra("com.tapsdk.tapad.internal.shortcut.extra.TOKEN", string).putExtra("com.tapsdk.tapad.internal.shortcut.extra.SHORTCUT_ID", shortcutPinRequest.getId()), 201326592);
            ShortcutPinRegistry.register(contextApplicationContext, string, shortcutPinRequest.getId(), shortcutPinCallback, shortcutPinOptions);
            z = true;
            if (!ShortcutPinApi26.requestPinShortcut(contextApplicationContext, shortcutPinRequest, broadcast.getIntentSender())) {
                ShortcutPinRegistry.complete(string, new ShortcutPinResult(shortcutPinRequest.getId(), ShortcutPinStatus.REQUEST_REJECTED, ShortcutPinSource.LOCAL_VALIDATION, false, "ShortcutManager.requestPinShortcut() returned false."));
                return shortcutPinHandle;
            }
        } catch (Throwable th) {
            ShortcutPinResult shortcutPinResult = new ShortcutPinResult(shortcutPinRequest.getId(), ShortcutPinStatus.ERROR, ShortcutPinSource.EXCEPTION, false, errorMessage(th));
            if (z) {
                ShortcutPinRegistry.complete(string, shortcutPinResult);
            } else {
                ShortcutPinRegistry.dispatch(shortcutPinCallback, shortcutPinResult);
            }
        }
        return shortcutPinHandle;
    }
}
