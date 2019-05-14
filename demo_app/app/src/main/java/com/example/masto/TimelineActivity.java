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

            // String myaccessToken = apps.getAccessToken("d6847806db9ff5ff3894b173ff5258ee61ff5c341ea8bc0e014113facabe04ae", "add86ce5ca853cf9d4835ceb760e3119e15f7bd71a29703c50d9ef1cc7441f3c", "e4dce8290a6c9d6759b2a9daf192652b9d661f971aa5df7f0bf87eb1ea2ba9f1").execute().getAccessToken();
            String myaccessToken = "6b49f76e710d4f7be1b2bcdc77cf0238eaeaf48743aa2bc096c945e30cf44d5f";
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
