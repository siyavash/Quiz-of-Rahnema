package com.rahnema;

import com.rahnema.controller.AccountController;
import com.rahnema.model.entity.Option;
import com.rahnema.model.entity.Question;
import com.rahnema.repository.OptionRepository;
import com.rahnema.repository.QuestionRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;

@EnableResourceServer
@SpringBootApplication
public class QuizOfRahnemaApplication implements CommandLineRunner {

    private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AccountController.class);

	public static void main(String[] args) {
		SpringApplication.run(QuizOfRahnemaApplication.class, args);
	}

	@Autowired
    QuestionRepository questionRepository;

	@Autowired
    OptionRepository optionRepository;

	private String longToString(long x) {
		String ret = "";
		while(x != 0) {
			ret += x % 10 + '0';
			x /= 10;
		}

		return ret;
	}

	private String cleanText(String text) {
		while(('0' <= text.charAt(0) && text.charAt(0) <= '9') || text.charAt(0) == '.' || text.charAt(0) == ' ') {
			text = text.substring(1);
		}

        while(('0' <= text.charAt(text.length() - 1) && text.charAt(text.length() - 1) <= '9') || text.charAt(text.length() - 1) == '.' || text.charAt(text.length() - 1) == ' ') {
            text = text.substring(0, text.length() - 1);
        }
		return text;
	}

	@Override
	public void run(String... args) throws Exception {
//			Scanner scanner = new Scanner(value);
//
//
//			if(! scanner.hasNextLine()) {
//				continue;
//			}
//			String text;
//			do{
//				text = scanner.nextLine();
//			} while (text.isEmpty() && scanner.hasNextLine());
//
//			if(! scanner.hasNextLine()) {
//				continue;
//			}
//			question.setText(cleanText(text));
//			questionRepository.save(question);
//
//			log.info(value);
//			while(scanner.hasNextLine()) {
//				String op = scanner.nextLine();
//
//				Option option = new Option();
//				option.setText(cleanText(op));
//				option.setQuestion(question);
//
//				optionRepository.save(option);
//
//				if(corAns > 0 && op.contains(longToString(corAns))) {
//					question.setCorrectAnswer(option.getId());
//				}
//			}
//			scanner.close();
	}

}
