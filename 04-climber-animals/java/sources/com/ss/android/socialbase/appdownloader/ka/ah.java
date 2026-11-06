package com.ss.android.socialbase.appdownloader.ka;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.downloader.network.ny;
import com.ss.android.socialbase.downloader.ny.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static int f4583ms = 8;
    private static volatile ah xr;
    private ms<Integer, Bitmap> ah;

    private static class ms<K, T> extends LinkedHashMap<K, T> {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final int f4585ms;

        public ms(int i, int i2) {
            super(i2, 0.75f, true);
            this.f4585ms = i;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.f4585ms;
        }
    }

    public static ah ms() {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new ah();
                }
            }
        }
        return xr;
    }

    private ah() {
        this.ah = null;
        int i = f4583ms;
        this.ah = new ms<>(i, i / 2);
    }

    public Bitmap ms(int i) {
        return this.ah.get(Integer.valueOf(i));
    }

    public void ms(final int i, final String str) {
        if (TextUtils.isEmpty(str) || ms(i) != null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.ah.zb().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ka.ah.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamXr;
                ByteArrayInputStream byteArrayInputStream;
                Closeable closeable;
                Throwable th;
                InputStream inputStreamMs;
                ByteArrayInputStream byteArrayInputStream2;
                Exception e;
                try {
                    try {
                        ny nyVarMs = com.ss.android.socialbase.downloader.downloader.ah.ms(true, 0, str, null);
                        if (nyVarMs != null) {
                            inputStreamMs = nyVarMs.ms();
                            try {
                                byteArrayOutputStreamXr = ah.xr(inputStreamMs);
                                try {
                                    byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamXr.toByteArray());
                                    try {
                                        byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamXr.toByteArray());
                                        try {
                                            BitmapFactory.Options options = new BitmapFactory.Options();
                                            options.inJustDecodeBounds = true;
                                            BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                            int i2 = options.outWidth;
                                            int i3 = options.outHeight;
                                            int iMs = com.ss.android.socialbase.appdownloader.ah.ms(com.ss.android.socialbase.downloader.downloader.ah.k(), 44.0f);
                                            options.inSampleSize = ah.ms(iMs, iMs, options);
                                            options.inJustDecodeBounds = false;
                                            ah.this.ah.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                            c.ms(inputStreamMs, byteArrayOutputStreamXr, byteArrayInputStream, byteArrayInputStream2);
                                            return;
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    } catch (Exception e3) {
                                        byteArrayInputStream2 = null;
                                        e = e3;
                                    } catch (Throwable th2) {
                                        closeable = null;
                                        th = th2;
                                        c.ms(inputStreamMs, byteArrayOutputStreamXr, byteArrayInputStream, closeable);
                                        throw th;
                                    }
                                } catch (Exception e4) {
                                    byteArrayInputStream2 = null;
                                    e = e4;
                                    byteArrayInputStream = null;
                                } catch (Throwable th3) {
                                    closeable = null;
                                    th = th3;
                                    byteArrayInputStream = null;
                                }
                            } catch (Exception e5) {
                                byteArrayInputStream = null;
                                byteArrayInputStream2 = null;
                                e = e5;
                                byteArrayOutputStreamXr = null;
                            } catch (Throwable th4) {
                                byteArrayInputStream = null;
                                closeable = null;
                                th = th4;
                                byteArrayOutputStreamXr = null;
                            }
                        } else {
                            c.ms(null, null, null, null);
                            return;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Exception e6) {
                    byteArrayOutputStreamXr = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    e = e6;
                    inputStreamMs = null;
                } catch (Throwable th6) {
                    byteArrayOutputStreamXr = null;
                    byteArrayInputStream = null;
                    closeable = null;
                    th = th6;
                    inputStreamMs = null;
                }
                ab.ms(e);
                c.ms(inputStreamMs, byteArrayOutputStreamXr, byteArrayInputStream, byteArrayInputStream2);
            }
        });
    }

    public static int ms(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream xr(InputStream inputStream) throws IOException {
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
