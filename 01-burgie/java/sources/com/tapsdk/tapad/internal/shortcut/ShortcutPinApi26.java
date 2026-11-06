package com.tapsdk.tapad.internal.shortcut;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.PersistableBundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
final class ShortcutPinApi26 {
    private ShortcutPinApi26() {
    }

    private static Context getIconContext(Context context, String str) {
        return (TextUtils.isEmpty(str) || str.equals(context.getPackageName())) ? context : context.createPackageContext(str, 0);
    }

    public static boolean isPinned(Context context, String str) {
        try {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            if (shortcutManager == null) {
                return false;
            }
            Iterator<ShortcutInfo> it = shortcutManager.getPinnedShortcuts().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getId())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isRequestPinShortcutSupported(Context context) {
        try {
            ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
            return shortcutManager != null && shortcutManager.isRequestPinShortcutSupported();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean requestPinShortcut(Context context, ShortcutPinRequest shortcutPinRequest, IntentSender intentSender) {
        ShortcutManager shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class);
        if (shortcutManager == null) {
            return false;
        }
        return shortcutManager.requestPinShortcut(toShortcutInfo(context, shortcutPinRequest), intentSender);
    }

    private static Icon toIcon(Context context, ShortcutPinIcon shortcutPinIcon) {
        if (shortcutPinIcon instanceof ShortcutPinIcon.BitmapIcon) {
            return Icon.createWithBitmap(((ShortcutPinIcon.BitmapIcon) shortcutPinIcon).getBitmap());
        }
        if (!(shortcutPinIcon instanceof ShortcutPinIcon.ResourceIcon)) {
            throw new IllegalArgumentException("Unsupported shortcut icon type.");
        }
        ShortcutPinIcon.ResourceIcon resourceIcon = (ShortcutPinIcon.ResourceIcon) shortcutPinIcon;
        return Icon.createWithResource(getIconContext(context, resourceIcon.getPackageName()), resourceIcon.getResourceId());
    }

    private static ShortcutInfo toShortcutInfo(Context context, ShortcutPinRequest shortcutPinRequest) {
        ShortcutInfo.Builder icon = new ShortcutInfo.Builder(context, shortcutPinRequest.getId()).setShortLabel(shortcutPinRequest.getShortLabel()).setIntent(new Intent(shortcutPinRequest.getLaunchIntent())).setIcon(toIcon(context, shortcutPinRequest.getIcon()));
        if (!TextUtils.isEmpty(shortcutPinRequest.getLongLabel())) {
            icon.setLongLabel(shortcutPinRequest.getLongLabel());
        }
        if (!TextUtils.isEmpty(shortcutPinRequest.getDisabledMessage())) {
            icon.setDisabledMessage(shortcutPinRequest.getDisabledMessage());
        }
        if (shortcutPinRequest.getActivity() != null) {
            icon.setActivity(shortcutPinRequest.getActivity());
        }
        Set<String> categories = shortcutPinRequest.getCategories();
        if (categories != null && !categories.isEmpty()) {
            icon.setCategories(categories);
        }
        PersistableBundle extras = shortcutPinRequest.getExtras();
        if (extras != null) {
            icon.setExtras(extras);
        }
        return icon.build();
    }
}
