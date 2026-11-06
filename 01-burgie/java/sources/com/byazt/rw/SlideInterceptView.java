package com.byazt.rw;

import android.content.Context;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.ca.iu;
import com.byazt.hg.pq;
import com.byazt.hg.vk;
import com.byazt.qx.c;
import com.byazt.sd.a;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET, 2105})
public class SlideInterceptView extends View implements qi.pr {
    public final pr aj;
    public float c;
    public boolean fw;
    public long hn;
    public float hw;
    public final Map<Integer, hw> k;
    public float pr;
    public float uc;
    public final com.byazt.qi.pr vk;
    public final iu w;
    public MotionEvent x;
    public final pq zo;

    public interface pr {
        c pr();

        void pr(View view, vk vkVar);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET, 1381})
    private static class hw {
        public float c;
        public MotionEvent fw;
        public long hn;
        public float hw;
        public float pr;
        public boolean uc = false;
        public float x;

        public hw(float f, float f2, long j, MotionEvent motionEvent) {
            this.pr = f;
            this.hw = f2;
            this.hn = j;
            this.x = f;
            this.c = f2;
            this.fw = motionEvent;
        }
    }

    public SlideInterceptView(Context context, pq pqVar, pr prVar) {
        super(context);
        this.fw = false;
        this.vk = new com.byazt.qi.pr();
        this.w = new iu(this);
        this.k = new HashMap();
        this.zo = pqVar;
        this.aj = prVar;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.vk.pr(motionEvent)) {
            return false;
        }
        this.vk.pr(this, new StringBuilder().append(getId()).toString(), motionEvent);
        pr(motionEvent);
        if (a.hw().xd()) {
            return hn(motionEvent);
        }
        return hw(motionEvent);
    }

    private void pr(MotionEvent motionEvent) {
        c cVarPr;
        pr prVar = this.aj;
        if (prVar != null && (cVarPr = prVar.pr()) != null) {
            cVarPr.hn(motionEvent.getDeviceId());
            cVarPr.hw(motionEvent.getSource());
            cVarPr.x(motionEvent.getToolType(0));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:34:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:39:0x0108  */
    /* JADX WARN: Code duplicated, block: B:41:0x0112  */
    /* JADX WARN: Code duplicated, block: B:43:0x0116  */
    /* JADX WARN: Code duplicated, block: B:45:0x011c  */
    /* JADX WARN: Code duplicated, block: B:46:0x012f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0133  */
    /* JADX WARN: Code duplicated, block: B:52:0x0147  */
    private boolean hw(MotionEvent motionEvent) {
        boolean z;
        pr prVar;
        pr prVar2;
        byte b;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.c = motionEvent.getX();
        this.uc = motionEvent.getY();
        this.x = motionEvent;
        float f = x - this.pr;
        float f2 = y - this.hw;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.hn;
        int iLb = this.zo.lb();
        int iHn = er.hn(getContext(), this.zo.qa());
        int iFo = this.zo.fo();
        int iHn2 = er.hn(getContext(), this.zo.rc());
        switch (motionEvent.getAction()) {
            case 0:
                this.pr = x;
                this.hw = y;
                this.hn = System.currentTimeMillis();
                if (iFo > 0) {
                    this.w.sendEmptyMessageDelayed(1, iFo);
                }
                z = false;
                break;
            case 1:
                this.w.removeMessages(1);
                if (pr(f, f2, iLb, iHn)) {
                    if (!this.fw) {
                        this.fw = true;
                        prVar2 = this.aj;
                        if (prVar2 != null) {
                            if (motionEvent.getAction() == 3) {
                                b = 7;
                            } else {
                                b = 2;
                            }
                            prVar2.pr(this, pr(b, this.hn, this.pr, this.hw, x, y));
                        }
                    }
                } else if (pr(f, f2, jCurrentTimeMillis, iFo, iHn2)) {
                    if (!this.fw) {
                        this.fw = true;
                        prVar = this.aj;
                        if (prVar != null) {
                            prVar.pr(this, pr((byte) 5, this.hn, this.pr, this.hw, x, y));
                        }
                    }
                } else if (!this.fw) {
                    z = true;
                }
                z = false;
                break;
            case 2:
                if (this.zo.ny() == 1 && pr(f, f2, iLb, iHn)) {
                    if (!this.fw) {
                        this.fw = true;
                        pr prVar3 = this.aj;
                        if (prVar3 != null) {
                            prVar3.pr(this, pr((byte) 2, this.hn, this.pr, this.hw, x, y));
                        }
                    }
                } else if (pr(f, f2, jCurrentTimeMillis, iFo, iHn2) && !this.fw) {
                    this.fw = true;
                    pr prVar4 = this.aj;
                    if (prVar4 != null) {
                        prVar4.pr(this, pr((byte) 5, this.hn, this.pr, this.hw, x, y));
                    }
                }
                z = false;
                break;
            case 3:
                float rawX = motionEvent.getRawX();
                if (motionEvent.getRawY() == 0.0f && rawX == 0.0f) {
                    this.w.removeMessages(1);
                    if (a.hw().xh()) {
                        this.w.removeMessages(1);
                        if (pr(f, f2, iLb, iHn)) {
                            if (!this.fw) {
                                this.fw = true;
                                prVar2 = this.aj;
                                if (prVar2 != null) {
                                    if (motionEvent.getAction() == 3) {
                                        b = 7;
                                    } else {
                                        b = 2;
                                    }
                                    prVar2.pr(this, pr(b, this.hn, this.pr, this.hw, x, y));
                                }
                            }
                        } else if (pr(f, f2, jCurrentTimeMillis, iFo, iHn2)) {
                            if (!this.fw) {
                                this.fw = true;
                                prVar = this.aj;
                                if (prVar != null) {
                                    prVar.pr(this, pr((byte) 5, this.hn, this.pr, this.hw, x, y));
                                }
                            }
                        } else if (!this.fw) {
                            z = true;
                        }
                        z = false;
                    } else {
                        z = false;
                    }
                } else {
                    this.w.removeMessages(1);
                    if (pr(f, f2, iLb, iHn)) {
                        if (!this.fw) {
                            this.fw = true;
                            prVar2 = this.aj;
                            if (prVar2 != null) {
                                if (motionEvent.getAction() == 3) {
                                    b = 7;
                                } else {
                                    b = 2;
                                }
                                prVar2.pr(this, pr(b, this.hn, this.pr, this.hw, x, y));
                            }
                        }
                    } else if (pr(f, f2, jCurrentTimeMillis, iFo, iHn2)) {
                        if (!this.fw) {
                            this.fw = true;
                            prVar = this.aj;
                            if (prVar != null) {
                                prVar.pr(this, pr((byte) 5, this.hn, this.pr, this.hw, x, y));
                            }
                        }
                    } else if (!this.fw) {
                        z = true;
                    }
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.vk.pr(this);
        }
        return !this.fw;
    }

    private boolean hn(MotionEvent motionEvent) {
        pr prVar;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        switch (actionMasked) {
            case 0:
            case 5:
                hw hwVar = new hw(motionEvent.getX(actionIndex), motionEvent.getY(actionIndex), System.currentTimeMillis(), motionEvent);
                this.k.put(Integer.valueOf(pointerId), hwVar);
                if (actionMasked == 0) {
                    this.pr = hwVar.pr;
                    this.hw = hwVar.hw;
                    this.hn = hwVar.hn;
                    this.c = hwVar.pr;
                    this.uc = hwVar.hw;
                    this.x = motionEvent;
                    int iFo = this.zo.fo();
                    if (iFo > 0) {
                        this.w.sendEmptyMessageDelayed(1, iFo);
                    }
                }
                break;
            case 1:
            case 6:
                hw hwVar2 = this.k.get(Integer.valueOf(pointerId));
                if (hwVar2 != null && !hwVar2.uc) {
                    pr(hwVar2, hwVar2.x - hwVar2.pr, hwVar2.c - hwVar2.hw, System.currentTimeMillis() - hwVar2.hn, hwVar2.x, hwVar2.c, motionEvent, true);
                }
                this.k.remove(Integer.valueOf(pointerId));
                if (actionMasked == 1) {
                    this.w.removeMessages(1);
                    if (!this.fw && this.k.isEmpty()) {
                        this.vk.pr(this);
                    }
                    this.k.clear();
                    this.fw = false;
                }
                break;
            case 2:
                boolean z = false;
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    hw hwVar3 = this.k.get(Integer.valueOf(motionEvent.getPointerId(i)));
                    if (hwVar3 != null && !hwVar3.uc) {
                        float x = motionEvent.getX(i);
                        float y = motionEvent.getY(i);
                        hwVar3.x = x;
                        hwVar3.c = y;
                        hwVar3.fw = motionEvent;
                        if (pr(hwVar3, x - hwVar3.pr, y - hwVar3.hw, System.currentTimeMillis() - hwVar3.hn, x, y, motionEvent, false)) {
                            z = true;
                        }
                    }
                }
                if (motionEvent.getPointerCount() > 0) {
                    this.c = motionEvent.getX(0);
                    this.uc = motionEvent.getY(0);
                    this.x = motionEvent;
                }
                if (z) {
                    this.fw = true;
                }
                break;
            case 3:
                if (motionEvent.getRawX() == 0.0f && motionEvent.getRawY() == 0.0f) {
                    this.w.removeMessages(1);
                    if (a.hw().xh() && !this.fw && pr(0.0f - this.pr, 0.0f - this.hw, this.zo.lb(), er.hn(getContext(), this.zo.qa())) && (prVar = this.aj) != null) {
                        prVar.pr(this, pr((byte) 7, this.hn, this.pr, this.hw, -1.0f, -1.0f));
                    }
                }
                this.w.removeMessages(1);
                this.k.clear();
                this.fw = false;
                break;
        }
        return !this.fw;
    }

    private boolean pr(hw hwVar, float f, float f2, long j, float f3, float f4, MotionEvent motionEvent, boolean z) {
        int iLb = this.zo.lb();
        int iHn = er.hn(getContext(), this.zo.qa());
        int iFo = this.zo.fo();
        int iHn2 = er.hn(getContext(), this.zo.rc());
        if ((z || this.zo.ny() == 1) && !hwVar.uc) {
            if (pr(f, f2, iLb, iHn)) {
                hwVar.uc = true;
                pr prVar = this.aj;
                if (prVar != null) {
                    prVar.pr(this, pr((byte) 2, hwVar.hn, hwVar.pr, hwVar.hw, f3, f4));
                }
                return true;
            }
        }
        if (hwVar.uc || !pr(f, f2, j, iFo, iHn2)) {
            return false;
        }
        hwVar.uc = true;
        pr prVar2 = this.aj;
        if (prVar2 != null) {
            prVar2.pr(this, pr((byte) 5, hwVar.hn, hwVar.pr, hwVar.hw, f3, f4));
        }
        return true;
    }

    private boolean pr(float f, float f2, int i, int i2) {
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        boolean z3 = (i & 4) == 4;
        boolean z4 = (i & 8) == 8;
        if (z && (-f2) > i2) {
            return true;
        }
        if (z2 && f2 > i2) {
            return true;
        }
        if (!z3 || (-f) <= i2) {
            return z4 && f > ((float) i2);
        }
        return true;
    }

    private boolean pr(float f, float f2, long j, int i, int i2) {
        if (i <= 0 || j < i) {
            return false;
        }
        float f3 = i2;
        if (Math.abs(f) > f3 || Math.abs(f2) > f3) {
            return false;
        }
        return true;
    }

    private vk pr(byte b, long j, float f, float f2, float f3, float f4) {
        vk vkVar = new vk();
        vkVar.pr(b);
        vkVar.pr(4);
        vkVar.hw(false);
        vkVar.pr(j);
        vkVar.hw(System.currentTimeMillis());
        vkVar.pr(f);
        vkVar.hw(f2);
        vkVar.hn(f3);
        vkVar.x(f4);
        return vkVar;
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        if (a.hw().xd()) {
            boolean z = false;
            Iterator<Map.Entry<Integer, hw>> it = this.k.entrySet().iterator();
            while (it.hasNext()) {
                hw value = it.next().getValue();
                if (value != null && !value.uc && pr(value.x - value.pr, value.c - value.hw, System.currentTimeMillis() - value.hn, this.zo.fo(), er.hn(getContext(), this.zo.rc()))) {
                    value.uc = true;
                    pr prVar = this.aj;
                    if (prVar != null) {
                        prVar.pr(this, pr((byte) 5, value.hn, value.pr, value.hw, value.x, value.c));
                    }
                    z = true;
                }
            }
            if (z) {
                this.fw = true;
                return;
            }
            return;
        }
        if (pr(this.c - this.pr, this.uc - this.hw, System.currentTimeMillis() - this.hn, this.zo.fo(), er.hn(getContext(), this.zo.rc())) && !this.fw) {
            this.fw = true;
            pr prVar2 = this.aj;
            if (prVar2 != null) {
                prVar2.pr(this, pr((byte) 5, this.hn, this.pr, this.hw, this.c, this.uc));
            }
        }
    }

    public void pr() {
        this.w.removeMessages(1);
        this.k.clear();
    }
}
