package refactoring_guru.facade.example;

import refactoring_guru.facade.example.facade.AudioConversionFacade;
import refactoring_guru.facade.example.facade.VideoConversionFacade;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        System.out.println("=========== start video demo ============");
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");
        System.out.println("=========== start audio demo ============");
        AudioConversionFacade audioConverter = new AudioConversionFacade();
        File mp3Audio = audioConverter.convertAudio("dangerious.m4a", "mp3");
        // ...
    }
}
