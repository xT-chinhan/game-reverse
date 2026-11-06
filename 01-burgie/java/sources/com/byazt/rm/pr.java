package com.byazt.rm;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bumptech.glide.load.Key;
import com.byazt.jl.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2349, 37})
public class pr {
    public x pr(String str) throws Throwable {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                if (randomAccessFile2.length() < 22) {
                    throw new IOException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
                }
                x xVar = new x(str);
                pr(randomAccessFile2, xVar);
                if (xVar.hw().pr() == 0) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e) {
                    }
                    return xVar;
                }
                hw(randomAccessFile2, xVar);
                try {
                    randomAccessFile2.close();
                } catch (IOException e2) {
                }
                return xVar;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void pr(RandomAccessFile randomAccessFile, x xVar) throws IOException {
        randomAccessFile.seek(hn(randomAccessFile, xVar) + 4);
        com.byazt.jl.hw hwVar = new com.byazt.jl.hw();
        randomAccessFile.skipBytes(6);
        hwVar.pr(xVar.x().hw(randomAccessFile));
        randomAccessFile.skipBytes(4);
        hwVar.pr(xVar.x().pr(randomAccessFile));
        xVar.pr(hwVar);
    }

    private void hw(RandomAccessFile randomAccessFile, x xVar) throws IOException {
        com.byazt.jl.pr prVar = new com.byazt.jl.pr();
        ArrayList arrayList = new ArrayList();
        long jHw = xVar.hw().hw();
        long jPr = xVar.hw().pr();
        randomAccessFile.seek(jHw);
        for (int i = 0; i < jPr; i++) {
            com.byazt.jl.hn hnVar = new com.byazt.jl.hn();
            if (xVar.x().pr(randomAccessFile) != 33639248) {
                throw new IOException("Expected central directory entry not found (#" + (i + 1) + ")");
            }
            randomAccessFile.skipBytes(6);
            hnVar.pr(xVar.x().hw(randomAccessFile));
            randomAccessFile.skipBytes(4);
            hnVar.pr(xVar.x().pr(randomAccessFile));
            hnVar.hw(xVar.x().pr(randomAccessFile));
            hnVar.hn(xVar.x().pr(randomAccessFile));
            int iHw = xVar.x().hw(randomAccessFile);
            hnVar.hn(iHw);
            hnVar.x(xVar.x().hw(randomAccessFile));
            int iHw2 = xVar.x().hw(randomAccessFile);
            randomAccessFile.skipBytes(8);
            hnVar.x(xVar.x().pr(randomAccessFile));
            if (iHw > 0) {
                byte[] bArr = new byte[iHw];
                randomAccessFile.readFully(bArr);
                hnVar.pr(pr(bArr));
                randomAccessFile.skipBytes(hnVar.w());
                if (iHw2 > 0) {
                    randomAccessFile.skipBytes(iHw2);
                }
                long filePointer = randomAccessFile.getFilePointer();
                randomAccessFile.seek(hnVar.m() + 28);
                hnVar.hw(xVar.x().hw(randomAccessFile));
                randomAccessFile.seek(filePointer);
                arrayList.add(hnVar);
            } else {
                throw new IOException("Invalid entry name in file header");
            }
        }
        prVar.pr(arrayList);
        xVar.pr(prVar);
    }

    private long hn(RandomAccessFile randomAccessFile, x xVar) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        randomAccessFile.seek(j);
        if (xVar.x().pr(randomAccessFile) == 101010256) {
            return j;
        }
        return x(randomAccessFile, xVar);
    }

    private long x(RandomAccessFile randomAccessFile, x xVar) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (length2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            randomAccessFile.seek(length);
            if (xVar.x().pr(randomAccessFile) == 101010256) {
                return length;
            }
            length3--;
        }
        throw new IOException("Zip headers not found. Probably not a zip file");
    }

    private String pr(byte[] bArr) {
        return new String(bArr, Charset.forName(Key.STRING_CHARSET_NAME));
    }
}
