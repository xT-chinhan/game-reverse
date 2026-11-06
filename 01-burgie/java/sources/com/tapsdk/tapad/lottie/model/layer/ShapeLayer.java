package com.tapsdk.tapad.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.tapsdk.tapad.lottie.LottieDrawable;
import com.tapsdk.tapad.lottie.animation.content.Content;
import com.tapsdk.tapad.lottie.animation.content.ContentGroup;
import com.tapsdk.tapad.lottie.model.KeyPath;
import com.tapsdk.tapad.lottie.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ShapeLayer extends BaseLayer {
    private final ContentGroup contentGroup;

    public ShapeLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer.getShapes()));
        this.contentGroup = contentGroup;
        List<Content> list = Collections.EMPTY_LIST;
        contentGroup.setContents(list, list);
    }

    @Override // com.tapsdk.tapad.lottie.model.layer.BaseLayer
    public void drawLayer(Canvas canvas, Matrix matrix, int i) {
        this.contentGroup.draw(canvas, matrix, i);
    }

    @Override // com.tapsdk.tapad.lottie.model.layer.BaseLayer, com.tapsdk.tapad.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix) {
        super.getBounds(rectF, matrix);
        this.contentGroup.getBounds(rectF, this.boundsMatrix);
    }

    @Override // com.tapsdk.tapad.lottie.model.layer.BaseLayer
    public void resolveChildKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.contentGroup.resolveKeyPath(keyPath, i, list, keyPath2);
    }
}
