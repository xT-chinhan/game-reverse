package com.byazt.et;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.xz.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 18})
public class l extends qg {
    public String cd;
    public float cp;
    public AtomicBoolean cy;
    public float d;
    public int hd;
    public int k;
    public int oa;
    public AtomicInteger sz;
    public sz um;

    public l(Context context) {
        super(context);
        this.oa = 0;
        this.sz = new AtomicInteger(Integer.MAX_VALUE);
        this.k = Integer.MAX_VALUE;
        this.cy = new AtomicBoolean(true);
        this.hd = 0;
        this.cd = "up";
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        Object obj;
        Object obj2;
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.l != null) {
            Object obj3 = this.l.get("direction");
            String strValueOf = "all";
            if (obj3 != null && !TextUtils.isEmpty(String.valueOf(obj3))) {
                strValueOf = String.valueOf(obj3);
            }
            this.cd = strValueOf;
            Object obj4 = this.l.get("distance");
            if (obj4 == null) {
                this.oa = 0;
            } else {
                this.oa = com.byazt.hb.s.n(String.valueOf(obj4), 0);
            }
            if (this.sz.get() == Integer.MAX_VALUE && (obj2 = this.l.get("frequency")) != null) {
                this.sz.set(com.byazt.hb.s.n(String.valueOf(obj2), Integer.MAX_VALUE));
            }
            if (this.k == Integer.MAX_VALUE && (obj = this.l.get("effectiveDuration")) != null) {
                this.k = com.byazt.hb.s.n(String.valueOf(obj), Integer.MAX_VALUE);
            }
            Object obj5 = this.l.get("inView");
            if (obj5 != null) {
                this.hd = com.byazt.hb.s.n(String.valueOf(obj5), 0);
            }
            this.cy.get();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        n();
        sz szVar = this.um;
        if (szVar != null) {
            return szVar.n(this.qg, motionEvent, this.n, this, this.cd, this.oa, this.sz, this.hd, this.cy.get());
        }
        return n(this.qg, motionEvent);
    }

    private void n() {
        if (this.k == Integer.MAX_VALUE || this.qg == null || System.currentTimeMillis() - this.qg.wm() < this.k) {
            return;
        }
        this.cy.set(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x001f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0054  */
    /* JADX WARN: Code duplicated, block: B:23:0x005c  */
    /* JADX WARN: Code duplicated, block: B:24:0x005e  */
    /* JADX WARN: Code duplicated, block: B:26:0x0066  */
    /* JADX WARN: Code duplicated, block: B:27:0x0068  */
    /* JADX WARN: Code duplicated, block: B:29:0x0070  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072  */
    /* JADX WARN: Code duplicated, block: B:32:0x007a  */
    /* JADX WARN: Code duplicated, block: B:33:0x007c  */
    /* JADX WARN: Code duplicated, block: B:35:0x0084  */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:38:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x008d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00af  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bc A[RETURN] */
    private boolean n(com.byazt.ih.s sVar, MotionEvent motionEvent) {
        float x;
        float y;
        int iQg;
        int iQg2;
        byte b;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.cp = motionEvent.getX();
            this.d = motionEvent.getY();
        } else if (action == 1) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (this.oa != 0 && this.n != null) {
                return n(sVar, x, y);
            }
            iQg = com.byazt.hb.fs.qg(this.tj, x - this.cp);
            iQg2 = com.byazt.hb.fs.qg(this.tj, y - this.d);
            switch (this.cd) {
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
            if (b != 0) {
                iQg = -iQg2;
            } else if (b != 1) {
                iQg = iQg2;
            } else if (b != 2) {
                iQg = -iQg;
            } else if (b != 3) {
                iQg = (int) Math.abs(Math.sqrt(Math.pow(iQg, 2.0d) + Math.pow(iQg2, 2.0d)));
            }
            if (iQg >= this.oa) {
                return false;
            }
            if (this.n != null) {
                this.cp = 0.0f;
                this.d = 0.0f;
                return n(sVar, x, y);
            }
        } else if (action == 3) {
            float rawX = motionEvent.getRawX();
            if (motionEvent.getRawY() != 0.0f || rawX != 0.0f) {
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (this.oa != 0) {
                }
                iQg = com.byazt.hb.fs.qg(this.tj, x - this.cp);
                iQg2 = com.byazt.hb.fs.qg(this.tj, y - this.d);
                switch (this.cd) {
                    case 3739:
                        if (r6.equals("up")) {
                            b = -1;
                        } else {
                            b = 0;
                        }
                        break;
                    case 96673:
                        if (r6.equals("all")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case 3089570:
                        if (r6.equals("down")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case 3317767:
                        if (r6.equals("left")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case 108511772:
                        if (r6.equals("right")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                if (b != 0) {
                    iQg = -iQg2;
                } else if (b != 1) {
                    iQg = iQg2;
                } else if (b != 2) {
                    iQg = -iQg;
                } else if (b != 3) {
                    iQg = (int) Math.abs(Math.sqrt(Math.pow(iQg, 2.0d) + Math.pow(iQg2, 2.0d)));
                }
                if (iQg >= this.oa) {
                    return false;
                }
                if (this.n != null) {
                    this.cp = 0.0f;
                    this.d = 0.0f;
                    return n(sVar, x, y);
                }
            }
        }
        return true;
    }

    private boolean n(com.byazt.ih.s sVar, float f, float f2) {
        if (this.sz.get() <= 0 || !this.cy.get()) {
            return false;
        }
        if (this.hd == 1 && !n(sVar.rv(), f, f2)) {
            return false;
        }
        this.n.n(sVar, this.w, this.s.qg(), this.s);
        if (this.sz.get() != Integer.MAX_VALUE) {
            this.sz.decrementAndGet();
        }
        return true;
    }

    private boolean n(View view, float f, float f2) {
        return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
    }

    public void n(sz szVar) {
        this.um = szVar;
    }
}
