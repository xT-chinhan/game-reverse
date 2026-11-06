package com.tapsdk.tapad.internal.runtime.plugin.stub;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.tapsdk.tapad.internal.AdType;
import com.tapsdk.tapad.internal.runtime.DirichletRuntime;
import com.tapsdk.tapad.internal.runtime.plugin.WebViewDialogFragment;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class InternalWebViewCallbackActuator {
    static final String CALLBACK_NAME = "open_internal_webview";
    private static final String FRAGMENT_TAG_PREFIX = "dirichlet_internal_webview_";
    private static final String TAG = "InternalWebViewActuator";

    private InternalWebViewCallbackActuator() {
    }

    private static void dispatchOpenResult(int i, int i2, int i3, boolean z, int i4) {
        if (i3 <= 0) {
            return;
        }
        int i5 = !z ? 1 : 0;
        if (!z) {
            i4 = -1;
        }
        int i6 = i4;
        DirichletRuntime dirichletRuntime = DirichletRuntime.getInstance();
        if (i <= 0 || i2 <= 0) {
            dirichletRuntime.triggerInteractionEvent(i5, i3, i6);
        } else {
            dirichletRuntime.triggerInteractionEvent(i, i2, i5, i3, i6);
        }
    }

    private static Activity findActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                break;
            }
            context = baseContext;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return null;
    }

    private static String fragmentTag(int i, int i2) {
        return FRAGMENT_TAG_PREFIX + i + "_" + i2;
    }

    public static boolean handles(String str) {
        return CALLBACK_NAME.equals(str);
    }

    private static boolean isUsable(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static boolean open(Context context, String str, AdType adType, int i, int i2) {
        int iOptInt;
        WebViewDialogFragment webViewDialogFragmentBuildInternalWebViewDialog;
        boolean z = false;
        int i3 = -1;
        try {
            if (str == null) {
                str = "{}";
            }
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(BreakpointSQLiteKey.URL, "");
            iOptInt = jSONObject.optInt("sessionId", -1);
            try {
                i = ownedId(jSONObject.optInt("instanceId", -1), i);
                i2 = ownedId(jSONObject.optInt("surfaceId", -1), i2);
                if (i > 0) {
                    jSONObject.put("instanceId", i);
                }
                if (i2 > 0) {
                    jSONObject.put("surfaceId", i2);
                }
                boolean z2 = true;
                try {
                    Activity activityFindActivity = findActivity(context);
                    if (!TextUtils.isEmpty(strOptString) && isUsable(activityFindActivity) && (webViewDialogFragmentBuildInternalWebViewDialog = BaseAdActivity.buildInternalWebViewDialog(jSONObject, adType, i, i2)) != null) {
                        String strFragmentTag = fragmentTag(i2, iOptInt);
                        if (!(activityFindActivity.getFragmentManager().findFragmentByTag(strFragmentTag) instanceof WebViewDialogFragment)) {
                            webViewDialogFragmentBuildInternalWebViewDialog.show(activityFindActivity.getFragmentManager(), strFragmentTag);
                        }
                        i3 = 2;
                        z = true;
                    }
                } catch (Throwable th) {
                }
                if (z || !openExternal(context, strOptString)) {
                    z2 = z;
                } else {
                    i3 = 1;
                }
                dispatchOpenResult(i, i2, iOptInt, z2, i3);
                return z2;
            } catch (Throwable th2) {
                dispatchOpenResult(i, i2, iOptInt, false, -1);
                return false;
            }
        } catch (Throwable th3) {
            iOptInt = -1;
        }
    }

    private static boolean openExternal(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
                if (!(context instanceof Activity)) {
                    intent.addFlags(C.ENCODING_PCM_MU_LAW);
                }
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
            }
        }
        return false;
    }

    private static int ownedId(int i, int i2) {
        return i2 > 0 ? i2 : i;
    }
}
