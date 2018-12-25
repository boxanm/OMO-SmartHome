package Reports;


import Appliances.Appliance;
import EventsAlerts.*;
import House.House;
import Organism.Organism;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author Michal
 * @version 1.0
 * @created 16-pro-2018 9:02:12
 */
public class ConsumptionReport extends HouseReport {

	public ConsumptionReport(){

	}

	/**
	 * @param house
	 * @param start
	 * @param end
	 */
	public void generateReport(House house, int start, int end){


		ArrayList<Event> allEvents = house.getEventReporter().getAllEvents();
		System.out.println("==================Consumption report==================");
		ArrayList<Consumption> consumptions = (ArrayList<Consumption>) allEvents
				.stream()
				.filter(Consumption.class::isInstance)
				.map(Consumption.class::cast)
				.filter(consumption -> consumption.getLapNumber() >= start && consumption.getLapNumber() < end)
				.sorted(Comparator.comparing((Consumption consumption) -> consumption.getSource().toString())
						.thenComparing(Consumption::getType))
				.collect(Collectors.toList());

		if(consumptions.size() > 0){

			Appliance source = (Appliance) consumptions.get(0).getSource();
			ConsumptionType consumptionType = consumptions.get(0).getType();
			int counter = 0;

			System.out.println("Appliance: " + source.toString());
			for (Consumption info:consumptions) {
				if(info.getSource() != source) {
					System.out.println("---Used " + counter + " of" +consumptionType);
					consumptionType = info.getType();
					source = (Appliance) info.getSource();
					System.out.println("Appliance: " + source.toString());
					counter = 0;
				}

				if(info.getType() != consumptionType){
					System.out.println("---Used " + counter + " of" +consumptionType);
					consumptionType = info.getType();
					counter = info.getConsuption();
				}
				else counter+=info.getConsuption();
			}
			System.out.println("---Used " + counter + " of" +consumptionType);
			System.out.println();
		}


	}

}