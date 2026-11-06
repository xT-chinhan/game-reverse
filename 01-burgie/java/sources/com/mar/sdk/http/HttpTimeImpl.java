package com.mar.sdk.http;

/* JADX INFO: loaded from: classes2.dex */
public class HttpTimeImpl implements HttpTime {
    @Override // com.mar.sdk.http.HttpTime
    public long time() {
        long baidu = HttpConnect.getBaiduTime().longValue();
        if (baidu <= 0) {
            long cctvTime = HttpConnect.getCCTVTime().longValue();
            return cctvTime > 0 ? cctvTime : System.currentTimeMillis();
        }
        return baidu;
    }
}
