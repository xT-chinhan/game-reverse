package com.tapsdk.tapad.internal.shortcut;

/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutPinOptions {
    public static final long DEFAULT_TIMEOUT_MILLIS = 45000;
    private final long timeoutMillis;

    public static final class Builder {
        private long timeoutMillis = ShortcutPinOptions.DEFAULT_TIMEOUT_MILLIS;

        public ShortcutPinOptions build() {
            return new ShortcutPinOptions(this);
        }

        public Builder setTimeoutMillis(long j) {
            this.timeoutMillis = j;
            return this;
        }
    }

    public long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public ShortcutPinOptions() {
        this(new Builder());
    }

    private ShortcutPinOptions(Builder builder) {
        if (builder.timeoutMillis >= 0) {
            this.timeoutMillis = builder.timeoutMillis;
            return;
        }
        throw new IllegalArgumentException("Shortcut pin timeout must not be negative.");
    }
}
