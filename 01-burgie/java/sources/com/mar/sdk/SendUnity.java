package com.mar.sdk;

/* JADX INFO: loaded from: classes2.dex */
public enum SendUnity {
    InitSDKSuccessful(0, "初始化SDK成功"),
    InitSDKFail(1, "初始化SDK失败"),
    LoginSuccess(2, "登录成功"),
    LoginFail(3, "登录失败"),
    Exit(4, "退出游戏回调"),
    PayResult(5, "支付回调"),
    onRedeemResult(6, "礼包下放"),
    onResult(7, "额外事件"),
    onResourceResult(8, "资源下载"),
    logoutResult(9, "登出回调"),
    onSwitchAccount(10, "切换账号"),
    GameArchive(12, "云存档"),
    OnSelectResult(13, "敏感词系统"),
    onAdResult(14, "广告事件"),
    ThirdResult(15, "第三方SDK回调");

    String desc;
    int type;

    SendUnity(int i, String str) {
        this.type = i;
        this.desc = str;
    }

    public static String getTypeByKeys(int i) {
        for (SendUnity sendUnity : values()) {
            if (sendUnity.getType() == i) {
                return sendUnity.getDesc();
            }
        }
        return "";
    }

    public String getDesc() {
        return this.desc;
    }

    public int getType() {
        return this.type;
    }
}
