package com.tapsdk.tapad.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableColorValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableIntegerValue;
import com.tapsdk.tapad.lottie.model.content.ShapeFill;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class ShapeFillParser {
    private ShapeFillParser() {
    }

    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean zNextBoolean = false;
        String strNextString = null;
        AnimatableColorValue color = null;
        AnimatableIntegerValue integer = null;
        int iNextInt = 1;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "fillEnabled":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "c":
                    color = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                    break;
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case "r":
                    iNextInt = jsonReader.nextInt();
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeFill(strNextString, zNextBoolean, iNextInt == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, color, integer);
    }
}
