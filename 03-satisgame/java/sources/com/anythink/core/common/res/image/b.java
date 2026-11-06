package com.anythink.core.common.res.image;

import android.os.SystemClock;
import com.byazt.ho.BaseConstants;
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
        return BaseConstants.Time.MINUTE;
    }

    private static int h() {
        return BaseConstants.Time.MINUTE;
    }

    protected abstract Map<String, String> a();

    protected abstract void a(Runnable runnable);

    protected abstract void a(String str);

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
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            try {
                a(b.this.d);
            } catch (Exception e) {
                b.this.a(e.getMessage());
            } catch (OutOfMemoryError e2) {
                e = e2;
                System.gc();
                b.this.a(e.getMessage());
            } catch (StackOverflowError e3) {
                e = e3;
                System.gc();
                b.this.a(e.getMessage());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v30 */
        /* JADX WARN: Type inference failed for: r0v38 */
        /* JADX WARN: Type inference failed for: r0v39 */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v40 */
        /* JADX WARN: Type inference failed for: r0v41 */
        /* JADX WARN: Type inference failed for: r0v42 */
        /* JADX WARN: Type inference failed for: r0v43 */
        /* JADX WARN: Type inference failed for: r0v44 */
        /* JADX WARN: Type inference failed for: r0v45 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v7, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v8, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v9, types: [java.net.HttpURLConnection] */
        private void a(String str) throws Throwable {
            String str2;
            b.this.f = System.currentTimeMillis();
            b.this.g = SystemClock.elapsedRealtime();
            ?? r0 = 0;
            r0 = 0;
            r0 = 0;
            r0 = 0;
            r0 = 0;
            r0 = 0;
            r0 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection.setInstanceFollowRedirects(false);
                        Map<String, String> mapA = b.this.a();
                        if (mapA != null && mapA.size() > 0) {
                            for (String str3 : mapA.keySet()) {
                                httpURLConnection.addRequestProperty(str3, mapA.get(str3));
                            }
                        }
                        if (b.this.e) {
                            b.this.a("Task had been canceled.");
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        httpURLConnection.setConnectTimeout(BaseConstants.Time.MINUTE);
                        httpURLConnection.setReadTimeout(BaseConstants.Time.MINUTE);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode != 200) {
                            if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                                b.this.a("Resource download fail, status code: " + responseCode + ", " + httpURLConnection.getResponseMessage() + ", url: " + str);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                            if (b.this.e) {
                                b.this.a("Task had been canceled.");
                            } else {
                                String headerField = httpURLConnection.getHeaderField("Location");
                                if (headerField != null) {
                                    if (!headerField.toLowerCase().startsWith("http")) {
                                        b.this.a("Final url is wrong:".concat(String.valueOf(headerField)));
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                    a(headerField);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        if (b.this.e) {
                            b.this.a("Task had been canceled.");
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
                            b.this.c();
                        } else {
                            str2 = "Save fail!";
                            b.this.a("Save fail!");
                        }
                        if (httpURLConnection != null) {
                            r0 = str2;
                            r0 = zA;
                            httpURLConnection.disconnect();
                            return;
                        }
                        r0 = str2;
                        r0 = zA;
                    } catch (OutOfMemoryError e) {
                        e = e;
                        r0 = httpURLConnection;
                        System.gc();
                        b.this.a(e.getMessage());
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                    } catch (StackOverflowError e2) {
                        e = e2;
                        r0 = httpURLConnection;
                        System.gc();
                        b.this.a(e.getMessage());
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                    } catch (Error e3) {
                        e = e3;
                        r0 = httpURLConnection;
                        System.gc();
                        b.this.a(e.getMessage());
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                    } catch (SocketTimeoutException e4) {
                        e = e4;
                        r0 = httpURLConnection;
                        b.this.a(e.getMessage());
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                    } catch (ConnectTimeoutException e5) {
                        e = e5;
                        r0 = httpURLConnection;
                        b.this.a(e.getMessage());
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                    } catch (Exception e6) {
                        e = e6;
                        r0 = httpURLConnection;
                        b.this.a(e.getMessage());
                        if (r0 != 0) {
                            r0.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        r0 = httpURLConnection;
                        if (r0 != 0) {
                            r0.disconnect();
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
