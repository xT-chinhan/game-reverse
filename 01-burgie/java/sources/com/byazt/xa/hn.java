package com.byazt.xa;

import android.os.Build;
import android.os.Environment;
import com.bumptech.glide.load.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT, 20})
public abstract class hn {
    public boolean hn;
    public boolean hw;
    public boolean pr;
    public boolean x;

    public abstract boolean pr(JSONObject jSONObject) throws JSONException, SecurityException;

    public hn(boolean z, boolean z2) {
        this.hw = z;
        this.hn = z2;
        this.x = false;
    }

    public hn(boolean z, boolean z2, boolean z3) {
        this.hw = z;
        this.hn = z2;
        this.x = z3;
    }

    /* JADX WARN: Code duplicated, block: B:105:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String pr(String str, String str2) throws Throwable {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        int i;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api.embed/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLockLock = null;
        try {
            File file = new File(str3);
            if (!file.exists() && !file.mkdirs()) {
                return str2;
            }
            File file2 = new File(str4);
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rwd");
            try {
                fileLockLock = randomAccessFile2.getChannel().lock();
                if (file2.isFile() && (i = randomAccessFile2.read((bArr = new byte[129]), 0, 129)) > 0 && i < 129) {
                    String str5 = new String(bArr, 0, i, Key.STRING_CHARSET_NAME);
                    if (aj.pr(str5)) {
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (Exception e) {
                            }
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (Exception e2) {
                        }
                        return str5;
                    }
                }
                byte[] bytes = str2.getBytes(Key.STRING_CHARSET_NAME);
                randomAccessFile2.setLength(0L);
                randomAccessFile2.write(bytes);
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception e3) {
                    }
                }
                try {
                    randomAccessFile2.close();
                } catch (Exception e4) {
                }
                return str2;
            } catch (IOException e5) {
                randomAccessFile = randomAccessFile2;
                e = e5;
            } catch (Throwable th) {
                randomAccessFile = randomAccessFile2;
                th = th;
                if (fileLockLock != null) {
                    try {
                        fileLockLock.release();
                    } catch (Exception e6) {
                    }
                }
                if (randomAccessFile != null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (Exception e7) {
                    throw th;
                }
            }
        } catch (IOException e8) {
            e = e8;
            randomAccessFile = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (com.byazt.gox.x.c().pr.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                    throw new SecurityException(e);
                }
                com.byazt.ec.w.hw(e);
            }
            if (fileLockLock != null) {
                try {
                    fileLockLock.release();
                } catch (Exception e9) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e10) {
                }
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            if (fileLockLock != null) {
                fileLockLock.release();
            }
            if (randomAccessFile != null) {
                throw th;
            }
            randomAccessFile.close();
            throw th;
        }
    }
}
