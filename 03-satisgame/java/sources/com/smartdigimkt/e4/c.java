package com.smartdigimkt.e4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public long a;
    public final HttpURLConnection b;
    public final InputStream c;

    public c(HttpURLConnection httpURLConnection, InputStream inputStream) {
        this.b = httpURLConnection;
        this.c = inputStream;
    }

    public final void a() {
        try {
            InputStream inputStream = this.c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable unused) {
        }
        try {
            HttpURLConnection httpURLConnection = this.b;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (Throwable unused2) {
        }
    }

    public final String a(boolean z) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStream bVar = this.c;
        if (bVar == null) {
            try {
                HttpURLConnection httpURLConnection = this.b;
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
            if (this.a > 0) {
                bVar = new b(this.c, this.a);
            }
            inputStreamReader = new InputStreamReader(bVar);
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
                    a();
                    return sb.toString();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    a();
                    throw th;
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
