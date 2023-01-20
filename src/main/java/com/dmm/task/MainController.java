package com.dmm.task;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/main")
	public String main() {
		return "main";
	}

	public int[][] calendarMatrix;

	List<Date> Week = new ArrayList<Date>();

	LocalDate Id;

	private void setLd(int month) {
		this.Id = LocalDate.of(this.getWeek().getValue(), month, 1);
	}
	
	private int getFirstDay() {
		return getLd().getDayOfWeek().getValue() - 1;
	}
	

	private Month getWeek() {

		return this.getWeek();
	}

	private LocalDate getLd() {
		return this.Id;
	}

	
	private int getMonthLength() {
		Month thisMonth = Month.from(getLd());
		return thisMonth.length(this.Id.isLeapYear());
	}

	
	

	public void calcFields() {

		int row = 0;
		int FD = getFirstDay();

		for (int date = 1; date <= getMonthLength(); date++) {
			this.calendarMatrix[row][FD] = date;
			
		}
	}
	
	
	

}