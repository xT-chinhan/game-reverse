package com.tapsdk.tapad.internal;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.tapsdk.tapad.AdRequest;
import com.tapsdk.tapad.R;
import com.tapsdk.tapad.TapAdConfig;
import com.tapsdk.tapad.e.j;
import com.tapsdk.tapad.model.entities.AdInfo;
import com.tapsdk.tapad.model.entities.RewardResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class RewardPresenter {
    private volatile RewardState a;
    WeakReference<Context> c;
    private final d e;
    private final AdRequest f;
    private final AdInfo g;
    private final TapAdConfig h;
    private CountDownTimer i;
    private CountDownTimer j;
    private long k;
    private final long l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private final j b = new j();
    private final CompositeDisposable d = new CompositeDisposable();
    private boolean q = false;
    private boolean r = true;
    private boolean s = true;
    private boolean t = false;
    private final Set<Long> u = new HashSet(Arrays.asList(5000L, Long.valueOf(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT), 20000L, 30000L));
    final Handler v = new a(Looper.getMainLooper());

    public enum RewardState {
        DEFAULT,
        SKIPPABLE,
        SKIPPABLE_REWARDED,
        COMPLETE,
        END
    }

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                RewardPresenter rewardPresenter = RewardPresenter.this;
                rewardPresenter.k = rewardPresenter.k > 1000 ? RewardPresenter.this.k - 1000 : 100L;
                RewardPresenter.this.e.a(RewardPresenter.this.k);
            } else if (i == 2) {
                RewardPresenter rewardPresenter2 = RewardPresenter.this;
                rewardPresenter2.n = rewardPresenter2.n > 1000 ? RewardPresenter.this.n - 1000 : 100L;
                RewardPresenter.this.e.b(RewardPresenter.this.n);
            }
        }
    }

    class b extends CountDownTimer {

        class a implements Consumer<RewardResult> {
            a() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(RewardResult rewardResult) throws Exception {
            }
        }

        /* JADX INFO: renamed from: com.tapsdk.tapad.internal.RewardPresenter$b$b, reason: collision with other inner class name */
        class C0601b implements Consumer<Throwable> {
            C0601b() {
            }

            @Override // io.reactivex.functions.Consumer
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Throwable th) throws Exception {
            }
        }

        b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!RewardPresenter.this.p) {
                RewardPresenter.this.p = true;
                RewardPresenter.this.e.b();
            }
            if (!RewardPresenter.this.t) {
                long j = (((RewardPresenter.this.l - RewardPresenter.this.k) + 1000) / 1000) * 1000;
                HashMap map = new HashMap();
                map.put("duration", "" + j);
                map.put("is_finished", "1");
                map.put("finished", "1");
                com.tapsdk.tapad.internal.tracker.c.a().a(RewardPresenter.this.g.videoViewMonitorUrls, map, RewardPresenter.this.g.getVideoViewMonitorHeaderListWrapper());
                if (RewardPresenter.this.e != null) {
                    RewardPresenter.this.e.a();
                }
                RewardPresenter.this.t = true;
            }
            RewardPresenter.this.d();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            RewardPresenter rewardPresenter;
            RewardState rewardState;
            RewardPresenter.this.k = j;
            long j2 = (RewardPresenter.this.l - RewardPresenter.this.k) + 1000;
            long j3 = (j2 / 1000) * 1000;
            if (RewardPresenter.this.u.contains(Long.valueOf(j3)) && !RewardPresenter.this.t) {
                RewardPresenter.this.u.remove(Long.valueOf(j3));
                HashMap map = new HashMap();
                RewardPresenter rewardPresenter2 = RewardPresenter.this;
                rewardPresenter2.t = Math.abs(j2 - ((long) (rewardPresenter2.g.materialInfo.videoInfoList.get(0).duration * 1000))) < 500;
                map.put("duration", "" + j3);
                map.put("is_finished", "" + (RewardPresenter.this.t ? 1 : 0));
                map.put("finished", "" + (RewardPresenter.this.t ? 1 : 0));
                com.tapsdk.tapad.internal.tracker.c.a().a(RewardPresenter.this.g.videoViewMonitorUrls, map, RewardPresenter.this.g.getVideoViewMonitorHeaderListWrapper());
                if (RewardPresenter.this.e != null && RewardPresenter.this.t) {
                    RewardPresenter.this.e.a();
                }
            }
            if (j2 >= ((int) (RewardPresenter.this.g.incentiveTime * 0.9f * 1000.0f)) && !RewardPresenter.this.o) {
                RewardPresenter.this.o = true;
                RewardPresenter.this.b.a(RewardPresenter.this.f, RewardPresenter.this.g, RewardPresenter.this.h).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(), new C0601b());
            }
            if (j2 >= ((long) RewardPresenter.this.g.incentiveTime) * 1000 && !RewardPresenter.this.p) {
                RewardPresenter.this.p = true;
                RewardPresenter.this.e.b();
            }
            if (j2 >= 30000) {
                if (RewardPresenter.this.g.renderStyles.a == 0) {
                    rewardPresenter = RewardPresenter.this;
                    rewardState = RewardState.SKIPPABLE;
                } else {
                    rewardPresenter = RewardPresenter.this;
                    rewardState = RewardState.SKIPPABLE_REWARDED;
                }
                rewardPresenter.a = rewardState;
            }
            RewardPresenter.this.e.a(j);
            if (j > com.anythink.basead.exoplayer.i.a.f || !RewardPresenter.this.r) {
                return;
            }
            RewardPresenter.this.r = false;
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            RewardPresenter.this.v.sendMessageDelayed(messageObtain, 1000L);
        }
    }

    class c extends CountDownTimer {
        c(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            RewardPresenter.this.e();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            RewardPresenter.this.n = j;
            RewardPresenter.this.e.b(j);
            if (j > com.anythink.basead.exoplayer.i.a.f || !RewardPresenter.this.s) {
                return;
            }
            RewardPresenter.this.s = false;
            Message messageObtain = Message.obtain();
            messageObtain.what = 2;
            RewardPresenter.this.v.sendMessageDelayed(messageObtain, 1000L);
        }
    }

    public interface d {
        void a();

        void a(long j);

        void b();

        void b(long j);

        void c();

        void d();

        void onError(int i, String str);
    }

    public static class e extends com.tapsdk.tapad.internal.b {
    }

    public static class f extends com.tapsdk.tapad.internal.b {
    }

    public static class g extends com.tapsdk.tapad.internal.b {
    }

    public static class h extends com.tapsdk.tapad.internal.b {
    }

    public RewardPresenter(Context context, d dVar, long j, AdRequest adRequest, AdInfo adInfo, TapAdConfig tapAdConfig) {
        this.c = new WeakReference<>(context);
        this.e = dVar;
        this.k = j;
        this.l = j;
        this.f = adRequest;
        this.g = adInfo;
        this.a = adInfo.renderStyles.a == 0 ? RewardState.DEFAULT : RewardState.SKIPPABLE;
        this.o = false;
        this.p = false;
        this.h = tapAdConfig;
    }

    private void f() {
        CountDownTimer countDownTimer = this.j;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.j = null;
        }
    }

    private void g() {
        CountDownTimer countDownTimer = this.i;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.i = null;
        }
    }

    private void h() {
        if (this.d.isDisposed()) {
            return;
        }
        this.d.dispose();
    }

    private void i() {
        this.m = com.anythink.basead.exoplayer.i.a.f;
        this.n = com.anythink.basead.exoplayer.i.a.f;
        if (this.j == null) {
            c cVar = new c(this.m, 1000L);
            this.j = cVar;
            cVar.start();
        }
    }

    private void j() {
        if (this.i == null) {
            b bVar = new b(this.k, 1000L);
            this.i = bVar;
            bVar.start();
        }
    }

    public Pair<String, String> a() {
        StringBuilder sb;
        long j;
        String string = "";
        if (this.a == RewardState.COMPLETE) {
            string = this.c.get() != null ? this.c.get().getString(R.string.tapad_btn_skip) : "";
            sb = new StringBuilder();
            j = this.n;
        } else {
            if (this.a == RewardState.END) {
                return Pair.create("", this.c.get() != null ? this.c.get().getString(R.string.tapad_btn_close) : "");
            }
            string = ((this.a == RewardState.SKIPPABLE || this.a == RewardState.SKIPPABLE_REWARDED) && this.c.get() != null) ? this.c.get().getString(R.string.tapad_btn_skip) : "";
            sb = new StringBuilder();
            j = this.k;
        }
        return Pair.create(sb.append((int) Math.ceil((j * 1.0f) / 1000.0f)).append(" 秒").toString(), string);
    }

    public void a(com.tapsdk.tapad.internal.b bVar) {
        if (bVar instanceof g) {
            j();
            return;
        }
        if ((bVar instanceof e) || (bVar instanceof h)) {
            g();
        } else if (bVar instanceof com.tapsdk.tapad.internal.d) {
            h();
        } else if (bVar instanceof f) {
            i();
        }
    }

    public int b() {
        return Math.max(this.g.incentiveTime - ((int) (((this.l - this.k) + 1000) / 1000)), 1);
    }

    public RewardState c() {
        return this.a;
    }

    public void d() {
        if (this.q) {
            return;
        }
        this.k = 0L;
        this.a = RewardState.COMPLETE;
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(0L);
            this.e.c();
            g();
        }
        i();
        this.q = true;
    }

    public void e() {
        this.n = 0L;
        this.a = RewardState.END;
        if (this.j != null) {
            f();
        }
        this.e.b(0L);
    }
}
