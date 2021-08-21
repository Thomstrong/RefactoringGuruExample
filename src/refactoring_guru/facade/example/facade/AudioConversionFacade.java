package refactoring_guru.facade.example.facade;

import refactoring_guru.facade.example.some_complex_media_library.*;

import java.io.File;

public class AudioConversionFacade {
    public File convertAudio(String fileName, String targetFormat) {
        System.out.println("AudioConversionFacade: start convert audio");

        MediaFile sourceAudio = new AudioFile(fileName);
        if (sourceAudio.getFileType().equalsIgnoreCase(targetFormat)) {
            return new File(fileName);
        }
        // do something convert file
        Codec sourceCodec = CodecFactory.extract(sourceAudio);
        Codec targetCodec;
        if (targetFormat.equalsIgnoreCase("m4a")) {
            targetCodec = new M4ACompressionCodec();
        } else {
            targetCodec = new MP3CompressionCodec();
        }
        File result = Utils.convertFile(sourceAudio, sourceCodec, targetCodec);

        System.out.println("AudioConversionFacade: conversion completed.");
        return result;
    }
}
