package com.tapsdk.tapad.internal;

import com.tapsdk.tapad.constants.ErrorCodeEnum;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'FAIL_TO_GET_GLOBAL_CONFIG' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class InterErrCode {
    private static final /* synthetic */ InterErrCode[] $VALUES;
    public static final InterErrCode AD_INFO_FAIL_GET_SPACE_ID;
    public static final InterErrCode CLIENT_FAIL_DISMISS_DIALOG;
    public static final InterErrCode CLIENT_FAIL_GET_NETWORK_TYPE;
    public static final InterErrCode CLIENT_FAIL_ON_ACTIVITY_CREATED;
    public static final InterErrCode CLIENT_FAIL_UPDATE_DOWNLOAD_NOTIFICATION;
    public static final InterErrCode COMMON_INIT_ERROR = new InterErrCode("COMMON_INIT_ERROR", 0, ErrorCodeEnum.AD_EXPIRED, "激励广告无视频素材，或视频已过期");
    public static final InterErrCode COMMON_NO_AD_ERROR = new InterErrCode("COMMON_NO_AD_ERROR", 1, ErrorCodeEnum.NO_AD_FILL, "广告素材不存在");
    public static final InterErrCode COMMON_UNKNOWN_ERROR;
    public static final InterErrCode FAIL_TO_CONFIG_MEDIA_PLAYER;
    public static final InterErrCode FAIL_TO_CREATE_BREAK_POINT_STORE_ON_SQL_LITE;
    public static final InterErrCode FAIL_TO_FORMAT_NUMBER;
    public static final InterErrCode FAIL_TO_GET_AD_INFO;
    public static final InterErrCode FAIL_TO_GET_GLOBAL_CONFIG;
    public static final InterErrCode FAIL_TO_GET_INSTALL_FILE_URI;
    public static final InterErrCode FAIL_TO_GET_PACKAGE_INFO;
    public static final InterErrCode FAIL_TO_GET_PACKAGE_NAME;
    public static final InterErrCode FAIL_TO_REPORT_DOWNLOAD_CONTENT;
    public static final InterErrCode FAIL_TO_SHOW_ERROR_VIEW;
    public static final InterErrCode FAIL_TO_START_ACTION_VIEW;
    public static final InterErrCode FAIL_TO_TRACK_NETWORK_STATS;
    public static final InterErrCode JSON_ERROR;
    public static final InterErrCode MEDIA_PLAYER_FAIL_TO_SET_VOLUME_VISIBILITY;
    public static final InterErrCode MEDIA_PLAYER_FAIL_TO_UPDATE_STATUS;
    public static final InterErrCode OAID_FAIL_TO_GET;
    public static final InterErrCode OAID_HONOR_FAIL_GET_INTENT_SERVICE;
    public static final InterErrCode OAID_OPPO_FAIL_DURING_OUID;
    public static final InterErrCode PARCELABLE_ERROR;
    private final String desc;
    private final ErrorCodeEnum publicCode;

    private static /* synthetic */ InterErrCode[] $values() {
        return new InterErrCode[]{COMMON_INIT_ERROR, COMMON_NO_AD_ERROR, FAIL_TO_GET_GLOBAL_CONFIG, FAIL_TO_GET_AD_INFO, AD_INFO_FAIL_GET_SPACE_ID, COMMON_UNKNOWN_ERROR, FAIL_TO_CONFIG_MEDIA_PLAYER, MEDIA_PLAYER_FAIL_TO_SET_VOLUME_VISIBILITY, MEDIA_PLAYER_FAIL_TO_UPDATE_STATUS, FAIL_TO_GET_PACKAGE_NAME, FAIL_TO_GET_PACKAGE_INFO, FAIL_TO_START_ACTION_VIEW, FAIL_TO_GET_INSTALL_FILE_URI, CLIENT_FAIL_ON_ACTIVITY_CREATED, JSON_ERROR, PARCELABLE_ERROR, FAIL_TO_TRACK_NETWORK_STATS, FAIL_TO_CREATE_BREAK_POINT_STORE_ON_SQL_LITE, CLIENT_FAIL_GET_NETWORK_TYPE, FAIL_TO_REPORT_DOWNLOAD_CONTENT, FAIL_TO_SHOW_ERROR_VIEW, CLIENT_FAIL_UPDATE_DOWNLOAD_NOTIFICATION, CLIENT_FAIL_DISMISS_DIALOG, FAIL_TO_FORMAT_NUMBER, OAID_FAIL_TO_GET, OAID_HONOR_FAIL_GET_INTENT_SERVICE, OAID_OPPO_FAIL_DURING_OUID};
    }

    static {
        ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.CONFIG_PARSE_ERROR;
        FAIL_TO_GET_GLOBAL_CONFIG = new InterErrCode("FAIL_TO_GET_GLOBAL_CONFIG", 2, errorCodeEnum, "fail to get global config");
        FAIL_TO_GET_AD_INFO = new InterErrCode("FAIL_TO_GET_AD_INFO", 3, ErrorCodeEnum.LOAD_FAILED, "fail to get ad info");
        AD_INFO_FAIL_GET_SPACE_ID = new InterErrCode("AD_INFO_FAIL_GET_SPACE_ID", 4, ErrorCodeEnum.INVALID_SPACE_ID, "ad_info fail get space id");
        COMMON_UNKNOWN_ERROR = new InterErrCode("COMMON_UNKNOWN_ERROR", 5, ErrorCodeEnum.UNKNOWN_ERROR, "unknown error occurred");
        ErrorCodeEnum errorCodeEnum2 = ErrorCodeEnum.VIDEO_LOAD_FAILED;
        FAIL_TO_CONFIG_MEDIA_PLAYER = new InterErrCode("FAIL_TO_CONFIG_MEDIA_PLAYER", 6, errorCodeEnum2, "fail to config media player");
        MEDIA_PLAYER_FAIL_TO_SET_VOLUME_VISIBILITY = new InterErrCode("MEDIA_PLAYER_FAIL_TO_SET_VOLUME_VISIBILITY", 7, errorCodeEnum2, "media player fail to set volume visibility");
        MEDIA_PLAYER_FAIL_TO_UPDATE_STATUS = new InterErrCode("MEDIA_PLAYER_FAIL_TO_UPDATE_STATUS", 8, errorCodeEnum2, "media player fail to update status");
        ErrorCodeEnum errorCodeEnum3 = ErrorCodeEnum.INTERNAL_ERROR;
        FAIL_TO_GET_PACKAGE_NAME = new InterErrCode("FAIL_TO_GET_PACKAGE_NAME", 9, errorCodeEnum3, "fail to get package name");
        FAIL_TO_GET_PACKAGE_INFO = new InterErrCode("FAIL_TO_GET_PACKAGE_INFO", 10, errorCodeEnum3, "fail to get package info");
        FAIL_TO_START_ACTION_VIEW = new InterErrCode("FAIL_TO_START_ACTION_VIEW", 11, ErrorCodeEnum.DEEPLINK_FAILED, "fail to start action view");
        FAIL_TO_GET_INSTALL_FILE_URI = new InterErrCode("FAIL_TO_GET_INSTALL_FILE_URI", 12, ErrorCodeEnum.INSTALL_FAILED, "fail to get install file uri");
        ErrorCodeEnum errorCodeEnum4 = ErrorCodeEnum.SHOW_FAILED;
        CLIENT_FAIL_ON_ACTIVITY_CREATED = new InterErrCode("CLIENT_FAIL_ON_ACTIVITY_CREATED", 13, errorCodeEnum4, "fail in on activity created method");
        JSON_ERROR = new InterErrCode("JSON_ERROR", 14, errorCodeEnum, "json error");
        PARCELABLE_ERROR = new InterErrCode("PARCELABLE_ERROR", 15, errorCodeEnum3, "parcelable error");
        ErrorCodeEnum errorCodeEnum5 = ErrorCodeEnum.NETWORK_ERROR;
        FAIL_TO_TRACK_NETWORK_STATS = new InterErrCode("FAIL_TO_TRACK_NETWORK_STATS", 16, errorCodeEnum5, "fail to track network stats");
        FAIL_TO_CREATE_BREAK_POINT_STORE_ON_SQL_LITE = new InterErrCode("FAIL_TO_CREATE_BREAK_POINT_STORE_ON_SQL_LITE", 17, ErrorCodeEnum.INSUFFICIENT_STORAGE, "fail to create point store on sql lite");
        CLIENT_FAIL_GET_NETWORK_TYPE = new InterErrCode("CLIENT_FAIL_GET_NETWORK_TYPE", 18, errorCodeEnum5, "fail get network type");
        ErrorCodeEnum errorCodeEnum6 = ErrorCodeEnum.DOWNLOAD_FAILED;
        FAIL_TO_REPORT_DOWNLOAD_CONTENT = new InterErrCode("FAIL_TO_REPORT_DOWNLOAD_CONTENT", 19, errorCodeEnum6, "fail to report download content");
        FAIL_TO_SHOW_ERROR_VIEW = new InterErrCode("FAIL_TO_SHOW_ERROR_VIEW", 20, errorCodeEnum4, "fail to show error view");
        CLIENT_FAIL_UPDATE_DOWNLOAD_NOTIFICATION = new InterErrCode("CLIENT_FAIL_UPDATE_DOWNLOAD_NOTIFICATION", 21, errorCodeEnum6, "fail to update download notification");
        CLIENT_FAIL_DISMISS_DIALOG = new InterErrCode("CLIENT_FAIL_DISMISS_DIALOG", 22, errorCodeEnum4, "fail to dismiss dialog");
        FAIL_TO_FORMAT_NUMBER = new InterErrCode("FAIL_TO_FORMAT_NUMBER", 23, errorCodeEnum3, "fail to format number");
        OAID_FAIL_TO_GET = new InterErrCode("OAID_FAIL_TO_GET", 24, errorCodeEnum3, "fail to get oaid");
        OAID_HONOR_FAIL_GET_INTENT_SERVICE = new InterErrCode("OAID_HONOR_FAIL_GET_INTENT_SERVICE", 25, errorCodeEnum3, "oaid honor fail get intent service");
        OAID_OPPO_FAIL_DURING_OUID = new InterErrCode("OAID_OPPO_FAIL_DURING_OUID", 26, errorCodeEnum3, "oaid oppo fail when get ouid");
        $VALUES = $values();
    }

    private InterErrCode(String str, int i, ErrorCodeEnum errorCodeEnum, String str2) {
        super(str, i);
        this.publicCode = errorCodeEnum;
        this.desc = str2;
    }

    public static InterErrCode valueOf(String str) {
        return (InterErrCode) Enum.valueOf(InterErrCode.class, str);
    }

    public static InterErrCode[] values() {
        return (InterErrCode[]) $VALUES.clone();
    }

    public int getCode() {
        return this.publicCode.getCode();
    }

    public String getDesc() {
        return this.desc;
    }

    public ErrorCodeEnum getPublicCode() {
        return this.publicCode;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ErrorCode{code='" + this.publicCode.getCode() + "', desc='" + this.desc + "'}";
    }
}
