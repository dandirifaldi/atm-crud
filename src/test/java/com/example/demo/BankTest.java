package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Banks;
import com.example.demo.services.BanksService;

@SpringBootTest
public class BankTest {
    @Autowired
    private BanksService bankService;

    // public BankTest(BanksService bankService){
        // this.bankService = bankService;
    // }

    @Test
    void Safe(){
        //  Arange
        Banks bank = new Banks();
        bank.setBank_id("999");
        bank.setName("Bank Test");

        //  Act
        Boolean result = bankService.Save(bank);

        // Assert
        Assertions.assertThat(result).isEqualTo(true);
    }
    @Test
	void delete() {
		// Arrange
		String id = "999";

		// Act
		Boolean result = bankService.Delete(id);

		// Assert
		Assertions.assertThat(result).isEqualTo(true);
	}
}
