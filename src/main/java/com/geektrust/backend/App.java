package com.geektrust.backend;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.geektrust.backend.command.Commands;
import com.geektrust.backend.command.GeekCommunity;
import com.geektrust.backend.exceptions.WaterBillException;
import com.geektrust.backend.services.FileProcessorService;

public class App {

	private static final Integer WATER_ALLOCATED_PER_PERSON_PER_DAY = 10;
	private static final Integer BILLABLE_DAYS_IN_MONTH = 30;

	// to Run ./gradlew run -args [filepath]
	// eg. ./gradlew run -args "input.txt"

	public static void main(String[] args) {
		//System.out.println("Welcome to Geektrust Backend Challenge!");
		try{
			if (args.length != 1) {
				throw new WaterBillException("Input file not supplied. Please provide the input file");
		}
		String filePath = args[0];
		FileProcessorService fileReaderService = new FileProcessorService(filePath);
		List<Commands> commands = fileReaderService.getCommandsFromFile();
		GeekCommunity geekHeightsCommunity =
          new GeekCommunity(WATER_ALLOCATED_PER_PERSON_PER_DAY, BILLABLE_DAYS_IN_MONTH);

		List<String> outputs =
          commands.stream()
              .map(
                  command ->
                      command
                          .getOperator()
                          .getOperationService()
                          .get()
                          .processOperation(command.getOperands(), geekHeightsCommunity))
              .filter(Objects::nonNull)
              .collect(Collectors.toList());

		outputs.forEach(System.out::println);
	}catch (Exception e) {
		System.out.println(e.getMessage());
	  }

}
}
