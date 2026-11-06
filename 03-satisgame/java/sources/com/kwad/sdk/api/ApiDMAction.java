package com.kwad.sdk.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface ApiDMAction {
    public static final String TRANSFORM_API_HOST = "TRANSFORM_API_HOST";
    public static final String URC = "URC";
    public static final String WRC = "WRC";
    public static final String WRI = "WRI";
    public static final String WRT = "WRT";
    public static final String enableDynamic = "enableDynamic";
    public static final String filterStack = "filterStack";
    public static final String getAutoRevertTime = "getAutoRevertTime";
    public static final String getThrowClassNotFoundSet = "getThrowClassNotFoundSet";
    public static final String reportDynamicUpdate = "reportDynamicUpdate";
}
