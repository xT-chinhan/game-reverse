package com.mar.sdk.taptap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.mar.sdk.log.Log;
import com.tapsdk.tapad.group.DirichletAdManager;
import com.tapsdk.tapad.group.DirichletAdNative;
import com.tapsdk.tapad.group.DirichletAdRequest;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletSplashActivity extends Activity {
    protected static final String TAG = "MARSDK-TaptapSplashAd";
    private boolean gameStart = false;
    private FrameLayout frameLayout = new FrameLayout(this);
    private boolean isStart = false;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addContentView(this.frameLayout, new FrameLayout.LayoutParams(-1, -1));
        try {
            this.gameStart = getIntent().getBooleanExtra("game_start", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DirichletAdCtrl.Inst().initTapAd(this, new DirichletAdCtrl.DirichletSdkCallBack() { // from class: com.mar.sdk.taptap.DirichletSplashActivity.1
            @Override // com.mar.sdk.taptap.DirichletAdCtrl.DirichletSdkCallBack
            public void init(final boolean isinit) {
                DirichletSplashActivity.this.runOnUiThread(new Runnable() { // from class: com.mar.sdk.taptap.DirichletSplashActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (isinit) {
                            DirichletSplashActivity.this.showAd();
                        } else {
                            DirichletSplashActivity.this.startGameActivity();
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAd() {
        DirichletAdNative adNative = DirichletAdManager.get().createAdNative(this);
        int spaceId = 0;
        try {
            spaceId = Integer.parseInt(DirichletAdCtrl.Inst().getSplashId());
        } catch (Exception e) {
            Log.d(TAG, "SplashActivity spaceId:0 Exception:" + e.toString());
        }
        DirichletAdRequest request = new DirichletAdRequest.Builder().withSpaceId(spaceId).withExpressViewAcceptedSize(-1, -1).build();
        adNative.showSplashAutoAd(request, this.frameLayout, new DirichletAdNative.SplashAutoAdListener() { // from class: com.mar.sdk.taptap.DirichletSplashActivity.2
            @Override // com.tapsdk.tapad.group.CommonListener
            public void onError(int code, String message) {
                Log.e("DirichletAd", "开屏自动加载失败: " + code + ", " + message);
                DirichletSplashActivity.this.startGameActivity();
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletSplashAd.AdInteractionListener
            public void onAdShow() {
                Log.d("DirichletAd", "开屏展示");
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletSplashAd.AdInteractionListener
            public void onAdClick() {
                Log.d("DirichletAd", "开屏点击");
            }

            @Override // com.tapsdk.tapad.group.ads.DirichletSplashAd.AdInteractionListener
            public void onAdClose() {
                Log.d("DirichletAd", "开屏关闭");
                DirichletSplashActivity.this.startGameActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGameActivity() {
        if (this.isStart) {
            return;
        }
        if (this.gameStart) {
            finish();
            this.isStart = true;
            return;
        }
        Log.d(TAG, "splash activity to next activity");
        try {
            Class<?> mainClass = Class.forName("{MARSDK_Game_Activity}");
            Intent intent = new Intent(this, mainClass);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            finish();
            e.printStackTrace();
        }
        this.isStart = true;
    }
}
