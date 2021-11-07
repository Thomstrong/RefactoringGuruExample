package refactoring_guru.proxy.example;

import refactoring_guru.proxy.example.downloader.CloudMusicDownloader;
import refactoring_guru.proxy.example.downloader.YoutubeDownloader;
import refactoring_guru.proxy.example.proxy.CloudMusicCacheProxy;
import refactoring_guru.proxy.example.proxy.YoutubeCacheProxy;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyCloudMusicClass;
import refactoring_guru.proxy.example.some_cool_media_library.ThirdPartyYoutubeClass;

public class Demo {

    public static void main(String[] args) {
        YoutubeDownloader naiveDownloader = new YoutubeDownloader(new ThirdPartyYoutubeClass());
        YoutubeDownloader smartDownloader = new YoutubeDownloader(new YoutubeCacheProxy());

        long naive = testVideo(naiveDownloader);
        long smart = testVideo(smartDownloader);
        System.out.print("Time saved by caching proxy: " + (naive - smart) + "ms");

        CloudMusicDownloader normalDownloader = new CloudMusicDownloader(new ThirdPartyCloudMusicClass());
        CloudMusicDownloader cachedDownloader = new CloudMusicDownloader(new CloudMusicCacheProxy());

        long normalDuration = testMusic(normalDownloader);
        long cachedDuration = testMusic(cachedDownloader);
        System.out.print("Time saved by caching proxy: " + (normalDuration - cachedDuration) + "ms");

    }

    private static long testVideo(YoutubeDownloader downloader) {
        long startTime = System.currentTimeMillis();

        // User behavior in our app:
        downloader.renderPopularVideos();
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderPopularVideos();
        downloader.renderVideoPage("dancesvideoo");
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz");
        downloader.renderVideoPage("someothervid");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }

    private static long testMusic(CloudMusicDownloader downloader) {
        long startTime = System.currentTimeMillis();

        downloader.renderRecommendPage();
        downloader.renderMusicPage("Only you");
        downloader.renderRecommendPage();
        downloader.renderMusicPage("Music 2");
        downloader.renderMusicPage("Music 2");
        downloader.renderMusicPage("Music 3");
        downloader.renderMusicPage("Music 3");
        downloader.renderMusicPage("Only you");
        downloader.renderMusicPage("Only you");

        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("Time elapsed: " + estimatedTime + "ms\n");
        return estimatedTime;
    }
}