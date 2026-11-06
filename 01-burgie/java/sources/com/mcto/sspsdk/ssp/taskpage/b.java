package com.mcto.sspsdk.ssp.taskpage;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.mcto.sspsdk.internal.gj;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends CountDownTimer {
    public final /* synthetic */ QyTaskPageActivity a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(QyTaskPageActivity qyTaskPageActivity, long j) {
        super(j, 1000L);
        this.a = qyTaskPageActivity;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        if ((this.a.A & 1) == 0) {
            QyTaskPageActivity.m(this.a);
            QyTaskPageActivity.b(this.a);
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        TextView textView = this.a.q;
        long j2 = j / 1000;
        AtomicInteger atomicInteger = gj.a;
        long j3 = j2 / 3600;
        long j4 = (j2 % 3600) / 60;
        long j5 = j2 % 60;
        StringBuilder sb = new StringBuilder(8);
        if (j3 < 10) {
            sb.append('0');
        }
        sb.append(j3).append(AbstractJsonLexerKt.COLON);
        if (j4 < 10) {
            sb.append('0');
        }
        sb.append(j4).append(AbstractJsonLexerKt.COLON);
        if (j5 < 10) {
            sb.append('0');
        }
        sb.append(j5);
        textView.setText(sb.toString() + " 后结束");
    }
}
