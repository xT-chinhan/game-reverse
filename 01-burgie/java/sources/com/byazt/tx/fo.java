package com.byazt.tx;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.d;
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
@com.byazt.vzx.pr(pr = {0, 1, 1587, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS})
public class fo {
    public static com.byazt.dx.uc pr(JsonReader jsonReader) throws IOException {
        float fPr = com.byazt.ptr.vk.pr();
        LongSparseArray<com.byazt.cg.zo> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.byazt.uxi.x> sparseArray = new SparseArray<>();
        com.byazt.dx.uc.x xVar = new com.byazt.dx.uc.x();
        com.byazt.dx.uc.hw hwVar = new com.byazt.dx.uc.hw();
        com.byazt.dx.uc.hn hnVar = new com.byazt.dx.uc.hn();
        com.byazt.dx.uc.pr prVar = new com.byazt.dx.uc.pr();
        com.byazt.dx.uc ucVar = new com.byazt.dx.uc();
        jsonReader.beginObject();
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        String strNextString = null;
        int iNextInt = 0;
        float fNextDouble3 = 0.0f;
        int iNextInt2 = 0;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -1408207997:
                    fPr = fPr;
                    if (strNextName.equals("assets")) {
                        b = 8;
                    }
                    break;
                case -1109732030:
                    fPr = fPr;
                    if (strNextName.equals("layers")) {
                        b = 6;
                    }
                    break;
                case -865448777:
                    fPr = fPr;
                    if (strNextName.equals("globalEvent")) {
                        b = cc.l;
                    }
                    break;
                case 104:
                    fPr = fPr;
                    if (strNextName.equals(an.aG)) {
                        b = 1;
                    }
                    break;
                case 118:
                    fPr = fPr;
                    if (strNextName.equals(an.aE)) {
                        b = 5;
                    }
                    break;
                case 119:
                    fPr = fPr;
                    if (strNextName.equals("w")) {
                        b = 0;
                    }
                    break;
                case 3208:
                    fPr = fPr;
                    if (strNextName.equals("dl")) {
                        b = cc.k;
                    }
                    break;
                case 3276:
                    fPr = fPr;
                    if (strNextName.equals("fr")) {
                        b = 4;
                    }
                    break;
                case 3292:
                    fPr = fPr;
                    if (strNextName.equals("gc")) {
                        b = cc.m;
                    }
                    break;
                case 3367:
                    fPr = fPr;
                    if (strNextName.equals("ip")) {
                        b = 2;
                    }
                    break;
                case 3553:
                    fPr = fPr;
                    if (strNextName.equals("op")) {
                        b = 3;
                    }
                    break;
                case 3002509:
                    fPr = fPr;
                    if (strNextName.equals("area")) {
                        b = 7;
                    }
                    break;
                case 94623709:
                    fPr = fPr;
                    if (strNextName.equals("chars")) {
                        b = 10;
                    }
                    break;
                case 97615364:
                    fPr = fPr;
                    if (strNextName.equals("fonts")) {
                        b = 9;
                    }
                    break;
                case 110364485:
                    fPr = fPr;
                    if (strNextName.equals("timer")) {
                        b = 12;
                    }
                    break;
                case 839250809:
                    fPr = fPr;
                    if (strNextName.equals("markers")) {
                        b = 11;
                    }
                    break;
                default:
                    fPr = fPr;
                    break;
            }
            switch (b) {
                case 0:
                    iNextInt2 = jsonReader.nextInt();
                    continue;
                case 1:
                    iNextInt = jsonReader.nextInt();
                    continue;
                case 2:
                    ucVar = ucVar;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                case 3:
                    fNextDouble = ((float) jsonReader.nextDouble()) - 0.01f;
                    ucVar = ucVar;
                    continue;
                case 4:
                    ucVar = ucVar;
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                case 5:
                    String[] strArrSplit = jsonReader.nextString().split("\\.");
                    if (!com.byazt.ptr.vk.pr(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        ucVar.pr("Lottie only supports bodymovin >= 4.4.0");
                    }
                    break;
                case 6:
                    pr(jsonReader, ucVar, arrayList, longSparseArray);
                    break;
                case 7:
                    pr(jsonReader, prVar);
                    break;
                case 8:
                    pr(jsonReader, ucVar, map, map2);
                    break;
                case 9:
                    pr(jsonReader, map3);
                    break;
                case 10:
                    pr(jsonReader, ucVar, sparseArray);
                    break;
                case 11:
                    pr(jsonReader, arrayList2);
                    break;
                case 12:
                    pr(jsonReader, xVar);
                    break;
                case 13:
                    strNextString = jsonReader.nextString();
                    continue;
                case 14:
                    pr(jsonReader, hnVar);
                    break;
                case 15:
                    pr(jsonReader, hwVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            ucVar = ucVar;
        }
        float f = fPr;
        com.byazt.dx.uc ucVar2 = ucVar;
        jsonReader.endObject();
        ucVar2.pr(new Rect(0, 0, (int) (iNextInt2 * f), (int) (iNextInt * f)), fNextDouble3, fNextDouble, fNextDouble2, arrayList, longSparseArray, map, map2, sparseArray, map3, arrayList2, xVar, strNextString, hwVar, hnVar, prVar);
        return ucVar2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    private static void pr(JsonReader jsonReader, com.byazt.dx.uc.pr prVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "x":
                        prVar.pr = jsonReader.nextString();
                        break;
                    case "y":
                        prVar.hw = jsonReader.nextString();
                        break;
                    case "w":
                        prVar.hn = jsonReader.nextString();
                        break;
                    case "h":
                        prVar.x = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    private static void pr(JsonReader jsonReader, com.byazt.dx.uc.hn hnVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "inel":
                        hnVar.hw = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i = 0; i < 2; i++) {
                                if (jsonReader.hasNext()) {
                                    hnVar.hw[0][i] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    case "el":
                        hnVar.pr = jsonReader.nextString();
                        break;
                    case "lel":
                        hnVar.hn = c(jsonReader);
                        break;
                    case "events":
                        hnVar.c = uc(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    private static void pr(JsonReader jsonReader, com.byazt.dx.uc.hw hwVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "se":
                        hwVar.pr = jsonReader.nextInt();
                        break;
                    case "be":
                        hwVar.hw = hn(jsonReader);
                        break;
                    case "ee":
                        hwVar.hn = hn(jsonReader);
                        break;
                    case "pc":
                        hwVar.x = jsonReader.nextInt();
                        break;
                    case "cpf":
                        hw(jsonReader, hwVar);
                        break;
                    case "zip":
                        hwVar.zo = hw(jsonReader);
                        break;
                    case "events":
                        hwVar.aj = uc(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:9:0x001e  */
    private static com.byazt.rwn.x hw(JsonReader jsonReader) {
        String strNextString;
        String strNextString2;
        String strNextString3;
        String strNextString4;
        try {
            jsonReader.beginObject();
            strNextString = null;
            strNextString2 = null;
            strNextString3 = null;
            strNextString4 = null;
            while (jsonReader.hasNext()) {
                try {
                    switch (jsonReader.nextName()) {
                        case "url":
                            strNextString = jsonReader.nextString();
                            break;
                        case "baseUrl":
                            strNextString2 = jsonReader.nextString();
                            break;
                        case "md5":
                            strNextString3 = jsonReader.nextString();
                            break;
                        case "firstImageName":
                            strNextString4 = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                } catch (Exception e) {
                }
            }
            jsonReader.endObject();
        } catch (Exception e2) {
            strNextString = null;
            strNextString2 = null;
            strNextString3 = null;
            strNextString4 = null;
        }
        if (strNextString == null) {
            return null;
        }
        return new com.byazt.rwn.x(strNextString, strNextString2, strNextString3, strNextString4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    private static void hw(JsonReader jsonReader, com.byazt.dx.uc.hw hwVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "fr":
                        hwVar.c = jsonReader.nextInt();
                        break;
                    case "el":
                        hwVar.uc = jsonReader.nextString();
                        break;
                    case "lel":
                        hwVar.fw = c(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
        }
    }

    private static Map<String, Object> hn(JsonReader jsonReader) throws IOException {
        HashMap map = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "lottie_back":
                    JSONObject jSONObject = new JSONObject();
                    map.put("lottie_back", jSONObject);
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        switch (jsonReader.nextName()) {
                            case "hd":
                                try {
                                    jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                                    jSONObject.putOpt("vid", "lottie_back");
                                    break;
                                } catch (JSONException e) {
                                    break;
                                }
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case "lel":
                    map.put("lel", c(jsonReader));
                    break;
                case "el":
                    map.put("el", jsonReader.nextString());
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    private static void pr(JsonReader jsonReader, com.byazt.dx.uc.x xVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "ke":
                        xVar.pr = jsonReader.nextInt();
                        break;
                    case "id":
                        xVar.hw = jsonReader.nextString();
                        break;
                    case "tl":
                        xVar.hn = jsonReader.nextString();
                        break;
                    case "at":
                        xVar.x = jsonReader.nextString();
                        break;
                    case "inel":
                        xVar.c = new int[]{-1, -1};
                        jsonReader.beginArray();
                        for (int i = 0; i < 2; i++) {
                            if (jsonReader.hasNext()) {
                                xVar.c[i] = jsonReader.nextInt();
                            }
                        }
                        jsonReader.endArray();
                        break;
                    case "el":
                        xVar.uc = jsonReader.nextString();
                        break;
                    case "lel":
                        xVar.fw = c(jsonReader);
                        break;
                    case "begin_el":
                        xVar.zo = jsonReader.nextString();
                        break;
                    case "begin_lel":
                        xVar.aj = c(jsonReader);
                        break;
                    case "lo":
                        xVar.vk = jsonReader.nextInt();
                        break;
                    case "tp":
                        xVar.w = jsonReader.nextInt();
                        break;
                    case "ids":
                        xVar.k = x(jsonReader);
                        break;
                    case "kp":
                        xVar.m = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
        } catch (Exception e) {
        }
    }

    private static String[] x(JsonReader jsonReader) {
        try {
            jsonReader.beginArray();
            String[] strArr = new String[3];
            for (int i = 0; i < 3; i++) {
                try {
                    if (jsonReader.hasNext()) {
                        strArr[i] = jsonReader.nextString();
                    }
                } catch (Exception e) {
                    return strArr;
                }
            }
            jsonReader.endArray();
            return strArr;
        } catch (Exception e2) {
            return null;
        }
    }

    private static void pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, List<com.byazt.cg.zo> list, LongSparseArray<com.byazt.cg.zo> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            com.byazt.cg.zo zoVarPr = ny.pr(jsonReader, ucVar);
            if (zoVarPr.w() == com.byazt.cg.zo.pr.IMAGE) {
                i++;
            }
            list.add(zoVarPr);
            longSparseArray.put(zoVarPr.c(), zoVarPr);
            if (i > 4) {
                com.byazt.ptr.uc.hw("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x00fe  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, Map<String, List<com.byazt.cg.zo>> map, Map<String, com.byazt.dx.aj> map2) throws IOException {
        byte b;
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
            List<com.byazt.dx.aj.hn> listFw = null;
            String strNextString5 = null;
            int[][] iArr = null;
            JSONArray jSONArrayC = null;
            String strNextString6 = null;
            String strNextString7 = null;
            com.byazt.dx.aj.pr prVar = null;
            com.byazt.dx.aj.hw hwVar = null;
            String strUc = null;
            int iNextInt = 0;
            int iNextInt2 = 0;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                switch (strNextName.hashCode()) {
                    case -1291329255:
                        if (strNextName.equals(d.ar)) {
                            b = cc.m;
                        } else {
                            b = -1;
                        }
                        break;
                    case -1109732030:
                        if (strNextName.equals("layers")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                        break;
                    case -925180581:
                        if (strNextName.equals("rotate")) {
                            b = cc.l;
                        } else {
                            b = -1;
                        }
                        break;
                    case -847116302:
                        if (strNextName.equals("ugen_v")) {
                            b = 10;
                        } else {
                            b = -1;
                        }
                        break;
                    case 104:
                        if (strNextName.equals(an.aG)) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                        break;
                    case 112:
                        if (strNextName.equals(an.ax)) {
                            b = 4;
                        } else {
                            b = -1;
                        }
                        break;
                    case 117:
                        if (strNextName.equals(an.aH)) {
                            b = 5;
                        } else {
                            b = -1;
                        }
                        break;
                    case 119:
                        if (strNextName.equals("w")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                        break;
                    case 3239:
                        if (strNextName.equals("el")) {
                            b = 11;
                        } else {
                            b = -1;
                        }
                        break;
                    case 3355:
                        if (strNextName.equals("id")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                        break;
                    case 3633:
                        if (strNextName.equals("rc")) {
                            b = 7;
                        } else {
                            b = -1;
                        }
                        break;
                    case 3695:
                        if (strNextName.equals("tc")) {
                            b = 6;
                        } else {
                            b = -1;
                        }
                        break;
                    case 107027:
                        if (strNextName.equals("lel")) {
                            b = cc.k;
                        } else {
                            b = -1;
                        }
                        break;
                    case 107902:
                        if (strNextName.equals("md5")) {
                            b = 9;
                        } else {
                            b = -1;
                        }
                        break;
                    case 112793:
                        if (strNextName.equals("rel")) {
                            b = 8;
                        } else {
                            b = -1;
                        }
                        break;
                    case 3237004:
                        if (strNextName.equals("inel")) {
                            b = 12;
                        } else {
                            b = -1;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                        strNextString = jsonReader.nextString();
                        break;
                    case 1:
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            com.byazt.cg.zo zoVarPr = ny.pr(jsonReader, ucVar);
                            longSparseArray.put(zoVarPr.c(), zoVarPr);
                            arrayList.add(zoVarPr);
                            iNextInt = iNextInt;
                        }
                        i = iNextInt;
                        jsonReader.endArray();
                        iNextInt = i;
                        break;
                    case 2:
                        iNextInt = jsonReader.nextInt();
                        break;
                    case 3:
                        iNextInt2 = jsonReader.nextInt();
                        break;
                    case 4:
                        strNextString2 = jsonReader.nextString();
                        break;
                    case 5:
                        strNextString3 = jsonReader.nextString();
                        break;
                    case 6:
                        jsonReader.beginArray();
                        listFw = fw(jsonReader);
                        jsonReader.endArray();
                        break;
                    case 7:
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            i = iNextInt;
                            iNextInt = i;
                        } else {
                            com.byazt.dx.aj.pr prVar2 = new com.byazt.dx.aj.pr();
                            jsonReader.beginObject();
                            pr(jsonReader, prVar2);
                            jsonReader.endObject();
                            prVar = prVar2;
                        }
                        break;
                    case 8:
                        strNextString4 = jsonReader.nextString();
                        break;
                    case 9:
                        strNextString6 = jsonReader.nextString();
                        break;
                    case 10:
                        strNextString7 = jsonReader.nextString();
                        break;
                    case 11:
                        strNextString5 = jsonReader.nextString();
                        break;
                    case 12:
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
                    case 13:
                        jSONArrayC = c(jsonReader);
                        break;
                    case 14:
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            i = iNextInt;
                            iNextInt = i;
                        } else {
                            com.byazt.dx.aj.hw hwVar2 = new com.byazt.dx.aj.hw();
                            jsonReader.beginObject();
                            pr(jsonReader, hwVar2);
                            jsonReader.endObject();
                            hwVar = hwVar2;
                        }
                        break;
                    case 15:
                        strUc = uc(jsonReader);
                        break;
                    default:
                        i = iNextInt;
                        jsonReader.skipValue();
                        iNextInt = i;
                        break;
                }
            }
            int i3 = iNextInt;
            jsonReader.endObject();
            if (strNextString2 != null) {
                com.byazt.dx.aj ajVar = new com.byazt.dx.aj(i3, iNextInt2, strNextString, strNextString2, strNextString3, strNextString4, listFw, strNextString5, iArr, jSONArrayC, strNextString6, strNextString7, prVar, hwVar, strUc);
                map2.put(ajVar.k(), ajVar);
            } else {
                map.put(strNextString, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static JSONArray c(JsonReader jsonReader) {
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "vid":
                            try {
                                jSONObject.put("vid", jsonReader.nextString());
                                break;
                            } catch (JSONException e) {
                                break;
                            }
                            break;
                        case "hd":
                            try {
                                jSONObject.put(LiveConfigKey.HIGH, jsonReader.nextInt());
                                break;
                            } catch (JSONException e2) {
                                break;
                            }
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e3) {
        }
        return jSONArray;
    }

    private static String uc(JsonReader jsonReader) {
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "on":
                            try {
                                jSONObject.put(DebugKt.DEBUG_PROPERTY_VALUE_ON, jsonReader.nextString());
                                break;
                            } catch (JSONException e) {
                                break;
                            }
                            break;
                        case "handlers":
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    jSONArray2.put(jsonReader.nextString());
                                }
                                jsonReader.endArray();
                                jSONObject.put("handlers", jSONArray2);
                                break;
                            } catch (JSONException e2) {
                                break;
                            }
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e3) {
        }
        return jSONArray.length() > 0 ? jSONArray.toString() : "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    private static void pr(JsonReader jsonReader, com.byazt.dx.aj.pr prVar) {
        while (jsonReader.hasNext()) {
            try {
                switch (jsonReader.nextName()) {
                    case "is_secondary":
                        prVar.hw = jsonReader.nextBoolean();
                        break;
                    case "gs":
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            break;
                        } else {
                            prVar.pr = new com.byazt.dx.aj.pr.C0046pr();
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                switch (jsonReader.nextName()) {
                                    case "r":
                                        prVar.pr.pr = (float) jsonReader.nextDouble();
                                        break;
                                    default:
                                        jsonReader.skipValue();
                                        break;
                                }
                            }
                            jsonReader.endObject();
                            break;
                        }
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x0012  */
    private static void pr(JsonReader jsonReader, com.byazt.dx.aj.hw hwVar) {
        while (jsonReader.hasNext()) {
            try {
                switch (jsonReader.nextName()) {
                    case "x":
                        hwVar.pr = jsonReader.nextInt();
                        break;
                    case "y":
                        hwVar.hw = jsonReader.nextInt();
                        break;
                    case "z":
                        hwVar.hn = jsonReader.nextInt();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x00d1  */
    private static List<com.byazt.dx.aj.hn> fw(JsonReader jsonReader) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                com.byazt.dx.aj.hn hnVar = new com.byazt.dx.aj.hn();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    switch (jsonReader.nextName()) {
                        case "l":
                            hnVar.pr = jsonReader.nextInt();
                            break;
                        case "le":
                            hnVar.hw = jsonReader.nextInt();
                            break;
                        case "s":
                            hnVar.uc = jsonReader.nextInt();
                            break;
                        case "els":
                            hnVar.fw = jsonReader.nextString();
                            break;
                        case "c":
                            hnVar.x = jsonReader.nextString();
                            break;
                        case "fcl":
                            hnVar.hn = jsonReader.nextString();
                            break;
                        case "bold":
                            hnVar.zo = jsonReader.nextInt();
                            break;
                        case "f":
                            hnVar.c = jsonReader.nextString();
                            break;
                        case "bs":
                            hnVar.aj = jsonReader.nextInt();
                            break;
                        case "ali":
                            hnVar.vk = jsonReader.nextString();
                            break;
                        case "ul":
                            hnVar.w = zo(jsonReader);
                            break;
                        case "st":
                            hnVar.k = zo(jsonReader);
                            break;
                        case "ml":
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                switch (jsonReader.nextName()) {
                                    case "m":
                                        hnVar.m = jsonReader.nextInt();
                                        break;
                                    case "l":
                                        hnVar.g = jsonReader.nextInt();
                                        break;
                                    default:
                                        jsonReader.skipValue();
                                        break;
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
                arrayList.add(hnVar);
            }
            return arrayList;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    private static com.byazt.dx.aj.hn.pr zo(JsonReader jsonReader) {
        try {
            com.byazt.dx.aj.hn.pr prVar = new com.byazt.dx.aj.hn.pr();
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "tn":
                        prVar.pr = jsonReader.nextInt();
                        break;
                    case "c":
                        prVar.hw = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            return prVar;
        } catch (Exception e) {
            return null;
        }
    }

    private static void pr(JsonReader jsonReader, Map<String, com.byazt.uxi.hn> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            switch (jsonReader.nextName()) {
                case "list":
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.byazt.uxi.hn hnVarPr = g.pr(jsonReader);
                        map.put(hnVarPr.hw(), hnVarPr);
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
    }

    private static void pr(JsonReader jsonReader, com.byazt.dx.uc ucVar, SparseArray<com.byazt.uxi.x> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.byazt.uxi.x xVarPr = m.pr(jsonReader, ucVar);
            sparseArray.put(xVarPr.hashCode(), xVarPr);
        }
        jsonReader.endArray();
    }

    private static void pr(JsonReader jsonReader, List<com.byazt.uxi.fw> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            String strNextString = null;
            jsonReader.beginObject();
            float fNextDouble = 0.0f;
            float fNextDouble2 = 0.0f;
            while (jsonReader.hasNext()) {
                switch (jsonReader.nextName()) {
                    case "cm":
                        strNextString = jsonReader.nextString();
                        break;
                    case "tm":
                        fNextDouble = (float) jsonReader.nextDouble();
                        break;
                    case "dr":
                        fNextDouble2 = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.byazt.uxi.fw(strNextString, fNextDouble, fNextDouble2));
        }
        jsonReader.endArray();
    }
}
