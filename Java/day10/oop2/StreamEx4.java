package day10.oop2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamEx4 {
    public static void main(String[] args) throws IOException {
        StreamEx4 ex = new StreamEx4();
        ex.filesLines();
    }

    private void filesLines() throws IOException {
        String dir = "C:/Users/minay/IdeaProjects/java/src/day10/";
        Path path = Paths.get(dir);
        Stream<Path> fileStream = Files.list(path);

        fileStream.flatMap(StreamEx4::getLines)
                .forEach(System.out::println);
    }

        private static Stream<String> getLines (Path f) {
            try {
                return Files.lines(f);
            } catch (IOException e) {
                return Stream.empty();
            }
        }

    }

