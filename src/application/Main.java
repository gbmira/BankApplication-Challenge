package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import model.Account;
import model.CheckingsAccount;
import model.Customer;
import model.SavingsAccount;
import model.Transaction;
import service.BankService;
import util.CSVExporter;

public class Main {

	private static Scanner sc = new Scanner(System.in);
	private static List<Account> accounts = new ArrayList<>();
	private static BankService bankService = new BankService();

	public static void main(String[] args) {
        Menu menuHandler = new Menu();
        menuHandler.run();
    }
}