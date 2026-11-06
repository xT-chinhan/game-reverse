package com.bytedance.adsdk.lottie.d;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.ek;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static com.bytedance.adsdk.lottie.model.layer.x ms(com.bytedance.adsdk.lottie.c cVar) {
        Rect rectD = cVar.d();
        return new com.bytedance.adsdk.lottie.model.layer.x(Collections.emptyList(), cVar, "__container", -1L, com.bytedance.adsdk.lottie.model.layer.x.ms.PRE_COMP, -1L, null, Collections.emptyList(), new com.bytedance.adsdk.lottie.model.ms.sl(), 0, 0, 0, 0.0f, 0.0f, rectD.width(), rectD.height(), null, null, Collections.emptyList(), com.bytedance.adsdk.lottie.model.layer.x.xr.NONE, null, false, null, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.lottie.model.layer.x ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        com.bytedance.adsdk.lottie.model.layer.x.xr xrVar = com.bytedance.adsdk.lottie.model.layer.x.xr.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        com.bytedance.adsdk.lottie.model.layer.x.xr xrVar2 = xrVar;
        com.bytedance.adsdk.lottie.model.layer.x.ms msVar = null;
        String strNextString = null;
        com.bytedance.adsdk.lottie.model.ms.sl slVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.ch chVarC = null;
        com.bytedance.adsdk.lottie.model.ms.hi hiVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.xr.ms msVarMs = null;
        ch chVarMs = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fAb = 0.0f;
        long jNextInt2 = -1;
        float fNextDouble4 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        float fNextDouble5 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals("h")) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals(bv.aI)) {
                        b = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        b = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals("ef")) {
                        b = 6;
                    }
                    break;
                case 3324:
                    if (strNextName.equals(LiveConfigKey.HIGH)) {
                        b = 7;
                    }
                    break;
                case 3367:
                    if (strNextName.equals("ip")) {
                        b = 8;
                    }
                    break;
                case 3432:
                    if (strNextName.equals(MediationConstant.ADN_KS)) {
                        b = 9;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 10;
                    }
                    break;
                case 3553:
                    if (strNextName.equals("op")) {
                        b = 11;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 12;
                    }
                    break;
                case 3669:
                    if (strNextName.equals("sh")) {
                        b = ek.k;
                    }
                    break;
                case 3679:
                    if (strNextName.equals("sr")) {
                        b = ek.l;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b = ek.m;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = ek.n;
                    }
                    break;
                case 3705:
                    if (strNextName.equals("tm")) {
                        b = 17;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        b = 18;
                    }
                    break;
                case 3717:
                    if (strNextName.equals("ty")) {
                        b = 19;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = 20;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = 21;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = 22;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.xr.ah ahVarMs = x.ms(jsonReader, cVar);
                        if (ahVarMs != null) {
                            arrayList2.add(ahVarMs);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.lottie.ka.ny.ms()));
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                hiVarMs = xr.ms(jsonReader, cVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (strNextName2.equals("d")) {
                            chVarC = d.c(jsonReader, cVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) com.bytedance.adsdk.lottie.ka.ny.ms()));
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (strNextName3.equals("ty")) {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    msVarMs = ka.ms(jsonReader, cVar);
                                } else if (iNextInt3 == 25) {
                                    chVarMs = new hi().ms(jsonReader, cVar);
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    cVar.ms("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    break;
                case 9:
                    slVarMs = ah.ms(jsonReader, cVar);
                    break;
                case 10:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 11:
                    fAb = (float) jsonReader.nextDouble();
                    break;
                case 12:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 13:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.ka.ny.ms());
                    break;
                case 14:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    iNextInt = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.ka.ny.ms());
                    break;
                case 17:
                    xrVarMs = d.ms(jsonReader, cVar, false);
                    break;
                case 18:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= com.bytedance.adsdk.lottie.model.layer.x.xr.values().length) {
                        cVar.ms("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    } else {
                        xrVar2 = com.bytedance.adsdk.lottie.model.layer.x.xr.values()[iNextInt4];
                        int i = AnonymousClass1.f153ms[xrVar2.ordinal()];
                        if (i == 1) {
                            cVar.ms("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            cVar.ms("Unsupported matte type: Luma Inverted");
                        }
                        cVar.ms(1);
                    }
                    break;
                case 19:
                    int iNextInt5 = jsonReader.nextInt();
                    if (iNextInt5 < com.bytedance.adsdk.lottie.model.layer.x.ms.UNKNOWN.ordinal()) {
                        msVar = com.bytedance.adsdk.lottie.model.layer.x.ms.values()[iNextInt5];
                    } else {
                        msVar = com.bytedance.adsdk.lottie.model.layer.x.ms.UNKNOWN;
                    }
                    break;
                case 20:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 21:
                    strNextString = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(i.ms(jsonReader, cVar));
                    }
                    cVar.ms(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble5 > 0.0f) {
            arrayList4.add(new com.bytedance.adsdk.lottie.c.ms(cVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble5)));
        }
        if (fAb <= 0.0f) {
            fAb = cVar.ab();
        }
        arrayList4.add(new com.bytedance.adsdk.lottie.c.ms(cVar, fValueOf2, fValueOf2, null, fNextDouble5, Float.valueOf(fAb)));
        arrayList4.add(new com.bytedance.adsdk.lottie.c.ms(cVar, fValueOf, fValueOf, null, fAb, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            cVar.ms("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.lottie.model.layer.x(arrayList2, cVar, strNextString2, jNextInt, msVar, jNextInt2, strNextString, arrayList, slVarMs, iNextInt, iNextInt2, color, fNextDouble4, fNextDouble, fNextDouble2, fNextDouble3, chVarC, hiVarMs, arrayList4, xrVar2, xrVarMs, zNextBoolean, msVarMs, chVarMs);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.d.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f153ms;

        static {
            int[] iArr = new int[com.bytedance.adsdk.lottie.model.layer.x.xr.values().length];
            f153ms = iArr;
            try {
                iArr[com.bytedance.adsdk.lottie.model.layer.x.xr.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f153ms[com.bytedance.adsdk.lottie.model.layer.x.xr.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
