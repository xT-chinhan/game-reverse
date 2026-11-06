package com.tapsdk.tapad.lottie.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableFloatValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableIntegerValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatablePathValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableScaleValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableTransform;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableValue;
import com.tapsdk.tapad.lottie.value.ScaleXY;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class AnimatableTransformParser {
    private AnimatableTransformParser() {
    }

    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        AnimatablePathValue animatablePathValue = null;
        AnimatableScaleValue scale = null;
        AnimatableIntegerValue integer = null;
        AnimatableValue<PointF, PointF> splitPath = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            animatablePathValue = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    continue;
                    break;
                case "p":
                    splitPath = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    scale = AnimatableValueParser.parseScale(jsonReader, lottieComposition);
                    continue;
                    break;
                case "eo":
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue;
                    break;
                case "rz":
                    lottieComposition.addWarning("Lottie doesn't support 3D layers.");
                    break;
                case "so":
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
        }
        if (z) {
            jsonReader.endObject();
        }
        return new AnimatableTransform(animatablePathValue == null ? new AnimatablePathValue() : animatablePathValue, splitPath, scale == null ? new AnimatableScaleValue(new ScaleXY(1.0f, 1.0f)) : scale, animatableFloatValue, integer == null ? new AnimatableIntegerValue() : integer, animatableFloatValue2, animatableFloatValue3);
    }
}
