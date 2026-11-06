package com.tapsdk.tapad.internal.shortcut;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ShortcutPinIcon {

    public static final class BitmapIcon extends ShortcutPinIcon {
        private final Bitmap bitmap;

        public BitmapIcon(Bitmap bitmap) {
            super();
            this.bitmap = (Bitmap) Objects.requireNonNull(bitmap, "Shortcut icon bitmap must not be null.");
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }
    }

    public static final class ResourceIcon extends ShortcutPinIcon {
        private final String packageName;
        private final int resourceId;

        public ResourceIcon(int i) {
            this(null, i);
        }

        public String getPackageName() {
            return this.packageName;
        }

        public int getResourceId() {
            return this.resourceId;
        }

        @Override // com.tapsdk.tapad.internal.shortcut.ShortcutPinIcon
        public void validate() {
            if (this.resourceId == 0) {
                throw new IllegalArgumentException("Shortcut icon resource id must not be 0.");
            }
        }

        public ResourceIcon(String str, int i) {
            super();
            if (i == 0) {
                throw new IllegalArgumentException("Shortcut icon resource id must not be 0.");
            }
            this.packageName = TextUtils.isEmpty(str) ? null : str;
            this.resourceId = i;
        }
    }

    public static ShortcutPinIcon bitmap(Bitmap bitmap) {
        return new BitmapIcon(bitmap);
    }

    public static ShortcutPinIcon resource(int i) {
        return new ResourceIcon(i);
    }

    public void validate() {
    }

    private ShortcutPinIcon() {
    }

    public static ShortcutPinIcon resource(String str, int i) {
        return new ResourceIcon(str, i);
    }
}
