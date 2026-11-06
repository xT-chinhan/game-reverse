package com.tapsdk.tapad;

import android.content.Context;
import com.tapsdk.tapad.internal.AdnRuntimeBootstrap;
import com.tapsdk.tapad.internal.Constants;
import com.tapsdk.tapad.internal.WasmUserActionReporter;
import com.tapsdk.tapad.internal.storage.SafeSP;
import com.tapsdk.tapad.internal.utils.ActivityUtil;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import com.tapsdk.tapad.internal.utils.PermissionUtil;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class TapAdManager {

    public static final class TapAdManagerHolder {
        private static final TapAdManager HOLDER = new TapAdManager();

        private TapAdManagerHolder() {
        }
    }

    public static TapAdManager get() {
        return TapAdManagerHolder.HOLDER;
    }

    public static void initializeHost(Context context, TapAdConfig tapAdConfig) {
        if (tapAdConfig == null) {
            return;
        }
        GUIDHelper.INSTANCE.init(context);
        AdnRuntimeBootstrap.getInstance().start(context, tapAdConfig);
    }

    public TapAdNative createAdNative(Context context) {
        return new TapAdNativeImpl(context);
    }

    public void requestPermissionIfNecessary(Context context, boolean z) {
        if (!z) {
            requestPermissionIfNecessary(context);
            return;
        }
        SafeSP sp = SafeSP.getSP(Constants.CacheKeys.PREFERENCES_NAME);
        if (sp == null) {
            requestPermissionIfNecessary(context);
            return;
        }
        Object obj = sp.getAll().get(Constants.CacheKeys.PERMISSION_REQUESTED);
        boolean z2 = obj instanceof Boolean;
        if (!(z2 ? ((Boolean) obj).booleanValue() : Boolean.parseBoolean(String.valueOf(obj)))) {
            requestPermissionIfNecessary(context);
            sp.putBoolean(Constants.CacheKeys.PERMISSION_REQUESTED, true);
        } else {
            if (z2) {
                return;
            }
            sp.putBoolean(Constants.CacheKeys.PERMISSION_REQUESTED, true);
        }
    }

    public void uploadUserAction(UserAction[] userActionArr, Callback callback) {
        WasmUserActionReporter.submit(userActionArr, callback);
    }

    private TapAdManager() {
    }

    public void requestPermissionIfNecessary(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : Arrays.asList("android.permission.READ_PHONE_STATE", "android.permission.ACCESS_COARSE_LOCATION")) {
            if (!PermissionUtil.checkPermission(context, str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            try {
                PermissionUtil.requestPermissions(ActivityUtil.getActivity(context), arrayList);
            } catch (Throwable th) {
                th.toString();
            }
        }
    }
}
