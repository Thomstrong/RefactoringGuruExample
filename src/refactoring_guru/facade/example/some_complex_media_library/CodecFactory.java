package refactoring_guru.facade.example.some_complex_media_library;

public class CodecFactory {
    public static Codec extract(MediaFile file) {
        String type = file.getFileType();
        switch (type) {
            case "mp4":
                System.out.println("CodecFactory: extracting mpeg audio...");
                return new MPEG4CompressionCodec();
            case "mp3":
                System.out.println("CodecFactory: extracting mp3 audio...");
                return new MP3CompressionCodec();
            case "m4a":
                System.out.println("CodecFactory: extracting m4a audio...");
                return new M4ACompressionCodec();
            case "ogg":
                System.out.println("CodecFactory: extracting ogg audio...");
                return new OggCompressionCodec();
            default:
                System.out.println("CodecFactory: file type not exist");
                return null;
        }
    }
}
