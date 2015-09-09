package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	public String[][] b2d() throws IOException {

		String filecsv = "./src/main/resources/Title_Validation.csv";
		BufferedReader bufrd = null;
		String line = null;
		String[] column = null;
		int lines = 0;
		int columns = 0;
		String splitBy = ",";
		String test_case_num = null;
		String url = null;
		String title_exp = null;

		// Counting lines and columns
		bufrd = new BufferedReader(new FileReader(filecsv));
		while ((line = bufrd.readLine()) != null){
			lines++;
			column = line.split(splitBy);
			columns = column.length;

		}
		bufrd.close();
		String d2d[][] = new String[lines][columns];
		bufrd = new BufferedReader(new FileReader(filecsv));
		WebDriver driver = new FirefoxDriver();
		int i = 0;
		while ((line = bufrd.readLine()) != null) {

			String[] csv = line.split(splitBy);
			test_case_num = csv[0];
			url = csv[1];
			title_exp = csv[2];

			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String title_act = driver.getTitle();

			d2d[i][0] = test_case_num;
			d2d[i][1] = title_exp;
			d2d[i][2] = title_act;

			i++;
		}

		driver.quit();
		bufrd.close();
		return d2d;
	}


}
