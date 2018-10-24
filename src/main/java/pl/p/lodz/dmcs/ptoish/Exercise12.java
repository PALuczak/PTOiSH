package pl.p.lodz.dmcs.ptoish;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

import java.nio.charset.Charset;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.MappedByteBuffer;

import java.time.Instant;

import java.util.Random;
import java.util.stream.IntStream;

public class Exercise12 {
    static String FILE = "exercise12.bin";

    public static void main(String[] args) {
        System.out.println("Exercise 1.2");
        System.out.println("Generate file");
        MyBenchmark.printTime(Exercise12::createLargeFile);
        System.out.println("Reading buffered");
        MyBenchmark.printTimeMultiple(Exercise12::readBuffered);
        System.out.println("Reading NIO");
        MyBenchmark.printTimeMultiple(Exercise12::readNIO);
        System.out.println("Reading mapped");
        MyBenchmark.printTimeMultiple(Exercise12::readMemoryMapped);
        System.out.println("Finished");

    }

    private static void createLargeFile() {
        try (FileOutputStream fileOut = new FileOutputStream(FILE)) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                Random random = new Random(Instant.now().getNano());
                IntStream ints = random.ints(200000000);
                ints.forEach(val -> {
                    try {
                        out.write(val);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            System.out.println("File created");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static void readBuffered() {
        try (FileReader fileReader = new FileReader(new File(FILE))) {
            try (BufferedReader reader = new BufferedReader(fileReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = null;
                    continue;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readNIO() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE), Charset.forName("ISO-8859-1"))) {
            while (reader.read() != -1) {
                continue;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void readMemoryMapped() {
        try (FileChannel fileChannel = new RandomAccessFile(Paths.get(FILE).toFile(), "r").getChannel()) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            while (mappedByteBuffer.hasRemaining()) {
                mappedByteBuffer.get();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
