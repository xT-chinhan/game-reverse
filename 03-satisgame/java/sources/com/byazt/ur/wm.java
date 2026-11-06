package com.byazt.ur;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.DebugKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm {
    public static com.byazt.pp.w n(JsonReader jsonReader) throws IOException {
        float f;
        byte b;
        float fN = com.byazt.nu.tj.n();
        LongSparseArray<com.byazt.eg.fs> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.byazt.ld.q> sparseArray = new SparseArray<>();
        com.byazt.pp.w.q qVar = new com.byazt.pp.w.q();
        com.byazt.pp.w.qg qgVar = new com.byazt.pp.w.qg();
        com.byazt.pp.w.s sVar = new com.byazt.pp.w.s();
        com.byazt.pp.w.n nVar = new com.byazt.pp.w.n();
        com.byazt.pp.w wVar = new com.byazt.pp.w();
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
                    f = fN;
                    if (strNextName.equals("assets")) {
                        b2 = 0;
                    }
                    break;
                case -1109732030:
                    f = fN;
                    if (strNextName.equals("layers")) {
                        b2 = 1;
                    }
                    break;
                case -865448777:
                    f = fN;
                    if (strNextName.equals("globalEvent")) {
                        b2 = 2;
                    }
                    break;
                case 104:
                    f = fN;
                    if (strNextName.equals("h")) {
                        b = 3;
                        b2 = b;
                    }
                    break;
                case 118:
                    f = fN;
                    if (strNextName.equals("v")) {
                        b = 4;
                        b2 = b;
                    }
                    break;
                case 119:
                    f = fN;
                    if (strNextName.equals("w")) {
                        b = 5;
                        b2 = b;
                    }
                    break;
                case 3208:
                    f = fN;
                    if (strNextName.equals("dl")) {
                        b = 6;
                        b2 = b;
                    }
                    break;
                case 3276:
                    f = fN;
                    if (strNextName.equals("fr")) {
                        b = 7;
                        b2 = b;
                    }
                    break;
                case 3292:
                    f = fN;
                    if (strNextName.equals("gc")) {
                        b = 8;
                        b2 = b;
                    }
                    break;
                case 3367:
                    f = fN;
                    if (strNextName.equals("ip")) {
                        b = 9;
                        b2 = b;
                    }
                    break;
                case 3553:
                    f = fN;
                    if (strNextName.equals("op")) {
                        b = 10;
                        b2 = b;
                    }
                    break;
                case 3002509:
                    f = fN;
                    if (strNextName.equals("area")) {
                        b = 11;
                        b2 = b;
                    }
                    break;
                case 94623709:
                    f = fN;
                    if (strNextName.equals("chars")) {
                        b = 12;
                        b2 = b;
                    }
                    break;
                case 97615364:
                    f = fN;
                    if (strNextName.equals("fonts")) {
                        b = 13;
                        b2 = b;
                    }
                    break;
                case 110364485:
                    f = fN;
                    if (strNextName.equals("timer")) {
                        b = 14;
                        b2 = b;
                    }
                    break;
                case 839250809:
                    f = fN;
                    if (strNextName.equals("markers")) {
                        b = 15;
                        b2 = b;
                    }
                    break;
                default:
                    f = fN;
                    break;
            }
            switch (b2) {
                case 0:
                    n(jsonReader, wVar, map, map2);
                    break;
                case 1:
                    n(jsonReader, wVar, arrayList, longSparseArray);
                    break;
                case 2:
                    n(jsonReader, sVar);
                    break;
                case 3:
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case 4:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.byazt.nu.tj.n(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        wVar.n("Lottie only supports bodymovin >= 4.4.0");
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
                    n(jsonReader, qgVar);
                    break;
                case 9:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 10:
                    fNextDouble2 = ((float) jsonReader.nextDouble()) - 0.01f;
                    break;
                case 11:
                    n(jsonReader, nVar);
                    break;
                case 12:
                    n(jsonReader, wVar, sparseArray);
                    break;
                case 13:
                    n(jsonReader, map3);
                    break;
                case 14:
                    n(jsonReader, qVar);
                    break;
                case 15:
                    n(jsonReader, arrayList2);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            fN = f;
        }
        float f2 = fN;
        jsonReader.endObject();
        wVar.n(new Rect(0, 0, (int) (iNextInt * f2), (int) (iNextInt2 * f2)), fNextDouble, fNextDouble2, fNextDouble3, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, qVar, strNextString, qgVar, sVar, nVar);
        return wVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0044  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void n(JsonReader jsonReader, com.byazt.pp.w.n nVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 104) {
                    switch (iHashCode) {
                        case 119:
                            if (!strNextName.equals("w")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 120:
                            if (!strNextName.equals(com.byazt.af.x.n)) {
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
                    nVar.n = jsonReader.nextString();
                } else if (b == 1) {
                    nVar.qg = jsonReader.nextString();
                } else if (b == 2) {
                    nVar.s = jsonReader.nextString();
                } else if (b == 3) {
                    nVar.q = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0052  */
    private static void n(JsonReader jsonReader, com.byazt.pp.w.s sVar) {
        byte b;
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != -1291329255) {
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
                    } else if (strNextName.equals("el")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("events")) {
                    b = 3;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    sVar.qg = new int[][]{new int[]{-1, -1}};
                    jsonReader.beginArray();
                    if (jsonReader.hasNext()) {
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                sVar.qg[0][i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                    }
                    jsonReader.endArray();
                } else if (b == 1) {
                    sVar.n = jsonReader.nextString();
                } else if (b == 2) {
                    sVar.s = l(jsonReader);
                } else if (b == 3) {
                    sVar.l = w(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0077  */
    private static void n(JsonReader jsonReader, com.byazt.pp.w.qg qgVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "se":
                        qgVar.n = jsonReader.nextInt();
                        break;
                    case "be":
                        qgVar.qg = s(jsonReader);
                        break;
                    case "ee":
                        qgVar.s = s(jsonReader);
                        break;
                    case "pc":
                        qgVar.q = jsonReader.nextInt();
                        break;
                    case "cpf":
                        qg(jsonReader, qgVar);
                        break;
                    case "zip":
                        qgVar.fs = qg(jsonReader);
                        break;
                    case "events":
                        qgVar.rv = w(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0045  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static com.byazt.vk.q qg(JsonReader jsonReader) {
        String strNextString;
        String strNextString2;
        String strNextString3;
        String strNextString4;
        byte b;
        try {
            jsonReader.beginObject();
            strNextString = null;
            strNextString2 = null;
            strNextString3 = null;
            strNextString4 = null;
            while (jsonReader.hasNext()) {
                try {
                    String strNextName = jsonReader.nextName();
                    switch (strNextName.hashCode()) {
                        case -332625698:
                            if (!strNextName.equals("baseUrl")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        case 107902:
                            if (!strNextName.equals("md5")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 116079:
                            if (!strNextName.equals(ImagesContract.URL)) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 374523318:
                            if (!strNextName.equals("firstImageName")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        strNextString = jsonReader.nextString();
                    } else if (b == 1) {
                        strNextString2 = jsonReader.nextString();
                    } else if (b == 2) {
                        strNextString3 = jsonReader.nextString();
                    } else if (b == 3) {
                        strNextString4 = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                } catch (Exception unused) {
                }
            }
            jsonReader.endObject();
        } catch (Exception unused2) {
            strNextString = null;
            strNextString2 = null;
            strNextString3 = null;
            strNextString4 = null;
        }
        if (strNextString == null) {
            return null;
        }
        return new com.byazt.vk.q(strNextString, strNextString2, strNextString3, strNextString4);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    private static void qg(JsonReader jsonReader, com.byazt.pp.w.qg qgVar) {
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
                } else if (strNextName.equals("el")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    qgVar.l = jsonReader.nextInt();
                } else if (b == 1) {
                    qgVar.w = jsonReader.nextString();
                } else if (b == 2) {
                    qgVar.x = l(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException unused) {
        }
    }

    private static Map<String, Object> s(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "el":
                    map.put("el", jsonReader.nextString());
                    break;
                case "lel":
                    map.put("lel", l(jsonReader));
                    break;
                case "lottie_back":
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
                            } catch (JSONException unused) {
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
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

    /* JADX WARN: Code duplicated, block: B:47:0x00a5  */
    private static void n(JsonReader jsonReader, com.byazt.pp.w.q qVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "ke":
                        qVar.n = jsonReader.nextInt();
                        break;
                    case "id":
                        qVar.qg = jsonReader.nextString();
                        break;
                    case "tl":
                        qVar.s = jsonReader.nextString();
                        break;
                    case "at":
                        qVar.q = jsonReader.nextString();
                        break;
                    case "inel":
                        qVar.l = new int[]{-1, -1};
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                qVar.l[i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case "el":
                        qVar.w = jsonReader.nextString();
                        break;
                    case "lel":
                        qVar.x = l(jsonReader);
                        break;
                    case "begin_el":
                        qVar.fs = jsonReader.nextString();
                        break;
                    case "begin_lel":
                        qVar.rv = l(jsonReader);
                        break;
                    case "lo":
                        qVar.tj = jsonReader.nextInt();
                        break;
                    case "tp":
                        qVar.cp = jsonReader.nextInt();
                        break;
                    case "ids":
                        qVar.d = q(jsonReader);
                        break;
                    case "kp":
                        qVar.oa = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception unused) {
        }
    }

    private static String[] q(JsonReader jsonReader) {
        try {
            jsonReader.beginArray();
            String[] strArr = new String[3];
            for (int i = 0; i < 3; i++) {
                try {
                    if (jsonReader.hasNext()) {
                        strArr[i] = jsonReader.nextString();
                    }
                } catch (Exception unused) {
                    return strArr;
                }
            }
            jsonReader.endArray();
            return strArr;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void n(JsonReader jsonReader, com.byazt.pp.w wVar, List<com.byazt.eg.fs> list, LongSparseArray<com.byazt.eg.fs> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.byazt.eg.fs fsVarN = ou.n(jsonReader, wVar);
            if (fsVarN.cp() == com.byazt.eg.fs.n.IMAGE) {
                i++;
            }
            list.add(fsVarN);
            longSparseArray.put(fsVarN.l(), fsVarN);
            if (i > 4) {
                com.byazt.nu.w.qg("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    private static void n(JsonReader jsonReader, com.byazt.pp.w wVar, Map<String, List<com.byazt.eg.fs>> map, Map<String, com.byazt.pp.rv> map2) throws IOException {
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
            List<com.byazt.pp.rv.s> listX = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayL = null;
            String strNextString6 = null;
            String strNextString7 = null;
            com.byazt.pp.rv.n nVar = null;
            com.byazt.pp.rv.qg qgVar = null;
            String strW = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                strNextName.hashCode();
                switch (strNextName) {
                    case "events":
                        strW = w(jsonReader);
                        break;
                    case "layers":
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.byazt.eg.fs fsVarN = ou.n(jsonReader, wVar);
                            longSparseArray.put(fsVarN.l(), fsVarN);
                            arrayList.add(fsVarN);
                            iNextInt = iNextInt;
                        }
                        i = iNextInt;
                        jsonReader.endArray();
                        iNextInt = i;
                        break;
                    case "rotate":
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            i = iNextInt;
                            iNextInt = i;
                            break;
                        } else {
                            com.byazt.pp.rv.qg qgVar2 = new com.byazt.pp.rv.qg();
                            jsonReader.beginObject();
                            n(jsonReader, qgVar2);
                            jsonReader.endObject();
                            qgVar = qgVar2;
                            break;
                        }
                        break;
                    case "ugen_v":
                        strNextString7 = jsonReader.nextString();
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
                    case "el":
                        strNextString5 = jsonReader.nextString();
                        break;
                    case "id":
                        strNextString = jsonReader.nextString();
                        break;
                    case "rc":
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            i = iNextInt;
                            iNextInt = i;
                            break;
                        } else {
                            com.byazt.pp.rv.n nVar2 = new com.byazt.pp.rv.n();
                            jsonReader.beginObject();
                            n(jsonReader, nVar2);
                            jsonReader.endObject();
                            nVar = nVar2;
                            break;
                        }
                        break;
                    case "tc":
                        jsonReader.beginArray();
                        listX = x(jsonReader);
                        jsonReader.endArray();
                        break;
                    case "lel":
                        jSONArrayL = l(jsonReader);
                        break;
                    case "md5":
                        strNextString6 = jsonReader.nextString();
                        break;
                    case "rel":
                        strNextString4 = jsonReader.nextString();
                        break;
                    case "inel":
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
                com.byazt.pp.rv rvVar = new com.byazt.pp.rv(i3, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listX, strNextString5, iArr, jSONArrayL, strNextString6, strNextString7, nVar, qgVar, strW);
                map2.put(rvVar.d(), rvVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    private static JSONArray l(JsonReader jsonReader) {
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
                        jSONObject.put("vid", jsonReader.nextString());
                    } else if (b == 1) {
                        try {
                            jSONObject.put(LiveConfigKey.HIGH, jsonReader.nextInt());
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046  */
    private static String w(JsonReader jsonReader) {
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
                    if (iHashCode != 3551) {
                        if (iHashCode == 2069097 && strNextName.equals("handlers")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (strNextName.equals(DebugKt.DEBUG_PROPERTY_VALUE_ON)) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        jSONObject.put(DebugKt.DEBUG_PROPERTY_VALUE_ON, jsonReader.nextString());
                    } else if (b == 1) {
                        try {
                            JSONArray jSONArray2 = new JSONArray();
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                jSONArray2.put(jsonReader.nextString());
                            }
                            jsonReader.endArray();
                            jSONObject.put("handlers", jSONArray2);
                        } catch (JSONException unused) {
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception unused2) {
        }
        return jSONArray.length() > 0 ? jSONArray.toString() : "";
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f  */
    private static void n(JsonReader jsonReader, com.byazt.pp.rv.n nVar) {
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
                    nVar.qg = jsonReader.nextBoolean();
                } else if (b == 1) {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        nVar.n = new com.byazt.pp.rv.n.C0302n();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            if (((strNextName2.hashCode() == 114 && strNextName2.equals("r")) ? (byte) 0 : (byte) -1) == 0) {
                                nVar.n.n = (float) jsonReader.nextDouble();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                } else {
                    jsonReader.skipValue();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0032  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void n(JsonReader jsonReader, com.byazt.pp.rv.qg qgVar) {
        byte b;
        while (jsonReader.hasNext()) {
            try {
                String strNextName = jsonReader.nextName();
                switch (strNextName.hashCode()) {
                    case 120:
                        if (!strNextName.equals(com.byazt.af.x.n)) {
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
                    case 122:
                        if (!strNextName.equals("z")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b == 0) {
                    qgVar.n = jsonReader.nextInt();
                } else if (b == 1) {
                    qgVar.qg = jsonReader.nextInt();
                } else if (b == 2) {
                    qgVar.s = jsonReader.nextInt();
                } else {
                    jsonReader.skipValue();
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x00e9  */
    private static List<com.byazt.pp.rv.s> x(JsonReader jsonReader) {
        byte b;
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                com.byazt.pp.rv.s sVar = new com.byazt.pp.rv.s();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "l":
                            sVar.n = jsonReader.nextInt();
                            break;
                        case "le":
                            sVar.qg = jsonReader.nextInt();
                            break;
                        case "s":
                            sVar.w = jsonReader.nextInt();
                            break;
                        case "els":
                            sVar.x = jsonReader.nextString();
                            break;
                        case "c":
                            sVar.q = jsonReader.nextString();
                            break;
                        case "fcl":
                            sVar.s = jsonReader.nextString();
                            break;
                        case "bold":
                            sVar.fs = jsonReader.nextInt();
                            break;
                        case "f":
                            sVar.l = jsonReader.nextString();
                            break;
                        case "bs":
                            sVar.rv = jsonReader.nextInt();
                            break;
                        case "ali":
                            sVar.tj = jsonReader.nextString();
                            break;
                        case "ul":
                            sVar.cp = fs(jsonReader);
                            break;
                        case "st":
                            sVar.d = fs(jsonReader);
                            break;
                        case "ml":
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String strNextName = jsonReader.nextName();
                                int iHashCode = strNextName.hashCode();
                                if (iHashCode != 108) {
                                    if (iHashCode == 109 && strNextName.equals("m")) {
                                        b = 0;
                                    } else {
                                        b = -1;
                                    }
                                } else if (strNextName.equals(com.anythink.core.common.l.a)) {
                                    b = 1;
                                } else {
                                    b = -1;
                                }
                                if (b == 0) {
                                    sVar.oa = jsonReader.nextInt();
                                } else if (b == 1) {
                                    sVar.sz = jsonReader.nextInt();
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                arrayList.add(sVar);
            }
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    private static com.byazt.pp.rv.s.n fs(JsonReader jsonReader) {
        byte b;
        try {
            com.byazt.pp.rv.s.n nVar = new com.byazt.pp.rv.s.n();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                int iHashCode = strNextName.hashCode();
                if (iHashCode != 99) {
                    if (iHashCode == 3706 && strNextName.equals("tn")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strNextName.equals("c")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    nVar.n = jsonReader.nextInt();
                } else if (b == 1) {
                    nVar.qg = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            return nVar;
        } catch (Exception unused) {
            return null;
        }
    }

    private static void n(JsonReader jsonReader, Map<String, com.byazt.ld.s> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("list")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.byazt.ld.s sVarN = sz.n(jsonReader);
                    map.put(sVarN.qg(), sVarN);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }

    private static void n(JsonReader jsonReader, com.byazt.pp.w wVar, SparseArray<com.byazt.ld.q> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.byazt.ld.q qVarN = oa.n(jsonReader, wVar);
            sparseArray.put(qVarN.hashCode(), qVarN);
        }
        jsonReader.endArray();
    }

    private static void n(JsonReader jsonReader, List<com.byazt.ld.x> list) throws IOException {
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
            list.add(new com.byazt.ld.x(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
