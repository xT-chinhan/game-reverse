package com.tapsdk.tapad.lottie.model.animatable;

import android.graphics.Path;
import com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.tapsdk.tapad.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.tapsdk.tapad.lottie.model.content.ShapeData;
import com.tapsdk.tapad.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super((List) list);
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<ShapeData, Path> createAnimation() {
        return new ShapeKeyframeAnimation(this.keyframes);
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
