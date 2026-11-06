package com.byazt.su;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.byazt.m.rv;
import com.byazt.rz.oa;
import com.byazt.ug.d;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 726, 5})
public class q extends com.byazt.ta.fs<Long, Bitmap> {
    public final Map<Long, SoftReference<n>> n;

    public interface n {
        void n(Bitmap bitmap);
    }

    @com.byazt.cp.n(n = {0, 1, 726, 524})
    private static class qg {
        public static q n = new q();
    }

    public static q n() {
        return qg.n;
    }

    private q() {
        super(8, 8);
        this.n = new HashMap();
    }

    public void n(long j, n nVar) {
        if (get(Long.valueOf(j)) != null) {
            nVar.n((Bitmap) get(Long.valueOf(j)));
        } else {
            this.n.put(Long.valueOf(j), new SoftReference<>(nVar));
        }
    }

    public void n(final long j, final long j2, final String str) {
        if (get(Long.valueOf(j)) != null) {
            SoftReference<n> softReferenceRemove = this.n.remove(Long.valueOf(j));
            if (softReferenceRemove == null || softReferenceRemove.get() == null) {
                return;
            }
            softReferenceRemove.get().n((Bitmap) get(Long.valueOf(j)));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            x.n(12, j2);
        } else {
            com.byazt.rz.s.n((com.byazt.rz.s.n<Object, R>) new com.byazt.rz.s.n<Object, Object>() { // from class: com.byazt.su.q.2
                @Override // com.byazt.rz.s.n
                public Object n(Object obj) throws Throwable {
                    Throwable th;
                    BufferedInputStream bufferedInputStream;
                    try {
                        try {
                            rv rvVarN = com.byazt.xv.s.n(true, 0, str, null);
                            if (rvVarN != null) {
                                bufferedInputStream = new BufferedInputStream(rvVarN.n());
                                try {
                                    bufferedInputStream.mark(bufferedInputStream.available());
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                    int i = options.outWidth;
                                    int i2 = options.outHeight;
                                    int iN = oa.n(d.getContext(), 60.0f);
                                    options.inSampleSize = q.qg(iN, iN, options);
                                    options.inJustDecodeBounds = false;
                                    bufferedInputStream.reset();
                                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                                        jSONObject.putOpt("bm_original_w", Integer.valueOf(i));
                                        jSONObject.putOpt("bm_original_h", Integer.valueOf(i2));
                                        jSONObject.putOpt("bm_bytes", Integer.valueOf(bitmapDecodeStream == null ? -1 : bitmapDecodeStream.getByteCount()));
                                    } catch (Exception unused) {
                                    }
                                    com.byazt.vj.n.n().n("ttd_pref_monitor", jSONObject, j2);
                                    q.this.put(Long.valueOf(j), bitmapDecodeStream);
                                    com.byazt.ta.w.n(bufferedInputStream);
                                } catch (Exception e) {
                                    e = e;
                                    com.byazt.ch.s.n().n(e, "BitmapCache loadBitmap");
                                    com.byazt.ta.w.n(bufferedInputStream);
                                }
                                return null;
                            }
                            com.byazt.ta.w.n(null);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            com.byazt.ta.w.n(null);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        com.byazt.ta.w.n(null);
                        throw th;
                    }
                    com.byazt.ch.s.n().n(e, "BitmapCache loadBitmap");
                    com.byazt.ta.w.n(bufferedInputStream);
                    return null;
                }
            }, (Object) null).n(new com.byazt.rz.s.n<Object, Object>() { // from class: com.byazt.su.q.1
                @Override // com.byazt.rz.s.n
                public Object n(Object obj) {
                    SoftReference softReference = (SoftReference) q.this.n.remove(Long.valueOf(j));
                    if (softReference == null || softReference.get() == null) {
                        return null;
                    }
                    ((n) softReference.get()).n((Bitmap) q.this.get(Long.valueOf(j)));
                    return null;
                }
            }).n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int qg(int i, int i2, BitmapFactory.Options options) {
        if (options.outWidth > i || options.outHeight > i2) {
            return Math.min(Math.round(options.outWidth / i), Math.round(options.outHeight / i2));
        }
        return 1;
    }
}
