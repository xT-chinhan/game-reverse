package com.anythink.core.common.l.a.a;

import android.os.Build;
import com.anythink.core.common.l.a.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
public final class c extends k {
    private final HttpURLConnection a;
    private final InputStream b;

    public c(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.a = httpURLConnection;
        this.b = inputStream;
    }

    @Override // com.anythink.core.common.l.a.k
    public final long a() {
        try {
            if (this.b == null || Build.VERSION.SDK_INT < 33) {
                return 0L;
            }
            return this.b.readAllBytes().length;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @Override // com.anythink.core.common.l.a.k
    public final String b() {
        return a(false);
    }

    @Override // com.anythink.core.common.l.a.k
    public final String c() {
        return a(true);
    }

    private String a(boolean z) throws Throwable {
        InputStreamReader inputStreamReader;
        if (this.b == null) {
            try {
                HttpURLConnection httpURLConnection = this.a;
                if (httpURLConnection == null) {
                    return "";
                }
                httpURLConnection.disconnect();
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        BufferedReader bufferedReader = null;
        try {
            inputStreamReader = new InputStreamReader(this.b);
            try {
                BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader2.readLine();
                        if (line != null) {
                            sb.append(line);
                            if (z) {
                                sb.append('\n');
                            }
                        } else {
                            try {
                                break;
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                    bufferedReader2.close();
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused3) {
                    }
                    try {
                        InputStream inputStream = this.b;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        HttpURLConnection httpURLConnection2 = this.a;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable unused4) {
                    }
                    return sb.toString();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable unused6) {
                        }
                    }
                    try {
                        InputStream inputStream2 = this.b;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        HttpURLConnection httpURLConnection3 = this.a;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                            throw th;
                        }
                        throw th;
                    } catch (Throwable unused7) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamReader = null;
        }
    }
}
