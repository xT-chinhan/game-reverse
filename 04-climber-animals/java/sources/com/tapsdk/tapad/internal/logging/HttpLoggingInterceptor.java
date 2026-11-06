package com.tapsdk.tapad.internal.logging;

import com.efs.sdk.base.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Response;
import okio.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public class HttpLoggingInterceptor implements Interceptor {
    private final Map<String, String> a;
    private final b b;
    private boolean c;
    private volatile Set<String> d;
    private volatile Level e;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    class a implements b {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.logging.HttpLoggingInterceptor.b
        public void a(String str, Map<String, String> map) {
        }
    }

    public interface b {
        void a(String str, Map<String, String> map);
    }

    private HttpLoggingInterceptor() {
        this.a = new HashMap();
        this.c = false;
        this.d = Collections.emptySet();
        this.e = Level.NONE;
        this.b = new a();
    }

    public HttpLoggingInterceptor(boolean z, b bVar) {
        this.a = new HashMap();
        this.c = false;
        this.d = Collections.emptySet();
        this.e = Level.NONE;
        this.c = z;
        this.b = bVar;
    }

    private void a(Headers headers, int i) {
        this.b.a(headers.name(i) + ": " + (this.d.contains(headers.name(i)) ? "██" : headers.value(i)), this.a);
    }

    private static boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase(Constants.CP_GZIP)) ? false : true;
    }

    static boolean a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i = 0; i < 16 && !buffer2.exhausted(); i++) {
                int utf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(utf8CodePoint) && !Character.isWhitespace(utf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public Level a() {
        return this.e;
    }

    public HttpLoggingInterceptor a(Level level) {
        if (level == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.e = level;
        return this;
    }

    public void a(String str) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(this.d);
        treeSet.add(str);
        this.d = treeSet;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
