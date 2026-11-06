package com.byazt.xqu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.byazt.edb.aj;
import com.byazt.eld.k;
import com.byazt.uk.m;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 432, 121})
public class x extends com.byazt.tuy.zo<Long, Bitmap> {
    public final Map<Long, SoftReference<pr>> pr;

    public interface pr {
        void pr(Bitmap bitmap);
    }

    @com.byazt.vzx.pr(pr = {0, 1, 432, 759})
    private static class hw {
        public static x pr = new x();
    }

    public static x pr() {
        return hw.pr;
    }

    private x() {
        super(8, 8);
        this.pr = new HashMap();
    }

    public void pr(long j, pr prVar) {
        if (get(Long.valueOf(j)) != null) {
            prVar.pr((Bitmap) get(Long.valueOf(j)));
        } else {
            this.pr.put(Long.valueOf(j), new SoftReference<>(prVar));
        }
    }

    public void pr(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<pr> softReferenceRemove = this.pr.remove(Long.valueOf(j));
            if (softReferenceRemove != null && softReferenceRemove.get() != null) {
                softReferenceRemove.get().pr((Bitmap) get(Long.valueOf(j)));
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            fw.pr(12, j2);
        } else {
            com.byazt.uk.hn.pr((com.byazt.uk.hn.pr<Object, R>) new com.byazt.uk.hn.pr<Object, Object>() { // from class: com.byazt.xqu.x.2
                @Override // com.byazt.uk.hn.pr
                public Object pr(Object obj) throws Throwable {
                    Throwable th;
                    BufferedInputStream bufferedInputStream;
                    try {
                        try {
                            aj ajVarPr = com.byazt.lj.hn.pr(true, 0, str, null);
                            if (ajVarPr == null) {
                                com.byazt.tuy.uc.pr(null);
                                return null;
                            }
                            bufferedInputStream = new BufferedInputStream(ajVarPr.pr());
                            try {
                                bufferedInputStream.mark(bufferedInputStream.available());
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                int i = options.outWidth;
                                int i2 = options.outHeight;
                                int iPr = m.pr(k.getContext(), 60.0f);
                                options.inSampleSize = x.hw(iPr, iPr, options);
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
                                }
                                com.byazt.mf.pr.pr().pr("ttd_pref_monitor", jSONObject, j2);
                                x.this.put(Long.valueOf(j), bitmapDecodeStream);
                                com.byazt.tuy.uc.pr(bufferedInputStream);
                            } catch (Exception e2) {
                                e = e2;
                                com.byazt.vi.hn.pr().pr(e, "BitmapCache loadBitmap");
                                com.byazt.tuy.uc.pr(bufferedInputStream);
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            com.byazt.tuy.uc.pr(null);
                            throw th;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        com.byazt.tuy.uc.pr(null);
                        throw th;
                    }
                    com.byazt.vi.hn.pr().pr(e, "BitmapCache loadBitmap");
                    com.byazt.tuy.uc.pr(bufferedInputStream);
                    return null;
                }
            }, (Object) null).pr(new com.byazt.uk.hn.pr<Object, Object>() { // from class: com.byazt.xqu.x.1
                @Override // com.byazt.uk.hn.pr
                public Object pr(Object obj) {
                    SoftReference softReference = (SoftReference) x.this.pr.remove(Long.valueOf(j));
                    if (softReference != null && softReference.get() != null) {
                        ((pr) softReference.get()).pr((Bitmap) x.this.get(Long.valueOf(j)));
                        return null;
                    }
                    return null;
                }
            }).pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hw(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
