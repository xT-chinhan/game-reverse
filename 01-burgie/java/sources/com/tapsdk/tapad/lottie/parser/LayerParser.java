package com.tapsdk.tapad.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableFloatValue;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableTextFrame;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableTextProperties;
import com.tapsdk.tapad.lottie.model.animatable.AnimatableTransform;
import com.tapsdk.tapad.lottie.model.content.ContentModel;
import com.tapsdk.tapad.lottie.model.layer.Layer;
import com.tapsdk.tapad.lottie.utils.Utils;
import com.tapsdk.tapad.lottie.value.Keyframe;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LayerParser {
    private LayerParser() {
    }

    public static Layer parse(LottieComposition lottieComposition) {
        Rect bounds = lottieComposition.getBounds();
        List list = Collections.EMPTY_LIST;
        return new Layer(list, lottieComposition, "__container", -1L, Layer.LayerType.PreComp, -1L, null, list, new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, bounds.width(), bounds.height(), null, null, list, Layer.MatteType.None, null);
    }

    public static Layer parse(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList;
        byte b;
        Layer.MatteType matteType = Layer.MatteType.None;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        float fNextDouble = 1.0f;
        int iDpScale = 0;
        int iDpScale2 = 0;
        int color = 0;
        int iDpScale3 = 0;
        int iDpScale4 = 0;
        Layer.LayerType layerType = null;
        String strNextString = null;
        AnimatableTransform animatableTransform = null;
        AnimatableTextFrame documentData = null;
        AnimatableTextProperties animatableTextProperties = null;
        AnimatableFloatValue animatableFloatValue = null;
        long jNextInt = 0;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        long jNextInt2 = -1;
        String strNextString2 = null;
        String strNextString3 = "UNSET";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            byte b2 = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b2 = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                        b2 = b;
                    }
                    break;
                case 104:
                    if (strNextName.equals(an.aG)) {
                        b = 2;
                        b2 = b;
                    }
                    break;
                case 116:
                    if (strNextName.equals(an.aI)) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case 119:
                    if (strNextName.equals("w")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 3432:
                    if (strNextName.equals(MediationConstant.ADN_KS)) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 11;
                        b2 = b;
                    }
                    break;
                case 3669:
                    if (strNextName.equals("sh")) {
                        b = 12;
                        b2 = b;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b = cc.k;
                        b2 = b;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b = cc.l;
                        b2 = b;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = cc.m;
                        b2 = b;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b = cc.n;
                        b2 = b;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        b = 17;
                        b2 = b;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        b = 18;
                        b2 = b;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = 19;
                        b2 = b;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = 20;
                        b2 = b;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = 21;
                        b2 = b;
                    }
                    break;
            }
            switch (b2) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        ContentModel contentModel = ContentModelParser.parse(jsonReader, lottieComposition);
                        if (contentModel != null) {
                            arrayList3.add(contentModel);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    iDpScale4 = (int) (Utils.dpScale() * jsonReader.nextInt());
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.getClass();
                        if (strNextName2.equals(an.av)) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                animatableTextProperties = AnimatableTextPropertiesParser.parse(jsonReader, lottieComposition);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (!strNextName2.equals("d")) {
                            jsonReader.skipValue();
                        } else {
                            documentData = AnimatableValueParser.parseDocumentData(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    iDpScale3 = (int) (Utils.dpScale() * jsonReader.nextInt());
                    break;
                case 5:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.getClass();
                            if (!strNextName3.equals("nm")) {
                                jsonReader.skipValue();
                            } else {
                                arrayList4.add(jsonReader.nextString());
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    lottieComposition.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 7:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    animatableTransform = AnimatableTransformParser.parse(jsonReader, lottieComposition);
                    break;
                case 9:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 10:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 11:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 12:
                    iDpScale2 = (int) (Utils.dpScale() * jsonReader.nextInt());
                    break;
                case 13:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 14:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    iDpScale = (int) (Utils.dpScale() * jsonReader.nextInt());
                    break;
                case 16:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition, false);
                    break;
                case 17:
                    matteType2 = Layer.MatteType.values()[jsonReader.nextInt()];
                    break;
                case 18:
                    int iNextInt = jsonReader.nextInt();
                    layerType = Layer.LayerType.Unknown;
                    if (iNextInt < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iNextInt];
                    }
                    break;
                case 19:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 20:
                    strNextString = jsonReader.nextString();
                    break;
                case 21:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(MaskParser.parse(jsonReader, lottieComposition));
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        float f = fNextDouble2 / fNextDouble;
        float endFrame = fNextDouble3 / fNextDouble;
        ArrayList arrayList5 = new ArrayList();
        if (f > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(f)));
        } else {
            arrayList = arrayList5;
        }
        if (endFrame <= 0.0f) {
            endFrame = lottieComposition.getEndFrame();
        }
        arrayList.add(new Keyframe(lottieComposition, fValueOf, fValueOf, null, f, Float.valueOf(endFrame)));
        arrayList.add(new Keyframe(lottieComposition, fValueOf2, fValueOf2, null, endFrame, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString3.endsWith(".ai") || "ai".equals(strNextString2)) {
            lottieComposition.addWarning("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList3, lottieComposition, strNextString3, jNextInt, layerType, jNextInt2, strNextString, arrayList2, animatableTransform, iDpScale, iDpScale2, color, fNextDouble, fNextDouble4, iDpScale3, iDpScale4, documentData, animatableTextProperties, arrayList, matteType2, animatableFloatValue);
    }
}
