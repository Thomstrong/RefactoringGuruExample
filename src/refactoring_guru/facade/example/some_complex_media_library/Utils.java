package refactoring_guru.facade.example.some_complex_media_library;

import java.io.File;

public class Utils {
    public static File convertFile(MediaFile file, Codec sourceCodec, Codec destinationCodec) {
        MediaFile buffer = BitrateReader.read(file, sourceCodec);
        MediaFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        return (new AudioMixer()).fix(intermediateResult);
    }
}
