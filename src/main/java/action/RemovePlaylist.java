package action;

import model.MixTape;
import model.Playlist;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("remove_playlist")
public class RemovePlaylist implements IAction {
    @JsonProperty("playlist_id")
    private String playlistId;

    public void execute(final MixTape mixTape) throws Exception {
        Playlist playlist =  mixTape.getPlaylistById(playlistId);
        if(playlist == null) {
            throw new Exception("Playlist with Id: " + playlistId + " does not exist");
        }

        mixTape.getPlaylists().remove(playlist);
    }
}
