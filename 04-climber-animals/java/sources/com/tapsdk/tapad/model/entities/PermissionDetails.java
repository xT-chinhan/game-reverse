package com.tapsdk.tapad.model.entities;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class PermissionDetails implements Parcelable {
    public static final Parcelable.Creator<PermissionDetails> CREATOR = new a();
    public final List<PermissionContent> permissionContentList;

    static class a implements Parcelable.Creator<PermissionDetails> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionDetails createFromParcel(Parcel parcel) {
            return new PermissionDetails(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PermissionDetails[] newArray(int i) {
            return new PermissionDetails[i];
        }
    }

    protected PermissionDetails(Parcel parcel) {
        this.permissionContentList = parcel.createTypedArrayList(PermissionContent.CREATOR);
    }

    public PermissionDetails(JSONArray jSONArray) throws JSONException {
        this.permissionContentList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            this.permissionContentList.add(new PermissionContent(jSONArray.getJSONObject(i)));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.permissionContentList);
    }
}
