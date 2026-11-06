package com.byazt.gu;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.aa.aj;
import com.byazt.aa.zo;
import com.byazt.ch.ho;
import com.byazt.dd.g;
import com.byazt.dd.k;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 665, 121})
public class x {
    public static void pr(of ofVar, ho hoVar, int i, AtomicBoolean atomicBoolean) {
        if (ofVar == null || hoVar == null || i != 1) {
            return;
        }
        JSONObject jSONObjectG = ie.g(ofVar);
        int iOptInt = 0;
        if (jSONObjectG != null) {
            try {
                iOptInt = jSONObjectG.optInt("tap_min_duration_threshold", 0);
            } catch (Exception e) {
            }
        }
        if (iOptInt <= 0) {
            return;
        }
        hoVar.pr(new hw(iOptInt, atomicBoolean));
    }

    @com.byazt.vzx.pr(pr = {0, 1, 665, 759})
    public static class hw implements aj.pr, com.byazt.dd.ho {
        public final Handler aj = new aj(Looper.getMainLooper(), this);
        public com.byazt.ik.hn c;
        public k fw;
        public boolean hn;
        public float hw;
        public float pr;
        public com.byazt.xv.hw uc;
        public final int x;
        public final AtomicBoolean zo;

        public hw(int i, AtomicBoolean atomicBoolean) {
            this.x = i;
            this.zo = atomicBoolean;
        }

