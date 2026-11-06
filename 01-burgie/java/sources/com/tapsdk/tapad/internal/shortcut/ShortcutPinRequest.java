package com.tapsdk.tapad.internal.shortcut;

import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class ShortcutPinRequest {
    private final ComponentName activity;
    private final Set<String> categories;
    private final CharSequence disabledMessage;
    private final PersistableBundle extras;
    private final ShortcutPinIcon icon;
    private final String id;
    private final Intent launchIntent;
    private final CharSequence longLabel;
    private final CharSequence shortLabel;

    public static final class Builder {
        private ComponentName activity;
        private Set<String> categories;
        private CharSequence disabledMessage;
        private PersistableBundle extras;
        private final ShortcutPinIcon icon;
        private final String id;
        private final Intent launchIntent;
        private CharSequence longLabel;
        private final CharSequence shortLabel;

        public Builder(String str, CharSequence charSequence, Intent intent, ShortcutPinIcon shortcutPinIcon) {
            this.id = (String) Objects.requireNonNull(str, "Shortcut id must not be null.");
            this.shortLabel = (CharSequence) Objects.requireNonNull(charSequence, "Shortcut short label must not be null.");
            this.launchIntent = (Intent) Objects.requireNonNull(intent, "Shortcut launch intent must not be null.");
            this.icon = (ShortcutPinIcon) Objects.requireNonNull(shortcutPinIcon, "Shortcut icon must not be null.");
        }

        public ShortcutPinRequest build() {
            return new ShortcutPinRequest(this);
        }

        public Builder setActivity(ComponentName componentName) {
            this.activity = componentName;
            return this;
        }

        public Builder setCategories(Set<String> set) {
            this.categories = set == null ? null : new HashSet(set);
            return this;
        }

        public Builder setDisabledMessage(CharSequence charSequence) {
            this.disabledMessage = charSequence;
            return this;
        }

        public Builder setExtras(PersistableBundle persistableBundle) {
            this.extras = persistableBundle == null ? null : new PersistableBundle(persistableBundle);
            return this;
        }

        public Builder setLongLabel(CharSequence charSequence) {
            this.longLabel = charSequence;
            return this;
        }
    }

    private static Set<String> copyCategories(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Shortcut category must not be blank.");
            }
            hashSet.add(str);
        }
        return hashSet;
    }

    public ComponentName getActivity() {
        return this.activity;
    }

    public Set<String> getCategories() {
        if (this.categories == null) {
            return null;
        }
        return new HashSet(this.categories);
    }

    public CharSequence getDisabledMessage() {
        return this.disabledMessage;
    }

    public PersistableBundle getExtras() {
        if (this.extras == null) {
            return null;
        }
        return new PersistableBundle(this.extras);
    }

    public ShortcutPinIcon getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public Intent getIntent() {
        return getLaunchIntent();
    }

    public Intent getLaunchIntent() {
        return new Intent(this.launchIntent);
    }

    public CharSequence getLongLabel() {
        return this.longLabel;
    }

    public CharSequence getShortLabel() {
        return this.shortLabel;
    }

    public void validate() {
        if (TextUtils.isEmpty(this.id)) {
            throw new IllegalArgumentException("Shortcut id must not be blank.");
        }
        if (TextUtils.isEmpty(this.shortLabel)) {
            throw new IllegalArgumentException("Shortcut short label must not be blank.");
        }
        Intent intent = this.launchIntent;
        if (intent == null) {
            throw new IllegalArgumentException("Shortcut launch intent must not be null.");
        }
        if (TextUtils.isEmpty(intent.getAction())) {
            throw new IllegalArgumentException("Shortcut launch intent must have a non-empty action.");
        }
        ShortcutPinIcon shortcutPinIcon = this.icon;
        if (shortcutPinIcon == null) {
            throw new IllegalArgumentException("Shortcut icon must not be null.");
        }
        shortcutPinIcon.validate();
    }

    private ShortcutPinRequest(Builder builder) {
        this.id = builder.id;
        this.shortLabel = builder.shortLabel;
        this.launchIntent = builder.launchIntent == null ? null : new Intent(builder.launchIntent);
        this.icon = builder.icon;
        this.longLabel = builder.longLabel;
        this.disabledMessage = builder.disabledMessage;
        this.activity = builder.activity;
        this.categories = copyCategories(builder.categories);
        this.extras = builder.extras != null ? new PersistableBundle(builder.extras) : null;
        validate();
    }
}
