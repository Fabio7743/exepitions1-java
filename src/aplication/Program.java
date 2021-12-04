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
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: checK-out");
		}
		
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:" + reservation);
		}
		System.out.println();
		
		System.out.println("Enter data to update the reservation: ");
		System.out.print("ChecK-in date (dd/MM/yyyy) ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy) ");
		checkOut = sdf.parse(sc.next());
		
			Reservation reservation = null;
			String error =  reservation.updateDates ( checkIn, checkOut);
			
			if (error != null) {
				System.out.println("Error in reservation: "+ error);
			}
			else {
				System.out.println("Reservation: "+ reservation);
		}
			sc.close();
		
	}
}


