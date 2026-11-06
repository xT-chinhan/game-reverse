package com.mar.sdk.taptap;

import android.app.Activity;
import com.mar.sdk.MARSDK;
import com.mar.sdk.SDKParams;
import com.mar.sdk.gg.AdCtrl;
import com.mar.sdk.gg.AdEvent;
import com.mar.sdk.gg.AdInst;
import com.mar.sdk.log.Log;
import com.mar.sdk.taptap.ad.AutoRewardAd;
import com.mar.sdk.taptap.ad.BannerAd;
import com.mar.sdk.taptap.ad.InterstitalAd;
import com.mar.sdk.taptap.ad.NativeIntersAd;
import com.mar.sdk.taptap.ad.RewardAd;
import com.tapsdk.tapad.group.DirichletAdConfig;
import com.tapsdk.tapad.group.DirichletAdCustomController;
import com.tapsdk.tapad.group.DirichletSdk;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletAdCtrl extends AdCtrl {
    protected static final String TAG = "MARSDK-DirichletCtrl";
    private static final DirichletAdCtrl inst = new DirichletAdCtrl();
    public boolean isAuto = false;
    boolean isinit = false;
    private long mediaId;
    private String mediakey;
    private String medianame;
    private String splashId;

    public interface DirichletSdkCallBack {
        void init(boolean z);
    }

    public static DirichletAdCtrl Inst() {
        return inst;
    }

    public void parseParams(SDKParams params) {
        if (params == null) {
            Log.d(TAG, "DirichletAdCtrl -- parseParams() SDKParams is null");
            return;
        }
        this.mediaId = params.contains("Dirichlet_Media_Id") ? params.getLong("Dirichlet_Media_Id").longValue() : 0L;
        this.medianame = params.contains("Dirichlet_Media_Name") ? params.getString("Dirichlet_Media_Name") : "";
        this.mediakey = params.contains("Dirichlet_Media_Key") ? params.getString("Dirichlet_Media_Key") : "";
        this.isAuto = params.contains("Dirichlet_Auto_Ad") ? params.getBoolean("Dirichlet_Auto_Ad").booleanValue() : false;
        this.splashId = params.contains("Dirichlet_Splash_Id") ? params.getString("Dirichlet_Splash_Id") : "";
        String bannerId = params.contains("Dirichlet_Banner_Id") ? params.getString("Dirichlet_Banner_Id") : "";
        if (bannerId != null && bannerId.compareTo("") != 0) {
            this.bannerIdList = bannerId.split(";");
        }
        String intersId = params.contains("Dirichlet_Inters_Id") ? params.getString("Dirichlet_Inters_Id") : "";
        if (intersId != null && intersId.compareTo("") != 0) {
            this.intersIdList = intersId.split(";");
        }
        String videoId = params.contains("Dirichlet_Reward_Id") ? params.getString("Dirichlet_Reward_Id") : "";
        if (videoId != null && videoId.compareTo("") != 0) {
            this.videoIdList = videoId.split(";");
        }
        String nativeintersId = params.contains("Dirichlet_Native_IntersId") ? params.getString("Dirichlet_Native_IntersId") : "";
        if (nativeintersId != null && nativeintersId.compareTo("") != 0) {
            this.nativeIntersIdList = nativeintersId.split(";");
        }
    }

    public String getSplashId() {
        return this.splashId;
    }

    @Override // com.mar.sdk.gg.AdCtrl
    public void showSplash() {
    }

    /* JADX INFO: renamed from: com.mar.sdk.taptap.DirichletAdCtrl$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$mar$sdk$gg$AdEvent$InstType;

        static {
            int[] iArr = new int[AdEvent.InstType.values().length];
            $SwitchMap$com$mar$sdk$gg$AdEvent$InstType = iArr;
            try {
                iArr[AdEvent.InstType.banner.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$mar$sdk$gg$AdEvent$InstType[AdEvent.InstType.video.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$mar$sdk$gg$AdEvent$InstType[AdEvent.InstType.nativeInters.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$mar$sdk$gg$AdEvent$InstType[AdEvent.InstType.inters.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Override // com.mar.sdk.gg.AdCtrl
    protected AdInst genAd(AdEvent.InstType type) {
        switch (AnonymousClass3.$SwitchMap$com$mar$sdk$gg$AdEvent$InstType[type.ordinal()]) {
            case 1:
                return new BannerAd();
            case 2:
                if (this.isAuto) {
                    return AutoRewardAd.getInstance();
                }
                return RewardAd.getInstance();
            case 3:
                return new NativeIntersAd();
            case 4:
                return new InterstitalAd();
            default:
                return null;
        }
    }

    public void initTapAd(Activity activity, final DirichletSdkCallBack callBack) {
        if (this.isinit) {
            return;
        }
        DirichletAdConfig config = new DirichletAdConfig.Builder().withMediaId(this.mediaId).withMediaName(this.medianame).withMediaKey(this.mediakey).enableDebug(false).withCustomController(new DirichletAdCustomController() { // from class: com.mar.sdk.taptap.DirichletAdCtrl.1
            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public boolean isCanUseLocation() {
                return false;
            }

            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public boolean isCanUsePhoneState() {
                return false;
            }

            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public String getDevImei() {
                return null;
            }

            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public boolean isCanUseWifiState() {
                return false;
            }

            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public boolean isCanUseWriteExternal() {
                return false;
            }

            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public String getDevOaid() {
                return null;
            }

            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public boolean alist() {
                return false;
            }

            @Override // com.tapsdk.tapad.group.DirichletAdCustomController
            public boolean isCanUseAndroidId() {
                return true;
            }
        }).build();
        DirichletSdk.init(MARSDK.getInstance().getApplication(), config, new DirichletSdk.InitListener() { // from class: com.mar.sdk.taptap.DirichletAdCtrl.2
            @Override // com.tapsdk.tapad.group.DirichletSdk.InitListener
            public void onInitSuccess() {
                Log.d(DirichletAdCtrl.TAG, "初始化成功");
                DirichletAdCtrl.this.isinit = true;
                MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.taptap.DirichletAdCtrl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DirichletAdCtrl.this.initAd();
                    }
                });
                DirichletSdkCallBack dirichletSdkCallBack = callBack;
                if (dirichletSdkCallBack != null) {
                    dirichletSdkCallBack.init(true);
                }
            }

            @Override // com.tapsdk.tapad.group.DirichletSdk.InitListener
            public void onInitFail(int code, String msg) {
                Log.d(DirichletAdCtrl.TAG, "初始化失败: " + code + ", " + msg);
                DirichletSdkCallBack dirichletSdkCallBack = callBack;
                if (dirichletSdkCallBack != null) {
                    dirichletSdkCallBack.init(false);
                }
            }
        });
    }
}
