package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableFloatValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableGradientColorValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableIntegerValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatablePointValue;
import com.tapsdk.tapad.lottie.model.content.GradientStroke;
import com.tapsdk.tapad.lottie.model.content.GradientType;
import com.tapsdk.tapad.lottie.model.content.ShapeStroke;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
class GradientStrokeParser {
    private GradientStrokeParser() {
    }

    public static GradientStroke parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        ArrayList arrayList = new ArrayList();
        float fNextDouble = 0.0f;
        String strNextString = null;
        GradientType gradientType = null;
        AnimatableGradientColorValue gradientColor = null;
        AnimatableIntegerValue integer = null;
        AnimatablePointValue point = null;
        AnimatablePointValue point2 = null;
        AnimatableFloatValue animatableFloatValue = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            AnimatableFloatValue animatableFloatValue3 = animatableFloatValue2;
            float f = fNextDouble;
            switch (strNextName) {
                case "d":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        AnimatableFloatValue animatableFloatValue4 = null;
                        String strNextString2 = null;
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            strNextName2.getClass();
                            lineJoinType = lineJoinType;
                            if (strNextName2.equals("n")) {
                                strNextString2 = jsonReader.nextString();
                            } else if (strNextName2.equals(an.aE)) {
                                animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        lineJoinType = lineJoinType;
                        jsonReader.endObject();
                        if (strNextString2.equals("o")) {
                            animatableFloatValue3 = animatableFloatValue4;
                        } else if (strNextString2.equals("d") || strNextString2.equals("g")) {
                            arrayList.add(animatableFloatValue4);
                        }
                    }
                    ShapeStroke.LineJoinType lineJoinType2 = lineJoinType;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add((AnimatableFloatValue) arrayList.get(0));
                    }
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    lineJoinType = lineJoinType2;
                    break;
                case "e":
                    point2 = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "g":
                    jsonReader.beginObject();
                    int iNextInt = -1;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        strNextName3.getClass();
                        if (strNextName3.equals("k")) {
                            gradientColor = AnimatableValueParser.parseGradientColor(jsonReader, lottieComposition, iNextInt);
                        } else if (strNextName3.equals(an.ax)) {
                            iNextInt = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "o":
                    integer = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "s":
                    point = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "t":
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.Linear : GradientType.Radial;
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "w":
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "lc":
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "lj":
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                case "ml":
                    fNextDouble = (float) jsonReader.nextDouble();
                    animatableFloatValue2 = animatableFloatValue3;
                    break;
                case "nm":
                    strNextString = jsonReader.nextString();
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
                default:
                    jsonReader.skipValue();
                    animatableFloatValue2 = animatableFloatValue3;
                    fNextDouble = f;
                    break;
            }
        }
        return new GradientStroke(strNextString, gradientType, gradientColor, integer, point, point2, animatableFloatValue, lineCapType, lineJoinType, fNextDouble, arrayList, animatableFloatValue2);
    }
}
