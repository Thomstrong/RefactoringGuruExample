package refactoring_guru.facade.example.some_complex_media_library;

/**
 * @author thomstrong
 */
public class AudioFile implements MediaFile {
    String fileName;
    String fileType;

    public AudioFile(String fileName) {
        this.fileName = fileName;
        this.fileType = fileName.substring(fileName.indexOf(".") + 1);
    }

    @Override
    public String getFileType() {
        return this.fileType;
    }
}
