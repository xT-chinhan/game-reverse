package com.mar.sdk.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.IAdListener;
import com.mar.sdk.gg.IMgg;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleAd implements IMgg {
    private TextView banner;
    private TextView bigNative;
    private TextView interts;
    private Activity mActivity;
    private final String TAG = "MARSDK";
    private int orientation = MARSDK.getInstance().getContext().getResources().getConfiguration().orientation;

    public SimpleAd(Activity activity) {
        this.mActivity = activity;
        this.banner = new TextView(this.mActivity);
        this.interts = new TextView(this.mActivity);
        this.bigNative = new TextView(this.mActivity);
    }

    @Override // com.mar.sdk.gg.IMgg
    public void checkBannerNative() {
        Log.d("MARSDK", "checkBannerNative: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void checkBigNative() {
        Log.d("MARSDK", "checkBigNative: ");
    }

    public int dp2px(float f) {
        return (int) ((f * MARSDK.getInstance().getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getBigNativeFlag() {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getFloatIconFlag() {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getIntersFlag() {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getIntersVideoFlag() {
        return false;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNativeIntersFlag() {
        return false;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNativeLucencyFlag() {
        return false;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNativeSplashFlag() {
        Log.d("MARSDK", "getNativeSplashFlag");
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNavigatePasterFlag() {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getVideoFlag() {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideBanner() {
        Log.d("MARSDK", "hideBanner: ");
        if (this.banner.getParent() != null) {
            ((ViewGroup) this.banner.getParent()).removeView(this.banner);
        }
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideBigNative() {
        Log.d("MARSDK", "hideBigNative: ");
        if (this.bigNative.getParent() != null) {
            ((ViewGroup) this.bigNative.getParent()).removeView(this.bigNative);
        }
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideFloatIcon() {
        Log.d("MARSDK", "hideFloatIcon");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideNativeBanner() {
        Log.d("MARSDK", "hideNativeBanner: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideNativeLucency() {
        Log.d("MARSDK", "hideNativeLucency");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideNavigatePaster() {
        Log.d("MARSDK", "hideNavigatePaster: ");
    }

    @Override // com.mar.sdk.IPlugin
    public boolean isSupportMethod(String str) {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void reportNavigatePasterClick() {
        Log.d("MARSDK", "reportNavigatePasterClick: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void setListener(IAdListener iAdListener) {
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showBanner(int i) {
        Log.d("MARSDK", "showBanner: ");
        if (this.banner.getParent() != null) {
            ((ViewGroup) this.banner.getParent()).removeView(this.banner);
        }
        FrameLayout.LayoutParams layoutParams = this.orientation == 1 ? new FrameLayout.LayoutParams(-1, dp2px(50.0f)) : new FrameLayout.LayoutParams(dp2px(360.0f), dp2px(50.0f));
        layoutParams.gravity = (i == 1 ? 48 : 80) | 1;
        this.banner.setText("展示banner,点击关闭");
        this.banner.setGravity(17);
        this.banner.setBackgroundColor(-16776961);
        this.banner.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.impl.SimpleAd.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SimpleAd.this.banner.getParent() != null) {
                    ((ViewGroup) SimpleAd.this.banner.getParent()).removeView(SimpleAd.this.banner);
                }
            }
        });
        this.mActivity.addContentView(this.banner, layoutParams);
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showBigNative() {
        Log.d("MARSDK", "showBigNative: ");
        if (this.bigNative.getParent() != null) {
            ((ViewGroup) this.bigNative.getParent()).removeView(this.bigNative);
        }
        FrameLayout.LayoutParams layoutParams = this.orientation == 1 ? new FrameLayout.LayoutParams(-1, dp2px(200.0f)) : new FrameLayout.LayoutParams(dp2px(360.0f), dp2px(300.0f));
        layoutParams.gravity = 81;
        this.bigNative.setText("展示BigNative,点击关闭");
        this.bigNative.setGravity(17);
        this.bigNative.setBackgroundColor(-16776961);
        this.bigNative.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.impl.SimpleAd.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SimpleAd.this.bigNative.getParent() != null) {
                    ((ViewGroup) SimpleAd.this.bigNative.getParent()).removeView(SimpleAd.this.bigNative);
                }
            }
        });
        this.mActivity.addContentView(this.bigNative, layoutParams);
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showFloatIcon(double d, double d2) {
        Log.d("MARSDK", "showFloatIcon");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showInters() {
        Log.d("MARSDK", "showInters: ");
        if (this.interts.getParent() != null) {
            ((ViewGroup) this.interts.getParent()).removeView(this.interts);
        }
        FrameLayout.LayoutParams layoutParams = this.orientation == 1 ? new FrameLayout.LayoutParams(-1, dp2px(300.0f)) : new FrameLayout.LayoutParams(dp2px(360.0f), dp2px(300.0f));
        layoutParams.gravity = 17;
        this.interts.setText("展示插屏,点击关闭");
        this.interts.setGravity(17);
        this.interts.setBackgroundColor(-16776961);
        this.interts.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.impl.SimpleAd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SimpleAd.this.interts.getParent() != null) {
                    ((ViewGroup) SimpleAd.this.interts.getParent()).removeView(SimpleAd.this.interts);
                }
            }
        });
        this.mActivity.addContentView(this.interts, layoutParams);
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showIntersVideo() {
        Log.d("MARSDK", "showIntersVideo: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeBanner() {
        Log.d("MARSDK", "showNativeBanner: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeInters() {
        Log.d("MARSDK", "showNativeInters: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeLucency(double d, double d2) {
        Log.d("MARSDK", "showNativeLucency:" + d + "||y:" + d2);
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeSplash() {
        Log.d("MARSDK", "showNativeSplash");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNavigatePaster() {
        Log.d("MARSDK", "showNavigatePaster: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showSplash() {
        Log.d("MARSDK", "showSplash: ");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showVideo() {
        Log.d("MARSDK", "showVideo: ");
        AlertDialog.Builder builder = new AlertDialog.Builder(MARSDK.getInstance().getContext());
        builder.setTitle("激励视频");
        builder.setMessage("是否获取奖励");
        builder.setNegativeButton("关闭", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.impl.SimpleAd.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MARSDK.getInstance().onResult(100, "0");
                dialogInterface.dismiss();
            }
        });
        builder.setNeutralButton("获取奖励", new DialogInterface.OnClickListener() { // from class: com.mar.sdk.impl.SimpleAd.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MARSDK.getInstance().onResult(100, "1");
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }
}
