package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.ApiDMAction;
import com.kwad.sdk.api.SDKApiHolder;
import com.smartdigimkt.sdk.api.SDMAdConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DynamicMonitor {
    public static final String TAG = "DynamicMonitor";
    public static int sUpdateCount;

    @interface CdnType {
        public static final String ECDN = "ecdn";
        public static final String KCDN = "kcdn";
    }

    public static void onDownloadStart(Api.Data data) {
        sUpdateCount++;
        report(1, data, 0L, 0, "");
    }

    public static void onDownloadSuccess(Api.Data data, long j) {
        report(2, data, j, 0, "");
    }

    public static void onDownloadFail(Api.Data data, long j, int i, String str) {
        report(3, data, j, i, str);
    }

    public static void onFileCheckFail(Api.Data data, int i, String str) {
        report(4, data, 0L, i, str);
    }

    public static void onFallbackToKCdn(Api.Data data, int i, String str) {
        report(8, data, 0L, i, str);
    }

    public static void onFallbackDownloadStart(Api.Data data) {
        report(9, data, 0L, 0, "");
    }

    public static void onInstallStart(Api.Data data) {
        report(5, data, 0L, 0, "");
    }

    public static void onInstallSuccess(Api.Data data, long j) {
        report(6, data, j, 0, "");
    }

    public static void onInstallFail(Api.Data data, int i, String str) {
        report(7, data, 0L, i, str);
    }

    private static void report(int i, Api.Data data, long j, int i2, String str) {
        if (data == null) {
            return;
        }
        try {
            JSONObject json = new MonitorInfo().setLoadStatus(i).setUpdateCount(sUpdateCount).setNewVersion(data.sdkVersion).setDownloadUrl(data.dynamicUrl).setOldDownloadUrl(data.oldDynamicUrl).setCdnType(resolveCdnType(data)).setIsFallback(i == 8 ? 1 : 0).setFallBackPolicy(data.fallBackPolicy).setDuration(j).setErrorCode(i2).setErrorMsg(str).toJson();
            ApiLogger.d(TAG, "status:" + i + "--jo:" + json);
            SDKApiHolder.doAction(ApiDMAction.reportDynamicUpdate, json);
        } catch (Throwable th) {
            ApiLogger.handleException(th);
        }
    }

    private static String resolveCdnType(Api.Data data) {
        return (data.oldDynamicUrl == null || data.oldDynamicUrl.isEmpty()) ? CdnType.KCDN : CdnType.ECDN;
    }

    private static class MonitorInfo {
        private String cdn_type;
        private String download_url;
        private long duration_ms;
        private String dynamic_version;
        private int error_code;
        private String error_msg;
        private int fall_back_policy;
        private int is_fallback;
        private int load_status;
        private String old_download_url;
        private int update_count;

        private MonitorInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setLoadStatus(int i) {
            this.load_status = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setUpdateCount(int i) {
            this.update_count = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setNewVersion(String str) {
            this.dynamic_version = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setDownloadUrl(String str) {
            this.download_url = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setOldDownloadUrl(String str) {
            this.old_download_url = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setCdnType(String str) {
            this.cdn_type = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setIsFallback(int i) {
            this.is_fallback = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setFallBackPolicy(int i) {
            this.fall_back_policy = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setDuration(long j) {
            this.duration_ms = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setErrorCode(int i) {
            this.error_code = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MonitorInfo setErrorMsg(String str) {
            this.error_msg = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.load_status));
                jSONObject.putOpt("update_count", Integer.valueOf(this.update_count));
                jSONObject.putOpt("dynamic_version", this.dynamic_version);
                jSONObject.putOpt(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, this.download_url);
                jSONObject.putOpt("old_download_url", this.old_download_url);
                jSONObject.putOpt("cdn_type", this.cdn_type);
                jSONObject.putOpt("is_fallback", Integer.valueOf(this.is_fallback));
                jSONObject.putOpt("fall_back_policy", Integer.valueOf(this.fall_back_policy));
                jSONObject.putOpt("duration_ms", Long.valueOf(this.duration_ms));
                jSONObject.putOpt("error_code", Integer.valueOf(this.error_code));
                jSONObject.putOpt("error_msg", this.error_msg);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public String toString() {
            return "MonitorInfo{load_status=" + this.load_status + ", update_count=" + this.update_count + ", dynamic_version='" + this.dynamic_version + "', download_url='" + this.download_url + "', old_download_url='" + this.old_download_url + "', cdn_type='" + this.cdn_type + "', is_fallback=" + this.is_fallback + ", fall_back_policy=" + this.fall_back_policy + ", duration_ms=" + this.duration_ms + ", error_code=" + this.error_code + ", error_msg='" + this.error_msg + "'}";
        }
    }
}
