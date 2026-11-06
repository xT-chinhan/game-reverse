package com.umeng.analytics.pro;

import com.qq.e.comm.constants.ErrorCode;

/* JADX INFO: compiled from: Errors.java */
/* JADX INFO: loaded from: classes4.dex */
public enum cb {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(5003),
    IOException(ErrorCode.NO_AD_FILL),
    UnKnownHostException(ErrorCode.TRAFFIC_CONTROL_DAY),
    HttpError(ErrorCode.PACKAGE_NAME_ERROR),
    EmptyResponse(ErrorCode.RESOURCE_LOAD_ERROR),
    ErrorResponse(ErrorCode.IMAGE_LOAD_ERROR),
    ErrorMakeRequestBody(ErrorCode.TRAFFIC_CONTROL_HOUR);

    private final int k;

    cb(int i) {
        this.k = i;
    }

    public String a() {
        if (this == UnKnownCode) {
            return b() + "--未知错误--";
        }
        if (this == Timeout) {
            return b() + "--连接超时--";
        }
        if (this == NetworkUnavailable) {
            return b() + "--网络不可用--";
        }
        if (this == SSLException) {
            return b() + "--SSL证书认证失败--";
        }
        if (this == IOException) {
            return b() + "--IO异常--";
        }
        if (this == HttpError) {
            return b() + "--服务端返回HTTP错误--";
        }
        if (this == EmptyResponse) {
            return b() + "--服务端返回数据为空--";
        }
        if (this == ErrorResponse) {
            return b() + "--服务端返回错误数据--";
        }
        return this == ErrorMakeRequestBody ? b() + "--请求报文构建错误--" : "unknown";
    }

    private String b() {
        return "错误码：" + this.k + " 错误信息：";
    }
}
