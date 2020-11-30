package be.pxl.ja;

import java.nio.file.Path;

public class PathOefening2 {
    public static void main(String[] args) {
        String userHome = System.getProperty("user.home");
        Path userHomePath = Path.of(userHome);
        Path linuxDirectoryPath = userHomePath.resolve("documents").resolve("os").resolve("linux");

        System.out.println(userHomePath);
        System.out.println(linuxDirectoryPath);

        System.out.println();

        System.out.println(linuxDirectoryPath.toString());
        System.out.println(linuxDirectoryPath.getFileName());
        System.out.println(linuxDirectoryPath.getName(0));
        System.out.println(linuxDirectoryPath.getNameCount());
        System.out.println(linuxDirectoryPath.subpath(0, 2));
        System.out.println(linuxDirectoryPath.getParent());
        System.out.println(linuxDirectoryPath.getRoot());
    }
}
