package com.tapsdk.tapad.lottie.parser;

import android.util.JsonReader;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.content.ContentModel;

/* JADX INFO: loaded from: classes3.dex */
class ContentModelParser {
    private ContentModelParser() {
    }

    public static ContentModel parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        ContentModel contentModel;
        String strNextString;
        jsonReader.beginObject();
        byte b = 2;
        int iNextInt = 2;
        while (true) {
            contentModel = null;
            if (!jsonReader.hasNext()) {
                strNextString = null;
                break;
            }
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (!strNextName.equals("d")) {
                if (strNextName.equals("ty")) {
                    strNextString = jsonReader.nextString();
                    break;
                }
                jsonReader.skipValue();
            } else {
                iNextInt = jsonReader.nextInt();
            }
        }
        if (strNextString == null) {
            return null;
        }
        switch (strNextString.hashCode()) {
            case 3239:
                b = !strNextString.equals("el") ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b = !strNextString.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strNextString.equals("gf")) {
                    b = -1;
                }
                break;
            case 3307:
                b = !strNextString.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b = !strNextString.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b = !strNextString.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b = !strNextString.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3646:
                b = !strNextString.equals("rp") ? (byte) -1 : (byte) 7;
                break;
            case 3669:
                b = !strNextString.equals("sh") ? (byte) -1 : (byte) 8;
                break;
            case 3679:
                b = !strNextString.equals("sr") ? (byte) -1 : (byte) 9;
                break;
            case 3681:
                b = !strNextString.equals("st") ? (byte) -1 : (byte) 10;
                break;
            case 3705:
                b = !strNextString.equals("tm") ? (byte) -1 : (byte) 11;
                break;
            case 3710:
                b = !strNextString.equals("tr") ? (byte) -1 : (byte) 12;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                contentModel = CircleShapeParser.parse(jsonReader, lottieComposition, iNextInt);
                break;
            case 1:
                contentModel = ShapeFillParser.parse(jsonReader, lottieComposition);
                break;
            case 2:
                contentModel = GradientFillParser.parse(jsonReader, lottieComposition);
                break;
            case 3:
                contentModel = ShapeGroupParser.parse(jsonReader, lottieComposition);
                break;
            case 4:
                contentModel = GradientStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case 5:
                contentModel = MergePathsParser.parse(jsonReader);
                lottieComposition.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                contentModel = RectangleShapeParser.parse(jsonReader, lottieComposition);
                break;
            case 7:
                contentModel = RepeaterParser.parse(jsonReader, lottieComposition);
                break;
            case 8:
                contentModel = ShapePathParser.parse(jsonReader, lottieComposition);
                break;
            case 9:
                contentModel = PolystarShapeParser.parse(jsonReader, lottieComposition);
                break;
            case 10:
                contentModel = ShapeStrokeParser.parse(jsonReader, lottieComposition);
                break;
            case 11:
                contentModel = ShapeTrimPathParser.parse(jsonReader, lottieComposition);
                break;
            case 12:
                contentModel = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                break;
        }
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        return contentModel;
    }
}
