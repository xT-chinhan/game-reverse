package com.byazt.uf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 886, 19})
public class n implements q {
    public final HttpURLConnection n;

    public n(HttpURLConnection httpURLConnection) {
        this.n = httpURLConnection;
    }

    @Override // com.byazt.uf.q
    public boolean n() {
        try {
            return this.n.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.byazt.uf.q
    public InputStream qg() throws IOException {
        return this.n.getInputStream();
    }

    @Override // com.byazt.uf.q
    public String s() {
        return this.n.getContentType();
    }

    @Override // com.byazt.uf.q
    public String q() {
        try {
            if (n()) {
                return null;
            }
            return "Unable to fetch " + this.n.getURL() + ". Failed with " + this.n.getResponseCode() + "\n" + n(this.n);
        } catch (IOException e) {
            com.byazt.nu.w.n("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.n.disconnect();
    }

    private String n(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
