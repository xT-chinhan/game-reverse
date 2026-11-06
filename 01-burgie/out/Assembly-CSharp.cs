// TypeDefIndex: 5350
class <Module>
{
}

// TypeDefIndex: 5351
class PlayerController
{
	float Speed;
	// RVA: 0x162acf0
	void Update() { }
	// RVA: 0x162add8
	void .ctor() { }
}

// TypeDefIndex: 5352
class PowerUp
{
	UnityEngine.GameObject pickupEffect;
	// RVA: 0x162ade0
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x162ae50
	void Pickup() { }
	// RVA: 0x162af68
	void .ctor() { }
}

// TypeDefIndex: 5353
class Quit
{
	// RVA: 0x162af70
	void Start() { }
	// RVA: 0x162af74
	void Update() { }
	// RVA: 0x162afd4
	void .ctor() { }
}

// TypeDefIndex: 5354
class ToogleHelper
{
	UnityEngine.GameObject BtnClaim;
	UnityEngine.GameObject BtnClose;
	UnityEngine.UI.Button BtnToggle;
	UnityEngine.GameObject ObjSign;
	bool IsSelected;
	// RVA: 0x162afdc
	void Start() { }
	// RVA: 0x162b06c
	void OnEnable() { }
	// RVA: 0x162b0f4
	void OnClickBtnToggle() { }
	// RVA: 0x162b070
	void ShowToggle() { }
	// RVA: 0x162b240
	bool GetIsSelected() { }
	// RVA: 0x162b248
	void .ctor() { }
	// RVA: 0x162b250
	void <Start>b__5_0() { }
}

// TypeDefIndex: 5355
class GameSetting.ChannelType
{
	int value__;
	GameSetting+ChannelType Android;
	GameSetting+ChannelType Ios;
	GameSetting+ChannelType Harmony;
	GameSetting+ChannelType WeiXin;
	GameSetting+ChannelType TiKTok;
	GameSetting+ChannelType HuaWei;
	GameSetting+ChannelType Oppo;
	GameSetting+ChannelType ViVo;
	GameSetting+ChannelType XiaoMi;
	GameSetting+ChannelType KuaiShou;
	GameSetting+ChannelType Honor;
	GameSetting+ChannelType NoAd;
}

// TypeDefIndex: 5356
class GameSetting.AnalyticsType
{
	int value__;
	GameSetting+AnalyticsType NoAnalytics;
	GameSetting+AnalyticsType GravityEngine;
}

// TypeDefIndex: 5357
class GameSetting
{
	GameSetting+ChannelType appChannelType;
	GameSetting+AnalyticsType analyticsType;
	// RVA: 0x162b254
	bool IsIos() { }
	// RVA: 0x162b264
	bool IsAndroid() { }
	// RVA: 0x162b274
	bool IsHarmony() { }
	// RVA: 0x162b284
	bool IsWeiXin() { }
	// RVA: 0x162b294
	bool IsTiKTok() { }
	// RVA: 0x162b2a4
	bool IsHuaWei() { }
	// RVA: 0x162b2b4
	bool IsOppo() { }
	// RVA: 0x162b2c4
	bool IsViVo() { }
	// RVA: 0x162b2d4
	bool IsXiaoMi() { }
	// RVA: 0x162b2e4
	bool IsKuaiShou() { }
	// RVA: 0x162b2f4
	bool IsHonor() { }
	// RVA: 0x162b304
	bool IsNoAd() { }
	// RVA: 0x162b314
	bool isGravityEngine() { }
	// RVA: 0x162b324
	void .ctor() { }
}

// TypeDefIndex: 5358
class SingletonMonoBehaviour`1
{
	T instance;
	// property Instance
	// no-body
	T get_Instance() { }
	// no-body
	void Awake() { }
	// no-body
	bool CheckInstance() { }
	// no-body
	void .ctor() { }
}

// TypeDefIndex: 5359
class Builder`1
{
	// no-body
	T builder() { }
	// no-body
	void .ctor() { }
}

// TypeDefIndex: 5360
class MARPayParams
{
	string productId;
	string productName;
	string productDesc;
	int price;
	string extension;
	int buyNum;
	int coinNum;
	string serverId;
	string serverName;
	string roleId;
	string roleName;
	int roleLevel;
	string vip;
	string orderId;
	// RVA: 0x162b36c
	void .ctor() { }
}

// TypeDefIndex: 5361
class MARPayParamsBuilder
{
	string productId;
	string productName;
	string productDesc;
	int price;
	string extension;
	int buyNum;
	int coinNum;
	string serverId;
	string serverName;
	string roleId;
	string roleName;
	int roleLevel;
	string vip;
	// RVA: 0x162b374
	MARPayParams builder() { }
	// RVA: 0x162b684
	void .ctor() { }
}

// TypeDefIndex: 5362
class MarSDKCallback
{
	MarSDKCallback _instance;
	// RVA: 0x162b6cc
	MarSDKCallback InitCallback() { }
	// RVA: 0x162b824
	void recieveMessageFromAndroid(string data) { }
	// RVA: 0x162b9cc
	void Dowork(int Type, string msg) { }
	// RVA: 0x162c9f8
	void OnAdStatusResult(MarSDK.AdParams adParams) { }
	// RVA: 0x162c93c
	void OnBlockedWordsResult(bool reqSuccess, bool isContain) { }
	// RVA: 0x162c894
	void OnGetGameArchiveSuccessful(string msg) { }
	// RVA: 0x162c1d8
	void OnInitSDKSuccessful() { }
	// RVA: 0x162c278
	void OnInitSDKFail() { }
	// RVA: 0x162c7ec
	void OnRewardVideo(string code) { }
	// RVA: 0x162c66c
	void OnRedeemResult(int propNumber, string propType, string msg, string listdata) { }
	// RVA: 0x162c318
	void OnLoginSuccess(string msg) { }
	// RVA: 0x162c3c0
	void OnLoginFail() { }
	// RVA: 0x162c460
	void OnLoginOut() { }
	// RVA: 0x162c744
	void OnResourceResult(string msg) { }
	// RVA: 0x162c500
	void OnSwitchAccount(string msg) { }
	// RVA: 0x162c5a8
	void OnPayResult(int code, string productId, string orderId) { }
	// RVA: 0x162cb98
	void .ctor() { }
}

// TypeDefIndex: 5363
class MarSDKInterfaceAndroid
{
	UnityEngine.AndroidJavaObject jo;
	// RVA: 0x162cba0
	void .ctor() { }
	// no-body
	T SDKCall(string method, object[] param) { }
	// RVA: 0x162cd9c
	void SDKCall(string method, object[] param) { }
	// RVA: 0x162ce54
	void SendMessageToAndroid(int Type, string msg) { }
	// RVA: 0x162cf84
	void showProtocol() { }
	// RVA: 0x162cfd0
	void showUserAgreement() { }
	// RVA: 0x162d01c
	bool getHiddenVideoFlag() { }
	// RVA: 0x162d0e0
	void ShowHiddenVideo(string data) { }
	// RVA: 0x162d0ec
	void Exit() { }
	// RVA: 0x162d138
	bool getBigNativeFlag() { }
	// RVA: 0x162d1fc
	bool getIntersFlag() { }
	// RVA: 0x162d2c0
	bool getVideoFlag() { }
	// RVA: 0x162d384
	void Gift(string msg) { }
	// RVA: 0x162d390
	void HideBanner() { }
	// RVA: 0x162d3dc
	void hideBigNative() { }
	// RVA: 0x162d428
	bool isSupportExit() { }
	// RVA: 0x162d4ec
	void Login() { }
	// RVA: 0x162d5b8
	void Openforum() { }
	// RVA: 0x162d604
	void OpenMoreGame() { }
	// RVA: 0x162d650
	void Pay(MARPayParams payParams) { }
	// RVA: 0x162d814
	void getGameObbRes(string version) { }
	// RVA: 0x162d820
	void SetPropDeliveredComplete(string orderId) { }
	// RVA: 0x162d82c
	bool IsNonConsumable(string productId) { }
	// RVA: 0x162d908
	void RestorePurchases(string productId) { }
	// RVA: 0x162d9cc
	void ShowBanner(string msg, string data) { }
	// RVA: 0x162dab8
	void showBigNative(string data) { }
	// RVA: 0x162dac4
	void ShowInters(string data) { }
	// RVA: 0x162dad0
	void ShowReward(string data) { }
	// RVA: 0x162dadc
	void ShowSplash(string data) { }
	// RVA: 0x162dae8
	void UmCustomEvent(string eventId, string eventData) { }
	// RVA: 0x162dc08
	void setUserProperty(string param) { }
	// RVA: 0x162dc14
	void setUserSetOnce(string param) { }
	// RVA: 0x162dc20
	void setTrackUserAdd(string param) { }
	// RVA: 0x162dc2c
	void switchAccount() { }
	// RVA: 0x162dc78
	void setVibrator(long vibratorTime) { }
	// RVA: 0x162dcb0
	void UmRegisterEvent(string eventName) { }
	// RVA: 0x162dcbc
	int requestChannelValue() { }
	// RVA: 0x162dd80
	void setGameArchive(string GameArchiveVersion, string data) { }
	// RVA: 0x162ddf0
	void getGameArchive(string GameArchiveVersion) { }
	// RVA: 0x162ddfc
	bool getFloatIconFlag() { }
	// RVA: 0x162dec0
	void ShowFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x162dfec
	void HideFloatIcon() { }
	// RVA: 0x162e038
	bool getNativeLucencyFlag() { }
	// RVA: 0x162e0fc
	void ShowNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x162e228
	void HideNativeLucency() { }
	// RVA: 0x162e274
	void CentermutualPush(int valueType) { }
	// RVA: 0x162e2ac
	void Logout() { }
	// RVA: 0x162e2f8
	void getBlockedWords(string words) { }
	// RVA: 0x162e304
	void ClearGameArchive(string gameArchiveVersion) { }
	// RVA: 0x162e310
	bool isSingleGame() { }
	// RVA: 0x162e3d4
	void submitExtraData(MARUserExtraData userExtraData) { }
	// RVA: 0x162e448
	string requestDeviceID() { }
	// RVA: 0x162e50c
	bool getCustomSwitch() { }
	// RVA: 0x162e5d0
	int checkDRM() { }
	// RVA: 0x162e694
	long getNewTime() { }
	// RVA: 0x162e758
	void CrossPushAction(int type) { }
	// RVA: 0x162e790
	void updateApk() { }
	// RVA: 0x162e7dc
	void callSpecialFinc(string funname, string json) { }
}

// TypeDefIndex: 5364
class MARSDKInterfaceManager
{
	// RVA: 0x162e90c
	void CentermutualPush(int valueType) { }
	// RVA: 0x162e944
	void ClearGameArchive(string gameArchiveVersion) { }
	// RVA: 0x162e97c
	void CrossPushAction(int type) { }
	// RVA: 0x162e9b4
	void Exit() { }
	// RVA: 0x162e9ec
	bool getBigNativeFlag() { }
	// RVA: 0x162ea24
	void getBlockedWords(string words) { }
	// RVA: 0x162ea5c
	bool getCustomSwitch() { }
	// RVA: 0x162ea94
	bool getFloatIconFlag() { }
	// RVA: 0x162eacc
	void getGameArchive(string GameArchiveVersion) { }
	// RVA: 0x162eb04
	void getGameObbRes(string version) { }
	// RVA: 0x162eb3c
	bool getHiddenVideoFlag() { }
	// RVA: 0x162eb74
	bool getIntersFlag() { }
	// RVA: 0x162ebac
	bool getNativeLucencyFlag() { }
	// RVA: 0x162ebe4
	long getNewTime() { }
	// RVA: 0x162ec1c
	bool getVideoFlag() { }
	// RVA: 0x162ec54
	void Gift(string msg) { }
	// RVA: 0x162ec8c
	void HideBanner() { }
	// RVA: 0x162ecc4
	void hideBigNative() { }
	// RVA: 0x162ecfc
	void HideFloatIcon() { }
	// RVA: 0x162ed34
	void HideNativeLucency() { }
	// RVA: 0x162ed6c
	bool isSingleGame() { }
	// RVA: 0x162eda4
	void Login() { }
	// RVA: 0x162eddc
	void Logout() { }
	// RVA: 0x162ee14
	void Openforum() { }
	// RVA: 0x162ee4c
	void Pay(MARPayParams payParams) { }
	// RVA: 0x162ee84
	bool IsNonConsumable(string productId) { }
	// RVA: 0x162ee8c
	void RestorePurchases(string productId) { }
	// RVA: 0x162eec4
	int requestChannelValue() { }
	// RVA: 0x162eefc
	string requestDeviceID() { }
	// RVA: 0x162ef34
	void setGameArchive(string GameArchiveVersion, string data) { }
	// RVA: 0x162ef6c
	void SetPropDeliveredComplete(string orderId) { }
	// RVA: 0x162efa4
	void setTrackUserAdd(string param) { }
	// RVA: 0x162efdc
	void setUserProperty(string param) { }
	// RVA: 0x162f014
	void setUserSetOnce(string param) { }
	// RVA: 0x162f04c
	void ShowBanner(string msg, string data) { }
	// RVA: 0x162f084
	void showBigNative(string data) { }
	// RVA: 0x162f0bc
	void ShowFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x162f0f4
	void ShowHiddenVideo(string data) { }
	// RVA: 0x162f12c
	void ShowInters(string data) { }
	// RVA: 0x162f164
	void ShowNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x162f19c
	void showProtocol() { }
	// RVA: 0x162f1d4
	void ShowReward(string data) { }
	// RVA: 0x162f20c
	void ShowSplash(string data) { }
	// RVA: 0x162f244
	void showUserAgreement() { }
	// RVA: 0x162f27c
	void submitExtraData(MARUserExtraData userExtraData) { }
	// RVA: 0x162f2b4
	void switchAccount() { }
	// RVA: 0x162f2ec
	void UmCustomEvent(string eventId, string eventData) { }
	// RVA: 0x162f324
	void UmRegisterEvent(string eventdata) { }
	// RVA: 0x162f35c
	void OpenURL(string urlStr) { }
	// RVA: 0x162cd94
	void .ctor() { }
}

// TypeDefIndex: 5365
class MarSDKInterfaceNoAd
{
	// RVA: 0x162f394
	void CentermutualPush(int valueType) { }
	// RVA: 0x162f398
	void ClearGameArchive(string gameArchiveVersion) { }
	// RVA: 0x162f39c
	void Exit() { }
	// RVA: 0x162f3a0
	bool getBigNativeFlag() { }
	// RVA: 0x162f3a8
	void getBlockedWords(string words) { }
	// RVA: 0x162f3ac
	void getGameArchive(string GameArchiveVersion) { }
	// RVA: 0x162f3b0
	bool getHiddenVideoFlag() { }
	// RVA: 0x162f3b8
	bool getIntersFlag() { }
	// RVA: 0x162f3c0
	bool getVideoFlag() { }
	// RVA: 0x162f3c8
	void Gift(string msg) { }
	// RVA: 0x162f3cc
	void HideBanner() { }
	// RVA: 0x162f3d0
	void hideBigNative() { }
	// RVA: 0x162f3d4
	void HideFloatIcon() { }
	// RVA: 0x162f3d8
	void HideNativeLucency() { }
	// RVA: 0x162f3dc
	bool isSupportExit() { }
	// RVA: 0x162f3e4
	void Login() { }
	// RVA: 0x162f4a8
	void Logout() { }
	// RVA: 0x162f564
	void Openforum() { }
	// RVA: 0x162f568
	void OpenMoreGame() { }
	// RVA: 0x162f56c
	void Pay(MARPayParams payParams) { }
	// RVA: 0x162f570
	void getGameObbRes(string version) { }
	// RVA: 0x162f574
	int requestChannelValue() { }
	// RVA: 0x162f57c
	string requestDeviceID() { }
	// RVA: 0x162f584
	void setGameArchive(string GameArchiveVersion, string data) { }
	// RVA: 0x162f588
	void SetPropDeliveredComplete(string orderId) { }
	// RVA: 0x162f58c
	void setVibrator(long vibratorTime) { }
	// RVA: 0x162f590
	void ShowBanner(string msg, string data) { }
	// RVA: 0x162f594
	void showBigNative(string data) { }
	// RVA: 0x162f598
	void ShowFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x162f59c
	bool getNativeLucencyFlag() { }
	// RVA: 0x162f5a4
	void ShowNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x162f5a8
	void ShowHiddenVideo(string data) { }
	// RVA: 0x162f5ac
	void ShowInters(string data) { }
	// RVA: 0x162f5b0
	void ShowReward(string data) { }
	// RVA: 0x162f638
	void ShowSplash(string data) { }
	// RVA: 0x162f63c
	void switchAccount() { }
	// RVA: 0x162f640
	void UmCustomEvent(string eventId, string eventData) { }
	// RVA: 0x162f644
	void setUserProperty(string param) { }
	// RVA: 0x162f648
	void setUserSetOnce(string param) { }
	// RVA: 0x162f64c
	void setTrackUserAdd(string param) { }
	// RVA: 0x162f650
	void UmRegisterEvent(string eventName) { }
	// RVA: 0x162f654
	bool isSingleGame() { }
	// RVA: 0x162f65c
	bool getCustomSwitch() { }
	// RVA: 0x162f664
	int checkDRM() { }
	// RVA: 0x162f66c
	void submitExtraData(MARUserExtraData userExtraData) { }
	// RVA: 0x162f724
	void ShowAchievementUI() { }
	// RVA: 0x162f728
	void SetAchievementProgress(string achievementId, float progress) { }
	// RVA: 0x162f72c
	void HideAchievementUI() { }
	// RVA: 0x162f730
	void ShowLeaderboards() { }
	// RVA: 0x162f734
	void HideLeaderboards() { }
	// RVA: 0x162f738
	void SetLeaderboardsProgress(string achievementId, float progress) { }
	// RVA: 0x162f73c
	void showProtocol() { }
	// RVA: 0x162f740
	void showUserAgreement() { }
	// RVA: 0x162f744
	bool getFloatIconFlag() { }
	// RVA: 0x162f74c
	long getNewTime() { }
	// RVA: 0x162f784
	void CrossPushAction(int type) { }
	// RVA: 0x162f7bc
	void .ctor() { }
}

// TypeDefIndex: 5366
class MARUserExtraData
{
	int dataType;
	string roleID;
	string roleName;
	string roleLevel;
	int serverID;
	string serverName;
	int moneyNum;
	long roleCreateTime;
	long roleLevelUpTime;
	string vip;
	int roleGender;
	string professionID;
	string professionName;
	string power;
	string partyID;
	string partyName;
	// RVA: 0x162f7c4
	void .ctor() { }
}

// TypeDefIndex: 5367
class MARUserExtraDataBuilder
{
	int dataType;
	string roleID;
	string roleName;
	string roleLevel;
	int serverID;
	string serverName;
	int moneyNum;
	long roleCreateTime;
	long roleLevelUpTime;
	string vip;
	int roleGender;
	string professionID;
	string professionName;
	string power;
	string partyID;
	string partyName;
	// RVA: 0x162f7cc
	MARUserExtraData builder() { }
	// RVA: 0x162fb58
	void .ctor() { }
}

// TypeDefIndex: 5368
class DontDestroyOnLoad
{
	// RVA: 0x162fba0
	void Awake() { }
	// RVA: 0x162fba4
	void .ctor() { }
}

// TypeDefIndex: 5369
class HidePanel
{
	// RVA: 0x162fbac
	void DeActive() { }
	// RVA: 0x162fbd0
	void .ctor() { }
}

// TypeDefIndex: 5370
class MarCustomDialog.MarCutomDialogData
{
	string title;
	string message;
	string canceltxt;
	string confirmtxt;
	string agreetxt;
	// RVA: 0x1630100
	void .ctor() { }
}

// TypeDefIndex: 5371
class MarCustomDialog
{
	UnityEngine.GameObject panel;
	UnityEngine.UI.Text title;
	UnityEngine.UI.Text message;
	UnityEngine.UI.Button btnCance;
	UnityEngine.UI.Button btnConfirm;
	UnityEngine.UI.Button btnAgree;
	System.Action<bool> action;
	// RVA: 0x162fbd8
	void onConfirm() { }
	// RVA: 0x162fc24
	void onCancel() { }
	// RVA: 0x162fc6c
	void onAgree() { }
	// RVA: 0x162fcb4
	void Awake() { }
	// RVA: 0x162fd2c
	void OnDestroy() { }
	// RVA: 0x162fd88
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16300f8
	void .ctor() { }
}

// TypeDefIndex: 5372
class ToastMgr.<>c__DisplayClass3_0
{
	ToastMgr <>4__this;
	string mess;
	// RVA: 0x16302cc
	void .ctor() { }
	// RVA: 0x163031c
	void <Show>b__0() { }
}

// TypeDefIndex: 5373
class ToastMgr
{
	UnityEngine.UI.Text toastText;
	UnityEngine.GameObject panel;
	System.Action<bool> callBackSponsor;
	// RVA: 0x1630108
	void Show(string mess, System.Action callBack) { }
	// RVA: 0x16302d4
	void .ctor() { }
}

// TypeDefIndex: 5374
class AdvertParams.AdvertIdMini
{
	int channelId;
	bool enableSwitch;
	string bannerAdvertId;
	string intersAdvertId;
	string incentiveVideoAdvertId;
	string nativeBannerAdvertId;
	string nativeIntersAdvertId;
	string nativeBigPictureAdvertId;
	string floatIconAdvertId;
	// RVA: 0x1630374
	void .ctor() { }
}

// TypeDefIndex: 5375
class AdvertParams.AdIntersControl
{
	string id;
	int channelId;
	int configType;
	string configTypeValue;
	int startNum;
	int intervalNum;
	int intervalTime;
	// RVA: 0x163037c
	void .ctor() { }
}

// TypeDefIndex: 5376
class AdvertParams.AdInoutControlEntity
{
	int channelId;
	bool enableSwitch;
	string popupType;
	int intervalNum;
	int intervalTime;
	int intersRatio;
	int nativeIntersRatio;
	int nativeSplashRatio;
	int splashAdvertRatio;
	// RVA: 0x1630384
	void .ctor() { }
}

// TypeDefIndex: 5377
class AdvertParams.AdDynamicNativeInters
{
	string id;
	int channelId;
	int configType;
	string configTypeValue;
	bool nativePasterSwitch;
	int nativePasterMostNumber;
	string nativePasterBigPicStyle;
	bool nativeIntersSwitch;
	int nativeIntersStartNumber;
	int nativeIntersIntervalTime;
	int nativeIntersMaxNumber;
	bool nativePasterMaskSwitch;
	int nativePasterHeightRatio;
	int nativePasterStartNumber;
	int nativePasterIntervalTime;
	bool nativeIntersRandomStyleSwitch;
	int nativeIntersIntervalNumber;
	int nativePasterIntervalNumber;
	bool nativeLucencySwitch;
	bool nativeLucencyMaskSwitch;
	int nativeLucencyStartNumber;
	int nativeLucencyMaxNumber;
	int nativeLucencyIntervalTime;
	int nativeLucencyIntervalNumber;
	int nativeLucencyHeightRatio;
	bool nativeSplashSwitch;
	int nativeSplashStartNumber;
	int nativeSplashMaxNumber;
	int nativeSplashIntervalTime;
	int nativeSplashIntervalNumber;
	// RVA: 0x163038c
	void .ctor() { }
}

// TypeDefIndex: 5378
class AdvertParams.AdCombineControl
{
	string id;
	int channelId;
	int configType;
	string configTypeValue;
	bool enableSwitch;
	int intersRatio;
	int nativeIntersRatio;
	int intersVideoRatio;
	int splashAdvertRatio;
	int incentiveVideoRatio;
	// RVA: 0x1630394
	void .ctor() { }
}

// TypeDefIndex: 5379
class AdvertParams.AdCombineDelayed
{
	string id;
	int channelId;
	int configType;
	string configTypeValue;
	bool delayedSwitch;
	int ejectionTime;
	int ejectionInterval;
	int ejectionEndTime;
	// RVA: 0x163039c
	void .ctor() { }
}

// TypeDefIndex: 5380
class AdvertParams.AdVirtualKeyControl
{
	bool virtualKeySwitch;
	bool virtualProbability;
	// RVA: 0x16303a4
	void .ctor() { }
}

// TypeDefIndex: 5381
class AdvertParams.AdSwitch
{
	string id;
	int channelId;
	int configType;
	string configTypeValue;
	bool bannerSwitch;
	bool intersSwitch;
	bool splashSwitch;
	bool videoSwitch;
	bool nativeBannerSwitch;
	bool nativeIntersSwitch;
	bool nativeBigSwitch;
	bool intersVideoSwitch;
	bool floatSwitch;
	bool disableRealnameSwitch;
	bool jumpRealnameSwitch;
	bool rebootSkipLoginSwitch;
	bool nativeLucencyAdvertSwitch;
	bool nativeSplashSwitch;
	bool customSwitch;
	// RVA: 0x16303ac
	void .ctor() { }
}

// TypeDefIndex: 5382
class AdvertParams.AdBannerControl
{
	string id;
	int channelId;
	int configType;
	string configTypeValue;
	int refreshRate;
	int loadIntervalTime;
	string priority;
	int maxCloseNum;
	// RVA: 0x16303b4
	void .ctor() { }
}

// TypeDefIndex: 5383
class AdvertParams.AdIncentiveVideoControl
{
	string id;
	int channelId;
	int configType;
	string configTypeValue;
	bool enableSwitch;
	int startNum;
	int intervalTime;
	int limitNum;
	// RVA: 0x16303bc
	void .ctor() { }
}

// TypeDefIndex: 5384
class AdvertParams.AdReturnKeyControl
{
	bool returnKeySwitch;
	int returnProbability;
	string popupType;
	// RVA: 0x16303c4
	void .ctor() { }
}

// TypeDefIndex: 5385
class AdvertParams
{
	AdvertParams+AdIntersControl adIntersControl;
	AdvertParams+AdInoutControlEntity adInoutControlEntity;
	bool advertSwitch;
	AdvertParams+AdDynamicNativeInters adDynamicNativeInters;
	AdvertParams+AdCombineControl adCombineControl;
	AdvertParams+AdCombineDelayed adCombineDelayed;
	AdvertParams+AdVirtualKeyControl adVirtualKeyControl;
	AdvertParams+AdSwitch adSwitch;
	string ip;
	AdvertParams+AdBannerControl adBannerControl;
	AdvertParams+AdIncentiveVideoControl adIncentiveVideoControl;
	AdvertParams+AdReturnKeyControl adReturnKeyControl;
	AdvertParams+AdvertIdMini advertIdMini;
	// RVA: 0x163036c
	void .ctor() { }
}

// TypeDefIndex: 5386
class AnalyticsInterface
{
	// no-body
	void Init() { }
	// no-body
	void setRegister(string msg) { }
	// no-body
	void Login(string msg) { }
	// no-body
	void Pay(MARPayParams mARPayParams) { }
	// no-body
	void setCustom(string eventId, string eventData) { }
	// no-body
	void TrackAdEvent(MarSDK.AdParams adParams) { }
	// no-body
	void setUserProperty(string user) { }
	// no-body
	void setUserSetOnce(string user) { }
	// no-body
	void setTrackUserAdd(string user) { }
	// RVA: 0x16303cc
	void .ctor() { }
}

// TypeDefIndex: 5387
class AnalyticsInterfaceManager
{
	// RVA: 0x16303d4
	void Init() { }
	// RVA: 0x163040c
	void Login(string msg) { }
	// RVA: 0x1630444
	void Pay(MARPayParams mARPayParams) { }
	// RVA: 0x163047c
	void setCustom(string eventId, string eventData) { }
	// RVA: 0x16304b4
	void setRegister(string msg) { }
	// RVA: 0x16304ec
	void setTrackUserAdd(string user) { }
	// RVA: 0x1630524
	void setUserProperty(string user) { }
	// RVA: 0x163055c
	void setUserSetOnce(string user) { }
	// RVA: 0x1630594
	void TrackAdEvent(MarSDK.AdParams adParams) { }
	// RVA: 0x16305cc
	void .ctor() { }
}

// TypeDefIndex: 5388
class MiniGameManager
{
	MarSDK.MarSDKInterface _interface;
	// RVA: 0x16305d4
	void .ctor() { }
	// RVA: 0x16309fc
	void setMarMiniChannel(int id) { }
	// RVA: 0x1630a64
	void Login() { }
	// RVA: 0x1630a84
	void Logout() { }
	// RVA: 0x1630aa4
	void switchAccount() { }
	// RVA: 0x1630ac4
	void submitExtraData(MARUserExtraData userExtraData) { }
	// RVA: 0x1630ae4
	void Exit() { }
	// RVA: 0x1630b04
	void Pay(MARPayParams payParams) { }
	// RVA: 0x1630b24
	void SetPropDeliveredComplete(string orderId) { }
	// RVA: 0x1630b44
	void Gift(string msg) { }
	// RVA: 0x1630b64
	bool IsNonConsumable(string productId) { }
	// RVA: 0x1630b84
	void RestorePurchases(string productId) { }
	// RVA: 0x1630ba8
	void ShowSplash(string data) { }
	// RVA: 0x1630bcc
	void ShowBanner(string msg, string data) { }
	// RVA: 0x1630bf4
	void HideBanner() { }
	// RVA: 0x1630c18
	bool getIntersFlag() { }
	// RVA: 0x1630c3c
	void ShowInters(string data) { }
	// RVA: 0x1630c60
	bool getVideoFlag() { }
	// RVA: 0x1630c84
	void ShowReward(string data) { }
	// RVA: 0x1630ca8
	bool getHiddenVideoFlag() { }
	// RVA: 0x1630ccc
	void ShowHiddenVideo(string data) { }
	// RVA: 0x1630cf0
	bool getBigNativeFlag() { }
	// RVA: 0x1630d14
	void showBigNative(string data) { }
	// RVA: 0x1630d38
	void hideBigNative() { }
	// RVA: 0x1630d5c
	bool getFloatIconFlag() { }
	// RVA: 0x1630d80
	void ShowFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x1630da4
	void HideFloatIcon() { }
	// RVA: 0x1630dc8
	bool getNativeLucencyFlag() { }
	// RVA: 0x1630dec
	void ShowNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x1630e10
	void HideNativeLucency() { }
	// RVA: 0x1630e34
	void CentermutualPush(int valueType) { }
	// RVA: 0x1630e58
	void CrossPushAction(int type) { }
	// RVA: 0x1630e7c
	void setGameArchive(string GameArchiveVersion, string data) { }
	// RVA: 0x1630ea0
	void getGameArchive(string GameArchiveVersion) { }
	// RVA: 0x1630ec4
	void ClearGameArchive(string gameArchiveVersion) { }
	// RVA: 0x1630ee8
	void UmCustomEvent(string eventId, string eventData) { }
	// RVA: 0x1630f20
	void UmRegisterEvent(string eventdata) { }
	// RVA: 0x1630f48
	void setUserProperty(string param) { }
	// RVA: 0x1630f70
	void setUserSetOnce(string param) { }
	// RVA: 0x1630f98
	void setTrackUserAdd(string param) { }
	// RVA: 0x1630fc0
	void showProtocol() { }
	// RVA: 0x1630fe4
	void showUserAgreement() { }
	// RVA: 0x1631008
	void getGameObbRes(string version) { }
	// RVA: 0x163102c
	void getBlockedWords(string words) { }
	// RVA: 0x1631050
	int requestChannelValue() { }
	// RVA: 0x16310a8
	bool isSingleGame() { }
	// RVA: 0x1631108
	bool getCustomSwitch() { }
	// RVA: 0x1631128
	void Openforum() { }
	// RVA: 0x163114c
	long getNewTime() { }
	// RVA: 0x16311b4
	void CreateShortcut(System.Action<bool> csCallback) { }
	// RVA: 0x16311d8
	void FollowUserProfile(System.Action<bool> csCallback) { }
	// RVA: 0x16311fc
	void showGridGame(int type, int sizeType, int top, int left, System.Action Show, System.Action Close, System.Action<string> Error, System.Action Click) { }
	// RVA: 0x1631228
	void hideGridGame(int type) { }
	// RVA: 0x163124c
	void startVRecorder(int maxtime, System.Action<string> onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x1631270
	void stopVRecorder(System.Action<string> onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x1631294
	void shareVRecorder(System.Action<System.Collections.Generic.Dictionary<string, object>> onSuccess, System.Action<string> onFail) { }
	// RVA: 0x16312b8
	void showSideBar(System.Action onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x16312dc
	void kspayDiscount(System.Action<bool, string> callback) { }
}

// TypeDefIndex: 5389
class Liquid.UpdateMode
{
	int value__;
	Liquid+UpdateMode Normal;
	Liquid+UpdateMode UnscaledTime;
}

// TypeDefIndex: 5390
class Liquid.<KeepRecalculatingFillForAWhile>d__31
{
	int <>1__state;
	object <>2__current;
	Liquid <>4__this;
	float duration;
	float <t>5__2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1631e10
	void .ctor(int <>1__state) { }
	// RVA: 0x16321d0
	void System.IDisposable.Dispose() { }
	// RVA: 0x16321d4
	bool MoveNext() { }
	// RVA: 0x1632280
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1632288
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16322c0
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5391
class Liquid
{
	Liquid+UpdateMode updateMode;
	float fillAmount;
	float CompensateShapeAmount;
	float MaxWobble;
	float WobbleSpeedMove;
	float Recovery;
	float Thickness;
	UnityEngine.Mesh mesh;
	UnityEngine.Renderer rend;
	UnityEngine.MaterialPropertyBlock mpb;
	bool canWobble;
	bool fillDirty;
	UnityEngine.Vector3 pos;
	UnityEngine.Vector3 comp;
	UnityEngine.Vector3 lastPos;
	UnityEngine.Vector3 velocity;
	UnityEngine.Quaternion lastRot;
	UnityEngine.Vector3 angularVelocity;
	float wobbleAmountX;
	float wobbleAmountZ;
	float wobbleAmountToAddX;
	float wobbleAmountToAddZ;
	float pulse;
	float sinewave;
	float time;
	UnityEngine.Coroutine catchUpCoroutine;
	// RVA: 0x1631300
	void Awake() { }
	// RVA: 0x1631514
	void Start() { }
	// RVA: 0x16317ec
	void Update() { }
	// RVA: 0x1631cc4
	void AllowWobble(bool enabled) { }
	// RVA: 0x1631d94
	System.Collections.IEnumerator KeepRecalculatingFillForAWhile(float duration) { }
	// RVA: 0x1631e38
	void SetFillAmount(float newAmount) { }
	// RVA: 0x163162c
	void RecalculateFill(float deltaTime) { }
	// RVA: 0x1631fbc
	void ApplyFill() { }
	// RVA: 0x1631934
	void UpdateWobble(float deltaTime) { }
	// RVA: 0x1631bcc
	void ApplyWobble() { }
	// RVA: 0x16313fc
	void GetMeshAndRenderer() { }
	// RVA: 0x1632044
	UnityEngine.Vector3 GetAngularVelocity(UnityEngine.Quaternion from, UnityEngine.Quaternion to) { }
	// RVA: 0x1631f00
	float GetLowestPoint() { }
	// RVA: 0x16321a8
	void .ctor() { }
}

// TypeDefIndex: 5392
class HandCamera
{
	UnityEngine.Transform cameraAnchor;
	// RVA: 0x16322c8
	void FixedUpdate() { }
	// RVA: 0x1632344
	void .ctor() { }
}

// TypeDefIndex: 5393
class CameraFollow
{
	UnityEngine.Transform anchorPoint;
	// RVA: 0x163234c
	void LateUpdate() { }
	// RVA: 0x1632424
	void .ctor() { }
}

// TypeDefIndex: 5394
class Crouch
{
	// RVA: 0x163242c
	void .ctor() { }
}

// TypeDefIndex: 5395
class FirstPersonAudio.<>c__DisplayClass27_0
{
	UnityEngine.AudioSource audioToPlay;
	System.Func<UnityEngine.AudioSource, bool> <>9__0;
	// RVA: 0x16331c4
	void .ctor() { }
	// RVA: 0x16335c8
	bool <SetPlayingMovingAudio>b__0(UnityEngine.AudioSource audio) { }
}

// TypeDefIndex: 5396
class FirstPersonAudio.<>c__DisplayClass34_0
{
	string name;
	// RVA: 0x16335ac
	void .ctor() { }
	// RVA: 0x163366c
	bool <GetOrCreateAudioSource>b__0(UnityEngine.AudioSource a) { }
}

// TypeDefIndex: 5397
class FirstPersonAudio
{
	FirstPersonMovement character;
	GroundCheck groundCheck;
	UnityEngine.AudioSource stepAudio;
	UnityEngine.AudioSource runningAudio;
	float velocityThreshold;
	float checkInterval;
	UnityEngine.Vector2 lastCharacterPosition;
	float checkTimer;
	UnityEngine.AudioSource landingAudio;
	UnityEngine.AudioClip[] landingSFX;
	Jump jump;
	UnityEngine.AudioSource jumpAudio;
	UnityEngine.AudioClip[] jumpSFX;
	Crouch crouch;
	UnityEngine.AudioSource crouchStartAudio;
	UnityEngine.AudioSource crouchedAudio;
	UnityEngine.AudioSource crouchEndAudio;
	UnityEngine.AudioClip[] crouchStartSFX;
	UnityEngine.AudioClip[] crouchEndSFX;
	// property CurrentCharacterPosition
	// property MovingAudios
	// RVA: 0x1632434
	UnityEngine.Vector2 get_CurrentCharacterPosition() { }
	// RVA: 0x1632494
	UnityEngine.AudioSource[] get_MovingAudios() { }
	// RVA: 0x163254c
	void Reset() { }
	// RVA: 0x1632a44
	void OnEnable() { }
	// RVA: 0x1632b60
	void OnDisable() { }
	// RVA: 0x1632c7c
	void FixedUpdate() { }
	// RVA: 0x1632d94
	void SetPlayingMovingAudio(UnityEngine.AudioSource audioToPlay) { }
	// RVA: 0x16331cc
	void PlayLandingAudio() { }
	// RVA: 0x1633310
	void PlayJumpAudio() { }
	// RVA: 0x163331c
	void PlayCrouchStartAudio() { }
	// RVA: 0x163332c
	void PlayCrouchEndAudio() { }
	// RVA: 0x1632a48
	void SubscribeToEvents() { }
	// RVA: 0x1632b64
	void UnsubscribeToEvents() { }
	// RVA: 0x163283c
	UnityEngine.AudioSource GetOrCreateAudioSource(string name) { }
	// RVA: 0x16331d8
	void PlayRandomClip(UnityEngine.AudioSource audio, UnityEngine.AudioClip[] clips) { }
	// RVA: 0x16335b4
	void .ctor() { }
}

// TypeDefIndex: 5398
class GroundCheck
{
	float distanceThreshold;
	bool isGrounded;
	System.Action Grounded;
	float OriginOffset;
	// property RaycastOrigin
	// property RaycastDistance
	// RVA: 0x163333c
	void add_Grounded(System.Action value) { }
	// RVA: 0x1633474
	void remove_Grounded(System.Action value) { }
	// RVA: 0x1633698
	UnityEngine.Vector3 get_RaycastOrigin() { }
	// RVA: 0x1633730
	float get_RaycastDistance() { }
	// RVA: 0x1633744
	void LateUpdate() { }
	// RVA: 0x1633858
	void OnDrawGizmosSelected() { }
	// RVA: 0x16339a0
	void .ctor() { }
}

// TypeDefIndex: 5399
class Jump
{
	UnityEngine.Rigidbody rb;
	float jumpStrength;
	System.Action Jumped;
	GroundCheck groundCheck;
	// RVA: 0x16333d8
	void add_Jumped(System.Action value) { }
	// RVA: 0x1633510
	void remove_Jumped(System.Action value) { }
	// RVA: 0x16339bc
	void Reset() { }
	// RVA: 0x1633a14
	void Awake() { }
	// RVA: 0x1633a6c
	void LateUpdate() { }
	// RVA: 0x1633b98
	void .ctor() { }
}

// TypeDefIndex: 5400
class Zoom
{
	UnityEngine.Camera cam;
	float defaultFOV;
	float maxZoomFOV;
	float currentZoom;
	float sensitivity;
	// RVA: 0x1633ba8
	void Awake() { }
	// RVA: 0x1633c60
	void Update() { }
	// RVA: 0x1633cd8
	void .ctor() { }
}

// TypeDefIndex: 5401
class FirstPersonLook
{
	FirstPersonLook instance;
	UnityEngine.Transform camAnchor;
	UnityEngine.Rigidbody playerRigidbody;
	UnityEngine.Camera[] playerCamerasForZoom;
	float camHeight;
	float <defaultFov>k__BackingField;
	ZoomState currentZoomState;
	float zoomWhenFocusing;
	float zoomWhenRunning;
	DG.Tweening.Tween zoomTween;
	float sensitivity;
	float smoothing;
	bool isMouseInverted;
	UnityEngine.Vector2 velocity;
	UnityEngine.Vector2 frameVelocity;
	// property defaultFov
	// RVA: 0x1633cf4
	float get_defaultFov() { }
	// RVA: 0x1633cfc
	void set_defaultFov(float value) { }
	// RVA: 0x1633d04
	void Awake() { }
	// RVA: 0x1633fe8
	void Update() { }
	// RVA: 0x1633f18
	void SetSensitivity(float _newValue) { }
	// RVA: 0x1633f84
	void SetMouseInverted(bool _inverted) { }
	// RVA: 0x1633e40
	void SetFov(int _newValue) { }
	// RVA: 0x163446c
	void SetZoom(ZoomState _newZoomState) { }
	// RVA: 0x16342a0
	void DisableZoom() { }
	// RVA: 0x16345dc
	void ZoomBackToThrow(float _percentage) { }
	// RVA: 0x1634774
	void .ctor() { }
}

// TypeDefIndex: 5402
class ZoomState
{
	int value__;
	ZoomState Normal;
	ZoomState Zooming;
	ZoomState Running;
}

// TypeDefIndex: 5403
class FirstPersonMovement
{
	FirstPersonMovement instance;
	FirstPersonLook firstPersonLook;
	float walkSpeed;
	UnityEngine.Transform camAnchor;
	bool <isZooming>k__BackingField;
	UnityEngine.KeyCode zoomKey;
	float zoomSpeed;
	bool <isRunning>k__BackingField;
	float runSpeed;
	UnityEngine.KeyCode runningKey;
	bool <isCrouching>k__BackingField;
	DG.Tweening.Tween crouchTween;
	float camLocalYWhenStanding;
	float crouchSpeed;
	float crouchPercentage;
	UnityEngine.KeyCode crouchKey;
	UnityEngine.Rigidbody rb;
	// property isZooming
	// property isRunning
	// property isCrouching
	// RVA: 0x1634790
	bool get_isZooming() { }
	// RVA: 0x1634798
	void set_isZooming(bool value) { }
	// RVA: 0x16347a4
	bool get_isRunning() { }
	// RVA: 0x16347ac
	void set_isRunning(bool value) { }
	// RVA: 0x16347b8
	bool get_isCrouching() { }
	// RVA: 0x16347c0
	void set_isCrouching(bool value) { }
	// RVA: 0x16347cc
	void Awake() { }
	// RVA: 0x163496c
	void Start() { }
	// RVA: 0x16349c0
	void OnDestroy() { }
	// RVA: 0x1634ae4
	void FreezeCharacterPhysics(bool freeze) { }
	// RVA: 0x1634b04
	void FixedUpdate() { }
	// RVA: 0x16350a0
	void Crouch(bool _crouch) { }
	// RVA: 0x1635258
	void .ctor() { }
}

// TypeDefIndex: 5404
class FirstPersonController
{
	UnityEngine.Rigidbody rb;
	UnityEngine.Camera playerCamera;
	float fov;
	bool invertCamera;
	bool cameraCanMove;
	float mouseSensitivity;
	float maxLookAngle;
	bool lockCursor;
	bool crosshair;
	UnityEngine.Sprite crosshairImage;
	UnityEngine.Color crosshairColor;
	float yaw;
	float pitch;
	UnityEngine.UI.Image crosshairObject;
	bool enableZoom;
	bool holdToZoom;
	UnityEngine.KeyCode zoomKey;
	float zoomFOV;
	float zoomStepTime;
	bool isZoomed;
	bool playerCanMove;
	float walkSpeed;
	float maxVelocityChange;
	bool isWalking;
	bool enableSprint;
	bool unlimitedSprint;
	UnityEngine.KeyCode sprintKey;
	float sprintSpeed;
	float sprintDuration;
	float sprintCooldown;
	float sprintFOV;
	float sprintFOVStepTime;
	bool useSprintBar;
	bool hideBarWhenFull;
	UnityEngine.UI.Image sprintBarBG;
	UnityEngine.UI.Image sprintBar;
	float sprintBarWidthPercent;
	float sprintBarHeightPercent;
	UnityEngine.CanvasGroup sprintBarCG;
	bool isSprinting;
	float sprintRemaining;
	float sprintBarWidth;
	float sprintBarHeight;
	bool isSprintCooldown;
	float sprintCooldownReset;
	bool enableJump;
	UnityEngine.KeyCode jumpKey;
	float jumpPower;
	bool isGrounded;
	bool enableCrouch;
	bool holdToCrouch;
	UnityEngine.KeyCode crouchKey;
	float crouchHeight;
	float speedReduction;
	bool isCrouched;
	UnityEngine.Vector3 originalScale;
	bool enableHeadBob;
	UnityEngine.Transform joint;
	float bobSpeed;
	UnityEngine.Vector3 bobAmount;
	UnityEngine.Vector3 jointOriginalPos;
	float timer;
	float camRotation;
	// RVA: 0x1635260
	void Awake() { }
	// RVA: 0x1635364
	void Start() { }
	// RVA: 0x1635540
	void Update() { }
	// RVA: 0x1635e04
	void FixedUpdate() { }
	// RVA: 0x1635a4c
	void CheckGround() { }
	// RVA: 0x163596c
	void Jump() { }
	// RVA: 0x16359c8
	void Crouch() { }
	// RVA: 0x1635c50
	void HeadBob() { }
	// RVA: 0x16360cc
	void .ctor() { }
}

// TypeDefIndex: 5405
class Inputs
{
	string FixedLeftJoystickPreferenceKey;
	PinePie.SimpleJoystick.JoystickController joyMove;
	PinePie.SimpleJoystick.JoystickController joyCam;
	TouchArea touchCam;
	UI_Selectable btnZoom;
	UI_Selectable btnCrouch;
	UI_Selectable btnRunning;
	UI_Selectable btnLeft;
	UI_Selectable btnRight;
	UnityEngine.Vector2 joySpeed;
	System.Collections.Generic.Dictionary<string, int> items;
	GrabableItem itemGrab;
	InteractableItem itemFocus;
	MissionId missionFocus;
	Inputs <Inst>k__BackingField;
	bool <Zoom>k__BackingField;
	bool <Crouch>k__BackingField;
	bool <Running>k__BackingField;
	bool <IsLeftJoystickFixed>k__BackingField;
	// property Inst
	// property Zoom
	// property Crouch
	// property Running
	// property IsLeftJoystickFixed
	// RVA: 0x1636190
	Inputs get_Inst() { }
	// RVA: 0x16361d8
	void set_Inst(Inputs value) { }
	// RVA: 0x1636230
	bool get_Zoom() { }
	// RVA: 0x1636278
	void set_Zoom(bool value) { }
	// RVA: 0x16362c8
	bool get_Crouch() { }
	// RVA: 0x1636310
	void set_Crouch(bool value) { }
	// RVA: 0x1636360
	bool get_Running() { }
	// RVA: 0x16363a8
	void set_Running(bool value) { }
	// RVA: 0x16363f8
	bool get_IsLeftJoystickFixed() { }
	// RVA: 0x1636440
	void set_IsLeftJoystickFixed(bool value) { }
	// RVA: 0x1636490
	void Awake() { }
	// RVA: 0x1636790
	void Start() { }
	// RVA: 0x163699c
	void OnDestroy() { }
	// RVA: 0x1636a70
	void Update() { }
	// RVA: 0x1636b60
	void OnZoomPointerPressed(int pointerId) { }
	// RVA: 0x16367e8
	void SetLeftJoystickFixed(bool isFixed, bool savePreference) { }
	// RVA: 0x1634324
	UnityEngine.Vector2 GetCam(UnityEngine.Vector2 v, float yScale) { }
	// RVA: 0x1635144
	UnityEngine.Vector2 GetMove(UnityEngine.Vector2 v) { }
	// RVA: 0x1636bd8
	bool GetLeft(bool v) { }
	// RVA: 0x1636cb8
	bool GetRight(bool v) { }
	// RVA: 0x1636d98
	UI_Selectable GetMouse(int p) { }
	// RVA: 0x1636e3c
	bool GetMouseButtonDown(int p) { }
	// RVA: 0x1636ef4
	bool GetMouseButtonUp(int p) { }
	// RVA: 0x1636fac
	bool GetMouseButton(int p) { }
	// RVA: 0x1636610
	void Update_Hover() { }
	// RVA: 0x1637064
	void FreshBtn() { }
	// RVA: 0x1637250
	void .ctor() { }
}

// TypeDefIndex: 5406
class TouchArea
{
	int NoPointer;
	UnityEngine.Vector2 speed;
	int capturedPointerId;
	UnityEngine.Vector2 previousPointerPosition;
	UnityEngine.Vector2 <Delta>k__BackingField;
	// property Delta
	// property HasCapturedPointer
	// RVA: 0x16372a8
	UnityEngine.Vector2 get_Delta() { }
	// RVA: 0x16372b0
	void set_Delta(UnityEngine.Vector2 value) { }
	// RVA: 0x1636b4c
	bool get_HasCapturedPointer() { }
	// RVA: 0x16372b8
	void OnDisable() { }
	// RVA: 0x1636b78
	void CapturePointer(int pointerId) { }
	// RVA: 0x1637310
	void Update() { }
	// RVA: 0x1637414
	void UpdateCapturedMouse() { }
	// RVA: 0x1637468
	void ReleaseCapturedPointer() { }
	// RVA: 0x16374c0
	void OnDrag(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x163750c
	void LateUpdate() { }
	// RVA: 0x163755c
	void .ctor() { }
}

// TypeDefIndex: 5407
class Manager_Mobile.<>c
{
	Manager_Mobile+<>c <>9;
	UnityEngine.Events.UnityAction<UnityEngine.EventSystems.BaseEventData> <>9__14_3;
	UnityEngine.Events.UnityAction<bool> <>9__15_0;
	// RVA: 0x163a1dc
	void .cctor() { }
	// RVA: 0x163a244
	void .ctor() { }
	// RVA: 0x163a24c
	void <Init_OptionUI_Btns>b__14_3(UnityEngine.EventSystems.BaseEventData o) { }
	// RVA: 0x163a2e8
	void <InitFixedLeftJoystickToggle>b__15_0(bool isFixed) { }
}

// TypeDefIndex: 5408
class Manager_Mobile.<>c__DisplayClass12_0
{
	DialogDisplayer ui;
	// RVA: 0x16395e4
	void .ctor() { }
	// RVA: 0x163a360
	void <Init_DialogUI>b__0(UnityEngine.EventSystems.BaseEventData o) { }
	// RVA: 0x163a380
	void <Init_DialogUI>b__1(UnityEngine.EventSystems.BaseEventData o) { }
}

// TypeDefIndex: 5409
class Manager_Mobile.<>c__DisplayClass14_0
{
	UIOptionsInGame ui;
	Manager_Mobile <>4__this;
	// RVA: 0x163972c
	void .ctor() { }
	// RVA: 0x163a3a0
	void <Init_OptionUI_Btns>b__0(UnityEngine.EventSystems.BaseEventData o) { }
	// RVA: 0x163a3bc
	void <Init_OptionUI_Btns>b__1(UnityEngine.EventSystems.BaseEventData o) { }
	// RVA: 0x163a420
	void <Init_OptionUI_Btns>b__2(UnityEngine.EventSystems.BaseEventData o) { }
}

// TypeDefIndex: 5410
class Manager_Mobile
{
	Manager_Mobile <Inst>k__BackingField;
	UnityEngine.GameObject prefabUI;
	UnityEngine.GameObject mobileUI;
	// property Inst
	// property TimeMul
	// RVA: 0x16375bc
	Manager_Mobile get_Inst() { }
	// RVA: 0x1637604
	void set_Inst(Manager_Mobile value) { }
	// RVA: 0x163765c
	float get_TimeMul() { }
	// RVA: 0x1637664
	void Init() { }
	// RVA: 0x1637814
	void Awake() { }
	// RVA: 0x16378b8
	void OnDestroy() { }
	// RVA: 0x163795c
	void OnSceneLoaded(UnityEngine.SceneManagement.Scene scene, UnityEngine.SceneManagement.LoadSceneMode mode) { }
	// RVA: 0x1637b28
	void Init_DialogUI() { }
	// RVA: 0x1637e08
	void Init_OptionUI_Content() { }
	// RVA: 0x1637f14
	void Init_OptionUI_Btns() { }
	// RVA: 0x1639924
	void InitFixedLeftJoystickToggle(UIOptionsInGame ui) { }
	// RVA: 0x1639d88
	void RefreshFixedLeftJoystickToggle() { }
	// RVA: 0x1639bf4
	void RefreshFixedLeftJoystickToggle(UnityEngine.UI.Toggle toggle) { }
	// RVA: 0x1639acc
	UnityEngine.UI.Toggle FindFixedLeftJoystickToggle(UIOptionsInGame ui) { }
	// RVA: 0x1638c04
	void Init_MissionUI() { }
	// RVA: 0x1638fec
	void Init_Other() { }
	// RVA: 0x16391e8
	void Init_SafeArea() { }
	// RVA: 0x1639354
	void Init_Scene(UnityEngine.SceneManagement.Scene scene) { }
	// RVA: 0x16395ec
	void AddBtnTrigger(UnityEngine.GameObject btn, UnityEngine.Events.UnityAction<UnityEngine.EventSystems.BaseEventData> act) { }
	// RVA: 0x16397c4
	void AddSafeWindow(UnityEngine.Transform ui, int count) { }
	// RVA: 0x163a078
	void AddSafeArea(UnityEngine.Transform ui, bool x, bool y) { }
	// RVA: 0x1639e1c
	UnityEngine.RectTransform FitToParent(UnityEngine.GameObject ui, UnityEngine.Transform parent) { }
	// RVA: 0x163a120
	void FitToEdge(UnityEngine.RectTransform rect, float left, float right, float top, float bottom) { }
	// RVA: 0x163989c
	void AnchorParent(UnityEngine.GameObject rect, UnityEngine.RectTransform parent, float x, float y, bool halfY) { }
	// RVA: 0x163a164
	void AnchorParent(UnityEngine.RectTransform rect, UnityEngine.RectTransform parent, float x, float y, bool halfY) { }
	// RVA: 0x1639734
	void ExtendPadding(UnityEngine.GameObject obj, float l, float r, float u, float d) { }
	// RVA: 0x163a1d4
	void .ctor() { }
}

// TypeDefIndex: 5411
class MobileControlLayoutEditor.Control
{
	UnityEngine.RectTransform rect;
	UnityEngine.RectTransform positionRect;
	UnityEngine.GameObject dottedLine;
	UnityEngine.Vector2 defaultPosition;
	UnityEngine.Vector3 defaultScale;
	bool isJoystick;
	// RVA: 0x163c108
	void .ctor() { }
}

// TypeDefIndex: 5412
class MobileControlLayoutEditor.CanvasGroupState
{
	UnityEngine.CanvasGroup group;
	float defaultAlpha;
}

// TypeDefIndex: 5413
class MobileControlLayoutEditor.BehaviourState
{
	UnityEngine.Behaviour behaviour;
	bool wasEnabled;
}

// TypeDefIndex: 5414
class MobileControlLayoutEditor.LayoutState
{
	float opacity;
	float scale;
	UnityEngine.Vector2[] positions;
	// RVA: 0x163b708
	void .ctor() { }
}

// TypeDefIndex: 5415
class MobileControlLayoutEditor.MobileControlLayoutDragTarget
{
	MobileControlLayoutEditor owner;
	MobileControlLayoutEditor+Control control;
	UnityEngine.Vector2 pointerOffset;
	// RVA: 0x163c110
	void Initialize(MobileControlLayoutEditor editor, MobileControlLayoutEditor+Control target) { }
	// RVA: 0x163d8e4
	void OnPointerDown(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x163db78
	void OnDrag(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x163d974
	bool CanMove() { }
	// RVA: 0x163d990
	bool TryGetAnchoredPointerPosition(UnityEngine.EventSystems.PointerEventData eventData, UnityEngine.Vector2& anchoredPosition) { }
	// RVA: 0x163dbf8
	UnityEngine.Vector2 ClampToParent(UnityEngine.Vector2 position) { }
	// RVA: 0x163dedc
	void .ctor() { }
}

// TypeDefIndex: 5416
class MobileControlLayoutEditor.<>c
{
	MobileControlLayoutEditor+<>c <>9;
	System.Predicate<MobileControlLayoutEditor+Control> <>9__42_0;
	// RVA: 0x163dee4
	void .cctor() { }
	// RVA: 0x163df4c
	void .ctor() { }
	// RVA: 0x163df54
	bool <DisableJoystickInputAndAddDragOverlay>b__42_0(MobileControlLayoutEditor+Control control) { }
}

// TypeDefIndex: 5417
class MobileControlLayoutEditor
{
	float minimumOpacity;
	float maximumOpacity;
	float defaultOpacity;
	float minimumScale;
	float maximumScale;
	float defaultScale;
	string PrefsPrefix;
	System.Collections.Generic.List<MobileControlLayoutEditor+Control> controls;
	System.Collections.Generic.List<MobileControlLayoutEditor+CanvasGroupState> opacityGroups;
	System.Collections.Generic.List<MobileControlLayoutEditor+BehaviourState> disabledActionInput;
	UnityEngine.GameObject setting;
	UnityEngine.Canvas optionsCanvas;
	bool optionsCanvasWasEnabled;
	UnityEngine.Transform actionRoot;
	PinePie.SimpleJoystick.JoystickController joystickController;
	bool joystickControllerWasEnabled;
	UnityEngine.GameObject joystickDragOverlay;
	bool leftWasActive;
	bool rightWasActive;
	UnityEngine.UI.Slider opacitySlider;
	UnityEngine.UI.Slider sizeSlider;
	TMPro.TMP_Text opacityPercent;
	TMPro.TMP_Text sizePercent;
	MobileControlLayoutEditor+LayoutState savedState;
	bool initialized;
	bool editing;
	// property IsEditing
	// RVA: 0x163a564
	void Awake() { }
	// RVA: 0x163a49c
	void Open() { }
	// RVA: 0x163af84
	void Save() { }
	// RVA: 0x163b304
	void Cancel() { }
	// RVA: 0x163b58c
	void RestoreDefaults() { }
	// RVA: 0x163a568
	void Initialize() { }
	// RVA: 0x163b710
	void ConfigureSlider(UnityEngine.UI.Slider slider, float minimum, float maximum, UnityEngine.Events.UnityAction<float> callback) { }
	// RVA: 0x163ba78
	void CollectEditableControls() { }
	// RVA: 0x163b800
	void CollectOpacityGroups() { }
	// RVA: 0x163ae00
	void BeginEditingInputOverride() { }
	// RVA: 0x163ac7c
	void DisableOptionsCanvas() { }
	// RVA: 0x163ca34
	void RestoreOptionsCanvas() { }
	// RVA: 0x163c140
	void DisableJoystickInputAndAddDragOverlay() { }
	// RVA: 0x163c698
	void DisableActionInput() { }
	// RVA: 0x163cadc
	void DisableAndRemember(UnityEngine.Behaviour behaviour) { }
	// RVA: 0x163c820
	void SetHandButtonsVisible(bool visible) { }
	// RVA: 0x163cc0c
	void RestoreEditingInputOverride() { }
	// RVA: 0x163bebc
	MobileControlLayoutEditor+LayoutState LoadState() { }
	// RVA: 0x163b11c
	void SaveState(MobileControlLayoutEditor+LayoutState state) { }
	// RVA: 0x163ce8c
	string PositionKey(int index, string axis) { }
	// RVA: 0x163ab0c
	MobileControlLayoutEditor+LayoutState CaptureState() { }
	// RVA: 0x163afe4
	void ApplyJoystickRestPosition(MobileControlLayoutEditor+LayoutState state) { }
	// RVA: 0x163b330
	void ApplyState(MobileControlLayoutEditor+LayoutState state) { }
	// RVA: 0x163cf14
	void SetOpacity(float value) { }
	// RVA: 0x163d224
	void SetScale(float value) { }
	// RVA: 0x163d628
	void Select(MobileControlLayoutEditor+Control selected) { }
	// RVA: 0x163d798
	bool get_IsEditing() { }
	// RVA: 0x163ae24
	void HideAllDottedLines() { }
	// RVA: 0x163d524
	void UpdateJoystickDottedLine(MobileControlLayoutEditor+Control control) { }
	// RVA: 0x163b274
	void CloseEditor() { }
	// RVA: 0x163d7a0
	void .ctor() { }
}

// TypeDefIndex: 5418
class Text_Mobile
{
	Text_Mobile Inst;
	UnityEngine.TextAsset textAsset;
	TMPro.TMP_Text version;
	TMPro.TMP_SpriteAsset sprAst;
	System.Collections.Generic.Dictionary<string, string> dic;
	string escText;
	// RVA: 0x163df6c
	void Awake() { }
	// RVA: 0x163e2c4
	void OnDestroy() { }
	// RVA: 0x163e318
	void Update() { }
	// RVA: 0x163e260
	void BindEmoji(UnityEngine.GameObject obj) { }
	// RVA: 0x163e31c
	string GetText(string key, string v) { }
	// RVA: 0x163e4fc
	void .ctor() { }
}

// TypeDefIndex: 5419
class UI_Cheat_Mobile.<ApplyUI>d__5
{
	int <>1__state;
	object <>2__current;
	UI_Cheat_Mobile <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x163e590
	void .ctor(int <>1__state) { }
	// RVA: 0x163e74c
	void System.IDisposable.Dispose() { }
	// RVA: 0x163e750
	bool MoveNext() { }
	// RVA: 0x163e9e8
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x163e9f0
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x163ea28
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5420
class UI_Cheat_Mobile
{
	UI_Selectable btnPlus;
	UI_Selectable btnMinus;
	System.Collections.Generic.List<UI_Selectable> deviceIDs;
	bool active;
	// RVA: 0x163e504
	void OnEnable() { }
	// RVA: 0x163e524
	System.Collections.IEnumerator ApplyUI() { }
	// RVA: 0x163e5b8
	void Update() { }
	// RVA: 0x163e744
	void .ctor() { }
}

// TypeDefIndex: 5421
class UI_GameMode
{
	UnityEngine.RectTransform icon;
	UnityEngine.RectTransform title;
	UnityEngine.RectTransform mode;
	UnityEngine.RectTransform body;
	UnityEngine.RectTransform slider;
	TMPro.TMP_Text desc;
	TMPro.TMP_Text tips;
	// property TextSize_Mode
	// property TextSize_Title
	// property TextSize_Desc
	// RVA: 0x163ea30
	float get_TextSize_Mode() { }
	// RVA: 0x163ea38
	float get_TextSize_Title() { }
	// RVA: 0x163ea40
	float get_TextSize_Desc() { }
	// RVA: 0x163ea48
	void Awake() { }
	// RVA: 0x163ed30
	void OnEnable() { }
	// RVA: 0x163ea4c
	void Init_Setup() { }
	// RVA: 0x163ed60
	void Init_Base() { }
	// RVA: 0x163f18c
	void Init_Tutorial() { }
	// RVA: 0x163f2e4
	void Init_Practice() { }
	// RVA: 0x163f3e8
	void Init_Normal() { }
	// RVA: 0x163f4d0
	void Init_Pomodoro() { }
	// RVA: 0x163f570
	void FitArea(UnityEngine.RectTransform rect, float left, float right, float up, float down) { }
	// RVA: 0x163f68c
	void .ctor() { }
}

// TypeDefIndex: 5422
class UI_ModePotato
{
	UnityEngine.RectTransform icon;
	UnityEngine.RectTransform slider;
	TMPro.TMP_Text time;
	UnityEngine.RectTransform btnStart;
	UnityEngine.RectTransform btnStop;
	UnityEngine.RectTransform btnPause;
	UnityEngine.RectTransform btnContinue;
	// RVA: 0x163f694
	void Awake() { }
	// RVA: 0x163f994
	void OnEnable() { }
	// RVA: 0x163fb44
	void Init_Btn(UnityEngine.RectTransform btn, float y) { }
	// RVA: 0x163fd00
	void .ctor() { }
}

// TypeDefIndex: 5423
class UI_Selectable
{
	bool <IsHolding>k__BackingField;
	bool <IsClick>k__BackingField;
	bool <IsDown>k__BackingField;
	bool <IsUp>k__BackingField;
	bool <IsOn>k__BackingField;
	UnityEngine.UI.Image content;
	UnityEngine.UI.Image icon;
	UnityEngine.UI.Image mark;
	System.Action<int> PointerPressed;
	// property IsHolding
	// property IsClick
	// property IsDown
	// property IsUp
	// property IsOn
	// RVA: 0x163fd08
	bool get_IsHolding() { }
	// RVA: 0x163fd10
	void set_IsHolding(bool value) { }
	// RVA: 0x163fd1c
	bool get_IsClick() { }
	// RVA: 0x163fd24
	void set_IsClick(bool value) { }
	// RVA: 0x163fd30
	bool get_IsDown() { }
	// RVA: 0x163fd38
	void set_IsDown(bool value) { }
	// RVA: 0x163fd44
	bool get_IsUp() { }
	// RVA: 0x163fd4c
	void set_IsUp(bool value) { }
	// RVA: 0x163fd58
	bool get_IsOn() { }
	// RVA: 0x163fd60
	void set_IsOn(bool value) { }
	// RVA: 0x163fd6c
	void add_PointerPressed(System.Action<int> value) { }
	// RVA: 0x163fe1c
	void remove_PointerPressed(System.Action<int> value) { }
	// RVA: 0x163fecc
	void OnDisable() { }
	// RVA: 0x163fed4
	void OnPointerDown(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x163ff14
	void OnPointerUp(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x163ff24
	void OnPointerExit(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x163ff30
	void OnPointerClick(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x163ffb0
	void LateUpdate() { }
	// RVA: 0x16400e0
	void .ctor() { }
}

// TypeDefIndex: 5424
class UI_OptionTab.<ApplyLayout>d__8
{
	int <>1__state;
	object <>2__current;
	UnityEngine.GameObject obj;
	UI_OptionTab <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x164053c
	void .ctor(int <>1__state) { }
	// RVA: 0x1640578
	void System.IDisposable.Dispose() { }
	// RVA: 0x164057c
	bool MoveNext() { }
	// RVA: 0x16407bc
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16407c4
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16407fc
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5425
class UI_OptionTab
{
	float border;
	float scale;
	TMPro.TMP_Text[] texts;
	// RVA: 0x16400e8
	void Awake() { }
	// RVA: 0x164047c
	void OnEnable() { }
	// RVA: 0x1640534
	void Set(float border, float scale) { }
	// RVA: 0x16403a0
	void AddIgnore(UnityEngine.GameObject obj) { }
	// RVA: 0x1640208
	void AddBG() { }
	// RVA: 0x16404ac
	System.Collections.IEnumerator ApplyLayout(UnityEngine.GameObject obj) { }
	// RVA: 0x1640564
	void .ctor() { }
}

// TypeDefIndex: 5426
class UI_ToggleLink
{
	UnityEngine.CanvasGroup canvas;
	System.Collections.Generic.List<UnityEngine.GameObject> list;
	// RVA: 0x1640804
	void Add(UnityEngine.GameObject obj) { }
	// RVA: 0x164093c
	void Update() { }
	// RVA: 0x1640ab8
	void .ctor() { }
}

// TypeDefIndex: 5427
class Outline.Mode
{
	int value__;
	Outline+Mode OutlineVisible;
	Outline+Mode OutlineAll;
	Outline+Mode OutlineHidden;
	Outline+Mode OutlineAndSilhouette;
	Outline+Mode SilhouetteOnly;
}

// TypeDefIndex: 5428
class Outline.ListVector3
{
	System.Collections.Generic.List<UnityEngine.Vector3> data;
	// RVA: 0x16425d8
	void .ctor() { }
}

// TypeDefIndex: 5429
class Outline.<>c
{
	Outline+<>c <>9;
	System.Func<UnityEngine.Renderer, bool> <>9__22_0;
	System.Func<UnityEngine.Vector3, int, System.Collections.Generic.KeyValuePair<UnityEngine.Vector3, int>> <>9__31_0;
	System.Func<System.Collections.Generic.KeyValuePair<UnityEngine.Vector3, int>, UnityEngine.Vector3> <>9__31_1;
	// RVA: 0x164280c
	void .cctor() { }
	// RVA: 0x1642874
	void .ctor() { }
	// RVA: 0x164287c
	bool <Awake>b__22_0(UnityEngine.Renderer r) { }
	// RVA: 0x16428d8
	System.Collections.Generic.KeyValuePair<UnityEngine.Vector3, int> <SmoothNormals>b__31_0(UnityEngine.Vector3 vertex, int index) { }
	// RVA: 0x1642960
	UnityEngine.Vector3 <SmoothNormals>b__31_1(System.Collections.Generic.KeyValuePair<UnityEngine.Vector3, int> pair) { }
}

// TypeDefIndex: 5430
class Outline
{
	System.Collections.Generic.HashSet<UnityEngine.Mesh> registeredMeshes;
	Outline+Mode outlineMode;
	UnityEngine.Color outlineColor;
	float outlineWidth;
	bool precomputeOutline;
	System.Collections.Generic.List<UnityEngine.Mesh> bakeKeys;
	System.Collections.Generic.List<Outline+ListVector3> bakeValues;
	UnityEngine.Renderer[] renderers;
	UnityEngine.Material outlineMaskMaterial;
	UnityEngine.Material outlineFillMaterial;
	bool needsUpdate;
	// property OutlineMode
	// property OutlineColor
	// property OutlineWidth
	// RVA: 0x1640ac0
	Outline+Mode get_OutlineMode() { }
	// RVA: 0x1640ac8
	void set_OutlineMode(Outline+Mode value) { }
	// RVA: 0x1640ad8
	UnityEngine.Color get_OutlineColor() { }
	// RVA: 0x1640ae4
	void set_OutlineColor(UnityEngine.Color value) { }
	// RVA: 0x1640af8
	float get_OutlineWidth() { }
	// RVA: 0x1640b00
	void set_OutlineWidth(float value) { }
	// RVA: 0x1640b10
	void Awake() { }
	// RVA: 0x1641130
	void EnableOutline(bool on) { }
	// RVA: 0x164113c
	void OnEnable() { }
	// RVA: 0x1641318
	void OnValidate() { }
	// RVA: 0x16416a0
	void Update() { }
	// RVA: 0x1641888
	void OnDisable() { }
	// RVA: 0x16419d0
	void OnDestroy() { }
	// RVA: 0x1641430
	void Bake() { }
	// RVA: 0x1640dc0
	void LoadSmoothNormals() { }
	// RVA: 0x1641a38
	System.Collections.Generic.List<UnityEngine.Vector3> SmoothNormals(UnityEngine.Mesh mesh) { }
	// RVA: 0x16425e0
	void CombineSubmeshes(UnityEngine.Mesh mesh, UnityEngine.Material[] materials) { }
	// RVA: 0x16416b4
	void UpdateMaterialProperties() { }
	// RVA: 0x1642688
	void .ctor() { }
	// RVA: 0x1642774
	void .cctor() { }
}

// TypeDefIndex: 5431
class ReasonsToBuyBurgiesCozyKitchen
{
	// RVA: 0x16429ac
	void PlayBurgies(Gamemode gamemode) { }
	// RVA: 0x16429b0
	bool ShouldIPurchaseIt() { }
	// RVA: 0x16429b8
	void .ctor() { }
}

// TypeDefIndex: 5432
class AdRewardType
{
	int value__;
	AdRewardType AdCoupon;
	AdRewardType CustomerDoubleReward;
	AdRewardType InstantKitchenRestock;
}

// TypeDefIndex: 5433
class AdRewardSystem
{
	int AdFreeWatchRequirement;
	int CustomerDoubleRewardDurationSeconds;
	int CoinValuePerAdCoupon;
	System.Action StateChanged;
	// property AdWatchCount
	// property AdCoupons
	// property IsAdFreeUnlocked
	// property CanClaimRewardWithoutAd
	// property CustomerRewardMultiplier
	// property CustomerDoubleRewardRemainingSeconds
	// property IsCustomerDoubleRewardActive
	// RVA: 0x16429c0
	void add_StateChanged(System.Action value) { }
	// RVA: 0x1642a78
	void remove_StateChanged(System.Action value) { }
	// RVA: 0x1642b30
	int get_AdWatchCount() { }
	// RVA: 0x1642b88
	int get_AdCoupons() { }
	// RVA: 0x1642be0
	bool get_IsAdFreeUnlocked() { }
	// RVA: 0x1642bf8
	bool get_CanClaimRewardWithoutAd() { }
	// RVA: 0x1642c10
	float get_CustomerRewardMultiplier() { }
	// RVA: 0x1642c58
	int get_CustomerDoubleRewardRemainingSeconds() { }
	// RVA: 0x1642c38
	bool get_IsCustomerDoubleRewardActive() { }
	// RVA: 0x1642de0
	bool GrantRewardAfterAd(AdRewardType rewardType) { }
	// RVA: 0x164300c
	bool GrantAdFreeReward(AdRewardType rewardType) { }
	// RVA: 0x1643038
	bool TryRedeemAdCouponForCoins() { }
	// RVA: 0x1643198
	void GrantAdCoupons(int amount) { }
	// RVA: 0x164328c
	void GrantPermanentAdFree() { }
	// RVA: 0x16433b0
	bool TryConsumeAdCoupon() { }
	// RVA: 0x16433b8
	bool TryConsumeAdCoupons(int amount) { }
	// RVA: 0x16430f4
	void ConsumeAdCoupon() { }
	// RVA: 0x1642e98
	bool GrantReward(AdRewardType rewardType) { }
	// RVA: 0x1643478
	void AddCustomerDoubleRewardDuration() { }
	// RVA: 0x1642cc8
	long GetCustomerDoubleRewardEndUtc() { }
	// RVA: 0x1642d74
	long CurrentUnixTimeSeconds() { }
}

// TypeDefIndex: 5434
class AlbumPageChange
{
	bool isPageForward;
	CardAlbum cardAlbum;
	// property Interact_Left
	// property Interact_Right
	// RVA: 0x1643520
	void RightInteract() { }
	// RVA: 0x16436a4
	void Interact() { }
	// RVA: 0x16436b0
	bool get_Interact_Left() { }
	// RVA: 0x16436b8
	bool get_Interact_Right() { }
	// RVA: 0x16436c0
	void .ctor() { }
}

// TypeDefIndex: 5435
class AlleyObstacles
{
	AlleyObstacles instance;
	// RVA: 0x16436c8
	void Awake() { }
	// RVA: 0x1643720
	void .ctor() { }
}

// TypeDefIndex: 5436
class Analytics
{
	float timeCounter;
	int totalPlaytime;
	int totalEarnedMoney;
	int totalWastedMoney;
	int startingMoney;
	// RVA: 0x1643728
	void Awake() { }
	// RVA: 0x16437f4
	void Update() { }
	// RVA: 0x164384c
	void AddMinute() { }
	// RVA: 0x16438cc
	void AddEarnedMoney(int newAmount) { }
	// RVA: 0x1643958
	void AddWastedMoney(int newAmount) { }
	// RVA: 0x16439e4
	int GetEarningMoneyPerHour() { }
	// RVA: 0x1643b10
	void .ctor() { }
}

// TypeDefIndex: 5437
class AudioManager
{
	AudioManager instance;
	UnityEngine.Audio.AudioMixer audioMixer;
	float musicVolume;
	float sfxVolume;
	float ambienceVolume;
	System.Action callbackOnMusicVolumeChange;
	bool appIsFocused;
	bool musicSoundsOnBg;
	bool sfxSoundsOnBg;
	bool ambienceSoundsOnBg;
	System.Collections.Generic.Dictionary<SoundId, System.Collections.Generic.List<UnityEngine.AudioClip>> sfxDict;
	// RVA: 0x1643b18
	void Awake() { }
	// RVA: 0x16440cc
	void Start() { }
	// RVA: 0x164420c
	void OnDestroy() { }
	// RVA: 0x164430c
	void OnApplicationFocus(bool _focus) { }
	// RVA: 0x1643f80
	void LoadAudioConfig() { }
	// RVA: 0x16441d4
	void ApplyCurrentVolumeConfig() { }
	// RVA: 0x1644310
	void OnWindowModeChange() { }
	// RVA: 0x1644670
	void SetSoundsOnBg(SoundTypes _soundType, bool _enabled) { }
	// RVA: 0x16443ec
	void SetVolume(SoundTypes _soundType, float _value) { }
	// RVA: 0x1644738
	float GetVolume(SoundTypes _soundType) { }
	// RVA: 0x1644768
	bool GetSoundsOnBg(SoundTypes _soundType) { }
	// RVA: 0x1643b80
	void LoadSFXFromResources() { }
	// RVA: 0x16447a4
	UnityEngine.AudioClip GetSFXClip(SoundId _soundToSearch) { }
	// RVA: 0x1644920
	SoundId GetSoundIdFromClip(UnityEngine.AudioClip _soundToSearch) { }
	// RVA: 0x1644aac
	void .ctor() { }
}

// TypeDefIndex: 5438
class SoundTypes
{
	int value__;
	SoundTypes Music;
	SoundTypes Sfx;
	SoundTypes Ambience;
}

// TypeDefIndex: 5439
class SoundId
{
	int value__;
	SoundId None;
	SoundId Bell;
	SoundId Cleaning;
	SoundId PotBoil;
	SoundId PanFry;
	SoundId PanFryLoud;
	SoundId PanFrySoft;
	SoundId PanFireStart;
	SoundId PanFireLoop;
	SoundId PanFireStop;
	SoundId Fireball;
	SoundId StoveOn;
	SoundId StoveOff;
	SoundId SwitchOn;
	SoundId SwitchOff;
	SoundId GetFromWoodCounter;
	SoundId PutOnMetalCounter;
	SoundId GetFromMetalCounter;
	SoundId PutOnStorage;
	SoundId GetFromStorage;
	SoundId PutOnFryingPan;
	SoundId GetFromFryingPan;
	SoundId CookState;
	SoundId TapWater;
	SoundId PutOnDishrack;
	SoundId GetFromDishrack;
	SoundId CuttingBoard;
	SoundId FreezerOpen;
	SoundId FreezerClose;
	SoundId FreezerCreak;
	SoundId FenceOpen;
	SoundId FenceClose;
	SoundId FenceTryOpen;
	SoundId CoinGetSmall;
	SoundId CoinGetMid;
	SoundId CoinGetBig;
	SoundId CoinPutSmall;
	SoundId CoinPutMid;
	SoundId TrashUse;
	SoundId TrashOpen;
	SoundId TrashClose;
	SoundId SplashSauce;
	SoundId CustomerHappy;
	SoundId CustomerDisappoint;
	SoundId CustomerAngry;
	SoundId CustomerTalk;
	SoundId CustomerLeave;
	SoundId UIClick;
	SoundId ToggleSnap;
	SoundId UIToggleOff;
	SoundId UIClickSelectable;
	SoundId UISliderTick;
	SoundId UITwitchConnected;
	SoundId UITwitchError;
	SoundId HeadHit;
	SoundId WolfHowl;
	SoundId ChristmasBells;
	SoundId DrinkPour;
	SoundId DrinkSuddenlyStopped;
	SoundId DrinkKick;
	SoundId DrinkStretch;
	SoundId DrinkDoorOpen;
	SoundId DrinkDoorClose;
	SoundId SoftWhoosh;
	SoundId UICameraSwitch;
	SoundId UIOptionsOn;
	SoundId UIOptionsOff;
	SoundId TabletOn;
	SoundId TabletOff;
	SoundId TabletForward;
	SoundId TabletBack;
	SoundId TabletError;
	SoundId TabletHover;
	SoundId PopOn;
	SoundId PopOff;
	SoundId TypingEnd;
	SoundId TextScroll;
	SoundId PaperAbsorb;
	SoundId SauceSplat;
	SoundId ResetBoxBreak;
	SoundId ResetBoxPunch;
	SoundId OpenDoorWarehouse;
	SoundId WhooshDoorWarehouse;
	SoundId CloseDoorWarehouse;
	SoundId FreezerSlideDoorOpen;
	SoundId FreezerSlideDoorClose;
	SoundId DrawerOpen;
	SoundId DrawerClose;
	SoundId CardOnAlbum;
	SoundId AlbumOpen;
	SoundId AlbumClose;
	SoundId AlbumPage;
	SoundId BoosterOpen;
	SoundId PopClick;
	SoundId WiltCheese;
}

// TypeDefIndex: 5440
class AudioPlayer
{
	bool initializedGlobal;
	bool initializedOneShot;
	bool initializedLooping;
	UnityEngine.AudioSource loopingAS;
	UnityEngine.AudioSource oneShotAS;
	UnityEngine.GameObject globalPlayerGO;
	UnityEngine.AudioSource globalPlayer;
	System.Collections.Generic.Dictionary<SoundId, UnityEngine.AudioSource> globalLoopPlayers;
	float justStartedMinTime;
	bool justInstated;
	bool globalCanPlaySounds;
	// RVA: 0x1644b4c
	void SilenceOnStart(bool _newValue) { }
	// RVA: 0x1644b58
	void Start() { }
	// RVA: 0x1644bd8
	void LateStart() { }
	// RVA: 0x1644be0
	void InitializeGlobal() { }
	// RVA: 0x1644e9c
	void InitializeOneShot() { }
	// RVA: 0x1645048
	void InitializeLooping() { }
	// RVA: 0x16451f4
	void PlaySoundOneShot(SoundId _soundId, float _pitch, bool ignoreIfJustInstated) { }
	// RVA: 0x16452e8
	void PlayLoopSoundWithoutOverriding(SoundId _soundId) { }
	// RVA: 0x16453d4
	void PlayLoopSound(SoundId _soundId) { }
	// RVA: 0x16456c0
	void StopLoopSound(bool stopItGradually) { }
	// RVA: 0x1645560
	void StopLoopSound(SoundId _soundId, bool stopItGradually) { }
	// RVA: 0x16457c4
	void PlayGlobalSound(SoundId _soundId, float _pitch) { }
	// RVA: 0x16458b8
	UnityEngine.AudioSource CreateNewGlobalLoop() { }
	// RVA: 0x1645acc
	void PlayGlobalLoop(SoundId _soundId) { }
	// RVA: 0x1645c2c
	void StopAllGlobalLoops() { }
	// RVA: 0x1645e78
	void StopGlobalLoop(SoundId _soundId) { }
	// RVA: 0x1645fbc
	void .ctor() { }
	// RVA: 0x1645fcc
	void .cctor() { }
	// RVA: 0x1646078
	void <StopLoopSound>b__20_0() { }
	// RVA: 0x16460ac
	void <StopLoopSound>b__21_0() { }
}

// TypeDefIndex: 5441
class AutodestroyOnDaytime
{
	System.Collections.Generic.List<DayTime> daytimesToBeDestroyed;
	// RVA: 0x16460e0
	void Start() { }
	// RVA: 0x16461c8
	void .ctor() { }
}

// TypeDefIndex: 5442
class AutoLoopPunch
{
	bool scalePause;
	float loopsPerSeg;
	float scaleDest;
	bool bigBeat;
	UnityEngine.Transform tr;
	// RVA: 0x1646250
	void Start() { }
	// RVA: 0x16462fc
	void PunchAnim() { }
	// RVA: 0x1646280
	void PlayPauseAnim(bool _isPlaying) { }
	// RVA: 0x16463c0
	void .ctor() { }
}

// TypeDefIndex: 5443
class AutoOffsetMat
{
	UnityEngine.Vector2 movement;
	UnityEngine.Material mat;
	UnityEngine.Vector2 currentOffset;
	// RVA: 0x16463c8
	void Awake() { }
	// RVA: 0x1646480
	void Update() { }
	// RVA: 0x1646534
	void .ctor() { }
}

// TypeDefIndex: 5444
class Autorotate.RotateAxis
{
	int value__;
	Autorotate+RotateAxis x;
	Autorotate+RotateAxis y;
	Autorotate+RotateAxis z;
}

// TypeDefIndex: 5445
class Autorotate
{
	bool rotacionPausada;
	Autorotate+RotateAxis ejeRotacion;
	float vueltasPorSeg;
	UnityEngine.Vector3 rotacion;
	UnityEngine.Transform tr;
	// RVA: 0x164653c
	void Start() { }
	// RVA: 0x164665c
	void Update() { }
	// RVA: 0x16466cc
	void .ctor() { }
}

// TypeDefIndex: 5446
class AutorotateUp
{
	// RVA: 0x16466d4
	void Update() { }
	// RVA: 0x164673c
	void .ctor() { }
}

// TypeDefIndex: 5447
class BadReviewManager
{
	System.Collections.Generic.List<CookingFail> <cookingWarnings>k__BackingField;
	System.Collections.Generic.List<CookingFail> <cookingFails>k__BackingField;
	System.Collections.Generic.List<DeliveryFail> <deliveryFails>k__BackingField;
	System.Collections.Generic.List<CriticalFail> <criticalFails>k__BackingField;
	System.Collections.Generic.List<GoodReview> <goodReviews>k__BackingField;
	bool <toothpickSolvedAnything>k__BackingField;
	System.Collections.Generic.HashSet<GrabableItem> seenDirtyItems;
	// property cookingWarnings
	// property cookingFails
	// property deliveryFails
	// property criticalFails
	// property goodReviews
	// property toothpickSolvedAnything
	// RVA: 0x1646744
	System.Collections.Generic.List<CookingFail> get_cookingWarnings() { }
	// RVA: 0x164674c
	void set_cookingWarnings(System.Collections.Generic.List<CookingFail> value) { }
	// RVA: 0x1646754
	System.Collections.Generic.List<CookingFail> get_cookingFails() { }
	// RVA: 0x164675c
	void set_cookingFails(System.Collections.Generic.List<CookingFail> value) { }
	// RVA: 0x1646764
	System.Collections.Generic.List<DeliveryFail> get_deliveryFails() { }
	// RVA: 0x164676c
	void set_deliveryFails(System.Collections.Generic.List<DeliveryFail> value) { }
	// RVA: 0x1646774
	System.Collections.Generic.List<CriticalFail> get_criticalFails() { }
	// RVA: 0x164677c
	void set_criticalFails(System.Collections.Generic.List<CriticalFail> value) { }
	// RVA: 0x1646784
	System.Collections.Generic.List<GoodReview> get_goodReviews() { }
	// RVA: 0x164678c
	void set_goodReviews(System.Collections.Generic.List<GoodReview> value) { }
	// RVA: 0x1646794
	bool get_toothpickSolvedAnything() { }
	// RVA: 0x164679c
	void set_toothpickSolvedAnything(bool value) { }
	// RVA: 0x16467a8
	bool AddToWarnings(CookingFail cF) { }
	// RVA: 0x16468a0
	int GetWarningsCount() { }
	// RVA: 0x16468e8
	bool AddToCookingFails(CookingFail f) { }
	// RVA: 0x1646c1c
	void AddToDeliveryFails(DeliveryFail f) { }
	// RVA: 0x1646ae0
	void AddToCriticalFails(CriticalFail f) { }
	// RVA: 0x1646d84
	void AddToGoodReviews(GoodReview gR) { }
	// RVA: 0x1646eec
	bool TryConvertWarningToFail(CookingFail cF) { }
	// RVA: 0x1647064
	bool IsWarningOrFailAlreadyOnList(CookingFail cF) { }
	// RVA: 0x16470a0
	bool IsWarningAlreadyOnList(CookingFail cF) { }
	// RVA: 0x16470f8
	bool IsFailAlreadyOnList(CookingFail cF) { }
	// RVA: 0x1647150
	string GetFormattedReviewForTutorial(CustomerOutfit customerOutfit, int shownStars, float remainingTime) { }
	// RVA: 0x1647480
	string GetFormattedReview(CustomerOutfit customerOutfit, int shownStars, float remainingTime) { }
	// RVA: 0x1648ddc
	bool GetSpecialCustomerExclusiveReview(CustomerOutfit customerOutfit, int shownStars, float remainingTime, string& writtenReview) { }
	// RVA: 0x1649568
	string GetSpecialCustomerExtraReview(CustomerOutfit customerOutfit, int shownStars, float remainingTime) { }
	// RVA: 0x164935c
	string GetExtraGoodReviewText() { }
	// RVA: 0x16472b0
	string GetRandomReviewSentence(string reviewId) { }
	// RVA: 0x164969c
	int GetStarSustractionOnDelivery() { }
	// RVA: 0x1649984
	int GetExtraScoreByGoodReviews() { }
	// RVA: 0x1649b8c
	void ClearSolvedOrDobleReviews() { }
	// RVA: 0x1649d04
	void AddSeenDirtyItem(GrabableItem item) { }
	// RVA: 0x1649d5c
	void RemoveSeenDirtyItem(GrabableItem item) { }
	// RVA: 0x1649db4
	void ClearAllSeenDirtyItems() { }
	// RVA: 0x1649e04
	void .ctor() { }
}

// TypeDefIndex: 5448
class CookingFail
{
	int value__;
	CookingFail Floor;
	CookingFail Fire;
	CookingFail BellSpam;
	CookingFail FenceSpam;
	CookingFail WindowLaunch;
	CookingFail Warehouse;
	CookingFail HeadHit;
}

// TypeDefIndex: 5449
class DeliveryFail
{
	int value__;
	DeliveryFail MissMeat;
	DeliveryFail MissVegan;
	DeliveryFail WrongSmashed;
	DeliveryFail RawMeat;
	DeliveryFail BurntFood;
	DeliveryFail MissTomato;
	DeliveryFail MissOnion;
	DeliveryFail MissCaramelizedOnion;
	DeliveryFail MissLettuce;
	DeliveryFail MissCheese;
	DeliveryFail MissDoubleCheese;
	DeliveryFail MissKetchup;
	DeliveryFail MissMayo;
	DeliveryFail MissMustard;
	DeliveryFail MissMayochup;
	DeliveryFail MissMostaneza;
	DeliveryFail MissMostchup;
	DeliveryFail MissBurgineza;
	DeliveryFail MissFavSauce;
	DeliveryFail UniqueMissCards;
	DeliveryFail WrongCardsMale;
	DeliveryFail WrongCardsFemale;
	DeliveryFail UniqueExtraCards;
	DeliveryFail ExtraTomato;
	DeliveryFail ExtraOnion;
	DeliveryFail ExtraLettuce;
	DeliveryFail ExtraCheese;
	DeliveryFail ExtraSauce;
	DeliveryFail LowCooked;
	DeliveryFail HighCooked;
	DeliveryFail Unfresh;
	DeliveryFail Dirty;
	DeliveryFail LightOff;
	DeliveryFail MissSoda;
	DeliveryFail SodaEmpty;
	DeliveryFail SodaMixed;
	DeliveryFail SodaWrong;
	DeliveryFail TrayNotNeeded;
	DeliveryFail VampireLightOn;
	DeliveryFail BurgerLoverBad;
	DeliveryFail Cardboxes;
	DeliveryFail BadKidBored;
}

// TypeDefIndex: 5450
class CriticalFail
{
	int value__;
	CriticalFail Baited;
	CriticalFail FaceClosed;
	CriticalFail TimeOut;
	CriticalFail CriticOnAnyFail;
	CriticalFail HoodRobbed;
	CriticalFail HoodBroken;
	CriticalFail BadKidBellRemoved;
	CriticalFail InstaBurger;
	CriticalFail VampireTrolled;
}

// TypeDefIndex: 5451
class GoodReview
{
	int value__;
	GoodReview CorrectToothpick;
	GoodReview CorrectSpecialSauce;
	GoodReview VampireLightOff;
	GoodReview BurgerLoverPerfect;
	GoodReview BurgerLoverGood;
}

// TypeDefIndex: 5452
class Bell.<PlayBellSong>d__27
{
	int <>1__state;
	object <>2__current;
	Bell <>4__this;
	float[] <>7__wrap1;
	int <>7__wrap2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x164af50
	void .ctor(int <>1__state) { }
	// RVA: 0x164b2c0
	void System.IDisposable.Dispose() { }
	// RVA: 0x164b2c4
	bool MoveNext() { }
	// RVA: 0x164b464
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x164b46c
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x164b4a4
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5453
class Bell.<PlayMultipleBells>d__20
{
	int <>1__state;
	object <>2__current;
	Bell <>4__this;
	int times;
	int <i>5__2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x164aae0
	void .ctor(int <>1__state) { }
	// RVA: 0x164b4ac
	void System.IDisposable.Dispose() { }
	// RVA: 0x164b4b0
	bool MoveNext() { }
	// RVA: 0x164b57c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x164b584
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x164b5bc
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5454
class Bell
{
	Bell instance;
	UnityEngine.Animator anim;
	int <timesCookPlayedBell>k__BackingField;
	int timesToBellSpamWarning;
	AudioPlayer bellAudioPlayer;
	bool isPlayingBellSong;
	float[][] bellSongs;
	// property timesCookPlayedBell
	// property Interact_Left
	// property Interact_Right
	// RVA: 0x1649ff8
	int get_timesCookPlayedBell() { }
	// RVA: 0x164a000
	void set_timesCookPlayedBell(int value) { }
	// RVA: 0x164a008
	void Awake() { }
	// RVA: 0x164a0e4
	void Start() { }
	// RVA: 0x164a380
	void OnDestroy() { }
	// RVA: 0x164a61c
	void OnNewCustomer() { }
	// RVA: 0x164a820
	void OnCustomerSpawnOrDespawn(bool spawns) { }
	// RVA: 0x164a878
	void OnWindowMaximize() { }
	// RVA: 0x164a8c4
	void OnStarsUpdate(int remainingStars) { }
	// RVA: 0x164a9dc
	bool IsBellPlayable() { }
	// RVA: 0x164aa3c
	void CustomerPlaysBellRandomTimes() { }
	// RVA: 0x164a740
	void CustomerPlaysBell(int times) { }
	// RVA: 0x164aa64
	System.Collections.IEnumerator PlayMultipleBells(int times) { }
	// RVA: 0x164ab08
	void RightInteract() { }
	// RVA: 0x164ab34
	void Ding() { }
	// RVA: 0x164aba8
	void AddUseToBellSpam() { }
	// RVA: 0x164ac90
	void BadKidEnjoysCookBell() { }
	// RVA: 0x164a870
	void ResetTimesCookPlayedBell() { }
	// RVA: 0x164ae14
	void CustomerPlaysBellSong() { }
	// RVA: 0x164aee4
	System.Collections.IEnumerator PlayBellSong() { }
	// RVA: 0x164af78
	bool get_Interact_Left() { }
	// RVA: 0x164af80
	bool get_Interact_Right() { }
	// RVA: 0x164af88
	void .ctor() { }
}

// TypeDefIndex: 5455
class BotNames
{
	string[] botMaleNames;
	string[] botFemaleNames;
	string[] botMaleNames_CN;
	string[] botFemaleNames_CN;
	// RVA: 0x164b5c4
	CustomerIdentity GetRandomBotIdentity(Gender _gender) { }
	// RVA: 0x164b714
	void .cctor() { }
}

// TypeDefIndex: 5456
class BoxesInKitchenDetector.<>c
{
	BoxesInKitchenDetector+<>c <>9;
	System.Predicate<GrabableItem> <>9__7_0;
	// RVA: 0x1650914
	void .cctor() { }
	// RVA: 0x165097c
	void .ctor() { }
	// RVA: 0x1650984
	bool <IsAnyBoxInKitchen>b__7_0(GrabableItem b) { }
}

// TypeDefIndex: 5457
class BoxesInKitchenDetector
{
	BoxesInKitchenDetector instance;
	System.Collections.Generic.HashSet<GrabableItem> boxesOnArea;
	UnityEngine.BoxCollider bC;
	// RVA: 0x1650340
	void Awake() { }
	// RVA: 0x16503d0
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x165059c
	void OnTriggerExit(UnityEngine.Collider other) { }
	// RVA: 0x1650488
	GrabableItem GetBoxComponentIfValid(UnityEngine.Collider other) { }
	// RVA: 0x1650654
	bool IsAnyBoxInKitchen() { }
	// RVA: 0x16507e8
	void .ctor() { }
	// RVA: 0x1650870
	bool <IsAnyBoxInKitchen>b__7_1(GrabableItem b) { }
}

// TypeDefIndex: 5458
class BreedSelector
{
	bool initialized;
	System.Collections.Generic.List<CustomerBreed> normalBreeds;
	System.Collections.Generic.List<CustomerBreed> softSecretBreeds;
	System.Collections.Generic.List<CustomerBreed> seasonBreeds;
	System.Collections.Generic.List<CustomerBreed> secretBreeds;
	System.Collections.Generic.List<CustomerBreed> streamerBreeds;
	// RVA: 0x1650a2c
	void Initialize() { }
	// RVA: 0x1650ab0
	void SortBreedsByType() { }
	// RVA: 0x16510d0
	CustomerBreed GetBreedByCustomerName(string customerName) { }
	// RVA: 0x1651248
	CustomerBreed GetBreedByInitialAndDayTime(string customerName) { }
	// RVA: 0x16513a4
	void UnlockBreed(string breedName, bool unlock) { }
	// RVA: 0x16513a8
	string GetRandomBreedNameSecret() { }
	// RVA: 0x16514d8
	string GetRandomBreedNameOfStreamer() { }
	// RVA: 0x1651608
	bool IsSecretOrStreamerSkin(CustomerBreed _breedToCheck) { }
	// RVA: 0x165147c
	System.Collections.Generic.List<CustomerBreed> GetSecretBreedList() { }
	// RVA: 0x16515ac
	System.Collections.Generic.List<CustomerBreed> GetStreamerBreedList() { }
	// RVA: 0x16516b8
	void .cctor() { }
}

// TypeDefIndex: 5459
class CustomerBreed
{
	int value__;
	CustomerBreed Undefined;
	CustomerBreed Duck;
	CustomerBreed Dog;
	CustomerBreed Bear;
	CustomerBreed Koala;
	CustomerBreed Flamingo;
	CustomerBreed Bat;
	CustomerBreed Fox;
	CustomerBreed Deer;
	CustomerBreed Wolf;
	CustomerBreed Mallard;
	CustomerBreed Dodo;
	CustomerBreed YellowDuck;
	CustomerBreed Panda;
	CustomerBreed Platypus;
	CustomerBreed AlbinoBat;
	CustomerBreed DarkBat;
	CustomerBreed DarkWolf;
	CustomerBreed DarkDog;
	CustomerBreed Skeleton;
	CustomerBreed Pumpkin;
	CustomerBreed Snowman;
	CustomerBreed Gingerbreadman;
	CustomerBreed Arcticfox;
	CustomerBreed Reindeer;
	CustomerBreed ArcticWolf;
	CustomerBreed Polarbear;
	CustomerBreed Robot;
	CustomerBreed Curro;
	CustomerBreed Deme;
	CustomerBreed Buffpup;
	CustomerBreed Corgicam;
	CustomerBreed Sayu;
}

// TypeDefIndex: 5460
class BurgerToppingScriptable
{
	ItemId <itemId>k__BackingField;
	UnityEngine.Mesh mesh;
	UnityEngine.Material mat;
	float height;
	// property itemId
	// RVA: 0x16517f4
	ItemId get_itemId() { }
	// RVA: 0x16517fc
	void set_itemId(ItemId value) { }
	// RVA: 0x1651804
	void Initialize() { }
	// RVA: 0x1651918
	void .ctor() { }
}

// TypeDefIndex: 5461
class CameraOverlayCanvas
{
	UnityEngine.Camera renderCamera;
	UnityEngine.RectTransform canvasFrame;
	UnityEngine.Vector2 canvasScalerSize;
	UnityEngine.Rect currentRect;
	// RVA: 0x1651920
	void Awake() { }
	// RVA: 0x16519c4
	void LateUpdate() { }
	// RVA: 0x16519c8
	void UpdatePosition() { }
	// RVA: 0x1651aec
	void SetCamera(UnityEngine.Camera _cam) { }
	// RVA: 0x1651b08
	void .ctor() { }
}

// TypeDefIndex: 5462
class CarController
{
	float speed;
	UnityEngine.Transform[] currentPath;
	int nextPointIndex;
	DG.Tweening.Sequence seq;
	// RVA: 0x1651b10
	void StartRandomPath(UnityEngine.Transform[] _newCarPath) { }
	// RVA: 0x1651b34
	void SetOnStartingPoint() { }
	// RVA: 0x1651bf4
	void SetNextPoint() { }
	// RVA: 0x1651f14
	void OnPathEnd() { }
	// RVA: 0x1651f80
	void .ctor() { }
	// RVA: 0x1651f88
	void <SetNextPoint>b__6_0() { }
}

// TypeDefIndex: 5463
class Card
{
	CardInfo <assignedCard>k__BackingField;
	UnityEngine.Material mat;
	UnityEngine.Material bgMat;
	// property assignedCard
	// RVA: 0x1651f8c
	CardInfo get_assignedCard() { }
	// RVA: 0x1651f94
	void set_assignedCard(CardInfo value) { }
	// RVA: 0x1651f9c
	int SetRandomId(CardRarity _cardRarity, System.Collections.Generic.List<int> _excludedIds) { }
	// RVA: 0x1652358
	void SetMat(CardInfo _assignedCard) { }
	// RVA: 0x1652640
	void .ctor() { }
}

// TypeDefIndex: 5464
class CardRarity
{
	int value__;
	CardRarity Common;
	CardRarity Rare;
	CardRarity Golden;
}

// TypeDefIndex: 5465
class CardAlbum.<>c__DisplayClass24_0
{
	float rotValue;
	CardAlbum <>4__this;
	// RVA: 0x16531c4
	void .ctor() { }
	// RVA: 0x1653240
	float <PlayPageAnimation>b__0() { }
	// RVA: 0x1653248
	void <PlayPageAnimation>b__1(float v) { }
	// RVA: 0x1653290
	void <PlayPageAnimation>b__2() { }
}

// TypeDefIndex: 5466
class CardAlbum
{
	CardAlbum instance;
	CardAlbumReceptor cardReceptor;
	AudioPlayer audioPlayer;
	UnityEngine.Mesh openBookMesh;
	UnityEngine.Mesh closedBookMesh;
	UnityEngine.BoxCollider openAlbumCollider;
	UnityEngine.BoxCollider closedAlbumCollider;
	UnityEngine.Transform pageAxis;
	UnityEngine.GameObject[] pageClickers;
	UnityEngine.Transform[] cardContainers;
	UnityEngine.Material invisibleMat;
	UnityEngine.Material[] cardMats;
	bool <isOpen>k__BackingField;
	int currentPage;
	int maxPages;
	DG.Tweening.Sequence pageSeq;
	// property isOpen
	// property Interact_Left
	// property Interact_Right
	// RVA: 0x1652698
	bool get_isOpen() { }
	// RVA: 0x16526a0
	void set_isOpen(bool value) { }
	// RVA: 0x16526ac
	void Awake() { }
	// RVA: 0x16527a0
	void SetCardMats() { }
	// RVA: 0x1652b18
	void RightInteract() { }
	// RVA: 0x1643640
	void ChangePage(bool _forward) { }
	// RVA: 0x1652a44
	void ForcePage(int _pageNum) { }
	// RVA: 0x1652b44
	void PlayPageAnimation(bool _forward) { }
	// RVA: 0x1652df0
	void OpenAlbum() { }
	// RVA: 0x1652f2c
	void CloseAlbum() { }
	// RVA: 0x1653030
	void UpdateAlbumVisuals() { }
	// RVA: 0x16531cc
	bool get_Interact_Left() { }
	// RVA: 0x16531d4
	bool get_Interact_Right() { }
	// RVA: 0x16531dc
	void .ctor() { }
}

// TypeDefIndex: 5467
class CardAlbumReceptor
{
	UnityEngine.Transform punchVisuals;
	CardAlbum cardAlbum;
	AudioPlayer audioPlayer;
	// RVA: 0x16532c4
	void Awake() { }
	// RVA: 0x1653338
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x165333c
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x16536fc
	void OnItemAbsorbed(GrabableItem receivedItem) { }
	// RVA: 0x16537b4
	void CanPlayAbsorbSoundAgain() { }
	// RVA: 0x16537b8
	void PunchAnim(UnityEngine.Transform punchedTransform) { }
	// RVA: 0x165387c
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x1653884
	void .ctor() { }
}

// TypeDefIndex: 5468
class CardBooster
{
	int boosterPrice;
	MaterialTinter matTinter;
	Dish attachedTray;
	// property Interact_Left
	// property Interact_Right
	// RVA: 0x165388c
	void Awake() { }
	// RVA: 0x16538f0
	void RightInteract() { }
	// RVA: 0x165390c
	void OpenBooster() { }
	// RVA: 0x16541ac
	string GetRandomBoosterContent() { }
	// RVA: 0x1654594
	void AttachToTray(Dish _dish) { }
	// RVA: 0x165459c
	bool get_Interact_Left() { }
	// RVA: 0x16545a4
	bool get_Interact_Right() { }
	// RVA: 0x16545ac
	void .ctor() { }
}

// TypeDefIndex: 5469
class BoosterContent
{
	int value__;
	BoosterContent GGG;
	BoosterContent ccG;
	BoosterContent cRG;
	BoosterContent cRR;
	BoosterContent ccR;
	BoosterContent ccc;
}

// TypeDefIndex: 5470
class Cardbox.<>c__DisplayClass24_0
{
	UnityEngine.Transform itemToMove;
	Cardbox <>4__this;
	ItemBox _itemBox;
	// RVA: 0x1655238
	void .ctor() { }
	// RVA: 0x1655304
	void <LerpToItemBox>b__0() { }
}

// TypeDefIndex: 5471
class Cardbox
{
	bool animated;
	bool unlimited;
	ItemId contentId;
	UnityEngine.Transform contentMesh;
	UnityEngine.Transform coverAxisL;
	UnityEngine.Transform coverAxisR;
	CardboxRefillDetector refillDetector;
	DG.Tweening.Sequence openSeq;
	bool <isBoxOpen>k__BackingField;
	bool <readyToLerp>k__BackingField;
	DG.Tweening.Sequence lerpingSeq;
	float lerpTime;
	System.Collections.Generic.List<UnityEngine.Transform> itemsInBox;
	// property isBoxOpen
	// property readyToLerp
	// RVA: 0x1654604
	bool get_isBoxOpen() { }
	// RVA: 0x165460c
	void set_isBoxOpen(bool value) { }
	// RVA: 0x1654618
	bool get_readyToLerp() { }
	// RVA: 0x1654620
	void set_readyToLerp(bool value) { }
	// RVA: 0x165462c
	void Awake() { }
	// RVA: 0x16548b4
	void OnDestroy() { }
	// RVA: 0x16548d8
	void Grab() { }
	// RVA: 0x1654c48
	void Release() { }
	// RVA: 0x165491c
	void OpenBox(bool _open) { }
	// RVA: 0x1654c8c
	void LerpToItemBox(ItemBox _itemBox) { }
	// RVA: 0x1655240
	void .ctor() { }
}

// TypeDefIndex: 5472
class CardboxRefillDetector.<PulseRoutine>d__6
{
	int <>1__state;
	object <>2__current;
	CardboxRefillDetector <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1655488
	void .ctor(int <>1__state) { }
	// RVA: 0x1655700
	void System.IDisposable.Dispose() { }
	// RVA: 0x1655704
	bool MoveNext() { }
	// RVA: 0x16559a4
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16559ac
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16559e4
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5473
class CardboxRefillDetector
{
	Cardbox cardbox;
	System.Collections.Generic.Dictionary<UnityEngine.Collider, ItemBox> validItemBoxesOnRange;
	bool isPulsing;
	UnityEngine.WaitForSeconds timePerPulse;
	// RVA: 0x16553a0
	void Start() { }
	// RVA: 0x16553f8
	void OnDisable() { }
	// RVA: 0x165541c
	System.Collections.IEnumerator PulseRoutine() { }
	// RVA: 0x16554b0
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x16555a4
	void OnTriggerExit(UnityEngine.Collider other) { }
	// RVA: 0x165563c
	void .ctor() { }
}

// TypeDefIndex: 5474
class CardSaveData
{
	int totalCards;
	int maxCardsPerRow;
	int maxCardsPerColumn;
	float xSize;
	float ySize;
	bool initialized;
	System.Collections.Generic.List<CardInfo> allCards;
	System.Collections.Generic.Dictionary<System.ValueTuple<int, CardRarity>, CardInfo> cardLookup;
	UnityEngine.Vector2 cardBgOffset;
	UnityEngine.Vector2 cardGoldenBgOffset;
	// RVA: 0x16559ec
	void InitializeCards() { }
	// RVA: 0x1655ce8
	void GenerateCard(int id, CardRarity rarity, bool owned) { }
	// RVA: 0x16521c4
	CardInfo GetCardData(int _index, CardRarity _rarity) { }
	// RVA: 0x165353c
	void AddCardAsOwned(CardInfo _card) { }
	// RVA: 0x1655ec0
	void .ctor() { }
	// RVA: 0x1655ec8
	void .cctor() { }
}

// TypeDefIndex: 5475
class CardInfo
{
	int cardId;
	CardRarity cardRarity;
	UnityEngine.Vector2 texOffset;
	bool isOwned;
	// RVA: 0x1655e68
	void .ctor(int _index, CardRarity _rarity, bool _isOwned) { }
	// RVA: 0x165604c
	UnityEngine.Vector2 GetOffset(int _cardIndex, CardRarity _rarity) { }
	// RVA: 0x1655eb4
	void SetAsOwned() { }
}

// TypeDefIndex: 5476
class CarSystem.<SpawningRoutine>d__6
{
	int <>1__state;
	object <>2__current;
	CarSystem <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16562e8
	void .ctor(int <>1__state) { }
	// RVA: 0x16564a8
	void System.IDisposable.Dispose() { }
	// RVA: 0x16564ac
	bool MoveNext() { }
	// RVA: 0x1656578
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1656580
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16565b8
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5477
class CarSystem
{
	CarController[] carModels;
	CarController[] carHalloweenModels;
	UnityEngine.Transform[][] carPaths;
	UnityEngine.Vector2 timeBetweenCars;
	// RVA: 0x16560f4
	void Start() { }
	// RVA: 0x165611c
	void GetCarPaths() { }
	// RVA: 0x165627c
	System.Collections.IEnumerator SpawningRoutine() { }
	// RVA: 0x1656310
	void SpawnNewCar() { }
	// RVA: 0x1656494
	void .ctor() { }
}

// TypeDefIndex: 5478
class CDKCanvas
{
	float TransitionTime;
	CDKCanvas <Instance>k__BackingField;
	UnityEngine.Canvas popupCanvas;
	UnityEngine.GameObject popupPanel;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupContent;
	TMPro.TMP_InputField codeInput;
	UnityEngine.UI.Button confirmButton;
	UnityEngine.UI.Button closeButton;
	bool isOnScreen;
	DG.Tweening.Sequence panelTween;
	float backgroundOpacity;
	// property Instance
	// RVA: 0x16565c0
	CDKCanvas get_Instance() { }
	// RVA: 0x1656608
	void set_Instance(CDKCanvas value) { }
	// RVA: 0x1656660
	void Awake() { }
	// RVA: 0x1656bcc
	void OnEnable() { }
	// RVA: 0x1656cfc
	void OnDisable() { }
	// RVA: 0x1656e2c
	void OnDestroy() { }
	// RVA: 0x1657038
	void Display() { }
	// RVA: 0x16574d4
	void PressConfirm() { }
	// RVA: 0x165785c
	void PressClose() { }
	// RVA: 0x1657b94
	void OnRedeemCompleted(MarsRedeemResult result) { }
	// RVA: 0x16569dc
	void HideImmediately() { }
	// RVA: 0x1656808
	void CachePopupElements() { }
	// RVA: 0x16572b4
	void PlayOpenAnimation() { }
	// RVA: 0x165798c
	void PlayCloseAnimation() { }
	// RVA: 0x1657c58
	void .ctor() { }
}

// TypeDefIndex: 5479
class CDKFail
{
	float TransitionTime;
	CDKFail <Instance>k__BackingField;
	UnityEngine.Canvas popupCanvas;
	UnityEngine.GameObject popupPanel;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupContent;
	UnityEngine.UI.Button closeButton;
	UnityEngine.UI.Button secondaryCloseButton;
	bool isOnScreen;
	DG.Tweening.Sequence panelTween;
	float backgroundOpacity;
	// property Instance
	// RVA: 0x1657c60
	CDKFail get_Instance() { }
	// RVA: 0x1657ca8
	void set_Instance(CDKFail value) { }
	// RVA: 0x1657d00
	void Awake() { }
	// RVA: 0x1658224
	void OnDestroy() { }
	// RVA: 0x16576a4
	void Display() { }
	// RVA: 0x16586a0
	void PressClose() { }
	// RVA: 0x1658070
	void HideImmediately() { }
	// RVA: 0x1657e9c
	void CachePopupElements() { }
	// RVA: 0x1658480
	void PlayOpenAnimation() { }
	// RVA: 0x16587d0
	void PlayCloseAnimation() { }
	// RVA: 0x16589d8
	void .ctor() { }
}

// TypeDefIndex: 5480
class ChatDisplayer
{
	ChatDisplayer instance;
	int secondsInScreen;
	bool initialized;
	UnityEngine.RectTransform chatArea;
	TextFitter[] textFitters;
	float[] timeToDisableSlot;
	AudioPlayer audioPlayer;
	// RVA: 0x16589e0
	void Awake() { }
	// RVA: 0x1658a38
	void Start() { }
	// RVA: 0x1658b70
	void Update() { }
	// RVA: 0x1658a3c
	void Initialize() { }
	// RVA: 0x1658c70
	void Chat(string message) { }
	// RVA: 0x1658ff4
	void RebuildLayout() { }
	// RVA: 0x1658ed0
	int GetFreeSlotIndex() { }
	// RVA: 0x1658b80
	void CheckSlotsToDisableByTime() { }
	// RVA: 0x1659060
	void DisableSlot(int slotIndex) { }
	// RVA: 0x1658c0c
	void ClearAllChats() { }
	// RVA: 0x16590fc
	void CheckToAutoDisableCanvas() { }
	// RVA: 0x1659194
	void .ctor() { }
}

// TypeDefIndex: 5481
class ClickableItem
{
	UnityEngine.Events.UnityEvent onClick;
	// RVA: 0x16591a4
	void Interact() { }
	// RVA: 0x165924c
	void RightInteract() { }
	// RVA: 0x1659258
	void .ctor() { }
}

// TypeDefIndex: 5482
class CloseButtonXEscChanger
{
	UnityEngine.GameObject xButton;
	UnityEngine.GameObject escButton;
	// RVA: 0x1659260
	void Start() { }
	// RVA: 0x1659374
	void OnDestroy() { }
	// RVA: 0x1659488
	void OnEnable() { }
	// RVA: 0x1659548
	void OnGrabChange(bool _isGrabbing) { }
	// RVA: 0x1659580
	void .ctor() { }
}

// TypeDefIndex: 5483
class CollisionSound
{
	UnityEngine.Rigidbody rb;
	UnityEngine.AudioSource audioSource;
	float speedToSound;
	// RVA: 0x1659588
	void Awake() { }
	// RVA: 0x1659618
	void OnTriggerEnter(UnityEngine.Collider col) { }
	// RVA: 0x1659750
	void .ctor() { }
}

// TypeDefIndex: 5484
class CommandManager
{
	System.Collections.Generic.Dictionary<string, ChatCommandKeys> cmdList;
	// RVA: 0x1659758
	void AddCommand(string cmdLangKey, string langCmdList) { }
	// RVA: 0x16599f8
	System.Collections.Generic.List<ChatCommandKeys> GetCommandsFromChatMessage(string rawChat) { }
	// RVA: 0x1659ea8
	System.Collections.Generic.HashSet<CookingFail> GetComplainsFromChatMessage(string chatInput) { }
	// RVA: 0x165a310
	void .cctor() { }
}

// TypeDefIndex: 5485
class ChatCommandKeys
{
	int value__;
	ChatCommandKeys None;
	ChatCommandKeys Bell;
	ChatCommandKeys Bell2;
	ChatCommandKeys Bell3;
	ChatCommandKeys BellSong;
	ChatCommandKeys Leave;
	ChatCommandKeys Floor;
	ChatCommandKeys Fire;
	ChatCommandKeys BellSpam;
	ChatCommandKeys FenceSpam;
	ChatCommandKeys WindowLaunch;
	ChatCommandKeys Warehouse;
	ChatCommandKeys Burger;
	ChatCommandKeys CancelBurger;
	ChatCommandKeys Vegan;
	ChatCommandKeys LightCook;
	ChatCommandKeys DarkCook;
	ChatCommandKeys Smashed;
	ChatCommandKeys Onion;
	ChatCommandKeys CaramelizedOnion;
	ChatCommandKeys Tomato;
	ChatCommandKeys Lettuce;
	ChatCommandKeys Cheese;
	ChatCommandKeys DoubleCheese;
	ChatCommandKeys Ketchup;
	ChatCommandKeys Mustard;
	ChatCommandKeys Mayo;
	ChatCommandKeys FavSauce;
	ChatCommandKeys CupCola;
	ChatCommandKeys CupLemon;
	ChatCommandKeys CupOrange;
	ChatCommandKeys NoOnion;
	ChatCommandKeys NoTomato;
	ChatCommandKeys NoLettuce;
	ChatCommandKeys NoCheese;
	ChatCommandKeys NoSauce;
	ChatCommandKeys ChangeBreed;
	ChatCommandKeys UnlockSkin;
	ChatCommandKeys LockSkin;
}

// TypeDefIndex: 5486
class CommentCanvasController
{
	float TransitionTime;
	float BackgroundOpacity;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupPanel;
	UnityEngine.Canvas popupCanvas;
	UnityEngine.UI.Button closeButton;
	UnityEngine.UI.Button commentButton;
	bool <IsOnScreen>k__BackingField;
	DG.Tweening.Sequence panelTween;
	// property IsOnScreen
	// RVA: 0x165a3a8
	bool get_IsOnScreen() { }
	// RVA: 0x165a3b0
	void set_IsOnScreen(bool value) { }
	// RVA: 0x165a3bc
	void Awake() { }
	// RVA: 0x165a554
	void Start() { }
	// RVA: 0x165a9f8
	void OnDestroy() { }
	// RVA: 0x165add0
	void Update() { }
	// RVA: 0x165b180
	void OnReviewPopupChanged(bool isReviewOnScreen) { }
	// RVA: 0x165b2cc
	void Display() { }
	// RVA: 0x165ae78
	void PressClose() { }
	// RVA: 0x165b634
	void PressComment() { }
	// RVA: 0x165a8b4
	void OnActiveCameraChange(UnityEngine.Camera newCamera) { }
	// RVA: 0x165a468
	void EnablePanels(bool enabled) { }
	// RVA: 0x165b79c
	void .ctor() { }
	// RVA: 0x165b7a4
	void <PressClose>b__18_0() { }
}

// TypeDefIndex: 5487
class CounterArea
{
	bool isBarCounter;
	CounterType counterType;
	CounterArea barCounter;
	GrabableItem attachedItem;
	AudioPlayer audioPlayer;
	UnityEngine.Transform spawnpoint;
	System.Action<GrabableItem> callbackOnAttachChange;
	// RVA: 0x165b7ac
	void Awake() { }
	// RVA: 0x165b8d4
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x165bb60
	void PlaySound(bool _putIn) { }
	// RVA: 0x165bbfc
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x165bc00
	void WithdrawItem(GrabableItem grabableItem) { }
	// RVA: 0x165be78
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x165bed8
	void .ctor() { }
}

// TypeDefIndex: 5488
class CounterType
{
	int value__;
	CounterType Wood;
	CounterType Metal;
	CounterType Hanger;
	CounterType Bag;
}

// TypeDefIndex: 5489
class CounterCoins
{
	CounterCoins instance;
	int <coinsInCounter>k__BackingField;
	UnityEngine.Transform[] piles;
	Coin[][] coinsInPiles;
	System.Collections.Generic.List<Coin> coins;
	System.Collections.Generic.List<Coin> lastEnabledCoins;
	DG.Tweening.Sequence vanishSeq;
	UnityEngine.BoxCollider boxCol;
	AudioPlayer audioPlayer;
	int customerPaymentBeforeMultiplier;
	bool customerPaymentWasDoubled;
	// property coinsInCounter
	// RVA: 0x165bee0
	int get_coinsInCounter() { }
	// RVA: 0x165bee8
	void set_coinsInCounter(int value) { }
	// RVA: 0x165bef0
	void Awake() { }
	// RVA: 0x165c59c
	void Interact() { }
	// RVA: 0x165cb08
	void RightInteract() { }
	// RVA: 0x165bfdc
	void SetCoinModels() { }
	// RVA: 0x165cb8c
	void DisplayCoins(int _amount) { }
	// RVA: 0x165cfa8
	void DisplayCustomerPayment(int amountBeforeMultiplier, int finalAmount, bool wasDoubled) { }
	// RVA: 0x165cb98
	void DisplayCoinsInternal(int _amount) { }
	// RVA: 0x165c36c
	void HideCoins() { }
	// RVA: 0x165c5b0
	void ConsumeCoins() { }
	// RVA: 0x165d158
	void Restore(bool isRestockStarting) { }
	// RVA: 0x165d164
	void .ctor() { }
	// RVA: 0x165d210
	void <ConsumeCoins>b__22_0() { }
}

// TypeDefIndex: 5490
class Coin
{
	UnityEngine.GameObject <gO>k__BackingField;
	UnityEngine.Transform <tr>k__BackingField;
	UnityEngine.Vector3 <originalPos>k__BackingField;
	UnityEngine.Material mat;
	// property gO
	// property tr
	// property originalPos
	// RVA: 0x165d214
	UnityEngine.GameObject get_gO() { }
	// RVA: 0x165d21c
	void set_gO(UnityEngine.GameObject value) { }
	// RVA: 0x165d224
	UnityEngine.Transform get_tr() { }
	// RVA: 0x165d22c
	void set_tr(UnityEngine.Transform value) { }
	// RVA: 0x165d234
	UnityEngine.Vector3 get_originalPos() { }
	// RVA: 0x165d240
	void set_originalPos(UnityEngine.Vector3 value) { }
	// RVA: 0x165cb14
	void .ctor(UnityEngine.GameObject _gO) { }
	// RVA: 0x165d24c
	void .ctor(UnityEngine.Transform _tr) { }
	// RVA: 0x165d054
	UnityEngine.Material GetMat() { }
	// RVA: 0x165cfc0
	void ResetCoin() { }
}

// TypeDefIndex: 5491
class Cup
{
	float fillAmount;
	bool isOverflowing;
	bool cupInitialized;
	UnityEngine.Transform fillTr;
	UnityEngine.Material fillMat;
	AudioPlayer audioPlayer;
	// RVA: 0x165d374
	void Awake() { }
	// RVA: 0x165d390
	void InitializeCup() { }
	// RVA: 0x165d5dc
	void OnDestroy() { }
	// RVA: 0x165d6c4
	void AddFill(float _amount, ItemId _newFlavor) { }
	// RVA: 0x165d5b4
	void ResetFill(float _percentage) { }
	// RVA: 0x165da78
	void Instafill(float _amount, ItemId _newFlavor) { }
	// RVA: 0x165d7b8
	void SetFlavor(ItemId _newFlavor) { }
	// RVA: 0x165dbb0
	ItemId Explode() { }
	// RVA: 0x165dbfc
	bool IsStraight() { }
	// RVA: 0x165dd64
	void OnAttached(InteractableArea _iArea) { }
	// RVA: 0x165dd98
	void OnKicked() { }
	// RVA: 0x165d8ac
	void UpdateOverfillState() { }
	// RVA: 0x165dd9c
	void .ctor() { }
}

// TypeDefIndex: 5492
class CupServingSlot
{
	GrabableItem attachedItem;
	AudioPlayer audioPlayer;
	SodaMachine <sodaMachine>k__BackingField;
	bool blocked;
	// property sodaMachine
	// RVA: 0x165ddf4
	SodaMachine get_sodaMachine() { }
	// RVA: 0x165ddfc
	void set_sodaMachine(SodaMachine value) { }
	// RVA: 0x165de04
	void BlockReceptionTemp() { }
	// RVA: 0x165de6c
	void RecoverReception() { }
	// RVA: 0x165de74
	void Awake() { }
	// RVA: 0x165df94
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x165e160
	void PlaySound(bool _putIn) { }
	// RVA: 0x165e190
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x165e194
	void WithdrawItem(GrabableItem grabableItem) { }
	// RVA: 0x165e2b0
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x165e310
	void .ctor() { }
}

// TypeDefIndex: 5493
class CursorManager.CursorType
{
	int value__;
	CursorManager+CursorType Default;
	CursorManager+CursorType Cuddle;
}

// TypeDefIndex: 5494
class CursorManager
{
	CursorManager instance;
	UnityEngine.Texture2D cuddleCursor;
	CursorManager+CursorType currentCursor;
	System.Collections.Generic.Dictionary<CursorManager+CursorType, UnityEngine.Texture2D> cursorDict;
	// RVA: 0x165e318
	void Awake() { }
	// RVA: 0x165e414
	void SetCursor(CursorManager+CursorType _newCursor) { }
	// RVA: 0x165e568
	void .ctor() { }
}

// TypeDefIndex: 5495
class CustomerController.CustomerState
{
	int value__;
	CustomerController+CustomerState None;
	CustomerController+CustomerState Despawned;
	CustomerController+CustomerState WalkingIn;
	CustomerController+CustomerState WaitingFence;
	CustomerController+CustomerState WaitingOrder;
	CustomerController+CustomerState ServingIn;
	CustomerController+CustomerState ServingWait;
	CustomerController+CustomerState ServingOut;
	CustomerController+CustomerState Leaving;
}

// TypeDefIndex: 5496
class CustomerController.LeavingReason
{
	int value__;
	CustomerController+LeavingReason Unknown;
	CustomerController+LeavingReason BurgerDone;
	CustomerController+LeavingReason BurgerBait;
	CustomerController+LeavingReason ClosedInFace;
	CustomerController+LeavingReason FriendlyClosed;
	CustomerController+LeavingReason TimeOut;
	CustomerController+LeavingReason Voluntary;
}

// TypeDefIndex: 5497
class CustomerController.CustomerMood
{
	int value__;
	CustomerController+CustomerMood Sad;
	CustomerController+CustomerMood Neutral;
	CustomerController+CustomerMood Happy;
}

// TypeDefIndex: 5498
class CustomerController.<>c
{
	CustomerController+<>c <>9;
	System.Func<ItemId, bool> <>9__83_0;
	// RVA: 0x1664da8
	void .cctor() { }
	// RVA: 0x1664e10
	void .ctor() { }
	// RVA: 0x1664e18
	bool <ModifyOrderDependingOnOutfit>b__83_0(ItemId rI) { }
}

// TypeDefIndex: 5499
class CustomerController.<>c__DisplayClass92_0
{
	CustomerController <>4__this;
	CustomerController+LeavingReason leavingReason;
	// RVA: 0x1661d30
	void .ctor() { }
	// RVA: 0x1664ec0
	void <ReturnFromServe>b__0() { }
}

// TypeDefIndex: 5500
class CustomerController.<>c__DisplayClass95_0
{
	bool displaysReview;
	CustomerController <>4__this;
	// RVA: 0x1662658
	void .ctor() { }
	// RVA: 0x1664ee0
	void <LeaveCounter>b__0() { }
}

// TypeDefIndex: 5501
class CustomerController.<GrabDish>d__91
{
	int <>1__state;
	object <>2__current;
	CustomerController <>4__this;
	float <t>5__2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1661ba8
	void .ctor(int <>1__state) { }
	// RVA: 0x1664f10
	void System.IDisposable.Dispose() { }
	// RVA: 0x1664f14
	bool MoveNext() { }
	// RVA: 0x1665354
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x166535c
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x1665394
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5502
class CustomerController
{
	bool <customerHasSeenPlayerGrabAnything>k__BackingField;
	CustomerDataScriptable <customerDataScriptable>k__BackingField;
	OutfitScriptable <outfitScriptable>k__BackingField;
	UnityEngine.Transform head;
	UnityEngine.GameObject headExploder;
	bool initialized;
	float baseWalkingSpeed;
	CustomerController+CustomerState currentCustomerState;
	CustomerController+CustomerMood currentCustomerHappiness;
	Gamemode <customerGamemode>k__BackingField;
	CustomerManager customerManager;
	UnityEngine.Animator anim;
	UnityEngine.Transform arms;
	UnityEngine.Vector3 armsRisedRotation;
	bool armsRised;
	EmotionController emotions;
	UnityEngine.MeshFilter headMF;
	UnityEngine.MeshFilter bodyMF;
	UnityEngine.MeshFilter lArmMF;
	UnityEngine.MeshFilter rArmMF;
	UnityEngine.MeshFilter normalEyesMF;
	UnityEngine.MeshFilter happyEyesMF;
	UnityEngine.MeshFilter disappointEyes;
	bool <hasOrderedAnything>k__BackingField;
	string <customerName>k__BackingField;
	int <orderSize>k__BackingField;
	System.Collections.Generic.List<ItemId> <reqItems>k__BackingField;
	System.Collections.Generic.List<ItemId> <avoidItems>k__BackingField;
	Dish <grabbedDish>k__BackingField;
	float startingTimeWaitingForFence;
	float maxTimeWaitingForFence;
	float waitTimeInCasePlayerMoveDishInCustomersFace;
	float timeToAutoLookRandom;
	int customerFinalStars;
	float ellapsedTimeSinceLastOrder;
	bool beingHeadHitted;
	AudioPlayer audioPlayer;
	int timesPlayerSwitchedLights;
	float lookSpeed;
	float disappointCD;
	float lastDisappointSound;
	float lastBadKidBellSpam;
	float badKidTimeToBellSpamAgain;
	bool canBadKidBellSpam;
	bool isBadKidBored;
	// property customerHasSeenPlayerGrabAnything
	// property customerDataScriptable
	// property outfitScriptable
	// property customerGamemode
	// property hasOrderedAnything
	// property customerName
	// property orderSize
	// property reqItems
	// property avoidItems
	// property grabbedDish
	// RVA: 0x165e570
	bool get_customerHasSeenPlayerGrabAnything() { }
	// RVA: 0x165e578
	void set_customerHasSeenPlayerGrabAnything(bool value) { }
	// RVA: 0x165e584
	CustomerDataScriptable get_customerDataScriptable() { }
	// RVA: 0x165e58c
	void set_customerDataScriptable(CustomerDataScriptable value) { }
	// RVA: 0x165e594
	OutfitScriptable get_outfitScriptable() { }
	// RVA: 0x165e59c
	void set_outfitScriptable(OutfitScriptable value) { }
	// RVA: 0x165e5a4
	Gamemode get_customerGamemode() { }
	// RVA: 0x165e5ac
	void set_customerGamemode(Gamemode value) { }
	// RVA: 0x165e5b4
	bool get_hasOrderedAnything() { }
	// RVA: 0x165e5bc
	void set_hasOrderedAnything(bool value) { }
	// RVA: 0x165e5c8
	string get_customerName() { }
	// RVA: 0x165e5d0
	void set_customerName(string value) { }
	// RVA: 0x165e5d8
	int get_orderSize() { }
	// RVA: 0x165e5e0
	void set_orderSize(int value) { }
	// RVA: 0x165e5e8
	System.Collections.Generic.List<ItemId> get_reqItems() { }
	// RVA: 0x165e5f0
	void set_reqItems(System.Collections.Generic.List<ItemId> value) { }
	// RVA: 0x165e5f8
	System.Collections.Generic.List<ItemId> get_avoidItems() { }
	// RVA: 0x165e600
	void set_avoidItems(System.Collections.Generic.List<ItemId> value) { }
	// RVA: 0x165e608
	Dish get_grabbedDish() { }
	// RVA: 0x165e610
	void set_grabbedDish(Dish value) { }
	// RVA: 0x165e618
	void Initialize(CustomerManager _customerManager) { }
	// RVA: 0x165eab8
	void OnDestroy() { }
	// RVA: 0x165eddc
	void OnGrabSomethingChange(bool _grabs) { }
	// RVA: 0x165ede8
	void Update() { }
	// RVA: 0x165f794
	void AutoLookAt() { }
	// RVA: 0x165feb8
	void LookAtRandomSpotsTimed() { }
	// RVA: 0x165f97c
	void LookAtMouse() { }
	// RVA: 0x1660184
	void CuddleDetector() { }
	// RVA: 0x165f484
	bool WaitingForFenceTimeOutWithNoOrder() { }
	// RVA: 0x165fc50
	void LookAt(UnityEngine.Transform target) { }
	// RVA: 0x1660088
	void LookAt(UnityEngine.Vector3 angle, float lerpTime) { }
	// RVA: 0x16602f8
	void RiseArms(bool rise, float timeToMove) { }
	// RVA: 0x165e9ec
	void ResetData() { }
	// RVA: 0x1660578
	void Spawn(CustomerIdentity _customerIdentity, Gamemode _customerGamemode, System.Collections.Generic.List<ItemId> _reqItems, System.Collections.Generic.List<ItemId> _avoidItems) { }
	// RVA: 0x1660acc
	void ModifyOrderDependingOnOutfit(CustomerOutfit _outfit, System.Collections.Generic.List<ItemId>& _reqItems, System.Collections.Generic.List<ItemId>& _avoidItems) { }
	// RVA: 0x1660920
	void SetCustomerBreedAndOutfit(CustomerIdentity _customerIdentity, CustomerDataScriptable _newCustomerScriptable) { }
	// RVA: 0x1661180
	void SetTimeSinceLastCustomer(float _ellapsedTimeSinceLastOrder) { }
	// RVA: 0x1660c34
	void SetOrder(System.Collections.Generic.List<ItemId> _reqItems, System.Collections.Generic.List<ItemId> _avoidItems) { }
	// RVA: 0x1660d78
	void WalkToCounter() { }
	// RVA: 0x1661664
	void WaitForFence() { }
	// RVA: 0x165f29c
	void WaitInCounter() { }
	// RVA: 0x165f0d4
	void TryToServeInCounter() { }
	// RVA: 0x1661b3c
	System.Collections.IEnumerator GrabDish() { }
	// RVA: 0x1661bd0
	void ReturnFromServe(bool gotDish) { }
	// RVA: 0x1662054
	void ProcessDishOpinion() { }
	// RVA: 0x1662100
	void Pay() { }
	// RVA: 0x165f52c
	void LeaveCounter(CustomerController+LeavingReason _leavingReason) { }
	// RVA: 0x1662660
	void SetReview() { }
	// RVA: 0x16626fc
	void Despawn() { }
	// RVA: 0x16628d4
	void DisableCharacter() { }
	// RVA: 0x166045c
	void ChangeCharacterMood(CustomerController+CustomerMood _newMood) { }
	// RVA: 0x1661390
	DG.Tweening.Sequence DoWalkingLerp(UnityEngine.Transform origin, UnityEngine.Transform dest) { }
	// RVA: 0x1661888
	bool CheckCookingFailsOnEntry() { }
	// RVA: 0x1662c1c
	void CheckLastCookingFails() { }
	// RVA: 0x1661d38
	void CheckDeliveryFails() { }
	// RVA: 0x1662d94
	void CheckDeliverySpecialFails() { }
	// RVA: 0x1661fdc
	void AddCriticalFailsOnLeaving(CustomerController+LeavingReason _leavingReason) { }
	// RVA: 0x16647dc
	void OnFenceOpen(bool open) { }
	// RVA: 0x166486c
	void OnLightSwitch(bool turnedOn) { }
	// RVA: 0x1664908
	void RecheckToLeaveByClosedInFace() { }
	// RVA: 0x1664920
	bool IsWaitingOrderOrBefore() { }
	// RVA: 0x1664934
	bool IsOnPenalizableTime() { }
	// RVA: 0x166485c
	bool IsWaitingOrder() { }
	// RVA: 0x1664948
	bool HasAlreadyLeft() { }
	// RVA: 0x16604a4
	void DisableEmotions() { }
	// RVA: 0x1662968
	void ShowHappiness(float _time) { }
	// RVA: 0x1664890
	void ShowDisappoint(float time) { }
	// RVA: 0x166495c
	void ShowSilentDisappoint(float time) { }
	// RVA: 0x16629a4
	void ShowAngry(bool isEndless) { }
	// RVA: 0x16604c0
	void DestroyGrabbedDish() { }
	// RVA: 0x16629e4
	float GetCurrentSpeed() { }
	// RVA: 0x1664978
	void ApplyHeadHit(UnityEngine.Vector3 hitOrigin) { }
	// RVA: 0x165ee98
	void BadKidBellInteractions() { }
	// RVA: 0x1664c58
	void SetBadKidAsHappy() { }
	// RVA: 0x166199c
	void OnLightsChange(bool _on) { }
	// RVA: 0x1664c60
	void .ctor() { }
	// RVA: 0x1664d80
	void <TryToServeInCounter>b__90_0() { }
	// RVA: 0x1664da0
	void <ApplyHeadHit>b__122_0() { }
}

// TypeDefIndex: 5503
class CustomerIdentityManager
{
	System.Collections.Generic.Dictionary<string, CustomerIdentity> cache;
	// RVA: 0x16607e0
	CustomerIdentity GetCustomerIdentity(string _customerName, bool _isBot) { }
	// RVA: 0x166539c
	CustomerIdentity SetNewCustomerIdentity(string _customerName, bool _isBot, Gender _gender, CustomerBreed _breed) { }
	// RVA: 0x16659a8
	CustomerIdentity SetNewCustomerIdentity(string _customerName, bool _isBot, Gender _gender) { }
	// RVA: 0x1665a18
	CustomerIdentity SetNewCustomerIdentity(string _customerName, bool _isBot, CustomerBreed _breed) { }
	// RVA: 0x16654fc
	CustomerIdentity LoadIdentity(string _customerName) { }
	// RVA: 0x1665a88
	void .cctor() { }
}

// TypeDefIndex: 5504
class CustomerIdentity
{
	string customerName;
	Gender gender;
	CustomerBreed breed;
	// RVA: 0x1665794
	void .ctor(string _customerName, Gender _gender, CustomerBreed _breed) { }
	// RVA: 0x16658ac
	void SaveIdentity() { }
}

// TypeDefIndex: 5505
class Gender
{
	int value__;
	Gender Undefined;
	Gender Male;
	Gender Female;
}

// TypeDefIndex: 5506
class CustomerManager.<>c
{
	CustomerManager+<>c <>9;
	System.Func<ItemId, ItemId> <>9__41_0;
	System.Func<System.Linq.IGrouping<ItemId, ItemId>, int> <>9__41_1;
	System.Predicate<ItemId> <>9__46_1;
	// RVA: 0x1668d58
	void .cctor() { }
	// RVA: 0x1668dc0
	void .ctor() { }
	// RVA: 0x1668dc8
	ItemId <CallTutorialCustomer>b__41_0(ItemId x) { }
	// RVA: 0x1668dd0
	int <CallTutorialCustomer>b__41_1(System.Linq.IGrouping<ItemId, ItemId> g) { }
	// RVA: 0x1668e18
	bool <RemoveNegatedItems>b__46_1(ItemId item) { }
}

// TypeDefIndex: 5507
class CustomerManager.<>c__DisplayClass46_0
{
	System.Collections.Generic.List<ItemId> avoidItems;
	// RVA: 0x16684f8
	void .ctor() { }
	// RVA: 0x1668e70
	bool <RemoveNegatedItems>b__0(ItemId item) { }
}

// TypeDefIndex: 5508
class CustomerManager
{
	CustomerManager instance;
	BadReviewManager <badReviews>k__BackingField;
	System.Action callbackOnDishReady;
	System.Action<Dish> callbackOnAnyBurgerClosed;
	string playerWaiting;
	float ellapsedTimeSinceLastOrder;
	float timePerStar;
	float _remainingTime;
	int _remainingStars;
	GrabableItem dishOnCounter;
	UnityEngine.Transform waypointSpawn;
	UnityEngine.Transform waypointWait;
	UnityEngine.Transform waypointServe;
	UnityEngine.Transform waypointReturnFromServe;
	UnityEngine.Transform waypointDespawn;
	System.Action<float, float> callbackCustomerTimerUpdate;
	System.Action<int> callbackStarsUpdate;
	System.Action<bool> callbackCustomerSpawnDespawn;
	System.Action callbackOnPlayerWaitingChange;
	CustomerController <currentCustomer>k__BackingField;
	CustomerController customerPrefab;
	System.Collections.Generic.List<ItemId> tutorialCookingRequests;
	float bellsPerTime;
	float timeToResetBells;
	System.Collections.Generic.List<float> lastBellTimes;
	// property badReviews
	// property remainingTime
	// property remainingStars
	// property currentCustomer
	// RVA: 0x1665b20
	BadReviewManager get_badReviews() { }
	// RVA: 0x1665b28
	void set_badReviews(BadReviewManager value) { }
	// RVA: 0x1665b30
	float get_remainingTime() { }
	// RVA: 0x1665b38
	void set_remainingTime(float value) { }
	// RVA: 0x1665c50
	int get_remainingStars() { }
	// RVA: 0x1665c24
	void set_remainingStars(int value) { }
	// RVA: 0x1665c58
	CustomerController get_currentCustomer() { }
	// RVA: 0x1665c60
	void set_currentCustomer(CustomerController value) { }
	// RVA: 0x1665c68
	void Awake() { }
	// RVA: 0x1665cc0
	void Start() { }
	// RVA: 0x1665ec8
	void OnDestroy() { }
	// RVA: 0x1665fc8
	void Update() { }
	// RVA: 0x1665fcc
	void CountWaitingTime() { }
	// RVA: 0x1666224
	void OnLearningModesRecursive() { }
	// RVA: 0x1666894
	void OnNormalTimerComplete() { }
	// RVA: 0x16663ec
	void CallTutorialCustomer() { }
	// RVA: 0x1666340
	void CallRandomBotCustomer(Gamemode _customerGamemode) { }
	// RVA: 0x1666a44
	void CallCustomer(CustomerIdentity _customerIdentity, Gamemode _customerGamemode, System.Collections.Generic.List<ItemId> reqItems, System.Collections.Generic.List<ItemId> avoidItems) { }
	// RVA: 0x166693c
	bool CanJoinANewCustomer() { }
	// RVA: 0x1667d2c
	void RemoveLockedItems(System.Collections.Generic.List<ItemId> reqItems, System.Collections.Generic.List<ItemId> avoidItems) { }
	// RVA: 0x1661188
	void RemoveNegatedItems(System.Collections.Generic.List<ItemId> reqItems, System.Collections.Generic.List<ItemId> avoidItems) { }
	// RVA: 0x166815c
	void AddCardToyIfEnoughExtras(CustomerIdentity _customerIdentity, System.Collections.Generic.List<ItemId> reqItems) { }
	// RVA: 0x1667ea0
	void EnsureTheresAnyMeatOrAddABasicOne(System.Collections.Generic.List<ItemId> reqItems) { }
	// RVA: 0x16683f8
	bool IsValidBurger(System.Collections.Generic.List<ItemId> reqItems) { }
	// RVA: 0x1666c70
	System.Collections.Generic.List<ItemId> GenerateRandomReqItems(CustomerIdentity _customerIdentity) { }
	// RVA: 0x1667a60
	System.Collections.Generic.List<ItemId> GenerateRandomAvoidedItems() { }
	// RVA: 0x1661760
	void SetPlayerWaitingForOrder(string _playerName) { }
	// RVA: 0x1668500
	string GetPlayerWaiting() { }
	// RVA: 0x1668508
	void PlayBell(string username, int times) { }
	// RVA: 0x16687cc
	void PlayBellSong(string username) { }
	// RVA: 0x16686d8
	bool CanRingTheBell(string username) { }
	// RVA: 0x1668848
	void LeaveCustomer(string username) { }
	// RVA: 0x1662780
	void OnCustomerDespawn() { }
	// RVA: 0x1665df4
	void ResetServiceData() { }
	// RVA: 0x1662a04
	void ReceiveCookingWarning(CookingFail cF) { }
	// RVA: 0x1662d04
	void ReceiveCookingFailOnlyIfWarned(CookingFail f) { }
	// RVA: 0x1662b24
	void ReceiveCookingFail(CookingFail f) { }
	// RVA: 0x1663014
	void ReceiveDeliveryFail(DeliveryFail f) { }
	// RVA: 0x16647c8
	void ReceiveGoodReview(GoodReview gR) { }
	// RVA: 0x1662d80
	void ReceiveCriticalFail(CriticalFail f) { }
	// RVA: 0x1668908
	void ReceiveWarningConvertedToFailInChat(CookingFail cF) { }
	// RVA: 0x165ba98
	void SetDishOnCounter(GrabableItem _dish) { }
	// RVA: 0x1668a6c
	GrabableItem GetDishOnCounter() { }
	// RVA: 0x1668a74
	void OnRandomBurgerCompleted(Dish _dish) { }
	// RVA: 0x16689c8
	void SetDishReady() { }
	// RVA: 0x1668b3c
	void .ctor() { }
}

// TypeDefIndex: 5509
class ViewerOrder
{
	CustomerIdentity customerIdentity;
	bool isSub;
	int bits;
	int previousOrderTime;
	float orderTime;
	string chatInput;
	System.Collections.Generic.List<ChatCommandKeys> chatInputAsCommands;
	// RVA: 0x1668ec8
	void .ctor(CustomerIdentity _customerIdentity, bool _isSub, int _bits, string _message, System.Collections.Generic.List<ChatCommandKeys> _chatInputAsCommands, int _previousOrderTime) { }
	// RVA: 0x1668fc4
	void OverrideInfo(CustomerIdentity _customerIdentity, bool _isSub, int _bits, string _message, System.Collections.Generic.List<ChatCommandKeys> _chatInputAsCommands, int _previousOrders) { }
}

// TypeDefIndex: 5510
class CustomerSpecialOutfit.<>c__DisplayClass8_0
{
	CustomerBreed _breed;
	// RVA: 0x1669980
	void .ctor() { }
	// RVA: 0x1669e9c
	bool <SetRandomOutfit>b__0(OutfitScriptable x) { }
}

// TypeDefIndex: 5511
class CustomerSpecialOutfit
{
	float outfitProb;
	UnityEngine.Transform headOutfitParent;
	UnityEngine.Transform bodyOutfitParent;
	OutfitScriptable outfitScriptable;
	System.Collections.Generic.List<UnityEngine.GameObject> spawnedCosmetics;
	System.Collections.Generic.List<UnityEngine.MeshRenderer> coloreableCosmetics;
	UnityEngine.Vector2[] colorTilingOffsets;
	// RVA: 0x16690c8
	OutfitScriptable SetSpecificOutfit(CustomerOutfit outfitToSearch) { }
	// RVA: 0x1660f6c
	OutfitScriptable SetRandomOutfit(CustomerBreed _breed) { }
	// RVA: 0x1669988
	bool SpecialOutfitConditions() { }
	// RVA: 0x1669144
	void ApplyOutfit(OutfitScriptable _oS) { }
	// RVA: 0x1669b50
	void RemoveOutfit() { }
	// RVA: 0x1669c80
	void .ctor() { }
}

// TypeDefIndex: 5512
class CustomerOutfit
{
	int value__;
	CustomerOutfit Normal;
	CustomerOutfit Critic;
	CustomerOutfit Rider;
	CustomerOutfit Vampire;
	CustomerOutfit Hood;
	CustomerOutfit BurgerLover;
	CustomerOutfit BadKid;
	CustomerOutfit Pirate;
}

// TypeDefIndex: 5513
class CuttingArea.<>c__DisplayClass20_0
{
	bool isNewCut;
	// RVA: 0x166ab40
	void .ctor() { }
}

// TypeDefIndex: 5514
class CuttingArea.<>c__DisplayClass20_1
{
	UnityEngine.GameObject[] backItems;
	CuttingArea+<>c__DisplayClass20_0 CS$<>8__locals1;
	// RVA: 0x166ab48
	void .ctor() { }
	// RVA: 0x166ad48
	void <PlaceOnBoard>b__0() { }
}

// TypeDefIndex: 5515
class CuttingArea
{
	CuttingBoard cuttingBoard;
	ParticleManager slicingParticles;
	StoragedItem[] storagedItems;
	System.Collections.Generic.HashSet<ItemId> <itemsOnSlicingBoard>k__BackingField;
	bool <hasUnfreshItem>k__BackingField;
	bool <hasDirtyItem>k__BackingField;
	AudioPlayer audioPlayer;
	// property itemsOnSlicingBoard
	// property hasUnfreshItem
	// property hasDirtyItem
	// RVA: 0x1669ee8
	System.Collections.Generic.HashSet<ItemId> get_itemsOnSlicingBoard() { }
	// RVA: 0x1669ef0
	void set_itemsOnSlicingBoard(System.Collections.Generic.HashSet<ItemId> value) { }
	// RVA: 0x1669ef8
	bool get_hasUnfreshItem() { }
	// RVA: 0x1669f00
	void set_hasUnfreshItem(bool value) { }
	// RVA: 0x1669f0c
	bool get_hasDirtyItem() { }
	// RVA: 0x1669f14
	void set_hasDirtyItem(bool value) { }
	// RVA: 0x1669f20
	void Awake() { }
	// RVA: 0x166a0ec
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x166a9e8
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x166aaec
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x166a1f8
	void PlaceOnBoard(GrabableItem receivedItem) { }
	// RVA: 0x166aa5c
	void RemoveFromBoard(ItemId itemIdToRemove) { }
	// RVA: 0x166ab50
	void UpdateEnabledItems() { }
	// RVA: 0x166ac30
	void RestoreArea(bool isRestockStarting) { }
	// RVA: 0x166acb8
	void .ctor() { }
}

// TypeDefIndex: 5516
class CuttingBoard
{
	UnityEngine.Transform knifeModel;
	CuttingArea cuttingArea;
	bool <hasFreshItem>k__BackingField;
	// property hasFreshItem
	// RVA: 0x166adbc
	bool get_hasFreshItem() { }
	// RVA: 0x166adc4
	void set_hasFreshItem(bool value) { }
	// RVA: 0x166add0
	void Awake() { }
	// RVA: 0x166af58
	void HoverItem(bool on) { }
	// RVA: 0x166afcc
	void Grab() { }
	// RVA: 0x166b038
	void AttachToArea(InteractableArea _newArea) { }
	// RVA: 0x166b058
	void DetachFromCurrentArea() { }
	// RVA: 0x166ae40
	void EnableKnife(bool showKnife) { }
	// RVA: 0x166b0e0
	void .ctor() { }
}

// TypeDefIndex: 5517
class DatabaseManager
{
	DatabaseManager instance;
	string gameVersion;
	System.Collections.Generic.Dictionary<Gamemode, DownloadedData> <downloadedGamemodeData>k__BackingField;
	DownloadedData noneData;
	DownloadedData tutorialData;
	DownloadedData practiceData;
	DownloadedData normalData;
	DownloadedData pomoData;
	System.Action callbackOnScoresDL;
	// property downloadedGamemodeData
	// RVA: 0x166b140
	System.Collections.Generic.Dictionary<Gamemode, DownloadedData> get_downloadedGamemodeData() { }
	// RVA: 0x166b148
	void set_downloadedGamemodeData(System.Collections.Generic.Dictionary<Gamemode, DownloadedData> value) { }
	// RVA: 0x166b150
	void Awake() { }
	// RVA: 0x166b1a8
	void Start() { }
	// RVA: 0x166b4b4
	void OnDestroy() { }
	// RVA: 0x166b66c
	void OnConnectionChange() { }
	// RVA: 0x166b3a4
	void OnGamemodeChange() { }
	// RVA: 0x166b6f4
	void UploadBurgerScore(Gamemode _gamemode, int burgerScore, string customerName, CustomerOutfit outfit, int orderSize) { }
	// RVA: 0x166b6f0
	void DownloadScoresAndPlayerData(Gamemode _gamemode) { }
	// RVA: 0x166b6f8
	void ParseDataAfterDownload(Gamemode _gamemode, string dlString) { }
	// RVA: 0x166b980
	DownloadedData GetGamemodeData(Gamemode _gamemode) { }
	// RVA: 0x166b9f8
	float GetGamemodeScore(Gamemode _gamemode) { }
	// RVA: 0x166ba9c
	string GetGamemodeBurgerCountString(Gamemode _gamemode) { }
	// RVA: 0x166bbc4
	string GetReviewScoreString(Gamemode _gamemode, float _score) { }
	// RVA: 0x166bce0
	void UploadAnalyticsData() { }
	// RVA: 0x166bce4
	void .ctor() { }
}

// TypeDefIndex: 5518
class GeoData
{
	string country;
	string capital;
	// RVA: 0x166bd6c
	void .ctor() { }
}

// TypeDefIndex: 5519
class DownloadedData
{
	DownloadedScore playerScore;
	DownloadedScore[] topScores;
	DownloadedScore[] upperScores;
	DownloadedScore[] lowerScores;
	DownloadedBurger[] userBurgers;
	// RVA: 0x166bd74
	DownloadedScore[] GetTopScores() { }
	// RVA: 0x166bd7c
	DownloadedScore[] GetRelativeScores() { }
	// RVA: 0x166c074
	bool IsPlayerInTop6() { }
	// RVA: 0x166c098
	bool IsPlayerOnDatabase() { }
	// RVA: 0x166c0a8
	void .ctor() { }
}

// TypeDefIndex: 5520
class DownloadedScore
{
	int ID;
	string SteamId;
	string Gamemode;
	int Score;
	string Username;
	int userRank;
	bool isPlayer;
	bool hasCheckedIfIsPlayer;
	// RVA: 0x166bfe4
	bool IsPlayer() { }
	// RVA: 0x166c0b0
	void .ctor() { }
}

// TypeDefIndex: 5521
class DownloadedBurger
{
	string Date;
	string Gamemode;
	string SteamId;
	string Username;
	int Score;
	string Customer;
	// RVA: 0x166c0b8
	void .ctor() { }
}

// TypeDefIndex: 5522
class DayCycle.<>c__DisplayClass30_0
{
	DayCycle <>4__this;
	UnityEngine.AudioClip nextAmbienceSound;
	// RVA: 0x166caa8
	void .ctor() { }
	// RVA: 0x166cd0c
	void <FadeAmbienceSound>b__0() { }
}

// TypeDefIndex: 5523
class DayCycle.<CheckTimeLoop>d__24
{
	int <>1__state;
	object <>2__current;
	DayCycle <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x166c440
	void .ctor(int <>1__state) { }
	// RVA: 0x166cd50
	void System.IDisposable.Dispose() { }
	// RVA: 0x166cd54
	bool MoveNext() { }
	// RVA: 0x166cdfc
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x166ce04
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x166ce3c
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5524
class DayCycle.<DayTransition>d__28
{
	int <>1__state;
	object <>2__current;
	DayTime _newDayState;
	DayCycle <>4__this;
	float _transitionTime;
	float <startingT>5__2;
	float <endingT>5__3;
	float <difT>5__4;
	float <t>5__5;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x166c82c
	void .ctor(int <>1__state) { }
	// RVA: 0x166ce44
	void System.IDisposable.Dispose() { }
	// RVA: 0x166ce48
	bool MoveNext() { }
	// RVA: 0x166d2cc
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x166d2d4
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x166d30c
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5525
class DayCycle
{
	DayTime <currentDayTime>k__BackingField;
	UnityEngine.Vector3 dayLightAngle;
	UnityEngine.Vector3 nightLightAngle;
	System.Collections.Generic.Dictionary<int, DayTime> daylightTimes;
	System.Collections.Generic.Dictionary<int, DayTime> daylightTimesHalloween;
	System.Collections.Generic.Dictionary<int, DayTime> daylightTimesChristmas;
	UnityEngine.Light dayLight;
	UnityEngine.Gradient lightColor;
	UnityEngine.AnimationCurve shadowStrength;
	UnityEngine.Gradient fogColor;
	UnityEngine.AnimationCurve fogEndDist;
	UnityEngine.Coroutine dayTransition;
	UnityEngine.Material skyboxDay;
	UnityEngine.Material skyboxNoon;
	UnityEngine.Material skyboxNight;
	UnityEngine.AudioSource ambiencePlayer;
	UnityEngine.AudioClip ambientDay;
	UnityEngine.AudioClip ambientNight;
	UnityEngine.Gradient ambientColor;
	DG.Tweening.Sequence ambienceSequence;
	// property currentDayTime
	// RVA: 0x166c0c0
	DayTime get_currentDayTime() { }
	// RVA: 0x166c108
	void set_currentDayTime(DayTime value) { }
	// RVA: 0x166c154
	void Start() { }
	// RVA: 0x166c340
	void OnDestroy() { }
	// RVA: 0x166c2d4
	System.Collections.IEnumerator CheckTimeLoop() { }
	// RVA: 0x166c468
	void UpdateDayState(float _transitionTime) { }
	// RVA: 0x166c4f8
	DayTime GetDayStateForThisHourAndSeason(int hour) { }
	// RVA: 0x166c730
	void SwitchDayNight(DayTime _newDayState, float _transitionTime) { }
	// RVA: 0x166c7a0
	System.Collections.IEnumerator DayTransition(DayTime _newDayState, float _transitionTime) { }
	// RVA: 0x166c854
	void FadeAmbienceSound(DayTime _previousDayTime, DayTime _nextDayTime) { }
	// RVA: 0x166cab0
	bool IsAmbientNightSounds(DayTime _dayTimeToCheck) { }
	// RVA: 0x166cae8
	DayTime GetSimplifiedDayTime(DayTime _dayTimeToCheck) { }
	// RVA: 0x166cb0c
	void OnSeasonChange() { }
	// RVA: 0x166cb14
	void .ctor() { }
}

// TypeDefIndex: 5526
class DayTime
{
	int value__;
	DayTime None;
	DayTime Day;
	DayTime Noon;
	DayTime Night;
	DayTime HalloweenNoon;
	DayTime HalloweenNight;
	DayTime ChristmasDay;
	DayTime ChristmasNoon;
	DayTime ChristmasNight;
}

// TypeDefIndex: 5527
class Deadzone
{
	// RVA: 0x166d314
	void OnTriggerEnter(UnityEngine.Collider col) { }
	// RVA: 0x166d388
	void .ctor() { }
}

// TypeDefIndex: 5528
class DialogDisplayer.<ShowDialogProgressive>d__39
{
	int <>1__state;
	object <>2__current;
	DialogDisplayer <>4__this;
	UnityEngine.WaitForSeconds <timePerLetter>5__2;
	UnityEngine.WaitForSeconds <timePerComma>5__3;
	UnityEngine.WaitForSeconds <timePerDot>5__4;
	System.Collections.Generic.List<char> <dotTimedChars>5__5;
	string <sentence>5__6;
	int <textProgress>5__7;
	bool <onTag>5__8;
	int <i>5__9;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x166e9a8
	void .ctor(int <>1__state) { }
	// RVA: 0x166eca4
	void System.IDisposable.Dispose() { }
	// RVA: 0x166eca8
	bool MoveNext() { }
	// RVA: 0x166f2a8
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x166f2b0
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x166f2e8
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5529
class DialogDisplayer
{
	DialogDisplayer instance;
	DialogType currentDisplaying;
	UnityEngine.GameObject dialogPanel;
	UnityEngine.UI.Image dialogBg;
	UnityEngine.RectTransform dialogGroup;
	TextController dialogText;
	UnityEngine.UI.Image dialogAvatar;
	UnityEngine.GameObject windowModeToggledPanel;
	UnityEngine.GameObject continueIcon;
	DG.Tweening.Sequence dialogSequence;
	bool canPressContinueDialog;
	UnityEngine.Sprite tailoIdle;
	UnityEngine.Sprite tailoCool;
	UnityEngine.Sprite tailoSigh;
	UnityEngine.Sprite tailoThink;
	UnityEngine.Sprite tailoPoint;
	UnityEngine.Sprite tailoSurprise;
	UnityEngine.GameObject missionPanel;
	UnityEngine.RectTransform missionGroup;
	UnityEngine.UI.Image missionImg;
	TextController missionText;
	UnityEngine.GameObject[] missionGuidePanels;
	UnityEngine.UI.Image[] missionGuideImgs;
	DG.Tweening.Sequence missionSequence;
	bool <ClickBG>k__BackingField;
	// property ClickBG
	// RVA: 0x166d390
	bool get_ClickBG() { }
	// RVA: 0x166d398
	void set_ClickBG(bool value) { }
	// RVA: 0x166d3a4
	void Awake() { }
	// RVA: 0x166d58c
	void Start() { }
	// RVA: 0x166d73c
	void OnDestroy() { }
	// RVA: 0x166d694
	void OnWindowMinimized() { }
	// RVA: 0x166d83c
	void Update() { }
	// RVA: 0x166d98c
	void Display(MissionId _dialogId) { }
	// RVA: 0x166db00
	void DisplayDialog(MissionId _dialogId) { }
	// RVA: 0x166e7e0
	void DisplayCustomDialog(string _textToDisplay) { }
	// RVA: 0x166e6cc
	void SetDialogAvatar(MissionId _dialogId) { }
	// RVA: 0x166e90c
	TailoEmotions GetTailoEmotion(MissionId _dialogId) { }
	// RVA: 0x166d8f0
	void SetAsContinuableDialog(bool continuable) { }
	// RVA: 0x166e774
	System.Collections.IEnumerator ShowDialogProgressive() { }
	// RVA: 0x166dc10
	void DisplayMission(MissionId _dialogId) { }
	// RVA: 0x166d530
	void HideAll(bool instant) { }
	// RVA: 0x166e9d0
	void HideDialog() { }
	// RVA: 0x166de54
	void HideMission() { }
	// RVA: 0x166de5c
	void DialogPopUpAnimation(bool show) { }
	// RVA: 0x166e494
	void DialogBounceCharacter() { }
	// RVA: 0x166e9d8
	void MissionPopUpAnimation(bool show) { }
	// RVA: 0x166ec5c
	void .ctor() { }
	// RVA: 0x166ec64
	void <DialogPopUpAnimation>b__44_0() { }
	// RVA: 0x166ec84
	void <MissionPopUpAnimation>b__46_0() { }
}

// TypeDefIndex: 5530
class DialogType
{
	int value__;
	DialogType None;
	DialogType Dialog;
	DialogType Mission;
}

// TypeDefIndex: 5531
class TailoEmotions
{
	int value__;
	TailoEmotions None;
	TailoEmotions Idle;
	TailoEmotions Cool;
	TailoEmotions Point;
	TailoEmotions Sigh;
	TailoEmotions Surprise;
	TailoEmotions Think;
}

// TypeDefIndex: 5532
class Dish.<>c
{
	Dish+<>c <>9;
	System.Func<ItemId, bool> <>9__38_0;
	System.Func<ItemId, bool> <>9__38_1;
	// RVA: 0x1671c00
	void .cctor() { }
	// RVA: 0x1671c68
	void .ctor() { }
	// RVA: 0x1671c70
	bool <ApplyRequiredIngredientsFails>b__38_0(ItemId t) { }
	// RVA: 0x1671c7c
	bool <ApplyRequiredIngredientsFails>b__38_1(ItemId t) { }
}

// TypeDefIndex: 5533
class Dish
{
	UnityEngine.BoxCollider itemExploderBC;
	UnityEngine.GameObject cleanShine;
	DishContent <dishContent>k__BackingField;
	bool <isExploded>k__BackingField;
	DG.Tweening.Tween contentPunchTween;
	AudioPlayer audioPlayer;
	UnityEngine.MeshFilter toppingPrefab;
	UnityEngine.Transform burgerParent;
	System.Collections.Generic.Dictionary<ItemId, System.Collections.Generic.List<UnityEngine.Transform>> instantedToppings;
	DishArea dishToppingDetectionArea;
	Cup cupPrefab;
	UnityEngine.Transform cupParent;
	Cup <attachedCup>k__BackingField;
	UnityEngine.Transform sideParent;
	GrabableItem attachedSide;
	// property dishContent
	// property isExploded
	// property attachedCup
	// RVA: 0x166f2f0
	DishContent get_dishContent() { }
	// RVA: 0x166f2f8
	void set_dishContent(DishContent value) { }
	// RVA: 0x166f300
	bool get_isExploded() { }
	// RVA: 0x166f308
	void set_isExploded(bool value) { }
	// RVA: 0x166f314
	Cup get_attachedCup() { }
	// RVA: 0x166f31c
	void set_attachedCup(Cup value) { }
	// RVA: 0x166f32c
	void Awake() { }
	// RVA: 0x166f430
	void Interact() { }
	// RVA: 0x166f400
	void ClearDish() { }
	// RVA: 0x1670c68
	void AddToothpick(Toothpick _receivedToothpick) { }
	// RVA: 0x1670d1c
	void ContentPunchAnim() { }
	// RVA: 0x1670e48
	void AddNewIngredient(ItemId _itemId, bool _isUnfresh, bool _isDirty) { }
	// RVA: 0x1670f04
	void AddNewSauce(GrabableItem _receivedItem) { }
	// RVA: 0x1670f3c
	void AddNewCup(Cup _cup) { }
	// RVA: 0x1670f64
	void AddNewSide(ItemId _sideId) { }
	// RVA: 0x1670f8c
	void DetachCup(GrabableItem _grabableItem) { }
	// RVA: 0x1671148
	void DetachSide(GrabableItem _grabableItem) { }
	// RVA: 0x166f4d0
	void DestroyExceedingToppingTransforms() { }
	// RVA: 0x16651a0
	void SetAsGrabbedByCustomer(CustomerController _customer) { }
	// RVA: 0x166f9b4
	void UpdateContentTransforms() { }
	// RVA: 0x1663028
	void ApplyRequiredIngredientsFails(System.Collections.Generic.List<ItemId> requiredItems) { }
	// RVA: 0x16643c4
	void ApplyAvoidedIngredientsFails(System.Collections.Generic.List<ItemId> avoidedItems) { }
	// RVA: 0x1671378
	void PlayCleanShine() { }
	// RVA: 0x1671400
	ItemId Explode() { }
	// RVA: 0x1671b54
	void .ctor() { }
}

// TypeDefIndex: 5534
class DishContent.<>c__DisplayClass43_0
{
	System.Collections.Generic.List<ItemId> requiredItems;
	System.Collections.Generic.List<ItemId> avoidedItems;
	System.Collections.Generic.List<ItemId> itemsToIgnore;
	// RVA: 0x1673dcc
	void .ctor() { }
	// RVA: 0x1673ee4
	bool <GetExtraLoverValidIngredientsCount>b__0(ItemId x) { }
}

// TypeDefIndex: 5535
class DishContent
{
	System.Collections.Generic.List<ItemId> content;
	System.Collections.Generic.List<ItemId> burgerContent;
	bool isBurgerDirty;
	bool isBurgerUnfresh;
	CustomerBreed toothpickBreed;
	bool isToothPickDirty;
	ItemId cupId;
	float cupFill;
	bool isCupDirty;
	ItemId sideId;
	// RVA: 0x1671c94
	void AddBurgerTopping(ItemId _newTopping, bool _isUnfresh, bool _isDirty) { }
	// RVA: 0x1671dd0
	void AddBurgerSauce(ItemId _sauceId) { }
	// RVA: 0x1672244
	void AddToothpick(Toothpick _toothpick) { }
	// RVA: 0x1672388
	void AddCup(Cup _cup) { }
	// RVA: 0x1672444
	void RemoveCup() { }
	// RVA: 0x16724a8
	void AddSide(ItemId _itemId) { }
	// RVA: 0x1672550
	void RemoveSide() { }
	// RVA: 0x16725b0
	void ClearAll() { }
	// RVA: 0x1671dc4
	void SetDirty() { }
	// RVA: 0x1671db8
	void SetUnfresh() { }
	// RVA: 0x1672630
	bool Contains(ItemId _itemId) { }
	// RVA: 0x1672688
	bool IsTotallyEmpty() { }
	// RVA: 0x16726f8
	bool IsBurgerStarted() { }
	// RVA: 0x1672774
	bool IsBurgerClosed() { }
	// RVA: 0x16727f0
	bool IsBurgerBunsOpen() { }
	// RVA: 0x1672820
	bool IsDirty() { }
	// RVA: 0x1672848
	bool IsUnfresh() { }
	// RVA: 0x1672850
	bool IsThisACompleteMeatBurger() { }
	// RVA: 0x1672964
	bool IsThisACompleteVeggieBurger() { }
	// RVA: 0x1672a48
	bool IsThisACompleteSmashBurger() { }
	// RVA: 0x16720bc
	bool HasAnySauce() { }
	// RVA: 0x1672afc
	bool HasAnyCup() { }
	// RVA: 0x1672bc0
	bool HasAnySide() { }
	// RVA: 0x1672c3c
	bool HasAnythingBurnt() { }
	// RVA: 0x1672cd0
	bool HasAnyRawPatty() { }
	// RVA: 0x1672d4c
	bool HasCorrectToothpick(CustomerBreed _expectedPick) { }
	// RVA: 0x1672db8
	bool HasCorrectSpecialSauce(CustomerController customer, System.Collections.Generic.List<ItemId> reqItems, System.Collections.Generic.List<ItemId> avoidItems) { }
	// RVA: 0x1672f9c
	bool HasCorrectMeat(System.Collections.Generic.List<ItemId> requiredItems) { }
	// RVA: 0x16730e4
	bool HasCorrectSpecialMeat(System.Collections.Generic.List<ItemId> requiredItems) { }
	// RVA: 0x167319c
	bool HasAnyWellCookedMeat() { }
	// RVA: 0x1673260
	int GetContentCount() { }
	// RVA: 0x16732a8
	int GetCorrectContentCount(System.Collections.Generic.List<ItemId> requiredItems) { }
	// RVA: 0x167345c
	int GetComplexToppingsExtraValue(System.Collections.Generic.List<ItemId> requiredItems) { }
	// RVA: 0x1673630
	int GetExtraLoverValidIngredientsCount(System.Collections.Generic.List<ItemId> requiredItems, System.Collections.Generic.List<ItemId> avoidedItems) { }
	// RVA: 0x1673dd4
	ItemId GetCurrentCup() { }
	// RVA: 0x1673ddc
	ItemId GetCurrentSide() { }
	// RVA: 0x1673de4
	bool HasMatchingCupFlavor(ItemId _flavorOnCheck) { }
	// RVA: 0x1673e00
	bool IsCupFilledEnoughForCustomer() { }
	// RVA: 0x1673e2c
	void .ctor() { }
}

// TypeDefIndex: 5536
class DishArea.<>c
{
	DishArea+<>c <>9;
	System.Func<ItemId, bool> <>9__12_0;
	// RVA: 0x1674ca0
	void .cctor() { }
	// RVA: 0x1674d08
	void .ctor() { }
	// RVA: 0x1674d10
	bool <HasFreeSlot>b__12_0(ItemId t) { }
}

// TypeDefIndex: 5537
class DishArea.<>c__DisplayClass13_0
{
	System.Collections.Generic.List<ItemId> ingredientsToCheck;
	// RVA: 0x167473c
	void .ctor() { }
	// RVA: 0x1674d28
	bool <CountIngredientsInPlate>b__0(ItemId item) { }
}

// TypeDefIndex: 5538
class DishArea
{
	Dish <dish>k__BackingField;
	StoragedItem[] itemVariety;
	AudioPlayer audioPlayer;
	UnityEngine.BoxCollider bC;
	System.Collections.Generic.List<ItemId> meatIngredients;
	// property dish
	// RVA: 0x1673f80
	Dish get_dish() { }
	// RVA: 0x1673f88
	void set_dish(Dish value) { }
	// RVA: 0x1673f90
	void Awake() { }
	// RVA: 0x1674130
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x1674350
	void WithdrawItem(GrabableItem withdrawedItem) { }
	// RVA: 0x1674354
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x1674358
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x167464c
	int CountIngredientsInPlate(System.Collections.Generic.List<ItemId> ingredientsToCheck) { }
	// RVA: 0x1674744
	void ReadjustBoxCollider(float _maxHeight) { }
	// RVA: 0x1674884
	void .ctor() { }
}

// TypeDefIndex: 5539
class DishPile
{
	// RVA: 0x1674d80
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x1674dc0
	bool IsEmptyPlate(GrabableItem receivedItem) { }
	// RVA: 0x1674e4c
	void .ctor() { }
}

// TypeDefIndex: 5540
class DontDestroyOnLoadScript
{
	// RVA: 0x1674e54
	void Awake() { }
	// RVA: 0x1674ec0
	void .ctor() { }
}

// TypeDefIndex: 5541
class DrawerButton
{
	UnityEngine.GameObject drawerContent;
	UnityEngine.Vector3 closedPos;
	UnityEngine.Vector3 openedPos;
	bool haveSeenCardsBefore;
	bool isOpen;
	AudioPlayer audioPlayer;
	UnityEngine.Rigidbody rb;
	DG.Tweening.Sequence openSeq;
	// RVA: 0x1674ec8
	void Awake() { }
	// RVA: 0x1675068
	void OnEnable() { }
	// RVA: 0x1675190
	void OnDestroy() { }
	// RVA: 0x16752c0
	void Interact() { }
	// RVA: 0x1675374
	void OpenDrawer(bool _open) { }
	// RVA: 0x1675638
	void RightInteract() { }
	// RVA: 0x1675644
	void OnRestock(bool isRestockStarting) { }
	// RVA: 0x16750c8
	void Restore() { }
	// RVA: 0x16755c8
	void JustSeenCards() { }
	// RVA: 0x1675658
	void .ctor() { }
	// RVA: 0x16756fc
	void <OpenDrawer>b__12_0() { }
}

// TypeDefIndex: 5542
class EmotionController.Emotion
{
	int value__;
	EmotionController+Emotion Neutral;
	EmotionController+Emotion Happy;
	EmotionController+Emotion Disappoint;
	EmotionController+Emotion Angry;
}

// TypeDefIndex: 5543
class EmotionController.<WaitToDisable>d__12
{
	int <>1__state;
	object <>2__current;
	EmotionController <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1675aa0
	void .ctor(int <>1__state) { }
	// RVA: 0x1675afc
	void System.IDisposable.Dispose() { }
	// RVA: 0x1675b00
	bool MoveNext() { }
	// RVA: 0x1675b9c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1675ba4
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x1675bdc
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5544
class EmotionController
{
	UnityEngine.Coroutine disableCoroutine;
	UnityEngine.GameObject normalEyes;
	UnityEngine.GameObject happyEyes;
	UnityEngine.GameObject happyEffectGroup;
	UnityEngine.ParticleSystem happyLoopParticles;
	UnityEngine.GameObject disappointEyes;
	UnityEngine.GameObject angryEffectGroup;
	UnityEngine.ParticleSystem angrySingleParticles;
	UnityEngine.ParticleSystem angryLoopParticles;
	// RVA: 0x167571c
	void SetAngry(bool isEndless) { }
	// RVA: 0x167593c
	void SetDisappoint(float time) { }
	// RVA: 0x1675a20
	void SetHappy(float _time) { }
	// RVA: 0x16758d0
	System.Collections.IEnumerator WaitToDisable() { }
	// RVA: 0x16757c4
	void Disable() { }
	// RVA: 0x1675ac8
	void StopDisableCoroutine() { }
	// RVA: 0x1675838
	void EnableEmotion(EmotionController+Emotion _newEmotion) { }
	// RVA: 0x1675af4
	void .ctor() { }
}

// TypeDefIndex: 5545
class EncryptionKeys
{
	string webEncryptionKey;
	string localEncryptionKey;
	// property WebEncryptionKey
	// property LocalEncryptionKey
	// RVA: 0x1675be4
	string get_WebEncryptionKey() { }
	// RVA: 0x1675bec
	string get_LocalEncryptionKey() { }
	// RVA: 0x1675bf4
	void .ctor() { }
}

// TypeDefIndex: 5546
class FailedItemDetector
{
	System.Collections.Generic.List<ItemId> ignorableItems;
	CookingFail cookingFail;
	// RVA: 0x1675c5c
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x1675de4
	void .ctor() { }
}

// TypeDefIndex: 5547
class FenceController.FenceState
{
	int value__;
	FenceController+FenceState None;
	FenceController+FenceState Open;
	FenceController+FenceState Mid;
	FenceController+FenceState Closed;
}

// TypeDefIndex: 5548
class FenceController
{
	FenceController instance;
	bool isCurrentlyOpen;
	bool canBeOpened;
	FenceController+FenceState maxOpenState;
	FenceController+FenceState currentFenceState;
	float closedYPos;
	float semiOpenYPos;
	float openYPos;
	DG.Tweening.Sequence fenceSeq;
	UnityEngine.Transform fenceMeshTr;
	System.Action<bool> callbackOnFenceOpen;
	int timesCookUsedFence;
	int timesToFenceSpamWarning;
	AudioPlayer audioPlayer;
	UnityEngine.Material opaqueMat;
	UnityEngine.Material fadedMat;
	UnityEngine.MeshRenderer mRnd;
	UnityEngine.BoxCollider bC;
	// RVA: 0x1675e6c
	void Awake() { }
	// RVA: 0x16760c4
	void Start() { }
	// RVA: 0x16764cc
	void OnDestroy() { }
	// RVA: 0x1676744
	void OnWindowChange() { }
	// RVA: 0x1676004
	void UpdateMeshRenderer() { }
	// RVA: 0x1676808
	void AutoOpenFence() { }
	// RVA: 0x1676814
	void OnGamemodeChange() { }
	// RVA: 0x1676820
	void OnCustomerSpawnDespawn(bool spawn) { }
	// RVA: 0x1676338
	void UpdateMaxOpenState() { }
	// RVA: 0x167692c
	void ChangeFenceState(FenceController+FenceState _newFenceState, bool allowPushAnim) { }
	// RVA: 0x1676fd4
	bool IsFenceOpen() { }
	// RVA: 0x16770f8
	bool IsFenceLockedDown() { }
	// RVA: 0x167711c
	void OnPomodoroContinueOrPause(bool isTimeRunning) { }
	// RVA: 0x1677148
	void InteractFromPomodoroContinue(bool openFence) { }
	// RVA: 0x1677174
	void CloseFenceManually() { }
	// RVA: 0x1677180
	void Interact() { }
	// RVA: 0x1677274
	void RightInteract() { }
	// RVA: 0x16771b4
	void AddUseToFenceSpam() { }
	// RVA: 0x1677280
	void ResetTimesCookUsedFence() { }
	// RVA: 0x1677288
	void .ctor() { }
	// RVA: 0x16772a4
	void <ChangeFenceState>b__27_0() { }
	// RVA: 0x16772a8
	void <ChangeFenceState>b__27_1() { }
	// RVA: 0x16772ac
	void <ChangeFenceState>b__27_2() { }
}

// TypeDefIndex: 5549
class FenceIconDisplayer
{
	UnityEngine.GameObject pomoIcon;
	bool initialized;
	UnityEngine.Animator anim;
	// RVA: 0x16772b0
	void Awake() { }
	// RVA: 0x16772b4
	void Initialize() { }
	// RVA: 0x1677354
	void PlayOpenError(Gamemode _gamemode) { }
	// RVA: 0x1677330
	void DisableGameObject() { }
	// RVA: 0x1677414
	void .ctor() { }
}

// TypeDefIndex: 5550
class Fireball
{
	UnityEngine.Rigidbody rb;
	UnityEngine.ParticleSystem[] fireParticles;
	AudioPlayer audioPlayer;
	// RVA: 0x167741c
	void Awake() { }
	// RVA: 0x16775e4
	void Start() { }
	// RVA: 0x16777ac
	void DestroyByRestock(bool restockOn) { }
	// RVA: 0x16777b0
	void AutoDestroy() { }
	// RVA: 0x1677890
	void OnDestroy() { }
	// RVA: 0x16779b4
	void .ctor() { }
}

// TypeDefIndex: 5551
class FloorManager
{
	FloorManager instance;
	bool isMotionFloor;
	UnityEngine.GameObject normalFloor;
	UnityEngine.GameObject antiMotionFloor;
	// RVA: 0x16779bc
	void Awake() { }
	// RVA: 0x1677a14
	void Start() { }
	// RVA: 0x1677aa8
	void ToggleMotionFloor(System.Nullable<bool> forceMotionState) { }
	// RVA: 0x1677b88
	void .ctor() { }
}

// TypeDefIndex: 5552
class FPSDisplay
{
	float avgDeltaTime;
	UnityEngine.GUIStyle style;
	// RVA: 0x1677b98
	void Start() { }
	// RVA: 0x1677c50
	void Update() { }
	// RVA: 0x1677c8c
	void OnGUI() { }
	// RVA: 0x1677e18
	void .ctor() { }
}

// TypeDefIndex: 5553
class Freezer
{
	UnityEngine.Transform door1;
	UnityEngine.Transform door2;
	UnityEngine.BoxCollider areaTrigger1;
	UnityEngine.BoxCollider areaTrigger2;
	float doorTime;
	DG.Tweening.Sequence doorsSeq;
	FreezerDoorState <currentDoorState>k__BackingField;
	System.Action<FreezerDoorState> callbackOnFreezerSlideDoorChange;
	AudioPlayer audioPlayer;
	// property currentDoorState
	// RVA: 0x1677e20
	FreezerDoorState get_currentDoorState() { }
	// RVA: 0x1677e28
	void set_currentDoorState(FreezerDoorState value) { }
	// RVA: 0x1677e30
	void Start() { }
	// RVA: 0x16780f8
	void OnDestroy() { }
	// RVA: 0x1678384
	void ClickDoor1() { }
	// RVA: 0x16785c8
	void ClickDoor2() { }
	// RVA: 0x1678810
	void RestoreState() { }
	// RVA: 0x1678940
	void RestoreState(bool isRestockStarting) { }
	// RVA: 0x1678850
	void CloseDoorsInstant() { }
	// RVA: 0x167898c
	void UpdateAreaTriggers(FreezerDoorState _currentDoorState) { }
	// RVA: 0x16789d8
	void .ctor() { }
}

// TypeDefIndex: 5554
class FreezerDoorState
{
	int value__;
	FreezerDoorState Closed;
	FreezerDoorState Open1;
	FreezerDoorState Open2;
}

// TypeDefIndex: 5555
class FridgeDoor
{
	FridgeDoor instance;
	bool <isOpen>k__BackingField;
	UnityEngine.Transform doorAxis;
	float openedYAxis;
	float closedYAxis;
	DG.Tweening.Sequence doorTween;
	UnityEngine.MeshCollider meshCol;
	System.Action<bool> callbackOnFridgeDoorChange;
	AudioPlayer audioPlayer;
	float timeCountToStale;
	float totalTimeToStaleCheese;
	System.Action callbackStaleFood;
	// property isOpen
	// RVA: 0x16789ec
	bool get_isOpen() { }
	// RVA: 0x16789f4
	void set_isOpen(bool value) { }
	// RVA: 0x1678a00
	void Awake() { }
	// RVA: 0x1678ca0
	void Update() { }
	// RVA: 0x1678d08
	void ResetTimeToStale() { }
	// RVA: 0x1678d10
	void OnDestroy() { }
	// RVA: 0x1678e40
	void RightInteract() { }
	// RVA: 0x1678e4c
	void Interact() { }
	// RVA: 0x1678ef8
	void Open(bool _open) { }
	// RVA: 0x1679120
	void RestoreState(bool isRestockStarting) { }
	// RVA: 0x1678bd8
	void InstantClose() { }
	// RVA: 0x1679134
	void .ctor() { }
	// RVA: 0x167913c
	void <Open>b__21_0() { }
}

// TypeDefIndex: 5556
class FryingPan
{
	ItemId itemOnPan;
	float cookingTime;
	System.Collections.Generic.Dictionary<ItemId, float> timeToNextState;
	System.Collections.Generic.List<ItemId> benefitStatesWithExtractor;
	float timeToChangeToNextState;
	float timeOnFire;
	float timeToExtinguish;
	float timeToBurnWithExtractor;
	bool <isOnFire>k__BackingField;
	bool isCooking;
	FryingPanArea fPanArea;
	UnityEngine.GameObject fireParticlesGo;
	UnityEngine.ParticleSystem[] fireParticles;
	UnityEngine.ParticleSystem cookingParticles;
	UnityEngine.GameObject cookingChangeParticles;
	AudioPlayer panAudioPlayer;
	Fireball fireballPrefab;
	float fireballTimer;
	float secBetweenFireballs;
	bool isUnderWater;
	UnityEngine.GameObject waterArea;
	// property isOnFire
	// RVA: 0x1679184
	bool get_isOnFire() { }
	// RVA: 0x167918c
	void set_isOnFire(bool value) { }
	// RVA: 0x1679198
	void Grab() { }
	// RVA: 0x167940c
	void UpdateFryingPanData(ItemId newItemId) { }
	// RVA: 0x167954c
	void Awake() { }
	// RVA: 0x1679968
	void OnDestroy() { }
	// RVA: 0x1679b60
	void Update() { }
	// RVA: 0x1679d58
	void CountFireTime() { }
	// RVA: 0x1679cc8
	void CountCookingTime() { }
	// RVA: 0x1679544
	void ResetCookingTime() { }
	// RVA: 0x1679684
	void SetOnCooking(bool on, bool force) { }
	// RVA: 0x1679e7c
	void TransformToNextState() { }
	// RVA: 0x167a144
	void PlayCookingChangeParticles() { }
	// RVA: 0x1679948
	void AutodisableCookingChangeParticles() { }
	// RVA: 0x1679740
	void SetOnFire(bool on) { }
	// RVA: 0x167a31c
	void Fireburst() { }
	// RVA: 0x1679da4
	void TimeFireballs() { }
	// RVA: 0x167a348
	void SpawnFireball() { }
	// RVA: 0x167a4dc
	void OnTriggerEnter(UnityEngine.Collider col) { }
	// RVA: 0x167a62c
	void OnTriggerExit(UnityEngine.Collider col) { }
	// RVA: 0x167a454
	void GetOutOfWater() { }
	// RVA: 0x167a6d4
	void .ctor() { }
}

// TypeDefIndex: 5557
class FryingPanArea
{
	UnityEngine.Transform spawnpoint;
	FryingPan fPan;
	StoragedItem[] itemVariety;
	UnityEngine.BoxCollider <boxCollider>k__BackingField;
	DG.Tweening.Tween punchChangeFoodTween;
	bool <hasUnfreshItem>k__BackingField;
	bool <hasDirtyItem>k__BackingField;
	AudioPlayer audioPlayer;
	// property boxCollider
	// property hasUnfreshItem
	// property hasDirtyItem
	// RVA: 0x167abc4
	UnityEngine.BoxCollider get_boxCollider() { }
	// RVA: 0x167abcc
	void set_boxCollider(UnityEngine.BoxCollider value) { }
	// RVA: 0x167abd4
	bool get_hasUnfreshItem() { }
	// RVA: 0x167abdc
	void set_hasUnfreshItem(bool value) { }
	// RVA: 0x167abe8
	bool get_hasDirtyItem() { }
	// RVA: 0x167abf0
	void set_hasDirtyItem(bool value) { }
	// RVA: 0x167abfc
	void Awake() { }
	// RVA: 0x167adcc
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x167ae9c
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x167aed4
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x1679f60
	void ChangePanContent(GrabableItem receivedItem, ItemId receivedItemId) { }
	// RVA: 0x167aed8
	bool IsPanEmpty() { }
	// RVA: 0x167b018
	void PunchEnabledItems() { }
	// RVA: 0x167b138
	void .ctor() { }
}

// TypeDefIndex: 5558
class GameManager
{
	bool <gamePaused>k__BackingField;
	GameSeason <currentGameSeason>k__BackingField;
	System.Action callbackOnGameSeasonChange;
	System.Action<bool> callbackPauseGame;
	System.Collections.Generic.List<object> panelsPausingTheGame;
	Gamemode <currentGamemode>k__BackingField;
	System.Action callbackOnGamemodeChange;
	WindowStatus <windowStatus>k__BackingField;
	System.Action callbackOnWindowChange;
	bool <isRestocking>k__BackingField;
	System.Action<bool> callbackOnRestockEvent;
	int onFireCounter;
	bool <isSomethingOnFire>k__BackingField;
	System.Action callbackOnFireChange;
	// property gamePaused
	// property currentGameSeason
	// property currentGamemode
	// property windowStatus
	// property isRestocking
	// property isSomethingOnFire
	// RVA: 0x167b140
	bool get_gamePaused() { }
	// RVA: 0x167b198
	void set_gamePaused(bool value) { }
	// RVA: 0x167b1f8
	GameSeason get_currentGameSeason() { }
	// RVA: 0x167b250
	void set_currentGameSeason(GameSeason value) { }
	// RVA: 0x167b2ac
	Gamemode get_currentGamemode() { }
	// RVA: 0x167b304
	void set_currentGamemode(Gamemode value) { }
	// RVA: 0x167b360
	WindowStatus get_windowStatus() { }
	// RVA: 0x167b3b8
	void set_windowStatus(WindowStatus value) { }
	// RVA: 0x167b414
	bool get_isRestocking() { }
	// RVA: 0x167b46c
	void set_isRestocking(bool value) { }
	// RVA: 0x167b4cc
	bool get_isSomethingOnFire() { }
	// RVA: 0x167b524
	void set_isSomethingOnFire(bool value) { }
	// RVA: 0x167b584
	void Awake() { }
	// RVA: 0x167b900
	void Start() { }
	// RVA: 0x167b904
	void LoadLastSeason() { }
	// RVA: 0x167bbd8
	void SetWindowStatus(WindowStatus _newWindowStatus) { }
	// RVA: 0x167bcf4
	void PauseGame(bool pause, object pausingPanel) { }
	// RVA: 0x167b60c
	void PauseGame(bool pause) { }
	// RVA: 0x167be34
	void OnRestockEvent(bool isStarting) { }
	// RVA: 0x167bee4
	void SetRefillingPause(bool _isRefilling) { }
	// RVA: 0x167b72c
	void ChangeCurrentGamemode(Gamemode _newGamemode) { }
	// RVA: 0x167bce8
	void UpdateFreeCursor() { }
	// RVA: 0x167a1c8
	void SetSomethingOnFire(bool _onFire) { }
	// RVA: 0x167ba30
	void ChangeGameSeason(GameSeason _newGameSeason) { }
	// RVA: 0x167bf74
	bool CheckCurrentSeason(GameSeason _seasonToCheck) { }
	// RVA: 0x167c008
	void .ctor() { }
	// RVA: 0x167c010
	void .cctor() { }
}

// TypeDefIndex: 5559
class WindowStatus
{
	int value__;
	WindowStatus InGame;
	WindowStatus InWindow;
	WindowStatus Minimized;
}

// TypeDefIndex: 5560
class Gamemode
{
	int value__;
	Gamemode None;
	Gamemode Tutorial;
	Gamemode Frenetic;
	Gamemode Normal;
	Gamemode Pomodoro;
}

// TypeDefIndex: 5561
class GameSeason
{
	int value__;
	GameSeason None;
	GameSeason Normal;
	GameSeason Halloween;
	GameSeason Christmas;
}

// TypeDefIndex: 5562
class GamemodeTimers
{
	GamemodeTimers instance;
	System.Collections.Generic.Dictionary<Gamemode, Timers> timers;
	System.Action<Gamemode> callbackOnAnyTimerStarts;
	System.Action<Gamemode> callbackOnAnyTimerStops;
	System.Action<Gamemode> callbackOnTimerCompletes;
	System.Action<bool> callbackOnPomodoroPause;
	// RVA: 0x167c0d4
	void Awake() { }
	// RVA: 0x167c12c
	void Start() { }
	// RVA: 0x167c3d0
	void Update() { }
	// RVA: 0x167c3d4
	void CountTime() { }
	// RVA: 0x167c684
	void RestartTimer(Gamemode _gamemode) { }
	// RVA: 0x1676fe4
	void PausePomodoro(bool _paused) { }
	// RVA: 0x167c80c
	bool IsPomodoroAndPaused() { }
	// RVA: 0x167c908
	void OnTimerCompletes(Gamemode _gamemode) { }
	// RVA: 0x167c924
	void StopTimer(Gamemode _gamemode) { }
	// RVA: 0x1676824
	bool IsCurrentTimerRunning() { }
	// RVA: 0x167ca44
	System.ValueTuple<string, string[]> GetTimeLeftStringForMenuPanel(Gamemode _gamemode) { }
	// RVA: 0x167ce6c
	float GetTimeEllapsed(Gamemode _gamemode) { }
	// RVA: 0x167cf1c
	void .ctor() { }
}

// TypeDefIndex: 5563
class Timers
{
	Gamemode gamemode;
	float timer;
	int timeGoal;
	bool isTimerPaused;
	string menuPanelStringFormat;
	int testingMult;
	// RVA: 0x167c278
	void .ctor(Gamemode _gamemode) { }
	// RVA: 0x167c790
	void RestartTimer(int _timeGoal) { }
	// RVA: 0x167d020
	void PauseTimer(bool _paused) { }
	// RVA: 0x167d02c
	bool IsPaused() { }
	// RVA: 0x167c53c
	void CountTime() { }
	// RVA: 0x167d164
	void SkipTimeToZero() { }
	// RVA: 0x167d034
	void OnEveryFrame() { }
	// RVA: 0x167cfa4
	void OnMinuteChange() { }
	// RVA: 0x167c9bc
	void StopTimer() { }
	// RVA: 0x167ca1c
	bool TimeIsRunning() { }
	// RVA: 0x167d4b0
	bool TimeIsOver() { }
	// RVA: 0x167d0b4
	void CompleteTimer() { }
	// RVA: 0x167d188
	System.ValueTuple<string, string[]> GetTimeLeftString() { }
	// RVA: 0x167cb0c
	System.ValueTuple<string, string[]> GetTimeLeftStringForMenuPanel() { }
	// RVA: 0x167cefc
	float GetTimeEllapsed() { }
}

// TypeDefIndex: 5564
class GetRewardCanvas
{
	float TransitionTime;
	GetRewardCanvas <Instance>k__BackingField;
	UnityEngine.Canvas popupCanvas;
	UnityEngine.GameObject popupPanel;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupContent;
	UnityEngine.GameObject adCouponItem;
	TMPro.TMP_Text adCouponAmountText;
	UnityEngine.GameObject coinsItem;
	TMPro.TMP_Text coinsAmountText;
	UnityEngine.GameObject adFreeItem;
	UnityEngine.UI.Button closeButton;
	UnityEngine.UI.Button secondaryCloseButton;
	bool isOnScreen;
	DG.Tweening.Sequence panelTween;
	float backgroundOpacity;
	// property Instance
	// RVA: 0x167d6c4
	GetRewardCanvas get_Instance() { }
	// RVA: 0x167d70c
	void set_Instance(GetRewardCanvas value) { }
	// RVA: 0x167d764
	void Awake() { }
	// RVA: 0x167dc94
	void OnDestroy() { }
	// RVA: 0x167def0
	void Display(System.Collections.Generic.IReadOnlyList<MarsRedeemReward> rewards) { }
	// RVA: 0x167e938
	void PressClose() { }
	// RVA: 0x167dad4
	void HideImmediately() { }
	// RVA: 0x167d900
	void CachePopupElements() { }
	// RVA: 0x167e718
	void PlayOpenAnimation() { }
	// RVA: 0x167ea68
	void PlayCloseAnimation() { }
	// RVA: 0x167e608
	void SetRewardItemsVisible(bool visible) { }
	// RVA: 0x167ec70
	void .ctor() { }
}

// TypeDefIndex: 5565
class GlobalTimer.<SyncTime>d__23
{
	int <>1__state;
	object <>2__current;
	GlobalTimer <>4__this;
	bool <wasTimeSynced>5__2;
	bool <timeReadSuccess>5__3;
	string[] <>7__wrap3;
	int <>7__wrap4;
	UnityEngine.Networking.UnityWebRequest <request>5__6;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x167f144
	void .ctor(int <>1__state) { }
	// RVA: 0x168013c
	void System.IDisposable.Dispose() { }
	// RVA: 0x1680158
	bool MoveNext() { }
	// RVA: 0x1680780
	void <>m__Finally1() { }
	// RVA: 0x1680830
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1680838
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x1680870
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5566
class GlobalTimer.<SyncTimeLoop>d__22
{
	int <>1__state;
	object <>2__current;
	GlobalTimer <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x167f11c
	void .ctor(int <>1__state) { }
	// RVA: 0x1680878
	void System.IDisposable.Dispose() { }
	// RVA: 0x168087c
	bool MoveNext() { }
	// RVA: 0x16809e4
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16809ec
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x1680a24
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5567
class GlobalTimer.<Timer>d__27
{
	int <>1__state;
	object <>2__current;
	GlobalTimer <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x167f728
	void .ctor(int <>1__state) { }
	// RVA: 0x1680a2c
	void System.IDisposable.Dispose() { }
	// RVA: 0x1680a30
	bool MoveNext() { }
	// RVA: 0x1680b2c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1680b34
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x1680b6c
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5568
class GlobalTimer
{
	GlobalTimer instance;
	System.DateTime <gameTime>k__BackingField;
	bool <isTimeSyncedOnline>k__BackingField;
	System.Action callbackOnNormalTimerComplete;
	System.Action callbackOnNormalTimerMinuteUpdate;
	System.Action callbackOnTimeSyncChange;
	int minTimeBetweenCustomers;
	int maxTimeBetweenCustomers;
	System.Collections.Generic.List<int> customerIdsAlreadySpawned;
	System.Collections.Generic.List<NextCustomerSchedule> nextCustomers;
	string[] timeUrls;
	int unsyncRetry;
	int resyncInterval;
	// property gameTime
	// property isTimeSyncedOnline
	// RVA: 0x167ec78
	System.DateTime get_gameTime() { }
	// RVA: 0x167ecd0
	void set_gameTime(System.DateTime value) { }
	// RVA: 0x167ed2c
	bool get_isTimeSyncedOnline() { }
	// RVA: 0x167ed84
	void set_isTimeSyncedOnline(bool value) { }
	// RVA: 0x167ede4
	void Awake() { }
	// RVA: 0x167ee4c
	void Start() { }
	// RVA: 0x167f090
	void ForceResync() { }
	// RVA: 0x167efb8
	System.Collections.IEnumerator SyncTimeLoop() { }
	// RVA: 0x167f0b0
	System.Collections.IEnumerator SyncTime() { }
	// RVA: 0x167ee8c
	void SyncToLocalTime() { }
	// RVA: 0x167f16c
	void ScheduleAllNextCustomers(System.DateTime _gameTime) { }
	// RVA: 0x167f3f8
	NextCustomerSchedule CalculateNextCustomer(System.DateTime previousCustomerDt) { }
	// RVA: 0x167f024
	System.Collections.IEnumerator Timer() { }
	// RVA: 0x167f750
	void AddSecondsToServerTime(int secondsToAdd) { }
	// RVA: 0x167f8fc
	void CheckForNewCustomerTurn() { }
	// RVA: 0x167fc30
	bool AreInSameMinute(System.DateTime dt1, System.DateTime dt2) { }
	// RVA: 0x167fd84
	bool IsInPast(System.DateTime now, System.DateTime supposedPast) { }
	// RVA: 0x167d4c4
	UnityEngine.Vector2Int GetBoundingMinutesForNextCustomer() { }
	// RVA: 0x167fe04
	NextCustomerSchedule GetVeryNextCustomer() { }
	// RVA: 0x167ff70
	void .ctor() { }
	// RVA: 0x1680138
	void .cctor() { }
}

// TypeDefIndex: 5569
class NextCustomerSchedule
{
	int <id>k__BackingField;
	System.DateTime <spawnTime>k__BackingField;
	System.DateTime <minSpawnTime>k__BackingField;
	System.DateTime <maxSpawnTime>k__BackingField;
	// property id
	// property spawnTime
	// property minSpawnTime
	// property maxSpawnTime
	// RVA: 0x1680b74
	int get_id() { }
	// RVA: 0x1680b7c
	void set_id(int value) { }
	// RVA: 0x1680b84
	System.DateTime get_spawnTime() { }
	// RVA: 0x1680b8c
	void set_spawnTime(System.DateTime value) { }
	// RVA: 0x1680b94
	System.DateTime get_minSpawnTime() { }
	// RVA: 0x1680b9c
	void set_minSpawnTime(System.DateTime value) { }
	// RVA: 0x1680ba4
	System.DateTime get_maxSpawnTime() { }
	// RVA: 0x1680bac
	void set_maxSpawnTime(System.DateTime value) { }
	// RVA: 0x167f5e4
	void .ctor(System.DateTime _spawnTime, System.DateTime _minTime, System.DateTime _maxTime) { }
}

// TypeDefIndex: 5570
class GrabableItem.<>c__DisplayClass56_0
{
	System.Action<GrabableItem> callbackOnComplete;
	GrabableItem <>4__this;
	// RVA: 0x168235c
	void .ctor() { }
	// RVA: 0x1682e68
	void <LerpToPoint>b__0() { }
}

// TypeDefIndex: 5571
class GrabableItem
{
	System.Collections.Generic.HashSet<GrabableItem> grabableItemsOnScene;
	bool <isAttacheable>k__BackingField;
	UnityEngine.Vector3 idlePositionOffsetHand;
	bool fixedHandRotation;
	UnityEngine.Vector3 idleRotationOffsetHand;
	UnityEngine.Vector3 idlePositionOffsetCounter;
	bool fixedCounterRotation;
	UnityEngine.Vector3 idleRotationOffsetCounter;
	float initialNonColTime;
	bool <isGrabbed>k__BackingField;
	bool <isUnfresh>k__BackingField;
	bool isDirty;
	UnityEngine.SpringJoint sJoint;
	UnityEngine.Rigidbody <rb>k__BackingField;
	ItemId itemId;
	UnityEngine.LayerMask interactableAreaLayer;
	InteractableArea <areaAttachedTo>k__BackingField;
	System.Collections.Generic.List<InteractableArea> attacheableAreasInRange;
	float spawnTime;
	float destroyTime;
	System.Action<GrabableItem> callbackOnGrab;
	System.Action<InteractableArea> callbackOnAttach;
	bool isManagedByUpgradedDetector;
	System.Collections.Generic.Dictionary<UnityEngine.GameObject, int> _originalLayers;
	// property isAttacheable
	// property isGrabbed
	// property isUnfresh
	// property rb
	// property areaAttachedTo
	// RVA: 0x1680bb4
	bool get_isAttacheable() { }
	// RVA: 0x1680bbc
	void set_isAttacheable(bool value) { }
	// RVA: 0x1680bc8
	bool get_isGrabbed() { }
	// RVA: 0x1680bd0
	void set_isGrabbed(bool value) { }
	// RVA: 0x1680bdc
	bool get_isUnfresh() { }
	// RVA: 0x1680be4
	void set_isUnfresh(bool value) { }
	// RVA: 0x1680bf0
	UnityEngine.Rigidbody get_rb() { }
	// RVA: 0x1680bf8
	void set_rb(UnityEngine.Rigidbody value) { }
	// RVA: 0x1680c00
	InteractableArea get_areaAttachedTo() { }
	// RVA: 0x1680c08
	void set_areaAttachedTo(InteractableArea value) { }
	// RVA: 0x1680c10
	void Interact() { }
	// RVA: 0x1680d24
	void RightInteract() { }
	// RVA: 0x1680d28
	void Initialize() { }
	// RVA: 0x1679654
	void Awake() { }
	// RVA: 0x168102c
	void Start() { }
	// RVA: 0x1681154
	ItemId Explode() { }
	// RVA: 0x1679994
	void OnDestroy() { }
	// RVA: 0x1679c6c
	void Update() { }
	// RVA: 0x1680cc4
	void AttachToHand(bool attach) { }
	// RVA: 0x167919c
	void Grab() { }
	// RVA: 0x1681cd0
	void Release() { }
	// RVA: 0x1681840
	void RegenerateRigidbody() { }
	// RVA: 0x168190c
	void MakeKinematic(bool on) { }
	// RVA: 0x1681bd8
	void SetPhysicsAsGrabbed(bool _grabbed) { }
	// RVA: 0x1681c60
	void InitialNonColliding() { }
	// RVA: 0x1681de8
	void RecoverCollision() { }
	// RVA: 0x1681714
	void TryToAttachToCurrentAreas() { }
	// RVA: 0x168150c
	void CheckToInstaLerpToHandPosition() { }
	// RVA: 0x16812dc
	void LerpToHandIdleRotation() { }
	// RVA: 0x1681e44
	void LerpToPoint(UnityEngine.Transform dest, float transitionTime, System.Action<GrabableItem> callbackOnComplete, UnityEngine.Vector3 newLocalScale) { }
	// RVA: 0x1682364
	UnityEngine.Quaternion GetClosestStandingRot() { }
	// RVA: 0x16819c8
	UnityEngine.Quaternion GetOffsetRotationOnGrab() { }
	// RVA: 0x16823c4
	void OnCustomerSpawnDespawn(bool spawns) { }
	// RVA: 0x16823d0
	void SetUnfresh() { }
	// RVA: 0x1675d90
	void SetDirty() { }
	// RVA: 0x16824d8
	void SetAsManagedBYUpgradedDetector(bool _enable) { }
	// RVA: 0x167a61c
	void OnTriggerEnter(UnityEngine.Collider _areaEntered) { }
	// RVA: 0x16824e4
	void OnTriggerEnterUpgraded(UnityEngine.Collider _areaEntered) { }
	// RVA: 0x167a6c4
	void OnTriggerExit(UnityEngine.Collider _areaExited) { }
	// RVA: 0x1682650
	void OnTriggerExitUpgraded(UnityEngine.Collider _areaExited) { }
	// RVA: 0x168279c
	void AttachToArea(InteractableArea _newArea) { }
	// RVA: 0x168281c
	void DetachFromCurrentArea() { }
	// RVA: 0x1682900
	void RestockDestruction(bool isRestockStarting) { }
	// RVA: 0x1680e30
	void SuscribeToRestock(bool _suscribe) { }
	// RVA: 0x1682930
	bool IsJustSpawned() { }
	// RVA: 0x1682964
	void SetLayersAsGrabbed() { }
	// RVA: 0x1682c38
	void SetLayersAsNormal() { }
	// RVA: 0x167aac0
	void .ctor() { }
	// RVA: 0x1682dd0
	void .cctor() { }
}

// TypeDefIndex: 5572
class SpringJointSettings
{
	// RVA: 0x1681af4
	void ApplySettings(UnityEngine.SpringJoint springJoint) { }
}

// TypeDefIndex: 5573
class GrabbableItemsRestocker
{
	GrabbableItemsRestocker instance;
	GrabableItem[] kitchenItemsToRestock;
	System.Collections.Generic.List<SavedItemToRestore> kitchenItemSpawnersData;
	System.Collections.Generic.HashSet<GrabableItem> kitchenItemsOnScene;
	GrabableItem[] warehouseItemsToRestock;
	System.Collections.Generic.List<SavedItemToRestore> warehouseItemSpawnersData;
	System.Collections.Generic.List<GrabableItem> <itemsSpawnedInWarehouse>k__BackingField;
	// property itemsSpawnedInWarehouse
	// RVA: 0x1682e88
	System.Collections.Generic.List<GrabableItem> get_itemsSpawnedInWarehouse() { }
	// RVA: 0x1682e90
	void set_itemsSpawnedInWarehouse(System.Collections.Generic.List<GrabableItem> value) { }
	// RVA: 0x1682e98
	void Awake() { }
	// RVA: 0x16834c8
	void OnDestroy() { }
	// RVA: 0x1682ff4
	void SaveItemSpawners() { }
	// RVA: 0x168367c
	void SpawnItemById(ItemId itemToSpawn) { }
	// RVA: 0x1683938
	GrabableItem SpawnItem(SavedItemToRestore itemToSpawn) { }
	// RVA: 0x1683a68
	void SpawnAllItems(bool isRestockStarting) { }
	// RVA: 0x16840e0
	void RestockAllItemsImmediately() { }
	// RVA: 0x1684138
	void RestockKitchenItemBoxesImmediately() { }
	// RVA: 0x1683a88
	void SpawnAllKitchenItems() { }
	// RVA: 0x1683db4
	void SpawnAllWarehouseItems() { }
	// RVA: 0x168422c
	void DestroyWarehouseItem(GrabableItem itemToDestroy) { }
	// RVA: 0x1684294
	void .ctor() { }
}

// TypeDefIndex: 5574
class SavedItemToRestore
{
	ItemId itemId;
	GrabableItem prefab;
	UnityEngine.Vector3 position;
	UnityEngine.Quaternion rotation;
	UnityEngine.Transform parent;
	// RVA: 0x16835ec
	void .ctor(ItemId _itemId, GrabableItem _prefab, UnityEngine.Transform _tr) { }
}

// TypeDefIndex: 5575
class RoomSpace
{
	int value__;
	RoomSpace Undefined;
	RoomSpace Kitchen;
	RoomSpace Warehouse;
	RoomSpace Street;
	RoomSpace Backyard;
}

// TypeDefIndex: 5576
class Grill
{
	ItemId itemOnGrill;
	float cookingTime;
	System.Collections.Generic.Dictionary<ItemId, float> timeToNextState;
	System.Collections.Generic.List<ItemId> benefitStatesWithExtractor;
	float timeToChangeToNextState;
	float timeOnFire;
	float timeToExtinguish;
	float timeToBurnWithExtractor;
	bool <isOnFire>k__BackingField;
	bool isCooking;
	bool isTurboOn;
	GrillArea grillArea;
	UnityEngine.GameObject fireParticlesGo;
	UnityEngine.ParticleSystem[] fireParticles;
	UnityEngine.ParticleSystem cookingParticles;
	UnityEngine.GameObject cookingChangeParticles;
	AudioPlayer grillAudioPlayer;
	SmashReceiver smashReceiver;
	// property isOnFire
	// RVA: 0x16843e8
	bool get_isOnFire() { }
	// RVA: 0x16843f0
	void set_isOnFire(bool value) { }
	// RVA: 0x16843fc
	void UpdateGrillData(ItemId newItemId) { }
	// RVA: 0x168453c
	void Awake() { }
	// RVA: 0x1684954
	void Start() { }
	// RVA: 0x1684a78
	void OnDestroy() { }
	// RVA: 0x1684bb0
	void Update() { }
	// RVA: 0x1684cc4
	void CountFireTime() { }
	// RVA: 0x1684c1c
	void CountCookingTime() { }
	// RVA: 0x1684534
	void ResetCookingTime() { }
	// RVA: 0x1684674
	void SetOnCooking(bool on, bool force) { }
	// RVA: 0x1684d10
	void TransformToNextState() { }
	// RVA: 0x168506c
	void PlayCookingChangeParticles() { }
	// RVA: 0x1684934
	void AutodisableCookingChangeParticles() { }
	// RVA: 0x1684730
	void SetOnFire(bool on) { }
	// RVA: 0x16850f0
	void RestoreGrill(bool isRestockStart) { }
	// RVA: 0x1685124
	void SetTurbo(bool _on) { }
	// RVA: 0x1685130
	void .ctor() { }
}

// TypeDefIndex: 5577
class GrillArea
{
	Grill grill;
	StoragedItem[] itemVariety;
	UnityEngine.BoxCollider <boxCollider>k__BackingField;
	DG.Tweening.Tween punchChangeFoodTween;
	bool <hasUnfreshItem>k__BackingField;
	bool <hasDirtyItem>k__BackingField;
	AudioPlayer audioPlayer;
	bool <isGrillOn>k__BackingField;
	// property boxCollider
	// property hasUnfreshItem
	// property hasDirtyItem
	// property isGrillOn
	// RVA: 0x168548c
	UnityEngine.BoxCollider get_boxCollider() { }
	// RVA: 0x1685494
	void set_boxCollider(UnityEngine.BoxCollider value) { }
	// RVA: 0x168549c
	bool get_hasUnfreshItem() { }
	// RVA: 0x16854a4
	void set_hasUnfreshItem(bool value) { }
	// RVA: 0x16854b0
	bool get_hasDirtyItem() { }
	// RVA: 0x16854b8
	void set_hasDirtyItem(bool value) { }
	// RVA: 0x16854c4
	bool get_isGrillOn() { }
	// RVA: 0x16854cc
	void set_isGrillOn(bool value) { }
	// RVA: 0x16854d8
	void Awake() { }
	// RVA: 0x1685670
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x1685740
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x1685788
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x1684e90
	void ChangeGrillContent(GrabableItem receivedItem, ItemId receivedItemId) { }
	// RVA: 0x168578c
	bool IsPanEmpty() { }
	// RVA: 0x1685810
	void PunchEnabledItems() { }
	// RVA: 0x1685930
	void TurnOnGrill(bool _on) { }
	// RVA: 0x168593c
	void .ctor() { }
}

// TypeDefIndex: 5578
class GrillButton
{
	GrillArea[] grillArea;
	bool <isTurnedOn>k__BackingField;
	AudioPlayer audioPlayer;
	// property isTurnedOn
	// RVA: 0x168594c
	bool get_isTurnedOn() { }
	// RVA: 0x1685954
	void set_isTurnedOn(bool value) { }
	// RVA: 0x1685960
	void Awake() { }
	// RVA: 0x1685c20
	void OnDestroy() { }
	// RVA: 0x1685d50
	void Interact() { }
	// RVA: 0x1685adc
	void TurnOn(bool on) { }
	// RVA: 0x1685dfc
	void RightInteract() { }
	// RVA: 0x1685e08
	void Restore(bool isRestockStarting) { }
	// RVA: 0x1685e20
	void .ctor() { }
}

// TypeDefIndex: 5579
class GrillHotTop.<>c__DisplayClass8_0
{
	GrillHotTop <>4__this;
	bool _on;
	// RVA: 0x16860c4
	void .ctor() { }
	// RVA: 0x16860fc
	void <TurnOn>b__0() { }
}

// TypeDefIndex: 5580
class GrillHotTop
{
	bool initialized;
	UnityEngine.MeshRenderer meshRenderer;
	UnityEngine.Material mat;
	float fadeDuration;
	DG.Tweening.Tween fadeTween;
	bool isOn;
	// RVA: 0x1685e28
	void Start() { }
	// RVA: 0x1685fe0
	void Initialize() { }
	// RVA: 0x1685e34
	void TurnOn(bool _on, bool _instant) { }
	// RVA: 0x16860cc
	void OnDestroy() { }
	// RVA: 0x16860e4
	void .ctor() { }
}

// TypeDefIndex: 5581
class GrillTurboButton
{
	Grill[] grills;
	GrillHotTop grillHotTop;
	GrillButton grillButton;
	int clickInteraction;
	bool isPressed;
	DG.Tweening.Tween pressTween;
	AudioPlayer audioPlayer;
	// RVA: 0x1686128
	void Awake() { }
	// RVA: 0x1686298
	void OnDestroy() { }
	// RVA: 0x16863dc
	void Interact() { }
	// RVA: 0x1686580
	void RightInteract() { }
	// RVA: 0x1686634
	void Update() { }
	// RVA: 0x168668c
	void HoverItem(bool on) { }
	// RVA: 0x1686490
	void SetPressed(bool _on) { }
	// RVA: 0x16866d4
	void PlayButtonPressAnim(bool _press) { }
	// RVA: 0x168680c
	void Restore(bool isRestockStarting) { }
	// RVA: 0x16868f8
	void .ctor() { }
}

// TypeDefIndex: 5582
class HandManager
{
	HandManager instance;
	UnityEngine.Camera playerCam;
	UnityEngine.Transform playerCamTr;
	UnityEngine.LayerMask layerMask;
	string interactableItemTag;
	UnityEngine.Color transparentReticleColor;
	UnityEngine.UI.Image reticle;
	float interactableDist;
	UnityEngine.GameObject objectOnHover;
	InteractableItem itemOnHover;
	System.Action<bool> callbackOnGrabSomethingChange;
	GrabableItem <itemOnGrab>k__BackingField;
	float maxThrowForce;
	AudioPlayer audioPlayer;
	// property itemOnGrab
	// property ItemOnHover
	// RVA: 0x1686900
	GrabableItem get_itemOnGrab() { }
	// RVA: 0x1686908
	void set_itemOnGrab(GrabableItem value) { }
	// RVA: 0x1686910
	InteractableItem get_ItemOnHover() { }
	// RVA: 0x1686918
	void Awake() { }
	// RVA: 0x1686970
	void Start() { }
	// RVA: 0x16869fc
	void Update() { }
	// RVA: 0x1686ed4
	void FixedUpdate() { }
	// RVA: 0x168700c
	void DetectFrontal() { }
	// RVA: 0x16872a0
	void HoverObject(UnityEngine.GameObject newHover) { }
	// RVA: 0x1686b78
	void ClickHoveredItem() { }
	// RVA: 0x1686c00
	void RightClickHoveredItem() { }
	// RVA: 0x168115c
	void SetItemAsGrabbed(GrabableItem _item, bool _isGrabbed) { }
	// RVA: 0x1687240
	bool IsGrabbingSomething() { }
	// RVA: 0x1686c88
	void InstantThrowItem() { }
	// RVA: 0x1687474
	void .ctor() { }
}

// TypeDefIndex: 5583
class HeadHitDetector.<RemoveCooldown>d__4
{
	int <>1__state;
	object <>2__current;
	HeadHitDetector <>4__this;
	UnityEngine.Collider col;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1687748
	void .ctor(int <>1__state) { }
	// RVA: 0x168784c
	void System.IDisposable.Dispose() { }
	// RVA: 0x1687850
	bool MoveNext() { }
	// RVA: 0x168791c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1687924
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x168795c
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5584
class HeadHitDetector
{
	CustomerController customerController;
	System.Collections.Generic.HashSet<UnityEngine.Collider> cooldownColliders;
	System.Collections.Generic.List<ItemId> ignorableItems;
	// RVA: 0x1687494
	void OnTriggerEnter(UnityEngine.Collider col) { }
	// RVA: 0x16876c0
	System.Collections.IEnumerator RemoveCooldown(UnityEngine.Collider col) { }
	// RVA: 0x1687770
	void .ctor() { }
}

// TypeDefIndex: 5585
class Headphones
{
	UnityEngine.GameObject sparkParticles;
	CustomerController owner;
	UnityEngine.AudioSource aS;
	AudioPlayer sfxAudioPlayer;
	AutoLoopPunch anim;
	bool <isPlaying>k__BackingField;
	// property isPlaying
	// RVA: 0x1687964
	bool get_isPlaying() { }
	// RVA: 0x168796c
	void set_isPlaying(bool value) { }
	// RVA: 0x1687978
	void Start() { }
	// RVA: 0x1687b78
	void RestockDestruction(bool isRestockStarting) { }
	// RVA: 0x1687c1c
	void OnDestroy() { }
	// RVA: 0x1687ce8
	void RightInteract() { }
	// RVA: 0x1687cec
	void PlayPauseMusic() { }
	// RVA: 0x1687e80
	void Grab() { }
	// RVA: 0x1687f2c
	ItemId Explode() { }
	// RVA: 0x1687f4c
	void ConvertToBrokenHeadphones() { }
	// RVA: 0x16883ec
	void .ctor() { }
}

// TypeDefIndex: 5586
class HoldingPoint
{
	HoldingPoint instance;
	UnityEngine.Rigidbody <rb>k__BackingField;
	UnityEngine.Vector3 defaultPos;
	UnityEngine.Vector3 lastOffset;
	UnityEngine.Vector3 laybackPos;
	// property rb
	// RVA: 0x1688448
	UnityEngine.Rigidbody get_rb() { }
	// RVA: 0x1688450
	void set_rb(UnityEngine.Rigidbody value) { }
	// RVA: 0x1688458
	void Awake() { }
	// RVA: 0x168852c
	void ApplyHandPositionOffset(UnityEngine.Vector3 _offset) { }
	// RVA: 0x1688588
	void LayBackToThrow(float _percentage) { }
	// RVA: 0x1688658
	void .ctor() { }
}

// TypeDefIndex: 5587
class InitializeProject
{
	InitializeProject instance;
	EncryptionKeys keys;
	bool vSync;
	int frameRate;
	// property Keys
	// RVA: 0x16886d0
	EncryptionKeys get_Keys() { }
	// RVA: 0x16886d8
	void Awake() { }
	// RVA: 0x168895c
	void EncryptAll() { }
	// RVA: 0x1688814
	void SetVSync(bool on) { }
	// RVA: 0x16888a8
	void SetFrameRate(int newFrameRate) { }
	// RVA: 0x16887ac
	void DecryptAll() { }
	// RVA: 0x1688bb4
	void CheckDecompilations() { }
	// RVA: 0x1688c60
	void CloseGame() { }
	// RVA: 0x1688db8
	void .ctor() { }
	// RVA: 0x1688dc0
	void .cctor() { }
}

// TypeDefIndex: 5588
class InteractableArea
{
	MaterialTinter matTinter;
	System.Collections.Generic.List<ItemId> admitedItems;
	DG.Tweening.Tween punchTween;
	// RVA: 0x1688e10
	void Awake() { }
	// RVA: 0x1688f2c
	void OnDestroy() { }
	// no-body
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// no-body
	bool ReceiveItem(GrabableItem receivedItem) { }
	// no-body
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x1689048
	void WithdrawItem(GrabableItem withdrawedItem) { }
	// RVA: 0x168904c
	void RestoreArea(bool isRestockStarting) { }
	// RVA: 0x1689050
	bool IsAdmitedItem(GrabableItem receivedItem) { }
	// RVA: 0x1689120
	bool CanBeAttachedToAnything(GrabableItem receivedItem) { }
	// RVA: 0x16891a0
	void PunchAnim(UnityEngine.Transform punchedTransform) { }
	// RVA: 0x168929c
	void .ctor() { }
}

// TypeDefIndex: 5589
class InteractableItem
{
	OutlineManager <outlineManager>k__BackingField;
	bool initialized;
	DG.Tweening.Tween punchTween;
	bool destroyed;
	UnityEngine.MeshFilter mFilter;
	UnityEngine.Collider mainCol;
	// property outlineManager
	// property Interact_Left
	// property Interact_Right
	// RVA: 0x1689324
	OutlineManager get_outlineManager() { }
	// RVA: 0x168932c
	void set_outlineManager(OutlineManager value) { }
	// RVA: 0x1689334
	bool get_Interact_Left() { }
	// RVA: 0x168933c
	bool get_Interact_Right() { }
	// no-body
	void Interact() { }
	// no-body
	void RightInteract() { }
	// RVA: 0x1689344
	void OnDestroy() { }
	// RVA: 0x1689348
	void Awake() { }
	// RVA: 0x1689354
	void Initialize() { }
	// RVA: 0x16894cc
	void HoverItem(bool on) { }
	// RVA: 0x16894e4
	void DestroyItem() { }
	// RVA: 0x168956c
	void PunchAnim(InteractableItem i) { }
	// RVA: 0x1689570
	void PunchAnim() { }
	// RVA: 0x168965c
	void UpdateMesh(UnityEngine.Mesh _newMesh) { }
	// RVA: 0x168977c
	void EnableCollider(bool e) { }
	// RVA: 0x168979c
	void .ctor() { }
}

// TypeDefIndex: 5590
class ItemId
{
	int value__;
	ItemId None;
	ItemId Any;
	ItemId FullBun;
	ItemId TopBun;
	ItemId BotBun;
	ItemId RawMeat;
	ItemId LightMeat;
	ItemId MidMeat;
	ItemId DarkMeat;
	ItemId BurntMeat;
	ItemId RawVegan;
	ItemId MidVegan;
	ItemId FryingPan;
	ItemId FullOnion;
	ItemId SlicedOnion;
	ItemId FullTomato;
	ItemId SlicedTomato;
	ItemId FullLettuce;
	ItemId SlicedLettuce;
	ItemId SlicedCheese;
	ItemId Dish;
	ItemId Bell;
	ItemId Radio;
	ItemId Monitor;
	ItemId Pot;
	ItemId CuttingBoard;
	ItemId Tray;
	ItemId SodaBottle;
	ItemId StaleCheese;
	ItemId MenuTablet;
	ItemId SmallCrate;
	ItemId ShoppingTablet;
	ItemId CaramelizedOnion;
	ItemId BurntOnion;
	ItemId Toothpick;
	ItemId ToothpickJar;
	ItemId Smasher;
	ItemId SmashedMeat;
	ItemId BurntSmashed;
	ItemId SmashedTomato;
	ItemId CleanPaperSheet;
	ItemId DirtyPaperSheet;
	ItemId WaitStand;
	ItemId KetchupSauce;
	ItemId MustardSauce;
	ItemId MayoSauce;
	ItemId MayochupSauce;
	ItemId MostchupSauce;
	ItemId MostanezaSauce;
	ItemId BurginezaSauce;
	ItemId BbqSauce;
	ItemId HoneySauce;
	ItemId HerbsSauce;
	ItemId PineSauce;
	ItemId Headphones;
	ItemId HeadphonesBroken;
	ItemId CardboxBun;
	ItemId CardboxMeat;
	ItemId CardboxVegan;
	ItemId CardboxOnion;
	ItemId CardboxTomato;
	ItemId CardboxLettuce;
	ItemId CardboxTray;
	ItemId CardboxCup;
	ItemId FullBunHalloween;
	ItemId TopBunHalloween;
	ItemId BotBunHalloween;
	ItemId CardboxBunHalloween;
	ItemId CupEmpty;
	ItemId CupMixed;
	ItemId CupCola;
	ItemId CupLemon;
	ItemId CupOrange;
	ItemId CardAlbum;
	ItemId CardBoosterMale;
	ItemId CardBoosterFemale;
	ItemId Card;
	ItemId CardEnvelope;
}

// TypeDefIndex: 5591
class InteractablePage
{
	string website;
	// RVA: 0x16897a4
	void Interact() { }
	// RVA: 0x16898a4
	void RightInteract() { }
	// RVA: 0x16898b0
	void .ctor() { }
}

// TypeDefIndex: 5592
class ItemBox
{
	UnityEngine.Transform spawnpoint;
	bool unlimitedItems;
	StoragedItem[] stock;
	AudioPlayer audioPlayer;
	// RVA: 0x16898b8
	void Awake() { }
	// RVA: 0x1689a30
	void InteractFromStoragedItem() { }
	// RVA: 0x1689acc
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x1689f78
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x1689ee8
	void PlaySound(ItemId itemId, bool _putIn) { }
	// RVA: 0x168a084
	void HoverGroup(bool on) { }
	// RVA: 0x168a110
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x168a194
	bool CanBeRefilledManually() { }
	// RVA: 0x168a19c
	bool HasRefilleableFreeSlot() { }
	// RVA: 0x1689d10
	void Refill(int unitsToAdd, GrabableItem receivedItem) { }
	// RVA: 0x168a220
	UnityEngine.Transform GetFirstFreeSlotTransform() { }
	// RVA: 0x1689ba0
	void RefillAsUnlimited(GrabableItem receivedItem) { }
	// RVA: 0x168a2c4
	void OnUnlimitedItemAbsorbed(GrabableItem receivedItem) { }
	// RVA: 0x168a378
	void RestoreArea(bool isRestockStarting) { }
	// RVA: 0x168a438
	void RefillAnimatedUnit(UnityEngine.Transform origin) { }
	// RVA: 0x168a534
	void .ctor() { }
}

// TypeDefIndex: 5593
class ItemBoxInsideFridge
{
	FridgeDoor fridgeDoor;
	UnityEngine.BoxCollider bC;
	// RVA: 0x168a538
	void Awake() { }
	// RVA: 0x168a598
	void Start() { }
	// RVA: 0x168a67c
	void OnDestroy() { }
	// RVA: 0x168a768
	void OnDoorChange(bool _isOpen) { }
	// RVA: 0x168a788
	bool CanBeRefilledManually() { }
	// RVA: 0x168a7a4
	void .ctor() { }
}

// TypeDefIndex: 5594
class ItemExploder
{
	float lastTimeExploded;
	float cdMaxTime;
	Splat splatPrefab;
	SplashParticles splashPrefab;
	bool canExplodeInCustomersHead;
	// RVA: 0x168a7a8
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x168abf8
	void SplatStain(ItemId _sauceId, float _spawnPosY, bool _isInsideKitchen) { }
	// RVA: 0x168aa34
	void SplashDrops(ItemId _sauceId, float _spawnPosY) { }
	// RVA: 0x168adc4
	void .ctor() { }
}

// TypeDefIndex: 5595
class ItemSpawner
{
	ItemId itemId;
	GrabableItem itemPrefab;
	// RVA: 0x168addc
	void Start() { }
	// RVA: 0x168ae48
	void Refill(int unitsToRefill) { }
	// RVA: 0x168ae4c
	void .ctor() { }
}

// TypeDefIndex: 5596
class LanguageManager
{
	LanguageManager instance;
	UnityEngine.TextAsset[] languageSheetsCSV;
	System.Collections.Generic.SortedDictionary<string, Translation> langDict;
	System.Collections.Generic.Dictionary<string, string> formatingDict;
	string <lineStartingCharacter>k__BackingField;
	string <fieldDelimiter>k__BackingField;
	string <stringDelimiter>k__BackingField;
	Languages currentLanguage;
	string lastSavedLanguage;
	System.Action callbackOnLanguageChange;
	// property lineStartingCharacter
	// property fieldDelimiter
	// property stringDelimiter
	// RVA: 0x168ae54
	string get_lineStartingCharacter() { }
	// RVA: 0x168ae5c
	void set_lineStartingCharacter(string value) { }
	// RVA: 0x168ae64
	string get_fieldDelimiter() { }
	// RVA: 0x168ae6c
	void set_fieldDelimiter(string value) { }
	// RVA: 0x168ae74
	string get_stringDelimiter() { }
	// RVA: 0x168ae7c
	void set_stringDelimiter(string value) { }
	// RVA: 0x168ae84
	void Awake() { }
	// RVA: 0x168af5c
	void LoadCurrentLanguage() { }
	// RVA: 0x168b844
	void SetNewLanguage(string newLang) { }
	// RVA: 0x168b4c0
	System.Collections.Generic.SortedDictionary<string, Translation> ParseLanguageSheet() { }
	// RVA: 0x168bb10
	string GetText(string key, bool notifyErrors) { }
	// RVA: 0x168bf90
	string FormatSecondsIntoString(int rawSeconds) { }
	// RVA: 0x168c120
	string FormatMinutesIntoString(int minutes) { }
	// RVA: 0x168c2bc
	string FormatString(string originalText) { }
	// RVA: 0x168c440
	void .ctor() { }
}

// TypeDefIndex: 5597
class Languages
{
	int value__;
	Languages English;
	Languages Spanish;
	Languages Portuguese;
	Languages Italian;
	Languages French;
	Languages German;
	Languages Polish;
	Languages Russian;
	Languages Turkish;
	Languages Ukrainian;
	Languages Chinese;
	Languages Japanese;
	Languages Korean;
}

// TypeDefIndex: 5598
class Translation
{
	string key;
	string english;
	string spanish;
	string portuguese;
	string italian;
	string french;
	string german;
	string polish;
	string russian;
	string turkish;
	string ukrainian;
	string chinese;
	string japanese;
	string korean;
	// RVA: 0x168b8e4
	void .ctor(string _key, string en, string es, string pt, string it, string fr, string de, string pl, string ru, string tr, string uk, string zh, string ja, string ko) { }
	// RVA: 0x168d26c
	void TryAddToCommands() { }
	// RVA: 0x168be84
	string GetTranslation(Languages lang) { }
	// RVA: 0x168d07c
	void FormatAllStrings() { }
	// RVA: 0x168d738
	string FormatString(string originalText, string stringDelimiter) { }
}

// TypeDefIndex: 5599
class LangVerifier
{
	UnityEngine.TextAsset[] languageSheetsCSV;
	TMPro.TMP_FontAsset[] fontAssets;
	string lineStartingCharacter;
	string fieldDelimiter;
	string stringDelimiter;
	System.Collections.Generic.Dictionary<string, System.Collections.Generic.Dictionary<string, string>> languageDictionary;
	// RVA: 0x168dac0
	void LoadLanguageData() { }
	// RVA: 0x168dfb0
	void VerifyLanguages() { }
	// RVA: 0x168e588
	void VerifyFonts() { }
	// RVA: 0x168ecf4
	void VerifyTags() { }
	// RVA: 0x168f970
	void VerifyLines() { }
	// RVA: 0x168ec0c
	bool IsCharacterInAnyFont(char c) { }
	// RVA: 0x1690004
	bool FontHasCharacterRecursive(TMPro.TMP_FontAsset font, char c) { }
	// RVA: 0x168f5f8
	System.Collections.Generic.HashSet<string> ExtractTags(string text, string pattern) { }
	// RVA: 0x168ff8c
	int CountOccurrences(string text, string substring) { }
	// RVA: 0x169020c
	void .ctor() { }
}

// TypeDefIndex: 5600
class LightSwitch
{
	LightSwitch instance;
	UnityEngine.GameObject insideLight;
	bool isTurnedOn;
	UnityEngine.Transform switcher;
	AudioPlayer audioPlayer;
	System.Action<bool> callbackOnLightSwitch;
	// RVA: 0x1690308
	void Awake() { }
	// RVA: 0x1690578
	void OnDestroy() { }
	// RVA: 0x169069c
	void RightInteract() { }
	// RVA: 0x16906a8
	void Interact() { }
	// RVA: 0x1690754
	void PressTurnOn(bool on) { }
	// RVA: 0x16904e4
	void ApplyTurnOn(bool on) { }
	// RVA: 0x169079c
	void TurnOnByTrashCover() { }
	// RVA: 0x16907b0
	void Restore(bool isRestockStarting) { }
	// RVA: 0x16907c8
	void .ctor() { }
}

// TypeDefIndex: 5601
class IntroCanvasInGame
{
	UnityEngine.RectTransform gameLogo;
	UnityEngine.UI.Image heynauLogo;
	UnityEngine.UI.Image bg;
	// RVA: 0x16907d8
	void Awake() { }
	// RVA: 0x169083c
	void Vanish() { }
	// RVA: 0x1690a4c
	void .ctor() { }
	// RVA: 0x1690a54
	void <Vanish>b__4_0() { }
}

// TypeDefIndex: 5602
class IntroSong
{
	float minSongTime;
	float currentVolume;
	UnityEngine.AudioSource audioSource;
	// RVA: 0x1690af4
	void Awake() { }
	// RVA: 0x1690be4
	void FadeSongOut() { }
	// RVA: 0x1690c98
	bool IsSongReady() { }
	// RVA: 0x1690d48
	void .ctor() { }
	// RVA: 0x1690d5c
	void <FadeSongOut>b__4_0() { }
}

// TypeDefIndex: 5603
class LoadingAgeNotice.<OpenAfterClick>d__23
{
	int <>1__state;
	object <>2__current;
	LoadingAgeNotice <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1692344
	void .ctor(int <>1__state) { }
	// RVA: 0x1692590
	void System.IDisposable.Dispose() { }
	// RVA: 0x1692594
	bool MoveNext() { }
	// RVA: 0x1692828
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1692830
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x1692868
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5604
class LoadingAgeNotice
{
	float TransitionTime;
	float ShadeOpacity;
	UnityEngine.Canvas targetCanvas;
	UnityEngine.Sprite ratingIcon;
	UnityEngine.TextAsset noticeText;
	UnityEngine.Sprite popupSprite;
	UnityEngine.Sprite closeIcon;
	TMPro.TMP_FontAsset chineseFont;
	UnityEngine.RectTransform popupBounds;
	UnityEngine.RectTransform popupPanel;
	UnityEngine.UI.Image shade;
	UnityEngine.GameObject popupRoot;
	UnityEngine.UI.Button ratingButton;
	DG.Tweening.Sequence popupTween;
	UnityEngine.Coroutine pendingOpen;
	bool available;
	bool isOpen;
	// RVA: 0x1690dc8
	void Awake() { }
	// RVA: 0x1691b1c
	void LateUpdate() { }
	// RVA: 0x1691c5c
	void OnDestroy() { }
	// RVA: 0x1691d48
	void SetAvailable(bool value) { }
	// RVA: 0x1690f64
	void BuildUi() { }
	// RVA: 0x16921a0
	void OnRatingClicked() { }
	// RVA: 0x16922d8
	System.Collections.IEnumerator OpenAfterClick() { }
	// RVA: 0x169236c
	void Close() { }
	// RVA: 0x1691e28
	void HideImmediately() { }
	// RVA: 0x1691f04
	UnityEngine.RectTransform CreateRect(string name, UnityEngine.Transform parent) { }
	// RVA: 0x169209c
	void Stretch(UnityEngine.RectTransform rect) { }
	// RVA: 0x1692580
	void .ctor() { }
}

// TypeDefIndex: 5605
class LoadingScene.<LoadSceneAsync>d__23
{
	int <>1__state;
	object <>2__current;
	LoadingScene <>4__this;
	string <sceneToUnload>5__2;
	UnityEngine.AsyncOperation <asyncOperation>5__3;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1693e2c
	void .ctor(int <>1__state) { }
	// RVA: 0x1693ecc
	void System.IDisposable.Dispose() { }
	// RVA: 0x1693ed0
	bool MoveNext() { }
	// RVA: 0x1694678
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x1694680
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16946b8
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5606
class LoadingScene
{
	string LoginButtonText;
	string StartGameButtonText;
	float PrimaryButtonCooldownSeconds;
	IntroSong introSong;
	UnityEngine.GameObject canvas;
	UnityEngine.UI.Button loginButton;
	TMPro.TMP_Text loginButtonLabel;
	UnityEngine.GameObject healthAdvice;
	TMPro.TMP_Text loadingLabel;
	UnityEngine.GameObject inputBlocker;
	LoadingAgeNotice ageNotice;
	bool loginUiLocked;
	bool loginUiReady;
	bool startGameRequested;
	float nextPrimaryButtonClickTime;
	// RVA: 0x1692870
	void Awake() { }
	// RVA: 0x16931d0
	void OnValidate() { }
	// RVA: 0x16931d4
	void Start() { }
	// RVA: 0x1693260
	void Update() { }
	// RVA: 0x1693270
	void OnDestroy() { }
	// RVA: 0x1693348
	void OnPrimaryButtonClicked() { }
	// RVA: 0x1692f7c
	void RefreshLoginUi() { }
	// RVA: 0x1692980
	bool ResolveLoginUiReferences() { }
	// RVA: 0x16931f4
	System.Collections.IEnumerator LoadSceneAsync() { }
	// RVA: 0x1693e54
	void DestroyEverything() { }
	// RVA: 0x1693ec4
	void .ctor() { }
}

// TypeDefIndex: 5607
class MarsSdkState
{
	int value__;
	MarsSdkState Initializing;
	MarsSdkState LoginRequired;
	MarsSdkState LoggingIn;
	MarsSdkState LoginFailed;
	MarsSdkState SyncingCloud;
	MarsSdkState Ready;
}

// TypeDefIndex: 5608
class MarsBannerPosition
{
	int value__;
	MarsBannerPosition Top;
	MarsBannerPosition Bottom;
}

// TypeDefIndex: 5609
class MarsRedeemRewardType
{
	int value__;
	MarsRedeemRewardType Unknown;
	MarsRedeemRewardType AdCoupon;
	MarsRedeemRewardType Coins;
	MarsRedeemRewardType AdFree;
}

// TypeDefIndex: 5610
class MarsRedeemReward
{
	MarsRedeemRewardType <Type>k__BackingField;
	int <Amount>k__BackingField;
	// property Type
	// property Amount
	// RVA: 0x16946c0
	MarsRedeemRewardType get_Type() { }
	// RVA: 0x16946c8
	int get_Amount() { }
	// RVA: 0x16946d0
	void .ctor(MarsRedeemRewardType type, int amount) { }
}

// TypeDefIndex: 5611
class MarsRedeemResult
{
	bool <Succeeded>k__BackingField;
	System.Collections.Generic.IReadOnlyList<MarsRedeemReward> <Rewards>k__BackingField;
	// property Succeeded
	// property Rewards
	// RVA: 0x16946d8
	bool get_Succeeded() { }
	// RVA: 0x16946e0
	System.Collections.Generic.IReadOnlyList<MarsRedeemReward> get_Rewards() { }
	// RVA: 0x16946e8
	void .ctor(bool succeeded, System.Collections.Generic.IReadOnlyList<MarsRedeemReward> rewards) { }
}

// TypeDefIndex: 5612
class MarsSdkService.<>c
{
	MarsSdkService+<>c <>9;
	System.Func<bool> <>9__31_0;
	System.Func<bool> <>9__33_0;
	// RVA: 0x169aef4
	void .cctor() { }
	// RVA: 0x169af5c
	void .ctor() { }
	// RVA: 0x169af64
	bool <get_IsRewardedReady>b__31_0() { }
	// RVA: 0x169afc4
	bool <get_IsInterstitialReady>b__33_0() { }
}

// TypeDefIndex: 5613
class MarsSdkService.<>c__DisplayClass101_0
{
	string response;
	bool received;
	// RVA: 0x169b024
	void .ctor() { }
	// RVA: 0x169b02c
	void <ProcessCloudQueue>b__0(string value) { }
}

// TypeDefIndex: 5614
class MarsSdkService.<>c__DisplayClass119_0
{
	MarsSdkService <>4__this;
	System.Action onReward;
	System.Action onFailed;
	// RVA: 0x169a34c
	void .ctor() { }
	// RVA: 0x169b05c
	void <TryShowRewarded>b__0() { }
	// RVA: 0x169b0b4
	void <TryShowRewarded>b__1() { }
	// RVA: 0x169b10c
	void <TryShowRewarded>b__2() { }
	// RVA: 0x169b15c
	void <TryShowRewarded>b__3() { }
	// RVA: 0x169b1b4
	void <TryShowRewarded>b__4() { }
	// RVA: 0x169b204
	void <TryShowRewarded>b__5() { }
}

// TypeDefIndex: 5615
class MarsSdkService.<>c__DisplayClass125_0
{
	MarsSdkService <>4__this;
	System.Action onClosed;
	System.Action onFailed;
	// RVA: 0x169aa34
	void .ctor() { }
	// RVA: 0x169b224
	void <TryShowInterstitial>b__0() { }
	// RVA: 0x169b264
	void <TryShowInterstitial>b__1() { }
}

// TypeDefIndex: 5616
class MarsSdkService.<FailRewardAfterClose>d__123
{
	int <>1__state;
	object <>2__current;
	MarsSdkService <>4__this;
	System.Action onFailed;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x169a77c
	void .ctor(int <>1__state) { }
	// RVA: 0x169b2a4
	void System.IDisposable.Dispose() { }
	// RVA: 0x169b2a8
	bool MoveNext() { }
	// RVA: 0x169b39c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x169b3a4
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x169b3dc
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5617
class MarsSdkService.<LoginTimeout>d__80
{
	int <>1__state;
	object <>2__current;
	MarsSdkService <>4__this;
	int attempt;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1697310
	void .ctor(int <>1__state) { }
	// RVA: 0x169b3e4
	void System.IDisposable.Dispose() { }
	// RVA: 0x169b3e8
	bool MoveNext() { }
	// RVA: 0x169b550
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x169b558
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x169b590
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5618
class MarsSdkService.<ProcessCloudQueue>d__101
{
	int <>1__state;
	object <>2__current;
	MarsSdkService <>4__this;
	MarsSdkService+<>c__DisplayClass101_0 <>8__1;
	CloudOperation <operation>5__2;
	MarSDK.MarSDKInterface <sdk>5__3;
	float <deadline>5__4;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x1698a94
	void .ctor(int <>1__state) { }
	// RVA: 0x169b598
	void System.IDisposable.Dispose() { }
	// RVA: 0x169b59c
	bool MoveNext() { }
	// RVA: 0x169ba24
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x169ba2c
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x169ba64
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5619
class MarsSdkService.<ReloadLoadingScene>d__114
{
	int <>1__state;
	object <>2__current;
	MarsSdkService <>4__this;
	bool alreadyAuthenticated;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16995e8
	void .ctor(int <>1__state) { }
	// RVA: 0x169ba6c
	void System.IDisposable.Dispose() { }
	// RVA: 0x169ba70
	bool MoveNext() { }
	// RVA: 0x169bc50
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x169bc58
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x169bc90
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5620
class MarsSdkService.<RestoreTimeScaleNextFrame>d__124
{
	int <>1__state;
	object <>2__current;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x169a7a4
	void .ctor(int <>1__state) { }
	// RVA: 0x169bc98
	void System.IDisposable.Dispose() { }
	// RVA: 0x169bc9c
	bool MoveNext() { }
	// RVA: 0x169bcf8
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x169bd00
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x169bd38
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5621
class MarsSdkService.<SimulateInterstitialCloseNextFrame>d__127
{
	int <>1__state;
	object <>2__current;
	MarsSdkService <>4__this;
	System.Action onClosed;
	System.Action onFailed;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x169ab14
	void .ctor(int <>1__state) { }
	// RVA: 0x169bd40
	void System.IDisposable.Dispose() { }
	// RVA: 0x169bd44
	bool MoveNext() { }
	// RVA: 0x169bdc4
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x169bdcc
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x169be04
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5622
class MarsSdkService.<UploadAfterDebounce>d__95
{
	int <>1__state;
	object <>2__current;
	MarsSdkService <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16988f8
	void .ctor(int <>1__state) { }
	// RVA: 0x169be0c
	void System.IDisposable.Dispose() { }
	// RVA: 0x169be10
	bool MoveNext() { }
	// RVA: 0x169bf20
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x169bf28
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x169bf60
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5623
class MarsSdkService
{
	string LoginLogPrefix;
	string CloudArchiveKey;
	float IosInitializationFallbackSeconds;
	float LoginTimeoutSeconds;
	float CloudTimeoutSeconds;
	float CloudUploadDebounceSeconds;
	MarsSdkService <Instance>k__BackingField;
	bool enableCloudArchive;
	bool enableSplashAd;
	MarsSdkState <State>k__BackingField;
	System.Action<MarsSdkState> StateChanged;
	System.Action<MarsRedeemResult> RedeemCompleted;
	System.Collections.Generic.Queue<CloudOperation> cloudOperations;
	UnityEngine.Coroutine loginTimeoutCoroutine;
	UnityEngine.Coroutine cloudQueueCoroutine;
	UnityEngine.Coroutine uploadDebounceCoroutine;
	bool loginInFlight;
	bool initializationComplete;
	bool initializationSuccessful;
	bool automaticLoginAttempted;
	bool loginCompletionHandled;
	bool splashRequested;
	bool applyingCloudArchive;
	bool rewardInProgress;
	bool rewardGranted;
	UnityEngine.Coroutine rewardCloseCoroutine;
	bool interstitialInProgress;
	bool redeemInProgress;
	bool switchingAccount;
	bool restartingAfterLogout;
	bool logoutFlowActive;
	int loginAttempt;
	int loginLogSequence;
	string lastLoginPayload;
	string iosAppId;
	// property Instance
	// property CloudArchiveEnabled
	// property SplashAdEnabled
	// property State
	// property IsReady
	// property IsLoggedIn
	// property IsInitializationComplete
	// property IsInitializationSuccessful
	// property CanManualLogin
	// property IsRewardedReady
	// property IsInterstitialReady
	// property ShouldShowRedeemCodeEntry
	// RVA: 0x1694720
	MarsSdkService get_Instance() { }
	// RVA: 0x1694768
	void set_Instance(MarsSdkService value) { }
	// RVA: 0x16947c0
	bool get_CloudArchiveEnabled() { }
	// RVA: 0x16947c8
	bool get_SplashAdEnabled() { }
	// RVA: 0x16947d0
	MarsSdkState get_State() { }
	// RVA: 0x16947d8
	void set_State(MarsSdkState value) { }
	// RVA: 0x16947e0
	bool get_IsReady() { }
	// RVA: 0x169399c
	bool get_IsLoggedIn() { }
	// RVA: 0x16947f0
	bool get_IsInitializationComplete() { }
	// RVA: 0x16947f8
	bool get_IsInitializationSuccessful() { }
	// RVA: 0x1693df8
	bool get_CanManualLogin() { }
	// RVA: 0x1694800
	bool get_IsRewardedReady() { }
	// RVA: 0x16949f4
	bool get_IsInterstitialReady() { }
	// RVA: 0x1694ae4
	bool get_ShouldShowRedeemCodeEntry() { }
	// RVA: 0x1694aec
	void add_StateChanged(System.Action<MarsSdkState> value) { }
	// RVA: 0x1694b9c
	void remove_StateChanged(System.Action<MarsSdkState> value) { }
	// RVA: 0x1694c4c
	void add_RedeemCompleted(System.Action<MarsRedeemResult> value) { }
	// RVA: 0x1694cfc
	void remove_RedeemCompleted(System.Action<MarsRedeemResult> value) { }
	// RVA: 0x1694dac
	void Awake() { }
	// RVA: 0x1695c3c
	void Update() { }
	// RVA: 0x1695dd0
	void OnDestroy() { }
	// RVA: 0x16956b0
	void ConfigureChannel() { }
	// RVA: 0x16957dc
	void BindSdkCallbacks() { }
	// RVA: 0x1695fb4
	bool TryRedeem(string code) { }
	// RVA: 0x1696350
	void OnRedeemResult(int propNumber, string propType, string msg, string listdata) { }
	// RVA: 0x1696190
	void CompleteRedeem(bool succeeded, System.Collections.Generic.List<MarsRedeemReward> rewards) { }
	// RVA: 0x1696468
	System.Collections.Generic.List<MarsRedeemReward> ParseRedeemRewards(int propNumber, string propType, string listdata) { }
	// RVA: 0x1696ae4
	void AddRedeemReward(System.Collections.Generic.List<MarsRedeemReward> rewards, int amount, string propType) { }
	// RVA: 0x1696c1c
	MarsRedeemRewardType GetRedeemRewardType(string propType) { }
	// RVA: 0x1696a44
	void GrantRedeemReward(MarsRedeemReward reward) { }
	// RVA: 0x1696cd8
	void OnSdkInitialized() { }
	// RVA: 0x1696f18
	void OnSdkInitializationFailed() { }
	// RVA: 0x1696e1c
	void BeginLogin() { }
	// RVA: 0x1697294
	System.Collections.IEnumerator LoginTimeout(int attempt) { }
	// RVA: 0x1697338
	void EnterManualLoginState(string reason) { }
	// RVA: 0x16939fc
	bool TryManualLogin() { }
	// RVA: 0x1696fe0
	bool RequestNativeLogin(string source) { }
	// RVA: 0x1697558
	void OnLoginSucceeded(string payload) { }
	// RVA: 0x1695cc4
	void CompleteSuccessfulLogin(string payload) { }
	// RVA: 0x1697d00
	void OnLoginFailed() { }
	// RVA: 0x1697420
	void FailLoginAttempt(int attempt, string reason) { }
	// RVA: 0x1697618
	void CompleteLoginAttempt() { }
	// RVA: 0x1695f20
	void CancelLoginWork() { }
	// RVA: 0x1697c24
	void BeginInitialCloudSync() { }
	// RVA: 0x1697eb4
	void ResolveInitialCloudArchive(bool completed, string response) { }
	// RVA: 0x169858c
	void NotifyLocalSaveChanged() { }
	// RVA: 0x16986cc
	void NotifySaveDeleted() { }
	// RVA: 0x169865c
	void ScheduleCloudUpload() { }
	// RVA: 0x169888c
	System.Collections.IEnumerator UploadAfterDebounce() { }
	// RVA: 0x16983ec
	void EnqueueLatestLocalArchive(System.Action<bool, string> completed) { }
	// RVA: 0x1698928
	void OnCloudWriteFinished(bool completed, string response) { }
	// RVA: 0x169879c
	void ClearCloudArchiveAfterLocalDelete() { }
	// RVA: 0x16989a8
	void OnCloudDeleteFinished(bool completed, string response) { }
	// RVA: 0x1697e14
	void EnqueueCloudOperation(CloudOperation operation) { }
	// RVA: 0x1698a28
	System.Collections.IEnumerator ProcessCloudQueue() { }
	// RVA: 0x1698abc
	void InvokeCloudCompletion(CloudOperation operation, bool completed, string response) { }
	// RVA: 0x1698b88
	string UnwrapArchiveResponse(string value) { }
	// RVA: 0x1698258
	bool TryParseCloudEnvelope(string json, CloudSaveEnvelope& envelope, System.DateTime& updatedUtc) { }
	// RVA: 0x1698dec
	void Logout() { }
	// RVA: 0x169904c
	void SwitchAccount() { }
	// RVA: 0x1699198
	void RequestNativeAccountSwitch() { }
	// RVA: 0x1688d58
	void Exit() { }
	// RVA: 0x16993cc
	void RequestChannelUpdate() { }
	// RVA: 0x1699470
	void OnLoggedOut() { }
	// RVA: 0x1699528
	void OnAccountSwitched(string payload) { }
	// RVA: 0x16976a0
	void CompleteAccountSwitch(string payload) { }
	// RVA: 0x1698f44
	void RestartAfterLogout() { }
	// RVA: 0x169934c
	System.Collections.IEnumerator ReloadLoadingScene(bool alreadyAuthenticated) { }
	// RVA: 0x1698ea0
	void SaveCurrentProgress() { }
	// RVA: 0x1697784
	void ReportSinglePlayerRole(string loginPayload) { }
	// RVA: 0x1699610
	string ExtractRoleId(string payload) { }
	// RVA: 0x169981c
	string FindFirstString(Newtonsoft.Json.Linq.JToken token, string[] keys) { }
	// RVA: 0x1699ee0
	bool TryShowRewarded(System.Action onReward, System.Action onFailed) { }
	// RVA: 0x169a354
	void CompleteReward(bool earned, System.Action onReward, System.Action onFailed, string callBackName) { }
	// RVA: 0x169a5d4
	void LogRewardCallback(string callBackName) { }
	// RVA: 0x169a660
	void ScheduleRewardClose(System.Action onFailed) { }
	// RVA: 0x169a6f4
	System.Collections.IEnumerator FailRewardAfterClose(System.Action onFailed) { }
	// RVA: 0x169a57c
	System.Collections.IEnumerator RestoreTimeScaleNextFrame() { }
	// RVA: 0x169a7cc
	bool TryShowInterstitial(System.Action onClosed, System.Action onFailed) { }
	// RVA: 0x169aa3c
	void CompleteInterstitial(bool closed, System.Action onClosed, System.Action onFailed) { }
	// RVA: 0x169aa78
	System.Collections.IEnumerator SimulateInterstitialCloseNextFrame(System.Action onClosed, System.Action onFailed) { }
	// RVA: 0x169ab3c
	void ShowBanner(MarsBannerPosition position) { }
	// RVA: 0x169ac00
	void HideBanner() { }
	// RVA: 0x169ac60
	bool OpenReview() { }
	// RVA: 0x16948f0
	bool SafeGetAdReady(System.Func<bool> query) { }
	// RVA: 0x1695b18
	void SetState(MarsSdkState newState) { }
	// RVA: 0x169517c
	void LogLoginFlow(string eventName, string details, bool warning) { }
	// RVA: 0x169ae68
	void .ctor() { }
	// RVA: 0x169aef0
	void <SwitchAccount>b__106_0(bool completed, string response) { }
}

// TypeDefIndex: 5624
class CloudSaveEnvelope
{
	int CurrentSchemaVersion;
	int schemaVersion;
	string updatedAtUtc;
	SteamCloudPrefs steamCloudPrefs;
	// RVA: 0x1698920
	void .ctor() { }
}

// TypeDefIndex: 5625
class CloudOperationKind
{
	int value__;
	CloudOperationKind Read;
	CloudOperationKind Write;
	CloudOperationKind Delete;
}

// TypeDefIndex: 5626
class CloudOperation
{
	CloudOperationKind <Kind>k__BackingField;
	string <Payload>k__BackingField;
	System.Action<bool, string> <Completed>k__BackingField;
	// property Kind
	// property Payload
	// property Completed
	// RVA: 0x169bf68
	CloudOperationKind get_Kind() { }
	// RVA: 0x169bf70
	string get_Payload() { }
	// RVA: 0x169bf78
	System.Action<bool, string> get_Completed() { }
	// RVA: 0x1697dc0
	void .ctor(CloudOperationKind kind, string payload, System.Action<bool, string> completed) { }
}

// TypeDefIndex: 5627
class MaterialTinter
{
	UnityEngine.MeshRenderer[] allMeshes;
	UnityEngine.Material[] allMats;
	UnityEngine.Color[] allOriginalColors;
	DG.Tweening.Sequence[] sequences;
	// RVA: 0x169bf80
	void Awake() { }
	// RVA: 0x169c1d0
	void TintRed() { }
	// RVA: 0x169c41c
	void .ctor() { }
}

// TypeDefIndex: 5628
class MenuCanvas
{
	MenuCanvas instance;
	MenuPanel currentPanel;
	MenuBanner currentBanner;
	DG.Tweening.Sequence redPulseSeq;
	UnityEngine.GameObject loadingPanel;
	UnityEngine.GameObject tutorialPanel;
	UnityEngine.GameObject practicePanel;
	UnityEngine.GameObject normalPanel;
	TextController normalTimer;
	UnityEngine.GameObject normalRequiresInternetPanel;
	UnityEngine.GameObject pomodoroPanel;
	UnityEngine.GameObject pomodoroOffPanel;
	UnityEngine.GameObject pomodoroPausedIcon;
	UnityEngine.UI.Image pomoBigWheelTimer;
	TextController pomoTimer;
	UnityEngine.GameObject cookingPanel;
	UnityEngine.GameObject starsBanner;
	UnityEngine.Transform goldStarsGroup;
	UnityEngine.Transform darkStarsGroup;
	UnityEngine.Transform[] goldStarsTr;
	UnityEngine.Transform[] darkStarsTr;
	UnityEngine.GameObject[] innerGoldStar;
	UnityEngine.GameObject[] innerDarkStar;
	UnityEngine.UI.Image starFill;
	UnityEngine.UI.Image pomoDisconnectedIcon;
	UnityEngine.Color disconnectedBaseColor;
	UnityEngine.Color errorDisconnectedColor;
	UnityEngine.GameObject pomodoroOffBanner;
	UnityEngine.GameObject closedBanner;
	// RVA: 0x169c480
	void Awake() { }
	// RVA: 0x169c4e0
	void InitializeStars() { }
	// RVA: 0x169c704
	void Start() { }
	// RVA: 0x169cfc8
	void UpdateOnInstantiate() { }
	// RVA: 0x169d888
	void OnDestroy() { }
	// RVA: 0x169e14c
	void AutochangeCanvases(Gamemode _gamemode) { }
	// RVA: 0x169e164
	void AutochangeCanvases(bool on) { }
	// RVA: 0x169cfb0
	void AutochangeCanvases() { }
	// RVA: 0x169e17c
	void AutochangePanelMode() { }
	// RVA: 0x169e344
	void ChangePanelMode(MenuPanel _newMenuPanel) { }
	// RVA: 0x169d064
	void AutochangeBannerMode() { }
	// RVA: 0x169e73c
	void ChangeBannerMode(MenuBanner _newBannerMode) { }
	// RVA: 0x169e7bc
	void ReceiveRedPulse(Gamemode _gamemode) { }
	// RVA: 0x169e968
	void OnNormalMinuteChange() { }
	// RVA: 0x169e5b0
	void UpdateTimerRemainingToNextCustomer(Gamemode _gamemode, float percentageElapsed) { }
	// RVA: 0x169d2b8
	void OnEnableStarsBanner() { }
	// RVA: 0x169d328
	void OnChangeRemainingTime(float currentTime, float totalTime) { }
	// RVA: 0x169d348
	void OnChangeStarValue(int currentStars) { }
	// RVA: 0x169ea14
	void .ctor() { }
}

// TypeDefIndex: 5629
class MenuPanel
{
	int value__;
	MenuPanel None;
	MenuPanel Loading;
	MenuPanel TutorialTimer;
	MenuPanel PracticeTimer;
	MenuPanel NormalTimer;
	MenuPanel NormalReqInternet;
	MenuPanel PomodoroTimer;
	MenuPanel PomodoroOff;
	MenuPanel PomodoroPaused;
	MenuPanel Cooking;
}

// TypeDefIndex: 5630
class MenuBanner
{
	int value__;
	MenuBanner Empty;
	MenuBanner PomodoroOff;
	MenuBanner ClosedFenceManual;
	MenuBanner StarsCooking;
}

// TypeDefIndex: 5631
class MenuMode
{
	int value__;
	MenuMode Loading;
	MenuMode TimeToPractice;
	MenuMode TimeToNormal;
	MenuMode TimeToPomodoro;
	MenuMode PomodoroOff;
	MenuMode StarsCooking;
	MenuMode CookingWindow;
}

// TypeDefIndex: 5632
class MenuClickable
{
	// RVA: 0x169ea34
	void Start() { }
	// RVA: 0x169eb44
	void OnDestroy() { }
	// RVA: 0x169eb40
	void OnWindowChange() { }
	// RVA: 0x169ec50
	void RightInteract() { }
	// RVA: 0x169ed18
	void .ctor() { }
}

// TypeDefIndex: 5633
class MenuIngredientDisplayer.<>c
{
	MenuIngredientDisplayer+<>c <>9;
	System.Func<ItemId, bool> <>9__23_0;
	// RVA: 0x16a06fc
	void .cctor() { }
	// RVA: 0x16a0764
	void .ctor() { }
	// RVA: 0x16a076c
	bool <UpdateDisplayingIngredients>b__23_0(ItemId t) { }
}

// TypeDefIndex: 5634
class MenuIngredientDisplayer
{
	MenuIngredientDisplayer instance;
	int tutorialBurgerCount;
	UnityEngine.GameObject ingredientsPanel;
	UnityEngine.Transform menuIngredientsParent;
	MenuIngredientSingleDisplay[] ingredientsDisplay;
	TextController headerText;
	UnityEngine.GameObject fullScreenSubpanel;
	UnityEngine.GameObject windowedSubpanel;
	TextController windowedTimer;
	UnityEngine.UI.Image windowedFillImage;
	UnityEngine.GameObject failHeader;
	UnityEngine.GameObject failIconFloor;
	UnityEngine.GameObject failIconFire;
	UnityEngine.GameObject failIconBellSpam;
	UnityEngine.GameObject failIconFenceSpam;
	UnityEngine.GameObject failIconWindowLaunch;
	UnityEngine.GameObject failIconDoor;
	// RVA: 0x169ed70
	void Awake() { }
	// RVA: 0x169edc8
	void Start() { }
	// RVA: 0x169efe0
	void UpdateOnInstantiate() { }
	// RVA: 0x169f8a4
	void OnDestroy() { }
	// RVA: 0x169f4a8
	void ShowOrder(CustomerController _customer, System.Collections.Generic.List<ItemId> _reqItems, System.Collections.Generic.List<ItemId> _avoidItems) { }
	// RVA: 0x16a0498
	void ClearOrder() { }
	// RVA: 0x169fb28
	void UpdateDisplayingIngredients(System.Collections.Generic.List<ItemId> _reqItems, System.Collections.Generic.List<ItemId> _avoidItems) { }
	// RVA: 0x169faa4
	void DisableAllDisplayedIngredients(bool hideWithTransition) { }
	// RVA: 0x16a03f8
	void UpdateCurrentPanel() { }
	// RVA: 0x169f0c4
	void UpdateFailBoxes() { }
	// RVA: 0x16a0508
	void ClearFailBoxes() { }
	// RVA: 0x16a05a4
	void ShowInFailBoxes(CookingFail cF) { }
	// RVA: 0x169f238
	void UpdateSubpanel() { }
	// RVA: 0x169f2f8
	void UpdateSubpanelTimer(float remainingTime, float totalTime) { }
	// RVA: 0x16a06f4
	void .ctor() { }
}

// TypeDefIndex: 5635
class MenuIngredientSingleDisplay
{
	UnityEngine.UI.Image frameImg;
	UnityEngine.UI.Image ingredientImg;
	UnityEngine.UI.Image iconImg;
	UnityEngine.Sprite burgerSpr;
	UnityEngine.Sprite vurgerSpr;
	UnityEngine.Sprite tomatoSpr;
	UnityEngine.Sprite cheeseSpr;
	UnityEngine.Sprite lettuceSpr;
	UnityEngine.Sprite onionSpr;
	UnityEngine.Sprite caramelizedOnionSpr;
	UnityEngine.Sprite ketchupSpr;
	UnityEngine.Sprite mustardSpr;
	UnityEngine.Sprite mayoSpr;
	UnityEngine.Sprite mustanezaSpr;
	UnityEngine.Sprite mayochupSpr;
	UnityEngine.Sprite mostchupSpr;
	UnityEngine.Sprite burginezaSpr;
	UnityEngine.Sprite favSauceSpr;
	UnityEngine.Sprite drySauceSpr;
	UnityEngine.Sprite cupColaSpr;
	UnityEngine.Sprite cupLemonSpr;
	UnityEngine.Sprite cupOrangeSpr;
	UnityEngine.Sprite vIcon;
	UnityEngine.Sprite xIcon;
	UnityEngine.Sprite fire1Icon;
	UnityEngine.Sprite fire2Icon;
	UnityEngine.Sprite fire3Icon;
	UnityEngine.Sprite veganIcon;
	UnityEngine.Sprite smashedIcon;
	UnityEngine.Sprite doubleIcon;
	UnityEngine.Color greenBg;
	UnityEngine.Color redBg;
	DG.Tweening.Sequence popSeq;
	// RVA: 0x16a0778
	void DisplayAs(ItemId _itemId, int _units) { }
	// RVA: 0x16a0cb4
	void Hide(bool hideWithTransition) { }
	// RVA: 0x16a0968
	void SetValues(ItemId _itemId, int _units) { }
	// RVA: 0x16a0e44
	void .ctor() { }
	// RVA: 0x16a0e4c
	void <Hide>b__34_0() { }
}

// TypeDefIndex: 5636
class MisMetodos
{
	// RVA: 0x16a0e54
	void .ctor() { }
}

// TypeDefIndex: 5637
class ExtensionMethods.<>c__40`1
{
	ExtensionMethods+<>c__40<T> <>9;
	System.Comparison<System.Collections.Generic.KeyValuePair<T, int>> <>9__40_0;
	// no-body
	void .cctor() { }
	// no-body
	void .ctor() { }
	// no-body
	int <SortDictionaryByAscValue>b__40_0(System.Collections.Generic.KeyValuePair<T, int> pair1, System.Collections.Generic.KeyValuePair<T, int> pair2) { }
}

// TypeDefIndex: 5638
class ExtensionMethods.<>c__42`1
{
	ExtensionMethods+<>c__42<T> <>9;
	System.Comparison<System.Collections.Generic.KeyValuePair<T, float>> <>9__42_0;
	// no-body
	void .cctor() { }
	// no-body
	void .ctor() { }
	// no-body
	int <SortDictionaryByAscValue>b__42_0(System.Collections.Generic.KeyValuePair<T, float> pair1, System.Collections.Generic.KeyValuePair<T, float> pair2) { }
}

// TypeDefIndex: 5639
class ExtensionMethods.<>c__6`1
{
	ExtensionMethods+<>c__6<T> <>9;
	System.Func<T, T> <>9__6_0;
	System.Func<System.Linq.IGrouping<T, T>, int> <>9__6_1;
	System.Func<System.Linq.IGrouping<T, T>, T> <>9__6_2;
	// no-body
	void .cctor() { }
	// no-body
	void .ctor() { }
	// no-body
	T <MostCommon>b__6_0(T i) { }
	// no-body
	int <MostCommon>b__6_1(System.Linq.IGrouping<T, T> grp) { }
	// no-body
	T <MostCommon>b__6_2(System.Linq.IGrouping<T, T> grp) { }
}

// TypeDefIndex: 5640
class ExtensionMethods
{
	System.Collections.Generic.List<char> preCap;
	UnityEngine.Vector3[] corners;
	// RVA: 0x16a0e5c
	void CopyGlobalTransformValues(UnityEngine.Transform tr, UnityEngine.Transform transformToCopyFrom) { }
	// no-body
	T GetComponentInRecursiveParent(UnityEngine.Transform tr) { }
	// RVA: 0x16a0eec
	int ActiveChildCount(UnityEngine.Transform padre) { }
	// RVA: 0x16a0f78
	int ActiveChildIndex(UnityEngine.Transform specificChild) { }
	// RVA: 0x16a10c8
	UnityEngine.Transform GetChildByName(UnityEngine.Transform padre, string nombreABuscar) { }
	// RVA: 0x16a1160
	UnityEngine.Transform GetChildByInitial(UnityEngine.Transform padre, string inicialABuscar) { }
	// no-body
	T MostCommon(System.Collections.Generic.IList<T> lista) { }
	// RVA: 0x16a11fc
	UnityEngine.Transform[] GetAllChild(UnityEngine.Transform padre) { }
	// RVA: 0x16a1300
	System.Collections.Generic.List<UnityEngine.Transform> GetAllChildRecursive(UnityEngine.Transform parent) { }
	// RVA: 0x16a16e8
	UnityEngine.Vector3[] GetAllChildPos(UnityEngine.Transform padre) { }
	// RVA: 0x16a1898
	UnityEngine.GameObject[] GetAllChildAsGameObject(UnityEngine.Transform padre) { }
	// RVA: 0x16a1978
	UnityEngine.UI.Image[] GetAllChildAsImage(UnityEngine.Transform padre) { }
	// no-body
	T[] GetAllChildAs(UnityEngine.Transform parent) { }
	// no-body
	T[] GetComponentsInChildren(object[] originalArray) { }
	// RVA: 0x16a1a9c
	void DestroyAllChildren(UnityEngine.Transform padre) { }
	// RVA: 0x16a1d9c
	UnityEngine.Transform RecursiveFindChild(UnityEngine.Transform padre, string nombreABuscar) { }
	// RVA: 0x16a1f04
	UnityEngine.Transform RecursiveFindChildAux(UnityEngine.Transform padre, string nombreABuscar) { }
	// RVA: 0x16a206c
	float RoundToCeroConCinco(float num) { }
	// RVA: 0x16a2108
	float RoundToUnDecimal(float num) { }
	// RVA: 0x16a21a8
	string CapitalizarInicial(string texto) { }
	// RVA: 0x16a222c
	string CapitalizarTrasPunto(string s) { }
	// RVA: 0x16a2404
	string CapitalizarTodasLasIniciales(string s) { }
	// no-body
	void Shuffle(System.Collections.Generic.IList<T> list) { }
	// no-body
	void ShuffleWithSeed(System.Collections.Generic.IList<T> list, string seed) { }
	// RVA: 0x16a2588
	float GetRandomValueFromSeed(string seed) { }
	// no-body
	void SetAsFirst(System.Collections.Generic.IList<T> list, int indexToMove) { }
	// no-body
	void SetAsLast(System.Collections.Generic.IList<T> list, int indexToMove) { }
	// no-body
	void GetOnlyUnique(System.Collections.Generic.IList<T> listaOriginal) { }
	// no-body
	T[] Concatenate(T[] arrayViejo, T[] arrayNuevo) { }
	// no-body
	System.Collections.Generic.List<T> ToList(T[] arrayViejo) { }
	// RVA: 0x16a25d0
	UnityEngine.Vector3 GetRandomPointInBoundsY0(UnityEngine.Bounds bounds) { }
	// RVA: 0x16a2628
	UnityEngine.Vector3 GetRandomPointInBoundsY0(UnityEngine.BoxCollider[] colArray) { }
	// RVA: 0x16a290c
	bool IsPointOnArea(UnityEngine.Bounds bounds, UnityEngine.Vector3 point) { }
	// RVA: 0x16a2780
	UnityEngine.BoxCollider GetColliderBasedOnSizeProbabilityY0(UnityEngine.BoxCollider[] colArray) { }
	// RVA: 0x16a2960
	string ConvertFromArabic(string source) { }
	// RVA: 0x16a2bac
	bool IsArabic(char character) { }
	// RVA: 0x16a2bf8
	string Reverse(string source) { }
	// RVA: 0x16a2c7c
	System.Collections.Generic.List<int> GenerarListaNumerica(int numInicial, int totalCount, bool shuffle) { }
	// RVA: 0x16a2d34
	UnityEngine.Vector2 ToVector2XZ(UnityEngine.Vector3 v) { }
	// no-body
	System.Collections.Generic.List<T> SortDictionaryByAscValue(System.Collections.Generic.Dictionary<T, int> dict) { }
	// no-body
	System.Collections.Generic.List<T> SortDictionaryByDescValue(System.Collections.Generic.Dictionary<T, int> dict) { }
	// no-body
	System.Collections.Generic.List<T> SortDictionaryByAscValue(System.Collections.Generic.Dictionary<T, float> dict) { }
	// no-body
	System.Collections.Generic.List<T> SortDictionaryByDescValue(System.Collections.Generic.Dictionary<T, float> dict) { }
	// no-body
	void RemoveAllMatches(System.Collections.Generic.IList<T> lista, T item) { }
	// no-body
	System.Collections.Generic.List<T> RemoveRepeatedEntries(System.Collections.Generic.IList<T> previousList) { }
	// no-body
	void ClampLength(System.Collections.Generic.IList<T> lista, int maxLength) { }
	// no-body
	void AddIfNew(System.Collections.Generic.IList<T> lista, T item) { }
	// RVA: 0x16a2d3c
	string FormatSecondsTo0_00_00(int seconds) { }
	// RVA: 0x16a2f4c
	string FormatSecondsTo0_00_00(float secondsFloat) { }
	// RVA: 0x16a31a8
	string FormatToK(int amount) { }
	// no-body
	T GetLastItem(T[] list) { }
	// no-body
	T GetRandomItem(T[] list) { }
	// no-body
	T GetLastItem(System.Collections.Generic.List<T> list) { }
	// no-body
	T GetRandomItem(System.Collections.Generic.List<T> list) { }
	// no-body
	T GetRandomItemFirstItemsWeighted(System.Collections.Generic.List<T> list) { }
	// no-body
	bool HasContent(System.Collections.Generic.List<T> list) { }
	// no-body
	bool IsNullOrEmpty(System.Collections.Generic.List<T> list) { }
	// no-body
	System.Collections.Generic.List<T> ConcatList(System.Collections.Generic.List<T> baseList, System.Collections.Generic.List<T> newList) { }
	// RVA: 0x16a32a0
	bool IsCloseTo0(float value, float threeshold) { }
	// RVA: 0x16a32b4
	float RoundTo0(float value, float threeshold) { }
	// no-body
	int GetItemCount(System.Collections.Generic.List<T> list, T item) { }
	// RVA: 0x16a32d0
	float RandomSignFloat() { }
	// RVA: 0x16a333c
	int RandomSignInt() { }
	// RVA: 0x16a3364
	int GetIntSign(int num) { }
	// RVA: 0x16a3374
	int GetIntSign(float num) { }
	// RVA: 0x16a338c
	int GetIntSignIncludingZero(int num) { }
	// RVA: 0x16a33a0
	int GetIntSignIncludingZero(float num) { }
	// RVA: 0x16a33cc
	float ToAbsolute(float value) { }
	// RVA: 0x16a33d4
	int ToAbsolute(int value) { }
	// RVA: 0x16a342c
	int Distance(int a, int b) { }
	// RVA: 0x16a348c
	float Distance(float a, float b) { }
	// RVA: 0x16a34ec
	int CheckDistance(UnityEngine.Vector3 puntoA, UnityEngine.Vector3 puntoB, float distancia) { }
	// no-body
	void RemoveDuplicated(System.Collections.Generic.IList<T> list) { }
	// no-body
	System.Collections.Generic.List<T> ValuesInCommon(System.Collections.Generic.List<T> list1, System.Collections.Generic.List<T> list2) { }
	// RVA: 0x16a3520
	UnityEngine.Sprite ConvertToSprite(UnityEngine.Texture2D tex, int pixelsPerUnit) { }
	// no-body
	System.Collections.Generic.List<T> DictToList(System.Collections.Generic.Dictionary<T, T> dict) { }
	// RVA: 0x16a3588
	string SetToK(int number) { }
	// no-body
	bool IsOnRange(T[] array, int valueToCheck) { }
	// no-body
	bool IsOnRange(T[,] mapCells, int indexX, int indexY) { }
	// no-body
	bool IsOnRange(T[,] mapCells, UnityEngine.Vector2Int index) { }
	// RVA: 0x16a3680
	string[] SplitBy(string originalString, string separator) { }
	// RVA: 0x16a3798
	string SplitBetweenStrings(string originalString, string startingString, string endingString) { }
	// RVA: 0x16a38d4
	string[] SplitAllBetweenStrings(string originalString, string startingString, string endingString) { }
	// RVA: 0x16a386c
	string SplitForward(string originalString, string startingString) { }
	// RVA: 0x16a3a9c
	string SplitBackwards(string originalString, string endingString) { }
	// no-body
	System.Collections.Generic.List<T> Replace(System.Collections.Generic.List<T> baseList, T oldValue, T newValue) { }
	// no-body
	T GetComponentInChildrenOnly(UnityEngine.GameObject gO) { }
	// no-body
	T GetComponentInChildrenOnly(UnityEngine.Transform tr) { }
	// no-body
	T[] GetComponentsInChildrenOnly(UnityEngine.GameObject gO) { }
	// no-body
	T[] GetComponentsInChildrenOnly(UnityEngine.Transform tr) { }
	// RVA: 0x16a3b0c
	string EllipsisDots(string originalText, int maxLength, int cuttingIndex) { }
	// RVA: 0x16a3bbc
	string GenerateRandomTextFormatted(string format) { }
	// RVA: 0x16a3db4
	string ConvertListToString(System.Collections.Generic.List<string> list, string separator, string lastSeparator) { }
	// no-body
	int GetFirstIndexOf(T[] array, T value) { }
	// RVA: 0x16a3f24
	string Encrypt(string originalText, string key) { }
	// RVA: 0x16a407c
	string Decrypt(string encryptedText, string key) { }
	// RVA: 0x16a41ec
	string HashText(string originalText) { }
	// RVA: 0x16a4488
	UnityEngine.AnimationCurve CombineCurves(UnityEngine.AnimationCurve[] curves, float[] curveDurations) { }
	// RVA: 0x16a46b0
	float GetLuminanceValue(UnityEngine.Color color) { }
	// RVA: 0x16a46e0
	UnityEngine.Color AdjustColorLuminance(UnityEngine.Color originalColor, float targetLuminancePercentage) { }
	// RVA: 0x16a4868
	string ReemplazarTildesOAcentos(string originalSentence) { }
	// RVA: 0x16a4d30
	int CountCharactersWithoutFormatting(string text) { }
	// RVA: 0x16a4ddc
	string ReplaceCharacters(string input, char[] charsToRemove, char charToInsert) { }
	// RVA: 0x16a4fb0
	void InvertLocalScaleX(UnityEngine.Transform transform) { }
	// RVA: 0x16a4fdc
	void SetLayerByName(UnityEngine.GameObject go, string layerName) { }
	// RVA: 0x16a50b0
	void SetLayerRecursively(UnityEngine.GameObject obj, string layerName) { }
	// RVA: 0x16a53e8
	UnityEngine.Bounds TransformBoundsTo(UnityEngine.RectTransform source, UnityEngine.Transform target) { }
	// RVA: 0x16a5678
	float NormalizeScrollDistance(UnityEngine.UI.ScrollRect scrollRect, int axis, float distance) { }
	// RVA: 0x16a585c
	void ScrollToCenter(UnityEngine.UI.ScrollRect scrollRect, UnityEngine.RectTransform target) { }
	// no-body
	bool IsNullOrEmpty(T[] array) { }
	// no-body
	bool IsNullOrSmallerOrEqualThan(T[] array, int maxSize) { }
	// no-body
	TKey GetRandomKey(System.Collections.Generic.Dictionary<TKey, TValue> dict) { }
	// no-body
	TValue GetRandomValue(System.Collections.Generic.Dictionary<TKey, TValue> dict) { }
	// RVA: 0x16a59b4
	bool HasAnyCommonLetter(string text) { }
	// RVA: 0x16a5a38
	bool IsOnlyLatinCharacters(string text) { }
	// RVA: 0x16a5ab4
	bool IsNullOrEmpty(string text) { }
	// RVA: 0x16a5abc
	bool IsOnRange(int baseNum, int minValueInclusive, int maxValueInclusive) { }
	// RVA: 0x16a5ad4
	bool IsOnRange(float baseNum, float minValueInclusive, float maxValueInclusive) { }
	// RVA: 0x16a5aec
	string ReplaceTurkishCharacters(string text) { }
	// RVA: 0x16a5b94
	void .cctor() { }
}

// TypeDefIndex: 5641
class MissionManager.<Start>d__7
{
	int <>1__state;
	object <>2__current;
	MissionManager <>4__this;
	MissionId <missionToLoad>5__2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16a61ec
	void .ctor(int <>1__state) { }
	// RVA: 0x16a9174
	void System.IDisposable.Dispose() { }
	// RVA: 0x16a9178
	bool MoveNext() { }
	// RVA: 0x16a931c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16a9324
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16a935c
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5642
class MissionManager
{
	MissionManager instance;
	MissionId currentMission;
	System.Action callbackOnNewMission;
	bool hasCompletedTutorial;
	System.Nullable<bool> firstBoosterAlreadyOpened;
	// property CurrentMission
	// RVA: 0x16a6120
	MissionId get_CurrentMission() { }
	// RVA: 0x16a6128
	void Awake() { }
	// RVA: 0x16a6180
	System.Collections.IEnumerator Start() { }
	// RVA: 0x16a6214
	MissionId LoadCurrentMission() { }
	// RVA: 0x16a6438
	void OnDestroy() { }
	// RVA: 0x16a66c4
	void UnsuscribeAllMissionEvents() { }
	// RVA: 0x16a6d50
	void StartNewMission(MissionId _newMissionId) { }
	// RVA: 0x16a787c
	void UpdateTutorialHighlights() { }
	// RVA: 0x16a7bdc
	void SetTutorialAsComplete() { }
	// RVA: 0x16a7f0c
	void PlayVictoryTheme() { }
	// RVA: 0x16a8008
	MissionId GetNextMissionId(MissionId _currentMission) { }
	// RVA: 0x16a8100
	void CompleteCurrentDialog() { }
	// RVA: 0x16a8270
	void OnMissionFrezerDoor(bool isOpen) { }
	// RVA: 0x16a7928
	void CheckMissionFreezerDoor() { }
	// RVA: 0x16a6390
	bool HasPurchasedBasics() { }
	// RVA: 0x16a82f4
	void OnMissionPuchaseBasics() { }
	// RVA: 0x16a79b4
	void CheckMissionPurchaseBasics() { }
	// RVA: 0x16a8378
	void OnMissionWashDishComplete() { }
	// RVA: 0x16a8394
	void OnMissionFirstBurgerWithoutPanComplete(Dish newBurgerClosed) { }
	// RVA: 0x16a8434
	void DelayedCompleteMissionFirstRawBurger() { }
	// RVA: 0x16a8450
	void OnFirstRestock(bool _restockScreenEnabled) { }
	// RVA: 0x16a850c
	void FirstRestockCompleteDelayed() { }
	// RVA: 0x16a8528
	void OnMissionFirstCookedBurgerComplete(Dish newBurgerClosed) { }
	// RVA: 0x16a8628
	void DelayedCompleteMissionFirstCookedBurger() { }
	// RVA: 0x16a8654
	void DelayedFailMissionFirstCookedBurger() { }
	// RVA: 0x16a8680
	void OnMissionFirstCustomersCustomerReview(bool _reviewOnScreen) { }
	// RVA: 0x16a79e8
	void CheckMissionFirstCustomers() { }
	// RVA: 0x16a8708
	void OnMissionPurchaseBell() { }
	// RVA: 0x16a7aa4
	void CheckMissionPurchaseBell() { }
	// RVA: 0x16a7b28
	void OnWindowChange() { }
	// RVA: 0x16a87bc
	void OnApplicationFocus(bool focus) { }
	// RVA: 0x16a87dc
	void ChangeToTutorialGamemode() { }
	// RVA: 0x16a8830
	void OnMissionServeAfterMinimizedReview(bool _reviewOnScreen) { }
	// RVA: 0x16a88d8
	void InitializeOutfitServedMission() { }
	// RVA: 0x16a8a14
	void OnReviewOpenedForOutfitDialog(bool _reviewOnScreen) { }
	// RVA: 0x16a8d20
	void OnReviewClosedForOutfitDialog(bool _reviewOnScreen) { }
	// RVA: 0x16a8e70
	void OnFirstOpenBooster() { }
	// RVA: 0x16a8f7c
	void OnNewUnlock(Unlockable unlockableId) { }
	// RVA: 0x16a9134
	float GetTutorialPercent() { }
	// RVA: 0x16a9164
	void .ctor() { }
}

// TypeDefIndex: 5643
class MissionId
{
	int value__;
	MissionId None;
	MissionId Dialog_Welcome;
	MissionId Dialog_Presentation;
	MissionId Dialog_CheckIngredients;
	MissionId Mission_OpenFreezer;
	MissionId Dialog_OpenFreezerComplete;
	MissionId Dialog_StartFromZero;
	MissionId Dialog_BasicIngredients;
	MissionId Dialog_PurchaseBasics;
	MissionId Mission_PurchaseBasics;
	MissionId Dialog_PurchaseBasicsComplete;
	MissionId Dialog_WashDish;
	MissionId Mission_WashDish;
	MissionId Dialog_WashDishComplete;
	MissionId Dialog_AskFirstBurger;
	MissionId Mission_FirstBurgerWithoutPan;
	MissionId Dialog_DeliveredFirstBurgerWithoutPan1;
	MissionId Dialog_DeliveredFirstBurgerWithoutPan2;
	MissionId Mission_Restock;
	MissionId Dialog_AfterRestock;
	MissionId Dialog_FirstCookedBurger;
	MissionId Mission_FirstCookedBurger;
	MissionId Dialog_FirstCookedBurgerWrong;
	MissionId Dialog_FirstCookedBurgerComplete;
	MissionId Dialog_FirstCustomers;
	MissionId Mission_FirstCustomers1;
	MissionId Mission_FirstCustomers2;
	MissionId Dialog_FirstCustomersComplete;
	MissionId Dialog_GameExplanationStart;
	MissionId Dialog_GameExplanationTimes;
	MissionId Dialog_GameExplanationWaitings;
	MissionId Dialog_GameExplanationQuality;
	MissionId Dialog_PurchaseBell;
	MissionId Mission_PurchaseBell;
	MissionId Dialog_PurchaseBellComplete;
	MissionId Dialog_WaitInMinimized;
	MissionId Mission_WaitInMinimized;
	MissionId Mission_ServeAfterMinimized;
	MissionId Dialog_ServeAfterMinimizedComplete;
	MissionId Dialog_RadioGift;
	MissionId Dialog_RadioExplain1;
	MissionId Dialog_RadioExplain2;
	MissionId Dialog_TutorialEnd1;
	MissionId Dialog_TutorialEnd2;
	MissionId Dialog_PurchaseTomato;
	MissionId Dialog_PurchaseOnion;
	MissionId Dialog_PurchaseLettuce;
	MissionId Dialog_PurchaseCheese;
	MissionId Dialog_PurchaseVegan;
	MissionId Dialog_PurchaseDishrack;
	MissionId Dialog_PurchaseSlicerB;
	MissionId Dialog_PurchaseTrash;
	MissionId Dialog_PurchaseTrashCover;
	MissionId Dialog_PurchaseLeaderboards;
	MissionId Dialog_PurchaseExtractor;
	MissionId Dialog_PurchaseToothpickJar;
	MissionId Dialog_PurchaseDecoration;
	MissionId Dialog_PurchaseGrill;
	MissionId Dialog_PurchaseSmasher;
	MissionId Dialog_PurchaseKetchupBottle;
	MissionId Dialog_PurchaseMustardBottle;
	MissionId Dialog_PurchaseHoneyBottle;
	MissionId Dialog_PurchaseBbqBottle;
	MissionId Dialog_PurchaseHerbsBottle;
	MissionId Dialog_PurchasePineBottle;
	MissionId Dialog_PurchaseMayoBottle;
	MissionId Dialog_PurchasePaperRoll;
	MissionId Dialog_PurchaseTray;
	MissionId Dialog_PurchaseDrinkMachine;
	MissionId Dialog_PurchaseLemonDrink;
	MissionId Dialog_PurchaseOrangeDrink;
	MissionId Dialog_PurchaseWaitStand;
	MissionId Dialog_PurchaseCardBooster;
	MissionId Dialog_PurchaseCardAlbum;
	MissionId Dialog_PurchaseGrillTurbo;
	MissionId Dialog_OpenFirstCardBooster;
	MissionId Dialog_FirstOutfitServed;
	MissionId Dialog_GameComplete;
}

// TypeDefIndex: 5644
class MissionScriptable
{
	MissionId missionId;
	UnityEngine.Sprite missionIcon;
	UnityEngine.Sprite[] missionGuideIcons;
	// RVA: 0x16a9364
	void Initialize() { }
	// RVA: 0x16a9474
	void .ctor() { }
}

// TypeDefIndex: 5645
class MobileShadowMode
{
	int value__;
	MobileShadowMode Disabled;
	MobileShadowMode InsideLightOnly;
	MobileShadowMode All;
}

// TypeDefIndex: 5646
class MobileRenderingController
{
	string DefaultShadowLightName;
	System.Collections.Generic.Dictionary<UnityEngine.Light, UnityEngine.LightShadows> originalLightShadows;
	MobileShadowMode shadowMode;
	string shadowLightName;
	// RVA: 0x16a947c
	void Awake() { }
	// RVA: 0x16a94ac
	void SetShadowMode(MobileShadowMode mode, string lightName) { }
	// RVA: 0x16a96f4
	void RefreshRenderingObjects() { }
	// RVA: 0x16a9494
	void ApplyMobileRenderingSettings() { }
	// RVA: 0x16a970c
	void DisablePostProcessing() { }
	// RVA: 0x16a9994
	void DisablePostProcessing(UnityEngine.Camera camera) { }
	// RVA: 0x16a9528
	void ApplyShadowSettings() { }
	// RVA: 0x16a9a78
	void .ctor() { }
}

// TypeDefIndex: 5647
class Monitor
{
	UnityEngine.Canvas canvas;
	// RVA: 0x16a9b24
	void TurnOn(bool on) { }
	// RVA: 0x16a9be0
	void .ctor() { }
}

// TypeDefIndex: 5648
class MonitorButton
{
	bool isTurnedOn;
	AudioPlayer audioPlayer;
	UnityEngine.Material mat;
	UnityEngine.Vector2 redColorMatOffset;
	UnityEngine.Vector2 greenColorMatOffset;
	Monitor monitor;
	// RVA: 0x16a9c38
	void Awake() { }
	// RVA: 0x16a9dec
	void InitializeButtonPos() { }
	// RVA: 0x16a9f24
	void Interact() { }
	// RVA: 0x16a9fd0
	void TurnOn(bool on) { }
	// RVA: 0x16aa160
	void RightInteract() { }
	// RVA: 0x16aa16c
	void .ctor() { }
}

// TypeDefIndex: 5649
class MotionSicknessManager
{
	CameraFollow playerCam;
	UnityEngine.Transform playerGroup;
	UnityEngine.Transform camAnchor;
	float minFPSToEnableFixedUpdate;
	int frameCount;
	float timeAccumulator;
	float averageFPS;
	bool isGrabbing;
	// RVA: 0x16aa180
	void Awake() { }
	// RVA: 0x16aa388
	void OnDestroy() { }
	// RVA: 0x16aa49c
	void Update() { }
	// RVA: 0x16aa504
	void UpdateSimulationMode(float fpsToEvaluate) { }
	// RVA: 0x16aa2c4
	void ChangeSimulationMode(UnityEngine.SimulationMode _newSimulationMode) { }
	// RVA: 0x16aa378
	void OnGrabSomethingChange(bool _isGrabbing) { }
	// RVA: 0x16aa524
	void SetCameraInsideCharacterMovingWithPhysicsSpeed() { }
	// RVA: 0x16aa628
	void SetCameraOutsideCharacterWithFluentMovement() { }
	// RVA: 0x16aa66c
	void .ctor() { }
}

// TypeDefIndex: 5650
class MultiCam
{
	MultiCam instance;
	bool initialized;
	DG.Tweening.Sequence camTransition;
	UnityEngine.Camera playerCam;
	UnityEngine.Camera unfocusCam;
	CamConfig unfocusCamConfig;
	UnityEngine.Rect lastWindowRect;
	UnityEngine.Vector2 currentCamSize;
	UnityEngine.Rect minimizedRect;
	System.Action<UnityEngine.Camera> callbackActiveCameraChange;
	float yRatio;
	UnityEngine.Vector2 <camScreenPos>k__BackingField;
	// property camScreenPos
	// RVA: 0x16aa674
	UnityEngine.Vector2 get_camScreenPos() { }
	// RVA: 0x16aa67c
	void set_camScreenPos(UnityEngine.Vector2 value) { }
	// RVA: 0x16aa684
	void Awake() { }
	// RVA: 0x16aa810
	void Start() { }
	// RVA: 0x16aa818
	void Update() { }
	// RVA: 0x16aa6e4
	void InitializeCams() { }
	// RVA: 0x16aa988
	UnityEngine.Rect FitRectToAspect(UnityEngine.Rect containerRect) { }
	// RVA: 0x16aabc8
	void SaveCurrentWindowPosition() { }
	// RVA: 0x16aaa38
	void LoadWindowPosition() { }
	// RVA: 0x16aad10
	void OnApplicationFocus(bool focus) { }
	// RVA: 0x16aa814
	void WindowizeWindow(WindowStatus _windowStatus, float transitionTime) { }
	// RVA: 0x16aad98
	void SetUnfocusCamNewRectCenter(UnityEngine.Rect unfocusRect) { }
	// RVA: 0x16aadb4
	void .ctor() { }
	// RVA: 0x16aade8
	void <WindowizeWindow>b__23_0() { }
	// RVA: 0x16aaea0
	void <WindowizeWindow>b__23_1() { }
	// RVA: 0x16aaedc
	void <WindowizeWindow>b__23_2() { }
}

// TypeDefIndex: 5651
class CamConfig
{
	UnityEngine.Vector3 camPos;
	UnityEngine.Vector3 camRot;
	float fov;
	// RVA: 0x16aa904
	void .ctor(UnityEngine.Transform _tr, float _fov) { }
}

// TypeDefIndex: 5652
class OpenAIChat.CoroutineRunner
{
	// RVA: 0x16ab1b8
	void .ctor() { }
}

// TypeDefIndex: 5653
class OpenAIChat.ChatResponse.Choice
{
	OpenAIChat+ChatResponse+Message message;
	// RVA: 0x16ab1c8
	void .ctor() { }
}

// TypeDefIndex: 5654
class OpenAIChat.ChatResponse.Message
{
	string role;
	string content;
	// RVA: 0x16ab1d0
	void .ctor() { }
}

// TypeDefIndex: 5655
class OpenAIChat.ChatResponse
{
	OpenAIChat+ChatResponse+Choice[] choices;
	// RVA: 0x16ab1c0
	void .ctor() { }
}

// TypeDefIndex: 5656
class OpenAIChat.<SolicitarRespuestaIA>d__6
{
	int <>1__state;
	object <>2__current;
	string contexto;
	System.Action<string> callback;
	UnityEngine.Networking.UnityWebRequest <request>5__2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16ab190
	void .ctor(int <>1__state) { }
	// RVA: 0x16ab1d8
	void System.IDisposable.Dispose() { }
	// RVA: 0x16ab1f4
	bool MoveNext() { }
	// RVA: 0x16ab718
	void <>m__Finally1() { }
	// RVA: 0x16ab7c8
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16ab7d0
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16ab808
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5657
class OpenAIChat
{
	string API_KEY;
	string API_URL;
	OpenAIChat+CoroutineRunner runnerInstance;
	// RVA: 0x16aaf54
	void EnsureRunnerExists() { }
	// RVA: 0x16ab08c
	void EnviarMensaje(string contexto, System.Action<string> callback) { }
	// RVA: 0x16ab108
	System.Collections.IEnumerator SolicitarRespuestaIA(string contexto, System.Action<string> callback) { }
}

// TypeDefIndex: 5658
class OutlineManager.<FlickeringRedOutline>d__30
{
	int <>1__state;
	object <>2__current;
	OutlineManager <>4__this;
	float <t>5__2;
	float <maxT>5__3;
	UnityEngine.Color <color1>5__4;
	UnityEngine.Color <color2>5__5;
	float <extraTime>5__6;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16ac594
	void .ctor(int <>1__state) { }
	// RVA: 0x16ac638
	void System.IDisposable.Dispose() { }
	// RVA: 0x16ac63c
	bool MoveNext() { }
	// RVA: 0x16ac7f4
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16ac7fc
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16ac834
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5659
class OutlineManager.<PulseMissionHighlight>d__27
{
	int <>1__state;
	object <>2__current;
	OutlineManager <>4__this;
	float <pulseTime>5__2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16ac3ec
	void .ctor(int <>1__state) { }
	// RVA: 0x16ac83c
	void System.IDisposable.Dispose() { }
	// RVA: 0x16ac840
	bool MoveNext() { }
	// RVA: 0x16ac9c0
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16ac9c8
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16aca00
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5660
class OutlineManager
{
	bool initialized;
	bool allowsWhiteOutline;
	bool allowsRedOutline;
	Outline outline;
	bool isWhiteOutlined;
	bool missionHighlighted;
	float outlineWidthOnFullscreen;
	float outlineWidthOnWindow;
	float missionOutlineWidthOnFullscreen;
	float missionOutlineWidthOnWindow;
	UnityEngine.Color missionOutlineColorYellow;
	UnityEngine.Color missionOutlineColorRed;
	UnityEngine.Coroutine missionHighlightCoroutine;
	UnityEngine.Coroutine flickeringRedOutline;
	// RVA: 0x16ab810
	void Awake() { }
	// RVA: 0x16ab958
	void Start() { }
	// RVA: 0x16ab814
	void Initialize() { }
	// RVA: 0x16abc8c
	void OnDestroy() { }
	// RVA: 0x16abf30
	void OnWindowChange() { }
	// RVA: 0x16ac270
	void OnReviewPopUp(bool reviewOpens) { }
	// RVA: 0x16abb28
	void ConfigureOutline() { }
	// RVA: 0x16ac280
	void ResetOutline() { }
	// RVA: 0x16ac350
	void OnGrabSomethingChange(bool _isGrabbing) { }
	// RVA: 0x16abbe8
	void SetOutlineOff() { }
	// RVA: 0x16ac35c
	void DisableOutline() { }
	// RVA: 0x16ac0a4
	void SetOutline(bool on) { }
	// RVA: 0x16a65a8
	void SetMissionHighlight(bool on) { }
	// RVA: 0x16abf44
	void ApplyMissionHighlight() { }
	// RVA: 0x16ac380
	System.Collections.IEnumerator PulseMissionHighlight() { }
	// RVA: 0x16ac414
	void FlickerRedOutline() { }
	// RVA: 0x16ac528
	System.Collections.IEnumerator FlickeringRedOutline() { }
	// RVA: 0x16ac5bc
	void .ctor() { }
	// RVA: 0x16ac5d4
	void .cctor() { }
}

// TypeDefIndex: 5661
class PaperSheet
{
	UnityEngine.Mesh dirtyPaperSheetModel;
	UnityEngine.Color currentSheetColor;
	float splatPercentage;
	float absortionCapacity;
	UnityEngine.Material mat;
	AudioPlayer audioPlayer;
	// RVA: 0x16aca08
	void Start() { }
	// RVA: 0x16acb08
	bool AbsorbSplat(UnityEngine.Color _splatColor, float _percentage) { }
	// RVA: 0x16acd24
	void OnStopAbsorbing() { }
	// RVA: 0x16acc28
	void UpdateSheetColor(UnityEngine.Color _newColor) { }
	// RVA: 0x16acc50
	void WrinkPaperSheet() { }
	// RVA: 0x16acd48
	void .ctor() { }
}

// TypeDefIndex: 5662
class ParticleManager.<PlayParticles>d__0
{
	int <>1__state;
	System.Runtime.CompilerServices.AsyncVoidMethodBuilder <>t__builder;
	ParticleManager <>4__this;
	System.Runtime.CompilerServices.TaskAwaiter <>u__1;
	// RVA: 0x16aceac
	void MoveNext() { }
	// RVA: 0x16ad0dc
	void SetStateMachine(System.Runtime.CompilerServices.IAsyncStateMachine stateMachine) { }
}

// TypeDefIndex: 5663
class ParticleManager
{
	// RVA: 0x16acda8
	void PlayParticles() { }
	// RVA: 0x16ace5c
	void Stop() { }
	// RVA: 0x16ace80
	void OnParticleSystemStopped() { }
	// RVA: 0x16acea4
	void .ctor() { }
}

// TypeDefIndex: 5664
class PedestrianController.PedestrianGroupTypes
{
	int value__;
	PedestrianController+PedestrianGroupTypes Single;
	PedestrianController+PedestrianGroupTypes Parent;
	PedestrianController+PedestrianGroupTypes Friends;
}

// TypeDefIndex: 5665
class PedestrianController
{
	PedestrianSystem pedestrianSystem;
	PedestrianSkinSetter pedestrianPrefab;
	UnityEngine.Transform singleTr;
	UnityEngine.Transform[] parentTr;
	UnityEngine.Transform[] friendsTr;
	float speed;
	UnityEngine.Transform[] currentPath;
	int nextPointIndex;
	DG.Tweening.Sequence seq;
	int pathNumber;
	// RVA: 0x16ad0e8
	void Start() { }
	// RVA: 0x16ad118
	void GenerateRandomGroup() { }
	// RVA: 0x16ad4f8
	void StartRandomPath(UnityEngine.Transform[] _newPath, int _pathNumber, PedestrianSystem _pedestrianSystem) { }
	// RVA: 0x16ad5bc
	void SetOnStartingPoint() { }
	// RVA: 0x16ad7a4
	void SetNextPoint() { }
	// RVA: 0x16adb7c
	void OnPathEnd() { }
	// RVA: 0x16adc54
	void .ctor() { }
	// RVA: 0x16adc64
	void <SetNextPoint>b__14_0() { }
}

// TypeDefIndex: 5666
class PedestrianSkinSetter
{
	UnityEngine.MeshFilter headMF;
	UnityEngine.MeshFilter eyesMF;
	UnityEngine.MeshFilter bodyMF;
	UnityEngine.MeshFilter lArmMF;
	UnityEngine.MeshFilter rArmMF;
	// RVA: 0x16ad474
	void SetSkin(CustomerDataScriptable c) { }
	// RVA: 0x16adc68
	void .ctor() { }
}

// TypeDefIndex: 5667
class PedestrianSystem.<SpawningRoutine>d__6
{
	int <>1__state;
	object <>2__current;
	PedestrianSystem <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16ade5c
	void .ctor(int <>1__state) { }
	// RVA: 0x16ae19c
	void System.IDisposable.Dispose() { }
	// RVA: 0x16ae1a0
	bool MoveNext() { }
	// RVA: 0x16ae26c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16ae274
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16ae2ac
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5668
class PedestrianSystem
{
	PedestrianController pedestrianPrefab;
	UnityEngine.Vector2 timeBetweenPedestrians;
	UnityEngine.Transform[][] pedestrianPaths;
	System.Collections.Generic.List<int> pathsOnUse;
	// RVA: 0x16adc70
	void Start() { }
	// RVA: 0x16adc98
	void GetPedestrianPaths() { }
	// RVA: 0x16addf0
	System.Collections.IEnumerator SpawningRoutine() { }
	// RVA: 0x16ade84
	void SpawnNewPedestrian() { }
	// RVA: 0x16adbfc
	void OnPathEnd(int pathNumber) { }
	// RVA: 0x16ae108
	void .ctor() { }
}

// TypeDefIndex: 5669
class Poster.<LoadImage>d__7
{
	int <>1__state;
	object <>2__current;
	string filePath;
	Poster <>4__this;
	UnityEngine.Networking.UnityWebRequest <www>5__2;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16ae504
	void .ctor(int <>1__state) { }
	// RVA: 0x16ae9ec
	void System.IDisposable.Dispose() { }
	// RVA: 0x16aea08
	bool MoveNext() { }
	// RVA: 0x16aecb0
	void <>m__Finally1() { }
	// RVA: 0x16aed60
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16aed68
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16aeda0
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5670
class Poster
{
	UnityEngine.Renderer targetRenderer;
	UnityEngine.Texture2D defaultImage;
	string PlayerPrefsKey;
	// RVA: 0x16ae2b4
	void Start() { }
	// RVA: 0x16ae370
	void RightInteract() { }
	// RVA: 0x16ae37c
	void Interact() { }
	// RVA: 0x16ae414
	void OpenImagePicker() { }
	// RVA: 0x16ae47c
	System.Collections.IEnumerator LoadImage(string filePath) { }
	// RVA: 0x16ae52c
	void ApplyImage(UnityEngine.Texture2D originalTex) { }
	// RVA: 0x16ae9e4
	void .ctor() { }
}

// TypeDefIndex: 5671
class PostProcessingManager
{
	UnityEngine.Rendering.PostProcessing.PostProcessVolume pPV;
	UnityEngine.Rendering.PostProcessing.PostProcessProfile fullscreenProfile;
	UnityEngine.Rendering.PostProcessing.PostProcessProfile windowedProfile;
	// RVA: 0x16aeda8
	void Awake() { }
	// RVA: 0x16aee70
	void Start() { }
	// RVA: 0x16aefa0
	void OnDestroy() { }
	// RVA: 0x16af0a0
	void OnWindowChange() { }
	// RVA: 0x16af15c
	void .ctor() { }
}

// TypeDefIndex: 5672
class Pot
{
	bool isCooking;
	UnityEngine.GameObject cookingParticles;
	AudioPlayer potAudioPlayer;
	// RVA: 0x16af164
	void Awake() { }
	// RVA: 0x16af268
	void Update() { }
	// RVA: 0x16af1e8
	void SetOnCooking(bool on, bool force) { }
	// RVA: 0x16af34c
	void .ctor() { }
}

// TypeDefIndex: 5673
class PunchOnClick
{
	bool initialized;
	UnityEngine.RectTransform rT;
	DG.Tweening.Tween tween;
	// RVA: 0x16af3a4
	void Awake() { }
	// RVA: 0x16af3a8
	void Initialize() { }
	// RVA: 0x16af41c
	void Punch() { }
	// RVA: 0x16af4c8
	void .ctor() { }
}

// TypeDefIndex: 5674
class PunchOnEnable
{
	bool initialized;
	UnityEngine.RectTransform rT;
	DG.Tweening.Tween tween;
	// RVA: 0x16af4d0
	void OnEnable() { }
	// RVA: 0x16af580
	void Initialize() { }
	// RVA: 0x16af4d4
	void Punch() { }
	// RVA: 0x16af5f4
	void .ctor() { }
}

// TypeDefIndex: 5675
class Radio
{
	int currentSongIndex;
	int currentFireSongIndex;
	Radio instance;
	UnityEngine.AudioSource radioSource;
	UnityEngine.Audio.AudioMixer audioMixer;
	UnityEngine.AudioClip[] songsOnPlay;
	UnityEngine.AudioClip[] radioSongs;
	UnityEngine.AudioClip[] fireSongs;
	UnityEngine.AudioClip[] pirateSongs;
	UnityEngine.AudioClip[] halloweenSongs;
	UnityEngine.AudioClip victorySong;
	UnityEngine.Animator radioAnim;
	bool isOnFireSong;
	// property Interact_Left
	// property Interact_Right
	// RVA: 0x16af5fc
	void Awake() { }
	// RVA: 0x16af6c8
	void Start() { }
	// RVA: 0x16afb80
	void OnDestroy() { }
	// RVA: 0x16af9fc
	void OnSeasonChange() { }
	// RVA: 0x16afa98
	void PlayLastSavedSong() { }
	// RVA: 0x16b0020
	void RightInteract() { }
	// RVA: 0x16a7f64
	void PlayVictoryTheme() { }
	// RVA: 0x16b0104
	void PressNextTheme(bool _next) { }
	// RVA: 0x16afe9c
	void ChangeThemeIndex(int _newSongIndex) { }
	// RVA: 0x16b01e8
	void ChangeFireThemeIndex(int _newSongIndex) { }
	// RVA: 0x16b013c
	void RadioFadeIn() { }
	// RVA: 0x16afaf0
	void OnMusicVolumeChange() { }
	// RVA: 0x16b0338
	void OnTimeUpdate(float remainingTime, float unusedParameter) { }
	// RVA: 0x16b041c
	void ChangeRadioSpeed(float _newSpeed) { }
	// RVA: 0x16b051c
	void OnFireChange() { }
	// RVA: 0x16b0710
	bool get_Interact_Left() { }
	// RVA: 0x16b0718
	bool get_Interact_Right() { }
	// RVA: 0x16b0720
	void .ctor() { }
}

// TypeDefIndex: 5676
class RecyclingAchievementTrigger
{
	System.Collections.Generic.List<GrabableItem> itemsInside;
	// RVA: 0x16b0778
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x16b08b8
	void OnTriggerExit(UnityEngine.Collider other) { }
	// RVA: 0x16b09a0
	void CheckItemsInside() { }
	// RVA: 0x16b0b48
	void .ctor() { }
}

// TypeDefIndex: 5677
class RequireUnlockableToEnable
{
	bool initialized;
	Unlockable[] requiredUnlockables;
	Unlockable[] unlockablesToNotHave;
	// RVA: 0x16b0bd0
	void Start() { }
	// RVA: 0x16b0d30
	void OnDestroy() { }
	// RVA: 0x16b0cd8
	void Initialize() { }
	// RVA: 0x16b0e20
	void OnEnable() { }
	// RVA: 0x16b0cf0
	void OnUnlockableChange() { }
	// RVA: 0x16b0e30
	bool CanBeEnabled() { }
	// RVA: 0x16b0f7c
	void .ctor() { }
}

// TypeDefIndex: 5678
class ResourceLoader.<>c
{
	ResourceLoader+<>c <>9;
	System.Func<CustomerDataScriptable, CustomerBreed> <>9__17_1;
	// RVA: 0x16b27e0
	void .cctor() { }
	// RVA: 0x16b2848
	void .ctor() { }
	// RVA: 0x16b2850
	CustomerBreed <GetAvailableBreedsInThisDayTime>b__17_1(CustomerDataScriptable c) { }
}

// TypeDefIndex: 5679
class ResourceLoader.<>c__DisplayClass17_0
{
	DayTime current;
	// RVA: 0x16b1d54
	void .ctor() { }
	// RVA: 0x16b2868
	bool <GetAvailableBreedsInThisDayTime>b__0(CustomerDataScriptable c) { }
}

// TypeDefIndex: 5680
class ResourceLoader
{
	UnityEngine.Color redColor;
	bool initialized;
	System.Collections.Generic.Dictionary<ItemId, GrabableItem> grabablePrefabs;
	System.Collections.Generic.Dictionary<MissionId, MissionScriptable> missionScriptables;
	System.Collections.Generic.Dictionary<CustomerBreed, CustomerDataScriptable> customerScriptables;
	System.Collections.Generic.Dictionary<CustomerOutfit, OutfitScriptable> outfitScriptables;
	System.Collections.Generic.Dictionary<ItemId, BurgerToppingScriptable> toppingScriptables;
	System.Collections.Generic.Dictionary<ItemId, UnityEngine.Color> sauceSplatColors;
	System.Collections.Generic.Dictionary<CustomerBreed, UnityEngine.Mesh> toothpicks;
	System.Collections.Generic.Dictionary<DayTime, System.Collections.Generic.List<CustomerBreed>> breedCache;
	// RVA: 0x16b0f84
	void Initialize() { }
	// RVA: 0x16b15b4
	GrabableItem GetGrabableItem(ItemId _itemId) { }
	// RVA: 0x16b1658
	MissionScriptable GetMission(MissionId _missionId) { }
	// RVA: 0x16b16dc
	CustomerDataScriptable GetBreedData(CustomerBreed _customerBreed) { }
	// RVA: 0x16b1844
	System.Collections.Generic.List<CustomerDataScriptable> GetAllBreedDatas() { }
	// RVA: 0x16b18dc
	CustomerDataScriptable GetRandomBreedData() { }
	// RVA: 0x16ad3a0
	CustomerDataScriptable GetRandomBreedDataInThisTimeRange() { }
	// RVA: 0x16b1978
	System.Collections.Generic.List<CustomerBreed> GetAvailableBreedsInThisDayTime() { }
	// RVA: 0x16b1d5c
	OutfitScriptable GetOutfitData(CustomerOutfit _outfit) { }
	// RVA: 0x16b1de0
	OutfitScriptable GetRandomOutfitData() { }
	// RVA: 0x16b1e7c
	BurgerToppingScriptable GetToppingData(ItemId _topping) { }
	// RVA: 0x16b1f20
	UnityEngine.Mesh GetToothpick(CustomerBreed _breed) { }
	// RVA: 0x16b1fc4
	ItemId GetFavSauce(CustomerBreed _breed) { }
	// RVA: 0x16b2054
	bool IsThisASauce(ItemId _itemToCheck) { }
	// RVA: 0x16b2078
	bool IsThisABread(ItemId _itemToCheck) { }
	// RVA: 0x16b209c
	bool IsThisAPatty(ItemId _itemToCheck) { }
	// RVA: 0x16b20c0
	bool IsThisADrink(ItemId _itemToCheck) { }
	// RVA: 0x16b20d0
	bool IsThisASide(ItemId _itemToCheck) { }
	// RVA: 0x16b212c
	bool IsThisAToy(ItemId _itemToCheck) { }
	// RVA: 0x16b213c
	bool IsThisCupVariant(ItemId _itemToCheck) { }
	// RVA: 0x16b21a4
	bool IsThisSplattable(ItemId _itemToCheck) { }
	// RVA: 0x16b222c
	void .ctor() { }
	// RVA: 0x16b2234
	void .cctor() { }
}

// TypeDefIndex: 5681
class RestockButton
{
	bool isResetBox;
	UnityEngine.AudioSource[] audiosources;
	AudioPlayer audioPlayer;
	// RVA: 0x16b288c
	void Start() { }
	// RVA: 0x16b2924
	void Interact() { }
	// RVA: 0x16b2b14
	void PerformReset() { }
	// RVA: 0x16b2a00
	void PerformRestock() { }
	// RVA: 0x16b2bbc
	void RightInteract() { }
	// RVA: 0x16b2bc8
	void .ctor() { }
}

// TypeDefIndex: 5682
class Reticle
{
	Reticle instance;
	UnityEngine.GameObject reticle;
	UnityEngine.UI.Image loadingCircle;
	bool isReticleEnabled;
	bool isLoadingAnim;
	float loadingCurrentTime;
	float loadingMaxTime;
	// RVA: 0x16b2bd0
	void Awake() { }
	// RVA: 0x16b2c9c
	void Start() { }
	// RVA: 0x16b2db0
	void OnDestroy() { }
	// RVA: 0x16b2ec4
	void Update() { }
	// RVA: 0x16b2f38
	void OnGrabSomethingChange(bool _isGrabbing) { }
	// RVA: 0x16b2f48
	void EnableReticle(bool _on) { }
	// RVA: 0x16b2c78
	void UpdateReticleState() { }
	// RVA: 0x16b2f54
	void StartLoadingCircle(float _time) { }
	// RVA: 0x16b2c38
	void StopLoadingCircle() { }
	// RVA: 0x16b2f98
	void .ctor() { }
}

// TypeDefIndex: 5683
class ReviewTimerDisplay
{
	bool initialized;
	float enableTime;
	TextController reviewText;
	// RVA: 0x16b2fa8
	void Initialize() { }
	// RVA: 0x16b301c
	void OnEnable() { }
	// RVA: 0x16b3088
	void OnDisable() { }
	// RVA: 0x16b30d4
	void OnMinuteUpdate() { }
	// RVA: 0x16b3358
	void .ctor() { }
}

// TypeDefIndex: 5684
class SauceBottle.<>c__DisplayClass6_0
{
	float easeT;
	Dish _dishToSplat;
	SauceBottle <>4__this;
	// RVA: 0x16b38c8
	void .ctor() { }
	// RVA: 0x16b3ecc
	void <RotateTweenToSplat>b__0(float t) { }
	// RVA: 0x16b3ed4
	void <RotateTweenToSplat>b__1() { }
	// RVA: 0x16b41f4
	void <RotateTweenToSplat>b__2() { }
	// RVA: 0x16b4214
	void <RotateTweenToSplat>b__3() { }
}

// TypeDefIndex: 5685
class SauceBottle
{
	System.Collections.Generic.List<Dish> dishesOnRange;
	AudioPlayer audioPlayer;
	Dish dishTweeningTo;
	DG.Tweening.Sequence rotateSeq;
	// RVA: 0x16b3360
	void Awake() { }
	// RVA: 0x16b33d4
	void Update() { }
	// RVA: 0x16b3590
	void RotateTweenToSplat(Dish _dishToSplat) { }
	// RVA: 0x16b3870
	void StopRotateTween() { }
	// RVA: 0x16b38d0
	void OnTriggerEnter(UnityEngine.Collider col) { }
	// RVA: 0x16b3a08
	void OnTriggerExit(UnityEngine.Collider col) { }
	// RVA: 0x16b34e0
	Dish GetSplattableDishOnRange() { }
	// RVA: 0x16b3af4
	bool IsSplattableDish(Dish _d) { }
	// RVA: 0x16b3c34
	void Splat(Dish splattableDish) { }
	// RVA: 0x16b3c94
	ItemId Explode() { }
	// RVA: 0x16b3cb8
	bool IsStraight() { }
	// RVA: 0x16b3e20
	void .ctor() { }
}

// TypeDefIndex: 5686
class SaveLoadFile
{
	string FILENAME;
	string AUTOSAVE_FILENAME;
	// property MainSavePath
	// property AutosavePath
	// RVA: 0x16b422c
	string get_MainSavePath() { }
	// RVA: 0x16b42cc
	string get_AutosavePath() { }
	// RVA: 0x16b436c
	void Save(SteamCloudPrefs steamCloudPrefs) { }
	// RVA: 0x16b4560
	void Autosave(SteamCloudPrefs steamCloudPrefs) { }
	// RVA: 0x16b4580
	SteamCloudPrefs Load(bool& previousDataFound) { }
	// RVA: 0x16b474c
	bool TryLoad(SteamCloudPrefs& data, System.DateTime& updatedUtc) { }
	// RVA: 0x16b4768
	void ReplaceMainAndAutosave(SteamCloudPrefs steamCloudPrefs) { }
	// RVA: 0x16b47d8
	void DeleteAllSaveData() { }
	// RVA: 0x16b465c
	bool TryLoad(SteamCloudPrefs& data, System.DateTime& updatedUtc, string& loadedPath) { }
	// RVA: 0x16b4828
	bool TryDeserialize(string path, SteamCloudPrefs& data) { }
	// RVA: 0x16b438c
	void Serialize(string path, SteamCloudPrefs data) { }
}

// TypeDefIndex: 5687
class SteamCloudPrefs
{
	string unlockables;
	string currentMissionId;
	string cardList;
	int currentCoins;
	int currentPerfectNormalBurgers;
	int totalPlaytime;
	int totalEarnedMoney;
	int totalWastedMoney;
	int lastGamemode;
	int adWatchCount;
	int adCoupons;
	long customerDoubleRewardEndUtc;
	int warehouseDoorHasBeenOpened;
	int hasCompletedTutorial;
	int hasClickedComment;
	// RVA: 0x16b4c38
	void .ctor() { }
}

// TypeDefIndex: 5688
class SaveManager.<>c
{
	SaveManager+<>c <>9;
	System.Func<string, bool> <>9__6_0;
	System.Func<string, bool> <>9__6_1;
	// RVA: 0x16b5920
	void .cctor() { }
	// RVA: 0x16b5988
	void .ctor() { }
	// RVA: 0x16b5990
	bool <CheckDeleteRequest>b__6_0(string f) { }
	// RVA: 0x16b5a18
	bool <CheckDeleteRequest>b__6_1(string d) { }
}

// TypeDefIndex: 5689
class SaveManager
{
	SaveManager instance;
	SteamCloudPrefs steamStorage;
	int tiempoParaAutosave;
	bool pendingSave;
	bool saving;
	// RVA: 0x16b4cbc
	void Awake() { }
	// RVA: 0x16b4d90
	void Autosave() { }
	// RVA: 0x16b4d54
	void LoadAll() { }
	// RVA: 0x16b4d98
	void CheckDeleteRequest() { }
	// RVA: 0x16b52b0
	void SaveNow() { }
	// RVA: 0x16b52cc
	void SaveData() { }
	// RVA: 0x16b5348
	void SaveDone() { }
	// RVA: 0x16b5074
	void DumpDataFromPrefsIfNoSaveData() { }
	// RVA: 0x16b535c
	string GetUnlockedAsStringListToDumpSaveData() { }
	// RVA: 0x16a7c3c
	void SaveNewValue(SaveableData saveableData, string _newValue) { }
	// RVA: 0x16b5618
	void SaveNewValue(SaveableData saveableData, int _newValue) { }
	// RVA: 0x16b56d0
	void SaveNewValue(SaveableData saveableData, long _newValue) { }
	// RVA: 0x16a7ea4
	void SaveNewValue(SaveableData saveableData, bool _newValue) { }
	// RVA: 0x16b56fc
	bool GetSavedUnlockable(Unlockable _unlockable) { }
	// RVA: 0x16b5574
	string GetSavedString(SaveableData saveableData) { }
	// RVA: 0x16b582c
	int GetSavedInt(SaveableData saveableData) { }
	// RVA: 0x16b58e4
	long GetSavedLong(SaveableData saveableData) { }
	// RVA: 0x16a632c
	bool GetSavedBool(SaveableData saveableData) { }
	// RVA: 0x16b5910
	void .ctor() { }
}

// TypeDefIndex: 5690
class SaveableData
{
	int value__;
	SaveableData CurrentMission;
	SaveableData Unlockables;
	SaveableData CurrentCoins;
	SaveableData CurrentPerfectNormalBurgers;
	SaveableData LastGamemode;
	SaveableData TotalPlaytime;
	SaveableData TotalEarnedMoney;
	SaveableData TotalWastedMoney;
	SaveableData WarehouseDoorBool;
	SaveableData HasCompletedTutorial;
	SaveableData HasClickedComment;
	SaveableData CardList;
	SaveableData AdWatchCount;
	SaveableData AdCoupons;
	SaveableData CustomerDoubleRewardEndUtc;
}

// TypeDefIndex: 5691
class ScoreDisplayer.ScoreErrors
{
	int value__;
	ScoreDisplayer+ScoreErrors None;
	ScoreDisplayer+ScoreErrors SteamDisconnected;
	ScoreDisplayer+ScoreErrors ServerUnreached;
	ScoreDisplayer+ScoreErrors OfflineMode;
	ScoreDisplayer+ScoreErrors UnknownError;
}

// TypeDefIndex: 5692
class ScoreDisplayer
{
	bool initialized;
	UnityEngine.Transform scoresParent;
	UnityEngine.GameObject screenGroup;
	SingleScoreDisplay[] singleScoreDisplays;
	UnityEngine.Transform midEllipsis;
	UnityEngine.Transform botEllipsis;
	TextController errorText;
	TextController gamemodeText;
	// RVA: 0x16b5aa0
	void Initialize() { }
	// RVA: 0x16b5b20
	void Start() { }
	// RVA: 0x16b65c8
	void OnDestroy() { }
	// RVA: 0x16b5ec8
	void OnScoreDataChange() { }
	// RVA: 0x16b5d88
	void SetScoresHeader() { }
	// RVA: 0x16b6914
	ScoreDisplayer+ScoreErrors DetectScoreErrors(DownloadedData dlData) { }
	// RVA: 0x16b68a4
	void CancelDisplayErrorOnDelay() { }
	// RVA: 0x16b6a08
	void DisplayErrorOnDelay() { }
	// RVA: 0x16b6804
	void EmptyAllScoreTexts() { }
	// RVA: 0x16b6a3c
	void .ctor() { }
}

// TypeDefIndex: 5693
class SingleScoreDisplay
{
	bool initialized;
	UnityEngine.Color highlightColor;
	UnityEngine.Color lowlightColor;
	TextController[] textControllers;
	UnityEngine.UI.Image[] playerIcons;
	UnityEngine.UI.Image shadedBg;
	// RVA: 0x16b6a44
	void Initialize() { }
	// RVA: 0x16b6b54
	void SetNewScore(DownloadedScore dlScore) { }
	// RVA: 0x16b6fb0
	int GetEnabledSiblingIndex() { }
	// RVA: 0x16b70f0
	void ClearScore() { }
	// RVA: 0x16b7114
	void .ctor() { }
}

// TypeDefIndex: 5694
class CustomerDataScriptable
{
	CustomerBreed customerBreed;
	System.Collections.Generic.List<DayTime> uniqueDayTimes;
	ItemId favSauce;
	UnityEngine.Mesh headModel;
	UnityEngine.Mesh bodyModel;
	UnityEngine.Mesh lArmModel;
	UnityEngine.Mesh rArmModel;
	UnityEngine.Mesh EyesM_Normal;
	UnityEngine.Mesh EyesM_Happy;
	UnityEngine.Mesh EyesM_Disappoint;
	UnityEngine.Mesh EyesF_Normal;
	UnityEngine.Mesh EyesF_Happy;
	UnityEngine.Mesh EyesF_Disappoint;
	UnityEngine.Sprite[] avatarIcons;
	// RVA: 0x16b7134
	void Initialize() { }
	// RVA: 0x16b7244
	bool IsOnValidDayTime(DayTime dayTimeToCheck) { }
	// RVA: 0x16b731c
	void .ctor() { }
}

// TypeDefIndex: 5695
class OutfitScriptable
{
	CustomerOutfit <outfit>k__BackingField;
	UnityEngine.GameObject headPrefab;
	UnityEngine.GameObject bodyPrefab;
	System.Collections.Generic.List<CustomerBreed> uncompatibleBreeds;
	System.Collections.Generic.List<CookingFail> cookingFailsToIgnore;
	System.Collections.Generic.List<DeliveryFail> deliveryFailsToIgnore;
	System.Collections.Generic.List<CriticalFail> criticalFailsToIgnore;
	System.Collections.Generic.List<GoodReview> goodReviewsToIgnore;
	// property outfit
	// RVA: 0x16b73a4
	CustomerOutfit get_outfit() { }
	// RVA: 0x16b73ac
	void set_outfit(CustomerOutfit value) { }
	// RVA: 0x16b73b4
	void Initialize() { }
	// RVA: 0x16b74c8
	bool IgnoresThisFail(CookingFail _fail) { }
	// RVA: 0x16b7520
	bool IgnoresThisFail(DeliveryFail _fail) { }
	// RVA: 0x16b7578
	bool IgnoresThisFail(CriticalFail _fail) { }
	// RVA: 0x16b75d0
	bool IgnoresThisGoodReview(GoodReview _goodReview) { }
	// RVA: 0x16b7628
	bool IsCompatibleBreed(CustomerBreed b) { }
	// RVA: 0x16b768c
	void .ctor() { }
}

// TypeDefIndex: 5696
class SeasonChangerItem
{
	GameSeason season;
	// RVA: 0x16b785c
	void Start() { }
	// RVA: 0x16b7910
	void Interact() { }
	// RVA: 0x16b7a14
	void ChangeSeason() { }
	// RVA: 0x16b7ac4
	void DLCPopUp() { }
	// RVA: 0x16b7b30
	void .ctor() { }
}

// TypeDefIndex: 5697
class SeasonModelSpawner.<>c__DisplayClass9_0
{
	System.Collections.Generic.List<UnityEngine.GameObject> itemsToEnable;
	// RVA: 0x16b8684
	void .ctor() { }
	// RVA: 0x16b8694
	bool <OnSeasonChange>b__0(UnityEngine.GameObject item) { }
}

// TypeDefIndex: 5698
class SeasonModelSpawner
{
	UnityEngine.GameObject[] normalProps;
	UnityEngine.GameObject halloweenInstantiablePrefab;
	UnityEngine.GameObject halloweenInstantedPack;
	UnityEngine.GameObject[] halloweenProps;
	UnityEngine.GameObject christmasInstantiablePrefab;
	UnityEngine.GameObject christmasInstantedPack;
	UnityEngine.GameObject[] christmasProps;
	// RVA: 0x16b7b38
	void Awake() { }
	// RVA: 0x16b7c38
	void OnDestroy() { }
	// RVA: 0x16b7d38
	void OnSeasonChange() { }
	// RVA: 0x16b868c
	void .ctor() { }
}

// TypeDefIndex: 5699
class ShoppingTablet
{
	UnityEngine.SpriteRenderer iconSpr;
	// property Interact_Left
	// property Interact_Right
	// RVA: 0x16b86ec
	void Awake() { }
	// RVA: 0x16b8818
	void HoverItem(bool on) { }
	// RVA: 0x16b875c
	void ShowShoppingIcon(bool show) { }
	// RVA: 0x16b8848
	void OpenShopMenu() { }
	// RVA: 0x16b889c
	void RightInteract() { }
	// RVA: 0x16b8934
	bool get_Interact_Left() { }
	// RVA: 0x16b893c
	bool get_Interact_Right() { }
	// RVA: 0x16b8944
	void .ctor() { }
}

// TypeDefIndex: 5700
class Sink
{
	Sink instance;
	System.Action callbackOnDishClean;
	UnityEngine.Transform dishSpawnpoint;
	UnityEngine.GameObject cleaningParticles;
	UnityEngine.ParticleSystem[] particles;
	int clickInteraction;
	bool isTurnedOn;
	bool cleaning;
	float cleaningTotalTime;
	float cleaningTimeMultWhenDishrackUnlocked;
	float cleaningTimeMult;
	float currentCleaningTime;
	AudioPlayer audioPlayer;
	UnityEngine.GameObject waterAreaTrigger;
	// RVA: 0x16b899c
	void Awake() { }
	// RVA: 0x16b8c4c
	void OnDestroy() { }
	// RVA: 0x16b8d7c
	void Interact() { }
	// RVA: 0x16b8e38
	void RightInteract() { }
	// RVA: 0x16b8ef4
	void Update() { }
	// RVA: 0x16b8fb0
	void HoverItem(bool on) { }
	// RVA: 0x16b8a98
	void TurnOn(bool on) { }
	// RVA: 0x16b8f60
	void CountCleaningTime() { }
	// RVA: 0x16b8ff8
	void CompleteCleaning() { }
	// RVA: 0x16b9208
	void Restore(bool isRestockStarting) { }
	// RVA: 0x16b9220
	void .ctor() { }
}

// TypeDefIndex: 5701
class SliderHandleDot
{
	bool initialized;
	UnityEngine.UI.Image img;
	UnityEngine.UI.Slider slider;
	// RVA: 0x16b9230
	void Start() { }
	// RVA: 0x16b9248
	void Initialize() { }
	// RVA: 0x16b944c
	void OnValueChanged(float _rawValue) { }
	// RVA: 0x16b94b0
	void .ctor() { }
}

// TypeDefIndex: 5702
class Smasher
{
	// RVA: 0x16b94b8
	void Awake() { }
	// RVA: 0x16b94d8
	void HoverItem(bool on) { }
	// RVA: 0x16b94e4
	void Grab() { }
	// RVA: 0x16b94ec
	void AttachToArea(InteractableArea _newArea) { }
	// RVA: 0x16b94f4
	void DetachFromCurrentArea() { }
	// RVA: 0x16b94fc
	void .ctor() { }
}

// TypeDefIndex: 5703
class SmashReceiver
{
	UnityEngine.Transform meatModel;
	DG.Tweening.Tween smashTween;
	System.Collections.Generic.List<Smasher> smashersOnUse;
	float timeToBeTotallySmashed;
	UnityEngine.Vector3 smashedSize;
	bool <isTotallySmashed>k__BackingField;
	// property isTotallySmashed
	// RVA: 0x16b9554
	bool get_isTotallySmashed() { }
	// RVA: 0x16b955c
	void set_isTotallySmashed(bool value) { }
	// RVA: 0x16b9568
	void OnEnable() { }
	// RVA: 0x16b9690
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x16b9850
	void OnTriggerExit(UnityEngine.Collider other) { }
	// RVA: 0x16b9994
	void SetAsTotallySmashed() { }
	// RVA: 0x16b99ac
	void .ctor() { }
	// RVA: 0x16b9a40
	void <OnTriggerEnter>b__10_0() { }
}

// TypeDefIndex: 5704
class SodaBigBottle
{
	float <fillAmount>k__BackingField;
	float totalTime;
	Liquid liquid;
	UnityEngine.Vector2 visualFillLimits;
	bool initializedLiquid;
	// property fillAmount
	// RVA: 0x16b9a58
	float get_fillAmount() { }
	// RVA: 0x16b9a60
	void set_fillAmount(float value) { }
	// RVA: 0x16b9a68
	void Awake() { }
	// RVA: 0x16b9c84
	void OnDestroy() { }
	// RVA: 0x16b9bfc
	void InitializeLiquid() { }
	// RVA: 0x16b9dcc
	float DecreaseFillAndReturnAmount() { }
	// RVA: 0x16b9d6c
	void UpdateLiquid() { }
	// RVA: 0x16b9e14
	void OnAttached(InteractableArea iArea) { }
	// RVA: 0x16b9e98
	void .ctor() { }
}

// TypeDefIndex: 5705
class SodaLever
{
	bool initializedLever;
	SodaMachine sodaMachine;
	string sodaStringName;
	bool <isTurnedOn>k__BackingField;
	AudioPlayer audioPlayer;
	// property isTurnedOn
	// RVA: 0x16b9f04
	bool get_isTurnedOn() { }
	// RVA: 0x16b9f0c
	void set_isTurnedOn(bool value) { }
	// RVA: 0x16b9f18
	void InitializeLever() { }
	// RVA: 0x16b9f8c
	void Awake() { }
	// RVA: 0x16ba224
	void OnDestroy() { }
	// RVA: 0x16ba354
	void Interact() { }
	// RVA: 0x16ba114
	void TurnOn(bool _on, bool _manual) { }
	// RVA: 0x16ba74c
	void RightInteract() { }
	// RVA: 0x16ba758
	void Restore(bool isRestockStarting) { }
	// RVA: 0x16ba774
	void .ctor() { }
}

// TypeDefIndex: 5706
class SodaMachine
{
	bool initialized;
	ItemId currentSpraying;
	SodaLever[] sodaLevers;
	Cup attachedCup;
	float totalFillTime;
	float kickValue;
	bool <isSpraying>k__BackingField;
	UnityEngine.Material streamMat;
	AudioPlayer audioPlayer;
	CupServingSlot cupServingSlot;
	float maxKickForce;
	SodaMachineDoor door;
	DG.Tweening.Sequence sodaStreamSeq;
	UnityEngine.Transform sodaStreamTop;
	UnityEngine.Transform sodaStreamBot;
	CounterArea bigBottleSlot;
	SodaBigBottle attachedBigBottle;
	bool pressed;
	bool bottle;
	bool closed;
	// property isSpraying
	// RVA: 0x16ba77c
	bool get_isSpraying() { }
	// RVA: 0x16ba784
	void set_isSpraying(bool value) { }
	// RVA: 0x16ba790
	void Awake() { }
	// RVA: 0x16ba794
	void Initialize() { }
	// RVA: 0x16bab10
	void OnDestroy() { }
	// RVA: 0x16babf4
	void Update() { }
	// RVA: 0x16babf8
	void AutoFill() { }
	// RVA: 0x16baed0
	void WasteBigBottle() { }
	// RVA: 0x16bacc4
	void KickCup(Cup _cup) { }
	// RVA: 0x16ba404
	void TurnOffAllLevers(SodaLever _exception) { }
	// RVA: 0x16ba4dc
	void UpdateSprayingSoda() { }
	// RVA: 0x16baf98
	void EnableSodaStream(bool _enable) { }
	// RVA: 0x16baa40
	void OnSodaBottleChange(GrabableItem _newItemOnBottleSlot) { }
	// RVA: 0x16bb1a4
	void .ctor() { }
	// RVA: 0x16bb1b4
	void <EnableSodaStream>b__32_0() { }
}

// TypeDefIndex: 5707
class SodaMachineDoor
{
	SodaMachine sodaMachine;
	float openedXAxis;
	bool isOpen;
	bool <isTotallyClosed>k__BackingField;
	UnityEngine.GameObject contentBlockers;
	UnityEngine.Transform doorAxis;
	DG.Tweening.Sequence doorTween;
	UnityEngine.BoxCollider boxCol;
	AudioPlayer audioPlayer;
	UnityEngine.BoxCollider bottleDetectorTrigger;
	// property isTotallyClosed
	// RVA: 0x16bb1e0
	bool get_isTotallyClosed() { }
	// RVA: 0x16bb1e8
	void set_isTotallyClosed(bool value) { }
	// RVA: 0x16bb1f4
	void Awake() { }
	// RVA: 0x16bb4a0
	void OnDestroy() { }
	// RVA: 0x16bb5d0
	void RightInteract() { }
	// RVA: 0x16bb5dc
	void Interact() { }
	// RVA: 0x16bb688
	void Open(bool _open) { }
	// RVA: 0x16bb8c4
	void RestoreState(bool isRestockStarting) { }
	// RVA: 0x16bb3e8
	void InstantClose() { }
	// RVA: 0x16bb8d8
	void .ctor() { }
	// RVA: 0x16bb8e0
	void <Open>b__17_0() { }
}

// TypeDefIndex: 5708
class SplashParticles
{
	// RVA: 0x16bb934
	void Initialize(ItemId _originalItem) { }
	// RVA: 0x16bba8c
	void SetParticlesColor(UnityEngine.Color _newColor) { }
	// RVA: 0x16bbd0c
	void .ctor() { }
}

// TypeDefIndex: 5709
class Splat.<AbsorbRoutine>d__11
{
	int <>1__state;
	object <>2__current;
	Splat <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16bc300
	void .ctor(int <>1__state) { }
	// RVA: 0x16bc8cc
	void System.IDisposable.Dispose() { }
	// RVA: 0x16bc8d0
	bool MoveNext() { }
	// RVA: 0x16bca48
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16bca50
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16bca88
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5710
class Splat
{
	bool isInsideKitchen;
	int splatsInKitchen;
	UnityEngine.Transform meshTr;
	UnityEngine.Material mat;
	UnityEngine.Color sauceColor;
	System.Collections.Generic.List<PaperSheet> papersOnArea;
	float splatPercentage;
	bool isAbsorbing;
	float absorbPercentageTic;
	// RVA: 0x16bbd14
	void OnDestroy() { }
	// RVA: 0x16bbe48
	void Initialize(ItemId _originalItem, bool _isInsideKitchen) { }
	// RVA: 0x16bc294
	System.Collections.IEnumerator AbsorbRoutine() { }
	// RVA: 0x16bc328
	void PapersOnAreaAbsorb() { }
	// RVA: 0x16bc4c8
	void ReduceSplatPercentage(float _amountToReduce) { }
	// RVA: 0x16bc060
	void SetColor(UnityEngine.Color _newColor) { }
	// RVA: 0x16bc15c
	void SpawnAnimation() { }
	// RVA: 0x16bc5d4
	void OnRestock(bool _restockStart) { }
	// RVA: 0x16bc640
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x16bc770
	void OnTriggerExit(UnityEngine.Collider other) { }
	// RVA: 0x16bc83c
	void .ctor() { }
}

// TypeDefIndex: 5711
class SteamBridge
{
	SteamBridge instance;
	string steamName;
	string steamId;
	bool hasHalloweenDLC;
	// RVA: 0x16bca90
	void Awake() { }
	// RVA: 0x16bcaac
	void PerformSingleton() { }
	// RVA: 0x16bcbec
	bool Accomplished(string AchievementID) { }
	// RVA: 0x16bcbf4
	void SetAchievement(string AchievementID) { }
	// RVA: 0x16bcc00
	void .ctor() { }
}

// TypeDefIndex: 5712
class SteamManager
{
	bool testMode;
	// property Initialized
	// RVA: 0x16bcbf8
	bool get_Initialized() { }
	// RVA: 0x16bcc08
	void .ctor() { }
}

// TypeDefIndex: 5713
class StoragedCheese
{
	UnityEngine.Mesh freshCheeseChunk;
	UnityEngine.Mesh staleCheeseChunk;
	bool nextCheeseWillBeStale;
	AudioPlayer audioPlayer;
	// RVA: 0x16bcc10
	void Awake() { }
	// RVA: 0x16bcca8
	void Start() { }
	// RVA: 0x16bcd98
	void OnDestroy() { }
	// RVA: 0x16bce94
	void Interact() { }
	// RVA: 0x16bd07c
	void StaleNextCheese() { }
	// RVA: 0x16bcecc
	void ResetStaleChance() { }
	// RVA: 0x16bd0dc
	void .ctor() { }
}

// TypeDefIndex: 5714
class StoragedItem.<>c__DisplayClass13_0
{
	StoragedItem <>4__this;
	System.Action callbackOnDestination;
	// RVA: 0x16bdb78
	void .ctor() { }
	// RVA: 0x16bdb80
	void <ReturnToOrigin>b__0() { }
}

// TypeDefIndex: 5715
class StoragedItem
{
	InteractableArea container;
	ItemId itemId;
	TransformData originalTransform;
	DG.Tweening.Sequence returningSequence;
	// RVA: 0x16bd0ec
	void AssignContainer(InteractableArea _container) { }
	// RVA: 0x16bcc8c
	void Awake() { }
	// RVA: 0x16bd0f4
	void InitializeOriginalTransform() { }
	// RVA: 0x16bd28c
	void HoverItem(bool on) { }
	// RVA: 0x16bcf48
	void Interact() { }
	// RVA: 0x16bd3ac
	void RightInteract() { }
	// RVA: 0x16bd380
	void InteractFromContainer() { }
	// RVA: 0x16bd3b0
	void ConvertIntoGrabbableItem() { }
	// RVA: 0x16bd7a8
	void SetNewContainer(InteractableArea newContainer) { }
	// RVA: 0x16bd7b0
	void ReturnToOrigin(UnityEngine.Transform from, float transitionTime, System.Action callbackOnDestination) { }
	// RVA: 0x16bd0e4
	void .ctor() { }
}

// TypeDefIndex: 5716
class TransformData
{
	UnityEngine.Vector3 localPos;
	UnityEngine.Quaternion localRot;
	UnityEngine.Vector3 localScale;
	// RVA: 0x16bd210
	void .ctor(UnityEngine.Vector3 _localPos, UnityEngine.Quaternion _localRot, UnityEngine.Vector3 _localScale) { }
}

// TypeDefIndex: 5717
class StoveArea
{
	UnityEngine.MeshRenderer stoveDarkCover;
	GrabableItem attachedItem;
	bool <isStoveOn>k__BackingField;
	AudioPlayer audioPlayer;
	// property isStoveOn
	// RVA: 0x16bdbc0
	bool get_isStoveOn() { }
	// RVA: 0x16bdbc8
	void set_isStoveOn(bool value) { }
	// RVA: 0x16bdbd4
	void Awake() { }
	// RVA: 0x16bdca8
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x16bde08
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x16bde0c
	void WithdrawItem(GrabableItem grabableItem) { }
	// RVA: 0x16bdec0
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x16bdf20
	void TurnOnStove(bool on) { }
	// RVA: 0x16bdf8c
	void .ctor() { }
}

// TypeDefIndex: 5718
class StoveButton
{
	int stoveIndex;
	StoveArea stoveArea;
	bool isTurnedOn;
	AudioPlayer audioPlayer;
	// RVA: 0x16bdf94
	void Awake() { }
	// RVA: 0x16be1f0
	void OnDestroy() { }
	// RVA: 0x16be320
	void Interact() { }
	// RVA: 0x16be110
	void TurnOn(bool on) { }
	// RVA: 0x16be3cc
	void RightInteract() { }
	// RVA: 0x16be3d8
	void Restore(bool isRestockStarting) { }
	// RVA: 0x16be3f0
	void .ctor() { }
}

// TypeDefIndex: 5719
class TextController
{
	string currentLangId;
	bool applyEllipsis;
	bool initialized;
	TMPro.TextMeshPro textWorld;
	TMPro.TextMeshProUGUI textUI;
	string currentRawString;
	string[] parameters;
	// RVA: 0x16be3f8
	void OnEnable() { }
	// RVA: 0x16be5bc
	void Start() { }
	// RVA: 0x16be6bc
	void OnDestroy() { }
	// RVA: 0x16be508
	void OnLanguageChange() { }
	// RVA: 0x16be410
	void Initialize() { }
	// RVA: 0x16be7ac
	void SetText(string _newLangId, string[] _parameters) { }
	// RVA: 0x16b6f30
	void SetGlobalText(string _newText) { }
	// RVA: 0x16bed6c
	void SetAsBold(bool _bold) { }
	// RVA: 0x16b6e3c
	void SetTextColor(UnityEngine.Color _color) { }
	// RVA: 0x16beb3c
	void UpdateText() { }
	// RVA: 0x16bee44
	void UpdateWithEllipsis() { }
	// RVA: 0x16bef3c
	string GetTextWithEllipsis(string text, float maxWidth) { }
	// RVA: 0x16bf074
	void .ctor() { }
}

// TypeDefIndex: 5720
class TextFitter
{
	float maxWidth;
	TMPro.TextMeshProUGUI text;
	UnityEngine.RectTransform slotRect;
	UnityEngine.RectTransform textRect;
	UnityEngine.UI.ContentSizeFitter textSizeFitter;
	PunchOnClick punchOnPopUp;
	// RVA: 0x16bf0d8
	void Awake() { }
	// RVA: 0x16bf230
	void SetText(string newText) { }
	// RVA: 0x16bf3d0
	void RebuildLayout() { }
	// RVA: 0x16bf43c
	void .ctor() { }
}

// TypeDefIndex: 5721
class TextTruncExt
{
	string updatedText;
	// RVA: 0x16bf444
	void OnPopulateMesh(UnityEngine.UI.VertexHelper toFill) { }
	// RVA: 0x16bf5d0
	void Update() { }
	// RVA: 0x16bf658
	void .ctor() { }
}

// TypeDefIndex: 5722
class TipCanvas
{
	float ShowDuration;
	float DisplayDuration;
	float HideDuration;
	TipCanvas instance;
	UnityEngine.RectTransform tipPanel;
	TMPro.TMP_Text tipText;
	UnityEngine.CanvasGroup tipCanvasGroup;
	DG.Tweening.Sequence tipTween;
	// RVA: 0x16bf6b8
	void Awake() { }
	// RVA: 0x16bf878
	void OnDestroy() { }
	// RVA: 0x16bf934
	void Show(string message) { }
	// RVA: 0x16bf7d4
	void SetPanelVisible(bool visible) { }
	// RVA: 0x16bfd74
	void .ctor() { }
	// RVA: 0x16bfd7c
	void <Show>b__10_0() { }
}

// TypeDefIndex: 5723
class Tomato
{
	UnityEngine.Mesh smashedTomatoMesh;
	int splashingCounter;
	int maxSplashes;
	// RVA: 0x16bfd84
	ItemId Explode() { }
	// RVA: 0x16bfdc8
	void ConvertToSmashedTomato() { }
	// RVA: 0x16bfe80
	void TryToRemoveSplatter() { }
	// RVA: 0x16bff3c
	void .ctor() { }
}

// TypeDefIndex: 5724
class TooltipHandler
{
	UnityEngine.GameObject tooltip;
	// RVA: 0x16bff94
	void OnEnable() { }
	// RVA: 0x16c001c
	void OnPointerEnter(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c01c8
	void OnPointerExit(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c0348
	void .ctor() { }
	// RVA: 0x16c0350
	void <OnPointerExit>b__3_0() { }
}

// TypeDefIndex: 5725
class Toothpick.<>c
{
	Toothpick+<>c <>9;
	System.Func<CustomerBreed, bool> <>9__8_0;
	// RVA: 0x16c0c2c
	void .cctor() { }
	// RVA: 0x16c0c94
	void .ctor() { }
	// RVA: 0x16c0c9c
	bool <SetRandomModel>b__8_0(CustomerBreed b) { }
}

// TypeDefIndex: 5726
class Toothpick
{
	CustomerBreed <assignedBreed>k__BackingField;
	System.Collections.Generic.Dictionary<CustomerBreed, System.Collections.Generic.List<CustomerBreed>> groupedBreeds;
	System.Collections.Generic.Dictionary<CustomerBreed, CustomerBreed> specialAdmitedToothpicks;
	// property assignedBreed
	// RVA: 0x16c0370
	CustomerBreed get_assignedBreed() { }
	// RVA: 0x16c0378
	void set_assignedBreed(CustomerBreed value) { }
	// RVA: 0x16c0380
	void Awake() { }
	// RVA: 0x16c0810
	void SetSpecificModelOrDestroy(CustomerBreed _customerBreed) { }
	// RVA: 0x16c03b0
	void SetRandomModel() { }
	// RVA: 0x16c0914
	CustomerBreed GetMainBreed(CustomerBreed _baseBreed) { }
	// RVA: 0x16c09b4
	bool IsCorrectToothpick(CustomerBreed _breed1, CustomerBreed _breed2) { }
	// RVA: 0x16c0a34
	void .ctor() { }
	// RVA: 0x16c0a94
	void .cctor() { }
}

// TypeDefIndex: 5727
class CamAreaDragCorner
{
	ScreenCorner corner;
	UnityEngine.Camera unfocusCam;
	UnityEngine.UI.Image img;
	bool isHovering;
	bool isDragging;
	bool isShowingIcon;
	// RVA: 0x16c0d30
	void Awake() { }
	// RVA: 0x16c0d9c
	void OnPointerEnter(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c0e30
	void OnDisable() { }
	// RVA: 0x16c0e38
	void OnPointerExit(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c0da8
	void UpdateFadeStatus() { }
	// RVA: 0x16c0e40
	void OnPointerDown(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c0eb4
	void OnDrag(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c1538
	bool TryGetIntersection(UnityEngine.Vector2 point1, UnityEngine.Vector2 direction1, UnityEngine.Vector2 point2, UnityEngine.Vector2 direction2, UnityEngine.Vector2& intersectionPoint) { }
	// RVA: 0x16c1648
	void OnPointerUp(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c173c
	void .ctor() { }
}

// TypeDefIndex: 5728
class ScreenCorner
{
	int value__;
	ScreenCorner BottomLeft;
	ScreenCorner TopLeft;
	ScreenCorner TopRight;
	ScreenCorner BottomRight;
}

// TypeDefIndex: 5729
class CamAreaDragNDrop
{
	CamAreaDragNDrop instance;
	UnityEngine.Camera unfocusCam;
	System.Action<bool> callbackOnDragChange;
	UnityEngine.Vector2 initialMousePos;
	UnityEngine.Vector2 initialCamPos;
	bool isDragging;
	// RVA: 0x16c1744
	void Awake() { }
	// RVA: 0x16c179c
	void OnPointerDown(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c1854
	void OnDrag(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c1a34
	void OnPointerUp(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16c1ac0
	void .ctor() { }
}

// TypeDefIndex: 5730
class DisplayChanger
{
	// RVA: 0x16c1ac8
	void .ctor() { }
}

// TypeDefIndex: 5731
class TabButtonShowUp
{
	// RVA: 0x16c1ad0
	void Start() { }
	// RVA: 0x16c1af4
	void OnDestroy() { }
	// RVA: 0x16c1bf4
	void OnAllowWindowModeChange(TransparentWindow+WindowOverlappingMode windowOverlappingMode) { }
	// RVA: 0x16c1c20
	void .ctor() { }
}

// TypeDefIndex: 5732
class TransparentWindow.WindowOverlappingMode
{
	int value__;
	TransparentWindow+WindowOverlappingMode Overlapping;
	TransparentWindow+WindowOverlappingMode Floating;
	TransparentWindow+WindowOverlappingMode None;
}

// TypeDefIndex: 5733
class TransparentWindow
{
	TransparentWindow instance;
	TransparentWindow+WindowOverlappingMode <windowOverlappingMode>k__BackingField;
	bool isTransparent;
	bool isHoveringWindow;
	UnityEngine.Camera unfocusCam;
	System.Action<bool> callbackOnWindowHoverChange;
	System.Action<TransparentWindow+WindowOverlappingMode> callbackOnAllowWindowModeChange;
	// property windowOverlappingMode
	// RVA: 0x16c1c28
	TransparentWindow+WindowOverlappingMode get_windowOverlappingMode() { }
	// RVA: 0x16c1c30
	void set_windowOverlappingMode(TransparentWindow+WindowOverlappingMode value) { }
	// RVA: 0x16c1c38
	void Awake() { }
	// RVA: 0x16c1e6c
	void Start() { }
	// RVA: 0x16c1f6c
	void OnDestroy() { }
	// RVA: 0x16c1d74
	void LoadAllowWindowMode() { }
	// RVA: 0x16c2104
	void SetAllowWindowMode(TransparentWindow+WindowOverlappingMode _windowOverlappingMode) { }
	// RVA: 0x16c1e54
	void SetTransparent(bool on) { }
	// RVA: 0x16c21c4
	void Update() { }
	// RVA: 0x16c2388
	void OnHoverWindowChange(bool isHovering) { }
	// RVA: 0x16c2238
	bool IsMouseInWindowizedArea() { }
	// RVA: 0x16c238c
	void WindowizeGame() { }
	// RVA: 0x16c2390
	void FlashWindow(bool on) { }
	// RVA: 0x16c2394
	void .ctor() { }
}

// TypeDefIndex: 5734
class CodeMonkeyUtils
{
	// RVA: 0x16c23a4
	UnityEngine.Vector3 GetMouseWorldPosition() { }
	// RVA: 0x16c2410
	UnityEngine.Vector3 GetMouseWorldPositionWithZ() { }
	// RVA: 0x16c2460
	UnityEngine.Vector3 GetMouseWorldPositionWithZ(UnityEngine.Camera worldCamera) { }
	// RVA: 0x16c23fc
	UnityEngine.Vector3 GetMouseWorldPositionWithZ(UnityEngine.Vector3 screenPosition, UnityEngine.Camera worldCamera) { }
	// RVA: 0x16c2488
	bool IsPointerOverUI() { }
}

// TypeDefIndex: 5735
class UIUnfocusCanvas
{
	UIUnfocusCanvas instance;
	UnityEngine.RectTransform upperBar;
	UnityEngine.UI.Image windowBorder;
	DG.Tweening.Sequence hoverSeq;
	bool isHovering;
	bool isDragging;
	bool isBorderEnabled;
	// RVA: 0x16c25cc
	void Awake() { }
	// RVA: 0x16c2624
	void OnEnable() { }
	// RVA: 0x16c2690
	void OnDisable() { }
	// RVA: 0x16c2698
	void Start() { }
	// RVA: 0x16c2798
	void OnDestroy() { }
	// RVA: 0x16c0ea8
	void OnDragChange(bool _isDragging) { }
	// RVA: 0x16c2684
	void OnHoverWindowChange(bool _isHovering) { }
	// RVA: 0x16c2898
	void UpdateBorderOnChange() { }
	// RVA: 0x16c29e0
	void PressMaximizeWindow() { }
	// RVA: 0x16c2a40
	void PressMinimizeWindow() { }
	// RVA: 0x16c2aa0
	void .ctor() { }
}

// TypeDefIndex: 5736
class UnfocusCamHover
{
	UnfocusCamHover instance;
	UnityEngine.Camera cam;
	UnityEngine.LayerMask layerMask;
	string interactableItemTag;
	UnityEngine.GameObject <objectOnHover>k__BackingField;
	InteractableItem itemOnHover;
	// property objectOnHover
	// RVA: 0x16c2aa8
	UnityEngine.GameObject get_objectOnHover() { }
	// RVA: 0x16c2ab0
	void set_objectOnHover(UnityEngine.GameObject value) { }
	// RVA: 0x16c2ab8
	void Awake() { }
	// RVA: 0x16c2b48
	void Update() { }
	// RVA: 0x16c2ce0
	void FixedUpdate() { }
	// RVA: 0x16c2dd0
	void DetectFrontal() { }
	// RVA: 0x16c2ee0
	void HoverObject(UnityEngine.GameObject newHover) { }
	// RVA: 0x16c2c58
	void ClickHoveredItem() { }
	// RVA: 0x16c3054
	void .ctor() { }
}

// TypeDefIndex: 5737
class WindowUIHoverArea
{
	bool isHovering;
	UIUnfocusCanvas uiUnfocusCanvas;
	float validHeightPercent;
	UnityEngine.Camera unfocusCam;
	// RVA: 0x16c305c
	void Start() { }
	// RVA: 0x16c3168
	void Update() { }
	// RVA: 0x16c31b4
	bool IsMouseInWindowizedArea() { }
	// RVA: 0x16c306c
	void HoverChange(bool _isHovering) { }
	// RVA: 0x16c32d0
	void .ctor() { }
}

// TypeDefIndex: 5738
class Trash
{
	UnityEngine.Transform punchVisuals;
	UnityEngine.Transform absorbingTransform;
	TrashCover trashCover;
	AudioPlayer audioPlayer;
	// RVA: 0x16c32e4
	void Awake() { }
	// RVA: 0x16c3358
	void WithdrawItem(StoragedItem withdrawedItem) { }
	// RVA: 0x16c335c
	bool ReceiveItem(GrabableItem receivedItem) { }
	// RVA: 0x16c34c8
	void OnItemAbsorbed(GrabableItem receivedItem) { }
	// RVA: 0x16c35bc
	void CanPlayTrashSoundAgain() { }
	// RVA: 0x16c35c0
	void PunchAnim(UnityEngine.Transform punchedTransform) { }
	// RVA: 0x16c3684
	bool HasFreeSlot(GrabableItem receivedItem) { }
	// RVA: 0x16c368c
	void .ctor() { }
}

// TypeDefIndex: 5739
class TrashCover
{
	bool <isOpen>k__BackingField;
	DG.Tweening.Tween tweenAnim;
	AudioPlayer audioPlayer;
	UnityEngine.BoxCollider trashTrigger;
	// property isOpen
	// RVA: 0x16c3694
	bool get_isOpen() { }
	// RVA: 0x16c369c
	void set_isOpen(bool value) { }
	// RVA: 0x16c36a8
	void Awake() { }
	// RVA: 0x16c3904
	void OnDestroy() { }
	// RVA: 0x16c3a34
	void Interact() { }
	// RVA: 0x16c3ae0
	void Open(bool _open) { }
	// RVA: 0x16c3d24
	void PushLightSwitch() { }
	// RVA: 0x16c3d78
	void RightInteract() { }
	// RVA: 0x16c3d84
	void Restore(bool isRestockStarting) { }
	// RVA: 0x16c3820
	void InstantClose() { }
	// RVA: 0x16c3d98
	void .ctor() { }
}

// TypeDefIndex: 5740
class UICoinManager.<>c__DisplayClass11_0
{
	UICoinManager <>4__this;
	int newCoinValue;
	// RVA: 0x16c43f0
	void .ctor() { }
	// RVA: 0x16c49dc
	void <UpdateCurrentCoinsText>b__2() { }
}

// TypeDefIndex: 5741
class UICoinManager.<>c__DisplayClass11_1
{
	int currentDisplayedCoinValue;
	UICoinManager+<>c__DisplayClass11_0 CS$<>8__locals1;
	// RVA: 0x16c444c
	void .ctor() { }
	// RVA: 0x16c4a1c
	int <UpdateCurrentCoinsText>b__0() { }
	// RVA: 0x16c4a24
	void <UpdateCurrentCoinsText>b__1(int x) { }
}

// TypeDefIndex: 5742
class UICoinManager
{
	UICoinManager instance;
	TMPro.TextMeshProUGUI coinText;
	TMPro.TextMeshProUGUI coinFadeText;
	DG.Tweening.Sequence numberAnim;
	DG.Tweening.Sequence fadeTextSeq;
	bool isFirstUpdate;
	DG.Tweening.Sequence redBlinkSeq;
	UnityEngine.Color defaultColor;
	// RVA: 0x16c3da0
	void Awake() { }
	// RVA: 0x16c3e50
	void Start() { }
	// RVA: 0x16c42f0
	void OnDestroy() { }
	// RVA: 0x16c3f74
	void UpdateCurrentCoinsText(int newCoinValue) { }
	// RVA: 0x16c4454
	void PlayCoinFadeText(int difference) { }
	// RVA: 0x16c43f8
	void KillMainNumAnimations() { }
	// RVA: 0x16c4434
	void KillAddedNumAnimations() { }
	// RVA: 0x16c4820
	void PlayCoinRedBlink() { }
	// RVA: 0x16c49c4
	void .ctor() { }
}

// TypeDefIndex: 5743
class UIExtraMealCanvas.<>c__DisplayClass44_0
{
	UIExtraMealCanvas <>4__this;
	AdRewardType rewardType;
	// RVA: 0x16c6c00
	void .ctor() { }
	// RVA: 0x16c7268
	void <ClaimReward>b__0() { }
}

// TypeDefIndex: 5744
class UIExtraMealCanvas
{
	float TransitionTime;
	float BackgroundOpacity;
	float AdFreeRewardCooldownSeconds;
	UIExtraMealCanvas instance;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupPanel;
	UnityEngine.Canvas popupCanvas;
	UnityEngine.RectTransform progressNode;
	UnityEngine.Vector2 progressStartPosition;
	UnityEngine.Vector2 progressEndPosition;
	TMPro.TMP_Text progressText;
	TextController freeAdText;
	TMPro.TMP_Text adCouponCountText;
	UnityEngine.UI.Button closeButton;
	UnityEngine.UI.Button adCouponButton;
	UnityEngine.UI.Button customerDoubleRewardButton;
	UnityEngine.UI.Button instantKitchenRestockButton;
	UnityEngine.UI.Button redeemAdCouponButton;
	UnityEngine.GameObject[] rewardAdPlayIcons;
	UnityEngine.RectTransform[] rewardButtonTexts;
	bool <IsOnScreen>k__BackingField;
	DG.Tweening.Sequence panelTween;
	bool rewardInProgress;
	float nextAdFreeRewardTime;
	UnityEngine.Vector2[] rewardButtonTextPositions;
	TMPro.TMP_Text customerDoubleRewardText;
	bool lastDoubleRewardActive;
	int lastDoubleRewardRemainingSeconds;
	// property IsOnScreen
	// RVA: 0x16c4acc
	bool get_IsOnScreen() { }
	// RVA: 0x16c4ad4
	void set_IsOnScreen(bool value) { }
	// RVA: 0x16c4ae0
	void Awake() { }
	// RVA: 0x16c4e80
	void Start() { }
	// RVA: 0x16c5784
	void OnEnable() { }
	// RVA: 0x16c5804
	void OnDisable() { }
	// RVA: 0x16c5884
	void OnDestroy() { }
	// RVA: 0x16c526c
	void OnActiveCameraChange(UnityEngine.Camera newCamera) { }
	// RVA: 0x16c5ca4
	void Update() { }
	// RVA: 0x16c64d0
	void DisplayExtraMeal() { }
	// RVA: 0x16c5d48
	void PressCloseExtraMeal() { }
	// RVA: 0x16c6840
	void PressAdCoupon() { }
	// RVA: 0x16c6b18
	void PressCustomerDoubleReward() { }
	// RVA: 0x16c6b20
	void PressInstantKitchenRestock() { }
	// RVA: 0x16c6b28
	void PressRedeemAdCoupon() { }
	// RVA: 0x16c6848
	void ClaimReward(AdRewardType rewardType) { }
	// RVA: 0x16c6c08
	void ShowAdFreeRewardCooldownToast() { }
	// RVA: 0x16c7060
	void CompleteRewardedClaim(AdRewardType rewardType) { }
	// RVA: 0x16c7040
	void CancelRewardedClaim() { }
	// RVA: 0x16c5410
	void RefreshView() { }
	// RVA: 0x16c6f30
	void SetRewardButtonsInteractable(bool interactable) { }
	// RVA: 0x16c6050
	void RefreshCustomerDoubleRewardButton() { }
	// RVA: 0x16c4d94
	void EnablePanels(bool enabled) { }
	// RVA: 0x16c4c60
	void CacheRewardButtonTextPositions() { }
	// RVA: 0x16c70a0
	void RefreshAdFreeButtonVisuals() { }
	// RVA: 0x16c7250
	void .ctor() { }
	// RVA: 0x16c7260
	void <PressCloseExtraMeal>b__39_0() { }
}

// TypeDefIndex: 5745
class InsufficientResource
{
	int value__;
	InsufficientResource AdCoupon;
	InsufficientResource Coins;
}

// TypeDefIndex: 5746
class UIExtraMealSmallCanvas
{
	float TransitionTime;
	float BackgroundOpacity;
	UIExtraMealSmallCanvas instance;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupPanel;
	UnityEngine.Canvas popupCanvas;
	TextController descriptionText;
	UnityEngine.UI.Button closeButton;
	UnityEngine.UI.Button goGetButton;
	bool <IsOnScreen>k__BackingField;
	DG.Tweening.Sequence panelTween;
	System.Action closeSourceOnGoGet;
	// property IsOnScreen
	// RVA: 0x16c7288
	bool get_IsOnScreen() { }
	// RVA: 0x16c7290
	void set_IsOnScreen(bool value) { }
	// RVA: 0x16c729c
	void Awake() { }
	// RVA: 0x16c7500
	void Start() { }
	// RVA: 0x16c78a8
	void OnDestroy() { }
	// RVA: 0x16c7bd8
	void Update() { }
	// RVA: 0x16c6bf4
	void Display() { }
	// RVA: 0x16c7f98
	void Display(InsufficientResource insufficientResource) { }
	// RVA: 0x16c7fa0
	void Display(InsufficientResource insufficientResource, System.Action closeSource) { }
	// RVA: 0x16c8330
	void SetDescription(InsufficientResource insufficientResource) { }
	// RVA: 0x16c7c80
	void PressClose() { }
	// RVA: 0x16c83f8
	void PressGoGet() { }
	// RVA: 0x16c7764
	void OnActiveCameraChange(UnityEngine.Camera newCamera) { }
	// RVA: 0x16c7414
	void EnablePanels(bool enabled) { }
	// RVA: 0x16c84e0
	void .ctor() { }
	// RVA: 0x16c84e8
	void <PressClose>b__23_0() { }
}

// TypeDefIndex: 5747
class UIOptionsInGame.<AdjustSoundPanelPositionAfterLayout>d__73
{
	int <>1__state;
	object <>2__current;
	UIOptionsInGame <>4__this;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16ca430
	void .ctor(int <>1__state) { }
	// RVA: 0x16cc8e0
	void System.IDisposable.Dispose() { }
	// RVA: 0x16cc8e4
	bool MoveNext() { }
	// RVA: 0x16cca88
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16cca90
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16ccac8
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5748
class UIOptionsInGame
{
	UIOptionsInGame instance;
	float transitionTime;
	float bgOpacity;
	UnityEngine.UI.Image optionsBg;
	UnityEngine.UI.Image optionsHeader;
	UnityEngine.RectTransform optionsPanel;
	DG.Tweening.Sequence optionsPanelTween;
	DG.Tweening.Sequence adCouponRedBlinkSeq;
	UnityEngine.Canvas canvas;
	UnityEngine.Color adCouponDefaultColor;
	UnityEngine.GameObject tutorialGamemodePanel;
	UnityEngine.UI.Slider tutorialPercentSlider;
	TextController tutorialProgressText;
	UnityEngine.GameObject practiceGamemodePanel;
	UnityEngine.GameObject normalGamemodePanel;
	TextController normalModeRemainingTimeText;
	UnityEngine.GameObject pomodoroGamemodePanel;
	UnityEngine.GameObject startPomodoroButton;
	UnityEngine.GameObject stopPomodoroButton;
	UnityEngine.GameObject pausePomodoroButton;
	UnityEngine.GameObject continuePomodoroButton;
	UnityEngine.UI.Slider pomodoroTimeSlider;
	TextController pomodoroTimeText;
	TextController pomoModeRemainingTimeText;
	UnityEngine.RectTransform graphicsPanel;
	UnityEngine.GameObject[] windowModeFilledLabels;
	UnityEngine.GameObject[] windowModeClearLabels;
	UnityEngine.UI.Toggle vSyncToggle;
	UnityEngine.GameObject vSyncToggleBorder;
	UnityEngine.GameObject fpsSelectorGroup;
	UnityEngine.GameObject[] fpsFilledLabels;
	UnityEngine.GameObject[] fpsClearLabels;
	UnityEngine.UI.Slider fovSensitivitySlider;
	UnityEngine.UI.Slider mouseSensitivitySlider;
	UnityEngine.UI.Toggle invertedMouseToggle;
	UnityEngine.GameObject invertedMouseToggleBorder;
	UnityEngine.UI.Toggle motionFloorToogle;
	UnityEngine.GameObject motionFloorToogleBorder;
	UnityEngine.RectTransform controlsPanel;
	UnityEngine.GameObject soundPanel;
	UnityEngine.UI.Slider musicVolumeSlider;
	UnityEngine.UI.Slider sfxVolumeSlider;
	UnityEngine.UI.Slider ambienceVolumeSlider;
	UnityEngine.UI.Toggle musicSoundsOnBg;
	UnityEngine.UI.Toggle sfxSoundsOnBg;
	UnityEngine.UI.Toggle ambienceSoundsOnBg;
	float soundPanelVerticalOffset;
	UnityEngine.Coroutine soundPanelPositionRoutine;
	UnityEngine.GameObject langPanel;
	UnityEngine.GameObject[] langFilledLabels;
	UnityEngine.GameObject[] langClearLabels;
	TextController adCouponCountText;
	UnityEngine.GameObject extraMealButton;
	TMPro.TMP_Text versionText;
	UnityEngine.UI.Button versionButton;
	UnityEngine.GameObject redeemCodeButton;
	// RVA: 0x16c84f0
	void Awake() { }
	// RVA: 0x16c8934
	void Start() { }
	// RVA: 0x16c9180
	void OnDestroy() { }
	// RVA: 0x16c9514
	void OnAdRewardStateChanged() { }
	// RVA: 0x16c9518
	void OnMarsSdkStateChanged(MarsSdkState state) { }
	// RVA: 0x16c9084
	void RefreshRedeemCodeButtonVisibility() { }
	// RVA: 0x16c8d4c
	void RefreshAdCouponCount() { }
	// RVA: 0x16c9528
	void PlayAdCouponRedBlink() { }
	// RVA: 0x16c9770
	void PressOpenExtraMeal() { }
	// RVA: 0x16c9c2c
	void OnActiveCameraChange(UnityEngine.Camera _newCam) { }
	// RVA: 0x16c9d28
	void PressOpenOptions() { }
	// RVA: 0x16ca098
	void PressUpdateVersion() { }
	// RVA: 0x16c8f28
	void RefreshVersionText() { }
	// RVA: 0x16c98d4
	void PressCloseOptions() { }
	// RVA: 0x16c8740
	void EnablePanels(bool on) { }
	// RVA: 0x16ca300
	void CollapseSubpanels() { }
	// RVA: 0x16ca3a8
	UnityEngine.Coroutine StopSoundPanelPositionAdjustment(UnityEngine.Coroutine routine) { }
	// RVA: 0x16ca3c4
	System.Collections.IEnumerator AdjustSoundPanelPositionAfterLayout() { }
	// RVA: 0x16ca458
	void PressGamemodeButton(int gamemodeIndex) { }
	// RVA: 0x16ca14c
	void ChangeGamemodePanel(Gamemode newGamemode) { }
	// RVA: 0x16ca4cc
	void OnMissionChange() { }
	// RVA: 0x16c8e30
	void RefreshExtraMealButtonVisibility() { }
	// RVA: 0x16ca680
	void UpdateRemainingTime(Gamemode _gamemode, System.ValueTuple<string, string[]> values) { }
	// RVA: 0x16c882c
	void OnPomodoroSlideValueChange() { }
	// RVA: 0x16ca6c0
	int GetTimeFromPomoSlider() { }
	// RVA: 0x16ca700
	void PressStartPomodoroTimer() { }
	// RVA: 0x16ca7ec
	void PressStopPomodoroTimer() { }
	// RVA: 0x16ca888
	void PressPausePomodoroTimer() { }
	// RVA: 0x16ca914
	void PressContinuePomodoroTimer() { }
	// RVA: 0x16ca9a0
	void OnPomodoroTimerComplete() { }
	// RVA: 0x16ca79c
	void EnableStartPomodoroButton(bool on) { }
	// RVA: 0x16caa70
	void EnablePomodoroContinueButtons() { }
	// RVA: 0x16cab54
	void OnFenceChange(bool fenceOpen) { }
	// RVA: 0x16cab58
	void PressGraphicsHeader() { }
	// RVA: 0x16cac40
	void UpdateGraphicsUIInfo() { }
	// RVA: 0x16cb2dc
	void OnVsyncToggle() { }
	// RVA: 0x16cb3bc
	void PressWindowModeSelectable(int windowModeIndex) { }
	// RVA: 0x16cb4e8
	void SetWindowMode(TransparentWindow+WindowOverlappingMode _newWindowMode) { }
	// RVA: 0x16cae98
	void HighlightCurrentWindowModeItem() { }
	// RVA: 0x16caf84
	void DisplayFpsSelectables(bool show) { }
	// RVA: 0x16cb544
	void PressFpsSelectable(int fpsIndex) { }
	// RVA: 0x16caffc
	void HighlightCurrentFpsItem() { }
	// RVA: 0x16cb810
	void OnFovSlideValueChange() { }
	// RVA: 0x16cb8e0
	void OnMouseSlideValueChange() { }
	// RVA: 0x16cb9e4
	void OnInvertMouseToggle() { }
	// RVA: 0x16cba98
	void PressToggleMotionFloor() { }
	// RVA: 0x16cbbdc
	void ApplySoundToSliders() { }
	// RVA: 0x16cbd78
	void PressControlsHeader() { }
	// RVA: 0x16cbe8c
	void PressSoundHeader() { }
	// RVA: 0x16cbf78
	void OnMusicSliderChange() { }
	// RVA: 0x16cc034
	void OnSfxSliderChange() { }
	// RVA: 0x16cc0f0
	void OnAmbienceSliderChange() { }
	// RVA: 0x16cc1ac
	void PressMusicBgToggle() { }
	// RVA: 0x16cc264
	void PressSfxBgToggle() { }
	// RVA: 0x16cc31c
	void PressAmbienceBgToggle() { }
	// RVA: 0x16cc3d4
	void PressChangeMusicTheme(bool _next) { }
	// RVA: 0x16cc478
	void PressLangHeader() { }
	// RVA: 0x16cc610
	void PressLangItem(string langId) { }
	// RVA: 0x16cc53c
	void HighlightCurrentLangItem() { }
	// RVA: 0x16cc6b4
	void PressCreditsHeader() { }
	// RVA: 0x16cc79c
	void PressExitGame() { }
	// RVA: 0x16cc8d0
	void .ctor() { }
	// RVA: 0x16cc8d8
	void <PressCloseOptions>b__69_0() { }
}

// TypeDefIndex: 5749
class UIPopUpCloser
{
	UIPopUpCloser instance;
	System.Collections.Generic.List<System.Action> escapeListeners;
	// RVA: 0x16ccad0
	void Awake() { }
	// RVA: 0x16ccb28
	void PressEscape() { }
	// RVA: 0x16ccbb4
	void AddEscapeListener(System.Action _method) { }
	// RVA: 0x16ccc48
	void RemoveEscapeListener(System.Action _method) { }
	// RVA: 0x16ccca0
	void .ctor() { }
}

// TypeDefIndex: 5750
class UIPurchaseHalloweenDLC
{
	UIPurchaseHalloweenDLC instance;
	UnityEngine.RectTransform bgPanel;
	// RVA: 0x16ccd28
	void Awake() { }
	// RVA: 0x16ccdd0
	void Start() { }
	// RVA: 0x16cced0
	void OnDestroy() { }
	// RVA: 0x16ccd9c
	void OnActiveCameraChange(UnityEngine.Camera _newCam) { }
	// RVA: 0x16cd0b8
	void DisplayPopUp() { }
	// RVA: 0x16cd1d4
	void PressApply() { }
	// RVA: 0x16cd270
	void PressCancelPopUp() { }
	// RVA: 0x16ccfd0
	void CancelPopUp() { }
	// RVA: 0x16ccda0
	void EnablePanels(bool _on) { }
	// RVA: 0x16cd2d4
	void .ctor() { }
}

// TypeDefIndex: 5751
class UIResetCanvas
{
	float TransitionTime;
	float BackgroundOpacity;
	UIResetCanvas instance;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupPanel;
	UnityEngine.Canvas popupCanvas;
	UnityEngine.UI.Button closeButton;
	UnityEngine.UI.Button resetButton;
	TMPro.TMP_Text adProgressText;
	bool <IsOnScreen>k__BackingField;
	DG.Tweening.Sequence panelTween;
	// property IsOnScreen
	// RVA: 0x16cd2dc
	bool get_IsOnScreen() { }
	// RVA: 0x16cd2e4
	void set_IsOnScreen(bool value) { }
	// RVA: 0x16cd2f0
	void Awake() { }
	// RVA: 0x16cd4b8
	void Start() { }
	// RVA: 0x16cd860
	void OnEnable() { }
	// RVA: 0x16cd8e0
	void OnDisable() { }
	// RVA: 0x16cd960
	void OnDestroy() { }
	// RVA: 0x16cdcd4
	void Update() { }
	// RVA: 0x16ce080
	void Display() { }
	// RVA: 0x16cdd7c
	void PressClose() { }
	// RVA: 0x16ce528
	void PressReset() { }
	// RVA: 0x16ce3ec
	void RefreshView() { }
	// RVA: 0x16cd71c
	void OnActiveCameraChange(UnityEngine.Camera newCamera) { }
	// RVA: 0x16cd3cc
	void EnablePanels(bool enabled) { }
	// RVA: 0x16ce99c
	void .ctor() { }
	// RVA: 0x16ce9a4
	void <PressClose>b__21_0() { }
}

// TypeDefIndex: 5752
class UIResetComfirmCanvas
{
	float TransitionTime;
	float BackgroundOpacity;
	UIResetComfirmCanvas instance;
	UnityEngine.UI.Image popupBackground;
	UnityEngine.RectTransform popupPanel;
	UnityEngine.Canvas popupCanvas;
	UnityEngine.UI.Button closeButton;
	UnityEngine.UI.Button confirmButton;
	RestockButton resetBox;
	bool <IsOnScreen>k__BackingField;
	DG.Tweening.Sequence panelTween;
	UIResetCanvas resetCanvas;
	// property IsOnScreen
	// RVA: 0x16ce9ac
	bool get_IsOnScreen() { }
	// RVA: 0x16ce9b4
	void set_IsOnScreen(bool value) { }
	// RVA: 0x16ce9c0
	void Awake() { }
	// RVA: 0x16ceb88
	void Start() { }
	// RVA: 0x16cef30
	void OnDestroy() { }
	// RVA: 0x16cf25c
	void Update() { }
	// RVA: 0x16ce61c
	void Display(UIResetCanvas owner) { }
	// RVA: 0x16cf304
	void PressClose() { }
	// RVA: 0x16cf608
	void PressConfirm() { }
	// RVA: 0x16cedec
	void OnActiveCameraChange(UnityEngine.Camera newCamera) { }
	// RVA: 0x16cea9c
	void EnablePanels(bool enabled) { }
	// RVA: 0x16cf64c
	void .ctor() { }
	// RVA: 0x16cf654
	void <PressClose>b__20_0() { }
}

// TypeDefIndex: 5753
class UIRestock.<>c
{
	UIRestock+<>c <>9;
	DG.Tweening.TweenCallback <>9__6_0;
	// RVA: 0x16cfb00
	void .cctor() { }
	// RVA: 0x16cfb68
	void .ctor() { }
	// RVA: 0x16cfb70
	void <DisplayRestockScreen>b__6_0() { }
}

// TypeDefIndex: 5754
class UIRestock
{
	UIRestock instance;
	UnityEngine.CanvasGroup panel;
	DG.Tweening.Sequence shadingSeq;
	UnityEngine.RectTransform icons;
	System.Action<bool> callbackOnRestockScreen;
	// RVA: 0x16cf65c
	void Awake() { }
	// RVA: 0x16cf704
	void DisplayRestockScreen(bool on) { }
	// RVA: 0x16cf6fc
	void EndRestocking() { }
	// RVA: 0x16cfacc
	void .ctor() { }
	// RVA: 0x16cfad4
	void <DisplayRestockScreen>b__6_1() { }
}

// TypeDefIndex: 5755
class UIReviewPanel
{
	float transitionTime;
	float bgOpacity;
	UIReviewPanel instance;
	bool <isReviewOnScreen>k__BackingField;
	int <LastShownStars>k__BackingField;
	UnityEngine.UI.Image customerAvatar;
	UnityEngine.UI.Image reviewBg;
	UnityEngine.RectTransform reviewPanel;
	TextController usernameText;
	TextController reviewText;
	TextController globalScoreText;
	DG.Tweening.Sequence panelTween;
	UnityEngine.Canvas canvas;
	UnityEngine.Transform headerStarsParent;
	UnityEngine.RectTransform[] headerStars;
	UnityEngine.UI.Image[] headerStarsImg;
	DG.Tweening.Sequence headerStarsSeq;
	UnityEngine.Transform shadedStarsParent;
	UnityEngine.RectTransform[] shadedStars;
	UnityEngine.Sprite starIcon;
	UnityEngine.Sprite toothpickIcon;
	System.Action<bool> callbackOnReviewPopUp;
	UnityEngine.Color[] iconColors;
	// property isReviewOnScreen
	// property LastShownStars
	// RVA: 0x16cfbc4
	bool get_isReviewOnScreen() { }
	// RVA: 0x16cfbcc
	void set_isReviewOnScreen(bool value) { }
	// RVA: 0x16cfbd8
	int get_LastShownStars() { }
	// RVA: 0x16cfbe0
	void set_LastShownStars(int value) { }
	// RVA: 0x16cfbe8
	void Awake() { }
	// RVA: 0x16cfef0
	void Start() { }
	// RVA: 0x16d0058
	void OnDestroy() { }
	// RVA: 0x16cfdf8
	void OnActiveCameraChange(UnityEngine.Camera _newCam) { }
	// RVA: 0x16d0158
	int CalculateRoundedReviewScore(float remainingTime, BadReviewManager badReviews) { }
	// RVA: 0x16d0200
	void DisplayReview(CustomerController customer, float remainingTime, BadReviewManager badReviews) { }
	// RVA: 0x16d07b8
	void Check5StarsAchievement(CustomerController customer) { }
	// RVA: 0x16d096c
	void Check5StarsSpecialCustomerAchievement(CustomerController customer) { }
	// RVA: 0x16d0b34
	void CountNormal5StarBurgersForAchievement(CustomerController customer) { }
	// RVA: 0x16d0c54
	void DisplayHeaderStars(int _currentStars, bool _toothpickSolvedAnything) { }
	// RVA: 0x16d1020
	void PressCloseReviewPanel() { }
	// RVA: 0x16cfffc
	void EnablePanels(bool on) { }
	// RVA: 0x16d12f8
	void .ctor() { }
	// RVA: 0x16d13f4
	void <PressCloseReviewPanel>b__39_0() { }
}

// TypeDefIndex: 5756
class UIShopButton
{
	bool scaleOnHover;
	UnityEngine.Events.UnityEvent OnClick;
	DG.Tweening.Tween scaleTween;
	// RVA: 0x16d13fc
	void OnEnable() { }
	// RVA: 0x16d1528
	void OnPointerEnter(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d1530
	void OnPointerExit(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d1538
	void OnPointerClick(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d1404
	void ScaleOnHover(bool sizeUp) { }
	// RVA: 0x16d154c
	void .ctor() { }
}

// TypeDefIndex: 5757
class UIShopCanvas
{
	float transitionTime;
	float bgOpacity;
	UIShopCanvas instance;
	bool <isShopOnScreen>k__BackingField;
	UnityEngine.RectTransform shopPanel;
	UnityEngine.UI.Image shopBg;
	UnityEngine.GameObject[] shopMenus;
	DG.Tweening.Sequence panelTween;
	System.Action<bool> callbackOnShopPopUp;
	// property isShopOnScreen
	// RVA: 0x16d1554
	bool get_isShopOnScreen() { }
	// RVA: 0x16d155c
	void set_isShopOnScreen(bool value) { }
	// RVA: 0x16d1568
	void Awake() { }
	// RVA: 0x16d1670
	void Start() { }
	// RVA: 0x16d18a4
	void OnDestroy() { }
	// RVA: 0x16d15d0
	void OnActiveCameraChange(UnityEngine.Camera _newCam) { }
	// RVA: 0x16d1d48
	void OnReviewPopUp(bool reviewIsOnScreen) { }
	// RVA: 0x16d1d54
	void DisplayShop() { }
	// RVA: 0x16d1a70
	void PressCloseShopPanel() { }
	// RVA: 0x16d1848
	void EnablePanels(bool on) { }
	// RVA: 0x16d2098
	void PressGoShopMenu(int menuIndex) { }
	// RVA: 0x16d202c
	void GoShopMenu(int menuIndex) { }
	// RVA: 0x16d2114
	void .ctor() { }
	// RVA: 0x16d211c
	void <PressCloseShopPanel>b__18_0() { }
}

// TypeDefIndex: 5758
class UIShopGuideButton
{
	DG.Tweening.Tween scaleTween;
	// RVA: 0x16d2124
	void OnEnable() { }
	// RVA: 0x16d2274
	void OnPointerEnter(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d227c
	void OnPointerExit(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d2284
	void OnPointerClick(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d2158
	void SizeUp(bool sizeUp) { }
	// RVA: 0x16d2330
	void .ctor() { }
}

// TypeDefIndex: 5759
class UIShopItem.PurchaseCurrency
{
	int value__;
	UIShopItem+PurchaseCurrency Coins;
	UIShopItem+PurchaseCurrency AdCoupons;
}

// TypeDefIndex: 5760
class UIShopItem
{
	int price;
	UIShopItem+PurchaseCurrency currency;
	int adCouponCost;
	TMPro.TMP_SpriteAsset adCouponSpriteAsset;
	bool isPurchaseable;
	bool initialized;
	Unlockable unlockableId;
	UnityEngine.Color greenTagColor;
	UnityEngine.Color redTagColor;
	UnityEngine.UI.Image priceTag;
	UnityEngine.GameObject checkIcon;
	DG.Tweening.Sequence tagColorSeq;
	DG.Tweening.Tween scaleTween;
	UnityEngine.CanvasGroup canvasGroup;
	UnityEngine.UI.Shadow shadow;
	// RVA: 0x16d2338
	void OnPointerEnter(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d246c
	void OnPointerExit(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d2474
	void OnPointerClick(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d2b58
	void CloseShopForResource() { }
	// RVA: 0x16d268c
	bool CanAfford() { }
	// RVA: 0x16d29a0
	void ConsumeCost() { }
	// RVA: 0x16d2710
	void RedTagFlash() { }
	// RVA: 0x16d2340
	void SizeUpPriceTag(bool sizeUp) { }
	// RVA: 0x16d2ca0
	void Start() { }
	// RVA: 0x16d30a0
	void OnDestroy() { }
	// RVA: 0x16d2da0
	void Initialize() { }
	// RVA: 0x16d3190
	void OnEnable() { }
	// RVA: 0x16d2f6c
	void OnUnlockableChange() { }
	// RVA: 0x16d3214
	void .ctor() { }
}

// TypeDefIndex: 5761
class UnlockableSystem
{
	UnlockableSystem instance;
	System.Collections.Generic.HashSet<Unlockable> unlockedItems;
	System.Action callbackOnUnlockableChange;
	System.Action<Unlockable> callbackOnSpecificUnlockableChange;
	System.Action callbackOnHasUnlockedEverything;
	int _currentCoins;
	System.Action<int> callbackOnCoinUpdate;
	// property currentCoins
	// RVA: 0x16d3240
	int get_currentCoins() { }
	// RVA: 0x16d3248
	void set_currentCoins(int value) { }
	// RVA: 0x16d3274
	void Awake() { }
	// RVA: 0x16d34f4
	void AddCoins(int _coinsToAdd) { }
	// RVA: 0x16d2bb0
	void SustractCoins(int _coinsToRemove) { }
	// RVA: 0x16d367c
	void ResetCoins() { }
	// RVA: 0x16d333c
	void LoadCurrentUnlocks() { }
	// RVA: 0x16d3710
	void LockItem(Unlockable _unlockableId) { }
	// RVA: 0x16d2a18
	void UnlockItem(Unlockable _unlockableId) { }
	// RVA: 0x16d39b0
	void AddExtraUnlocksWhenUnlockingSomething(Unlockable _baseUnlockable) { }
	// RVA: 0x16d31bc
	bool IsUnlocked(Unlockable _unlockableId) { }
	// RVA: 0x16d39c4
	int GetDecoCount() { }
	// RVA: 0x16d39cc
	bool IsIngredientUnlocked(ItemId _itemId) { }
	// RVA: 0x16d3bdc
	bool IsAnySauceUnlocked() { }
	// RVA: 0x16d3864
	bool HasUnlockedEverything() { }
	// RVA: 0x16d3c4c
	int GetUnlockedCount() { }
	// RVA: 0x16d3d98
	void .ctor() { }
}

// TypeDefIndex: 5762
class Unlockable
{
	int value__;
	Unlockable Bun;
	Unlockable Meat;
	Unlockable FryingPan;
	Unlockable Tomato;
	Unlockable Lettuce;
	Unlockable Onion;
	Unlockable Cheese;
	Unlockable Vegan;
	Unlockable Dishrack;
	Unlockable SlicerB;
	Unlockable Trash;
	Unlockable Leaderboards;
	Unlockable Extractor;
	Unlockable PaperRoll;
	Unlockable Poster;
	Unlockable Radio;
	Unlockable SlicerA;
	Unlockable Bell;
	Unlockable ToothpickJar;
	Unlockable Grill;
	Unlockable Smasher;
	Unlockable Tray;
	Unlockable WaitStand;
	Unlockable Cards;
	Unlockable CardAlbum;
	Unlockable GrillTurbo;
	Unlockable KetchupSauce;
	Unlockable MustardSauce;
	Unlockable MayoSauce;
	Unlockable BbqSauce;
	Unlockable HoneySauce;
	Unlockable HerbsSauce;
	Unlockable PineSauce;
	Unlockable DrinkMachine;
	Unlockable ColaDrink;
	Unlockable LemonDrink;
	Unlockable OrangeDrink;
}

// TypeDefIndex: 5763
class UpgradedCounterTriggerDetector
{
	GrabableItem parentGrabbable;
	// RVA: 0x16d3e20
	void Awake() { }
	// RVA: 0x16d3f14
	void OnTriggerEnter(UnityEngine.Collider _areaEntered) { }
	// RVA: 0x16d3f30
	void OnTriggerExit(UnityEngine.Collider _areaExited) { }
	// RVA: 0x16d3f4c
	void .ctor() { }
}

// TypeDefIndex: 5764
class URLs.UrlIds
{
	int value__;
	URLs+UrlIds SetBurgerScore;
	URLs+UrlIds GetHighscores;
	URLs+UrlIds GetDevList;
	URLs+UrlIds SetAnalytics;
	URLs+UrlIds SetLogErrors;
	URLs+UrlIds PostGameVersion;
	URLs+UrlIds PostHashedMac;
	URLs+UrlIds PostSteamId;
	URLs+UrlIds PostSteamName;
	URLs+UrlIds PostFollowerAmount;
	URLs+UrlIds PostGamemode;
	URLs+UrlIds PostScore;
	URLs+UrlIds PostCustomerName;
	URLs+UrlIds PostCustomerOutfit;
	URLs+UrlIds PostCustomerOrderSize;
	URLs+UrlIds PostTotalPlaytime;
	URLs+UrlIds PostGameScene;
	URLs+UrlIds PostDeviceName;
	URLs+UrlIds PostLanguage;
	URLs+UrlIds PostCity;
	URLs+UrlIds PostTotalEarnedMoney;
	URLs+UrlIds PostTotalWastedMoney;
	URLs+UrlIds PostMoneyPerHour;
	URLs+UrlIds PostUnlockedCount;
	URLs+UrlIds PostErrorType;
	URLs+UrlIds PostErrorMessage;
	URLs+UrlIds PostErrorStacktrace;
	URLs+UrlIds PostLogHistory;
}

// TypeDefIndex: 5765
class URLs
{
	System.Collections.Generic.Dictionary<URLs+UrlIds, string> <urlDict>k__BackingField;
	// property urlDict
	// RVA: 0x16d3f54
	System.Collections.Generic.Dictionary<URLs+UrlIds, string> get_urlDict() { }
	// RVA: 0x16d3fac
	void set_urlDict(System.Collections.Generic.Dictionary<URLs+UrlIds, string> value) { }
	// RVA: 0x16d4014
	void DecryptAllEntries(string encryptionKey) { }
	// RVA: 0x16d42e4
	string GetUrl(URLs+UrlIds idToFind) { }
	// RVA: 0x16d43cc
	void .cctor() { }
}

// TypeDefIndex: 5766
class WarehouseDoor.PlayerArea
{
	int value__;
	WarehouseDoor+PlayerArea None;
	WarehouseDoor+PlayerArea OuterTrigger;
	WarehouseDoor+PlayerArea InnerTrigger;
}

// TypeDefIndex: 5767
class WarehouseDoor.DoorState
{
	int value__;
	WarehouseDoor+DoorState Closed;
	WarehouseDoor+DoorState Opening;
	WarehouseDoor+DoorState Open;
	WarehouseDoor+DoorState WaitingToClose;
	WarehouseDoor+DoorState SlowClosing;
	WarehouseDoor+DoorState QuickClosing;
}

// TypeDefIndex: 5768
class WarehouseDoor.<>c__DisplayClass18_0
{
	WarehouseDoor <>4__this;
	bool _quickClosing;
	// RVA: 0x16d5288
	void .ctor() { }
	// RVA: 0x16d53f4
	void <Close>b__0() { }
}

// TypeDefIndex: 5769
class WarehouseDoor
{
	WarehouseDoor+DoorState currentDoorState;
	int lastOpenDir;
	float timeToAutoclose;
	System.Collections.Generic.HashSet<WarehouseDoorTrigger> smallTriggers;
	System.Collections.Generic.HashSet<WarehouseDoorTrigger> bigTriggers;
	WarehouseDoor+PlayerArea currentPlayerArea;
	UnityEngine.MeshCollider[] handlerColliders;
	AudioPlayer audioPlayer;
	DG.Tweening.Sequence doorSeq;
	UnityEngine.Transform doorAxis;
	// RVA: 0x16d48f8
	void Start() { }
	// RVA: 0x16d4a5c
	void OnDestroy() { }
	// RVA: 0x16d4b80
	void PlayerOnTrigger(bool _isEntering, WarehouseDoorTrigger _trigger) { }
	// RVA: 0x16d4fec
	void ClickOnKitchenSideHandler() { }
	// RVA: 0x16d5034
	void ClickOnWarehouseSideHandler() { }
	// RVA: 0x16d4ff4
	void ClickOnwarehouseSideHandler(int _dir) { }
	// RVA: 0x16d4df4
	void OpenDoor(int _dir) { }
	// RVA: 0x16d4d14
	void WaitToClose() { }
	// RVA: 0x16d503c
	void Close(bool _quickClosing) { }
	// RVA: 0x16d5290
	void RestoreState(bool isRestockStarting) { }
	// RVA: 0x16d529c
	void CloseDoorInstant() { }
	// RVA: 0x16d532c
	void .ctor() { }
	// RVA: 0x16d53e0
	void <OpenDoor>b__16_0() { }
	// RVA: 0x16d53ec
	void <WaitToClose>b__17_0() { }
}

// TypeDefIndex: 5770
class WarehouseDoorTrigger
{
	WarehouseDoor warehouseDoor;
	bool isSmallestTrigger;
	int <currentOpenDir>k__BackingField;
	// property currentOpenDir
	// RVA: 0x16d5554
	int get_currentOpenDir() { }
	// RVA: 0x16d555c
	void set_currentOpenDir(int value) { }
	// RVA: 0x16d5564
	void Start() { }
	// RVA: 0x16d5670
	void OnTriggerEnter(UnityEngine.Collider col) { }
	// RVA: 0x16d56ec
	void OnTriggerExit(UnityEngine.Collider col) { }
	// RVA: 0x16d5768
	void .ctor() { }
}

// TypeDefIndex: 5771
class WarehousePlayerDetector
{
	WarehousePlayerDetector instance;
	CounterArea deliveryArea;
	// RVA: 0x16d5770
	void Awake() { }
	// RVA: 0x16d5888
	void OnTriggerEnter(UnityEngine.Collider other) { }
	// RVA: 0x16d593c
	void .ctor() { }
}

// TypeDefIndex: 5772
class WarehouseRestocking
{
	WarehouseRestocking instance;
	UnityEngine.BoxCollider warehouseArea;
	System.Action callbackOnWarehouseRestockByDoor;
	// RVA: 0x16d5944
	void Awake() { }
	// RVA: 0x16d548c
	void ResetWarehouseIfPlayerIsInKitchen() { }
	// RVA: 0x16d5a50
	void DestroyWarehouseItemsInsideTheWarehouse() { }
	// RVA: 0x16d59d4
	bool IsInWarehouseArea(UnityEngine.Vector3 _pointToCheck) { }
	// RVA: 0x16d5cb0
	void .ctor() { }
}

// TypeDefIndex: 5773
class WobblyText.TextEmotion
{
	int value__;
	WobblyText+TextEmotion Idle;
	WobblyText+TextEmotion Wiggle;
	WobblyText+TextEmotion SoftShake;
	WobblyText+TextEmotion Shake;
	WobblyText+TextEmotion Impact;
}

// TypeDefIndex: 5774
class WobblyText
{
	WobblyText+TextEmotion textEmotion;
	TMPro.TextMeshProUGUI textComponent;
	TMPro.TMP_CharacterInfo charInfo;
	UnityEngine.Vector3[] verts;
	UnityEngine.Vector3 orig;
	float linearOffset;
	UnityEngine.Vector3 offset;
	float wiggleRangeY;
	float wiggleSpeed;
	float waveOffset;
	float softShakeSpeed;
	float softShakeMagnitude;
	float shakeMagnitude;
	float impactSize;
	float impactTime;
	UnityEngine.Vector3[] impactEffectSideSize;
	System.Collections.Generic.List<float> characterSpawnTime;
	float impactTextCharacterCount;
	// RVA: 0x16d5cb8
	void Start() { }
	// RVA: 0x16d5db4
	void LateUpdate() { }
	// RVA: 0x16d5eec
	void WiggleEffect(TMPro.TMP_TextInfo& textInfo) { }
	// RVA: 0x16d623c
	void ShakeEffect(TMPro.TMP_TextInfo& textInfo) { }
	// RVA: 0x16d6074
	void SoftShakeEffect(TMPro.TMP_TextInfo& textInfo) { }
	// RVA: 0x16d661c
	void ImpactUpdateShownCharacters(int currentCharacters) { }
	// RVA: 0x16d63b8
	void ImpactEffect(TMPro.TMP_TextInfo& textInfo) { }
	// RVA: 0x16d6748
	void .ctor() { }
}

// TypeDefIndex: 5775
class UnitySourceGeneratedAssemblyMonoScriptTypes_v1.MonoScriptData
{
	byte[] FilePathsData;
	byte[] TypesData;
	int TotalTypes;
	int TotalFiles;
	bool IsEditorOnly;
}

// TypeDefIndex: 5776
class UnitySourceGeneratedAssemblyMonoScriptTypes_v1
{
	// RVA: 0x16d6828
	UnitySourceGeneratedAssemblyMonoScriptTypes_v1+MonoScriptData Get() { }
	// RVA: 0x16d6920
	void .ctor() { }
}

// TypeDefIndex: 5777
class QMSSkyboxFREE.QMSSkyboxFREE
{
	System.Collections.Generic.List<UnityEngine.Material> skyboxMaterials;
	int currentIndex;
	TMPro.TextMeshProUGUI skyboxIndex;
	TMPro.TextMeshProUGUI skyboxNameText;
	TMPro.TextMeshProUGUI helpText;
	// RVA: 0x16d6928
	void Start() { }
	// RVA: 0x16d6aec
	void Update() { }
	// RVA: 0x16d6944
	void UpdateSkybox(int index) { }
	// RVA: 0x16d6cf0
	void SwitchSkybox(int direction) { }
	// RVA: 0x16d6d68
	void SwitchFirstOrLastSkybox(int direction) { }
	// RVA: 0x16d69cc
	void UpdateUI() { }
	// RVA: 0x16d6b04
	void HandleKeyboardInput() { }
	// RVA: 0x16d6bf4
	void HandleMouseCameraRotation() { }
	// RVA: 0x16d6dec
	void .ctor() { }
}

// TypeDefIndex: 5778
class Orbit.SafeArea.SimDevice
{
	int value__;
	Orbit.SafeArea+SimDevice None;
	Orbit.SafeArea+SimDevice iPhoneX;
	Orbit.SafeArea+SimDevice iPhoneXsMax;
	Orbit.SafeArea+SimDevice Pixel3XL_LSL;
	Orbit.SafeArea+SimDevice Pixel3XL_LSR;
}

// TypeDefIndex: 5779
class Orbit.SafeArea
{
	Orbit.SafeArea+SimDevice Sim;
	UnityEngine.Rect[] NSA_iPhoneX;
	UnityEngine.Rect[] NSA_iPhoneXsMax;
	UnityEngine.Rect[] NSA_Pixel3XL_LSL;
	UnityEngine.Rect[] NSA_Pixel3XL_LSR;
	UnityEngine.RectTransform Panel;
	UnityEngine.Rect LastSafeArea;
	UnityEngine.Vector2Int LastScreenSize;
	UnityEngine.ScreenOrientation LastOrientation;
	bool ConformX;
	bool ConformY;
	bool Logging;
	// RVA: 0x16d6df4
	void Awake() { }
	// RVA: 0x16d6f40
	void OnDisable() { }
	// RVA: 0x16d6f60
	void Update() { }
	// RVA: 0x16d6f64
	void Refresh() { }
	// RVA: 0x16d704c
	UnityEngine.Rect GetSafeArea() { }
	// RVA: 0x16d7270
	void ApplySafeArea(UnityEngine.Rect r) { }
	// RVA: 0x16d768c
	void .ctor() { }
}

// TypeDefIndex: 5780
class Orbit.UI_OptionBtn
{
	System.Collections.Generic.List<UnityEngine.RectTransform> btns;
	System.Collections.Generic.List<UnityEngine.RectTransform> icons;
	System.Collections.Generic.List<TMPro.TMP_Text> labels;
	// RVA: 0x16d781c
	void OnEnable() { }
	// RVA: 0x16d7c40
	void AddOptionButton(string buttonPath, string iconPath, string labelPath) { }
	// RVA: 0x16d8134
	void AddButton(UnityEngine.RectTransform button) { }
	// RVA: 0x16d8234
	void AddIcon(UnityEngine.Transform icon) { }
	// RVA: 0x16d8384
	void AddLabel(UnityEngine.Transform label) { }
	// RVA: 0x16d7d54
	void Apply() { }
	// RVA: 0x16d84d4
	void .ctor() { }
}

// TypeDefIndex: 5781
class PinePie.SimpleJoystick.JoystickBaseMode
{
	int value__;
	PinePie.SimpleJoystick.JoystickBaseMode Static;
	PinePie.SimpleJoystick.JoystickBaseMode Dynamic;
	PinePie.SimpleJoystick.JoystickBaseMode Floating;
}

// TypeDefIndex: 5782
class PinePie.SimpleJoystick.JoystickController
{
	UnityEngine.RectTransform joystickBase;
	UnityEngine.RectTransform handle;
	PinePie.SimpleJoystick.JoystickBaseMode baseMode;
	float joystickRange;
	float deadZone;
	int directionSnaps;
	bool snapHandleBack;
	bool autoHide;
	UnityEngine.Vector2 inputDirection;
	System.Action OnTouchPressed;
	System.Action OnTouchRemoved;
	System.Action OnDirectionChanged;
	UnityEngine.Vector2 baseStartPos;
	UnityEngine.Canvas parentCanvas;
	bool dragStartedInside;
	bool isInitialized;
	UnityEngine.RectTransform area;
	// property InputDirection
	// RVA: 0x16d84dc
	UnityEngine.Vector2 get_InputDirection() { }
	// RVA: 0x16d84e4
	void add_OnTouchPressed(System.Action value) { }
	// RVA: 0x16d8580
	void remove_OnTouchPressed(System.Action value) { }
	// RVA: 0x16d861c
	void add_OnTouchRemoved(System.Action value) { }
	// RVA: 0x16d86b8
	void remove_OnTouchRemoved(System.Action value) { }
	// RVA: 0x16d8754
	void add_OnDirectionChanged(System.Action value) { }
	// RVA: 0x16d87f0
	void remove_OnDirectionChanged(System.Action value) { }
	// RVA: 0x16d888c
	void Awake() { }
	// RVA: 0x16d8ac8
	void OnDisable() { }
	// RVA: 0x16d8944
	void SetBaseMode(PinePie.SimpleJoystick.JoystickBaseMode mode) { }
	// RVA: 0x16d8b18
	void SetBasePosition(UnityEngine.Vector2 position) { }
	// RVA: 0x16d8bbc
	void OnPointerDown(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d8ebc
	void OnDrag(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d9554
	void OnPointerUp(UnityEngine.EventSystems.PointerEventData eventData) { }
	// RVA: 0x16d94cc
	UnityEngine.Vector2 GetClosestPointLocal(UnityEngine.RectTransform rectTransform, UnityEngine.Vector2 localInputPoint) { }
	// RVA: 0x16d966c
	void .ctor() { }
}

// TypeDefIndex: 5783
class Battlehub.Dispatcher.Dispatcher
{
	Battlehub.Dispatcher.Dispatcher m_current;
	Battlehub.Dispatcher.Dispatcher <Current>k__BackingField;
	int m_lock;
	bool m_run;
	System.Collections.Generic.Queue<System.Action> m_wait;
	// property Current
	// RVA: 0x16d96d8
	Battlehub.Dispatcher.Dispatcher get_Current() { }
	// RVA: 0x16d9720
	void set_Current(Battlehub.Dispatcher.Dispatcher value) { }
	// RVA: 0x16d9778
	void BeginInvoke(System.Action action) { }
	// RVA: 0x16d9808
	void Awake() { }
	// RVA: 0x16d9970
	void Update() { }
	// RVA: 0x16d9ac4
	void .ctor() { }
}

// TypeDefIndex: 5784
class LitJson.JsonType
{
	int value__;
	LitJson.JsonType None;
	LitJson.JsonType Object;
	LitJson.JsonType Array;
	LitJson.JsonType String;
	LitJson.JsonType Int;
	LitJson.JsonType Long;
	LitJson.JsonType Double;
	LitJson.JsonType Boolean;
}

// TypeDefIndex: 5785
class LitJson.IJsonWrapper
{
	// property IsArray
	// property IsBoolean
	// property IsDouble
	// property IsInt
	// property IsLong
	// property IsObject
	// property IsString
	// no-body
	bool get_IsArray() { }
	// no-body
	bool get_IsBoolean() { }
	// no-body
	bool get_IsDouble() { }
	// no-body
	bool get_IsInt() { }
	// no-body
	bool get_IsLong() { }
	// no-body
	bool get_IsObject() { }
	// no-body
	bool get_IsString() { }
	// no-body
	bool GetBoolean() { }
	// no-body
	double GetDouble() { }
	// no-body
	int GetInt() { }
	// no-body
	LitJson.JsonType GetJsonType() { }
	// no-body
	long GetLong() { }
	// no-body
	string GetString() { }
	// no-body
	void SetBoolean(bool val) { }
	// no-body
	void SetDouble(double val) { }
	// no-body
	void SetInt(int val) { }
	// no-body
	void SetJsonType(LitJson.JsonType type) { }
	// no-body
	void SetLong(long val) { }
	// no-body
	void SetString(string val) { }
	// no-body
	string ToJson() { }
	// no-body
	void ToJson(LitJson.JsonWriter writer) { }
}

// TypeDefIndex: 5786
class LitJson.JsonData
{
	System.Collections.Generic.IList<LitJson.JsonData> inst_array;
	bool inst_boolean;
	double inst_double;
	int inst_int;
	long inst_long;
	System.Collections.Generic.IDictionary<string, LitJson.JsonData> inst_object;
	string inst_string;
	string json;
	LitJson.JsonType type;
	System.Collections.Generic.IList<System.Collections.Generic.KeyValuePair<string, LitJson.JsonData>> object_list;
	// property Count
	// property IsArray
	// property IsBoolean
	// property IsDouble
	// property IsInt
	// property IsLong
	// property IsObject
	// property IsString
	// property Keys
	// property System.Collections.ICollection.Count
	// property System.Collections.ICollection.IsSynchronized
	// property System.Collections.ICollection.SyncRoot
	// property System.Collections.IDictionary.IsFixedSize
	// property System.Collections.IDictionary.IsReadOnly
	// property System.Collections.IDictionary.Keys
	// property System.Collections.IDictionary.Values
	// property LitJson.IJsonWrapper.IsArray
	// property LitJson.IJsonWrapper.IsBoolean
	// property LitJson.IJsonWrapper.IsDouble
	// property LitJson.IJsonWrapper.IsInt
	// property LitJson.IJsonWrapper.IsLong
	// property LitJson.IJsonWrapper.IsObject
	// property LitJson.IJsonWrapper.IsString
	// property System.Collections.IList.IsFixedSize
	// property System.Collections.IList.IsReadOnly
	// property System.Collections.IDictionary.Item
	// property System.Collections.Specialized.IOrderedDictionary.Item
	// property System.Collections.IList.Item
	// property Item
	// property Item
	// RVA: 0x16d9acc
	int get_Count() { }
	// RVA: 0x16d9c4c
	bool get_IsArray() { }
	// RVA: 0x16d9c5c
	bool get_IsBoolean() { }
	// RVA: 0x16d9c6c
	bool get_IsDouble() { }
	// RVA: 0x16d9c7c
	bool get_IsInt() { }
	// RVA: 0x16d9c8c
	bool get_IsLong() { }
	// RVA: 0x16d9c9c
	bool get_IsObject() { }
	// RVA: 0x16d9cac
	bool get_IsString() { }
	// RVA: 0x16d9cbc
	System.Collections.Generic.ICollection<string> get_Keys() { }
	// RVA: 0x16d9edc
	bool ContainsKey(string key) { }
	// RVA: 0x16da008
	int System.Collections.ICollection.get_Count() { }
	// RVA: 0x16da00c
	bool System.Collections.ICollection.get_IsSynchronized() { }
	// RVA: 0x16da0b8
	object System.Collections.ICollection.get_SyncRoot() { }
	// RVA: 0x16da164
	bool System.Collections.IDictionary.get_IsFixedSize() { }
	// RVA: 0x16da210
	bool System.Collections.IDictionary.get_IsReadOnly() { }
	// RVA: 0x16da2bc
	System.Collections.ICollection System.Collections.IDictionary.get_Keys() { }
	// RVA: 0x16da694
	System.Collections.ICollection System.Collections.IDictionary.get_Values() { }
	// RVA: 0x16daa6c
	bool LitJson.IJsonWrapper.get_IsArray() { }
	// RVA: 0x16daa7c
	bool LitJson.IJsonWrapper.get_IsBoolean() { }
	// RVA: 0x16daa8c
	bool LitJson.IJsonWrapper.get_IsDouble() { }
	// RVA: 0x16daa9c
	bool LitJson.IJsonWrapper.get_IsInt() { }
	// RVA: 0x16daaac
	bool LitJson.IJsonWrapper.get_IsLong() { }
	// RVA: 0x16daabc
	bool LitJson.IJsonWrapper.get_IsObject() { }
	// RVA: 0x16daacc
	bool LitJson.IJsonWrapper.get_IsString() { }
	// RVA: 0x16daadc
	bool System.Collections.IList.get_IsFixedSize() { }
	// RVA: 0x16dacac
	bool System.Collections.IList.get_IsReadOnly() { }
	// RVA: 0x16dad58
	object System.Collections.IDictionary.get_Item(object key) { }
	// RVA: 0x16dae08
	void System.Collections.IDictionary.set_Item(object key, object value) { }
	// RVA: 0x16db304
	object System.Collections.Specialized.IOrderedDictionary.get_Item(int idx) { }
	// RVA: 0x16db3c8
	void System.Collections.Specialized.IOrderedDictionary.set_Item(int idx, object value) { }
	// RVA: 0x16db5d4
	object System.Collections.IList.get_Item(int index) { }
	// RVA: 0x16db684
	void System.Collections.IList.set_Item(int index, object value) { }
	// RVA: 0x16db964
	LitJson.JsonData get_Item(string prop_name) { }
	// RVA: 0x16daf6c
	void set_Item(string prop_name, LitJson.JsonData value) { }
	// RVA: 0x16dba14
	LitJson.JsonData get_Item(int index) { }
	// RVA: 0x16db6bc
	void set_Item(int index, LitJson.JsonData value) { }
	// RVA: 0x16dbb64
	void .ctor() { }
	// RVA: 0x16dbb6c
	void .ctor(bool boolean) { }
	// RVA: 0x16dbb9c
	void .ctor(double number) { }
	// RVA: 0x16dbbcc
	void .ctor(int number) { }
	// RVA: 0x16dbbfc
	void .ctor(long number) { }
	// RVA: 0x16dbc2c
	void .ctor(object obj) { }
	// RVA: 0x16dbe5c
	void .ctor(string str) { }
	// RVA: 0x16dbe94
	LitJson.JsonData op_Implicit(bool data) { }
	// RVA: 0x16dbefc
	LitJson.JsonData op_Implicit(double data) { }
	// RVA: 0x16dbf68
	LitJson.JsonData op_Implicit(int data) { }
	// RVA: 0x16dbfcc
	LitJson.JsonData op_Implicit(long data) { }
	// RVA: 0x16dc030
	LitJson.JsonData op_Implicit(string data) { }
	// RVA: 0x16dc0a0
	bool op_Explicit(LitJson.JsonData data) { }
	// RVA: 0x16dc10c
	double op_Explicit(LitJson.JsonData data) { }
	// RVA: 0x16dc178
	int op_Explicit(LitJson.JsonData data) { }
	// RVA: 0x16dc1f4
	long op_Explicit(LitJson.JsonData data) { }
	// RVA: 0x16dc270
	string op_Explicit(LitJson.JsonData data) { }
	// RVA: 0x16dc2dc
	void System.Collections.ICollection.CopyTo(System.Array array, int index) { }
	// RVA: 0x16dc39c
	void System.Collections.IDictionary.Add(object key, object value) { }
	// RVA: 0x16dc568
	void System.Collections.IDictionary.Clear() { }
	// RVA: 0x16dc69c
	bool System.Collections.IDictionary.Contains(object key) { }
	// RVA: 0x16dc750
	System.Collections.IDictionaryEnumerator System.Collections.IDictionary.GetEnumerator() { }
	// RVA: 0x16dc7e8
	void System.Collections.IDictionary.Remove(object key) { }
	// RVA: 0x16dca74
	System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator() { }
	// RVA: 0x16dcb1c
	bool LitJson.IJsonWrapper.GetBoolean() { }
	// RVA: 0x16dcb80
	double LitJson.IJsonWrapper.GetDouble() { }
	// RVA: 0x16dcbe4
	int LitJson.IJsonWrapper.GetInt() { }
	// RVA: 0x16dcc48
	long LitJson.IJsonWrapper.GetLong() { }
	// RVA: 0x16dccac
	string LitJson.IJsonWrapper.GetString() { }
	// RVA: 0x16dcd10
	void LitJson.IJsonWrapper.SetBoolean(bool val) { }
	// RVA: 0x16dcd2c
	void LitJson.IJsonWrapper.SetDouble(double val) { }
	// RVA: 0x16dcd44
	void LitJson.IJsonWrapper.SetInt(int val) { }
	// RVA: 0x16dcd5c
	void LitJson.IJsonWrapper.SetLong(long val) { }
	// RVA: 0x16dcd74
	void LitJson.IJsonWrapper.SetString(string val) { }
	// RVA: 0x16dcda0
	string LitJson.IJsonWrapper.ToJson() { }
	// RVA: 0x16dce78
	void LitJson.IJsonWrapper.ToJson(LitJson.JsonWriter writer) { }
	// RVA: 0x16dceac
	int System.Collections.IList.Add(object value) { }
	// RVA: 0x16dcf80
	void System.Collections.IList.Clear() { }
	// RVA: 0x16dd03c
	bool System.Collections.IList.Contains(object value) { }
	// RVA: 0x16dd0f0
	int System.Collections.IList.IndexOf(object value) { }
	// RVA: 0x16dd1a4
	void System.Collections.IList.Insert(int index, object value) { }
	// RVA: 0x16dd278
	void System.Collections.IList.Remove(object value) { }
	// RVA: 0x16dd33c
	void System.Collections.IList.RemoveAt(int index) { }
	// RVA: 0x16dd400
	System.Collections.IDictionaryEnumerator System.Collections.Specialized.IOrderedDictionary.GetEnumerator() { }
	// RVA: 0x16dd520
	void System.Collections.Specialized.IOrderedDictionary.Insert(int idx, object key, object value) { }
	// RVA: 0x16dd66c
	void System.Collections.Specialized.IOrderedDictionary.RemoveAt(int idx) { }
	// RVA: 0x16d9b78
	System.Collections.ICollection EnsureCollection() { }
	// RVA: 0x16d9d68
	System.Collections.IDictionary EnsureDictionary() { }
	// RVA: 0x16dab88
	System.Collections.IList EnsureList() { }
	// RVA: 0x16daee0
	LitJson.JsonData ToJsonData(object obj) { }
	// RVA: 0x16dd818
	void WriteJson(LitJson.IJsonWrapper obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16dceb0
	int Add(object value) { }
	// RVA: 0x16de420
	bool Remove(object obj) { }
	// RVA: 0x16de7ac
	void Clear() { }
	// RVA: 0x16de8bc
	bool Equals(LitJson.JsonData x) { }
	// RVA: 0x16dea6c
	LitJson.JsonType GetJsonType() { }
	// RVA: 0x16dea74
	void SetJsonType(LitJson.JsonType type) { }
	// RVA: 0x16dcda4
	string ToJson() { }
	// RVA: 0x16dce7c
	void ToJson(LitJson.JsonWriter writer) { }
	// RVA: 0x16debe8
	string ToString() { }
}

// TypeDefIndex: 5787
class LitJson.OrderedDictionaryEnumerator
{
	System.Collections.Generic.IEnumerator<System.Collections.Generic.KeyValuePair<string, LitJson.JsonData>> list_enumerator;
	// property Current
	// property Entry
	// property Key
	// property Value
	// RVA: 0x16ded04
	object get_Current() { }
	// RVA: 0x16ded68
	System.Collections.DictionaryEntry get_Entry() { }
	// RVA: 0x16dee50
	object get_Key() { }
	// RVA: 0x16deefc
	object get_Value() { }
	// RVA: 0x16dd4f0
	void .ctor(System.Collections.Generic.IEnumerator<System.Collections.Generic.KeyValuePair<string, LitJson.JsonData>> enumerator) { }
	// RVA: 0x16defb0
	bool MoveNext() { }
	// RVA: 0x16df050
	void Reset() { }
}

// TypeDefIndex: 5788
class LitJson.JsonException
{
	// RVA: 0x16df0f4
	void .ctor() { }
	// RVA: 0x16df0fc
	void .ctor(LitJson.ParserToken token) { }
	// RVA: 0x16df198
	void .ctor(LitJson.ParserToken token, System.Exception inner_exception) { }
	// RVA: 0x16df23c
	void .ctor(int c) { }
	// RVA: 0x16df2d8
	void .ctor(int c, System.Exception inner_exception) { }
	// RVA: 0x16df37c
	void .ctor(string message) { }
	// RVA: 0x16df384
	void .ctor(string message, System.Exception inner_exception) { }
}

// TypeDefIndex: 5789
class LitJson.PropertyMetadata
{
	System.Reflection.MemberInfo Info;
	bool IsField;
	System.Type Type;
}

// TypeDefIndex: 5790
class LitJson.ArrayMetadata
{
	System.Type element_type;
	bool is_array;
	bool is_list;
	// property ElementType
	// property IsArray
	// property IsList
	// RVA: 0x16df38c
	System.Type get_ElementType() { }
	// RVA: 0x16df434
	void set_ElementType(System.Type value) { }
	// RVA: 0x16df43c
	bool get_IsArray() { }
	// RVA: 0x16df444
	void set_IsArray(bool value) { }
	// RVA: 0x16df450
	bool get_IsList() { }
	// RVA: 0x16df458
	void set_IsList(bool value) { }
}

// TypeDefIndex: 5791
class LitJson.ObjectMetadata
{
	System.Type element_type;
	bool is_dictionary;
	System.Collections.Generic.IDictionary<string, LitJson.PropertyMetadata> properties;
	// property ElementType
	// property IsDictionary
	// property Properties
	// RVA: 0x16df464
	System.Type get_ElementType() { }
	// RVA: 0x16df50c
	void set_ElementType(System.Type value) { }
	// RVA: 0x16df514
	bool get_IsDictionary() { }
	// RVA: 0x16df51c
	void set_IsDictionary(bool value) { }
	// RVA: 0x16df528
	System.Collections.Generic.IDictionary<string, LitJson.PropertyMetadata> get_Properties() { }
	// RVA: 0x16df530
	void set_Properties(System.Collections.Generic.IDictionary<string, LitJson.PropertyMetadata> value) { }
}

// TypeDefIndex: 5792
class LitJson.ExporterFunc
{
	// RVA: 0x16df538
	void .ctor(object object, nint method) { }
	// RVA: 0x16df644
	void Invoke(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16df658
	System.IAsyncResult BeginInvoke(object obj, LitJson.JsonWriter writer, System.AsyncCallback callback, object object) { }
	// RVA: 0x16df680
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5793
class LitJson.ExporterFunc`1
{
	// no-body
	void .ctor(object object, nint method) { }
	// no-body
	void Invoke(T obj, LitJson.JsonWriter writer) { }
	// no-body
	System.IAsyncResult BeginInvoke(T obj, LitJson.JsonWriter writer, System.AsyncCallback callback, object object) { }
	// no-body
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5794
class LitJson.ImporterFunc
{
	// RVA: 0x16df68c
	void .ctor(object object, nint method) { }
	// RVA: 0x16df794
	object Invoke(object input) { }
	// RVA: 0x16df7a8
	System.IAsyncResult BeginInvoke(object input, System.AsyncCallback callback, object object) { }
	// RVA: 0x16df7c8
	object EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5795
class LitJson.ImporterFunc`2
{
	// no-body
	void .ctor(object object, nint method) { }
	// no-body
	TValue Invoke(TJson input) { }
	// no-body
	System.IAsyncResult BeginInvoke(TJson input, System.AsyncCallback callback, object object) { }
	// no-body
	TValue EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5796
class LitJson.WrapperFactory
{
	// RVA: 0x16df7d4
	void .ctor(object object, nint method) { }
	// RVA: 0x16df870
	LitJson.IJsonWrapper Invoke() { }
	// RVA: 0x16df884
	System.IAsyncResult BeginInvoke(System.AsyncCallback callback, object object) { }
	// RVA: 0x16df8a4
	LitJson.IJsonWrapper EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5797
class LitJson.JsonMapper.<>c
{
	LitJson.JsonMapper+<>c <>9;
	LitJson.WrapperFactory <>9__23_0;
	LitJson.ExporterFunc <>9__24_0;
	LitJson.ExporterFunc <>9__24_1;
	LitJson.ExporterFunc <>9__24_2;
	LitJson.ExporterFunc <>9__24_3;
	LitJson.ExporterFunc <>9__24_4;
	LitJson.ExporterFunc <>9__24_5;
	LitJson.ExporterFunc <>9__24_6;
	LitJson.ExporterFunc <>9__24_7;
	LitJson.ExporterFunc <>9__24_8;
	LitJson.ExporterFunc <>9__24_9;
	LitJson.ImporterFunc <>9__25_0;
	LitJson.ImporterFunc <>9__25_1;
	LitJson.ImporterFunc <>9__25_2;
	LitJson.ImporterFunc <>9__25_3;
	LitJson.ImporterFunc <>9__25_4;
	LitJson.ImporterFunc <>9__25_5;
	LitJson.ImporterFunc <>9__25_6;
	LitJson.ImporterFunc <>9__25_7;
	LitJson.ImporterFunc <>9__25_8;
	LitJson.ImporterFunc <>9__25_9;
	LitJson.ImporterFunc <>9__25_10;
	LitJson.ImporterFunc <>9__25_11;
	LitJson.ImporterFunc <>9__25_12;
	LitJson.ImporterFunc <>9__25_13;
	LitJson.WrapperFactory <>9__30_0;
	LitJson.WrapperFactory <>9__31_0;
	LitJson.WrapperFactory <>9__32_0;
	// RVA: 0x16e6c1c
	void .cctor() { }
	// RVA: 0x16e6c84
	void .ctor() { }
	// RVA: 0x16e6c8c
	LitJson.IJsonWrapper <ReadSkip>b__23_0() { }
	// RVA: 0x16e6ce0
	void <RegisterBaseExporters>b__24_0(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e6d98
	void <RegisterBaseExporters>b__24_1(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e6e50
	void <RegisterBaseExporters>b__24_2(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e6f40
	void <RegisterBaseExporters>b__24_3(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e6fc0
	void <RegisterBaseExporters>b__24_4(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e7078
	void <RegisterBaseExporters>b__24_5(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e7130
	void <RegisterBaseExporters>b__24_6(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e71e8
	void <RegisterBaseExporters>b__24_7(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e72a0
	void <RegisterBaseExporters>b__24_8(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e7320
	void <RegisterBaseExporters>b__24_9(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e7430
	object <RegisterBaseImporters>b__25_0(object input) { }
	// RVA: 0x16e7500
	object <RegisterBaseImporters>b__25_1(object input) { }
	// RVA: 0x16e75d0
	object <RegisterBaseImporters>b__25_2(object input) { }
	// RVA: 0x16e76a0
	object <RegisterBaseImporters>b__25_3(object input) { }
	// RVA: 0x16e7770
	object <RegisterBaseImporters>b__25_4(object input) { }
	// RVA: 0x16e7840
	object <RegisterBaseImporters>b__25_5(object input) { }
	// RVA: 0x16e7910
	object <RegisterBaseImporters>b__25_6(object input) { }
	// RVA: 0x16e79e0
	object <RegisterBaseImporters>b__25_7(object input) { }
	// RVA: 0x16e7aac
	object <RegisterBaseImporters>b__25_8(object input) { }
	// RVA: 0x16e7b78
	object <RegisterBaseImporters>b__25_9(object input) { }
	// RVA: 0x16e7c70
	object <RegisterBaseImporters>b__25_10(object input) { }
	// RVA: 0x16e7d40
	object <RegisterBaseImporters>b__25_11(object input) { }
	// RVA: 0x16e7e04
	object <RegisterBaseImporters>b__25_12(object input) { }
	// RVA: 0x16e7f00
	object <RegisterBaseImporters>b__25_13(object input) { }
	// RVA: 0x16e7fe8
	LitJson.IJsonWrapper <ToObject>b__30_0() { }
	// RVA: 0x16e803c
	LitJson.IJsonWrapper <ToObject>b__31_0() { }
	// RVA: 0x16e8090
	LitJson.IJsonWrapper <ToObject>b__32_0() { }
}

// TypeDefIndex: 5798
class LitJson.JsonMapper.<>c__DisplayClass39_0`1
{
	LitJson.ExporterFunc<T> exporter;
	// no-body
	void .ctor() { }
	// no-body
	void <RegisterExporter>b__0(object obj, LitJson.JsonWriter writer) { }
}

// TypeDefIndex: 5799
class LitJson.JsonMapper.<>c__DisplayClass40_0`2
{
	LitJson.ImporterFunc<TJson, TValue> importer;
	// no-body
	void .ctor() { }
	// no-body
	object <RegisterImporter>b__0(object input) { }
}

// TypeDefIndex: 5800
class LitJson.JsonMapper
{
	int max_nesting_depth;
	System.IFormatProvider datetime_format;
	System.Collections.Generic.IDictionary<System.Type, LitJson.ExporterFunc> base_exporters_table;
	System.Collections.Generic.IDictionary<System.Type, LitJson.ExporterFunc> custom_exporters_table;
	System.Collections.Generic.IDictionary<System.Type, System.Collections.Generic.IDictionary<System.Type, LitJson.ImporterFunc>> base_importers_table;
	System.Collections.Generic.IDictionary<System.Type, System.Collections.Generic.IDictionary<System.Type, LitJson.ImporterFunc>> custom_importers_table;
	System.Collections.Generic.IDictionary<System.Type, LitJson.ArrayMetadata> array_metadata;
	object array_metadata_lock;
	System.Collections.Generic.IDictionary<System.Type, System.Collections.Generic.IDictionary<System.Type, System.Reflection.MethodInfo>> conv_ops;
	object conv_ops_lock;
	System.Collections.Generic.IDictionary<System.Type, LitJson.ObjectMetadata> object_metadata;
	object object_metadata_lock;
	System.Collections.Generic.IDictionary<System.Type, System.Collections.Generic.IList<LitJson.PropertyMetadata>> type_properties;
	object type_properties_lock;
	LitJson.JsonWriter static_writer;
	object static_writer_lock;
	// RVA: 0x16df8b0
	void .cctor() { }
	// RVA: 0x16e1820
	void AddArrayMetadata(System.Type type) { }
	// RVA: 0x16e1ca4
	void AddObjectMetadata(System.Type type) { }
	// RVA: 0x16e2420
	void AddTypeProperties(System.Type type) { }
	// RVA: 0x16e2988
	System.Reflection.MethodInfo GetConvOp(System.Type t1, System.Type t2) { }
	// RVA: 0x16e31f8
	object ReadValue(System.Type inst_type, LitJson.JsonReader reader) { }
	// RVA: 0x16e42b4
	LitJson.IJsonWrapper ReadValue(LitJson.WrapperFactory factory, LitJson.JsonReader reader) { }
	// RVA: 0x16e41b4
	void ReadSkip(LitJson.JsonReader reader) { }
	// RVA: 0x16dfcac
	void RegisterBaseExporters() { }
	// RVA: 0x16e09f0
	void RegisterBaseImporters() { }
	// RVA: 0x16e49c0
	void RegisterImporter(System.Collections.Generic.IDictionary<System.Type, System.Collections.Generic.IDictionary<System.Type, LitJson.ImporterFunc>> table, System.Type json_type, System.Type value_type, LitJson.ImporterFunc importer) { }
	// RVA: 0x16e4c00
	void WriteValue(object obj, LitJson.JsonWriter writer, bool writer_is_private, int depth) { }
	// RVA: 0x16e6368
	string ToJson(object obj) { }
	// RVA: 0x16e64e0
	void ToJson(object obj, LitJson.JsonWriter writer) { }
	// RVA: 0x16e654c
	LitJson.JsonData ToObject(LitJson.JsonReader reader) { }
	// RVA: 0x16e6698
	LitJson.JsonData ToObject(System.IO.TextReader reader) { }
	// RVA: 0x16e6810
	LitJson.JsonData ToObject(string json) { }
	// no-body
	T ToObject(LitJson.JsonReader reader) { }
	// no-body
	T ToObject(System.IO.TextReader reader) { }
	// no-body
	T ToObject(string json) { }
	// RVA: 0x16e69ec
	object ToObject(string json, System.Type ConvertType) { }
	// RVA: 0x16e495c
	LitJson.IJsonWrapper ToWrapper(LitJson.WrapperFactory factory, LitJson.JsonReader reader) { }
	// RVA: 0x16e695c
	LitJson.IJsonWrapper ToWrapper(LitJson.WrapperFactory factory, string json) { }
	// no-body
	void RegisterExporter(LitJson.ExporterFunc<T> exporter) { }
	// no-body
	void RegisterImporter(LitJson.ImporterFunc<TJson, TValue> importer) { }
	// RVA: 0x16e6a7c
	void UnregisterExporters() { }
	// RVA: 0x16e6b48
	void UnregisterImporters() { }
	// RVA: 0x16e6c14
	void .ctor() { }
}

// TypeDefIndex: 5801
class LitJson.JsonMockWrapper
{
	// property IsArray
	// property IsBoolean
	// property IsDouble
	// property IsInt
	// property IsLong
	// property IsObject
	// property IsString
	// property System.Collections.IList.IsFixedSize
	// property System.Collections.IList.IsReadOnly
	// property System.Collections.IList.Item
	// property System.Collections.ICollection.Count
	// property System.Collections.ICollection.IsSynchronized
	// property System.Collections.ICollection.SyncRoot
	// property System.Collections.IDictionary.IsFixedSize
	// property System.Collections.IDictionary.IsReadOnly
	// property System.Collections.IDictionary.Keys
	// property System.Collections.IDictionary.Values
	// property System.Collections.IDictionary.Item
	// property System.Collections.Specialized.IOrderedDictionary.Item
	// RVA: 0x16e80e4
	bool get_IsArray() { }
	// RVA: 0x16e80ec
	bool get_IsBoolean() { }
	// RVA: 0x16e80f4
	bool get_IsDouble() { }
	// RVA: 0x16e80fc
	bool get_IsInt() { }
	// RVA: 0x16e8104
	bool get_IsLong() { }
	// RVA: 0x16e810c
	bool get_IsObject() { }
	// RVA: 0x16e8114
	bool get_IsString() { }
	// RVA: 0x16e811c
	bool GetBoolean() { }
	// RVA: 0x16e8124
	double GetDouble() { }
	// RVA: 0x16e812c
	int GetInt() { }
	// RVA: 0x16e8134
	LitJson.JsonType GetJsonType() { }
	// RVA: 0x16e813c
	long GetLong() { }
	// RVA: 0x16e8144
	string GetString() { }
	// RVA: 0x16e8184
	void SetBoolean(bool val) { }
	// RVA: 0x16e8188
	void SetDouble(double val) { }
	// RVA: 0x16e818c
	void SetInt(int val) { }
	// RVA: 0x16e8190
	void SetJsonType(LitJson.JsonType type) { }
	// RVA: 0x16e8194
	void SetLong(long val) { }
	// RVA: 0x16e8198
	void SetString(string val) { }
	// RVA: 0x16e819c
	string ToJson() { }
	// RVA: 0x16e81dc
	void ToJson(LitJson.JsonWriter writer) { }
	// RVA: 0x16e81e0
	bool System.Collections.IList.get_IsFixedSize() { }
	// RVA: 0x16e81e8
	bool System.Collections.IList.get_IsReadOnly() { }
	// RVA: 0x16e81f0
	object System.Collections.IList.get_Item(int index) { }
	// RVA: 0x16e81f8
	void System.Collections.IList.set_Item(int index, object value) { }
	// RVA: 0x16e81fc
	int System.Collections.IList.Add(object value) { }
	// RVA: 0x16e8204
	void System.Collections.IList.Clear() { }
	// RVA: 0x16e8208
	bool System.Collections.IList.Contains(object value) { }
	// RVA: 0x16e8210
	int System.Collections.IList.IndexOf(object value) { }
	// RVA: 0x16e8218
	void System.Collections.IList.Insert(int i, object v) { }
	// RVA: 0x16e821c
	void System.Collections.IList.Remove(object value) { }
	// RVA: 0x16e8220
	void System.Collections.IList.RemoveAt(int index) { }
	// RVA: 0x16e8224
	int System.Collections.ICollection.get_Count() { }
	// RVA: 0x16e822c
	bool System.Collections.ICollection.get_IsSynchronized() { }
	// RVA: 0x16e8234
	object System.Collections.ICollection.get_SyncRoot() { }
	// RVA: 0x16e823c
	void System.Collections.ICollection.CopyTo(System.Array array, int index) { }
	// RVA: 0x16e8240
	System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator() { }
	// RVA: 0x16e8248
	bool System.Collections.IDictionary.get_IsFixedSize() { }
	// RVA: 0x16e8250
	bool System.Collections.IDictionary.get_IsReadOnly() { }
	// RVA: 0x16e8258
	System.Collections.ICollection System.Collections.IDictionary.get_Keys() { }
	// RVA: 0x16e8260
	System.Collections.ICollection System.Collections.IDictionary.get_Values() { }
	// RVA: 0x16e8268
	object System.Collections.IDictionary.get_Item(object key) { }
	// RVA: 0x16e8270
	void System.Collections.IDictionary.set_Item(object key, object value) { }
	// RVA: 0x16e8274
	void System.Collections.IDictionary.Add(object k, object v) { }
	// RVA: 0x16e8278
	void System.Collections.IDictionary.Clear() { }
	// RVA: 0x16e827c
	bool System.Collections.IDictionary.Contains(object key) { }
	// RVA: 0x16e8284
	void System.Collections.IDictionary.Remove(object key) { }
	// RVA: 0x16e8288
	System.Collections.IDictionaryEnumerator System.Collections.IDictionary.GetEnumerator() { }
	// RVA: 0x16e8290
	object System.Collections.Specialized.IOrderedDictionary.get_Item(int idx) { }
	// RVA: 0x16e8298
	void System.Collections.Specialized.IOrderedDictionary.set_Item(int idx, object value) { }
	// RVA: 0x16e829c
	System.Collections.IDictionaryEnumerator System.Collections.Specialized.IOrderedDictionary.GetEnumerator() { }
	// RVA: 0x16e82a4
	void System.Collections.Specialized.IOrderedDictionary.Insert(int i, object k, object v) { }
	// RVA: 0x16e82a8
	void System.Collections.Specialized.IOrderedDictionary.RemoveAt(int i) { }
	// RVA: 0x16e82ac
	void .ctor() { }
}

// TypeDefIndex: 5802
class LitJson.JsonToken
{
	int value__;
	LitJson.JsonToken None;
	LitJson.JsonToken ObjectStart;
	LitJson.JsonToken PropertyName;
	LitJson.JsonToken ObjectEnd;
	LitJson.JsonToken ArrayStart;
	LitJson.JsonToken ArrayEnd;
	LitJson.JsonToken Int;
	LitJson.JsonToken Long;
	LitJson.JsonToken Double;
	LitJson.JsonToken String;
	LitJson.JsonToken Boolean;
	LitJson.JsonToken Null;
}

// TypeDefIndex: 5803
class LitJson.JsonReader
{
	System.Collections.Generic.IDictionary<int, System.Collections.Generic.IDictionary<int, int[]>> parse_table;
	System.Collections.Generic.Stack<int> automaton_stack;
	int current_input;
	int current_symbol;
	bool end_of_json;
	bool end_of_input;
	LitJson.Lexer lexer;
	bool parser_in_string;
	bool parser_return;
	bool read_started;
	System.IO.TextReader reader;
	bool reader_is_owned;
	bool skip_non_members;
	object token_value;
	LitJson.JsonToken token;
	// property AllowComments
	// property AllowSingleQuotedStrings
	// property SkipNonMembers
	// property EndOfInput
	// property EndOfJson
	// property Token
	// property Value
	// RVA: 0x16e82b4
	bool get_AllowComments() { }
	// RVA: 0x16e82d0
	void set_AllowComments(bool value) { }
	// RVA: 0x16e82f0
	bool get_AllowSingleQuotedStrings() { }
	// RVA: 0x16e830c
	void set_AllowSingleQuotedStrings(bool value) { }
	// RVA: 0x16e832c
	bool get_SkipNonMembers() { }
	// RVA: 0x16e8334
	void set_SkipNonMembers(bool value) { }
	// RVA: 0x16e8340
	bool get_EndOfInput() { }
	// RVA: 0x16e8348
	bool get_EndOfJson() { }
	// RVA: 0x16e8350
	LitJson.JsonToken get_Token() { }
	// RVA: 0x16e8358
	object get_Value() { }
	// RVA: 0x16e8360
	void .cctor() { }
	// RVA: 0x16e8b1c
	void .ctor(string json_text) { }
	// RVA: 0x16e8d20
	void .ctor(System.IO.TextReader reader) { }
	// RVA: 0x16e8b8c
	void .ctor(System.IO.TextReader reader, bool owned) { }
	// RVA: 0x16e83b8
	System.Collections.Generic.IDictionary<int, System.Collections.Generic.IDictionary<int, int[]>> PopulateParseTable() { }
	// RVA: 0x16e8f10
	void TableAddCol(System.Collections.Generic.IDictionary<int, System.Collections.Generic.IDictionary<int, int[]>> parse_table, LitJson.ParserToken row, int col, int[] symbols) { }
	// RVA: 0x16e8e20
	void TableAddRow(System.Collections.Generic.IDictionary<int, System.Collections.Generic.IDictionary<int, int[]>> parse_table, LitJson.ParserToken rule) { }
	// RVA: 0x16e9044
	void ProcessNumber(string number) { }
	// RVA: 0x16e9298
	void ProcessSymbol() { }
	// RVA: 0x16e9458
	bool ReadToken() { }
	// RVA: 0x16e9680
	void Close() { }
	// RVA: 0x16e9750
	bool Read() { }
}

// TypeDefIndex: 5804
class LitJson.Condition
{
	int value__;
	LitJson.Condition InArray;
	LitJson.Condition InObject;
	LitJson.Condition NotAProperty;
	LitJson.Condition Property;
	LitJson.Condition Value;
}

// TypeDefIndex: 5805
class LitJson.WriterContext
{
	int Count;
	bool InArray;
	bool InObject;
	bool ExpectingValue;
	int Padding;
	// RVA: 0x16e9bb0
	void .ctor() { }
}

// TypeDefIndex: 5806
class LitJson.JsonWriter
{
	System.Globalization.NumberFormatInfo number_format;
	LitJson.WriterContext context;
	System.Collections.Generic.Stack<LitJson.WriterContext> ctx_stack;
	bool has_reached_end;
	char[] hex_seq;
	int indentation;
	int indent_value;
	System.Text.StringBuilder inst_string_builder;
	bool pretty_print;
	bool validate;
	bool lower_case_properties;
	System.IO.TextWriter writer;
	// property IndentValue
	// property PrettyPrint
	// property TextWriter
	// property Validate
	// property LowerCaseProperties
	// RVA: 0x16e9bb8
	int get_IndentValue() { }
	// RVA: 0x16e9bc0
	void set_IndentValue(int value) { }
	// RVA: 0x16e9bd4
	bool get_PrettyPrint() { }
	// RVA: 0x16e9bdc
	void set_PrettyPrint(bool value) { }
	// RVA: 0x16e9be8
	System.IO.TextWriter get_TextWriter() { }
	// RVA: 0x16e9bf0
	bool get_Validate() { }
	// RVA: 0x16e9bf8
	void set_Validate(bool value) { }
	// RVA: 0x16e9c04
	bool get_LowerCaseProperties() { }
	// RVA: 0x16e9c0c
	void set_LowerCaseProperties(bool value) { }
	// RVA: 0x16e9c18
	void .cctor() { }
	// RVA: 0x16e9c74
	void .ctor() { }
	// RVA: 0x16e9e6c
	void .ctor(System.Text.StringBuilder sb) { }
	// RVA: 0x16e9ed8
	void .ctor(System.IO.TextWriter writer) { }
	// RVA: 0x16e9f5c
	void DoValidation(LitJson.Condition cond) { }
	// RVA: 0x16e9d34
	void Init() { }
	// RVA: 0x16ea0e4
	void IntToHex(int n, char[] hex) { }
	// RVA: 0x16ea15c
	void Indent() { }
	// RVA: 0x16ea174
	void Put(string str) { }
	// RVA: 0x16ea200
	void PutNewline() { }
	// RVA: 0x16ea208
	void PutNewline(bool add_comma) { }
	// RVA: 0x16ea29c
	void PutString(string str) { }
	// RVA: 0x16ea5a4
	void Unindent() { }
	// RVA: 0x16ea5bc
	string ToString() { }
	// RVA: 0x16ea624
	void Reset() { }
	// RVA: 0x16ea710
	void Write(bool boolean) { }
	// RVA: 0x16ea7a8
	void Write(System.Decimal number) { }
	// RVA: 0x16ea884
	void Write(double number) { }
	// RVA: 0x16ea9c0
	void Write(int number) { }
	// RVA: 0x16eaa94
	void Write(long number) { }
	// RVA: 0x16eab68
	void Write(string str) { }
	// RVA: 0x16eabf4
	void Write(ulong number) { }
	// RVA: 0x16eacc8
	void WriteArrayEnd() { }
	// RVA: 0x16eadc8
	void WriteArrayStart() { }
	// RVA: 0x16eaebc
	void WriteObjectEnd() { }
	// RVA: 0x16eafbc
	void WriteObjectStart() { }
	// RVA: 0x16eb0b0
	void WritePropertyName(string property_name) { }
}

// TypeDefIndex: 5807
class LitJson.FsmContext
{
	bool Return;
	int NextState;
	LitJson.Lexer L;
	int StateStack;
	// RVA: 0x16eb1dc
	void .ctor() { }
}

// TypeDefIndex: 5808
class LitJson.Lexer.StateHandler
{
	// RVA: 0x16ebc20
	void .ctor(object object, nint method) { }
	// RVA: 0x16ed0b8
	bool Invoke(LitJson.FsmContext ctx) { }
	// RVA: 0x16ed0cc
	System.IAsyncResult BeginInvoke(LitJson.FsmContext ctx, System.AsyncCallback callback, object object) { }
	// RVA: 0x16ed0ec
	bool EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5809
class LitJson.Lexer
{
	int[] fsm_return_table;
	LitJson.Lexer+StateHandler[] fsm_handler_table;
	bool allow_comments;
	bool allow_single_quoted_strings;
	bool end_of_input;
	LitJson.FsmContext fsm_context;
	int input_buffer;
	int input_char;
	System.IO.TextReader reader;
	int state;
	System.Text.StringBuilder string_buffer;
	string string_value;
	int token;
	int unichar;
	// property AllowComments
	// property AllowSingleQuotedStrings
	// property EndOfInput
	// property Token
	// property StringValue
	// RVA: 0x16eb1e4
	bool get_AllowComments() { }
	// RVA: 0x16eb1ec
	void set_AllowComments(bool value) { }
	// RVA: 0x16eb1f8
	bool get_AllowSingleQuotedStrings() { }
	// RVA: 0x16eb200
	void set_AllowSingleQuotedStrings(bool value) { }
	// RVA: 0x16eb20c
	bool get_EndOfInput() { }
	// RVA: 0x16eb214
	int get_Token() { }
	// RVA: 0x16eb21c
	string get_StringValue() { }
	// RVA: 0x16eb224
	void .cctor() { }
	// RVA: 0x16e8d28
	void .ctor(System.IO.TextReader reader) { }
	// RVA: 0x16ebb9c
	int HexValue(int digit) { }
	// RVA: 0x16eb26c
	void PopulateFsmTables(LitJson.Lexer+StateHandler[]& fsm_handler_table, int[]& fsm_return_table) { }
	// RVA: 0x16ebd28
	char ProcessEscChar(int esc_char) { }
	// RVA: 0x16ebe18
	bool State1(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec020
	bool State2(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec0c8
	bool State3(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec204
	bool State4(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec2fc
	bool State5(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec378
	bool State6(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec474
	bool State7(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec508
	bool State8(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec5c4
	bool State9(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec62c
	bool State10(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec694
	bool State11(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec700
	bool State12(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec768
	bool State13(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec7d0
	bool State14(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec838
	bool State15(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec8a4
	bool State16(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec90c
	bool State17(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec974
	bool State18(LitJson.FsmContext ctx) { }
	// RVA: 0x16ec9e0
	bool State19(LitJson.FsmContext ctx) { }
	// RVA: 0x16eca88
	bool State20(LitJson.FsmContext ctx) { }
	// RVA: 0x16ecaf4
	bool State21(LitJson.FsmContext ctx) { }
	// RVA: 0x16ecc2c
	bool State22(LitJson.FsmContext ctx) { }
	// RVA: 0x16ecda0
	bool State23(LitJson.FsmContext ctx) { }
	// RVA: 0x16ece48
	bool State24(LitJson.FsmContext ctx) { }
	// RVA: 0x16ecebc
	bool State25(LitJson.FsmContext ctx) { }
	// RVA: 0x16ecf38
	bool State26(LitJson.FsmContext ctx) { }
	// RVA: 0x16ecfa0
	bool State27(LitJson.FsmContext ctx) { }
	// RVA: 0x16ed008
	bool State28(LitJson.FsmContext ctx) { }
	// RVA: 0x16ebff0
	bool GetChar() { }
	// RVA: 0x16ed080
	int NextChar() { }
	// RVA: 0x16e94ac
	bool NextToken() { }
	// RVA: 0x16ec1f8
	void UngetChar() { }
}

// TypeDefIndex: 5810
class LitJson.LitDictionary
{
	System.Collections.Generic.Dictionary<string, string> dic;
	// RVA: 0x16ed114
	void .ctor() { }
}

// TypeDefIndex: 5811
class LitJson.ParserToken
{
	int value__;
	LitJson.ParserToken None;
	LitJson.ParserToken Number;
	LitJson.ParserToken True;
	LitJson.ParserToken False;
	LitJson.ParserToken Null;
	LitJson.ParserToken CharSeq;
	LitJson.ParserToken Char;
	LitJson.ParserToken Text;
	LitJson.ParserToken Object;
	LitJson.ParserToken ObjectPrime;
	LitJson.ParserToken Pair;
	LitJson.ParserToken PairRest;
	LitJson.ParserToken Array;
	LitJson.ParserToken ArrayPrime;
	LitJson.ParserToken Value;
	LitJson.ParserToken ValueRest;
	LitJson.ParserToken String;
	LitJson.ParserToken End;
	LitJson.ParserToken Epsilon;
}

// TypeDefIndex: 5812
class MarSDK.Helper
{
	MarSDK.Helper Instance;
	// RVA: 0x16ed11c
	void Awake() { }
	// RVA: 0x16ed218
	void Init() { }
	// RVA: 0x16ed21c
	void .ctor() { }
}

// TypeDefIndex: 5813
class MarSDK.UiCanvas_Banner
{
	UnityEngine.UI.Button BtnClose;
	// RVA: 0x16ed224
	void Awake() { }
	// RVA: 0x16ed6d4
	void OnDestroy() { }
	// RVA: 0x16ed898
	void OnClickClose() { }
	// RVA: 0x16ed8bc
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16ed900
	void .ctor() { }
	// RVA: 0x16ed908
	void <Awake>b__1_0() { }
}

// TypeDefIndex: 5814
class MarSDK.UiCanvas_BigNative
{
	UnityEngine.UI.Button BtnClose;
	// RVA: 0x16ed90c
	void Awake() { }
	// RVA: 0x16eda90
	void OnDestroy() { }
	// RVA: 0x16edb00
	void OnClickClose() { }
	// RVA: 0x16edb24
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16edb68
	void .ctor() { }
	// RVA: 0x16edb70
	void <Awake>b__1_0() { }
}

// TypeDefIndex: 5815
class MarSDK.UiCanvas_Icon
{
	UnityEngine.UI.Button BtnClose;
	UnityEngine.RectTransform IconRectTransform;
	UnityEngine.RectTransform EndRectTransform;
	UnityEngine.RectTransform canvasRectTransform;
	// RVA: 0x16edb74
	void Awake() { }
	// RVA: 0x16edc9c
	void Init() { }
	// RVA: 0x16eddcc
	void OnDestroy() { }
	// RVA: 0x16ede3c
	void OnEnable() { }
	// RVA: 0x16ede40
	void OnClickClose() { }
	// RVA: 0x16ede64
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16edfdc
	void .ctor() { }
	// RVA: 0x16edfe4
	void <Awake>b__4_0() { }
}

// TypeDefIndex: 5816
class MarSDK.UiCanvas_Inters
{
	UnityEngine.UI.Button BtnClose;
	// RVA: 0x16edfe8
	void Awake() { }
	// RVA: 0x16ee154
	void OnDestroy() { }
	// RVA: 0x16ee1ac
	void OnClickClose() { }
	// RVA: 0x16ee1d0
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16ee204
	void .ctor() { }
	// RVA: 0x16ee20c
	void <Awake>b__1_0() { }
}

// TypeDefIndex: 5817
class MarSDK.UiCanvas_RewardVideo
{
	UnityEngine.UI.Button BtnClose;
	// RVA: 0x16ee210
	void Awake() { }
	// RVA: 0x16ee37c
	void OnDestroy() { }
	// RVA: 0x16ee3d4
	void OnClickClose() { }
	// RVA: 0x16ee6b0
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16ee6e4
	void .ctor() { }
	// RVA: 0x16ee6ec
	void <Awake>b__1_0() { }
}

// TypeDefIndex: 5818
class MarSDK.UiCanvas_Setting
{
	UnityEngine.UI.Button BtnClose;
	UnityEngine.UI.Button BtnToggleSound;
	UnityEngine.UI.Button BtnToggleVertial;
	UnityEngine.GameObject ObjSoundSign;
	UnityEngine.GameObject ObjVertialSign;
	// RVA: 0x16ee6f0
	void Awake() { }
	// RVA: 0x16ee8a0
	void ShowSound() { }
	// RVA: 0x16ee8a4
	void ShowVertial() { }
	// RVA: 0x16ee8a8
	void OnDestroy() { }
	// RVA: 0x16ee918
	void OnEnable() { }
	// RVA: 0x16ee91c
	void show() { }
	// RVA: 0x16ee984
	void OnClickToggleSound() { }
	// RVA: 0x16ee988
	void OnClickToggleVertial() { }
	// RVA: 0x16ee98c
	void OnClickClose() { }
	// RVA: 0x16ee9b0
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16ee9e4
	void .ctor() { }
	// RVA: 0x16ee9ec
	void <Awake>b__5_0() { }
	// RVA: 0x16ee9f0
	void <Awake>b__5_1() { }
	// RVA: 0x16ee9f4
	void <Awake>b__5_2() { }
}

// TypeDefIndex: 5819
class MarSDK.ClientEventType
{
	int value__;
	MarSDK.ClientEventType HiddenIcon;
	MarSDK.ClientEventType OpenIcon;
	MarSDK.ClientEventType OpenSettingPanel;
	MarSDK.ClientEventType OpenRewardVideo;
	MarSDK.ClientEventType OpenInters;
	MarSDK.ClientEventType OpenBigNative;
	MarSDK.ClientEventType OpenBanner;
	MarSDK.ClientEventType HiddenBanner;
	MarSDK.ClientEventType SelectNoVideo;
	MarSDK.ClientEventType SelectVideo;
	MarSDK.ClientEventType HidenBigNative;
	MarSDK.ClientEventType ShowPagePanel;
	MarSDK.ClientEventType ShowNativeLucency;
	MarSDK.ClientEventType HideNativeLucency;
	MarSDK.ClientEventType QRcode;
	MarSDK.ClientEventType CustomDialog;
}

// TypeDefIndex: 5820
class MarSDK.IClientEventListener
{
	// no-body
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
}

// TypeDefIndex: 5821
class MarSDK.EventManager
{
	System.Collections.Generic.Dictionary<MarSDK.ClientEventType, System.Collections.Generic.List<MarSDK.IClientEventListener>> _clientEventListener;
	// RVA: 0x16ed3a8
	void RegisterClientEventListener(MarSDK.ClientEventType type, MarSDK.IClientEventListener listener) { }
	// RVA: 0x16ed744
	void UnRegisterClientEventListener(MarSDK.ClientEventType type, MarSDK.IClientEventListener listener) { }
	// RVA: 0x16ee9f8
	void DispatchClientEvent(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16eeb8c
	void .ctor() { }
}

// TypeDefIndex: 5822
class MarSDK.IGlobalObject
{
	// no-body
	void Active() { }
	// no-body
	void Release() { }
}

// TypeDefIndex: 5823
class MarSDK.GlobalObjectManager
{
	System.Collections.Generic.List<MarSDK.IGlobalObject> _globalObjects;
	System.Collections.Generic.List<UnityEngine.GameObject> _gameObjects;
	// RVA: 0x16eec28
	void Retain(MarSDK.IGlobalObject go) { }
	// RVA: 0x16eed54
	void Retain(UnityEngine.GameObject go) { }
	// RVA: 0x16eeea8
	void Release() { }
	// RVA: 0x16ef0ec
	void ResourcesCleanUp() { }
	// RVA: 0x16ef0f4
	void .ctor() { }
}

// TypeDefIndex: 5824
class MarSDK.GlobalObject`1
{
	T _instance;
	// property Instance
	// no-body
	T get_Instance() { }
	// no-body
	void .ctor() { }
	// no-body
	void Init() { }
	// no-body
	void Active() { }
	// no-body
	void Release() { }
}

// TypeDefIndex: 5825
class MarSDK.IOSSDKManager
{
	MarSDK.IOSSDKManager _instance;
	// property Instance
	// RVA: 0x16ef0fc
	MarSDK.IOSSDKManager get_Instance() { }
	// RVA: 0x16ef3e4
	void MarSDKInit() { }
	// RVA: 0x16ef3e8
	void MarSDKLogin() { }
	// RVA: 0x16ef3ec
	void MarSDKLogOut() { }
	// RVA: 0x16ef3f0
	void MarSDKSwitchAccount() { }
	// RVA: 0x16ef3f4
	void MarSDKPay(string str) { }
	// RVA: 0x16ef3f8
	void MarSdkShowBanner(string msg) { }
	// RVA: 0x16ef3fc
	void MarSdkHiddenBanner() { }
	// RVA: 0x16ef400
	void MarSdkShowInters(string msg) { }
	// RVA: 0x16ef404
	void MarSdkShowVideo(string msg) { }
	// RVA: 0x16ef408
	void ShowHiddenVideo(string msg) { }
	// RVA: 0x16ef40c
	void SetUpKeyValueICloudStoreWithKey(string key, string value) { }
	// RVA: 0x16ef410
	string GetKeyValueICloudStoreWithKey(string key) { }
	// RVA: 0x16ef450
	void ShowRating(string appId) { }
	// RVA: 0x16ef454
	void CopyCommentContent() { }
	// RVA: 0x16ef458
	void reportCustomEvents(string eventId, string jsontext) { }
	// RVA: 0x16ef45c
	int GetResult(int index) { }
	// RVA: 0x16ef464
	void GameCenter() { }
	// RVA: 0x16ef468
	void ShowAchievementUI() { }
	// RVA: 0x16ef46c
	void SetAchievementProgress(string achievementId, float progress) { }
	// RVA: 0x16ef470
	void ShowNativeAd(string msg) { }
	// RVA: 0x16ef474
	void HiddenNativeAd() { }
	// RVA: 0x16ef478
	bool GetSplashFlag() { }
	// RVA: 0x16ef480
	bool GetIntersFlag() { }
	// RVA: 0x16ef488
	bool GetBannerFlag() { }
	// RVA: 0x16ef490
	bool GetRewradVideoFlag() { }
	// RVA: 0x16ef498
	bool GetNativeFlag() { }
	// RVA: 0x16ef4a0
	bool GetFloatIconFlag() { }
	// RVA: 0x16ef4a8
	void ShowBigNative(string data) { }
	// RVA: 0x16ef4ac
	void HiddenBigNative() { }
	// RVA: 0x16ef4b0
	void GameCenterMutualPush() { }
	// RVA: 0x16ef4b4
	void GameOverMutualPush() { }
	// RVA: 0x16ef4b8
	void HiddenMutualPush() { }
	// RVA: 0x16ef4bc
	void MarExitSDK() { }
	// RVA: 0x16ef4c0
	void MarSetPropDeliveredComplete(string orderId) { }
	// RVA: 0x16ef4c4
	void exchangeGiftbag(string msg) { }
	// RVA: 0x16ef4c8
	void openforum() { }
	// RVA: 0x16ef4cc
	void getMarGameData(string version) { }
	// RVA: 0x16ef4d0
	void MarGetBlockedWords(string msg) { }
	// RVA: 0x16ef4d4
	int MarRequestChannelValue() { }
	// RVA: 0x16ef4dc
	string MarRequestDeviceID() { }
	// RVA: 0x16ef51c
	bool isSingleGame() { }
	// RVA: 0x16ef524
	void submitExtraData(string data) { }
	// RVA: 0x16ef528
	void MarShowSplash(string data) { }
	// RVA: 0x16ef52c
	void MarShowFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x16ef530
	void MarSdkHideFloatIcon() { }
	// RVA: 0x16ef534
	void MarShowNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x16ef538
	void MarSdkHideNativeLucency() { }
	// RVA: 0x16ef53c
	bool GetCustomSwitch() { }
	// RVA: 0x16ef544
	void HideAchievementUI() { }
	// RVA: 0x16ef548
	void ShowLeaderboards() { }
	// RVA: 0x16ef54c
	void HideLeaderboards() { }
	// RVA: 0x16ef550
	void SetLeaderboardsProgress(string achievementId, float progress) { }
	// RVA: 0x16ef554
	void LocalPushMessage(string fireDate, string alertBody, bool isRepeatDay) { }
	// RVA: 0x16ef558
	void CleanNotification() { }
	// RVA: 0x16ef55c
	long getNewTime() { }
	// RVA: 0x16ef564
	void CrossPushAction(int type) { }
	// RVA: 0x16ef568
	void SetUserProperty(string param) { }
	// RVA: 0x16ef56c
	void UmRegisterEvent(string eventName) { }
	// RVA: 0x16ef570
	void OpenURL(string urlStr) { }
	// RVA: 0x16ef574
	bool IsNonConsumable(string productId) { }
	// RVA: 0x16ef57c
	void RestorePurchases(string productId) { }
	// RVA: 0x16ef580
	void .ctor() { }
}

// TypeDefIndex: 5826
class MarSDK.IosUnityCallBack
{
	MarSDK.IosUnityCallBack _instance;
	object _lock;
	// RVA: 0x16ef250
	MarSDK.IosUnityCallBack InitCallback() { }
	// RVA: 0x16ef588
	void Awake() { }
	// RVA: 0x16ef5f4
	void OnInitSDKSuccessful(string msg) { }
	// RVA: 0x16ef6f0
	void LogoInCallBack(string msg) { }
	// RVA: 0x16efab8
	void SendPropsCallBack(string msg) { }
	// RVA: 0x16efbd8
	void LogoOutCallBack(string msg) { }
	// RVA: 0x16efca0
	void ShowVideoCallBack(string msg) { }
	// RVA: 0x16efd68
	void GameCenterCallBack(string msg) { }
	// RVA: 0x16efe24
	void PayCallBack(string msg) { }
	// RVA: 0x16efa44
	void ShowOnLoginSuccessful(string msg) { }
	// RVA: 0x16effe8
	void ShowOnLoginFailed() { }
	// RVA: 0x16f0054
	bool IsLogin() { }
	// RVA: 0x16f005c
	void OnRedeemResult(string msg) { }
	// RVA: 0x16f0224
	void OnAdStatusResult(string msg) { }
	// RVA: 0x16f0700
	void setAppstoreRedemptionCodeRedemptionBlock(string productId) { }
	// RVA: 0x16f07a0
	void .ctor() { }
	// RVA: 0x16f07a8
	void .cctor() { }
}

// TypeDefIndex: 5827
class MarSDK.UnityToIOSManager
{
	MarSDK.UnityToIOSManager mInstance;
	long lastTime;
	int PushIndex;
	string PushText;
	System.Collections.Generic.List<string> ContentList;
	// RVA: 0x16f081c
	void Awake() { }
	// RVA: 0x16f0820
	void OnApplicationPause(bool paused) { }
	// RVA: 0x16f0824
	void Push() { }
	// RVA: 0x16f0828
	void NotificationMessage(string message, int hour, int minute, bool isRepeatDay) { }
	// RVA: 0x16f082c
	void NotificationMessage(string message, System.DateTime newDate, bool isRepeatDay) { }
	// RVA: 0x16f0830
	long GetTimeStamp(System.DateTime dt, bool bflag) { }
	// RVA: 0x16f0974
	void NotificationMessage() { }
	// RVA: 0x16f0978
	void CleanNotification() { }
	// RVA: 0x16f097c
	void WaitOneFrameClear() { }
	// RVA: 0x16f0980
	void .ctor() { }
}

// TypeDefIndex: 5828
class MarSDK.AdsPanel.<>c
{
	MarSDK.AdsPanel+<>c <>9;
	System.Action <>9__19_0;
	System.Action <>9__20_0;
	// RVA: 0x16f24dc
	void .cctor() { }
	// RVA: 0x16f2544
	void .ctor() { }
	// RVA: 0x16f254c
	void <OnClickBtnShowRewardVideo>b__19_0() { }
	// RVA: 0x16f25b4
	void <OnClickBtnShowHiddenRewardVideo>b__20_0() { }
}

// TypeDefIndex: 5829
class MarSDK.AdsPanel
{
	UnityEngine.UI.Button Btn_Back;
	UnityEngine.UI.Button Btn_ShowSplash;
	UnityEngine.UI.Button Btn_ShowInters;
	UnityEngine.UI.Button Btn_ShowBanner;
	UnityEngine.UI.Button Btn_HiddenBanner;
	UnityEngine.UI.Button Btn_ShowBigNative;
	UnityEngine.UI.Button Btn_HiddenBigNative;
	UnityEngine.UI.Button Btn_ShowRewardVideo;
	UnityEngine.UI.Button Btn_ShowHiddenRewardVideo;
	UnityEngine.UI.Button Btn_ShowIcon;
	UnityEngine.UI.Button Btn_HiddenIcon;
	// RVA: 0x16f0b68
	void Start() { }
	// RVA: 0x16f0f20
	void OnClickBtnBack() { }
	// RVA: 0x16f0f44
	void OnClickBtnShowSplash() { }
	// RVA: 0x16f1130
	void OnClickBtnShowInters() { }
	// RVA: 0x16f137c
	void OnClickBtnShowBanner() { }
	// RVA: 0x16f1590
	void OnClickBtnHiddenBanner() { }
	// RVA: 0x16f164c
	void OnClickBtnShowBigNative() { }
	// RVA: 0x16f1898
	void OnClickBtnHiddenBigNative() { }
	// RVA: 0x16f1954
	void OnClickBtnShowRewardVideo() { }
	// RVA: 0x16f1d68
	void OnClickBtnShowHiddenRewardVideo() { }
	// RVA: 0x16f2170
	void OnClickBtnShowIcon() { }
	// RVA: 0x16f23ec
	void OnClickBtnHiddenIcon() { }
	// RVA: 0x16f24a8
	void .ctor() { }
	// RVA: 0x16f24b0
	void <Start>b__11_0() { }
	// RVA: 0x16f24b4
	void <Start>b__11_1() { }
	// RVA: 0x16f24b8
	void <Start>b__11_2() { }
	// RVA: 0x16f24bc
	void <Start>b__11_3() { }
	// RVA: 0x16f24c0
	void <Start>b__11_4() { }
	// RVA: 0x16f24c4
	void <Start>b__11_5() { }
	// RVA: 0x16f24c8
	void <Start>b__11_6() { }
	// RVA: 0x16f24cc
	void <Start>b__11_7() { }
	// RVA: 0x16f24d0
	void <Start>b__11_8() { }
	// RVA: 0x16f24d4
	void <Start>b__11_9() { }
	// RVA: 0x16f24d8
	void <Start>b__11_10() { }
}

// TypeDefIndex: 5830
class MarSDK.FirstIn.<>c
{
	MarSDK.FirstIn+<>c <>9;
	MarSDK.MarSDKInterface+LoginSuccess <>9__4_0;
	MarSDK.MarSDKInterface+LoginFail <>9__4_1;
	MarSDK.MarSDKInterface+LoginOut <>9__4_2;
	MarSDK.MarSDKInterface+InitSDKSuccessful <>9__4_3;
	MarSDK.MarSDKInterface+InitSDKFail <>9__4_4;
	MarSDK.MarSDKInterface+SwitchAccount <>9__4_5;
	// RVA: 0x16f3118
	void .cctor() { }
	// RVA: 0x16f3180
	void .ctor() { }
	// RVA: 0x16f3188
	void <Awake>b__4_0(string msg) { }
	// RVA: 0x16f3448
	void <Awake>b__4_1() { }
	// RVA: 0x16f34b0
	void <Awake>b__4_2() { }
	// RVA: 0x16f3518
	void <Awake>b__4_3() { }
	// RVA: 0x16f3580
	void <Awake>b__4_4() { }
	// RVA: 0x16f35e8
	void <Awake>b__4_5(string msg) { }
}

// TypeDefIndex: 5831
class MarSDK.FirstIn
{
	MarSDK.FirstIn <Instance>k__BackingField;
	// property Instance
	// RVA: 0x16f261c
	MarSDK.FirstIn get_Instance() { }
	// RVA: 0x16f2664
	void set_Instance(MarSDK.FirstIn value) { }
	// RVA: 0x16f26bc
	void Awake() { }
	// RVA: 0x16f310c
	void Start() { }
	// RVA: 0x16f2bfc
	void Init() { }
	// RVA: 0x16f3110
	void .ctor() { }
}

// TypeDefIndex: 5832
class MarSDK.IOSPanel
{
	UnityEngine.UI.Button Btn_Back;
	UnityEngine.UI.Button Btn_ShowAchievementUI;
	UnityEngine.UI.Button Btn_SetAchievementProgress;
	// RVA: 0x16f3670
	void Start() { }
	// RVA: 0x16f37a8
	void OnClickBtnBack() { }
	// RVA: 0x16f37cc
	void OnClickBtnShowAchievementUI() { }
	// RVA: 0x16f3890
	void OnClickBtnSetAchievementProgress() { }
	// RVA: 0x16f398c
	void .ctor() { }
	// RVA: 0x16f3994
	void <Start>b__3_0() { }
	// RVA: 0x16f3998
	void <Start>b__3_1() { }
	// RVA: 0x16f399c
	void <Start>b__3_2() { }
}

// TypeDefIndex: 5833
class MarSDK.LoginPanel
{
	UnityEngine.UI.Button Btn_Back;
	UnityEngine.UI.Button Btn_Login;
	UnityEngine.UI.Button Btn_Logout;
	UnityEngine.UI.Button Btn_SwitchAccount;
	// RVA: 0x16f39a0
	void Start() { }
	// RVA: 0x16f3b28
	void OnClickBtnBack() { }
	// RVA: 0x16f3b4c
	void OnClickBtnLogin() { }
	// RVA: 0x16f3c5c
	void OnClickBtnLogout() { }
	// RVA: 0x16f3d2c
	void OnClickBtnSwitchAccount() { }
	// RVA: 0x16f3e3c
	void .ctor() { }
	// RVA: 0x16f3e44
	void <Start>b__4_0() { }
	// RVA: 0x16f3e48
	void <Start>b__4_1() { }
	// RVA: 0x16f3e4c
	void <Start>b__4_2() { }
	// RVA: 0x16f3e50
	void <Start>b__4_3() { }
}

// TypeDefIndex: 5834
class MarSDK.MenuPanel
{
	UnityEngine.GameObject ObjLoginPanel;
	UnityEngine.GameObject ObjAdsPanel;
	UnityEngine.GameObject ObjPayPanel;
	UnityEngine.GameObject ObjIosPanel;
	UnityEngine.GameObject ObjOthersPanel;
	UnityEngine.UI.Button Btn_Login;
	UnityEngine.UI.Button Btn_Ads;
	UnityEngine.UI.Button Btn_Pay;
	UnityEngine.UI.Button Btn_Ios;
	UnityEngine.UI.Button Btn_Others;
	// RVA: 0x16f3e54
	void Awake() { }
	// RVA: 0x16f3ec8
	void Start() { }
	// RVA: 0x16f40a0
	void OnClickBtnLogin() { }
	// RVA: 0x16f40c0
	void OnClickBtnAds() { }
	// RVA: 0x16f40e0
	void OnClickBtnPay() { }
	// RVA: 0x16f4100
	void OnClickBtnIOS() { }
	// RVA: 0x16f4120
	void OnClickBtnOther() { }
	// RVA: 0x16f4140
	void .ctor() { }
	// RVA: 0x16f4148
	void <Start>b__11_0() { }
	// RVA: 0x16f414c
	void <Start>b__11_1() { }
	// RVA: 0x16f4150
	void <Start>b__11_2() { }
	// RVA: 0x16f4154
	void <Start>b__11_3() { }
	// RVA: 0x16f4158
	void <Start>b__11_4() { }
}

// TypeDefIndex: 5835
class MarSDK.OtherPanel.<>c
{
	MarSDK.OtherPanel+<>c <>9;
	System.Action<string> <>9__14_0;
	System.Action<bool, bool> <>9__15_0;
	System.Action<string> <>9__16_0;
	System.Action<string> <>9__17_0;
	System.Action<string> <>9__21_0;
	// RVA: 0x16f5864
	void .cctor() { }
	// RVA: 0x16f58cc
	void .ctor() { }
	// RVA: 0x16f58d4
	void <OnClickBtnGetObbDownloadUrl>b__14_0(string msg) { }
	// RVA: 0x16f5960
	void <OnClickBlockedWords>b__15_0(bool reqSucess, bool isContain) { }
	// RVA: 0x16f5a5c
	void <OnClickSaveGame>b__16_0(string data) { }
	// RVA: 0x16f5ae8
	void <OnClickLoadGame>b__17_0(string data) { }
	// RVA: 0x16f5b74
	void <OnClickClearGameData>b__21_0(string data) { }
}

// TypeDefIndex: 5836
class MarSDK.OtherPanel
{
	UnityEngine.UI.Button Btn_Back;
	UnityEngine.UI.Button Btn_GetObbDownloadUrl;
	UnityEngine.UI.Button Btn_BlockdWords;
	UnityEngine.UI.Button Btn_SaveGame;
	UnityEngine.UI.Button Btn_LoadGame;
	UnityEngine.UI.Button Btn_UmcustomEvent;
	UnityEngine.UI.Button Btn_UmcustomEvents;
	UnityEngine.UI.Button Btn_GetChannelvalue;
	UnityEngine.UI.Button Btn_ClearGameData;
	UnityEngine.UI.Button Btn_SelectmutualPush;
	UnityEngine.UI.Button Btn_CentermutualPush;
	UnityEngine.UI.Button Btn_HiddenMutualPush;
	// RVA: 0x16f415c
	void Start() { }
	// RVA: 0x16f463c
	void OnClickBtnBack() { }
	// RVA: 0x16f4660
	void OnClickBtnGetObbDownloadUrl() { }
	// RVA: 0x16f48ac
	void OnClickBlockedWords() { }
	// RVA: 0x16f4b44
	void OnClickSaveGame() { }
	// RVA: 0x16f4dbc
	void OnClickLoadGame() { }
	// RVA: 0x16f5008
	void OnClickUmcustomEvent() { }
	// RVA: 0x16f50e8
	void OnClickUmcustomEvents() { }
	// RVA: 0x16f52e4
	void OnClickGetChannelValue() { }
	// RVA: 0x16f53a0
	void OnClickClearGameData() { }
	// RVA: 0x16f55ec
	void OnClickBtnSelectmutualPush() { }
	// RVA: 0x16f56ac
	void OnClickBtnCentermutualPush() { }
	// RVA: 0x16f576c
	void OnClickBtnHiddenMutualPush() { }
	// RVA: 0x16f582c
	void .ctor() { }
	// RVA: 0x16f5834
	void <Start>b__12_0() { }
	// RVA: 0x16f5838
	void <Start>b__12_1() { }
	// RVA: 0x16f583c
	void <Start>b__12_2() { }
	// RVA: 0x16f5840
	void <Start>b__12_3() { }
	// RVA: 0x16f5844
	void <Start>b__12_4() { }
	// RVA: 0x16f5848
	void <Start>b__12_5() { }
	// RVA: 0x16f584c
	void <Start>b__12_6() { }
	// RVA: 0x16f5850
	void <Start>b__12_7() { }
	// RVA: 0x16f5854
	void <Start>b__12_8() { }
	// RVA: 0x16f5858
	void <Start>b__12_9() { }
	// RVA: 0x16f585c
	void <Start>b__12_10() { }
	// RVA: 0x16f5860
	void <Start>b__12_11() { }
}

// TypeDefIndex: 5837
class MarSDK.PayPanel.<>c
{
	MarSDK.PayPanel+<>c <>9;
	UnityEngine.Events.UnityAction <>9__8_3;
	UnityEngine.Events.UnityAction <>9__8_4;
	// RVA: 0x16f6684
	void .cctor() { }
	// RVA: 0x16f66ec
	void .ctor() { }
	// RVA: 0x16f66f4
	void <Start>b__8_3() { }
	// RVA: 0x16f69bc
	void <Start>b__8_4() { }
}

// TypeDefIndex: 5838
class MarSDK.PayPanel
{
	UnityEngine.UI.Button Btn_Back;
	UnityEngine.UI.Button BtnBuyCoin1;
	UnityEngine.UI.Button BtnBuyCoin2;
	UnityEngine.UI.Button ResertButton;
	UnityEngine.UI.InputField GetGiftInputField;
	UnityEngine.UI.Button ExchangeButton;
	UnityEngine.UI.Text CoinSum;
	int CoinCount;
	// RVA: 0x16f5c00
	void Start() { }
	// RVA: 0x16f60dc
	void PayResults(string productId) { }
	// RVA: 0x16f61bc
	void .ctor() { }
	// RVA: 0x16f61c4
	void <Start>b__8_0() { }
	// RVA: 0x16f61e8
	void <Start>b__8_1(int code, string productId, string orderId) { }
	// RVA: 0x16f63b4
	void <Start>b__8_2(int propNumber, string propType, string msg, string listdata) { }
	// RVA: 0x16f6518
	void <Start>b__8_5() { }
	// RVA: 0x16f6550
	void <Start>b__8_6() { }
}

// TypeDefIndex: 5839
class MarSDK.AdParams
{
	int AD_TYPE_UNKNOW;
	int AD_TYPE_SPLASH;
	int AD_TYPE_BANNER;
	int AD_TYPE_INTERSTITIAL;
	int AD_TYPE_VIDEO;
	int AD_TYPE_NATIVEBIG;
	int AD_TYPE_FLOAT_ICON;
	int AD_TYPE_NATIVE_LUCENCY;
	int AD_LOAD_SUCCESS;
	int AD_LOAD_FAILED;
	int AD_SHOW_SUCCESS;
	int AD_SHOW_FAILED;
	int AD_CLICK;
	int AD_CLOSE;
	string platform;
	string adCode;
	string adSource;
	int adType;
	int adStatus;
	string error;
	string gamedata;
	// RVA: 0x16f06f8
	void .ctor() { }
}

// TypeDefIndex: 5840
class MarSDK.MarSDKInterface.InitSDKSuccessful
{
	// RVA: 0x16f2f24
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6d54
	void Invoke() { }
	// RVA: 0x16f6d68
	System.IAsyncResult BeginInvoke(System.AsyncCallback callback, object object) { }
	// RVA: 0x16f6d88
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5841
class MarSDK.MarSDKInterface.InitSDKFail
{
	// RVA: 0x16f2fc0
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6d94
	void Invoke() { }
	// RVA: 0x16f6da8
	System.IAsyncResult BeginInvoke(System.AsyncCallback callback, object object) { }
	// RVA: 0x16f6dc8
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5842
class MarSDK.MarSDKInterface.LoginSuccess
{
	// RVA: 0x16f2d3c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6dd4
	void Invoke(string msg) { }
	// RVA: 0x16f6de8
	System.IAsyncResult BeginInvoke(string msg, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f6e08
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5843
class MarSDK.MarSDKInterface.LoginFail
{
	// RVA: 0x16f2dec
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6e14
	void Invoke() { }
	// RVA: 0x16f6e28
	System.IAsyncResult BeginInvoke(System.AsyncCallback callback, object object) { }
	// RVA: 0x16f6e48
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5844
class MarSDK.MarSDKInterface.LoginOut
{
	// RVA: 0x16f2e88
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6e54
	void Invoke() { }
	// RVA: 0x16f6e68
	System.IAsyncResult BeginInvoke(System.AsyncCallback callback, object object) { }
	// RVA: 0x16f6e88
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5845
class MarSDK.MarSDKInterface.SwitchAccount
{
	// RVA: 0x16f305c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6e94
	void Invoke(string msg) { }
	// RVA: 0x16f6ea8
	System.IAsyncResult BeginInvoke(string msg, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f6ec8
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5846
class MarSDK.MarSDKInterface.PayResult
{
	// RVA: 0x16f5f9c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6ed4
	void Invoke(int code, string productId, string orderId) { }
	// RVA: 0x16f6ee8
	System.IAsyncResult BeginInvoke(int code, string productId, string orderId, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f6f84
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5847
class MarSDK.MarSDKInterface.RedeemResult
{
	// RVA: 0x16f603c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f6f90
	void Invoke(int propNumber, string propType, string msg, string list) { }
	// RVA: 0x16f6fa4
	System.IAsyncResult BeginInvoke(int propNumber, string propType, string msg, string list, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7050
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5848
class MarSDK.MarSDKInterface.RedemptionCode
{
	// RVA: 0x16f705c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f710c
	void Invoke(string productId) { }
	// RVA: 0x16f7120
	System.IAsyncResult BeginInvoke(string productId, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7140
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5849
class MarSDK.MarSDKInterface.ResourceResult
{
	// RVA: 0x16f714c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f71fc
	void Invoke(string msg) { }
	// RVA: 0x16f7210
	System.IAsyncResult BeginInvoke(string msg, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7230
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5850
class MarSDK.MarSDKInterface.GameArchiveResult
{
	// RVA: 0x16f723c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f72ec
	void Invoke(string msg) { }
	// RVA: 0x16f7300
	System.IAsyncResult BeginInvoke(string msg, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7320
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5851
class MarSDK.MarSDKInterface.BlockedWordsResult
{
	// RVA: 0x16f732c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f73cc
	void Invoke(bool reqSuccess, bool isContain) { }
	// RVA: 0x16f73e8
	System.IAsyncResult BeginInvoke(bool reqSuccess, bool isContain, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7490
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5852
class MarSDK.MarSDKInterface.ThirdPartyResult
{
	// RVA: 0x16f749c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f754c
	void Invoke(string msg) { }
	// RVA: 0x16f7560
	System.IAsyncResult BeginInvoke(string msg, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7580
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5853
class MarSDK.MarSDKInterface.SplashResult
{
	// RVA: 0x16f758c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f7694
	void Invoke(MarSDK.AdParams adParams) { }
	// RVA: 0x16f76a8
	System.IAsyncResult BeginInvoke(MarSDK.AdParams adParams, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f76c8
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5854
class MarSDK.MarSDKInterface.BannerResult
{
	// RVA: 0x16f76d4
	void .ctor(object object, nint method) { }
	// RVA: 0x16f77dc
	void Invoke(MarSDK.AdParams adParams) { }
	// RVA: 0x16f77f0
	System.IAsyncResult BeginInvoke(MarSDK.AdParams adParams, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7810
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5855
class MarSDK.MarSDKInterface.IntersResult
{
	// RVA: 0x16f781c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f7924
	void Invoke(MarSDK.AdParams adParams) { }
	// RVA: 0x16f7938
	System.IAsyncResult BeginInvoke(MarSDK.AdParams adParams, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7958
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5856
class MarSDK.MarSDKInterface.RewardVideo
{
	// RVA: 0x16f7964
	void .ctor(object object, nint method) { }
	// RVA: 0x16f7a14
	void Invoke(string code) { }
	// RVA: 0x16f7a28
	System.IAsyncResult BeginInvoke(string code, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7a48
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5857
class MarSDK.MarSDKInterface.VideoResult
{
	// RVA: 0x16f7a54
	void .ctor(object object, nint method) { }
	// RVA: 0x16f7b5c
	void Invoke(MarSDK.AdParams adParams) { }
	// RVA: 0x16f7b70
	System.IAsyncResult BeginInvoke(MarSDK.AdParams adParams, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7b90
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5858
class MarSDK.MarSDKInterface.NativeResult
{
	// RVA: 0x16f7b9c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f7ca4
	void Invoke(MarSDK.AdParams adParams) { }
	// RVA: 0x16f7cb8
	System.IAsyncResult BeginInvoke(MarSDK.AdParams adParams, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7cd8
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5859
class MarSDK.MarSDKInterface.FloatIconResult
{
	// RVA: 0x16f7ce4
	void .ctor(object object, nint method) { }
	// RVA: 0x16f7dec
	void Invoke(MarSDK.AdParams adParams) { }
	// RVA: 0x16f7e00
	System.IAsyncResult BeginInvoke(MarSDK.AdParams adParams, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7e20
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5860
class MarSDK.MarSDKInterface.NativeLucencyResult
{
	// RVA: 0x16f7e2c
	void .ctor(object object, nint method) { }
	// RVA: 0x16f7f34
	void Invoke(MarSDK.AdParams adParams) { }
	// RVA: 0x16f7f48
	System.IAsyncResult BeginInvoke(MarSDK.AdParams adParams, System.AsyncCallback callback, object object) { }
	// RVA: 0x16f7f68
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5861
class MarSDK.MarSDKInterface
{
	MarSDK.MarSDKInterface+InitSDKSuccessful OnInitSDKSuccessful;
	MarSDK.MarSDKInterface+InitSDKFail OnInitSDKFail;
	MarSDK.MarSDKInterface+LoginSuccess OnLoginSuccess;
	MarSDK.MarSDKInterface+LoginFail OnLoginFail;
	MarSDK.MarSDKInterface+LoginOut OnLoginOut;
	MarSDK.MarSDKInterface+SwitchAccount OnSwitchAccount;
	MarSDK.MarSDKInterface+PayResult OnPayResult;
	MarSDK.MarSDKInterface+RedeemResult OnRedeemResult;
	MarSDK.MarSDKInterface+RedemptionCode OnRedemptionCode;
	MarSDK.MarSDKInterface+ResourceResult OnResourceResult;
	MarSDK.MarSDKInterface+GameArchiveResult OnGameArchiveResult;
	MarSDK.MarSDKInterface+BlockedWordsResult OnBlockedWordsResult;
	MarSDK.MarSDKInterface+ThirdPartyResult OnThirdPartyResult;
	MarSDK.MarSDKInterface+SplashResult OnSplashResult;
	MarSDK.MarSDKInterface+BannerResult OnBannerResult;
	MarSDK.MarSDKInterface+IntersResult OnIntersResult;
	MarSDK.MarSDKInterface+RewardVideo OnRewardVideo;
	MarSDK.MarSDKInterface+VideoResult OnVideoResult;
	MarSDK.MarSDKInterface+NativeResult OnNativeResult;
	MarSDK.MarSDKInterface+FloatIconResult OnFloatIconResult;
	MarSDK.MarSDKInterface+NativeLucencyResult OnNativeLucencyResult;
	// no-body
	void Login() { }
	// no-body
	void Logout() { }
	// no-body
	void switchAccount() { }
	// no-body
	void submitExtraData(MARUserExtraData userExtraData) { }
	// no-body
	void Exit() { }
	// no-body
	void Pay(MARPayParams payParams) { }
	// no-body
	void SetPropDeliveredComplete(string orderId) { }
	// no-body
	void Gift(string msg) { }
	// no-body
	bool IsNonConsumable(string productId) { }
	// no-body
	void RestorePurchases(string productId) { }
	// no-body
	void ShowSplash(string data) { }
	// no-body
	void ShowBanner(string msg, string data) { }
	// no-body
	void HideBanner() { }
	// no-body
	bool getIntersFlag() { }
	// no-body
	void ShowInters(string data) { }
	// no-body
	bool getVideoFlag() { }
	// no-body
	void ShowReward(string data) { }
	// no-body
	bool getHiddenVideoFlag() { }
	// no-body
	void ShowHiddenVideo(string data) { }
	// no-body
	bool getBigNativeFlag() { }
	// no-body
	void showBigNative(string data) { }
	// no-body
	void hideBigNative() { }
	// no-body
	bool getFloatIconFlag() { }
	// no-body
	void ShowFloatIcon(float posx, float posy, string data) { }
	// no-body
	void HideFloatIcon() { }
	// no-body
	bool getNativeLucencyFlag() { }
	// no-body
	void ShowNativeLucency(float posx, float posy, string data) { }
	// no-body
	void HideNativeLucency() { }
	// no-body
	void CentermutualPush(int valueType) { }
	// no-body
	void CrossPushAction(int type) { }
	// no-body
	void setGameArchive(string GameArchiveVersion, string data) { }
	// no-body
	void getGameArchive(string GameArchiveVersion) { }
	// no-body
	void ClearGameArchive(string gameArchiveVersion) { }
	// no-body
	void UmCustomEvent(string eventId, string eventData) { }
	// no-body
	void UmRegisterEvent(string eventdata) { }
	// no-body
	void setUserProperty(string param) { }
	// no-body
	void setUserSetOnce(string param) { }
	// no-body
	void setTrackUserAdd(string param) { }
	// no-body
	void showProtocol() { }
	// no-body
	void showUserAgreement() { }
	// no-body
	void getGameObbRes(string version) { }
	// no-body
	void getBlockedWords(string words) { }
	// no-body
	int requestChannelValue() { }
	// no-body
	string requestDeviceID() { }
	// no-body
	bool isSingleGame() { }
	// no-body
	bool getCustomSwitch() { }
	// no-body
	void Openforum() { }
	// no-body
	long getNewTime() { }
	// RVA: 0x16f6b90
	bool checkPayParams(MARPayParams payParams) { }
	// RVA: 0x16f6ce0
	void OpenMoreGame() { }
	// RVA: 0x16f6ce4
	bool isSupportExit() { }
	// RVA: 0x16f6cec
	void setVibrator(long vibratorTime) { }
	// RVA: 0x16f6cf0
	int checkDRM() { }
	// RVA: 0x16f6cf8
	void updateApk() { }
	// RVA: 0x16f6cfc
	void callSpecialFinc(string funname, string json) { }
	// RVA: 0x16f6d00
	void ShowAchievementUI() { }
	// RVA: 0x16f6d04
	void SetAchievementProgress(string achievementId, float progress) { }
	// RVA: 0x16f6d08
	void HideAchievementUI() { }
	// RVA: 0x16f6d0c
	void ShowLeaderboards() { }
	// RVA: 0x16f6d10
	void SetLeaderboardsProgress(string rankingId, float progress) { }
	// RVA: 0x16f6d14
	void HideLeaderboards() { }
	// RVA: 0x16f6d18
	void Rate(string appId) { }
	// RVA: 0x16f6d1c
	void CopyCommentContent() { }
	// RVA: 0x16f6d20
	void GameCenter() { }
	// RVA: 0x16f6d24
	void OpenURL(string urlStr) { }
	// RVA: 0x16f6d28
	void CreateShortcut(System.Action<bool> csCallback) { }
	// RVA: 0x16f6d2c
	void FollowUserProfile(System.Action<bool> csCallback) { }
	// RVA: 0x16f6d30
	void showGridGame(int type, int sizeType, int top, int left, System.Action Show, System.Action Close, System.Action<string> Error, System.Action Click) { }
	// RVA: 0x16f6d34
	void hideGridGame(int type) { }
	// RVA: 0x16f6d38
	void startVRecorder(int maxtime, System.Action<string> onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x16f6d3c
	void stopVRecorder(System.Action<string> onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x16f6d40
	void shareVRecorder(System.Action<System.Collections.Generic.Dictionary<string, object>> onSuccess, System.Action<string> onFail) { }
	// RVA: 0x16f6d44
	void showSideBar(System.Action onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x16f6d48
	void kspayDiscount(System.Action<bool, string> callback) { }
	// RVA: 0x16f6d4c
	void .ctor() { }
}

// TypeDefIndex: 5862
class MarSDK.FromAndroid
{
	int InitSDKSuccessful;
	int InitSDKFail;
	int LoginSuccess;
	int LoginFail;
	int Exit;
	int PayResult;
	int onRedeemResult;
	int onResult;
	int onResourceResult;
	int LogOut;
	int onSwitchAccount;
	int getGameArchive;
	int OnSelectResult;
	int onAdResult;
	int ThirdResult;
	// RVA: 0x16f7f74
	void .ctor() { }
}

// TypeDefIndex: 5863
class MarSDK.SendAndroid
{
	int Login;
	int Pay;
	int ShowInter;
	int ShowBanner;
	int ShowRewardedVideo;
	int Gift;
	int payOK;
	int Exit;
	int ShowSplash;
	int getGameObbRes;
	int OpenMoment;
	int HideBanner;
	int getBigNativeFlag;
	int hideBigNative;
	int checkBigNative;
	int OpenMoreGame;
	int showBigNative;
	int UmCustomEvent;
	int switchAccount;
	int onLogout;
	int UmRegisterEvent;
	int setGameArchive;
	int getGameArchive;
	int showNativeInters;
	int setVibrator;
	int getBlockedWords;
	int ClearGameArchive;
	int showHiddenVideo;
	int callSpecialFinc;
	int ShowFloatIcon;
	int HideFloatIcon;
	int SelectmutualPush;
	int setUserProperty;
	int submitExtraData;
	int showProtocol;
	int showUserAgreement;
	int ShowNativeLucency;
	int HideNativeLucency;
	int SelectCrossPush;
	int updateApk;
	int setUserSetOnce;
	int setTrackUserAdd;
	// RVA: 0x16f7f7c
	void .ctor() { }
}

// TypeDefIndex: 5864
class MarSDK.CallSpecialFinc
{
	string TAPTAPSHARE;
	// RVA: 0x16f7f84
	void .ctor() { }
}

// TypeDefIndex: 5865
class MarSDK.MarSDKInterfaceDefault
{
	// RVA: 0x16f7f8c
	void CentermutualPush(int valueType) { }
	// RVA: 0x16f7ff4
	void ClearGameArchive(string gameArchiveVersion) { }
	// RVA: 0x16f805c
	void Exit() { }
	// RVA: 0x16f80c4
	bool getBigNativeFlag() { }
	// RVA: 0x16f80cc
	void getBlockedWords(string words) { }
	// RVA: 0x16f8158
	void getGameArchive(string GameArchiveVersion) { }
	// RVA: 0x16f81e4
	bool getHiddenVideoFlag() { }
	// RVA: 0x16f81ec
	bool getIntersFlag() { }
	// RVA: 0x16f81f4
	bool getVideoFlag() { }
	// RVA: 0x16f81fc
	void Gift(string msg) { }
	// RVA: 0x16f8288
	void HideBanner() { }
	// RVA: 0x16f8388
	void hideBigNative() { }
	// RVA: 0x16f8488
	void HideFloatIcon() { }
	// RVA: 0x16f8588
	void HideNativeLucency() { }
	// RVA: 0x16f8688
	bool isSupportExit() { }
	// RVA: 0x16f8690
	void Login() { }
	// RVA: 0x16f8750
	void Logout() { }
	// RVA: 0x16f8808
	void Openforum() { }
	// RVA: 0x16f8870
	void OpenMoreGame() { }
	// RVA: 0x16f88d8
	void Pay(MARPayParams payParams) { }
	// RVA: 0x16f8b94
	void getGameObbRes(string version) { }
	// RVA: 0x16f8c20
	int requestChannelValue() { }
	// RVA: 0x16f8c28
	void setGameArchive(string GameArchiveVersion, string data) { }
	// RVA: 0x16f8cdc
	void SetPropDeliveredComplete(string orderId) { }
	// RVA: 0x16f8d68
	void setVibrator(long vibratorTime) { }
	// RVA: 0x16f8e08
	void ShowBanner(string msg, string data) { }
	// RVA: 0x16f8f2c
	void showBigNative(string data) { }
	// RVA: 0x16f902c
	void ShowFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x16f91c4
	bool getNativeLucencyFlag() { }
	// RVA: 0x16f91cc
	void ShowNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x16f9364
	void ShowHiddenVideo(string data) { }
	// RVA: 0x16f9464
	void ShowInters(string data) { }
	// RVA: 0x16f9564
	void ShowReward(string data) { }
	// RVA: 0x16f9664
	void ShowSplash(string data) { }
	// RVA: 0x16f96cc
	void switchAccount() { }
	// RVA: 0x16f9734
	void UmCustomEvent(string eventId, string eventData) { }
	// RVA: 0x16f97e8
	void setUserProperty(string param) { }
	// RVA: 0x16f9874
	void setUserSetOnce(string param) { }
	// RVA: 0x16f9878
	void setTrackUserAdd(string param) { }
	// RVA: 0x16f987c
	void UmRegisterEvent(string eventName) { }
	// RVA: 0x16f9908
	bool isSingleGame() { }
	// RVA: 0x16f9910
	void submitExtraData(MARUserExtraData userExtraData) { }
	// RVA: 0x16f99c8
	bool getCustomSwitch() { }
	// RVA: 0x16f99d0
	int checkDRM() { }
	// RVA: 0x16f99d8
	void ShowAchievementUI() { }
	// RVA: 0x16f99dc
	void SetAchievementProgress(string achievementId, float progress) { }
	// RVA: 0x16f99e0
	void HideAchievementUI() { }
	// RVA: 0x16f99e4
	void ShowLeaderboards() { }
	// RVA: 0x16f99e8
	void HideLeaderboards() { }
	// RVA: 0x16f99ec
	void SetLeaderboardsProgress(string achievementId, float progress) { }
	// RVA: 0x16f99f0
	void showProtocol() { }
	// RVA: 0x16f99f4
	void showUserAgreement() { }
	// RVA: 0x16f99f8
	bool getFloatIconFlag() { }
	// RVA: 0x16f9a00
	long getNewTime() { }
	// RVA: 0x16f9a38
	void CrossPushAction(int type) { }
	// RVA: 0x16f9a70
	void .ctor() { }
}

// TypeDefIndex: 5866
class MarSDK.MarSDKInterfaceIOS
{
	// RVA: 0x16f9a78
	void Login() { }
	// RVA: 0x16f9af0
	void Logout() { }
	// RVA: 0x16f9b08
	void switchAccount() { }
	// RVA: 0x16f9b20
	void submitExtraData(MARUserExtraData userExtraData) { }
	// RVA: 0x16f9b88
	void Exit() { }
	// RVA: 0x16f9ba0
	void Pay(MARPayParams payParams) { }
	// RVA: 0x16f9d00
	void SetPropDeliveredComplete(string orderId) { }
	// RVA: 0x16f9d18
	void Gift(string msg) { }
	// RVA: 0x16f9d30
	bool IsNonConsumable(string productId) { }
	// RVA: 0x16f9d4c
	void RestorePurchases(string productId) { }
	// RVA: 0x16f9d64
	void ShowSplash(string data) { }
	// RVA: 0x16f9d7c
	void ShowBanner(string msg, string data) { }
	// RVA: 0x16f9d94
	void HideBanner() { }
	// RVA: 0x16f9dac
	bool getIntersFlag() { }
	// RVA: 0x16f9dc8
	void ShowInters(string data) { }
	// RVA: 0x16f9de0
	bool getVideoFlag() { }
	// RVA: 0x16f9dfc
	void ShowReward(string data) { }
	// RVA: 0x16f9e14
	bool getHiddenVideoFlag() { }
	// RVA: 0x16f9e30
	void ShowHiddenVideo(string data) { }
	// RVA: 0x16f9e48
	bool getBigNativeFlag() { }
	// RVA: 0x16f9e64
	void showBigNative(string data) { }
	// RVA: 0x16f9e7c
	void hideBigNative() { }
	// RVA: 0x16f9e94
	bool getFloatIconFlag() { }
	// RVA: 0x16f9eb0
	void ShowFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x16f9ec8
	void HideFloatIcon() { }
	// RVA: 0x16f9f40
	bool getNativeLucencyFlag() { }
	// RVA: 0x16f9f48
	void ShowNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x16f9f60
	void HideNativeLucency() { }
	// RVA: 0x16f9fd8
	void CentermutualPush(int valueType) { }
	// RVA: 0x16fa008
	void CrossPushAction(int type) { }
	// RVA: 0x16fa020
	void setGameArchive(string GameArchiveVersion, string data) { }
	// RVA: 0x16fa038
	void getGameArchive(string GameArchiveVersion) { }
	// RVA: 0x16fa0e4
	void ClearGameArchive(string gameArchiveVersion) { }
	// RVA: 0x16fa11c
	void UmCustomEvent(string eventId, string eventData) { }
	// RVA: 0x16fa134
	void UmRegisterEvent(string eventName) { }
	// RVA: 0x16fa14c
	void setUserProperty(string param) { }
	// RVA: 0x16fa1e8
	void setUserSetOnce(string param) { }
	// RVA: 0x16fa1ec
	void setTrackUserAdd(string param) { }
	// RVA: 0x16fa1f0
	void showProtocol() { }
	// RVA: 0x16fa1f4
	void showUserAgreement() { }
	// RVA: 0x16fa1f8
	void getGameObbRes(string version) { }
	// RVA: 0x16fa210
	void getBlockedWords(string words) { }
	// RVA: 0x16fa228
	int requestChannelValue() { }
	// RVA: 0x16fa244
	bool isSingleGame() { }
	// RVA: 0x16fa260
	bool getCustomSwitch() { }
	// RVA: 0x16fa27c
	void Openforum() { }
	// RVA: 0x16fa294
	long getNewTime() { }
	// RVA: 0x16fa2b0
	void OpenMoreGame() { }
	// RVA: 0x16fa318
	bool isSupportExit() { }
	// RVA: 0x16fa320
	void setVibrator(long vibratorTime) { }
	// RVA: 0x16fa3c0
	int checkDRM() { }
	// RVA: 0x16fa3c8
	void callSpecialFinc(string funname, string json) { }
	// RVA: 0x16fa3cc
	void ShowAchievementUI() { }
	// RVA: 0x16fa3e4
	void SetAchievementProgress(string achievementId, float progress) { }
	// RVA: 0x16fa3fc
	void HideAchievementUI() { }
	// RVA: 0x16fa414
	void ShowLeaderboards() { }
	// RVA: 0x16fa42c
	void HideLeaderboards() { }
	// RVA: 0x16fa444
	void SetLeaderboardsProgress(string achievementId, float progress) { }
	// RVA: 0x16fa45c
	void Rate(string appId) { }
	// RVA: 0x16fa474
	void CopyCommentContent() { }
	// RVA: 0x16fa48c
	void GameCenter() { }
	// RVA: 0x16fa4a4
	void OpenURL(string urlStr) { }
	// RVA: 0x16fa4bc
	string FixFromIOS(string utf8BytesMisreadAsLatin1) { }
	// RVA: 0x16fa544
	void .ctor() { }
}

// TypeDefIndex: 5867
class MarSDK.MarSDKManager.<>c__DisplayClass21_0
{
	MARPayParams payParams;
	System.Action<MARPayParams> Sucess;
	System.Action<MARPayParams> Fail;
	// RVA: 0x16fa858
	void .ctor() { }
	// RVA: 0x16fc2c8
	void <PayCall>b__0(int code, string productId, string orderId) { }
}

// TypeDefIndex: 5868
class MarSDK.MarSDKManager.<>c__DisplayClass26_0
{
	System.Action<string> callback;
	// RVA: 0x16fa934
	void .ctor() { }
	// RVA: 0x16fc42c
	void <SetGameArchive>b__0(string msg) { }
}

// TypeDefIndex: 5869
class MarSDK.MarSDKManager.<>c__DisplayClass27_0
{
	System.Action<string> callback;
	// RVA: 0x16fa93c
	void .ctor() { }
	// RVA: 0x16fc50c
	void <GetGameArchive>b__0(string msg) { }
}

// TypeDefIndex: 5870
class MarSDK.MarSDKManager.<>c__DisplayClass28_0
{
	System.Action<string> callback;
	// RVA: 0x16fa944
	void .ctor() { }
	// RVA: 0x16fc5ec
	void <ClearGameArchive>b__0(string msg) { }
}

// TypeDefIndex: 5871
class MarSDK.MarSDKManager.<>c__DisplayClass37_0
{
	System.Action onAdShowFailed;
	System.Action onAdShowSuccess;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	// RVA: 0x16fabb8
	void .ctor() { }
	// RVA: 0x16fc6cc
	void <ShowSplash>b__0(MarSDK.AdParams adparams) { }
}

// TypeDefIndex: 5872
class MarSDK.MarSDKManager.<>c__DisplayClass40_0
{
	System.Action onAdShowFailed;
	System.Action onAdShowSuccess;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	// RVA: 0x16fac20
	void .ctor() { }
	// RVA: 0x16fc750
	void <ShowBanner>b__0(MarSDK.AdParams adparams) { }
}

// TypeDefIndex: 5873
class MarSDK.MarSDKManager.<>c__DisplayClass45_0
{
	System.Action onAdShowSuccess;
	System.Action onAdShowFailed;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	// RVA: 0x16facd8
	void .ctor() { }
	// RVA: 0x16fc7d4
	void <ShowInters>b__0(MarSDK.AdParams adparams) { }
}

// TypeDefIndex: 5874
class MarSDK.MarSDKManager.<>c__DisplayClass49_0
{
	System.Action onAdShowSuccess;
	System.Action onAdShowFailed;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	System.Action success;
	System.Action fail;
	// RVA: 0x16fada8
	void .ctor() { }
	// RVA: 0x16fc858
	void <ShowReward>b__0(MarSDK.AdParams adparams) { }
	// RVA: 0x16fc934
	void <ShowReward>b__1(string code) { }
}

// TypeDefIndex: 5875
class MarSDK.MarSDKManager.<>c__DisplayClass53_0
{
	System.Action onAdShowSuccess;
	System.Action onAdShowFailed;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	System.Action success;
	System.Action fail;
	// RVA: 0x16fae78
	void .ctor() { }
	// RVA: 0x16fc9e8
	void <ShowHidenVideo>b__0(MarSDK.AdParams adparams) { }
	// RVA: 0x16fca6c
	void <ShowHidenVideo>b__1(string code) { }
}

// TypeDefIndex: 5876
class MarSDK.MarSDKManager.<>c__DisplayClass57_0
{
	System.Action onAdShowSuccess;
	System.Action onAdShowFailed;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	// RVA: 0x16faf30
	void .ctor() { }
	// RVA: 0x16fcb24
	void <ShowBigNative>b__0(MarSDK.AdParams adparams) { }
}

// TypeDefIndex: 5877
class MarSDK.MarSDKManager.<>c__DisplayClass62_0
{
	System.Action onAdShowSuccess;
	System.Action onAdShowFailed;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	// RVA: 0x16fb000
	void .ctor() { }
	// RVA: 0x16fcba8
	void <ShowFloatIcon>b__0(MarSDK.AdParams adparams) { }
}

// TypeDefIndex: 5878
class MarSDK.MarSDKManager.<>c__DisplayClass67_0
{
	System.Action onAdShowSuccess;
	System.Action onAdShowFailed;
	System.Action onAdClicked;
	System.Action OnAdClosed;
	// RVA: 0x16fb2d4
	void .ctor() { }
	// RVA: 0x16fcc2c
	void <ShowNativeLucency>b__0(MarSDK.AdParams adparams) { }
}

// TypeDefIndex: 5879
class MarSDK.MarSDKManager.<>c__DisplayClass75_0
{
	System.Action<string> callback;
	// RVA: 0x16fb474
	void .ctor() { }
	// RVA: 0x16fccb0
	void <getGameObbRes>b__0(string msg) { }
}

// TypeDefIndex: 5880
class MarSDK.MarSDKManager.<>c__DisplayClass76_0
{
	System.Action<bool, bool> callback;
	// RVA: 0x16fb47c
	void .ctor() { }
	// RVA: 0x16fccd4
	void <GetBlockedWords>b__0(bool reqSuccess, bool isContain) { }
}

// TypeDefIndex: 5881
class MarSDK.MarSDKManager
{
	string MarSdkVersion;
	string MarSdkMiniVersion;
	MarSDK.MarSDKManager _instance;
	MarSDK.MarSDKInterface _interface;
	bool IsLogin;
	string splashData;
	string bannerData;
	string intersData;
	string rewardData;
	string hidenVideoData;
	string bigNativeData;
	string floatIconData;
	string nativeLucencyData;
	// property Instance
	// property _marSDKInterface
	// RVA: 0x16ef818
	MarSDK.MarSDKManager get_Instance() { }
	// RVA: 0x16ee478
	MarSDK.MarSDKInterface get__marSDKInterface() { }
	// RVA: 0x16fa54c
	void Update() { }
	// RVA: 0x16fa684
	void Start() { }
	// RVA: 0x16fa688
	void OnDestroy() { }
	// RVA: 0x16fa6d8
	void OnApplicationPause(bool focus) { }
	// RVA: 0x16fa6dc
	int getWidth() { }
	// RVA: 0x16fa6e4
	int getHeight() { }
	// RVA: 0x16f3ba4
	void Login() { }
	// RVA: 0x16f3cb4
	void LogOut() { }
	// RVA: 0x16f3d84
	void SwitchAccount() { }
	// RVA: 0x16f33e0
	void submitExtraData(MARUserExtraData userExtraData) { }
	// RVA: 0x16fa624
	void Exit() { }
	// RVA: 0x16f692c
	void Pay(MARPayParams payParams) { }
	// RVA: 0x16fa6ec
	void PayCall(MARPayParams payParams, System.Action<MARPayParams> Sucess, System.Action<MARPayParams> Fail) { }
	// RVA: 0x16f634c
	void SetPropDeliveredComplete(string orderId) { }
	// RVA: 0x16f661c
	void GetGift(string code) { }
	// RVA: 0x16fa860
	bool IsNonConsumable(string productId) { }
	// RVA: 0x16fa8c8
	void RestorePurchases(string productId) { }
	// RVA: 0x16f4c98
	void SetGameArchive(string id, string data, System.Action<string> callback) { }
	// RVA: 0x16f4eec
	void GetGameArchive(string id, System.Action<string> callback) { }
	// RVA: 0x16f54d0
	void ClearGameArchive(string id, System.Action<string> callback) { }
	// RVA: 0x16f5078
	void UmCustomeEvent(string eventId) { }
	// RVA: 0x16fa94c
	void UmCustomeEvents(string eventId, string label) { }
	// RVA: 0x16f5230
	void UmCustomeEventDictionary(string eventId, System.Collections.Generic.Dictionary<string, string> eventData) { }
	// RVA: 0x16faa28
	void SetUserProperty(string param) { }
	// RVA: 0x16faa94
	void setUserSetOnce(string param) { }
	// RVA: 0x16fab00
	void setTrackUserAdd(string param) { }
	// RVA: 0x16fab6c
	void ShowSplash(string data, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f0fac
	void ShowSplash(System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16fabc0
	void ShowBanners(string msg, string data, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f13fc
	void ShowBanner(string msg, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f15e8
	void HidenBanner() { }
	// RVA: 0x16fac28
	bool IsInterFlag() { }
	// RVA: 0x16fac8c
	void ShowInters(string data, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f1198
	void ShowInters(System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16face0
	bool IsVideoFlag() { }
	// RVA: 0x16fad44
	void ShowReward(string data, System.Action success, System.Action fail, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f1a80
	void ShowReward(System.Action success, System.Action fail, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16fadb0
	bool IsHiddenVideoFlag() { }
	// RVA: 0x16fae14
	void ShowHidenVideo(string data, System.Action success, System.Action fail, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f1e94
	void ShowHidenVideo(System.Action success, System.Action fail, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16fae80
	bool IsBigNativeFlag() { }
	// RVA: 0x16faee4
	void ShowBigNative(string data, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f16b4
	void ShowBigNative(System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f18f0
	void HidenBigNative() { }
	// RVA: 0x16faf38
	bool getFloatIconFlag() { }
	// RVA: 0x16faf9c
	void ShowFloatIcon(float x, float y, string data, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f21e8
	void ShowFloatIcon(float x, float y, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16f2444
	void HidenFloatIcon() { }
	// RVA: 0x16fb008
	bool getNativeLucencyFlag() { }
	// RVA: 0x16fb06c
	void ShowNativeLucency(float x, float y, string data, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16fb0d0
	void ShowNativeLucency(float x, float y, System.Action onAdShowSuccess, System.Action onAdShowFailed, System.Action onAdClicked, System.Action OnAdClosed) { }
	// RVA: 0x16fb2dc
	void HideNativeLucency() { }
	// RVA: 0x16f5644
	void SelectmutualPush() { }
	// RVA: 0x16f5704
	void CentermutualPush() { }
	// RVA: 0x16f57c4
	void HiddenMutualPush() { }
	// RVA: 0x16fb340
	void CrossPushAction(int type) { }
	// RVA: 0x16fb3ac
	void showProtocol() { }
	// RVA: 0x16fb410
	void showUserAgreement() { }
	// RVA: 0x16f4790
	void getGameObbRes(string version, System.Action<string> callback) { }
	// RVA: 0x16f49dc
	void GetBlockedWords(string str, System.Action<bool, bool> callback) { }
	// RVA: 0x16f533c
	int RequestChannelValue() { }
	// RVA: 0x16fb484
	string RequestDeviceID() { }
	// RVA: 0x16fb4e8
	void setOpenforum() { }
	// RVA: 0x16f68c8
	bool isSingleGame() { }
	// RVA: 0x16fb54c
	bool getCustomSwitch() { }
	// RVA: 0x16fb5b0
	long getNewTime() { }
	// RVA: 0x16fb614
	void OpenMoreGame() { }
	// RVA: 0x16fb680
	bool isSupportExit() { }
	// RVA: 0x16fb6e4
	void setVibrator(long milliseconds) { }
	// RVA: 0x16fb758
	void checkDRM() { }
	// RVA: 0x16fb7c4
	void updateApk() { }
	// RVA: 0x16fb830
	void callSpecialFinc(string funname, string json) { }
	// RVA: 0x16f3824
	void ShowAchievementUI() { }
	// RVA: 0x16f3904
	void SetAchievementProgress(string achievementId, float progress) { }
	// RVA: 0x16fb8b8
	void HideAchievementUI() { }
	// RVA: 0x16fb924
	void ShowLeaderboards() { }
	// RVA: 0x16fb990
	void SetLeaderboardsProgress(string rankingId, float progress) { }
	// RVA: 0x16fba18
	void HideLeaderboards() { }
	// RVA: 0x16fba84
	void Rate(string appId) { }
	// RVA: 0x16fbaf8
	void CopyCommentContent() { }
	// RVA: 0x16fbb64
	void GameCenter() { }
	// RVA: 0x16fbbd0
	void CreateShortcut(System.Action<bool> csCallback) { }
	// RVA: 0x16fbc44
	void FollowUserProfile(System.Action<bool> csCallback) { }
	// RVA: 0x16fbcb8
	void showGridGame(int type, int sizeType, int top, int left, System.Action Show, System.Action Close, System.Action<string> Error, System.Action Click) { }
	// RVA: 0x16fbd94
	void hideGridGame(int type) { }
	// RVA: 0x16fbe00
	void startVRecorder(int maxtime, System.Action<string> onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x16fbe90
	void stopVRecorder(System.Action<string> onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x16fbf18
	void shareVRecorder(System.Action<System.Collections.Generic.Dictionary<string, object>> onSuccess, System.Action<string> onFail) { }
	// RVA: 0x16fbfa0
	void showSideBar(System.Action onSuccess, System.Action<int, string> onFail) { }
	// RVA: 0x16fc028
	void OpenURL(string urlStr) { }
	// RVA: 0x16fc094
	void kspayDiscount(System.Action<bool, string> callback) { }
	// RVA: 0x16fc108
	void ShowMarCutomDialog(MarCustomDialog+MarCutomDialogData data, System.Action<bool> callback) { }
	// RVA: 0x16fc224
	void .ctor() { }
	// RVA: 0x16fc22c
	void .cctor() { }
}

// TypeDefIndex: 5882
class MarSDK.BtnPage
{
	int Index;
	UnityEngine.UI.Button Btn;
	UnityEngine.GameObject ObjSelected;
	// RVA: 0x16fcd00
	void Awake() { }
	// RVA: 0x16fcdf0
	void OnDestroy() { }
	// RVA: 0x16fce48
	void OnClickBtn() { }
	// RVA: 0x16fcf54
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16fd018
	void .ctor() { }
	// RVA: 0x16fd020
	void <Awake>b__3_0() { }
}

// TypeDefIndex: 5883
class MarSDK.Page
{
	int Index;
	// RVA: 0x16fd024
	void Awake() { }
	// RVA: 0x16fd098
	void OnDestroy() { }
	// RVA: 0x16fd0f0
	void Start() { }
	// RVA: 0x16fd0f4
	void OnClientEventHandler(MarSDK.ClientEventType type, object[] param) { }
	// RVA: 0x16fd1bc
	void .ctor() { }
}

// TypeDefIndex: 5884
class MarSDK.AnalyticsManager
{
	MarSDK.AnalyticsManager _instance;
	AnalyticsInterface analyticsInterface;
	// property Instance
	// property _analyticsInterface
	// RVA: 0x16fd1c4
	MarSDK.AnalyticsManager get_Instance() { }
	// RVA: 0x16fd254
	AnalyticsInterface get__analyticsInterface() { }
	// RVA: 0x16fd4cc
	void Init() { }
	// RVA: 0x16fd4f0
	void setRegister(string msg) { }
	// RVA: 0x16fd51c
	void Login(string msg) { }
	// RVA: 0x16fd548
	void Pay(MARPayParams mARPayParams) { }
	// RVA: 0x16fd574
	void setCustom(string eventId, string eventData) { }
	// RVA: 0x16fd5b4
	void TrackAdEvent(MarSDK.AdParams adParams) { }
	// RVA: 0x16fd5e0
	void setUserProperty(string user) { }
	// RVA: 0x16fd60c
	void setUserSetOnce(string user) { }
	// RVA: 0x16fd638
	void setTrackUserAdd(string user) { }
	// RVA: 0x16fd24c
	void .ctor() { }
}

// TypeDefIndex: 5885
class MarSDK.HttpRequest.<DelayTime>d__21
{
	int <>1__state;
	object <>2__current;
	float time;
	System.Action action;
	int count;
	int <num>5__2;
	bool <isfor>5__3;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16fd8ac
	void .ctor(int <>1__state) { }
	// RVA: 0x16fe128
	void System.IDisposable.Dispose() { }
	// RVA: 0x16fe12c
	bool MoveNext() { }
	// RVA: 0x16fe24c
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16fe254
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16fe28c
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5886
class MarSDK.HttpRequest.<RequestGet>d__23
{
	int <>1__state;
	object <>2__current;
	UnityEngine.Networking.UnityWebRequest request;
	System.Action<UnityEngine.Networking.UnityWebRequest> callback;
	UnityEngine.Networking.UnityWebRequest <>7__wrap1;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16fd99c
	void .ctor(int <>1__state) { }
	// RVA: 0x16fe294
	void System.IDisposable.Dispose() { }
	// RVA: 0x16fe2b0
	bool MoveNext() { }
	// RVA: 0x16fe4b8
	void <>m__Finally1() { }
	// RVA: 0x16fe568
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16fe570
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16fe5a8
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5887
class MarSDK.HttpRequest.<RequestPost>d__25
{
	int <>1__state;
	object <>2__current;
	UnityEngine.Networking.UnityWebRequest request;
	System.Action<UnityEngine.Networking.UnityWebRequest> callback;
	UnityEngine.Networking.UnityWebRequest <>7__wrap1;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16fda90
	void .ctor(int <>1__state) { }
	// RVA: 0x16fe5b0
	void System.IDisposable.Dispose() { }
	// RVA: 0x16fe5cc
	bool MoveNext() { }
	// RVA: 0x16fe7d4
	void <>m__Finally1() { }
	// RVA: 0x16fe884
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16fe88c
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16fe8c4
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5888
class MarSDK.HttpRequest.<RequestPostJson>d__27
{
	int <>1__state;
	object <>2__current;
	UnityEngine.Networking.UnityWebRequest request;
	System.Action<UnityEngine.Networking.UnityWebRequest> callback;
	UnityEngine.Networking.UnityWebRequest <>7__wrap1;
	// property System.Collections.Generic.IEnumerator<System.Object>.Current
	// property System.Collections.IEnumerator.Current
	// RVA: 0x16fe8cc
	void .ctor(int <>1__state) { }
	// RVA: 0x16fe8f4
	void System.IDisposable.Dispose() { }
	// RVA: 0x16fe910
	bool MoveNext() { }
	// RVA: 0x16feb64
	void <>m__Finally1() { }
	// RVA: 0x16fec14
	object System.Collections.Generic.IEnumerator<System.Object>.get_Current() { }
	// RVA: 0x16fec1c
	void System.Collections.IEnumerator.Reset() { }
	// RVA: 0x16fec54
	object System.Collections.IEnumerator.get_Current() { }
}

// TypeDefIndex: 5889
class MarSDK.HttpRequest
{
	string Baseurl;
	string loginApi;
	string refToeknApi;
	string reportUser;
	string payApi;
	string payQuery;
	string checkOrder;
	string payComplete;
	string exGift;
	string wxPay;
	string tiktokPay;
	string kspay;
	string kspayDiscount;
	string adConfig;
	string trackBaseurl;
	string trackLinkApi;
	string trackActivateMultiApi;
	MarSDK.HttpRequest instance;
	// property Instance
	// RVA: 0x16fd664
	MarSDK.HttpRequest get_Instance() { }
	// RVA: 0x16fd800
	void setDelayTime(float time, int count, System.Action action) { }
	// RVA: 0x16fd820
	System.Collections.IEnumerator DelayTime(float time, int count, System.Action action) { }
	// RVA: 0x16fd8d4
	void HttpRequestGet(string url, System.Action<UnityEngine.Networking.UnityWebRequest> callback) { }
	// RVA: 0x16fd914
	System.Collections.IEnumerator RequestGet(UnityEngine.Networking.UnityWebRequest request, string url, System.Action<UnityEngine.Networking.UnityWebRequest> callback) { }
	// RVA: 0x16fd9c4
	void HttpRequestPost(string url, UnityEngine.WWWForm form, System.Action<UnityEngine.Networking.UnityWebRequest> callback) { }
	// RVA: 0x16fda08
	System.Collections.IEnumerator RequestPost(UnityEngine.Networking.UnityWebRequest request, string url, System.Action<UnityEngine.Networking.UnityWebRequest> callback) { }
	// RVA: 0x16fdab8
	void HttpRequestPostJson(string url, string json, System.Action<UnityEngine.Networking.UnityWebRequest> callback) { }
	// RVA: 0x16fdc00
	System.Collections.IEnumerator RequestPostJson(UnityEngine.Networking.UnityWebRequest request, string url, System.Action<UnityEngine.Networking.UnityWebRequest> callback) { }
	// RVA: 0x16fdc90
	void .ctor() { }
	// RVA: 0x16fe08c
	void .cctor() { }
}

// TypeDefIndex: 5890
class MarSDK.MarSDKMD5
{
	// RVA: 0x16fec5c
	string EncryptMD5_16(string _encryptContent) { }
	// RVA: 0x16fed30
	string EncryptMD5_32(string _encryptContent) { }
	// RVA: 0x16fee38
	string EncryptMD5_64(string _encryptContent) { }
	// RVA: 0x16feedc
	void .ctor() { }
}

// TypeDefIndex: 5891
class MarSDK.MiniSDKConfig
{
	bool onlineGame;
	int gameType;
	int gameId;
	string gameVersion;
	int gameVersionCode;
	int channelId;
	string sdkVersionCode;
	string userId;
	string token;
	string nickName;
	string openId;
	// RVA: 0x16feee4
	void .ctor() { }
	// RVA: 0x16feeec
	void .cctor() { }
}

// TypeDefIndex: 5892
class MarSDK.MiniTtrackConfig
{
	bool trackSwitch;
	string trackChannelId;
	string trackAppKey;
	string trackParams;
	string trackDeviceId;
	string trackOpenId;
	string deviceSource;
	string trackToken;
	// RVA: 0x16feffc
	void .ctor() { }
	// RVA: 0x16ff004
	void .cctor() { }
}

// TypeDefIndex: 5893
class MarSDK.MarSDKMiniManager.OrderSuccess
{
	// RVA: 0x1704b20
	void .ctor(object object, nint method) { }
	// RVA: 0x1704bd0
	void Invoke(string json) { }
	// RVA: 0x1704be4
	System.IAsyncResult BeginInvoke(string json, System.AsyncCallback callback, object object) { }
	// RVA: 0x1704c04
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5894
class MarSDK.MarSDKMiniManager.OrderFail
{
	// RVA: 0x1704c10
	void .ctor(object object, nint method) { }
	// RVA: 0x1704cac
	void Invoke() { }
	// RVA: 0x1704cc0
	System.IAsyncResult BeginInvoke(System.AsyncCallback callback, object object) { }
	// RVA: 0x1704ce0
	void EndInvoke(System.IAsyncResult result) { }
}

// TypeDefIndex: 5895
class MarSDK.MarSDKMiniManager.<>c__DisplayClass11_0
{
	MarSDK.MarSDKMiniManager <>4__this;
	string orderId;
	string productId;
	// RVA: 0x17004e0
	void .ctor() { }
	// RVA: 0x1704cec
	void <payQuery>b__0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5896
class MarSDK.MarSDKMiniManager.<>c__DisplayClass14_0
{
	MarSDK.MarSDKMiniManager <>4__this;
	string productId;
	string orderId;
	// RVA: 0x1700f48
	void .ctor() { }
	// RVA: 0x17052fc
	void <wxPay>b__0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5897
class MarSDK.MarSDKMiniManager.<>c__DisplayClass15_0
{
	MarSDK.MarSDKMiniManager <>4__this;
	string productId;
	string orderId;
	// RVA: 0x170121c
	void .ctor() { }
	// RVA: 0x17057d0
	void <tiktokPay>b__0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5898
class MarSDK.MarSDKMiniManager.<>c__DisplayClass16_0
{
	MarSDK.MarSDKMiniManager <>4__this;
	System.Action<bool, string> callback;
	// RVA: 0x170143c
	void .ctor() { }
	// RVA: 0x1705ca4
	void <kspayDiscount>b__0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5899
class MarSDK.MarSDKMiniManager.<>c__DisplayClass17_0
{
	MarSDK.MarSDKMiniManager <>4__this;
	string productId;
	string orderId;
	// RVA: 0x1701710
	void .ctor() { }
	// RVA: 0x17060f4
	void <ksPayBack>b__0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5900
class MarSDK.MarSDKMiniManager.<>c__DisplayClass8_0
{
	MarSDK.MarSDKMiniManager <>4__this;
	MARPayParams payParams;
	// RVA: 0x16ff8fc
	void .ctor() { }
	// RVA: 0x17065d0
	void <pay>b__0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5901
class MarSDK.MarSDKMiniManager.<>c__DisplayClass9_0
{
	MarSDK.MarSDKMiniManager <>4__this;
	MARPayParams payParams;
	// RVA: 0x16ffea0
	void .ctor() { }
	// RVA: 0x1706864
	void <createOrder>b__0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5902
class MarSDK.MarSDKMiniManager
{
	string TAG;
	MarSDK.MarSDKMiniManager instance;
	string AdKey;
	MARPayParams mARPayParams;
	bool startCheck;
	string orderKey;
	MarSDK.MarSDKMiniManager+OrderSuccess OnOrderSuccess;
	MarSDK.MarSDKMiniManager+OrderFail OnOrderFail;
	// property Instance
	// RVA: 0x16ff0e0
	MarSDK.MarSDKMiniManager get_Instance() { }
	// RVA: 0x16ff20c
	void login(string json) { }
	// RVA: 0x16ff45c
	void getAdConfigToApp() { }
	// RVA: 0x16ff6c4
	void pay(MARPayParams payParams) { }
	// RVA: 0x16ff904
	void createOrder(MARPayParams payParams) { }
	// RVA: 0x16ffea8
	void checkFailOrder() { }
	// RVA: 0x17000c0
	void payQuery(string productId, string orderId) { }
	// RVA: 0x17004e8
	void analyticsPay(string orderId) { }
	// RVA: 0x170073c
	void orderComplete(string orderId) { }
	// RVA: 0x1700c7c
	void wxPay(string productId, string orderId) { }
	// RVA: 0x1700f50
	void tiktokPay(string productId, string orderId) { }
	// RVA: 0x1701224
	void kspayDiscount(System.Action<bool, string> callback) { }
	// RVA: 0x1701444
	void ksPayBack(string productId, string orderId) { }
	// RVA: 0x1701718
	void checkOrder() { }
	// RVA: 0x1701ae0
	void queryLocal() { }
	// RVA: 0x1701ca0
	void saveOrder(string orderId, string productId, int orderMoney, string productName) { }
	// RVA: 0x1700960
	void removeOrder(string orderID) { }
	// RVA: 0x1702260
	void ascribeTrackLink() { }
	// RVA: 0x1702500
	void ascribeTrackActive() { }
	// RVA: 0x1702824
	void reportUserAscribeTrack() { }
	// RVA: 0x16ff164
	void .ctor() { }
	// RVA: 0x1702b54
	void <login>b__4_0(UnityEngine.Networking.UnityWebRequest request) { }
	// RVA: 0x170333c
	void <getAdConfigToApp>b__6_0(UnityEngine.Networking.UnityWebRequest request) { }
	// RVA: 0x1703ec4
	void <checkFailOrder>b__10_0(UnityEngine.Networking.UnityWebRequest request) { }
	// RVA: 0x1704434
	void <orderComplete>b__13_0(UnityEngine.Networking.UnityWebRequest request) { }
	// RVA: 0x17044fc
	void <checkOrder>b__19_0() { }
	// RVA: 0x1704500
	void <ascribeTrackLink>b__24_0(UnityEngine.Networking.UnityWebRequest request) { }
	// RVA: 0x17045d0
	void <ascribeTrackActive>b__25_0(UnityEngine.Networking.UnityWebRequest request) { }
	// RVA: 0x1704a58
	void <reportUserAscribeTrack>b__26_0(UnityEngine.Networking.UnityWebRequest request) { }
}

// TypeDefIndex: 5903
class MarSDK.OrderInfo
{
	string orderId;
	string productId;
	int orderMoney;
	string productName;
	// RVA: 0x1702258
	void .ctor() { }
}

// TypeDefIndex: 5904
class MarSDK.MggControl.<>c__DisplayClass59_0
{
	MarSDK.MggControl <>4__this;
	string data;
	// RVA: 0x170911c
	void .ctor() { }
	// RVA: 0x170b054
	void <showInterst>b__0() { }
}

// TypeDefIndex: 5905
class MarSDK.MggControl
{
	string TAG;
	MarSDK.MggControl instance;
	MarSDK.MggManageAdInterface mggManageAd;
	AdvertParams advertParams;
	bool isAdSwitch;
	bool splashSwitch;
	bool nativeSplashSwitch;
	bool bannerSwitch;
	bool nativeBannerSwitch;
	int refreshRate;
	int loadIntervalTime;
	string priority;
	int bannermaxCloseNum;
	bool intersSwitch;
	bool intersVideoSwitch;
	bool nativeIntersSwitch;
	bool nativeBigSwitch;
	int interstStartNum;
	int interstIntervalNum;
	int interstIntervalTime;
	bool interstEnableSwitch;
	int intersRatio;
	int nativeIntersRatio;
	int intersVideoRatio;
	int incentiveVideoRatio;
	int splashAdvertRatio;
	bool delayedSwitch;
	int ejectionTime;
	int ejectionEndTime;
	int ejectionInterval;
	bool videoSwitch;
	bool videoEnableSwitch;
	int videoStartNum;
	int videolimitNum;
	int videoIntervalTime;
	bool floatSwitch;
	bool nativeLucencySwitch;
	string[] bannerAdvertId;
	string[] intersAdvertId;
	string[] incentiveVideoAdvertId;
	string[] nativeBannerAdvertId;
	string[] nativeIntersAdvertId;
	string[] nativeBigPictureAdvertId;
	string[] floatIconAdvertId;
	bool customSwitch;
	int bannerCloseNum;
	int InStartNum;
	float delayedtime;
	long Inlasttime;
	string interstFalg;
	int VdStartNum;
	int VdCount;
	long Vdlasttime;
	// property Instance
	// RVA: 0x1703740
	MarSDK.MggControl get_Instance() { }
	// RVA: 0x1706e78
	void setMggManageAdInterface(MarSDK.MggManageAdInterface mggManage) { }
	// RVA: 0x17037c4
	void analysisMggControlData(string jsonstr) { }
	// RVA: 0x170703c
	void Init() { }
	// RVA: 0x17078ec
	void showSplash(string data) { }
	// RVA: 0x17078f0
	void showBnner(string msg, string data) { }
	// RVA: 0x1707d18
	void hideBnner() { }
	// RVA: 0x1708048
	bool getIntersFlag() { }
	// RVA: 0x1708e6c
	void showInterst(string data) { }
	// RVA: 0x1708328
	string getInterstControl() { }
	// RVA: 0x17088f4
	bool getNativeIntersFlag() { }
	// RVA: 0x17092f8
	void showNativeInters(string data) { }
	// RVA: 0x1708ac8
	bool getIntersVideoFlag() { }
	// RVA: 0x17094e8
	void showIntersVideo(string data) { }
	// RVA: 0x17096d8
	bool getVideoFlag() { }
	// RVA: 0x17098ac
	void showReward(string data) { }
	// RVA: 0x1708c9c
	bool getHiddenVideoFlag() { }
	// RVA: 0x1709a9c
	void showHiddenVideo(string data) { }
	// RVA: 0x1709e5c
	bool getBigNativeFlag() { }
	// RVA: 0x170a030
	void showBigNative(string data) { }
	// RVA: 0x170a220
	void hideBigNative() { }
	// RVA: 0x170a390
	void checkBigNative() { }
	// RVA: 0x170a394
	bool getFloatIconFlag() { }
	// RVA: 0x170a568
	void showFloatIcon(float posx, float posy, string data) { }
	// RVA: 0x170a884
	void hideFloatIcon() { }
	// RVA: 0x170a9f4
	bool getNativeLucencyFlag() { }
	// RVA: 0x170abc8
	void showNativeLucency(float posx, float posy, string data) { }
	// RVA: 0x170aee4
	void hideNativeLucency() { }
	// RVA: 0x1706f3c
	string[] shuffleIds(string[] ids) { }
	// RVA: 0x1709124
	long getTimeLong() { }
	// RVA: 0x1706dec
	void .ctor() { }
}

// TypeDefIndex: 5906
class MarSDK.MggAdInterface.<>c__DisplayClass21_0
{
	MarSDK.MggAdInterface <>4__this;
	int type;
	// RVA: 0x170ba88
	void .ctor() { }
	// RVA: 0x170bb20
	void <Init>b__0() { }
}

// TypeDefIndex: 5907
class MarSDK.MggAdInterface
{
	string TAG;
	string[] bannerAdvertId;
	string[] intersAdvertId;
	string[] incentiveVideoAdvertId;
	string[] nativeBannerAdvertId;
	string[] nativeIntersAdvertId;
	string[] nativeBigPictureAdvertId;
	string[] floatIconAdvertId;
	bool isload;
	bool isShow;
	string adid;
	int nextnum;
	int failnum;
	int adtype;
	string gamedata;
	// RVA: 0x170b390
	void setGameData(string data) { }
	// RVA: 0x170b398
	void OnLoad(bool loads, string msg) { }
	// RVA: 0x170b924
	void OnShow(bool show, string msg) { }
	// RVA: 0x170b93c
	void OnClose() { }
	// RVA: 0x170ba78
	void OnClick() { }
	// RVA: 0x170ba80
	bool isLoad() { }
	// RVA: 0x1707724
	void Init(int type) { }
	// RVA: 0x170b964
	void loadAD(int type) { }
	// no-body
	void load(string adid) { }
	// RVA: 0x170ba90
	void show() { }
	// RVA: 0x170ba94
	void show(string msg) { }
	// RVA: 0x170ba98
	void show(float posx, float posy) { }
	// no-body
	void hide() { }
	// RVA: 0x170b3c4
	void AdCallback(int adStatus) { }
	// RVA: 0x1709de4
	void RewardCallBack(string code) { }
	// RVA: 0x170ba9c
	void .ctor() { }
}

// TypeDefIndex: 5908
class MarSDK.MggManageAdInterface
{
	// no-body
	MarSDK.MggAdInterface MggAd(int type) { }
}

// TypeDefIndex: 5909
class MarSDK.MggAdType
{
	int Splash;
	int Banner;
	int Interst;
	int Reward;
	int HiddenVideo;
	int NativeBig;
	int FloatIcon;
	int NativeLucency;
	int NativeBanner;
	int NativeInterst;
	int NativeSplash;
	int InterstVideo;
	// RVA: 0x170bb40
	void .ctor() { }
}

// TypeDefIndex: 5910
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=12
{
}

// TypeDefIndex: 5911
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=14
{
}

// TypeDefIndex: 5912
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=20
{
}

// TypeDefIndex: 5913
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=24
{
}

// TypeDefIndex: 5914
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=28
{
}

// TypeDefIndex: 5915
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=32
{
}

// TypeDefIndex: 5916
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=36
{
}

// TypeDefIndex: 5917
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=44
{
}

// TypeDefIndex: 5918
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=112
{
}

// TypeDefIndex: 5919
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=7595
{
}

// TypeDefIndex: 5920
class <PrivateImplementationDetails>.__StaticArrayInitTypeSize=13087
{
}

// TypeDefIndex: 5921
class <PrivateImplementationDetails>
{
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=44 30B83693F58E7C9D49CEF9C24BBE541B599D50D373ABD9E838231748B02EFA0D;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=32 352FD86ADDED82F20D7AD5F044BA53EBF8DF8AE976442789E461C44B701993F9;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=28 4420AE9EA037FB50C498D08EF5FDD95C41735AEFF6842B6891AF4A30A6B7FD87;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=7595 523DE4D86151E56F83C11BC489AC855C540700D04555E3C368C46E83350DAF54;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=36 53AC29773768BF7F47096FC4E792CC6CF38727BB37DB760728EBB27475BC1077;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=20 544B72EACCCB43B26349B092A3D34F7BBEBC801F1E14ACCF3CA776A4EE55287D;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=12 59B7E757844D3BF9299877BD1C17451611BFBAB493374D6B18D973FDE534151A;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=12 5B979F69B96A61586A09DD4ED26F20534C629B08732AE32FA34B6F8A0049ACDD;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=44 5DEB3D520B61BF22A8AED9BEB9B63992298A3C67FF8E8D8505C792D9233819BD;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=12 7FCA397EF25DB53B2C58A05F9BBFA4E8E0685FDBC8AAF39536123447056895C0;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=28 929E76F9915235D6A60A8CF32587DB847C60FB81CAEB8F37002E6A1B4DC30B7D;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=12 B257E85A5D3CAB5E738D5A0FD1A7AE96624BFE92CB7915726CBBE1518C3225CF;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=12 B7A918F6F138CA8137025633559198B529D28CCEC5A51B005376CC69A5B83D85;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=112 C84227140A8A7787B30DFF8BD5693C19AA5A430C4E89FFD0256D7F77B3FEAD82;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=13087 E6C41C4D39768B3B2819E9955810C6CACB350D7FF019AD248EEFDD436489812F;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=14 EF55C9B0D74D5DB487F909A36F9BB1B546D4D9564365933731F67539AC80BDBF;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=12 FC03ECB1D62767A5B31230F548FA4D4C02F01E3DA8CA1FC66C7C332EA16BF206;
	<PrivateImplementationDetails>+__StaticArrayInitTypeSize=24 FCCF98AC160C12666AD4416BDE9496DB586878CBD0A125F874C82F3B90F53DA2;
	// RVA: 0x170bb48
	uint ComputeStringHash(string s) { }
}
