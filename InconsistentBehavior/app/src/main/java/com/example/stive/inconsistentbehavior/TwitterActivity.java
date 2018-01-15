package com.example.stive.inconsistentbehavior;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class TwitterActivity extends AppCompatActivity {

    private Context context = this;
    private TextView textEmpty;
    private RecyclerView recyclerTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        recyclerTweets = findViewById(R.id.recyclerTweets);
        textEmpty = findViewById(R.id.textEmpty);
        Twitter.initialize(context);

        recyclerTweets.setLayoutManager(new LinearLayoutManager(this));

        final UserTimeline userTimeline = new UserTimeline.Builder()
                .screenName("Google")
                .build();

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(this)
                        .setTimeline(userTimeline)
                        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                        .build();

        recyclerTweets.setAdapter(adapter);


        if(recyclerTweets.getAdapter().getItemCount() == 0){
           // recyclerTweets.setVisibility(View.GONE);
            textEmpty.setVisibility(View.VISIBLE);
        }

    }

}

