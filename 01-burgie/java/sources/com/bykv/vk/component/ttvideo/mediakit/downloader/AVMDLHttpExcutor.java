package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.byazt.nzn.g;
import com.byazt.nzn.ho;
import com.byazt.nzn.hw;
import com.byazt.nzn.k;
import com.byazt.nzn.m;
import com.byazt.nzn.nt;
import com.byazt.nzn.uc;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.Util;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static k okHttpClient;

    private static synchronized k getOkHttpClient() {
        long j;
        long j2;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            long j3 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            if (config == null) {
                j = 10000;
            } else {
                if (config.mOpenTimeOut <= 0) {
                    j2 = 10000;
                } else {
                    j2 = config.mOpenTimeOut * 1000;
                }
                if (config.mRWTimeOut <= 0) {
                    j3 = j2;
                    j = 10000;
                } else {
                    j3 = j2;
                    j = config.mRWTimeOut * 1000;
                }
            }
            k.pr prVar = new k.pr();
            prVar.pr(Collections.singletonList(m.HTTP_1_1));
            prVar.pr(j3, TimeUnit.MILLISECONDS).hw(j, TimeUnit.MILLISECONDS).hn(j, TimeUnit.MILLISECONDS);
            okHttpClient = prVar.pr();
        }
        return okHttpClient;
    }

    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        g.pr prVar = new g.pr();
        prVar.pr(aVMDLRequest.urls[i]);
        prVar.pr(TapHttp.METHOD_GET, (ho) null);
        prVar.pr(toOkHttpHeaders(aVMDLRequest));
        hw hwVarPr = getOkHttpClient().pr(prVar.hw());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            nt ntVarHw = hwVarPr.hw();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, ntVarHw, hwVarPr);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static uc toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        uc.pr prVar = new uc.pr();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                entry.getKey();
                entry.getValue();
                prVar.hw(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            prVar.hw(Util.RANGE, strBuildRangeHeader);
        }
        prVar.hw("Accept-Encoding", "identity");
        return prVar.pr();
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
        if (j < 0 && j2 > 0) {
            return "-".concat(String.valueOf(j2));
        }
        return null;
    }
}
