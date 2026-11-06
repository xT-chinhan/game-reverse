package com.taptap.sdk.kit.internal.time;

import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.fi.BaseConstants;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.bundle.BundleId;
import com.taptap.sdk.compliance.constants.BundleKey;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TapWebClock.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u000e\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002JN\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00162\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0017H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010)2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010,\u001a\u0004\u0018\u00010)2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010.\u001a\u0004\u0018\u00010/2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u0004H\u0002J\u0017\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b5J\u0018\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0002J$\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0016H\u0002J\u001c\u0010>\u001a\u0004\u0018\u0001092\b\u0010?\u001a\u0004\u0018\u0001092\u0006\u0010@\u001a\u000203H\u0002J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010B\u001a\u00020CH\u0002JM\u0010E\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020\u00042\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\u0014\b\u0002\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160G2\b\b\u0002\u0010H\u001a\u00020IH\u0000¢\u0006\u0002\bJJ\u0018\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0010\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004H\u0002J\u0012\u0010O\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0007J\u0015\u0010P\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u0004H\u0000¢\u0006\u0002\bQJ\u001e\u0010R\u001a\u0004\u0018\u00010/2\b\u0010S\u001a\u0004\u0018\u00010T2\b\u00107\u001a\u0004\u0018\u00010/H\u0007J\u0012\u0010U\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0007J\u0014\u0010V\u001a\u0004\u0018\u00010/2\b\u0010S\u001a\u0004\u0018\u00010TH\u0007J\u001e\u0010V\u001a\u0004\u0018\u00010/2\b\u0010W\u001a\u0004\u0018\u00010\u00142\b\u0010S\u001a\u0004\u0018\u00010TH\u0007J\u001e\u0010V\u001a\u0004\u0018\u00010/2\b\u0010W\u001a\u0004\u0018\u00010\u00142\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010V\u001a\u0004\u0018\u00010/2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0007J\u0017\u0010X\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bYJ\u0012\u0010Z\u001a\u00020\u00162\b\u0010[\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\\\u001a\u00020\u00162\b\u0010]\u001a\u0004\u0018\u00010\u0004H\u0002J\u0017\u0010^\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b_J!\u0010`\u001a\u00020\u00162\b\u0010a\u001a\u0004\u0018\u00010\u00042\b\u0010b\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bcJ!\u0010d\u001a\u00020\u00162\b\u0010a\u001a\u0004\u0018\u00010\u00042\b\u0010b\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\beJ\u0018\u0010f\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0016H\u0002J\u0010\u0010g\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010h\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004H\u0002JX\u0010i\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00172$\u0010j\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0017\u0012\u0004\u0012\u00020\u00190kH\u0007J\u0018\u0010l\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010m\u001a\u00020)H\u0002J\u0012\u0010n\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J0\u0010o\u001a\u0004\u0018\u00010<2\u0006\u0010 \u001a\u00020\u00042\u0014\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00172\u0006\u0010H\u001a\u00020IH\u0002J'\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u0002092\u0006\u0010t\u001a\u00020\u00072\b\b\u0002\u0010u\u001a\u00020vH\u0000¢\u0006\u0002\bwJ\u0015\u0010x\u001a\u00020\u00042\u0006\u0010y\u001a\u00020\u0004H\u0000¢\u0006\u0002\bzJ\u0018\u0010{\u001a\u0002092\u0006\u0010|\u001a\u00020r2\u0006\u0010s\u001a\u000209H\u0002J+\u0010}\u001a\u0004\u0018\u00010)2\b\u0010~\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b\u007fJ%\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0081\u0001\u001a\u00020\u00042\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0003\b\u0083\u0001J\u0015\u0010\u0084\u0001\u001a\u0004\u0018\u00010/2\b\u0010S\u001a\u0004\u0018\u00010TH\u0007J\u0012\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010L\u001a\u00020\u0004H\u0002J!\u0010\u0087\u0001\u001a\u00020\u00162\u0006\u0010L\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0017\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010;\u001a\u00020<H\u0002J,\u0010\u0089\u0001\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0007\u0010\u008a\u0001\u001a\u00020\u00162\b\u0010[\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0003\b\u008b\u0001J\u0019\u0010\u008c\u0001\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0003\b\u008d\u0001J\"\u0010\u008e\u0001\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u0004H\u0002J\u0019\u0010\u0090\u0001\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u0018\u0010\u0091\u0001\u001a\u00020\u00072\u0007\u0010\u0092\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u00042\n\b\u0002\u0010\u0095\u0001\u001a\u00030\u0096\u0001H\u0000¢\u0006\u0003\b\u0097\u0001JK\u0010\u0098\u0001\u001a\u00020/2\t\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00042\b\u0010~\u001a\u0004\u0018\u00010\u00042\u0007\u0010\u0092\u0001\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00042\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u00108\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u0012\u001aB\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00160\u0016 \u0015* \u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u0014\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\u00170\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¡\u0001"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock;", "", "()V", "CLOCK_JS_PATH", "", "CLOCK_SCRIPT_TAG", "CONNECT_TIMEOUT_MS", "", "INJECTABLE_HOST_SUFFIXES", "", "JS_INTERFACE_NAME", "MAX_HTML_BYTES", "META_CHARSET", "Lkotlin/text/Regex;", "READ_TIMEOUT_MS", "REDIRECT_CODES", "", "SRC_ATTR", "javascriptInterfaceInstalled", "", "Landroid/webkit/WebView;", "kotlin.jvm.PlatformType", "", "", "addJavascriptInterface", "", "webView", "bounceDocument", "Lcom/taptap/sdk/kit/internal/time/TapWebClock$InjectedDocument;", "from", "to", "buildDocument", BreakpointSQLiteKey.URL, NotificationCompat.CATEGORY_STATUS, MediationConstant.KEY_REASON, "contentType", "bytes", "", "complete", "headers", "charsetFromBom", "Ljava/nio/charset/Charset;", "charsetFromContentType", "charsetFromMeta", "charsetFromName", Common.System.NAME, "clockScriptResponse", "Landroid/webkit/WebResourceResponse;", "clockSrcPath", "src", "contentEncodingAction", "Lcom/taptap/sdk/kit/internal/time/TapWebClock$ContentEncodingAction;", "contentEncoding", "contentEncodingAction$tap_common_release", "copyResponse", "response", "data", "Ljava/io/InputStream;", "copyResponseHeaders", "connection", "Ljava/net/HttpURLConnection;", "skipContentEncoding", "decodeContent", "stream", "action", "effectivePort", ContentProviderManager.PROVIDER_URI, "Ljava/net/URI;", "effectiveScheme", "fetchInjectedDocument", "isAllowedUrl", "Lkotlin/Function1;", "cookies", "Lcom/taptap/sdk/kit/internal/time/TapWebClock$CookieSink;", "fetchInjectedDocument$tap_common_release", "findTagClose", "html", "htmlAttribute", Constants.VALUE_FIELD, "inject", "injectIntoHtml", "injectIntoHtml$tap_common_release", "injectIntoResponse", "request", "Landroid/webkit/WebResourceRequest;", "install", "intercept", "view", "isClockScriptUrl", "isClockScriptUrl$tap_common_release", "isGet", "method", "isHtmlMime", "mime", "isInjectableDocumentUrl", "isInjectableDocumentUrl$tap_common_release", "isSameDocumentUrl", "left", "right", "isSameDocumentUrl$tap_common_release", "isSameOrigin", "isSameOrigin$tap_common_release", "isSkippedResponseHeader", "isValidUtf8", "jsStringLiteral", "load", "loadUrl", "Lkotlin/Function2;", "looksLikeHtml", "charset", "mimeOf", "openDocumentConnection", "requestHeaders", "readAtMost", "Lcom/taptap/sdk/kit/internal/time/TapWebClock$BoundedRead;", "source", "maxBytes", "prefix", "Ljava/io/ByteArrayOutputStream;", "readAtMost$tap_common_release", "redirectBounceHtml", "target", "redirectBounceHtml$tap_common_release", "replayUnread", "read", "resolveHtmlCharset", "encoding", "resolveHtmlCharset$tap_common_release", "resolveRedirect", "current", "location", "resolveRedirect$tap_common_release", "rewriteMainDocument", "scanHtml", "Lcom/taptap/sdk/kit/internal/time/TapWebClock$HtmlScan;", "scriptSrcIsClock", "setCookieValues", "shouldRewriteDocument", "isForMainFrame", "shouldRewriteDocument$tap_common_release", "shouldServeClockScript", "shouldServeClockScript$tap_common_release", "skipRawTextEnd", "tag", "skipTagName", "statusCodeForWebResourceResponse", "statusCode", "statusCodeForWebResourceResponse$tap_common_release", "webClockPatchScript", "tapTimeMillis", "", "webClockPatchScript$tap_common_release", "webResponse", "mimeType", "AndroidCookieSink", "BoundedRead", "ContentEncodingAction", "CookieSink", "DisconnectingInputStream", "HtmlScan", "InjectedDocument", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TapWebClock {
    public static final String CLOCK_JS_PATH = "/__tapsdk_web_clock__.js";
    private static final String CLOCK_SCRIPT_TAG = "<script src=\"/__tapsdk_web_clock__.js\"></script>";
    private static final int CONNECT_TIMEOUT_MS = 5000;
    private static final String JS_INTERFACE_NAME = "TapSDKTime";
    public static final int MAX_HTML_BYTES = 2097152;
    private static final int READ_TIMEOUT_MS = 5000;
    public static final TapWebClock INSTANCE = new TapWebClock();
    private static final Map<WebView, Boolean> javascriptInterfaceInstalled = Collections.synchronizedMap(new WeakHashMap());
    private static final List<String> INJECTABLE_HOST_SUFFIXES = CollectionsKt.listOf((Object[]) new String[]{"tapsdk.xdrnd.cn", "tapsdk.xdrnd.com", "tapsdk.tapapis.cn", "tapsdk.tapapis.com", "tapsdk.api.xdrnd.cn", "tapsdk.api.xdrnd.com", "tapsdk.api.tapapis.cn", "tapsdk.api.tapapis.com"});
    private static final Set<Integer> REDIRECT_CODES = SetsKt.setOf((Object[]) new Integer[]{301, 302, 303, 307, 308});
    private static final Regex META_CHARSET = new Regex("<meta\\b[^>]*?(?:charset\\s*=\\s*[\"']?([A-Za-z0-9._-]+)|http-equiv\\s*=\\s*[\"']?content-type[\"'][^>]*charset=([A-Za-z0-9._-]+))", (Set<? extends RegexOption>) SetsKt.setOf((Object[]) new RegexOption[]{RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL}));
    private static final Regex SRC_ATTR = new Regex("src\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]+))", RegexOption.IGNORE_CASE);

    /* JADX INFO: compiled from: TapWebClock.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock$ContentEncodingAction;", "", "(Ljava/lang/String;I)V", "IDENTITY", "DECODE_GZIP", "PASSTHROUGH", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ContentEncodingAction {
        IDENTITY,
        DECODE_GZIP,
        PASSTHROUGH
    }

    /* JADX INFO: compiled from: TapWebClock.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH&¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock$CookieSink;", "", "getCookie", "", BreakpointSQLiteKey.URL, "saveFromResponse", "", "setCookies", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface CookieSink {
        String getCookie(String url);

        void saveFromResponse(String url, List<String> setCookies);
    }

    @JvmStatic
    public static final void load(WebView webView, String str, Function2<? super String, ? super Map<String, String>, Unit> loadUrl) {
        Intrinsics.checkNotNullParameter(loadUrl, "loadUrl");
        load$default(webView, str, null, loadUrl, 4, null);
    }

    private TapWebClock() {
    }

    @JvmStatic
    public static final void install(WebView webView) {
        if (webView == null) {
            return;
        }
        INSTANCE.addJavascriptInterface(webView);
        inject(webView);
    }

    @JvmStatic
    public static final void inject(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.evaluateJavascript(webClockPatchScript$tap_common_release$default(INSTANCE, 0L, 1, null), null);
        } catch (RuntimeException e) {
        }
    }

    @JvmStatic
    public static final WebResourceResponse intercept(WebResourceRequest request) {
        return intercept((WebView) null, request);
    }

    @JvmStatic
    public static final WebResourceResponse intercept(String url) {
        return INSTANCE.clockScriptResponse(url);
    }

    @JvmStatic
    public static final WebResourceResponse intercept(WebView view, WebResourceRequest request) {
        Uri url;
        return INSTANCE.clockScriptResponse((request == null || (url = request.getUrl()) == null) ? null : url.toString());
    }

    @JvmStatic
    public static final WebResourceResponse intercept(WebView view, String url) {
        return INSTANCE.clockScriptResponse(url);
    }

    @JvmStatic
    public static final WebResourceResponse rewriteMainDocument(WebResourceRequest request) {
        Map<String, String> mapEmptyMap;
        InjectedDocument document;
        Uri url;
        String url2 = (request == null || (url = request.getUrl()) == null) ? null : url.toString();
        TapWebClock tapWebClock = INSTANCE;
        if (!tapWebClock.shouldRewriteDocument$tap_common_release(url2, request != null && request.isForMainFrame(), request != null ? request.getMethod() : null)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Map<String, String> requestHeaders = request != null ? request.getRequestHeaders() : null;
            if (requestHeaders == null) {
                requestHeaders = MapsKt.emptyMap();
            }
            mapEmptyMap = requestHeaders;
        } else {
            mapEmptyMap = MapsKt.emptyMap();
        }
        if (url2 == null || (document = fetchInjectedDocument$tap_common_release$default(tapWebClock, url2, mapEmptyMap, null, null, 12, null)) == null) {
            return null;
        }
        return document.toResponse();
    }

    public static /* synthetic */ void load$default(WebView webView, String str, Map map, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        load(webView, str, map, function2);
    }

    @JvmStatic
    public static final void load(WebView webView, String url, Map<String, String> headers, Function2<? super String, ? super Map<String, String>, Unit> loadUrl) {
        String it;
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(loadUrl, "loadUrl");
        String str = url;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        LinkedHashMap requestHeaders = new LinkedHashMap(headers);
        if (webView != null) {
            INSTANCE.addJavascriptInterface(webView);
            try {
                String userAgent = webView.getSettings().getUserAgentString();
                String str2 = userAgent;
                if (!(str2 == null || StringsKt.isBlank(str2))) {
                    Iterable iterableKeySet = requestHeaders.keySet();
                    Intrinsics.checkNotNullExpressionValue(iterableKeySet, "requestHeaders.keys");
                    Iterable $this$none$iv = iterableKeySet;
                    if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
                        Iterator it2 = $this$none$iv.iterator();
                        do {
                            if (!it2.hasNext()) {
                                z = true;
                                break;
                            } else {
                                Object element$iv = it2.next();
                                it = (String) element$iv;
                            }
                        } while (!StringsKt.equals(it, "User-Agent", true));
                    } else {
                        z = true;
                    }
                    if (z) {
                        requestHeaders.put("User-Agent", userAgent);
                    }
                }
            } catch (RuntimeException e) {
            }
        }
        loadUrl.invoke(url, requestHeaders);
    }

    @JvmStatic
    public static final WebResourceResponse injectIntoResponse(WebResourceRequest request, WebResourceResponse response) {
        InputStream source;
        Uri url;
        if (response == null) {
            return null;
        }
        String url2 = (request == null || (url = request.getUrl()) == null) ? null : url.toString();
        TapWebClock tapWebClock = INSTANCE;
        if (!tapWebClock.shouldRewriteDocument$tap_common_release(url2, request != null && request.isForMainFrame(), request != null ? request.getMethod() : null)) {
            return response;
        }
        String mime = response.getMimeType();
        if (mime == null) {
            mime = "";
        }
        if (!tapWebClock.isHtmlMime(mime) || (source = response.getData()) == null) {
            return response;
        }
        ByteArrayOutputStream prefix = new ByteArrayOutputStream();
        try {
            BoundedRead read = tapWebClock.readAtMost$tap_common_release(source, 2097152, prefix);
            if (read.getComplete()) {
                Charset charset = tapWebClock.resolveHtmlCharset$tap_common_release(response.getEncoding(), mime, read.getBytes());
                if (charset != null) {
                    String html = new String(read.getBytes(), charset);
                    byte[] bytes = tapWebClock.injectIntoHtml$tap_common_release(html).getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    return tapWebClock.copyResponse(response, new ByteArrayInputStream(bytes));
                }
                return tapWebClock.copyResponse(response, new ByteArrayInputStream(read.getBytes()));
            }
            return tapWebClock.copyResponse(response, tapWebClock.replayUnread(read, source));
        } catch (Exception e) {
            return INSTANCE.copyResponse(response, new SequenceInputStream(new ByteArrayInputStream(prefix.toByteArray()), source));
        }
    }

    /* JADX INFO: compiled from: TapWebClock.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jg\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u000bHÖ\u0001J\u0010\u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010-\u001a\u00020\u0003J\u0006\u0010.\u001a\u00020\u000eJ\u0006\u0010/\u001a\u000200J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013¨\u00062"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock$InjectedDocument;", "", BreakpointSQLiteKey.URL, "", "body", "", "charset", "mime", "headers", "", "statusCode", "", MediationConstant.KEY_REASON, "data", "Ljava/io/InputStream;", "(Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;Ljava/io/InputStream;)V", "getBody", "()[B", "getCharset", "()Ljava/lang/String;", "getData", "()Ljava/io/InputStream;", "getHeaders", "()Ljava/util/Map;", "html", "getHtml", "getMime", "getReason", "getStatusCode", "()I", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "header", Common.System.NAME, "openBody", "toResponse", "Landroid/webkit/WebResourceResponse;", "toString", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class InjectedDocument {
        private final byte[] body;
        private final String charset;
        private final InputStream data;
        private final Map<String, String> headers;
        private final String mime;
        private final String reason;
        private final int statusCode;
        private final String url;

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final byte[] getBody() {
            return this.body;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getCharset() {
            return this.charset;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getMime() {
            return this.mime;
        }

        public final Map<String, String> component5() {
            return this.headers;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final InputStream getData() {
            return this.data;
        }

        public final InjectedDocument copy(String url, byte[] body, String charset, String mime, Map<String, String> headers, int statusCode, String reason, InputStream data) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(charset, "charset");
            Intrinsics.checkNotNullParameter(mime, "mime");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new InjectedDocument(url, body, charset, mime, headers, statusCode, reason, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InjectedDocument)) {
                return false;
            }
            InjectedDocument injectedDocument = (InjectedDocument) other;
            return Intrinsics.areEqual(this.url, injectedDocument.url) && Intrinsics.areEqual(this.body, injectedDocument.body) && Intrinsics.areEqual(this.charset, injectedDocument.charset) && Intrinsics.areEqual(this.mime, injectedDocument.mime) && Intrinsics.areEqual(this.headers, injectedDocument.headers) && this.statusCode == injectedDocument.statusCode && Intrinsics.areEqual(this.reason, injectedDocument.reason) && Intrinsics.areEqual(this.data, injectedDocument.data);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((this.url.hashCode() * 31) + Arrays.hashCode(this.body)) * 31) + this.charset.hashCode()) * 31) + this.mime.hashCode()) * 31) + this.headers.hashCode()) * 31) + Integer.hashCode(this.statusCode)) * 31) + this.reason.hashCode()) * 31;
            InputStream inputStream = this.data;
            return iHashCode + (inputStream == null ? 0 : inputStream.hashCode());
        }

        public String toString() {
            return "InjectedDocument(url=" + this.url + ", body=" + Arrays.toString(this.body) + ", charset=" + this.charset + ", mime=" + this.mime + ", headers=" + this.headers + ", statusCode=" + this.statusCode + ", reason=" + this.reason + ", data=" + this.data + ')';
        }

        public InjectedDocument(String url, byte[] body, String charset, String mime, Map<String, String> headers, int statusCode, String reason, InputStream data) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(charset, "charset");
            Intrinsics.checkNotNullParameter(mime, "mime");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.url = url;
            this.body = body;
            this.charset = charset;
            this.mime = mime;
            this.headers = headers;
            this.statusCode = statusCode;
            this.reason = reason;
            this.data = data;
        }

        public /* synthetic */ InjectedDocument(String str, byte[] bArr, String str2, String str3, Map map, int i, String str4, InputStream inputStream, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, bArr, str2, (i2 & 8) != 0 ? "text/html" : str3, (i2 & 16) != 0 ? MapsKt.emptyMap() : map, (i2 & 32) != 0 ? 200 : i, (i2 & 64) != 0 ? "OK" : str4, (i2 & 128) != 0 ? null : inputStream);
        }

        public final String getUrl() {
            return this.url;
        }

        public final byte[] getBody() {
            return this.body;
        }

        public final String getCharset() {
            return this.charset;
        }

        public final String getMime() {
            return this.mime;
        }

        public final Map<String, String> getHeaders() {
            return this.headers;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }

        public final String getReason() {
            return this.reason;
        }

        public final InputStream getData() {
            return this.data;
        }

        public final String header(String name) {
            Object element$iv;
            Map.Entry it;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterable $this$firstOrNull$iv = this.headers.entrySet();
            Iterator it2 = $this$firstOrNull$iv.iterator();
            do {
                if (!it2.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it2.next();
                it = (Map.Entry) element$iv;
            } while (!StringsKt.equals((String) it.getKey(), name, true));
            Map.Entry entry = (Map.Entry) element$iv;
            if (entry != null) {
                return (String) entry.getValue();
            }
            return null;
        }

        public final String getHtml() {
            Charset charsetObj = TapWebClock.INSTANCE.charsetFromName(this.charset);
            if (charsetObj == null) {
                charsetObj = StandardCharsets.ISO_8859_1;
            }
            byte[] bArr = this.body;
            Intrinsics.checkNotNullExpressionValue(charsetObj, "charsetObj");
            return new String(bArr, charsetObj);
        }

        public final InputStream openBody() {
            InputStream inputStream = this.data;
            return inputStream == null ? new ByteArrayInputStream(this.body) : inputStream;
        }

        public final WebResourceResponse toResponse() {
            LinkedHashMap responseHeaders = new LinkedHashMap(this.headers);
            Iterable iterableKeySet = responseHeaders.keySet();
            Intrinsics.checkNotNullExpressionValue(iterableKeySet, "responseHeaders.keys");
            Iterable $this$none$iv = iterableKeySet;
            boolean z = true;
            if (!($this$none$iv instanceof Collection) || !((Collection) $this$none$iv).isEmpty()) {
                for (Object element$iv : $this$none$iv) {
                    String it = (String) element$iv;
                    if (StringsKt.equals(it, "Content-Type", true)) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                responseHeaders.put("Content-Type", this.mime + "; charset=" + this.charset);
            }
            return TapWebClock.INSTANCE.webResponse(this.mime, this.charset, this.statusCode, this.reason, responseHeaders, openBody());
        }
    }

    /* JADX INFO: compiled from: TapWebClock.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016¨\u0006\n"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock$AndroidCookieSink;", "Lcom/taptap/sdk/kit/internal/time/TapWebClock$CookieSink;", "()V", "getCookie", "", BreakpointSQLiteKey.URL, "saveFromResponse", "", "setCookies", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AndroidCookieSink implements CookieSink {
        public static final AndroidCookieSink INSTANCE = new AndroidCookieSink();

        private AndroidCookieSink() {
        }

        @Override // com.taptap.sdk.kit.internal.time.TapWebClock.CookieSink
        public String getCookie(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            try {
                return CookieManager.getInstance().getCookie(url);
            } catch (Throwable th) {
                return null;
            }
        }

        @Override // com.taptap.sdk.kit.internal.time.TapWebClock.CookieSink
        public void saveFromResponse(String url, List<String> setCookies) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookies, "setCookies");
            if (setCookies.isEmpty()) {
                return;
            }
            try {
                CookieManager manager = CookieManager.getInstance();
                List<String> $this$forEach$iv = setCookies;
                for (Object element$iv : $this$forEach$iv) {
                    String cookie = (String) element$iv;
                    manager.setCookie(url, cookie);
                }
                manager.flush();
            } catch (Throwable th) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InjectedDocument fetchInjectedDocument$tap_common_release$default(TapWebClock tapWebClock, String str, Map map, Function1 function1, CookieSink cookieSink, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<String, Boolean>() { // from class: com.taptap.sdk.kit.internal.time.TapWebClock$fetchInjectedDocument$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(TapWebClock.INSTANCE.isInjectableDocumentUrl$tap_common_release(it));
                }
            };
        }
        if ((i & 8) != 0) {
            cookieSink = AndroidCookieSink.INSTANCE;
        }
        return tapWebClock.fetchInjectedDocument$tap_common_release(str, map, function1, cookieSink);
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0101  */
    /* JADX WARN: Code duplicated, block: B:53:0x0105  */
    /* JADX WARN: Code duplicated, block: B:54:0x0108  */
    public final InjectedDocument fetchInjectedDocument$tap_common_release(String url, Map<String, String> headers, Function1<? super String, Boolean> isAllowedUrl, CookieSink cookies) throws Throwable {
        InputStream rawStream;
        String str;
        String reason;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(isAllowedUrl, "isAllowedUrl");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        if (!isAllowedUrl.invoke(url).booleanValue()) {
            return null;
        }
        HttpURLConnection connection = null;
        boolean disconnectOnExit = true;
        try {
            HttpURLConnection opened = openDocumentConnection(url, headers, cookies);
            if (opened == null) {
                return null;
            }
            try {
                try {
                    int status = opened.getResponseCode();
                    cookies.saveFromResponse(url, setCookieValues(opened));
                    if (REDIRECT_CODES.contains(Integer.valueOf(status))) {
                        String next = resolveRedirect$tap_common_release(url, opened.getHeaderField("Location"));
                        if (next == null) {
                            opened.disconnect();
                            return null;
                        }
                        InjectedDocument injectedDocumentBounceDocument = bounceDocument(url, next);
                        opened.disconnect();
                        return injectedDocumentBounceDocument;
                    }
                    String contentType = opened.getContentType();
                    String contentEncoding = opened.getHeaderField("Content-Encoding");
                    ContentEncodingAction encodingAction = contentEncodingAction$tap_common_release(contentEncoding);
                    try {
                        if (status < 400 || (rawStream = opened.getErrorStream()) == null) {
                            rawStream = opened.getInputStream();
                        }
                    } catch (Exception e) {
                        rawStream = null;
                    }
                    ByteArrayInputStream byteArrayInputStreamDecodeContent = decodeContent(rawStream, encodingAction);
                    if (byteArrayInputStreamDecodeContent == null) {
                        byteArrayInputStreamDecodeContent = new ByteArrayInputStream(new byte[0]);
                    }
                    InputStream stream = byteArrayInputStreamDecodeContent;
                    BoundedRead read = readAtMost$tap_common_release$default(this, stream, 2097152, null, 4, null);
                    boolean z = true;
                    Map<String, String> mapCopyResponseHeaders = copyResponseHeaders(opened, encodingAction != ContentEncodingAction.PASSTHROUGH);
                    String it = opened.getResponseMessage();
                    if (it == null) {
                        if (200 <= status || status >= 300) {
                            z = false;
                        }
                        if (z) {
                            str = "OK";
                        } else {
                            str = "Error";
                        }
                        reason = str;
                    } else {
                        if (!(!StringsKt.isBlank(it))) {
                            it = null;
                        }
                        if (it == null) {
                            if (200 <= status) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (z) {
                                str = "OK";
                            } else {
                                str = "Error";
                            }
                            reason = str;
                        } else {
                            reason = it;
                        }
                    }
                    if (read.getComplete() && encodingAction != ContentEncodingAction.PASSTHROUGH) {
                        InjectedDocument injectedDocumentBuildDocument = buildDocument(url, statusCodeForWebResourceResponse$tap_common_release(status), reason, contentType, read.getBytes(), true, mapCopyResponseHeaders);
                        opened.disconnect();
                        return injectedDocumentBuildDocument;
                    }
                    try {
                        byte[] bArrPlus = ArraysKt.plus(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x016c: INVOKE (r3v4 'bArrPlus' byte[]) = 
                              (wrap byte[]:0x0164: INVOKE (r6v2 ?? I:??[OBJECT, ARRAY]) VIRTUAL call: com.taptap.sdk.kit.internal.time.TapWebClock.BoundedRead.getBytes():byte[] A[Catch: all -> 0x01c6, Exception -> 0x01ce, MD:():byte[] (m), WRAPPED] (LINE:293))
                              (wrap byte[]:0x0168: INVOKE (r6v2 ?? I:??[OBJECT, ARRAY]) VIRTUAL call: com.taptap.sdk.kit.internal.time.TapWebClock.BoundedRead.getOverflow():byte[] A[Catch: all -> 0x01c6, Exception -> 0x01ce, MD:():byte[] (m), WRAPPED])
                             STATIC call: kotlin.collections.ArraysKt.plus(byte[], byte[]):byte[] A[Catch: all -> 0x01c6, Exception -> 0x01ce, DECLARE_VAR, MD:(byte[], byte[]):byte[] (m)] (LINE:293) in method: com.taptap.sdk.kit.internal.time.TapWebClock.fetchInjectedDocument$tap_common_release(java.lang.String, java.util.Map<java.lang.String, java.lang.String>, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.Boolean>, com.taptap.sdk.kit.internal.time.TapWebClock$CookieSink):com.taptap.sdk.kit.internal.time.TapWebClock$InjectedDocument, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:320)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v2 ??
                            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                            */
                        /*
                            Method dump skipped, instruction units count: 498
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.taptap.sdk.kit.internal.time.TapWebClock.fetchInjectedDocument$tap_common_release(java.lang.String, java.util.Map, kotlin.jvm.functions.Function1, com.taptap.sdk.kit.internal.time.TapWebClock$CookieSink):com.taptap.sdk.kit.internal.time.TapWebClock$InjectedDocument");
                    }

                    private final InjectedDocument buildDocument(String url, int status, String reason, String contentType, byte[] bytes, boolean complete, Map<String, String> headers) {
                        Charset charsetCharsetFromContentType;
                        String mime = mimeOf(contentType);
                        Charset injectCharset = resolveHtmlCharset$tap_common_release(null, contentType, bytes);
                        if (complete) {
                            boolean z = false;
                            if (200 <= status && status < 300) {
                                z = true;
                            }
                            if (z && injectCharset != null && (isHtmlMime(mime) || looksLikeHtml(bytes, injectCharset))) {
                                byte[] injected = injectIntoHtml$tap_common_release(new String(bytes, injectCharset)).getBytes(injectCharset);
                                Intrinsics.checkNotNullExpressionValue(injected, "this as java.lang.String).getBytes(charset)");
                                String strName = injectCharset.name();
                                Intrinsics.checkNotNullExpressionValue(strName, "injectCharset.name()");
                                return new InjectedDocument(url, injected, strName, mime, headers, status, reason, null, 128, null);
                            }
                        }
                        if (injectCharset == 0) {
                            charsetCharsetFromContentType = charsetFromContentType(contentType);
                            if (charsetCharsetFromContentType == null && (charsetCharsetFromContentType = charsetFromBom(bytes)) == null) {
                                charsetCharsetFromContentType = isValidUtf8(bytes) ? StandardCharsets.UTF_8 : StandardCharsets.ISO_8859_1;
                            }
                        } else {
                            charsetCharsetFromContentType = injectCharset;
                        }
                        Charset passCharset = charsetCharsetFromContentType;
                        String strName2 = passCharset.name();
                        Intrinsics.checkNotNullExpressionValue(strName2, "passCharset.name()");
                        return new InjectedDocument(url, bytes, strName2, mime, headers, status, reason, null, 128, null);
                    }

                    /* JADX WARN: Code duplicated, block: B:44:0x0069  */
                    public final boolean isSameDocumentUrl$tap_common_release(String left, String right) {
                        boolean z;
                        String str = left;
                        if (!(str == null || StringsKt.isBlank(str))) {
                            String str2 = right;
                            if (!(str2 == null || StringsKt.isBlank(str2))) {
                                if (Intrinsics.areEqual(left, right)) {
                                    return true;
                                }
                                try {
                                    URI a = new URI(left);
                                    URI b = new URI(right);
                                    if (isSameOrigin$tap_common_release(left, right)) {
                                        String path = a.getPath();
                                        String str3 = "";
                                        if (path == null) {
                                            path = "";
                                        }
                                        String path2 = b.getPath();
                                        if (path2 == null) {
                                            path2 = "";
                                        }
                                        if (Intrinsics.areEqual(path, path2)) {
                                            String query = a.getQuery();
                                            if (query == null) {
                                                query = "";
                                            }
                                            String query2 = b.getQuery();
                                            if (query2 != null) {
                                                str3 = query2;
                                            }
                                            z = Intrinsics.areEqual(query, str3);
                                        }
                                    }
                                    return z;
                                } catch (Exception e) {
                                    return false;
                                }
                            }
                        }
                        return false;
                    }

                    /* JADX WARN: Code duplicated, block: B:35:0x007c  */
                    public final boolean isSameOrigin$tap_common_release(String left, String right) {
                        boolean z;
                        String str = left;
                        if (!(str == null || StringsKt.isBlank(str))) {
                            String str2 = right;
                            if (!(str2 == null || StringsKt.isBlank(str2))) {
                                try {
                                    URI a = new URI(left);
                                    URI b = new URI(right);
                                    if (Intrinsics.areEqual(effectiveScheme(a), effectiveScheme(b))) {
                                        String host = a.getHost();
                                        String str3 = "";
                                        if (host == null) {
                                            host = "";
                                        }
                                        Locale US = Locale.US;
                                        Intrinsics.checkNotNullExpressionValue(US, "US");
                                        String lowerCase = host.toLowerCase(US);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                                        String host2 = b.getHost();
                                        if (host2 != null) {
                                            str3 = host2;
                                        }
                                        Locale US2 = Locale.US;
                                        Intrinsics.checkNotNullExpressionValue(US2, "US");
                                        String lowerCase2 = str3.toLowerCase(US2);
                                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                                        z = Intrinsics.areEqual(lowerCase, lowerCase2) && effectivePort(a) == effectivePort(b);
                                    }
                                    return z;
                                } catch (Exception e) {
                                    return false;
                                }
                            }
                        }
                        return false;
                    }

                    public final String injectIntoHtml$tap_common_release(String html) {
                        int at;
                        Intrinsics.checkNotNullParameter(html, "html");
                        HtmlScan scan = scanHtml(html);
                        if (scan.getAlreadyInjected()) {
                            return html;
                        }
                        if (scan.getHeadTagEnd() >= 0) {
                            at = scan.getHeadTagEnd();
                        } else {
                            at = scan.getHtmlTagEnd() >= 0 ? scan.getHtmlTagEnd() : 0;
                        }
                        StringBuilder sb = new StringBuilder();
                        String strSubstring = html.substring(0, at);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        StringBuilder sbAppend = sb.append(strSubstring).append(CLOCK_SCRIPT_TAG);
                        String strSubstring2 = html.substring(at);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                        return sbAppend.append(strSubstring2).toString();
                    }

                    public static /* synthetic */ String webClockPatchScript$tap_common_release$default(TapWebClock tapWebClock, long j, int i, Object obj) {
                        if ((i & 1) != 0) {
                            j = TapTime.INSTANCE.getCurrentTimeInMillis();
                        }
                        return tapWebClock.webClockPatchScript$tap_common_release(j);
                    }

                    public final String webClockPatchScript$tap_common_release(long tapTimeMillis) {
                        return StringsKt.trimIndent("\n            (function(){\n              try {\n                var tapTime = " + tapTimeMillis + ";\n                var originPerf = (typeof performance !== \"undefined\" && performance.now) ? performance.now() : 0;\n                window.__TAPSDK_WEB_CLOCK__ = {\n                  tapTime: tapTime,\n                  originPerf: originPerf,\n                  nativeSynced: false\n                };\n                if (window.__TAPSDK_WEB_CLOCK_PATCHED__) return;\n                window.__TAPSDK_WEB_CLOCK_PATCHED__ = true;\n                var NativeDate = Date;\n                function now() {\n                  var state = window.__TAPSDK_WEB_CLOCK__;\n                  var p = (typeof performance !== \"undefined\" && performance.now) ? performance.now() : 0;\n                  try {\n                    if (window.TapSDKTime && window.TapSDKTime.now) {\n                      if (!state.nativeSynced || (p - state.originPerf) > 250) {\n                        var nativeNow = Number(window.TapSDKTime.now());\n                        if (!isNaN(nativeNow)) {\n                          state.tapTime = nativeNow;\n                          state.originPerf = p;\n                          state.nativeSynced = true;\n                          return nativeNow;\n                        }\n                      }\n                    }\n                  } catch (e) {}\n                  return state.tapTime + (p - state.originPerf);\n                }\n                function TapDate(a, b, c, d, e, f, g) {\n                  var date;\n                  if (this instanceof TapDate || this instanceof NativeDate) {\n                    switch (arguments.length) {\n                      case 0: date = new NativeDate(now()); break;\n                      case 1: date = new NativeDate(a); break;\n                      case 2: date = new NativeDate(a, b); break;\n                      case 3: date = new NativeDate(a, b, c); break;\n                      case 4: date = new NativeDate(a, b, c, d); break;\n                      case 5: date = new NativeDate(a, b, c, d, e); break;\n                      case 6: date = new NativeDate(a, b, c, d, e, f); break;\n                      default: date = new NativeDate(a, b, c, d, e, f, g);\n                    }\n                    return date;\n                  }\n                  return (new NativeDate(now())).toString();\n                }\n                TapDate.now = now;\n                TapDate.parse = NativeDate.parse;\n                TapDate.UTC = NativeDate.UTC;\n                TapDate.prototype = NativeDate.prototype;\n                Date = TapDate;\n              } catch (e) {}\n            })();\n        ");
                    }

                    private final void addJavascriptInterface(WebView webView) {
                        if (Intrinsics.areEqual((Object) javascriptInterfaceInstalled.put(webView, true), (Object) true)) {
                            return;
                        }
                        try {
                            webView.addJavascriptInterface(new TapTimeJavascriptInterface(), JS_INTERFACE_NAME);
                        } catch (RuntimeException e) {
                            Map<WebView, Boolean> javascriptInterfaceInstalled2 = javascriptInterfaceInstalled;
                            Intrinsics.checkNotNullExpressionValue(javascriptInterfaceInstalled2, "javascriptInterfaceInstalled");
                            javascriptInterfaceInstalled2.put(webView, false);
                        }
                    }

                    public final boolean isClockScriptUrl$tap_common_release(String url) {
                        String str = url;
                        if (str == null || str.length() == 0) {
                            return false;
                        }
                        try {
                            return Intrinsics.areEqual(new URI(url).getPath(), CLOCK_JS_PATH);
                        } catch (Exception e) {
                            return false;
                        }
                    }

                    public final boolean shouldServeClockScript$tap_common_release(String url) {
                        return isClockScriptUrl$tap_common_release(url) && isInjectableDocumentUrl$tap_common_release(url);
                    }

                    public final boolean shouldRewriteDocument$tap_common_release(String url, boolean isForMainFrame, String method) {
                        return isForMainFrame && isGet(method) && isInjectableDocumentUrl$tap_common_release(url);
                    }

                    public final boolean isInjectableDocumentUrl$tap_common_release(String url) {
                        String scheme;
                        String host;
                        String str = url;
                        boolean z = true;
                        if (str == null || StringsKt.isBlank(str)) {
                            return false;
                        }
                        try {
                            URI uri = new URI(url);
                            String scheme2 = uri.getScheme();
                            if (scheme2 != null) {
                                Locale US = Locale.US;
                                Intrinsics.checkNotNullExpressionValue(US, "US");
                                scheme = scheme2.toLowerCase(US);
                                Intrinsics.checkNotNullExpressionValue(scheme, "this as java.lang.String).toLowerCase(locale)");
                            } else {
                                scheme = null;
                            }
                            if (Intrinsics.areEqual(scheme, BaseConstants.SCHEME_HTTPS) && (host = uri.getHost()) != null) {
                                Locale US2 = Locale.US;
                                Intrinsics.checkNotNullExpressionValue(US2, "US");
                                String host2 = host.toLowerCase(US2);
                                Intrinsics.checkNotNullExpressionValue(host2, "this as java.lang.String).toLowerCase(locale)");
                                if (host2 != null) {
                                    Iterable $this$any$iv = INJECTABLE_HOST_SUFFIXES;
                                    if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                                        z = false;
                                    } else {
                                        for (Object element$iv : $this$any$iv) {
                                            String suffix = (String) element$iv;
                                            if (Intrinsics.areEqual(host2, suffix) || StringsKt.endsWith$default(host2, new StringBuilder().append('.').append(suffix).toString(), false, 2, (Object) null)) {
                                            }
                                        }
                                        z = false;
                                    }
                                    return z;
                                }
                            }
                            return false;
                        } catch (Exception e) {
                            return false;
                        }
                    }

                    private final WebResourceResponse clockScriptResponse(String url) {
                        if (!shouldServeClockScript$tap_common_release(url)) {
                            return null;
                        }
                        String strWebClockPatchScript$tap_common_release$default = webClockPatchScript$tap_common_release$default(this, 0L, 1, null);
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        byte[] bytes = strWebClockPatchScript$tap_common_release$default.getBytes(UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        return webResponse("application/javascript", "utf-8", 200, "OK", MapsKt.mapOf(TuplesKt.to("Content-Type", "application/javascript; charset=utf-8"), TuplesKt.to("Cache-Control", "no-store")), new ByteArrayInputStream(bytes));
                    }

                    /* JADX INFO: compiled from: TapWebClock.kt */
                    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock$BoundedRead;", "", "bytes", "", "complete", "", "overflow", "([BZ[B)V", "getBytes", "()[B", "getComplete", "()Z", "getOverflow", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                    public static final class BoundedRead {
                        private final byte[] bytes;
                        private final boolean complete;
                        private final byte[] overflow;

                        public BoundedRead(byte[] bytes, boolean complete, byte[] overflow) {
                            Intrinsics.checkNotNullParameter(bytes, "bytes");
                            Intrinsics.checkNotNullParameter(overflow, "overflow");
                            this.bytes = bytes;
                            this.complete = complete;
                            this.overflow = overflow;
                        }

                        public /* synthetic */ BoundedRead(byte[] bArr, boolean z, byte[] bArr2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                            this(bArr, z, (i & 4) != 0 ? new byte[0] : bArr2);
                        }

                        public final byte[] getBytes() {
                            return this.bytes;
                        }

                        public final boolean getComplete() {
                            return this.complete;
                        }

                        public final byte[] getOverflow() {
                            return this.overflow;
                        }
                    }

                    public static /* synthetic */ BoundedRead readAtMost$tap_common_release$default(TapWebClock tapWebClock, InputStream inputStream, int i, ByteArrayOutputStream byteArrayOutputStream, int i2, Object obj) {
                        if ((i2 & 4) != 0) {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        }
                        return tapWebClock.readAtMost$tap_common_release(inputStream, i, byteArrayOutputStream);
                    }

                    public final BoundedRead readAtMost$tap_common_release(InputStream source, int maxBytes, ByteArrayOutputStream prefix) throws IOException {
                        Intrinsics.checkNotNullParameter(source, "source");
                        Intrinsics.checkNotNullParameter(prefix, "prefix");
                        byte[] buffer = new byte[8192];
                        while (prefix.size() <= maxBytes) {
                            int remaining = (maxBytes + 1) - prefix.size();
                            int n = source.read(buffer, 0, Math.min(buffer.length, remaining));
                            if (n < 0) {
                                byte[] byteArray = prefix.toByteArray();
                                Intrinsics.checkNotNullExpressionValue(byteArray, "prefix.toByteArray()");
                                return new BoundedRead(byteArray, true, null, 4, null);
                            }
                            prefix.write(buffer, 0, n);
                        }
                        byte[] all = prefix.toByteArray();
                        Intrinsics.checkNotNullExpressionValue(all, "all");
                        byte[] bArrCopyOf = Arrays.copyOf(all, maxBytes);
                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(this, newSize)");
                        return new BoundedRead(bArrCopyOf, false, ArraysKt.copyOfRange(all, maxBytes, all.length));
                    }

                    private final InputStream replayUnread(BoundedRead read, InputStream source) {
                        return new SequenceInputStream(new ByteArrayInputStream(ArraysKt.plus(read.getBytes(), read.getOverflow())), source);
                    }

                    private final WebResourceResponse copyResponse(WebResourceResponse response, InputStream data) {
                        Map<String, String> mapEmptyMap;
                        String it;
                        String mimeType = response.getMimeType();
                        String encoding = response.getEncoding();
                        int statusCode = Build.VERSION.SDK_INT >= 21 ? response.getStatusCode() : 200;
                        String str = "OK";
                        if (Build.VERSION.SDK_INT >= 21 && (it = response.getReasonPhrase()) != null) {
                            if (!(!StringsKt.isBlank(it))) {
                                it = null;
                            }
                            if (it != null) {
                                str = it;
                            }
                        }
                        if (Build.VERSION.SDK_INT >= 21) {
                            Map<String, String> responseHeaders = response.getResponseHeaders();
                            if (responseHeaders == null) {
                                responseHeaders = MapsKt.emptyMap();
                            }
                            mapEmptyMap = responseHeaders;
                        } else {
                            mapEmptyMap = MapsKt.emptyMap();
                        }
                        return webResponse(mimeType, encoding, statusCode, str, mapEmptyMap, data);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
                    public final WebResourceResponse webResponse(String mimeType, String encoding, int statusCode, String reason, Map<String, String> headers, InputStream data) {
                        String mime;
                        if (mimeType == null) {
                            mime = "text/html";
                        } else {
                            mime = StringsKt.isBlank(mimeType) ^ true ? mimeType : null;
                            if (mime == null) {
                                mime = "text/html";
                            }
                        }
                        WebResourceResponse response = new WebResourceResponse(mime, encoding, data);
                        if (Build.VERSION.SDK_INT >= 21) {
                            int iStatusCodeForWebResourceResponse$tap_common_release = statusCodeForWebResourceResponse$tap_common_release(statusCode);
                            String str = reason;
                            if (StringsKt.isBlank(str)) {
                                str = "OK";
                            }
                            response.setStatusCodeAndReasonPhrase(iStatusCodeForWebResourceResponse$tap_common_release, str);
                            response.setResponseHeaders(headers);
                        }
                        return response;
                    }

                    private final boolean isGet(String method) {
                        String str = method;
                        return (str == null || str.length() == 0) || StringsKt.equals(method, TapHttp.METHOD_GET, true);
                    }

                    private final HttpURLConnection openDocumentConnection(String url, Map<String, String> requestHeaders, CookieSink cookies) throws IOException {
                        URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
                        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                        HttpURLConnection connection = (HttpURLConnection) uRLConnectionOpenConnection;
                        connection.setInstanceFollowRedirects(false);
                        connection.setConnectTimeout(5000);
                        connection.setReadTimeout(5000);
                        connection.setRequestMethod(TapHttp.METHOD_GET);
                        connection.setUseCaches(false);
                        if (requestHeaders != null) {
                            for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
                                String key = entry.getKey();
                                String value = entry.getValue();
                                if (!StringsKt.equals(key, "Accept-Encoding", true) && !StringsKt.equals(key, "Cookie", true)) {
                                    connection.setRequestProperty(key, value);
                                }
                            }
                        }
                        connection.setRequestProperty("Accept-Encoding", "identity");
                        String it = cookies.getCookie(url);
                        if (it != null) {
                            if (!(true ^ StringsKt.isBlank(it))) {
                                it = null;
                            }
                            if (it != null) {
                                String cookie = it;
                                connection.setRequestProperty("Cookie", cookie);
                            }
                        }
                        return connection;
                    }

                    /* JADX INFO: compiled from: TapWebClock.kt */
                    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock$DisconnectingInputStream;", "Ljava/io/FilterInputStream;", "input", "Ljava/io/InputStream;", "connection", "Ljava/net/HttpURLConnection;", "(Ljava/io/InputStream;Ljava/net/HttpURLConnection;)V", ILivePush.ClickType.CLOSE, "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                    private static final class DisconnectingInputStream extends FilterInputStream {
                        private final HttpURLConnection connection;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public DisconnectingInputStream(InputStream input, HttpURLConnection connection) {
                            super(input);
                            Intrinsics.checkNotNullParameter(input, "input");
                            Intrinsics.checkNotNullParameter(connection, "connection");
                            this.connection = connection;
                        }

                        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                        public void close() {
                            try {
                                super.close();
                            } finally {
                                this.connection.disconnect();
                            }
                        }
                    }

                    private final Map<String, String> copyResponseHeaders(HttpURLConnection connection, boolean skipContentEncoding) {
                        LinkedHashMap result = new LinkedHashMap();
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        if (headerFields != null) {
                            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                                String key = entry.getKey();
                                List<String> values = entry.getValue();
                                String str = key;
                                if (!(str == null || StringsKt.isBlank(str))) {
                                    List<String> list = values;
                                    if (!(list == null || list.isEmpty())) {
                                        TapWebClock tapWebClock = INSTANCE;
                                        Intrinsics.checkNotNullExpressionValue(key, "key");
                                        if (!tapWebClock.isSkippedResponseHeader(key, skipContentEncoding)) {
                                            Intrinsics.checkNotNullExpressionValue(values, "values");
                                            result.put(key, CollectionsKt.joinToString$default(values, ", ", null, null, 0, null, null, 62, null));
                                        }
                                    }
                                }
                            }
                        }
                        return result;
                    }

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Code duplicated, block: B:30:0x0062 A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:31:0x0064 A[ORIG_RETURN, RETURN] */
                    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                    private final boolean isSkippedResponseHeader(String name, boolean skipContentEncoding) {
                        Locale US = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US, "US");
                        String lowerCase = name.toLowerCase(US);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        switch (lowerCase.hashCode()) {
                            case -1132779846:
                                if (lowerCase.equals("content-length")) {
                                    return true;
                                }
                                return false;
                            case -775651618:
                                if (lowerCase.equals("connection")) {
                                    return true;
                                }
                                return false;
                            case -301047837:
                                if (lowerCase.equals("set-cookie2")) {
                                    return true;
                                }
                                return false;
                            case 211181701:
                                if (lowerCase.equals("keep-alive")) {
                                    return true;
                                }
                                return false;
                            case 285929373:
                                if (lowerCase.equals("proxy-connection")) {
                                    return true;
                                }
                                return false;
                            case 1237214767:
                                if (lowerCase.equals("set-cookie")) {
                                    return true;
                                }
                                return false;
                            case 1274458357:
                                if (lowerCase.equals("transfer-encoding")) {
                                    return true;
                                }
                                return false;
                            case 2095084583:
                                if (lowerCase.equals("content-encoding")) {
                                    return skipContentEncoding;
                                }
                                return false;
                            default:
                                return false;
                        }
                    }

                    /* JADX WARN: Code duplicated, block: B:13:0x0052  */
                    private final List<String> setCookieValues(HttpURLConnection connection) {
                        Iterable iterableEmptyList;
                        Map<String, List<String>> headerFields = connection.getHeaderFields();
                        if (headerFields != null) {
                            LinkedHashMap result$iv = new LinkedHashMap();
                            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                                if (StringsKt.equals(entry.getKey(), "Set-Cookie", true)) {
                                    result$iv.put(entry.getKey(), entry.getValue());
                                }
                            }
                            LinkedHashMap $this$filterKeys$iv = result$iv;
                            Collection collectionValues = $this$filterKeys$iv.values();
                            if (collectionValues != null) {
                                iterableEmptyList = CollectionsKt.flatten(collectionValues);
                            } else {
                                iterableEmptyList = null;
                            }
                        } else {
                            iterableEmptyList = null;
                        }
                        if (iterableEmptyList == null) {
                            iterableEmptyList = CollectionsKt.emptyList();
                        }
                        Iterable $this$filter$iv = iterableEmptyList;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            String it = (String) element$iv$iv;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            if (!StringsKt.isBlank(it)) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        return (List) destination$iv$iv;
                    }

                    public final ContentEncodingAction contentEncodingAction$tap_common_release(String contentEncoding) {
                        List listEmptyList;
                        String it;
                        Iterable iterableSplit$default;
                        boolean z = false;
                        if (contentEncoding == null || (iterableSplit$default = StringsKt.split$default((CharSequence) contentEncoding, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                            listEmptyList = null;
                        } else {
                            Iterable $this$map$iv = iterableSplit$default;
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                String it2 = (String) item$iv$iv;
                                String string = StringsKt.trim((CharSequence) it2).toString();
                                Locale US = Locale.US;
                                Intrinsics.checkNotNullExpressionValue(US, "US");
                                String lowerCase = string.toLowerCase(US);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                                destination$iv$iv.add(lowerCase);
                            }
                            Iterable $this$filter$iv = (List) destination$iv$iv;
                            Collection destination$iv$iv2 = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                String it3 = (String) element$iv$iv;
                                if (it3.length() > 0) {
                                    destination$iv$iv2.add(element$iv$iv);
                                }
                            }
                            listEmptyList = (List) destination$iv$iv2;
                        }
                        if (listEmptyList == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        List encodings = listEmptyList;
                        if (!encodings.isEmpty()) {
                            List $this$all$iv = encodings;
                            if (($this$all$iv instanceof Collection) && $this$all$iv.isEmpty()) {
                                z = true;
                            } else {
                                Iterator it4 = $this$all$iv.iterator();
                                do {
                                    if (!it4.hasNext()) {
                                        z = true;
                                        break;
                                    }
                                    Object element$iv = it4.next();
                                    it = (String) element$iv;
                                } while (Intrinsics.areEqual(it, "identity"));
                            }
                            if (!z) {
                                String only = (String) CollectionsKt.singleOrNull(encodings);
                                return (Intrinsics.areEqual(only, com.efs.sdk.base.Constants.CP_GZIP) || Intrinsics.areEqual(only, "x-gzip")) ? ContentEncodingAction.DECODE_GZIP : ContentEncodingAction.PASSTHROUGH;
                            }
                        }
                        return ContentEncodingAction.IDENTITY;
                    }

                    public final int statusCodeForWebResourceResponse$tap_common_release(int statusCode) {
                        int status = RangesKt.coerceIn(statusCode, 100, 599);
                        boolean z = false;
                        if (300 <= status && status < 400) {
                            z = true;
                        }
                        if (z) {
                            return 200;
                        }
                        return status;
                    }

                    public final String resolveRedirect$tap_common_release(String current, String location) {
                        Intrinsics.checkNotNullParameter(current, "current");
                        String str = location;
                        if (str == null || StringsKt.isBlank(str)) {
                            return null;
                        }
                        try {
                            String resolved = new URL(new URL(current), StringsKt.trim((CharSequence) location).toString()).toString();
                            Intrinsics.checkNotNullExpressionValue(resolved, "try {\n            URL(UR…    return null\n        }");
                            String strSubstringBefore = StringsKt.substringBefore(resolved, "://", "");
                            Locale US = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(US, "US");
                            String scheme = strSubstringBefore.toLowerCase(US);
                            Intrinsics.checkNotNullExpressionValue(scheme, "this as java.lang.String).toLowerCase(locale)");
                            if (Intrinsics.areEqual(scheme, "http") || Intrinsics.areEqual(scheme, BaseConstants.SCHEME_HTTPS)) {
                                return resolved;
                            }
                            return null;
                        } catch (Exception e) {
                            return null;
                        }
                    }

                    public final String redirectBounceHtml$tap_common_release(String target) {
                        Intrinsics.checkNotNullParameter(target, "target");
                        String js = jsStringLiteral(target);
                        String attr = htmlAttribute(target);
                        return "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta http-equiv=\"refresh\" content=\"0;url=" + attr + "\"><script>location.replace(" + js + ");</script></head><body></body></html>";
                    }

                    private final InjectedDocument bounceDocument(String from, String to) {
                        String strRedirectBounceHtml$tap_common_release = redirectBounceHtml$tap_common_release(to);
                        Charset UTF_8 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                        byte[] bytes = strRedirectBounceHtml$tap_common_release.getBytes(UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        String strName = StandardCharsets.UTF_8.name();
                        Intrinsics.checkNotNullExpressionValue(strName, "UTF_8.name()");
                        return new InjectedDocument(from, bytes, strName, "text/html", MapsKt.mapOf(TuplesKt.to("Content-Type", "text/html; charset=utf-8"), TuplesKt.to("Cache-Control", "no-store")), 200, "OK", null, 128, null);
                    }

                    private final String jsStringLiteral(String value) {
                        StringBuilder $this$jsStringLiteral_u24lambda_u2417 = new StringBuilder();
                        String $this$forEach$iv = value;
                        for (int i = 0; i < $this$forEach$iv.length(); i++) {
                            char element$iv = $this$forEach$iv.charAt(i);
                            if (element$iv == '\\') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\\\");
                            } else if (element$iv == '\"') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\\"");
                            } else if (element$iv == '\'') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\'");
                            } else if (element$iv == '\n') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\n");
                            } else if (element$iv == '\r') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\r");
                            } else if (element$iv == 8232) {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\u2028");
                            } else if (element$iv == 8233) {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\u2029");
                            } else if (element$iv == '<') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\u003c");
                            } else if (element$iv == '>') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\u003e");
                            } else if (element$iv == '&') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\u0026");
                            } else if (element$iv < ' ') {
                                $this$jsStringLiteral_u24lambda_u2417.append("\\u");
                                String string = Integer.toString(element$iv, CharsKt.checkRadix(16));
                                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                                $this$jsStringLiteral_u24lambda_u2417.append(StringsKt.padStart(string, 4, '0'));
                            } else {
                                $this$jsStringLiteral_u24lambda_u2417.append(element$iv);
                            }
                        }
                        String escaped = $this$jsStringLiteral_u24lambda_u2417.toString();
                        Intrinsics.checkNotNullExpressionValue(escaped, "StringBuilder().apply(builderAction).toString()");
                        return '\"' + escaped + '\"';
                    }

                    private final String htmlAttribute(String value) {
                        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(value, "&", "&amp;", false, 4, (Object) null), "\"", "&quot;", false, 4, (Object) null), "'", "&#39;", false, 4, (Object) null), "<", "&lt;", false, 4, (Object) null), ">", "&gt;", false, 4, (Object) null);
                    }

                    private final InputStream decodeContent(InputStream stream, ContentEncodingAction action) {
                        if (stream == null) {
                            return null;
                        }
                        if (action == ContentEncodingAction.DECODE_GZIP) {
                            return new GZIPInputStream(stream);
                        }
                        return stream;
                    }

                    private final String mimeOf(String contentType) {
                        String str = contentType;
                        String str2 = "text/html";
                        if (str == null || StringsKt.isBlank(str)) {
                            return "text/html";
                        }
                        String string = StringsKt.trim((CharSequence) StringsKt.split$default((CharSequence) contentType, new String[]{";"}, false, 2, 2, (Object) null).get(0)).toString();
                        if (!StringsKt.isBlank(string)) {
                            str2 = string;
                        }
                        return str2;
                    }

                    private final String effectiveScheme(URI uri) {
                        String scheme = uri.getScheme();
                        if (scheme == null) {
                            scheme = "";
                        }
                        Locale US = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US, "US");
                        String lowerCase = scheme.toLowerCase(US);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                        return lowerCase;
                    }

                    private final int effectivePort(URI uri) {
                        if (uri.getPort() != -1) {
                            return uri.getPort();
                        }
                        String strEffectiveScheme = effectiveScheme(uri);
                        if (Intrinsics.areEqual(strEffectiveScheme, BaseConstants.SCHEME_HTTPS)) {
                            return 443;
                        }
                        return Intrinsics.areEqual(strEffectiveScheme, "http") ? 80 : -1;
                    }

                    private final boolean isHtmlMime(String mime) {
                        if (mime != null) {
                            Locale US = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(US, "US");
                            String value = mime.toLowerCase(US);
                            Intrinsics.checkNotNullExpressionValue(value, "this as java.lang.String).toLowerCase(locale)");
                            if (value != null) {
                                return StringsKt.contains$default((CharSequence) value, (CharSequence) "text/html", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) value, (CharSequence) "application/xhtml", false, 2, (Object) null);
                            }
                        }
                        return false;
                    }

                    private final boolean looksLikeHtml(byte[] bytes, Charset charset) {
                        String string = StringsKt.trimStart((CharSequence) new String(bytes, 0, Math.min(bytes.length, 256), charset)).toString();
                        Locale US = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US, "US");
                        String prefix = string.toLowerCase(US);
                        Intrinsics.checkNotNullExpressionValue(prefix, "this as java.lang.String).toLowerCase(locale)");
                        return StringsKt.startsWith$default(prefix, "<!doctype html", false, 2, (Object) null) || StringsKt.startsWith$default(prefix, "<html", false, 2, (Object) null) || StringsKt.startsWith$default(prefix, "<head", false, 2, (Object) null);
                    }

                    public final Charset resolveHtmlCharset$tap_common_release(String encoding, String contentType, byte[] bytes) {
                        Intrinsics.checkNotNullParameter(bytes, "bytes");
                        Charset it = charsetFromName(encoding);
                        if (it != null) {
                            return it;
                        }
                        Charset it2 = charsetFromContentType(contentType);
                        if (it2 != null) {
                            return it2;
                        }
                        Charset it3 = charsetFromBom(bytes);
                        if (it3 != null) {
                            return it3;
                        }
                        Charset it4 = charsetFromMeta(bytes);
                        if (it4 != null) {
                            return it4;
                        }
                        if (isValidUtf8(bytes)) {
                            Charset UTF_8 = StandardCharsets.UTF_8;
                            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                            if (looksLikeHtml(bytes, UTF_8)) {
                                return StandardCharsets.UTF_8;
                            }
                        }
                        return null;
                    }

                    private final Charset charsetFromContentType(String contentType) {
                        Iterable iterableSplit$default;
                        if (contentType != null && (iterableSplit$default = StringsKt.split$default((CharSequence) contentType, new String[]{";"}, false, 0, 6, (Object) null)) != null) {
                            Iterable $this$forEach$iv = iterableSplit$default;
                            for (Object element$iv : $this$forEach$iv) {
                                String part = (String) element$iv;
                                String trimmed = StringsKt.trim((CharSequence) part).toString();
                                if (StringsKt.startsWith(trimmed, "charset=", true)) {
                                    return INSTANCE.charsetFromName(StringsKt.removeSurrounding(StringsKt.removeSurrounding(StringsKt.trim((CharSequence) StringsKt.substringAfter$default(trimmed, "=", (String) null, 2, (Object) null)).toString(), (CharSequence) "\""), (CharSequence) "'"));
                                }
                            }
                        }
                        return null;
                    }

                    private final Charset charsetFromBom(byte[] bytes) {
                        if (bytes.length >= 3 && bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) {
                            return StandardCharsets.UTF_8;
                        }
                        if (bytes.length >= 2 && bytes[0] == -2 && bytes[1] == -1) {
                            return StandardCharsets.UTF_16BE;
                        }
                        if (bytes.length >= 2 && bytes[0] == -1 && bytes[1] == -2) {
                            return StandardCharsets.UTF_16LE;
                        }
                        return null;
                    }

                    private final Charset charsetFromMeta(byte[] bytes) {
                        int iMin = Math.min(bytes.length, 4096);
                        Charset ISO_8859_1 = StandardCharsets.ISO_8859_1;
                        Intrinsics.checkNotNullExpressionValue(ISO_8859_1, "ISO_8859_1");
                        String prefix = new String(bytes, 0, iMin, ISO_8859_1);
                        MatchResult match = Regex.find$default(META_CHARSET, prefix, 0, 2, null);
                        if (match == null) {
                            return null;
                        }
                        String str = match.getGroupValues().get(1);
                        if (str.length() == 0) {
                            str = match.getGroupValues().get(2);
                        }
                        String name = str;
                        return charsetFromName(name);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public final Charset charsetFromName(String name) {
                        String value = name != null ? StringsKt.trim((CharSequence) name).toString() : null;
                        if (value == null) {
                            value = "";
                        }
                        if (value.length() == 0) {
                            return null;
                        }
                        try {
                            return Charset.forName(value);
                        } catch (Exception e) {
                            return null;
                        }
                    }

                    private final boolean isValidUtf8(byte[] bytes) {
                        try {
                            CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
                            decoder.onMalformedInput(CodingErrorAction.REPORT);
                            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                            decoder.decode(ByteBuffer.wrap(bytes));
                            return true;
                        } catch (Exception e) {
                            return false;
                        }
                    }

                    /* JADX INFO: compiled from: TapWebClock.kt */
                    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/taptap/sdk/kit/internal/time/TapWebClock$HtmlScan;", "", "headTagEnd", "", "htmlTagEnd", "alreadyInjected", "", "(IIZ)V", "getAlreadyInjected", "()Z", "getHeadTagEnd", "()I", "getHtmlTagEnd", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "tap-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                    private static final /* data */ class HtmlScan {
                        private final boolean alreadyInjected;
                        private final int headTagEnd;
                        private final int htmlTagEnd;

                        public static /* synthetic */ HtmlScan copy$default(HtmlScan htmlScan, int i, int i2, boolean z, int i3, Object obj) {
                            if ((i3 & 1) != 0) {
                                i = htmlScan.headTagEnd;
                            }
                            if ((i3 & 2) != 0) {
                                i2 = htmlScan.htmlTagEnd;
                            }
                            if ((i3 & 4) != 0) {
                                z = htmlScan.alreadyInjected;
                            }
                            return htmlScan.copy(i, i2, z);
                        }

                        /* JADX INFO: renamed from: component1, reason: from getter */
                        public final int getHeadTagEnd() {
                            return this.headTagEnd;
                        }

                        /* JADX INFO: renamed from: component2, reason: from getter */
                        public final int getHtmlTagEnd() {
                            return this.htmlTagEnd;
                        }

                        /* JADX INFO: renamed from: component3, reason: from getter */
                        public final boolean getAlreadyInjected() {
                            return this.alreadyInjected;
                        }

                        public final HtmlScan copy(int headTagEnd, int htmlTagEnd, boolean alreadyInjected) {
                            return new HtmlScan(headTagEnd, htmlTagEnd, alreadyInjected);
                        }

                        public boolean equals(Object other) {
                            if (this == other) {
                                return true;
                            }
                            if (!(other instanceof HtmlScan)) {
                                return false;
                            }
                            HtmlScan htmlScan = (HtmlScan) other;
                            return this.headTagEnd == htmlScan.headTagEnd && this.htmlTagEnd == htmlScan.htmlTagEnd && this.alreadyInjected == htmlScan.alreadyInjected;
                        }

                        public int hashCode() {
                            return (((Integer.hashCode(this.headTagEnd) * 31) + Integer.hashCode(this.htmlTagEnd)) * 31) + Boolean.hashCode(this.alreadyInjected);
                        }

                        public String toString() {
                            return "HtmlScan(headTagEnd=" + this.headTagEnd + ", htmlTagEnd=" + this.htmlTagEnd + ", alreadyInjected=" + this.alreadyInjected + ')';
                        }

                        public HtmlScan(int headTagEnd, int htmlTagEnd, boolean alreadyInjected) {
                            this.headTagEnd = headTagEnd;
                            this.htmlTagEnd = htmlTagEnd;
                            this.alreadyInjected = alreadyInjected;
                        }

                        public final int getHeadTagEnd() {
                            return this.headTagEnd;
                        }

                        public final int getHtmlTagEnd() {
                            return this.htmlTagEnd;
                        }

                        public final boolean getAlreadyInjected() {
                            return this.alreadyInjected;
                        }
                    }

                    /* JADX WARN: Code duplicated, block: B:86:0x0144  */
                    /* JADX WARN: Code duplicated, block: B:87:0x0146  */
                    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                    private final HtmlScan scanHtml(String html) {
                        int iSkipRawTextEnd;
                        int n = html.length();
                        int i = 0;
                        int headTagEnd = -1;
                        int htmlTagEnd = -1;
                        boolean alreadyInjected = false;
                        while (i < n) {
                            if (html.charAt(i) != '<') {
                                i++;
                            } else if (StringsKt.startsWith$default(html, "<!--", i, false, 4, (Object) null)) {
                                int end = StringsKt.indexOf$default((CharSequence) html, "-->", i + 4, false, 4, (Object) null);
                                i = end < 0 ? n : end + 3;
                            } else if (StringsKt.startsWith(html, "<![CDATA[", i, true)) {
                                int end2 = StringsKt.indexOf$default((CharSequence) html, "]]>", i + 9, false, 4, (Object) null);
                                i = end2 < 0 ? n : end2 + 3;
                            } else if (StringsKt.startsWith$default(html, "<!", i, false, 4, (Object) null) || StringsKt.startsWith$default(html, "<?", i, false, 4, (Object) null)) {
                                int close = findTagClose(html, i + 2);
                                i = close < 0 ? n : close + 1;
                            } else {
                                boolean isClose = i + 1 < n && html.charAt(i + 1) == '/';
                                int nameStart = isClose ? i + 2 : i + 1;
                                int nameEnd = skipTagName(html, nameStart);
                                if (nameEnd > nameStart) {
                                    String strSubstring = html.substring(nameStart, nameEnd);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                                    Locale US = Locale.US;
                                    Intrinsics.checkNotNullExpressionValue(US, "US");
                                    String name = strSubstring.toLowerCase(US);
                                    Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String).toLowerCase(locale)");
                                    int close2 = findTagClose(html, nameEnd);
                                    if (close2 < 0) {
                                        return new HtmlScan(headTagEnd, htmlTagEnd, alreadyInjected);
                                    }
                                    int tagEnd = close2 + 1;
                                    if (!isClose) {
                                        boolean selfClosing = close2 > i && html.charAt(close2 + (-1)) == '/';
                                        switch (name.hashCode()) {
                                            case -1003243718:
                                                if (!name.equals("textarea")) {
                                                    i = tagEnd;
                                                } else {
                                                    if (selfClosing) {
                                                        iSkipRawTextEnd = tagEnd;
                                                    } else {
                                                        iSkipRawTextEnd = skipRawTextEnd(html, tagEnd, name);
                                                    }
                                                    i = iSkipRawTextEnd;
                                                }
                                                break;
                                            case -907685685:
                                                if (!name.equals("script")) {
                                                    i = tagEnd;
                                                } else {
                                                    if (scriptSrcIsClock(html, nameEnd, close2)) {
                                                        alreadyInjected = true;
                                                    }
                                                    i = selfClosing ? tagEnd : skipRawTextEnd(html, tagEnd, "script");
                                                }
                                                break;
                                            case 3198432:
                                                if (!name.equals("head")) {
                                                    i = tagEnd;
                                                } else {
                                                    if (headTagEnd < 0) {
                                                        headTagEnd = tagEnd;
                                                    }
                                                    i = tagEnd;
                                                }
                                                break;
                                            case 3213227:
                                                if (!name.equals("html")) {
                                                    i = tagEnd;
                                                } else {
                                                    if (htmlTagEnd < 0) {
                                                        htmlTagEnd = tagEnd;
                                                    }
                                                    i = tagEnd;
                                                }
                                                break;
                                            case 109780401:
                                                if (!name.equals(BundleId.STYLE)) {
                                                    i = tagEnd;
                                                } else {
                                                    if (selfClosing) {
                                                        iSkipRawTextEnd = tagEnd;
                                                    } else {
                                                        iSkipRawTextEnd = skipRawTextEnd(html, tagEnd, name);
                                                    }
                                                    i = iSkipRawTextEnd;
                                                }
                                                break;
                                            case 110371416:
                                                if (!name.equals(BundleKey.TITLE)) {
                                                    i = tagEnd;
                                                } else {
                                                    if (selfClosing) {
                                                        iSkipRawTextEnd = tagEnd;
                                                    } else {
                                                        iSkipRawTextEnd = skipRawTextEnd(html, tagEnd, name);
                                                    }
                                                    i = iSkipRawTextEnd;
                                                }
                                                break;
                                            case 1551550924:
                                                if (!name.equals("noscript")) {
                                                    i = tagEnd;
                                                } else {
                                                    if (selfClosing) {
                                                        iSkipRawTextEnd = tagEnd;
                                                    } else {
                                                        iSkipRawTextEnd = skipRawTextEnd(html, tagEnd, name);
                                                    }
                                                    i = iSkipRawTextEnd;
                                                }
                                                break;
                                            default:
                                                i = tagEnd;
                                                break;
                                        }
                                    } else {
                                        i = tagEnd;
                                    }
                                } else {
                                    i++;
                                }
                            }
                        }
                        return new HtmlScan(headTagEnd, htmlTagEnd, alreadyInjected);
                    }

                    private final int skipTagName(String html, int from) {
                        int i = from;
                        while (i < html.length()) {
                            char c = html.charAt(i);
                            if (!Character.isLetterOrDigit(c) && c != '-' && c != ':') {
                                break;
                            }
                            i++;
                        }
                        return i;
                    }

                    private final int findTagClose(String html, int from) {
                        Character quote = null;
                        for (int i = from; i < html.length(); i++) {
                            char c = html.charAt(i);
                            if (quote != null) {
                                if (c == quote.charValue()) {
                                    quote = null;
                                }
                            } else {
                                boolean z = true;
                                if (c != '\"' && c != '\'') {
                                    z = false;
                                }
                                if (z) {
                                    quote = Character.valueOf(c);
                                } else if (c == '>') {
                                    return i;
                                }
                            }
                        }
                        return -1;
                    }

                    private final int skipRawTextEnd(String html, int from, String tag) {
                        String needle = "</" + tag;
                        int i = from;
                        while (i < html.length()) {
                            int idx = StringsKt.indexOf((CharSequence) html, needle, i, true);
                            if (idx < 0) {
                                return html.length();
                            }
                            int after = needle.length() + idx;
                            if (after >= html.length() || html.charAt(after) == '>' || CharsKt.isWhitespace(html.charAt(after))) {
                                int close = findTagClose(html, after);
                                return close < 0 ? html.length() : close + 1;
                            }
                            i = after;
                        }
                        return html.length();
                    }

                    private final boolean scriptSrcIsClock(String html, int from, int to) {
                        if (from >= to) {
                            return false;
                        }
                        String attrs = html.substring(from, to);
                        Intrinsics.checkNotNullExpressionValue(attrs, "this as java.lang.String…ing(startIndex, endIndex)");
                        MatchResult match = Regex.find$default(SRC_ATTR, attrs, 0, 2, null);
                        if (match == null) {
                            return false;
                        }
                        String str = match.getGroupValues().get(1);
                        if (str.length() == 0) {
                            String str2 = match.getGroupValues().get(2);
                            if (str2.length() == 0) {
                                str2 = match.getGroupValues().get(3);
                            }
                            str = str2;
                        }
                        String src = str;
                        return Intrinsics.areEqual(clockSrcPath(src), CLOCK_JS_PATH);
                    }

                    private final String clockSrcPath(String src) {
                        URI uri;
                        String value = StringsKt.trim((CharSequence) src).toString();
                        if (value.length() == 0) {
                            return null;
                        }
                        try {
                            if (StringsKt.startsWith$default(value, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(value, "https://", false, 2, (Object) null) || StringsKt.startsWith$default(value, "/", false, 2, (Object) null)) {
                                uri = new URI(value);
                            } else {
                                uri = new URI("https://local.invalid/" + value);
                            }
                            return uri.getPath();
                        } catch (Exception e) {
                            return StringsKt.substringBefore$default(StringsKt.substringBefore$default(value, '?', (String) null, 2, (Object) null), '#', (String) null, 2, (Object) null);
                        }
                    }
                }
