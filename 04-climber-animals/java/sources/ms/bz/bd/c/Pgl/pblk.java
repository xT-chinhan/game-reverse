package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.ch.d.ah;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
public final class pblk {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final pblb f4850ms;

    public interface pblb {
        void ms(String str);
    }

    final class pgla implements Runnable {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        final /* synthetic */ Context f4851ms;

        pgla(Context context) {
            this.f4851ms = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "80f62a", new byte[]{8, 1, 32, 113})).equals(pblk.ms(pblk.this).toUpperCase())) {
                    new ms.bz.bd.c.Pgl.pgla(this.f4851ms).ms(pblk.this.f4850ms);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e68e89", new byte[]{92, 1, 106, 38, 34, 7})).equals(pblk.ms(pblk.this).toUpperCase())) {
                    new pblo(this.f4851ms).ms(pblk.this.f4850ms);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e5274", new byte[]{11, 87, 118, 105})).equals(pblk.ms(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5db0bb", new byte[]{11, 72, 52, 116, 113, com.anythink.core.common.s.a.c.b, 5})).equals(pblk.ms(pblk.this).toUpperCase())) {
                    b1 b1Var = new b1(this.f4851ms);
                    b1Var.ms(pblk.this.f4850ms);
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f39c4c", new byte[]{77, 5, 111})).equals(pblk.ms(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9d25fb", new byte[]{ek.l, 67, 115, 115, 116, 80, 21, 118})).equals(pblk.ms(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.ms() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f4492a", new byte[]{68, 5, 114, 100})).equals(pblk.ms(pblk.this).toUpperCase())) {
                    return;
                }
                pblk.this.getClass();
                if (pblk.xr() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d3d5c3", new byte[]{70, ek.n, 58, 114, 105, 10, com.anythink.core.common.s.a.c.b})).equals(pblk.ms(pblk.this).toUpperCase())) {
                    return;
                }
                if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "881b12", new byte[]{5, 31, 108, 57, 56, 10})).equals(pblk.ms(pblk.this).toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1a34fb", new byte[]{ek.k, 76, 116, 111, 117, 90, 0, 97})).equals(pblk.ms(pblk.this).toUpperCase())) {
                    pbls pblsVar = new pbls(this.f4851ms);
                    pblsVar.ms(pblk.this.f4850ms);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public pblk(pblb pblbVar) {
        this.f4850ms = pblbVar;
    }

    private static String ms(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bcb4d1", new byte[]{114, 111, 21, 82, 84, 47, 101, 12, 60, 119, 61, 82, 8, 83, 79, 35, 108, 114, 33, 107, 99, 100, 3, 84, 82, 35, 114}));
            return (String) cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1c2028", new byte[]{39, 100, 85}), String.class, String.class).invoke(cls, str, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dfaf68", new byte[]{96, 106, 25, 28, 6, 56, 105}));
        } catch (Exception unused) {
            return null;
        }
    }

    static String ms(pblk pblkVar) {
        pblkVar.getClass();
        return Build.MANUFACTURER.toUpperCase();
    }

    public static boolean ms() {
        String strMs = ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f9327d", new byte[]{101, 52, ek.l, 68, 29, 122, 105, 28, 44, 100, 101, 62, 69, 75, ek.k, 61, 105, 25, 96, 103, 123}));
        return !TextUtils.isEmpty(strMs) && strMs.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8cb3fe", new byte[]{ek.m, 83, 52, 98, 116, 87, 20, 113}));
    }

    private void xr(Context context) {
        new ah(new pgla(context), "bd/c/Pgl/pblk").start();
    }

    public static boolean xr() {
        String strMs = ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d5769c", new byte[]{103, 56, 10, 81, 21, 97, 110, 90, 118, 116, 122, 51, 81, 65, 18}));
        return (TextUtils.isEmpty(strMs) || strMs.equalsIgnoreCase((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a55d80", new byte[]{101, 57, 77, 30, 8, 48, 108}))) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x023e  */
    public final void ms(Context context) {
        String strMs;
        String str = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "aa741b", new byte[]{81, 80, 113, 115});
        String str2 = Build.MANUFACTURER;
        if (str.equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f3838d", new byte[]{95, 4, 106, 112, 34, 90})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "91e11a", new byte[]{4, 22, 56, 106, 56, 89})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2b0de3", new byte[]{ek.l, 79, 119, com.anythink.core.common.s.a.c.c, 118, 11, 3, 98})).equals(str2.toUpperCase().toUpperCase())) {
            xr(context);
            strMs = null;
        } else {
            if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6584d9", new byte[]{10, 18, 98, 122, 110})).equals(str2.toUpperCase().toUpperCase())) {
                new x0(context).ms(this.f4850ms);
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6b67b7", new byte[]{9, 85, 103, 106, 124})).equals(str2.toUpperCase().toUpperCase())) {
                strMs = new z0(context).ms();
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e30e54", new byte[]{91, 1, 115, 62})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "96c46e", new byte[]{27, 21, 61, 115, 60, 92, 29})).equals(str2.toUpperCase().toUpperCase())) {
                xr(context);
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "884689", new byte[]{31, 19, 113, 109})).equals(str2.toUpperCase().toUpperCase())) {
                strMs = new u1(context).ms();
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a6a6f3", new byte[]{72, 29, 51, 109, 116, ek.k})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "09588a", new byte[]{3, 23, 103, 111, 44, 69, 27, 57, 86, 67})).equals(str2.toUpperCase().toUpperCase())) {
                strMs = new v1(context).ms();
            } else if (((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1991c5", new byte[]{ek.m, 21, 111, 117, 112, 23, 1})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4d5b09", new byte[]{31, 82, 99})).equals(str2.toUpperCase().toUpperCase()) || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3ed781", new byte[]{4, 66, 37, 113, 42, 3, 31, 119})).equals(str2.toUpperCase().toUpperCase()) || ms() || ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9f0134", new byte[]{27, 87, 118, 108})).equals(str2.toUpperCase().toUpperCase()) || xr()) {
                xr(context);
            }
            strMs = null;
        }
        pblb pblbVar = this.f4850ms;
        if (pblbVar != null) {
            pblbVar.ms(strMs);
        }
    }
}
