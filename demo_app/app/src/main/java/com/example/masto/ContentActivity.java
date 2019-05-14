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
import com.sys1yagi.mastodon4j.api.exception.Mastodon4jRequestException;
import com.sys1yagi.mastodon4j.api.method.Public;
import java.util.ArrayList;
import okhttp3.OkHttpClient;

public class ContentActivity extends AppCompatActivity {

    public static ArrayList<String> contentList = new ArrayList<String>();

    // Connect Mastodon
    public class GetInstanceContent extends AsyncTask<String, Void, Void> {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected Void doInBackground(String... strings) {
            MastodonClient client = new MastodonClient.Builder(strings[0], new OkHttpClient.Builder(), new Gson()).build();
            Public publicMethod = new Public(client);

            try {
                Pageable<com.sys1yagi.mastodon4j.api.entity.Status> statuses = publicMethod.getLocalPublic(new Range())
                        .doOnJson(System.out::println)
                        .execute();
                for (com.sys1yagi.mastodon4j.api.entity.Status status : statuses.getPart()) {
                    String name = status.getAccount().getDisplayName();
                    if (name == "")
                        name = "Unknown";
                    String conx = status.getContent();
                    contentList.add("\n" + name + ":\n\n" + conx.substring(3, conx.length()-4) + "\n");
                }
            } catch (Mastodon4jRequestException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Intent intent = getIntent();
        String instance = (String) intent.getStringExtra("InsName");

        if (!contentList.isEmpty())
            contentList.clear();

        GetInstanceContent newCon = new GetInstanceContent();
        newCon.execute(instance);

        ListView contents = (ListView) findViewById(R.id.contentView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contentList);
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
