package com.banking.dummybankingapi.restAssured;

import com.banking.dummybankingapi.model.Transaction;
import com.banking.dummybankingapi.service.dto.AccountRequestDto;
import com.banking.dummybankingapi.service.dto.TransactionRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DummyBankApiTransferTest {

    @Autowired
    private ModelMapper modelMapper;

    private String baseUrl = "http://localhost:3001/api/";

    @Test
    @Order(1)
    public void createAccount() {
        // Arrange
        AccountRequestDto accountARequestDto = new AccountRequestDto(2001L, "alice", "Alice Doe");
        AccountRequestDto accountBRequestDto = new AccountRequestDto(2002L, "bob", "Bob Roe");

        List<AccountRequestDto> accounts = List.of(accountARequestDto, accountBRequestDto);

        // Act
        for (AccountRequestDto account : accounts) {
            Response response = RestAssured
                    .given()
                    .contentType(ContentType.JSON)
                    .body(account)
                    .when()
                    .post(baseUrl + "accounts/")
                    .then()
                    .extract()
                    .response();

            // Assert
            assertThat(response.getStatusCode(), anyOf(is(200), is(201)));
            assertThat(response.jsonPath().getString("code"), equalTo(account.getCode()));
            assertThat(response.jsonPath().getString("name"), equalTo(account.getName()));
        }
    }

    @Test
    @Order(2)
    public void getAccountA() {
        // Arrange
        String accountId = "2001";

        // Act
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", accountId)
                .when()
                .get(baseUrl + "accounts/{id}")
                .then()
                .extract()
                .response();

        // Assert
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getString("code"), equalTo("alice"));
        assertThat(response.jsonPath().getString("name"), equalTo("Alice Doe"));
    }

    @Test
    @Order(3)
    public void createTransaction() {
        // Arrange
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto(90001L, new BigDecimal("125.5"), 2, "alice", "bob", "Rent part");

        // Act
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(transactionRequestDto)
                .when()
                .post(baseUrl + "transactions/")
                .then()
                .extract()
                .response();

        // Assert
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getLong("id"), equalTo(transactionRequestDto.getId()));
        assertThat(response.jsonPath().getObject("amount", BigDecimal.class), equalTo(transactionRequestDto.getAmount()));
        assertThat(response.jsonPath().getString("comment"), equalTo(transactionRequestDto.getComment()));
    }

    @Test
    @Order(4)
    public void getTransaction() {
        // Arrange
        String transactionId = "90001";

        // Act
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", transactionId)
                .when()
                .get(baseUrl + "transactions/{id}")
                .then()
                .extract()
                .response();

        // Assert
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(response.jsonPath().getString("accountCodeFrom"), equalTo("alice"));
        assertThat(response.jsonPath().getString("accountCodeTo"), equalTo("bob"));
        assertThat(response.jsonPath().getString("amount"), equalTo("125.5"));
    }

    @Test
    @Order(5)
    public void updateTransaction() {
        // Arrange
        String transactionId = "90001";

        Transaction loadedTransaction = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", transactionId)
                .get(baseUrl + "transactions/{id}")
                .as(Transaction.class);

        TransactionRequestDto transactionRequestDto = modelMapper.map(loadedTransaction, TransactionRequestDto.class);
        transactionRequestDto.setComment("Rent part (updated)");

        // Act
        Response updateResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", transactionId)
                .body(transactionRequestDto)
                .when()
                .put(baseUrl + "transactions/{id}")
                .then()
                .extract()
                .response();

        // Assert
        Response findByResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", transactionId)
                .when()
                .get(baseUrl + "transactions/{id}")
                .then()
                .extract()
                .response();

        assertThat(updateResponse.getStatusCode(), equalTo(200));
        assertThat(findByResponse.jsonPath().getString("comment"), equalTo("Rent part (updated)"));
    }

    @Test
    @Order(6)
    public void deleteTransaction() {
        // Arrange
        String transactionId = "90001";

        // Act
        Response deleteResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", transactionId)
                .when()
                .delete(baseUrl + "transactions/{id}")
                .then()
                .extract()
                .response();

        // Assert
        Response findByResponse = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", transactionId)
                .when()
                .get(baseUrl + "transactions/{id}")
                .then()
                .extract()
                .response();

        assertThat(deleteResponse.getStatusCode(), anyOf(is(200), is(204)));
        assertThat(findByResponse.getStatusCode(), equalTo(200));
        assertThat(findByResponse.getBody().asString(), blankOrNullString());
    }

}
