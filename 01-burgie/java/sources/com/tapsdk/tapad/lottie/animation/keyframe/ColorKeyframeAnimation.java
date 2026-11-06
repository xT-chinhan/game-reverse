package com.tapsdk.tapad.lottie.animation.keyframe;

import com.tapsdk.tapad.lottie.utils.GammaEvaluator;
import com.tapsdk.tapad.lottie.value.Keyframe;
import com.tapsdk.tapad.lottie.value.LottieValueCallback;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<Integer>) keyframe, f);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public Integer getValue(Keyframe<Integer> keyframe, float f) {
        Integer num;
        Integer num2 = keyframe.startValue;
        if (num2 == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        Integer num3 = num2;
        int iIntValue = num3.intValue();
        Integer num4 = keyframe.endValue;
        int iIntValue2 = num4.intValue();
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        return (lottieValueCallback == 0 || (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), num3, num4, f, getLinearCurrentKeyframeProgress(), getProgress())) == null) ? Integer.valueOf(GammaEvaluator.evaluate(f, iIntValue, iIntValue2)) : num;
    }
}
