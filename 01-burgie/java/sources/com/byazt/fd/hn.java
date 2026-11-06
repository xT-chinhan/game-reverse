package com.byazt.fd;

import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatViewInflater;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.dea.uc;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 43, 20})
public class hn {
    /* JADX WARN: Multi-variable type inference failed */
    public static void pr(hw hwVar, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            uc.c(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            hwVar.zeusSuperOnCreate(null);
            hwVar.finish();
            return;
        }
        Intent intent = hwVar.getIntent();
        String pluginPkgName = hwVar.getPluginPkgName();
        Plugin plugin = hwVar.getPlugin();
        if (plugin == null) {
            uc.c(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            hwVar.zeusSuperOnCreate(null);
            hwVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.pr(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(hwVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (!plugin.isLoaded() || TextUtils.isEmpty(stringExtra)) {
            try {
                hwVar.zeusSuperOnCreate(null);
                ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                hwVar.finish();
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            hwVar.zeusSuperOnCreate(null);
            hwVar.finish();
            pr(stringExtra, "activityInfo null", plugin);
            return;
        }
        try {
            IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            FieldUtils.writeField(iPluginActivity, "mApplication", hwVar.getApplication());
            hwVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(hwVar, plugin);
            hwVar.zeusSuperSetTheme(activityInfo.theme);
            TypedArray typedArrayObtainStyledAttributes = ((Activity) hwVar).getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
            if (typedArrayObtainStyledAttributes.getBoolean(typedArrayObtainStyledAttributes.getIndex(0), false)) {
                pr((Activity) hwVar);
            }
            typedArrayObtainStyledAttributes.recycle();
            iPluginActivity.attachBaseContext(hwVar.getBaseContext());
            try {
                if (((Activity) hwVar).getRequestedOrientation() != activityInfo.screenOrientation) {
                    ((Activity) hwVar).setRequestedOrientation(activityInfo.screenOrientation);
                }
            } catch (IllegalStateException e2) {
            }
            iPluginActivity.onCreate(bundle);
        } catch (Exception e3) {
            pr(stringExtra, Log.getStackTraceString(e3), plugin);
        }
    }

    private static void pr(String str, String str2, Plugin plugin) {
        try {
            com.byazt.wp.pr reporter = GlobalParam.getInstance().getReporter();
            if (reporter != null && plugin != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("t_act", str);
                jSONObject.putOpt("p_pkg", plugin.mPkgName);
                jSONObject.putOpt("p_vc", Integer.valueOf(plugin.getVersion()));
                jSONObject.putOpt("p_avc", Integer.valueOf(plugin.getApiVersionCode()));
                jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str2);
                reporter.pr(com.byazt.yk.hw.w, jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    public static void pr(hw hwVar, Context context) {
        if (!Zeus.hasInit()) {
            uc.c(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            hwVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = hwVar.getPluginPkgName();
        boolean zLoadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            hwVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (zLoadPlugin) {
                hwVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(hwVar, "mResources", (Object) null);
            } else {
                hwVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void pr(Activity activity, View view) {
        Object field;
        if (view == null) {
            return;
        }
        try {
            Object field2 = FieldUtils.readField(view, "mListenerInfo");
            if (field2 != null && (field = FieldUtils.readField(field2, "mOnClickListener")) != null) {
                String name = field.getClass().getName();
                if (name.startsWith(AppCompatViewInflater.class.getName()) || name.startsWith(View.class.getName())) {
                    view.setOnClickListener(new pr(activity, view.getId(), (String) FieldUtils.readField(field, "mMethodName")));
                }
            }
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            uc.pr(e);
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    pr(activity, viewGroup.getChildAt(i));
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static Class pr() {
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void pr(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", pr(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
        } catch (Throwable th) {
        }
    }
}
