package com.byazt.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.byazt.m.rv;
import com.byazt.ta.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 8})
public class s {
    public static int n = 8;
    public static volatile s qg;
    public n<Integer, Bitmap> s;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 546})
    private static class n<K, T> extends LinkedHashMap<K, T> {
        public final int n;

        public n(int i, int i2) {
            super(i2, 0.75f, true);
            this.n = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.n;
        }
    }

    public static s n() {
        if (qg == null) {
            synchronized (s.class) {
                if (qg == null) {
                    qg = new s();
                }
            }
        }
        return qg;
    }

    private s() {
        this.s = null;
        int i = n;
        this.s = new n<>(i, i / 2);
    }

    public Bitmap n(int i) {
        return this.s.get(Integer.valueOf(i));
    }

    public void n(final int i, final String str) {
        if (TextUtils.isEmpty(str) || n(i) != null) {
            return;
        }
        com.byazt.xv.s.oa().submit(new Runnable() { // from class: com.byazt.j.s.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamQg;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStreamN;
                InputStream inputStream = null;
                try {
                    rv rvVarN = com.byazt.xv.s.n(true, 0, str, null);
                    if (rvVarN != null) {
                        inputStreamN = rvVarN.n();
                        try {
                            byteArrayOutputStreamQg = s.qg(inputStreamN);
                            try {
                                byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamQg.toByteArray());
                                try {
                                    byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamQg.toByteArray());
                                    try {
                                        BitmapFactory.Options options = new BitmapFactory.Options();
                                        options.inJustDecodeBounds = true;
                                        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                        int i2 = options.outWidth;
                                        int i3 = options.outHeight;
                                        int iN = com.byazt.e.s.n(com.byazt.xv.s.u(), 44.0f);
                                        options.inSampleSize = s.n(iN, iN, options);
                                        options.inJustDecodeBounds = false;
                                        s.this.s.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                        w.n(inputStreamN, byteArrayOutputStreamQg, byteArrayInputStream, byteArrayInputStream2);
                                        return;
                                    } catch (Exception unused) {
                                        inputStream = inputStreamN;
                                        w.n(inputStream, byteArrayOutputStreamQg, byteArrayInputStream, byteArrayInputStream2);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        w.n(inputStreamN, byteArrayOutputStreamQg, byteArrayInputStream, byteArrayInputStream2);
                                        throw th;
                                    }
                                } catch (Exception unused2) {
                                    byteArrayInputStream2 = null;
                                } catch (Throwable th3) {
                                    byteArrayInputStream2 = null;
                                    th = th3;
                                }
                            } catch (Exception unused3) {
                                byteArrayInputStream = null;
                                byteArrayInputStream2 = byteArrayInputStream;
                                inputStream = inputStreamN;
                                w.n(inputStream, byteArrayOutputStreamQg, byteArrayInputStream, byteArrayInputStream2);
                            } catch (Throwable th4) {
                                byteArrayInputStream2 = null;
                                th = th4;
                                byteArrayInputStream = null;
                            }
                        } catch (Exception unused4) {
                            byteArrayOutputStreamQg = null;
                            byteArrayInputStream = null;
                        } catch (Throwable th5) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = null;
                            th = th5;
                            byteArrayOutputStreamQg = null;
                        }
                    } else {
                        w.n(null, null, null, null);
                        return;
                    }
                } catch (Exception unused5) {
                    byteArrayOutputStreamQg = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                } catch (Throwable th6) {
                    byteArrayOutputStreamQg = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th6;
                    inputStreamN = null;
                }
                w.n(inputStream, byteArrayOutputStreamQg, byteArrayInputStream, byteArrayInputStream2);
            }
        });
    }

    public static int n(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream qg(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i >= 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream;
            }
        }
    }
}
