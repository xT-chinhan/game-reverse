package com.mar.sdk;

import android.content.Intent;
import android.os.Process;
import android.widget.Toast;
import com.mar.sdk.gg.control.MggControl;
import com.mar.sdk.log.Log;
import com.mar.sdk.permission.INetworkListener;
import com.mar.sdk.permission.MARNetworkDialog;
import com.taptap.sdk.compliance.TapTapCompliance;
import com.taptap.sdk.compliance.TapTapComplianceCallback;
import com.taptap.sdk.compliance.constants.ComplianceMessage;
import com.taptap.sdk.compliance.option.TapTapComplianceOptions;
import com.taptap.sdk.core.TapTapSdk;
import com.taptap.sdk.core.TapTapSdkOptions;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.callback.TapTapCallback;
import com.taptap.sdk.kit.internal.exception.TapTapException;
import com.taptap.sdk.login.AccessToken;
import com.taptap.sdk.login.TapTapAccount;
import com.taptap.sdk.login.TapTapLogin;
import com.taptap.sdk.rep.TapTapRep;
import com.taptap.sdk.rep.internal.TapRepResultCallback;
import com.taptap.sdk.review.TapTapReview;
import com.taptap.sdk.update.TapTapUpdate;
import com.taptap.sdk.update.TapTapUpdateCallback;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TapTapSDK {
    private static TapTapSDK instance;
    private String clientid;
    private String clienttoken;
    private boolean isupdate;
    private String TAG = "MARSDK-TapTapSDK";
    private boolean enableLog = false;

    public static TapTapSDK getInstance() {
        if (instance == null) {
            instance = new TapTapSDK();
        }
        return instance;
    }

    public void initSDK(SDKParams params) {
        try {
            this.clientid = params.contains("Taptap_ClientId") ? params.getString("Taptap_ClientId") : "";
            this.clienttoken = params.contains("Taptap_ClientToken") ? params.getString("Taptap_ClientToken") : "";
            this.enableLog = params.contains("Taptap_DeBug") ? params.getBoolean("Taptap_DeBug").booleanValue() : false;
            this.isupdate = params.contains("Taptap_Update") ? params.getBoolean("Taptap_Update").booleanValue() : false;
            MARSDK.getInstance().setSDKListener(new TaptapMarSdkListener() { // from class: com.mar.sdk.TapTapSDK.1
                @Override // com.mar.sdk.TaptapMarSdkListener, com.mar.sdk.base.IMARSDKListener
                public void onResult(int code, String msg) {
                    super.onResult(code, msg);
                    if (code == 5) {
                        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.TapTapSDK.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(MARSDK.getInstance().getContext(), "登录失败,重新登录", 0).show();
                                MARSDK.getInstance().getContext().startActivity(new Intent(MARSDK.getInstance().getContext(), (Class<?>) MARTapTapLoginActivity.class));
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(this.TAG, "taptap initSDK Exception:" + e.toString());
        }
    }

    public void initTap() {
        TapTapSdkOptions tapSdkOptions = new TapTapSdkOptions(this.clientid, this.clienttoken, 0);
        tapSdkOptions.setEnableLog(this.enableLog);
        TapTapComplianceOptions tapComplianceOptions = new TapTapComplianceOptions(false, true);
        TapTapSdk.init(MARSDK.getInstance().getContext(), tapSdkOptions, tapComplianceOptions);
        MARSDK.getInstance().onResult(1, "init success");
        TapTapCompliance.registerComplianceCallback(new TapTapComplianceCallback() { // from class: com.mar.sdk.TapTapSDK.2
            @Override // com.taptap.sdk.compliance.TapTapComplianceCallback
            public void onComplianceResult(int code, Map<String, ?> extra) {
                Log.d(TapTapSDK.this.TAG, "registerComplianceCallback onComplianceResult " + code);
                switch (code) {
                    case 500:
                        MARSDK.getInstance().onResult(27, "");
                        break;
                    case 1000:
                        System.exit(0);
                        MARSDK.getInstance().getContext().finish();
                        break;
                    case 1001:
                        MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.TapTapSDK.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                TapTapSDK.this.logout();
                                TapTapCompliance.exit();
                                TapTapSDK.this.login();
                            }
                        });
                        break;
                    case 1030:
                    case ComplianceMessage.DURATION_LIMIT /* 1050 */:
                    case 1100:
                    case ComplianceMessage.INVALID_CLIENT_OR_NETWORK_ERROR /* 1200 */:
                        MARSDK.getInstance().onResult(28, "");
                        break;
                    case 9002:
                        System.exit(0);
                        MARSDK.getInstance().getContext().finish();
                        break;
                    default:
                        MARSDK.getInstance().onResult(28, "");
                        break;
                }
            }
        });
        if (this.isupdate) {
            TapTapUpdate.checkForceUpdate();
        }
    }

    public void login() {
        if (!SDKTools.isNetworkAvailable(MARSDK.getInstance().getContext())) {
            MARNetworkDialog.showDialog(MARSDK.getInstance().getContext(), true, new INetworkListener() { // from class: com.mar.sdk.TapTapSDK.3
                @Override // com.mar.sdk.permission.INetworkListener
                public void retry() {
                    TapTapSDK.this.login();
                }

                @Override // com.mar.sdk.permission.INetworkListener
                public void exit() {
                    MARSDK.getInstance().getContext().finish();
                    System.exit(0);
                    Process.killProcess(Process.myPid());
                }
            });
            return;
        }
        TapTapAccount currentTapAccount = TapTapLogin.getCurrentTapAccount();
        if (currentTapAccount != null) {
            loginMAR(currentTapAccount);
        } else {
            MARSDK.getInstance().getContext().startActivity(new Intent(MARSDK.getInstance().getContext(), (Class<?>) MARTapTapLoginActivity.class));
        }
    }

    public void loginWithScopes() {
        String[] scopes = {"public_profile"};
        TapTapLogin.loginWithScopes(MARSDK.getInstance().getContext(), scopes, new TapTapCallback<TapTapAccount>() { // from class: com.mar.sdk.TapTapSDK.4
            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onSuccess(TapTapAccount tapTapAccount) {
                TapTapSDK.this.loginMAR(tapTapAccount);
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onFail(TapTapException exception) {
                Log.d(TapTapSDK.this.TAG, "login onFail " + exception.toString());
                MARSDK.getInstance().onResult(5, "taptap login faill：" + exception.toString());
            }

            @Override // com.taptap.sdk.kit.internal.callback.TapTapCallback
            public void onCancel() {
                Log.d(TapTapSDK.this.TAG, "login onCancel ");
                MARSDK.getInstance().onResult(5, "taptap login onCancel");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginMAR(TapTapAccount tapTapAccount) {
        Log.d(this.TAG, "login loginMAR " + tapTapAccount.toString());
        JSONObject jsonObject = new JSONObject();
        try {
            AccessToken accessToken = tapTapAccount.getAccessToken();
            if (accessToken != null) {
                jsonObject.put("mac_key", accessToken.getMacKey());
                jsonObject.put("kid", accessToken.getKid());
            }
            jsonObject.put("unionid", tapTapAccount.getUnionId());
            jsonObject.put("openid", tapTapAccount.getOpenId());
            jsonObject.put(Common.System.NAME, tapTapAccount.getName());
            jsonObject.put("avatar", tapTapAccount.getAvatar());
            Log.d(this.TAG, jsonObject.toString());
            MARSDK.getInstance().onLoginResult(jsonObject.toString());
            MARSDK.getInstance().onResult(4, "taptap login success");
            if (!MggControl.getInstance().isDisableRealnameSwitch()) {
                realNameRegister();
            }
        } catch (Exception e) {
            Log.e(this.TAG, "login Exception：" + e);
            login();
        }
    }

    public void logout() {
        TapTapLogin.logout();
    }

    public void realNameRegister() {
        Log.d(this.TAG, "realNameRegister");
        TapTapAccount currentTapAccount = TapTapLogin.getCurrentTapAccount();
        if (currentTapAccount != null) {
            String unionId = currentTapAccount.getUnionId();
            TapTapCompliance.startup(MARSDK.getInstance().getContext(), unionId);
        }
    }

    public void queryAntiAddiction() {
        int ageRange = TapTapCompliance.getAgeRange();
        Log.d(this.TAG, "queryAntiAddiction ageRange :" + ageRange);
        if (ageRange == -1) {
            MARSDK.getInstance().onResult(29, "0");
        } else if (ageRange == 0) {
            MARSDK.getInstance().onResult(29, ageRange + "");
        } else {
            MARSDK.getInstance().onResult(29, ageRange + "");
        }
    }

    public void updataApk() {
        Log.d(this.TAG, "updataApk");
        TapTapUpdate.updateGame(MARSDK.getInstance().getContext(), new TapTapUpdateCallback() { // from class: com.mar.sdk.TapTapSDK.5
            @Override // com.taptap.sdk.update.TapTapUpdateCallback
            public void onCancel() {
                Log.d(TapTapSDK.this.TAG, "updataApk onCancel");
            }
        });
    }

    public void openReview() {
        TapTapReview.openReview();
    }

    public void opneRep(SDKParams params) {
        String url = params.getString(BreakpointSQLiteKey.URL);
        TapTapRep.open(url, new TapRepResultCallback() { // from class: com.mar.sdk.TapTapSDK.6
            @Override // com.taptap.sdk.rep.internal.TapRepResultCallback
            public void onRepSuccess() {
                Log.d(TapTapSDK.this.TAG, "opneRep onRepSuccess");
            }

            @Override // com.taptap.sdk.rep.internal.TapRepResultCallback
            public void onRepFail(int i, String s) {
                Log.d(TapTapSDK.this.TAG, " opneRep onRepFail :" + i + "==" + s);
            }
        });
    }
}
