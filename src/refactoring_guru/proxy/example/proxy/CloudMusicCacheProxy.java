package refactoring_guru.proxy.example.proxy;

import refactoring_guru.proxy.example.some_cool_media_library.Music;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyCloudMusicClass;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyCloudMusicLib;

import java.util.HashMap;

public class CloudMusicCacheProxy implements ThirdPartyCloudMusicLib {
    ThirdPartyCloudMusicLib cloudMusicService;
    private HashMap<String, Music> cachedRecommendMusic = new HashMap<>();
    private HashMap<String, Music> cachedAll = new HashMap<>();

    public CloudMusicCacheProxy() {
        this.cloudMusicService = new ThirdPartyCloudMusicClass();
    }

    @Override
    public HashMap<String, Music> todayRecommend() {
        if (cachedRecommendMusic.isEmpty()) {
            cachedRecommendMusic = cloudMusicService.todayRecommend();
        } else {
            System.out.println("Get recommend from cache!");
        }
        return cachedRecommendMusic;
    }

    @Override
    public Music getMusic(String musicId) {
        if (this.cachedAll.get(musicId) == null) {
            this.cachedAll.put(musicId, cloudMusicService.getMusic(musicId));
        } else {
            System.out.println("Get music " + musicId + " from cache!");
        }
        return cachedAll.get(musicId);
    }
}
