package com.tapsdk.tapad.constants;

import com.qq.e.comm.constants.ErrorCode;
import com.tapsdk.tapad.internal.runtime.mediation.AdapterEnvelope;
import com.taptap.sdk.rep.internal.TapRepResultCallbackKt;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum ErrorCodeEnum {
    SUCCESS(AdapterEnvelope.MAX_TRACE_FRAMES, "成功"),
    UNKNOWN_ERROR(100001, com.tapsdk.tapad.internal.Constants.OAIDErrorMessage.UNKNOWN),
    INVALID_PARAMETER(TapRepResultCallbackKt.REP_FAIL_PARAM_ERROR, "参数无效"),
    INTERNAL_ERROR(TapRepResultCallbackKt.REP_FAIL_CLIENT_ERROR, "内部错误"),
    NOT_INITIALIZED(TapRepResultCallbackKt.REP_FAIL_UNKNOWN_ERROR, "SDK 未初始化"),
    DISPOSED(100005, "资源已释放"),
    INIT_FAILED(101001, "初始化失败"),
    INVALID_MEDIA_ID(101002, "媒体ID无效"),
    INVALID_MEDIA_KEY(101003, "媒体密钥无效"),
    CONTEXT_NULL(101004, "Context 为空"),
    CONFIG_NULL(101005, "配置为空"),
    DUPLICATE_INIT(101006, "重复初始化"),
    NETWORK_ERROR(102001, "网络异常"),
    NETWORK_TIMEOUT(102002, "网络超时"),
    NO_NETWORK(102003, "无网络连接"),
    DNS_ERROR(102004, "DNS 解析失败"),
    SSL_ERROR(102005, "SSL 证书错误"),
    SERVER_ERROR(ErrorCode.ServerError.NO_MATCH_AD, "服务器错误"),
    LOAD_FAILED(103001, "加载失败"),
    NO_AD_FILL(103002, "无广告填充"),
    INVALID_SPACE_ID(103003, "广告位 ID 无效"),
    REQUEST_TOO_FREQUENT(103004, "请求过于频繁"),
    AD_EXPIRED(103005, "广告已过期"),
    CACHE_FAILED(103006, "缓存失败"),
    SHOW_FAILED(104001, "展示失败"),
    ACTIVITY_NULL(104002, "Activity 为空"),
    CONTAINER_NULL(104003, "容器视图为空"),
    CONTAINER_INVISIBLE(104004, "容器不可见"),
    ORIENTATION_MISMATCH(104005, "方向不匹配"),
    AD_NOT_READY(104006, "广告未就绪"),
    ALREADY_SHOWN(104007, "广告已展示"),
    CLICK_FAILED(105001, "点击失败"),
    LANDING_PAGE_ERROR(105002, "落地页错误"),
    DOWNLOAD_FAILED(105003, "下载失败"),
    INSTALL_FAILED(105004, "安装失败"),
    DEEPLINK_FAILED(105005, "深度链接失败"),
    RESOURCE_LOAD_FAILED(106001, "资源加载失败"),
    IMAGE_LOAD_FAILED(106002, "图片加载失败"),
    VIDEO_LOAD_FAILED(106003, "视频加载失败"),
    INSUFFICIENT_STORAGE(106004, "存储空间不足"),
    MEMORY_INSUFFICIENT(106005, "内存不足"),
    PERMISSION_DENIED(107001, "权限被拒绝"),
    INSTALL_PERMISSION_DENIED(107002, "安装权限被拒绝"),
    STORAGE_PERMISSION_DENIED(107003, "存储权限被拒绝"),
    NETWORK_PERMISSION_DENIED(107004, "网络权限被拒绝"),
    BIDDING_FAILED(108001, "竞价失败"),
    PRICE_TOO_LOW(108002, "出价过低"),
    BIDDING_TIMEOUT(108003, "竞价超时"),
    INVALID_BIDDING_PARAMS(108004, "竞价参数无效"),
    CONFIG_PARSE_ERROR(109001, "配置解析错误"),
    CONFIG_EXPIRED(109002, "配置已过期"),
    FEATURE_DISABLED(109003, "功能已禁用");

    private static final Map<Integer, ErrorCodeEnum> CODE_MAP;
    private final int code;
    private final String desc;

    static {
        HashMap map = new HashMap();
        for (ErrorCodeEnum errorCodeEnum : values()) {
            map.put(Integer.valueOf(errorCodeEnum.code), errorCodeEnum);
        }
        CODE_MAP = Collections.unmodifiableMap(map);
    }

    ErrorCodeEnum(int i, String str) {
        this.code = i;
        this.desc = str;
    }

    public static ErrorCodeEnum fromCode(int i) {
        ErrorCodeEnum errorCodeEnum = CODE_MAP.get(Integer.valueOf(i));
        return errorCodeEnum != null ? errorCodeEnum : UNKNOWN_ERROR;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ErrorCode{code=" + this.code + ", desc='" + this.desc + "'}";
    }
}
