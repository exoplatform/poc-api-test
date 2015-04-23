package org.exoplatform.bch.stream;

import org.exoplatform.bch.activity.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy implementation for testing
 * Created by bdechateauvieux on 4/23/15.
 */
public class StreamStorage {
    private static final List<Activity> STREAM = new ArrayList<Activity>();

    public static List<Activity> getStream() {
        return STREAM;
    }

    public static void addActivity(Activity activity) {
        STREAM.add(activity);
    }
}
