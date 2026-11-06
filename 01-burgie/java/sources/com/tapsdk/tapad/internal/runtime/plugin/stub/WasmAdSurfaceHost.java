package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.SurfaceSession;
import com.tapsdk.tapad.internal.runtime.WasmModule;
import com.tapsdk.tapad.internal.runtime.plugin.AdCallbackListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class WasmAdSurfaceHost {
    private static final String TAG = "WasmAdSurfaceHost";

    /* JADX INFO: renamed from: com.tapsdk.tapad.internal.runtime.plugin.stub.WasmAdSurfaceHost$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tapsdk$tapad$internal$runtime$plugin$stub$WasmAdSurfaceHost$SurfaceKind;

        static {
            int[] iArr = new int[SurfaceKind.values().length];
            $SwitchMap$com$tapsdk$tapad$internal$runtime$plugin$stub$WasmAdSurfaceHost$SurfaceKind = iArr;
            try {
                iArr[SurfaceKind.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$runtime$plugin$stub$WasmAdSurfaceHost$SurfaceKind[SurfaceKind.PORTRAIT_TRANSLUCENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$runtime$plugin$stub$WasmAdSurfaceHost$SurfaceKind[SurfaceKind.LANDSCAPE_TRANSLUCENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tapsdk$tapad$internal$runtime$plugin$stub$WasmAdSurfaceHost$SurfaceKind[SurfaceKind.PORTRAIT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum SurfaceKind {
        PORTRAIT,
        LANDSCAPE,
        PORTRAIT_TRANSLUCENT,
        LANDSCAPE_TRANSLUCENT
    }

    private WasmAdSurfaceHost() {
    }

    public static boolean attach(Context context, int i, int i2, String str) {
        SurfaceSession live;
        if (context == null || i < 0) {
            return false;
        }
        if (i2 > 0) {
            return InlineAdSurfaceHost.attach(i, i2);
        }
        boolean z = context instanceof Activity;
        if ((z && !isActivityUsable((Activity) context)) || (live = DirichletRuntime.getInstance().surfaceSessions().getLive(i)) == null) {
            return false;
        }
        Intent intent = new Intent(context, selectActivityClass(parseSurfaceKind(live.config().surfaceKind)));
        if (!z) {
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
        }
        intent.putExtra(BaseAdActivity.EXTRA_INSTANCE_ID, live.instanceId());
        intent.putExtra(BaseAdActivity.EXTRA_SURFACE_ID, i);
        context.startActivity(intent);
        return true;
    }

    public static int create(Context context, int i, WasmModule wasmModule, Object obj, AdCallbackListener adCallbackListener, String str) {
        if (context == null || wasmModule == null || i < 0) {
            throw new IllegalArgumentException("invalid wasm ad surface request");
        }
        JSONObject json = parseJson(str);
        SurfaceKind surface = parseSurface(json);
        String wasmEntry = parseWasmEntry(json);
        BaseAdActivity.AdActivityConfig config = parseConfig(json);
        config.surfaceKind = surface.name();
        return DirichletRuntime.getInstance().createSurfaceSession(i, wasmModule, obj, wasmEntry, config, adCallbackListener);
    }

    private static boolean firstBoolean(JSONObject jSONObject, boolean z, String... strArr) {
        Object objFirstValue = firstValue(jSONObject, strArr);
        if (objFirstValue instanceof Boolean) {
            return ((Boolean) objFirstValue).booleanValue();
        }
        if (objFirstValue instanceof Number) {
            return ((Number) objFirstValue).intValue() != 0;
        }
        if (objFirstValue != null) {
            String strTrim = String.valueOf(objFirstValue).trim();
            if ("1".equals(strTrim) || "true".equalsIgnoreCase(strTrim)) {
                return true;
            }
            if ("0".equals(strTrim) || "false".equalsIgnoreCase(strTrim)) {
                return false;
            }
        }
        return z;
    }

    private static int firstColor(JSONObject jSONObject, int i, String... strArr) {
        Object objFirstValue = firstValue(jSONObject, strArr);
        if (objFirstValue instanceof Number) {
            return ((Number) objFirstValue).intValue();
        }
        if (objFirstValue != null) {
            String strTrim = String.valueOf(objFirstValue).trim();
            if (!TextUtils.isEmpty(strTrim)) {
                try {
                    if (!strTrim.startsWith("0x") && !strTrim.startsWith("0X")) {
                        return Color.parseColor(strTrim);
                    }
                    return (int) Long.parseLong(strTrim.substring(2), 16);
                } catch (Exception e) {
                }
            }
        }
        return i;
    }

    private static String firstString(JSONObject jSONObject, String... strArr) {
        Object objFirstValue = firstValue(jSONObject, strArr);
        return objFirstValue == null ? "" : String.valueOf(objFirstValue);
    }

    private static Object firstValue(JSONObject jSONObject, String... strArr) {
        if (jSONObject == null) {
            return null;
        }
        for (String str : strArr) {
            if (jSONObject.has(str)) {
                return jSONObject.opt(str);
            }
        }
        return null;
    }

    public static boolean isActivityUsable(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean openInternalWebView(Context context, String str, AdType adType) {
        return InternalWebViewCallbackActuator.open(context, str, adType, -1, -1);
    }

    private static AdType parseAdType(JSONObject jSONObject) {
        return AdType.fromWireName(firstString(jSONObject, "ad_type", "adType", "type"));
    }

    private static BaseAdActivity.AdActivityConfig parseConfig(JSONObject jSONObject) {
        BaseAdActivity.AdActivityConfig adActivityConfigFullscreenDefault = BaseAdActivity.AdActivityConfig.fullscreenDefault();
        adActivityConfigFullscreenDefault.hideStatusBar = firstBoolean(jSONObject, adActivityConfigFullscreenDefault.hideStatusBar, "hide_status_bar", "hideStatusBar");
        adActivityConfigFullscreenDefault.hideNavigationBar = firstBoolean(jSONObject, adActivityConfigFullscreenDefault.hideNavigationBar, "hide_navigation_bar", "hideNavigationBar");
        adActivityConfigFullscreenDefault.enableNotchSupport = firstBoolean(jSONObject, adActivityConfigFullscreenDefault.enableNotchSupport, "enable_notch_support", "enableNotchSupport");
        adActivityConfigFullscreenDefault.keepScreenOn = firstBoolean(jSONObject, adActivityConfigFullscreenDefault.keepScreenOn, "keep_screen_on", "keepScreenOn");
        adActivityConfigFullscreenDefault.statusBarColor = firstColor(jSONObject, adActivityConfigFullscreenDefault.statusBarColor, "status_bar_color", "statusBarColor");
        adActivityConfigFullscreenDefault.navigationBarColor = firstColor(jSONObject, adActivityConfigFullscreenDefault.navigationBarColor, "navigation_bar_color", "navigationBarColor");
        adActivityConfigFullscreenDefault.containerBackgroundColor = firstColor(jSONObject, adActivityConfigFullscreenDefault.containerBackgroundColor, "container_background_color", "containerBackgroundColor");
        adActivityConfigFullscreenDefault.adType = parseAdType(jSONObject);
        return adActivityConfigFullscreenDefault;
    }

    private static JSONObject parseJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            return new JSONObject();
        }
    }

    private static SurfaceKind parseSurface(JSONObject jSONObject) {
        SurfaceKind surfaceKind = SurfaceKind.PORTRAIT;
        Object objFirstValue = firstValue(jSONObject, "surface", "surface_kind", "surfaceKind");
        SurfaceKind surfaceValue = parseSurfaceValue(objFirstValue, surfaceKind);
        if (surfaceValue != surfaceKind || objFirstValue != null) {
            return surfaceValue;
        }
        boolean zFirstBoolean = firstBoolean(jSONObject, false, "translucent", "is_translucent", "isTranslucent");
        String strFirstString = firstString(jSONObject, "screen_orientation", "screenOrientation", "orientation");
        if ("landscape".equalsIgnoreCase(strFirstString) || "1".equals(strFirstString)) {
            return zFirstBoolean ? SurfaceKind.LANDSCAPE_TRANSLUCENT : SurfaceKind.LANDSCAPE;
        }
        if ("portrait".equalsIgnoreCase(strFirstString) || "2".equals(strFirstString)) {
            if (zFirstBoolean) {
                return SurfaceKind.PORTRAIT_TRANSLUCENT;
            }
        } else if (zFirstBoolean) {
            return SurfaceKind.PORTRAIT_TRANSLUCENT;
        }
        return surfaceKind;
    }

    private static SurfaceKind parseSurfaceKind(String str) {
        if (TextUtils.isEmpty(str)) {
            return SurfaceKind.PORTRAIT;
        }
        try {
            return SurfaceKind.valueOf(str);
        } catch (IllegalArgumentException e) {
            return SurfaceKind.PORTRAIT;
        }
    }

    private static SurfaceKind parseSurfaceValue(Object obj, SurfaceKind surfaceKind) {
        if (obj instanceof Number) {
            switch (((Number) obj).intValue()) {
                case 1:
                    return SurfaceKind.PORTRAIT;
                case 2:
                    return SurfaceKind.LANDSCAPE;
                case 3:
                    return SurfaceKind.PORTRAIT_TRANSLUCENT;
                case 4:
                    return SurfaceKind.LANDSCAPE_TRANSLUCENT;
            }
        }
        if (obj != null) {
            String lowerCase = String.valueOf(obj).trim().toLowerCase();
            if ("portrait".equals(lowerCase) || "portrait_opaque".equals(lowerCase)) {
                return SurfaceKind.PORTRAIT;
            }
            if ("landscape".equals(lowerCase) || "landscape_opaque".equals(lowerCase)) {
                return SurfaceKind.LANDSCAPE;
            }
            if ("portrait_translucent".equals(lowerCase) || "portraittranslucent".equals(lowerCase)) {
                return SurfaceKind.PORTRAIT_TRANSLUCENT;
            }
            if ("landscape_translucent".equals(lowerCase) || "landscapetranslucent".equals(lowerCase)) {
                return SurfaceKind.LANDSCAPE_TRANSLUCENT;
            }
        }
        return surfaceKind;
    }

    private static String parseWasmEntry(JSONObject jSONObject) {
        String strFirstString = firstString(jSONObject, "entry", "wasm_entry", "wasmEntry", "function");
        return TextUtils.isEmpty(strFirstString) ? "ad_render" : strFirstString;
    }

    private static Class<? extends Activity> selectActivityClass(SurfaceKind surfaceKind) {
        int i = AnonymousClass1.$SwitchMap$com$tapsdk$tapad$internal$runtime$plugin$stub$WasmAdSurfaceHost$SurfaceKind[surfaceKind.ordinal()];
        if (i == 1) {
            return LandscapeActivity.class;
        }
        if (i != 2) {
            return i != 3 ? PortraitActivity.class : LandscapeTranslucentActivity.class;
        }
        return PortraitTranslucentActivity.class;
    }
}
