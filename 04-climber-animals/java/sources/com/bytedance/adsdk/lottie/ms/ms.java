package com.bytedance.adsdk.lottie.ms;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.lottie.ka.x;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends Paint {
    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public ms() {
    }

    public ms(int i) {
        super(i);
    }

    public ms(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public ms(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            setColor((x.ms(i, 0, 255) << 24) | (getColor() & ViewCompat.MEASURED_SIZE_MASK));
        } else {
            super.setAlpha(x.ms(i, 0, 255));
        }
    }
}
