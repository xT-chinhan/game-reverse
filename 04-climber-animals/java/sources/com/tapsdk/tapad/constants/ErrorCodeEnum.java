package com.tapsdk.tapad.constants;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.kwad.library.solder.lib.ext.PluginError;
import com.qq.e.comm.constants.ErrorCode;

/* JADX INFO: loaded from: classes3.dex */
public enum ErrorCodeEnum {
    SUCCESS(0, "success"),
    COMMON_INIT_ERROR(3001, "初始化错误"),
    COMMON_NET_ERROR(3002, "网络异常"),
    COMMON_ORIENTATION_ERROR(3003, "应用横竖方向参数与广告位支持方向不匹配"),
    COMMON_INVALID_CONTAINER_ERROR(3004, "广告容器无效或不可见"),
    COMMON_INTERSTITIAL_ERROR(3005, "插屏广告异常"),
    COMMON_PARAM_INTERERROR(ErrorCode.PrivateError.LOAD_TIME_OUT, "内部错误"),
    COMMON_FEED_REUSE_ERROR(PluginError.ERROR_BUILD_REMOTE_PLUGIN_INFO, "信息流广告在不同页面重复使用"),
    COMMON_UNKOWN_ERROR(AVMDLDataLoader.KeyIsEnableEventInfo, Constants.l.b);

    private final int code;
    private final String desc;

    ErrorCodeEnum(int i, String str) {
        this.code = i;
        this.desc = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ErrorCode:{code='" + this.code + "', desc='" + this.desc + "'}";
    }
}
