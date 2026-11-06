package com.bykv.vk.openvk.component.video.ms.xr.ka;

import com.anythink.basead.ui.GuideToClickView;
import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.openvk.component.video.ms.xr.ny;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    List<ny.xr> f87ms;
    ka xr;

    public abstract List<ny.xr> ah();

    public abstract String c();

    public abstract InputStream d();

    public abstract String ka();

    public abstract int ms();

    protected String ms(int i) {
        switch (i) {
            case 200:
                return ca.k;
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case 300:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case 305:
                        return "Use Proxy";
                    default:
                        switch (i) {
                            case 400:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case 402:
                                return "Payment Required";
                            case 403:
                                return "Forbidden";
                            case 404:
                                return "Not Found";
                            case 405:
                                return "Method Not Allowed";
                            case 406:
                                return "Not Acceptable";
                            case 407:
                                return "Proxy Authentication Required";
                            case TTAdConstant.INTERACTION_TYPE_CODE /* 408 */:
                                return "Request Time-Out";
                            case TTAdConstant.IMAGE_LIST_CODE /* 409 */:
                                return "Conflict";
                            case TTAdConstant.IMAGE_LIST_SIZE_CODE /* 410 */:
                                return "Gone";
                            case TTAdConstant.IMAGE_CODE /* 411 */:
                                return "Length Required";
                            case TTAdConstant.IMAGE_URL_CODE /* 412 */:
                                return "Precondition Failed";
                            case TTAdConstant.VIDEO_INFO_CODE /* 413 */:
                                return "Request Entity Too Large";
                            case TTAdConstant.VIDEO_URL_CODE /* 414 */:
                                return "Request-URI Too Large";
                            case TTAdConstant.VIDEO_COVER_URL_CODE /* 415 */:
                                return "Unsupported Media Type";
                            default:
                                switch (i) {
                                    case 500:
                                        return "Internal Server Error";
                                    case 501:
                                        return "Not Implemented";
                                    case 502:
                                        return "Bad Gateway";
                                    case GuideToClickView.a.c /* 503 */:
                                        return "Service Unavailable";
                                    case 504:
                                        return "Gateway Timeout";
                                    case 505:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String ms(String str, String str2);

    public abstract boolean xr();

    public ka ab() {
        return this.xr;
    }

    protected ny.xr ms(String str) {
        List<ny.xr> list;
        if (str != null && (list = this.f87ms) != null && list.size() > 0) {
            for (ny.xr xrVar : this.f87ms) {
                if (str.equals(xrVar.f103ms)) {
                    return xrVar;
                }
            }
        }
        return null;
    }
}
