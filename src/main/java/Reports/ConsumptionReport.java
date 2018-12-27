package Reports;


import Appliances.Appliance;
import Appliances.ConsumptionType;
import EventsAlerts.*;
import House.House;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class ConsumptionReport extends HouseReport {

	private static final double electricityPrice = 4.5;
	private static final double waterPrice = 75;


	public ConsumptionReport() {

	}

	private double countElectricity(double num){
		return num*electricityPrice;
	}

	private double countWater(double num){
		return num*waterPrice;
	}

	private double countPrice(double num, ConsumptionType consumptionType){
		switch (consumptionType){
			case water:
				return countWater(num);
			case electricity:
				return countElectricity(num);
		}
		return 0;
	}

	private String getUnit(ConsumptionType consumptionType){
		switch (consumptionType){
			case water:
				return "m^3";
			case electricity:
				return "kW";
		}
		return null;

	}


	private String getConsumptionString(double counter, ConsumptionType consumptionType){
		return ("---Used " + counter + " " + getUnit(consumptionType)+" of " + consumptionType + ". Total price: " + countPrice(counter,consumptionType)+ " Kè");
	}


	/**
	 * @param house
	 * @param start
	 * @param end
	 */

	public void generateReport(House house, int start, int end) {
		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		System.out.println("==================Consumption report from lap "+start+" to " + end +"==================");
		ArrayList<Consumption> consumptions = (ArrayList<Consumption>) allEvents
				.stream()
				.filter(Consumption.class::isInstance)
				.map(Consumption.class::cast)
				.filter(consumption -> consumption.getType() == ConsumptionType.electricity || consumption.getType() == ConsumptionType.water)
				.filter(consumption -> consumption.getLapNumber() >= start && consumption.getLapNumber() < end)
				.sorted(Comparator.comparing((Consumption consumption) -> consumption.getSource().toString())
						.thenComparing(Consumption::getType))
				.collect(Collectors.toList());

		if (consumptions.size() > 0) {

			Appliance source = (Appliance) consumptions.get(0).getSource();
			ConsumptionType consumptionType = consumptions.get(0).getType();
			double counter = 0;
			double totalElectricityConsumption = 0;
			double totalWaterConsumption = 0;

			System.out.println("Appliance: " + source.toString());
			for (Consumption info : consumptions) {
				if (info.getSource() != source) {
					System.out.println(getConsumptionString(counter,consumptionType));
					consumptionType = info.getType();
					source = (Appliance) info.getSource();
					System.out.println("Appliance: " + source.toString());
					switch (consumptionType){
						case water:
							totalWaterConsumption += counter;
							break;
						case electricity:
							totalElectricityConsumption += counter;
							break;
					}
					counter = 0;
				}

				if (info.getType() != consumptionType) {
					System.out.println(getConsumptionString(counter,consumptionType));
					consumptionType = info.getType();
					counter = info.getConsumption();
				} else counter += info.getConsumption();
			}
			System.out.println(getConsumptionString(counter,consumptionType));
			System.out.println();
			System.out.println("Total water consumption:");
			System.out.println(getConsumptionString(totalWaterConsumption,ConsumptionType.water));
			System.out.println("Total electricity consumption:");
			System.out.println(getConsumptionString(totalElectricityConsumption,ConsumptionType.electricity));
		}
	}

	public void generateEventReportToFile(House house, int start, int end) {
		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");

		String timeLog = "src/main/java/Reports/EvenReport " + time.format(dtf) + ".txt";
		try {
			PrintWriter writer = new PrintWriter(timeLog, "UTF-8");
			System.out.println("==================Consumption report from lap "+start+" to " + end +"==================");
			ArrayList<Consumption> consumptions = (ArrayList<Consumption>) allEvents
					.stream()
					.filter(Consumption.class::isInstance)
					.map(Consumption.class::cast)
					.filter(consumption -> consumption.getLapNumber() >= start && consumption.getLapNumber() < end)
					.sorted(Comparator.comparing((Consumption consumption) -> consumption.getSource().toString())
							.thenComparing(Consumption::getType))
					.collect(Collectors.toList());

			if (consumptions.size() > 0) {

				Appliance source = (Appliance) consumptions.get(0).getSource();
				ConsumptionType consumptionType = consumptions.get(0).getType();
				double counter = 0;
				double totalElectricityConsumption = 0;
				double totalWaterConsumption = 0;

				writer.println("Appliance: " + source.toString());
				for (Consumption info : consumptions) {
					if (info.getSource() != source) {
						writer.println(getConsumptionString(counter,consumptionType));
						consumptionType = info.getType();
						source = (Appliance) info.getSource();
						writer.println("Appliance: " + source.toString());
						switch (consumptionType){
							case water:
								totalWaterConsumption += counter;
								break;
							case electricity:
								totalElectricityConsumption += counter;
								break;
						}
						counter = 0;
					}

					if (info.getType() != consumptionType) {
						writer.println(getConsumptionString(counter,consumptionType));
						consumptionType = info.getType();
						counter = info.getConsumption();
					} else counter += info.getConsumption();
				}
				writer.println(getConsumptionString(counter,consumptionType));
				writer.println();
				writer.println("Total water consumption:");
				writer.println(getConsumptionString(totalWaterConsumption,ConsumptionType.water));
				writer.println("Total electricity consumption:");
				writer.println(getConsumptionString(totalElectricityConsumption,ConsumptionType.electricity));
				writer.close();

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}