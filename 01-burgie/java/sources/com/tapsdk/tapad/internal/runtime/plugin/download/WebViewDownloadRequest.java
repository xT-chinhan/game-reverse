package com.tapsdk.tapad.internal.runtime.plugin.download;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.byazt.eyv.AdBaseConstants;
import com.tapsdk.tapad.internal.runtime.download.DownloadUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class WebViewDownloadRequest {
    private static final Pattern FILENAME_PATTERN = Pattern.compile("filename\\*?=(?:UTF-8'')?\"?([^\";]+)\"?");
    public final String contentDisposition;
    public final String fileName;
    public final String mimeType;
    public final long size;
    public final String url;
    public final String userAgent;

    public WebViewDownloadRequest(String str, String str2, String str3, String str4, long j) {
        str = str == null ? "" : str;
        this.url = str;
        this.userAgent = str2 == null ? "" : str2;
        str3 = str3 == null ? "" : str3;
        this.contentDisposition = str3;
        str4 = str4 == null ? "" : str4;
        this.mimeType = str4;
        this.size = j;
        this.fileName = resolveFileName(str, str3, str4);
    }

    private static String fileNameFromContentDisposition(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Matcher matcher = FILENAME_PATTERN.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private static String resolveFileName(String str, String str2, String str3) {
        String strFileNameFromContentDisposition = fileNameFromContentDisposition(str2);
        if (TextUtils.isEmpty(strFileNameFromContentDisposition)) {
            strFileNameFromContentDisposition = URLUtil.guessFileName(str, str2, str3);
        }
        if (TextUtils.isEmpty(strFileNameFromContentDisposition)) {
            strFileNameFromContentDisposition = DownloadUtils.extractFileName(str);
        }
        String strSanitizeFileName = DownloadUtils.sanitizeFileName(strFileNameFromContentDisposition);
        return TextUtils.isEmpty(strSanitizeFileName) ? "download_" + System.currentTimeMillis() : strSanitizeFileName;
    }

    public boolean isApk() {
        return this.fileName.toLowerCase(Locale.US).endsWith(".apk") || AdBaseConstants.MIME_APK.equalsIgnoreCase(this.mimeType);
    }
}
