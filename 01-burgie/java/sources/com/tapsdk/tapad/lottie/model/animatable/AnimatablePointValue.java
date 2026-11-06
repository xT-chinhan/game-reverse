package com.tapsdk.tapad.lottie.model.animatable;

import android.graphics.PointF;
import com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.tapsdk.tapad.lottie.animation.keyframe.PointKeyframeAnimation;
import com.tapsdk.tapad.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super((List) list);
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.AnimatableValue
    public BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        return new PointKeyframeAnimation(this.keyframes);
    }

    @Override // com.tapsdk.tapad.lottie.model.animatable.BaseAnimatableValue
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
