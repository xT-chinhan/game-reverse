package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.smartdigimkt.o3.d;
import com.smartdigimkt.sdk.basead.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes3.dex */
public class WrapRoundImageView extends RoundImageView {
    public WrapRoundImageView(Context context) {
        super(context);
    }

    public int[] setBitmapAndResize(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        setImageBitmap(bitmap);
        if (i > 0 && i2 > 0) {
            try {
                int[] iArrA = d.a(i, i2, bitmap.getWidth() / bitmap.getHeight());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = iArrA[0];
                    layoutParams.height = iArrA[1];
                    setLayoutParams(layoutParams);
                    return iArrA;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public WrapRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
