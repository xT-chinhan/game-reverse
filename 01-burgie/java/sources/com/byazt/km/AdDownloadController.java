package com.byazt.km;

import android.app.Activity;
import com.byazt.bek.DownloadController;
import com.byazt.bek.hw;
import com.byazt.eld.k;
import com.byazt.vzx.pr;
import com.byazt.zv.DownloadMarketInterceptor;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, 95, 1270})
public class AdDownloadController implements DownloadController {
    public int mDownloadMode;
    public Object mExtraClickOperation;
    public JSONObject mExtraJson;
    public Object mExtraObject;
    public int mInterceptFlag;
    public boolean mIsAddToDownloadManage;
    public boolean mIsAutoDownloadOnCardShow;
    public boolean mIsEnableBackDialog;
    public int mLinkMode;
    public boolean mShouldUseNewWebView;
    public hw marketStatusChangeListener;
    public boolean mEnableShowComplianceDialog = true;
    public boolean mEnableNewActivity = true;
    public boolean mEnableAH = true;
    public boolean mEnableAM = true;
    public boolean mEnableOppoAutoDownload = true;
    public DownloadMarketInterceptor mDownloadMarketInterceptor = null;
    public WeakReference<Activity> mActivityRef = null;

    @Override // com.byazt.bek.DownloadController
    public int getLinkMode() {
        return this.mLinkMode;
    }

