package com.mar.sdk.impl;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import com.mar.sdk.IGameResource;
import com.mar.sdk.MARCallBack;
import com.mar.sdk.MARSDK;
import com.mar.sdk.SDKTools;
import com.mar.sdk.log.Log;
import com.mar.sdk.utils.EncryptUtils;
import com.mar.sdk.utils.MARHttpUtils;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleGameResource implements IGameResource {

    static class DownloadURLTask extends AsyncTask<Void, Void, String> {
        private String gameVersion;
        private MARCallBack marCallBack;
        private ProgressDialog processTip;

        private DownloadURLTask(String str, MARCallBack mARCallBack) {
            this.marCallBack = mARCallBack;
            this.gameVersion = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            String str = MARSDK.getInstance().getMARServerURL() + "/mobile/platform/user/getMarPlatformConfig";
            if (MARSDK.getInstance().getTestId() == null || MARSDK.getInstance().getTestId().equals("")) {
                return "";
            }
            HashMap map = new HashMap();
            map.put("playId", MARSDK.getInstance().getTestId());
            return MARHttpUtils.httpGet(str, map);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            if (str == null || str.equals("")) {
                SDKTools.hideProgressTip(this.processTip);
                this.marCallBack.onCallBack("Failed to get, the result is null");
                return;
            }
            Log.w("MARSDK", str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 0) == 200) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    new GetDownloadUrl(this.processTip, jSONObject2.getString("grAppId"), jSONObject2.getString("grAppKey"), jSONObject2.getString("grGameEnName"), this.gameVersion, this.marCallBack).execute(new Void[0]);
                } else {
                    SDKTools.hideProgressTip(this.processTip);
                    this.marCallBack.onCallBack("Failed to get, please contact developer");
                }
            } catch (Exception e) {
                SDKTools.hideProgressTip(this.processTip);
                this.marCallBack.onCallBack(e.toString());
                e.printStackTrace();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            this.processTip = SDKTools.showProgressTip(MARSDK.getInstance().getContext(), "正在获取数据，请稍后...");
        }
    }

    static class GetDownloadUrl extends AsyncTask<Void, Void, String> {
        private String appId;
        private String appKey;
        private MARCallBack callBack;
        private String gameName;
        private String gameVersion;
        private ProgressDialog progressDialog;

        public GetDownloadUrl(ProgressDialog progressDialog, String str, String str2, String str3, String str4, MARCallBack mARCallBack) {
            this.progressDialog = progressDialog;
            this.appId = str;
            this.appKey = str2;
            this.gameName = str3;
            this.gameVersion = str4;
            this.callBack = mARCallBack;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str = MARSDK.getInstance().getCurrChannel() + "ep" + jCurrentTimeMillis;
            String str2 = MARSDK.getInstance().getArchiveUrl() + "/cloud-archive-server/mobile/tencentcos/getTencentFileList";
            StringBuffer stringBuffer = new StringBuffer("appId=");
            stringBuffer.append(this.appId).append("&userId=");
            stringBuffer.append(str).append("&appKey=");
            stringBuffer.append(this.appKey).append("&timestamp=");
            stringBuffer.append(jCurrentTimeMillis);
            String strMd5 = EncryptUtils.md5(stringBuffer.toString());
            HashMap map = new HashMap();
            map.put("appId", this.appId);
            map.put("gameEnName", this.gameName);
            map.put("gameVersion", this.gameVersion);
            map.put("mobileUserId", str);
            map.put("timestamp", jCurrentTimeMillis + "");
            map.put("signature", strMd5);
            Log.w("MARSDK", map.toString());
            return MARHttpUtils.httpGet(str2, map);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            MARCallBack mARCallBack = this.callBack;
            if (mARCallBack != null) {
                mARCallBack.onCallBack(str);
            }
            SDKTools.hideProgressTip(this.progressDialog);
        }
    }

    @Override // com.mar.sdk.IGameResource
    public void getDownloadUrl(String str, MARCallBack mARCallBack) {
        new DownloadURLTask(str, mARCallBack).execute(new Void[0]);
    }
}
