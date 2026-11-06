package com.mar.sdk.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.provider.Settings;
import com.mar.sdk.log.Log;
import com.mar.sdk.permission.utils.PermissionHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MARPermission {
    private static MARPermission instance;
    private Map<Integer, IPermissionResultListener> listenerMap = new HashMap();

    public static MARPermission getInstance() {
        if (instance == null) {
            instance = new MARPermission();
        }
        return instance;
    }

    private MARPermission() {
    }

    public boolean isOverMarshmallow() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public boolean isNeedAskPermission() {
        return isOverMarshmallow();
    }

    public boolean isNeedAskPermission(Activity context, String[] permissions) {
        List<String> deniedPermissions;
        return isNeedAskPermission() && (deniedPermissions = findDeniedPermissions(context, permissions)) != null && deniedPermissions.size() > 0;
    }

    public void requestPermissions(Activity context, int requestCode, String[] permissions, IPermissionResultListener listener) {
        if (!isNeedAskPermission(context, permissions)) {
            listener.onPermissionSuccess();
            return;
        }
        if (this.listenerMap.containsKey(Integer.valueOf(requestCode))) {
            listener.onPermissionCanceled();
            Log.e("MARSDK", "requestPermissions failed. requestCode already exists");
        } else {
            this.listenerMap.put(Integer.valueOf(requestCode), listener);
            List<String> deniedPermissions = findDeniedPermissions(context, permissions);
            requestPermissions(context, requestCode, deniedPermissions, listener);
        }
    }

    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        if (this.listenerMap.containsKey(Integer.valueOf(requestCode))) {
            IPermissionResultListener listener = this.listenerMap.get(Integer.valueOf(requestCode));
            onPermisionCheckResult(activity, requestCode, permissions, grantResults, listener);
        }
    }

    public static void requestWriteSetting(Activity context, IPermissionWriteSettingListener grantedListener) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (!Settings.System.canWrite(context)) {
                    grantedListener.onPermissionDenied();
                } else {
                    grantedListener.onPermissionGranted();
                }
                return;
            } catch (Exception e) {
                e.printStackTrace();
                grantedListener.onPermissionGranted();
                return;
            }
        }
        grantedListener.onPermissionGranted();
    }

    @TargetApi(23)
    private List<String> findDeniedPermissions(Activity activity, String... permission) {
        List<String> denyPermissions = new ArrayList<>();
        for (String value : permission) {
            if (!PermissionHelper.checkSelfPermission(activity, value)) {
                denyPermissions.add(value);
            }
        }
        Log.d("MARSDK", "findDeniedPermissions->curr denied permissions:");
        for (String p : denyPermissions) {
            Log.d("MARSDK", p);
        }
        Log.d("MARSDK", "findDeniedPermissions->end");
        return denyPermissions;
    }

    @TargetApi(23)
    private void onPermisionCheckResult(Activity context, int requestCode, String[] permissions, int[] grantResults, IPermissionResultListener listener) {
        try {
            this.listenerMap.remove(Integer.valueOf(requestCode));
            List<String> deniedPermissions = findDeniedPermissions(context, permissions);
            if (deniedPermissions.size() > 0) {
                List<String> deniedForeverPermissions = new ArrayList<>();
                for (String permission : deniedPermissions) {
                    if (!context.shouldShowRequestPermissionRationale(permission)) {
                        deniedForeverPermissions.add(permission);
                    }
                }
                listener.onPermissionFailed((String[]) deniedPermissions.toArray(new String[deniedPermissions.size()]), (String[]) deniedForeverPermissions.toArray(new String[deniedForeverPermissions.size()]));
                Log.d("MARSDK", "onPermissionCheckResult failed.");
                for (String p : deniedPermissions) {
                    Log.d("MARSDK", "permission " + p + " denied");
                }
                return;
            }
            listener.onPermissionSuccess();
        } catch (Exception e) {
            e.printStackTrace();
            this.listenerMap.remove(Integer.valueOf(requestCode));
            listener.onPermissionFailed(permissions, null);
        }
    }

    @TargetApi(23)
    private void requestPermissions(Activity context, int requestCode, List<String> permissions, IPermissionResultListener listener) {
        if (permissions == null || permissions.size() == 0) {
            this.listenerMap.remove(Integer.valueOf(requestCode));
            listener.onPermissionSuccess();
        } else {
            Log.d("MARSDK", "begin to request permissions . size:" + permissions.size());
            context.requestPermissions((String[]) permissions.toArray(new String[permissions.size()]), requestCode);
        }
    }
}
