package com.hieupham.cleanarchitecture.data.source.local.api.converter;

import android.arch.persistence.room.TypeConverter;
import java.util.Date;

/**
 * Created by hieupham on 1/13/18.
 */

public class DateMillisConverter {
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
