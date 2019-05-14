package com.example.masto;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.sys1yagi.mastodon4j.MastodonClient;
import com.sys1yagi.mastodon4j.api.Pageable;
import com.sys1yagi.mastodon4j.api.Range;
import com.sys1yagi.mastodon4j.api.entity.Status;
import com.sys1yagi.mastodon4j.api.exception.Mastodon4jRequestException;
import com.sys1yagi.mastodon4j.api.method.Apps;
import com.sys1yagi.mastodon4j.api.method.Timelines;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class TimelineActivity extends AppCompatActivity {

    public static ArrayList<String> timelineList = new ArrayList<String>();

    public class GetHomeContent extends AsyncTask<String, Void, Void> {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected Void doInBackground(String... strings) {

            String myaccessToken = "YOUR_TOKEN_HERE";
            MastodonClient client = new MastodonClient.Builder(strings[0], new OkHttpClient.Builder(), new Gson()).accessToken(myaccessToken).build();
            Timelines mytimelines = new Timelines(client);

            try {
                Pageable<com.sys1yagi.mastodon4j.api.entity.Status> statuses = mytimelines.getHome(new Range())
                        .doOnJson(System.out::println)
                        .execute();

                for (com.sys1yagi.mastodon4j.api.entity.Status status : statuses.getPart()) {
                    String name = status.getAccount().getDisplayName();
                    if (name == "")
                        name = "Unknown";
                    String conx = status.getContent();
                    timelineList.add("\n" + name + ":\n\n" + conx.substring(3, conx.length()-4) + "\n");
                }
            } catch (Mastodon4jRequestException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        Intent intent = getIntent();
        String instance = (String) intent.getStringExtra("InsName");

        if (!timelineList.isEmpty())
            timelineList.clear();

        GetHomeContent getHomeContent = new GetHomeContent();
        getHomeContent.execute(instance);

        ListView contents = (ListView) findViewById(R.id.contentView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, timelineList);
        contents.setAdapter(arrayAdapter);

        ImageView refresh = (ImageView) findViewById(R.id.refreshView);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}
