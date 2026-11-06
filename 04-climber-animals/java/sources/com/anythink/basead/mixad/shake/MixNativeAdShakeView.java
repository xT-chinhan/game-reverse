package com.anythink.basead.mixad.shake;

import android.content.Context;
import android.widget.FrameLayout;
import com.anythink.basead.ui.ShakeThumbView;
import com.anythink.core.api.ATShakeViewListener;
import com.anythink.core.common.h.y;

/* JADX INFO: loaded from: classes.dex */
public class MixNativeAdShakeView extends FrameLayout implements com.anythink.core.common.l.a {
    private y a;
    private int b;
    private ATShakeViewListener c;

    public MixNativeAdShakeView(Context context) {
        super(context);
    }

    public MixNativeAdShakeView(Context context, y yVar, int i) {
        super(context);
        this.a = yVar;
        this.b = i;
    }

    public void initView(int i, int i2, ATShakeViewListener aTShakeViewListener) {
        this.c = aTShakeViewListener;
        ShakeThumbView shakeThumbView = new ShakeThumbView(getContext());
        if (i <= 0) {
            i = -2;
        }
        if (i2 <= 0) {
            i2 = -2;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = 17;
        shakeThumbView.setLayoutParams(layoutParams);
        addView(shakeThumbView);
        shakeThumbView.setShakeSetting(this.a, this.b != 1 ? 3 : 1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ATShakeViewListener aTShakeViewListener = this.c;
        if (aTShakeViewListener != null) {
            aTShakeViewListener.onDismiss();
        }
    }
}
