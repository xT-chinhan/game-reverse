package com.bykv.vk.openvk.component.video.ms.xr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final RandomAccessFile f106ms;

    x(File file, String str) throws ms {
        try {
            this.f106ms = new RandomAccessFile(file, str);
        } catch (FileNotFoundException e) {
            throw new ms(e);
        }
    }

    void ms(long j) throws ms {
        try {
            this.f106ms.seek(j);
        } catch (IOException e) {
            throw new ms(e);
        }
    }

    void ms(byte[] bArr, int i, int i2) throws ms {
        try {
            this.f106ms.write(bArr, i, i2);
        } catch (IOException e) {
            throw new ms(e);
        }
    }

    int ms(byte[] bArr) throws ms {
        try {
            return this.f106ms.read(bArr);
        } catch (IOException e) {
            throw new ms(e);
        }
    }

    void ms() {
        com.bykv.vk.openvk.component.video.ms.ah.ms.ms(this.f106ms);
    }

    static class ms extends Exception {
        ms(Throwable th) {
            super(th);
        }
    }
}
