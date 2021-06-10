package action;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import model.MixTape;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "action")
@JsonSubTypes({
        @JsonSubTypes.Type(value = AddPlaylist.class, name = "add_playlist"),
        @JsonSubTypes.Type(value = RemovePlaylist.class, name = "remove_playlist"),
        @JsonSubTypes.Type(value = AddSongToPlaylist.class, name = "add_song_to_playlist")
})
public interface IAction {
    void execute(final MixTape musicInfo) throws Exception;
}
