package com.taptap.sdk.db.biz.gameplay.reporter;

import com.taptap.sdk.db.data.model.GameDuration;
import com.taptap.sdk.db.event.DevicePlayGameEvent;
import com.taptap.sdk.db.event.UserPlayGameEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: compiled from: DefaultGameDurationReporter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/taptap/sdk/db/biz/gameplay/reporter/DefaultGameDurationReporter;", "Lcom/taptap/sdk/db/biz/gameplay/reporter/GameDurationReporter;", "()V", "submitDeviceDuration", "", "duration", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitUserDurations", "userDurations", "", "Lcom/taptap/sdk/db/data/model/GameDuration$User;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tap-db_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultGameDurationReporter implements GameDurationReporter {
    @Override // com.taptap.sdk.db.biz.gameplay.reporter.GameDurationReporter
    public Object submitUserDurations(List<GameDuration.User> list, Continuation<? super Unit> continuation) {
        List<GameDuration.User> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            GameDuration.User userDuration = (GameDuration.User) element$iv;
            long durationInSeconds = userDuration.getDuration() / 1000;
            if (durationInSeconds > 0) {
                new UserPlayGameEvent.Builder(MapsKt.hashMapOf(TuplesKt.to("duration", Boxing.boxLong(durationInSeconds)))).setUserId(userDuration.getId()).isAutomatically(true).build().submit();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.taptap.sdk.db.biz.gameplay.reporter.GameDurationReporter
    public Object submitDeviceDuration(long duration, Continuation<? super Unit> continuation) {
        long durationInSeconds = duration / 1000;
        new DevicePlayGameEvent.Builder(MapsKt.hashMapOf(TuplesKt.to("duration", Boxing.boxLong(durationInSeconds)))).isAutomatically(true).build().submit();
        return Unit.INSTANCE;
    }
}
