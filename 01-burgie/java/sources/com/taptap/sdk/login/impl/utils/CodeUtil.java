package com.taptap.sdk.login.impl.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.byazt.fi.BaseConstants;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.taptap.sdk.kit.internal.http.TapHttpUtil;
import com.taptap.sdk.kit.internal.time.TapTime;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CodeUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, d2 = {"Lcom/taptap/sdk/login/impl/utils/CodeUtil;", "", "()V", "getAuthorization", "", "urlString", "method", "kid", "macKey", "getCodeChallenge", "codeVerifier", "getEncodeStr", "signCode", "", "getSignCode", "getTime", "tap-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CodeUtil {
    public static final CodeUtil INSTANCE = new CodeUtil();

    private CodeUtil() {
    }

    public final String getCodeChallenge(String codeVerifier) {
        Intrinsics.checkNotNullParameter(codeVerifier, "codeVerifier");
        return getEncodeStr(getSignCode(codeVerifier));
    }

    public final String getAuthorization(String urlString, String method, String kid, String macKey) throws NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(kid, "kid");
        Intrinsics.checkNotNullParameter(macKey, "macKey");
        try {
            URL url = new URL(urlString);
            String time = getTime();
            String randomStr = TapHttpUtil.INSTANCE.getRandomString(5);
            String host = url.getHost();
            Intrinsics.checkNotNullExpressionValue(host, "host");
            String uri = urlString.substring(StringsKt.lastIndexOf$default((CharSequence) urlString, host, 0, false, 6, (Object) null) + host.length());
            Intrinsics.checkNotNullExpressionValue(uri, "this as java.lang.String).substring(startIndex)");
            String port = StringsKt.startsWith$default(urlString, BaseConstants.SCHEME_HTTPS, false, 2, (Object) null) ? LiveConfigKey.DEFAULT_TLS_PORT : "80";
            if (!(host.length() == 0)) {
                if (!(uri.length() == 0)) {
                    String sign = TapHttpUtil.INSTANCE.secret(macKey, time + '\n' + randomStr + '\n' + method + '\n' + uri + '\n' + host + '\n' + port + "\n\n", TapHttpUtil.HMAC_SHA1);
                    Pair[] authPairs = {new Pair("id", kid), new Pair("ts", time), new Pair("nonce", randomStr), new Pair("mac", sign)};
                    return "MAC " + ArraysKt.joinToString$default(authPairs, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Pair<? extends String, ? extends String>, CharSequence>() { // from class: com.taptap.sdk.login.impl.utils.CodeUtil.getAuthorization.1
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

    private final String getTime() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%010d", Arrays.copyOf(new Object[]{Long.valueOf(TapTime.INSTANCE.getCurrentTimeInMillis() / ((long) 1000))}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    private final String getEncodeStr(byte[] signCode) {
        if (signCode == null) {
            return null;
        }
        byte[] encoded = Base64.encode(signCode, 11);
        Intrinsics.checkNotNullExpressionValue(encoded, "encoded");
        return new String(encoded, Charsets.UTF_8);
    }

    private final byte[] getSignCode(String codeVerifier) {
        if (TextUtils.isEmpty(codeVerifier)) {
            return null;
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = codeVerifier.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            digest.update(bytes);
            byte[] signCode = digest.digest();
            return signCode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
