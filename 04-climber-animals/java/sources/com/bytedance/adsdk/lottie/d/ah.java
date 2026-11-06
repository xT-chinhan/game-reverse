package com.bytedance.adsdk.lottie.d;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static com.bytedance.adsdk.lottie.model.ms.sl ms(JsonReader jsonReader, com.bytedance.adsdk.lottie.c cVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.bytedance.adsdk.lottie.model.ms.xr xrVar = null;
        com.bytedance.adsdk.lottie.model.ms.ka kaVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVarXr = null;
        com.bytedance.adsdk.lottie.model.ms.ab abVarD = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs2 = null;
        com.bytedance.adsdk.lottie.model.ms.d dVarXr = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs3 = null;
        com.bytedance.adsdk.lottie.model.ms.xr xrVarMs4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "a":
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals(com.kuaishou.weapon.p0.t.a)) {
                            kaVarMs = ms.ms(jsonReader, cVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                    break;
                case "o":
                    dVarXr = d.xr(jsonReader, cVar);
                    continue;
                    break;
                case "p":
                    zbVarXr = ms.xr(jsonReader, cVar);
                    continue;
                    break;
                case "r":
                    break;
                case "s":
                    abVarD = d.d(jsonReader, cVar);
                    continue;
                    break;
                case "eo":
                    xrVarMs4 = d.ms(jsonReader, cVar, false);
                    continue;
                    break;
                case "rz":
                    cVar.ms("Lottie doesn't support 3D layers.");
                    break;
                case "sa":
                    xrVarMs2 = d.ms(jsonReader, cVar, false);
                    continue;
                    break;
                case "sk":
                    xrVarMs = d.ms(jsonReader, cVar, false);
                    continue;
                    break;
                case "so":
                    xrVarMs3 = d.ms(jsonReader, cVar, false);
                    continue;
                    break;
                default:
                    jsonReader.skipValue();
                    continue;
                    break;
            }
            com.bytedance.adsdk.lottie.model.ms.xr xrVarMs5 = d.ms(jsonReader, cVar, false);
            if (xrVarMs5.ah().isEmpty()) {
                xrVarMs5.ah().add(new com.bytedance.adsdk.lottie.c.ms(cVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(cVar.ab())));
            } else if (((com.bytedance.adsdk.lottie.c.ms) xrVarMs5.ah().get(0)).f150ms == 0) {
                xrVarMs5.ah().set(0, new com.bytedance.adsdk.lottie.c.ms(cVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(cVar.ab())));
            }
            xrVar = xrVarMs5;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (ms(kaVarMs)) {
            kaVarMs = null;
        }
        return new com.bytedance.adsdk.lottie.model.ms.sl(kaVarMs, ms(zbVarXr) ? null : zbVarXr, ms(abVarD) ? null : abVarD, ms(xrVar) ? null : xrVar, dVarXr, xrVarMs3, xrVarMs4, xr(xrVarMs) ? null : xrVarMs, ah(xrVarMs2) ? null : xrVarMs2);
    }

    private static boolean ms(com.bytedance.adsdk.lottie.model.ms.ka kaVar) {
        if (kaVar != null) {
            return kaVar.xr() && kaVar.ah().get(0).f150ms.equals(0.0f, 0.0f);
        }
        return true;
    }

    private static boolean ms(com.bytedance.adsdk.lottie.model.ms.zb<PointF, PointF> zbVar) {
        if (zbVar != null) {
            return !(zbVar instanceof com.bytedance.adsdk.lottie.model.ms.ny) && zbVar.xr() && zbVar.ah().get(0).f150ms.equals(0.0f, 0.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean ms(com.bytedance.adsdk.lottie.model.ms.xr xrVar) {
        if (xrVar != null) {
            return xrVar.xr() && ((Float) ((com.bytedance.adsdk.lottie.c.ms) xrVar.ah().get(0)).f150ms).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean ms(com.bytedance.adsdk.lottie.model.ms.ab abVar) {
        if (abVar != null) {
            return abVar.xr() && ((com.bytedance.adsdk.lottie.c.d) ((com.bytedance.adsdk.lottie.c.ms) abVar.ah().get(0)).f150ms).xr(1.0f, 1.0f);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean xr(com.bytedance.adsdk.lottie.model.ms.xr xrVar) {
        if (xrVar != null) {
            return xrVar.xr() && ((Float) ((com.bytedance.adsdk.lottie.c.ms) xrVar.ah().get(0)).f150ms).floatValue() == 0.0f;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean ah(com.bytedance.adsdk.lottie.model.ms.xr xrVar) {
        if (xrVar != null) {
            return xrVar.xr() && ((Float) ((com.bytedance.adsdk.lottie.c.ms) xrVar.ah().get(0)).f150ms).floatValue() == 0.0f;
        }
        return true;
    }
}
