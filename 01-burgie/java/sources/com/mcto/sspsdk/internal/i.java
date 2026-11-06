package com.mcto.sspsdk.internal;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class i {
    public static /* synthetic */ String a(int i) {
        switch (i) {
            case 1:
                return "AD_EVENT_LOADING";
            case 2:
                return "AD_EVENT_SUCCESS";
            case 3:
                return "AD_EVENT_FAILURE_CDN_HTTP_ERROR";
            case 4:
                return "AD_EVENT_FAILURE_CDN_TIMEOUT";
            case 5:
                return "AD_EVENT_FAILURE_CDN_PARSE_ERROR";
            case 6:
                return "AD_EVENT_FAILURE_HTTP_ERROR";
            case 7:
                return "AD_EVENT_FAILURE_TIMEOUT";
            case 8:
                return "AD_EVENT_FAILURE_DATA_ERROR";
            case 9:
                return "AD_EVENT_FAILURE_TYPE_ERROR";
            case 10:
                return "AD_EVENT_FAILURE_OVER_SIZE";
            case 11:
                return "AD_EVENT_GONE";
            case 12:
                return "AD_EVENT_IMPRESSION";
            case 13:
                return "AD_EVENT_START";
            case 14:
                return "AD_EVENT_1Q";
            case 15:
                return "AD_EVENT_MID";
            case 16:
                return "AD_EVENT_3Q";
            case 17:
                return "AD_EVENT_STOP";
            case 18:
                return "AD_EVENT_COMPLETE";
            case 19:
                return "AD_EVENT_TRUEVIEW";
            case 20:
                return "AD_EVENT_REPLAY";
            case 21:
                return "AD_EVENT_CLICK";
            case 22:
                return "AD_EVENT_CLOSE";
            case 23:
                return "AD_EVENT_SEEK";
            case 24:
                return "AD_EVENT_SKIP";
            case 25:
                return "AD_EVENT_DEEPLINK";
            case 26:
                return "AD_EVENT_INCENTIVETASK";
            case 27:
                return "AD_EVENT_EXT_ARE_OPEN";
            case 28:
                return "AD_EVENT_EXT_ARE_SHOW";
            case 29:
                return "AD_EVENT_EXT_ARE_ERROR";
            case 30:
                return "AD_EVENT_EXT_ARE_CLOSE";
            case 31:
                return "AD_EVENT_PRE_DOWNLOAD";
            case 32:
                return "AD_EVENT_DOWNLOAD_ERROR";
            case 33:
                return "AD_EVENT_DOWNLOAD";
            case 34:
                return "AD_EVENT_DOWNLOADED";
            case 35:
                return "AD_EVENT_INSTALLED";
            default:
                return AbstractJsonLexerKt.NULL;
        }
    }
}
