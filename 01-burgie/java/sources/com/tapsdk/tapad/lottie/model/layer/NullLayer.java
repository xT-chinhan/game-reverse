package com.tapsdk.tapad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tapsdk.tapad.lottie.LottieDrawable;

/* JADX INFO: loaded from: classes3.dex */
public class NullLayer extends BaseLayer {
    public NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    @Override // com.tapsdk.tapad.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
    }

    @Override // com.tapsdk.tapad.lottie.model.layer.BaseLayer, com.tapsdk.tapad.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
