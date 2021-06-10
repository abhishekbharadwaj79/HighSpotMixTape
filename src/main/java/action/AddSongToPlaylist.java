package action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import model.MixTape;
import model.Playlist;
import model.Song;

@JsonTypeName("add_song_to_playlist")
public class AddSongToPlaylist implements IAction {
    @JsonProperty("song_id")
    private String songId;

    @JsonProperty("playlist_id")
    private String playlistId;

    public void execute(final MixTape mixTape) throws Exception {

        final Song song = mixTape.getSongById(songId);
        if (song == null) {
            throw new Exception("Song with Id: " + songId + " does not exist");
        }

        final Playlist playList = mixTape.getPlaylistById(playlistId);
        if (playList == null) {
            throw new Exception("Playlist with Id: " + playlistId + " does not exist");
        }

        if (playList.getSongIds().contains(songId)) {
            throw new Exception("Song with Id: " + songId + " already exists in playlist with Id: " + playlistId);
        }

        playList.getSongIds().add(songId);
    }
}
