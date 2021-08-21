package refactoring_guru.facade.example.some_complex_media_library;

public class BitrateReader {
    public static MediaFile read(MediaFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static MediaFile convert(MediaFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}
