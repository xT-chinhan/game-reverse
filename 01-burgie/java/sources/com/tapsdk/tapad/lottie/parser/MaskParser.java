package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableIntegerValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableShapeValue;
import com.tapsdk.tapad.lottie.model.content.Mask;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class MaskParser {
    private MaskParser() {
    }

    public static Mask parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        jsonReader.beginObject();
        Mask.MaskMode maskMode = null;
        AnimatableShapeValue shapeData = null;
        AnimatableIntegerValue integer = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case "pt":
                    shapeData = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    break;
                case "mode":
                    String strNextString = jsonReader.nextString();
                    strNextString.getClass();
                    switch (strNextString) {
                        case "a":
                            maskMode = Mask.MaskMode.MaskModeAdd;
                            break;
                        case "i":
                            lottieComposition.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MaskModeIntersect;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MaskModeSubtract;
                            break;
                        default:
                            maskMode = Mask.MaskMode.MaskModeAdd;
                            break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new Mask(maskMode, shapeData, integer);
    }
}
