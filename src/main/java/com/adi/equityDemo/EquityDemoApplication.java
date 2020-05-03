package com.adi.equityDemo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adi.equityDemo.entities.Security;
import com.adi.equityDemo.entities.SecurityInfo;
import com.adi.equityDemo.repositories.SecurityRepository;
import com.adi.equityDemo.utils.EquityUtil;
import com.adi.equityDemo.utils.FileToBeanUtil;

@SpringBootApplication
public class EquityDemoApplication implements CommandLineRunner {

	@Autowired
	private SecurityRepository securityRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EquityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String filePath = "C:\\Users\\gullu\\Downloads\\EQ300420.csv";
		List<Security> securityList = FileToBeanUtil.readCSVToObjects(Security.class, filePath);
		List<SecurityInfo> securityInfoList = FileToBeanUtil.readCSVToObjects(SecurityInfo.class, filePath);
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
		Date date = formatter.parse("300420");
		securityList.stream().forEach(security -> {
			SecurityInfo secInfo = EquityUtil.findByProperty(securityInfoList,
					info -> info.getSc_code().equals(security.getSc_code()));
			if (secInfo != null) {
				security.setInfoList(new ArrayList<>());
				security.getInfoList().add(secInfo);
				secInfo.setSecurity(security);
				secInfo.setCreatedAt(date);
			}
			securityRepository.save(security);
		});

		System.out.println("All good");
	}

}
