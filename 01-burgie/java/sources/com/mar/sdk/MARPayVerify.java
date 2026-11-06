package com.mar.sdk;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.mar.sdk.plugin.MARPay;
import com.mar.sdk.utils.StoreUtils;
import com.mar.sdk.verify.MARProxy;
import com.mar.sdk.verify.UCheckResult;
import com.taptap.sdk.db.biz.iap.lib2plus.BillingClientConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MARPayVerify {
    private static final String CHECK_STORE_KEY = "checkstorekey";
    private static final int MAX_TRY_NUM = 3;
    private static final String PAY_STORE_KEY = "paystorekey";
    private static final int TRY_INTERVAL_SECS = 200;
    private static MARPayVerify instance;
    private volatile boolean autoChecking = false;
    private Timer timer = new Timer();
    private TimerTask autoCheckTask = new TimerTask() { // from class: com.mar.sdk.MARPayVerify.2
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (MARSDK.getInstance().getMainRunFlag()) {
                List<PayParams> orders = MARPayVerify.this.getCachedOrders();
                Log.d("MARSDK", "begin auto check failed orders");
                if (orders == null || orders.size() == 0) {
                    Log.d("MARSDK", "there is no order in cache.");
                    return;
                }
                for (PayParams order : orders) {
                    if (MARPayVerify.this.handlingOrders.contains(order.getOrderID())) {
                        Log.d("MARSDK", "order current in handling orders. just ignore." + order.getOrderID());
                    } else {
                        UCheckResult result = MARProxy.check(order.getOrderID());
                        MARPayVerify.this.onPayReCheckResult(order.getOrderID(), result);
                    }
                }
                return;
            }
            Log.d("MARSDK", "check orders is not main run");
        }
    };
    private List<String> handlingOrders = Collections.synchronizedList(new ArrayList());

    private MARPayVerify() {
    }

    public static MARPayVerify getInstance() {
        if (instance == null) {
            instance = new MARPayVerify();
        }
        return instance;
    }

    public void handleResult(int code, String orderId) {
        handleResult(code, orderId, "");
    }

    public void handleResult(int code, final String orderId, final String productId) {
        if (!MARSDK.getInstance().isSingleGame()) {
            onPayResult(code, orderId, productId);
            Log.d("MARSDK", "online game pay");
            return;
        }
        Log.d("MARSDK", "============= normal pay check");
        if (code == 33) {
            Log.d("MARSDK", "pay cancel,return fail");
            onPayResult(33, orderId);
            removeOrder(orderId);
        } else {
            this.handlingOrders.add(orderId);
            MARSDK.getInstance().runOnMainThread(new Runnable() { // from class: com.mar.sdk.MARPayVerify.1
                @Override // java.lang.Runnable
                public void run() {
                    MARPayVerify.this.startTask(MARPayVerify.this.new PayCheckTask(), orderId, productId);
                }
            });
        }
    }

    public void payQueryTask(String orderID) {
        UCheckResult result = MARProxy.check(orderID);
        onPayReCheckResult(orderID, result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTask(AsyncTask<String, ?, ?> task, String order, String productId) {
        if (Build.VERSION.SDK_INT >= 11) {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, order, productId);
        } else {
            task.execute(order, productId);
        }
    }

    @SuppressLint({"NewApi"})
    class PayCheckTask extends AsyncTask<String, Void, UCheckResult> {
        private String order;
        private String productId;

        PayCheckTask() {
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public UCheckResult doInBackground(String... args) {
            UCheckResult result;
            this.order = args[0];
            this.productId = args[1];
            Log.d("MARSDK", "begin to send pay check req..." + this.order);
            int tryNum = 0;
            do {
                if (tryNum > 0) {
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                tryNum++;
                result = MARProxy.check(this.order);
                if (result != null && result.getState() >= 2) {
                    break;
                }
            } while (tryNum < 3);
            return result;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(UCheckResult result) {
            MARPayVerify.this.onPayCheckResult(this.order, result, this.productId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPayCheckResult(String orderId, UCheckResult result, String productId) {
        this.handlingOrders.remove(orderId);
        if (result != null) {
            if (result.getState() >= 2) {
                Log.d("MARSDK", "============= onPayCheckResult called. pay success");
                onPayResult(10, orderId, productId);
                return;
            } else {
                Log.d("MARSDK", "============= onPayCheckResult called. pay failed");
                onPayResult(11, orderId, productId);
                return;
            }
        }
        Log.d("MARSDK", "============= onPayCheckResult called. pay failed");
        onPayResult(11, orderId, productId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPayReCheckResult(String orderId, UCheckResult result) {
        this.handlingOrders.remove(orderId);
        if (result != null) {
            if (result.getState() >= 2) {
                Log.d("MARSDK", "============= onPayCheckResult2 called. pay success");
                onPayResult(10, orderId);
            } else {
                Log.d("MARSDK", "============= onPayCheckResult2 called. pay failed");
                onPayResult(11, orderId);
            }
        }
        if (result != null && result.getSupplyOrderNum() >= result.getPollOrderNumLimited()) {
            removeOrder(orderId);
        }
    }

    private void onPayResult(int code, String orderId) {
        PayParams orderInfo = getOrder(orderId);
        JSONObject json = new JSONObject();
        try {
            if (code == 10) {
                json.put("payResult", 0);
            } else {
                json.put("payResult", 1);
            }
            json.put(BillingClientConstants.PRODUCT_ID, orderInfo.getProductId());
            json.put("orderId", orderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MARSDK.getInstance().onPayResultBack(code, json.toString());
    }

    private void onPayResult(int code, String orderId, String productId) {
        JSONObject json = new JSONObject();
        try {
            if (code == 10) {
                json.put("payResult", 0);
            } else {
                json.put("payResult", 1);
            }
            if (productId != null && !TextUtils.isEmpty(productId)) {
                json.put(BillingClientConstants.PRODUCT_ID, productId);
            } else {
                PayParams orderInfo = getOrder(orderId);
                json.put(BillingClientConstants.PRODUCT_ID, orderInfo.getProductId());
            }
            json.put("orderId", orderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MARSDK.getInstance().onPayResultBack(code, json.toString());
    }

    public void setPropDeliveredComplete(String orderID) {
        if (!MARSDK.getInstance().isSingleGame()) {
            Log.d("MARSDK", "online game don't need report order");
        } else if (orderID != null && !orderID.isEmpty()) {
            Log.d("", "======== on prop delivered complete");
            removeOrder(orderID);
            sendPropCompleteTask(orderID);
        }
    }

    private void sendPropCompleteTask(String orderId) {
        if (!MARPay.getInstance().isSupport("pay")) {
            Log.w("MARSDK", "not support pay,don't need send");
            return;
        }
        PropCompleteTask task = new PropCompleteTask();
        if (Build.VERSION.SDK_INT >= 11) {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, orderId);
        } else {
            task.execute(orderId);
        }
    }

    class PropCompleteTask extends AsyncTask<String, Void, Boolean> {
        PropCompleteTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Boolean doInBackground(String... args) {
            String orderId = args[0];
            Log.d("MARSDK", "begin to send prop complete req..." + orderId);
            return Boolean.valueOf(MARProxy.completePay(orderId));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Boolean result) {
            if (result.booleanValue()) {
                Log.d("MARSDK", "============= prop complete");
            }
        }
    }

    public void checkFailedOrders() {
        Log.d("MARSDK", "============= repay check");
        startAutoTask();
    }

    public void startAutoTask() {
        if (this.autoChecking) {
            Log.w("MARSDK", "auto task already started. just igore.");
            return;
        }
        this.autoChecking = true;
        if (this.timer == null) {
            this.timer = new Timer();
        }
        this.timer.schedule(this.autoCheckTask, 3000L, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<PayParams> getCachedOrders() {
        String c = StoreUtils.getString(MARSDK.getInstance().getContext(), PAY_STORE_KEY);
        if (TextUtils.isEmpty(c)) {
            Log.d("MARSDK", "pay order in cache is null");
            return null;
        }
        try {
            JSONArray array = new JSONArray(c);
            List<PayParams> result = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject j = array.getJSONObject(i);
                String orderID = j.optString("orderId", null);
                if (!TextUtils.isEmpty(orderID)) {
                    Log.d("MARSDK", "begin get pay order in cache. orderID:" + orderID);
                    try {
                        PayParams order = new PayParams();
                        order.setOrderID(orderID);
                        order.setProductId(j.optString(BillingClientConstants.PRODUCT_ID));
                        order.setExtension(j.optString("extension"));
                        result.add(order);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int getOrderListLength() {
        String c = StoreUtils.getString(MARSDK.getInstance().getContext(), PAY_STORE_KEY);
        if (TextUtils.isEmpty(c)) {
            return 0;
        }
        try {
            JSONArray array = new JSONArray(c);
            return array.length();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void storeOrder(PayParams p) {
        if (!MARSDK.getInstance().isSingleGame()) {
            Log.d("MARSDK", "online game,storeOrder cancel");
            return;
        }
        Log.d("MARSDK", "begin store order:" + p.getOrderID());
        Log.d("MARSDK", "begin store order:" + p.getExtension());
        String g = StoreUtils.getString(MARSDK.getInstance().getContext(), PAY_STORE_KEY);
        if (TextUtils.isEmpty(g)) {
            g = "[]";
        }
        if (p != null) {
            try {
                JSONObject extra = new JSONObject();
                extra.put("orderId", p.getOrderID());
                extra.put(BillingClientConstants.PRODUCT_ID, p.getProductId());
                extra.put("extension", p.getExtension());
                JSONArray array = new JSONArray(g);
                array.put(extra);
                StoreUtils.putString(MARSDK.getInstance().getContext(), PAY_STORE_KEY, array.toString());
                Log.d("MARSDK", "store order success." + extra.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isHaveOrderId(String orderID) {
        String g = StoreUtils.getString(MARSDK.getInstance().getContext(), PAY_STORE_KEY);
        if (TextUtils.isEmpty(g)) {
            g = "[]";
        }
        return g.indexOf(orderID) >= 0;
    }

    public PayParams getOrder(String orderID) {
        Log.d("MARSDK", "begin to check order from store." + orderID);
        if (TextUtils.isEmpty(orderID)) {
            return null;
        }
        String g = StoreUtils.getString(MARSDK.getInstance().getContext(), PAY_STORE_KEY);
        if (TextUtils.isEmpty(g)) {
            g = "[]";
        }
        try {
            JSONArray array = new JSONArray(g);
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                if (orderID.equals(item.optString("orderId", ""))) {
                    Log.d("MARSDK", "get order from store:" + orderID);
                    PayParams order = new PayParams();
                    order.setOrderID(orderID);
                    order.setProductId(item.optString(BillingClientConstants.PRODUCT_ID));
                    order.setExtension(item.optString("extension"));
                    return order;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private PayParams removeOrder(String orderID) {
        Log.d("MARSDK", "begin to remove order from store." + orderID);
        if (TextUtils.isEmpty(orderID)) {
            return null;
        }
        String g = StoreUtils.getString(MARSDK.getInstance().getContext(), PAY_STORE_KEY);
        if (TextUtils.isEmpty(g)) {
            g = "[]";
        }
        PayParams order = null;
        try {
            JSONArray array = new JSONArray(g);
            JSONArray left = new JSONArray();
            int i = 0;
            PayParams order2 = null;
            while (i < array.length()) {
                try {
                    JSONObject item = array.getJSONObject(i);
                    if (!orderID.equals(item.optString("orderId", ""))) {
                        left.put(item);
                        order = order2;
                    } else {
                        Log.d("MARSDK", "remove order from store:" + orderID);
                        order = new PayParams();
                        order.setOrderID(orderID);
                        order.setProductId(item.optString("goodsId"));
                        order.setExtension(item.optString("extension"));
                    }
                    i++;
                    order2 = order;
                } catch (JSONException e) {
                    e = e;
                    order = order2;
                    e.printStackTrace();
                    return order;
                }
            }
            StoreUtils.putString(MARSDK.getInstance().getContext(), PAY_STORE_KEY, left.toString());
            Log.d("MARSDK", "remove order success." + orderID);
            return order2;
        } catch (JSONException e2) {
            e = e2;
        }
    }
}
