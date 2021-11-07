package refactoring_guru.proxy.example.some_cool_media_library;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


public class ThirdPartyCloudMusicClass implements ThirdPartyCloudMusicLib {

    @Override
    public HashMap<String, Music> todayRecommend() {
        connectToServer("http://music.163.com");
        return getRandomMusics();
    }

    @Override
    public Music getMusic(String musicTitle) {
        connectToServer("http://music.163.com");
        return getMusicByName(musicTitle);
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    private HashMap<String, Music> getRandomMusics() {
        System.out.println("Downloading recommends...");
        experienceNetworkLatency();
        HashMap<String, Music> result = new HashMap<>();
        result.put("Only you", new Music(getMd5Of("only-you"), "Only you"));
        result.put("Music 2", new Music(getMd5Of("Music-2"), "Music 2"));
        result.put("Music 3", new Music(getMd5Of("Music-3"), "Music 3"));
        result.put("Music 4", new Music(getMd5Of("Music-4"), "Music 4"));

        return result;
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private String getMd5Of(String s) {
        MessageDigest m = null;
        try {
            m = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "shit!";
        }
        m.update(s.getBytes());
        byte[] digest = m.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private Music getMusicByName(String musicTitle) {
        System.out.println("Downloading music " + musicTitle + "...");
        experienceNetworkLatency();
        Music music = new Music(getMd5Of(musicTitle), "Music of " + musicTitle);

        System.out.println("Done!");
        return music;
    }
}
