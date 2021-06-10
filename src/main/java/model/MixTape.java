package model;

import java.util.List;

public class MixTape {
    private List<User> users;
    private List<Playlist> playlists;
    private List<Song> songs;

    public MixTape() {}

    public MixTape(List<User> userList, List<Playlist> playlistList, List<Song> songList) {
        this.users.addAll(userList);
        this.playlists.addAll(playlistList);
        this.songs.addAll(songList);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public User getUserById(String userId) {
        for(User user : users) {
            if(user.getId().equals(userId))
                return user;
        }
        return null;
    }

    public Playlist getPlaylistById(String playListId) {
        for(Playlist playlist : playlists) {
            if(playlist.getId().equals(playListId))
                return playlist;
        }
        return null;
    }

    public Song getSongById(String songId) {
        for(Song song : songs) {
            if(song.getId().equals(songId))
                return song;
        }
        return null;
    }
}
