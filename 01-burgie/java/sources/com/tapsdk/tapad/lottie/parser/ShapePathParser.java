package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableShapeValue;
import com.tapsdk.tapad.lottie.model.content.ShapePath;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class ShapePathParser {
    private ShapePathParser() {
    }

    public static ShapePath parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String strNextString = null;
        int iNextInt = 0;
        AnimatableShapeValue shapeData = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "ks":
                    shapeData = AnimatableValueParser.parseShapeData(jsonReader, lottieComposition);
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                case "ind":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapePath(strNextString, iNextInt, shapeData);
    }
}
