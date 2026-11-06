package com.kwad.sdk.dexapi.kssupport;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: loaded from: classes3.dex */
public class SResourcesCompat {
    public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawable(resources, i, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getDrawableForDensity(resources, i, i2, theme);
    }

    public static int getColor(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getColor(resources, i, theme);
    }

    public static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) throws Resources.NotFoundException {
        return ResourcesCompat.getColorStateList(resources, i, theme);
    }

    public static Typeface getFont(Context context, int i) throws Resources.NotFoundException {
        return ResourcesCompat.getFont(context, i);
    }

    public static void getFont(Context context, int i, ResourcesCompat.FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        ResourcesCompat.getFont(context, i, fontCallback, handler);
    }

    private SResourcesCompat() {
    }
}
