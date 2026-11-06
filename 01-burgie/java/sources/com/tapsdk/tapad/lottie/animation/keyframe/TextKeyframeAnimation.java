package com.tapsdk.tapad.lottie.animation.keyframe;

import com.tapsdk.tapad.lottie.model.DocumentData;
import com.tapsdk.tapad.lottie.value.Keyframe;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<DocumentData>) keyframe, f);
    }

    @Override // com.tapsdk.tapad.lottie.animation.keyframe.BaseKeyframeAnimation
    public DocumentData getValue(Keyframe<DocumentData> keyframe, float f) {
        return keyframe.startValue;
    }
}
