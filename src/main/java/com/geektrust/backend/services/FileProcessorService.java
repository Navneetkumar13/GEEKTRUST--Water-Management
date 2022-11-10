package com.geektrust.backend.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.geektrust.backend.command.Commands;
import com.geektrust.backend.exceptions.WaterBillException;

public class FileProcessorService {

    private String filepath;

    public FileProcessorService(String filepath){
        if(filepath == null){
            throw new NullPointerException();
        }
        this.filepath = filepath;
    }

    public List<Commands> getCommandsFromFile() throws WaterBillException{
        try (Stream<String> lines = Files.lines(Paths.get(this.filepath))) {
            return lines.filter(line -> !isEmptyOrComment(line)).map(Commands::from).collect(Collectors.toList());
        }catch(IOException e){
            throw new WaterBillException("Error occurred while processing input file  " + filepath);
        }
    }


    private boolean isEmptyOrComment(String line) {
        return line.isEmpty() || line.trim().isEmpty() || line.trim().startsWith("#");
      }
}
