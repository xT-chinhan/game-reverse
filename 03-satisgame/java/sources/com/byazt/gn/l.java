package com.byazt.gn;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.hb.rv;
import com.byazt.vh.k;
import com.byazt.xz.d;
import com.byazt.xz.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 18})
public class l {
    public static void n(pk pkVar, k kVar, int i, AtomicBoolean atomicBoolean) {
        if (pkVar == null || kVar == null || i != 1) {
            return;
        }
        JSONObject jSONObjectSz = nf.sz(pkVar);
        int iOptInt = 0;
        if (jSONObjectSz != null) {
            try {
                iOptInt = jSONObjectSz.optInt("tap_min_duration_threshold", 0);
            } catch (Exception unused) {
            }
        }
        if (iOptInt <= 0) {
            return;
        }
        kVar.n(new qg(iOptInt, atomicBoolean));
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 120})
    public static class qg implements com.byazt.xz.k, rv.n {
        public final AtomicBoolean fs;
        public com.byazt.ih.s l;
        public float n;
        public final int q;
        public float qg;
        public final Handler rv = new rv(Looper.getMainLooper(), this);
        public boolean s;
        public com.byazt.et.qg w;
        public d x;

        public qg(int i, AtomicBoolean atomicBoolean) {
            this.q = i;
            this.fs = atomicBoolean;
        }

        @Override // com.byazt.xz.k
        public boolean n(com.byazt.ih.s sVar, MotionEvent motionEvent, d dVar, com.byazt.et.qg qgVar) {
            boolean z;
            com.byazt.xz.x xVarCp = qgVar.cp();
            if (xVarCp == null || xVarCp.qg().isEmpty()) {
                z = false;
            } else {
                Iterator<com.byazt.xz.x.n> it = xVarCp.qg().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().qg(), "convert")) {
                        z = true;
                    }
                }
                z = false;
            }
            return n(sVar, motionEvent, qgVar, dVar, z);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x0057  */
        /* JADX WARN: Code duplicated, block: B:23:0x0066  */
        /* JADX WARN: Code duplicated, block: B:25:0x006d  */
        public boolean n(com.byazt.ih.s sVar, MotionEvent motionEvent, com.byazt.et.qg qgVar, d dVar, boolean z) {
            int i;
            float rawX;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.fs.set(false);
                this.n = motionEvent.getRawX();
                this.qg = motionEvent.getRawY();
                this.l = sVar;
                this.w = qgVar;
                this.x = dVar;
                if (z && (i = this.q) > 0) {
                    this.rv.sendEmptyMessageDelayed(1, i);
                }
            } else if (action == 1) {
                this.rv.removeMessages(1);
                this.l = null;
                this.w = null;
                this.x = null;
                if (this.s) {
                    this.s = false;
                    this.n = 0.0f;
                    this.qg = 0.0f;
                    return false;
                }
                rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.n) < 15.0f || Math.abs(rawY - this.qg) >= 15.0f) {
                    this.s = false;
                    return false;
                }
                if (!this.fs.get()) {
                    this.fs.set(true);
                    if (dVar != null) {
                        dVar.n(sVar, qgVar.x(), qgVar.cp().qg(), this.w.cp());
                        this.n = 0.0f;
                        this.qg = 0.0f;
                        return true;
                    }
                }
            } else if (action == 2) {
                float rawX2 = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                if (Math.abs(rawX2 - this.n) >= 15.0f || Math.abs(rawY2 - this.qg) >= 15.0f) {
                    this.s = true;
                }
            } else if (action == 3) {
                this.s = false;
                float rawX3 = motionEvent.getRawX();
                if (motionEvent.getRawY() == 0.0f && rawX3 == 0.0f) {
                    this.rv.removeMessages(1);
                    this.l = null;
                    this.w = null;
                    this.x = null;
                } else {
                    this.rv.removeMessages(1);
                    this.l = null;
                    this.w = null;
                    this.x = null;
                    if (this.s) {
                        this.s = false;
                        this.n = 0.0f;
                        this.qg = 0.0f;
                        return false;
                    }
                    rawX = motionEvent.getRawX();
                    float rawY3 = motionEvent.getRawY();
                    if (Math.abs(rawX - this.n) < 15.0f) {
                    }
                    this.s = false;
                    return false;
                }
            }
            return true;
        }

        @Override // com.byazt.hb.rv.n
        public void n(Message message) {
            if (this.x == null || this.l == null || this.w == null || this.s) {
                return;
            }
            if (!this.fs.get()) {
                this.fs.set(true);
                this.x.n(this.l, this.w.x(), this.w.cp().qg(), this.w.cp());
            }
            this.l = null;
            this.w = null;
            this.x = null;
        }
    }

    public static void n(pk pkVar, k kVar, int i, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2) {
        int iOptInt;
        boolean zKn;
        if (pkVar == null || kVar == null) {
            return;
        }
        JSONObject jSONObjectSz = nf.sz(pkVar);
        int i2 = -1;
        if (jSONObjectSz == null || i != 1) {
            iOptInt = -1;
        } else {
            try {
                int iOptInt2 = jSONObjectSz.optInt("slide_ignore_up", -1);
                try {
                    iOptInt = jSONObjectSz.optInt("slide_min_threshold", -1);
                    i2 = iOptInt2;
                } catch (Exception unused) {
                    iOptInt = -1;
                    i2 = iOptInt2;
                    zKn = false;
                    kVar.n(new n(i2, iOptInt, zKn, atomicBoolean, atomicBoolean2));
                }
            } catch (Exception unused2) {
                iOptInt = -1;
            }
        }
        try {
            zKn = com.byazt.nf.rv.qg().kn();
        } catch (Exception unused3) {
            zKn = false;
        }
        kVar.n(new n(i2, iOptInt, zKn, atomicBoolean, atomicBoolean2));
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class n implements sz {
        public boolean fs;
        public float n;
        public final AtomicBoolean q;
        public float qg;
        public final AtomicBoolean s;
        public int w;
        public int x;
        public final Map<String, s> l = new HashMap();
        public boolean rv = true;

        /* JADX INFO: renamed from: com.byazt.gn.l$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME})
        private static class C0181n {
            public final boolean l;
            public final int n;
            public final String q;
            public final AtomicInteger qg;
            public final int s;

            public C0181n(String str, int i, AtomicInteger atomicInteger, int i2, boolean z) {
                this.q = str;
                this.n = i;
                this.qg = atomicInteger;
                this.s = i2;
                this.l = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int n() {
                return this.n;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public AtomicInteger qg() {
                return this.qg;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int s() {
                return this.s;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String q() {
                return this.q;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean l() {
                return this.l;
            }
        }

        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES})
        private static class s {
            public float n;
            public float qg;
            public boolean s;

            private s() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void n(float f, float f2) {
                this.n = f;
                this.qg = f2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public float n() {
                return this.n;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public float qg() {
                return this.qg;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean s() {
                return this.s;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void q() {
                this.s = true;
            }
        }

        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 784})
        private static class qg {
            public final boolean l;
            public final com.byazt.ih.s n;
            public final d q;
            public final MotionEvent qg;
            public final com.byazt.et.qg s;
            public final C0181n w;

            public qg(com.byazt.ih.s sVar, MotionEvent motionEvent, com.byazt.et.qg qgVar, d dVar, boolean z, C0181n c0181n) {
                this.n = sVar;
                this.qg = motionEvent;
                this.s = qgVar;
                this.q = dVar;
                this.l = z;
                this.w = c0181n;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public com.byazt.ih.s n() {
                return this.n;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public MotionEvent qg() {
                return this.qg;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public com.byazt.et.qg s() {
                return this.s;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public d q() {
                return this.q;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean l() {
                return this.l;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public C0181n w() {
                return this.w;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean x() {
                return this.q != null;
            }
        }

        public n(int i, int i2, boolean z, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2) {
            this.w = i;
            this.x = i2;
            this.fs = z;
            this.s = atomicBoolean;
            this.q = atomicBoolean2;
        }

        @Override // com.byazt.xz.sz
        public void n(String str, Object obj) {
            try {
                if (((str.hashCode() == 2001723438 && str.equals("lastEventInView")) ? (byte) 0 : (byte) -1) != 0) {
                    return;
                }
                this.rv = ((Boolean) obj).booleanValue();
            } catch (Exception unused) {
            }
        }

        @Override // com.byazt.xz.sz
        public boolean n(com.byazt.ih.s sVar, MotionEvent motionEvent, d dVar, com.byazt.et.qg qgVar, String str, int i, AtomicInteger atomicInteger, int i2, boolean z) {
            boolean z2;
            C0181n c0181n = new C0181n(str, i, atomicInteger, i2, z);
            com.byazt.xz.x xVarCp = qgVar.cp();
            if (xVarCp != null && !xVarCp.qg().isEmpty()) {
                Iterator<com.byazt.xz.x.n> it = xVarCp.qg().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (TextUtils.equals(it.next().qg(), "convert")) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            return n(new qg(sVar, motionEvent, qgVar, dVar, z2 && this.w == 1, c0181n));
        }

        private String n(int i, com.byazt.et.qg qgVar) {
            return i + "_" + System.identityHashCode(qgVar);
        }

        private boolean qg(qg qgVar) {
            MotionEvent motionEventQg = qgVar.qg();
            int actionMasked = motionEventQg.getActionMasked();
            int actionIndex = motionEventQg.getActionIndex();
            int pointerId = motionEventQg.getPointerId(actionIndex);
            String strN = n(pointerId, qgVar.s());
            motionEventQg.getPointerCount();
            if (actionMasked == 0) {
                this.s.set(false);
            } else {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        return s(qgVar);
                    }
                    if (actionMasked == 3) {
                        if (com.byazt.nf.rv.qg().nm() && qg(motionEventQg)) {
                            x(qgVar);
                        }
                        this.l.clear();
                        return true;
                    }
                    if (actionMasked != 5) {
                        if (actionMasked != 6) {
                            return true;
                        }
                    }
                }
                return n(qgVar, actionIndex, pointerId, strN);
            }
            n(motionEventQg, actionIndex, strN);
            return true;
        }

        private void n(MotionEvent motionEvent, int i, String str) {
            s sVar = new s();
            sVar.n(motionEvent.getX(i), motionEvent.getY(i));
            this.l.put(str, sVar);
        }

        private boolean s(qg qgVar) {
            MotionEvent motionEventQg = qgVar.qg();
            for (int i = 0; i < motionEventQg.getPointerCount(); i++) {
                int pointerId = motionEventQg.getPointerId(i);
                s sVar = this.l.get(n(pointerId, qgVar.s()));
                if (n(qgVar, sVar) && n(qgVar, sVar, pointerId, i)) {
                    return true;
                }
            }
            return true;
        }

        private boolean n(qg qgVar, s sVar) {
            return (!qgVar.l() || sVar == null || sVar.s() || this.s.get()) ? false : true;
        }

        private boolean n(qg qgVar, s sVar, int i, int i2) {
            MotionEvent motionEventQg = qgVar.qg();
            float x = motionEventQg.getX(i2);
            float y = motionEventQg.getY(i2);
            if (!n(x, y, sVar.n(), sVar.qg(), qgVar.w())) {
                return false;
            }
            sVar.q();
            return qgVar.x() && n(qgVar, x, y);
        }

        private boolean n(qg qgVar, int i, int i2, String str) {
            MotionEvent motionEventQg = qgVar.qg();
            s sVar = this.l.get(str);
            if (sVar != null) {
                try {
                    if (!sVar.s() && !this.s.get()) {
                        float x = motionEventQg.getX(i);
                        float y = motionEventQg.getY(i);
                        if (qgVar.w().n() != 0 || !n(qgVar, sVar, x, y, "Slide event for pointer " + i2 + ", check limit threshold 0")) {
                            if (n(x, y, sVar.n(), sVar.qg(), qgVar.w())) {
                                n(qgVar, sVar, x, y, (String) null);
                            }
                        }
                    }
                    return true;
                } finally {
                    this.l.remove(str);
                }
            }
            return false;
        }

        private boolean n(qg qgVar, s sVar, float f, float f2, String str) {
            if (!qgVar.x() || sVar.s() || this.s.get()) {
                return false;
            }
            TextUtils.isEmpty(str);
            sVar.q();
            return n(qgVar, f, f2);
        }

        private boolean q(qg qgVar) {
            MotionEvent motionEventQg = qgVar.qg();
            int action = motionEventQg.getAction();
            if (action == 0) {
                return n(motionEventQg);
            }
            if (action != 1) {
                if (action == 2) {
                    return l(qgVar);
                }
                if (action != 3) {
                    return true;
                }
                if (qg(motionEventQg)) {
                    if (com.byazt.nf.rv.qg().nm()) {
                        w(qgVar);
                    }
                    return true;
                }
            }
            return fs(qgVar);
        }

        private boolean n(MotionEvent motionEvent) {
            this.s.set(false);
            this.n = motionEvent.getX();
            this.qg = motionEvent.getY();
            return true;
        }

        private boolean l(qg qgVar) {
            if (qgVar.l() && !this.s.get()) {
                MotionEvent motionEventQg = qgVar.qg();
                float x = motionEventQg.getX();
                float y = motionEventQg.getY();
                if (n(x, y, this.n, this.qg, qgVar.w()) && qgVar.x()) {
                    n();
                    return n(qgVar, x, y);
                }
            }
            return true;
        }

        private boolean qg(MotionEvent motionEvent) {
            return motionEvent.getRawY() == 0.0f && motionEvent.getRawX() == 0.0f;
        }

        private void w(qg qgVar) {
            if (!this.s.get() && qgVar.x() && n(0.0f, 0.0f, this.n, this.qg, qgVar.w)) {
                this.s.set(true);
                AtomicBoolean atomicBoolean = this.q;
                if (atomicBoolean != null) {
                    atomicBoolean.set(true);
                }
                qgVar.q().n(qgVar.n(), qgVar.s().x(), qgVar.s().cp().qg(), qgVar.s().cp());
                n();
            }
        }

        private void x(qg qgVar) {
            if (this.s.get() || !qgVar.x()) {
                return;
            }
            for (s sVar : this.l.values()) {
                if (sVar != null && !sVar.s() && n(0.0f, 0.0f, sVar.n(), sVar.qg(), qgVar.w)) {
                    sVar.q();
                    this.s.set(true);
                    AtomicBoolean atomicBoolean = this.q;
                    if (atomicBoolean != null) {
                        atomicBoolean.set(true);
                    }
                    qgVar.q().n(qgVar.n(), qgVar.s().x(), qgVar.s().cp().qg(), qgVar.s().cp());
                    return;
                }
            }
        }

        private boolean fs(qg qgVar) {
            if (this.s.get()) {
                return true;
            }
            MotionEvent motionEventQg = qgVar.qg();
            float x = motionEventQg.getX();
            float y = motionEventQg.getY();
            if (qgVar.w().n() == 0 && n(qgVar, x, y, "Slide event, check limit threshold 0")) {
                return true;
            }
            if (!n(x, y, this.n, this.qg, qgVar.w())) {
                return false;
            }
            n(qgVar, x, y, (String) null);
            return true;
        }

        private boolean n(qg qgVar, float f, float f2, String str) {
            if (!qgVar.x() || this.s.get()) {
                return false;
            }
            TextUtils.isEmpty(str);
            n();
            return n(qgVar, f, f2);
        }

        private void n() {
            this.n = 0.0f;
            this.qg = 0.0f;
        }

        public boolean n(qg qgVar) {
            if (this.fs) {
                return qg(qgVar);
            }
            return q(qgVar);
        }

        private boolean n(View view, float f, float f2) {
            return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
        }

        private boolean n(qg qgVar, float f, float f2) {
            C0181n c0181nW = qgVar.w();
            AtomicInteger atomicIntegerQg = c0181nW.qg();
            if ((atomicIntegerQg != null && atomicIntegerQg.get() <= 0) || !c0181nW.l()) {
                return false;
            }
            if (c0181nW.s() == 1 && (!n(qgVar.n().rv(), f, f2) || !this.rv)) {
                return false;
            }
            this.s.set(true);
            qgVar.q().n(qgVar.n(), qgVar.s().x(), qgVar.s().cp().qg(), qgVar.s().cp());
            if (atomicIntegerQg != null && atomicIntegerQg.get() != Integer.MAX_VALUE) {
                atomicIntegerQg.decrementAndGet();
            }
            return true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:20:0x0054  */
        private boolean n(float f, float f2, float f3, float f4, C0181n c0181n) {
            byte b;
            int iQg = com.byazt.hb.fs.qg(com.byazt.nf.rv.getContext(), f - f3);
            int iQg2 = com.byazt.hb.fs.qg(com.byazt.nf.rv.getContext(), f2 - f4);
            switch (c0181n.q()) {
                case "up":
                    b = 0;
                    break;
                case "all":
                    b = 4;
                    break;
                case "down":
                    b = 1;
                    break;
                case "left":
                    b = 2;
                    break;
                case "right":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                iQg = -iQg2;
            } else if (b == 1) {
                iQg = iQg2;
            } else if (b == 2) {
                iQg = -iQg;
            } else if (b != 3) {
                iQg = (int) Math.abs(Math.sqrt(Math.pow(iQg, 2.0d) + Math.pow(iQg2, 2.0d)));
            }
            int i = this.x;
            if (i >= 0) {
                return iQg >= i;
            }
            return iQg >= c0181n.n();
        }
    }
}
