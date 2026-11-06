package com.mar.sdk;

/* JADX INFO: loaded from: classes2.dex */
public enum FromUnity {
    InitSDK(0, "初始化SDK"),
    Login(1, "登录"),
    Pay(2, "支付"),
    ShowInter(3, "展示插屏"),
    BannerAD(4, "显示banner广告"),
    ShowRewardedVideo(5, "播放激励视频"),
    Gift(6, "礼包兑换"),
    payOK(7, "支付道具下放成功"),
    Exit(8, "退出游戏"),
    ShowSplash(11, "开屏广告"),
    queryGameData(12, "游戏数据"),
    OpenMoment(13, "打开论坛"),
    HideBanner(14, "隐藏Banner"),
    getBigNativeFlag(15, "原生大图是否被加载"),
    hideBigNative(16, "隐藏原生大图"),
    checkBigNative(17, "点击原生大图"),
    OpenMoreGame(18, "打开更多游戏"),
    showBigNative(19, "展示原生大图"),
    UmCustomEvent(20, "自定义事件"),
    UmCustomEvents(21, "自定义事件"),
    switchAccount(22, "切换账号"),
    onLogout(23, "登出"),
    UmRegisterEvent(24, "注册统计"),
    setGameArchive(25, "保存存档"),
    getGameArchive(26, "读取存档"),
    showNativeInters(27, "显示原生插屏广告"),
    setVibrator(28, "震动"),
    requestChannelValue(29, "获取取到号"),
    getBlockedWords(30, "敏感词"),
    ClearGameArchive(31, "删除存档"),
    showHiddenVideo(32, "播放可控制激励视频"),
    callSpecialFinc(33, "特殊方法"),
    ShowFloatIcon(34, "显示悬浮icon"),
    HideFloatIcon(35, "隐藏悬浮icon"),
    ReportEvent(36, ""),
    SelectmutualPush(37, "调用结算互推界面"),
    setUserProperty(38, "设置用户属性"),
    submitExtraData(39, "上传用户角色信息"),
    showProtocol(40, "展示隐私协议"),
    showUserAgreement(41, "展示用户协议"),
    ShowNativeLucency(42, "展示原生自渲染透明广告"),
    HideNativeLucency(43, "隐藏原生自渲染透明广告"),
    SelectCrossPush(44, "调用交叉互推"),
    UpdateApk(45, "调用渠道更新apk"),
    setUserSetOnce(46, "设置只有一次用户属性"),
    setTrackUserAdd(47, "设置用户属性累计");

    String desc;
    int type;

    FromUnity(int i, String str) {
        this.type = i;
        this.desc = str;
    }

    public static FromUnity getTypeByKeys(int i) {
        for (FromUnity fromUnity : values()) {
            if (fromUnity.getType() == i) {
                return fromUnity;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getType() {
        return this.type;
    }
}
