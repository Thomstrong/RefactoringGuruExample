package refactoring_guru.facade.example.facade;

import refactoring_guru.facade.example.some_complex_media_library.*;
import refactoring_guru.facade.example.some_complex_media_library.*;

import java.io.File;

public class VideoConversionFacade {
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");
        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new OggCompressionCodec();
        } else {
            destinationCodec = new MPEG4CompressionCodec();
        }
        File result = Utils.convertFile(file, sourceCodec, destinationCodec);
        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}
