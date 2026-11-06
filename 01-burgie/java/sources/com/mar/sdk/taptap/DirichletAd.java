package com.mar.sdk.taptap;

import android.app.Activity;
import android.content.Intent;
import com.mar.sdk.MARSDK;
import com.mar.sdk.gg.IAdListener;
import com.mar.sdk.gg.IMgg;
import com.mar.sdk.log.Log;

/* JADX INFO: loaded from: classes2.dex */
public class DirichletAd implements IMgg {
    private static final String TAG = "MARSDK-Dirichlet";

    public DirichletAd(Activity context) {
        DirichletAdCtrl.Inst().initTapAd(context, null);
    }

    @Override // com.mar.sdk.IPlugin
    public boolean isSupportMethod(String methodName) {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void setListener(IAdListener listener) {
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showBanner(int pos) {
        Log.d(TAG, "Dirichlet showBanner");
        DirichletAdCtrl.Inst().showBanner(pos);
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideBanner() {
        Log.d(TAG, "Dirichlet hideBanner");
        DirichletAdCtrl.Inst().hideBanner();
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getIntersFlag() {
        Log.d(TAG, "Dirichlet getIntersFlag");
        return DirichletAdCtrl.Inst().getIntersFlag();
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showInters() {
        Log.d(TAG, "Dirichlet showInters");
        DirichletAdCtrl.Inst().showInters();
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getIntersVideoFlag() {
        Log.d(TAG, "Dirichlet getIntersVideoFlag");
        return false;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showIntersVideo() {
        Log.d(TAG, "Dirichlet showIntersVideo");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showSplash() {
        Log.d(TAG, "Dirichlet showSplash");
        Activity context = MARSDK.getInstance().getContext();
        Intent intent = new Intent(context, (Class<?>) DirichletSplashActivity.class);
        intent.putExtra("game_start", true);
        context.startActivityForResult(intent, 1001);
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getVideoFlag() {
        Log.d(TAG, "Dirichlet getVideoFlag");
        return DirichletAdCtrl.Inst().isAuto || DirichletAdCtrl.Inst().getVideoFlag();
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showVideo() {
        Log.d(TAG, "Dirichlet showVideo");
        DirichletAdCtrl.Inst().showVideo();
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getBigNativeFlag() {
        Log.d(TAG, "Dirichlet getBigNativeFlag");
        return false;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showBigNative() {
        Log.d(TAG, "Dirichlet showBigNative");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideBigNative() {
        Log.d(TAG, "Dirichlet hideBigNative");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void checkBigNative() {
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNativeIntersFlag() {
        Log.d(TAG, "Dirichlet getNativeIntersFlag");
        return DirichletAdCtrl.Inst().getNativeIntersFlag();
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeInters() {
        Log.d(TAG, "Dirichlet showNativeInters");
        DirichletAdCtrl.Inst().showNativeInters();
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeBanner() {
        Log.d(TAG, "Dirichlet showNativeBanner");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideNativeBanner() {
        Log.d(TAG, "Dirichlet hideNativeBanner");
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getFloatIconFlag() {
        return true;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showFloatIcon(double x, double y) {
        Log.d(TAG, "Dirichlet showFloatIcon");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideFloatIcon() {
        Log.d(TAG, "Dirichlet hideFloatIcon");
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeLucency(double x, double y) {
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideNativeLucency() {
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNativeSplashFlag() {
        return false;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNativeSplash() {
    }

    @Override // com.mar.sdk.gg.IMgg
    public void checkBannerNative() {
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNavigatePasterFlag() {
        return false;
    }

    @Override // com.mar.sdk.gg.IMgg
    public void showNavigatePaster() {
    }

    @Override // com.mar.sdk.gg.IMgg
    public void hideNavigatePaster() {
    }

    @Override // com.mar.sdk.gg.IMgg
    public void reportNavigatePasterClick() {
    }

    @Override // com.mar.sdk.gg.IMgg
    public boolean getNativeLucencyFlag() {
        return false;
    }
}
