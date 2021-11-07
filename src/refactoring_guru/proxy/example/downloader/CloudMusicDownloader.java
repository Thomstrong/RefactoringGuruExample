package refactoring_guru.proxy.example.downloader;

import refactoring_guru.proxy.example.some_cool_media_library.Music;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyCloudMusicLib;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyYoutubeLib;
import refactoring_guru.proxy.example.some_cool_media_library.Video;

import java.util.HashMap;

public class CloudMusicDownloader {
    private ThirdPartyCloudMusicLib api;

    public CloudMusicDownloader(ThirdPartyCloudMusicLib api) {
        this.api = api;
    }

    public void renderMusicPage(String musicId) {
        Music music = api.getMusic(musicId);
        System.out.println("\n-------------------------------");
        System.out.println("Music Detail (imagine fancy HTML)");
        System.out.println("ID: " + music.id);
        System.out.println("Title: " + music.title);
        System.out.println("Video: " + music.data);
        System.out.println("-------------------------------\n");
    }

    public void renderRecommendPage() {
        HashMap<String, Music> list = api.todayRecommend();
        System.out.println("\n-------------------------------");
        System.out.println("Today Recommend musics on CloudMusic(imagine fancy HTML)");
        for (Music music : list.values()) {
            System.out.println("ID: " + music.id + " / Title: " + music.title);
        }
        System.out.println("-------------------------------\n");
    }
}
