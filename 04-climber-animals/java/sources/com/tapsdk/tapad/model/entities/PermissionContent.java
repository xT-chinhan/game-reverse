package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import com.taptap.sdk.compliance.constants.BundleKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionContent implements Parcelable {
    public static final Parcelable.Creator<PermissionContent> CREATOR = new a();
    public final String description;
    public final String title;

    static class a implements Parcelable.Creator<PermissionContent> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionContent createFromParcel(Parcel parcel) {
            return new PermissionContent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionContent[] newArray(int i) {
            return new PermissionContent[i];
        }
    }

    protected PermissionContent(Parcel parcel) {
        this.title = parcel.readString();
        this.description = parcel.readString();
    }

    public PermissionContent(JSONObject jSONObject) {
        this.title = jSONObject.optString("title");
        this.description = jSONObject.optString(BundleKey.DESCRIPTION);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.description);
    }
}
