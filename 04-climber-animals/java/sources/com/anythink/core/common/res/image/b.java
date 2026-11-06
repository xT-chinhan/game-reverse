package com.anythink.core.common.res.image;

import android.os.SystemClock;
import com.anythink.core.common.v.b.d;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Map;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private final String a = getClass().getSimpleName();
    protected String d;
    protected boolean e;
    protected long f;
    protected long g;
    protected long h;
    protected long i;
    protected long j;

    private static int g() {
        return 60000;
    }

    private static int h() {
        return 60000;
    }

    protected abstract Map<String, String> a();

    protected abstract void a(d dVar);

    protected abstract void a(String str, String str2);

    protected abstract boolean a(InputStream inputStream);

    protected abstract void b();

    protected abstract void c();

    public b(String str) {
        this.d = str;
    }

    public final void d() {
        this.e = false;
        a(new AnonymousClass1());
    }

    private void e() {
        this.e = true;
    }

    /* JADX INFO: renamed from: com.anythink.core.common.res.image.b$1, reason: invalid class name */
    final class AnonymousClass1 extends d {
        AnonymousClass1() {
        }

        @Override // com.anythink.core.common.v.b.d
        public final void a() throws Throwable {
            try {
                b(b.this.d);
            } catch (Exception e) {
                String unused = b.this.a;
                e.getMessage();
                b.this.a(c.a, e.getMessage());
            } catch (OutOfMemoryError e2) {
                e = e2;
                System.gc();
                b.this.a(c.a, e.getMessage());
            } catch (StackOverflowError e3) {
                e = e3;
                System.gc();
                b.this.a(c.a, e.getMessage());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v10, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v30 */
        /* JADX WARN: Type inference failed for: r1v38 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r1v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v40 */
        /* JADX WARN: Type inference failed for: r1v41 */
        /* JADX WARN: Type inference failed for: r1v42 */
        /* JADX WARN: Type inference failed for: r1v43 */
        /* JADX WARN: Type inference failed for: r1v44 */
        /* JADX WARN: Type inference failed for: r1v45 */
        /* JADX WARN: Type inference failed for: r1v5, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v6, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v8, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r1v9, types: [java.net.HttpURLConnection] */
        private void b(String str) throws Throwable {
            String str2;
            b.this.f = System.currentTimeMillis();
            b.this.g = SystemClock.elapsedRealtime();
            ?? r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            r1 = 0;
            try {
                try {
                    String unused = b.this.a;
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setInstanceFollowRedirects(false);
                        Map<String, String> mapA = b.this.a();
                        if (mapA != null && mapA.size() > 0) {
                            for (String str3 : mapA.keySet()) {
                                httpURLConnection.addRequestProperty(str3, mapA.get(str3));
                                String unused2 = b.this.a;
                                new StringBuilder("REQUEST ADDED HEADER: \n").append(str3).append("  :  ");
                                mapA.get(str3);
                            }
                        }
                        if (b.this.e) {
                            b.this.a(c.b, "Task had been canceled.");
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        httpURLConnection.setConnectTimeout(60000);
                        httpURLConnection.setReadTimeout(60000);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 200) {
                            String unused3 = b.this.a;
                            new StringBuilder("http respond status code is ").append(responseCode).append(" ! url=");
                            if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                                b.this.a(c.a, "Resource download fail, status code: " + responseCode + ", " + httpURLConnection.getResponseMessage() + ", url: " + str);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (b.this.e) {
                                b.this.a(c.b, "Task had been canceled.");
                            } else {
                                String headerField = httpURLConnection.getHeaderField("Location");
                                if (headerField != null) {
                                    if (!headerField.toLowerCase().startsWith("http")) {
                                        b.this.a(c.a, "Final url is wrong:".concat(String.valueOf(headerField)));
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                    b(headerField);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        if (b.this.e) {
                            b.this.a(c.b, "Task had been canceled.");
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        b.this.j = httpURLConnection.getContentLength();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        boolean zA = b.this.a(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        b.this.h = System.currentTimeMillis();
                        b.this.i = SystemClock.elapsedRealtime();
                        if (zA) {
                            String unused4 = b.this.a;
                            String str4 = b.this.d;
                            b.this.c();
                        } else {
                            String unused5 = b.this.a;
                            String str5 = b.this.d;
                            str2 = "Save fail!";
                            b.this.a(c.a, "Save fail!");
                        }
                        if (httpURLConnection != null) {
                            r1 = str2;
                            r1 = zA;
                            httpURLConnection.disconnect();
                            return;
                        }
                        r1 = str2;
                        r1 = zA;
                    } catch (OutOfMemoryError e) {
                        e = e;
                        r1 = httpURLConnection;
                        System.gc();
                        String unused6 = b.this.a;
                        e.getMessage();
                        b.this.a(c.a, e.getMessage());
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                    } catch (StackOverflowError e2) {
                        e = e2;
                        r1 = httpURLConnection;
                        System.gc();
                        String unused7 = b.this.a;
                        e.getMessage();
                        b.this.a(c.a, e.getMessage());
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                    } catch (Error e3) {
                        e = e3;
                        r1 = httpURLConnection;
                        System.gc();
                        String unused8 = b.this.a;
                        e.getMessage();
                        b.this.a(c.a, e.getMessage());
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        r1 = httpURLConnection;
                        b.this.a(c.a, e.getMessage());
                        String unused9 = b.this.a;
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                    } catch (ConnectTimeoutException e5) {
                        e = e5;
                        r1 = httpURLConnection;
                        b.this.a(c.a, e.getMessage());
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                    } catch (Exception e6) {
                        e = e6;
                        r1 = httpURLConnection;
                        String unused10 = b.this.a;
                        e.getMessage();
                        b.this.a(c.a, e.getMessage());
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        r1 = httpURLConnection;
                        if (r1 != 0) {
                            r1.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (OutOfMemoryError e7) {
                e = e7;
            } catch (StackOverflowError e8) {
                e = e8;
            } catch (Error e9) {
                e = e9;
            } catch (SocketTimeoutException e10) {
                e = e10;
            } catch (ConnectTimeoutException e11) {
                e = e11;
            } catch (Exception e12) {
                e = e12;
            }
        }
    }

    private void f() {
        a(new AnonymousClass1());
    }
}
