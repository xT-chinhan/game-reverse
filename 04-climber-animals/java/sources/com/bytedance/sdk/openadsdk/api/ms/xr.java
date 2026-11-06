package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadEventConfig;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private DownloadEventConfig f1805ms;

    public xr(DownloadEventConfig downloadEventConfig) {
        this.f1805ms = downloadEventConfig;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_REFER, ms()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_BUTTON_TAG, xr()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_ITEM_TAG, ah()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_LABEL, d()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_START_LABEL, ka()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_PAUSE_LABEL, c()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_CONTINUE_LABEL, ab()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_CLICK_INSTALL_LABEL, x()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_STORAGE_DENY_LABEL, ny()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_EVENT_OBJECT, ch()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_DOWNLOAD_SCENE, hi()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_CLICK_EVENT, sl()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_IS_ENABLE_V3_EVENT, zb()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_EXTRA_JSON, u()).ms(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_GET_PARAMS_JSON, ub()).xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 223515) {
            if (valueSet == null) {
                return null;
            }
            ms(((Integer) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_DOWNLOAD_SCENE_PARAMETER, Integer.class)).intValue());
            return null;
        }
        if (i != 223517 || valueSet == null) {
            return null;
        }
        ms((String) valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_REFER_PARAMETER, String.class));
        return null;
    }

    public String ms() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getRefer();
        }
        return null;
    }

    public String xr() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickButtonTag();
        }
        return null;
    }

    public String ah() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickItemTag();
        }
        return null;
    }

    public String d() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickLabel();
        }
        return null;
    }

    public String ka() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickStartLabel();
        }
        return null;
    }

    public String c() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickPauseLabel();
        }
        return null;
    }

    public String ab() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickContinueLabel();
        }
        return null;
    }

    public String x() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getClickInstallLabel();
        }
        return null;
    }

    public String ny() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getStorageDenyLabel();
        }
        return null;
    }

    public Object ch() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraEventObject();
        }
        return null;
    }

    public int hi() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getDownloadScene();
        }
        return 0;
    }

    public boolean sl() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableClickEvent();
        }
        return false;
    }

    public boolean zb() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.isEnableV3Event();
        }
        return false;
    }

    public JSONObject u() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getExtraJson();
        }
        return null;
    }

    public JSONObject ub() {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            return downloadEventConfig.getParamsJson();
        }
        return null;
    }

    public void ms(int i) {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            downloadEventConfig.setDownloadScene(i);
        }
    }

    public void ms(String str) {
        DownloadEventConfig downloadEventConfig = this.f1805ms;
        if (downloadEventConfig != null) {
            downloadEventConfig.setRefer(str);
        }
    }

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
        if (iIntValue != 223515) {
            if (iIntValue == 223517 && valueSetXr != null) {
                ms((String) valueSetXr.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_REFER_PARAMETER, String.class));
            }
        } else if (valueSetXr != null) {
            ms(((Integer) valueSetXr.objectValue(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG_SET_DOWNLOAD_SCENE_PARAMETER, Integer.class)).intValue());
        }
        return null;
    }
}
