package com.tapsdk.tapad.lottie.model.content;

import com.tapsdk.tapad.lottie.LottieDrawable;
import com.tapsdk.tapad.lottie.animation.content.Content;
import com.tapsdk.tapad.lottie.animation.content.ShapeContent;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableShapeValue;
import com.tapsdk.tapad.lottie.model.layer.BaseLayer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath implements ContentModel {
    private final int index;
    private final String name;
    private final AnimatableShapeValue shapePath;

    public ShapePath(String str, int i, AnimatableShapeValue animatableShapeValue) {
        this.name = str;
        this.index = i;
        this.shapePath = animatableShapeValue;
    }

    public String getName() {
        return this.name;
    }

    public AnimatableShapeValue getShapePath() {
        return this.shapePath;
    }

    @Override // com.tapsdk.tapad.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapePath{name=" + this.name + ", index=" + this.index + AbstractJsonLexerKt.END_OBJ;
    }
}
