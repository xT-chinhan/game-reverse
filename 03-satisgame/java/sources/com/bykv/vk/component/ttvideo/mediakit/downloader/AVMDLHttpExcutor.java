package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.byazt.tbt.cy;
import com.byazt.tbt.d;
import com.byazt.tbt.k;
import com.byazt.tbt.oa;
import com.byazt.tbt.qg;
import com.byazt.tbt.sz;
import com.byazt.tbt.w;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static d okHttpClient;

    private static synchronized d getOkHttpClient() {
        long j;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            long j2 = 10000;
            if (config != null) {
                j2 = config.mOpenTimeOut > 0 ? config.mOpenTimeOut * 1000 : 10000L;
                j = config.mRWTimeOut > 0 ? config.mRWTimeOut * 1000 : 10000L;
            } else {
                j = 10000;
            }
            d.n nVar = new d.n();
            nVar.n(Collections.singletonList(oa.HTTP_1_1));
            nVar.n(j2, TimeUnit.MILLISECONDS).qg(j, TimeUnit.MILLISECONDS).s(j, TimeUnit.MILLISECONDS);
            okHttpClient = nVar.n();
        }
        return okHttpClient;
    }

    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        sz.n nVar = new sz.n();
        nVar.qg(aVMDLRequest.urls[i]);
        nVar.n(TapHttp.METHOD_GET, (k) null);
        nVar.n(toOkHttpHeaders(aVMDLRequest));
        qg qgVarN = getOkHttpClient().n(nVar.qg());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            cy cyVarQg = qgVarN.qg();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, cyVarQg, qgVarN);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static w toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        w.n nVar = new w.n();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                entry.getKey();
                entry.getValue();
                nVar.qg(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            nVar.qg("Range", strBuildRangeHeader);
        }
        nVar.qg("Accept-Encoding", "identity");
        return nVar.n();
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
