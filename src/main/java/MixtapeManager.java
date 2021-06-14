import java.io.File;

import action.IAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.MixTape;

public class MixtapeManager {

    public static void main(String[] args) {

        File inputFile = new File(args[0]);
        File changesFile = new File(args[1]);
        File output = new File(args[2]);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MixTape mixTape = objectMapper.readValue(inputFile, MixTape.class);
            IAction[] actions = objectMapper.readValue(changesFile, IAction[].class);


            for (IAction action : actions) {
                action.execute(mixTape);
            }

            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(output, mixTape);
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
