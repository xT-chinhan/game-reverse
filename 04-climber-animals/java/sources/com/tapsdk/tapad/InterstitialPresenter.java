package com.tapsdk.tapad;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.tapsdk.tapad.internal.RewardPresenter;
import com.tapsdk.tapad.model.entities.AdInfo;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class InterstitialPresenter {
    WeakReference<Context> b;
    private final c c;
    private final AdInfo d;
    private CountDownTimer e;
    private long f;
    private final long g;
    private long h;
    private boolean i = false;
    final Handler j = new a(Looper.getMainLooper());
    private volatile RewardState a = RewardState.SKIPPABLE;

    public enum RewardState {
        DEFAULT,
        SKIPPABLE,
        SKIPPABLE_REWARDED,
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
                InterstitialPresenter interstitialPresenter = InterstitialPresenter.this;
                interstitialPresenter.f = interstitialPresenter.f > 1000 ? InterstitialPresenter.this.f - 1000 : 100L;
                InterstitialPresenter.this.c.a(InterstitialPresenter.this.f);
            } else if (i == 2) {
                InterstitialPresenter interstitialPresenter2 = InterstitialPresenter.this;
                interstitialPresenter2.h = interstitialPresenter2.h > 1000 ? InterstitialPresenter.this.h - 1000 : 100L;
                InterstitialPresenter.this.c.b(InterstitialPresenter.this.h);
            }
        }
    }

    class b extends CountDownTimer {
        b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (!InterstitialPresenter.this.i) {
                long j = (((InterstitialPresenter.this.g - InterstitialPresenter.this.f) + 1000) / 1000) * 1000;
                HashMap map = new HashMap();
                map.put("duration", "" + j);
                map.put("is_finished", "1");
                map.put("finished", "1");
                com.tapsdk.tapad.internal.tracker.c.a().a(InterstitialPresenter.this.d.videoViewMonitorUrls, map, InterstitialPresenter.this.d.getVideoViewMonitorHeaderListWrapper());
            }
            InterstitialPresenter.this.c();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            InterstitialPresenter.this.f = j;
            InterstitialPresenter.this.c.a(j);
            if (j >= 1000) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                InterstitialPresenter.this.j.sendMessageDelayed(messageObtain, 1000L);
            }
        }
    }

    public interface c {
        void a(long j);

        void b(long j);

        void onError(int i, String str);
    }

    public InterstitialPresenter(Context context, c cVar, long j, AdInfo adInfo) {
        this.b = new WeakReference<>(context);
        this.c = cVar;
        this.f = j;
        this.g = j;
        this.d = adInfo;
    }

    private void d() {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.e = null;
        }
    }

    private void e() {
    }

    private void f() {
        if (this.e == null) {
            b bVar = new b(this.f, 1000L);
            this.e = bVar;
            bVar.start();
        }
    }

    public Pair<String, String> a() {
        if (this.a == RewardState.END) {
            return this.b.get() != null ? Pair.create("0 秒", this.b.get().getString(R.string.tapad_btn_skip)) : Pair.create("0 秒", "跳过");
        }
        if (this.a == RewardState.SKIPPABLE) {
            return Pair.create(((int) Math.ceil((this.f * 1.0f) / 1000.0f)) + " 秒", this.b.get() != null ? this.b.get().getString(R.string.tapad_btn_skip) : "跳过");
        }
        return this.b.get() != null ? Pair.create("", this.b.get().getString(R.string.tapad_btn_close)) : Pair.create("", "关闭");
    }

    public void a(com.tapsdk.tapad.internal.b bVar) {
        if (bVar instanceof RewardPresenter.g) {
            f();
            return;
        }
        if ((bVar instanceof RewardPresenter.e) || (bVar instanceof RewardPresenter.h)) {
            d();
        } else if (bVar instanceof com.tapsdk.tapad.internal.d) {
            e();
        }
    }

    public RewardState b() {
        return this.a;
    }

    public void c() {
        this.h = 0L;
        this.a = RewardState.END;
        this.c.b(0L);
    }
}
