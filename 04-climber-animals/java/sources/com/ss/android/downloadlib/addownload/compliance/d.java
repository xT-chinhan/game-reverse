package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.ss.android.downloadlib.ab.zb;
import com.ss.android.downloadlib.addownload.hi;
import com.ss.android.socialbase.downloader.network.ny;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d extends com.ss.android.socialbase.downloader.ny.x<Long, Bitmap> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Map<Long, SoftReference<ms>> f4376ms;

    public interface ms {
        void ms(Bitmap bitmap);
    }

    private static class xr {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private static d f4379ms = new d();
    }

    public static d ms() {
        return xr.f4379ms;
    }

    private d() {
        super(8, 8);
        this.f4376ms = new HashMap();
    }

    public void ms(long j, ms msVar) {
        if (get(Long.valueOf(j)) != null) {
            msVar.ms((Bitmap) get(Long.valueOf(j)));
        } else {
            this.f4376ms.put(Long.valueOf(j), new SoftReference<>(msVar));
        }
    }

    public void ms(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<ms> softReferenceRemove = this.f4376ms.remove(Long.valueOf(j));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().ms((Bitmap) get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            ab.ms(12, j2);
        } else {
            com.ss.android.downloadlib.ab.ah.ms((com.ss.android.downloadlib.ab.ah.ms<Object, R>) new com.ss.android.downloadlib.ab.ah.ms<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.2
                @Override // com.ss.android.downloadlib.ab.ah.ms
                public Object ms(Object obj) throws Throwable {
                    BufferedInputStream bufferedInputStream;
                    Throwable th;
                    try {
                        ny nyVarMs = com.ss.android.socialbase.downloader.downloader.ah.ms(true, 0, str, null);
                        if (nyVarMs != null) {
                            bufferedInputStream = new BufferedInputStream(nyVarMs.ms());
                            try {
                                try {
                                    bufferedInputStream.mark(bufferedInputStream.available());
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                    int i = options.outWidth;
                                    int i2 = options.outHeight;
                                    int iMs = zb.ms(hi.getContext(), 60.0f);
                                    options.inSampleSize = d.xr(iMs, iMs, options);
                                    options.inJustDecodeBounds = false;
                                    bufferedInputStream.reset();
                                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                        jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                                    } catch (Exception e) {
                                        com.bytedance.sdk.openadsdk.api.ab.ms(e);
                                    }
                                    com.ss.android.downloadlib.d.ms.ms().ms("ttd_pref_monitor", jSONObject, j2);
                                    d.this.put(Long.valueOf(j), bitmapDecodeStream);
                                    com.ss.android.socialbase.downloader.ny.c.ms(bufferedInputStream);
                                } catch (Exception e2) {
                                    e = e2;
                                    com.ss.android.downloadlib.ka.ah.ms().ms(e, "BitmapCache loadBitmap");
                                    com.ss.android.socialbase.downloader.ny.c.ms(bufferedInputStream);
                                }
                                return null;
                            } catch (Throwable th2) {
                                th = th2;
                                com.ss.android.socialbase.downloader.ny.c.ms(bufferedInputStream);
                                throw th;
                            }
                        }
                        com.ss.android.socialbase.downloader.ny.c.ms(null);
                        return null;
                    } catch (Exception e3) {
                        e = e3;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        bufferedInputStream = null;
                        th = th3;
                        com.ss.android.socialbase.downloader.ny.c.ms(bufferedInputStream);
                        throw th;
                    }
                    com.ss.android.downloadlib.ka.ah.ms().ms(e, "BitmapCache loadBitmap");
                    com.ss.android.socialbase.downloader.ny.c.ms(bufferedInputStream);
                    return null;
                }
            }, (Object) null).ms(new com.ss.android.downloadlib.ab.ah.ms<Object, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.d.1
                @Override // com.ss.android.downloadlib.ab.ah.ms
                public Object ms(Object obj) {
                    SoftReference softReference = (SoftReference) d.this.f4376ms.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((ms) softReference.get()).ms((Bitmap) d.this.get(Long.valueOf(j)));
                    return null;
                }
            }).ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int xr(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
