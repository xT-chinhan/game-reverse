package com.tapsdk.tapad.lib_iqyadapter;

import android.util.Log;
import com.bumptech.glide.load.Key;
import com.tapsdk.tapad.constants.Constants;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class IQYBidInfoReporter {
    private static final int ACCESS_TYPE_SDK = 0;
    private static final String BID_INFO_URL = "https://bidinfo-ssp.iqiyi.com/bid_info";
    private static final int BID_STATUS_LOSS = 1;
    private static final int BID_STATUS_WIN = 0;
    private static final Map<String, String> DSP_NAME_MAP;
    private static final int LOSE_REASON_DEFAULT = 1;
    private static final int PRICE_TYPE_EXACT = 0;
    private static final String TAG = "IQYBidInfoReporter";
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    IQYBidInfoReporter() {
    }

    static {
        HashMap map = new HashMap();
        DSP_NAME_MAP = map;
        map.put("CSJ", "穿山甲");
        map.put("GDT", "广点通");
        map.put("TapADN", "taptap");
        map.put("IQY", "爱奇艺");
    }

    static void reportWin(final String impressionId, final String adZone, final int website, final long followerPrice, final String followerDsp) {
        executor.execute(new Runnable() { // from class: com.tapsdk.tapad.lib_iqyadapter.IQYBidInfoReporter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                IQYBidInfoReporter.lambda$reportWin$0(impressionId, adZone, website, followerDsp, followerPrice);
            }
        });
    }

    static /* synthetic */ void lambda$reportWin$0(String impressionId, String adZone, int website, String followerDsp, long followerPrice) {
        try {
            JSONObject body = new JSONObject();
            body.put("impression_id", impressionId);
            body.put("ad_zone", adZone);
            body.put("access_type", 0);
            body.put("bid_status", 0);
            body.put("website", website);
            body.put("follower_dsp", mapDspName(followerDsp));
            body.put("follower_price", followerPrice);
            body.put("follower_price_type", 0);
            post(body);
        } catch (Exception e) {
            Log.w(TAG, "reportWin error", e);
        }
    }

    static void reportLoss(final String impressionId, final String adZone, final int website, final long winnerPrice, final String winnerDsp, final int loseReason) {
        executor.execute(new Runnable() { // from class: com.tapsdk.tapad.lib_iqyadapter.IQYBidInfoReporter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                IQYBidInfoReporter.lambda$reportLoss$1(impressionId, adZone, website, winnerDsp, winnerPrice, loseReason);
            }
        });
    }

    static /* synthetic */ void lambda$reportLoss$1(String impressionId, String adZone, int website, String winnerDsp, long winnerPrice, int loseReason) {
        try {
            JSONObject body = new JSONObject();
            body.put("impression_id", impressionId);
            body.put("ad_zone", adZone);
            body.put("access_type", 0);
            body.put("bid_status", 1);
            body.put("website", website);
            body.put("winner_dsp", mapDspName(winnerDsp));
            body.put("winner_price", winnerPrice);
            body.put("winner_price_type", 0);
            body.put(Constants.Bidding.LOSS_REASON, loseReason > 0 ? loseReason : 1);
            post(body);
        } catch (Exception e) {
            Log.w(TAG, "reportLoss error", e);
        }
    }

    private static String mapDspName(String networkName) {
        if (networkName == null || networkName.isEmpty()) {
            return "其他";
        }
        String mapped = DSP_NAME_MAP.get(networkName);
        return mapped != null ? mapped : networkName;
    }

    private static void post(JSONObject body) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(BID_INFO_URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(TapHttp.METHOD_POST);
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setDoOutput(true);
            byte[] data = body.toString().getBytes(Key.STRING_CHARSET_NAME);
            OutputStream os = conn.getOutputStream();
            os.write(data);
            os.flush();
            os.close();
            int code = conn.getResponseCode();
            if (code != 200) {
                Log.w(TAG, "bid_info response code: " + code);
            }
        } catch (Exception e) {
            Log.w(TAG, "post error", e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
