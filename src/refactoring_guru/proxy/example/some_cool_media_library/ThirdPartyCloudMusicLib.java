package refactoring_guru.proxy.example.some_cool_media_library;

import java.util.HashMap;

public interface ThirdPartyCloudMusicLib {
    public HashMap<String, Music> todayRecommend();

    public Music getMusic(String musicId);
}
