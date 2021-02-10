package com.techprogramme.jsonreader;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class JsonReader {

    public static void main(String[] args) {

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("E:\\Projects\\Music Lyrics\\jSON\\artist_json.json"));
            Map<?, ?> map = gson.fromJson(reader, Map.class);

            String artistID = (String) map.get("artist_id");
            System.out.println("Artist ID : "+artistID);
            String artist_name = (String) map.get("artist_name");
            System.out.println("Artist Name : "+artist_name);
            String artist_category = (String) map.get("artist_category");
            System.out.println("Artist Category : "+artist_category);
            String artist_rating = (String) map.get("artist_rating");
            System.out.println("Artist Rating : "+artist_rating);

            ArrayList songList = (ArrayList) map.get("songs");

            for (int i = 0; i < songList.size(); i++) {
                Map<?, ?> s = (Map<?, ?>) songList.get(i);
                String song_id = s.get("song_id").toString();
                String song_name = s.get("song_name").toString();

                System.out.println("Song ID : "+song_id+" || Song Name : "+song_name);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}


