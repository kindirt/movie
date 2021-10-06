package server_client;

public class SeatDto {
	private int seat_id;
	
	private String seat_detail;
	@Override
	public String toString() {
		return "SeatDto [seat_id=" + seat_id  + ", seat_detail=" + seat_detail + "]";
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	
	public String getSeat_detail() {
		return seat_detail;
	}
	public SeatDto(int seat_id, String seat_detail) {
		super();
		this.seat_id = seat_id;
		this.seat_detail = seat_detail;
	}
	public void setSeat_detail(String seat_detail) {
		this.seat_detail = seat_detail;
	}

}
