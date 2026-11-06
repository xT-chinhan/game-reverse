package com.tapsdk.tapad.lottie.parser;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.tapsdk.tapad.lottie.L;
import com.tapsdk.tapad.lottie.LottieComposition;
import com.tapsdk.tapad.lottie.LottieImageAsset;
import com.tapsdk.tapad.lottie.model.Font;
import com.tapsdk.tapad.lottie.model.FontCharacter;
import com.tapsdk.tapad.lottie.model.layer.Layer;
import com.tapsdk.tapad.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class LottieCompositionParser {
    private LottieCompositionParser() {
    }

    public static LottieComposition parse(JsonReader jsonReader) {
        SparseArray<FontCharacter> sparseArray;
        HashMap map;
        float fDpScale = Utils.dpScale();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        SparseArray<FontCharacter> sparseArray2 = new SparseArray<>();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            switch (strNextName) {
                case "assets":
                    sparseArray = sparseArray2;
                    map = map4;
                    parseAssets(jsonReader, lottieComposition, map2, map3);
                    break;
                case "layers":
                    sparseArray = sparseArray2;
                    map = map4;
                    parseLayers(jsonReader, lottieComposition, arrayList, longSparseArray);
                    break;
                case "h":
                    iNextInt = jsonReader.nextInt();
                    continue;
                    break;
                case "v":
                    sparseArray = sparseArray2;
                    map = map4;
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!Utils.isAtLeastVersion(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        lottieComposition.addWarning("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    }
                    break;
                case "w":
                    iNextInt2 = jsonReader.nextInt();
                    continue;
                    break;
                case "fr":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    map4 = map4;
                    sparseArray2 = sparseArray2;
                    continue;
                    break;
                case "ip":
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                    break;
                case "op":
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    map4 = map4;
                    sparseArray2 = sparseArray2;
                    continue;
                    break;
                case "chars":
                    parseChars(jsonReader, lottieComposition, sparseArray2);
                    sparseArray = sparseArray2;
                    map = map4;
                    break;
                case "fonts":
                    parseFonts(jsonReader, map4);
                    sparseArray = sparseArray2;
                    map = map4;
                    break;
                default:
                    sparseArray = sparseArray2;
                    map = map4;
                    jsonReader.skipValue();
                    break;
            }
            map4 = map;
            sparseArray2 = sparseArray;
        }
        jsonReader.endObject();
        lottieComposition.init(new Rect(0, 0, (int) (iNextInt2 * fDpScale), (int) (iNextInt * fDpScale)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map2, map3, sparseArray2, map4);
        return lottieComposition;
    }

    private static void parseAssets(JsonReader jsonReader, LottieComposition lottieComposition, Map<String, List<Layer>> map, Map<String, LottieImageAsset> map2) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            int iNextInt = 0;
            int iNextInt2 = 0;
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                switch (strNextName) {
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            Layer layer = LayerParser.parse(jsonReader, lottieComposition);
                            longSparseArray.put(layer.getId(), layer);
                            arrayList.add(layer);
                        }
                        jsonReader.endArray();
                        break;
                    case "h":
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case "p":
                        strNextString2 = jsonReader.nextString();
                        break;
                    case "u":
                        strNextString3 = jsonReader.nextString();
                        break;
                    case "w":
                        iNextInt = jsonReader.nextInt();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (strNextString2 != null) {
                LottieImageAsset lottieImageAsset = new LottieImageAsset(iNextInt, iNextInt2, strNextString, strNextString2, strNextString3);
                map2.put(lottieImageAsset.getId(), lottieImageAsset);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void parseChars(JsonReader jsonReader, LottieComposition lottieComposition, SparseArray<FontCharacter> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            FontCharacter fontCharacter = FontCharacterParser.parse(jsonReader, lottieComposition);
            sparseArray.put(fontCharacter.hashCode(), fontCharacter);
        }
        jsonReader.endArray();
    }

    private static void parseFonts(JsonReader jsonReader, Map<String, Font> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.getClass();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    Font font = FontParser.parse(jsonReader);
                    map.put(font.getName(), font);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void parseLayers(JsonReader jsonReader, LottieComposition lottieComposition, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            Layer layer = LayerParser.parse(jsonReader, lottieComposition);
            if (layer.getLayerType() == Layer.LayerType.Image) {
                i++;
            }
            list.add(layer);
            longSparseArray.put(layer.getId(), layer);
            if (i > 4) {
                L.warn("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }
}
