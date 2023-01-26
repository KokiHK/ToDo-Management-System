package com.dmm.task;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
			if (w == DayOfWeek.SUNDAY) {
				// 何もしない
			} else {
				day = day.minusDays(w.getValue());
			}

			for (int i = 1; i <= 7; i++) {
				week.add(day);
				day = day.plusDays(1);
			}
			month.add(week);
			week = new ArrayList<>();

			System.out.println(day.lengthOfMonth());
			for (int i = 7; i <= day.lengthOfMonth(); i++) {

				week.add(day);

				DayOfWeek q = day.getDayOfWeek();
				if (q == DayOfWeek.SATURDAY) {
					month.add(week);
					week = new ArrayList<>();
				}

				day = day.plusDays(1);
			}

			System.out.println(month);
		}

		MultiValueMap<LocalDate, Tasks> tasks = new LinkedMultiValueMap<LocalDate, Tasks>();

		model.addAttribute("tasks", tasks);
		model.addAttribute("matrix", month);
		
		
		return "main";
	}

	
	
}

