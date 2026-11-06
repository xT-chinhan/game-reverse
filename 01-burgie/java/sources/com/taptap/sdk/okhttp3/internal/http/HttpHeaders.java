package com.taptap.sdk.okhttp3.internal.http;

import com.taptap.sdk.okhttp3.Challenge;
import com.taptap.sdk.okhttp3.Cookie;
import com.taptap.sdk.okhttp3.CookieJar;
import com.taptap.sdk.okhttp3.Headers;
import com.taptap.sdk.okhttp3.HttpUrl;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.Response;
import com.taptap.sdk.okio.Buffer;
import com.taptap.sdk.okio.ByteString;
import com.taptap.sdk.update.download.core.Util;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get(Util.CONTENT_LENGTH));
    }

    private static long stringToLong(String s) {
        if (s == null) {
            return -1L;
        }
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1L;
        }
    }

    public static boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
        for (String field : varyFields(cachedResponse)) {
            if (!com.taptap.sdk.okhttp3.internal.Util.equal(cachedRequest.values(field), newRequest.headers(field))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static boolean hasVaryAll(Headers responseHeaders) {
        return varyFields(responseHeaders).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Set<String> varyFields(Headers responseHeaders) {
        Set<String> result = Collections.emptySet();
        int size = responseHeaders.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(responseHeaders.name(i))) {
                String value = responseHeaders.value(i);
                if (result.isEmpty()) {
                    result = new TreeSet((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String varyField : value.split(",")) {
                    result.add(varyField.trim());
                }
            }
        }
        return result;
    }

    public static Headers varyHeaders(Response response) {
        Headers requestHeaders = response.networkResponse().request().headers();
        Headers responseHeaders = response.headers();
        return varyHeaders(requestHeaders, responseHeaders);
    }

    public static Headers varyHeaders(Headers requestHeaders, Headers responseHeaders) {
        Set<String> varyFields = varyFields(responseHeaders);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder result = new Headers.Builder();
        int size = requestHeaders.size();
        for (int i = 0; i < size; i++) {
            String fieldName = requestHeaders.name(i);
            if (varyFields.contains(fieldName)) {
                result.add(fieldName, requestHeaders.value(i));
            }
        }
        return result.build();
    }

    public static List<Challenge> parseChallenges(Headers responseHeaders, String headerName) {
        List<Challenge> result = new ArrayList<>();
        for (int h = 0; h < responseHeaders.size(); h++) {
            if (headerName.equalsIgnoreCase(responseHeaders.name(h))) {
                Buffer header = new Buffer().writeUtf8(responseHeaders.value(h));
                parseChallengeHeader(result, header);
            }
        }
        return result;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x008e  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0084 A[EDGE_INSN: B:68:0x0084->B:27:0x0084 BREAK  A[LOOP:1: B:21:0x0071->B:69:0x0071], SYNTHETIC] */
    private static void parseChallengeHeader(List<Challenge> result, Buffer header) {
        String parameterValue;
        String replaced;
        String peek = null;
        while (true) {
            if (peek == null) {
                skipWhitespaceAndCommas(header);
                peek = readToken(header);
                if (peek == null) {
                    return;
                }
            }
            String schemeName = peek;
            boolean commaPrefixed = skipWhitespaceAndCommas(header);
            peek = readToken(header);
            if (peek == null) {
                if (header.exhausted()) {
                    result.add(new Challenge(schemeName, (Map<String, String>) Collections.emptyMap()));
                    return;
                }
                return;
            }
            int eqCount = skipAll(header, (byte) 61);
            boolean commaSuffixed = skipWhitespaceAndCommas(header);
            if (!commaPrefixed && (commaSuffixed || header.exhausted())) {
                result.add(new Challenge(schemeName, (Map<String, String>) Collections.singletonMap(null, peek + repeat('=', eqCount))));
                peek = null;
            } else {
                Map<String, String> parameters = new LinkedHashMap<>();
                int eqCount2 = eqCount + skipAll(header, (byte) 61);
                while (true) {
                    if (peek == null) {
                        peek = readToken(header);
                        if (skipWhitespaceAndCommas(header)) {
                            break;
                        }
                        eqCount2 = skipAll(header, (byte) 61);
                        if (eqCount2 == 0) {
                            break;
                        }
                        if (eqCount2 <= 1 || skipWhitespaceAndCommas(header)) {
                            return;
                        }
                        if (header.exhausted() && header.getByte(0L) == 34) {
                            parameterValue = readQuotedString(header);
                        } else {
                            parameterValue = readToken(header);
                        }
                        if (parameterValue == null) {
                            return;
                        }
                        replaced = parameters.put(peek, parameterValue);
                        peek = null;
                        if (replaced != null) {
                            return;
                        }
                        if (skipWhitespaceAndCommas(header) && !header.exhausted()) {
                            return;
                        }
                    } else {
                        if (eqCount2 == 0) {
                            break;
                            break;
                        }
                        if (eqCount2 <= 1) {
                            return;
                        }
                        if (header.exhausted()) {
                            parameterValue = readToken(header);
                        } else {
                            parameterValue = readToken(header);
                        }
                        if (parameterValue == null) {
                            return;
                        }
                        replaced = parameters.put(peek, parameterValue);
                        peek = null;
                        if (replaced != null) {
                            return;
                        } else {
                            if (skipWhitespaceAndCommas(header)) {
                            }
                        }
                    }
                }
                result.add(new Challenge(schemeName, parameters));
            }
        }
    }

    private static boolean skipWhitespaceAndCommas(Buffer buffer) {
        boolean commaFound = false;
        while (!buffer.exhausted()) {
            byte b = buffer.getByte(0L);
            if (b == 44) {
                buffer.readByte();
                commaFound = true;
            } else {
                if (b != 32 && b != 9) {
                    break;
                }
                buffer.readByte();
            }
        }
        return commaFound;
    }

    private static int skipAll(Buffer buffer, byte b) {
        int count = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b) {
            count++;
            buffer.readByte();
        }
        return count;
    }

    private static String readQuotedString(Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException();
        }
        Buffer result = new Buffer();
        while (true) {
            long i = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (i == -1) {
                return null;
            }
            if (buffer.getByte(i) == 34) {
                result.write(buffer, i);
                buffer.readByte();
                return result.readUtf8();
            }
            if (buffer.size() == i + 1) {
                return null;
            }
            result.write(buffer, i);
            buffer.readByte();
            result.write(buffer, 1L);
        }
    }

    private static String readToken(Buffer buffer) {
        try {
            long tokenSize = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (tokenSize == -1) {
                tokenSize = buffer.size();
            }
            if (tokenSize != 0) {
                return buffer.readUtf8(tokenSize);
            }
            return null;
        } catch (EOFException e) {
            throw new AssertionError();
        }
    }

    private static String repeat(char c, int count) {
        char[] array = new char[count];
        Arrays.fill(array, c);
        return new String(array);
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl url, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> cookies = Cookie.parseAll(url, headers);
        if (cookies.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(url, cookies);
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(Util.METHOD_HEAD)) {
            return false;
        }
        int responseCode = response.code();
        return (((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header(Util.TRANSFER_ENCODING))) ? false : true;
    }

    public static int skipUntil(String input, int pos, String characters) {
        while (pos < input.length() && characters.indexOf(input.charAt(pos)) == -1) {
            pos++;
        }
        return pos;
    }

    public static int skipWhitespace(String input, int pos) {
        char c;
        while (pos < input.length() && ((c = input.charAt(pos)) == ' ' || c == '\t')) {
            pos++;
        }
        return pos;
    }

    public static int parseSeconds(String value, int defaultValue) {
        try {
            long seconds = Long.parseLong(value);
            if (seconds > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (seconds < 0) {
                return 0;
            }
            return (int) seconds;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
