package com.byazt.bny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1753, 37})
public class pr implements x {
    public final HttpURLConnection pr;

    public pr(HttpURLConnection httpURLConnection) {
        this.pr = httpURLConnection;
    }

    @Override // com.byazt.bny.x
    public boolean pr() {
        try {
            return this.pr.getResponseCode() / 100 == 2;
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.byazt.bny.x
    public InputStream hw() throws IOException {
        return this.pr.getInputStream();
    }

    @Override // com.byazt.bny.x
    public String hn() {
        return this.pr.getContentType();
    }

    @Override // com.byazt.bny.x
    public String x() {
        try {
            if (pr()) {
                return null;
            }
            return "Unable to fetch " + this.pr.getURL() + ". Failed with " + this.pr.getResponseCode() + "\n" + pr(this.pr);
        } catch (IOException e) {
            com.byazt.ptr.uc.pr("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pr.disconnect();
    }

    private String pr(HttpURLConnection httpURLConnection) throws IOException {
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
                    } catch (Exception e) {
                    }
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception e2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }
}
