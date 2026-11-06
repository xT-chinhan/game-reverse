package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;
import android.util.JsonToken;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.animation.keyframe.PathKeyframe;
import com.tapsdk.tapad.lottie.utils.Utils;

/* JADX INFO: loaded from: classes3.dex */
class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    public static PathKeyframe parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        return new PathKeyframe(lottieComposition, KeyframeParser.parse(jsonReader, lottieComposition, Utils.dpScale(), PathParser.INSTANCE, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
    }
}
