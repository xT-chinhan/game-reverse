package com.byazt.xv;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.dd.g;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, 121})
public class x extends hw {
    public AtomicInteger g;
    public int ho;
    public float k;
    public String lb;
    public int m;
    public AtomicBoolean nt;
    public g qa;
    public float w;
    public int yb;

    public x(Context context) {
        super(context);
        this.m = 0;
        this.g = new AtomicInteger(Integer.MAX_VALUE);
        this.ho = Integer.MAX_VALUE;
        this.nt = new AtomicBoolean(true);
        this.yb = 0;
        this.lb = "up";
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        Object obj;
        Object obj2;
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.c != null) {
            Object obj3 = this.c.get("direction");
            String strValueOf = "all";
            if (obj3 != null && !TextUtils.isEmpty(String.valueOf(obj3))) {
                strValueOf = String.valueOf(obj3);
            }
            this.lb = strValueOf;
            Object obj4 = this.c.get("distance");
            if (obj4 != null) {
                this.m = com.byazt.aa.hn.pr(String.valueOf(obj4), 0);
            } else {
                this.m = 0;
            }
            if (this.g.get() == Integer.MAX_VALUE && (obj2 = this.c.get("frequency")) != null) {
                this.g.set(com.byazt.aa.hn.pr(String.valueOf(obj2), Integer.MAX_VALUE));
            }
            if (this.ho == Integer.MAX_VALUE && (obj = this.c.get("effectiveDuration")) != null) {
                this.ho = com.byazt.aa.hn.pr(String.valueOf(obj), Integer.MAX_VALUE);
            }
            Object obj5 = this.c.get("inView");
            if (obj5 != null) {
                this.yb = com.byazt.aa.hn.pr(String.valueOf(obj5), 0);
            }
            this.nt.get();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        pr();
        g gVar = this.qa;
        if (gVar != null) {
            return gVar.pr(this.hw, motionEvent, this.pr, this, this.lb, this.m, this.g, this.yb, this.nt.get());
        }
        return pr(this.hw, motionEvent);
    }

    private void pr() {
        if (this.ho != Integer.MAX_VALUE && this.hw != null && System.currentTimeMillis() - this.hw.fo() >= this.ho) {
            this.nt.set(false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:22:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0065  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:28:0x006f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x0079  */
    /* JADX WARN: Code duplicated, block: B:32:0x007b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x0087  */
    /* JADX WARN: Code duplicated, block: B:38:0x009f  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:43:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b7 A[RETURN] */
    private boolean pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        float x;
        float y;
        int iHw;
        int iHw2;
        switch (motionEvent.getAction()) {
            case 0:
                this.w = motionEvent.getX();
                this.k = motionEvent.getY();
                return true;
            case 1:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (this.m != 0 && this.pr != null) {
                    return pr(hnVar, x, y);
                }
                iHw = com.byazt.aa.zo.hw(this.vk, x - this.w);
                iHw2 = com.byazt.aa.zo.hw(this.vk, y - this.k);
                switch (this.lb) {
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
                if (iHw >= this.m) {
                    return false;
                }
                if (this.pr != null) {
                    this.w = 0.0f;
                    this.k = 0.0f;
                    return pr(hnVar, x, y);
                }
                return true;
            case 2:
            default:
                return true;
            case 3:
                float rawX = motionEvent.getRawX();
                if (motionEvent.getRawY() != 0.0f || rawX != 0.0f) {
                    x = motionEvent.getX();
                    y = motionEvent.getY();
                    if (this.m != 0) {
                    }
                    iHw = com.byazt.aa.zo.hw(this.vk, x - this.w);
                    iHw2 = com.byazt.aa.zo.hw(this.vk, y - this.k);
                    switch (this.lb) {
                        case 3739:
                            if (r5.equals("up")) {
                            }
                            break;
                        case 96673:
                            if (r5.equals("all")) {
                            }
                            break;
                        case 3089570:
                            if (r5.equals("down")) {
                            }
                            break;
                        case 3317767:
                            if (r5.equals("left")) {
                            }
                            break;
                        case 108511772:
                            if (r5.equals("right")) {
                            }
                            break;
                    }
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Switch insn not found in header
                        	at java.base/java.util.Objects.requireNonNull(Objects.java:259)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        */
                    /*
                        Method dump skipped, instruction units count: 244
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.byazt.xv.x.pr(com.byazt.ik.hn, android.view.MotionEvent):boolean");
                }

                private boolean pr(com.byazt.ik.hn hnVar, float f, float f2) {
                    if (this.g.get() <= 0 || !this.nt.get()) {
                        return false;
                    }
                    if (this.yb == 1 && !pr(hnVar.aj(), f, f2)) {
                        return false;
                    }
                    this.pr.pr(hnVar, this.uc, this.hn.hw(), this.hn);
                    if (this.g.get() != Integer.MAX_VALUE) {
                        this.g.decrementAndGet();
                    }
                    return true;
                }

                private boolean pr(View view, float f, float f2) {
                    return f >= 0.0f && f < ((float) view.getWidth()) && f2 >= 0.0f && f2 < ((float) view.getHeight());
                }

                public void pr(g gVar) {
                    this.qa = gVar;
                }
            }
