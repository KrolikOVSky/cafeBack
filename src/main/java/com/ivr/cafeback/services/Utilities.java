package com.ivr.cafeback.services;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class Utilities {
    @Value("${upload.path}")
    private String uploadPath;

    public static String convert(String word) {
        StringBuilder result = new StringBuilder();
        word = word.toLowerCase();
        for (var letter : word.toCharArray()) {
            result.append(cyrillicToLatin(String.valueOf(letter)));
        }
        return result.toString();
    }

    private static String cyrillicToLatin(String letter) {
        switch (letter) {
            case "а":
                return "a";
            case "б":
                return "b";
            case "в":
                return "v";
            case "г":
                return "g";
            case "д":
                return "d";
            case "е":
            case "э":
                return "e";
            case "ё":
                return "yo";
            case "ж":
                return "zh";
            case "з":
                return "z";
            case "и":
                return "i";
            case "й":
                return "y";
            case "к":
                return "k";
            case "л":
                return "l";
            case "м":
                return "m";
            case "н":
                return "n";
            case "о":
                return "o";
            case "п":
                return "p";
            case "р":
                return "r";
            case "с":
                return "s";
            case "т":
                return "t";
            case "у":
                return "u";
            case "ф":
                return "f";
            case "х":
                return "h";
            case "ц":
                return "c";
            case "ч":
                return "ch";
            case "ш":
                return "sh";
            case "щ":
                return "sch";
            case "ы":
                return "y";
            case "ю":
                return "yu";
            case "я":
                return "ya";
            case " ":
                return "-";
            case "ъ":
            case "ь":
                return "";
            default:
                return letter;
        }
    }

    private static String latinToCyrillic(String letter) {
        switch (letter) {
            case "a":
                return "а";
            case "b":
                return "б";
            case "c":
                return "ц";
            case "d":
                return "д";
            case "e":
                return "е";
            case "f":
                return "ф";
            case "g":
                return "г";
            case "h":
                return "х";
            case "i":
                return "и";
            case "j":
                return "дж";
            case "k":
                return "к";
            case "l":
                return "л";
            case "m":
                return "м";
            case "n":
                return "н";
            case "o":
                return "о";
            case "p":
                return "п";
            case "q":
                return "к";
            case "r":
                return "р";
            case "s":
                return "с";
            case "t":
                return "т";
            case "u":
                return "ю";
            case "v":
                return "в";
            case "w":
                return "в";
            case "x":
                return "кс";
            case "y":
                return "й";
            case "z":
                return "з";
            case " ":
                return "-";
            default:
                return "";
        }
    }

    public boolean fileSave(String content) {
        try {
            File filePath = new File(this.uploadPath);
            if (!filePath.exists()) {
                System.out.println(filePath.mkdir());
            }

            File file = new File(String.format("%s/%s", filePath.getPath(), new Date()));

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(content);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void base64Decode(String content) {

    }

    public static String getExtension(String code) {
        return code.substring(code.indexOf("/") + 1, code.lastIndexOf(";"));
    }

    public static String getBase64(String code) {
        return code.substring(code.indexOf(",") + 1);
    }

    private static void base64ToImage(String content) throws IOException {
//        byte[] decodedBytes = Base64.getDecoder().decode(content);
//        FileUtils.writeByteArrayToFile(new File("/home/alex/Desktop/Test/img.png"), decodedBytes);
    }

    public static String saveImages(String code, String path) {
        String base64 = getBase64(code);
        String extension = getExtension(code);
        String fileName = String.format("%s.%s", UUID.randomUUID(), extension);

        try {
            File file = new File(String.format("%s/%s", path, fileName));
            if(!new File(path).exists()){
                System.out.println(new File(path).mkdir());
            }
            byte[] decodedBytes = Base64.getDecoder().decode(base64);
            FileUtils.writeByteArrayToFile(file, decodedBytes);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return fileName;
    }

}
