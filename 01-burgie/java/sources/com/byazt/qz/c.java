package com.byazt.qz;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1192, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.to.hw, com.byazt.to.pr {
    public static boolean hn;
    public static Method hw;
    public static Method pr;
    public final boolean c;
    public final com.byazt.cr.hn x;

    static {
        hn = false;
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            pr = cls.getDeclaredMethod("readMapXml", InputStream.class);
            hw = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            pr.setAccessible(true);
            hw.setAccessible(true);
            hn = true;
        } catch (Exception e) {
            hn = false;
        }
    }

    public static boolean pr() {
        return hn;
    }

    public c(com.byazt.cr.hn hnVar) {
        this.x = hnVar;
        this.c = false;
    }

    public c(com.byazt.cr.hn hnVar, boolean z) {
        this.x = hnVar;
        this.c = z;
    }

    @Override // com.byazt.to.pr
    public Map<String, Object> pr(File file) throws Throwable {
        if (hn && file.exists()) {
            BufferedInputStream bufferedInputStream = null;
            if (!file.canRead()) {
                return null;
            }
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file), 49152);
                try {
                    Map<String, Object> mapPr = new com.byazt.ox.hw().pr((Map) pr.invoke(null, bufferedInputStream2), this.x, this.c);
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                    }
                    return mapPr;
                } catch (Exception e2) {
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return Collections.emptyMap();
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return Collections.emptyMap();
    }

    @Override // com.byazt.to.hw
    public void pr(Map<String, Object> map, File file) throws Throwable {
        if (!hn || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    hw.invoke(null, new com.byazt.ox.hw().pr(map, this.x, this.c), fileOutputStream2);
                    fileOutputStream2.close();
                } catch (Exception e) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
            }
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
