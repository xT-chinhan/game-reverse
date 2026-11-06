package com.tapsdk.tapad.internal.shortcut;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutPinResult {
    private final String id;
    private final String message;
    private final ShortcutPinSource source;
    private final ShortcutPinStatus status;
    private final boolean verifiedPinned;

    public ShortcutPinResult(String str, ShortcutPinStatus shortcutPinStatus, ShortcutPinSource shortcutPinSource, boolean z, String str2) {
        this.id = (String) Objects.requireNonNull(str, "Shortcut id must not be null.");
        this.status = (ShortcutPinStatus) Objects.requireNonNull(shortcutPinStatus, "Shortcut pin status must not be null.");
        this.source = (ShortcutPinSource) Objects.requireNonNull(shortcutPinSource, "Shortcut pin source must not be null.");
        this.verifiedPinned = z;
        this.message = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public ShortcutPinSource getSource() {
        return this.source;
    }

    public ShortcutPinStatus getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        ShortcutPinStatus shortcutPinStatus = this.status;
        return shortcutPinStatus == ShortcutPinStatus.SUCCESS || shortcutPinStatus == ShortcutPinStatus.ALREADY_PINNED;
    }

    public boolean isVerifiedPinned() {
        return this.verifiedPinned;
    }
}
