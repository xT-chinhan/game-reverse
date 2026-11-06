package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadController;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private DownloadController f1804ms;

    public ms(DownloadController downloadController) {
        this.f1804ms = downloadController;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_LINK_MODE, ms()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_MODE, xr()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_BACK_DIALOG, ah()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ADD_TO_DOWNLOAD_MANAGE, d()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_ENABLE_MULTIPLE_DOWNLOAD, ka()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_DOWNLOAD_CHUNK_COUNT, c()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_CLICK_OPERATION, ab()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SHOULD_USE_NEW_WEB_VIEW, x()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_INTERCEPT_FLAG, ny()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, ch()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_OBJECT, hi()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_GET_EXTRA_JSON, ch()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_SHOW_COMPLIANCE_DIALOG, sl()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, zb()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_NEW_ACTIVITY, u()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AH, ub()).ms(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_ENABLE_AM, ao()).xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 223317) {
            if (valueSet == null) {
                return null;
            }
            xr(((Boolean) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_NEW_ACTIVITY, Boolean.class)).booleanValue());
            return null;
        }
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_DOWNLOAD_MODE /* 223311 */:
                if (valueSet != null) {
                    ms(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_MODE, Integer.class)).intValue());
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_LINK_MODE /* 223312 */:
                if (valueSet != null) {
                    xr(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_LINK_MODE, Integer.class)).intValue());
                }
                break;
            case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_ENABLE_SHOW_COMPLIANCE_DIALOG /* 223313 */:
                if (valueSet != null) {
                    ms(((Boolean) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_SHOW_COMPLIANCE_DIALOG, Boolean.class)).booleanValue());
                }
                break;
        }
        return null;
    }

    public int ms() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.getLinkMode();
        }
        return 0;
    }

    public int xr() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.getDownloadMode();
        }
        return 0;
    }

    public boolean ah() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.isEnableBackDialog();
        }
        return false;
    }

    public boolean d() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.isAddToDownloadManage();
        }
        return false;
    }

    public boolean ka() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.isEnableMultipleDownload();
        }
        return false;
    }

    public int c() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.getDowloadChunkCount();
        }
        return 0;
    }

    public Object ab() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.getExtraClickOperation();
        }
        return null;
    }

    public boolean x() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.shouldUseNewWebView();
        }
        return false;
    }

    public int ny() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.getInterceptFlag();
        }
        return 0;
    }

    public JSONObject ch() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.getExtraJson();
        }
        return null;
    }

    public Object hi() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.getExtraObject();
        }
        return null;
    }

    public void ms(int i) {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            downloadController.setDownloadMode(i);
        }
    }

    public void xr(int i) {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            downloadController.setLinkMode(i);
        }
    }

    public void ms(boolean z) {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            downloadController.setEnableShowComplianceDialog(z);
        }
    }

    public boolean sl() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.enableShowComplianceDialog();
        }
        return false;
    }

    public boolean zb() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.isAutoDownloadOnCardShow();
        }
        return false;
    }

    public boolean u() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.enableNewActivity();
        }
        return false;
    }

    public void xr(boolean z) {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            downloadController.setEnableNewActivity(z);
        }
    }

    public boolean ub() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.enableAH();
        }
        return false;
    }

    public boolean ao() {
        DownloadController downloadController = this.f1804ms;
        if (downloadController != null) {
            return downloadController.enableAM();
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        int iIntValue = valueSetXr.intValue(-99999987);
        if (iIntValue == -99999986) {
            return values().sparseArray();
        }
        if (iIntValue != 223317) {
            switch (iIntValue) {
                case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_DOWNLOAD_MODE /* 223311 */:
                    if (valueSetXr != null) {
                        ms(((Integer) valueSetXr.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_MODE, Integer.class)).intValue());
                    }
                    break;
                case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_LINK_MODE /* 223312 */:
                    if (valueSetXr != null) {
                        xr(((Integer) valueSetXr.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_LINK_MODE, Integer.class)).intValue());
                    }
                    break;
                case ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_SET_ENABLE_SHOW_COMPLIANCE_DIALOG /* 223313 */:
                    if (valueSetXr != null) {
                        ms(((Boolean) valueSetXr.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_SHOW_COMPLIANCE_DIALOG, Boolean.class)).booleanValue());
                    }
                    break;
            }
        } else if (valueSetXr != null) {
            xr(((Boolean) valueSetXr.objectValue(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER_PARAMETER_ENABLE_NEW_ACTIVITY, Boolean.class)).booleanValue());
        }
        return null;
    }
}
