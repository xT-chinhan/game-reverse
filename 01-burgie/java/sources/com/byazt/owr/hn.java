package com.byazt.owr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.byazt.edb.aj;
import com.byazt.tuy.uc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 404, 20})
public class hn {
    public static volatile hn hw;
    public static int pr = 8;
    public pr<Integer, Bitmap> hn;

    @com.byazt.vzx.pr(pr = {0, 1, 404, 116})
    private static class pr<K, T> extends LinkedHashMap<K, T> {
        public final int pr;

        public pr(int i, int i2) {
            super(i2, 0.75f, true);
            this.pr = i;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, T> entry) {
            return size() > this.pr;
        }
    }

    public static hn pr() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    private hn() {
        this.hn = null;
        int i = pr;
        this.hn = new pr<>(i, i / 2);
    }

    public Bitmap pr(int i) {
        return this.hn.get(Integer.valueOf(i));
    }

    public void pr(final int i, final String str) {
        if (TextUtils.isEmpty(str) || pr(i) != null) {
            return;
        }
        com.byazt.lj.hn.m().submit(new Runnable() { // from class: com.byazt.owr.hn.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                ByteArrayOutputStream byteArrayOutputStreamHw;
                ByteArrayInputStream byteArrayInputStream;
                ByteArrayInputStream byteArrayInputStream2;
                Throwable th;
                InputStream inputStreamPr;
                InputStream inputStream = null;
                try {
                    aj ajVarPr = com.byazt.lj.hn.pr(true, 0, str, null);
                    if (ajVarPr == null) {
                        uc.pr(null, null, null, null);
                        return;
                    }
                    inputStreamPr = ajVarPr.pr();
                    try {
                        byteArrayOutputStreamHw = hn.hw(inputStreamPr);
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStreamHw.toByteArray());
                            try {
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStreamHw.toByteArray());
                                try {
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(byteArrayInputStream, null, options);
                                    int i2 = options.outWidth;
                                    int i3 = options.outHeight;
                                    int iPr = com.byazt.mdu.hn.pr(com.byazt.lj.hn.of(), 44.0f);
                                    options.inSampleSize = hn.pr(iPr, iPr, options);
                                    options.inJustDecodeBounds = false;
                                    hn.this.hn.put(Integer.valueOf(i), BitmapFactory.decodeStream(byteArrayInputStream2, null, options));
                                    uc.pr(inputStreamPr, byteArrayOutputStreamHw, byteArrayInputStream, byteArrayInputStream2);
                                    return;
                                } catch (Exception e) {
                                    inputStream = inputStreamPr;
                                    uc.pr(inputStream, byteArrayOutputStreamHw, byteArrayInputStream, byteArrayInputStream2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    uc.pr(inputStreamPr, byteArrayOutputStreamHw, byteArrayInputStream, byteArrayInputStream2);
                                    throw th;
                                }
                            } catch (Exception e2) {
                                byteArrayInputStream2 = null;
                            } catch (Throwable th3) {
                                byteArrayInputStream2 = null;
                                th = th3;
                            }
                        } catch (Exception e3) {
                            byteArrayInputStream = null;
                            byteArrayInputStream2 = byteArrayInputStream;
                            inputStream = inputStreamPr;
                            uc.pr(inputStream, byteArrayOutputStreamHw, byteArrayInputStream, byteArrayInputStream2);
                        } catch (Throwable th4) {
                            byteArrayInputStream2 = null;
                            th = th4;
                            byteArrayInputStream = null;
                        }
                    } catch (Exception e4) {
                        byteArrayOutputStreamHw = null;
                        byteArrayInputStream = null;
                    } catch (Throwable th5) {
                        byteArrayInputStream = null;
                        byteArrayInputStream2 = null;
                        th = th5;
                        byteArrayOutputStreamHw = null;
                    }
                } catch (Exception e5) {
                    byteArrayOutputStreamHw = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                } catch (Throwable th6) {
                    byteArrayOutputStreamHw = null;
                    byteArrayInputStream = null;
                    byteArrayInputStream2 = null;
                    th = th6;
                    inputStreamPr = null;
                }
                uc.pr(inputStream, byteArrayOutputStreamHw, byteArrayInputStream, byteArrayInputStream2);
            }
        });
    }

    public static int pr(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteArrayOutputStream hw(InputStream inputStream) throws IOException {
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
