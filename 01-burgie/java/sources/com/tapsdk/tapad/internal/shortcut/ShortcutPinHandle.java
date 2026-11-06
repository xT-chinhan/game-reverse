package com.tapsdk.tapad.internal.shortcut;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutPinHandle {
    private final CancelAction cancelAction;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);
    private final String token;

    public interface CancelAction {
        void cancel(String str);
    }

    public ShortcutPinHandle(String str, CancelAction cancelAction) {
        this.token = (String) Objects.requireNonNull(str, "Shortcut pin token must not be null.");
        this.cancelAction = (CancelAction) Objects.requireNonNull(cancelAction, "Shortcut pin cancel action must not be null.");
    }

    public void cancel() {
        if (this.cancelled.compareAndSet(false, true)) {
            this.cancelAction.cancel(this.token);
        }
    }

    public String getToken() {
        return this.token;
    }

    public boolean isCancelled() {
        return this.cancelled.get();
    }
}
