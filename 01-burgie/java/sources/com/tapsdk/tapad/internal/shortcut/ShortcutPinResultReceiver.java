package com.tapsdk.tapad.internal.shortcut;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutPinResultReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ShortcutPinRegistry.onStandardCallback(context, intent);
    }
}
