package com.byazt.rft;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 18})
public class l extends InputStream {
    public InputStream n;
    public HttpURLConnection qg;

    public l(InputStream inputStream, HttpURLConnection httpURLConnection) {
        this.n = inputStream;
        this.qg = httpURLConnection;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            return inputStream.read();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            return inputStream.read(bArr);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        return 0;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            return inputStream.skip(j);
        }
        return 0L;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            inputStream.close();
            this.n = null;
        }
        HttpURLConnection httpURLConnection = this.qg;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.qg = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            inputStream.mark(i);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.n;
        if (inputStream != null) {
            return inputStream.markSupported();
        }
        return false;
    }
}
