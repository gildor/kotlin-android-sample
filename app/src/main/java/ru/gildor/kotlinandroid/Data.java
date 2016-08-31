package ru.gildor.kotlinandroid;

import android.content.Intent;
import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Data implements Parcelable {
    public static Data create() {
        return new AutoValue_Data("create title", 42, new Intent());
    }

    public static Data.Builder builder() {
        return new AutoValue_Data.Builder().intent(new Intent()).number(42).title("my title");
    }

    public abstract String title();

    public abstract int number();

    public abstract Intent intent();

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder title(String title);

        public abstract Builder number(int number);

        public abstract Builder intent(Intent object);

        public abstract Data build();
    }
}
