package action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import model.MixTape;
import model.Playlist;

@JsonTypeName("add_playlist")
public class AddPlaylist implements IAction {

    @JsonProperty("playlist")
    private Playlist playlist;

    public void execute(final MixTape mixTape) throws Exception {
        if(playlist.getSongIds().size() == 0) {
            throw new Exception("The playlist has no songs");
        }

        if (mixTape.getPlaylistById(playlist.getId()) != null) {
            throw new Exception("The playlist already exists");
        }

        if (mixTape.getUserById(playlist.getUserId()) == null) {
            throw new Exception("The playlist already exists");
        }

        for (String songId : playlist.getSongIds()) {
            if (mixTape.getSongById(songId) == null) {
                throw new Exception("Song id: " + songId + " does not exist");
            }
        }

        mixTape.getPlaylists().add(playlist);
    }
}