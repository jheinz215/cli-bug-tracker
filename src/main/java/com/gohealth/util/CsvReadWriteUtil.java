package com.gohealth.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.gohealth.model.Ticket;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

@Component
public class CsvReadWriteUtil {
	
	public List<Ticket> readFileToObjectList( String fileName ) {
		List<Ticket> ticketList = new ArrayList<Ticket>();
		try( FileReader reader = new FileReader(new ClassPathResource(fileName).getFile())){
			ticketList = new CsvToBeanBuilder<Ticket>(reader).withType(Ticket.class)
					.build()
					.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticketList;
	}
	
	public void writeObjectListToFile( List<Ticket> ticketList, String fileName ) {
		try (FileWriter writer = new FileWriter(new ClassPathResource(fileName).getFile())){
			StatefulBeanToCsvBuilder<Ticket> builder = 
					new StatefulBeanToCsvBuilder<Ticket>(writer);
			builder.build().write(ticketList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
