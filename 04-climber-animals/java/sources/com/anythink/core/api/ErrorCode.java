package com.anythink.core.api;

import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes.dex */
public class ErrorCode {
    public static final String adShowError = "4006";
    public static final String adSourceBidError = "4007";
    public static final String adSourceLoadBidTypeFilterError = "2032";
    public static final String adSourceLoadCappingError = "2022";
    public static final String adSourceLoadPriceFilterError = "2033";
    public static final String adSourceLoadRiskError = "2031";
    public static final String adSourceLoadUnitFilterError = "2034";
    public static final String adSourceNotFilledError = "4008";
    public static final String adapterInnerError = "2006";
    public static final String adapterNotExistError = "2002";
    public static final String appIdError = "10003";
    public static final String appIdOrPlaceIdEmpty = "3002";
    public static final String appKeyError = "10001";
    public static final String biddingResultHasShow = "2019";
    public static final String c2sBiddingCacheError = "2012";
    public static final String compareFailedError = "2035";
    public static final String contextDestoryError = "4002";
    public static final String dataLevelLowError = "9992";
    public static final String exception = "9999";
    public static final String filterByMNErrorCodeReqLimit = "2020";
    public static final String filterByMatchNetworkErrorCode = "2021";
    public static final String filterByRefreshSystemSplash = "2015";
    public static final String filterSourceError = "2010";
    public static final String forbidNetworkByDeveloper = "2018";
    public static final String formatError = "3003";
    public static final String httpStatuException = "9990";
    public static final String inAdxBidFailedInterval = "2017";
    public static final String inAdxBidInterval = "2016";
    public static final String inNetworkErrorCodeRequestFailPacing = "2014";
    public static final String inPacingError = "2004";
    public static final String inPacingError_Format = "2030";
    public static final String inPacingError_Global = "2029";
    public static final String inRequestFailPacing = "2007";
    public static final String loadCappingError = "2009";
    public static final String loadCappingError_Format = "2024";
    public static final String loadCappingError_Global = "2023";
    public static final String loadFailInPacingError = "2008";
    public static final String loadInShowingFilter = "2011";
    public static final String loadingError = "2005";
    public static final String networkError = "1001";
    public static final String networkFirmIdFilterSourceError = "2013";
    public static final String noADError = "4001";
    public static final String noAdsourceConfig = "4004";
    public static final String noAdsourceConfigInDebugerMode = "4009";
    public static final String noAvailableAdsource = "4005";
    public static final String noFillNcError = "2036";
    public static final String noFillSError = "2037";
    public static final String noFillSrError = "2038";
    public static final String outOfCapError = "2003";
    public static final String outOfCapError_day_Format = "2026";
    public static final String outOfCapError_day_Global = "2025";
    public static final String outOfCapError_hour_Format = "2028";
    public static final String outOfCapError_hour_Global = "2027";
    public static final String placeDeletedError = "3004";
    public static final String placeStrategyError = "3001";
    public static final String placementAdClose = "4003";
    public static final String placementIdError = "10004";
    public static final String serverError = "1002";
    public static final String sharedPlacementIdError = "10019";
    public static final String statuError = "9991";
    public static final String timeOutError = "2001";
    public static final String unknown = "-9999";
    public static final String unknownMediationIdError = "10020";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static AdError getErrorCode(String str, String str2, String str3) {
        String str4;
        str.hashCode();
        int iHashCode = str.hashCode();
        String str5 = inPacingError;
        String str6 = outOfCapError;
        String str7 = adapterNotExistError;
        String str8 = timeOutError;
        String str9 = serverError;
        String str10 = loadingError;
        byte b = -1;
        switch (iHashCode) {
            case 1507424:
                str4 = networkError;
                if (str.equals(str4)) {
                    b = 0;
                }
                break;
            case 1507425:
                b = str.equals(str9) ? (byte) 1 : (byte) -1;
                str9 = str9;
                str4 = networkError;
                break;
            case 1537215:
                b = str.equals(str8) ? (byte) 2 : (byte) -1;
                str8 = str8;
                str4 = networkError;
                break;
            case 1537216:
                b = str.equals(str7) ? (byte) 3 : (byte) -1;
                str7 = str7;
                str4 = networkError;
                break;
            case 1537217:
                b = str.equals(str6) ? (byte) 4 : (byte) -1;
                str6 = str6;
                str4 = networkError;
                break;
            case 1537218:
                b = str.equals(str5) ? (byte) 5 : (byte) -1;
                str5 = str5;
                str4 = networkError;
                break;
            case 1537219:
                b = str.equals(str10) ? (byte) 6 : (byte) -1;
                str10 = str10;
                str4 = networkError;
                break;
            case 1537220:
                if (str.equals(adapterInnerError)) {
                    b = 7;
                }
                str4 = networkError;
                break;
            case 1537221:
                if (str.equals(inRequestFailPacing)) {
                    b = 8;
                }
                str4 = networkError;
                break;
            case 1537222:
                if (str.equals(loadFailInPacingError)) {
                    b = 9;
                }
                str4 = networkError;
                break;
            case 1537223:
                if (str.equals(loadCappingError)) {
                    b = 10;
                }
                str4 = networkError;
                break;
            case 1537245:
                if (str.equals(filterSourceError)) {
                    b = 11;
                }
                str4 = networkError;
                break;
            case 1537246:
                if (str.equals(loadInShowingFilter)) {
                    b = 12;
                }
                str4 = networkError;
                break;
            case 1537247:
                if (str.equals(c2sBiddingCacheError)) {
                    b = ek.k;
                }
                str4 = networkError;
                break;
            case 1537248:
                if (str.equals(networkFirmIdFilterSourceError)) {
                    b = ek.l;
                }
                str4 = networkError;
                break;
            case 1537249:
                if (str.equals(inNetworkErrorCodeRequestFailPacing)) {
                    b = ek.m;
                }
                str4 = networkError;
                break;
            case 1537250:
                if (str.equals(filterByRefreshSystemSplash)) {
                    b = ek.n;
                }
                str4 = networkError;
                break;
            case 1537251:
                if (str.equals(inAdxBidInterval)) {
                    b = 17;
                }
                str4 = networkError;
                break;
            case 1537252:
                if (str.equals(inAdxBidFailedInterval)) {
                    b = 18;
                }
                str4 = networkError;
                break;
            case 1537253:
                if (str.equals(forbidNetworkByDeveloper)) {
                    b = 19;
                }
                str4 = networkError;
                break;
            case 1537276:
                if (str.equals(filterByMNErrorCodeReqLimit)) {
                    b = 20;
                }
                str4 = networkError;
                break;
            case 1537277:
                if (str.equals(filterByMatchNetworkErrorCode)) {
                    b = 21;
                }
                str4 = networkError;
                break;
            case 1537278:
                if (str.equals(adSourceLoadCappingError)) {
                    b = 22;
                }
                str4 = networkError;
                break;
            case 1537279:
                if (str.equals(loadCappingError_Global)) {
                    b = 23;
                }
                str4 = networkError;
                break;
            case 1537280:
                if (str.equals(loadCappingError_Format)) {
                    b = 24;
                }
                str4 = networkError;
                break;
            case 1537281:
                if (str.equals(outOfCapError_day_Global)) {
                    b = 25;
                }
                str4 = networkError;
                break;
            case 1537282:
                if (str.equals(outOfCapError_day_Format)) {
                    b = 26;
                }
                str4 = networkError;
                break;
            case 1537283:
                if (str.equals(outOfCapError_hour_Global)) {
                    b = 27;
                }
                str4 = networkError;
                break;
            case 1537284:
                if (str.equals(outOfCapError_hour_Format)) {
                    b = 28;
                }
                str4 = networkError;
                break;
            case 1537285:
                if (str.equals(inPacingError_Global)) {
                    b = 29;
                }
                str4 = networkError;
                break;
            case 1537307:
                if (str.equals(inPacingError_Format)) {
                    b = 30;
                }
                str4 = networkError;
                break;
            case 1537308:
                if (str.equals(adSourceLoadRiskError)) {
                    b = 31;
                }
                str4 = networkError;
                break;
            case 1537309:
                if (str.equals(adSourceLoadBidTypeFilterError)) {
                    b = 32;
                }
                str4 = networkError;
                break;
            case 1537310:
                if (str.equals(adSourceLoadPriceFilterError)) {
                    b = 33;
                }
                str4 = networkError;
                break;
            case 1537311:
                if (str.equals(adSourceLoadUnitFilterError)) {
                    b = 34;
                }
                str4 = networkError;
                break;
            case 1537312:
                if (str.equals(compareFailedError)) {
                    b = 35;
                }
                str4 = networkError;
                break;
            case 1537313:
                if (str.equals(noFillNcError)) {
                    b = 36;
                }
                str4 = networkError;
                break;
            case 1537314:
                if (str.equals(noFillSError)) {
                    b = 37;
                }
                str4 = networkError;
                break;
            case 1537315:
                if (str.equals(noFillSrError)) {
                    b = 38;
                }
                str4 = networkError;
                break;
            case 1567006:
                if (str.equals(placeStrategyError)) {
                    b = 39;
                }
                str4 = networkError;
                break;
            case 1567007:
                if (str.equals(appIdOrPlaceIdEmpty)) {
                    b = 40;
                }
                str4 = networkError;
                break;
            case 1567008:
                if (str.equals(formatError)) {
                    b = 41;
                }
                str4 = networkError;
                break;
            case 1596797:
                if (str.equals(noADError)) {
                    b = 42;
                }
                str4 = networkError;
                break;
            case 1596798:
                if (str.equals(contextDestoryError)) {
                    b = 43;
                }
                str4 = networkError;
                break;
            case 1596799:
                if (str.equals(placementAdClose)) {
                    b = 44;
                }
                str4 = networkError;
                break;
            case 1596800:
                if (str.equals(noAdsourceConfig)) {
                    b = 45;
                }
                str4 = networkError;
                break;
            case 1596801:
                if (str.equals(noAvailableAdsource)) {
                    b = 46;
                }
                str4 = networkError;
                break;
            case 1596802:
                if (str.equals(adShowError)) {
                    b = 47;
                }
                str4 = networkError;
                break;
            case 1596803:
                if (str.equals(adSourceBidError)) {
                    b = 48;
                }
                str4 = networkError;
                break;
            case 1596804:
                if (str.equals(adSourceNotFilledError)) {
                    b = 49;
                }
                str4 = networkError;
                break;
            case 1596805:
                if (str.equals(noAdsourceConfigInDebugerMode)) {
                    b = 50;
                }
                str4 = networkError;
                break;
            case 1754679:
                if (str.equals(httpStatuException)) {
                    b = 51;
                }
                str4 = networkError;
                break;
            case 1754680:
                if (str.equals(statuError)) {
                    b = 52;
                }
                str4 = networkError;
                break;
            case 1754681:
                if (str.equals(dataLevelLowError)) {
                    b = 53;
                }
                str4 = networkError;
                break;
            case 1754688:
                if (str.equals(exception)) {
                    b = 54;
                }
                str4 = networkError;
                break;
            case 46730162:
                if (str.equals("10001")) {
                    b = 55;
                }
                str4 = networkError;
                break;
            case 46730164:
                if (str.equals(appIdError)) {
                    b = 56;
                }
                str4 = networkError;
                break;
            case 46730165:
                if (str.equals(placementIdError)) {
                    b = 57;
                }
                str4 = networkError;
                break;
            case 46730201:
                if (str.equals(sharedPlacementIdError)) {
                    b = 58;
                }
                str4 = networkError;
                break;
            case 46730223:
                if (str.equals(unknownMediationIdError)) {
                    b = 59;
                }
                str4 = networkError;
                break;
            default:
                str4 = networkError;
                break;
        }
        switch (b) {
            case 0:
                return new AdError(str4, "Network is unavailable.", str2, str3);
            case 1:
                return new AdError(str9, "Server is unavailable.", str2, str3);
            case 2:
                return new AdError(str8, "Ad load time out.", str2, str3);
            case 3:
                return new AdError(str7, "Adapter does not exist.", str2, str3);
            case 4:
                return new AdError(str6, "Not satisfy the Placement's Cap configuration.", str2, str3);
            case 5:
                return new AdError(str5, "Not satisfy the Placement's Placing configuration.", str2, str3);
            case 6:
                return new AdError(str10, "Placement's Ad is loading.", str2, str3);
            case 7:
                return new AdError(adapterInnerError, "Please check if your network sdk version is correct and all the network plugin has been put in your package.", str2, str3);
            case 8:
                return new AdError(inRequestFailPacing, "Not satisfy the Fail-request's Placing configuration.", str2, str3);
            case 9:
                return new AdError(loadFailInPacingError, "The placement load too frequent within the specified time period after the previous load failure.", str2, str3);
            case 10:
                return new AdError(loadCappingError, "The placement load too many times within the specified time period.", str2, str3);
            case 11:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                return new AdError(str, str3, str2, str3);
            case 12:
                return new AdError(loadInShowingFilter, "This unitgroup can't load on showing.", str2, str3);
            case 13:
                return new AdError(c2sBiddingCacheError, "C2S Bidding Cache error.", str2, str3);
            case 14:
                return new AdError(noAdsourceConfigInDebugerMode, "AdSource filter by network firm id.", str2, str3);
            case 23:
                return new AdError(loadCappingError_Global, "The placement load too many times within global time period.", str2, str3);
            case 24:
                return new AdError(loadCappingError_Format, "The placement load too many times within format time period.", str2, str3);
            case 25:
                return new AdError(outOfCapError_day_Global, "App global cap limit within day.", str2, str3);
            case 26:
                return new AdError(outOfCapError_day_Format, "Ad format cap limit within day.", str2, str3);
            case 27:
                return new AdError(outOfCapError_hour_Global, "App global cap limit within hour.", str2, str3);
            case 28:
                return new AdError(outOfCapError_hour_Format, "Ad format cap limit within hour.", str2, str3);
            case 29:
                return new AdError(inPacingError_Global, "App global pace limit.", str2, str3);
            case 30:
                return new AdError(inPacingError_Format, "Format pace limit.", str2, str3);
            case 31:
                return new AdError(adSourceLoadRiskError, "Risk device filter.", str2, str3);
            case 32:
                return new AdError(adSourceLoadBidTypeFilterError, "Bid type limit.", str2, str3);
            case 33:
                return new AdError(adSourceLoadPriceFilterError, "Price limit.", str2, str3);
            case 34:
                return new AdError(adSourceLoadUnitFilterError, "Ad unit limit.", str2, str3);
            case 35:
                return new AdError(compareFailedError, "Multi mediation fail.", str2, str3);
            case 36:
                return new AdError(str, "AdSource continuous no fill.", str2, str3);
            case 37:
                return new AdError(str, "AdSource cumulative no fill.", str2, str3);
            case 38:
                return new AdError(str, "AdSource cumulative no fill percentage.", str2, str3);
            case 39:
                return new AdError(placeStrategyError, "Get placement strategy error, please check your appid、appkey and placementid is availiable.", str2, str3);
            case 40:
                return new AdError(appIdOrPlaceIdEmpty, "AppId or PlacementId is empty.", str2, str3);
            case 41:
                return new AdError(formatError, "Mismatched ad placement and ad format", str2, str3);
            case 42:
                return new AdError(noADError, "Return Ad is empty.", str2, str3);
            case 43:
                return new AdError(contextDestoryError, "Context or activity has been destory.", str2, str3);
            case 44:
                return new AdError(placementAdClose, "Placement Ads switch is close.", str2, str3);
            case 45:
                return new AdError(noAdsourceConfig, "The placement strategy does not contain any ad sources, please check the mediation configuration in TopOn", str2, str3);
            case 46:
                return new AdError(noAvailableAdsource, "Ad sources are filtered, no ad source is currently available", str2, str3);
            case 47:
                return new AdError(adShowError, "Ad show failed", str2, str3);
            case 48:
                return new AdError(adSourceBidError, "Bid error", str2, str3);
            case 49:
                return new AdError(adSourceNotFilledError, "Ad source not filled, cause by customize fillter.", str2, str3);
            case 50:
                return new AdError(noAdsourceConfigInDebugerMode, "The placement strategy does not contain any ad sources, please check the debugger configuration in ATSDK.setDebuggerConfig", str2, str3);
            case 51:
                return new AdError(httpStatuException, "Possible network issue on device. Please check your network.", str2, str3);
            case 52:
                if ("699".equals(str2)) {
                    return new AdError(placeDeletedError, "This Placement has been suspended or deleted and no longer obtains Placement strategy.", "", "");
                }
                if ("700".equals(str2)) {
                    return new AdError(statuError, "API access restricted due to too many requests. Please reduce requests or try again later.", "", "");
                }
                return new AdError(statuError, "Service status error.", str2, str3);
            case 53:
                return new AdError(dataLevelLowError, "Upload data level is FORBIDDEN, must called 'ATSDK.setGDPRUploadDataLevel' to set the level.", str2, str3);
            case 54:
                return new AdError(exception, "Exception in sdk.", str2, str3);
            case 55:
                return new AdError("10001", "Please check your appkey.", str2, str3);
            case 56:
                return new AdError(appIdError, "Please check your appid.", str2, str3);
            case 57:
                return new AdError(placementIdError, "Please check your placementid.", str2, str3);
            case 58:
                return new AdError(sharedPlacementIdError, "Forbidden placement", str2, str3);
            case 59:
                return new AdError(unknownMediationIdError, "Unknown Mediation ID", str2, str3);
            default:
                return new AdError("-9999", "unknown", str2, str3);
        }
    }
}
