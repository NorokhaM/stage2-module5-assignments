package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private static List<String> stringArrayList = new ArrayList<>();
    private StringBuilder builder;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationscanner, List<String> stringArrayList) {
        this.processorName= processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationscanner;
        LocalProcessor.stringArrayList = stringArrayList;
        builder = new StringBuilder(processorName);
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        try {
            stringArrayList = new ArrayList<>(stringList);
            for (String s : stringArrayList) {
                System.out.println(s.hashCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        for (String s : stringList) {
            builder.append(s).append(" ");
        }
        processorName=builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        try {
            informationScanner = new Scanner(file);
            builder = new StringBuilder(processorName);
            while (informationScanner.hasNext()) {
                builder.append(informationScanner.nextLine());
            }
            processorName = builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            informationScanner.close();
        }
    }
}
