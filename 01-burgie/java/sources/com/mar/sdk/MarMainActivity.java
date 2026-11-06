package com.mar.sdk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.gg.AdEvent;
import com.mar.sdk.gg.IAdResult;
import com.mar.sdk.gg.MARGgPlatform;
import com.mar.sdk.gg.control.MggControl;
import com.mar.sdk.gg.push.CrossPushStyle;
import com.mar.sdk.gg.push.PushStyle;
import com.mar.sdk.permission.MARProtocolActivity;
import com.mar.sdk.platform.MARExitListener;
import com.mar.sdk.platform.MARInitListener;
import com.mar.sdk.platform.MARPlatform;
import com.mar.sdk.plugin.BlockWordsCallBack;
import com.mar.sdk.plugin.MARSpecialInterface;
import com.mar.sdk.utils.EncryptUtils;
import com.mar.sdk.verify.MARProxy;
import com.mar.sdk.verify.UGameArchive;
import com.mar.sdk.verify.UToken;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import com.taptap.sdk.db.constant.Common;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MarMainActivity extends UnityPlayerActivity {
    private boolean InitSDK = false;

    /* JADX INFO: renamed from: com.mar.sdk.MarMainActivity$11, reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$mar$sdk$FromUnity;

        static {
            int[] iArr = new int[FromUnity.values().length];
            $SwitchMap$com$mar$sdk$FromUnity = iArr;
            try {
                iArr[FromUnity.Login.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.switchAccount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.onLogout.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.Pay.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.ShowInter.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.ShowRewardedVideo.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.showHiddenVideo.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.BannerAD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.ShowSplash.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.Gift.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.payOK.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.Exit.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.queryGameData.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.OpenMoment.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.HideBanner.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.getBigNativeFlag.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.showBigNative.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.hideBigNative.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.checkBigNative.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.OpenMoreGame.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.UmCustomEvent.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.UmCustomEvents.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.UmRegisterEvent.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.setGameArchive.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.getGameArchive.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.ClearGameArchive.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.showNativeInters.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.setVibrator.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.getBlockedWords.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.callSpecialFinc.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.ShowFloatIcon.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.HideFloatIcon.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.ShowNativeLucency.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.HideNativeLucency.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.SelectmutualPush.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.SelectCrossPush.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.setUserProperty.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.submitExtraData.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.showProtocol.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.showUserAgreement.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.UpdateApk.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.setUserSetOnce.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$mar$sdk$FromUnity[FromUnity.setTrackUserAdd.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
        }
    }

    private void SelectCrossPush(int i) {
        MARPlatform.getInstance().showCrossPush(CrossPushStyle.values()[i - 1]);
    }

    private void SelectmutualPush(int i) {
        MARPlatform.getInstance().mutualPush(PushStyle.values()[i - 1]);
    }

    private void callSpecialFinc(String str) {
        Log.d("callSpecialFinc", str + "");
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("funname");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
            if (jSONObjectOptJSONObject == null) {
                MARSpecialInterface.getInstance().callSpecailFunc(this, strOptString, null);
                return;
            }
            SDKParams sDKParams = new SDKParams();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString2 = jSONObjectOptJSONObject.optString(next);
                if (!TextUtils.isEmpty(strOptString2)) {
                    sDKParams.put(next, strOptString2);
                }
            }
            MARSpecialInterface.getInstance().callSpecailFunc(this, strOptString, sDKParams);
        } catch (Exception e) {
            Log.e("MARSDK", "callSpecialFinc Exception" + e.toString());
        }
    }

    private void getBlockedWords(String str) {
        MARPlatform.getInstance().getBlockedWords(str, new BlockWordsCallBack() { // from class: com.mar.sdk.MarMainActivity.10
            @Override // com.mar.sdk.plugin.BlockWordsCallBack
            public void selectResult(boolean z, boolean z2, List<String> list) {
                String str2 = z + "_" + z2;
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        str2 = str2 + "_" + list.get(i);
                    }
                }
                MarMainActivity.this.callUnity(SendUnity.OnSelectResult.getType(), str2);
            }
        });
    }

    private void initSDK() {
        MARPlatform.getInstance().init(this, new MARInitListener() { // from class: com.mar.sdk.MarMainActivity.1
            @Override // com.mar.sdk.platform.MARInitListener
            public void onInitResult(int i, String str) {
                Log.d("MARSDK", "init result.code:" + i + ";msg:" + str);
                if (i == 1) {
                    MarMainActivity.this.callUnity(SendUnity.InitSDKSuccessful.getType(), "");
                    MarMainActivity.this.InitSDK = true;
                } else {
                    if (i != 2) {
                        return;
                    }
                    MarMainActivity.this.callUnity(SendUnity.InitSDKFail.getType(), "");
                    MarMainActivity.this.InitSDK = false;
                }
            }

            @Override // com.mar.sdk.platform.MARInitListener
            public void onLoginResult(int i, UToken uToken) {
                JSONObject jSONObject;
                JSONException e;
                if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    Log.d("MARSDK", "login failed from sdk." + i);
                    MarMainActivity.this.callUnity(SendUnity.LoginFail.getType(), "");
                    return;
                }
                try {
                    jSONObject = new JSONObject(uToken.toString());
                    try {
                        jSONObject.put("getUserID", uToken.getUserID());
                        jSONObject.put("getToken", uToken.getToken());
                    } catch (JSONException e2) {
                        e = e2;
                        e.printStackTrace();
                    }
                } catch (JSONException e3) {
                    jSONObject = null;
                    e = e3;
                }
                MarMainActivity.this.callUnity(SendUnity.LoginSuccess.getType(), jSONObject != null ? jSONObject.toString() : "");
                if (MARSDK.getInstance().getGameType() == 1 || (MARSDK.getInstance().getGameType() == 3 && !MggControl.getInstance().getFreeFlag())) {
                    MggControl.getInstance().reqAdControlInfo();
                }
                MarMainActivity.this.setAdCallBack();
            }

            @Override // com.mar.sdk.platform.MARInitListener
            public void onLogout() {
                Log.d("MARSDK", "登出账号");
                MarMainActivity.this.callUnity(SendUnity.logoutResult.getType(), "");
            }

            @Override // com.mar.sdk.platform.MARInitListener
            public void onPayResult(int i, String str) {
                Log.d("MARSDK", "pay result result.code:" + i + ";msg:" + str);
                MarMainActivity.this.callUnity(SendUnity.PayResult.getType(), str);
            }

            @Override // com.mar.sdk.platform.MARInitListener
            public void onRedeemResult(String str) {
                Log.d("MARSDK", "redeem result result msg:" + str);
                MarMainActivity.this.callUnity(SendUnity.onRedeemResult.getType(), str);
            }

            @Override // com.mar.sdk.platform.MARInitListener
            public void onResult(int i, String str) {
                Log.d("MARSDK", "onResult result.code:" + i + ";msg:" + str);
                if (100 == i) {
                    MarMainActivity.this.callUnity(SendUnity.onResult.getType(), str);
                } else if (122 == i) {
                    MarMainActivity.this.callUnity(SendUnity.ThirdResult.getType(), str);
                }
            }

            @Override // com.mar.sdk.platform.MARInitListener
            public void onSwitchAccount(UToken uToken) {
                Log.d("MARSDK", "切换账号并登陆成功");
                Toast.makeText(MarMainActivity.this, "切换账号并登陆成功", 1).show();
                MarMainActivity.this.callUnity(SendUnity.onSwitchAccount.getType(), uToken.toString());
            }
        });
    }

    public static boolean isNonConsumable(String str) {
        return MARPlatform.getInstance().isNonConsumable(str);
    }

    public static void restorePurchases(String str) {
        MARPlatform.getInstance().restorePurchases(str);
    }

    public void ClearGameArchive(int i) {
        MARPlatform.getInstance().clearGameArchive(i, new MARCloudCallBack() { // from class: com.mar.sdk.MarMainActivity.5
            @Override // com.mar.sdk.MARCloudCallBack
            public void onCloudResult(UGameArchive uGameArchive) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("getStatus", uGameArchive.getStatus());
                    jSONObject.put("getSerialNumber", uGameArchive.getSerialNumber());
                    jSONObject.put("gameArchive", uGameArchive.getGameArchive());
                    jSONObject.put("getExtraData", uGameArchive.getExtraData());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MarMainActivity.this.callUnity(SendUnity.GameArchive.getType(), jSONObject.toString());
            }
        });
    }

    public void GetGift(String str) {
        MARPlatform.getInstance().exchangeGift(str);
    }

    public void OpenMoreGame() {
        MARPlatform.getInstance().gotoMoreGame();
    }

    public void ReciveMessageFromUnity(int i, String str) {
        FromUnity typeByKeys = FromUnity.getTypeByKeys(i);
        if (typeByKeys == null) {
            Log.d("MARSDK", "ReciveMessageFromUnity is null============" + i + "===" + str);
        }
        Log.d("MARSDK", "ReciveMessageFromUnity============" + i + ":" + typeByKeys.getDesc() + "===" + str);
        switch (AnonymousClass11.$SwitchMap$com$mar$sdk$FromUnity[typeByKeys.ordinal()]) {
            case 1:
                login();
                break;
            case 2:
                switchAccount();
                break;
            case 3:
                onLogout();
                break;
            case 4:
                pay(str);
                break;
            case 5:
                showInters(str);
                break;
            case 6:
                showVideo(str);
                break;
            case 7:
                showHiddenVideo(str);
                break;
            case 8:
                showBanner(str);
                break;
            case 9:
                showSplash(str);
                break;
            case 10:
                GetGift(str);
                break;
            case 11:
                setPropDeliveredComplete(str);
                break;
            case 12:
                exit();
                break;
            case 13:
                getGameObbRes(str);
                break;
            case 14:
                openMoment();
                break;
            case 15:
                hideBanner();
                break;
            case 16:
                getBigNativeFlag();
                break;
            case 17:
                showBigNative(str);
                break;
            case 18:
                hideBigNative();
                break;
            case 19:
                checkBigNative();
                break;
            case 20:
                OpenMoreGame();
                break;
            case 21:
            case 22:
                UmCustomEvent(str);
                break;
            case 23:
                UmRegisterEvent();
                break;
            case 24:
                updateGameArchive(str);
                break;
            case 25:
                getGameArchive(Integer.parseInt(str));
                break;
            case 26:
                ClearGameArchive(Integer.parseInt(str));
                break;
            case 27:
                showNativeInters(str);
                break;
            case 28:
                setVibrator(Long.parseLong(str));
                break;
            case 29:
                getBlockedWords(str);
                break;
            case 30:
                callSpecialFinc(str);
                break;
            case 31:
                showFloatIcon(str);
                break;
            case 32:
                hideFloatIcon();
                break;
            case 33:
                showNativeLucency(str);
                break;
            case 34:
                hideNativeLucency();
                break;
            case 35:
                SelectmutualPush(Integer.parseInt(str));
                break;
            case 36:
                SelectCrossPush(Integer.parseInt(str));
                break;
            case 37:
                setUserProperty(str);
                break;
            case 38:
                submitExtraData(str);
                break;
            case 39:
                showProtocol();
                break;
            case 40:
                showUserAgreement();
                break;
            case 41:
                updateApk();
                break;
            case 42:
                setUserSetOnce(str);
                break;
            case 43:
                setTrackUserAdd(str);
                break;
        }
    }

    public void ReportEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            MARPlatform.getInstance().ssReportEvent(jSONObject.getString("eventName"), jSONObject.getJSONObject("data"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UmCustomEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString("eventId");
            if (strOptString != null && !strOptString.equals("")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    MARPlatform.getInstance().UmCustomEvent(strOptString, null);
                    return;
                }
                SDKParams sDKParams = new SDKParams();
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString2 = jSONObjectOptJSONObject.optString(next);
                    if (!TextUtils.isEmpty(strOptString2)) {
                        sDKParams.put(next, strOptString2);
                    }
                }
                MARPlatform.getInstance().UmCustomEvent(strOptString, sDKParams);
                return;
            }
            MARPlatform.getInstance().UmCustomEvent(str, null);
        } catch (Exception e) {
            MARPlatform.getInstance().UmCustomEvent(str, null);
            Log.e("MARSDK", "UmCustomEvent Exception" + e.toString());
        }
    }

    public void UmRegisterEvent() {
        SDKParams sDKParams = new SDKParams();
        sDKParams.put("用户注册", 0);
        MARPlatform.getInstance().UmRegisterEvent(sDKParams);
    }

    public void callUnity(int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i);
            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
            UnityPlayer.UnitySendMessage("MarReceive", "recieveMessageFromAndroid", jSONObject.toString());
            Log.d("MARSDK", "callUnity=============" + i + ":" + SendUnity.getTypeByKeys(i) + "=================" + str);
        } catch (JSONException e) {
            Log.d("MARSDK", "callUnity=============JSONException:" + i + "==" + str + "==" + e.toString());
        }
    }

    public void checkBigNative() {
        MARGgPlatform.getInstance().checkBigNative();
    }

    public void exit() {
        MARPlatform.getInstance().exitSDK(new MARExitListener() { // from class: com.mar.sdk.MarMainActivity.2
            @Override // com.mar.sdk.platform.MARExitListener
            public void onGameExit() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MarMainActivity.this);
                builder.setTitle("退出确认");
                builder.setMessage("现在还早，要不要再玩一会？");
                builder.setCancelable(true);
                builder.setPositiveButton("好吧", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.MarMainActivity.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                builder.setNeutralButton("一会再玩", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.MarMainActivity.2.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MarMainActivity.this.finish();
                        System.exit(0);
                    }
                });
                builder.show();
            }
        });
    }

    public boolean getBigNativeFlag() {
        return MARGgPlatform.getInstance().getBigNativeFlag();
    }

    public int getCheckDRM() {
        return MARSDK.getInstance().getCheckDRM();
    }

    public boolean getCustomSwitch() {
        return MARGgPlatform.getInstance().getCustomSwitch();
    }

    public boolean getFloatIconFlag() {
        return MARGgPlatform.getInstance().getFloatIconFlag();
    }

    public void getGameArchive(int i) {
        MARPlatform.getInstance().getGameArchive(i, new MARCloudCallBack() { // from class: com.mar.sdk.MarMainActivity.4
            @Override // com.mar.sdk.MARCloudCallBack
            public void onCloudResult(UGameArchive uGameArchive) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("getStatus", uGameArchive.getStatus());
                    jSONObject.put("getSerialNumber", uGameArchive.getSerialNumber());
                    jSONObject.put("gameArchive", uGameArchive.getGameArchive());
                    jSONObject.put("getExtraData", uGameArchive.getExtraData());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MarMainActivity.this.callUnity(SendUnity.GameArchive.getType(), jSONObject.toString());
            }
        });
    }

    public void getGameObbRes(String str) {
        MARPlatform.getInstance().getDownloadUrl(str, new MARCallBack() { // from class: com.mar.sdk.MarMainActivity.9
            @Override // com.mar.sdk.MARCallBack
            public void onCallBack(String str2) {
                MarMainActivity.this.callUnity(SendUnity.onResourceResult.getType(), str2);
            }
        });
    }

    public boolean getHiddenVideoFlag() {
        return MARGgPlatform.getInstance().getHiddenVideoFlag();
    }

    public boolean getIntersFlag() {
        return MARGgPlatform.getInstance().getIntersFlag();
    }

    public boolean getNativeIntersFlag() {
        return MARGgPlatform.getInstance().getNativeIntersFlag();
    }

    public boolean getNativeLucencyFlag() {
        return MARGgPlatform.getInstance().getNativeLucencyFlag();
    }

    public long getNewTime() {
        return MARSDK.getInstance().getNetworkTime();
    }

    public boolean getVideoFlag() {
        return MARGgPlatform.getInstance().getVideoFlag();
    }

    public void hideBanner() {
        MARGgPlatform.getInstance().hideBanner();
    }

    public void hideBigNative() {
        MARGgPlatform.getInstance().hideBigNative();
    }

    public void hideFloatIcon() {
        MARGgPlatform.getInstance().hideFloatIcon();
    }

    public void hideNativeLucency() {
        MARGgPlatform.getInstance().hideNativeLucency();
    }

    public boolean isSingleGame() {
        return MARSDK.getInstance().isSingleGame();
    }

    public boolean isSupportExit() {
        Log.d("MARSDK", "判断是否有渠道退出");
        boolean zIsSupportExit = MARPlatform.getInstance().isSupportExit();
        Log.d("isSupport", "渠道退出结果" + zIsSupportExit);
        return zIsSupportExit;
    }

    public void login() {
        MARPlatform.getInstance().login(this);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        MARSDK.getInstance().onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initSDK();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onDestroy() {
        Log.d("MARSDK", "onDestroy");
        MARSDK.getInstance().onDestroy();
        super.onDestroy();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        exit();
        return true;
    }

    public void onLogout() {
        MARPlatform.getInstance().logout();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Log.d("MARSDK", "onNewIntent");
        MARSDK.getInstance().onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onPause() {
        Log.d("MARSDK", "onPause");
        MARSDK.getInstance().onPause();
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        MARSDK.getInstance().onRequestPermissionResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onRestart() {
        Log.d("MARSDK", "onReStart");
        MARSDK.getInstance().onRestart();
        super.onRestart();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onResume() {
        Log.d("MARSDK", "onResume");
        MARSDK.getInstance().onResume();
        super.onResume();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onStart() {
        Log.d("MARSDK", "onStart");
        MARSDK.getInstance().onStart();
        super.onStart();
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onStop() {
        Log.d("MARSDK", "onStop");
        MARSDK.getInstance().onStop();
        super.onStop();
    }

    public void openMoment() {
        MARPlatform.getInstance().openMoment();
    }

    public void pay(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            PayParams payParams = new PayParams();
            payParams.setBuyNum(jSONObject.optInt("buyNum"));
            payParams.setCoinNum(jSONObject.optInt("coinNum"));
            payParams.setExtension(jSONObject.optString("extension"));
            payParams.setPrice(jSONObject.optInt(IAction.PurchaseKey.Price));
            payParams.setProductId(jSONObject.optString(BillingClientConstants.PRODUCT_ID));
            payParams.setProductName(jSONObject.optString(IAction.PurchaseKey.ProductName));
            payParams.setProductDesc(jSONObject.optString("productDesc"));
            payParams.setRoleId(jSONObject.optString("roleId"));
            payParams.setRoleLevel(jSONObject.optInt(IAction.RoleKey.RoleLevel));
            payParams.setRoleName(jSONObject.optString(IAction.RoleKey.RoleName));
            payParams.setServerId(jSONObject.optString("serverId"));
            payParams.setServerName(jSONObject.optString(IAction.RoleKey.ServerName));
            payParams.setVip(jSONObject.optString("vip"));
            MARPlatform.getInstance().pay(this, payParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int requestChannelValue() {
        return Integer.parseInt(MARSDK.getInstance().getCurrChannel() + "");
    }

    public String requestDeviceID() {
        try {
            return EncryptUtils.md5(MARSDK.getInstance().getContext().getPackageName() + Settings.Secure.getString(MARSDK.getInstance().getContext().getContentResolver(), Common.Predefined.SUB_ANDROID_ID));
        } catch (Exception unused) {
            return "";
        }
    }

    public void setAdCallBack() {
        MARSDK.getInstance().setAdListener(new IAdResult() { // from class: com.mar.sdk.MarMainActivity.6
            @Override // com.mar.sdk.gg.IAdResult
            public void onAdResult(int i, AdEvent adEvent) {
                int i2;
                int i3;
                Log.d("MARSDK", "Unity onAdResult AdEvent================" + i + "===" + adEvent.toString());
                if (adEvent == null) {
                    Log.d("MARSDK", "Unity onAdResult AdEvent is null");
                    return;
                }
                if (adEvent.type == AdEvent.AdType.AdTypeSplash) {
                    i2 = 1;
                } else if (adEvent.type == AdEvent.AdType.AdTypeBanner) {
                    i2 = 2;
                } else if (adEvent.type == AdEvent.AdType.AdTypeInters) {
                    i2 = 3;
                } else if (adEvent.type == AdEvent.AdType.AdTypeVideo) {
                    i2 = 4;
                } else if (adEvent.type == AdEvent.AdType.AdTypeNativeBig) {
                    i2 = 5;
                } else if (adEvent.type == AdEvent.AdType.AdTypeFolatIcon) {
                    i2 = 6;
                } else {
                    i2 = adEvent.type == AdEvent.AdType.AdTypeLucency ? 7 : 0;
                }
                if (i == 1007) {
                    i3 = MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE;
                } else if (i == 1005) {
                    i3 = 502;
                } else if (i == 1001) {
                    i3 = 504;
                } else if (i == 1009) {
                    i3 = 505;
                } else if (i == 1003) {
                    i3 = 506;
                } else {
                    i3 = i == 1002 ? 507 : 500;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("platform", "android");
                    jSONObject.put("adCode", adEvent.adId);
                    jSONObject.put("adSource", adEvent.instType + "");
                    jSONObject.put("adType", i2);
                    jSONObject.put("adStatus", i3);
                    jSONObject.put("error", adEvent.error + "");
                    jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, adEvent.toString());
                    MarMainActivity.this.callUnity(SendUnity.onAdResult.getType(), jSONObject.toString());
                } catch (Exception e) {
                    Log.d("MARSDK", "Unity onAdResult  Exception:" + e.toString());
                }
            }
        });
    }

    public void setPropDeliveredComplete(String str) {
        MARPlatform.getInstance().setPropDeliveredComplete(str);
    }

    public void setTrackUserAdd(String str) {
        MARPlatform.getInstance().setTrackUserAdd(str);
    }

    public void setUserProperty(String str) {
        MARPlatform.getInstance().setUserProperty(str);
    }

    public void setUserSetOnce(String str) {
        MARPlatform.getInstance().setUserSetOnce(str);
    }

    public void setVibrator(long j) {
        Log.d("MARSDK", "setVibrator -----------------" + j);
        try {
            ((Vibrator) getSystemService("vibrator")).vibrate(j);
        } catch (Exception unused) {
        }
    }

    public void showBanner(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = Integer.parseInt(jSONObject.optString("postion"));
            String strOptString = jSONObject.optString("data");
            if (!SDKTools.isNullOrEmpty(strOptString)) {
                MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeBanner, strOptString);
            }
            MARGgPlatform.getInstance().showBanner(i);
        } catch (Exception unused) {
        }
    }

    public void showBigNative(String str) {
        if (!SDKTools.isNullOrEmpty(str)) {
            MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeNativeBig, str);
        }
        MARGgPlatform.getInstance().showBigNative();
    }

    public void showFloatIcon(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            double d = jSONObject.getDouble("PosX");
            double d2 = jSONObject.getDouble("PosY");
            String strOptString = jSONObject.optString("data");
            if (!SDKTools.isNullOrEmpty(strOptString)) {
                MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeFolatIcon, strOptString);
            }
            MARGgPlatform.getInstance().showFloatIcon(d, d2);
        } catch (Exception unused) {
        }
    }

    public void showHiddenVideo(String str) {
        if (!SDKTools.isNullOrEmpty(str)) {
            MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeVideo, str);
        }
        MARGgPlatform.getInstance().showHiddenVideo();
    }

    public void showInters(String str) {
        if (!SDKTools.isNullOrEmpty(str)) {
            MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeInters, str);
        }
        MARGgPlatform.getInstance().showInters();
    }

    public void showNativeInters(String str) {
        if (!SDKTools.isNullOrEmpty(str)) {
            MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeInters, str);
        }
        MARGgPlatform.getInstance().showNativeInters();
    }

    public void showNativeLucency(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            double d = jSONObject.getDouble("PosX");
            double d2 = jSONObject.getDouble("PosY");
            String strOptString = jSONObject.optString("data");
            if (!SDKTools.isNullOrEmpty(strOptString)) {
                MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeLucency, strOptString);
            }
            MARGgPlatform.getInstance().showNativeLucency(d, d2);
        } catch (Exception unused) {
        }
    }

    public void showProtocol() {
        runOnUiThread(new Runnable() { // from class: com.mar.sdk.MarMainActivity.7
            @Override // java.lang.Runnable
            public void run() {
                MARProtocolActivity.showProtocol(MarMainActivity.this, MARProxy.getPrivacy().getPrivacyAgreementPath());
            }
        });
    }

    public void showSplash(String str) {
        if (!SDKTools.isNullOrEmpty(str)) {
            MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeSplash, str);
        }
        MARGgPlatform.getInstance().showSplash();
    }

    public void showUserAgreement() {
        runOnUiThread(new Runnable() { // from class: com.mar.sdk.MarMainActivity.8
            @Override // java.lang.Runnable
            public void run() {
                MARProtocolActivity.showUserAgreement(MarMainActivity.this, MARProxy.getPrivacy().getUserAgreementPath());
            }
        });
    }

    public void showVideo(String str) {
        if (!SDKTools.isNullOrEmpty(str)) {
            MARGgPlatform.getInstance().setADGameEvens(AdEvent.AdType.AdTypeVideo, str);
        }
        MARGgPlatform.getInstance().showVideo();
    }

    public void submitExtraData(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            UserExtraData userExtraData = new UserExtraData();
            userExtraData.setDataType(jSONObject.optInt("dataType"));
            userExtraData.setRoleID(jSONObject.optString(IAction.RoleKey.RoleID));
            userExtraData.setRoleName(jSONObject.optString(IAction.RoleKey.RoleName));
            userExtraData.setRoleLevel(jSONObject.optString(IAction.RoleKey.RoleLevel));
            userExtraData.setServerID(jSONObject.optInt(IAction.RoleKey.ServerID));
            userExtraData.setServerName(jSONObject.optString(IAction.RoleKey.ServerName));
            userExtraData.setMoneyNum(jSONObject.optInt("moneyNum"));
            userExtraData.setRoleCreateTime(jSONObject.optLong("roleCreateTime"));
            userExtraData.setRoleLevelUpTime(jSONObject.optLong("roleLevelUpTime"));
            userExtraData.setVip(jSONObject.optString("vip"));
            userExtraData.setRoleGender(jSONObject.optInt("roleGender"));
            userExtraData.setProfessionID(jSONObject.optString("professionID"));
            userExtraData.setProfessionName(jSONObject.optString("professionName"));
            userExtraData.setPower(jSONObject.optString("power"));
            userExtraData.setPartyID(jSONObject.optString("partyID"));
            userExtraData.setPartyName(jSONObject.optString("partyName"));
            MARPlatform.getInstance().submitExtraData(userExtraData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchAccount() {
        MARPlatform.getInstance().switchAccount();
    }

    public void updateApk() {
        MARPlatform.getInstance().updateApk();
    }

    public void updateGameArchive(String str) {
        Log.d("MARSDK", "updateGameArchive -----------------" + str);
        String str2 = str.split("_")[0];
        String strSubstring = str.substring(str2.length() + 1);
        int i = Integer.parseInt(str2);
        Log.d("MARSDK", "游戏数据 -----------------" + strSubstring);
        MARPlatform.getInstance().updateGameArchive(strSubstring, i, new MARCloudCallBack() { // from class: com.mar.sdk.MarMainActivity.3
            @Override // com.mar.sdk.MARCloudCallBack
            public void onCloudResult(UGameArchive uGameArchive) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("getStatus", uGameArchive.getStatus());
                    jSONObject.put("getSerialNumber", uGameArchive.getSerialNumber());
                    jSONObject.put("gameArchive", uGameArchive.getGameArchive());
                    jSONObject.put("getExtraData", uGameArchive.getExtraData());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MarMainActivity.this.callUnity(SendUnity.GameArchive.getType(), jSONObject.toString());
            }
        });
    }
}
