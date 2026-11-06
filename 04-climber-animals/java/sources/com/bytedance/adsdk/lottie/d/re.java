package com.bytedance.adsdk.lottie.d;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.umeng.analytics.pro.ek;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class re {
    public static com.bytedance.adsdk.lottie.c ms(JsonReader jsonReader) throws IOException {
        float f;
        byte b;
        float fMs = com.bytedance.adsdk.lottie.ka.ny.ms();
        LongSparseArray<com.bytedance.adsdk.lottie.model.layer.x> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.lottie.model.d> sparseArray = new SparseArray<>();
        com.bytedance.adsdk.lottie.c.d dVar = new com.bytedance.adsdk.lottie.c.d();
        com.bytedance.adsdk.lottie.c.xr xrVar = new com.bytedance.adsdk.lottie.c.xr();
        com.bytedance.adsdk.lottie.c.ah ahVar = new com.bytedance.adsdk.lottie.c.ah();
        com.bytedance.adsdk.lottie.c.ms msVar = new com.bytedance.adsdk.lottie.c.ms();
        com.bytedance.adsdk.lottie.c cVar = new com.bytedance.adsdk.lottie.c();
        jsonReader.beginObject();
        String strNextString = null;
        int iNextInt = 0;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b2 = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    f = fMs;
                    if (strNextName.equals("assets")) {
                        b2 = 0;
                    }
                    break;
                case -1109732030:
                    f = fMs;
                    if (strNextName.equals("layers")) {
                        b2 = 1;
                    }
                    break;
                case -865448777:
                    f = fMs;
                    if (strNextName.equals("globalEvent")) {
                        b2 = 2;
                    }
                    break;
                case 104:
                    f = fMs;
                    if (strNextName.equals("h")) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case 118:
                    f = fMs;
                    if (strNextName.equals("v")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case 119:
                    f = fMs;
                    if (strNextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3208:
                    f = fMs;
                    if (strNextName.equals("dl")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 3276:
                    f = fMs;
                    if (strNextName.equals("fr")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 3292:
                    f = fMs;
                    if (strNextName.equals("gc")) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 3367:
                    f = fMs;
                    if (strNextName.equals("ip")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 3553:
                    f = fMs;
                    if (strNextName.equals("op")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 3002509:
                    f = fMs;
                    if (strNextName.equals("area")) {
                        b = 11;
                        b2 = b;
                    }
                    break;
                case 94623709:
                    f = fMs;
                    if (strNextName.equals("chars")) {
                        b = 12;
                        b2 = b;
                    }
                    break;
                case 97615364:
                    f = fMs;
                    if (strNextName.equals("fonts")) {
                        b = ek.k;
                        b2 = b;
                    }
                    break;
                case 110364485:
                    f = fMs;
                    if (strNextName.equals("timer")) {
                        b = ek.l;
                        b2 = b;
                    }
                    break;
                case 839250809:
                    f = fMs;
                    if (strNextName.equals("markers")) {
                        b = ek.m;
                        b2 = b;
                    }
                    break;
                default:
                    f = fMs;
                    break;
            }
            switch (b2) {
                case 0:
                    ms(jsonReader, cVar, map, map2);
                    break;
                case 1:
                    ms(jsonReader, cVar, arrayList, longSparseArray);
                    break;
                case 2:
                    ms(jsonReader, ahVar);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.lottie.ka.ny.ms(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        cVar.ms("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 5:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 6:
                    strNextString = jsonReader.nextString();
                    break;
                case 7:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case 8:
                    ms(jsonReader, xrVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    ms(jsonReader, msVar);
                    break;
                case 12:
                    ms(jsonReader, cVar, sparseArray);
                    break;
                case 13:
                    ms(jsonReader, map3);
                    break;
                case 14:
                    ms(jsonReader, dVar);
                    break;
                case 15:
                    ms(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            fMs = f;
        }
        float f2 = fMs;
        jsonReader.endObject();
        cVar.ms(new Rect(0, 0, (int) (iNextInt * f2), (int) (iNextInt2 * f2)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, dVar, strNextString, xrVar, ahVar, msVar);
        return cVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c.ms msVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 104) {
                    switch (iHashCode) {
                        case 119:
                            if (!strNextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 120:
                            if (!strNextName.equals("x")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 121:
                            if (!strNextName.equals("y")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                } else if (strNextName.equals("h")) {
                    b = 3;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    msVar.f146ms = jsonReader.nextString();
                } else if (b == 1) {
                    msVar.xr = jsonReader.nextString();
                } else if (b == 2) {
                    msVar.ah = jsonReader.nextString();
                } else if (b == 3) {
                    msVar.d = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0042  */
    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c.ah ahVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 107027) {
                        if (iHashCode == 3237004 && strNextName.equals("inel")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("lel")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    ahVar.xr = new int[][]{new int[]{-1, -1}};
                    jsonReader.beginArray();
                    if (jsonReader.hasNext()) {
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                ahVar.xr[0][i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                    }
                    jsonReader.endArray();
                } else if (b == 1) {
                    ahVar.f144ms = jsonReader.nextString();
                } else if (b == 2) {
                    ahVar.ah = ah(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c.xr xrVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3139) {
                    if (iHashCode != 3232) {
                        if (iHashCode != 3571) {
                            if (iHashCode != 3666) {
                                if (iHashCode == 98713 && strNextName.equals("cpf")) {
                                    b = 4;
                                } else {
                                    b = -1;
                                }
                            } else if (strNextName.equals("se")) {
                                b = 0;
                            } else {
                                b = -1;
                            }
                        } else if (strNextName.equals(com.kuaishou.weapon.p0.t.x)) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("ee")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("be")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    xrVar.f147ms = jsonReader.nextInt();
                } else if (b == 1) {
                    xrVar.xr = xr(jsonReader);
                } else if (b == 2) {
                    xrVar.ah = xr(jsonReader);
                } else if (b == 3) {
                    xrVar.d = jsonReader.nextInt();
                } else if (b == 4) {
                    xr(jsonReader, xrVar);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    private static void xr(JsonReader jsonReader, com.bytedance.adsdk.lottie.c.xr xrVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 3239) {
                    if (iHashCode != 3276) {
                        if (iHashCode == 107027 && strNextName.equals("lel")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals("fr")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    xrVar.ka = jsonReader.nextInt();
                } else if (b == 1) {
                    xrVar.c = jsonReader.nextString();
                } else if (b == 2) {
                    xrVar.ab = ah(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private static Map<String, Object> xr(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("lel")) {
                map.put("lel", ah(jsonReader));
            } else if (strNextName.equals("lottie_back")) {
                JSONObject jSONObject = new JSONObject();
                map.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.hashCode();
                    if (strNextName2.equals(LiveConfigKey.HIGH)) {
                        try {
                            jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.sl.ms(e);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        Object objRemove = map.remove("lottie_back");
        if (objRemove instanceof JSONObject) {
            Object obj = map.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(objRemove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(objRemove);
                map.put("lel", jSONArray);
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x007a  */
    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c.d dVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "ke":
                        dVar.f145ms = jsonReader.nextInt();
                        break;
                    case "id":
                        dVar.xr = jsonReader.nextString();
                        break;
                    case "tl":
                        dVar.ah = jsonReader.nextString();
                        break;
                    case "at":
                        dVar.d = jsonReader.nextString();
                        break;
                    case "inel":
                        dVar.ka = new int[]{-1, -1};
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                dVar.ka[i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case "el":
                        dVar.c = jsonReader.nextString();
                        break;
                    case "lel":
                        dVar.ab = ah(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, List<com.bytedance.adsdk.lottie.model.layer.x> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.x> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.layer.x xVarMs = b.ms(jsonReader, cVar);
            if (xVarMs.hi() == com.bytedance.adsdk.lottie.model.layer.x.ms.IMAGE) {
                i++;
            }
            list.add(xVarMs);
            longSparseArray.put(xVarMs.ka(), xVarMs);
            if (i > 4) {
                com.bytedance.adsdk.lottie.ka.ka.xr("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, Map<String, List<com.bytedance.adsdk.lottie.model.layer.x>> map, Map<String, com.bytedance.adsdk.lottie.ny> map2) throws IOException {
        int i;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String strNextString = null;
            String strNextString2 = null;
            String strNextString3 = null;
            String strNextString4 = null;
            List<com.bytedance.adsdk.lottie.ny.xr> listD = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayAh = null;
            String strNextString6 = null;
            String strNextString7 = null;
            com.bytedance.adsdk.lottie.ny.ms msVar = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                byte b = -1;
                switch (strNextName.hashCode()) {
                    case -1109732030:
                        if (strNextName.equals("layers")) {
                            b = 0;
                        }
                        break;
                    case -847116302:
                        if (strNextName.equals("ugen_v")) {
                            b = 1;
                        }
                        break;
                    case 104:
                        if (strNextName.equals("h")) {
                            b = 2;
                        }
                        break;
                    case 112:
                        if (strNextName.equals("p")) {
                            b = 3;
                        }
                        break;
                    case 117:
                        if (strNextName.equals("u")) {
                            b = 4;
                        }
                        break;
                    case 119:
                        if (strNextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                            b = 5;
                        }
                        break;
                    case 3239:
                        if (strNextName.equals(com.kuaishou.weapon.p0.t.n)) {
                            b = 6;
                        }
                        break;
                    case 3355:
                        if (strNextName.equals("id")) {
                            b = 7;
                        }
                        break;
                    case 3633:
                        if (strNextName.equals("rc")) {
                            b = 8;
                        }
                        break;
                    case 3695:
                        if (strNextName.equals("tc")) {
                            b = 9;
                        }
                        break;
                    case 107027:
                        if (strNextName.equals("lel")) {
                            b = 10;
                        }
                        break;
                    case 107902:
                        if (strNextName.equals("md5")) {
                            b = 11;
                        }
                        break;
                    case 112793:
                        if (strNextName.equals("rel")) {
                            b = 12;
                        }
                        break;
                    case 3237004:
                        if (strNextName.equals("inel")) {
                            b = ek.k;
                        }
                        break;
                }
                switch (b) {
                    case 0:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.model.layer.x xVarMs = b.ms(jsonReader, cVar);
                            longSparseArray.put(xVarMs.ka(), xVarMs);
                            arrayList.add(xVarMs);
                            iNextInt = iNextInt;
                        }
                        i = iNextInt;
                        jsonReader.endArray();
                        iNextInt = i;
                        break;
                    case 1:
                        strNextString7 = jsonReader.nextString();
                        break;
                    case 2:
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case 3:
                        strNextString2 = jsonReader.nextString();
                        break;
                    case 4:
                        strNextString3 = jsonReader.nextString();
                        break;
                    case 5:
                        iNextInt = jsonReader.nextInt();
                        break;
                    case 6:
                        strNextString5 = jsonReader.nextString();
                        break;
                    case 7:
                        strNextString = jsonReader.nextString();
                        break;
                    case 8:
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            i = iNextInt;
                            iNextInt = i;
                        } else {
                            com.bytedance.adsdk.lottie.ny.ms msVar2 = new com.bytedance.adsdk.lottie.ny.ms();
                            jsonReader.beginObject();
                            ms(jsonReader, msVar2);
                            jsonReader.endObject();
                            msVar = msVar2;
                        }
                        break;
                    case 9:
                        jsonReader.beginArray();
                        listD = d(jsonReader);
                        jsonReader.endArray();
                        break;
                    case 10:
                        jSONArrayAh = ah(jsonReader);
                        break;
                    case 11:
                        strNextString6 = jsonReader.nextString();
                        break;
                    case 12:
                        strNextString4 = jsonReader.nextString();
                        break;
                    case 13:
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i2 = 0; i2 < 2; i2++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i2] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        i = iNextInt;
                        iNextInt = i;
                        break;
                }
            }
            int i3 = iNextInt;
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.bytedance.adsdk.lottie.ny nyVar = new com.bytedance.adsdk.lottie.ny(i3, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listD, strNextString5, iArr, jSONArrayAh, strNextString6, strNextString7, msVar);
                map2.put(nyVar.hi(), nyVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    private static JSONArray ah(JsonReader jsonReader) {
        byte b;
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    int iHashCode = strNextName.hashCode();
                    if (iHashCode != 3324) {
                        if (iHashCode == 116753 && strNextName.equals("vid")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(LiveConfigKey.HIGH)) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        try {
                            jSONObject.put("vid", jsonReader.nextString());
                        } catch (JSONException e) {
                            com.bytedance.sdk.component.utils.sl.ms(e);
                        }
                    } else if (b == 1) {
                        try {
                            jSONObject.put(LiveConfigKey.HIGH, jsonReader.nextInt());
                        } catch (JSONException e2) {
                            com.bytedance.sdk.component.utils.sl.ms(e2);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e3) {
            com.bytedance.sdk.component.utils.sl.ms(e3);
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.ny.ms msVar) {
        byte b;
        while (jsonReader.hasNext()) {
            try {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -2128704353) {
                    if (iHashCode == 3308 && strNextName.equals("gs")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("is_secondary")) {
                    b = 0;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    msVar.xr = jsonReader.nextBoolean();
                } else if (b == 1) {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        msVar.f266ms = new com.bytedance.adsdk.lottie.ny.ms.C0190ms();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            if (((strNextName2.hashCode() == 114 && strNextName2.equals(com.kuaishou.weapon.p0.t.k)) ? (byte) 0 : (byte) -1) == 0) {
                                msVar.f266ms.f267ms = (float) jsonReader.nextDouble();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                } else {
                    jsonReader.skipValue();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    private static List<com.bytedance.adsdk.lottie.ny.xr> d(JsonReader jsonReader) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                com.bytedance.adsdk.lottie.ny.xr xrVar = new com.bytedance.adsdk.lottie.ny.xr();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "l":
                            xrVar.f268ms = jsonReader.nextInt();
                            break;
                        case "le":
                            xrVar.xr = jsonReader.nextInt();
                            break;
                        case "s":
                            xrVar.c = jsonReader.nextInt();
                            break;
                        case "c":
                            xrVar.d = jsonReader.nextString();
                            break;
                        case "fcl":
                            xrVar.ah = jsonReader.nextString();
                            break;
                        case "bold":
                            xrVar.ab = jsonReader.nextInt();
                            break;
                        case "f":
                            xrVar.ka = jsonReader.nextString();
                            break;
                        case "bs":
                            xrVar.x = jsonReader.nextInt();
                            break;
                        case "ali":
                            xrVar.ny = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                arrayList.add(xrVar);
            }
            return arrayList;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
            return null;
        }
    }

    private static void ms(JsonReader jsonReader, Map<String, com.bytedance.adsdk.lottie.model.ah> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.ah ahVarMs = u.ms(jsonReader);
                    map.put(ahVarMs.xr(), ahVarMs);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar, SparseArray<com.bytedance.adsdk.lottie.model.d> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.d dVarMs = zb.ms(jsonReader, cVar);
            sparseArray.put(dVarMs.hashCode(), dVarMs);
        }
        jsonReader.endArray();
    }

    private static void ms(JsonReader jsonReader, List<com.bytedance.adsdk.lottie.model.c> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            String strNextString = null;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.lottie.model.c(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
