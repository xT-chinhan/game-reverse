package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.c;
import com.bytedance.sdk.component.xr.ms.sl;
import com.bytedance.sdk.component.xr.ms.u;
import com.bytedance.sdk.component.xr.ms.ub;
import com.bytedance.sdk.component.xr.ms.xr;
import com.bytedance.sdk.component.xr.ms.zb;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static sl okHttpClient;

    private static synchronized sl getOkHttpClient() {
        long j;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            long j2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            if (config != null) {
                long j3 = config.mOpenTimeOut > 0 ? config.mOpenTimeOut * 1000 : 10000L;
                if (config.mRWTimeOut > 0) {
                    j2 = config.mRWTimeOut * 1000;
                }
                long j4 = j2;
                j2 = j3;
                j = j4;
            } else {
                j = 10000;
            }
            sl.ms msVar = new sl.ms();
            msVar.ms(Collections.singletonList(zb.HTTP_1_1));
            msVar.ms(j2, TimeUnit.MILLISECONDS).xr(j, TimeUnit.MILLISECONDS).ah(j, TimeUnit.MILLISECONDS);
            okHttpClient = msVar.ms();
        }
        return okHttpClient;
    }

    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        u.ms msVar = new u.ms();
        msVar.ms(aVMDLRequest.urls[i]);
        msVar.ms("GET", (ub) null);
        msVar.ms(toOkHttpHeaders(aVMDLRequest));
        xr xrVarMs = getOkHttpClient().ms(msVar.xr());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ao aoVarMs = xrVarMs.ms();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, aoVarMs, xrVarMs);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static c toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        c.ms msVar = new c.ms();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                entry.getKey();
                entry.getValue();
                msVar.xr(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            msVar.xr("Range", strBuildRangeHeader);
        }
        msVar.xr("Accept-Encoding", "identity");
        return msVar.ms();
    }

    public static String buildRangeHeader(long j, long j2) {
        String strFormRangeStrBySize = formRangeStrBySize(j, j2);
        if (strFormRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(String.valueOf(strFormRangeStrBySize));
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + "-" + j2;
        }
        if (j >= 0) {
            return j + "-";
        }
        if (j >= 0 || j2 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(j2));
    }
}
