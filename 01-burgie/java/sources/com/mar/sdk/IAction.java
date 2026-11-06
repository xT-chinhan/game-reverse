package com.mar.sdk;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IAction extends IPlugin {
    public static final int PLUGIN_TYPE = 8;

    public static class BuyKey {
        public static final String BuyType = "buyType";
        public static final String CostAmount = "amount";
        public static final String Currency = "currency";
        public static final String IsVirtualCurrency = "isVCurrency";
        public static final String TargetID = "targetID";
        public static final String TargetName = "targetName";
        public static final String TargetNum = "targetCount";
        public static final String VirtualCurrencyName = "currencyName";
    }

    public static class CommonKey {
        public static final String IsSuccess = "isSuccess";
    }

    public static class LoginKey {
        public static final String Method = "method";
        public static final String UserId = "userID";
    }

    public static class PurchaseKey {
        public static final String Currrency = "currency";
        public static final String OrderID = "orderID";
        public static final String PayType = "payType";
        public static final String Price = "price";
        public static final String ProductID = "productID";
        public static final String ProductName = "productName";
        public static final String ProductNum = "productCount";
        public static final String ProductType = "productType";
    }

    public static class RegisterKey {
        public static final String Method = "method";
        public static final String UserId = "userID";
    }

    public static class RoleKey {
        public static final String RoleID = "roleID";
        public static final String RoleLevel = "roleLevel";
        public static final String RoleName = "roleName";
        public static final String ServerID = "serverID";
        public static final String ServerName = "serverName";
    }

    public static class TaskKey {
        public static final String TaskDesc = "taskDesc";
        public static final String TaskID = "taskID";
        public static final String TaskLevel = "taskLevel";
        public static final String TaskName = "taskName";
        public static final String TaskType = "taskType";
    }

    void buy(SDKParams sDKParams);

    void createRole(SDKParams sDKParams);

    void customEvent(String str, SDKParams sDKParams);

    void enterGame(SDKParams sDKParams);

    void levelUp(SDKParams sDKParams);

    void login(SDKParams sDKParams);

    void purchase(SDKParams sDKParams);

    void register(SDKParams sDKParams);

    void reportEvent(String str, JSONObject jSONObject);

    void setSuperProperties(String str);

    void setTrackUserAdd(String str);

    void setUserProperty(String str);

    void setUserSetOnce(String str);

    void task(SDKParams sDKParams);
}
