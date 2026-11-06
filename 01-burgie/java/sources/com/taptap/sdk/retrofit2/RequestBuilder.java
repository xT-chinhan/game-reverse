package com.taptap.sdk.retrofit2;

import com.taptap.sdk.okhttp3.FormBody;
import com.taptap.sdk.okhttp3.Headers;
import com.taptap.sdk.okhttp3.HttpUrl;
import com.taptap.sdk.okhttp3.MediaType;
import com.taptap.sdk.okhttp3.MultipartBody;
import com.taptap.sdk.okhttp3.Request;
import com.taptap.sdk.okhttp3.RequestBody;
import com.taptap.sdk.okio.Buffer;
import com.taptap.sdk.okio.BufferedSink;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
final class RequestBuilder {
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final HttpUrl baseUrl;

    @Nullable
    private RequestBody body;

    @Nullable
    private MediaType contentType;

    @Nullable
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final Headers.Builder headersBuilder;
    private final String method;

    @Nullable
    private MultipartBody.Builder multipartBuilder;

    @Nullable
    private String relativeUrl;
    private final Request.Builder requestBuilder = new Request.Builder();

    @Nullable
    private HttpUrl.Builder urlBuilder;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    RequestBuilder(String method, HttpUrl baseUrl, @Nullable String relativeUrl, @Nullable Headers headers, @Nullable MediaType contentType, boolean hasBody, boolean isFormEncoded, boolean isMultipart) {
        this.method = method;
        this.baseUrl = baseUrl;
        this.relativeUrl = relativeUrl;
        this.contentType = contentType;
        this.hasBody = hasBody;
        if (headers != null) {
            this.headersBuilder = headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        if (isFormEncoded) {
            this.formBuilder = new FormBody.Builder();
        } else if (isMultipart) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.multipartBuilder = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    void setRelativeUrl(Object relativeUrl) {
        this.relativeUrl = relativeUrl.toString();
    }

    void addHeader(String name, String value, boolean allowUnsafeNonAsciiValues) {
        if ("Content-Type".equalsIgnoreCase(name)) {
            try {
                this.contentType = MediaType.get(value);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Malformed content type: " + value, e);
            }
        } else if (allowUnsafeNonAsciiValues) {
            this.headersBuilder.addUnsafeNonAscii(name, value);
        } else {
            this.headersBuilder.add(name, value);
        }
    }

    void addHeaders(Headers headers) {
        this.headersBuilder.addAll(headers);
    }

    void addPathParam(String name, String value, boolean encoded) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        String replacement = canonicalizeForPath(value, encoded);
        String newRelativeUrl = this.relativeUrl.replace("{" + name + "}", replacement);
        if (PATH_TRAVERSAL.matcher(newRelativeUrl).matches()) {
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + value);
        }
        this.relativeUrl = newRelativeUrl;
    }

    private static String canonicalizeForPath(String input, boolean alreadyEncoded) {
        int i = 0;
        int limit = input.length();
        while (i < limit) {
            int codePoint = input.codePointAt(i);
            if (codePoint >= 32 && codePoint < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePoint) == -1 && (alreadyEncoded || (codePoint != 47 && codePoint != 37))) {
                i += Character.charCount(codePoint);
            } else {
                Buffer out = new Buffer();
                out.writeUtf8(input, 0, i);
                canonicalizeForPath(out, input, i, limit, alreadyEncoded);
                return out.readUtf8();
            }
        }
        return input;
    }

    private static void canonicalizeForPath(Buffer out, String input, int pos, int limit, boolean alreadyEncoded) {
        Buffer utf8Buffer = null;
        int i = pos;
        while (i < limit) {
            int codePoint = input.codePointAt(i);
            if (!alreadyEncoded || (codePoint != 9 && codePoint != 10 && codePoint != 12 && codePoint != 13)) {
                if (codePoint < 32 || codePoint >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePoint) != -1 || (!alreadyEncoded && (codePoint == 47 || codePoint == 37))) {
                    if (utf8Buffer == null) {
                        utf8Buffer = new Buffer();
                    }
                    utf8Buffer.writeUtf8CodePoint(codePoint);
                    while (!utf8Buffer.exhausted()) {
                        int b = utf8Buffer.readByte() & UByte.MAX_VALUE;
                        out.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        out.writeByte((int) cArr[(b >> 4) & 15]);
                        out.writeByte((int) cArr[b & 15]);
                    }
                } else {
                    out.writeUtf8CodePoint(codePoint);
                }
            }
            i += Character.charCount(codePoint);
        }
    }

    void addQueryParam(String name, @Nullable String value, boolean encoded) {
        String str = this.relativeUrl;
        if (str != null) {
            HttpUrl.Builder builderNewBuilder = this.baseUrl.newBuilder(str);
            this.urlBuilder = builderNewBuilder;
            if (builderNewBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (encoded) {
            this.urlBuilder.addEncodedQueryParameter(name, value);
        } else {
            this.urlBuilder.addQueryParameter(name, value);
        }
    }

    void addFormField(String name, String value, boolean encoded) {
        if (encoded) {
            this.formBuilder.addEncoded(name, value);
        } else {
            this.formBuilder.add(name, value);
        }
    }

    void addPart(Headers headers, RequestBody body) {
        this.multipartBuilder.addPart(headers, body);
    }

    void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    void setBody(RequestBody body) {
        this.body = body;
    }

    <T> void addTag(Class<T> cls, @Nullable T value) {
        this.requestBuilder.tag(cls, value);
    }

    Request.Builder get() {
        HttpUrl url;
        HttpUrl.Builder urlBuilder = this.urlBuilder;
        if (urlBuilder != null) {
            url = urlBuilder.build();
        } else {
            url = this.baseUrl.resolve(this.relativeUrl);
            if (url == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        RequestBody body = this.body;
        if (body == null) {
            FormBody.Builder builder = this.formBuilder;
            if (builder != null) {
                body = builder.build();
            } else {
                MultipartBody.Builder builder2 = this.multipartBuilder;
                if (builder2 != null) {
                    body = builder2.build();
                } else if (this.hasBody) {
                    body = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType contentType = this.contentType;
        if (contentType != null) {
            if (body != null) {
                body = new ContentTypeOverridingRequestBody(body, contentType);
            } else {
                this.headersBuilder.add("Content-Type", contentType.toString());
            }
        }
        return this.requestBuilder.url(url).headers(this.headersBuilder.build()).method(this.method, body);
    }

    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody delegate, MediaType contentType) {
            this.delegate = delegate;
            this.contentType = contentType;
        }

        @Override // com.taptap.sdk.okhttp3.RequestBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // com.taptap.sdk.okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // com.taptap.sdk.okhttp3.RequestBody
        public void writeTo(BufferedSink sink) throws IOException {
            this.delegate.writeTo(sink);
        }
    }
}
