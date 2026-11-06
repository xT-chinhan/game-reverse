package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ny implements e<com.bytedance.adsdk.lottie.model.xr> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ny f158ms = new ny();

    private ny() {
    }

    @Override // com.bytedance.adsdk.lottie.d.e
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.lottie.model.xr xr(JsonReader jsonReader, float f) throws IOException {
        com.bytedance.adsdk.lottie.model.xr.ms msVar = com.bytedance.adsdk.lottie.model.xr.ms.CENTER;
        jsonReader.beginObject();
        com.bytedance.adsdk.lottie.model.xr.ms msVar2 = msVar;
        String strNextString = null;
        String strNextString2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iMs = 0;
        int iMs2 = 0;
        boolean zNextBoolean = true;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "f":
                    strNextString2 = jsonReader.nextString();
                    break;
                case "j":
                    int iNextInt2 = jsonReader.nextInt();
                    if (iNextInt2 > com.bytedance.adsdk.lottie.model.xr.ms.CENTER.ordinal() || iNextInt2 < 0) {
                        msVar2 = com.bytedance.adsdk.lottie.model.xr.ms.CENTER;
                        break;
                    } else {
                        msVar2 = com.bytedance.adsdk.lottie.model.xr.ms.values()[iNextInt2];
                        break;
                    }
                    break;
                case "s":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "t":
                    strNextString = jsonReader.nextString();
                    break;
                case "fc":
                    iMs = y.ms(jsonReader);
                    break;
                case "lh":
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    break;
                case "ls":
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    break;
                case "of":
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case "ps":
                    jsonReader.beginArray();
                    PointF pointF3 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF = pointF3;
                    break;
                case "sc":
                    iMs2 = y.ms(jsonReader);
                    break;
                case "sw":
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case "sz":
                    jsonReader.beginArray();
                    PointF pointF4 = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
                    jsonReader.endArray();
                    pointF2 = pointF4;
                    break;
                case "tr":
                    iNextInt = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.bytedance.adsdk.lottie.model.xr(strNextString, strNextString2, fNextDouble, msVar2, iNextInt, fNextDouble2, fNextDouble3, iMs, iMs2, fNextDouble4, zNextBoolean, pointF, pointF2);
    }
}
