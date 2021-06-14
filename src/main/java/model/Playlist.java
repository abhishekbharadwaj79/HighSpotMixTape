package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;


public class Playlist {
    private String id;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("song_ids")
    private List<String> songIds = new ArrayList<String>();

    public Playlist() {}

    public Playlist(String id, String userId, List<String> songIds) {
        this.id = id;
        this.userId = userId;
        this.songIds = songIds;
    }

    public String getUserId() {
        return userId;
    }

    public List<String> getSongIds() {
        return songIds;
    }

    public String getId() {
        return id;
    }
}
