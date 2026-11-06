package com.byazt.tx;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1587, 36})
public class ny {
    public static com.byazt.cg.zo pr(com.byazt.dx.uc ucVar) {
        Rect rectX = ucVar.x();
        return new com.byazt.cg.zo(Collections.emptyList(), ucVar, "__container", -1L, com.byazt.cg.zo.pr.PRE_COMP, -1L, null, Collections.emptyList(), new com.byazt.eqw.k(), 0, 0, 0, 0.0f, 0.0f, rectX.width(), rectX.height(), null, null, Collections.emptyList(), com.byazt.cg.zo.hw.NONE, null, false, null, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:104:0x020e  */
    /* JADX WARN: Code duplicated, block: B:130:0x027f  */
    /* JADX WARN: Code duplicated, block: B:77:0x017e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v107 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v51 */
    public static com.byazt.cg.zo pr(JsonReader jsonReader, com.byazt.dx.uc ucVar) throws IOException {
        ArrayList arrayList;
        ?? r1;
        ?? r2;
        com.byazt.cg.zo.hw hwVar = com.byazt.cg.zo.hw.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(1.0f);
        boolean z = false;
        Float fValueOf2 = Float.valueOf(0.0f);
        com.byazt.cg.zo.hw hwVar2 = hwVar;
        float fNextDouble = 1.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        com.byazt.cg.zo.pr prVar = null;
        String strNextString = null;
        com.byazt.eqw.k kVarPr = null;
        com.byazt.eqw.vk vkVarUc = null;
        com.byazt.eqw.w wVarPr = null;
        com.byazt.eqw.hw hwVarPr = null;
        com.byazt.ynb.pr prVarPr = null;
        vk vkVarPr = null;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        float fNextDouble5 = 0.0f;
        float fFw = 0.0f;
        long jNextInt = -1;
        long jNextInt2 = 0;
        String strNextString2 = null;
        String strNextString3 = "UNSET";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (!strNextName.equals("parent")) {
                        r1 = -1;
                    } else {
                        r1 = 4;
                    }
                    break;
                case -903568142:
                    if (!strNextName.equals("shapes")) {
                        r1 = -1;
                    } else {
                        r1 = 11;
                    }
                    break;
                case 104:
                    if (!strNextName.equals(an.aG)) {
                        r1 = -1;
                    } else {
                        r1 = 17;
                    }
                    break;
                case 116:
                    if (!strNextName.equals(an.aI)) {
                        r1 = -1;
                    } else {
                        r1 = 12;
                    }
                    break;
                case 119:
                    if (!strNextName.equals("w")) {
                        r1 = -1;
                    } else {
                        r1 = 16;
                    }
                    break;
                case 3177:
                    if (!strNextName.equals("cl")) {
                        r1 = -1;
                    } else {
                        r1 = 21;
                    }
                    break;
                case 3233:
                    if (!strNextName.equals("ef")) {
                        r1 = -1;
                    } else {
                        r1 = 13;
                    }
                    break;
                case 3324:
                    if (!strNextName.equals(LiveConfigKey.HIGH)) {
                        r1 = -1;
                    } else {
                        r1 = 22;
                    }
                    break;
                case 3367:
                    if (!strNextName.equals("ip")) {
                        r1 = -1;
                    } else {
                        r1 = 18;
                    }
                    break;
                case 3432:
                    if (!strNextName.equals(MediationConstant.ADN_KS)) {
                        r1 = -1;
                    } else {
                        r1 = 8;
                    }
                    break;
                case 3519:
                    if (!strNextName.equals("nm")) {
                        r1 = -1;
                    } else {
                        r1 = z;
                    }
                    break;
                case 3553:
                    if (!strNextName.equals("op")) {
                        r1 = -1;
                    } else {
                        r1 = 19;
                    }
                    break;
                case 3664:
                    if (!strNextName.equals("sc")) {
                        r1 = -1;
                    } else {
                        r1 = 7;
                    }
                    break;
                case 3669:
                    if (!strNextName.equals("sh")) {
                        r1 = -1;
                    } else {
                        r1 = 6;
                    }
                    break;
                case 3679:
                    if (!strNextName.equals("sr")) {
                        r1 = -1;
                    } else {
                        r1 = 14;
                    }
                    break;
                case 3681:
                    if (!strNextName.equals("st")) {
                        r1 = -1;
                    } else {
                        r1 = 15;
                    }
                    break;
                case 3684:
                    if (!strNextName.equals("sw")) {
                        r1 = -1;
                    } else {
                        r1 = 5;
                    }
                    break;
                case 3705:
                    if (!strNextName.equals("tm")) {
                        r1 = -1;
                    } else {
                        r1 = 20;
                    }
                    break;
                case 3712:
                    if (!strNextName.equals("tt")) {
                        r1 = -1;
                    } else {
                        r1 = 9;
                    }
                    break;
                case 3717:
                    if (!strNextName.equals("ty")) {
                        r1 = -1;
                    } else {
                        r1 = 3;
                    }
                    break;
                case 104415:
                    if (!strNextName.equals("ind")) {
                        r1 = -1;
                    } else {
                        r1 = 1;
                    }
                    break;
                case 108390670:
                    if (!strNextName.equals("refId")) {
                        r1 = -1;
                    } else {
                        r1 = 2;
                    }
                    break;
                case 1441620890:
                    if (!strNextName.equals("masksProperties")) {
                        r1 = -1;
                    } else {
                        r1 = 10;
                    }
                    break;
                default:
                    r1 = -1;
                    break;
            }
            switch (r1) {
                case 0:
                    strNextString3 = jsonReader.nextString();
                    z = false;
                    continue;
                case 1:
                    jNextInt2 = jsonReader.nextInt();
                    z = false;
                    continue;
                case 2:
                    strNextString = jsonReader.nextString();
                    z = false;
                    continue;
                case 3:
                    int iNextInt3 = jsonReader.nextInt();
                    if (iNextInt3 < com.byazt.cg.zo.pr.UNKNOWN.ordinal()) {
                        prVar = com.byazt.cg.zo.pr.values()[iNextInt3];
                        z = false;
                    } else {
                        prVar = com.byazt.cg.zo.pr.UNKNOWN;
                        z = false;
                        continue;
                    }
                    break;
                case 4:
                    jNextInt = jsonReader.nextInt();
                    z = false;
                    continue;
                case 5:
                    iNextInt = (int) (jsonReader.nextInt() * com.byazt.ptr.vk.pr());
                    z = false;
                    continue;
                case 6:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.byazt.ptr.vk.pr());
                    z = false;
                    continue;
                case 7:
                    color = Color.parseColor(jsonReader.nextString());
                    z = false;
                    continue;
                case 8:
                    kVarPr = hn.pr(jsonReader, ucVar);
                    z = false;
                    continue;
                case 9:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= com.byazt.cg.zo.hw.values().length) {
                        ucVar.pr("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    } else {
                        hwVar2 = com.byazt.cg.zo.hw.values()[iNextInt4];
                        switch (AnonymousClass1.pr[hwVar2.ordinal()]) {
                            case 1:
                                ucVar.pr("Unsupported matte type: Luma");
                                break;
                            case 2:
                                ucVar.pr("Unsupported matte type: Luma Inverted");
                                break;
                        }
                        ucVar.pr(1);
                        z = false;
                    }
                    break;
                case 10:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList2.add(rc.pr(jsonReader, ucVar));
                    }
                    ucVar.pr(arrayList2.size());
                    jsonReader.endArray();
                    break;
                case 11:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.byazt.ynb.hn hnVarPr = zo.pr(jsonReader, ucVar);
                        if (hnVarPr != null) {
                            arrayList3.add(hnVarPr);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 12:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        switch (jsonReader.nextName()) {
                            case "d":
                                vkVarUc = x.uc(jsonReader, ucVar);
                                break;
                            case "a":
                                jsonReader.beginArray();
                                if (jsonReader.hasNext()) {
                                    wVarPr = hw.pr(jsonReader, ucVar);
                                }
                                while (jsonReader.hasNext()) {
                                    jsonReader.skipValue();
                                }
                                jsonReader.endArray();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    z = false;
                    continue;
                case 13:
                    jsonReader.beginArray();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            switch (strNextName2.hashCode()) {
                                case 3519:
                                    if (!strNextName2.equals("nm")) {
                                        r2 = -1;
                                    } else {
                                        r2 = 1;
                                    }
                                    break;
                                case 3717:
                                    if (!strNextName2.equals("ty")) {
                                        r2 = -1;
                                    } else {
                                        r2 = z;
                                    }
                                    break;
                                default:
                                    r2 = -1;
                                    break;
                            }
                            switch (r2) {
                                case 0:
                                    int iNextInt5 = jsonReader.nextInt();
                                    if (iNextInt5 == 29) {
                                        prVarPr = c.pr(jsonReader, ucVar);
                                        z = false;
                                    } else if (iNextInt5 == 25) {
                                        vkVarPr = new w().pr(jsonReader, ucVar);
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    break;
                                case 1:
                                    arrayList4.add(jsonReader.nextString());
                                    z = false;
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    z = false;
                                    break;
                            }
                        }
                        jsonReader.endObject();
                        z = false;
                    }
                    jsonReader.endArray();
                    ucVar.pr("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList4)));
                    z = false;
                    continue;
                case 14:
                    fNextDouble = (float) jsonReader.nextDouble();
                    continue;
                case 15:
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    continue;
                case 16:
                    fNextDouble4 = (float) (jsonReader.nextDouble() * ((double) com.byazt.ptr.vk.pr()));
                    continue;
                case 17:
                    fNextDouble5 = (float) (jsonReader.nextDouble() * ((double) com.byazt.ptr.vk.pr()));
                    continue;
                case 18:
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    continue;
                case 19:
                    fFw = (float) jsonReader.nextDouble();
                    continue;
                case 20:
                    hwVarPr = x.pr(jsonReader, ucVar, z);
                    continue;
                case 21:
                    strNextString2 = jsonReader.nextString();
                    continue;
                case 22:
                    zNextBoolean = jsonReader.nextBoolean();
                    continue;
                default:
                    jsonReader.skipValue();
                    break;
            }
            z = false;
        }
        jsonReader.endObject();
        ArrayList arrayList5 = new ArrayList();
        if (fNextDouble2 > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new com.byazt.cz.pr(ucVar, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(fNextDouble2)));
        } else {
            arrayList = arrayList5;
        }
        if (fFw <= 0.0f) {
            fFw = ucVar.fw();
        }
        arrayList.add(new com.byazt.cz.pr(ucVar, fValueOf, fValueOf, null, fNextDouble2, Float.valueOf(fFw)));
        arrayList.add(new com.byazt.cz.pr(ucVar, fValueOf2, fValueOf2, null, fFw, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString3.endsWith(".ai") || "ai".equals(strNextString2)) {
            ucVar.pr("Convert your Illustrator layers to shape layers.");
        }
        return new com.byazt.cg.zo(arrayList3, ucVar, strNextString3, jNextInt2, prVar, jNextInt, strNextString, arrayList2, kVarPr, iNextInt, iNextInt2, color, fNextDouble, fNextDouble3, fNextDouble4, fNextDouble5, vkVarUc, wVarPr, arrayList, hwVar2, hwVarPr, zNextBoolean, prVarPr, vkVarPr);
    }

    /* JADX INFO: renamed from: com.byazt.tx.ny$1, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1587, 88})
    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.cg.zo.hw.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.cg.zo.hw.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.cg.zo.hw.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
