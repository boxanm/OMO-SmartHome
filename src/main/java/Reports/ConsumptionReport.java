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
 * @author Michal Koreš, Matìj Boxan
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class ConsumptionReport extends HouseTimeReport {
	final static String filename = "ConsumptionReport";

	private static final double electricityPrice = 4.5;
	private static final double waterPrice = 75;


	/**
	 * class serving as Consumption generator
	 */
	public ConsumptionReport() {
		name = filename;
	}

	/**
	 * multiples input with electricityPrice
	 * @param num number of used kW
	 * @return price of electricity
	 */
	private double countElectricity(double num){
		return num*electricityPrice;
	}

	/**
	 * multiples input with waterPrice
	 * @param num number of used m^3
	 * @return price of water
	 */
	private double countWater(double num){
		return num*waterPrice;
	}

	/**
	 * @param num number of used units
	 * @param consumptionType type of counted variable
	 * @return price
	 */
	private double countPrice(double num, ConsumptionType consumptionType){
		switch (consumptionType){
			case water:
				return countWater(num);
			case electricity:
				return countElectricity(num);
		}
		return 0;
	}

	/**
	 * @param consumptionType type of variable
	 * @return variable unit as string
	 */
	private String getUnit(ConsumptionType consumptionType){
		switch (consumptionType){
			case water:
				return "m^3";
			case electricity:
				return "kW";
		}
		return null;

	}

	/**
	 * returns formatted string based on input
	 * @param counter number of used units
	 * @param consumptionType type of used units
	 * @return formatted string
	 */
	private String getConsumptionString(double counter, ConsumptionType consumptionType){
		return ("---Used " + counter + " " + getUnit(consumptionType)+" of " + consumptionType + ". Total price: " + countPrice(counter,consumptionType)+ " Kè");
	}
	
	public void generateReport(House house, int start, int end, PrintWriter writer) {
		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		writer.println("==================Consumption report from lap "+start+" to " + end +"==================");
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
		}
	}

}