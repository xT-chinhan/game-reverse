package com.tapsdk.tapad.internal.tracker.experiment.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.tapsdk.tapad.internal.tracker.experiment.ExpTdsTrackerConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ExpTrackMessage implements Parcelable {
    public static final Parcelable.Creator<ExpTrackMessage> CREATOR = new a();
    public final long createTime;
    public final Map<String, String> logCommonParams;
    public final Map<String, String> logContentsMap;
    public final ExpTdsTrackerConfig tdsTrackerConfig;

    static class a implements Parcelable.Creator<ExpTrackMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpTrackMessage createFromParcel(Parcel parcel) {
            return new ExpTrackMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpTrackMessage[] newArray(int i) {
            return new ExpTrackMessage[i];
        }
    }

    protected ExpTrackMessage(Parcel parcel) {
        this.tdsTrackerConfig = (ExpTdsTrackerConfig) parcel.readParcelable(ExpTrackMessage.class.getClassLoader());
        HashMap map = new HashMap();
        this.logContentsMap = map;
        parcel.readMap(map, ExpTrackMessage.class.getClassLoader());
        this.createTime = parcel.readLong();
        HashMap map2 = new HashMap();
        this.logCommonParams = map2;
        parcel.readMap(map2, ExpTrackMessage.class.getClassLoader());
    }

    public ExpTrackMessage(ExpTdsTrackerConfig expTdsTrackerConfig, Map<String, String> map, long j, Map<String, String> map2) {
        this.tdsTrackerConfig = expTdsTrackerConfig;
        this.logContentsMap = map;
        this.createTime = j;
        this.logCommonParams = map2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.tdsTrackerConfig, i);
        parcel.writeMap(this.logContentsMap);
        parcel.writeLong(this.createTime);
        parcel.writeMap(this.logCommonParams);
    }
}
