package com.mar.sdk.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Xml;
import com.mar.sdk.MARSDK;
import com.mar.sdk.SDKTools;
import com.mar.sdk.log.Log;
import com.mar.sdk.permission.utils.PermissionPageUtils;
import com.mar.sdk.utils.StoreUtils;
import com.taptap.sdk.db.constant.Common;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class MARAutoPermission implements IPermissionResultListener {
    private static final int CODE_MAR_PERMISSION = 20151001;
    private static MARAutoPermission instance;
    private Activity context;
    private IAutoPermissionListener listener;
    private IPermissionLifeCycle permissionLifeCycle;
    private Map<String, MARPermissionInfo> permissions;
    private String protocolOrientation;
    private String protocolUrl;
    private String userAgreementUrl;
    private boolean loaded = false;
    private boolean autoPermission = false;
    private boolean directPermission = true;
    private boolean needWriteSetting = false;
    private boolean jumpingPermission = false;
    private boolean jumpingWriteSettings = false;
    private boolean showPermissionDialog = true;

    private MARAutoPermission() {
    }

    public static MARAutoPermission getInstance() {
        if (instance == null) {
            instance = new MARAutoPermission();
        }
        return instance;
    }

    public IPermissionLifeCycle getPermissionLifeCycle() {
        return this.permissionLifeCycle;
    }

    public void setPermissionLifeCycle(IPermissionLifeCycle callback) {
        this.permissionLifeCycle = callback;
    }

    public void init(Context context) {
        if (!this.loaded) {
            this.permissions = loadPermissions(context);
            this.loaded = true;
        }
    }

    public void requestDangerousPermissions(final Activity context, final IAutoPermissionListener listener) {
        if (!this.loaded) {
            init(context);
        }
        final List<String> ps = getDangerousPermissions();
        if (this.showPermissionDialog && !StoreUtils.getBoolean(context, "mar_permission_dialog_showed", false)) {
            Log.d("MARSDK", "mar protocol url configed. now to show protocol dialog.");
            MARPermissionDialog.showDialog(context, isAutoProtocol(), this.protocolUrl, this.userAgreementUrl, this.protocolOrientation, new ArrayList(this.permissions.values()), new IProtocolListener() { // from class: com.mar.sdk.permission.MARAutoPermission.1
                @Override // com.mar.sdk.permission.IProtocolListener
                public void onAgreed() {
                    StoreUtils.putBoolean(context, "mar_permission_dialog_showed", true);
                    MARAutoPermission.this.doRequestDangerousPermissions(context, ps, listener);
                    MARSDK.getInstance().onResult(121, "agree permission");
                }
            });
        } else {
            Log.d("MARSDK", "mar protocol url not configed. don't show protocol dialog.");
            doRequestDangerousPermissions(context, ps, listener);
        }
    }

    public String getProtocolOrientation() {
        return this.protocolOrientation;
    }

    public String getProtocolUrl() {
        return this.protocolUrl;
    }

    public String getUserAgreementUrl() {
        return this.userAgreementUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestDangerousPermissions(Activity context, List<String> ps, IAutoPermissionListener listener) {
        this.context = context;
        this.listener = listener;
        this.jumpingPermission = false;
        this.jumpingWriteSettings = false;
        requestPermissions((String[]) ps.toArray(new String[ps.size()]));
    }

    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == CODE_MAR_PERMISSION) {
            Log.d("MARSDK", "MARAutoPermission: onRequestPermissionsResult called.");
            MARPermission.getInstance().onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
        }
    }

    private List<String> getDangerousPermissions() {
        List<String> result = new ArrayList<>();
        if (this.permissions != null) {
            for (MARPermissionInfo p : this.permissions.values()) {
                result.add(p.getName());
            }
        }
        return result;
    }

    private Map<String, MARPermissionInfo> loadPermissions(Context context) throws Throwable {
        String xmlPlugins = SDKTools.getAssetConfigs(context, "mar_permissions.xml");
        if (xmlPlugins == null) {
            Log.e("MARSDK", "fail to load mar_permissions.xml");
            this.showPermissionDialog = false;
            return null;
        }
        XmlPullParser parser = Xml.newPullParser();
        Map<String, MARPermissionInfo> permissionList = new HashMap<>();
        try {
            parser.setInput(new StringReader(xmlPlugins));
            for (int eventType = parser.getEventType(); eventType != 1; eventType = parser.next()) {
                switch (eventType) {
                    case 2:
                        String tag = parser.getName();
                        if ("permission".equals(tag)) {
                            String name = parser.getAttributeValue(null, Common.System.NAME);
                            String cname = parser.getAttributeValue(null, "cname");
                            String group = parser.getAttributeValue(null, "group");
                            MARPermissionInfo permissionInfo = new MARPermissionInfo(name, cname, group);
                            permissionList.put(name, permissionInfo);
                            Log.d("MARSDK", "load a dangerous permission: " + name + "; group:" + group);
                        } else if ("permissions".equals(tag)) {
                            String writeSettings = parser.getAttributeValue(null, "writeSettings");
                            if (!TextUtils.isEmpty(writeSettings)) {
                                try {
                                    Log.d("MARSDK", "sdk current need write settings permission:" + writeSettings);
                                    this.needWriteSetting = Boolean.valueOf(writeSettings).booleanValue();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            String showDialog = parser.getAttributeValue(null, "showPermissionDialog");
                            if (!TextUtils.isEmpty(showDialog) && "true".equalsIgnoreCase(showDialog)) {
                                this.showPermissionDialog = true;
                            } else {
                                this.showPermissionDialog = false;
                            }
                            String directPermissionStr = parser.getAttributeValue(null, "directPermission");
                            if (!TextUtils.isEmpty(directPermissionStr) && "true".equalsIgnoreCase(directPermissionStr)) {
                                this.directPermission = true;
                            } else {
                                this.directPermission = false;
                            }
                            this.protocolUrl = parser.getAttributeValue(null, "protocolUrl");
                            this.userAgreementUrl = parser.getAttributeValue(null, "userAgreementUrl");
                            this.protocolOrientation = parser.getAttributeValue(null, "protocolOrientation");
                            break;
                        }
                        break;
                }
            }
            return permissionList;
        } catch (IOException e2) {
            e2.printStackTrace();
            return permissionList;
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
            return permissionList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestPermissions(String[] permissions) {
        MARPermission.getInstance().requestPermissions(this.context, CODE_MAR_PERMISSION, permissions, this);
    }

    private void showPermissionTipDialog(final String[] failedPermissions, final boolean gotoPermissionSettings) {
        try {
            String tips = getFailedPermissionNames(failedPermissions);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("权限申请失败");
            builder.setMessage("为了游戏能正常进行，我们需要访问您的 " + tips + " 权限");
            builder.setCancelable(true);
            builder.setPositiveButton("退出游戏", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.permission.MARAutoPermission.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int whichButton) {
                    Log.d("MARSDK", "user cancel to open permission. so app kill self.");
                    MARSDK.getInstance().getContext().finish();
                    System.exit(0);
                }
            });
            builder.setNeutralButton(gotoPermissionSettings ? "开启权限" : "确  定", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.permission.MARAutoPermission.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int whichButton) {
                    if (gotoPermissionSettings) {
                        MARAutoPermission.this.jumpingPermission = true;
                        PermissionPageUtils.jumpPermissionPageDefault(MARSDK.getInstance().getApplication());
                    } else {
                        MARAutoPermission.this.requestPermissions(failedPermissions);
                    }
                }
            });
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWriteSettingTipDialog() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
            builder.setTitle("权限申请");
            builder.setMessage("为了游戏能正常进行，我们需要访问您的 【修改设置】 权限，请前往系统设置中进行开启");
            builder.setCancelable(true);
            builder.setPositiveButton("退出游戏", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.permission.MARAutoPermission.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int whichButton) {
                    Log.d("MARSDK", "user cancel to open permission. so app kill self.");
                    MARSDK.getInstance().getContext().finish();
                    System.exit(0);
                }
            });
            builder.setNeutralButton("开启权限", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.permission.MARAutoPermission.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int whichButton) {
                    MARAutoPermission.this.jumpingWriteSettings = true;
                    PermissionPageUtils.jumpWriteSettingPage(MARSDK.getInstance().getApplication());
                }
            });
            builder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getFailedPermissionNames(String[] failedPermissions) {
        String tips = "";
        for (String p : failedPermissions) {
            MARPermissionInfo pInfo = this.permissions.get(p);
            if (pInfo != null) {
                tips = tips + "【" + pInfo.getCname() + "】";
            }
        }
        return tips;
    }

    @Override // com.mar.sdk.permission.IPermissionResultListener
    public void onPermissionSuccess() {
        this.jumpingPermission = false;
        if (this.needWriteSetting) {
            requestWriteSettings(this.context);
        } else if (this.listener != null) {
            this.listener.onAutoPermissionSuccess();
        }
    }

    public void requestWriteSettings(Activity context) {
        this.jumpingWriteSettings = false;
        MARPermission.getInstance();
        MARPermission.requestWriteSetting(context, new IPermissionWriteSettingListener() { // from class: com.mar.sdk.permission.MARAutoPermission.6
            @Override // com.mar.sdk.permission.IPermissionWriteSettingListener
            public void onPermissionGranted() {
                Log.d("MARSDK", "write settings permission already granted.");
                if (MARAutoPermission.this.listener != null) {
                    MARAutoPermission.this.listener.onAutoPermissionSuccess();
                }
            }

            @Override // com.mar.sdk.permission.IPermissionWriteSettingListener
            public void onPermissionDenied() {
                Log.d("MARSDK", "write settings permission was denied.");
                MARAutoPermission.this.showWriteSettingTipDialog();
            }
        });
    }

    @Override // com.mar.sdk.permission.IPermissionResultListener
    public void onPermissionFailed(String[] failedPermissions, String[] deniedForeverPermissions) {
        if (0 != 0) {
            boolean gotoPermissionSettings = false;
            if (deniedForeverPermissions != null && deniedForeverPermissions.length > 0) {
                gotoPermissionSettings = true;
            }
            showPermissionTipDialog(failedPermissions, gotoPermissionSettings);
            return;
        }
        if (this.listener != null) {
            this.listener.onAutoPermissionFailed(failedPermissions, deniedForeverPermissions);
        }
    }

    @Override // com.mar.sdk.permission.IPermissionResultListener
    public void onPermissionCanceled() {
    }

    public boolean isAutoPermission() {
        return this.autoPermission;
    }

    public boolean isAutoProtocol() {
        return !TextUtils.isEmpty(this.protocolUrl);
    }

    public void setAutoPermission(boolean autoPermission) {
        this.autoPermission = autoPermission;
    }

    public boolean isDirectPermission() {
        return this.directPermission;
    }

    public void setDirectPermission(boolean directPermission) {
        this.directPermission = directPermission;
    }

    public boolean isJumpingPermission() {
        return this.jumpingPermission;
    }

    public boolean isJumpingWriteSettings() {
        return this.jumpingWriteSettings;
    }
}
