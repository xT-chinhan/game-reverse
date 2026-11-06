package com.mcto.sspsdk.ssp.taskpage;

import android.content.Context;
import android.os.SystemClock;
import android.support.constraint.Constraints;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.internal.a4;
import com.mcto.sspsdk.internal.b4;
import com.mcto.sspsdk.internal.e1;
import com.mcto.sspsdk.internal.eh;
import com.mcto.sspsdk.internal.fc;
import com.mcto.sspsdk.internal.gj;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.j;
import com.mcto.sspsdk.internal.l;
import com.mcto.sspsdk.internal.o9;
import com.mcto.sspsdk.internal.oj;
import com.mcto.sspsdk.internal.p;
import com.mcto.sspsdk.internal.p9;
import com.mcto.sspsdk.internal.sc;
import com.mcto.sspsdk.internal.v5;
import com.mcto.sspsdk.internal.w3;
import com.mcto.sspsdk.internal.y3;
import com.mcto.sspsdk.internal.z3;
import com.taptap.sdk.update.download.DownloadTask;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class TaskAdItemView extends sc {
    private oj b;
    private final TextView c;
    private final TextView d;
    private final QYNiceImageView e;
    private final TextView f;
    private final View g;
    private w3 h;
    private boolean i;
    private boolean j;
    private long k;
    private float l;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private final g r;

    public TaskAdItemView(Context context) {
        this(context, null);
    }

    final void a(oj ojVar) {
        this.b = ojVar;
        this.c.setText(ojVar.a.P);
        this.e.a(ojVar.a.Q);
        a(ojVar.c);
        if (ojVar.a.n()) {
            this.g.setOnClickListener(null);
        } else {
            this.g.setOnClickListener(this.r);
        }
    }

    @Override // com.mcto.sspsdk.internal.sc
    protected final void b() {
        this.j = true;
        d();
    }

    protected final void d() {
        if (this.j && this.i) {
            HashMap map = new HashMap(4);
            map.put(v5.KEY_VIEW_COORDINATE, gj.a(this));
            map.put(v5.KEY_AD_VIEW_RECT, getWidth() + "_" + getHeight());
            l lVarA = l.a();
            p pVar = this.b.a;
            lVarA.getClass();
            l.a(12, pVar, map);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.l = motionEvent.getX();
            this.m = motionEvent.getY();
            this.n = motionEvent.getX();
            this.o = motionEvent.getY();
            this.p = motionEvent.getRawX();
            this.q = motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected final void onClick(View view) {
        boolean z;
        a4 a4Var = new a4();
        a4Var.b = z3.LIMIT_GRAPHIC;
        a4Var.a = this;
        float f = this.l;
        float f2 = this.m;
        float f3 = this.n;
        float f4 = this.o;
        a4Var.h = f;
        a4Var.i = f2;
        a4Var.j = f3;
        a4Var.k = f4;
        a4 a4VarA = a4Var.a(this.p, this.q);
        a4VarA.e = gj.a(view);
        b4 b4Var = new b4(a4VarA);
        l lVarA = l.a();
        p pVar = this.b.a;
        HashMap mapA = gj.a(b4Var, this);
        lVarA.getClass();
        l.a(21, pVar, mapA);
        l lVarA2 = l.a();
        p pVar2 = this.b.a;
        HashMap mapA2 = gj.a(b4Var, this);
        lVarA2.getClass();
        l.a(19, pVar2, mapA2);
        p pVar3 = this.b.a;
        if (pVar3.S0 != 3 || e1.c(pVar3.i().optString("apkName"))) {
            z = true;
        } else {
            z = false;
            fc.a(getContext(), "需要您先安装应用，再打开浏览才能领取进度奖励。", TTAdConstant.INIT_LOCAL_FAIL_CODE);
        }
        String str = this.b.a() + ", 点击, 应用安装：" + z;
        p9.a.getClass();
        eh.a.a(new o9("ssp_task_page", str, null));
        if (!this.b.a.n()) {
            int iA = y3.a(getContext(), this.b.a, b4Var);
            if (iA == -1) {
                return;
            }
            if (iA == 4) {
                l lVarA3 = l.a();
                p pVar4 = this.b.a;
                lVarA3.getClass();
                l.a(25, pVar4, null);
            }
        }
        oj ojVar = this.b;
        int i = ojVar.c;
        if (j.a(i) <= 1) {
            if (j.a(ojVar.c) <= j.a(2)) {
                ojVar.c = 2;
            }
            this.k = SystemClock.elapsedRealtime();
        } else if (i == 4) {
            this.k = 1L;
        }
    }

    @Override // com.mcto.sspsdk.internal.sc, android.view.View
    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i != 0 || this.k == 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.k;
        p pVar = this.b.a;
        if (pVar.S0 != 3 || e1.c(pVar.i().optString("apkName"))) {
            oj ojVar = this.b;
            long j = ojVar.d - jElapsedRealtime;
            if (j < 1000) {
                a(3);
                this.h.a(this.b);
                String str = this.b.a() + ", checking";
                p9.a.getClass();
                eh.a.a(new o9("ssp_task_page", str, null));
            } else {
                ojVar.d = j;
                a(2);
                String str2 = this.b.a() + ", check remaining" + this.b.d;
                p9.a.getClass();
                eh.a.a(new o9("ssp_task_page", str2, null));
                fc.a(getContext(), this.b.b, DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS);
            }
        } else {
            a(2);
            fc.a(getContext(), this.b.b, DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS);
            String str3 = this.b.a() + ", double check.应用未安装";
            p9.a.getClass();
            eh.a.a(new o9("ssp_task_page", str3, null));
        }
        this.k = 0L;
    }

    public TaskAdItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = false;
        this.j = false;
        this.k = 0L;
        this.l = -999.0f;
        this.m = -999.0f;
        this.n = -999.0f;
        this.o = -999.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = new g(this);
        setLayoutParams(new Constraints.LayoutParams(-1, -2));
        LayoutInflater.from(context).inflate(R.layout.qy_task_listitem_icon_pic, (ViewGroup) this, true);
        this.c = (TextView) findViewById(R.id.qy_app_name);
        this.d = (TextView) findViewById(R.id.qy_app_title);
        QYNiceImageView qYNiceImageView = (QYNiceImageView) findViewById(R.id.qy_app_icon);
        this.e = qYNiceImageView;
        this.f = (TextView) findViewById(R.id.qy_app_button);
        this.g = findViewById(R.id.qy_card_bg);
        hk.a(qYNiceImageView, hk.a(context, 10.0f));
    }

    final void a(w3 w3Var) {
        this.h = w3Var;
    }

    protected final void a(boolean z) {
        this.i = z;
        if (z) {
            d();
        }
    }

    @Override // com.mcto.sspsdk.internal.sc
    protected final void a() {
        this.j = false;
    }

    final void a(int i) {
        String strReplace;
        String str;
        int iA = j.a(i);
        oj ojVar = this.b;
        if (iA < j.a(ojVar.c)) {
            return;
        }
        if (j.a(ojVar.c) <= j.a(i)) {
            ojVar.c = i;
        }
        TextView textView = this.d;
        oj ojVar2 = this.b;
        int i2 = ojVar2.c;
        if (i2 == 2) {
            strReplace = ojVar2.f.replace("%nrt", ((int) Math.ceil(ojVar2.d / 1000.0d)) + "秒");
        } else if (i2 == 3) {
            strReplace = "进度奖励下发中";
        } else if (i2 == 5) {
            strReplace = "任务已完成";
        } else if (i2 == 4) {
            strReplace = "奖励下发失败点击重新领取";
        } else {
            strReplace = ojVar2.e.replace("%nrt", ((int) Math.ceil(ojVar2.d / 1000.0d)) + "秒");
        }
        textView.setText(strReplace);
        TextView textView2 = this.f;
        oj ojVar3 = this.b;
        int i3 = ojVar3.c;
        if (i3 == 5) {
            str = "已完成";
        } else if (i3 == 4) {
            str = "领取奖励";
        } else if (i3 == 3) {
            str = "下发中";
        } else {
            str = String.format(Locale.CHINA, "浏览 +%d%%", Integer.valueOf(ojVar3.a.V));
        }
        textView2.setText(str);
        if (i == 5) {
            this.f.setAlpha(0.5f);
        } else {
            this.f.setAlpha(1.0f);
        }
    }
}
