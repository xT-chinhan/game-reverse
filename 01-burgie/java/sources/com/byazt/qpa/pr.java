package com.byazt.qpa;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import android.support.v4.view.ViewCompat;
import com.byazt.ptr.aj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2195, 37})
public class pr extends Paint {
    public pr() {
    }

    public pr(int i) {
        super(i);
    }

    public pr(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public pr(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i) {
        if (Build.VERSION.SDK_INT < 29) {
            setColor((aj.pr(i, 0, 255) << 24) | (getColor() & ViewCompat.MEASURED_SIZE_MASK));
        } else {
            super.setAlpha(aj.pr(i, 0, 255));
        }
    }
}
