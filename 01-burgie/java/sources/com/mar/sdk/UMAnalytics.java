package com.mar.sdk;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UMAnalytics extends MARIActionAdapter {
    public UMAnalytics(Activity context) {
        UMAnalyticsSDK.getInstance().initSDK();
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IPlugin
    public boolean isSupportMethod(String methodName) {
        return true;
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void register(SDKParams params) {
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void login(SDKParams params) throws Throwable {
        UMAnalyticsSDK.getInstance().customEvent("loginEvent", params == null ? null : params.getConfings());
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void buy(SDKParams params) {
        String item = params.getString(IAction.BuyKey.TargetID);
        int num = params.getInt(IAction.BuyKey.TargetNum);
        int CostAmount = params.getInt(IAction.BuyKey.CostAmount);
        UMAnalyticsSDK.getInstance().buy(item, num, CostAmount);
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void purchase(SDKParams params) {
        int money = params.getInt(IAction.PurchaseKey.Price);
        int num = params.getInt(IAction.PurchaseKey.ProductNum);
        UMAnalyticsSDK.getInstance().pay(money, num);
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void createRole(SDKParams params) {
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void enterGame(SDKParams params) {
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void levelUp(SDKParams params) {
        int levelup = params.getInt("levelup");
        UMAnalyticsSDK.getInstance().levelup(levelup);
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void task(SDKParams params) {
        if (params.contains("startLevel")) {
            String level = params.getString("startLevel");
            UMAnalyticsSDK.getInstance().startLevel(level);
        } else if (params.contains("failLevel")) {
            String level2 = params.getString("failLevel");
            UMAnalyticsSDK.getInstance().failLevel(level2);
        } else if (params.contains("finishLevel")) {
            String level3 = params.getString("finishLevel");
            UMAnalyticsSDK.getInstance().finishLevel(level3);
        }
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void customEvent(String name, SDKParams params) throws Throwable {
        UMAnalyticsSDK.getInstance().customEvent(name, params == null ? null : params.getConfings());
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void reportEvent(String name, JSONObject json) {
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void setUserProperty(String s) {
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void setUserSetOnce(String s) {
    }

    @Override // com.mar.sdk.MARIActionAdapter, com.mar.sdk.IAction
    public void setTrackUserAdd(String s) {
    }
}
