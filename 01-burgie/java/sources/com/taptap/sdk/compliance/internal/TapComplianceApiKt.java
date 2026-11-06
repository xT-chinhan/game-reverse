package com.taptap.sdk.compliance.internal;

import android.util.Base64;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.taptap.sdk.common.network.NetworkClientKt;
import com.taptap.sdk.kit.internal.TapLoggerKt;
import com.taptap.sdk.kit.internal.TapSDKHost;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import com.taptap.sdk.kit.internal.time.TapTime;
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
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\u001a*\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0000\u001a\b\u0010\u0012\u001a\u00020\rH\u0000\u001a\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\b\u0010\u0016\u001a\u00020\rH\u0002\u001a\u0018\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\rH\u0002\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001b\u0010\u0007\u001a\u00020\b8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, d2 = {"api", "Lcom/taptap/sdk/compliance/internal/ComplianceApiService;", "kotlin.jvm.PlatformType", "getApi", "()Lcom/taptap/sdk/compliance/internal/ComplianceApiService;", "api$delegate", "Lkotlin/Lazy;", "complianceScope", "Lkotlinx/coroutines/CoroutineScope;", "getComplianceScope", "()Lkotlinx/coroutines/CoroutineScope;", "complianceScope$delegate", "getAuthorization", "", "urlString", "method", "kid", "macKey", "getHost", "getRandomString", "length", "", "getTime", "signMac", "signatureBaseString", "key", "tap-compliance_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TapComplianceApiKt {
    private static final Lazy complianceScope$delegate = LazyKt.lazy(TapComplianceApiKt$complianceScope$2.INSTANCE);
    private static final Lazy api$delegate = LazyKt.lazy(new Function0<ComplianceApiService>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceApiKt$api$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ComplianceApiService invoke() {
            return (ComplianceApiService) NetworkClientKt.provideRetrofit$default("https://" + TapComplianceApiKt.getHost(), null, 2, null).create(ComplianceApiService.class);
        }
    });

    public static final CoroutineScope getComplianceScope() {
        return (CoroutineScope) complianceScope$delegate.getValue();
    }

    public static final String getHost() {
        return TapSDKHost.INSTANCE.getApiHost();
    }

    public static final ComplianceApiService getApi() {
        return (ComplianceApiService) api$delegate.getValue();
    }

    public static final String getAuthorization(String urlString, String method, String kid, String macKey) {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(macKey, "macKey");
        try {
            URL url = new URL(urlString);
            String time = getTime();
            String randomStr = getRandomString(5);
            String host = url.getHost();
            Intrinsics.checkNotNullExpressionValue(host, "host");
            String uri = urlString.substring(StringsKt.lastIndexOf$default((CharSequence) urlString, host, 0, false, 6, (Object) null) + host.length());
            Intrinsics.checkNotNullExpressionValue(uri, "this as java.lang.String).substring(startIndex)");
            String port = StringsKt.startsWith$default(urlString, BaseConstants.SCHEME_HTTPS, false, 2, (Object) null) ? LiveConfigKey.DEFAULT_TLS_PORT : "80";
            if (!(host.length() == 0)) {
                if (!(uri.length() == 0)) {
                    String sign = signMac(time + '\n' + randomStr + '\n' + method + '\n' + uri + '\n' + host + '\n' + port + "\n\n", macKey);
                    Pair[] authPairs = {new Pair("id", kid), new Pair("ts", time), new Pair("nonce", randomStr), new Pair("mac", sign)};
                    return "MAC " + ArraysKt.joinToString$default(authPairs, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.taptap.sdk.compliance.internal.TapComplianceApiKt.getAuthorization.1
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

    public static final String getRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt("abcdefghijklmnopqrstuvwxyz0123456789".length());
            sb.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(number));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    private static final String signMac(String signatureBaseString, String key) {
        try {
            TapLoggerKt.logInfo("[mac token]: signature=" + signatureBaseString + ", key=" + key);
            byte[] bytes = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKeySpec signingKey = new SecretKeySpec(bytes, TapHttpUtil.HMAC_SHA1);
            Mac mac = Mac.getInstance(TapHttpUtil.HMAC_SHA1);
            mac.init(signingKey);
            byte[] text = signatureBaseString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String).getBytes(charset)");
            byte[] signatureBytes = Base64.encode(mac.doFinal(text), 2);
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
