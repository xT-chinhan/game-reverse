package com.taptap.sdk.compilance.internal;

import android.util.Base64;
import com.anythink.core.common.f.e;
import com.byazt.ho.BaseConstants;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.taptap.sdk.kit.internal.TapTapKit;
import com.taptap.sdk.kit.internal.http.TapHttp;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import com.taptap.sdk.kit.internal.http.TapTime;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: TapComplianceApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u001a(\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001\u001a\b\u0010\u0015\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018\u001a\b\u0010\u0019\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u0005\u001a\u00020\u00068@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\u000b\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001d"}, d2 = {"HOST_CN", "", "HOST_IO", "HOST_RND_CN", "HOST_RND_IO", "complianceScope", "Lkotlinx/coroutines/CoroutineScope;", "getComplianceScope", "()Lkotlinx/coroutines/CoroutineScope;", "complianceScope$delegate", "Lkotlin/Lazy;", "netApi", "Lcom/taptap/sdk/kit/internal/http/TapHttp;", "getNetApi", "()Lcom/taptap/sdk/kit/internal/http/TapHttp;", "netApi$delegate", "getAuthorization", "urlString", "method", "kid", "macKey", "getHost", "getRandomString", "length", "", "getTime", "signMac", "signatureBaseString", e.a.b, "tap-compliance_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceApiKt {
    private static final String HOST_CN = "tapsdk.tapapis.cn";
    private static final String HOST_IO = "tapsdk.tapapis.com";
    private static final String HOST_RND_CN = "tapsdk.api.xdrnd.cn";
    private static final String HOST_RND_IO = "tapsdk.api.xdrnd.com";
    private static final Lazy complianceScope$delegate = LazyKt.lazy(TapComplianceApiKt$complianceScope$2.INSTANCE);
    private static final Lazy netApi$delegate = LazyKt.lazy(new Function0<TapHttp>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceApiKt$netApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TapHttp invoke() {
            return TapHttp.INSTANCE.newBuilder("TapCompliance", "4.5.0").enableAuthorization().connectTimeout(10000L).writeTimeout(5000L).readTimeout(5000L).domain(TapComplianceApiKt.getHost()).build();
        }
    });

    public static final CoroutineScope getComplianceScope() {
        return (CoroutineScope) complianceScope$delegate.getValue();
    }

    public static final String getHost() {
        if (TapComplianceInternal.INSTANCE.getRegionType() == 1) {
            return TapTapKit.INSTANCE.isRND() ? HOST_RND_IO : HOST_IO;
        }
        return TapTapKit.INSTANCE.isRND() ? HOST_RND_CN : HOST_CN;
    }

    public static final TapHttp getNetApi() {
        return (TapHttp) netApi$delegate.getValue();
    }

    public static final String getAuthorization(String urlString, String method, String kid, String macKey) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(macKey, "macKey");
        try {
            URL url = new URL(urlString);
            String time = getTime();
            String randomString = getRandomString(5);
            String host = url.getHost();
            Intrinsics.checkNotNullExpressionValue(host, "host");
            String strSubstring = urlString.substring(StringsKt.lastIndexOf$default((CharSequence) urlString, host, 0, false, 6, (Object) null) + host.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
            String str = StringsKt.startsWith$default(urlString, BaseConstants.SCHEME_HTTPS, false, 2, (Object) null) ? LiveConfigKey.DEFAULT_TLS_PORT : "80";
            if (!(host.length() == 0)) {
                if (!(strSubstring.length() == 0)) {
                    return "MAC " + ArraysKt.joinToString$default(new Pair[]{new Pair("id", kid), new Pair("ts", time), new Pair("nonce", randomString), new Pair("mac", signMac(time + '\n' + randomString + '\n' + method + '\n' + strSubstring + '\n' + host + '\n' + str + "\n\n", macKey))}, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.taptap.sdk.compilance.internal.TapComplianceApiKt.getAuthorization.1
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final CharSequence invoke2(Pair<String, String> p) {
                            Intrinsics.checkNotNullParameter(p, "p");
                            return p.getFirst() + "=\"" + p.getSecond() + '\"';
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair) {
                            return invoke2((Pair<String, String>) pair);
                        }
                    }, 30, (Object) null);
                }
            }
            throw new IllegalArgumentException("Cannot parse url " + urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String getRandomString(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(random.nextInt(36)));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    private static final String signMac(String str, String str2) {
        try {
            TapComplianceLoggerKt.logInfo("[mac token]: signature=" + str + ", key=" + str2);
            byte[] bytes = str2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, TapHttpUtil.HMAC_SHA1);
            Mac mac = Mac.getInstance(TapHttpUtil.HMAC_SHA1);
            mac.init(secretKeySpec);
            byte[] bytes2 = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            byte[] signatureBytes = Base64.encode(mac.doFinal(bytes2), 2);
            Intrinsics.checkNotNullExpressionValue(signatureBytes, "signatureBytes");
            return new String(signatureBytes, Charsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e2) {
            throw new IllegalStateException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static final String getTime() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%010d", Arrays.copyOf(new Object[]{Long.valueOf(TapTime.INSTANCE.getCurrentTimeInMillis() / ((long) 1000))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }
}