        @Override // com.byazt.dd.ho
        public boolean pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent, k kVar, com.byazt.xv.hw hwVar) {
            boolean z;
            com.byazt.dd.fw fwVarW = hwVar.w();
            if (fwVarW != null && !fwVarW.hw().isEmpty()) {
                Iterator<com.byazt.dd.fw.pr> it = fwVarW.hw().iterator();
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next().hw(), "convert")) {
                        z = true;
                    }
                }
                z = false;
            } else {
                z = false;
            }
            return pr(hnVar, motionEvent, hwVar, kVar, z);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:15:0x0050  */
        /* JADX WARN: Code duplicated, block: B:17:0x005f  */
        /* JADX WARN: Code duplicated, block: B:19:0x0066  */
        public boolean pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent, com.byazt.xv.hw hwVar, k kVar, boolean z) {
            int i;
            float rawX;
            switch (motionEvent.getAction()) {
                case 0:
                    this.zo.set(false);
                    this.pr = motionEvent.getRawX();
                    this.hw = motionEvent.getRawY();
                    this.c = hnVar;
                    this.uc = hwVar;
                    this.fw = kVar;
                    if (z && (i = this.x) > 0) {
                        this.aj.sendEmptyMessageDelayed(1, i);
                    }
                    return true;
                case 1:
                    this.aj.removeMessages(1);
                    this.c = null;
                    this.uc = null;
                    this.fw = null;
                    if (this.hn) {
                        this.hn = false;
                        this.pr = 0.0f;
                        this.hw = 0.0f;
                        return false;
                    }
                    rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    if (Math.abs(rawX - this.pr) < 15.0f || Math.abs(rawY - this.hw) >= 15.0f) {
                        this.hn = false;
                        return false;
                    }
                    if (!this.zo.get()) {
                        this.zo.set(true);
                        if (kVar != null) {
                            kVar.pr(hnVar, hwVar.fw(), hwVar.w().hw(), this.uc.w());
                            this.pr = 0.0f;
                            this.hw = 0.0f;
                            return true;
                        }
                    }
                    return true;
                case 2:
                    float rawX2 = motionEvent.getRawX();
                    float rawY2 = motionEvent.getRawY();
                    if (Math.abs(rawX2 - this.pr) >= 15.0f || Math.abs(rawY2 - this.hw) >= 15.0f) {
                        this.hn = true;
                    }
                    return true;
                case 3:
                    this.hn = false;
                    float rawX3 = motionEvent.getRawX();
                    if (motionEvent.getRawY() == 0.0f && rawX3 == 0.0f) {
                        this.aj.removeMessages(1);
                        this.c = null;
                        this.uc = null;
                        this.fw = null;
                    } else {
                        this.aj.removeMessages(1);
                        this.c = null;
                        this.uc = null;
                        this.fw = null;
                        if (this.hn) {
                            this.hn = false;
                            this.pr = 0.0f;
                            this.hw = 0.0f;
                            return false;
                        }
                        rawX = motionEvent.getRawX();
                        float rawY3 = motionEvent.getRawY();
                        if (Math.abs(rawX - this.pr) < 15.0f) {
                            break;
                        }
                        this.hn = false;
                        return false;
                    }
                    return true;
                default:
                    return true;
            }
        }

        @Override // com.byazt.aa.aj.pr
        public void pr(Message message) {
            if (this.fw != null && this.c != null && this.uc != null && !this.hn) {
                if (!this.zo.get()) {
                    this.zo.set(true);
                    this.fw.pr(this.c, this.uc.fw(), this.uc.w().hw(), this.uc.w());
                }
                this.c = null;
                this.uc = null;
                this.fw = null;
            }
        }
    }

    public static void pr(of ofVar, ho hoVar, int i, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2) {
        int iOptInt;
        int i2;
        boolean zXd;
        int i3;
        if (ofVar == null || hoVar == null) {
            return;
        }
        JSONObject jSONObjectG = ie.g(ofVar);
        int i4 = -1;
        if (jSONObjectG != null && i == 1) {
            try {
                int iOptInt2 = jSONObjectG.optInt("slide_ignore_up", -1);
                try {
                    iOptInt = jSONObjectG.optInt("slide_min_threshold", -1);
                    i4 = iOptInt2;
                } catch (Exception e) {
                    iOptInt = -1;
                    i4 = iOptInt2;
                    i2 = iOptInt;
                    zXd = false;
                    i3 = i4;
                    hoVar.pr(new pr(i3, i2, zXd, atomicBoolean, atomicBoolean2));
                }
            } catch (Exception e2) {
                iOptInt = -1;
            }
        } else {
            iOptInt = -1;
        }
        try {
            i2 = iOptInt;
            zXd = a.hw().xd();
            i3 = i4;
        } catch (Exception e3) {
            i2 = iOptInt;
            zXd = false;
            i3 = i4;
        }
        hoVar.pr(new pr(i3, i2, zXd, atomicBoolean, atomicBoolean2));
    }

    @com.byazt.vzx.pr(pr = {0, 1, 665, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
    public static class pr implements g {
        public int fw;
        public final AtomicBoolean hn;
        public float hw;
        public float pr;
        public int uc;
        public final AtomicBoolean x;
        public boolean zo;
        public final Map<String, hn> c = new HashMap();
        public boolean aj = true;

        /* JADX INFO: renamed from: com.byazt.gu.x$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 665, 1355})
        private static class C0080pr {
            public final boolean c;
            public final int hn;
            public final AtomicInteger hw;
            public final int pr;
            public final String x;

            public C0080pr(String str, int i, AtomicInteger atomicInteger, int i2, boolean z) {
                this.x = str;
                this.pr = i;
                this.hw = atomicInteger;
                this.hn = i2;
                this.c = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int pr() {
                return this.pr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public AtomicInteger hw() {
                return this.hw;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int hn() {
                return this.hn;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String x() {
                return this.x;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c() {
                return this.c;
            }
        }

        @com.byazt.vzx.pr(pr = {0, 1, 665, 1887})
        private static class hn {
            public boolean hn;
            public float hw;
            public float pr;

            private hn() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void pr(float f, float f2) {
                this.pr = f;
                this.hw = f2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public float pr() {
                return this.pr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public float hw() {
                return this.hw;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean hn() {
                return this.hn;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void x() {
                this.hn = true;
            }
        }

        @com.byazt.vzx.pr(pr = {0, 1, 665, 1895})
        private static class hw {
            public final boolean c;
            public final com.byazt.xv.hw hn;
            public final MotionEvent hw;
            public final com.byazt.ik.hn pr;
            public final C0080pr uc;
            public final k x;

            public hw(com.byazt.ik.hn hnVar, MotionEvent motionEvent, com.byazt.xv.hw hwVar, k kVar, boolean z, C0080pr c0080pr) {
                this.pr = hnVar;
                this.hw = motionEvent;
                this.hn = hwVar;
                this.x = kVar;
                this.c = z;
                this.uc = c0080pr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public com.byazt.ik.hn pr() {
                return this.pr;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public MotionEvent hw() {
                return this.hw;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public com.byazt.xv.hw hn() {
                return this.hn;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public k x() {
                return this.x;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean c() {
                return this.c;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public C0080pr uc() {
                return this.uc;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean fw() {
                return this.x != null;
            }
        }

        public pr(int i, int i2, boolean z, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2) {
            this.uc = 0;
            this.fw = -1;
            this.uc = i;
            this.fw = i2;
            this.zo = z;
            this.hn = atomicBoolean;
            this.x = atomicBoolean2;
        }

        @Override // com.byazt.dd.g
        public void pr(String str, Object obj) {
            try {
                switch (str) {
                    case "lastEventInView":
                        this.aj = ((Boolean) obj).booleanValue();
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
            }
        }

        @Override // com.byazt.dd.g
        public boolean pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent, k kVar, com.byazt.xv.hw hwVar, String str, int i, AtomicInteger atomicInteger, int i2, boolean z) {
            boolean z2;
            C0080pr c0080pr = new C0080pr(str, i, atomicInteger, i2, z);
            com.byazt.dd.fw fwVarW = hwVar.w();
            if (fwVarW != null && !fwVarW.hw().isEmpty()) {
                Iterator<com.byazt.dd.fw.pr> it = fwVarW.hw().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals(it.next().hw(), "convert")) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            return pr(new hw(hnVar, motionEvent, hwVar, kVar, z2 && this.uc == 1, c0080pr));
        }

        private String pr(int i, com.byazt.xv.hw hwVar) {
            return i + "_" + System.identityHashCode(hwVar);
        }

        private boolean hw(hw hwVar) {
            MotionEvent motionEventHw = hwVar.hw();
            int actionMasked = motionEventHw.getActionMasked();
            int actionIndex = motionEventHw.getActionIndex();
            int pointerId = motionEventHw.getPointerId(actionIndex);
            String strPr = pr(pointerId, hwVar.hn());
            motionEventHw.getPointerCount();
            switch (actionMasked) {
                case 0:
                    this.hn.set(false);
                    break;
                case 1:
                case 6:
                    return pr(hwVar, actionIndex, pointerId, strPr);
                case 2:
                    return hn(hwVar);
                case 3:
                    if (a.hw().xh() && hw(motionEventHw)) {
                        fw(hwVar);
                    }
                    this.c.clear();
                    return true;
                case 4:
                default:
                    return true;
                case 5:
                    break;
            }
            pr(motionEventHw, actionIndex, strPr);
            return true;
        }

        private void pr(MotionEvent motionEvent, int i, String str) {
            hn hnVar = new hn();
            hnVar.pr(motionEvent.getX(i), motionEvent.getY(i));
            this.c.put(str, hnVar);
        }

        private boolean hn(hw hwVar) {
            MotionEvent motionEventHw = hwVar.hw();
            for (int i = 0; i < motionEventHw.getPointerCount(); i++) {
                int pointerId = motionEventHw.getPointerId(i);
                hn hnVar = this.c.get(pr(pointerId, hwVar.hn()));
                if (pr(hwVar, hnVar) && pr(hwVar, hnVar, pointerId, i)) {
                    return true;
                }
            }
            return true;
        }

        private boolean pr(hw hwVar, hn hnVar) {
            return (!hwVar.c() || hnVar == null || hnVar.hn() || this.hn.get()) ? false : true;
        }

        private boolean pr(hw hwVar, hn hnVar, int i, int i2) {
            MotionEvent motionEventHw = hwVar.hw();
            float x = motionEventHw.getX(i2);
            float y = motionEventHw.getY(i2);
            if (!pr(x, y, hnVar.pr(), hnVar.hw(), hwVar.uc())) {
                return false;
            }
            hnVar.x();
            return hwVar.fw() && pr(hwVar, x, y);
        }

        private boolean pr(hw hwVar, int i, int i2, String str) {
            MotionEvent motionEventHw = hwVar.hw();
            hn hnVar = this.c.get(str);
            if (hnVar == null) {
                this.c.remove(str);
                return false;
            }
            try {
                if (!hnVar.hn() && !this.hn.get()) {
                    float x = motionEventHw.getX(i);
                    float y = motionEventHw.getY(i);
                    if (hwVar.uc().pr() == 0 && pr(hwVar, hnVar, x, y, "Slide event for pointer " + i2 + ", check limit threshold 0")) {
                        this.c.remove(str);
                        return true;
                    }
                    if (!pr(x, y, hnVar.pr(), hnVar.hw(), hwVar.uc())) {
                        this.c.remove(str);
                        return false;
                    }
                    if (pr(hwVar, hnVar, x, y, (String) null)) {
                        this.c.remove(str);
                        return true;
                    }
                    this.c.remove(str);
                    return true;
                }
                this.c.remove(str);
                return true;
            } catch (Throwable th) {
                this.c.remove(str);
                throw th;
            }
        }

        private boolean pr(hw hwVar, hn hnVar, float f, float f2, String str) {
            if (!hwVar.fw() || hnVar.hn() || this.hn.get()) {
                return false;
            }
            TextUtils.isEmpty(str);
            hnVar.x();
            return pr(hwVar, f, f2);
        }

        private boolean x(hw hwVar) {
            MotionEvent motionEventHw = hwVar.hw();
            switch (motionEventHw.getAction()) {
                case 0:
                    return pr(motionEventHw);
                case 1:
                    break;
                case 2:
                    return c(hwVar);
                case 3:
                    if (hw(motionEventHw)) {
                        if (a.hw().xh()) {
                            uc(hwVar);
                        }
                        return true;
                    }
                    break;
                default:
                    return true;
            }
            return zo(hwVar);
        }

        private boolean pr(MotionEvent motionEvent) {
            this.hn.set(false);
            this.pr = motionEvent.getX();
            this.hw = motionEvent.getY();
            return true;
        }

        private boolean c(hw hwVar) {
            if (!hwVar.c() || this.hn.get()) {
                return true;
            }
            MotionEvent motionEventHw = hwVar.hw();
            float x = motionEventHw.getX();
            float y = motionEventHw.getY();
            if (!pr(x, y, this.pr, this.hw, hwVar.uc()) || !hwVar.fw()) {
                return true;
            }
            pr();
            return pr(hwVar, x, y);
        }

        private boolean hw(MotionEvent motionEvent) {
            return motionEvent.getRawY() == 0.0f && motionEvent.getRawX() == 0.0f;
        }

        private void uc(hw hwVar) {
            if (!this.hn.get() && hwVar.fw() && pr(0.0f, 0.0f, this.pr, this.hw, hwVar.uc)) {
                this.hn.set(true);
                AtomicBoolean atomicBoolean = this.x;
                if (atomicBoolean != null) {
                    atomicBoolean.set(true);
                }
                hwVar.x().pr(hwVar.pr(), hwVar.hn().fw(), hwVar.hn().w().hw(), hwVar.hn().w());
                pr();
            }
        }

        private void fw(hw hwVar) {
            if (this.hn.get() || !hwVar.fw()) {
                return;
            }
            for (hn hnVar : this.c.values()) {
                if (hnVar != null && !hnVar.hn() && pr(0.0f, 0.0f, hnVar.pr(), hnVar.hw(), hwVar.uc)) {
                    hnVar.x();
                    this.hn.set(true);
                    AtomicBoolean atomicBoolean = this.x;
                    if (atomicBoolean != null) {
                        atomicBoolean.set(true);
                    }
                    hwVar.x().pr(hwVar.pr(), hwVar.hn().fw(), hwVar.hn().w().hw(), hwVar.hn().w());
                    return;
                }
            }
        }

        private boolean zo(hw hwVar) {
            if (this.hn.get()) {
                return true;
            }
            MotionEvent motionEventHw = hwVar.hw();
            float x = motionEventHw.getX();
            float y = motionEventHw.getY();
            if (hwVar.uc().pr() == 0 && pr(hwVar, x, y, "Slide event, check limit threshold 0")) {
                return true;
            }
            if (!pr(x, y, this.pr, this.hw, hwVar.uc())) {
                return false;
            }
            pr(hwVar, x, y, (String) null);
            return true;
        }

        private boolean pr(hw hwVar, float f, float f2, String str) {
            if (!hwVar.fw() || this.hn.get()) {
                return false;
            }
            TextUtils.isEmpty(str);
            pr();
            return pr(hwVar, f, f2);
        }

        private void pr() {
            this.pr = 0.0f;
            this.hw = 0.0f;
        }

        public boolean pr(hw hwVar) {
            if (this.zo) {
                return hw(hwVar);
            }
            return x(hwVar);
        }

        private boolean pr(View view, float f, float f2) {
            return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
        }

        private boolean pr(hw hwVar, float f, float f2) {
            C0080pr c0080prUc = hwVar.uc();
            AtomicInteger atomicIntegerHw = c0080prUc.hw();
            if ((atomicIntegerHw == null || atomicIntegerHw.get() > 0) && c0080prUc.c()) {
                if (c0080prUc.hn() == 1 && (!pr(hwVar.pr().aj(), f, f2) || !this.aj)) {
                    return false;
                }
                this.hn.set(true);
                hwVar.x().pr(hwVar.pr(), hwVar.hn().fw(), hwVar.hn().w().hw(), hwVar.hn().w());
                if (atomicIntegerHw != null && atomicIntegerHw.get() != Integer.MAX_VALUE) {
                    atomicIntegerHw.decrementAndGet();
                }
                return true;
            }
            return false;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:20:0x0052  */
        private boolean pr(float f, float f2, float f3, float f4, C0080pr c0080pr) {
            int iHw = zo.hw(a.getContext(), f - f3);
            int iHw2 = zo.hw(a.getContext(), f2 - f4);
            switch (c0080pr.x()) {
                case "up":
                    iHw = -iHw2;
                    break;
                case "down":
                    iHw = iHw2;
                    break;
                case "left":
                    iHw = -iHw;
                    break;
                case "right":
                    break;
                case "all":
                default:
                    iHw = (int) Math.abs(Math.sqrt(Math.pow(iHw, 2.0d) + Math.pow(iHw2, 2.0d)));
                    break;
            }
            int i = this.fw;
            if (i >= 0) {
                return iHw >= i;
            }
            return iHw >= c0080pr.pr();
        }
    }
}
