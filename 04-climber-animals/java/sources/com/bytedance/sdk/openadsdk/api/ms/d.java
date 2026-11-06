package com.bytedance.sdk.openadsdk.api.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.model.DownloadShortInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private DownloadShortInfo f1803ms;

    public d(DownloadShortInfo downloadShortInfo) {
        this.f1803ms = downloadShortInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ms.ms.ms.ms.xr.ms().ms(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ID, ms()).ms(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_STATUS, xr()).ms(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_TOTAL_BYTES, ah()).ms(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_CURRENT_BYTES, d()).ms(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FILE_NAME, ka()).ms(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_FAIL_STATUS, c()).ms(ValueSetConstants.VALUE_DOWNLOAD_SHORT_GET_ONLY_WIFI, ab()).xr();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS /* 223700 */:
                return (T) Boolean.valueOf(equals(valueSet.objectValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS_PARAMETER, Object.class)));
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_HASH_CODE /* 223701 */:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public boolean equals(Object obj) {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    public long ms() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.id;
        }
        return -1L;
    }

    public int xr() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    public long ah() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    public long d() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    public String ka() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }

    public int c() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }

    public boolean ab() {
        DownloadShortInfo downloadShortInfo = this.f1803ms;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case -99999986:
                return values().sparseArray();
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS /* 223700 */:
                return Boolean.valueOf(equals(valueSetXr.objectValue(ValueSetConstants.VALUE_DOWNLOAD_SHORT_EQUALS_PARAMETER, Object.class)));
            case ValueSetConstants.VALUE_DOWNLOAD_SHORT_HASH_CODE /* 223701 */:
                hashCode();
            default:
                return null;
        }
    }
}
