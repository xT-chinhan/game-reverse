package com.mcto.sspsdk.ssp.taskpage;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.imageview.QYNiceImageView;
import com.mcto.sspsdk.internal.gj;
import com.mcto.sspsdk.internal.he;
import com.mcto.sspsdk.internal.hk;
import com.mcto.sspsdk.internal.ie;
import com.mcto.sspsdk.internal.j0;
import com.mcto.sspsdk.internal.k0;
import com.mcto.sspsdk.internal.l0;
import com.mcto.sspsdk.internal.mh;
import com.mcto.sspsdk.internal.nh;
import com.mcto.sspsdk.internal.og;
import com.mcto.sspsdk.internal.oj;
import com.mcto.sspsdk.internal.ok;
import com.mcto.sspsdk.internal.p;
import com.mcto.sspsdk.internal.r9;
import com.mcto.sspsdk.internal.rk;
import com.mcto.sspsdk.internal.sg;
import com.mcto.sspsdk.internal.sk;
import com.mcto.sspsdk.internal.vh;
import com.mcto.sspsdk.internal.wh;
import com.mcto.sspsdk.ssp.utils.ClickAnimationView;
import com.mcto.unionsdk.QiClient;
import com.mcto.unionsdk.QiClientFactory;
import com.mcto.unionsdk.QiSlot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class QyTaskPageActivity extends AppCompatActivity implements View.OnClickListener {
    private l0 a;
    private String d;
    private ViewGroup e;
    private ProgressBar f;
    private TextView g;
    private TextView h;
    private QYNiceImageView i;
    private TextView j;
    private TextView k;
    private QyEnergyProgressBar l;
    private TextView m;
    private QYNiceImageView n;
    private TextView o;
    private ViewGroup p;
    private TextView q;
    private b r;
    private ClickAnimationView s;
    private TextView t;
    private RecyclerView u;
    private ProgressBar v;
    private h w;
    private TextView x;
    private int b = 0;
    private String c = "再推进%repg%进度，就可以获取终极奖励了";
    private boolean y = false;
    private long z = 0;
    private int A = 0;
    private final AtomicBoolean B = new AtomicBoolean(false);
    private boolean C = false;
    private final he D = new he(this);

    public QyTaskPageActivity() {
        new e(this);
    }

    static void b(QyTaskPageActivity qyTaskPageActivity) {
        qyTaskPageActivity.s.b();
        qyTaskPageActivity.s.setVisibility(8);
        qyTaskPageActivity.p.setVisibility(8);
    }

    static /* synthetic */ void m(QyTaskPageActivity qyTaskPageActivity) {
        qyTaskPageActivity.A |= 1;
    }

    static void n(QyTaskPageActivity qyTaskPageActivity) {
        qyTaskPageActivity.x.setVisibility(0);
        qyTaskPageActivity.u.setVisibility(8);
        qyTaskPageActivity.s.b();
        qyTaskPageActivity.s.setVisibility(8);
        qyTaskPageActivity.p.setVisibility(8);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.y || this.C) {
            finish();
            return;
        }
        this.C = true;
        nh.a(this).a("iad_dev", "tp_est", "" + System.currentTimeMillis());
        rk rkVar = new rk(this);
        rkVar.b = "确定退出吗?";
        rkVar.c = this.c.replace("%repg", "" + (100 - this.b));
        rkVar.d = "继续做任务";
        rkVar.a = true;
        rkVar.e = "退出";
        rkVar.f = new ie(this);
        new sk(this, rkVar).show();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.z < 500) {
            return;
        }
        this.z = jElapsedRealtime;
        int id = view.getId();
        if (id == R.id.qy_task_page_black_icon) {
            onBackPressed();
            return;
        }
        if (id == R.id.qy_task_page_rules_link) {
            rk rkVar = new rk(this);
            rkVar.b = "规则说明";
            rkVar.c = "https://static-s.iqiyi.com/lequ/20251112/a5641f4392d445d79a2ec2b6c98c4259.html";
            new sk(this, rkVar).show();
            return;
        }
        if (id == R.id.qy_task_page_refresh_base_task) {
            this.t.setVisibility(8);
            this.A = 0;
            throw null;
        }
        if (id != R.id.qy_task_page_loading_retry) {
            return;
        }
        this.f.setVisibility(0);
        this.g.setText("努力加载中");
        this.h.setVisibility(8);
        throw null;
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setRequestedOrientation((configuration.screenLayout & 15) >= 3 ? 10 : 1);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.qy_activity_task_page);
        boolean z = false;
        hk.a((AppCompatActivity) this, false);
        setRequestedOrientation((getResources().getConfiguration().screenLayout & 15) >= 3 ? 10 : 1);
        this.e = (ViewGroup) findViewById(R.id.qy_task_page_loading_group);
        this.f = (ProgressBar) findViewById(R.id.qy_task_page_loading_icon);
        this.g = (TextView) findViewById(R.id.qy_task_page_loading_desc);
        this.h = (TextView) findViewById(R.id.qy_task_page_loading_retry);
        this.i = (QYNiceImageView) findViewById(R.id.qy_task_page_header_image);
        this.j = (TextView) findViewById(R.id.qy_task_page_subtitle);
        this.k = (TextView) findViewById(R.id.qy_task_page_title);
        hk.a(findViewById(R.id.qy_task_page_progress_poster_group), (int) ((getResources().getDisplayMetrics().density * 4.0f) + 0.5f));
        this.l = (QyEnergyProgressBar) findViewById(R.id.qy_task_page_progress_bar);
        this.m = (TextView) findViewById(R.id.qy_task_page_progress_desc);
        this.n = (QYNiceImageView) findViewById(R.id.qy_task_page_progress_poster_icon);
        this.o = (TextView) findViewById(R.id.qy_task_page_progress_poster_value);
        this.p = (ViewGroup) findViewById(R.id.qy_task_page_time_mission_group);
        this.q = (TextView) findViewById(R.id.qy_task_page_time_mission_countdown);
        this.s = (ClickAnimationView) findViewById(R.id.qy_task_page_time_guide_animation);
        TaskAdItemView taskAdItemView = (TaskAdItemView) findViewById(R.id.qy_task_page_time_mission_card);
        this.u = (RecyclerView) findViewById(R.id.qy_task_page_base_task_list);
        this.t = (TextView) findViewById(R.id.qy_task_page_refresh_base_task);
        this.x = (TextView) findViewById(R.id.qy_task_page_no_ad_tips);
        this.v = (ProgressBar) findViewById(R.id.qy_task_page_base_ad_loading_icon);
        this.t.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.e.setOnClickListener(this);
        findViewById(R.id.qy_task_page_black_icon).setOnClickListener(this);
        findViewById(R.id.qy_task_page_rules_link).setOnClickListener(this);
        try {
            this.a = new l0(this);
            this.u.setHasFixedSize(true);
            this.u.addItemDecoration(new wh(this));
            this.u.setLayoutManager(new LinearLayoutManager(this));
            h hVar = new h(this.D);
            this.w = hVar;
            hVar.f = taskAdItemView;
            this.u.setAdapter(hVar);
            long jA = gj.a((Object) nh.a(this).a("tp_est"), 0L);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jA - jCurrentTimeMillis) <= 86400000 && (jCurrentTimeMillis + ((long) TimeZone.getDefault().getOffset(jCurrentTimeMillis))) / 86400000 == (jA + ((long) TimeZone.getDefault().getOffset(jA))) / 86400000) {
                z = true;
            }
            this.C = z;
            Intent intent = getIntent();
            if (intent != null) {
                intent.getStringExtra("pageEventId");
            }
            og.a.getAndSet(null);
            throw new RuntimeException("关键信息缺失。");
        } catch (Exception e) {
            r9.a("ssp_task_page", "loading", e);
            this.g.setText("加载出错，请关闭页面后，重新进入！\n" + e.getMessage());
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected final void onDestroy() {
        b bVar = this.r;
        if (bVar != null) {
            bVar.cancel();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            hk.a((AppCompatActivity) this, false);
        }
    }

    static void a(QyTaskPageActivity qyTaskPageActivity, vh vhVar) {
        if (qyTaskPageActivity.B.compareAndSet(false, true)) {
            mh mhVar = vhVar.a;
            JSONObject jSONObject = mhVar.v;
            if (jSONObject != null) {
                String strOptString = jSONObject.optString("acig");
                qyTaskPageActivity.d = strOptString;
                if (!TextUtils.isEmpty(strOptString)) {
                    qyTaskPageActivity.i.a(ok.a(qyTaskPageActivity.d, TTAdConstant.STYLE_SIZE_RADIO_3_2, 840));
                    if (Build.VERSION.SDK_INT >= 31) {
                        qyTaskPageActivity.n.a(ok.a(qyTaskPageActivity.d, 96, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE));
                        qyTaskPageActivity.n.setRenderEffect(RenderEffect.createBlurEffect(20.0f, 20.0f, Shader.TileMode.CLAMP));
                    } else {
                        qyTaskPageActivity.n.b();
                        qyTaskPageActivity.n.a(ok.a(qyTaskPageActivity.d, 96, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE));
                    }
                }
            }
            JSONObject jSONObject2 = mhVar.u;
            if (jSONObject2 != null) {
                qyTaskPageActivity.k.setText(sg.a(sg.a(jSONObject2.optJSONArray("pageTitle")), "", ""));
                qyTaskPageActivity.j.setText(sg.a(sg.a(jSONObject2.optJSONArray("pageSubTitle")), "", ""));
                qyTaskPageActivity.i.a(ok.a(qyTaskPageActivity.d, TTAdConstant.STYLE_SIZE_RADIO_3_2, 840));
                qyTaskPageActivity.l.a(jSONObject2.optString("spt"));
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(qyTaskPageActivity.b, jSONObject2.optInt("ctpgr"));
                valueAnimatorOfInt.setDuration(700L);
                valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
                valueAnimatorOfInt.addUpdateListener(new f(qyTaskPageActivity));
                valueAnimatorOfInt.start();
                qyTaskPageActivity.n.b();
                qyTaskPageActivity.n.a(ok.a(qyTaskPageActivity.d, 96, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE));
                SpannableString spannableString = new SpannableString("¥" + jSONObject2.optInt("skupr"));
                spannableString.setSpan(new RelativeSizeSpan(0.5f), 0, 1, 33);
                qyTaskPageActivity.o.setText(spannableString);
                jSONObject2.optString("rdedDialog");
                qyTaskPageActivity.c = jSONObject2.optString("edgt");
            }
            qyTaskPageActivity.e.setVisibility(8);
        }
    }

    static void a(QyTaskPageActivity qyTaskPageActivity, long j) {
        qyTaskPageActivity.p.setVisibility(0);
        qyTaskPageActivity.s.setVisibility(0);
        qyTaskPageActivity.s.a(new Size((int) ((qyTaskPageActivity.getResources().getDisplayMetrics().density * 15.0f) + 0.5f), (int) ((qyTaskPageActivity.getResources().getDisplayMetrics().density * 15.0f) + 0.5f)), new Size((int) ((qyTaskPageActivity.getResources().getDisplayMetrics().density * 44.0f) + 0.5f), (int) ((qyTaskPageActivity.getResources().getDisplayMetrics().density * 44.0f) + 0.5f)));
        qyTaskPageActivity.s.a();
        b bVar = qyTaskPageActivity.r;
        if (bVar != null) {
            bVar.cancel();
        }
        if (j == 0) {
            qyTaskPageActivity.s.b();
            qyTaskPageActivity.s.setVisibility(8);
            qyTaskPageActivity.p.setVisibility(8);
        } else {
            if (j < 0) {
                qyTaskPageActivity.q.setText("");
                return;
            }
            b bVar2 = new b(qyTaskPageActivity, j * 1000);
            qyTaskPageActivity.r = bVar2;
            bVar2.start();
        }
    }

    static void a(QyTaskPageActivity qyTaskPageActivity, ArrayList arrayList) {
        boolean z = false;
        if (arrayList != null) {
            int i = 1;
            if (arrayList.size() > 1) {
                l0 l0Var = qyTaskPageActivity.a;
                a aVar = new a(qyTaskPageActivity);
                l0Var.getClass();
                if (arrayList.isEmpty()) {
                    aVar.a(Collections.EMPTY_LIST);
                    return;
                }
                List listSynchronizedList = Collections.synchronizedList(new ArrayList());
                AtomicInteger atomicInteger = new AtomicInteger(arrayList.size());
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    p pVar = (p) it.next();
                    if (!pVar.n()) {
                        listSynchronizedList.add(new oj(pVar));
                        if (atomicInteger.decrementAndGet() == 0) {
                            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
                            aVar.a(listSynchronizedList);
                        }
                    } else {
                        int i2 = pVar.g;
                        if (l0Var.b == null) {
                            l0Var.b = new HashMap();
                        }
                        QiClient qiClient = (QiClient) l0Var.b.get(Integer.valueOf(i2));
                        if (qiClient == null) {
                            qiClient = QiClientFactory.getQiClient(i2, l0Var.a);
                            l0Var.b.put(Integer.valueOf(i2), qiClient);
                        }
                        QiSlot qiSlotBuild = new QiSlot.Builder().count(i).adType(2).token(pVar.e()).build();
                        AtomicBoolean atomicBoolean = new AtomicBoolean(z);
                        qiClient.loadAd(qiSlotBuild, new j0(pVar, atomicBoolean, listSynchronizedList, atomicInteger, scheduledExecutorServiceNewScheduledThreadPool, aVar, SystemClock.elapsedRealtime()));
                        scheduledExecutorServiceNewScheduledThreadPool.schedule(new k0(atomicBoolean, atomicInteger, scheduledExecutorServiceNewScheduledThreadPool, aVar, listSynchronizedList), 5L, TimeUnit.SECONDS);
                        l0Var = l0Var;
                        z = false;
                        i = 1;
                    }
                }
                return;
            }
        }
        qyTaskPageActivity.x.setVisibility(0);
        qyTaskPageActivity.u.setVisibility(8);
        qyTaskPageActivity.s.b();
        qyTaskPageActivity.s.setVisibility(8);
        qyTaskPageActivity.p.setVisibility(8);
    }
}
