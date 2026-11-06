package com.tapsdk.tapad.lottie.model.content;

import com.tapsdk.tapad.lottie.LottieDrawable;
import com.tapsdk.tapad.lottie.animation.content.Content;
import com.tapsdk.tapad.lottie.animation.content.ContentGroup;
import com.tapsdk.tapad.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class ShapeGroup implements ContentModel {
    private final List<ContentModel> items;
    private final String name;

    public ShapeGroup(String str, List<ContentModel> list) {
        this.name = str;
        this.items = list;
    }

    public List<ContentModel> getItems() {
        return this.items;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.tapsdk.tapad.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.items.toArray()) + AbstractJsonLexerKt.END_OBJ;
    }
}
