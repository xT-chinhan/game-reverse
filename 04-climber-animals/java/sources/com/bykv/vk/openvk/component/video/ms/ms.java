package com.bykv.vk.openvk.component.video.ms;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.c.ah;
import com.bykv.vk.openvk.component.video.api.ms.xr;
import com.kwad.sdk.api.model.AdnName;
import com.tapsdk.tapad.constants.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ms {
    public static int ah = 10;
    public static int d = 10;
    private static xr ka = null;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static int f52ms = 10;
    public static int xr = 10;

    public static void ms(Context context) {
        com.bykv.vk.openvk.component.video.api.c.ms.ms(context);
    }

    public static void ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            f52ms = jSONObject.optInt("splash", 10);
            xr = jSONObject.optInt(Constants.AdTypeName.REWARD, 10);
            ah = jSONObject.optInt("brand", 10);
            int iOptInt = jSONObject.optInt(AdnName.OTHER, 10);
            d = iOptInt;
            if (f52ms < 0) {
                f52ms = 10;
            }
            if (xr < 0) {
                xr = 10;
            }
            if (ah < 0) {
                ah = 10;
            }
            if (iOptInt < 0) {
                d = 10;
            }
            ah.ms("MediaConfig", "splash=", Integer.valueOf(f52ms), ",reward=", Integer.valueOf(xr), ",brand=", Integer.valueOf(ah), ",other=", Integer.valueOf(d));
        } catch (Throwable th) {
            ah.ah("MediaConfig", th.getMessage());
        }
    }

    public static void ms(xr xrVar) {
        ka = xrVar;
    }

    public static void ms() {
        xr xrVar = ka;
        if (xrVar != null) {
            xrVar.ka();
        }
    }

    public static int xr() {
        return f52ms;
    }

    public static int ah() {
        return xr;
    }

    public static int d() {
        return ah;
    }

    public static int ka() {
        return d;
    }
}
