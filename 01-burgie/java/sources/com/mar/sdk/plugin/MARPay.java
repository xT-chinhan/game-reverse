package com.mar.sdk.plugin;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.mar.sdk.IPay;
import com.mar.sdk.MARPayVerify;
import com.mar.sdk.MARSDK;
import com.mar.sdk.PayParams;
import com.mar.sdk.SDKTools;
import com.mar.sdk.base.PluginFactory;
import com.mar.sdk.log.Log;
import com.mar.sdk.rule.IPayRule;
import com.mar.sdk.rule.IPayRuleResult;
import com.mar.sdk.verify.MARProxy;
import com.mar.sdk.verify.UOrder;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARPay {
    private static MARPay instance;
    private final String TAG = "MARSDK";
    private volatile PayParams currPayParams = null;
    private IPay payPlugin;
    private IPayRule rule;

    private MARPay() {
    }

    public static MARPay getInstance() {
        if (instance == null) {
            instance = new MARPay();
        }
        return instance;
    }

    public void init() {
        this.payPlugin = (IPay) PluginFactory.getInstance().initPlugin(2);
    }

    public boolean isSupport(String method) {
        if (this.payPlugin == null) {
            return false;
        }
        return this.payPlugin.isSupportMethod(method);
    }

    public void setPayRule(IPayRule rule) {
        this.rule = rule;
    }

    public void pay(PayParams data) {
        if (this.payPlugin != null) {
            Log.d("MARSDK", "is support pay:" + isSupport("pay"));
            if (!isSupport("pay")) {
                this.payPlugin.pay(data);
                return;
            }
            if (MARSDK.getInstance().getServerToken() != null) {
                startTokenTask(data);
                return;
            }
            Log.d("MARSDK", "not login pay stop.");
            onPayResultFail(data.getProductId());
            Toast.makeText(MARSDK.getInstance().getContext(), "未登录，请登录后支付!", 0).show();
            MARUser.getInstance().login();
        }
    }

    private void onPayResultFail(String productId) {
        JSONObject json = new JSONObject();
        try {
            json.put("payResult", 1);
            json.put(BillingClientConstants.PRODUCT_ID, productId);
            json.put("orderId", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MARSDK.getInstance().onPayResultBack(11, json.toString());
    }

    public void payNormal(PayParams data) {
        if (this.rule != null) {
            Log.d("MARSDK", "enter pay rule check.");
            this.rule.check(data, new IPayRuleResult() { // from class: com.mar.sdk.plugin.MARPay.1
                @Override // com.mar.sdk.rule.IPayRuleResult
                public void onResult(boolean canPay, PayParams data2) {
                    if (canPay) {
                        MARPay.this.doPay(data2);
                    } else {
                        Log.e("MARSDK", "pay rule check result. can not pay.");
                    }
                }
            });
        } else {
            doPay(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPay(PayParams data) {
        String productId = data.getProductId();
        String productName = data.getProductName();
        String productDesc = data.getProductDesc();
        int price = data.getPrice();
        String serverId = data.getServerId();
        String serverName = data.getServerName();
        String roleId = data.getRoleId();
        String roleName = data.getRoleName();
        if (!MARSDK.getInstance().isSingleGame()) {
            if (roleId.equals("10101")) {
                roleId = MARSDK.getInstance().getUToken().getUserID();
            }
            if (roleName.equals("Martian")) {
                roleName = MARSDK.getInstance().getUToken().getNickName();
            }
            data.setRoleId(roleId);
            data.setRoleName(roleName);
        }
        List<String> params = new ArrayList<>();
        params.add(productId);
        params.add(productName);
        params.add(productDesc);
        params.add(serverId);
        params.add(serverName);
        params.add(roleId);
        params.add(roleName);
        for (String st : params) {
            if (TextUtils.isEmpty(st)) {
                Log.d("MARSDK", "must param is null,create order fail");
                onPayResultFail(productId);
                return;
            }
            Log.d("MARSDK", st);
        }
        if (price <= 0) {
            Log.d("MARSDK", "price must more than 0,create order fail");
            onPayResultFail(productId);
            return;
        }
        this.currPayParams = data;
        if (MARSDK.getInstance().isGetOrder()) {
            startOrderTask(data);
        } else {
            this.payPlugin.pay(data);
        }
    }

    public boolean needQueryResult() {
        return this.payPlugin.needQueryResult();
    }

    public void checkFailedOrders() {
        if (!isSupport("pay") || MARSDK.getInstance().getGameType() == 1) {
            Log.d("MARSDK", "not support pay, checkFailedOrders return");
        } else {
            Log.d("MARSDK", "begin check orders pay.");
            MARPayVerify.getInstance().startAutoTask();
        }
    }

    private void startOrderTask(PayParams data) {
        GetOrderTask authTask = new GetOrderTask(data);
        if (Build.VERSION.SDK_INT >= 11) {
            authTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            authTask.execute(new Void[0]);
        }
    }

    @SuppressLint({"NewApi"})
    class GetOrderTask extends AsyncTask<Void, Void, UOrder> {
        private PayParams data;
        private ProgressDialog processTip;

        public GetOrderTask(PayParams data) {
            this.data = data;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.processTip = SDKTools.showProgressTip(MARSDK.getInstance().getContext(), "正在启动支付，请稍后...");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public UOrder doInBackground(Void... args) {
            Log.d("MARSDK", "begin to get order id from marserver...");
            return MARProxy.getOrder(this.data);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(UOrder order) {
            SDKTools.hideProgressTip(this.processTip);
            try {
                if (order == null) {
                    Log.e("MARSDK", "get order from marserver failed.");
                    MARPay.this.currPayParams = null;
                    Toast.makeText(MARSDK.getInstance().getContext(), "获取订单号失败", 0).show();
                    return;
                }
                if (order.getState() == 5003) {
                    Toast.makeText(MARSDK.getInstance().getContext(), "商品ID不存在", 0).show();
                    return;
                }
                if (order.getState() == 5004) {
                    Toast.makeText(MARSDK.getInstance().getContext(), "商品价格不匹配", 0).show();
                    return;
                }
                Log.d("MARSDK", "get order from marserver success. orderID:" + order.getOrder() + ";extension:" + order.getExtension() + ";productId:" + order.getProductID());
                this.data.setOrderID(order.getOrder());
                this.data.setExtension(order.getExtension());
                MARPayVerify.getInstance().storeOrder(this.data);
                String payProductId = MARPay.this.currPayParams.getProductId();
                if (!payProductId.equals(order.getProductID())) {
                    MARPay.this.currPayParams.setCpProductId(payProductId);
                }
                this.data.setProductId(order.getProductID());
                MARPay.this.payPlugin.pay(this.data);
            } catch (Exception e) {
                MARPay.this.currPayParams = null;
                e.printStackTrace();
            }
        }
    }

    private void startTokenTask(PayParams data) {
        String result = MARProxy.setTokenActive();
        if (result != null && result.equals("1")) {
            payNormal(data);
        } else {
            Log.e("MARSDK", "==== pay is stoped, the token is not working");
            onPayResultFail(data.getProductId());
        }
    }

    public PayParams getCurrPayParams() {
        return this.currPayParams;
    }

    public void setCurrPayParams(PayParams order) {
        this.currPayParams = order;
    }
}
