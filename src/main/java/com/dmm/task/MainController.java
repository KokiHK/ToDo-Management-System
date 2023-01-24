package com.dmm.task;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/main")
	public String main() {

		List<List<LocalDate>> month = new ArrayList<>();

		List<LocalDate> week = new ArrayList<>();

		LocalDate day;
		{

			day = LocalDate.now();
			day = LocalDate.of(day.getYear(), day.getMonthValue(), 1);

			DayOfWeek w = day.getDayOfWeek();
			day = day.minusDays(w.getValue());

			for (int i = 1; i <= 7; i++) {
				day = day.plusDays(1);
				week.add(day);
			}
			month.add(week);
			//System.out.println(week);
			week = new ArrayList<>();

			for (int i = 7; i <= day.lengthOfMonth(); i++) {

				week.add(day);

				DayOfWeek q = day.getDayOfWeek();
				
				day = day.plusDays(1);

				if (q == DayOfWeek.SATURDAY) {

					week.add(day);

					month.add(week);

					week = new ArrayList<>();

				}
				

			}
			System.out.println(month);

			//7日間入れた後weekの初期化忘れないこと
			//列挙型if文書き方。
			//day 代入していく

		}

		return "main";
	}
}
