package refactoring_guru.facade.example.some_complex_media_library;

import java.io.File;

public class AudioMixer {
    public File fix(MediaFile result) {
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}
