package com.tapsdk.tapad.internal.runtime.web;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bumptech.glide.load.Key;
import com.byazt.fi.BaseConstants;
import com.tapsdk.tapad.c;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.Util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class DirichletCreativePackage {
    private static final String CONTENT_SECURITY_POLICY = "default-src 'self' data: blob:; connect-src 'none'; img-src 'self' data: blob:; media-src 'self' data: blob:; font-src 'self' data:; script-src 'self' 'unsafe-inline'; style-src 'self' 'unsafe-inline'; frame-src 'none'; object-src 'none'; base-uri 'none'; form-action 'none'";
    private static final int MAX_FILE_BYTES = 25165824;
    private static final int MAX_FILE_COUNT = 1024;
    private static final int MAX_PACKAGE_BYTES = 33554432;
    private static final int MAX_TOTAL_UNCOMPRESSED_BYTES = 67108864;
    private final String entrypoint;
    private final Map<String, byte[]> files;

    public final class PackageWebViewClient extends WebViewClient {
        private final DirichletCreativeWebBridge bridge;
        private final Set<String> imageUrls;
        private final Set<String> mediaUrls;
        private final String originHost;

        public PackageWebViewClient(DirichletCreativeWebBridge dirichletCreativeWebBridge, String str, Set<String> set, Set<String> set2) {
            this.bridge = dirichletCreativeWebBridge;
            this.originHost = Uri.parse(str).getHost();
            this.mediaUrls = set;
            this.imageUrls = set2;
        }

        private WebResourceResponse blockedResponse() {
            return new WebResourceResponse("text/plain", Key.STRING_CHARSET_NAME, 403, "Forbidden", Collections.singletonMap("Cache-Control", "no-store"), new ByteArrayInputStream(new byte[0]));
        }

        private int[] byteRange(String str, int i) {
            int iIndexOf;
            int i2;
            int iMax;
            if (i <= 0 || str == null || str.contains(",") || (iIndexOf = str.indexOf(45)) < 0) {
                return null;
            }
            try {
                String strTrim = str.substring(0, iIndexOf).trim();
                String strTrim2 = str.substring(iIndexOf + 1).trim();
                if (strTrim.isEmpty()) {
                    int i3 = Integer.parseInt(strTrim2);
                    if (i3 <= 0) {
                        return null;
                    }
                    iMax = Math.max(0, i - i3);
                    i2 = i - 1;
                } else {
                    int i4 = Integer.parseInt(strTrim);
                    i2 = strTrim2.isEmpty() ? i - 1 : Integer.parseInt(strTrim2);
                    iMax = i4;
                }
                if (iMax >= 0 && iMax < i && i2 >= iMax) {
                    return new int[]{iMax, Math.min(i2, i - 1)};
                }
                return null;
            } catch (NumberFormatException e) {
                return null;
            }
        }

        private String header(Map<String, String> map, String str) {
            if (map == null) {
                return null;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (str.equalsIgnoreCase(entry.getKey())) {
                    return entry.getValue();
                }
            }
            return null;
        }

        private boolean isAllowedExternal(String str) {
            if (this.imageUrls.contains(str) || this.mediaUrls.contains(str)) {
                return true;
            }
            Iterator<String> it = this.mediaUrls.iterator();
            while (it.hasNext()) {
                Uri uri = Uri.parse(it.next());
                Uri uri2 = Uri.parse(str);
                if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(uri2.getScheme()) && DirichletCreativePackage.safeEquals(uri.getHost(), uri2.getHost()) && DirichletCreativePackage.effectivePort(uri) == DirichletCreativePackage.effectivePort(uri2)) {
                    String path = uri.getPath();
                    int iLastIndexOf = path == null ? -1 : path.lastIndexOf(47);
                    String strSubstring = iLastIndexOf >= 0 ? path.substring(0, iLastIndexOf + 1) : "/";
                    if (uri2.getPath() != null && uri2.getPath().startsWith(strSubstring)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean isPackageOrigin(Uri uri) {
            String str;
            return uri != null && BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(uri.getScheme()) && (str = this.originHost) != null && str.equalsIgnoreCase(uri.getHost());
        }

        private WebResourceResponse responseFor(Uri uri, Map<String, String> map) {
            if (uri == null) {
                return blockedResponse();
            }
            String scheme = uri.getScheme();
            if ("data".equalsIgnoreCase(scheme) || "blob".equalsIgnoreCase(scheme) || isAllowedExternal(uri.toString())) {
                return null;
            }
            if (!isPackageOrigin(uri)) {
                return blockedResponse();
            }
            String strNormalizePath = DirichletCreativePackage.normalizePath(uri.getPath());
            byte[] bArr = (byte[]) DirichletCreativePackage.this.files.get(strNormalizePath);
            if (bArr == null) {
                return blockedResponse();
            }
            String strMime = DirichletCreativePackage.mime(strNormalizePath);
            String str = (strMime.startsWith("text/") || strMime.contains("javascript") || strMime.contains("json")) ? Key.STRING_CHARSET_NAME : null;
            String strHeader = header(map, Util.RANGE);
            if (strHeader == null || !strHeader.startsWith("bytes=")) {
                return new WebResourceResponse(strMime, str, 200, "OK", responseHeaders(bArr.length), new ByteArrayInputStream(bArr));
            }
            int[] iArrByteRange = byteRange(strHeader.substring(6), bArr.length);
            if (iArrByteRange == null) {
                HashMap map2 = new HashMap();
                map2.put(Util.CONTENT_RANGE, "bytes */" + bArr.length);
                return new WebResourceResponse("text/plain", Key.STRING_CHARSET_NAME, 416, "Range Not Satisfiable", map2, new ByteArrayInputStream(new byte[0]));
            }
            int i = iArrByteRange[0];
            int i2 = iArrByteRange[1];
            int i3 = (i2 - i) + 1;
            Map<String, String> mapResponseHeaders = responseHeaders(i3);
            mapResponseHeaders.put(Util.CONTENT_RANGE, "bytes " + i + "-" + i2 + "/" + bArr.length);
            return new WebResourceResponse(strMime, str, 206, "Partial Content", mapResponseHeaders, new ByteArrayInputStream(bArr, i, i3));
        }

        private Map<String, String> responseHeaders(int i) {
            HashMap map = new HashMap();
            map.put(Util.ACCEPT_RANGES, "bytes");
            map.put("Cache-Control", "no-store");
            map.put(Util.CONTENT_LENGTH, Integer.toString(i));
            return map;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            try {
                if (this.bridge == null || !isPackageOrigin(Uri.parse(str))) {
                    return;
                }
                this.bridge.onPageFinished();
            } catch (Throwable th) {
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return (webResourceRequest == null || webResourceRequest.getUrl() == null || !TapHttp.METHOD_GET.equalsIgnoreCase(webResourceRequest.getMethod())) ? blockedResponse() : responseFor(webResourceRequest.getUrl(), webResourceRequest.getRequestHeaders());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return webResourceRequest == null || !isPackageOrigin(webResourceRequest.getUrl());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                return true ^ isPackageOrigin(Uri.parse(str));
            } catch (Throwable th) {
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                return responseFor(Uri.parse(str), Collections.EMPTY_MAP);
            } catch (Throwable th) {
                return blockedResponse();
            }
        }
    }

    private DirichletCreativePackage(Map<String, byte[]> map, String str) {
        this.files = Collections.unmodifiableMap(map);
        this.entrypoint = str;
    }

    private static boolean containsHls(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String lowerCase = it.next().toLowerCase(Locale.US);
            if (lowerCase.contains(".m3u8") || lowerCase.contains("format=m3u8")) {
                return true;
            }
        }
        return false;
    }

    private static String cspOrigins(Set<String> set) {
        HashSet hashSet = new HashSet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            try {
                Uri uri = Uri.parse(it.next());
                if (BaseConstants.SCHEME_HTTPS.equalsIgnoreCase(uri.getScheme()) && uri.getHost() != null) {
                    int iEffectivePort = effectivePort(uri);
                    hashSet.add(" https://" + uri.getHost() + (iEffectivePort == 443 ? "" : ":" + iEffectivePort));
                }
            } catch (Throwable th) {
            }
        }
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        return joinWithEmptySeparator(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int effectivePort(Uri uri) {
        if (uri.getPort() >= 0) {
            return uri.getPort();
        }
        return 443;
    }

    private static boolean hasParentSegment(String str) {
        for (String str2 : str.split("/")) {
            if ("..".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            if (sb.length() > 0) {
                sb.append('/');
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private static String joinWithEmptySeparator(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    private static Set<String> jsonStringSet(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String strOptString = jSONArray.optString(i, "");
            if (strOptString.startsWith("https://")) {
                hashSet.add(strOptString);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String mime(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.endsWith(".html") || lowerCase.endsWith(".htm")) {
            return "text/html";
        }
        if (lowerCase.endsWith(".css")) {
            return "text/css";
        }
        if (lowerCase.endsWith(".js")) {
            return "application/javascript";
        }
        if (lowerCase.endsWith(".json")) {
            return "application/json";
        }
        if (lowerCase.endsWith(".svg")) {
            return "image/svg+xml";
        }
        if (lowerCase.endsWith(".png")) {
            return "image/png";
        }
        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg")) {
            return "image/jpeg";
        }
        if (lowerCase.endsWith(".webp")) {
            return "image/webp";
        }
        if (lowerCase.endsWith(".gif")) {
            return "image/gif";
        }
        if (lowerCase.endsWith(".mp4")) {
            return "video/mp4";
        }
        if (lowerCase.endsWith(".webm")) {
            return "video/webm";
        }
        return lowerCase.endsWith(".woff2") ? "font/woff2" : "application/octet-stream";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String normalizePath(String str) {
        if (str == null) {
            return "";
        }
        String strReplace = str.replace(AbstractJsonLexerKt.STRING_ESC, '/');
        while (strReplace.startsWith("/")) {
            strReplace = strReplace.substring(1);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strReplace.split("/")) {
            if (!str2.isEmpty() && !".".equals(str2)) {
                if (!"..".equals(str2)) {
                    arrayList.add(str2);
                } else if (!arrayList.isEmpty()) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return join(arrayList);
    }

    public static DirichletCreativePackage openVerifiedArchive(byte[] bArr, String str) throws IOException {
        if (bArr == null || bArr.length == 0 || bArr.length > 33554432) {
            throw new IOException("DCWP_PACKAGE_SIZE_INVALID");
        }
        Map<String, byte[]> zip = readZip(bArr);
        if (str == null || str.isEmpty() || !str.equals(normalizePath(str)) || !zip.containsKey(str)) {
            throw new IOException("DCWP_ENTRYPOINT_INVALID");
        }
        return new DirichletCreativePackage(zip, str);
    }

    private static Map<String, byte[]> readZip(byte[] bArr) throws IOException {
        HashMap map = new HashMap();
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(bArr));
        int i = 0;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return map;
                }
                String strReplace = nextEntry.getName() == null ? "" : nextEntry.getName().replace(AbstractJsonLexerKt.STRING_ESC, '/');
                if (strReplace.startsWith("/") || hasParentSegment(strReplace)) {
                    throw new IOException("DCWP_PATH_OUT_OF_SCOPE");
                }
                String strNormalizePath = normalizePath(strReplace);
                if (!strNormalizePath.isEmpty() && !nextEntry.isDirectory()) {
                    if (nextEntry.getMethod() != 0) {
                        throw new IOException("DCWP_ZIP_COMPRESSION_UNSUPPORTED");
                    }
                    if (nextEntry.getSize() > 25165824 || nextEntry.getCompressedSize() > 25165824 || (nextEntry.getSize() >= 0 && nextEntry.getCompressedSize() >= 0 && nextEntry.getSize() != nextEntry.getCompressedSize())) {
                        throw new IOException("DCWP_ZIP_ENTRY_SIZE_INVALID:" + strNormalizePath);
                    }
                    if (map.containsKey(strNormalizePath)) {
                        throw new IOException("DCWP_DUPLICATE_FILE:" + strNormalizePath);
                    }
                    if (map.size() >= 1024) {
                        throw new IOException("DCWP_TOO_MANY_FILES");
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr2 = new byte[8192];
                    int i2 = 0;
                    while (true) {
                        int i3 = zipInputStream.read(bArr2);
                        if (i3 < 0) {
                            i += i2;
                            map.put(strNormalizePath, byteArrayOutputStream.toByteArray());
                            break;
                        }
                        i2 += i3;
                        if (i2 > MAX_FILE_BYTES) {
                            throw new IOException("DCWP_FILE_TOO_LARGE:" + strNormalizePath);
                        }
                        if (((long) i) + ((long) i2) > 67108864) {
                            throw new IOException("DCWP_TOTAL_UNCOMPRESSED_TOO_LARGE");
                        }
                        byteArrayOutputStream.write(bArr2, 0, i3);
                    }
                }
            } catch (Throwable th) {
                try {
                    zipInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean safeEquals(String str, String str2) {
        return (str == null || str2 == null || !str.equalsIgnoreCase(str2)) ? false : true;
    }

    private static String text(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new String(bArr, StandardCharsets.UTF_8);
    }

    private static String withHostPolicy(String str, DirichletCreativeWebBridge dirichletCreativeWebBridge, Set<String> set, Set<String> set2) {
        String strCspOrigins = cspOrigins(set);
        String str2 = "<meta http-equiv=\"Content-Security-Policy\" content=\"" + CONTENT_SECURITY_POLICY.replace("connect-src 'none'", containsHls(set) ? c.a("connect-src 'self'", strCspOrigins) : "connect-src 'none'").replace("media-src 'self' data: blob:", "media-src 'self' data: blob:" + strCspOrigins).replace("img-src 'self' data: blob:", "img-src 'self' data: blob:" + cspOrigins(set2)) + "\">";
        String str3 = dirichletCreativeWebBridge == null ? "" : "<script>" + dirichletCreativeWebBridge.bootstrapScript().replace("</script", "<\\/script") + "</script>";
        int iIndexOf = str.toLowerCase(Locale.US).indexOf("<head>");
        if (iIndexOf < 0) {
            return str2 + str3 + str;
        }
        int i = iIndexOf + 6;
        return str.substring(0, i) + str2 + str3 + str.substring(i);
    }

    public String entrypoint() {
        return this.entrypoint;
    }

    public byte[] file(String str) {
        byte[] bArr = this.files.get(normalizePath(str));
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public void loadInto(WebView webView, DirichletCreativeWebBridge dirichletCreativeWebBridge) {
        loadInto(webView, dirichletCreativeWebBridge, new JSONObject());
    }

    public void loadInto(WebView webView, DirichletCreativeWebBridge dirichletCreativeWebBridge, JSONObject jSONObject) {
        if (webView == null) {
            throw new IllegalArgumentException("webView == null");
        }
        if (dirichletCreativeWebBridge != null) {
            dirichletCreativeWebBridge.attach(webView);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowContentAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setMixedContentMode(1);
        webView.getSettings().setSupportMultipleWindows(false);
        webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        webView.removeJavascriptInterface("Android");
        String str = "https://" + UUID.randomUUID().toString().replace("-", "") + ".dirichlet-creative.invalid/";
        Set<String> setJsonStringSet = jsonStringSet(jSONObject == null ? null : jSONObject.optJSONArray("media_urls"));
        Set<String> setJsonStringSet2 = jsonStringSet(jSONObject != null ? jSONObject.optJSONArray("image_urls") : null);
        webView.setWebViewClient(new PackageWebViewClient(dirichletCreativeWebBridge, str, setJsonStringSet, setJsonStringSet2));
        webView.loadDataWithBaseURL(str, withHostPolicy(text(this.files.get(entrypoint())), dirichletCreativeWebBridge, setJsonStringSet, setJsonStringSet2), "text/html", Key.STRING_CHARSET_NAME, null);
    }
}
