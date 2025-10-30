package util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import model.Transaction;

public class CSVExporter {
	public static void export(List<Transaction> transactions, String path) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(path))){
			writer.println("Date,Type,Amount,Origin,Destination");
			for (Transaction t : transactions){
				writer.printf("%s,%s,%.2f,%s,%s%n",
						t.getTimestamp(),
						t.getType(),
						t.getAmount(),
						t.getSource() != null ? t.getSource().getAccountNumber() : "-",
						t.getDestination() != null ? t.getDestination().getAccountNumber() : "-");
			}
			System.out.println();
			System.out.println("CSV exported!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