    @Override // com.byazt.bek.DownloadController
    public int getDownloadMode() {
        return this.mDownloadMode;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isEnableBackDialog() {
        return this.mIsEnableBackDialog;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isAddToDownloadManage() {
        return this.mIsAddToDownloadManage;
    }

    @Override // com.byazt.bek.DownloadController
    public Object getExtraClickOperation() {
        return this.mExtraClickOperation;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.byazt.bek.DownloadController
    public int getDowloadChunkCount() {
        return 1;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean shouldUseNewWebView() {
        return this.mShouldUseNewWebView;
    }

    @Override // com.byazt.bek.DownloadController
    public int getInterceptFlag() {
        return this.mInterceptFlag;
    }

    @Override // com.byazt.bek.DownloadController
    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.byazt.bek.DownloadController
    public Object getExtraObject() {
        return this.mExtraObject;
    }

    @Override // com.byazt.bek.DownloadController
    public void setDownloadMode(int i) {
        this.mDownloadMode = i;
    }

    @Override // com.byazt.bek.DownloadController
    public void setLinkMode(int i) {
        this.mLinkMode = i;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableShowComplianceDialog() {
        return this.mEnableShowComplianceDialog;
    }

    @Override // com.byazt.bek.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
        this.mEnableShowComplianceDialog = z;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return this.mIsAutoDownloadOnCardShow;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableNewActivity() {
        return this.mEnableNewActivity;
    }

    public void setIsAutoDownloadOnCardShow(boolean z) {
        this.mIsAutoDownloadOnCardShow = z;
    }

    @Override // com.byazt.bek.DownloadController
    public void setEnableNewActivity(boolean z) {
        this.mEnableNewActivity = z;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableAH() {
        return this.mEnableAH;
    }

    @Override // com.byazt.bek.DownloadController
    public boolean enableAM() {
        return this.mEnableAM;
    }

    @Override // com.byazt.bek.DownloadController
    public hw getMarketStatusChangeListener() {
        return this.marketStatusChangeListener;
    }

    public void setMarketStatusChangeListener(hw hwVar) {
        this.marketStatusChangeListener = hwVar;
    }

    public void setExtraObject(Object obj) {
        this.mExtraObject = obj;
    }

    public void setExtraJson(JSONObject jSONObject) {
        this.mExtraJson = jSONObject;
    }

    public boolean enableOppoAutoDownload() {
        return this.mEnableOppoAutoDownload;
    }

    public void setEnableOppoAutoDownload(boolean z) {
        this.mEnableOppoAutoDownload = z;
    }

    public DownloadMarketInterceptor getDownloadMarketInterceptor() {
        return this.mDownloadMarketInterceptor;
    }

    public void setDownloadMarketInterceptor(DownloadMarketInterceptor downloadMarketInterceptor) {
        this.mDownloadMarketInterceptor = downloadMarketInterceptor;
    }

    public Activity getWeakActivity() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void setWeakActivity(Activity activity) {
        if (activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
        } else {
            this.mActivityRef = null;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("link_mode", Integer.valueOf(this.mLinkMode));
            jSONObject.putOpt("download_mode", Integer.valueOf(this.mDownloadMode));
            int i = 1;
            jSONObject.putOpt("enable_back_dialog", Integer.valueOf(this.mIsEnableBackDialog ? 1 : 0));
            jSONObject.putOpt("add_to_manage", Integer.valueOf(this.mIsAddToDownloadManage ? 1 : 0));
            jSONObject.putOpt("use_new_webview", Integer.valueOf(this.mShouldUseNewWebView ? 1 : 0));
            jSONObject.putOpt("intercept_flag", Integer.valueOf(this.mInterceptFlag));
            jSONObject.putOpt("enable_show_compliance_dialog", Integer.valueOf(this.mEnableShowComplianceDialog ? 1 : 0));
            jSONObject.putOpt("is_auto_download_on_card_show", Integer.valueOf(this.mIsAutoDownloadOnCardShow ? 1 : 0));
            jSONObject.putOpt("extra", this.mExtraJson);
            jSONObject.putOpt("enable_new_activity", Integer.valueOf(this.mEnableNewActivity ? 1 : 0));
            jSONObject.putOpt("enable_ah", Integer.valueOf(this.mEnableAH ? 1 : 0));
            jSONObject.putOpt("enable_am", Integer.valueOf(this.mEnableAM ? 1 : 0));
            if (!this.mEnableOppoAutoDownload) {
                i = 0;
            }
            jSONObject.putOpt("enable_oppo_auto_download", Integer.valueOf(i));
        } catch (Exception e) {
            k.a().pr(e, "AdDownloadController toJson");
        }
        return jSONObject;
    }

    public static AdDownloadController fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            builder.setLinkMode(jSONObject.optInt("link_mode"));
            builder.setDownloadMode(jSONObject.optInt("download_mode"));
            builder.setIsEnableBackDialog(jSONObject.optInt("enable_back_dialog") == 1);
            builder.setIsAddToDownloadManage(jSONObject.optInt("add_to_manage") == 1);
            builder.setShouldUseNewWebView(jSONObject.optInt("use_new_webview") == 1);
            builder.setInterceptFlag(jSONObject.optInt("intercept_flag"));
            builder.setEnableShowComplianceDialog(jSONObject.optInt("enable_show_compliance_dialog", 1) == 1);
            builder.setIsAutoDownloadOnCardShow(jSONObject.optInt("is_auto_download_on_card_show") == 1);
            builder.setEnableNewActivity(jSONObject.optInt("enable_new_activity", 1) == 1);
            builder.setEnableAH(jSONObject.optInt("enable_ah", 1) == 1);
            builder.setEnableAM(jSONObject.optInt("enable_am", 1) == 1);
            builder.setExtraJson(jSONObject.optJSONObject("extra"));
            builder.setEnableOppoAutoDownload(jSONObject.optInt("enable_oppo_auto_download", 1) == 1);
        } catch (Exception e) {
            k.a().pr(e, "AdDownloadController fromJson");
        }
        return builder.build();
    }

    @pr(pr = {0, 1, 95, 1431})
    public static final class Builder {
        public AdDownloadController controller = new AdDownloadController();

        public Builder setLinkMode(int i) {
            this.controller.mLinkMode = i;
            return this;
        }

        public Builder setDownloadMode(int i) {
            this.controller.mDownloadMode = i;
            return this;
        }

        public Builder setIsEnableBackDialog(boolean z) {
            this.controller.mIsEnableBackDialog = z;
            return this;
        }

        public Builder setIsAddToDownloadManage(boolean z) {
            this.controller.mIsAddToDownloadManage = z;
            return this;
        }

        @Deprecated
        public Builder setIsEnableMultipleDownload(boolean z) {
            return this;
        }

        @Deprecated
        public Builder setDowloadChunkCount(int i) {
            return this;
        }

        @Deprecated
        public Builder setExtraOperation(Object obj) {
            this.controller.mExtraClickOperation = obj;
            return this;
        }

        public Builder setShouldUseNewWebView(boolean z) {
            this.controller.mShouldUseNewWebView = z;
            return this;
        }

        public Builder setInterceptFlag(int i) {
            this.controller.mInterceptFlag = i;
            return this;
        }

        public Builder setExtraJson(JSONObject jSONObject) {
            this.controller.mExtraJson = jSONObject;
            return this;
        }

        public Builder setExtraObject(Object obj) {
            this.controller.mExtraObject = obj;
            return this;
        }

        public Builder setEnableShowComplianceDialog(boolean z) {
            this.controller.mEnableShowComplianceDialog = z;
            return this;
        }

        public Builder setIsAutoDownloadOnCardShow(boolean z) {
            this.controller.mIsAutoDownloadOnCardShow = z;
            return this;
        }

        public Builder setEnableNewActivity(boolean z) {
            this.controller.mEnableNewActivity = z;
            return this;
        }

        public Builder setEnableAH(boolean z) {
            this.controller.mEnableAH = z;
            return this;
        }

        public Builder setEnableAM(boolean z) {
            this.controller.mEnableAM = z;
            return this;
        }

        public Builder setEnableOppoAutoDownload(boolean z) {
            this.controller.mEnableOppoAutoDownload = z;
            return this;
        }

        public AdDownloadController build() {
            return this.controller;
        }
    }
}
