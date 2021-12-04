package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checKin;
	private Date checKOut;
	public Reservation(Integer roomNumber, Date checKin, Date checKOut) {
		
		this.roomNumber = roomNumber;
		this.checKin = checKin;
		this.checKOut = checKOut;
	}
		private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getChecKin() {
		return checKin;
	}

	public Date getChecKOut() {
		return checKOut;
	}
	public long duration(){
		long diff = checKOut.getTime() - checKin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checKOut, Date checKin) {
		
		Date now = new Date();
		if (checKin.before(now)|| checKOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if(!checKOut.after(checKin)) {
			return "Check-out date must be after check-in date";
		}
		
		this.checKin = checKin;
		this.checKOut = checKOut;
		return null;
	}
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format (checKin)
				+ " check-out: "
				+ sdf.format (checKOut)				
				+ ", "
				+ duration ( )
				+ " nights";
		
	}
}
