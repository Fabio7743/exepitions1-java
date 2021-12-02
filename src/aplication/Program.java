package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new  Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number : ");
		int number = sc.nextInt();
		System.out.print("Chec-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Chec-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if ( !checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date be after check-in date");
				
		}
		else {
			Reservation reservation = new Reservation (number, checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
		}
		sc.close();
		
	}

}
