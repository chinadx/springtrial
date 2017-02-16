package cn.goodman.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Shaun on 2017/2/16.
 */
public class PathGoGoGo {
    private static Log log = LogFactory.getLog(PathGoGoGo.class);
    public static void main(String[] args) {
        Path path = Paths.get("F:\\temp", "learn", "path");
        log.info(path.getName(1));
        try {
            Files.copy(Paths.get("F:\\temp\\260.jpeg"), Paths.get("F:\\temp\\666.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
